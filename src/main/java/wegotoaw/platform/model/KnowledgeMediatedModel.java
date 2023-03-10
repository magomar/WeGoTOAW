package wegotoaw.platform.model;

import wegotoaw.platform.engine.knowledge.KnowledgeCategory;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public abstract class KnowledgeMediatedModel<T> {

    protected final KnowledgeCategory kLevel;

    public KnowledgeMediatedModel(KnowledgeCategory informationLevel) {
        this.kLevel = informationLevel;
    }

    public KnowledgeCategory getKnowledgeCategory() {
        return kLevel;
    }
}
