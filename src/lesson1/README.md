# Занятие №1 08.10.2024
## Основные структуры данных

> «Алгоритмы + структуры данных = программы» *Никлаус Вирт*

### Что такое и зачем нужны алгоритмы и структуры данных?

В рамках нашей дисциплины мы будем трактовать вышеупомянутые определения следующим образом.

***Структура данных*** - это способ организации данных в памяти компьютера. \
*Например:* массив, связный список, очередь и т.д.\
***Алгоритмы*** - упорядоченный набор операций, который обеспечивает выполнение различных действий над этими структурами. \
*Например:* поиск элемента, сортировка и т.д.

### Какие задачи помогает решить хорошее знание структур данных и алгоритмов?

Условно, ситуации можно разделить на ***три группы***:

- Хранение реальных данных.
- Инструментарий программиста.
- Моделирование.

### Хранение реальных данных

Подавляющее большинство структур данных, которые мы рассмотрим, будут направлены на решение задач хранения реальных данных.

***Реальные данные*** - данные описывающие физические сущности из "реального мира". \
*Например:* запись из картотеки, абонент из телефонной книги, товар в магазине и т.д.

В процессе преобразования и организации данных нам с вами придется отвечать на следующие вопросы:

 - Как данные будут храниться в памяти компьютера?
 - Подойдет ли ваше решение для сотни объектов? Для тысячи? А для миллиона?
 - Позволяет ли ваше решение быстро добавлять новые и удалять старые записи?
 - Возможен ли быстрый поиск?
 - Каким образом будет происходить сортировка?
 - и другие.

### Инструментарий программиста

Помимо структур данных которые хранят данные более или менее доступные пользователю. Существуют структуры, с которыми работает программа.

Программисты используют такие структуры в качестве вспомогательных инструментов.

*Например:* стек, очередь.

### Моделирование

Некоторые структуры данных позволяют смоделировать ситуации из реального мира. Например, графы могут использоваться для представления логистических цепочек или соединений задач в проекте.

### Краткий обзор структур данных

| Структура данных     | Достоинства                                                     | Недостатки                                                  |
|----------------------|-----------------------------------------------------------------|-------------------------------------------------------------|
| Массив               | Быстрая вставка, быстрый доступ к элементам                     | Медленный поиск, медленное удаление, фиксированный размер   |
| Упорядоченный массив | Поиск быстрее, чем в обычном массиве                            | Медленное удаление, медленная вставка, фиксированный размер |
| Стек                 | LIFO                                                            | Медленный доступ к произвольным элементам                   |
| Очередь              | FIFO                                                            | Медленный доступ к произвольным элементам                   |
| Связный список       | Быстрая вставка, быстрое удаление                               | Медленный поиск                                             |
| Двоичное дерево      | Быстрый поиск, вставка, удаление                                | Сложный алгоритм удаления                                   |
| Красно-черное дерево | Быстрый поиск, вставка, удаление                                | Сложность                                                   |
| Дерево 2-3-4         | Быстрый поиск, вставка, удаление. Дерево всегда сбалансировано. | Сложность                                                   |
| Хеш - таблица        | Очень быстрый доступ по ключу                                   | Медленное удаление, неэффективный расход памяти             |
| Куча                 | Быстрая вставка, удаление, доступ к наибольшему объекту         | Медленный доступ к произвольным элементам                   |
| Граф                 | Моделирование реальных ситуаций                                 | Сложность алгоритмизации                                    |

___

### Полезные ссылки по теме

 - https://prog-cpp.ru/data-struct/ - на примере С, но это нестрашно.
 - Потом мб еще чего-нибудь накидаю...