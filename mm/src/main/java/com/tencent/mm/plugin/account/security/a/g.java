package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class g implements bd {
    private static HashMap<Integer, h.b> kiQ;
    private e kiP;
    private IListener kiR = new IListener<yo>() {
        /* class com.tencent.mm.plugin.account.security.a.g.AnonymousClass2 */

        {
            AppMethodBeat.i(161759);
            this.__eventId = yo.class.getName().hashCode();
            AppMethodBeat.o(161759);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yo yoVar) {
            AppMethodBeat.i(125531);
            boolean a2 = a(yoVar);
            AppMethodBeat.o(125531);
            return a2;
        }

        private static boolean a(yo yoVar) {
            AppMethodBeat.i(125530);
            f.p(yoVar.eeN.eeO, yoVar.eeN.eeP);
            AppMethodBeat.o(125530);
            return false;
        }
    };
    private IListener kiS = new IListener<ka>() {
        /* class com.tencent.mm.plugin.account.security.a.g.AnonymousClass3 */

        {
            AppMethodBeat.i(161760);
            this.__eventId = ka.class.getName().hashCode();
            AppMethodBeat.o(161760);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ka kaVar) {
            AppMethodBeat.i(125532);
            ka kaVar2 = kaVar;
            kaVar2.dOW.dOX = f.dD(kaVar2.dOV.context);
            AppMethodBeat.o(125532);
            return false;
        }
    };
    private IListener kiT = new IListener<kb>() {
        /* class com.tencent.mm.plugin.account.security.a.g.AnonymousClass4 */

        {
            AppMethodBeat.i(161761);
            this.__eventId = kb.class.getName().hashCode();
            AppMethodBeat.o(161761);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kb kbVar) {
            AppMethodBeat.i(125533);
            kbVar.dOY.dOZ = f.boP();
            AppMethodBeat.o(125533);
            return false;
        }
    };

    public g() {
        AppMethodBeat.i(125534);
        AppMethodBeat.o(125534);
    }

    private static synchronized g boQ() {
        g gVar;
        synchronized (g.class) {
            AppMethodBeat.i(125535);
            gVar = (g) y.at(g.class);
            AppMethodBeat.o(125535);
        }
        return gVar;
    }

    public static e boR() {
        AppMethodBeat.i(125536);
        com.tencent.mm.kernel.g.aAf().azk();
        if (boQ().kiP == null) {
            boQ().kiP = new e(com.tencent.mm.kernel.g.aAh().hqK);
        }
        e eVar = boQ().kiP;
        AppMethodBeat.o(125536);
        return eVar;
    }

    static {
        AppMethodBeat.i(125539);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        kiQ = hashMap;
        hashMap.put(Integer.valueOf("SAFE_DEVICE_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.account.security.a.g.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return e.SQL_CREATE;
            }
        });
        AppMethodBeat.o(125539);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return kiQ;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(125537);
        EventCenter.instance.addListener(this.kiR);
        EventCenter.instance.addListener(this.kiS);
        EventCenter.instance.addListener(this.kiT);
        AppMethodBeat.o(125537);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(125538);
        EventCenter.instance.removeListener(this.kiR);
        EventCenter.instance.removeListener(this.kiS);
        EventCenter.instance.removeListener(this.kiT);
        AppMethodBeat.o(125538);
    }
}
