package wegotoaw.platform.scenario.forces;

import wegotoaw.application.shared.models.forces.DetectedUnitModel;
import wegotoaw.application.shared.models.forces.IdentifiedUnitModel;
import wegotoaw.application.shared.models.forces.KnownUnitModel;
import wegotoaw.application.shared.models.forces.UnitModel;
import wegotoaw.data.wrappers.scenario.Availability;
import wegotoaw.data.wrappers.scenario.Emphasis;
import wegotoaw.platform.engine.action.Action;
import wegotoaw.platform.engine.action.ActionSpace;
import wegotoaw.platform.engine.action.ActionType;
import wegotoaw.platform.engine.command.tactical.TacticalMission;
import wegotoaw.platform.engine.knowledge.KnowledgeCategory;
import wegotoaw.platform.engine.movement.MovementType;
import wegotoaw.platform.engine.time.Clock;
import wegotoaw.platform.model.ModelProvider;
import wegotoaw.platform.model.UserRole;
import wegotoaw.platform.scenario.Scale;
import wegotoaw.platform.scenario.Scenario;
import wegotoaw.platform.scenario.assets.Asset;
import wegotoaw.platform.scenario.assets.AssetTrait;
import wegotoaw.platform.scenario.assets.AssetType;
import wegotoaw.platform.scenario.assets.AssetTypes;
import wegotoaw.platform.scenario.board.Board;
import wegotoaw.platform.scenario.board.Direction;
import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.util.MathUtils;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author Mario Gomez <margomez antiTank dsic.upv.es>
 */
public abstract class Unit implements ModelProvider<UnitModel> {

