
<a align="center" href="https://komarev.com/ghpvc/?username=daramirra&style=flat&color=9152C0&label=Hello%20Visitors!">
  <img src="https://komarev.com/ghpvc/?username=Vasili888-QA&style=flat&color=9152C0&label=Hello%20Visitors!"/>
</a>


<h1 align="center">:point_down: Project with autoTests for iFuture.by :point_down:</h1>

![iFuture.png](src/test/resources/images/iFuture.png)

___
<h2 align="center">What I like to use...</h2>

| Java | IntelliJ IDEA | Gradle | Maven | Junit5 | Selenide | Cucumber |
|:------:|:----:|:----:|:------:|:------:|:------:|:------:|
| <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/java.png" width="150" height="70"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/IntelliJ-IDEA.png" width="150" height="70"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/Gradle.png" width="150" height="70"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/maven.png" width="150" height="70"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/junit.png" width="150" height="70"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/Selenide.jfif" width="150" height="70"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/cucumber.jpg" width="150" height="70"> |
| GitHub | Jenkins | Bamboo | Selenoid | Allure Report | Allure TestOps | Jira |
| <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/logo/Github.png" width="50" height="50"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/logo/Jenkins.png" width="50" height="50"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/bamboo.png" width="170" height="40"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/logo/Selenoid.png" width="70" height="70"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/logo/Allure_Report.png" width="70" height="70"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/logo/AllureTestOps.png" width="70" height="70"> | <img src="https://github.com/Vasili888-QA/Vasili888-QA/blob/master/images/logo/Jira.png" width="70" height="70"> |


---


  <p align="center">
    <a href="https://github.com/Vasili888-QA/Vasili888-QA/issues">
      <img alt="Issues" src="https://img.shields.io/github/issues/Vasili888-QA/JUnit5ParameterizeTests?color=e7f90f" />
    </a>
    <a href="https://github.com/Vasili888-QA/Vasili888-QA/pulls">
      <img alt="GitHub pull requests" src="https://img.shields.io/github/issues-pr/Vasili888-QA/JUnit5ParameterizeTests?color=1eed1e" />
    </a>
  </p>

---

<a href="https://github.com/Vasili888-QA/github-readme-stats">
  <img align="center" src="https://github-readme-stats.vercel.app/api/?username=Vasili888-QA&theme=buefy&bg_color=30,abf596,f7f685&title_color=040ec5&text_color=040ec5"  alt="Test"/>
</a>
<a href="https://github-readme-stats.vercel.app/api/top-langs?username=Vasili888-QA&theme=vue&show_icons=true&locale=en&layout=normal">
  <img align="center" src="https://github-readme-stats.vercel.app/api/top-langs?username=Vasili888-QA&theme=vue&show_icons=true&locale=en&layout=normal&bg_color=30,f7f685,abf596&title_color=040ec5&text_color=040ec5"  alt="Test2"/>
</a>

___
<h6 align="right">From Minsk with :sparkling_heart:  at iFuture</h6>


## :computer: Run command on Terminal:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Run tests from terminal with filled remote.properties:*

```bash
gradle clean test

or 

gradle clean regress_tests
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Run tests from terminal without filled remote.properties:*

```bash
gradle clean test 
  -Dbrowser=[BROWSER]
  -DbrowserVersion=[BROWSER_VERSION]
  -DbrowserSize=[BROWSER_SIZE]
  -DremoteDriverUrl=https://[selenoidUser]:[selenoidPwd]@[REMOTE_DRIVER_URL]/wd/hub/
  -DvideoStorage=https://[REMOTE_DRIVER_URL]/video/
  -Dthreads=[THREADS]
  -DaccountPassword=[ACCOUNT_PASSWORD]
  -DbaseUrl=[BASE_URL]
```

Where:
>- [x] *Dbrowser - Browser type, default value Chrome*
>- [x] *DbrowserVersion - Browser version, default value 91.0*
>- [x] *DbrowserSize - Browser window size, default value 1920x1080*
>- [x] *DremoteDriverUrl - Remote server Selenoid with login and password, default value https://[selenoidUser]:[selenoidPwd]@selenoid.autotests.cloud/wd/hub/*
>- [x] *DvideoStorage - Video storage on Selenoid, default value https://selenoid.autotests.cloud/video/*
>- [x] *Dthreads - Quantity of threads, default value 1*
>- [x] *DaccountPassword - Account password for tests*
>- [x] *DbaseUrl - Base URL*

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Run tests from terminal with a few threads:*

```bash
gradle clean test -Dthreads=[threadsValue]
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:green_circle:&nbsp;&nbsp;*Make Allure report:*

```bash
allure serve build/allure-results
```

---
<h2 align="center">Get Allure Report</h2>

![allureReport.png](src/test/resources/images/allureReport.png)

---
<h2 align="center">Integration with test management system "Allure TestOps"</h2>

![allureReport.png](src/test/resources/images/Allure-Test-Ops.jpg)

---
<h2 align="center">Integration with bug tracking system "Jira"</h2>

![allureReport.png](src/test/resources/images/JiraIntegration.png)

---
<h2 align="center">Telegram Notification</h2>

![telegramReport](src/test/resources/images/telegram-Report.png)

---
<h2 align="center">Get Video Report</h2>

![allureReport.png](src/test/resources/images/video2.gif)
