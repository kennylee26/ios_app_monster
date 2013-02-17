package me.kennylee.monster;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.kennylee.monster.vo.Enemy;

/**
 * @author kennylee
 * 
 */
public class BattleResumeAnalyzer {

	private static final Logger logger = LoggerFactory
			.getLogger(BattleResumeAnalyzer.class);

	private static final Pattern EGG_PATTERN = Pattern
			.compile("egg\\s*=\\s*1,\\s*num\\s*=\\s*([\\d]+),");
	private static final Pattern FIRST_EGG_PATTERN = Pattern
			.compile("num\\s?=\\s?([\\d]+)[\\s\\S]*egg\\s*=\\s*1,\\s*defend");

	/**
	 * 分析信息文件，转成怪物属性对象。
	 * 
	 * @param str
	 * @return List of Enemy
	 */
	public static List<Enemy> analysis(String str) {
		List<Enemy> enemies = new ArrayList<Enemy>();
		Matcher matcher = FIRST_EGG_PATTERN.matcher(str);
		addEnemy(enemies, matcher);
		logger.debug("first egg: " + enemies.size());
		matcher = EGG_PATTERN.matcher(str);
		addEnemy(enemies, matcher);
		return enemies;
	}

	private static void addEnemy(List<Enemy> enemies, Matcher matcher) {
		while (matcher.find()) {
			String eggNum = matcher.group(1);
			Enemy e = new Enemy();
			e.setEgg(true);
			e.setNum(Integer.valueOf(eggNum));
			enemies.add(e);
		}
	}

}
