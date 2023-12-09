package lab4;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
public class Library 
{
	private String Name;
	private String City;
	private String State;
	private List<Book> books;; //array list
	
	public Library(String name, String city, String state) 
	{
		super();
		Name = name;
		City = city;
		State = state;
		this.books = new ArrayList<>();
	}
	// Biconditional Association
	
	public void addBook(Book book) {
        books.add(book);
        book.setLibrary(this); // Set the library reference in the book
    }

    public List<Book> getBooks() 
    {
        return books;
    }
    public void removeBook(Book book) {
        books.remove(book);
        book.setLibrary(null);
    }
    public int getSize() {
    	return books.size();
    }
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(City, Name, State);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		return Objects.equals(City, other.City) && Objects.equals(Name, other.Name)
				&& Objects.equals(State, other.State);
	}

	@Override
	public String toString() {
		return "Library [Name=" + Name + ", City=" + City + ", State=" + State + ", book=" + books + ", ]";
	}

	public void setBook(Book book) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
