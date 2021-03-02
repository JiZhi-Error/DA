package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.e;

public abstract class d implements c {
    public boolean RCE = false;
    b RCF = null;
    protected byte[] RCG = null;
    public Object RCH = null;
    protected int RCI;
    protected int RCJ = 0;
    protected final String TAG2 = getClass().getSimpleName();
    private final long iMN = Util.MILLSECONDS_OF_MINUTE;
    private Runnable iMR = new Runnable() {
        /* class com.tencent.pb.common.b.d.AnonymousClass1 */

        public final void run() {
            d.this.pjO = true;
            b.d("MicroMsg.Voip", "NETTASK_RECV TimeOut cmd= ", d.this.hiV());
            e.U(20006, 3, "-1104");
            if (d.this.RCF != null) {
                d.this.RCF.a(2, -1, "time exceed, force to callback", d.this);
            }
        }
    };
    private int mErrorCode = -999;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    protected int mNetType = 2;
    boolean pjO = false;

    /* access modifiers changed from: protected */
    public abstract Object cO(byte[] bArr);

    public abstract int getType();

    /* access modifiers changed from: protected */
    public abstract String hiV();

    public final int a(b bVar) {
        if (this.RCG == null) {
            b.w("MicroMsg.Voip", this.TAG2, "dosene reqData is null cmd=" + this.RCI);
            return -1;
        }
        this.RCF = bVar;
        int a2 = f.hiZ().a((a) null, new i(this), this.RCI, hiV(), this.RCG, this.RCJ);
        if (a2 >= 0) {
            this.mHandler.postDelayed(this.iMR, Util.MILLSECONDS_OF_MINUTE);
        }
        b.d("MicroMsg.Voip", "NETTASK_SEND dosene:cmd ", hiV(), Integer.valueOf(a2));
        return a2;
    }

    @Override // com.tencent.pb.common.b.c
    public final void onResp(final int i2, byte[] bArr) {
        final int i3 = 2;
        b.d("MicroMsg.Voip", this.TAG2, "onResp errcode", Integer.valueOf(i2));
        this.mHandler.removeCallbacks(this.iMR);
        b.d("MicroMsg.Voip", "NETTASK_RECV onResp:cmd= ", hiV(), Integer.valueOf(i2), Boolean.valueOf(this.pjO));
        if (i2 != 0) {
            b.w("MicroMsg.Voip", this.TAG2, "getNetworkErrType errcode:".concat(String.valueOf(i2)));
            if (i2 != -1) {
                i3 = i2 == 6801 ? 10 : 4;
            } else if (h.isNetworkConnected()) {
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        if (this.pjO) {
            b.d("MicroMsg.Voip", "onResp netscene already canceled, cmd:" + this.RCI);
            return;
        }
        this.mErrorCode = i2;
        this.RCH = cO(bArr);
        this.mHandler.post(new Runnable() {
            /* class com.tencent.pb.common.b.d.AnonymousClass2 */

            public final void run() {
                if (d.this.pjO) {
                    b.d("MicroMsg.Voip", d.this.TAG2, "onResp netscene already canceled, cmd:" + d.this.RCI);
                } else if (d.this.RCF != null) {
                    d.this.RCF.a(i3, i2, "", d.this);
                }
            }
        });
    }

    public final void c(int i2, com.google.a.a.e eVar) {
        this.RCI = i2;
        byte[] bArr = null;
        try {
            bArr = com.google.a.a.e.b(eVar);
        } catch (Exception e2) {
        }
        this.RCG = bArr;
    }
}
