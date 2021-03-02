package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class FreezableUtils {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.ArrayList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        AppMethodBeat.i(11628);
        ArrayList<T> arrayList2 = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(arrayList.get(i2).freeze());
        }
        AppMethodBeat.o(11628);
        return arrayList2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.ArrayList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        AppMethodBeat.i(11629);
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e2 : eArr) {
            arrayList.add(e2.freeze());
        }
        AppMethodBeat.o(11629);
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.ArrayList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        AppMethodBeat.i(11630);
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList();
        for (E e2 : iterable) {
            arrayList.add(e2.freeze());
        }
        AppMethodBeat.o(11630);
        return arrayList;
    }
}
