package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/* access modifiers changed from: package-private */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static n f2098a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Context f2099b = null;

    private n() {
        AppMethodBeat.i(54048);
        AppMethodBeat.o(54048);
    }

    static n a(Context context) {
        AppMethodBeat.i(188325);
        if (f2098a == null) {
            synchronized (n.class) {
                try {
                    if (f2098a == null) {
                        f2098a = new n();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(188325);
                    throw th;
                }
            }
        }
        f2099b = context.getApplicationContext();
        n nVar = f2098a;
        AppMethodBeat.o(188325);
        return nVar;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        AppMethodBeat.i(188326);
        a("copy_core_ver", i2);
        a("copy_status", i3);
        AppMethodBeat.o(188326);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, int i3) {
        AppMethodBeat.i(188327);
        a("tpatch_ver", i2);
        a("tpatch_status", i3);
        AppMethodBeat.o(188327);
    }

    /* access modifiers changed from: package-private */
    public File a() {
        AppMethodBeat.i(188328);
        q.a();
        File file = new File(q.t(f2099b), "tbscoreinstall.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                AppMethodBeat.o(188328);
                return null;
            }
        }
        AppMethodBeat.o(188328);
        return file;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        r2 = r0;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004d, code lost:
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e A[SYNTHETIC, Splitter:B:15:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A[SYNTHETIC, Splitter:B:21:0x003b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Properties e() {
        /*
            r5 = this;
            r1 = 0
            r4 = 188329(0x2dfa9, float:2.63905E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.io.File r0 = r5.a()     // Catch:{ Exception -> 0x0029, all -> 0x0036 }
            java.util.Properties r2 = new java.util.Properties     // Catch:{ Exception -> 0x0029, all -> 0x0036 }
            r2.<init>()     // Catch:{ Exception -> 0x0029, all -> 0x0036 }
            if (r0 == 0) goto L_0x0051
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004c, all -> 0x0036 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x004c, all -> 0x0036 }
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x004c, all -> 0x0036 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x004c, all -> 0x0036 }
            r2.load(r0)     // Catch:{ Exception -> 0x004f, all -> 0x0048 }
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r0.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0024:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r0 = r2
        L_0x0028:
            return r0
        L_0x0029:
            r0 = move-exception
            r2 = r1
            r0 = r1
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0031:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r0 = r2
            goto L_0x0028
        L_0x0036:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L_0x0039:
            if (r3 == 0) goto L_0x003e
            r3.close()     // Catch:{ IOException -> 0x0046 }
        L_0x003e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r2
        L_0x0042:
            r0 = move-exception
            goto L_0x0024
        L_0x0044:
            r0 = move-exception
            goto L_0x0031
        L_0x0046:
            r0 = move-exception
            goto L_0x003e
        L_0x0048:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L_0x0039
        L_0x004c:
            r0 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x004f:
            r1 = move-exception
            goto L_0x002c
        L_0x0051:
            r0 = r1
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.n.e():java.util.Properties");
    }

    /* access modifiers changed from: package-private */
    public int b() {
        AppMethodBeat.i(188330);
        int c2 = c("install_core_ver");
        AppMethodBeat.o(188330);
        return c2;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        AppMethodBeat.i(188331);
        int b2 = b("install_status");
        AppMethodBeat.o(188331);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        AppMethodBeat.i(188332);
        a("dexopt_retry_num", i2);
        AppMethodBeat.o(188332);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        AppMethodBeat.i(188333);
        a("unzip_retry_num", i2);
        AppMethodBeat.o(188333);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        AppMethodBeat.i(188334);
        a("install_apk_path", str);
        AppMethodBeat.o(188334);
    }

    /* access modifiers changed from: package-private */
    public void c(int i2, int i3) {
        AppMethodBeat.i(188335);
        a("install_core_ver", i2);
        a("install_status", i3);
        AppMethodBeat.o(188335);
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        AppMethodBeat.i(188336);
        a("incrupdate_status", i2);
        AppMethodBeat.o(188336);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        AppMethodBeat.i(188337);
        int b2 = b("incrupdate_status");
        AppMethodBeat.o(188337);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        AppMethodBeat.i(188338);
        a("unlzma_status", i2);
        AppMethodBeat.o(188338);
    }

    /* access modifiers changed from: package-private */
    public int b(String str) {
        AppMethodBeat.i(188339);
        try {
            Properties e2 = e();
            if (!(e2 == null || e2.getProperty(str) == null)) {
                int parseInt = Integer.parseInt(e2.getProperty(str));
                AppMethodBeat.o(188339);
                return parseInt;
            }
        } catch (Exception e3) {
        }
        AppMethodBeat.o(188339);
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069 A[SYNTHETIC, Splitter:B:19:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a A[SYNTHETIC, Splitter:B:27:0x007a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r6, java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.n.a(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public void a(String str, int i2) {
        AppMethodBeat.i(188341);
        a(str, String.valueOf(i2));
        AppMethodBeat.o(188341);
    }

    /* access modifiers changed from: package-private */
    public int c(String str) {
        AppMethodBeat.i(188342);
        Properties e2 = e();
        if (e2 == null || e2.getProperty(str) == null) {
            AppMethodBeat.o(188342);
            return 0;
        }
        int parseInt = Integer.parseInt(e2.getProperty(str));
        AppMethodBeat.o(188342);
        return parseInt;
    }

    /* access modifiers changed from: package-private */
    public String d(String str) {
        AppMethodBeat.i(188343);
        Properties e2 = e();
        if (e2 == null || e2.getProperty(str) == null) {
            AppMethodBeat.o(188343);
            return null;
        }
        String property = e2.getProperty(str);
        AppMethodBeat.o(188343);
        return property;
    }
}
