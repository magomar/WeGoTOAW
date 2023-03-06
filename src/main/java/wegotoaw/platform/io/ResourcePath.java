package wegotoaw.platform.io;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public enum ResourcePath {

    DATA("Data"), EQUIPMENT("Data/Equipment"), SCENARIOS("Data/Scenarios"), GRAPHICS("Graphics"), ICONS_SMALL("Graphics/Icons/Small"), ICONS_MEDIUM("Graphics/Icons/Medium"), // TODO
    //    ICONS_LARGE("Graphics/Icons/Large"),
    GRAPHICS_BACKGROUND("Graphics/Background"), WEATHER("Graphics/Weather"), OTHER("Graphics/Other");
    private final String relativePath;
    private final Path folderPath;

    ResourcePath(final String relativePath) {
        Path folderPath1;
        this.relativePath = relativePath;
//        this.folderPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), relativePath);
        URL res = ClassLoader.getSystemClassLoader().getResource(this.relativePath);
        try {
            folderPath1 = Paths.get(res.toURI()).toFile().toPath();
        } catch (URISyntaxException e) {
            folderPath1 = FileSystems.getDefault().getPath(System.getProperty("user.dir"), relativePath);
            ;
            System.out.println(this.relativePath);
//            throw new RuntimeException(e);
        }
        folderPath = folderPath1;
    }

    public Path getFolderPath() {
        return folderPath;
    }

    public Path getFilePath(String filename) {
        return FileSystems.getDefault().getPath(folderPath.toString(), filename);
    }

    public File getFile(String filename) {
        return getFilePath(filename).toFile();
    }

    public String getFilename(String filename) {
        return getFilePath(filename).toString();
    }

    public String getRelativePath() {
        return relativePath;
    }

    public Path getSubPath(String... subPath) {
        return FileSystems.getDefault().getPath(folderPath.toString(), subPath);
    }
}
