package org.example.lombok;

import lombok.*;
import lombok.experimental.Accessors;

import java.net.URL;
import java.util.List;

//@Getter
//@Setter
//@NoArgsConstructor//Конструктор без аргументов
//@AllArgsConstructor
//@ToString(exclude = "minutes")//exclude типо убрать,тут не будет минут в toString
//@EqualsAndHashCode(exclude = "minutes")

@Data//Тоже самое что выше все,кроме AllArgsConstructor вроде как
@Builder//Для чего это будет видно в Test но это типо конструктора с этим пустой конструктор не работает вроде
public class Movie {
    @Setter(AccessLevel.PRIVATE)//метод Set будет private для id
    @NonNull private long id;//Чтобы переданное в конструктор точно было не пустым
    private String title;
    private String description;
    @Accessors(fluent = true)//вместо getCountry() и setCountry() надо будет писать country() или country(1)
    private String country;
    @Setter(AccessLevel.NONE)//Не будет такого метода
    private int rating;
    @Getter(AccessLevel.PROTECTED)
    private URL officialSite;
    private String language;
    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.PRIVATE)
    @Builder.Default//Чтобы было в Builder,а так не static не final там нету со static вроде не работает
    private final int minutes = 120;
    @Singular("cast")//Чтобы можно было добавлять удалять ну все методы у листа использовать
    private List<String> cast;
}
