package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.Arrays;

final class d {
    static String toString(Object obj) {
        AppMethodBeat.i(144621);
        if (obj == null) {
            AppMethodBeat.o(144621);
            return BuildConfig.COMMAND;
        }
        String obj2 = obj.toString();
        AppMethodBeat.o(144621);
        return obj2;
    }

    static boolean equals(Object obj, Object obj2) {
        AppMethodBeat.i(144622);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.o(144622);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.o(144622);
            return true;
        } else {
            AppMethodBeat.o(144622);
            return false;
        }
    }

    static boolean deepEquals(Object obj, Object obj2) {
        AppMethodBeat.i(144623);
        if (obj == null || obj2 == null) {
            if (obj == obj2) {
                AppMethodBeat.o(144623);
                return true;
            }
            AppMethodBeat.o(144623);
            return false;
        } else if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
            boolean deepEquals = Arrays.deepEquals((Object[]) obj, (Object[]) obj2);
            AppMethodBeat.o(144623);
            return deepEquals;
        } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
            boolean equals = Arrays.equals((boolean[]) obj, (boolean[]) obj2);
            AppMethodBeat.o(144623);
            return equals;
        } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            boolean equals2 = Arrays.equals((byte[]) obj, (byte[]) obj2);
            AppMethodBeat.o(144623);
            return equals2;
        } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
            boolean equals3 = Arrays.equals((char[]) obj, (char[]) obj2);
            AppMethodBeat.o(144623);
            return equals3;
        } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
            boolean equals4 = Arrays.equals((double[]) obj, (double[]) obj2);
            AppMethodBeat.o(144623);
            return equals4;
        } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
            boolean equals5 = Arrays.equals((float[]) obj, (float[]) obj2);
            AppMethodBeat.o(144623);
            return equals5;
        } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
            boolean equals6 = Arrays.equals((int[]) obj, (int[]) obj2);
            AppMethodBeat.o(144623);
            return equals6;
        } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
            boolean equals7 = Arrays.equals((long[]) obj, (long[]) obj2);
            AppMethodBeat.o(144623);
            return equals7;
        } else if (!(obj instanceof short[]) || !(obj2 instanceof short[])) {
            boolean equals8 = obj.equals(obj2);
            AppMethodBeat.o(144623);
            return equals8;
        } else {
            boolean equals9 = Arrays.equals((short[]) obj, (short[]) obj2);
            AppMethodBeat.o(144623);
            return equals9;
        }
    }
}
