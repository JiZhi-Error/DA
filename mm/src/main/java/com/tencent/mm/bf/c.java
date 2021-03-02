package com.tencent.mm.bf;

import com.tencent.map.swlocation.api.INetworkApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.sdk.TbsMediaPlayer;

public final class c implements INetworkApi, i {
    private float dTj;
    private int dTk;
    private int dTl;
    private String dTm;
    private String dTn;
    private a jiK;
    private byte[] jiL;
    private int jiM;
    private float latitude;
    private Object lock = new Object();
    private int scene;
    private MTimerHandler timerHandler;

    public c(float f2, float f3, int i2, int i3, String str, String str2, int i4, int i5) {
        AppMethodBeat.i(150905);
        g.aAi();
        this.timerHandler = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.bf.c.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(150904);
                Log.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
                if (c.this.jiK != null) {
                    g.aAg().hqi.a(c.this.jiK);
                }
                c.this.jiK = null;
                c.this.jiL = null;
                synchronized (c.this.lock) {
                    try {
                        c.this.lock.notifyAll();
                    } catch (Throwable th) {
                        AppMethodBeat.o(150904);
                        throw th;
                    }
                }
                AppMethodBeat.o(150904);
                return false;
            }
        }, false);
        this.dTj = f2;
        this.latitude = f3;
        this.dTk = i2;
        this.dTl = i3;
        this.dTm = str;
        this.dTn = str2;
        this.jiM = i4;
        this.scene = i5;
        g.aAg().hqi.a(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, this);
        AppMethodBeat.o(150905);
    }

    public final void finish() {
        AppMethodBeat.i(150906);
        this.timerHandler.stopTimer();
        if (this.jiK != null) {
            g.aAg().hqi.a(this.jiK);
        }
        this.jiK = null;
        this.jiL = null;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } catch (Throwable th) {
                AppMethodBeat.o(150906);
                throw th;
            }
        }
        unRegister();
        AppMethodBeat.o(150906);
    }

    private void unRegister() {
        AppMethodBeat.i(150907);
        g.aAg().hqi.b(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, this);
        AppMethodBeat.o(150907);
    }

    @Override // com.tencent.map.swlocation.api.INetworkApi
    public final byte[] httpRequest(String str, byte[] bArr) {
        AppMethodBeat.i(150908);
        Log.w("MicroMsg.SenseWhereHttpUtil", "why use this method? sense where sdk has something warn.");
        byte[] bArr2 = new byte[0];
        AppMethodBeat.o(150908);
        return bArr2;
    }

    @Override // com.tencent.map.swlocation.api.INetworkApi, com.b.a.a.q
    public final byte[] httpRequest(byte[] bArr) {
        AppMethodBeat.i(150909);
        try {
            String str = new String(bArr, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            Log.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : ".concat(String.valueOf(str)));
            this.jiL = null;
            this.jiK = new a(this.dTj, this.latitude, this.dTk, this.dTl, this.dTm, this.dTn, this.jiM, this.scene, str);
            g.aAg().hqi.a(this.jiK, 0);
            this.timerHandler.startTimer(Util.MILLSECONDS_OF_MINUTE);
            synchronized (this.lock) {
                try {
                    this.lock.wait();
                } catch (Throwable th) {
                    AppMethodBeat.o(150909);
                    throw th;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e2, "", new Object[0]);
            Log.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + e2.toString());
        }
        Log.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", Boolean.valueOf(Util.isNullOrNil(this.jiL)));
        byte[] bArr2 = this.jiL;
        AppMethodBeat.o(150909);
        return bArr2;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(150910);
        this.timerHandler.stopTimer();
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof a) {
                String nullAs = Util.nullAs(((a) qVar).jil, "");
                Log.d("MicroMsg.SenseWhereHttpUtil", "senseWhereResp: ".concat(String.valueOf(nullAs)));
                try {
                    this.jiL = nullAs.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e2, "", new Object[0]);
                    Log.e("MicroMsg.SenseWhereHttpUtil", "string to byte[] error. " + e2.toString());
                }
            } else {
                this.jiL = null;
            }
            synchronized (this.lock) {
                try {
                    this.lock.notifyAll();
                } catch (Throwable th) {
                    AppMethodBeat.o(150910);
                    throw th;
                }
            }
        } else {
            Log.w("MicroMsg.SenseWhereHttpUtil", "upload sense where info error. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
            this.jiL = null;
            synchronized (this.lock) {
                try {
                    this.lock.notifyAll();
                } catch (Throwable th2) {
                    AppMethodBeat.o(150910);
                    throw th2;
                }
            }
            b.beB().beD();
            h.INSTANCE.idkeyStat(345, 4, 1, false);
        }
        this.jiK = null;
        AppMethodBeat.o(150910);
    }
}
