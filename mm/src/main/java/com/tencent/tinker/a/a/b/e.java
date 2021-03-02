package com.tencent.tinker.a.a.b;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class e {
    public static int hash(Object... objArr) {
        if (objArr.length == 0) {
            return 0;
        }
        int i2 = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                if (!(obj instanceof Number)) {
                    if (obj instanceof boolean[]) {
                        i2 += Arrays.hashCode((boolean[]) obj);
                    } else if (obj instanceof byte[]) {
                        i2 += Arrays.hashCode((byte[]) obj);
                    } else if (obj instanceof char[]) {
                        i2 += Arrays.hashCode((char[]) obj);
                    } else if (obj instanceof short[]) {
                        i2 += Arrays.hashCode((short[]) obj);
                    } else if (obj instanceof int[]) {
                        i2 += Arrays.hashCode((int[]) obj);
                    } else if (obj instanceof long[]) {
                        i2 += Arrays.hashCode((long[]) obj);
                    } else if (obj instanceof float[]) {
                        i2 += Arrays.hashCode((float[]) obj);
                    } else if (obj instanceof double[]) {
                        i2 += Arrays.hashCode((double[]) obj);
                    } else if (obj instanceof Object[]) {
                        i2 += Arrays.hashCode((Object[]) obj);
                    } else if (obj.getClass().isArray()) {
                        for (int i3 = 0; i3 < Array.getLength(obj); i3++) {
                            i2 += hash(Array.get(obj, i3));
                        }
                    }
                }
                i2 += obj.hashCode();
            }
        }
        return i2;
    }
}
