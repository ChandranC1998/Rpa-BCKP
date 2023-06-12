import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample1 {
	WebDriver driver;

	public void  a_LoadingPage() {
		System.setProperty("webdriver.chrome.driver","D:\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	public void  b_LocateTheElements() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Click Me')]")).click();

	}
	public void  c_closeAndQuit() {
		driver.close();
		driver.quit();
	}
	public void d_FileUpload() {
		WebElement Fileupload = driver.findElement(By.id("uploadfile_0"));
		Fileupload.sendKeys("C:\\Users\\Admin\\Desktop\\beauty.jpg");
		WebElement accept=	driver.findElement(By.id("terms"));
		accept.click();
		WebElement 	submit=driver.findElement(By.id("submitbutton"));
		submit.click();
	}
	public void e_GetMethods() {
		String FontSize = driver.findElement(By.id("signin_button")).getCssValue("font-size");
		System.out.println(FontSize);
		String Tagname = driver.findElement(By.id("signin_button")).getTagName();
		System.out.println(Tagname);
		String att = driver.findElement(By.id("signin_button")).getAttribute("class");
		System.out.println(att);
		String text = driver.findElement(By.id("signin_button")).getText();
		System.out.println(text);
		String title = driver.getTitle();
		System.out.println(title);
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
	}
	public void f_AlartPopup() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void g_ConfirmPopup() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
	}
	public void g_PromptPopup() {
		Alert alert = driver.switchTo().alert();						
		alert.sendKeys("Sujan");
		alert.accept();
		alert.dismiss();
	}
	public void h_KeyBoardPopup() {
		Actions act = new Actions (driver);
		driver.findElement(By.id("email")).sendKeys("rreyutiuyou@gmail.com");
		act.sendKeys(Keys.TAB, "password").perform();
		act.sendKeys(Keys.ENTER).build().perform();
		act.sendKeys(Keys.RETURN).build().perform();
		//return =enter is same meaning
	}
	public void i_KeyboardIncrementAndDecrementOption() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_UP).build().perform();
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		for (int i = 0; i < 3; i++) {
			act.sendKeys(Keys.ARROW_UP).build().perform();;
		}
	}
	public void j_linkTest() {
		driver.findElement(By.linkText("Forgot your password ?")).click();
		driver.findElement(By.partialLinkText("Forgot")).click();
	}
	public void k_SimilarElementCounts() {
		int linkscount = driver.findElements(By.tagName("a")).size();
		System.out.println(linkscount);
		int imagecount = driver.findElements(By.tagName("img")).size();
		System.out.println(imagecount);
		int textcount = driver.findElements(By.xpath("//p[@text()='arun'])")).size();
		System.out.println(textcount);
	}
	public void	l_MouseActionAndMouseHover() {
		WebElement mousemovingtoElectronics= driver.findElement(By.xpath("//div[contains(text(),'Electronics')]"));
		Actions act =new Actions(driver);
		act.moveToElement(mousemovingtoElectronics).build().perform();
	}
	public void m_MouseActionDragdrops() {
		Actions act = new Actions(driver);
		WebElement Element1 = driver.findElement(By.id("draggable"));
		WebElement Element2 = driver.findElement(By.id("droppable"));
		act.dragAndDrop(Element1, Element2).build().perform();
	}
	public void n_MouseActionRightClicks() {
		WebElement rightclick =driver.findElement(By.xpath("//span[contains(text(),'right click')]"));
		Actions act =new Actions(driver);
		///for right click the button we use context clickmethod
		act.contextClick(rightclick).build().perform();
	}
	public void o_MouseActionsDoubleclicks() {
		WebElement DoubleClick=	driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
		Actions act=new Actions(driver);
		act.doubleClick( DoubleClick).build().perform();
	}
	public void p_NavigationCommands() {
		driver.navigate().to("https://www.flipkart.com/");
		driver.navigate().back();
		driver.navigate().forward();
	}
	public void q_TimingSet() throws InterruptedException {
		Thread.sleep(3000);
	}
	public void R_ImplicitTiming() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//h3[contains(text(),'Sachin Tendulkar - Wikipedia')]")).click();
	}
	public void s_ExplicitTiming() {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'Sachin Tendulkar - Wikipedia')]")));

		driver.findElement(By.xpath("//h3[contains(text(),'Sachin Tendulkar - Wikipedia')]")).click();
	}
	public void t_HandlingTabs() {
		ArrayList <String> gmailtabs= new  ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(gmailtabs.get(1));
	}

	public void u_HandlingWindsow() {
		ArrayList<String> naukriwindows = new ArrayList<String>(driver.getWindowHandles());
		String mainwindowtitle = driver.getTitle();
		System.out.println(mainwindowtitle);
		driver.switchTo().window(naukriwindows.get(1));
		String childwindowtitle = driver.getTitle();
		System.out.println(childwindowtitle);
		driver.close();

	}
	public void v_MouseScrolling() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		// ithu width and hight kuduthu check seivatharku
		js.executeScript("window.scrollBy(0,1000)");
		//ithu pade voda endku povatharkku
		js.equals("window.scrollTo(0,document.body.scrollHeight");
	}
	private void  w_getscreenshot(){
		//class referencevariable asking driver to take screenshoot and get output as File(physical variable)  and storing its is in ScrFile( referencevariable)  and datatype is FILE)
		File ScrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScrFile, new File("F:\\selenium\\Screenshot\\screenshot"+System.currentTimeMillis()+".png"));
		//imaginary variable scrFile ,real time bring Screenshot,fileUtiles used to copy screenshot from ScrFile to Machine path using copyFile(method) .
	}
	public void x_pageloadTime() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("Sachine tendulkar");
		Actions act =new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//h3[contains(text(),'Sachin Tendulkar - Wikipedia')]")).click();
		
	}
	public void y_cssselector() {
		// driver.findElement(By.className("signin btn btn-info")).click();
		driver.findElement(By.cssSelector("#signin_button")).click();

		// driver.findElement(By.id("user_login")).sendKeys("UserName");
		driver.findElement(By.cssSelector("#user_login")).sendKeys("UserName");

		// driver.findElement(By.id("user_password")).sendKeys("Password");
		driver.findElement(By.cssSelector("#user_password")).sendKeys("Password");

		driver.findElement(By.name("submit")).click();
		// css selector two type
		// id - start(#)
		// class-start(.)
		// adv-script will run bit faster
		// class and id attribute only used.
		
	}
	public void z_Mousescrolling() {
		driver.findElement(By.xpath("(//span[contains(text(),'Get access')]/preceding::button)[2]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//ITHU KURIPITA OR THEVAIPATTA IDANGALUKU POVATHARKU
		js.executeScript("window.scrollBy(0,1000)");
		//ITHU DIRECTAH LAST END POVATHERKU
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}

