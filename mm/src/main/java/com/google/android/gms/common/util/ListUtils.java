package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ListUtils {
    private ListUtils() {
    }

    public static <T> ArrayList<T> copyAndRemoveElementFromListIfPresent(List<T> list, T t) {
        AppMethodBeat.i(5269);
        int size = list.size();
        ArrayList<T> arrayList = new ArrayList<>(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t2 = list.get(i2);
            if (t == null || !t.equals(t2)) {
                arrayList.add(t2);
            }
        }
        AppMethodBeat.o(5269);
        return arrayList;
    }

    public static <T> ArrayList<T> copyAndRemoveElementsFromListIfPresent(List<T> list, Collection<T> collection) {
        AppMethodBeat.i(5270);
        Preconditions.checkNotNull(collection);
        ArrayList<T> arrayList = new ArrayList<>(list.size());
        for (T t : list) {
            if (!collection.contains(t)) {
                arrayList.add(t);
            }
        }
        AppMethodBeat.o(5270);
        return arrayList;
    }
}
