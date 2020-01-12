package pars;

import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

	public static void main(String[] args)  throws IOException {
				List<Article> articlelist = new ArrayList<>();
				
					Document doc = Jsoup.connect("https://jobs.dou.ua/vacancies/?category=Java&exp=0-1").get();
			
					Elements titleElements = doc.getElementsByAttributeValue("Class", "vacancy");
			
					titleElements.forEach(titleElement -> {
						Element aElement = titleElement.child(0);
						String url = aElement.attr("href");
						String title = aElement.child(0).text();
						
						articlelist.add(new Article(url, title));
					});
					articlelist.forEach(System.out::println);
			
			}
		}
		class Article{	
			
			private String url;
			private String name;
			
			
			
			public Article(String url, String name) {
				super();
				this.url = url;
				this.name = name;
			}
			public String getUrl() {
				return url;
			}
			/**
			 * @param utl the url to set
			 */
			public void setUrl(String url) {
				this.url = url;
			}
			/**
			 * @return the name
			 */
			public String getName() {
				return name;
			}
			/**
			 * @param name the name to set
			 */
			public void setName(String name) {
				this.name = name;
			}
			@Override
			public String toString() {
				return "Article [url=" + url + ", name=" + name + "]";
			}
			
			

		
		}
	


