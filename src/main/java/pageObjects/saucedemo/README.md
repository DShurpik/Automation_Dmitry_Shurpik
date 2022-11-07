mvn versions:display-dependency-updates - команда для просмотра доступных обновлений библиотек

mvn versions:use-latest-versions - команда для автоматического обновления всех версий

mvn clean - очистка target репозитория

mvn install -DskipTests - компиляция jar-файла без запуска тестов

mvn clean install -DskipTests - очистка и компиляция jar файла

mvn clean test   Результат: Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 54.273 s - in TestSuite
                            Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

mvn -Dtest=Lecture8_1 test запуск свита тестов Lecture8_1

mvn -Dtest=Lecture8_2#frame_Test test запуск 1 теста frame_Test из Lecture8_2

mvn clean test -DsuiteXmlFile="src/test/java/resources/Lecture_8.xml" запуск из командной строки Xml файла Lecture_8

mvn clean test -DsuiteXmlFile="src/test/java/resources/Lecture_9.xml" запуск из командной строки Xml файла Lecture_9

mvn -Dtest=Lecture8_1#login1withProperty test -DAAA="standard_user" -DFFF="secret_sauce"
    В тест 


mvn clean test -DsuiteXml="Lecture_11"


mvn allure:serve команды для аллюра
mvn allure:report

