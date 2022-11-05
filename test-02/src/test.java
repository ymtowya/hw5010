import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class test {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Map<String, Integer> resMap = new HashMap<>();
    int maxc = Collections.max(resMap.values());
    int tmp = resMap.getOrDefault(args, 0);
    for (int i : resMap.values()) {
      
    }
  }

}
