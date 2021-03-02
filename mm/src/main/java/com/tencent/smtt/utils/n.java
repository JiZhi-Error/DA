package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class n {

    /* renamed from: c  reason: collision with root package name */
    private static n f2272c = null;

    /* renamed from: a  reason: collision with root package name */
    private Context f2273a = null;

    /* renamed from: b  reason: collision with root package name */
    private File f2274b = null;

    /* renamed from: d  reason: collision with root package name */
    private String f2275d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";

    /* renamed from: e  reason: collision with root package name */
    private String f2276e = "http://log.tbs.qq.com/ajax?c=pu&tk=";

    /* renamed from: f  reason: collision with root package name */
    private String f2277f = "http://log.tbs.qq.com/ajax?c=dl&k=";

    /* renamed from: g  reason: collision with root package name */
    private String f2278g = "http://cfg.imtt.qq.com/tbs?v=2&mk=";

    /* renamed from: h  reason: collision with root package name */
    private String f2279h = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";

    /* renamed from: i  reason: collision with root package name */
    private String f2280i = "http://log.tbs.qq.com/ajax?c=ucfu&k=";

    /* renamed from: j  reason: collision with root package name */
    private String f2281j = "https://tbsrecovery.imtt.qq.com/getconfig";

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            AppMethodBeat.i(53861);
            if (f2272c == null) {
                f2272c = new n(context);
            }
            nVar = f2272c;
            AppMethodBeat.o(53861);
        }
        return nVar;
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            nVar = f2272c;
        }
        return nVar;
    }

    @TargetApi(11)
    private n(Context context) {
        AppMethodBeat.i(53862);
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.f2273a = context.getApplicationContext();
        h();
        AppMethodBeat.o(53862);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0105 A[SYNTHETIC, Splitter:B:47:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011d A[SYNTHETIC, Splitter:B:55:0x011d] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void h() {
        /*
        // Method dump skipped, instructions count: 313
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.n.h():void");
    }

    private File i() {
        Throwable th;
        File file;
        AppMethodBeat.i(188554);
        try {
            if (this.f2274b == null) {
                this.f2274b = new File(f.a(this.f2273a, 5));
                if (this.f2274b == null || !this.f2274b.isDirectory()) {
                    AppMethodBeat.o(188554);
                    return null;
                }
            }
            file = new File(this.f2274b, "tbsnet.conf");
            if (!file.exists()) {
                TbsLog.e("TbsCommonConfig", "Get file(" + file.getCanonicalPath() + ") failed!");
                AppMethodBeat.o(188554);
                return null;
            }
            try {
                TbsLog.w("TbsCommonConfig", "pathc:" + file.getCanonicalPath());
            } catch (Throwable th2) {
                th = th2;
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
                AppMethodBeat.o(188554);
                return file;
            }
            AppMethodBeat.o(188554);
            return file;
        } catch (Throwable th3) {
            th = th3;
            file = null;
            StringWriter stringWriter2 = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter2));
            TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter2.toString());
            AppMethodBeat.o(188554);
            return file;
        }
    }

    public String b() {
        AppMethodBeat.i(53865);
        TbsLog.d("TbsCommonConfig", "getPvUploadPostUrl:" + this.f2275d);
        String str = this.f2275d;
        AppMethodBeat.o(53865);
        return str;
    }

    public String c() {
        AppMethodBeat.i(53866);
        TbsLog.d("TbsCommonConfig", "getTbsDownloadStatPostUrl:" + this.f2277f);
        String str = this.f2277f;
        AppMethodBeat.o(53866);
        return str;
    }

    public String d() {
        AppMethodBeat.i(53867);
        TbsLog.d("TbsCommonConfig", "getTbsDownloaderPostUrl:" + this.f2278g);
        String str = this.f2278g;
        AppMethodBeat.o(53867);
        return str;
    }

    public String e() {
        AppMethodBeat.i(53868);
        TbsLog.d("TbsCommonConfig", "getTbsLogPostUrl:" + this.f2279h);
        String str = this.f2279h;
        AppMethodBeat.o(53868);
        return str;
    }

    public String f() {
        AppMethodBeat.i(53869);
        TbsLog.d("TbsCommonConfig", "getPvUploadPostUrl:" + this.f2276e);
        String str = this.f2276e;
        AppMethodBeat.o(53869);
        return str;
    }

    public String g() {
        return this.f2281j;
    }
}