    //    public static final Comparator<Unit> UNIT_ACTION_FINISH_COMPARATOR = new UnitActionFinishComparator();
    public static final Comparator<Unit> UNIT_ENTRY_COMPARATOR = new UnitEntryComparator();
    public static final int MAX_ENDURANCE = 18 * 60 * 60;
    /**
     * IMPORTANT: Currently the id of the unit is just a reference from Toaw, but it is not a unique identifier
     */
    protected int id;
    /**
     * The name which identifies the unit within a force's OOB
     */
    protected String name;
    /**
     * Identifies a graphic icon depicting the {@link #unitType}
     */
    protected int iconId;
    /**
     * Identifies the combination of colors of the graphical icon
     */
    protected UnitsColor color;
    /**
     * The type of unit (infantry, motorized infantry, armor, artillery, etc.)
     */
    protected UnitType unitType;
    /**
     * The echelon of the unit in its military organization (battalion, division, etc.)
     */
    protected Echelon echelon;
    /**
     * The formation the unit is attached to
     */
    protected Formation formation;
    /**
     * The force the unit belongs to
     */
    protected Force force;
//    protected Experience experience;
    /**
     * Represents the quality of the unit, its ability to perform its duties. It captures both the training and the
     * experience of a unit. In general proficiency tend to increase as the unit executes actions. It is specified as a
     * percentage, where 100% is the best possible proficiency.
     */
    protected int proficiency;
    /**
     * Represents the physical condition of a unit due to the changeEndurance and tear of its personnel and equipment,
     * as well as its organization and cohesion state. It is specified as a percentage, where 100% is the ideal
     * condition, with the equipment in perfect conditions, all the personnel fit and rested
     */
    protected int readiness;
    /**
     * Represents the amount of supplies available. It is specified as a percentage, where 100% indicates that the unit
     * is able to fully feed its personnel, and has standard fuel and ammunition for sustained operations during a
     * single day
     */
    protected int supply;
    /**
     * Current location of the unit on the map board
     */
    protected Tile location;
    /**
     * Represents the level of losses acceptable before disengaging from combat It is represented by an Ordinal scale
     * (minimize losses, limit losses, ignore losses)
     */
    protected Emphasis emphasis;
    /**
     * Indicates whether a unit is available or not, and the reason for not being available Ir is represented by a
     * Nominal scale (available, disbanded, eliminated, expected as reinforcement, etc.)
     */
    protected Availability availability;
    /**
     * Represents the operational state of a unit, how it is deployed and what it is doing (deployed, embarked, mobile,
     * deploying, assembling, moving, attacking, routing, reorganizing, etc. )
     */
    protected OpState opState;
    /**
     * Priority to receive replacements
     */
    protected int replacementPriority;
    /**
     * It can represent two things. If a unit is expected to enter as a reinforcement, it represents the turn it is
     * received. However, if a unit is a conditional reinforcement, it represents the identifier of the event that fires
     * the reception of the unit.
     */
    protected int entry;
    /**
     * This attribute is used in units resulting of division to reference the unit that was divided.
     */
    protected Unit parent;
    /**
     * Collection of assets available in the unit. An asset includes information concerning the unitType of equipment, the
     * current amount of that equipment, and the maximum amount (the ideal condition). Assets are stored in a
     * {@code Map} having {@link AssetType} objects as keys, and {@link Asset} objects as values.
     */
    protected Map<AssetType, Asset> assets;
    // ************ COMPUTED ATTRIBUTES ****************
    /**
     * Represents the special capabilities of a unit. It is specified as a map that links asset types to the number of
     * assets possessing each asset trait. Stored as a map Assets are stored in a  {@code Map} having {@link AssetType}
     * objects as keys, and the amount of that trait as values (and {@link Integer})
     */
    protected Map<AssetTrait, Integer> traits;
    /**
     * Fighting strength against armored vehicles such as tanks, armored personnel carriers, etc. (hard targets)
     */
    protected int antiTank;
    /**
     * Fighting strength against personnel, animals and non-armored equipment (soft targets)
     */
    protected int antiPersonnel;
    /**
     * Fighting strength against aircrafts flying at high altitude
     */
    protected int highAntiAir;
    /**
     * Fighting strength against aircrafts flying at low/medium altitude
     */
    protected int lowAntiAir;
    /**
     * Strength that represents the capacity to sustain loses. In general defense is computed as the sum of personnel
     * and vehicles
     */
    protected int defense;
    /**
     * Fighting strength against soft targets (people, animals, non-armored equipment) using long-range indirect-fires
     * (Bombardment) (soft targets)
     */
    protected int artillery;
    /**
     * Range for indirect fire, specified in Km *
     */
    protected int artilleryRange;
    /**
     * Weight in kilograms
     */
    protected int weight;
    /**
     * Movement unitType depends on the unitType of assets in the unit (air, naval, foot, motorized, etc.)
     */
    protected MovementType movementType;
    /**
     * Standard average moving speed in ideal conditions, specified in meters per minute. Depends on the unitType of assets
     * in the unit
     */
    protected int speed;
    /**
     * The actual ability to perform actions, taking into account readiness and proficiency.
     */
    protected int quality;
    /**
     * The actual efficacy when performing actions, considering quality and supplies
     */
    protected int efficacy;
    /**
     * The ability to explore the environment and obtain information
     */
    protected int reconnaissance;
    /**
     * Represents the remaining physical resistance of a unit before becoming exhausted, expressed in action points
     * (seconds of low-intensity activity). The execution of actions consumes endurance, but it can be replenished by
     * resting.
     */
    protected int endurance;
    /**
     * Represents the maximum physical resistance of a unit when fully rested, given the actual readiness and supplies.
     *
     * @see #endurance
     */
    protected int maxEndurance;
    /**
     * Distance in meters a unit is currently able to move antiTank standard average speed, before becoming exhausted.
     */
    protected int range;
    /**
     * Distance in meters a rested unit would be able to move in ideal conditions at standard average speed before
     * becoming exhausted.
     */
    protected int maxRange;
    /**
     * Models of the unit for every knowledge category
     */
    private final Map<KnowledgeCategory, UnitModel> models;
    /**
     * The tactical mission assigned to this unit
     */
    protected TacticalMission mission;
    /**
     * Whether the unit is active or not. Only available units may be active. Only active units can take orders.
     * Non-active units keep their current locations and behave as defending.
     */
    protected boolean active;

    protected Unit() {
        models = new HashMap<>();
    }

