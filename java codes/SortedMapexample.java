package COLLECTIONS;

import java.util.*;
import java.util.Map.Entry;

class Book {
    private String author;
    private double price;

    public Book(String author, double price) {
        this.author = author;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [author= " + author + ", Price=" + price + "]";
    }
}

class Bookstore {
    private java.util.SortedMap<String, Book> bookmap;

    public Bookstore() {
        bookmap = new TreeMap<String, Book>();
    }

    public void addBook(String title, String author, double price) {
        Book bk = new Book(author, price);
        bookmap.put(title, bk);
    }

    public void display() {
        for (Entry<String, Book> entry : bookmap.entrySet()) {
            System.out.println("Title: " + entry.getKey() + " " + entry.getValue());
        }
    }

    public void displayBooksInRange(String fromTitle, String toTitle) {
        SortedMap<String, Book> submap = bookmap.subMap(fromTitle, toTitle);
        System.out.println("Books in the range:");
        for (Map.Entry<String, Book> entry : submap.entrySet()) {
            System.out.println("Title: " + entry.getKey() + " " + entry.getValue());
        }
    }

    public void getFirstBook() {
        if (!bookmap.isEmpty()) {
            System.out.println("First Book: " + bookmap.firstEntry());
        } else {
            System.out.println("No books available.");
        }
    }

    public void getLastBook() {
        if (!bookmap.isEmpty()) {
            System.out.println("Last Book: " + bookmap.lastEntry());
        } else {
            System.out.println("No books available.");
        }
    }
}

public class SortedMapexample {

    public static void main(String[] args) {
        Bookstore store = new Bookstore();
        store.addBook("Java", "John", 450000);
        store.addBook("DS", "Honey", 150000);
        store.addBook("C", "Ram", 45456700);
        store.addBook("C#", "Bob", 450340);
System.out.println("all books");
        store.display();
        
        store.displayBooksInRange("C", "Java");

        store.getFirstBook();
        store.getLastBook();
    }
}
