package c.t.m.sapp.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import java.text.SimpleDateFormat;
import java.util.Date;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f52a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public static e f53b;

    /* renamed from: c  reason: collision with root package name */
    public final String f54c = "DexAsynchHandler";

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f55d;

    /* renamed from: e  reason: collision with root package name */
    public a f56e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57f;

    /* renamed from: g  reason: collision with root package name */
    public Context f58g;

    /* renamed from: h  reason: collision with root package name */
    public k f59h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleDateFormat f60i = new SimpleDateFormat("HHmmss");

    /* renamed from: j  reason: collision with root package name */
    public SimpleDateFormat f61j = new SimpleDateFormat("yyyyMMdd-HHmmss");

    /* access modifiers changed from: package-private */
    public class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public StringBuilder f62a = new StringBuilder(1024);

        public a(Looper looper) {
            super(looper);
            AppMethodBeat.i(222951);
            this.f62a.setLength(0);
            AppMethodBeat.o(222951);
        }

        public void a(Message message) {
            AppMethodBeat.i(222953);
            try {
                switch (message.what) {
                    case 10001:
                        AppMethodBeat.o(222953);
                        return;
                    case 10002:
                        AppMethodBeat.o(222953);
                        return;
                    case ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL /*{ENCODED_INT: 10003}*/:
                        AppMethodBeat.o(222953);
                        return;
                    case ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL /*{ENCODED_INT: 10004}*/:
                        AppMethodBeat.o(222953);
                        return;
                    case 10005:
                        g.a(e.this.f58g);
                        AppMethodBeat.o(222953);
                        return;
                    case 10006:
                        AppMethodBeat.o(222953);
                        return;
                    case CdnLogic.kMediaTypeFavoriteBigFile /*{ENCODED_INT: 10007}*/:
                        AppMethodBeat.o(222953);
                        return;
                    case 10008:
                        q.a(e.this.f58g);
                        AppMethodBeat.o(222953);
                        return;
                    default:
                        AppMethodBeat.o(222953);
                        return;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(222953);
            }
        }

        public void handleMessage(Message message) {
            AppMethodBeat.i(222952);
            super.handleMessage(message);
            a(message);
            AppMethodBeat.o(222952);
        }
    }

    public e(Context context) {
        AppMethodBeat.i(222954);
        this.f58g = context.getApplicationContext();
        this.f59h = new k(this.f58g);
        AppMethodBeat.o(222954);
    }

    public static e b() {
        return f53b;
    }

    public void a(String str, String str2) {
    }

    public void c() {
        AppMethodBeat.i(222956);
        if (this.f57f) {
            AppMethodBeat.o(222956);
            return;
        }
        this.f55d = new HandlerThread("d_thread");
        this.f55d.start();
        this.f56e = new a(this.f55d.getLooper());
        this.f57f = true;
        AppMethodBeat.o(222956);
    }

    public void d() {
    }

    public static e a(Context context) {
        AppMethodBeat.i(222955);
        if (f53b == null) {
            synchronized (e.class) {
                try {
                    if (f53b == null) {
                        f53b = new e(context);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(222955);
                    throw th;
                }
            }
        }
        e eVar = f53b;
        AppMethodBeat.o(222955);
        return eVar;
    }

    public void a(String str) {
        AppMethodBeat.i(222957);
        try {
            if (this.f58g == null || this.f56e == null || str == null || str.length() == 0) {
                AppMethodBeat.o(222957);
                return;
            }
            p.f92a = 3000;
            StringBuilder sb = new StringBuilder();
            sb.append("LOC_CORE").append(',').append(this.f61j.format(new Date())).append(',').append(q.h(this.f58g)).append(',').append(q.l(this.f58g)).append(',').append(q.e()).append(',').append(q.f()).append(',').append(q.b()).append(',').append("COMP").append(str).append("$");
            a(sb.toString().getBytes());
            AppMethodBeat.o(222957);
        } catch (Throwable th) {
            AppMethodBeat.o(222957);
        }
    }

    public void a() {
        AppMethodBeat.i(222958);
        if (this.f58g == null) {
            AppMethodBeat.o(222958);
            return;
        }
        a(10005, (String) null);
        AppMethodBeat.o(222958);
    }

    public final void a(int i2, String str) {
        AppMethodBeat.i(222960);
        a aVar = this.f56e;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage();
            obtainMessage.obj = str;
            obtainMessage.what = i2;
            o.a(aVar, obtainMessage);
        }
        AppMethodBeat.o(222960);
    }

    public boolean a(byte[] bArr) {
        AppMethodBeat.i(222959);
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    byte[] a2 = a(bArr, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
                    if (a2 == null || a2.length == 0) {
                        AppMethodBeat.o(222959);
                        return true;
                    }
                    if (p.a("https://analytics.map.qq.com/tr?mllc", a2) == null) {
                        this.f59h.a(a2);
                    }
                    AppMethodBeat.o(222959);
                    return false;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(222959);
                return false;
            }
        }
        AppMethodBeat.o(222959);
        return true;
    }

    public final byte[] a(byte[] bArr, String str) {
        AppMethodBeat.i(222961);
        if (bArr == null || bArr.length == 0) {
            byte[] bArr2 = f52a;
            AppMethodBeat.o(222961);
            return bArr2;
        }
        byte[] b2 = m.b(q.b(bArr), str);
        if (b2 == null || b2.length == 0) {
            byte[] bArr3 = f52a;
            AppMethodBeat.o(222961);
            return bArr3;
        }
        byte[] bArr4 = new byte[(b2.length + 2)];
        System.arraycopy(q.a(b2.length), 0, bArr4, 0, 2);
        System.arraycopy(b2, 0, bArr4, 2, b2.length);
        AppMethodBeat.o(222961);
        return bArr4;
    }
}
