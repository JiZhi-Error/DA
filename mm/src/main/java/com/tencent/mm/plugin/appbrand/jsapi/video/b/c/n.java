package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public final class n {
    private static AtomicInteger mzm = new AtomicInteger(10000);
    String eby;
    boolean ifP;
    private long kNt = -1;
    private c mxv = c.myu;
    String mxw = "";
    private int mzA;
    Future<?> mzk;
    private int mzn = 0;
    private int mzo = 0;
    o mzp;
    private final Object mzq = new Object();
    int mzr = mzm.incrementAndGet();
    int mzs = 0;
    long mzt;
    long mzu;
    public boolean mzv;
    String mzw;
    public String mzx;
    String mzy;
    private int mzz;
    int priority = -1;
    long startTime = System.currentTimeMillis();
    String uuid;

    static {
        AppMethodBeat.i(234824);
        AppMethodBeat.o(234824);
    }

    public n() {
        AppMethodBeat.i(234816);
        AppMethodBeat.o(234816);
    }

    public final synchronized void xy(int i2) {
        this.mzA = i2;
    }

    public final synchronized void xz(int i2) {
        this.mzz += i2;
    }

    public final String getLogTag() {
        AppMethodBeat.i(234817);
        String str = this.mxw + "VideoRequest";
        AppMethodBeat.o(234817);
        return str;
    }

    public final synchronized long getTotalLength() {
        return this.kNt;
    }

    public final synchronized c bJP() {
        return this.mxv;
    }

    public final synchronized void a(long j2, c cVar) {
        AppMethodBeat.i(234818);
        this.kNt = j2;
        this.mxv = cVar;
        if (this.mxv.equals(c.myw)) {
            this.mzs |= 8;
        }
        AppMethodBeat.o(234818);
    }

    public final String toString() {
        String obj;
        AppMethodBeat.i(234819);
        StringBuilder append = new StringBuilder().append(super.toString()).append("{seq=").append(this.mzr).append(",priority=").append(this.priority).append(",range=[").append(this.mzt).append(",").append(this.mzu).append("],uuid=").append(this.uuid).append(",contentType=").append(this.mzx).append(",cancelState=").append(this.mzo).append(",sourceUrl=").append(this.eby).append(",videoKey=").append(this.mzw).append(",task=");
        if (this.mzk == null) {
            obj = BuildConfig.COMMAND;
        } else {
            obj = this.mzk.toString();
        }
        String sb = append.append(obj).append("}").toString();
        AppMethodBeat.o(234819);
        return sb;
    }

    public final long bJV() {
        AppMethodBeat.i(234820);
        long currentTimeMillis = (long) (((float) (((long) this.mzz) * 1000)) / ((float) ((System.currentTimeMillis() - this.startTime) * 1024)));
        AppMethodBeat.o(234820);
        return currentTimeMillis;
    }

    public final void bJW() {
        AppMethodBeat.i(234821);
        if (eg(2, 3)) {
            if (this.mzp != null) {
                this.mzp.bJY();
            }
            if (a.bJK().cWq) {
                h.log(3, getLogTag(), "cancel success, seq=" + this.mzr);
            }
        }
        AppMethodBeat.o(234821);
    }

    public final void bJX() {
        AppMethodBeat.i(234822);
        if (eg(1, 2) && a.bJK().cWq) {
            h.log(3, getLogTag(), "cancel proceeding, seq=" + this.mzr);
        }
        AppMethodBeat.o(234822);
    }

    public final void xA(int i2) {
        if ((this.mzn & i2) == 0) {
            this.mzn += i2;
        }
    }

    public final boolean xB(int i2) {
        boolean z;
        synchronized (this.mzq) {
            z = this.mzo == i2;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final boolean eg(int i2, int i3) {
        AppMethodBeat.i(234823);
        synchronized (this.mzq) {
            try {
                if (this.mzo == i2) {
                    this.mzo = i3;
                    return true;
                }
                h.log(5, getLogTag(), String.format(Locale.US, "transState error, current %d, condition %d, newState %d", Integer.valueOf(this.mzo), Integer.valueOf(i2), Integer.valueOf(i3)));
                AppMethodBeat.o(234823);
                return false;
            } finally {
                AppMethodBeat.o(234823);
            }
        }
    }
}
