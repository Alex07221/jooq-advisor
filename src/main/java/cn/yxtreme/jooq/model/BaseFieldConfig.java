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
        initInsertField();
        initUpdateField();
        initDeleteField();
    }

    public void initInsertField() {
        this.insertField = new InsertField();
    }

    public void initUpdateField() {
        this.updateField = new UpdateField();
    }

    public void initDeleteField() {
        this.deleteField = new DeleteField();
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
            this.created = "createdAt";
            this.updated = "updatedAt";
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
            this.updated = "updatedAt";
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
