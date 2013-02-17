package me.kennylee.monster;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import me.kennylee.monster.vo.Enemy;
import me.kennylee.monster.vo.QueryModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
//				DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/analysis", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> analysis(@RequestBody QueryModel model) {
		Map<String, Object> map = new HashMap<String, Object>(1);
		String str = model.getBattleresume();
		logger.debug("-----" + str);
		List<Enemy> enemies = BattleResumeAnalyzer.analysis(str);
		map.put("enemies", enemies);
		return map;
	}

}
