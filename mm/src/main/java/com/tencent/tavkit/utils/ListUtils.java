package com.tencent.tavkit.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {
    public static <T> List<T> listWithObjects(T... tArr) {
        AppMethodBeat.i(197673);
        ArrayList arrayList = new ArrayList(Arrays.asList(tArr));
        AppMethodBeat.o(197673);
        return arrayList;
    }
}
