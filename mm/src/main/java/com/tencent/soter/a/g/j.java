package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.soter.a.c.b;
import com.tencent.soter.a.f.d;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.c;
import com.tencent.soter.core.c.e;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.h;
import java.nio.charset.Charset;

public class j extends d {
    private static final String RRJ = ("soter_triggered_oom" + g.getMessageDigest(a.hlp().getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET))));
    private static final String RRK = ("soter_triggered_oom_count" + g.getMessageDigest(a.hlp().getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET))));
    private d RQZ;
    private boolean RRL = false;
    private String RRM = "";
    private h.a RRN = new h.a() {
        /* class com.tencent.soter.a.g.j.AnonymousClass1 */

        @Override // com.tencent.soter.core.c.h.a
        @SuppressLint({"ApplySharedPref"})
        public final void hlv() {
            AppMethodBeat.i(102);
            com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
            SharedPreferences hlJ = b.hlG().hlJ();
            if (hlJ != null) {
                SharedPreferences.Editor edit = hlJ.edit();
                edit.putInt(j.RRK, hlJ.getInt(j.RRK, 0) + 1);
                edit.commit();
            }
            AppMethodBeat.o(102);
        }

        @Override // com.tencent.soter.core.c.h.a
        public final boolean hlu() {
            AppMethodBeat.i(103);
            SharedPreferences hlJ = b.hlG().hlJ();
            if (hlJ != null) {
                int i2 = hlJ.getInt(j.RRK, 0);
                com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: is triggered OOM: %b", Integer.valueOf(i2));
                if (i2 >= 10) {
                    AppMethodBeat.o(103);
                    return true;
                }
                AppMethodBeat.o(103);
                return false;
            }
            AppMethodBeat.o(103);
            return false;
        }

        @Override // com.tencent.soter.core.c.h.a
        public final void reset() {
            AppMethodBeat.i(104);
            SharedPreferences hlJ = b.hlG().hlJ();
            if (hlJ != null) {
                hlJ.edit().putInt(j.RRK, 0).apply();
            }
            AppMethodBeat.o(104);
        }
    };
    private String RRa = "";
    private int[] RRb;

    static {
        AppMethodBeat.i(112);
        AppMethodBeat.o(112);
    }

    public j(Context context, e eVar) {
        boolean z = false;
        AppMethodBeat.i(107);
        c cVar = eVar.RRc;
        if (cVar != null) {
            com.tencent.soter.core.c.d.a(cVar);
        }
        HandlerThread handlerThread = eVar.RRe;
        if (handlerThread != null) {
            g hlR = g.hlR();
            if (hlR.RRm != null && hlR.RRm.isAlive()) {
                com.tencent.soter.core.c.d.i("Soter.SoterTaskThread", "quit the previous thread", new Object[0]);
                hlR.RRm.quit();
            }
            hlR.RRm = handlerThread;
            hlR.RRm.setName("SoterGenKeyHandlerThreadName");
            if (!handlerThread.isAlive()) {
                handlerThread.start();
            }
            hlR.RRn = new Handler(hlR.RRm.getLooper());
        }
        b hlG = b.hlG();
        SharedPreferences sharedPreferences = context.getSharedPreferences("soter_status", 0);
        synchronized (b.class) {
            try {
                hlG.RQz = sharedPreferences;
            } catch (Throwable th) {
                AppMethodBeat.o(107);
                throw th;
            }
        }
        h.a(this.RRN);
        a.hle();
        a.lc(context);
        a.efp();
        if (a.hlj() && (a.fN(context) || a.aU(context, 2))) {
            z = true;
        }
        this.RRL = z;
        this.RQZ = eVar.RQZ;
        this.RRb = eVar.RRb;
        this.RRa = eVar.RRa;
        this.RRM = eVar.RRd;
        AppMethodBeat.o(107);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final boolean hlM() {
        boolean z;
        String str;
        AppMethodBeat.i(108);
        if (b.hlG().hlC()) {
            com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: duplicate initialize soter", new Object[0]);
            c(new com.tencent.soter.a.b.d(TXLiteAVCode.EVT_SW_ENCODER_START_SUCC, "soter already have initialized"));
            AppMethodBeat.o(108);
            return true;
        }
        int[] iArr = this.RRb;
        if (iArr == null || iArr.length <= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
            c(new com.tencent.soter.a.b.d(1024, "no business scene provided"));
            AppMethodBeat.o(108);
            return true;
        }
        if (g.nullAsNil(this.RRa).length() > 16) {
            com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
            String messageDigest = g.getMessageDigest(this.RRa.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
            if (g.isNullOrNil(messageDigest) || messageDigest.length() < 16) {
                str = null;
            } else {
                str = messageDigest.substring(0, 16);
            }
            if (g.isNullOrNil(str)) {
                com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
                c(new com.tencent.soter.a.b.d(TXLiteAVCode.EVT_CAMERA_CLOSE, "the account salt length is too long"));
                AppMethodBeat.o(108);
                return true;
            }
            this.RRa = str;
        }
        if (g.isNullOrNil(this.RRM) || this.RRM.length() <= 24) {
            if (this.RQZ == null) {
                com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
            }
            if (!g.isNullOrNil(this.RRM)) {
                com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
                e.hls().RPL = this.RRM;
            }
            g.hlR().aj(new Runnable() {
                /* class com.tencent.soter.a.g.j.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(105);
                    j.this.f(j.this.RRa, j.this.RRb);
                    j.c(j.this);
                    AppMethodBeat.o(105);
                }
            });
            AppMethodBeat.o(108);
            return false;
        }
        com.tencent.soter.core.c.d.e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
        c(new com.tencent.soter.a.b.d(TXLiteAVCode.EVT_RTMP_PUSH_PUBLISH_START, "the passed ask name is too long (larger than 24)"));
        AppMethodBeat.o(108);
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void hlN() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void execute() {
        AppMethodBeat.i(109);
        if (!this.RRL) {
            com.tencent.soter.core.c.d.w("Soter.TaskInit", "soter: TaskInit check isNativeSupport[" + this.RRL + "]", new Object[0]);
            c(new com.tencent.soter.a.b.d(2));
            synchronized (b.class) {
                try {
                    b.hlG().DQ(false);
                    b.hlG().hlH();
                } finally {
                    AppMethodBeat.o(109);
                }
            }
        } else if (this.RQZ == null) {
            b.hlG().DQ(true);
            b.hlG().hlH();
            c(new com.tencent.soter.a.b.d(0));
            AppMethodBeat.o(109);
        } else {
            this.RQZ.setRequest(new d.a(a.hlp()));
            this.RQZ.a(new com.tencent.soter.a.f.b<d.b>() {
                /* class com.tencent.soter.a.g.j.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.soter.a.f.b
                public final /* synthetic */ void eB(d.b bVar) {
                    AppMethodBeat.i(106);
                    d.b bVar2 = bVar;
                    com.tencent.soter.core.c.d.i("Soter.TaskInit", "soter: got support tag from backend: %b", Boolean.valueOf(bVar2.edB));
                    synchronized (b.class) {
                        try {
                            b.hlG().DQ(bVar2.edB);
                            b.hlG().hlH();
                            b.hlG().RQx = bVar2.RQx;
                        } catch (Throwable th) {
                            AppMethodBeat.o(106);
                            throw th;
                        }
                    }
                    j.this.c(new com.tencent.soter.a.b.d(0));
                    AppMethodBeat.o(106);
                }
            });
            this.RQZ.execute();
            AppMethodBeat.o(109);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void b(com.tencent.soter.a.b.e eVar) {
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DefaultLocale"})
    public void f(String str, int[] iArr) {
        AppMethodBeat.i(110);
        for (int i2 : iArr) {
            b.hlG().hlI().put(i2, String.format("%suid%d_%s_scene%d", "Wechat", Integer.valueOf(Process.myUid()), g.nullAsNil(str), Integer.valueOf(i2)));
        }
        AppMethodBeat.o(110);
    }

    static /* synthetic */ void c(j jVar) {
        AppMethodBeat.i(111);
        SharedPreferences hlJ = b.hlG().hlJ();
        int i2 = hlJ.getInt(e.hls().RPL, -1);
        com.tencent.soter.core.c.d.d("Soter.TaskInit", "soter: ask status: %d", Integer.valueOf(i2));
        if (!(i2 != 0) || !a.hlm()) {
            for (int i3 : jVar.RRb) {
                String str = b.hlG().hlI().get(i3, "");
                if (!g.isNullOrNil(str)) {
                    int i4 = hlJ.getInt(str, 0);
                    com.tencent.soter.core.c.d.d("Soter.TaskInit", "soter: %s status: %d", str, Integer.valueOf(i4));
                    if ((i4 != 0) && a.bqh(str)) {
                        com.tencent.soter.core.c.d.i("Soter.TaskInit", "remove invalid ask: %s", str);
                        a.dE(str, false);
                    }
                }
            }
            AppMethodBeat.o(111);
            return;
        }
        com.tencent.soter.core.c.d.i("Soter.TaskInit", "invalid ask, remove all key", new Object[0]);
        a.hll();
        for (int i5 : jVar.RRb) {
            a.dE(b.hlG().hlI().get(i5, ""), false);
        }
        AppMethodBeat.o(111);
    }
}
