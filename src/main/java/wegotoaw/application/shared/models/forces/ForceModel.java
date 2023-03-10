package wegotoaw.application.shared.models.forces;

import wegotoaw.application.shared.gui.components.OOBTreeNode;
import wegotoaw.application.shared.gui.profiles.GraphicsModel;
import wegotoaw.application.shared.gui.providers.ImageProvider;
import wegotoaw.platform.model.RoleMediatedModel;
import wegotoaw.platform.model.UserRole;
import wegotoaw.platform.scenario.forces.Force;
import wegotoaw.platform.scenario.forces.Formation;
import wegotoaw.platform.scenario.forces.Unit;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public final class ForceModel extends RoleMediatedModel {

    private final Force force;

    public ForceModel(Force force, UserRole role) {
        super(role);
        this.force = force;
    }

    public String getName() {
        return force.getName();
    }

    public List<UnitModel> getUnitModels() {
        List<UnitModel> unitModels = new ArrayList<>();
        for (Unit unit : force.getActiveUnits()) {
            UnitModel unitModel = unit.getModel(userRole);
            if (unitModel != null) {
                unitModels.add(unitModel);
            }
        }
        return unitModels;
    }

    public List<FormationModel> getFormationModels() {
        List<FormationModel> formations = new ArrayList<>();
        for (Formation formation : force.getFormations()) {
            FormationModel formationModel = formation.getModel(userRole);
            if (formationModel != null) {
                formations.add(formationModel);
            }
        }
        return formations;
    }

    public TreeModel getTreeModel() {
        Map<Formation, MutableTreeNode> formationNodes = new HashMap<>();
        for (Formation formation : force.getFormations()) {
            Unit hq = formation.getHq();
            MutableTreeNode formationNode;
            if (hq != null) {
                ImageProvider unitImageProvider = GraphicsModel.INSTANCE.getProfiledImageProvider(hq.getColor(), 2);
                ImageIcon treeNodeIcon = new ImageIcon(unitImageProvider.getImage(hq.getIconId()));
                formationNode = new OOBTreeNode(formation, treeNodeIcon);
            } else {
                formationNode = new DefaultMutableTreeNode(formation);
            }

            formationNodes.put(formation, formationNode);
        }
        Formation top = force.getFormations().get(0);
        MutableTreeNode root = formationNodes.get(top);
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        for (Unit unit : force.getActiveUnits()) {
            ImageProvider unitImageProvider = GraphicsModel.INSTANCE.getProfiledImageProvider(unit.getColor(), 2);
            ImageIcon treeNodeIcon = new ImageIcon(unitImageProvider.getImage(unit.getIconId()));
            MutableTreeNode unitNode = new OOBTreeNode(unit, treeNodeIcon);
            MutableTreeNode parent = formationNodes.get(unit.getFormation());
            treeModel.insertNodeInto(unitNode, parent, parent.getChildCount());
        }
        for (Formation formation : force.getFormations()) {
            Formation superior = formation.getSuperior();
            if (!formation.equals(top)) {
                MutableTreeNode node = formationNodes.get(formation);
                MutableTreeNode parent = formationNodes.get(superior);
                treeModel.insertNodeInto(node, parent, parent.getChildCount());
            }
        }
        return treeModel;
    }
}
