package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.z;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.mm.plugin.appbrand.jsapi.p.ao;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.h;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpClientWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class f implements i {
    static int mScene = 0;
    boolean BaN = false;
    private boolean BaO = false;
    c BaP;
    private a BaQ;
    private IListener BaR = new IListener<aaa>() {
        /* class com.tencent.mm.plugin.product.ui.f.AnonymousClass3 */

        {
            AppMethodBeat.i(160830);
            this.__eventId = aaa.class.getName().hashCode();
            AppMethodBeat.o(160830);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaa aaa) {
            AppMethodBeat.i(66964);
            aaa aaa2 = aaa;
            if (!(aaa2 instanceof aaa)) {
                Log.f("MicroMsg.MallProductUI", "mismatched event");
                AppMethodBeat.o(66964);
                return false;
            } else if (aaa2.egJ.egL) {
                Log.f("MicroMsg.MallProductUI", "WalletPayResultEvent is from kinda, ScanQRCodePay");
                AppMethodBeat.o(66964);
                return false;
            } else {
                if (aaa2.egJ.result != -1) {
                    Log.i("MicroMsg.MallProductUI", "MallProduct pay result : cancel");
                } else if (!f.this.BaO) {
                    Log.i("MicroMsg.MallProductUI", "MallProduct pay result : ok");
                    f.f(f.this);
                    f.this.BaO = true;
                }
                AppMethodBeat.o(66964);
                return true;
            }
        }
    };
    Activity mContext;

    public interface a {
        void D(int i2, int i3, String str);
    }

    static /* synthetic */ void f(f fVar) {
        AppMethodBeat.i(66973);
        fVar.eDC();
        AppMethodBeat.o(66973);
    }

    public f(Activity activity, a aVar) {
        AppMethodBeat.i(66965);
        this.mContext = activity;
        com.tencent.mm.plugin.product.a.a.eDb();
        this.BaP = com.tencent.mm.plugin.product.a.a.eDc();
        this.BaQ = aVar;
        AppMethodBeat.o(66965);
    }

    public final void onStart() {
        AppMethodBeat.i(66966);
        g.aAi();
        g.aAg().hqi.a(553, this);
        g.aAi();
        g.aAg().hqi.a(554, this);
        g.aAi();
        g.aAg().hqi.a(z.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(556, this);
        g.aAi();
        g.aAg().hqi.a(JsApiGetLabInfo.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(578, this);
        g.aAi();
        g.aAg().hqi.a(ao.CTRL_INDEX, this);
        AppMethodBeat.o(66966);
    }

    public final void onStop() {
        AppMethodBeat.i(66967);
        g.aAi();
        g.aAg().hqi.b(553, this);
        g.aAi();
        g.aAg().hqi.b(554, this);
        g.aAi();
        g.aAg().hqi.b(z.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(556, this);
        g.aAi();
        g.aAg().hqi.b(JsApiGetLabInfo.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(578, this);
        g.aAi();
        g.aAg().hqi.b(ao.CTRL_INDEX, this);
        AppMethodBeat.o(66967);
    }

    public final void eDB() {
        AppMethodBeat.i(66968);
        m mVar = this.BaP.AYX;
        cz czVar = new cz();
        anb anb = new anb();
        anh anh = new anh();
        ana ana = new ana();
        anh.bhf(com.tencent.mm.model.z.aTY());
        anh.bhg(com.tencent.mm.model.z.aTY());
        anh.ajm(11);
        anh.MA(Util.nowMilliSecond());
        ana.bgY(mVar.AZB.name);
        ana.bgZ(this.BaP.eDv());
        ana.ajj(mVar.AZy);
        ana.bhb(this.BaP.a(mVar));
        ana.bha(mVar.eDx());
        czVar.dFZ.title = mVar.AZB.name;
        czVar.dFZ.desc = this.BaP.eDv();
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 11;
        anb.a(anh);
        anb.b(ana);
        czVar.dFZ.activity = this.mContext;
        czVar.dFZ.dGf = 5;
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(66968);
    }

    private void eDC() {
        AppMethodBeat.i(66969);
        d eDd = com.tencent.mm.plugin.product.a.a.eDb().eDd();
        dki eDj = this.BaP.eDj();
        if (eDj != null && !Util.isNullOrNil(eDj.xKd) && !eDj.xKd.contains(";")) {
            eDd.AZp.remove(eDj.xKd);
            eDd.AZp.add(eDj.xKd);
            eDd.eDw();
        }
        Intent intent = new Intent(this.mContext, MallProductUI.class);
        intent.putExtra("key_go_finish", true);
        intent.addFlags(67108864);
        Activity activity = this.mContext;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/product/ui/MallProductHelper", "doSuccessFinish", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(66969);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(66970);
        Log.d("MicroMsg.MallProductUI", "errCode: " + i3 + ", errMsg: " + str);
        if (i2 != 0 || i3 != 0) {
            switch (i3) {
                case -10010003:
                    Log.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
                    if (qVar instanceof h) {
                        h hVar = (h) qVar;
                        this.BaP.a(hVar.AZt, hVar.AZu);
                        if (this.BaQ != null) {
                            this.BaQ.D(i2, i3, str);
                        }
                        AppMethodBeat.o(66970);
                        return;
                    }
                    break;
                default:
                    Log.i("MicroMsg.MallProductUI", "unkown errCode ".concat(String.valueOf(i3)));
                    if (Util.isNullOrNil(str)) {
                        str = i3 + " : " + this.mContext.getString(R.string.ewn);
                    }
                    if (this.BaQ != null) {
                        this.BaQ.D(i2, i3, str);
                        break;
                    }
                    break;
            }
        } else if (qVar instanceof h) {
            h hVar2 = (h) qVar;
            this.BaP.a(hVar2.AZt, hVar2.AZu);
            if (this.BaQ != null) {
                this.BaQ.D(i2, i3, str);
            }
            if (!Util.isNullOrNil(hVar2.AZt.AZx)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11007, this.BaP.eDk(), hVar2.AZt.AZx, Integer.valueOf(mScene), 1);
                AppMethodBeat.o(66970);
                return;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11007, this.BaP.eDk(), hVar2.AZs, Integer.valueOf(mScene), 1);
            AppMethodBeat.o(66970);
            return;
        } else if (qVar instanceof j) {
            j jVar = (j) qVar;
            c cVar = this.BaP;
            String str2 = jVar.AYZ;
            LinkedList<akg> linkedList = jVar.AZk;
            LinkedList<bd> linkedList2 = jVar.AZl;
            cVar.AYZ = str2;
            cVar.AZl = linkedList2;
            cVar.AZk = linkedList;
            cVar.Ut(0);
            Activity activity = this.mContext;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this.mContext, MallProductSubmitUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/product/ui/MallProductHelper", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11009, this.BaP.eDk(), this.BaP.AYX.AZx, Integer.valueOf(mScene), 1);
            AppMethodBeat.o(66970);
            return;
        } else if (!(qVar instanceof com.tencent.mm.plugin.product.b.f)) {
            if (qVar instanceof l) {
                String str3 = ((l) qVar).AZw;
                int i4 = 6;
                if (mScene == 7) {
                    i4 = 1001;
                }
                Log.d("MicroMsg.MallProductUI", "payScene:".concat(String.valueOf(i4)));
                com.tencent.mm.pluginsdk.wallet.f.a(this.mContext, str3, this.BaP.getAppId(), i4, 3);
                EventCenter.instance.addListener(this.BaR);
                AppMethodBeat.o(66970);
                return;
            } else if (qVar instanceof k) {
                com.tencent.mm.ui.base.h.cD(this.mContext, this.mContext.getString(R.string.ex6));
                eDC();
                AppMethodBeat.o(66970);
                return;
            } else if (qVar instanceof com.tencent.mm.plugin.product.b.g) {
                try {
                    this.mContext.dismissDialog(HttpClientWrapper.RET_CODE_PROTOCOL);
                } catch (Exception e2) {
                    Log.e("MicroMsg.MallProductUI", e2.toString());
                }
                c cVar2 = this.BaP;
                cVar2.AZk = ((com.tencent.mm.plugin.product.b.g) qVar).AZk;
                cVar2.Ut(0);
                AppMethodBeat.o(66970);
                return;
            } else if (qVar instanceof com.tencent.mm.plugin.product.b.i) {
                try {
                    this.mContext.dismissDialog(HttpClientWrapper.RET_CODE_PROTOCOL);
                } catch (Exception e3) {
                    Log.e("MicroMsg.MallProductUI", e3.toString());
                }
                com.tencent.mm.plugin.product.b.i iVar = (com.tencent.mm.plugin.product.b.i) qVar;
                c cVar3 = this.BaP;
                String str4 = iVar.mUrl;
                LinkedList<ahl> linkedList3 = iVar.AZv;
                if (!Util.isNullOrNil(str4) && linkedList3 != null && linkedList3.size() > 0) {
                    if (cVar3.AZo == null) {
                        cVar3.AZo = new HashMap();
                    }
                    cVar3.AZo.put(str4, linkedList3);
                }
                if (this.BaQ != null) {
                    this.BaQ.D(i2, i3, str);
                }
                AppMethodBeat.o(66970);
                return;
            }
        }
        AppMethodBeat.o(66970);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        AppMethodBeat.i(66971);
        switch (i2) {
            case 1:
                if (i3 == -1 && intent != null) {
                    this.BaP.aO(intent);
                    if (this.BaQ != null) {
                        this.BaQ.D(0, 0, "");
                    }
                    g.aAi();
                    t tVar = g.aAg().hqi;
                    c cVar = this.BaP;
                    if (cVar.AYX != null) {
                        str = cVar.AYX.AZx;
                    } else {
                        str = "";
                    }
                    tVar.a(new com.tencent.mm.plugin.product.b.g(str, this.BaP.AYZ, this.BaP.AZd), 0);
                    AppMethodBeat.o(66971);
                    return;
                }
            case 2:
                if (i3 == -1 && intent != null) {
                    this.BaP.aO(intent);
                    g.aAi();
                    g.aAg().hqi.a(new j(this.BaP.eDr(), mScene), 0);
                    break;
                }
            case 3:
                aaa aaa = new aaa();
                aaa.egJ.result = i2;
                aaa.egJ.intent = intent;
                this.BaR.callback(aaa);
                AppMethodBeat.o(66971);
                return;
            case 4:
                if (this.BaQ != null) {
                    this.BaQ.D(0, 0, "");
                    AppMethodBeat.o(66971);
                    return;
                }
                break;
            case 10000:
                this.mContext.showDialog(HttpClientWrapper.RET_CODE_PROTOCOL);
                g.aAi();
                g.aAg().hqi.a(new com.tencent.mm.plugin.product.b.i(this.BaP.AYZ, this.BaP.AZg), 0);
                AppMethodBeat.o(66971);
                return;
        }
        AppMethodBeat.o(66971);
    }

    static /* synthetic */ int a(f fVar, Intent intent, m mVar) {
        AppMethodBeat.i(66972);
        mScene = intent.getIntExtra("key_product_scene", 3);
        String stringExtra = intent.getStringExtra("key_product_info");
        String stringExtra2 = intent.getStringExtra("key_product_id");
        String stringExtra3 = intent.getStringExtra("key_source_url");
        c cVar = fVar.BaP;
        if (!Util.isNullOrNil(stringExtra3)) {
            cVar.AZa = stringExtra3;
        }
        int i2 = -2;
        Log.i("MicroMsg.MallProductUI", "Scene : " + mScene);
        switch (mScene) {
            case 1:
            case 2:
            case 4:
                if (!Util.isNullOrNil(stringExtra)) {
                    mVar = m.b(mVar, stringExtra);
                    if (mVar == null) {
                        i2 = -1;
                        break;
                    } else {
                        fVar.BaP.a(mVar, (List<n>) null);
                        stringExtra2 = mVar.AZx;
                        i2 = 0;
                        break;
                    }
                }
                break;
            case 3:
                if (!Util.isNullOrNil(stringExtra)) {
                    mVar = m.a(mVar, stringExtra);
                    if (mVar == null) {
                        i2 = -1;
                        break;
                    } else {
                        fVar.BaP.a(mVar, (List<n>) null);
                        stringExtra2 = mVar.AZx;
                        i2 = 0;
                        break;
                    }
                }
                break;
        }
        if (!Util.isNullOrNil(stringExtra2)) {
            g.aAi();
            g.aAg().hqi.a(new h(mVar, stringExtra2), 0);
        } else {
            i2 = -1;
        }
        AppMethodBeat.o(66972);
        return i2;
    }
}
