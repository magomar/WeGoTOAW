package wegotoaw.application.shared.commands;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public enum AresCommandGroup implements CommandGroup {

    FILE("File", 'F') {
        @Override
        public Command[] getCommands() {
            return FileCommands.values();
        }
    },
    VIEW("View", 'V') {
        @Override
        public Command[] getCommands() {
            return ViewCommands.values();
        }
    },
    ENGINE("Engine", 'E') {
        @Override
        public Command[] getCommands() {
            return EngineCommands.values();
        }
    },
    PATHFINDER_TOOLS("Tools", 'T') {
        @Override
        public Command[] getCommands() {
            return PathfinderToolsCommands.values();
        }
    };
    private final Integer mnemonic;
    private final String text;

    private AresCommandGroup(final String text, final char mnemonic) {
        this.text = text;
        this.mnemonic = Integer.valueOf(mnemonic);
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Integer getMnemonic() {
        return mnemonic;
    }

    @Override
    public String getName() {
        return name();
    }


}
