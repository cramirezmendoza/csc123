package lab4;
import java.util.Objects;
public class Book {
	String Title;
	String Author;
	int pages;
	int ISBN;
	Library library;
	
	
	public Book(String title, String author, int pages, int iSBN) {
		super();
		Title = title;
		Author = author;
		this.pages = pages;
		ISBN = iSBN;
	}
	// Biconditional Association
	public void setLibrary(Library l) {
	    this.library = l;
	    if (l.getBooks() != this) {
	        l.setBook(this);
	    }
	}

	public Library getLibrary() {
	    return this.library;
	}



	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getAuthor() {
		return Author;
	}


	public void setAuthor(String author) {
		Author = author;
	}


	public int getPages() {
		return pages;
	}


	public void setPages(int pages) {
		this.pages = pages;
	}


	public int getISBN() {
		return ISBN;
	}


	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Author, ISBN, Title, pages);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(Author, other.Author) && ISBN == other.ISBN && Objects.equals(Title, other.Title)
				&& pages == other.pages;
	}
	@Override
	public String toString() {
		return "Book [Title=" + Title + ", Author=" + Author + ", pages=" + pages + ", ISBN=" + ISBN + ", library="
				+ library + "]";
	}
	
	

}
