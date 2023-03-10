package wegotoaw.application.shared.gui.views.layerviews;

import wegotoaw.application.shared.boundaries.viewers.layerviewers.ArrowLayerViewer;
import wegotoaw.application.shared.gui.decorators.ImageDecorators;
import wegotoaw.application.shared.gui.profiles.GraphicsModel;
import wegotoaw.application.shared.gui.providers.AresMiscTerrainGraphics;
import wegotoaw.platform.engine.algorithms.pathfinding.Node;
import wegotoaw.platform.engine.algorithms.pathfinding.Path;
import wegotoaw.platform.scenario.board.Direction;
import wegotoaw.platform.scenario.board.Directions;
import wegotoaw.platform.scenario.board.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

/**
 * Draws the movement arrows on a BufferedImage
 *
 * @author Heine <heisncfr@inf.upv.es>
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public class ArrowLayerView extends AbstractImageLayerView implements ArrowLayerViewer {

    private Path activePath;
    private Path selectedUnitPath;
    private Collection<Path> formationPaths;
    private Collection<Path> forcePaths;

    @Override
    public String name() {
        return ArrowLayerViewer.NAME;
    }

    @Override
    public void updateLayer() {
        initialize();
        if (!isVisible()) return;
        Graphics2D g2 = globalImage.createGraphics();
        if (forcePaths != null) {
            for (Path path : forcePaths) {
                paintArrow(g2, path, ArrowType.FORCE);
            }
        }
        if (formationPaths != null) {
            for (Path path : formationPaths) {
                paintArrow(g2, path, ArrowType.FORMATION);
            }
        }
        if (selectedUnitPath != null) {
            paintArrow(g2, selectedUnitPath, ArrowType.UNIT);
        }
        if (activePath != null) {
            paintArrowWithCost(g2, activePath, ArrowType.ACTIVE);
        }
        g2.dispose();
    }

    /**
     * Paints finish arrow for the {@code activePath} passed as argument
     *
     * @param activePath the path from the selected unit to the location pointed by the mouse
     */
    @Override
    public void updateCurrentOrders(Path activePath) {
        this.activePath = activePath;
        updateLayer();
    }

    /**
     * Paint the last orders arrows for the {@code path} passed as argument
     *
     * @param lastPath the path of the last order given to the selected unit
     */
    @Override
    public void updateLastOrders(Path lastPath) {
        this.selectedUnitPath = lastPath;
        updateLayer();
    }

    /**
     * Paint arrows for planned orders of all units in the same force as the selected unit, as described by the {@code selectedUnitPath},
     * {@code formationPaths} and {@code forcePaths}
     *
     * @param selectedUnitPath path of the orders for the selected unit
     * @param formationPaths   paths of the orders of other units in the same formation as the selected unit
     * @param forcePaths       paths of the orders of the rest of the units in the same force as the selected unit
     */
    @Override
    public void updatePlannedOrders(Path selectedUnitPath, Collection<Path> formationPaths, Collection<Path> forcePaths) {
        this.selectedUnitPath = selectedUnitPath;
        this.formationPaths = formationPaths;
        this.forcePaths = forcePaths;
        updateLayer();
    }

    private void paintArrow(Graphics2D g2, Path path, ArrowType type) {
        if (path.size() < 2) {
            return;
        }
        Node last = path.getLast();
        Node current = path.getFirst();
        Node next = current.getNext();
        paintArrowSegment(g2, current, EnumSet.of(next.getDirection().getOpposite()), type);
        while (next != last) {
            current = next;
            next = next.getNext();
            Direction from = current.getDirection();
            Direction to = next.getDirection().getOpposite();
            paintArrowSegment(g2, current, EnumSet.of(from, to), type);
        }
        paintFinalArrowSegment(g2, last, last.getDirection(), type);
    }

    private void paintArrowWithCost(Graphics2D g2, Path path, ArrowType type) {
        if (path.size() < 2) {
            return;
        }
        Node last = path.getLast();
        Node current = path.getFirst();
        Node next = current.getNext();
        paintArrowSegmentWithCost(g2, current, EnumSet.of(next.getDirection().getOpposite()), type);
        while (next != last) {
            current = next;
            next = next.getNext();
            Direction from = current.getDirection();
            Direction to = next.getDirection().getOpposite();
            paintArrowSegmentWithCost(g2, current, EnumSet.of(from, to), type);
        }
        paintFinalArrowSegmentWithCost(g2, last, last.getDirection(), type);
    }


    private void paintFinalArrowSegment(Graphics2D g2, Node node, Direction direction, ArrowType type) {
        Point coordinates = Directions.getDirections(direction.ordinal() + 25).getCoordinates();
        BufferedImage arrowImage = GraphicsModel.INSTANCE.getProfiledImageProvider(type.getProvider(), profile).getImage(coordinates);
        Tile tile = node.getTile();
        Point pos = GraphicsModel.INSTANCE.tileToPixel(tile.getCoordinates(), profile);
        g2.drawImage(arrowImage, pos.x, pos.y, contentPane);
        contentPane.repaint(pos.x, pos.y, arrowImage.getWidth(), arrowImage.getHeight());
    }


    private void paintFinalArrowSegmentWithCost(Graphics2D g2, Node node, Direction direction, ArrowType type) {
        Point coordinates = Directions.getDirections(direction.ordinal() + 25).getCoordinates();
        BufferedImage arrowImage = GraphicsModel.INSTANCE.getProfiledImageProvider(type.getProvider(), profile).getImage(coordinates);
        Tile tile = node.getTile();
        Point pos = GraphicsModel.INSTANCE.tileToPixel(tile.getCoordinates(), profile);
        g2.drawImage(arrowImage, pos.x, pos.y, contentPane);
        BufferedImage subImage = globalImage.getSubimage(pos.x, pos.y, arrowImage.getWidth(), arrowImage.getHeight());
        Graphics2D arrowG2 = subImage.createGraphics();
        arrowG2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        ImageDecorators decorator = GraphicsModel.INSTANCE.getImageDecorators(profile);
        int cost = (int) node.getG();
        decorator.paintArrowCost(arrowG2, cost);
        arrowG2.dispose();
        contentPane.repaint(pos.x, pos.y, arrowImage.getWidth(), arrowImage.getHeight());
    }


    private void paintArrowSegment(Graphics2D g2, Node node, Set<Direction> directions, ArrowType type) {
        Point coordinates = Directions.getDirections(Direction.getBitmask(directions)).getCoordinates();
        BufferedImage arrowImage = GraphicsModel.INSTANCE.getProfiledImageProvider(type.getProvider(), profile).getImage(coordinates);
        Tile tile = node.getTile();
        Point pos = GraphicsModel.INSTANCE.tileToPixel(tile.getCoordinates(), profile);
        g2.drawImage(arrowImage, pos.x, pos.y, contentPane);
        contentPane.repaint(pos.x, pos.y, arrowImage.getWidth(), arrowImage.getHeight());
    }


    private void paintArrowSegmentWithCost(Graphics2D g2, Node node, Set<Direction> directions, ArrowType type) {
        Point coordinates = Directions.getDirections(Direction.getBitmask(directions)).getCoordinates();
        BufferedImage arrowImage = GraphicsModel.INSTANCE.getProfiledImageProvider(type.getProvider(), profile).getImage(coordinates);
        Tile tile = node.getTile();
        Point pos = GraphicsModel.INSTANCE.tileToPixel(tile.getCoordinates(), profile);
        g2.drawImage(arrowImage, pos.x, pos.y, contentPane);
        BufferedImage subImage = globalImage.getSubimage(pos.x, pos.y, arrowImage.getWidth(), arrowImage.getHeight());
        Graphics2D arrowG2 = subImage.createGraphics();
        arrowG2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        ImageDecorators decorator = GraphicsModel.INSTANCE.getImageDecorators(profile);
        int cost = (int) node.getG();
        decorator.paintArrowCost(arrowG2, cost);
        arrowG2.dispose();
        contentPane.repaint(pos.x, pos.y, arrowImage.getWidth(), arrowImage.getHeight());
    }

    private enum ArrowType {

        ACTIVE(AresMiscTerrainGraphics.RED_ARROWS),
        UNIT(AresMiscTerrainGraphics.PURPLE_ARROWS),
        FORMATION(AresMiscTerrainGraphics.DARK_BLUE_ARROWS),
        FORCE(AresMiscTerrainGraphics.BLUE_ARROWS);
        private final AresMiscTerrainGraphics provider;

        private ArrowType(final AresMiscTerrainGraphics provider) {
            this.provider = provider;
        }

        public AresMiscTerrainGraphics getProvider() {
            return provider;
        }
    }
}
