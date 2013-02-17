package me.kennylee.monster;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import me.kennylee.monster.vo.Enemy;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestAnalysisBattleResume {

	@Test
	public void test() throws IOException {
		String filePath = this.getClass().getClassLoader().getResource(".")
				.getPath()
				+ "/" + "BattleResume.lua";
		File file = new File(filePath);
		InputStream is = new FileInputStream(file);
		List<String> lines = IOUtils.readLines(is);
		String str = "";
		for (String l : lines) {
			//str += IOUtils.LINE_SEPARATOR;
			str += l;
		}
		List<Enemy> enemies = BattleResumeAnalyzer.analysis(str);
		Assert.assertFalse(enemies.isEmpty());
		for (Enemy enemy : enemies) {
			System.out.println(enemy);
		}
	}

}
