package com.tencent.mm.compatible.e;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import java.util.Locale;

public final class a {
    public static Boolean gKU;

    public static class b {
        public int gKX;
        SparseArray<String> gKY;
        public String gKZ;
        public String model;
        public String version;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(155845);
            String format = String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", this.gKZ, this.model, this.version, this.gKY, Integer.valueOf(this.gKX));
            AppMethodBeat.o(155845);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.compatible.e.a$a  reason: collision with other inner class name */
    static class C0302a {
        int gKV;
        int gKW;
        int gKX;
        SparseArray<String> gKY;
        String pkgName;

        private C0302a() {
        }

        /* synthetic */ C0302a(byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(155844);
            String format = String.format(Locale.US, "pkgname: %s, minCode:%d, maxCode: %d, value: %s, chkExp: %d", this.pkgName, Integer.valueOf(this.gKV), Integer.valueOf(this.gKW), this.gKY, Integer.valueOf(this.gKX));
            AppMethodBeat.o(155844);
            return format;
        }
    }

    public static boolean a(String str, String str2, PInt pInt, PBool pBool) {
        AppMethodBeat.i(155846);
        if (str == null) {
            pBool.value = false;
            AppMethodBeat.o(155846);
            return false;
        } else if (str2 == null) {
            pBool.value = true;
            AppMethodBeat.o(155846);
            return false;
        } else if (str.equals(str2)) {
            pInt.value++;
            pBool.value = true;
            AppMethodBeat.o(155846);
            return true;
        } else {
            pBool.value = false;
            AppMethodBeat.o(155846);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074 A[SYNTHETIC, Splitter:B:22:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e4 A[SYNTHETIC, Splitter:B:39:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0178 A[SYNTHETIC, Splitter:B:48:0x0178] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0229  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r10, java.util.List<com.tencent.mm.compatible.e.a.b> r11, java.util.List<com.tencent.mm.compatible.e.a.C0302a> r12) {
        /*
        // Method dump skipped, instructions count: 578
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.e.a.a(java.lang.String, java.util.List, java.util.List):void");
    }
}
