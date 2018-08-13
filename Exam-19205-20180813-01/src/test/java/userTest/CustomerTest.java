package userTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hand.customermgt.customer.Customer;
import com.hand.customermgt.service.CustomerService;
import com.hand.filmmgt.model.Film;
import com.hand.filmmgt.model.Language;
import com.hand.filmmgt.service.FilmService;
import com.hand.filmmgt.service.LanguageService;

@RunWith(SpringJUnit4ClassRunner.class) // 用于指明执行当前测试类
@ContextConfiguration(locations = "classpath:spring/appconfig-root.xml")
public class CustomerTest {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private FilmService filmService;

	@Autowired
	private LanguageService languageService;
	
	@Before
	public void init() {
	}

	@Test
	public void saveCustomer() {
		Customer customer = new Customer();
		customer.setName("zhouyu");
		customer.setPassword("zhouyu");
		customerService.save(customer);
	}
	
	@Test
	public void saveFilm(){
		Film film = new Film();
		film.setId(0L);
		film.setTitle("我不是药神");
		filmService.save(film);
		
	}
	
	@Test
	public void saveLanguage(){
		//English  Japanese Spanish Chinese Russian 
		Language language = new Language();
		language.setLanguage("Russian");
		languageService.save(language);
	}
	
	/**
	 * 从文件中添加电影到数据库
	 * 
	 * @throws IOException
	 */
	@Test
	public void addMoviesByFile() throws IOException {
		File file = new File("data/movie");// Text文件
		BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
		String s = null;
		ArrayList<Film> list = new ArrayList<Film>();
		while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
			Film movie = new Film();

			String strArr[] = s.split("\\|");
			long a = Integer.parseInt(strArr[0]);
			movie.setId(a);
			movie.setTitle(strArr[1]);
			movie.setPicPath(strArr[1] + ".jpg");
			movie.setDescription(strArr[4]);
			list.add(movie);
			filmService.save(movie);
			System.out.println("当前电影id： " + a);
		}
		br.close();
		System.err.println("电影长度为：" + list.size());
		System.err.println("添加成功！");
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public FilmService getFilmService() {
		return filmService;
	}

	public void setFilmService(FilmService filmService) {
		this.filmService = filmService;
	}

	public LanguageService getLanguageService() {
		return languageService;
	}

	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}
	
}
