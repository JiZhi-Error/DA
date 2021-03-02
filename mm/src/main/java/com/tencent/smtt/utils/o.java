package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class o {

    /* renamed from: e  reason: collision with root package name */
    private static o f2282e = null;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2283a = false;

    /* renamed from: b  reason: collision with root package name */
    private Context f2284b = null;

    /* renamed from: c  reason: collision with root package name */
    private File f2285c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2286d = false;

    /* renamed from: f  reason: collision with root package name */
    private File f2287f = null;

    public static synchronized o a(Context context) {
        o oVar;
        synchronized (o.class) {
            AppMethodBeat.i(53848);
            if (f2282e == null) {
                f2282e = new o(context);
            }
            oVar = f2282e;
            AppMethodBeat.o(53848);
        }
        return oVar;
    }

    private o(Context context) {
        AppMethodBeat.i(53849);
        this.f2284b = context.getApplicationContext();
        b();
        AppMethodBeat.o(53849);
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            oVar = f2282e;
        }
        return oVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063 A[SYNTHETIC, Splitter:B:29:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007a A[SYNTHETIC, Splitter:B:37:0x007a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b() {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.o.b():void");
    }

    private File d() {
        File file;
        AppMethodBeat.i(53851);
        try {
            if (this.f2285c == null) {
                this.f2285c = new File(QbSdk.getTbsFolderDir(this.f2284b), "core_private");
                if (this.f2285c == null || !this.f2285c.isDirectory()) {
                    AppMethodBeat.o(53851);
                    return null;
                }
            }
            file = new File(this.f2285c, "debug.conf");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Throwable th) {
            file = null;
        }
        AppMethodBeat.o(53851);
        return file;
    }

    public void a(boolean z) {
        AppMethodBeat.i(53852);
        this.f2286d = z;
        c();
        AppMethodBeat.o(53852);
    }

    public void c() {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2;
        Properties properties;
        AppMethodBeat.i(53853);
        try {
            File d2 = d();
            if (d2 == null) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    bufferedInputStream2.close();
                } catch (Exception e2) {
                }
                BufferedOutputStream bufferedOutputStream3 = null;
                try {
                    bufferedOutputStream3.close();
                    AppMethodBeat.o(53853);
                } catch (Exception e3) {
                    AppMethodBeat.o(53853);
                }
            } else {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(d2));
                try {
                    properties = new Properties();
                    properties.load(bufferedInputStream);
                    properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.f2283a));
                    properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.f2286d));
                    bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(d2));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e4) {
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e5) {
                    }
                    AppMethodBeat.o(53853);
                    throw th;
                }
                try {
                    properties.store(bufferedOutputStream2, (String) null);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e6) {
                    }
                    try {
                        bufferedOutputStream2.close();
                        AppMethodBeat.o(53853);
                    } catch (Exception e7) {
                        AppMethodBeat.o(53853);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = bufferedOutputStream2;
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    AppMethodBeat.o(53853);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            bufferedInputStream.close();
            bufferedOutputStream.close();
            AppMethodBeat.o(53853);
            throw th;
        }
    }
}
