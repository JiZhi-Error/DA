package kotlin.l.b.a.b.n.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.g.b.p;

public final class a {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Collection<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> a(Collection<? extends T> collection, Collection<? extends T> collection2) {
        AppMethodBeat.i(61341);
        p.h(collection2, "collection");
        if (collection2.isEmpty()) {
            AppMethodBeat.o(61341);
            return collection;
        } else if (collection == 0) {
            AppMethodBeat.o(61341);
            return collection2;
        } else if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            AppMethodBeat.o(61341);
            return collection;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
            linkedHashSet.addAll(collection2);
            LinkedHashSet linkedHashSet2 = linkedHashSet;
            AppMethodBeat.o(61341);
            return linkedHashSet2;
        }
    }
}
