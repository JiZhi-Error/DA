package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;

public final class a {
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Integer> G(Iterable<? extends K> iterable) {
        AppMethodBeat.i(61342);
        p.h(iterable, "$this$mapToIndex");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = 0;
        Iterator<? extends K> it = iterable.iterator();
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i2));
            i2++;
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        AppMethodBeat.o(61342);
        return linkedHashMap2;
    }

    public static final <T> void c(Collection<T> collection, T t) {
        AppMethodBeat.i(61343);
        p.h(collection, "$this$addIfNotNull");
        if (t != null) {
            collection.add(t);
        }
        AppMethodBeat.o(61343);
    }

    public static final <K, V> HashMap<K, V> avL(int i2) {
        AppMethodBeat.i(61344);
        HashMap<K, V> hashMap = new HashMap<>(hp(i2));
        AppMethodBeat.o(61344);
        return hashMap;
    }

    public static final <E> HashSet<E> avM(int i2) {
        AppMethodBeat.i(61345);
        HashSet<E> hashSet = new HashSet<>(hp(i2));
        AppMethodBeat.o(61345);
        return hashSet;
    }

    public static final int hp(int i2) {
        if (i2 < 3) {
            return 3;
        }
        return (i2 / 3) + i2 + 1;
    }

    public static final <T> List<T> bC(ArrayList<T> arrayList) {
        AppMethodBeat.i(61346);
        p.h(arrayList, "$this$compact");
        switch (arrayList.size()) {
            case 0:
                v vVar = v.SXr;
                AppMethodBeat.o(61346);
                return vVar;
            case 1:
                List<T> listOf = j.listOf(j.ks(arrayList));
                AppMethodBeat.o(61346);
                return listOf;
            default:
                arrayList.trimToSize();
                ArrayList<T> arrayList2 = arrayList;
                AppMethodBeat.o(61346);
                return arrayList2;
        }
    }
}
