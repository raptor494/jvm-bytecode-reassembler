package com.raptor.test01;

import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TestClass01 {
	public static void main(String[] args) throws Exception {
		try {

			final String AUTHOR_UNKNOWN = "Unknown";
			
			var literature = Set.of(new Literature[] {
				
				new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling"),
				new Magazine("MAD", "#476"),
				new MagazineArticle(new Magazine("MAD", "#540"), "Donald Trump vs. The Bible", AUTHOR_UNKNOWN),
				new Book("The Way of Kings", "Brandon Sanderson"),
				new WebArticle(new Website("BBC News", new URL("https://www.bbc.com/news")), new URL("https://www.bbc.com/news/health-53889823"), "Hong Kong reports 'first case' of virus reinfection", AUTHOR_UNKNOWN),
				new Website("Gamespot", new URL("https://www.gamespot.com")),
				new WebArticle(new Website("Gamespot", new URL("https://www.gamespot.com")), new URL("https://www.gamespot.com/articles/crysis-remastered-launching-on-xbox-one-ps4-and-pc/1100-6481243/"), "Crysis Remastered Launching On Xbox One, PS4, And PC This September", "Alessandro Barbosa"),
					
			});
			
			var books = literature.stream()
					.filter(Book.class::isInstance)
					.map(Book.class::cast)
					.collect(Collectors.toSet());
			
			var authoredLiterature = literature.stream()
					.filter(AuthoredLiterature.class::isInstance)
					.map(AuthoredLiterature.class::cast)
					.collect(Collectors.toSet());
			
			var unknownAuthoredLiterature = authoredLiterature.stream()
					.filter(it -> it.author() == AUTHOR_UNKNOWN)
					.collect(Collectors.toSet());
			
			var articles = literature.stream()
					.filter(Article.class::isInstance)
					.map(Article.class::cast)
					.collect(Collectors.toSet());
			
			System.out.print("books = ");
			printcollection(books);
			System.out.println();
			
			System.out.print("authoredLiterature = ");
			printcollection(authoredLiterature);
			System.out.println();
			
			System.out.print("unknownAuthoredLiterature = ");
			printcollection(unknownAuthoredLiterature);
			System.out.println();
			
			System.out.print("articles = ");
			printcollection(articles);
			System.out.println();

		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;

		}
		
	}
	
	static void printcollection(Collection<?> collection) {
		if (collection == null) {
			System.out.println("null");
			return;
		}
		
		System.out.println('[');
		
		boolean first = true; 
		for (var element : collection) {
			if (first) first = false;
			else System.out.println(',');
			
			System.out.print("    "+element);
		}
		
		System.out.println();
		System.out.print(']');
	}
	
}

@interface Annotated {
	String name() default "";
}

interface Literature {
	@Annotated(name = "name")
	String name();
}

interface AuthoredLiterature extends Literature {
	String author();
}

interface ContainedLiterature<L extends Literature> extends Literature {
	L getContainer();
}

record Book(String name, String author) implements AuthoredLiterature {
	
	public Book {
		if (name == null) throw new NullPointerException("name");
		if (author == null) throw new NullPointerException("author");
		if ((name = name.strip()).isEmpty()) throw new IllegalArgumentException("name may not be blank");
		if ((author = author.strip()).isEmpty()) throw new IllegalArgumentException("author may not be blank");
	}
	
}

record Magazine(String name, String edition) implements Literature {
	
	public Magazine {
		if (name == null) throw new NullPointerException("name");
		if (edition == null) throw new NullPointerException("edition");
		if ((name = name.strip()).isEmpty()) throw new IllegalArgumentException("name may not be blank");
		if ((edition = edition.strip()).isEmpty()) throw new IllegalArgumentException("edition may not be blank");
	}
	
}

record Newspaper(String name, Date date) implements Literature {
	
	public Newspaper {
		if (name == null) throw new NullPointerException("name");
		if (date == null) throw new NullPointerException("date");
		if ((name = name.strip()).isEmpty()) throw new IllegalArgumentException("name may not be blank");
	}
	
}

record Website(String name, URL homepageURL) implements Literature {
	
