package SE10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Test1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(22);
        numbers.add(33);
        numbers.add(44);
        numbers.add(55);

        List<Integer> javab= numbers
                .stream()
                .filter((x)-> x%2==0)
                .map(x->x*5)
                .collect(Collectors.toList());
        System.out.println(javab);
//        System.out.println(numbers);
//        for (int i = 0; i < numbers.size(); i++) {
//            if (numbers.get(i) % 2 == 0) {
//                javab.add(numbers.get(i));
//            }
//        }
//        System.out.println(javab);
//        List javab=new ArrayList();
//       for(int i : numbers){
//           if(i%2==0){
//               javab.add(numbers.get(i));
//           }
//        }
//        System.out.println(javab);
    }
}
