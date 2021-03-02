package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.aa;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.m;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.ne;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements i, com.tencent.mm.pluginsdk.b.a {
    private List<Preference> HKF = new ArrayList();
    private CheckBoxPreference IcE;
    as contact;
    Context context;
    private q nUq;
    private CheckBoxPreference qNs;
    private f screen;

    public a(Context context2) {
        AppMethodBeat.i(214225);
        this.context = context2;
        AppMethodBeat.o(214225);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        AppMethodBeat.i(214226);
        this.screen = fVar;
        this.contact = asVar;
        fVar.addPreferencesFromResource(R.xml.am);
        this.IcE = (CheckBoxPreference) fVar.bmg("contact_info_wxpay_collection_top");
        this.qNs = (CheckBoxPreference) fVar.bmg("contact_info_wxpay_collection_not_disturb");
        cCt();
        a(fSu());
        g.azz().a(2860, this);
        g.azz().a(new k(), 0);
        AppMethodBeat.o(214226);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(214227);
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "handleEvent key:%s", str);
        if (Util.isEqual("contact_info_wxpay_collection_go_to", str)) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", this.contact.field_username);
            intent.putExtra("finish_direct", true);
            c.f(this.context, ".ui.chatting.ChattingUI", intent);
            xV(3);
        } else if (Util.isEqual("contact_info_wxpay_collection_top", str)) {
            if (this.IcE.isChecked()) {
                ab.E(this.contact.field_username, true);
                xV(4);
            } else {
                ab.F(this.contact.field_username, true);
                xV(5);
            }
        } else if (Util.isEqual("contact_info_wxpay_collection_not_disturb", str)) {
            if (this.qNs.isChecked()) {
                ab.z(this.contact);
                xV(6);
            } else {
                ab.A(this.contact);
                xV(7);
            }
        } else if (Util.isEqual("contact_info_wxpay_collection_help", str)) {
            com.tencent.mm.wallet_core.ui.f.u("gh_106decc2eec5@app", "/pages/product/productInfo/product.html?code=A4075&producttitle=收款小账本&scene_id=kf5662", 0, 1165);
            xV(8);
        } else if (Util.isEqual("contact_info_wxpay_collection_clear_data", str)) {
            h.c(this.context, this.context.getString(R.string.ba3), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(214219);
                    com.tencent.f.h.RTc.aX(new Runnable() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.a.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(214218);
                            Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "clear record");
                            ((l) g.af(l.class)).eiy().aEE("gh_f0a92aa7146c");
                            AppMethodBeat.o(214218);
                        }
                    });
                    a.xV(9);
                    AppMethodBeat.o(214219);
                }
            }, null);
        } else if (Util.isEqual("contact_info_wxpay_collection_install", str)) {
            Context context2 = this.context;
            this.context.getString(R.string.zb);
            this.nUq = h.a(context2, this.context.getString(R.string.gst), true, (DialogInterface.OnCancelListener) null);
            this.nUq.show();
            g.azz().a(30, this);
            LinkedList linkedList = new LinkedList();
            linkedList.add("gh_f0a92aa7146c");
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(1);
            g.azz().a(new p(linkedList, linkedList2, "", ""), 0);
            g.aAg().hqi.a(new aa(new aa.a<aa>() {
                /* class com.tencent.mm.plugin.wallet_core.ui.a.AnonymousClass5 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
                @Override // com.tencent.mm.al.aa.a
                public final /* synthetic */ void a(int i2, int i3, String str, aa aaVar) {
                    JSONObject jSONObject;
                    AppMethodBeat.i(214224);
                    aa aaVar2 = aaVar;
                    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "onSceneEnd errType = " + i2 + ", errCode = " + i3 + ",errMsg = " + str);
                    if (i2 == 0 && i3 == 0) {
                        btv bab = aaVar2.bab();
                        if (bab == null) {
                            Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "resp is null.");
                            AppMethodBeat.o(214224);
                            return;
                        }
                        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "resp : %s", bab.MaE);
                        com.tencent.mm.api.c MT = ag.bah().MT(a.this.contact.field_username);
                        try {
                            if (Util.isNullOrNil(MT.field_extInfo)) {
                                jSONObject = new JSONObject();
                            } else {
                                jSONObject = new JSONObject(MT.field_extInfo);
                            }
                        } catch (Exception e2) {
                            Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "create Json object from extInfo error. %s.", e2);
                            jSONObject = new JSONObject();
                        }
                        try {
                            jSONObject.put("MMBizMenu", bab.MaE);
                        } catch (JSONException e3) {
                            Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "updateExtInfoAttrs MMBizMenu failed：value(%s), exception : %s.", bab.MaE, e3);
                        }
                        MT.field_extInfo = jSONObject.toString();
                        ag.bah().h(MT);
                        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "Update bizInfo attributes successfully.");
                        AppMethodBeat.o(214224);
                        return;
                    }
                    Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "scene.getType() = %s", Integer.valueOf(aaVar2.getType()));
                    AppMethodBeat.o(214224);
                }
            }), 0);
            xV(11);
        } else if (Util.isEqual("contact_info_wxpay_collection_uninstall", str)) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.a.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(214220);
                    ((m) g.af(m.class)).a(((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).fJ(a.this.contact.field_username), (Activity) a.this.context, a.this.contact);
                    a.this.cCt();
                    a.this.fSv();
                    a.b(null);
                    a.xV(10);
                    AppMethodBeat.o(214220);
                }
            }, null);
        }
        AppMethodBeat.o(214227);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void cCt() {
        AppMethodBeat.i(214228);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.bhu));
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "contact.getUsername():%s", this.contact.field_username);
        if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            helperHeaderPreference.updateStatus(1);
            this.screen.m38do("contact_info_wxpay_collection_install", true);
            this.screen.m38do("contact_info_wxpay_collection_uninstall", false);
            this.screen.m38do("contact_info_wxpay_collection_go_to", false);
            this.screen.m38do("contact_info_wxpay_collection_top", false);
            this.screen.m38do("contact_info_wxpay_collection_not_disturb", false);
            this.screen.m38do("contact_info_wxpay_collection_help", false);
            this.screen.m38do("contact_info_wxpay_collection_clear_data", false);
            if (((l) g.af(l.class)).aST().bkg(this.contact.field_username)) {
                this.IcE.setChecked(true);
            } else {
                this.IcE.setChecked(false);
            }
            if (this.contact.Zx()) {
                this.qNs.setChecked(true);
                AppMethodBeat.o(214228);
                return;
            }
            this.qNs.setChecked(false);
            AppMethodBeat.o(214228);
            return;
        }
        helperHeaderPreference.updateStatus(0);
        this.screen.m38do("contact_info_wxpay_collection_install", false);
        this.screen.m38do("contact_info_wxpay_collection_uninstall", true);
        this.screen.m38do("contact_info_wxpay_collection_go_to", true);
        this.screen.m38do("contact_info_wxpay_collection_top", true);
        this.screen.m38do("contact_info_wxpay_collection_not_disturb", true);
        this.screen.m38do("contact_info_wxpay_collection_help", true);
        this.screen.m38do("contact_info_wxpay_collection_clear_data", true);
        AppMethodBeat.o(214228);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        btx btx;
        com.tencent.mm.api.c cVar;
        AppMethodBeat.i(214229);
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (qVar instanceof p) {
            g.azz().b(30, this);
            if (i2 == 0 && i3 == 0) {
                String gmD = ((p) qVar).gmD();
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "bind fitness contact %s success", gmD);
                as Kn = ((l) g.af(l.class)).aSN().Kn("gh_f0a92aa7146c");
                if (Kn == null || Util.isNullOrNil(gmD)) {
                    Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "respUsername == " + gmD + ", contact = " + Kn);
                } else {
                    if (ab.IR(Kn.field_username)) {
                        String nullAsNil = Util.nullAsNil(Kn.field_username);
                        cVar = ((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).fJ(nullAsNil);
                        if (cVar != null) {
                            cVar.field_username = gmD;
                        }
                        ((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).fK(nullAsNil);
                        Kn.BK(nullAsNil);
                    } else {
                        cVar = null;
                    }
                    Kn.setUsername(gmD);
                    if (((int) Kn.gMZ) == 0) {
                        ((l) g.af(l.class)).aSN().aq(Kn);
                    }
                    if (((int) Kn.gMZ) <= 0) {
                        Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "addContact : insert contact failed");
                    } else {
                        ab.B(Kn);
                        as Kn2 = ((l) g.af(l.class)).aSN().Kn(Kn.field_username);
                        if (cVar != null) {
                            ((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).b(cVar);
                        } else {
                            com.tencent.mm.api.c fJ = ((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).fJ(Kn2.field_username);
                            if (fJ == null || fJ.Uz()) {
                                Log.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "shouldUpdate");
                                ay.a.iDq.aL(Kn2.field_username, "");
                                com.tencent.mm.aj.c.Mf(Kn2.field_username);
                            } else if (Kn2.gBQ()) {
                                Log.d("MicroMsg.WxPay.ContactWidgetWxPayCollection", "update contact, last check time=%d", Integer.valueOf(Kn2.fuP));
                                ay.a.iDq.aL(Kn2.field_username, "");
                                com.tencent.mm.aj.c.Mf(Kn2.field_username);
                            }
                        }
                    }
                }
                com.tencent.mm.api.c fJ2 = ((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).fJ(Kn.field_username);
                if (fJ2 != null) {
                    ((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).a(fJ2);
                }
                g.aAh().azQ().set(327825, Boolean.TRUE);
            } else {
                Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
                    Toast.makeText(MMApplicationContext.getContext(), str, 1).show();
                }
            }
            if (this.nUq != null) {
                this.nUq.dismiss();
            }
            cCt();
            AppMethodBeat.o(214229);
            return;
        }
        if (qVar instanceof k) {
            g.azz().b(2860, this);
            if (i2 == 0 && i3 == 0) {
                k kVar = (k) qVar;
                if (kVar.HPJ == null) {
                    btx = new btx();
                } else {
                    btx = kVar.HPJ;
                }
                a(btx);
                b(btx);
                AppMethodBeat.o(214229);
                return;
            }
            Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin fail!");
        }
        AppMethodBeat.o(214229);
    }

    static void xV(int i2) {
        AppMethodBeat.i(214230);
        ne neVar = new ne();
        neVar.eXG = (long) i2;
        neVar.bfK();
        AppMethodBeat.o(214230);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    private void a(btx btx) {
        AppMethodBeat.i(214231);
        if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            fSv();
            AppMethodBeat.o(214231);
            return;
        }
        fSv();
        if (btx == null || btx.MaF == null || btx.MaF.MaA == null || btx.MaF.MaA.isEmpty()) {
            Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "NetSceneGetPayPlugin no data");
            AppMethodBeat.o(214231);
            return;
        }
        int indexOf = this.screen.indexOf("contact_info_wxpay_collection_go_to");
        Iterator<cdv> it = btx.MaF.MaA.iterator();
        int i2 = indexOf;
        while (it.hasNext()) {
            cdv next = it.next();
            if (next.Mjq.isEmpty()) {
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "ItemSectionViewData is null");
            } else {
                int i3 = i2 + 1;
                PreferenceSmallCategory preferenceSmallCategory = new PreferenceSmallCategory(this.context);
                this.screen.a(preferenceSmallCategory, i3);
                this.HKF.add(preferenceSmallCategory);
                Iterator<egf> it2 = next.Mjq.iterator();
                while (it2.hasNext()) {
                    egf next2 = it2.next();
                    if (next2.Ngf.isEmpty() || next2.Ngg.isEmpty()) {
                        Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData data null");
                    } else {
                        final ehf ehf = next2.Ngf.get(0);
                        ehf ehf2 = next2.Ngg.get(0);
                        final dqe dqe = next2.KEP;
                        if (ehf.NgT.isEmpty() || Util.isNullOrNil(ehf.NgT.get(0).text) || dqe == null) {
                            Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "TableCellViewData inner data null");
                        } else {
                            i3++;
                            AnonymousClass3 r7 = new Preference(this.context) {
                                /* class com.tencent.mm.plugin.wallet_core.ui.a.AnonymousClass3 */

                                @Override // com.tencent.mm.ui.base.preference.Preference
                                public final void onBindView(View view) {
                                    AppMethodBeat.i(214222);
                                    super.onBindView(view);
                                    if (this.OZp != null) {
                                        view.setOnClickListener(new View.OnClickListener() {
                                            /* class com.tencent.mm.plugin.wallet_core.ui.a.AnonymousClass3.AnonymousClass1 */

                                            public final void onClick(View view) {
                                                AppMethodBeat.i(214221);
                                                b bVar = new b();
                                                bVar.bm(view);
                                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayCollection$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                                AnonymousClass3.this.OZp.a(null);
                                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayCollection$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                                AppMethodBeat.o(214221);
                                            }
                                        });
                                    }
                                    AppMethodBeat.o(214222);
                                }
                            };
                            r7.setTitle(ehf.NgT.get(0).text);
                            r7.setLayoutResource(R.layout.b8j);
                            if (!ehf2.NgT.isEmpty() && !Util.isNullOrNil(ehf2.NgT.get(0).text)) {
                                r7.setSummary(ehf2.NgT.get(0).text);
                            }
                            this.screen.a(r7, i3);
                            this.HKF.add(r7);
                            r7.OZp = new Preference.b() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.a.AnonymousClass4 */

                                @Override // com.tencent.mm.ui.base.preference.Preference.b
                                public final boolean a(Preference preference) {
                                    AppMethodBeat.i(214223);
                                    Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "text(%s) click!", ehf.NgT.get(0).text);
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("key_tiny_app_scene", 1165);
                                    com.tencent.mm.plugin.wallet_core.utils.g.a(a.this.context, dqe, bundle);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(19541, 1, ehf.NgT.get(0).text);
                                    AppMethodBeat.o(214223);
                                    return true;
                                }
                            };
                        }
                    }
                }
                i2 = i3;
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(214231);
    }

    static void b(btx btx) {
        String str;
        AppMethodBeat.i(214232);
        if (!(btx == null || btx.MaF == null || btx.MaF.MaA == null || btx.MaF.MaA.isEmpty())) {
            try {
                str = new String(btx.toByteArray(), KindaConfigCacheStg.SAVE_CHARSET);
            } catch (IOException e2) {
                Log.e("MicroMsg.WxPay.ContactWidgetWxPayCollection", "save config exp, " + e2.getLocalizedMessage());
            }
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WX_PAY_REVEIVE_PLUGIN_CONFIG_STRING_SYNC, str);
            g.aAi();
            g.aAh().azQ().gBI();
            AppMethodBeat.o(214232);
        }
        str = " ";
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WX_PAY_REVEIVE_PLUGIN_CONFIG_STRING_SYNC, str);
        g.aAi();
        g.aAh().azQ().gBI();
        AppMethodBeat.o(214232);
    }

    private static btx fSu() {
        AppMethodBeat.i(214233);
        btx btx = new btx();
        g.aAi();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WX_PAY_REVEIVE_PLUGIN_CONFIG_STRING_SYNC, (Object) null);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.WxPay.ContactWidgetWxPayCollection", "etReceiptAssisPluginResponse failed");
        } else {
            try {
                btx.parseFrom(str.getBytes(KindaConfigCacheStg.SAVE_CHARSET));
            } catch (Exception e2) {
                Log.w("MicroMsg.WxPay.ContactWidgetWxPayCollection", "parseConfig exp, " + e2.getLocalizedMessage());
            }
        }
        AppMethodBeat.o(214233);
        return btx;
    }

    /* access modifiers changed from: package-private */
    public final void fSv() {
        AppMethodBeat.i(214234);
        if (this.HKF != null && this.HKF.size() > 0) {
            for (Preference preference : this.HKF) {
                this.screen.e(preference);
            }
            this.screen.notifyDataSetChanged();
            this.HKF.clear();
        }
        AppMethodBeat.o(214234);
    }
}
