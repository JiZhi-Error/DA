package com.google.android.gms.common.collect;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashSet */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Set<E> difference(Set<? extends E> set, Set<? extends E> set2) {
        AppMethodBeat.i(4541);
        Preconditions.checkNotNull(set);
        Preconditions.checkNotNull(set2);
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            if (!set2.contains(obj)) {
                hashSet.add(obj);
            }
        }
        AppMethodBeat.o(4541);
        return hashSet;
    }

    public static <E> Set<E> union(Iterable<Set<E>> iterable) {
        AppMethodBeat.i(4540);
        Preconditions.checkNotNull(iterable);
        HashSet hashSet = new HashSet();
        for (Set<E> set : iterable) {
            hashSet.addAll(set);
        }
        AppMethodBeat.o(4540);
        return hashSet;
    }

    public static <E> Set<E> union(Set<? extends E> set, Set<? extends E> set2) {
        AppMethodBeat.i(4539);
        Preconditions.checkNotNull(set);
        Preconditions.checkNotNull(set2);
        HashSet hashSet = new HashSet(set);
        hashSet.addAll(set2);
        AppMethodBeat.o(4539);
        return hashSet;
    }
}