    protected Unit(wegotoaw.data.wrappers.scenario.Unit unit, Formation formation, Force force, Scenario scenario) {
        id = unit.getId();
        name = unit.getName();
        unitType = UnitType.valueOf(unit.getType().name());
        if (unitType.ordinal() > 114) {
            System.err.println(unit.getName() + " *** " + unitType);
        }
        iconId = unit.getIconId();
        color = UnitsColor.values()[unit.getColor()];
        echelon = Echelon.valueOf(unit.getSize().name());
        this.formation = formation;
        this.force = force;
        proficiency = unit.getProficiency();
        readiness = unit.getReadiness();
        supply = unit.getSupply();
        emphasis = unit.getEmphasis();
        availability = unit.getAvailability();
        opState = OpState.valueOf(unit.getOpState().name());
        replacementPriority = unit.getReplacementPriority();
        entry = (availability == Availability.TURN || availability == Availability.EVENT ? entry = unit.getEntry() : 1);
        artilleryRange = 0;
        assets = new HashMap<>();
        traits = new EnumMap<>(AssetTrait.class);
        boolean providesIndirectFireSupport = unitType.getCapabilities().contains(Capability.BOMBARDMENT);
        AssetTypes assetTypes = scenario.getAssetTypes();
        for (wegotoaw.data.wrappers.scenario.Unit.Equipment equip : unit.getEquipment()) {
            Asset asset = new Asset(equip, assetTypes);
            AssetType assetType = asset.getType();
            assets.put(assetType, asset);
            int n = asset.getNumber();
            if (n > 0) {
                antiTank += n * assetType.getAt();
                antiPersonnel += n * assetType.getAp();
                defense += n * assetType.getDf();
                highAntiAir += n * assetType.getAah();
                lowAntiAir += n * assetType.getAal();
                if (providesIndirectFireSupport) {
                    int astRange = assetType.getArtyRange();
                    if (astRange > 0) {
                        artilleryRange = (artilleryRange == 0 ? astRange : Math.min(artilleryRange, astRange));
                        artillery += n * assetType.getAp() / 2;
                    }
                }
                weight += n * assetType.getWeight();
                Set<AssetTrait> assetTraits = assetType.getTraits();
                for (AssetTrait trait : assetTraits) {
                    if (traits.containsKey(trait)) {
                        traits.put(trait, traits.get(trait) + asset.getNumber());
                    } else {
                        traits.put(trait, asset.getNumber());
                    }
                }
            }
        }
        Board board = scenario.getBoard();
        int x = unit.getX();
        int y = unit.getY();
        location = board.getMap()[x][y];
        models = new HashMap<>();
//        models.put(KnowledgeCategory.NONE, null);
        models.put(KnowledgeCategory.POOR, new DetectedUnitModel(this));
        models.put(KnowledgeCategory.GOOD, new IdentifiedUnitModel(this));
        models.put(KnowledgeCategory.COMPLETE, new KnownUnitModel(this));
        active = false;
    }

    /**
     * Places the unit on board and initializes its attributes.
     */
    public void initialize() {
        updateMaxValues();
        endurance = maxEndurance;
        range = maxRange;
        updateDerivedValues();
        location.add(this);
    }

    /**
     * Activates the unit.Only active units may execute orders and accept new orders
     *
     * @see #active
     */
    public void activate() {
        active = true;
    }

    /**
     * Changes the readiness of the unit by the specified {@code amount}
     *
     * @param amount
     */
    public void changeReadiness(int amount) {
        readiness += amount;
        readiness = MathUtils.setBounds(readiness, 0, 100);
        updateDerivedValues();
    }

    /**
     * Changes the supply levels of the unit by the specified {@code amount}
     *
     * @param amount
     */
    public void changeSupply(int amount) {
        supply += amount;
        supply = MathUtils.setBounds(supply, 0, 200);
        updateDerivedValues();
    }

    /**
     * Updates derived attributes ({@code quality} {@code efficacy})
     */
    protected void updateDerivedValues() {
        quality = (2 * proficiency + readiness) / 3;
        efficacy = (2 * proficiency + readiness + Math.min(100, supply)) / 4;
    }

    /**
     * Updates the maximum values permitted for endurance ({@code maxEndurance} and {@code maxRange}). This feature
     * simulates a loss of recovery capacity (which occurs for example after incurring in excessive fatigue). Units
     * with these values reduced are not able to recover 100% performance after resting.
     */
    public void updateMaxValues() {
        maxEndurance = MAX_ENDURANCE * (200 + readiness + Math.min(100, supply)) / 400;
        maxRange = speed * maxEndurance / 90 / 1000;
    }

