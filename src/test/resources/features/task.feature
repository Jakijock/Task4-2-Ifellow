#language: ru

Функция: Проверка работы страницы

  Предыстория:
    Когда пользователь авторизирован
    И открыта домашняя страница

  @success
  Структура сценария: создание нового теста
    Когда открыта страница для создания задач
    Тогда заполняем поля: Тема=<name>, Описание=<description>
    И нажимаем кнопку Создать тест

    Примеры:
      |name    |description  |
      |TestSirozh3|Description|