package com.tencent.map.tools.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.tools.sheet.listener.ModuleEncryptListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import java.io.File;
import java.util.Date;

public class g {

    /* renamed from: j  reason: collision with root package name */
    private static g f1330j;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f1331a;

    /* renamed from: b  reason: collision with root package name */
    a f1332b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1333c;

    /* renamed from: d  reason: collision with root package name */
    public Context f1334d;

    /* renamed from: e  reason: collision with root package name */
    public k f1335e;

    /* renamed from: f  reason: collision with root package name */
    public ModuleEncryptListener f1336f;

    /* renamed from: g  reason: collision with root package name */
    public File f1337g;

    /* renamed from: h  reason: collision with root package name */
    Looper f1338h;

    /* renamed from: i  reason: collision with root package name */
    private final String f1339i = g.class.getSimpleName();

    private g(Context context) {
        AppMethodBeat.i(180792);
        this.f1334d = context.getApplicationContext();
        this.f1331a = new HandlerThread("d_thread");
        this.f1331a.start();
        this.f1338h = this.f1331a.getLooper();
        this.f1332b = new a(this.f1338h);
        AppMethodBeat.o(180792);
    }

    public static g a(Context context) {
        AppMethodBeat.i(180793);
        synchronized (g.class) {
            try {
                if (f1330j == null) {
                    f1330j = new g(context);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(180793);
                throw th;
            }
        }
        g gVar = f1330j;
        AppMethodBeat.o(180793);
        return gVar;
    }

    public static g a() {
        return f1330j;
    }

    public final void a(String str, String str2) {
        AppMethodBeat.i(180794);
        if (a.f1317i && this.f1335e != null) {
            k kVar = this.f1335e;
            if (a.f1317i) {
                q.a(kVar.f1355b, 10001, kVar.f1354a.format(new Date()) + "," + str + "," + str2);
            }
        }
        AppMethodBeat.o(180794);
    }

    class a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private StringBuilder f1341b = new StringBuilder(1024);

        public a(Looper looper) {
            super(looper);
            AppMethodBeat.i(180790);
            AppMethodBeat.o(180790);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void handleMessage(Message message) {
            AppMethodBeat.i(180791);
            super.handleMessage(message);
            try {
                switch (message.what) {
                    case 10002:
                        AppMethodBeat.o(180791);
                        return;
                    case 10005:
                        if (a.f1317i && g.this.f1335e != null) {
                            k kVar = g.this.f1335e;
                            if (a.f1317i) {
                                q.a(kVar.f1355b, (int) ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, 0);
                                break;
                            }
                        }
                        break;
                }
                AppMethodBeat.o(180791);
            } catch (Throwable th) {
                AppMethodBeat.o(180791);
            }
        }
    }
}
