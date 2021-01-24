package Amazon;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ItemsToDisplay {
    public static List<String> fetchItemsToDisplay(int sortParameter, int sortOrder,
                                                   int itemsPerPage, int pageNumber,
                                                   int numOfItems,
                                                   HashMap<String, int[]> dataArray) {

        if (sortParameter == 0 && sortOrder == 0) {
            return dataArray.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(Map.Entry::getKey)
                    .skip(itemsPerPage * pageNumber)
                    .limit(itemsPerPage)
                    .collect(Collectors.toList());
        }

        if (sortParameter == 0 && sortOrder == 1) {
            return dataArray.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .map(Map.Entry::getKey)
                    .skip(itemsPerPage * pageNumber)
                    .limit(itemsPerPage)
                    .collect(Collectors.toList());
        }

        if (sortOrder == 0) {
            return dataArray.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(a -> a[sortParameter - 1])))
                    .map(Map.Entry::getKey)
                    .skip(itemsPerPage * pageNumber)
                    .limit(itemsPerPage)
                    .collect(Collectors.toList());
        }

        if (sortOrder == 1) {
            return dataArray.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder(Comparator.comparingInt(a -> a[sortParameter - 1]))))
                    .map(Map.Entry::getKey)
                    .skip(itemsPerPage * pageNumber)
                    .limit(itemsPerPage)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(fetchItemsToDisplay(1, 0, 2, 1, 3,new HashMap<>()).stream().collect(Collectors.joining(" ")));
    }
}
