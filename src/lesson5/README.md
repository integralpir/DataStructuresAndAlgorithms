# Занятие №5 09.11.2024
##  Сравнение объектов. Простая сортировка.

Во всех примерах, приводившихся ранее, мы работали с массивом примитивных данных типа ```long```.
Хранение примитивных типов упрощает примеры, но оно не характерно для использования реальных структур данных. 
Обычно хранимые элементы данных (записи) состоят из многих полей. 
Скажем, в записи работника может храниться фамилия, имя, возраст, номер социального страхования и т. д. 
В каталоге коллекции марок хранится название страны, выпустившей марку, номер по каталогу, состояние, текущая стоимость и т. д

### Сравнения объектов.

Давайте разберем основные операции, которые позволяли нам реализовывать методы наших массивов,
и сравним их реализацию с примитивными и ссылочными (объектными) данными.

В качестве хранилища с примитивными данными мы будем использовать наш массив целых чисел типа long из прошлых занятий.
В качестве хранилища с объектами мы будем использовать массив объектов класса ```Person```:

```java
public class Person {
    private String firstName;
    private String lastName;
    private String passportSeriesNumber;
    private byte age;
    
    // Конструкторы & аксессоры
}
```
> *В рамках данного занятия мы будем работать с той условностью, что наши массивы принимают только уникальные значения.*

#### Тождество

Для того чтобы добавить новый элемент в массив с примитивными данных мы проходились в цикле по всем элементам 
и проверяли их равенство с помощью оператора ```==```, на этой логике был реализован метод ```contains```...

```java
 public boolean contains(long searchValue) {
    for (int i = 0; i < nElems; i++) {
        if (array[i] == searchValue) {
            return true;
        }
    }

    return false;
}
```

Особенностью примитивных типов является то, что они хранятся в памяти в качестве значений, тогда как объекты хранятся в качестве ссылок на ячейки памяти, где хранятся данные об объекте.
Не будем углубляться в устройство памяти в ```Java```. Вышесказанное было нужно лишь для того, чтобы понять, что следующий код ***будет сравнивать не значения переменных, а их ссылки***...

```java
import lesson5.examples.Person;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Roman", "Orlov", "1234123456", 26);
        Person person2 = new Person("Roman", "Orlov", "1234123456", 26);

        System.out.println(person1 == person2); // false
    }
}
```

Казалось бы, значения переменных должны быть одинаковыми, так и есть, но объекты записаны в разные ячейки памяти и оператор ```==``` сравнивает лишь ссылки.
Например, следующий код отработает корректно т.к. ```person2``` будет присвоена ссылка на ```person1```...

```java
import lesson5.examples.Person;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Roman", "Orlov", "1234123456", 26);
        Person person2 = person1;

        System.out.println(person1 == person2); // true
    }
}
```

Итак, как же в таком случае нужно проверять тождество двух объектов. 
В этом нам помогут два метода класса ```Object``` - ```equals``` & ```hashCode```.

> Все классы в ```Java``` неявно (на уровне компиляции) наследуются от класса ```Object```, поэтому в каждом вашем классе могут быть переопределены некоторые методы
> такие, как ```equals```, ```hashCode```, ```toString``` и другие, тем не менее они уже имеют свою собственную реализацию.

Рассмотрим реализацию вышеупомянутых методов...

```java
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String passportSeriesNumber;
    private byte age;

    // Конструкторы & аксессоры

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(passportSeriesNumber, person.passportSeriesNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, passportSeriesNumber, age);
    }
}
```

Вместе, эти два метода образуют так называемый контракт Equals & HashCode, методы **должны(!)** переопределяться парой.
Зачем? Т.к. сперва производится сравнение по хешу, чтобы понять, совпадают ли объекты, а только после подключается equals, 
чтобы определить, совпадают ли значения полей объекта.

Каждый из этой пары методов обязан соблюдать свой контракт, если коротко, то:
##### equals:
 - Рефлексивность — ```x.equals(x)``` возвращает ```true```.
 - Симметричность — ```x.equals(y) <=> y.equals(x)```.
 - Транзитивность — ```x.equals(y) <=> y.equals(z) <=> x.equals(z)```.
 - Согласованность — повторный вызов ```x.equals(y)``` должен возвращать значение предыдущего вызова, если сравниваемые поля не изменялись.
 - Сравнение null — ```x.equals(null)``` возвращает ```false```.
