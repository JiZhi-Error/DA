package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.wallet_core.d;
import java.util.HashMap;

public class a implements bd {
    private d.a Ipd;
    private IListener<dg> Ipe = new IListener<dg>() {
        /* class com.tencent.mm.plugin.wallet_ecard.a.AnonymousClass1 */

        {
            AppMethodBeat.i(160892);
            this.__eventId = dg.class.getName().hashCode();
            AppMethodBeat.o(160892);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dg dgVar) {
            AppMethodBeat.i(71675);
            boolean a2 = a(dgVar);
            AppMethodBeat.o(71675);
            return a2;
        }

        private boolean a(final dg dgVar) {
            String[] split;
            AppMethodBeat.i(71674);
            final dg.a aVar = dgVar.dGm;
            HashMap hashMap = new HashMap();
            if (!Util.isNullOrNil(aVar.packageExt) && (split = aVar.packageExt.split("&")) != null && split.length > 0) {
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!Util.isNullOrNil(split[i2])) {
                        String[] split2 = split[i2].split("=");
                        if (split2.length == 2 && !Util.isNullOrNil(split2[0])) {
                            hashMap.put(split2[0], split2[1]);
                        }
                    }
                }
            }
            final String str = (String) hashMap.get("extradata");
            Log.i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", str, hashMap);
            com.tencent.mm.plugin.wallet_core.c.d dVar = new com.tencent.mm.plugin.wallet_core.c.d(aVar.appId, aVar.dmc, aVar.nonceStr, aVar.packageExt, aVar.signType, aVar.signature, aVar.dGo, 15, "openECard", aVar.payChannel);
            g.aAi();
            g.aAg().hqi.a(580, new i() {
                /* class com.tencent.mm.plugin.wallet_ecard.a.AnonymousClass1.AnonymousClass1 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(71673);
                    g.aAi();
                    g.aAg().hqi.b(580, this);
                    if (i2 == 0 && i3 == 0) {
                        Log.i("MicroMsg.SubCoreECard", "jsapi check success");
                        e.bfP(((com.tencent.mm.plugin.wallet_core.c.d) qVar).fPP());
                        Context context = (Context) aVar.aWF.get();
                        if (context == null || !(context instanceof Activity)) {
                            dgVar.dGn.retCode = -1;
                            dgVar.dGm.callback.run();
                            AppMethodBeat.o(71673);
                            return;
                        }
                        a.this.Ipd = new C1924a(dgVar);
                        b.a(Util.getInt(dgVar.dGm.dGq, 0), dgVar.dGm.token, dgVar.dGm.dGp, str, context, a.this.Ipd);
                        AppMethodBeat.o(71673);
                        return;
                    }
                    Log.e("MicroMsg.SubCoreECard", "jsapi check fail");
                    dgVar.dGn.retCode = -1;
                    dgVar.dGm.callback.run();
                    AppMethodBeat.o(71673);
                }
            });
            g.aAi();
            g.aAg().hqi.a(dVar, 0);
            AppMethodBeat.o(71674);
            return false;
        }
    };
    private IListener<ou> Ipf = new IListener<ou>() {
        /* class com.tencent.mm.plugin.wallet_ecard.a.AnonymousClass2 */

        {
            AppMethodBeat.i(160893);
            this.__eventId = ou.class.getName().hashCode();
            AppMethodBeat.o(160893);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ou ouVar) {
            AppMethodBeat.i(71676);
            ou ouVar2 = ouVar;
            int i2 = 1;
            if (ouVar2.dUO.scene > 0) {
                i2 = ouVar2.dUO.scene;
            }
            Context context = (Context) ouVar2.dUO.aWF.get();
            if (context != null) {
                b.a(i2, (String) null, "WEB_DEBIT", (String) null, context, (d.a) null);
            }
            AppMethodBeat.o(71676);
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(71678);
        AppMethodBeat.o(71678);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.a$a  reason: collision with other inner class name */
    class C1924a implements d.a {
        private dg Ipl;

        public C1924a(dg dgVar) {
            this.Ipl = dgVar;
        }

        @Override // com.tencent.mm.wallet_core.d.a
        public final Intent q(int i2, Bundle bundle) {
            AppMethodBeat.i(71677);
            Log.i("MicroMsg.SubCoreECard", "open process end: %s", Integer.valueOf(i2));
            if (i2 == -1) {
                this.Ipl.dGn.retCode = 0;
                h.INSTANCE.a(14954, e.gsR(), "openEcard:ok");
            } else {
                this.Ipl.dGn.retCode = -1;
                if (!e.gsQ()) {
                    h.INSTANCE.a(14954, e.gsR(), "openEcard:fail");
                }
            }
            this.Ipl.dGm.callback.run();
            if (!e.gsQ()) {
                e.gsS();
            }
            a.this.Ipd = null;
            Intent intent = new Intent();
            intent.putExtras(bundle);
            AppMethodBeat.o(71677);
            return intent;
        }
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(71679);
        this.Ipe.alive();
        this.Ipf.alive();
        AppMethodBeat.o(71679);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(71680);
        this.Ipe.dead();
        this.Ipf.dead();
        AppMethodBeat.o(71680);
    }
}
