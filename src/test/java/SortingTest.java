import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by peterhealy on 29/08/2016.
 */
public class SortingTest {


    @Test public void maps_and_sorting() throws Exception {

        SortedMap<Integer, String> mappy = new TreeMap<>();

        mappy.put(3, "Three");
        mappy.put(1, "One");
        mappy.put(2, "Two");

        Map<Integer, String> sortedMap = mappy.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(mappy);
        System.out.println(sortedMap);

    }

    @Test
    public void mess() throws Exception {

        List<Employee> employees = EmployeeHelper.getEmployees();

        //Sort all employees by first name
        employees.sort(Comparator.comparing(e -> e.getFirstName()));

        System.out.println(employees);

        assertThat(employees).isNotEmpty();

    }


}
