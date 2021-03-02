package kotlin.a;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, hxF = {"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", MessengerShareContentUtility.ELEMENTS, "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, hxG = 1)
public class an extends am {
    public static final <T> Set<T> a(Set<? extends T> set, Iterable<? extends T> iterable) {
        AppMethodBeat.i(206273);
        p.h(set, "$this$minus");
        p.h(iterable, MessengerShareContentUtility.ELEMENTS);
        Collection<?> a2 = j.a((Iterable) iterable, (Iterable) set);
        if (a2.isEmpty()) {
            Set<T> r = j.r((Iterable) set);
            AppMethodBeat.o(206273);
            return r;
        } else if (a2 instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!a2.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            LinkedHashSet linkedHashSet2 = linkedHashSet;
            AppMethodBeat.o(206273);
            return linkedHashSet2;
        } else {
            LinkedHashSet linkedHashSet3 = new LinkedHashSet(set);
            linkedHashSet3.removeAll(a2);
            LinkedHashSet linkedHashSet4 = linkedHashSet3;
            AppMethodBeat.o(206273);
            return linkedHashSet4;
        }
    }

    public static final <T> Set<T> c(Set<? extends T> set, T t) {
        AppMethodBeat.i(129004);
        p.h(set, "$this$plus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(ae.atJ(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(129004);
        return linkedHashSet2;
    }

    public static final <T> Set<T> b(Set<? extends T> set, Iterable<? extends T> iterable) {
        AppMethodBeat.i(129005);
        p.h(set, "$this$plus");
        p.h(iterable, MessengerShareContentUtility.ELEMENTS);
        Integer d2 = j.d(iterable);
        LinkedHashSet linkedHashSet = new LinkedHashSet(ae.atJ(d2 != null ? d2.intValue() + set.size() : set.size() * 2));
        linkedHashSet.addAll(set);
        j.a((Collection) linkedHashSet, (Iterable) iterable);
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(129005);
        return linkedHashSet2;
    }
}
