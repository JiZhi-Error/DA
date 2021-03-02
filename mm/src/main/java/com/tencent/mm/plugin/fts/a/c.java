package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.recovery.log.RecoveryFileLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c {
    public static final int[] wUC = {65536};
    public static final int[] wUD = {196608};
    public static final int[] wUE = {262144};
    public static final int[] wUF = {327680};
    public static final int[] wUG = {393216};
    public static final int[] wUH = {458752};
    public static final int[] wUI = {131073, 131074};
    public static final int[] wUJ = {131072, 131075, 131076, 131081};
    public static final int[] wUK = {131072, 131075, 131076, 131081};
    public static final int[] wUL = {131072};
    public static final int[] wUM = {131073, 131074};
    public static final int[] wUN = {131077, 131078};
    public static final int[] wUO = {131079, 131080};
    public static final int[] wUP = {5, 6, 7, 1, 2, 3};
    public static final Map<Integer, Integer> wUQ;
    public static final int[] wUR = {2, 3, 6, 7};
    public static final int[] wUS = {29, 30, 31, 34, 35, 36, 33, 32, 37};
    public static final int[] wUT;
    public static final int[] wUU;
    public static final int[] wUV = new int[43];
    public static final int[] wUW = new int[27];
    public static final String wUX = (b.aKJ() + "fts/");

    public static final class a {
        public static final Pattern wUY = Pattern.compile(";");
        public static final Pattern wUZ = Pattern.compile(" ");
        public static final Pattern wVa = Pattern.compile(RecoveryFileLog.SPLITTER);
        public static final Pattern wVb = Pattern.compile("‌");
        public static final Pattern wVc;
        public static final Pattern wVd;
        public static final Pattern wVe = Pattern.compile("\\s+");
        public static final Pattern wVf = Pattern.compile(",");
        public static final Pattern wVg = Pattern.compile("[A-Za-z]+");

        static {
            AppMethodBeat.i(131618);
            Pattern compile = Pattern.compile("‍");
            wVc = compile;
            wVd = compile;
            AppMethodBeat.o(131618);
        }
    }

    static {
        AppMethodBeat.i(131619);
        int[] iArr = {8, 9, 10};
        wUT = iArr;
        wUU = iArr;
        int[] iArr2 = {131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080};
        int[] iArr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0};
        int[] iArr4 = {1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0};
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < 9; i2++) {
            hashMap.put(Integer.valueOf(iArr2[i2]), Integer.valueOf(i2));
        }
        wUQ = Collections.unmodifiableMap(hashMap);
        for (int i3 = 0; i3 < 43; i3++) {
            wUV[iArr3[i3]] = i3;
        }
        for (int i4 = 0; i4 < 27; i4++) {
            wUW[iArr4[i4]] = i4;
        }
        AppMethodBeat.o(131619);
    }
}
