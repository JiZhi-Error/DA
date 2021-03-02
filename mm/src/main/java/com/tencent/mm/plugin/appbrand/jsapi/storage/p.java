package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;

public final class p {
    public static int p(String... strArr) {
        AppMethodBeat.i(147297);
        int i2 = 0;
        for (String str : strArr) {
            if (str != null) {
                i2 += str.length();
            }
        }
        AppMethodBeat.o(147297);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042 A[SYNTHETIC, Splitter:B:19:0x0042] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String z(com.tencent.mm.vfs.o r6) {
        /*
            r5 = 169495(0x29617, float:2.37513E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            boolean r0 = r6.exists()
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = ""
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0012:
            return r0
        L_0x0013:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r2 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            com.tencent.mm.vfs.u r3 = new com.tencent.mm.vfs.u     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r2 = 1024(0x400, float:1.435E-42)
            char[] r2 = new char[r2]     // Catch:{ IOException -> 0x0037 }
        L_0x0027:
            int r3 = r1.read(r2)     // Catch:{ IOException -> 0x0037 }
            r4 = -1
            if (r3 == r4) goto L_0x0049
            r4 = 0
            java.lang.String r3 = java.lang.String.valueOf(r2, r4, r3)     // Catch:{ IOException -> 0x0037 }
            r0.append(r3)     // Catch:{ IOException -> 0x0037 }
            goto L_0x0027
        L_0x0037:
            r0 = move-exception
        L_0x0038:
            r2 = 169495(0x29617, float:2.37513E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x003f }
            throw r0     // Catch:{ all -> 0x003f }
        L_0x003f:
            r0 = move-exception
        L_0x0040:
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ Exception -> 0x0059 }
        L_0x0045:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r0
        L_0x0049:
            r1.close()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r0 = r0.toString()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0012
        L_0x0054:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r0
        L_0x0059:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r0
        L_0x005e:
            r0 = move-exception
            r1 = r2
            goto L_0x0040
        L_0x0061:
            r0 = move-exception
            r1 = r2
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.storage.p.z(com.tencent.mm.vfs.o):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A[SYNTHETIC, Splitter:B:16:0x0035] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(java.lang.String r5, java.lang.String... r6) {
        /*
            r4 = 147299(0x23f63, float:2.0641E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.mm.vfs.o r0 = new com.tencent.mm.vfs.o
            android.content.Context r1 = com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()
            java.io.File r1 = r1.getCacheDir()
            r0.<init>(r1, r5)
            r2 = 0
            com.tencent.mm.vfs.v r1 = new com.tencent.mm.vfs.v     // Catch:{ all -> 0x0031 }
            r1.<init>(r0)     // Catch:{ all -> 0x0031 }
            int r2 = r6.length     // Catch:{ all -> 0x003e }
            r0 = 0
        L_0x001b:
            if (r0 >= r2) goto L_0x0025
            r3 = r6[r0]     // Catch:{ all -> 0x003e }
            r1.write(r3)     // Catch:{ all -> 0x003e }
            int r0 = r0 + 1
            goto L_0x001b
        L_0x0025:
            r1.close()     // Catch:{ IOException -> 0x002c }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x002b:
            return
        L_0x002c:
            r0 = move-exception
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x002b
        L_0x0031:
            r0 = move-exception
            r1 = r2
        L_0x0033:
            if (r1 == 0) goto L_0x0038
            r1.close()     // Catch:{ IOException -> 0x003c }
        L_0x0038:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x003c:
            r1 = move-exception
            goto L_0x0038
        L_0x003e:
            r0 = move-exception
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.storage.p.g(java.lang.String, java.lang.String[]):void");
    }

    public static String aaO(String str) {
        AppMethodBeat.i(147300);
        String z = z(new o(MMApplicationContext.getContext().getCacheDir(), str));
        AppMethodBeat.o(147300);
        return z;
    }

    public static void aaP(String str) {
        AppMethodBeat.i(147301);
        Log.i("MicroMsg.JsApiStorageHelper", "deleteTmpFile: " + str + ":" + new o(MMApplicationContext.getContext().getCacheDir(), str).delete());
        AppMethodBeat.o(147301);
    }

    static String a(p.a aVar) {
        if (aVar == p.a.NONE) {
            return "ok";
        }
        if (aVar == p.a.QUOTA_REACHED) {
            return "fail:quota reached";
        }
        return "fail:internal error set DB data fail";
    }
}
