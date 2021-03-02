package com.tencent.e.d.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class e {
    public static List<a> hkz() {
        a aqA;
        AppMethodBeat.i(138364);
        ArrayList arrayList = new ArrayList();
        String[] list = new File("/proc").list();
        if (list == null) {
            AppMethodBeat.o(138364);
        } else {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char charAt = str.charAt(0);
                        if (charAt <= '9' && charAt >= '0' && (aqA = aqA(Integer.parseInt(str))) != null) {
                            arrayList.add(aqA);
                        }
                    } catch (Exception e2) {
                    }
                }
            }
            AppMethodBeat.o(138364);
        }
        return arrayList;
    }

    private static String aqz(int i2) {
        AppMethodBeat.i(138365);
        String str = "";
        try {
            byte[] hv = b.hv(String.format(Locale.ENGLISH, "/proc/%d/cmdline", Integer.valueOf(i2)), 100);
            if (hv != null) {
                str = new String(hv, 0, a(hv, 0, 0));
            }
            if (TextUtils.isEmpty(str)) {
                byte[] hv2 = b.hv(String.format(Locale.ENGLISH, "/proc/%d/status", Integer.valueOf(i2)), 150);
                if (hv2 != null) {
                    int a2 = a(hv2, 7, '\n');
                    if (a2 == 0) {
                        AppMethodBeat.o(138365);
                        return "";
                    }
                    str = new String(hv2, 6, a2 - 6);
                }
            }
            AppMethodBeat.o(138365);
            return str;
        } catch (Throwable th) {
            AppMethodBeat.o(138365);
            return "";
        }
    }

    private static int a(byte[] bArr, int i2, char c2) {
        int i3 = i2 - 1;
        while (true) {
            int i4 = i3 + 1;
            if (i3 >= bArr.length) {
                return 0;
            }
            if (i4 == bArr.length || bArr[i4] == c2) {
                return i4;
            }
            i3 = i4;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a2 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.e.d.b.e.a aqA(int r12) {
        /*
        // Method dump skipped, instructions count: 199
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.e.d.b.e.aqA(int):com.tencent.e.d.b.e$a");
    }

    public static class a {
        public int RMw;
        public String RMx;
        public String name = "";
        public int pid;
        public int uid;

        a(int i2, int i3, String str, int i4, String str2) {
            this.pid = i2;
            this.RMw = i3;
            this.name = str;
            this.uid = i4;
            this.RMx = str2;
        }

        public final String toString() {
            AppMethodBeat.i(138363);
            String str = "PID=" + this.pid + " PPID=" + this.RMw + " NAME=" + this.name + " UID=" + this.uid + " CONTEXT=" + this.RMx;
            AppMethodBeat.o(138363);
            return str;
        }
    }
}
