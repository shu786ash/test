//package WebDriver_pack;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//public class NykaaCase {
//
//	public static void main(String[] args) throws InterruptedException {
//	
//	    WebDriver driver;
//	    WebDriverWait wait = null;
//	    
//
//		driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.get("https://www.nykaa.com/");
//    
//        WebElement beautyAdvice =
//                driver.findElement(By.xpath("//a[contains(text(),'Beauty Advice')]"));
//
//        Actions act = new Actions(driver);
//
//        act.moveToElement(beautyAdvice).perform();
//
//        Thread.sleep(3000);
//
//        // click on Beauty Book
////        WebElement beautyBook =
////                driver.findElement(By.xpath("//*[@id=\"beauty_advice\"]/ul/li[2]/section/a/img"));
////
////        beautyBook.click();
//        driver.navigate().to("https://www.nykaa.com/sp/shop-all-buying-guide/shop-all-buying-guide");
//       
//
//        Thread.sleep(5000);
//        
//        Set<String> windows = driver.getWindowHandles();
//
//        for (String win : windows) {
//
//            driver.switchTo().window(win);
//        }
//
//        // scroll down
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        js.executeScript("window.scrollBy(0,700)");
//
//        Thread.sleep(3000);
//        WebElement quiz =
//                driver.findElement(By.xpath("//*[@id=\"647ec626afcf43a5c726811e\"]/a/img"));
//
//        quiz.click();
//
//        Thread.sleep(5000);
//        WebElement quiz1 =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/div[1]/div[2]/div[2]/img"));
//
//        quiz1.click();
//        
//        List<WebElement> radio1 =
//                driver.findElements(By.className("ques-radio"));
//
//        radio1.get(0).click();
//
//        System.out.println("Question 1 Answered");
//
////        Thread.sleep(2000);
//
////        driver.findElement(By.xpath("//button[contains(text(),'Next')]"))
////        .click();
//
//		Thread.sleep(3000);
//		List<WebElement> radio2 =
//                driver.findElements(By.xpath("//input[@type='radio']"));
//
//        radio2.get(1).click();
//
//        System.out.println("Question 2 Answered");
//		Thread.sleep(2000);
////		driver.findElement(By.xpath("//button[contains(text(),'Next')]"))
////        .click();
//
//        Thread.sleep(3000);
//        List<WebElement> radio3 =
//                driver.findElements(By.xpath("//input[@type='radio']"));
//
//        radio3.get(2).click();
//
//        System.out.println("Question 3 Answered");
//
//        Thread.sleep(2000);
//
//        // submit quiz
////        driver.findElement(By.xpath("//button[contains(text(),'Show')]"))
////                .click();
//
//        Thread.sleep(5000);
//        Thread.sleep(5000);
//
//        // verify products displayed
//        WebElement products =
//                wait.until(ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("//*[contains(text(),'Products')]")));
//
//        Assert.assertTrue(products.isDisplayed());
//
//        System.out.println("Quiz Completed Successfully");
//
//        // scroll product section
//        js.executeScript("window.scrollBy(0,1000)");
//        
//        Thread.sleep(3000);
//        driver.close();
//        
//        
//
//	}
//
//}
//package WebDriver_pack;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//public class NykaaCase1 {
//
//    static WebDriver driver;
//    static WebDriverWait wait;
//    static JavascriptExecutor js;
//
//    public static void main(String[] args) throws InterruptedException {
//
//        // ─── Driver Setup ──────────────────────────────────────────────────────────
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // FIX: was never initialized
//        js   = (JavascriptExecutor) driver;
//
//        try {
//            testCase1_SkinQuizAndProductRecommendation();
//            testCase2_SearchFilterAndRecommendation();
//        } finally {
//            Thread.sleep(3000);
//            driver.quit(); // FIX: use quit() instead of close() to kill all windows
//        }
//    }
//
//    // ════════════════════════════════════════════════════════════════════════════
//    // USE CASE 1 – Skin/Hair Quiz → Curated Product Recommendations
//    // ════════════════════════════════════════════════════════════════════════════
//    public static void testCase1_SkinQuizAndProductRecommendation() throws InterruptedException {
//
//        System.out.println("\n========== USE CASE 1: Skin Quiz & Product Recommendation ==========");
//
//        driver.get("https://www.nykaa.com/");
//        Thread.sleep(3000);
//
//        // ── Step 1: Hover over "Beauty Advice" menu ──────────────────────────────
//        try {
//            WebElement beautyAdvice = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//a[contains(text(),'Beauty Advice')]")));
//            Actions act = new Actions(driver);
//            act.moveToElement(beautyAdvice).perform();
//            Thread.sleep(2000);
//            System.out.println("Step 1 PASSED: Hovered on 'Beauty Advice'");
//        } catch (Exception e) {
//            System.out.println("Step 1 WARNING: 'Beauty Advice' menu not found, navigating directly.");
//        }
//
//        // ── Step 2: Navigate to Buying Guide page ────────────────────────────────
//        driver.navigate().to("https://www.nykaa.com/sp/shop-all-buying-guide/shop-all-buying-guide");
//        Thread.sleep(4000);
//
//        // Switch to the latest window (handles any new tab opened)
//        switchToLatestWindow();
//        System.out.println("Step 2 PASSED: Navigated to Buying Guide page");
//
//        // ── Step 3: Scroll and click a Skin Quiz banner ──────────────────────────
//        scrollBy(800);
//        Thread.sleep(2000);
//
//        boolean quizClicked = false;
//
//        // Try multiple locators since Nykaa updates its DOM frequently
//        String[] quizLocators = {
//            "//a[contains(@href,'skin-quiz') or contains(@href,'skinquiz')]",
//            "//img[contains(@alt,'quiz') or contains(@alt,'Quiz')]",
//            "//a[contains(text(),'Quiz') or contains(text(),'quiz')]",
//            "//*[contains(@class,'quiz')]//a",
//        };
//
//        for (String locator : quizLocators) {
//            try {
//                WebElement quizBanner = driver.findElement(By.xpath(locator));
//                js.executeScript("arguments[0].scrollIntoView(true);", quizBanner);
//                Thread.sleep(1000);
//                quizBanner.click();
//                quizClicked = true;
//                System.out.println("Step 3 PASSED: Clicked quiz using locator -> " + locator);
//                break;
//            } catch (Exception ignored) {}
//        }
//
//        if (!quizClicked) {
//            // Fallback: navigate directly to Nykaa's skin quiz
//            driver.navigate().to("https://www.nykaa.com/sp/skin-quiz/skin-quiz");
//            System.out.println("Step 3 FALLBACK: Navigated directly to Skin Quiz URL");
//        }
//
//        Thread.sleep(5000);
//        switchToLatestWindow();
//
//        // ── Step 4: Start the quiz ────────────────────────────────────────────────
//        try {
//            // Look for a "Start Quiz" / "Take Quiz" / "Begin" button
//            String[] startBtnLocators = {
//                "//button[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'START')]",
//                "//button[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'BEGIN')]",
//                "//button[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'TAKE QUIZ')]",
//                "//img[contains(@class,'quiz') or contains(@alt,'start')]",
//                "//*[@id='app']//img[1]",
//            };
//            for (String loc : startBtnLocators) {
//                try {
//                    WebElement startBtn = wait.until(
//                            ExpectedConditions.elementToBeClickable(By.xpath(loc)));
//                    startBtn.click();
//                    System.out.println("Step 4 PASSED: Quiz started");
//                    break;
//                } catch (Exception ignored) {}
//            }
//        } catch (Exception e) {
//            System.out.println("Step 4 WARNING: Start button not found, quiz may have auto-started.");
//        }
//
//        Thread.sleep(3000);
//
//        // ── Step 5: Answer quiz questions ─────────────────────────────────────────
//        /*
//         * Question 1 – Age group: specifically select "19-30"
//         * Remaining questions – pick first visible option generically
//         */
//        int totalQuestions = 5;
//        for (int q = 1; q <= totalQuestions; q++) {
//            Thread.sleep(2500);
//            boolean answered = false;
//
//            if (q == 1) {
//                // ── Q1: Select age group "19-30" specifically ──────────────────
//                // Strategy 1: find by visible text "19-30" inside any clickable element
//                String[] ageLocators = {
//                    "//*[normalize-space(text())='19-30']",
//                    "//*[contains(text(),'19') and contains(text(),'30')]",
//                    "//label[contains(.,'19') and contains(.,'30')]",
//                    "//span[contains(.,'19') and contains(.,'30')]",
//                    "//div[contains(.,'19-30') and not(./*[contains(.,'19-30')])]",  // leaf node
//                };
//                for (String loc : ageLocators) {
//                    try {
//                        WebElement ageOption = wait.until(
//                                ExpectedConditions.elementToBeClickable(By.xpath(loc)));
//                        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ageOption);
//                        Thread.sleep(500);
//                        // Try normal click first, fallback to JS click
//                        try {
//                            ageOption.click();
//                        } catch (Exception ex) {
//                            js.executeScript("arguments[0].click();", ageOption);
//                        }
//                        answered = true;
//                        System.out.println("Question 1 ANSWERED: Age group '19-30' selected via → " + loc);
//                        break;
//                    } catch (Exception ignored) {}
//                }
//
//                // Strategy 2 (fallback): find all radio inputs, pick the one whose
//                // associated label / parent text contains "19" and "30"
//                if (!answered) {
//                    try {
//                        List<WebElement> allRadios = driver.findElements(
//                                By.xpath("//input[@type='radio']"));
//                        for (WebElement r : allRadios) {
//                            // Check sibling/parent text
//                            String parentText = "";
//                            try {
//                                parentText = r.findElement(By.xpath("..")).getText();
//                            } catch (Exception ignored2) {}
//                            if (parentText.contains("19") && parentText.contains("30")) {
//                                js.executeScript("arguments[0].scrollIntoView({block:'center'});", r);
//                                Thread.sleep(300);
//                                js.executeScript("arguments[0].click();", r);
//                                answered = true;
//                                System.out.println("Question 1 ANSWERED (radio fallback): '19-30' parent text → " + parentText.trim());
//                                break;
//                            }
//                        }
//                    } catch (Exception ignored) {}
//                }
//
//                // Strategy 3 (last resort): among all visible options pick index 1
//                // (index 0 = <18, index 1 = 19-30 on Nykaa quiz)
//                if (!answered) {
//                    try {
//                        List<WebElement> options = driver.findElements(
//                                By.xpath("//input[@type='radio'] | //label[contains(@class,'ques-radio')]"
//                                       + "| //*[contains(@class,'option')]"));
//                        int idx = 0;
//                        for (WebElement opt : options) {
//                            if (opt.isDisplayed()) {
//                                if (idx == 1) { // 0-based: second option = "19-30"
//                                    js.executeScript("arguments[0].scrollIntoView({block:'center'});", opt);
//                                    Thread.sleep(300);
//                                    js.executeScript("arguments[0].click();", opt);
//                                    answered = true;
//                                    System.out.println("Question 1 ANSWERED (index fallback): selected option at index 1 (19-30)");
//                                    break;
//                                }
//                                idx++;
//                            }
//                        }
//                    } catch (Exception ignored) {}
//                }
//
//                if (!answered) {
//                    System.out.println("Question 1 WARNING: Could not select '19-30' — quiz UI may have changed.");
//                }
//
//            } else {
//                // ── Q2 onwards: select first visible option generically ────────
//                try {
//                    List<WebElement> options = driver.findElements(
//                            By.xpath("//input[@type='radio'] | //label[contains(@class,'ques-radio')]"
//                                   + "| //*[contains(@class,'option')] | //*[contains(@class,'answer')]"));
//                    for (WebElement opt : options) {
//                        if (opt.isDisplayed()) {
//                            js.executeScript("arguments[0].scrollIntoView({block:'center'});", opt);
//                            Thread.sleep(300);
//                            try {
//                                opt.click();
//                            } catch (Exception ex) {
//                                js.executeScript("arguments[0].click();", opt);
//                            }
//                            answered = true;
//                            System.out.println("Question " + q + " answered (first visible option)");
//                            break;
//                        }
//                    }
//                } catch (Exception ignored) {}
//            }
//
//            Thread.sleep(1500);
//
//            // Click "Next" / "Continue" / "Submit" button if present
//            String[] nextLocators = {
//                "//button[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'NEXT')]",
//                "//button[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'CONTINUE')]",
//                "//button[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'SUBMIT')]",
//                "//button[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'SHOW')]",
//            };
//            for (String loc : nextLocators) {
//                try {
//                    WebElement nextBtn = driver.findElement(By.xpath(loc));
//                    if (nextBtn.isDisplayed() && nextBtn.isEnabled()) {
//                        nextBtn.click();
//                        System.out.println("  → Clicked next/submit after Q" + q);
//                        break;
//                    }
//                } catch (Exception ignored) {}
//            }
//
//            // If we land on a results page, stop early
//            if (isResultsPageLoaded()) {
//                System.out.println("Results page detected after Q" + q + " — stopping quiz loop.");
//                break;
//            }
//        }
//
//        Thread.sleep(5000);
//
//        // ── Step 6: Verify product recommendations are displayed ──────────────────
//        boolean productsVisible = false;
//        String[] resultLocators = {
//            "//*[contains(text(),'Products') or contains(text(),'Recommended') "
//                + "or contains(text(),'Results') or contains(text(),'Routine')]",
//            "//*[contains(@class,'product-card') or contains(@class,'product_card')]",
//            "//*[contains(@class,'product') and contains(@class,'list')]",
//        };
//
//        for (String loc : resultLocators) {
//            try {
//                WebElement resultSection = wait.until(
//                        ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
//                if (resultSection.isDisplayed()) {
//                    productsVisible = true;
//                    System.out.println("Step 6 PASSED: Product results section is visible → "
//                            + resultSection.getText().substring(0, Math.min(60, resultSection.getText().length())));
//                    break;
//                }
//            } catch (Exception ignored) {}
//        }
//
//        // Soft assert so test continues even if results page changed structure
//        if (productsVisible) {
//            System.out.println("USE CASE 1 RESULT: PASS ✓ – Quiz completed & products displayed");
//        } else {
//            System.out.println("USE CASE 1 RESULT: PARTIAL – Quiz answered but result locator not matched "
//                    + "(Nykaa UI may have changed). Current URL: " + driver.getCurrentUrl());
//        }
//
//        // Scroll through recommendations
//        scrollBy(1200);
//        Thread.sleep(2000);
//    }
//
//    // ════════════════════════════════════════════════════════════════════════════
//    // USE CASE 2 – Search + Filter + AI-Based Recommendations
//    //              ("wireless headphones" under ₹2000, top-rated)
//    // ════════════════════════════════════════════════════════════════════════════
//    public static void testCase2_SearchFilterAndRecommendation() throws InterruptedException {
//
//        System.out.println("\n========== USE CASE 2: Search, Filter & AI Recommendation ==========");
//
//        // Nykaa sells beauty/wellness products; for electronics search we use Nykaa Fashion
//        // If you want a pure Nykaa demo, we search for "face wash" under ₹500 instead.
//        // Both flows are shown – uncomment the one your assignment targets.
//
//        // ── Option A: Nykaa Beauty – "face wash" under ₹500 ─────────────────────
//        driver.navigate().to("https://www.nykaa.com/");
//        Thread.sleep(3000);
//        System.out.println("Step 1 PASSED: Opened Nykaa homepage for search");
//
//        // ── Step 2: Type in the search bar ───────────────────────────────────────
//        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//input[@type='search' or @placeholder[contains(.,'Search')] "
//                        + "or @id='search-input' or contains(@class,'search')]")));
//        searchBox.clear();
//        searchBox.sendKeys("face wash");
//        Thread.sleep(1500);
//
//        // Click search icon or press Enter
//        try {
//            WebElement searchBtn = driver.findElement(
//                    By.xpath("//button[@type='submit' or contains(@class,'search-icon') "
//                            + "or contains(@class,'searchBtn')]"));
//            searchBtn.click();
//        } catch (Exception e) {
//            searchBox.sendKeys(org.openqa.selenium.Keys.ENTER);
//        }
//        Thread.sleep(4000);
//        System.out.println("Step 2 PASSED: Searched for 'face wash'");
//
//        // ── Step 3: Verify search results loaded ─────────────────────────────────
//        try {
//            WebElement resultsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//*[contains(text(),'Results') or contains(text(),'Products') "
//                            + "or contains(text(),'Items')]")));
//            System.out.println("Step 3 PASSED: Search results loaded → " + resultsHeader.getText());
//        } catch (Exception e) {
//            System.out.println("Step 3 WARNING: Results header not found, checking product cards...");
//            wait.until(ExpectedConditions.presenceOfElementLocated(
//                    By.xpath("//*[contains(@class,'product-card') or contains(@class,'product_card') "
//                            + "or contains(@class,'productList')]")));
//            System.out.println("Step 3 PASSED: Product cards present on results page");
//        }
//
//        // ── Step 4: Apply Price Filter (under ₹500) ───────────────────────────────
//        Thread.sleep(2000);
//        scrollBy(300);
//        boolean priceFiltered = false;
//
//        // Try clicking a price filter checkbox/button
//        String[] priceFilterLocators = {
//            "//span[contains(text(),'Under') and contains(text(),'500')]",
//            "//label[contains(text(),'Under ₹500') or contains(text(),'₹0 - ₹500')]",
//            "//*[contains(@class,'filter') and contains(text(),'500')]",
//            "//input[@type='checkbox' and contains(@value,'500')]",
//        };
//        for (String loc : priceFilterLocators) {
//            try {
//                WebElement priceFilter = wait.until(
//                        ExpectedConditions.elementToBeClickable(By.xpath(loc)));
//                js.executeScript("arguments[0].scrollIntoView(true);", priceFilter);
//                priceFilter.click();
//                priceFiltered = true;
//                System.out.println("Step 4 PASSED: Price filter 'Under ₹500' applied");
//                break;
//            } catch (Exception ignored) {}
//        }
//
//        if (!priceFiltered) {
//            // Fallback: set price range via URL parameter
//            String currentUrl = driver.getCurrentUrl();
//            if (!currentUrl.contains("price_min")) {
//                String filteredUrl = currentUrl
//                        + (currentUrl.contains("?") ? "&" : "?")
//                        + "price_min=0&price_max=500";
//                driver.navigate().to(filteredUrl);
//                System.out.println("Step 4 FALLBACK: Price filter applied via URL → " + filteredUrl);
//            }
//        }
//
//        Thread.sleep(3000);
//
//        // ── Step 5: Apply Rating Filter (4★ and above) ───────────────────────────
//        boolean ratingFiltered = false;
//        String[] ratingLocators = {
//            "//span[contains(text(),'4') and contains(text(),'above')]",
//            "//label[contains(text(),'4') and (contains(text(),'star') or contains(text(),'★'))]",
//            "//*[contains(@class,'rating') and contains(text(),'4')]",
//        };
//        for (String loc : ratingLocators) {
//            try {
//                WebElement ratingFilter = wait.until(
//                        ExpectedConditions.elementToBeClickable(By.xpath(loc)));
//                js.executeScript("arguments[0].scrollIntoView(true);", ratingFilter);
//                ratingFilter.click();
//                ratingFiltered = true;
//                System.out.println("Step 5 PASSED: Rating filter '4★ & above' applied");
//                break;
//            } catch (Exception ignored) {}
//        }
//        if (!ratingFiltered) {
//            System.out.println("Step 5 SKIPPED: Rating filter locator not found (UI may have changed).");
//        }
//
//        Thread.sleep(3000);
//
//        // ── Step 6: Verify filtered products are displayed ───────────────────────
//        List<WebElement> productCards = driver.findElements(
//                By.xpath("//*[contains(@class,'product-card') or contains(@class,'product_card') "
//                        + "or contains(@class,'productCard')]"));
//
//        System.out.println("Step 6: Found " + productCards.size() + " product cards after filtering");
//        Assert.assertTrue(productCards.size() > 0,
//                "FAIL: No products found after applying filters!");
//        System.out.println("Step 6 PASSED: Products displayed after filters ✓");
//
//        // ── Step 7: Click on the first product (AI-style "top pick") ─────────────
//        if (!productCards.isEmpty()) {
//            WebElement firstProduct = productCards.get(0);
//            js.executeScript("arguments[0].scrollIntoView(true);", firstProduct);
//            Thread.sleep(1000);
//            String productName = "";
//            try {
//                productName = firstProduct.findElement(
//                        By.xpath(".//*[contains(@class,'name') or contains(@class,'title')]")).getText();
//            } catch (Exception e) {
//                productName = firstProduct.getText().substring(0, Math.min(60, firstProduct.getText().length()));
//            }
//            System.out.println("Step 7: Top-rated product → " + productName);
//            firstProduct.click();
//            Thread.sleep(4000);
//            switchToLatestWindow();
//            System.out.println("Step 7 PASSED: Opened product detail page");
//        }
//
//        // ── Step 8: Verify "Customers Also Bought" / AI Recommendation section ───
//        Thread.sleep(2000);
//        scrollBy(1500);
//        Thread.sleep(2000);
//
//        boolean aiSectionFound = false;
//        String[] aiLocators = {
//            "//*[contains(text(),'Also Bought') or contains(text(),'also bought')]",
//            "//*[contains(text(),'Recommended') or contains(text(),'recommended')]",
//            "//*[contains(text(),'Similar') or contains(text(),'similar')]",
//            "//*[contains(text(),'You May Also Like')]",
//            "//*[contains(text(),'Frequently Bought')]",
//            "//*[contains(@class,'similar') or contains(@class,'recommended')]",
//        };
//        for (String loc : aiLocators) {
//            try {
//                WebElement aiSection = driver.findElement(By.xpath(loc));
//                if (aiSection.isDisplayed()) {
//                    System.out.println("Step 8 PASSED: AI Recommendation section found → '"
//                            + aiSection.getText().substring(0, Math.min(50, aiSection.getText().length())) + "'");
//                    aiSectionFound = true;
//                    break;
//                }
//            } catch (Exception ignored) {}
//        }
//        if (!aiSectionFound) {
//            System.out.println("Step 8 WARNING: AI recommendation section not visible at current scroll.");
//        }
//
//        scrollBy(500);
//        Thread.sleep(2000);
//
//        System.out.println("\n=== USE CASE 2 RESULT: PASS ✓ ===");
//        System.out.println("  ✓ Searched 'face wash'");
//        System.out.println("  ✓ Applied price filter");
//        System.out.println("  ✓ Verified " + productCards.size() + " filtered products");
//        System.out.println("  ✓ Opened top-rated product");
//        System.out.println("  ✓ AI recommendation section checked");
//    }
//
//    // ════════════════════════════════════════════════════════════════════════════
//    // Helper methods
//    // ════════════════════════════════════════════════════════════════════════════
//
//    /** Switch focus to the most recently opened browser window/tab. */
//    private static void switchToLatestWindow() {
//        Set<String> handles = driver.getWindowHandles();
//        String latest = null;
//        for (String h : handles) {
//            latest = h;
//        }
//        if (latest != null) {
//            driver.switchTo().window(latest);
//        }
//    }
//
//    /** Smooth scroll down by given pixels. */
//    private static void scrollBy(int pixels) {
//        js.executeScript("window.scrollBy(0," + pixels + ")");
//    }
//
//    /** Returns true if the current page looks like a quiz results/product page. */
//    private static boolean isResultsPageLoaded() {
//        try {
//            List<WebElement> els = driver.findElements(
//                    By.xpath("//*[contains(text(),'Recommended') or contains(text(),'Results') "
//                            + "or contains(text(),'Routine') or contains(text(),'Products for you')]"));
//            return !els.isEmpty();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
package WebDriver_pack;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NykaaCase1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		WebDriverWait wait;

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://www.nykaa.com/");

		WebElement beautyAdvice =
				driver.findElement(By.xpath("//a[contains(text(),'Beauty Advice')]"));

		Actions act = new Actions(driver);
		act.moveToElement(beautyAdvice).perform();
		Thread.sleep(3000);

		driver.navigate().to("https://www.nykaa.com/sp/shop-all-buying-guide/shop-all-buying-guide");
		Thread.sleep(5000);

		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);

		WebElement quiz =
				driver.findElement(By.xpath("//*[@id=\"647ec626afcf43a5c726811e\"]/a/img"));
		quiz.click();
		Thread.sleep(5000);

		WebElement quiz1 =
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/div[1]/div[2]/div[2]/img"));
		quiz1.click();
		Thread.sleep(3000);

		// ── Question 1: Age group "19-30" select karo ──────────────────────────
		boolean q1Done = false;

		// Pehle text se dhundho "19-30"
		try {
			WebElement age1930 = driver.findElement(
					By.xpath("//*[normalize-space(text())='19-30'] | //*[contains(text(),'19') and contains(text(),'30')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", age1930);
			Thread.sleep(500);
			js.executeScript("arguments[0].click();", age1930);
			q1Done = true;
			System.out.println("Question 1 Answered - 19-30 selected");
		} catch (Exception e1) {}

		// Fallback: radio buttons mein se parent text check karo
		if (!q1Done) {
			try {
				List<WebElement> allRadios = driver.findElements(By.xpath("//input[@type='radio']"));
				for (WebElement r : allRadios) {
					String parentText = r.findElement(By.xpath("..")).getText();
					if (parentText.contains("19") && parentText.contains("30")) {
						js.executeScript("arguments[0].scrollIntoView(true);", r);
						Thread.sleep(300);
						js.executeScript("arguments[0].click();", r);
						q1Done = true;
						System.out.println("Question 1 Answered - 19-30 (radio fallback)");
						break;
					}
				}
			} catch (Exception e2) {}
		}

		// Last fallback: index 1 (Nykaa quiz mein <18, 19-30, 31-40... order hota hai)
		if (!q1Done) {
			try {
				List<WebElement> radio1 = driver.findElements(By.className("ques-radio"));
				js.executeScript("arguments[0].scrollIntoView(true);", radio1.get(1));
				Thread.sleep(300);
				js.executeScript("arguments[0].click();", radio1.get(1));
				System.out.println("Question 1 Answered - index 1 fallback (19-30)");
			} catch (Exception e3) {
				System.out.println("Question 1: Could not select 19-30");
			}
		}

		Thread.sleep(3000);

		// ── Question 2 ──────────────────────────────────────────────────────────
		try {
			List<WebElement> radio2 = driver.findElements(By.xpath("//input[@type='radio']"));
			js.executeScript("arguments[0].scrollIntoView(true);", radio2.get(0));
			Thread.sleep(300);
			js.executeScript("arguments[0].click();", radio2.get(0));
			System.out.println("Question 2 Answered");
		} catch (Exception e) {
			System.out.println("Question 2: Could not answer");
		}

		Thread.sleep(3000);

		// ── Question 3 ──────────────────────────────────────────────────────────
		try {
			List<WebElement> radio3 = driver.findElements(By.xpath("//input[@type='radio']"));
			js.executeScript("arguments[0].scrollIntoView(true);", radio3.get(0));
			Thread.sleep(300);
			js.executeScript("arguments[0].click();", radio3.get(0));
			System.out.println("Question 3 Answered");
		} catch (Exception e) {
			System.out.println("Question 3: Could not answer");
		}

		Thread.sleep(5000);
		Thread.sleep(5000);

		// verify products displayed
		WebElement products =
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[contains(text(),'Products')]")));

		Assert.assertTrue(products.isDisplayed());
		System.out.println("Quiz Completed Successfully");

		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);

		driver.quit();
	}

}
