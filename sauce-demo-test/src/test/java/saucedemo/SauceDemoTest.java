package saucedemo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SauceDemoTest extends SauceTestBase
{
	String siteUrl = "https://www.saucedemo.com/";

	@Test
	public void openPage()
	{
		driver.get(siteUrl);

		String title = driver.getTitle();
		System.out.println("got title: " + title);

		assertThat(title).isEqualTo("Swag Labs");
	}
}
