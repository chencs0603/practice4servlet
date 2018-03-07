package personal.chencs.practice.cookie;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: chencs
 * @date: 2018/3/6
 * @description:
 */
public class BookRespository {

    private static Map<Integer, Book> bookList = new LinkedHashMap<>();

    static {
        bookList.put(1, new Book(1, "Java", "zhangsan", 45.35f, "nice book"));
        bookList.put(2, new Book(2, "Servlet", "lisi", 42.42f, "nice book"));
        bookList.put(3, new Book(3, "Struts2", "wangwu", 64.24f, "nice book"));
        bookList.put(4, new Book(4, "Spring MVC", "chencs", 83.45f, "nice book"));
        bookList.put(5, new Book(5, "Play", "yiming", 74.24f, "nice book"));
    }

    public static List<Book> queryAll() {
        List<Book> list = new ArrayList<>();
        for (Map.Entry<Integer, Book> bookMap: bookList.entrySet()) {
            list.add(bookMap.getValue());
        }

        return list;
    }

    public static Book queryById(Integer id) {
        for (Map.Entry<Integer, Book> bookMap: bookList.entrySet()) {
            if (id == bookMap.getKey()) {
                return bookMap.getValue();
            }
        }

        return null;
    }

}