	public Website {
		if (name == null) throw new NullPointerException("name");
		if (homepageURL == null) throw new NullPointerException("homepageURL");
		if ((name = name.strip()).isEmpty()) throw new IllegalArgumentException("name may not be blank");
	}
	
}

abstract class Article implements Literature, AuthoredLiterature {
	protected final String name;
	protected final String author;
	
	public Article(String name, String author) {
		if (name == null) throw new NullPointerException("name");
		if (author == null) throw new NullPointerException("author");
		if ((name = name.strip()).isEmpty()) throw new IllegalArgumentException("name may not be blank");
		if ((author = author.strip()).isEmpty()) throw new IllegalArgumentException("author may not be blank");
		
		this.name = name;
		this.author = author;
	}
	
	@Override
	public final String name() { return name; }
	
	@Override
	public final String author() { return author; }
	
	@Override
	public int hashCode() {
		return Objects.hash(name, author);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Article a) || obj.getClass() != this.getClass()) return false;
		return this.name.equals(a.name) && this.author.equals(a.author);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"[name="+name+", author="+author+']';
	}
	
}

final class WebArticle extends Article implements Literature, ContainedLiterature<Website> {
	private final Website website;
	private final URL articleURL;
	
	public WebArticle(Website website, URL articleURL, String name, String author) {
		super(name, author);
		if (website == null) throw new NullPointerException("website");
		if (articleURL == null) throw new NullPointerException("articleURL");
		
		String websiteHost = website.homepageURL().getHost();
		if (websiteHost.startsWith("www.")) {
			websiteHost = websiteHost.substring(4);
		}
		
		if (!articleURL.getHost().endsWith(websiteHost)) throw new IllegalArgumentException("articleURL is not on the given website");
		
		this.website = website;
		this.articleURL = articleURL;
	}
	
	public final Website website() { return website; }
	
	public final URL articleURL() { return articleURL; }
	
	@Override
	public final Website getContainer() { return website; }
	
	@Override
	public int hashCode() {
		return Objects.hash(website, articleURL, name, author);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof WebArticle a) /*|| obj.getClass() != this.getClass()*/) return false;
		return this.website.equals(a.website) && this.articleURL.equals(a.articleURL) && this.name.equals(a.name) && this.author.equals(a.author);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"[website="+website+", articleURL="+articleURL+", name="+name+", author="+author+']';
	}
	
}

final class NewspaperArticle extends Article implements ContainedLiterature<Newspaper> {
	private final Newspaper newspaper;
	
	public NewspaperArticle(Newspaper newspaper, String name, String author) {
		super(name, author);
		if (newspaper == null) throw new NullPointerException("newspaper");
		
		this.newspaper = newspaper;
	}
	
	public final Newspaper newspaper() { return newspaper; }
	
	@Override
	public final Newspaper getContainer() { return newspaper; }
	
	@Override
	public int hashCode() {
		return Objects.hash(newspaper, name, author);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof NewspaperArticle a) /*|| obj.getClass() != this.getClass()*/) return false;
		return this.newspaper.equals(a.newspaper) && this.name.equals(a.name) && this.author.equals(a.author);		
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"[newspaper="+newspaper+", name="+name+", author="+author+']';
	}
	
}

final class MagazineArticle extends Article implements AuthoredLiterature, ContainedLiterature<Magazine> {
	private final Magazine magazine;
	
	public MagazineArticle(Magazine magazine, String name, String author) {
		super(name, author);
		if (magazine == null) throw new NullPointerException("magazine");
		
		this.magazine = magazine;
	}
	
	public final Magazine magazine() { return magazine; }
	
	@Override
	public final Magazine getContainer() { return magazine; }
	
	@Override
	public int hashCode() {
		return Objects.hash(magazine, name, author);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof MagazineArticle a) /*|| obj.getClass() != this.getClass()*/) return false;
		return this.magazine.equals(a.magazine) && this.name.equals(a.name) && this.author.equals(a.author);		
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"[magazine="+magazine+", name="+name+", author="+author+']';
	}
	
}

enum Day {
	MONDAY("Mon."),
	TUESDAY("Tues."),
	WEDNESDAY("Wed."),
	THURSDAY("Thurs."),
	FRIDAY("Fri."),
	SATURDAY("Sat."),
	SUNDAY("Sun.");

	public final String abbreviation;

	private Day(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}