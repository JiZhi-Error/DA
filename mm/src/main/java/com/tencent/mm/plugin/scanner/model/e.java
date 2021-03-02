package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.f.e;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.c;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e {
    String CFr;
    c CFs;
    a CFt;
    e.a CFu = new e.a() {
        /* class com.tencent.mm.plugin.scanner.model.e.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.scanner.f.e.a
        public final void r(int i2, Bundle bundle) {
            AppMethodBeat.i(51612);
            Log.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", Integer.valueOf(i2));
            np npVar = new np();
            npVar.dTL.dTJ = i2;
            npVar.dTL.activity = e.this.mActivity;
            npVar.dTL.dDX = e.this.CFr;
            npVar.dTL.dTM = bundle;
            EventCenter.instance.publish(npVar);
            AppMethodBeat.o(51612);
        }
    };
    public IListener CFv = new IListener<cr>() {
        /* class com.tencent.mm.plugin.scanner.model.e.AnonymousClass2 */

        {
            AppMethodBeat.i(160999);
            this.__eventId = cr.class.getName().hashCode();
            AppMethodBeat.o(160999);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(cr crVar) {
            AppMethodBeat.i(51613);
            cr crVar2 = crVar;
            if (crVar2 == null || !(crVar2 instanceof cr)) {
                Log.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a DealQBarStrEvent instance");
            } else {
                e.this.ePN();
                e.this.CFr = crVar2.dFK.dDX;
                e.this.mActivity = crVar2.dFK.activity;
                Log.i("MicroMsg.ExternRequestDealQBarStrHandler", "request deal qbar, activity:%s, str:%s, codeType %d, codeVersion: %s, from : %d", e.this.mActivity, e.this.CFr, Integer.valueOf(crVar2.dFK.dFL), Integer.valueOf(crVar2.dFK.dFM), Integer.valueOf(crVar2.dFK.from));
                if (crVar2.dFK.dFL == 19 || crVar2.dFK.dFL == 22) {
                    e.this.CFs = new c();
                    e.this.CFs.sourceType = crVar2.dFK.sourceType;
                    e.this.CFs.imagePath = crVar2.dFK.imagePath;
                    e.this.CFs.dFO = crVar2.dFK.dFO;
                    e.this.CFs.source = crVar2.dFK.source;
                    if (!(crVar2.dFK.dFP == null || crVar2.dFK.dFP.getString("stat_send_msg_user") == null)) {
                        e.this.CFs.talker = crVar2.dFK.dFP.getString("stat_send_msg_user");
                    }
                    int i2 = crVar2.dFK.from < 0 ? 2 : 3;
                    if (crVar2.dFK.scene > 0) {
                        e.this.CFs.pHw = crVar2.dFK.scene;
                    }
                    if (i2 == 3) {
                        e.this.CFs.appId = crVar2.dFK.dFN;
                    }
                    e.this.CFs.a(e.this.mActivity, e.this.CFr, i2, "", crVar2.dFK.dFL, crVar2.dFK.dFM, e.this.CFu, null, crVar2.dFK.dFP, 0, false, -1, false);
                } else {
                    e.this.CFt = new a();
                    a aVar = e.this.CFt;
                    Activity activity = e.this.mActivity;
                    e.a aVar2 = e.this.CFu;
                    int i3 = crVar2.dFK.dFL;
                    String str = e.this.CFr;
                    int i4 = crVar2.dFK.dFM;
                    Bundle bundle = crVar2.dFK.dFP;
                    if (!Util.isNullOrNil(str)) {
                        aVar.dKq = activity;
                        aVar.dFP = bundle;
                        aVar.CSZ = aVar2;
                        aVar.CJz = 0;
                        n nVar = new n(i3, str, i4);
                        aVar.eRL();
                        g.azz().a(nVar, 0);
                        aVar.a(activity.getString(R.string.fsp), new c.a(nVar) {
                            /* class com.tencent.mm.plugin.scanner.util.a.AnonymousClass3 */
                            final /* synthetic */ n CTf;

                            {
                                this.CTf = r2;
                            }

                            @Override // com.tencent.mm.plugin.scanner.view.c.a
                            public final void eRN() {
                                AppMethodBeat.i(52021);
                                a.this.eRM();
                                g.azz().a(this.CTf);
                                AppMethodBeat.o(52021);
                            }
                        });
                    }
                }
            }
            AppMethodBeat.o(51613);
            return false;
        }
    };
    public IListener CFw = new IListener<aw>() {
        /* class com.tencent.mm.plugin.scanner.model.e.AnonymousClass3 */

        {
            AppMethodBeat.i(161000);
            this.__eventId = aw.class.getName().hashCode();
            AppMethodBeat.o(161000);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aw awVar) {
            AppMethodBeat.i(51614);
            aw awVar2 = awVar;
            if (awVar2 == null || !(awVar2 instanceof aw)) {
                Log.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a CancelDealQBarStrEvent instance");
                AppMethodBeat.o(51614);
            } else {
                Log.i("MicroMsg.ExternRequestDealQBarStrHandler", "cancel deal qbar, activity:%s, str:%s", e.this.mActivity, e.this.CFr);
                if (awVar2.dDW.activity != e.this.mActivity || !awVar2.dDW.dDX.equals(e.this.CFr)) {
                    Log.e("MicroMsg.ExternRequestDealQBarStrHandler", "not same as string that are dealing");
                    AppMethodBeat.o(51614);
                } else {
                    e.this.ePN();
                    AppMethodBeat.o(51614);
                }
            }
            return false;
        }
    };
    public IListener CFx = new IListener<rl>() {
        /* class com.tencent.mm.plugin.scanner.model.e.AnonymousClass4 */

        {
            AppMethodBeat.i(177783);
            this.__eventId = rl.class.getName().hashCode();
            AppMethodBeat.o(177783);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rl rlVar) {
            AppMethodBeat.i(177784);
            rl rlVar2 = rlVar;
            if (rlVar2 != null && rlVar2.dYc.activity == e.this.mActivity) {
                e.this.mActivity = null;
                if (e.this.CFs != null && e.this.CFs.getContext() == rlVar2.dYc.activity) {
                    Log.d("MicroMsg.ExternRequestDealQBarStrHandler", "alvinluo releaseDealQBarStr set qbarStringHandle activity null");
                    com.tencent.mm.plugin.scanner.util.c cVar = e.this.CFs;
                    if (cVar.mActivityRef != null) {
                        cVar.mActivityRef.clear();
                        cVar.mActivityRef = null;
                    }
                    if (cVar.pqa != null) {
                        cVar.pqa.dismiss();
                    }
                    cVar.pqa = null;
                }
                if (e.this.CFt != null && e.this.CFt.dKq == rlVar2.dYc.activity) {
                    Log.d("MicroMsg.ExternRequestDealQBarStrHandler", "alvinluo releaseDealQBarStr set barCodeStringHandle activity null");
                    a aVar = e.this.CFt;
                    aVar.dKq = null;
                    if (aVar.gtM != null) {
                        aVar.gtM.dismiss();
                    }
                    aVar.gtM = null;
                }
            }
            AppMethodBeat.o(177784);
            return false;
        }
    };
    Activity mActivity;

    public e() {
        AppMethodBeat.i(51615);
        AppMethodBeat.o(51615);
    }

    public final void ePN() {
        AppMethodBeat.i(51616);
        if (this.CFs != null) {
            this.CFs.eRR();
            this.CFs = null;
        }
        this.mActivity = null;
        this.CFr = null;
        AppMethodBeat.o(51616);
    }
}
