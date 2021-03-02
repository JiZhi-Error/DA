package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.notification.c.c;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f implements bd {
    private static f AHw = null;
    private static o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.notification.d.f.AnonymousClass7 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(26800);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    gu guVar = new gu();
                    guVar.dKP.isActive = true;
                    EventCenter.instance.publish(guVar);
                }
            }
            AppMethodBeat.o(26800);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(26801);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    gu guVar = new gu();
                    guVar.dKP.isActive = false;
                    EventCenter.instance.publish(guVar);
                }
            }
            AppMethodBeat.o(26801);
        }
    };
    private IListener AHA = new IListener<sj>() {
        /* class com.tencent.mm.plugin.notification.d.f.AnonymousClass1 */

        {
            AppMethodBeat.i(161401);
            this.__eventId = sj.class.getName().hashCode();
            AppMethodBeat.o(161401);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sj sjVar) {
            AppMethodBeat.i(26794);
            f.this.AHx.eyz();
            AppMethodBeat.o(26794);
            return false;
        }
    };
    private IListener AHB = new IListener<sk>() {
        /* class com.tencent.mm.plugin.notification.d.f.AnonymousClass2 */

        {
            AppMethodBeat.i(161402);
            this.__eventId = sk.class.getName().hashCode();
            AppMethodBeat.o(161402);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sk skVar) {
            AppMethodBeat.i(26795);
            f.this.AHy.eyz();
            AppMethodBeat.o(26795);
            return false;
        }
    };
    private IListener AHC = new IListener<oh>() {
        /* class com.tencent.mm.plugin.notification.d.f.AnonymousClass3 */

        {
            AppMethodBeat.i(161403);
            this.__eventId = oh.class.getName().hashCode();
            AppMethodBeat.o(161403);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(oh ohVar) {
            AppMethodBeat.i(26796);
            f.this.AHx.eyE();
            AppMethodBeat.o(26796);
            return false;
        }
    };
    private IListener AHD = new IListener<oi>() {
        /* class com.tencent.mm.plugin.notification.d.f.AnonymousClass4 */

        {
            AppMethodBeat.i(161404);
            this.__eventId = oi.class.getName().hashCode();
            AppMethodBeat.o(161404);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(oi oiVar) {
            AppMethodBeat.i(26797);
            f.this.AHy.eyE();
            AppMethodBeat.o(26797);
            return false;
        }
    };
    private IListener AHE = new IListener<cy>() {
        /* class com.tencent.mm.plugin.notification.d.f.AnonymousClass5 */

        {
            AppMethodBeat.i(161405);
            this.__eventId = cy.class.getName().hashCode();
            AppMethodBeat.o(161405);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(cy cyVar) {
            AppMethodBeat.i(26798);
            f.this.AHx.eyG().dismiss();
            f.this.AHy.eyG().dismiss();
            Log.i("MicroMsg.SubCoreNotification", "dismiss all fail msg notification");
            AppMethodBeat.o(26798);
            return false;
        }
    };
    private IListener AHF = new IListener<gu>() {
        /* class com.tencent.mm.plugin.notification.d.f.AnonymousClass6 */

        {
            AppMethodBeat.i(161406);
            this.__eventId = gu.class.getName().hashCode();
            AppMethodBeat.o(161406);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gu guVar) {
            AppMethodBeat.i(26799);
            f.this.ntv = guVar.dKP.isActive;
            AppMethodBeat.o(26799);
            return false;
        }
    };
    c AHx = null;
    c AHy = null;
    private com.tencent.mm.plugin.notification.a.a AHz = null;
    private boolean ntv = false;

    static {
        AppMethodBeat.i(26809);
        AppMethodBeat.o(26809);
    }

    private f() {
        AppMethodBeat.i(26802);
        b.init();
        if (this.AHy == null) {
            this.AHy = new e();
        }
        if (this.AHx == null) {
            this.AHx = new d();
        }
        AppMethodBeat.o(26802);
    }

    public static FailSendMsgNotification TU(int i2) {
        AppMethodBeat.i(26803);
        if (i2 == 2 && eyV().AHy != null) {
            Log.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
            FailSendMsgNotification eyG = eyV().AHy.eyG();
            AppMethodBeat.o(26803);
            return eyG;
        } else if (i2 != 1 || eyV().AHx == null) {
            AppMethodBeat.o(26803);
            return null;
        } else {
            Log.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
            FailSendMsgNotification eyG2 = eyV().AHx.eyG();
            AppMethodBeat.o(26803);
            return eyG2;
        }
    }

    public static f eyV() {
        AppMethodBeat.i(26804);
        if (AHw == null) {
            AHw = new f();
        }
        f fVar = AHw;
        AppMethodBeat.o(26804);
        return fVar;
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(26805);
        this.AHx.eyP();
        this.AHx.eyQ();
        this.AHy.eyP();
        this.AHy.eyQ();
        if (this.AHz == null) {
            this.AHz = new com.tencent.mm.plugin.notification.a.a();
        }
        com.tencent.mm.plugin.notification.a.a aVar = this.AHz;
        if (!bg.aAc()) {
            Log.e("MicroMsg.NotificationObserver", "account not ready!");
        } else {
            Log.d("MicroMsg.NotificationObserver", "added");
            try {
                bg.aVF();
                com.tencent.mm.model.c.aST().remove(aVar);
                bg.aVF();
                com.tencent.mm.model.c.aST().add(aVar);
                aVar.AGx = true;
            } catch (Exception e2) {
                Log.e("MicroMsg.NotificationObserver", "exception:%s", Util.stackTraceToString(e2));
            }
        }
        EventCenter.instance.addListener(this.AHA);
        EventCenter.instance.addListener(this.AHB);
        EventCenter.instance.addListener(this.AHC);
        EventCenter.instance.addListener(this.AHD);
        EventCenter.instance.addListener(this.AHE);
        EventCenter.instance.addListener(this.AHF);
        bg.getNotification().nR(com.tencent.mm.n.g.aqG());
        bg.getNotification().dj(false);
        Log.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
        AppMethodBeat.o(26805);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(26806);
        this.AHx.eyR();
        this.AHx.eyS();
        this.AHy.eyR();
        this.AHy.eyS();
        if (this.AHz != null) {
            com.tencent.mm.plugin.notification.a.a aVar = this.AHz;
            if (bg.aAc()) {
                try {
                    bg.aVF();
                    com.tencent.mm.model.c.aST().remove(aVar);
                } catch (Exception e2) {
                    Log.e("MicroMsg.NotificationObserver", "exception:%s", Util.stackTraceToString(e2));
                }
            }
        }
        EventCenter.instance.removeListener(this.AHA);
        EventCenter.instance.removeListener(this.AHB);
        EventCenter.instance.removeListener(this.AHC);
        EventCenter.instance.removeListener(this.AHD);
        EventCenter.instance.removeListener(this.AHE);
        EventCenter.instance.removeListener(this.AHF);
        bg.getNotification().nR(0);
        bg.getNotification().dj(true);
        Log.d("MicroMsg.SubCoreNotification", "onAccountRelease");
        AppMethodBeat.o(26806);
    }

    public static boolean Pv() {
        AppMethodBeat.i(26807);
        boolean z = eyV().ntv;
        AppMethodBeat.o(26807);
        return z;
    }

    public static ArrayList<Long> aJ(ca caVar) {
        AppMethodBeat.i(26808);
        if (caVar == null) {
            AppMethodBeat.o(26808);
            return null;
        }
        bg.aVF();
        com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
        ArrayList<ca> eiK = ((l) g.af(l.class)).eiy().eiK();
        ArrayList<Long> arrayList = new ArrayList<>();
        Iterator<ca> it = eiK.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().field_msgId));
        }
        AppMethodBeat.o(26808);
        return arrayList;
    }
}