    /**
     * Changes the {@code endurance} of the unit by the specified {@code amount}
     *
     * @param amount
     */
    public void changeEndurance(int amount) {
        endurance += amount;
        endurance = MathUtils.setUpperBound(endurance, maxEndurance);
        range = speed * endurance / 90 / 1000;
    }

    public void addAssets() {
        throw new UnsupportedOperationException();
    }

    public void removeAssets() {
        throw new UnsupportedOperationException();
    }

    public void setParent(Unit parent) {
        this.parent = parent;
    }

    /**
     * Moves the unit one tile in the indicated {@code direction}. This method simply changes the location of the unit,
     * and updates the board accordingly (removes unit from previous location and adds it to the new location)
     *
     * @param direction direction of the movement relative to the origin of the movement
     */
    public void move(Direction direction) {
        location.remove(this);
        this.location = location.getNeighbor(direction);
        location.add(this);
    }

    /**
     * Sets the operational state of the unit. This indicates the way the unit is deployed and/or which kind of activity
     * is performing
     *
     * @param opState
     */
    public void setOpState(OpState opState) {
        if (opState != null) {
            this.opState = opState;
        }
    }

    public void setMission(TacticalMission mission) {
        this.mission = mission;
    }

    public Map<AssetType, Asset> getAssets() {
        return assets;
    }

    public Map<AssetTrait, Integer> getTraits() {
        return traits;
    }

    public int getTraitValue(AssetTrait trait) {
        if (traits.containsKey(AssetTrait.RECON)) {
            return traits.get(AssetTrait.RECON);
        } else {
            return 0;
        }
    }

