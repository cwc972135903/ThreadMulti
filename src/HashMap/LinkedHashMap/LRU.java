package HashMap.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/29 16:26
 */
public class LRU {
    public static void main(String ...args){
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());
    }
}

/**
 * 泛型类继承：https://blog.csdn.net/qq_41603898/article/details/87924593
 * 1->2->3 2->3->1 3->1->4
 * @param <K>
 * @param <V>
 */
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3;

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }

    LRUCache() {
        super((int)Math.ceil(MAX_ENTRIES/0.75)+1 , 0.75f, true);
    }
}
