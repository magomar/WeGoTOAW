package wegotoaw.application.shared.gui.views;

import wegotoaw.application.shared.boundaries.viewers.OOBViewer;
import wegotoaw.application.shared.gui.ComponentFactory;
import wegotoaw.application.shared.gui.components.OOBTreeCellRenderer;
import wegotoaw.application.shared.models.ScenarioModel;
import wegotoaw.application.shared.models.forces.ForceModel;
import wegotoaw.platform.scenario.forces.Unit;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.Enumeration;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public class OOBView extends AbstractView<JScrollPane> implements OOBViewer {

    private JTree[] oobTree;
    private JTabbedPane tabbedPane;
    private TreeSelectionListener treeSelectionListener;

    @Override
    protected JScrollPane layout() {
        tabbedPane = new JTabbedPane();
        return new JScrollPane(tabbedPane);
    }

    @Override
    public void loadScenario(ScenarioModel scenario) {
        ForceModel[] force = scenario.getForceModel();
        oobTree = new JTree[force.length];
        int index = 0;
        for (ForceModel forceModel : force) {
            JTree tree = ComponentFactory.tree(forceModel.getTreeModel());
            tree.setCellRenderer(new OOBTreeCellRenderer());
            tree.setName(forceModel.getName());
            tree.addTreeSelectionListener(treeSelectionListener);
            tabbedPane.add(tree);
            oobTree[index++] = tree;
        }
    }

    @Override
    public void updateScenario(ScenarioModel scenario) {
        int index = 0;
        for (ForceModel forceModel : scenario.getForceModel()) {
            oobTree[index++].setModel(forceModel.getTreeModel());
        }
    }

    @Override
    public void addTreeSelectionListener(TreeSelectionListener listener) {
        this.treeSelectionListener = listener;
    }

    @Override
    public void select(Unit unit) {
        int forceIndex = unit.getForce().getId();
        JTree tree = oobTree[forceIndex];
        TreePath path = find((DefaultMutableTreeNode) tree.getModel().getRoot(), unit.toString());
        tree.removeTreeSelectionListener(treeSelectionListener);
        tree.setSelectionPath(path);
        tree.scrollPathToVisible(path);
        tree.addTreeSelectionListener(treeSelectionListener);
        tabbedPane.setSelectedIndex(forceIndex);

    }

    private TreePath find(DefaultMutableTreeNode root, String s) {
        @SuppressWarnings("unchecked")
        Enumeration<TreeNode> e = root.depthFirstEnumeration();
        while (e.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
            if (node.toString().equalsIgnoreCase(s)) {
                return new TreePath(node.getPath());
            }
        }
        return null;
    }

    @Override
    public void flush() {
        tabbedPane.removeAll();
    }
}
