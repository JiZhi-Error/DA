package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;

public final class c {
    public static <T> boolean isEmpty(Collection<T> collection) {
        AppMethodBeat.i(202347);
        if (collection == null || collection.isEmpty()) {
            AppMethodBeat.o(202347);
            return true;
        }
        AppMethodBeat.o(202347);
        return false;
    }

    public static <T> boolean o(Collection<T> collection) {
        AppMethodBeat.i(202348);
        if (!isEmpty(collection)) {
            AppMethodBeat.o(202348);
            return true;
        }
        AppMethodBeat.o(202348);
        return false;
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        AppMethodBeat.i(202349);
        if (map == null || map.isEmpty()) {
            AppMethodBeat.o(202349);
            return true;
        }
        AppMethodBeat.o(202349);
        return false;
    }

    public static <K, V> boolean aI(Map<K, V> map) {
        AppMethodBeat.i(202350);
        if (!isEmpty(map)) {
            AppMethodBeat.o(202350);
            return true;
        }
        AppMethodBeat.o(202350);
        return false;
    }

    public static <T> boolean w(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean x(T[] tArr) {
        AppMethodBeat.i(202351);
        if (!w(tArr)) {
            AppMethodBeat.o(202351);
            return true;
        }
        AppMethodBeat.o(202351);
        return false;
    }

    public static boolean K(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }
}
