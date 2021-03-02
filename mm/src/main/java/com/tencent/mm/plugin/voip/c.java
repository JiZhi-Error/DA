package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.app.o;
import com.tencent.mm.blink.b;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.k.d;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class c implements bd {
    private u GSJ = null;
    private p GSK = new p();
    private d GSL;
    com.tencent.mm.media.k.d GSM;
    private e GSN = new e();
    private a GSO = new a();
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.voip.c.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(114800);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!com.tencent.mm.kernel.a.azj()) {
                    b.ake().arrange(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.c.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(114799);
                            u fFg = c.fFg();
                            u.b bVar = fFg.GZc;
                            if (bVar != null) {
                                Log.i("MicroMsg.Voip.VoipService", "on voip resume");
                                String str = bVar.toUser;
                                boolean z = bVar.GZs;
                                boolean z2 = bVar.GZt;
                                long j2 = bVar.ypH;
                                fFg.enB();
                                fFg.a(MMApplicationContext.getContext(), str, j2, z, z2, true);
                                AppMethodBeat.o(114799);
                                return;
                            }
                            Log.i("MicroMsg.Voip.VoipService", "do not need voip resume");
                            AppMethodBeat.o(114799);
                        }
                    });
                }
            }
            AppMethodBeat.o(114800);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(114801);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                com.tencent.mm.kernel.a.azj();
            }
            AppMethodBeat.o(114801);
        }
    };

    public c() {
        AppMethodBeat.i(114804);
        AppMethodBeat.o(114804);
    }

    static {
        AppMethodBeat.i(114810);
        com.tencent.mm.plugin.voip.video.a.c.fLC();
        AppMethodBeat.o(114810);
    }

    private static c fFf() {
        AppMethodBeat.i(114805);
        c cVar = (c) y.at(c.class);
        AppMethodBeat.o(114805);
        return cVar;
    }

    public static u fFg() {
        AppMethodBeat.i(114806);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(114806);
            throw bVar;
        }
        if (fFf().GSJ == null) {
            fFf().GSJ = new u();
        }
        u uVar = fFf().GSJ;
        AppMethodBeat.o(114806);
        return uVar;
    }

    public static d fFh() {
        AppMethodBeat.i(184039);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(184039);
            throw bVar;
        }
        if (fFf().GSL == null) {
            fFf().GSL = new d();
        }
        d dVar = fFf().GSL;
        AppMethodBeat.o(184039);
        return dVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        MMHandler mMHandler;
        AppMethodBeat.i(114808);
        if (this.GSL != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.voip.c.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(114802);
                    c.this.GSL.rX(true);
                    c.this.GSL = null;
                    AppMethodBeat.o(114802);
                }
            });
        }
        if (this.GSM != null) {
            com.tencent.mm.media.k.d dVar = this.GSM;
            MMHandler mMHandler2 = dVar.handler;
            if (mMHandler2 != null) {
                mMHandler2.removeCallbacksAndMessages(null);
            }
            MMHandler mMHandler3 = dVar.handler;
            if (!(mMHandler3 == null || mMHandler3.isQuit() || (mMHandler = dVar.handler) == null)) {
                mMHandler.post(new d.c(dVar));
            }
        }
        l lVar = fFg().GYS.GSZ;
        if (lVar.GVX != null) {
            n nVar = lVar.GVX;
            if (nVar.GWP != null) {
                nVar.GWP.quitSafely();
                nVar.GWP = null;
            }
        }
        this.appForegroundListener.dead();
        h.d.b(50, this.GSK);
        fFg().unRegister();
        EventCenter.instance.removeListener(this.GSN);
        EventCenter.instance.removeListener(this.GSO);
        AppMethodBeat.o(114808);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    public static void a(boolean z, boolean z2, long j2, String str) {
        AppMethodBeat.i(235470);
        g.aAh().azQ().set(ar.a.USERINFO_VOIP_STATUS_PUSH_BOOLEAN, Boolean.FALSE);
        g.aAh().azQ().set(ar.a.USERINFO_VOIP_STATUS_VIDEO_MODE_BOOLEAN, Boolean.valueOf(z));
        g.aAh().azQ().set(ar.a.USERINFO_VOIP_STATUS_OUT_CALL_BOOLEAN, Boolean.valueOf(z2));
        g.aAh().azQ().set(ar.a.USERINFO_VOIP_STATUS_BEFORE_TIME_LONG, Long.valueOf(j2));
        g.aAh().azQ().set(ar.a.USERINFO_VOIP_STATUS_TO_USER_STRING, str);
        g.aAh().azQ().gBI();
        AppMethodBeat.o(235470);
    }

    public static void fFi() {
        AppMethodBeat.i(235471);
        g.aAh().azQ().set(ar.a.USERINFO_VOIP_STATUS_PUSH_BOOLEAN, Boolean.TRUE);
        g.aAh().azQ().gBI();
        AppMethodBeat.o(235471);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        boolean z2;
        AppMethodBeat.i(114809);
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_VOIP_STATUS_PUSH_BOOLEAN, (Object) null);
        if (obj != null && !((Boolean) obj).booleanValue()) {
            boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_VOIP_STATUS_VIDEO_MODE_BOOLEAN, Boolean.FALSE)).booleanValue();
            boolean booleanValue2 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_VOIP_STATUS_OUT_CALL_BOOLEAN, Boolean.FALSE)).booleanValue();
            long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_VOIP_STATUS_BEFORE_TIME_LONG, (Object) 0)).longValue();
            String str = (String) g.aAh().azQ().get(ar.a.USERINFO_VOIP_STATUS_TO_USER_STRING, (Object) null);
            Log.i("MicroMsg.SubCoreVoip", "voip message need push is %s,%s,%s,%s", Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2), Long.valueOf(longValue), str);
            s.c(str, booleanValue ? ca.OqC : ca.OqB, booleanValue2 ? 1 : 0, 6, MMApplicationContext.getContext().getString(R.string.i3v));
            fFi();
        }
        h.d.a(50, this.GSK);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_camera_number_mmkv_cache, 0) == 1 || com.tencent.mm.protocal.d.KyR || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("MicroMsg.SubCoreVoip", "onAccountPostReset before initCameraNumbers, useMMKVCache : %b", Boolean.valueOf(z2));
        com.tencent.mm.compatible.c.a aVar = com.tencent.mm.compatible.c.a.gDs;
        com.tencent.mm.compatible.c.a.dp(z2);
        com.tencent.mm.media.widget.d.c cVar = com.tencent.mm.media.widget.d.c.itl;
        com.tencent.mm.media.widget.d.c.aRN();
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.voip.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(235469);
                boolean z = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_codec_count_cache, 1) == 1 || com.tencent.mm.protocal.d.KyR || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG;
                Log.i("MicroMsg.SubCoreVoip", "makeCameraCache getCodecCountCache : ", Boolean.valueOf(z));
                if (z) {
                    com.tencent.mm.compatible.c.a aVar = com.tencent.mm.compatible.c.a.gDs;
                    com.tencent.mm.compatible.c.a.anO();
                }
                AppMethodBeat.o(235469);
            }
        });
        fFg();
        this.GSM = new com.tencent.mm.media.k.d();
        this.GSM.aNb();
        this.appForegroundListener.alive();
        EventCenter.instance.addListener(this.GSN);
        EventCenter.instance.addListener(this.GSO);
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        boolean booleanValue3 = ((Boolean) g.aAh().azQ().get(73217, Boolean.TRUE)).booleanValue();
        boolean booleanValue4 = ((Boolean) g.aAh().azQ().get(73218, Boolean.TRUE)).booleanValue();
        boolean apR = com.tencent.mm.n.b.apR();
        boolean booleanValue5 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        Log.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", Boolean.valueOf(booleanValue3), Boolean.valueOf(booleanValue4), Boolean.valueOf(apR), Boolean.valueOf(booleanValue5));
        if (!booleanValue5) {
            boolean z3 = booleanValue3 || booleanValue4;
            if (z3 != apR) {
                if (z3 && !apR) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(500, 13, 1, false);
                } else if (!z3 && apR) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(500, 14, 1, false);
                }
            }
            g.aAh().azQ().set(ar.a.USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC, Boolean.TRUE);
        }
        be.rY(1);
        AppMethodBeat.o(114809);
    }

    public static boolean fFj() {
        AppMethodBeat.i(235472);
        if ((z.aUd() & 137438953472L) == 0) {
            AppMethodBeat.o(235472);
            return true;
        }
        AppMethodBeat.o(235472);
        return false;
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    public class a extends IListener<ps> {
        public a() {
            AppMethodBeat.i(161651);
            this.__eventId = ps.class.getName().hashCode();
            AppMethodBeat.o(161651);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00de  */
        @Override // com.tencent.mm.sdk.event.IListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.ps r14) {
            /*
            // Method dump skipped, instructions count: 288
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.c.a.callback(com.tencent.mm.sdk.event.IEvent):boolean");
        }
    }
}
