package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class g {
    public static HashMap<String, String> jNI = new HashMap<>();
    public static final a wVA = new a(63744, 64217);
    public static final a wVB = new a(194560, 195101);
    public static final a wVC = new a(59413, 59503);
    public static final a wVD = new a(58368, 58856);
    public static final a wVE = new a(58880, 59087);
    public static final a wVF = new a(12736, 12771);
    public static final a wVG = new a(12272, 12283);
    public static final a wVH = new a(12549, 12576);
    public static final a wVI = new a(12704, 12730);
    public static final a wVJ = new a(65, 90);
    public static final a wVK = new a(97, 122);
    public static final a wVL = new a(48, 57);
    public static b wVM = new b();
    public static HashMap<String, String[]> wVN = new HashMap<>();
    public static final a wVt = new a(19968, 40869);
    public static final a wVu = new a(40870, 40907);
    public static final a wVv = new a(13312, 19893);
    public static final a wVw = new a(131072, 173782);
    public static final a wVx = new a(173824, 177972);
    public static final a wVy = new a(177984, 178205);
    public static final a wVz = new a(12032, 12245);

    static {
        AppMethodBeat.i(131669);
        AppMethodBeat.o(131669);
    }

    public static boolean B(char c2) {
        AppMethodBeat.i(131665);
        if (wVt.Nm(c2) || wVu.Nm(c2) || wVv.Nm(c2) || wVw.Nm(c2) || wVx.Nm(c2) || wVy.Nm(c2)) {
            AppMethodBeat.o(131665);
            return true;
        }
        AppMethodBeat.o(131665);
        return false;
    }

    public static class a {
        int bottom;
        int wVO;

        public a(int i2, int i3) {
            this.bottom = i2;
            this.wVO = i3;
        }

        public final boolean Nm(int i2) {
            return i2 >= this.bottom && i2 <= this.wVO;
        }
    }

    public static boolean C(char c2) {
        AppMethodBeat.i(131666);
        if (wVJ.Nm(c2) || wVK.Nm(c2)) {
            AppMethodBeat.o(131666);
            return true;
        }
        AppMethodBeat.o(131666);
        return false;
    }

    public static boolean D(char c2) {
        AppMethodBeat.i(131667);
        boolean Nm = wVL.Nm(c2);
        AppMethodBeat.o(131667);
        return Nm;
    }

    public static final String ayw(String str) {
        AppMethodBeat.i(131668);
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        for (char c2 : charArray) {
            if (B(c2)) {
                String str2 = jNI.get(String.valueOf(c2));
                if (!Util.isNullOrNil(str2)) {
                    stringBuffer.append(str2);
                }
            }
            stringBuffer.append(c2);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(131668);
        return stringBuffer2;
    }
}
