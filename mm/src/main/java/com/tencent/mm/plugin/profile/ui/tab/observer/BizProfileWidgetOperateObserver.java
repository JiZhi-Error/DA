package com.tencent.mm.plugin.profile.ui.tab.observer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.g;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.j;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.e;
import java.util.Map;

public class BizProfileWidgetOperateObserver extends BaseBizProfileOperateObserver {
    private ContactInfoUI BiT;
    private ph BiU;
    private boolean BiZ = true;
    private int kgm;

    public BizProfileWidgetOperateObserver(ContactInfoUI contactInfoUI) {
        this.BiT = contactInfoUI;
    }

    @Override // com.tencent.mm.plugin.profile.ui.tab.observer.IBizProfileOperateObserver, com.tencent.mm.plugin.profile.ui.tab.observer.BaseBizProfileOperateObserver
    public final boolean a(f fVar, final as asVar) {
        AppMethodBeat.i(232015);
        if (this.BiZ) {
            this.BiZ = false;
            this.BiT.setMMTitle(Util.nullAsNil(asVar.field_nickname));
            this.BiT.setMMTitleColor(0);
            this.BiT.setTitleDividerVis(false);
            this.BiT.setIsDarkActionbarBg(false);
            this.BiT.setActionbarColor(this.BiT.getResources().getColor(R.color.f3045c));
            this.BiT.hideActionbarLine();
            this.BiT.setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver.AnonymousClass1 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(232009);
                    BizProfileWidgetOperateObserver.this.BiT.onBackPressed();
                    AppMethodBeat.o(232009);
                    return true;
                }
            }, R.raw.actionbar_icon_dark_back);
            this.BiT.removeAllOptionMenu();
            this.BiT.addIconOptionMenu(1, R.string.hpa, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(232010);
                    BizProfileWidgetOperateObserver.a(BizProfileWidgetOperateObserver.this, asVar);
                    AppMethodBeat.o(232010);
                    return true;
                }
            });
            this.BiT.addIconOptionMenu(0, "", R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver.AnonymousClass3 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(232014);
                    e eVar = new e((Context) BizProfileWidgetOperateObserver.this.BiT, 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(232012);
                            if (c.oR(asVar.field_type)) {
                                if (asVar.arE()) {
                                    if (!ab.clc() || !g.Nd(asVar.field_username)) {
                                        mVar.kV(5, R.string.euv);
                                    } else {
                                        mVar.kV(5, R.string.b_l);
                                    }
                                } else if (!ab.clc() || !g.Nd(asVar.field_username)) {
                                    mVar.kV(4, R.string.bh2);
                                } else {
                                    mVar.kV(4, R.string.b_h);
                                }
                            } else if (((int) asVar.gMZ) <= 0) {
                                ay.a.iDq.a(asVar.field_username, "", new ay.b.a() {
                                    /* class com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.mm.model.ay.b.a
                                    public final void p(String str, boolean z) {
                                        AppMethodBeat.i(232011);
                                        Log.i("MicroMsg.ContactWidgetTabBizInfo.UI", "onCreateMMMenu Fetch Contact username:%s, succ: %b", str, Boolean.valueOf(z));
                                        AppMethodBeat.o(232011);
                                    }
                                });
                            }
                            mVar.kV(2, R.string.bf6);
                            mVar.kV(6, R.string.ay8);
                            if (c.oR(asVar.field_type)) {
                                mVar.kV(3, R.string.b_w);
                            }
                            AppMethodBeat.o(232012);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.profile.ui.tab.observer.BizProfileWidgetOperateObserver.AnonymousClass3.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(232013);
                            switch (menuItem.getItemId()) {
                                case 2:
                                    BizProfileWidgetOperateObserver.b(BizProfileWidgetOperateObserver.this, asVar);
                                    AppMethodBeat.o(232013);
                                    return;
                                case 3:
                                    BizProfileWidgetOperateObserver.c(BizProfileWidgetOperateObserver.this, asVar);
                                    AppMethodBeat.o(232013);
                                    return;
                                case 4:
                                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(asVar.field_username, 903, BizProfileWidgetOperateObserver.this.kgm, BizProfileWidgetOperateObserver.this.enterTime);
                                    j.HO(asVar.field_username);
                                    BizProfileWidgetOperateObserver.ad(asVar);
                                    if (!ab.clc() || g.Nb(asVar.field_username)) {
                                        h.cD(BizProfileWidgetOperateObserver.this.BiT, BizProfileWidgetOperateObserver.this.BiT.getString(R.string.euw));
                                        AppMethodBeat.o(232013);
                                        return;
                                    }
                                case 5:
                                    com.tencent.mm.model.ab.F(asVar.field_username, true);
                                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(asVar.field_username, 904, BizProfileWidgetOperateObserver.this.kgm, BizProfileWidgetOperateObserver.this.enterTime);
                                    BizProfileWidgetOperateObserver.ad(asVar);
                                    if (!ab.clc() || g.Nb(asVar.field_username)) {
                                        h.cD(BizProfileWidgetOperateObserver.this.BiT, BizProfileWidgetOperateObserver.this.BiT.getString(R.string.aj0));
                                        AppMethodBeat.o(232013);
                                        return;
                                    }
                                case 6:
                                    BizProfileWidgetOperateObserver.d(BizProfileWidgetOperateObserver.this, asVar);
                                    AppMethodBeat.o(232013);
                                    return;
                                default:
                                    Log.w("MicroMsg.ContactWidgetTabBizInfo.UI", "default onMMMenuItemSelected err");
                                    break;
                            }
                            AppMethodBeat.o(232013);
                        }
                    };
                    eVar.dGm();
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(asVar.field_username, 600, BizProfileWidgetOperateObserver.this.kgm, BizProfileWidgetOperateObserver.this.enterTime);
                    AppMethodBeat.o(232014);
                    return false;
                }
            });
            this.BiU = a.aKy(asVar.field_username);
            com.tencent.mm.api.c fJ = g.fJ(asVar.field_username);
            this.dhu = null;
            this.dhv = null;
            this.BeW = null;
            if ((fJ == null || fJ.cG(false) == null) && this.BeX != null) {
                fJ = new com.tencent.mm.api.c();
                fJ.field_username = asVar.field_username;
                fJ.field_brandFlag = this.BeX.kem;
                fJ.field_brandIconURL = this.BeX.kep;
                fJ.field_brandInfo = this.BeX.keo;
                fJ.field_extInfo = this.BeX.ken;
                fJ.field_type = fJ.cG(false).getServiceType();
            }
            if (fJ != null && fJ.field_brandInfo == null && fJ.field_extInfo == null && this.BeX != null) {
                fJ.field_username = asVar.field_username;
                fJ.field_brandFlag = this.BeX.kem;
                fJ.field_brandIconURL = this.BeX.kep;
                fJ.field_brandInfo = this.BeX.keo;
                fJ.field_extInfo = this.BeX.ken;
                fJ.field_type = fJ.cG(false).getServiceType();
            }
            if (fJ != null) {
                this.Bdk = fJ;
                this.dhu = fJ.UO();
                this.dhv = fJ.cG(false);
                this.BeW = this.dhv.getWxaEntryInfoList();
                if (this.dhv.US() != null && this.dhv.US().length() > 0) {
                    this.dhE = this.dhv.US();
                }
            }
            String stringExtra = this.BiT.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
            if (!Util.isNullOrNil(stringExtra)) {
                this.BiT.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
                h.a(this.BiT, stringExtra, "", this.BiT.getString(R.string.x_), (DialogInterface.OnClickListener) null);
            }
        }
        AppMethodBeat.o(232015);
        return false;
    }

    static /* synthetic */ void a(BizProfileWidgetOperateObserver bizProfileWidgetOperateObserver, as asVar) {
        AppMethodBeat.i(232016);
        String str = asVar.field_username;
        Intent fXX = ai.fXX();
        fXX.putExtra("ftsneedkeyboard", true);
        fXX.putExtra("ftsbizscene", 19);
        fXX.putExtra("ftsType", 2);
        Map<String, String> h2 = ai.h(19, false, 2);
        h2.put("userName", str);
        if (!Util.isNullOrNil(bizProfileWidgetOperateObserver.BiU.KWn)) {
            h2.put("thirdExtParam", bizProfileWidgetOperateObserver.BiU.KWn);
        }
        fXX.putExtra("rawUrl", ai.bd(h2));
        fXX.putExtra("key_load_js_without_delay", true);
        fXX.putExtra("ftsbizusername", str);
        fXX.putExtra(e.p.OzF, 13307);
        fXX.putStringArrayListExtra(e.p.OzG, com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.fd(str, bizProfileWidgetOperateObserver.kgm));
        fXX.addFlags(67108864);
        com.tencent.mm.br.c.b(bizProfileWidgetOperateObserver.BiT, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(str, 1301, bizProfileWidgetOperateObserver.enterTime);
        AppMethodBeat.o(232016);
    }

    static /* synthetic */ void b(BizProfileWidgetOperateObserver bizProfileWidgetOperateObserver, as asVar) {
        AppMethodBeat.i(232017);
        Intent intent = new Intent();
        intent.putExtra("Select_Talker_Name", asVar.field_username);
        intent.putExtra("Select_block_List", asVar.field_username);
        intent.putExtra("Select_Send_Card", true);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", true);
        b.jRt.a(intent, 1, bizProfileWidgetOperateObserver.BiT);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(asVar.field_username, 800, bizProfileWidgetOperateObserver.kgm, bizProfileWidgetOperateObserver.enterTime);
        AppMethodBeat.o(232017);
    }

    static /* synthetic */ void c(BizProfileWidgetOperateObserver bizProfileWidgetOperateObserver, as asVar) {
        AppMethodBeat.i(232018);
        Intent intent = new Intent();
        intent.setClass(bizProfileWidgetOperateObserver.BiT, NewBizInfoSettingUI.class);
        intent.putExtra("Contact_User", asVar.field_username);
        intent.putExtra("key_start_biz_profile_setting_from_scene", 2);
        intent.putExtra("key_profile_enter_timestamp", bizProfileWidgetOperateObserver.enterTime);
        if (bizProfileWidgetOperateObserver.BiT.getIntent() != null) {
            intent.putExtras(bizProfileWidgetOperateObserver.BiT.getIntent());
        }
        ContactInfoUI contactInfoUI = bizProfileWidgetOperateObserver.BiT;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(contactInfoUI, bl.axQ(), "com/tencent/mm/plugin/profile/ui/tab/observer/BizProfileWidgetOperateObserver", "jumpToSettingUI", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        contactInfoUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(contactInfoUI, "com/tencent/mm/plugin/profile/ui/tab/observer/BizProfileWidgetOperateObserver", "jumpToSettingUI", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(232018);
    }

    static /* synthetic */ void ad(as asVar) {
        AppMethodBeat.i(232019);
        ao aoVar = new ao();
        aoVar.dDs.userName = asVar.field_username;
        EventCenter.instance.publish(aoVar);
        AppMethodBeat.o(232019);
    }

    static /* synthetic */ void d(BizProfileWidgetOperateObserver bizProfileWidgetOperateObserver, as asVar) {
        AppMethodBeat.i(232020);
        if (asVar == null || Util.isNullOrNil(asVar.field_username)) {
            AppMethodBeat.o(232020);
            return;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(asVar.field_username, 601, bizProfileWidgetOperateObserver.kgm, bizProfileWidgetOperateObserver.enterTime);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", asVar.field_username));
        intent.putExtra("key_menu_hide_expose", true);
        com.tencent.mm.br.c.b(bizProfileWidgetOperateObserver.BiT, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(232020);
    }
}
