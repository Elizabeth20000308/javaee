package edu.njfu.sas.util;

public class Pageutil {
    private int currentPage;
    private long pageCount;
    private int pageSize;
    private int maxPage;

    public void setCurrentPage(int currentPage) {
        if (currentPage>maxPage){
            this.currentPage=maxPage;
        }else if (currentPage<1){
            this.currentPage=1;
        }else {
            this.currentPage = currentPage;
        }
    }

    public Pageutil(int currentPage,long pageCount, int pageSize) {
        this.pageCount=pageCount;
        setCurrentPage(currentPage);
        this.pageSize = pageSize;
        this.maxPage = (int) (pageCount % pageSize == 0 ? (pageCount/pageSize) : (pageCount/pageSize + 1));
        System.out.println(this.maxPage+"aaa");
    }

    public boolean isLastPage(){
        return maxPage==currentPage;
    }
     public  boolean isFirstPage(){
         return 1==currentPage;
    }
    public int nextPage(){
        if (maxPage!=currentPage){
            return currentPage++;
        }else{
            System.out.println("已是最后一页");
            return currentPage;
        }

    }
    public int prePage(){
        if (currentPage!=1){
            return currentPage--;
        }else {
            System.out.println("已是第一页");
            return currentPage;
        }
    }
    public int getMaxPage() {
        return maxPage;
    }
    public int getCurrentPage() {
        return currentPage;
    }
}
