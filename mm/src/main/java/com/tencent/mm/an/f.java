package com.tencent.mm.an;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Random;

public class f implements bd {
    private i iSA = new i() {
        /* class com.tencent.mm.an.f.AnonymousClass3 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(150434);
            if (!(qVar instanceof d)) {
                Log.w("MicroMsg.SubCoreCdnTransport", "get cdn dns on scene end but is not [NetSceneGetCdnDns]");
                AppMethodBeat.o(150434);
                return;
            }
            Log.i("MicroMsg.SubCoreCdnTransport", "%d get cdn dns on scene end errType[%d] errCode[%d] errMsg[%s] lastGetDnsErrorTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(f.this.iSy));
            if ("doScene failed".equals(str)) {
                Log.d("MicroMsg.SubCoreCdnTransport", "%d get cdn dns cache do nothing.", Integer.valueOf(hashCode()));
                AppMethodBeat.o(150434);
                return;
            }
            h.INSTANCE.idkeyStat(546, (long) (i2 + 10), 1, true);
            if (i2 == 0) {
                if (f.this.iSy > 0) {
                    h.INSTANCE.idkeyStat(546, 52, 1, true);
                    f.this.iSy = 0;
                }
                AppMethodBeat.o(150434);
            } else if (i2 == 4) {
                AppMethodBeat.o(150434);
            } else if (f.this.iSy == 0) {
                int i4 = ((d) qVar).scene;
                f.this.iSy = Util.nowMilliSecond();
                f.this.iSz.removeMessages(1);
                f.this.iSz.sendMessageDelayed(f.this.iSz.obtainMessage(1, i4, 0), 30000);
                h.INSTANCE.idkeyStat(546, 50, 1, true);
                AppMethodBeat.o(150434);
            } else {
                f.this.iSy = 0;
                h.INSTANCE.idkeyStat(546, 51, 1, true);
                AppMethodBeat.o(150434);
            }
        }
    };
    private a iSv = null;
    private b iSw = null;
    private com.tencent.mm.ak.f iSx;
    private long iSy = 0;
    private MMHandler iSz = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.an.f.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(150433);
            if (message.what != 1) {
                AppMethodBeat.o(150433);
            } else if (f.this.iSy == 0) {
                AppMethodBeat.o(150433);
            } else {
                int i2 = message.arg1;
                Log.i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", Integer.valueOf(i2), Long.valueOf(f.this.iSy), Long.valueOf(Util.milliSecondsToNow(f.this.iSy)));
                g.azz().a(new d(i2), 0);
                AppMethodBeat.o(150433);
            }
        }
    };

    public f() {
        AppMethodBeat.i(150435);
        AppMethodBeat.o(150435);
    }

    public static synchronized f baN() {
        f fVar;
        synchronized (f.class) {
            AppMethodBeat.i(150436);
            fVar = (f) y.at(f.class);
            AppMethodBeat.o(150436);
        }
        return fVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    public static String baO() {
        AppMethodBeat.i(150437);
        g.aAf().azk();
        String str = g.aAh().cachePath + "cdndnsinfo/";
        AppMethodBeat.o(150437);
        return str;
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    public static com.tencent.mm.ak.f baP() {
        AppMethodBeat.i(150438);
        com.tencent.mm.ak.f fVar = baN().iSx;
        AppMethodBeat.o(150438);
        return fVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(150439);
        onAccountRelease();
        g.aAf().azk();
        if (baN().iSw == null) {
            baN().iSw = new b();
            Log.i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", Integer.valueOf(baN().iSw.hashCode()));
        }
        o oVar = new o(baO());
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        this.iSx = new com.tencent.mm.ak.f() {
            /* class com.tencent.mm.an.f.AnonymousClass1 */

            @Override // com.tencent.mm.ak.f
            public final void a(tc tcVar, tc tcVar2, tc tcVar3) {
                AppMethodBeat.i(150432);
                Log.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + tcVar.toString() + " getCore().engine:" + f.baR());
                if (f.baR() != null) {
                    f.baR().a(tcVar, tcVar2, tcVar3, (byte[]) null, (byte[]) null, (tc) null);
                    com.tencent.f.h.RTc.b(new Runnable() {
                        /* class com.tencent.mm.an.f.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(150430);
                            if (f.baQ() != null) {
                                f.baQ().fD(false);
                            }
                            AppMethodBeat.o(150430);
                        }

                        public final String toString() {
                            AppMethodBeat.i(150431);
                            String str = super.toString() + "|infoUpdate";
                            AppMethodBeat.o(150431);
                            return str;
                        }
                    }, "MicroMsg.Cdn.ThreadName");
                }
                AppMethodBeat.o(150432);
            }
        };
        g.azz().a(379, this.iSA);
        Log.i("MicroMsg.SubCoreCdnTransport", "onAccountPostReset, tryToGetCdnDns");
        sU(1);
        AppMethodBeat.o(150439);
    }

    public static b baQ() {
        AppMethodBeat.i(150440);
        if (baN().iSw == null) {
            synchronized (f.class) {
                try {
                    if (baN().iSw == null) {
                        baN().iSw = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(150440);
                    throw th;
                }
            }
        }
        b bVar = baN().iSw;
        AppMethodBeat.o(150440);
        return bVar;
    }

    public static synchronized a baR() {
        a aVar;
        synchronized (f.class) {
            AppMethodBeat.i(150441);
            if (baN().iSv == null) {
                g.aAf();
                if (a.azo()) {
                    baN().iSv = new a(g.aAh().cachePath, baQ());
                } else {
                    String str = ar.NSe + com.tencent.mm.b.g.getMessageDigest(("mm" + new Random().nextLong()).getBytes()) + FilePathGenerator.ANDROID_DIR_SEP;
                    Log.v("MicroMsg.SubCoreCdnTransport", "hy: cdn temp path: %s", str);
                    baN().iSv = new a(str, baQ());
                }
            }
            aVar = baN().iSv;
            AppMethodBeat.o(150441);
        }
        return aVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(150442);
        this.iSx = null;
        if (this.iSv != null) {
            a aVar = this.iSv;
            CdnLogic.UnInitialize();
            aVar.iRn = null;
            aVar.iRo = null;
            aVar.iRi = null;
            this.iSv = null;
        }
        if (this.iSw != null) {
            b bVar = this.iSw;
            if (bVar.iRw != null) {
                bVar.iRw.clear();
            }
            if (g.aAf().azp()) {
                g.aAh().azQ().remove(bVar);
            }
            bVar.iRr.removeCallbacksAndMessages(null);
            g.aAg().b(bVar.iRt);
            g.aAg().hqi.b(379, bVar);
            EventCenter.instance.removeListener(bVar.iRs);
            bVar.appForegroundListener.dead();
            bVar.iRv.stopTimer();
            this.iSw = null;
        }
        this.iSy = 0;
        this.iSz.removeCallbacksAndMessages(null);
        g.azz().b(379, this.iSA);
        AppMethodBeat.o(150442);
    }

    public final void sU(int i2) {
        AppMethodBeat.i(150443);
        this.iSy = 0;
        this.iSz.removeMessages(1);
        g.azz().a(new d(i2), 0);
        AppMethodBeat.o(150443);
    }
}
