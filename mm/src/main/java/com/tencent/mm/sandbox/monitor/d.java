package com.tencent.mm.sandbox.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

/* access modifiers changed from: package-private */
public final class d {
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092 A[SYNTHETIC, Splitter:B:22:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d1 A[SYNTHETIC, Splitter:B:30:0x00d1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int A(java.lang.String r12, byte[] r13) {
        /*
        // Method dump skipped, instructions count: 271
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sandbox.monitor.d.A(java.lang.String, byte[]):int");
    }

    public static boolean deleteFile(String str) {
        AppMethodBeat.i(169801);
        if (str == null) {
            AppMethodBeat.o(169801);
            return true;
        }
        File file = new File(str);
        if (file.exists()) {
            boolean delete = file.delete();
            AppMethodBeat.o(169801);
            return delete;
        }
        AppMethodBeat.o(169801);
        return true;
    }

    public static int bhI(String str) {
        AppMethodBeat.i(169802);
        if (str == null) {
            AppMethodBeat.o(169802);
            return 0;
        }
        File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.o(169802);
            return 0;
        }
        int length = (int) file.length();
        AppMethodBeat.o(169802);
        return length;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d2 A[SYNTHETIC, Splitter:B:31:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0117 A[SYNTHETIC, Splitter:B:39:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] bhJ(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 356
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sandbox.monitor.d.bhJ(java.lang.String):byte[]");
    }

    public static final boolean YS(String str) {
        AppMethodBeat.i(169804);
        if (str == null) {
            AppMethodBeat.o(169804);
            return false;
        } else if (new File(str).exists()) {
            AppMethodBeat.o(169804);
            return true;
        } else {
            AppMethodBeat.o(169804);
            return false;
        }
    }

    public static String bhK(String str) {
        AppMethodBeat.i(169805);
        if (str == null) {
            AppMethodBeat.o(169805);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            String C = C(file);
            AppMethodBeat.o(169805);
            return C;
        }
        AppMethodBeat.o(169805);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a A[SYNTHETIC, Splitter:B:16:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045 A[SYNTHETIC, Splitter:B:22:0x0045] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String C(java.io.File r8) {
        /*
            r4 = 102400(0x19000, double:5.05923E-319)
            r0 = 0
            r3 = 169806(0x2974e, float:2.37949E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            boolean r1 = r8.exists()
            if (r1 != 0) goto L_0x0014
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0013:
            return r0
        L_0x0014:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0036, all -> 0x0041 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0036, all -> 0x0041 }
            long r6 = r8.length()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 > 0) goto L_0x0031
        L_0x0021:
            int r1 = (int) r4     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            java.lang.String r1 = com.tencent.mm.b.g.b(r2, r1)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.close()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.close()     // Catch:{ IOException -> 0x004c }
        L_0x002c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            r0 = r1
            goto L_0x0013
        L_0x0031:
            long r4 = r8.length()
            goto L_0x0021
        L_0x0036:
            r1 = move-exception
            r1 = r0
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ IOException -> 0x004e }
        L_0x003d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0013
        L_0x0041:
            r1 = move-exception
            r2 = r0
        L_0x0043:
            if (r2 == 0) goto L_0x0048
            r2.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0048:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r1
        L_0x004c:
            r0 = move-exception
            goto L_0x002c
        L_0x004e:
            r1 = move-exception
            goto L_0x003d
        L_0x0050:
            r0 = move-exception
            goto L_0x0048
        L_0x0052:
            r0 = move-exception
            r1 = r0
            goto L_0x0043
        L_0x0055:
            r1 = move-exception
            r1 = r2
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sandbox.monitor.d.C(java.io.File):java.lang.String");
    }
}