##### hashCode:
 - Повторный вызов ```hashCode``` для одного и того же объекта должен возвращать одинаковые хеш-значения, если поля объекта, участвующие в вычислении значения, не менялись.
 - Если ```equals()``` для двух объектов возвращает ```true```, ```hashCode()``` также должен возвращать для них одно и то же число.
 - При этом неравные между собой объекты могут иметь одинаковый ```hashCode```.

Таким образом, переопределив методы ```equals``` и ```hashCode```, реализация метода ```contains``` нашего массива с объектами примет следующий вид...

```java
public boolean contains(Person searchPerson) {
    for (int i = 0; i < nElems; i++) {
        if (array[i].hashCode() == searchPerson.hashCode() && array[i].equals(searchPerson)) {
            return true;
        }
    }
    
    return false;
}
```

___
#### Сравнение

По аналогии с операцией тождественности, операторы которые подходили нам для сравнения переменных примитивных типов не подойдут для сравнения объектов.
Причина тут гораздо более очевидная нежели при определении равенства.
Если допустить использование стандартных операторов сравнения в случае объектов, то какую часть / поле / совокупность полей мы должны сравнивать? Получается какая-то неразбериха и парадокс.

Потому, для сравнения двух объектов в Java существуют два интерфейса ```Comparable``` и ```Comparator```.
Для того чтобы понять в каком случае какой интерфейс лучше использовать введем два понятия ***натуральный и ненатуральный порядок***.
Натуральный порядок - это про наиболее частые сравнения, например в школьном журнале это может быть сортировка по алфавиту учеников,
ненатуральный порядок это про более частные сравнения, которые необходимо использовать в частных случаях.

##### Натуральный порядок

Начнем разбор с натурального порядка. Представим, что наш массив объектов класса Person будет очень часто сортировать этих Person по возрасту.
В таком случае наш естественный порядок - это сортировка по возрасту. Для реализации этого порядка мы используем интерфейс ```Comparable```.
Т.к. ```Comparable``` это интерфейс, его необходимо реализовать, класс принимает следующий вид...

```java
public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String passportSeriesNumber;
    private byte age;

    // Конструкторы & аксессоры

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(passportSeriesNumber, person.passportSeriesNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, passportSeriesNumber, age);
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}
```

Интерфейс ```Comparable``` имеет один метод ```compareTo``` который возвращает целое число.

Дело в том, что сравнение двух объектов дает нам 3 возможных варианта:

- ```а < b```
- ```a > b```
- ```a == b```.

У ```boolean``` же есть всего 2 значения — true и false, что неудобно для сравнения объектов.

С ```int``` все намного проще. Если возвращаемое значение ```> 0```, значит ```a > b```, 
если результат ```compareTo < 0```, значит ```а < b```, 
а если результат ```== 0```, значит два объекта равны: ```a == b```.

Реализовав в нашем классе интерфейс ```Comparable``` и понимая, что в этом интерфейсе мы реализуем натуральный порядок сортировки, 
мы можем смело реализовывать методы ```getMax``` и ```getMin``` с той лишь поправкой, что с мы будем искать самого младшего и самого старшего человека в нашем массиве...

```java
public Person getOldest() {
    Person theOldestPerson = array[0];

    for (int i = 0; i < nElems; i++) {
        if (array[i].compareTo(theOldestPerson) > 0) {
            theOldestPerson = array[i];
        }
    }

    return theOldestPerson;
}
```

```java
public Person getYoungest() {
    Person theYoungestPerson = array[0];

    for (int i = 0; i < nElems; i++) {
        if (array[i].compareTo(theYoungestPerson) < 0) {
            theYoungestPerson = array[i];
        }
    }

    return theYoungestPerson;
}
```

##### Ненатуральный порядок

Ненатуральный порядок напротив, позволяет реализовывать более частные операции сравнения.
Для частных сравнений нужны частные классы реализующие интерфейс ```Comparator```.
Интерфейс ```Comparator``` имеет единственный метод ```compare(Object o1, Object o2)```.