    public Tile getLocation() {
        return location;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public int getRange() {
        return range;
    }

    public int getId() {
        return id;
    }

    public int getHighAntiAir() {
        return highAntiAir * efficacy;
    }

    public int getLowAntiAir() {
        return lowAntiAir * efficacy;
    }

    public int getAntiPersonnel() {
        return antiPersonnel * efficacy;
    }

    public int getArtillery() {
        return artillery * efficacy;
    }

    public int getAntiTank() {
        return antiTank * efficacy;
    }

    public UnitsColor getColor() {
        return color;
    }

    public int getDefense() {
        return defense * efficacy;
    }

    public int getArtilleryRange() {
        return artilleryRange;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getStamina() {
        return endurance * 100 / MAX_ENDURANCE;
    }

    public double getAttackStrength() {
        return efficacy * (double) (antiTank + antiPersonnel) / (Scale.INSTANCE.getArea() * 1.5);
    }

    public double getDefenseStrength() {
        return efficacy * (double) defense / (Scale.INSTANCE.getArea() * 1.5);
    }

    public int getEfficacy() {
        return efficacy;
    }

    public Emphasis getEmphasis() {
        return emphasis;
    }

    public int getEntry() {
        return entry;
    }

    public int getIconId() {
        return iconId;
    }

    public String getName() {
        return name;
    }

    public int getReconnaissance() {
        return reconnaissance;
    }

    public Unit getParent() {
        return parent;
    }

    public int getProficiency() {
        return proficiency;
    }

    public int getQuality() {
        return quality;
    }

    public int getReadiness() {
        return readiness;
    }

    public int getReplacementPriority() {
        return replacementPriority;
    }

    public Echelon getSize() {
        return echelon;
    }

    public int getSpeed() {
        return speed;
    }

    public Availability getAvailability() {
        return availability;
    }

    public int getSupply() {
        return supply;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public int getWeight() {
        return weight;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public Echelon getEchelon() {
        return echelon;
    }

    public Force getForce() {
        return force;
    }

    public Formation getFormation() {
        return formation;
    }

    public OpState getOpState() {
        return opState;
    }

    /**
     * Compares two units in terms of the turn of entry
     */
    protected static class UnitEntryComparator implements Comparator<Unit>, Serializable {

        @Override
        public int compare(Unit u1, Unit u2) {
            int entry1 = u1.getEntry();
            int entry2 = u2.getEntry();
            return entry1 - entry2;
        }
    }

    //    protected static class UnitActionFinishComparator implements Comparator<Unit> {
//
//        @Override
//        public int compare(Unit u1, Unit u2) {
//            Action a1 = u1.getAction();
//            Action a2 = u2.getAction();
//            if (a1 == null) {
//                if (a2 == null) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            } else if (a2 == null) {
//                return -1;
//            } else {
//                return a1.getFinish() - a2.getFinish();
//            }
//        }
//    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.force);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Unit other = (Unit) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.force, other.force)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toStringVerbose() {
        return name + "(" + unitType.name() + ")." + movementType + "." + opState + " @ " + location;
    }

    public String toStringMultiline() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (").append(echelon).append(')').append('\n');
        sb.append("Belongs to ").append(formation).append(" (").append(force).append(")\n");
        sb.append("Unit unitType: ").append(unitType).append('\n');
        sb.append("Location: ").append(location).append('\n');
        sb.append("Movement: ").append(movementType).append(" (").append(speed * 60.0 / 1000).append(" Km/h)\n");
        sb.append("OpState: ").append(opState).append('\n');
        sb.append("Stamina: ").append(getStamina()).append('\n');
//        sb.append("Endurance: ").append(endurance).append(" / ").append(MAX_ENDURANCE).append('\n');
        sb.append(mission.toStringMultiline());
        sb.append("Proficiency: ").append(proficiency).append('\n');
        sb.append("Readiness: ").append(readiness).append('\n');
        sb.append("Supply: ").append(supply).append('\n');
        sb.append("Range: ").append(range).append('/').append(maxRange).append('\n');
        sb.append("Quality: ").append(quality).append('\n');
        sb.append("Efficacy: ").append(efficacy).append('\n');
        sb.append("\n___Strenghts___\n");
        sb.append("Attack ").append(efficacy * (antiTank + antiPersonnel)).append('\n');
        sb.append("Defense: ").append(efficacy * defense).append("\n");
        sb.append("AT: ").append(efficacy * antiTank).append("  ");
        sb.append("AP: ").append(efficacy * antiPersonnel).append("\n");
        sb.append("HAA: ").append(efficacy * highAntiAir).append("   ");
        sb.append("LAA: ").append(efficacy * lowAntiAir).append("\n");
        if (artillery != 0) {
            sb.append("Art: ").append(efficacy * artillery).append(" (Range ").append(range).append(" Km.)\n");
        }
        if (!unitType.getCapabilities().isEmpty()) {
            sb.append("\n___Capabilities___\n");
            for (Capability capability : unitType.getCapabilities()) {
                sb.append(capability).append('\n');
            }
        }
        sb.append("\n___Assets___\n");
        for (Asset asset : assets.values()) {
            sb.append(asset).append('\n');
        }
        sb.append("\n___Traits___\n");
        for (Entry<AssetTrait, Integer> traitEntry : traits.entrySet()) {
            sb.append(traitEntry.getKey()).append(": ").append(traitEntry.getValue()).append('\n');
        }
        return sb.toString();
    }

    @Override
    public final UnitModel getModel(UserRole role) {
        KnowledgeCategory knowledgeCategory = location.getKnowledgeLevel(role).getCategory();
        return models.get(knowledgeCategory);
    }

    /**
     * Return
     *
     * @param knowledgeCategory
     * @return
     */
    public final UnitModel getModel(KnowledgeCategory knowledgeCategory) {
        return models.get(knowledgeCategory);
    }

    /**
     * Returns true if the  has enough endurance to perform the action. The answer depends on the current
     * {@link #endurance} of the unit as well as the {@link ActionType} passed as a parameter provided
     *
     * @param type
     * @return
     */
    public boolean canEndure(ActionType type) {
        return endurance > type.getRequiredEndurace(Clock.INSTANCE.getMINUTES_PER_TICK()) || type.getWearRate() < 0;
    }

    public TacticalMission getMission() {
        return mission;
    }

    public void act(ActionSpace actionSpace) {
        mission.executeAction(actionSpace);
    }

    public Action schedule() {
        return mission.scheduleAction();
    }

    /**
     * The unit gathers information on the surrounding environment. At this point only the adjacent tiles are considered
     */
    public void perceive() {
        location.reconnoissance(this, Clock.INSTANCE.getMINUTES_PER_TICK());
        for (Tile tile : location.getNeighbors().values()) {
            tile.reconnoissance(this, Clock.INSTANCE.getMINUTES_PER_TICK());
        }
    }

    public boolean isAircraft() {
        return movementType == MovementType.AIRCRAFT;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }
}
