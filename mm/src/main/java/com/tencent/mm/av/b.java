package com.tencent.mm.av;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.a.z;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import java.lang.ref.WeakReference;
import java.util.Stack;

public final class b implements e.a {
    int Mr;
    boolean cwV = false;
    private a iWH;
    Stack<Long> iWI;
    long iWJ = 0;
    public int iWK = 0;
    long iWL = 0;
    int iWM = 0;
    boolean iWN = false;
    long iWO = 0;
    long iWP = 0;
    int iWQ;
    MTimerHandler iWR = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.av.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(150512);
            long uidRxBytes = TrafficStats.getUidRxBytes(b.this.Mr);
            long uidTxBytes = TrafficStats.getUidTxBytes(b.this.Mr);
            long j2 = (uidRxBytes - b.this.iWO) + (uidTxBytes - b.this.iWP);
            Log.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + (j2 / 1024));
            if (j2 <= 20480) {
                b.this.iWN = false;
                b.this.start();
            } else {
                b.this.iWO = uidRxBytes;
                b.this.iWP = uidTxBytes;
                b.this.iWR.startTimer(1000);
            }
            AppMethodBeat.o(150512);
            return true;
        }
    }, false);
    IListener iWS = new IListener<pg>() {
        /* class com.tencent.mm.av.b.AnonymousClass2 */

        {
            AppMethodBeat.i(161773);
            this.__eventId = pg.class.getName().hashCode();
            AppMethodBeat.o(161773);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pg pgVar) {
            int i2;
            AppMethodBeat.i(150513);
            pg pgVar2 = pgVar;
            b bVar = b.this;
            int i3 = b.this.iWM;
            if (pgVar2.dVo.pause) {
                i2 = 1;
            } else {
                i2 = -1;
            }
            bVar.iWM = i2 + i3;
            if (b.this.iWM < 0) {
                b.this.iWM = 0;
                Log.e("MicroMsg.AutoGetBigImgLogic", "mPauseCnt < 0");
            }
            Log.i("MicroMsg.AutoGetBigImgLogic", "req pause: " + pgVar2.dVo.pause + " count:" + b.this.iWM);
            b.this.start();
            AppMethodBeat.o(150513);
            return false;
        }
    };
    IListener iWT = new IListener<z>() {
        /* class com.tencent.mm.av.b.AnonymousClass3 */

        {
            AppMethodBeat.i(161774);
            this.__eventId = z.class.getName().hashCode();
            AppMethodBeat.o(161774);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(z zVar) {
            AppMethodBeat.i(150515);
            boolean a2 = a(zVar);
            AppMethodBeat.o(150515);
            return a2;
        }

        private boolean a(z zVar) {
            AppMethodBeat.i(150514);
            b.this.iWQ = zVar.dCX.mode;
            Log.d("MicroMsg.AutoGetBigImgLogic", "mode = " + b.this.iWQ);
            d.baW();
            if (!d.baX()) {
                synchronized (b.this.iWI) {
                    try {
                        b.this.iWI.clear();
                    } catch (Throwable th) {
                        AppMethodBeat.o(150514);
                        throw th;
                    }
                }
            }
            AppMethodBeat.o(150514);
            return false;
        }
    };

    /* access modifiers changed from: package-private */
    public static class a extends MMHandler {
        private WeakReference<b> iWV;

        public a(b bVar, Looper looper) {
            super(looper);
            AppMethodBeat.i(150516);
            this.iWV = new WeakReference<>(bVar);
            AppMethodBeat.o(150516);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(150517);
            b bVar = this.iWV.get();
            if (bVar != null && 1 == message.what) {
                boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_pause_other_preload_android, false);
                zj zjVar = new zj();
                zjVar.efx.dKy = 2;
                EventCenter.instance.publish(zjVar);
                if ((!zjVar.efy.calling && !com.tencent.mm.q.a.att()) || !a2) {
                    if (!bVar.cwV && System.currentTimeMillis() - bVar.iWL > 1200000) {
                        Log.i("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
                        AppMethodBeat.o(150517);
                    } else if (bVar.iWJ != 0 || bVar.iWI.size() <= 0 || bVar.iWM != 0 || bVar.iWN) {
                        Log.i("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + bVar.iWJ + " size: " + bVar.iWI.size() + " cnt: " + bVar.iWM + " pauseOnMonitor: " + bVar.iWN);
                        AppMethodBeat.o(150517);
                    } else {
                        synchronized (bVar.iWI) {
                            try {
                                bVar.iWJ = bVar.iWI.pop().longValue();
                            } finally {
                                AppMethodBeat.o(150517);
                            }
                        }
                        ca Hb = ((l) g.af(l.class)).eiy().Hb(bVar.iWJ);
                        g G = q.bcR().G(Hb.field_talker, Hb.field_msgSvrId);
                        if (G.fQW == 1) {
                            Log.i("MicroMsg.AutoGetBigImgLogic", bVar.iWJ + " already has hd thumb");
                            bVar.iWJ = 0;
                            bVar.start();
                            AppMethodBeat.o(150517);
                            return;
                        }
                        Log.i("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + bVar.iWJ + "  image_" + Hb.field_msgId);
                        f.baQ().iRE.add("image_" + Hb.field_msgId);
                        q.bcS().a(G.localId, Hb.field_msgId, 0, Long.valueOf(bVar.iWJ), bVar.iWK, bVar);
                    }
                }
            }
        }
    }

    public b(Looper looper) {
        int i2;
        AppMethodBeat.i(150518);
        this.iWH = new a(this, looper);
        this.iWI = new Stack<>();
        this.Mr = Process.myUid();
        Integer num = (Integer) g.aAh().azQ().get(327681, (Object) null);
        if (num == null || 3 == num.intValue()) {
            i2 = 1;
        } else {
            i2 = num.intValue();
        }
        this.iWQ = i2;
        EventCenter.instance.addListener(this.iWS);
        EventCenter.instance.addListener(this.iWT);
        AppMethodBeat.o(150518);
    }

    public final void start() {
        AppMethodBeat.i(150519);
        this.iWH.sendEmptyMessage(1);
        AppMethodBeat.o(150519);
    }

    public final void setForeground(boolean z) {
        AppMethodBeat.i(150520);
        Log.d("MicroMsg.AutoGetBigImgLogic", "is foreground: ".concat(String.valueOf(z)));
        this.cwV = z;
        this.iWL = System.currentTimeMillis();
        AppMethodBeat.o(150520);
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, q qVar) {
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, q qVar) {
        AppMethodBeat.i(150521);
        if (i4 == 0 && i5 == 0) {
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                Log.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
            } else {
                long nullAs = Util.nullAs((Long) g.aAh().azQ().get(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, (Object) null), 0);
                long safeParseLong = Util.safeParseLong((String) DateFormat.format("M", System.currentTimeMillis()));
                Log.d("MicroMsg.AutoGetBigImgLogic", "img " + j2 + " msgLocalId: " + j3 + " has been downloaded current %d month %d", Long.valueOf(1 + nullAs), Long.valueOf(safeParseLong));
                g.aAh().azQ().set(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(nullAs + 1));
                g.aAh().azQ().set(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(safeParseLong));
            }
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).b(j3, true, false);
        } else {
            Log.e("MicroMsg.AutoGetBigImgLogic", "img " + j2 + "msgLocalId " + j3 + " download failed");
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).b(j3, false, false);
        }
        this.iWJ = 0;
        d.baW();
        if (!d.baX()) {
            Log.i("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
            synchronized (this.iWI) {
                try {
                    this.iWI.clear();
                } finally {
                    AppMethodBeat.o(150521);
                }
            }
            return;
        }
        this.iWO = TrafficStats.getUidRxBytes(this.Mr);
        this.iWP = TrafficStats.getUidTxBytes(this.Mr);
        this.iWR.startTimer(1000);
        AppMethodBeat.o(150521);
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj) {
        AppMethodBeat.i(150522);
        Log.i("MicroMsg.AutoGetBigImgLogic", "img " + j2 + " has been canceled");
        ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).b(j3, false, true);
        AppMethodBeat.o(150522);
    }
}
