## Цели проекта
Дипломная работа поможет закрепить знания и навыки по автоматизации тестирования мобильных приложений.

## Описание
Приложение даёт функционал по работе с претензиями хосписа и включает в себя:

1. Информацию о претензиях и функционал для работы с ними.
2. Новостную сводку хосписа.
3. Тематические цитаты.

## Документация

* **[План тестирования,Чек-лист,Тест-кейсы]**

  **[Google] - https://drive.google.com/drive/folders/1y69_V8NzznSSAW5ZG6EtZ1rH-ke50y-0?usp=sharing**
  **[GIT] - https://github.com/scriperirk/GitDiplomFinal/tree/dfe1f1d024e96c27470b0d2d772224a2a1cc6f13/Dopoln** 

* **[Результаты - allure-results]**

  **[Google] - https://drive.google.com/drive/folders/1y69_V8NzznSSAW5ZG6EtZ1rH-ke50y-0?usp=sharing**
  **[GIT] - https://github.com/scriperirk/GitDiplomFinal/tree/dfe1f1d024e96c27470b0d2d772224a2a1cc6f13/Dopoln**


## Шаги запуска тестирования

1. Выполнить git clone https://github.com/scriperirk/GitDiplomFinal.git на локальную машину.
2. Запустить **Android Studio** с проектом **GitDiplomFinal\fmh-android**.
3. Дождаться установки всех необходимых зависимостей.
4. Подключить устройство **Android API 32**, анимация окон и переходов должны быть отключены.
5. В проекте на папке **fmh-android\app** выбрать пункт контекстного меню **Run 'All Tests'**
6. Дальше необходимо скопировать результаты тестирования: запустить **Device File Explorer**, перейти в **\data\data\ru.iteco.fmhandroid\files\target** и сохранить в папку проекта.
7. Выполнить в терминале команду **allure serve**