1. Логин с пустыми значениями
2. Логин с пустым паролем
3. Логин с некорректным логином и паролем
4. Закрыть окно с ошибкой
5. Проверка наличия кнопки Remove
6. Проверка наличия кнопки Add
7. Проверка цены продукта в каталоге
8. Проверка удаления из корзины (используя список продуктов)
9. Проверка количества в корзине
10. Проверка цены в корзине
11. Проверка удаления из корзины

1. [INFO] Building soucedemo 1.0-SNAPSHOT
   [INFO] --------------------------------[ jar ]---------------------------------
   [INFO] 
   [INFO] --- versions-maven-plugin:2.8.1:use-latest-versions (default-cli) @ soucedemo ---
   [INFO] Major version changes allowed
   [INFO] artifact org.seleniumhq.selenium:selenium-java: checking for updates from central
   [INFO] artifact org.testng:testng: checking for updates from central
   [INFO] artifact io.github.bonigarcia:webdrivermanager: checking for updates from central
   [INFO] ------------------------------------------------------------------------
   [INFO] BUILD SUCCESS
   [INFO] ------------------------------------------------------------------------
   [INFO] Total time:  1.866 s
   [INFO] Finished at: 2021-05-27T19:01:45+03:00
   [INFO] ------------------------------------------------------------------------


2. [INFO] Tests run: 13, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 42.708 s - in TestSuite

3. mvn -Dtest=LoginTest#closeErrorMessageTest+loginAsIncorrectUserTest test