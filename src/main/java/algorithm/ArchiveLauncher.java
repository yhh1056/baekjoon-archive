package algorithm;

import algorithm.file.MarkdownGenerator;

public class ArchiveLauncher {

    public void run(MarkdownGenerator... generators) {
        for (MarkdownGenerator generator : generators) {
            generator.generate();
        }
    }
}
