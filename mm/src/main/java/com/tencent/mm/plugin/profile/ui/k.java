package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.api.m;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.gb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;

public final class k implements com.tencent.mm.pluginsdk.b.a {
    private CheckBoxPreference BfA;
    private a BfB = null;
    private CheckBoxPreference Bfz;
    final Context mContext;
    private f nRm;
    as rjX = null;

    public k(Context context) {
        this.mContext = context;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        AppMethodBeat.i(231872);
        Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onAttach");
        this.nRm = fVar;
        this.rjX = asVar;
        fVar.addPreferencesFromResource(R.xml.a6);
        this.Bfz = (CheckBoxPreference) fVar.bmg("contact_info_mini_shop_helper_top");
        this.BfA = (CheckBoxPreference) fVar.bmg("contact_info_mini_shop_helper_not_disturb");
        eEy();
        AppMethodBeat.o(231872);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(231873);
        Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onDetach");
        AppMethodBeat.o(231873);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        int i2;
        int i3 = 2;
        AppMethodBeat.i(231874);
        Log.i("MicroMsg.ContactWidgetMiniShopHelper", "handleEvent, key: ".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.o(231874);
            return false;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2027998924:
                if (str.equals("contact_info_mini_shop_helper_go_to")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1521942243:
                if (str.equals("contact_info_mini_shop_helper_install")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1450872065:
                if (str.equals("contact_info_mini_shop_helper_help")) {
                    c2 = 4;
                    break;
                }
                break;
            case -788100886:
                if (str.equals("contact_info_mini_shop_helper_my")) {
                    c2 = 1;
                    break;
                }
                break;
            case 154744730:
                if (str.equals("contact_info_mini_shop_helper_clear_data")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1338682839:
                if (str.equals("contact_info_mini_shop_helper_top")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1342712804:
                if (str.equals("contact_info_mini_shop_helper_uninstall")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1848846101:
                if (str.equals("contact_info_mini_shop_helper_not_disturb")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                Intent intent = new Intent();
                intent.putExtra("Chat_User", this.rjX.field_username);
                intent.putExtra("finish_direct", true);
                c.f(this.mContext, ".ui.chatting.ChattingUI", intent);
                eEz().er(1, 1);
                AppMethodBeat.o(231874);
                return true;
            case 1:
                r rVar = (r) g.af(r.class);
                if (rVar == null) {
                    Log.w("MicroMsg.ContactWidgetMiniShopHelper", "gotoMyMiniShop, weAppLauncher is null");
                } else {
                    com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                    gVar.appId = "wx4aedf8c9edf9fd72";
                    gVar.kHw = "/common/pages/index/index.html";
                    gVar.scene = 1165;
                    rVar.a(this.mContext, gVar);
                    eEz().er(2, 1);
                }
                AppMethodBeat.o(231874);
                return true;
            case 2:
                boolean isChecked = this.Bfz.isChecked();
                a eEz = eEz();
                if (isChecked) {
                    i2 = 2;
                } else {
                    i2 = 3;
                }
                eEz.er(3, i2);
                if (isChecked) {
                    ab.E(this.rjX.field_username, true);
                } else {
                    ab.F(this.rjX.field_username, true);
                }
                AppMethodBeat.o(231874);
                return true;
            case 3:
                boolean isChecked2 = this.BfA.isChecked();
                a eEz2 = eEz();
                if (!isChecked2) {
                    i3 = 3;
                }
                eEz2.er(4, i3);
                if (isChecked2) {
                    ab.z(this.rjX);
                } else {
                    ab.A(this.rjX);
                }
                AppMethodBeat.o(231874);
                return true;
            case 4:
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", ((b) g.af(b.class)).a(b.a.clicfg_minishop_plugin_helpcenter, "https://developers.weixin.qq.com/community/minihome/article/doc/000000208c8018662cda04cf35b813"));
                intent2.putExtra("showShare", true);
                intent2.putExtra("allow_mix_content_mode", false);
                c.b(this.mContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
                eEz().er(5, 1);
                AppMethodBeat.o(231874);
                return true;
            case 5:
                h.c(this.mContext, this.mContext.getString(R.string.ba3), "", this.mContext.getString(R.string.t2), this.mContext.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.k.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(231867);
                        com.tencent.f.h.RTc.aX(new Runnable() {
                            /* class com.tencent.mm.plugin.profile.ui.k.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(231866);
                                k.this.eEz().er(6, 1);
                                ((l) g.af(l.class)).eiy().aEE("gh_579db1f2cf89");
                                AppMethodBeat.o(231866);
                            }
                        });
                        AppMethodBeat.o(231867);
                    }
                }, null);
                AppMethodBeat.o(231874);
                return true;
            case 6:
                Context context = this.mContext;
                this.mContext.getString(R.string.zb);
                final q a2 = h.a(context, this.mContext.getString(R.string.gst), true, (DialogInterface.OnCancelListener) null);
                a2.show();
                g.azz().a(30, new i() {
                    /* class com.tencent.mm.plugin.profile.ui.k.AnonymousClass2 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                        com.tencent.mm.api.c cVar;
                        AppMethodBeat.i(231868);
                        Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onSceneEnd, errType: %d, errCode: %d, errMsg: %s, scene: %d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
                        if (qVar instanceof p) {
                            g.azz().b(30, this);
                            if (i2 == 0 && i3 == 0) {
                                String gmD = ((p) qVar).gmD();
                                Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onSceneEnd, respUsername: ".concat(String.valueOf(gmD)));
                                as Kn = ((l) g.af(l.class)).aSN().Kn("gh_579db1f2cf89");
                                if (Kn == null || Util.isNullOrNil(gmD)) {
                                    Log.e("MicroMsg.ContactWidgetMiniShopHelper", "updateContact, contact: %s, respUsername: %s", Kn, gmD);
                                } else {
                                    if (ab.IR(Kn.field_username)) {
                                        String nullAsNil = Util.nullAsNil(Kn.field_username);
                                        cVar = ((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).fJ(nullAsNil);
                                        if (cVar == null) {
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
                                        Log.e("MicroMsg.ContactWidgetMiniShopHelper", "updateContact, insert contact fail");
                                    } else {
                                        ab.B(Kn);
                                        as Kn2 = ((l) g.af(l.class)).aSN().Kn(Kn.field_username);
                                        if (cVar != null) {
                                            ((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).b(cVar);
                                        } else {
                                            com.tencent.mm.api.c fJ = ((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).fJ(Kn2.field_username);
                                            if (fJ == null || fJ.Uz()) {
                                                Log.i("MicroMsg.ContactWidgetMiniShopHelper", "updateBizInfoInNeed, shouldUpdate");
                                                ay.a.iDq.aL(Kn2.field_username, "");
                                                com.tencent.mm.aj.c.Mf(Kn2.field_username);
                                            } else if (Kn2.gBQ()) {
                                                Log.i("MicroMsg.ContactWidgetMiniShopHelper", "updateBizInfoInNeed, last check time:" + Kn2.fuP);
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
                                Log.w("MicroMsg.ContactWidgetMiniShopHelper", "onSceneEnd, fail");
                                if (4 == i2 && -24 == i3 && !Util.isNullOrNil(str)) {
                                    Toast.makeText(MMApplicationContext.getContext(), str, 1).show();
                                }
                            }
                            a2.dismiss();
                            k.this.eEy();
                        }
                        AppMethodBeat.o(231868);
                    }
                });
                ArrayList arrayList = new ArrayList();
                arrayList.add("gh_579db1f2cf89");
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(1);
                g.azz().a(new p(arrayList, arrayList2, "", ""), 0);
                AppMethodBeat.o(231874);
                return true;
            case 7:
                h.c(this.mContext, this.mContext.getString(R.string.gsw), "", this.mContext.getString(R.string.t2), this.mContext.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.k.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(231869);
                        ((m) g.af(m.class)).a(((com.tencent.mm.api.p) g.af(com.tencent.mm.api.p.class)).fJ(k.this.rjX.field_username), (Activity) k.this.mContext, k.this.rjX);
                        k.this.eEy();
                        AppMethodBeat.o(231869);
                    }
                }, null);
                AppMethodBeat.o(231874);
                return true;
            default:
                AppMethodBeat.o(231874);
                return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    /* access modifiers changed from: package-private */
    public final void eEy() {
        AppMethodBeat.i(231875);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.nRm.bmg("contact_info_mini_shop_helper_header_helper");
        helperHeaderPreference.bk(this.rjX.field_username, this.rjX.arI(), this.mContext.getString(R.string.bcy));
        if (com.tencent.mm.contact.c.oR(this.rjX.field_type)) {
            helperHeaderPreference.updateStatus(1);
            this.nRm.m38do("contact_info_mini_shop_helper_install", true);
            this.nRm.m38do("contact_info_mini_shop_helper_uninstall", false);
            this.nRm.m38do("contact_info_mini_shop_helper_go_to", false);
            this.nRm.m38do("contact_info_mini_shop_helper_my", false);
            this.nRm.m38do("contact_info_mini_shop_helper_top", false);
            this.nRm.m38do("contact_info_mini_shop_helper_not_disturb", false);
            this.nRm.m38do("contact_info_mini_shop_helper_help", false);
            this.nRm.m38do("contact_info_mini_shop_helper_clear_data", false);
            this.Bfz.setChecked(((l) g.af(l.class)).aST().bkg(this.rjX.field_username));
            this.BfA.setChecked(this.rjX.Zx());
            AppMethodBeat.o(231875);
            return;
        }
        helperHeaderPreference.updateStatus(0);
        this.nRm.m38do("contact_info_mini_shop_helper_install", false);
        this.nRm.m38do("contact_info_mini_shop_helper_uninstall", true);
        this.nRm.m38do("contact_info_mini_shop_helper_go_to", true);
        this.nRm.m38do("contact_info_mini_shop_helper_my", true);
        this.nRm.m38do("contact_info_mini_shop_helper_top", true);
        this.nRm.m38do("contact_info_mini_shop_helper_not_disturb", true);
        this.nRm.m38do("contact_info_mini_shop_helper_help", true);
        this.nRm.m38do("contact_info_mini_shop_helper_clear_data", true);
        AppMethodBeat.o(231875);
    }

    /* access modifiers changed from: package-private */
    public final a eEz() {
        AppMethodBeat.i(231876);
        if (this.BfB == null) {
            this.BfB = new a((byte) 0);
        }
        a aVar = this.BfB;
        AppMethodBeat.o(231876);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private final gb BfE;

        private a() {
            AppMethodBeat.i(231870);
            this.BfE = new gb();
            AppMethodBeat.o(231870);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void er(int i2, int i3) {
            AppMethodBeat.i(231871);
            gb gbVar = this.BfE;
            gbVar.eIs = (long) i2;
            gbVar.eIt = (long) i3;
            gbVar.bfK();
            AppMethodBeat.o(231871);
        }
    }
}
