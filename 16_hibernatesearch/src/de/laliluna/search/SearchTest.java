package de.laliluna.search;

import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.WildcardQuery;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

public class SearchTest {
	public static void main(String[] args) {
		createSomeArticles();
		search();
	}

	private static void search() {
		Session session = SessionFactoryUtil.getFactory().openSession();
//		create a full text session
		FullTextSession fSession = Search.getFullTextSession(session);
		fSession.beginTransaction();
//		create a parser to parse a full text query
		/*QueryParser parser = new QueryParser("title", new StandardAnalyzer());
		Query lucenceQuery = null;
		try {
			lucenceQuery = parser.parse("title:About nonsense AND content:everywhere");
			
		} catch (ParseException e) {
			throw new RuntimeException("Cannot search with query string",e);
		}
//		execute the query
		List<Article> articles = fSession.createFullTextQuery(lucenceQuery, Article.class).list();
		for (Article article : articles) {
			System.out.println(article);
		}*/
		System.out.println("Searching for title 'About Hibernate'");
//		search a full term
		List<Article> articles = null;
		articles = fSession.createFullTextQuery(new TermQuery(new Term("title", "About Hibernate")), Article.class).list();
		System.out.println(articles.size());
		
		for (Article article : articles) {
			System.out.println(article);
		}
		System.exit(0);
/*
		System.out.println("Searching for title starting with 'About'");
//		search a full term
		articles = fSession.createFullTextQuery(new WildcardQuery(new Term("title", "About*")), Article.class).list();
		for (Article article : articles) {
			System.out.println(article);
		}
*/
		fSession.getTransaction().commit();
	}

	private static void createSomeArticles() {
		Session  session = SessionFactoryUtil.getFactory().getCurrentSession();
		session.beginTransaction();
		session.save(new Article("About Hibernate", "This article covers all the quirks of Hibernate"));
		session.save(new Article("About Advanced Hibernate", "Hibernating is a popular sport of students everywhere in the world"));
		session.save(new Article("About Nonsense", "Nonsense is nearly everywhere in our everydays live"));
		
		session.getTransaction().commit();
	}
}
