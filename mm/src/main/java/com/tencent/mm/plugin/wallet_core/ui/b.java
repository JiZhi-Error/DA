package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.api.m;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.nf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import java.util.Iterator;
import java.util.LinkedList;

public final class b implements i, a {
    private static final String IcK = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_product.html?scene_id=kf1");
    private CheckBoxPreference IcE;
    private as contact;
    private Context context;
    private q nUq;
    private CheckBoxPreference qNs;
    private f screen;

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(214236);
        bVar.cCt();
        AppMethodBeat.o(214236);
    }

    static {
        AppMethodBeat.i(214237);
        AppMethodBeat.o(214237);
    }

    public b(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        AppMethodBeat.i(70640);
        this.screen = fVar;
        this.contact = asVar;
        fVar.addPreferencesFromResource(R.xml.an);
        this.IcE = (CheckBoxPreference) fVar.bmg("contact_info_wxpay_notify_top");
        this.qNs = (CheckBoxPreference) fVar.bmg("contact_info_wxpay_notify_not_disturb");
        cCt();
        g.azz().a(1820, this);
        g.azz().a(new com.tencent.mm.plugin.wallet_core.c.i(), 0);
        AppMethodBeat.o(70640);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(70641);
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "handleEvent key:%s", str);
        if (Util.isEqual("contact_info_wxpay_notify_go_to", str)) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", this.contact.field_username);
            intent.putExtra("finish_direct", true);
            c.f(this.context, ".ui.chatting.ChattingUI", intent);
        } else if (Util.isEqual("contact_info_wxpay_notify_top", str)) {
            if (this.IcE.isChecked()) {
                ab.E(this.contact.field_username, true);
                xV(3);
            } else {
                ab.F(this.contact.field_username, true);
                xV(4);
            }
        } else if (Util.isEqual("contact_info_wxpay_notify_not_disturb", str)) {
            if (this.qNs.isChecked()) {
                ab.z(this.contact);
                xV(5);
            } else {
                ab.A(this.contact);
                xV(6);
            }
        } else if (Util.isEqual("contact_info_wxpay_notify_help", str)) {
            com.tencent.mm.wallet_core.ui.f.bn(this.context, IcK);
            xV(7);
        } else if (Util.isEqual("contact_info_wxpay_notify_clear_data", str)) {
            h.c(this.context, this.context.getString(R.string.ba3), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.b.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(70635);
                    ((l) g.af(l.class)).eiy().aEE("gh_3dfda90e39d6");
                    AppMethodBeat.o(70635);
                }
            }, null);
            xV(8);
        } else if (Util.isEqual("contact_info_wxpay_notify_install", str)) {
            Context context2 = this.context;
            this.context.getString(R.string.zb);
            this.nUq = h.a(context2, this.context.getString(R.string.gst), true, (DialogInterface.OnCancelListener) null);
            this.nUq.show();
            g.azz().a(30, this);
            LinkedList linkedList = new LinkedList();
            linkedList.add("gh_3dfda90e39d6");
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(1);
            g.azz().a(new p(linkedList, linkedList2, "", ""), 0);
            xV(10);
        } else if (Util.isEqual("contact_info_wxpay_notify_uninstall", str)) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.b.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(70636);
                    ((m) g.af(m.class)).a(((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).fJ(b.this.contact.field_username), (Activity) b.this.context, b.this.contact);
                    b.c(b.this);
                    AppMethodBeat.o(70636);
                }
            }, null);
            xV(9);
        }
        AppMethodBeat.o(70641);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    private void cCt() {
        AppMethodBeat.i(70642);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.bhz));
        if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            helperHeaderPreference.updateStatus(1);
            this.screen.m38do("contact_info_wxpay_notify_install", true);
            this.screen.m38do("contact_info_wxpay_notify_uninstall", false);
            this.screen.m38do("contact_info_wxpay_notify_go_to", false);
            this.screen.m38do("contact_info_wxpay_notify_top", false);
            this.screen.m38do("contact_info_wxpay_notify_not_disturb", false);
            this.screen.m38do("contact_info_wxpay_notify_help", false);
            this.screen.m38do("contact_info_wxpay_notify_clear_data", false);
            if (((l) g.af(l.class)).aST().bkg(this.contact.field_username)) {
                this.IcE.setChecked(true);
            } else {
                this.IcE.setChecked(false);
            }
            if (this.contact.Zx()) {
                this.qNs.setChecked(true);
                AppMethodBeat.o(70642);
                return;
            }
            this.qNs.setChecked(false);
            AppMethodBeat.o(70642);
            return;
        }
        helperHeaderPreference.updateStatus(0);
        this.screen.m38do("contact_info_wxpay_notify_install", false);
        this.screen.m38do("contact_info_wxpay_notify_uninstall", true);
        this.screen.m38do("contact_info_wxpay_notify_go_to", true);
        this.screen.m38do("contact_info_wxpay_notify_top", true);
        this.screen.m38do("contact_info_wxpay_notify_not_disturb", true);
        this.screen.m38do("contact_info_wxpay_notify_help", true);
        this.screen.m38do("contact_info_wxpay_notify_clear_data", true);
        AppMethodBeat.o(70642);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        dap dap;
        com.tencent.mm.api.c cVar;
        AppMethodBeat.i(70643);
        Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (qVar instanceof p) {
            g.azz().b(30, this);
            if (i2 == 0 && i3 == 0) {
                String gmD = ((p) qVar).gmD();
                Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "bind fitness contact %s success", gmD);
                as Kn = ((l) g.af(l.class)).aSN().Kn("gh_3dfda90e39d6");
                if (Kn == null || Util.isNullOrNil(gmD)) {
                    Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "respUsername == " + gmD + ", contact = " + Kn);
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
                        Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "addContact : insert contact failed");
                    } else {
                        ab.B(Kn);
                        as Kn2 = ((l) g.af(l.class)).aSN().Kn(Kn.field_username);
                        if (cVar != null) {
                            ((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).b(cVar);
                        } else {
                            com.tencent.mm.api.c fJ = ((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).fJ(Kn2.field_username);
                            if (fJ == null || fJ.Uz()) {
                                Log.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "shouldUpdate");
                                ay.a.iDq.aL(Kn2.field_username, "");
                                com.tencent.mm.aj.c.Mf(Kn2.field_username);
                            } else if (Kn2.gBQ()) {
                                Log.d("MicroMsg.WxPay.ContactWidgetWxPayNotify", "update contact, last check time=%d", Integer.valueOf(Kn2.fuP));
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
                Log.e("MicroMsg.WxPay.ContactWidgetWxPayNotify", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
                    Toast.makeText(MMApplicationContext.getContext(), str, 1).show();
                }
            }
            if (this.nUq != null) {
                this.nUq.dismiss();
            }
            cCt();
            AppMethodBeat.o(70643);
            return;
        }
        if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.i) {
            g.azz().b(1820, this);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.wallet_core.c.i iVar = (com.tencent.mm.plugin.wallet_core.c.i) qVar;
                if (iVar.HPG == null) {
                    dap = new dap();
                } else {
                    dap = iVar.HPG;
                }
                if (dap == null || dap.MaF == null || dap.MaF.MaA == null || dap.MaF.MaA.isEmpty()) {
                    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin no data");
                    AppMethodBeat.o(70643);
                    return;
                }
                int indexOf = this.screen.indexOf("contact_info_wxpay_notify_clear_data");
                Iterator<cdv> it = dap.MaF.MaA.iterator();
                while (it.hasNext()) {
                    cdv next = it.next();
                    if (next.Mjq.isEmpty()) {
                        Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "ItemSectionViewData is null");
                    } else {
                        int i4 = indexOf + 1;
                        this.screen.a(new PreferenceSmallCategory(this.context), i4);
                        Iterator<egf> it2 = next.Mjq.iterator();
                        indexOf = i4;
                        while (it2.hasNext()) {
                            egf next2 = it2.next();
                            if (next2.Ngf.isEmpty() || next2.Ngg.isEmpty()) {
                                Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData data null");
                            } else {
                                final ehf ehf = next2.Ngf.get(0);
                                ehf ehf2 = next2.Ngg.get(0);
                                final dqe dqe = next2.KEP;
                                if (ehf.NgT.isEmpty() || Util.isNullOrNil(ehf.NgT.get(0).text) || dqe == null) {
                                    Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "TableCellViewData inner data null");
                                } else {
                                    indexOf++;
                                    AnonymousClass3 r7 = new Preference(this.context) {
                                        /* class com.tencent.mm.plugin.wallet_core.ui.b.AnonymousClass3 */

                                        @Override // com.tencent.mm.ui.base.preference.Preference
                                        public final void onBindView(View view) {
                                            AppMethodBeat.i(70638);
                                            super.onBindView(view);
                                            if (this.OZp != null) {
                                                view.setOnClickListener(new View.OnClickListener() {
                                                    /* class com.tencent.mm.plugin.wallet_core.ui.b.AnonymousClass3.AnonymousClass1 */

                                                    public final void onClick(View view) {
                                                        AppMethodBeat.i(70637);
                                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                                        bVar.bm(view);
                                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayNotify$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                                        AnonymousClass3.this.OZp.a(null);
                                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ContactWidgetWxPayNotify$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                                        AppMethodBeat.o(70637);
                                                    }
                                                });
                                            }
                                            AppMethodBeat.o(70638);
                                        }
                                    };
                                    r7.setTitle(ehf.NgT.get(0).text);
                                    r7.setLayoutResource(R.layout.b8j);
                                    if (!ehf2.NgT.isEmpty() && !Util.isNullOrNil(ehf2.NgT.get(0).text)) {
                                        r7.setSummary(ehf2.NgT.get(0).text);
                                    }
                                    this.screen.a(r7, indexOf);
                                    r7.OZp = new Preference.b() {
                                        /* class com.tencent.mm.plugin.wallet_core.ui.b.AnonymousClass4 */

                                        @Override // com.tencent.mm.ui.base.preference.Preference.b
                                        public final boolean a(Preference preference) {
                                            AppMethodBeat.i(214235);
                                            Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "text(%s) click!", ehf.NgT.get(0).text);
                                            Bundle bundle = new Bundle();
                                            bundle.putInt("key_tiny_app_scene", 1000);
                                            com.tencent.mm.plugin.wallet_core.utils.g.a(b.this.context, dqe, bundle);
                                            AppMethodBeat.o(214235);
                                            return true;
                                        }
                                    };
                                }
                            }
                        }
                    }
                }
                this.screen.notifyDataSetChanged();
                AppMethodBeat.o(70643);
                return;
            }
            Log.i("MicroMsg.WxPay.ContactWidgetWxPayNotify", "NetSceneGetPayPlugin fail!");
        }
        AppMethodBeat.o(70643);
    }

    private static void xV(int i2) {
        AppMethodBeat.i(70644);
        nf nfVar = new nf();
        nfVar.eXG = (long) i2;
        nfVar.bfK();
        AppMethodBeat.o(70644);
    }
}
