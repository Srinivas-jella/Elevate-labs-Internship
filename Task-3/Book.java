class Book{
    private int bookId;
    private String bookTitle;
    private boolean isIssued;

    public Book(int bookId,String bookTitle,boolean isIssued){
        this.bookId=bookId;
        this.bookTitle=bookTitle;
        this.isIssued=isIssued;
    }

    public int getBookId() {
        return bookId;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public boolean isIssued() {
        return isIssued;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    @Override
    public String toString() {
        return "Book [ID=" + bookId + ", Title=" + bookTitle + ", Issued=" + isIssued + "]";
    }
}