package cn.yxtreme.jooq.listener;

/**
 * @author Alex
 */
public final class Page {
    private long currentPage;
    private long pageSize;
    private long total;
    private long pageTotal;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public long getCurrentPage() {
        return this.currentPage;
    }

    @SuppressWarnings("all")
    public long getPageSize() {
        return this.pageSize;
    }

    @SuppressWarnings("all")
    public long getTotal() {
        return this.total;
    }

    @SuppressWarnings("all")
    public long getPageTotal() {
        return this.pageTotal;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Page(currentPage=" + this.getCurrentPage() + ", pageSize=" + this.getPageSize() + ", total=" + this.getTotal() + ", pageTotal=" + this.getPageTotal() + ")";
    }

    @SuppressWarnings("all")
    public void setCurrentPage(final long currentPage) {
        this.currentPage = currentPage;
    }

    @SuppressWarnings("all")
    public void setPageSize(final long pageSize) {
        this.pageSize = pageSize;
    }

    @SuppressWarnings("all")
    public void setTotal(final long total) {
        this.total = total;
    }

    @SuppressWarnings("all")
    public void setPageTotal(final long pageTotal) {
        this.pageTotal = pageTotal;
    }
    //</editor-fold>
}
