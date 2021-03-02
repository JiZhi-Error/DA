package com.tencent.pb.common.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    public static <E> List<E> M(E... eArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 7; i2++) {
            arrayList.add(eArr[i2]);
        }
        return arrayList;
    }

    public static <E> Map<E, E> N(E... eArr) {
        if (eArr.length % 2 != 0) {
            throw new IllegalArgumentException("length of map is " + eArr.length);
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < eArr.length; i2 += 2) {
            hashMap.put(eArr[i2], eArr[i2 + 1]);
        }
        return hashMap;
    }
}
