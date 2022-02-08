package cn.yxtreme.jooq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: Alex
 * @since: 2021/8/10
 */
@Getter
@Setter
public class BaseFieldConfig {

    private InsertField insertField;
    private UpdateField updateField;
    private DeleteField deleteField;

    public BaseFieldConfig() {
        insertField = initInsertField();
        updateField = initUpdateField();
        deleteField = initDeleteField();
    }

    public InsertField initInsertField() {
        return new InsertField();
    }

    public UpdateField initUpdateField() {
        return new UpdateField();
    }

    public DeleteField initDeleteField() {
        return new DeleteField();
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class InsertField {
        private String id;
        private String created;
        private String updated;
        private String version;
        private String deleted;

        private InsertField() {
            this.id = "id";
            this.created = "created_at";
            this.updated = "updated_at";
            this.version = "version";
            this.deleted = "deleted";
        }

    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class UpdateField {
        private String updated;
        private String version;

        private UpdateField() {
            this.updated = "updated_at";
            this.version = "version";
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class DeleteField {

        private String deleted;

        private DeleteField() {
            this.deleted = "deleted";
        }

    }
}
