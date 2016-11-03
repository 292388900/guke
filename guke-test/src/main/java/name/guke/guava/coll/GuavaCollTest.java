package name.guke.guava.coll;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GUKE on 2016/4/8.
 */
public class GuavaCollTest {

    @Test
    public void testNewList() {
        List<Integer> objects = Lists.newArrayList();
        objects.add(1);
        System.err.println("Lists.newArrayList().add(1):" + objects);

        List<Integer> integers = Lists.newArrayList(1, 2);
        System.err.println("Lists.newArrayList(1, 2):" + integers);

        List<Integer> integers1 = Lists.reverse(integers);
        System.err.println("Lists.reverse(Lists.newArrayList(1, 2)):" + integers1);

        List<Integer> linkedList = Lists.newLinkedList();
        linkedList.add(1);
        System.err.println("Lists.newLinkedList().add(1):" + linkedList);

        List<Integer> integers2 = Lists.asList(1, new Integer[]{2});
        System.err.println("Lists.asList(1, new Integer[]{2}):" + integers2);

        List<Object> transform = Lists.transform(Lists.newArrayList(1, 2), new Function<Integer, Object>() {
            public Object apply(Integer input) {
                return String.valueOf(input);
            }
        });
        System.err.println("Lists.transform(Lists.newArrayList(1, 2), new Function<Integer, Object>() {..}:" + transform);
    }

    @Test
    public void testNewSets() {
        Sets.newHashSet();
        Sets.newHashSet(1,2);
    }

    @Test
    public void testNewMaps() {
        Maps.newConcurrentMap();
        Maps.newHashMap();
        Maps.newTreeMap();
        Maps.newIdentityHashMap();
        Maps.newLinkedHashMap();
        Sets.newHashSet(1,2);
    }
}
