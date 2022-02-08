package cn.yxtreme.jooq.model;

/**
 * @author: Alex
 * @since: 2021/8/10
 */
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


        //<editor-fold defaultstate="collapsed" desc="delombok">
        @SuppressWarnings("all")
        public static class InsertFieldBuilder {
            @SuppressWarnings("all")
            private String id;
            @SuppressWarnings("all")
            private String created;
            @SuppressWarnings("all")
            private String updated;
            @SuppressWarnings("all")
            private String version;
            @SuppressWarnings("all")
            private String deleted;

            @SuppressWarnings("all")
            InsertFieldBuilder() {
            }

            @SuppressWarnings("all")
            public BaseFieldConfig.InsertField.InsertFieldBuilder id(final String id) {
                this.id = id;
                return this;
            }

            @SuppressWarnings("all")
            public BaseFieldConfig.InsertField.InsertFieldBuilder created(final String created) {
                this.created = created;
                return this;
            }

            @SuppressWarnings("all")
            public BaseFieldConfig.InsertField.InsertFieldBuilder updated(final String updated) {
                this.updated = updated;
                return this;
            }

            @SuppressWarnings("all")
            public BaseFieldConfig.InsertField.InsertFieldBuilder version(final String version) {
                this.version = version;
                return this;
            }

            @SuppressWarnings("all")
            public BaseFieldConfig.InsertField.InsertFieldBuilder deleted(final String deleted) {
                this.deleted = deleted;
                return this;
            }

            @SuppressWarnings("all")
            public BaseFieldConfig.InsertField build() {
                return new BaseFieldConfig.InsertField(this.id, this.created, this.updated, this.version, this.deleted);
            }

            @Override
            @SuppressWarnings("all")
            public String toString() {
                return "BaseFieldConfig.InsertField.InsertFieldBuilder(id=" + this.id + ", created=" + this.created + ", updated=" + this.updated + ", version=" + this.version + ", deleted=" + this.deleted + ")";
            }
        }

        @SuppressWarnings("all")
        public static BaseFieldConfig.InsertField.InsertFieldBuilder builder() {
            return new BaseFieldConfig.InsertField.InsertFieldBuilder();
        }

        @SuppressWarnings("all")
        public String getId() {
            return this.id;
        }

        @SuppressWarnings("all")
        public String getCreated() {
            return this.created;
        }

        @SuppressWarnings("all")
        public String getUpdated() {
            return this.updated;
        }

        @SuppressWarnings("all")
        public String getVersion() {
            return this.version;
        }

        @SuppressWarnings("all")
        public String getDeleted() {
            return this.deleted;
        }

        @SuppressWarnings("all")
        public InsertField(final String id, final String created, final String updated, final String version, final String deleted) {
            this.id = id;
            this.created = created;
            this.updated = updated;
            this.version = version;
            this.deleted = deleted;
        }
        //</editor-fold>
    }


    public static class UpdateField {
        private String updated;
        private String version;

        private UpdateField() {
            this.updated = "updated_at";
            this.version = "version";
        }


        //<editor-fold defaultstate="collapsed" desc="delombok">
        @SuppressWarnings("all")
        public static class UpdateFieldBuilder {
            @SuppressWarnings("all")
            private String updated;
            @SuppressWarnings("all")
            private String version;

            @SuppressWarnings("all")
            UpdateFieldBuilder() {
            }

            @SuppressWarnings("all")
            public BaseFieldConfig.UpdateField.UpdateFieldBuilder updated(final String updated) {
                this.updated = updated;
                return this;
            }

            @SuppressWarnings("all")
            public BaseFieldConfig.UpdateField.UpdateFieldBuilder version(final String version) {
                this.version = version;
                return this;
            }

            @SuppressWarnings("all")
            public BaseFieldConfig.UpdateField build() {
                return new BaseFieldConfig.UpdateField(this.updated, this.version);
            }

            @Override
            @SuppressWarnings("all")
            public String toString() {
                return "BaseFieldConfig.UpdateField.UpdateFieldBuilder(updated=" + this.updated + ", version=" + this.version + ")";
            }
        }

        @SuppressWarnings("all")
        public static BaseFieldConfig.UpdateField.UpdateFieldBuilder builder() {
            return new BaseFieldConfig.UpdateField.UpdateFieldBuilder();
        }

        @SuppressWarnings("all")
        public String getUpdated() {
            return this.updated;
        }

        @SuppressWarnings("all")
        public String getVersion() {
            return this.version;
        }

        @SuppressWarnings("all")
        public UpdateField(final String updated, final String version) {
            this.updated = updated;
            this.version = version;
        }
        //</editor-fold>
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    public static class DeleteField {
    //</editor-fold>
        private String deleted;

        private DeleteField() {
            this.deleted = "deleted";
        }


        //<editor-fold defaultstate="collapsed" desc="delombok">
        @SuppressWarnings("all")
        public static class DeleteFieldBuilder {
            @SuppressWarnings("all")
            private String deleted;

            @SuppressWarnings("all")
            DeleteFieldBuilder() {
            }

            @SuppressWarnings("all")
            public BaseFieldConfig.DeleteField.DeleteFieldBuilder deleted(final String deleted) {
                this.deleted = deleted;
                return this;
            }

            @SuppressWarnings("all")
            public BaseFieldConfig.DeleteField build() {
                return new BaseFieldConfig.DeleteField(this.deleted);
            }

            @Override
            @SuppressWarnings("all")
            public String toString() {
                return "BaseFieldConfig.DeleteField.DeleteFieldBuilder(deleted=" + this.deleted + ")";
            }
        }

        @SuppressWarnings("all")
        public static BaseFieldConfig.DeleteField.DeleteFieldBuilder builder() {
            return new BaseFieldConfig.DeleteField.DeleteFieldBuilder();
        }

        @SuppressWarnings("all")
        public String getDeleted() {
            return this.deleted;
        }

        @SuppressWarnings("all")
        public DeleteField(final String deleted) {
            this.deleted = deleted;
        }
        //</editor-fold>
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public InsertField getInsertField() {
        return this.insertField;
    }

    @SuppressWarnings("all")
    public UpdateField getUpdateField() {
        return this.updateField;
    }

    @SuppressWarnings("all")
    public DeleteField getDeleteField() {
        return this.deleteField;
    }

    @SuppressWarnings("all")
    public void setInsertField(final InsertField insertField) {
        this.insertField = insertField;
    }

    @SuppressWarnings("all")
    public void setUpdateField(final UpdateField updateField) {
        this.updateField = updateField;
    }

    @SuppressWarnings("all")
    public void setDeleteField(final DeleteField deleteField) {
        this.deleteField = deleteField;
    }
    //</editor-fold>
}
