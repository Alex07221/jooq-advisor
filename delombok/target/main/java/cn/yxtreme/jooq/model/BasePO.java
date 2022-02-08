package cn.yxtreme.jooq.model;

import java.time.LocalDateTime;

/**
 * @author: xuZeBiao
 * @since: 2021/7/27
 */
public class BasePO {
    private Long id;
    private Boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer version;


    @SuppressWarnings("all")
    public static abstract class BasePOBuilder<C extends BasePO, B extends BasePO.BasePOBuilder<C, B>> {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private Boolean deleted;
        @SuppressWarnings("all")
        private LocalDateTime createdAt;
        @SuppressWarnings("all")
        private LocalDateTime updatedAt;
        @SuppressWarnings("all")
        private Integer version;

        @SuppressWarnings("all")
        protected abstract B self();

        @SuppressWarnings("all")
        public abstract C build();

        @SuppressWarnings("all")
        public B id(final Long id) {
            this.id = id;
            return self();
        }

        @SuppressWarnings("all")
        public B deleted(final Boolean deleted) {
            this.deleted = deleted;
            return self();
        }

        @SuppressWarnings("all")
        public B createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return self();
        }

        @SuppressWarnings("all")
        public B updatedAt(final LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return self();
        }

        @SuppressWarnings("all")
        public B version(final Integer version) {
            this.version = version;
            return self();
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "BasePO.BasePOBuilder(id=" + this.id + ", deleted=" + this.deleted + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", version=" + this.version + ")";
        }
    }


    @SuppressWarnings("all")
    private static final class BasePOBuilderImpl extends BasePO.BasePOBuilder<BasePO, BasePO.BasePOBuilderImpl> {
        @SuppressWarnings("all")
        private BasePOBuilderImpl() {
        }

        @Override
        @SuppressWarnings("all")
        protected BasePO.BasePOBuilderImpl self() {
            return this;
        }

        @Override
        @SuppressWarnings("all")
        public BasePO build() {
            return new BasePO(this);
        }
    }

    @SuppressWarnings("all")
    protected BasePO(final BasePO.BasePOBuilder<?, ?> b) {
        this.id = b.id;
        this.deleted = b.deleted;
        this.createdAt = b.createdAt;
        this.updatedAt = b.updatedAt;
        this.version = b.version;
    }

    @SuppressWarnings("all")
    public static BasePO.BasePOBuilder<?, ?> builder() {
        return new BasePO.BasePOBuilderImpl();
    }

    @SuppressWarnings("all")
    public BasePO(final Long id, final Boolean deleted, final LocalDateTime createdAt, final LocalDateTime updatedAt, final Integer version) {
        this.id = id;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.version = version;
    }

    @SuppressWarnings("all")
    public BasePO() {
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public Boolean getDeleted() {
        return this.deleted;
    }

    @SuppressWarnings("all")
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @SuppressWarnings("all")
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    @SuppressWarnings("all")
    public Integer getVersion() {
        return this.version;
    }

    @SuppressWarnings("all")
    public BasePO setId(final Long id) {
        this.id = id;
        return this;
    }

    @SuppressWarnings("all")
    public BasePO setDeleted(final Boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    @SuppressWarnings("all")
    public BasePO setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @SuppressWarnings("all")
    public BasePO setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @SuppressWarnings("all")
    public BasePO setVersion(final Integer version) {
        this.version = version;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BasePO)) return false;
        final BasePO other = (BasePO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$deleted = this.getDeleted();
        final Object other$deleted = other.getDeleted();
        if (this$deleted == null ? other$deleted != null : !this$deleted.equals(other$deleted)) return false;
        final Object this$version = this.getVersion();
        final Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof BasePO;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $deleted = this.getDeleted();
        result = result * PRIME + ($deleted == null ? 43 : $deleted.hashCode());
        final Object $version = this.getVersion();
        result = result * PRIME + ($version == null ? 43 : $version.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "BasePO(id=" + this.getId() + ", deleted=" + this.getDeleted() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", version=" + this.getVersion() + ")";
    }
}
