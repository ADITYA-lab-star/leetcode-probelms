import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L380 {

    class RandomizedSet {

        HashSet<Integer> ranset = new HashSet<Integer>();

        public RandomizedSet() {
            
        }

        public boolean insert(int val) {
            if (ranset.contains(val)) {
                return false;
            }
            ranset.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (ranset.contains(val)) {
                ranset.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            List<Integer> list = new ArrayList<>(ranset);
            int idx = (int) (Math.random() * list.size());
            return list.get(idx);
        }

    }

}