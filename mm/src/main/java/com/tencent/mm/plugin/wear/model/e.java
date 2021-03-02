package com.tencent.mm.plugin.wear.model;

import android.app.KeyguardManager;
import android.os.Looper;
import android.os.PowerManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.blink.b;
import com.tencent.mm.g.a.aan;
import com.tencent.mm.g.a.aaq;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.a;
import com.tencent.mm.plugin.wear.model.f.f;
import com.tencent.mm.plugin.wear.model.f.g;
import com.tencent.mm.plugin.wear.model.f.i;
import com.tencent.mm.plugin.wear.model.f.j;
import com.tencent.mm.plugin.wear.model.f.k;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.protocal.protobuf.eys;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public final class e {
    IListener ELJ = new IListener<nm>() {
        /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass1 */

        {
            AppMethodBeat.i(161463);
            this.__eventId = nm.class.getName().hashCode();
            AppMethodBeat.o(161463);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(nm nmVar) {
            AppMethodBeat.i(29986);
            nm nmVar2 = nmVar;
            if (e.a(e.this) && !"gh_3dfda90e39d6".equals(nmVar2.dTE.talker)) {
                bg.aVF();
                ca aEx = c.aSQ().aEx(nmVar2.dTE.talker);
                if (aEx != null ? h.aqJ().getInt("WearLuckyBlock", 0) == 0 && (aEx.gDe() || aEx.gDf()) : false) {
                    a.fVN().a(new g(aEx));
                    if (nmVar2.dTE.dCm > 1) {
                        e.v(nmVar2.dTE.talker, nmVar2.dTE.dCm, false);
                    }
                } else {
                    e.v(nmVar2.dTE.talker, nmVar2.dTE.dCm, true);
                }
            }
            AppMethodBeat.o(29986);
            return false;
        }
    };
    private KeyguardManager IxK;
    IListener IxL = new IListener<l>() {
        /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass4 */

        {
            AppMethodBeat.i(161465);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(161465);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(l lVar) {
            AppMethodBeat.i(29990);
            if (lVar.dCi.isActive) {
                a.fVN().a(new i());
            }
            AppMethodBeat.o(29990);
            return false;
        }
    };
    IListener IxM = new IListener<ot>() {
        /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass5 */

        {
            AppMethodBeat.i(161466);
            this.__eventId = ot.class.getName().hashCode();
            AppMethodBeat.o(161466);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ot otVar) {
            AppMethodBeat.i(29992);
            final ot otVar2 = otVar;
            b.ake().arrange(new Runnable() {
                /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass5.AnonymousClass1 */

                public final void run() {
                    eys eys;
                    boolean z;
                    AppMethodBeat.i(29991);
                    a.fVK().aWk(otVar2.dUN.talker);
                    f aWj = a.fVK().aWj(otVar2.dUN.talker);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(aWj.id));
                    a.fVN().a(new i(arrayList));
                    if (otVar2.dUN.talker.equals("gh_43f2581f6fd6") && (eys = a.fVM().IxH.Iyu) != null) {
                        b fVL = a.fVL();
                        if (eys == null || !fVL.IxA || !b.aWi(eys.Nvp)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            a.fVL();
                            b.a(eys);
                            AppMethodBeat.o(29991);
                            return;
                        }
                        a.fVL().connect();
                    }
                    AppMethodBeat.o(29991);
                }
            });
            AppMethodBeat.o(29992);
            return false;
        }
    };
    IListener IxN = new IListener<aaq>() {
        /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass8 */

        {
            AppMethodBeat.i(161468);
            this.__eventId = aaq.class.getName().hashCode();
            AppMethodBeat.o(161468);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaq aaq) {
            AppMethodBeat.i(29996);
            switch (aaq.ehD.dDe) {
                case 5:
                    a.fVN().a(new com.tencent.mm.plugin.wear.model.f.l(20011, ""));
                    break;
                case 6:
                case 7:
                    a.fVN().a(new com.tencent.mm.plugin.wear.model.f.l(20012, ""));
                    break;
            }
            AppMethodBeat.o(29996);
            return false;
        }
    };
    IListener IxO = new IListener<nx>() {
        /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass9 */

        {
            AppMethodBeat.i(161469);
            this.__eventId = nx.class.getName().hashCode();
            AppMethodBeat.o(161469);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(nx nxVar) {
            AppMethodBeat.i(29997);
            nx nxVar2 = nxVar;
            if (e.a(e.this)) {
                a.fVN().a(new f(nxVar2.dTZ.userName, nxVar2.dTZ.nickName, nxVar2.dTZ.type));
            }
            AppMethodBeat.o(29997);
            return false;
        }
    };
    IListener IxP = new IListener<tx>() {
        /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass10 */

        {
            AppMethodBeat.i(161470);
            this.__eventId = tx.class.getName().hashCode();
            AppMethodBeat.o(161470);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tx txVar) {
            AppMethodBeat.i(29998);
            if (e.a(e.this)) {
                a.fVN().a(new com.tencent.mm.plugin.wear.model.f.e());
            }
            AppMethodBeat.o(29998);
            return false;
        }
    };
    MTimerHandler cve = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass7 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(29995);
            a.fVN().a(new a());
            AppMethodBeat.o(29995);
            return true;
        }
    }, true);
    IListener gnH = new IListener<sw>() {
        /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass11 */

        {
            AppMethodBeat.i(161471);
            this.__eventId = sw.class.getName().hashCode();
            AppMethodBeat.o(161471);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sw swVar) {
            AppMethodBeat.i(29999);
            sw swVar2 = swVar;
            if (e.a(e.this)) {
                bg.aVF();
                az bjY = c.aST().bjY(swVar2.dZp.dTX.field_talker);
                if (bjY != null) {
                    int i2 = bjY.field_unReadCount;
                    f aWj = a.fVK().aWj(swVar2.dZp.dTX.field_talker);
                    if (i2 - aWj.IxY > 0) {
                        e.v(swVar2.dZp.dTX.field_talker, i2, false);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf(aWj.id));
                        a.fVN().a(new i(arrayList));
                    }
                }
            }
            AppMethodBeat.o(29999);
            return false;
        }
    };
    IListener ndY = new IListener<zj>() {
        /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass6 */

        {
            AppMethodBeat.i(161467);
            this.__eventId = zj.class.getName().hashCode();
            AppMethodBeat.o(161467);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(29994);
            boolean a2 = a(zjVar);
            AppMethodBeat.o(29994);
            return a2;
        }

        private static boolean a(zj zjVar) {
            ett ett;
            AppMethodBeat.i(29993);
            switch (zjVar.efx.dKy) {
                case 3:
                    byte[] bArr = zjVar.efx.efs;
                    if (bArr != null && bArr.length >= 10 && bArr[0] == 1) {
                        byte[] bArr2 = new byte[(bArr.length - 1)];
                        System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
                        try {
                            ett = (ett) new ett().parseFrom(bArr2);
                        } catch (IOException e2) {
                            ett = null;
                        }
                        if (ett != null) {
                            String str = ett.NqS;
                            Log.i("MicroMsg.Wear.WearLogic", "voip invite talker=%s | type=%s", str, Integer.valueOf(ett.NqJ));
                            a.fVN().a(new com.tencent.mm.plugin.wear.model.f.l(20010, str));
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(29993);
            return false;
        }
    };
    private PowerManager powerManager;
    i.a sMj = new i.a() {
        /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
        public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i iVar, i.c cVar) {
            AppMethodBeat.i(29988);
            if (cVar == null) {
                AppMethodBeat.o(29988);
                return;
            }
            if (cVar.zqo > 0 && a.fVM().IxI.Iyv.equals(cVar.talker)) {
                a.fVN().a(new com.tencent.mm.plugin.wear.model.f.c() {
                    /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.wear.model.f.c
                    public final void send() {
                        AppMethodBeat.i(29987);
                        try {
                            a.fVQ();
                            r.a(20007, a.fVM().IxI.Iyv.getBytes("utf8"), false);
                            AppMethodBeat.o(29987);
                        } catch (UnsupportedEncodingException e2) {
                            AppMethodBeat.o(29987);
                        }
                    }

                    @Override // com.tencent.mm.plugin.wear.model.f.d
                    public final String getName() {
                        return "SendMsgSyncTask";
                    }
                });
            }
            AppMethodBeat.o(29988);
        }
    };
    IListener yYb = new IListener<aan>() {
        /* class com.tencent.mm.plugin.wear.model.e.AnonymousClass3 */

        {
            AppMethodBeat.i(161464);
            this.__eventId = aan.class.getName().hashCode();
            AppMethodBeat.o(161464);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aan aan) {
            AppMethodBeat.i(29989);
            aan aan2 = aan;
            switch (aan2.ehq.action) {
                case 2:
                    a.fVN().a(new com.tencent.mm.plugin.wear.model.f.h(aan2.ehr.dFm, aan2.ehr.eht, aan2.ehr.ehu, aan2.ehr.ehv));
                    break;
                case 4:
                    if (h.aqJ().getInt("WearPayBlock", 0) == 0) {
                        a.fVN().a(new k(aan2.ehq.ehs, aan2.ehq.content));
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(29989);
            return false;
        }
    };

    public e() {
        AppMethodBeat.i(CommonUtils.MAX_TIMEOUT_MS);
        Log.i("MicroMsg.Wear.WearLogic", "Create!");
        this.ELJ.alive();
        this.IxL.alive();
        this.IxM.alive();
        this.ndY.alive();
        this.IxN.alive();
        this.IxO.alive();
        this.IxP.alive();
        this.gnH.alive();
        this.yYb.alive();
        this.cve.startTimer(1800000);
        this.powerManager = (PowerManager) MMApplicationContext.getContext().getSystemService("power");
        this.IxK = (KeyguardManager) MMApplicationContext.getContext().getSystemService("keyguard");
        bg.aVF();
        c.aSQ().a(this.sMj, (Looper) null);
        AppMethodBeat.o(CommonUtils.MAX_TIMEOUT_MS);
    }

    public static void v(String str, int i2, boolean z) {
        AppMethodBeat.i(CdnLogic.kMediaLittleAppPacket);
        a.fVN().a(new j(str, i2, z));
        AppMethodBeat.o(CdnLogic.kMediaLittleAppPacket);
    }

    static /* synthetic */ boolean a(e eVar) {
        AppMethodBeat.i(30002);
        if (eVar.IxK.inKeyguardRestrictedInputMode() || !eVar.powerManager.isScreenOn()) {
            AppMethodBeat.o(30002);
            return true;
        }
        AppMethodBeat.o(30002);
        return false;
    }
}
