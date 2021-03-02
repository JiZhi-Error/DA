package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.af;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.e;
import com.tencent.mm.al.g;
import com.tencent.mm.al.i;
import com.tencent.mm.al.p;
import com.tencent.mm.api.c;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.j;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.dvy;
import com.tencent.mm.protocal.protobuf.dvz;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.protocal.protobuf.fbw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c implements i, i.b, p, a {
    private static final String Bff = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/infringement?username=%s&from=1#wechat_redirect");
    private String BdC;
    private com.tencent.mm.api.c Bdk;
    private boolean Bdx;
    private k BeV;
    private List<WxaAttributes.WxaEntryInfo> BeW;
    private aeq BeX;
    private boolean BeY;
    private boolean BeZ;
    private boolean Bfa;
    private int Bfb;
    private String Bfc;
    private boolean Bfd;
    d Bfe;
    private Bundle Bfg;
    private SnsAdClick Bfh;
    private String Bfi;
    private as contact;
    private boolean dhC;
    private String dhE;
    private List<c.a> dhu;
    private c.b dhv;
    private CheckBoxPreference gtX;
    private MMActivity gte;
    private boolean guh;
    private boolean isDeleteCancel;
    private int kgm;
    private f screen;
    private SharedPreferences sp;
    private q tipDialog;
    String wZz;

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(231855);
        cVar.sF(false);
        AppMethodBeat.o(231855);
    }

    static /* synthetic */ void a(c cVar, int i2) {
        AppMethodBeat.i(231861);
        cVar.bP(i2, null);
        AppMethodBeat.o(231861);
    }

    static /* synthetic */ void a(c cVar, com.tencent.mm.api.c cVar2, boolean z) {
        AppMethodBeat.i(231854);
        cVar.a(cVar2, z);
        AppMethodBeat.o(231854);
    }

    static /* synthetic */ void h(c cVar) {
        AppMethodBeat.i(231858);
        cVar.eEt();
        AppMethodBeat.o(231858);
    }

    static /* synthetic */ void k(c cVar) {
        AppMethodBeat.i(231862);
        cVar.eEr();
        AppMethodBeat.o(231862);
    }

    static {
        AppMethodBeat.i(231863);
        AppMethodBeat.o(231863);
    }

    private c(MMActivity mMActivity) {
        this.BeX = null;
        this.BeY = false;
        this.BeZ = false;
        this.dhC = false;
        this.Bfa = false;
        this.Bfb = 0;
        this.Bfe = null;
        this.sp = null;
        this.Bfh = null;
        this.Bfi = null;
        this.tipDialog = null;
        this.isDeleteCancel = false;
        this.gte = mMActivity;
    }

    public c(MMActivity mMActivity, String str, aeq aeq) {
        this(mMActivity);
        this.BdC = str;
        this.BeX = aeq;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        boolean z;
        boolean z2;
        Preference bmg;
        int i2;
        AppMethodBeat.i(27090);
        if (str == null) {
            AppMethodBeat.o(27090);
            return false;
        } else if (str.equals("contact_info_verifyuser_weibo")) {
            new com.tencent.mm.plugin.profile.ui.a.a(this.gte).jx(this.contact.fuM, this.contact.field_username);
            AppMethodBeat.o(27090);
            return true;
        } else if ("contact_info_biz_go_chatting".endsWith(str)) {
            if (this.Bfh != null) {
                rr rrVar = new rr();
                this.Bfh.jkU = 5;
                rrVar.dYk.dYl = this.Bfh;
                EventCenter.instance.publish(rrVar);
            }
            if (this.Bdk == null || (!this.Bdk.UF() && !this.Bdk.UH())) {
                Intent intent = new Intent();
                if (this.gte.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                    intent.setFlags(268435456);
                }
                if (this.Bdx) {
                    intent.putExtra("Chat_User", this.contact.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    this.gte.setResult(-1, intent);
                } else {
                    intent.putExtra("Chat_User", this.contact.field_username);
                    intent.putExtra("Chat_Mode", 1);
                    intent.putExtra("finish_direct", true);
                    b.jRt.d(intent, this.gte);
                }
            } else {
                Intent intent2 = new Intent();
                if (this.Bdk.UH()) {
                    String UN = this.Bdk.UN();
                    if (Util.isNullOrNil(UN)) {
                        Log.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
                        AppMethodBeat.o(27090);
                        return false;
                    }
                    intent2.putExtra("enterprise_biz_name", UN);
                    intent2.putExtra("enterprise_biz_display_name", aa.getDisplayName(UN));
                } else {
                    intent2.putExtra("enterprise_biz_name", this.contact.field_username);
                    intent2.putExtra("enterprise_biz_display_name", aa.getDisplayName(this.contact.field_username));
                }
                intent2.addFlags(67108864);
                com.tencent.mm.br.c.f(this.gte, ".ui.conversation.EnterpriseConversationUI", intent2);
                this.gte.finish();
            }
            bP(5, null);
            AppMethodBeat.o(27090);
            return true;
        } else if ("contact_info_biz_add".endsWith(str)) {
            if (!com.tencent.mm.model.gdpr.c.aXj()) {
                eEr();
            } else {
                com.tencent.mm.model.gdpr.c.a(this.gte, com.tencent.mm.model.gdpr.a.BIZ, this.contact.field_username, new com.tencent.mm.model.gdpr.b() {
                    /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass4 */

                    @Override // com.tencent.mm.model.gdpr.b
                    public final void sx(int i2) {
                        AppMethodBeat.i(27075);
                        if (i2 == 0) {
                            c.k(c.this);
                        }
                        AppMethodBeat.o(27075);
                    }
                });
            }
            if (this.Bfb != 0) {
                h.INSTANCE.a(11263, Integer.valueOf(this.Bfb), this.contact.field_username);
            }
            AppMethodBeat.o(27090);
            return true;
        } else if ("contact_info_biz_read_msg_online".endsWith(str)) {
            AppMethodBeat.o(27090);
            return true;
        } else if ("contact_info_stick_biz".equals(str)) {
            if (((CheckBoxPreference) this.screen.bmg("contact_info_stick_biz")).isChecked()) {
                h.INSTANCE.a(13307, this.contact.field_username, 1, 1, 0, "", Integer.valueOf(this.kgm));
                j.HO(this.contact.field_username);
            } else {
                ab.F(this.contact.field_username, true);
                h.INSTANCE.a(13307, this.contact.field_username, 1, 2, 0, "", Integer.valueOf(this.kgm));
            }
            AppMethodBeat.o(27090);
            return true;
        } else {
            if ("contact_info_guarantee_info".equals(str) && this.dhv.UY() != null && !Util.isNullOrNil(this.dhv.UY().diy)) {
                Intent intent3 = new Intent();
                intent3.putExtra("rawUrl", this.dhv.UY().diy);
                intent3.putExtra("useJs", true);
                intent3.putExtra("vertical_scroll", true);
                intent3.putExtra("geta8key_scene", 3);
                com.tencent.mm.br.c.b(this.gte, "webview", ".ui.tools.WebViewUI", intent3);
            }
            if (str.startsWith("contact_info_bizinfo_external#") && (i2 = Util.getInt(str.replace("contact_info_bizinfo_external#", ""), -1)) >= 0 && i2 < this.dhu.size()) {
                c.a aVar = this.dhu.get(i2);
                String str2 = aVar.url;
                Intent intent4 = new Intent();
                intent4.putExtra("rawUrl", str2);
                intent4.putExtra("useJs", true);
                intent4.putExtra("vertical_scroll", true);
                intent4.putExtra("geta8key_scene", 3);
                intent4.putExtra("KPublisherId", "brand_profile");
                intent4.putExtra("prePublishId", "brand_profile");
                if ((this.Bfg != null && (this.kgm == 39 || this.kgm == 56 || this.kgm == 35)) || this.kgm == 87 || this.kgm == 89 || this.kgm == 85 || this.kgm == 88) {
                    Log.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("KFromBizSearch", true);
                    bundle.putBundle("KBizSearchExtArgs", this.Bfg);
                    intent4.putExtra("jsapiargs", bundle);
                    int i3 = com.tencent.mm.contact.c.oR(this.contact.field_type) ? 7 : 6;
                    int identifier = this.gte.getResources().getIdentifier(aVar.dhy, "string", this.gte.getPackageName());
                    String str3 = aVar.title;
                    if (identifier > 0) {
                        str3 = this.gte.getString(identifier);
                    }
                    bP(i3, str3);
                }
                com.tencent.mm.br.c.b(this.gte, "webview", ".ui.tools.WebViewUI", intent4);
                AppMethodBeat.o(27090);
                return true;
            } else if ("contact_info_subscribe_bizinfo".endsWith(str) || "contact_info_show_brand".endsWith(str) || "contact_info_locate".endsWith(str)) {
                final com.tencent.mm.api.c cVar = this.Bdk;
                if (cVar == null) {
                    AppMethodBeat.o(27090);
                    return true;
                }
                if ("contact_info_subscribe_bizinfo".endsWith(str)) {
                    if (!cVar.UE()) {
                        if (cVar.Ux()) {
                            cVar.field_brandFlag |= 1;
                            if (this.dhv == null && cVar != null) {
                                this.dhv = cVar.cG(false);
                            }
                            if (this.dhv == null || !this.dhv.UR() || !com.tencent.mm.br.c.aZU("brandservice")) {
                                this.screen.m38do("contact_info_template_recv", true);
                            } else {
                                this.screen.m38do("contact_info_template_recv", false);
                            }
                        } else {
                            cVar.field_brandFlag &= -2;
                            this.screen.m38do("contact_info_template_recv", true);
                        }
                        h hVar = h.INSTANCE;
                        Object[] objArr = new Object[6];
                        objArr[0] = cVar.field_username;
                        objArr[1] = 1;
                        objArr[2] = Integer.valueOf(cVar.Ux() ? 3 : 4);
                        objArr[3] = 0;
                        objArr[4] = "";
                        objArr[5] = Integer.valueOf(this.kgm);
                        hVar.a(13307, objArr);
                    } else if (cVar != null) {
                        if (cVar.UH()) {
                            bg.azz().a(1363, this);
                            final com.tencent.mm.plugin.profile.b.c cVar2 = new com.tencent.mm.plugin.profile.b.c(cVar.field_username, ((CheckBoxPreference) this.screen.bmg("contact_info_subscribe_bizinfo")).isChecked() ? 0 : 4);
                            bg.azz().a(cVar2, 0);
                            MMActivity mMActivity = this.gte;
                            this.gte.getString(R.string.zb);
                            this.tipDialog = com.tencent.mm.ui.base.h.a((Context) mMActivity, this.gte.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass15 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(27085);
                                    bg.azz().a(cVar2);
                                    bg.azz().b(1363, c.this);
                                    AppMethodBeat.o(27085);
                                }
                            });
                        } else if (cVar.UF()) {
                            ag.bar();
                            String str4 = cVar.field_username;
                            if (!((CheckBoxPreference) this.screen.bmg("contact_info_subscribe_bizinfo")).isChecked()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            final af a2 = e.a(str4, z2, this);
                            MMActivity mMActivity2 = this.gte;
                            this.gte.getString(R.string.zb);
                            this.tipDialog = com.tencent.mm.ui.base.h.a((Context) mMActivity2, this.gte.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass16 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(27086);
                                    ag.bar();
                                    e.a(a2);
                                    AppMethodBeat.o(27086);
                                }
                            });
                        }
                    }
                } else if ("contact_info_show_brand".endsWith(str)) {
                    if ((cVar.field_brandFlag & 2) == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        cVar.field_brandFlag |= 2;
                    } else {
                        cVar.field_brandFlag &= -3;
                    }
                } else if ("contact_info_locate".endsWith(str)) {
                    if (cVar.Uy()) {
                        cVar.field_brandFlag &= -5;
                    } else {
                        this.Bfe = com.tencent.mm.ui.base.h.a(this.gte, this.gte.getString(R.string.axr, new Object[]{this.contact.arJ()}), this.gte.getString(R.string.zb), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(27071);
                                cVar.field_hadAlert = 1;
                                cVar.field_brandFlag |= 4;
                                c.a(c.this, cVar, true);
                                AppMethodBeat.o(27071);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass12 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(27082);
                                cVar.field_hadAlert = 1;
                                c.a(c.this, cVar, false);
                                AppMethodBeat.o(27082);
                            }
                        });
                    }
                }
                if (!cVar.UH() && !cVar.UF()) {
                    a(cVar, false);
                }
                AppMethodBeat.o(27090);
                return true;
            } else if ("contact_info_verifyuser".endsWith(str)) {
                if (!ab.Iv(this.contact.field_username) || !WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()) {
                    com.tencent.mm.api.c cVar3 = this.Bdk;
                    if (cVar3 == null) {
                        AppMethodBeat.o(27090);
                        return true;
                    }
                    c.b cG = cVar3.cG(false);
                    if (cG == null) {
                        AppMethodBeat.o(27090);
                        return true;
                    }
                    String str5 = null;
                    if (cG.Va() != null && !Util.isNullOrNil(cG.Va().dit)) {
                        str5 = cG.Va().dit;
                    } else if (cG.Vb() != null && !Util.isNullOrNil(cG.Vb().diB)) {
                        str5 = cG.Vb().diB;
                    }
                    if (!Util.isNullOrNil(str5)) {
                        Intent intent5 = new Intent();
                        intent5.putExtra("rawUrl", str5);
                        intent5.putExtra("useJs", true);
                        intent5.putExtra("vertical_scroll", true);
                        intent5.putExtra("geta8key_scene", 3);
                        com.tencent.mm.br.c.b(this.gte, "webview", ".ui.tools.WebViewUI", intent5);
                    }
                    AppMethodBeat.o(27090);
                    return true;
                }
                AppMethodBeat.o(27090);
                return true;
            } else if ("contact_info_trademark".endsWith(str)) {
                com.tencent.mm.api.c cVar4 = this.Bdk;
                if (cVar4 == null) {
                    AppMethodBeat.o(27090);
                    return true;
                }
                if (cVar4.cG(false) != null && !Util.isNullOrNil(cVar4.cG(false).UT())) {
                    Intent intent6 = new Intent();
                    intent6.putExtra("rawUrl", cVar4.cG(false).UT());
                    intent6.putExtra("useJs", true);
                    intent6.putExtra("vertical_scroll", true);
                    intent6.putExtra("geta8key_scene", 3);
                    com.tencent.mm.br.c.b(this.gte, "webview", ".ui.tools.WebViewUI", intent6);
                }
                AppMethodBeat.o(27090);
                return true;
            } else {
                if ("contact_is_mute".endsWith(str)) {
                    this.guh = !this.guh;
                    if (this.guh) {
                        ab.z(this.contact);
                    } else {
                        ab.A(this.contact);
                    }
                    sG(this.guh);
                }
                if ("enterprise_contact_info_enter".equals(str)) {
                    if (this.gte == null) {
                        Log.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
                    } else if (this.Bdk == null) {
                        Log.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
                    } else {
                        Intent intent7 = new Intent();
                        intent7.putExtra("enterprise_biz_name", this.Bdk.field_username);
                        intent7.addFlags(67108864);
                        com.tencent.mm.br.c.b(this.gte, "brandservice", ".ui.EnterpriseBizContactListUI", intent7);
                    }
                }
                if ("contact_info_biz_disable".equals(str)) {
                    com.tencent.mm.ui.base.h.c(this.gte, this.gte.getString(R.string.bxd), "", this.gte.getString(R.string.bxc), this.gte.getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass13 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(27083);
                            c.a(c.this);
                            AppMethodBeat.o(27083);
                        }
                    }, null);
                }
                if ("contact_info_biz_enable".equals(str)) {
                    sF(true);
                }
                if ("contact_info_template_recv".equals(str)) {
                    Intent intent8 = new Intent();
                    intent8.putExtra("enterprise_biz_name", this.Bdk.field_username);
                    com.tencent.mm.br.c.b(this.gte, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", intent8);
                }
                if ("contact_info_service_phone".equals(str) && (bmg = this.screen.bmg("contact_info_service_phone")) != null && bmg.getSummary() != null && !Util.isNullOrNil(bmg.getSummary().toString())) {
                    final String charSequence = bmg.getSummary().toString();
                    com.tencent.mm.ui.base.h.a((Context) this.gte, true, charSequence, "", this.gte.getString(R.string.baf), this.gte.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(27078);
                            Intent intent = new Intent("android.intent.action.DIAL");
                            intent.setFlags(268435456);
                            intent.setData(Uri.parse(WebView.SCHEME_TEL + charSequence));
                            if (Util.isIntentAvailable(c.this.gte, intent)) {
                                MMActivity mMActivity = c.this.gte;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetBizInfo$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                mMActivity.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/profile/ui/ContactWidgetBizInfo$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            AppMethodBeat.o(27078);
                        }
                    }, (DialogInterface.OnClickListener) null);
                }
                if ("contact_info_expose_btn".equals(str)) {
                    eEt();
                }
                if (str.equals("biz_placed_to_the_top")) {
                    Log.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
                    if (this.sp == null) {
                        this.sp = this.gte.getSharedPreferences(this.gte.getPackageName() + "_preferences", 0);
                    }
                    if (this.contact != null) {
                        if (this.contact.arE()) {
                            Log.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", this.contact.field_username);
                            ab.F(this.contact.field_username, true);
                            this.sp.edit().putBoolean("biz_placed_to_the_top", false).commit();
                        } else {
                            j.HO(this.contact.field_username);
                            Log.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", this.contact.field_username);
                            this.sp.edit().putBoolean("biz_placed_to_the_top", true).commit();
                        }
                    }
                }
                AppMethodBeat.o(27090);
                return true;
            }
        }
    }

    private void sF(boolean z) {
        AppMethodBeat.i(27091);
        final com.tencent.mm.plugin.profile.b.d dVar = new com.tencent.mm.plugin.profile.b.d(this.Bdk.field_username, !z);
        bg.azz().a(1394, this);
        bg.azz().a(dVar, 0);
        MMActivity mMActivity = this.gte;
        this.gte.getString(R.string.zb);
        this.tipDialog = com.tencent.mm.ui.base.h.a((Context) mMActivity, this.gte.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass14 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(27084);
                bg.azz().a(dVar);
                bg.azz().b(1394, c.this);
                AppMethodBeat.o(27084);
            }
        });
        AppMethodBeat.o(27091);
    }

    private void a(com.tencent.mm.api.c cVar, boolean z) {
        AppMethodBeat.i(27092);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("contact_info_subscribe_bizinfo");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.screen.bmg("contact_info_locate");
        cpe cpe = new cpe();
        cpe.kem = cVar.field_brandFlag;
        cpe.UserName = this.contact.field_username;
        if (UL(this.kgm)) {
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new k.a(58, cpe));
        } else {
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new k.a(47, cpe));
        }
        ag.bah().update(cVar, new String[0]);
        checkBoxPreference.setChecked(cVar.Ux());
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setChecked(cVar.Uy());
        }
        if (z) {
            eEp();
        }
        AppMethodBeat.o(27092);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        AppMethodBeat.i(27093);
        if (asVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (Util.nullAsNil(asVar.field_username).length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.assertTrue(z3);
        if (fVar != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assert.assertTrue(z4);
        this.screen = fVar;
        this.contact = asVar;
        this.Bdx = z;
        this.kgm = i2;
        this.Bfb = this.gte.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.Bfh = (SnsAdClick) this.gte.getIntent().getParcelableExtra("KSnsAdTag");
        this.Bfg = this.gte.getIntent().getBundleExtra("Contact_Ext_Args");
        this.Bfi = this.gte.getIntent().getStringExtra("key_add_contact_report_info");
        eEp();
        String stringExtra = this.gte.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!Util.isNullOrNil(stringExtra)) {
            this.gte.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
            com.tencent.mm.ui.base.h.a(this.gte, stringExtra, "", this.gte.getString(R.string.x_), (DialogInterface.OnClickListener) null);
        }
        if (asVar != null) {
            ag.bau().MN(asVar.field_username);
            if (g.Ne(asVar.field_username)) {
                String str = asVar.field_username;
                if (g.DQ(str)) {
                    ag.baq();
                    com.tencent.mm.al.a.h.a(str, this);
                    String UN = g.fJ(str).UN();
                    if (UN != null) {
                        ag.bau().MN(UN);
                    }
                } else if (g.Ng(str)) {
                    ag.bar();
                    e.a(str, this);
                    ag.bah();
                    String MX = com.tencent.mm.al.f.MX(str);
                    if (MX != null) {
                        ag.bau().MN(MX);
                    }
                }
            }
        }
        AppMethodBeat.o(27093);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0776  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x08ef  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x095d  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x09e1  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0a39  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0ca7  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0e1f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0309  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void eEp() {
        /*
        // Method dump skipped, instructions count: 3734
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.c.eEp():void");
    }

    private String UK(int i2) {
        AppMethodBeat.i(27095);
        switch (i2) {
            case 0:
                String string = this.gte.getResources().getString(R.string.bhj);
                AppMethodBeat.o(27095);
                return string;
            case 1:
                String string2 = this.gte.getResources().getString(R.string.am2);
                AppMethodBeat.o(27095);
                return string2;
            case 2:
                String string3 = this.gte.getResources().getString(R.string.am3);
                AppMethodBeat.o(27095);
                return string3;
            default:
                Log.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", Integer.valueOf(i2));
                String string4 = this.gte.getResources().getString(R.string.bbv);
                AppMethodBeat.o(27095);
                return string4;
        }
    }

    private void eEq() {
        AppMethodBeat.i(27096);
        if (this.contact == null || !com.tencent.mm.contact.c.oR(this.contact.field_type) || ab.Jf(this.contact.field_username) || ab.JM(this.contact.field_username)) {
            this.screen.m38do("contact_is_mute", true);
            if (this.contact == null || com.tencent.mm.contact.c.oR(this.contact.field_type) || !UL(this.kgm)) {
                this.screen.m38do("contact_info_expose_btn", true);
            } else {
                this.screen.m38do("contact_info_expose_btn", false);
            }
        } else {
            this.screen.m38do("contact_is_mute", false);
        }
        this.screen.m38do("contact_info_verifyuser_weibo", true);
        this.screen.m38do("contact_info_subscribe_bizinfo", true);
        this.screen.m38do("contact_info_template_recv", true);
        this.screen.m38do("contact_info_locate", true);
        if (!this.BeY) {
            this.screen.m38do("contact_info_time_expired", true);
        } else {
            this.screen.m38do("contact_info_biz_add", true);
        }
        if (this.contact == null || ((!ab.JA(this.contact.field_username) && !ab.JM(this.contact.field_username)) || !com.tencent.mm.contact.c.oR(this.contact.field_type))) {
            this.screen.m38do("contact_info_biz_go_chatting", true);
        } else {
            this.screen.m38do("contact_info_biz_go_chatting", false);
        }
        if (ab.JM(this.contact.field_username)) {
            this.screen.m38do("contact_info_user_desc", true);
        }
        AppMethodBeat.o(27096);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27097);
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.screen.bmg("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference != null) {
            bizInfoHeaderPreference.onDetach();
        }
        AppMethodBeat.o(27097);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(27098);
        if (this.gte == null) {
            Log.e("MicroMsg.ContactWidgetBizInfo", "null == context");
            AppMethodBeat.o(27098);
            return;
        }
        Log.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i2) {
            case 1:
                if (i3 != -1 || intent == null) {
                    AppMethodBeat.o(27098);
                    return;
                }
                String stringExtra = intent.getStringExtra("be_send_card_name");
                String stringExtra2 = intent.getStringExtra("received_card_name");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                String stringExtra3 = intent.getStringExtra("custom_send_text");
                com.tencent.mm.plugin.messenger.a.g.eir().s(stringExtra, stringExtra2, booleanExtra);
                com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra3, stringExtra2);
                com.tencent.mm.ui.widget.snackbar.b.r(this.gte, this.gte.getString(R.string.dc_));
                AppMethodBeat.o(27098);
                return;
            default:
                AppMethodBeat.o(27098);
                return;
        }
    }

    private static boolean aKp(String str) {
        AppMethodBeat.i(27099);
        try {
            long j2 = Util.getLong(str, 0);
            if (j2 <= 0 || j2 - (System.currentTimeMillis() / 1000) >= 0) {
                AppMethodBeat.o(27099);
                return false;
            }
            AppMethodBeat.o(27099);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(27099);
            return false;
        }
    }

    private void bP(int i2, String str) {
        int i3;
        String str2;
        AppMethodBeat.i(27100);
        if (this.Bfg == null || !(this.kgm == 39 || this.kgm == 56 || this.kgm == 35 || this.kgm == 87 || this.kgm == 88 || this.kgm == 89 || this.kgm == 85)) {
            Log.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
            AppMethodBeat.o(27100);
        } else if (this.contact == null) {
            Log.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
            AppMethodBeat.o(27100);
        } else {
            String string = this.Bfg.getString("Contact_Ext_Args_Search_Id");
            String nullAsNil = Util.nullAsNil(this.Bfg.getString("Contact_Ext_Args_Query_String"));
            int i4 = this.Bfg.getInt("Contact_Ext_Args_Index");
            switch (this.kgm) {
                case 35:
                    i3 = 1;
                    break;
                case s.CTRL_INDEX:
                    i3 = 5;
                    break;
                case 87:
                    i3 = 2;
                    break;
                case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                    i3 = 3;
                    break;
                case PlayerException.EXCEPTION_IN_CHECK_STATE /*{ENCODED_INT: 89}*/:
                    i3 = 4;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            String nullAsNil2 = Util.nullAsNil(this.Bfg.getString("Contact_Ext_Extra_Params"));
            String str3 = nullAsNil + "," + i2 + "," + Util.nullAsNil(this.contact.field_username) + "," + i4 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i3;
            if (!Util.isNullOrNil(str)) {
                str2 = str3 + "," + str + "," + nullAsNil2;
            } else {
                str2 = str3 + ",," + nullAsNil2;
            }
            Log.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", str2);
            h.INSTANCE.kvStat(10866, str2);
            AppMethodBeat.o(27100);
        }
    }

    private void eEr() {
        AppMethodBeat.i(27101);
        if (this.gte.getIntent() != null && this.gte.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            String stringExtra = this.gte.getIntent().getStringExtra("KHardDeviceBindTicket");
            if (Util.isNullOrNil(stringExtra)) {
                Log.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
            } else if (!eEs()) {
                Log.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", stringExtra);
                bg.azz().a(536, this);
                dr drVar = new dr();
                drVar.dGF.dGH = stringExtra;
                drVar.dGF.opType = 1;
                EventCenter.instance.publish(drVar);
                final com.tencent.mm.ak.q qVar = drVar.dGG.dGJ;
                MMActivity mMActivity = this.gte;
                this.gte.getString(R.string.zb);
                this.tipDialog = com.tencent.mm.ui.base.h.a((Context) mMActivity, this.gte.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass5 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(27076);
                        bg.azz().b(536, c.this);
                        dr drVar = new dr();
                        drVar.dGF.opType = 2;
                        drVar.dGF.dGJ = qVar;
                        EventCenter.instance.publish(drVar);
                        AppMethodBeat.o(27076);
                    }
                });
                AppMethodBeat.o(27101);
                return;
            }
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.gte, new a.AbstractC2025a() {
            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass6 */

            /* JADX WARNING: Code restructure failed: missing block: B:62:0x0246, code lost:
                if (r2 == false) goto L_0x013d;
             */
            @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(boolean r9, boolean r10, java.lang.String r11, java.lang.String r12) {
                /*
                // Method dump skipped, instructions count: 586
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.c.AnonymousClass6.a(boolean, boolean, java.lang.String, java.lang.String):void");
            }
        });
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(Integer.valueOf(this.kgm));
        if (this.dhE != null) {
            aVar.wHV = this.dhE;
        }
        if (!Util.isNullOrNil(this.wZz)) {
            aVar.wZz = this.wZz;
        }
        aVar.Keg = true;
        aVar.a(this.contact.field_username, linkedList, this.Bfi);
        AppMethodBeat.o(27101);
    }

    private boolean eEs() {
        AppMethodBeat.i(27102);
        if (this.gte.getIntent() == null) {
            AppMethodBeat.o(27102);
            return false;
        }
        String stringExtra = this.gte.getIntent().getStringExtra(TPDownloadProxyEnum.USER_DEVICE_ID);
        String stringExtra2 = this.gte.getIntent().getStringExtra("device_type");
        dv dvVar = new dv();
        dvVar.dGR.dGL = stringExtra;
        dvVar.dGR.dGP = stringExtra2;
        EventCenter.instance.publish(dvVar);
        boolean z = dvVar.dGS.dGT;
        AppMethodBeat.o(27102);
        return z;
    }

    private void eEt() {
        AppMethodBeat.i(27103);
        if (this.contact == null || Util.isNullOrNil(this.contact.field_username)) {
            AppMethodBeat.o(27103);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", String.format(Bff, this.contact.field_username));
        intent.putExtra("showShare", false);
        com.tencent.mm.br.c.b(this.gte, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(27103);
    }

    private void sG(boolean z) {
        AppMethodBeat.i(27104);
        if (this.contact != null) {
            if (this.gte != null) {
                if (!z || g.DQ(this.contact.field_username)) {
                    this.gte.setTitleMuteIconVisibility(8);
                } else {
                    this.gte.setTitleMuteIconVisibility(0);
                }
            }
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("contact_is_mute");
            if (checkBoxPreference != null) {
                checkBoxPreference.setChecked(z);
            }
        }
        AppMethodBeat.o(27104);
    }

    private void aKq(String str) {
        com.tencent.mm.al.h hVar;
        AppMethodBeat.i(27105);
        Log.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", str, Boolean.valueOf(this.Bfd));
        if (this.Bfd) {
            AppMethodBeat.o(27105);
            return;
        }
        this.Bfc = str;
        if (this.dhv == null || !this.dhv.Vg() || this.contact == null) {
            this.screen.m38do("contact_info_kf_worker", true);
            AppMethodBeat.o(27105);
        } else if (Util.isNullOrNil(str)) {
            com.tencent.mm.al.h Nn = ag.bag().Nn(this.contact.field_username);
            if (Nn == null) {
                this.screen.m38do("contact_info_kf_worker", true);
                ag.bai().a(this);
                ag.bai().be(this.contact.field_username, z.aTY());
                this.Bfd = true;
                AppMethodBeat.o(27105);
                return;
            }
            Log.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", Nn.field_openId);
            this.screen.m38do("contact_info_kf_worker", false);
            IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) this.screen.bmg("contact_info_kf_worker");
            iconWidgetPreference.setSummary(Nn.field_nickname);
            Bitmap a2 = com.tencent.mm.aj.c.a(Nn.field_openId, false, -1, null);
            if (a2 == null) {
                c(Nn);
                aKr(Nn.field_openId);
                AppMethodBeat.o(27105);
                return;
            }
            iconWidgetPreference.al(a2);
            AppMethodBeat.o(27105);
        } else {
            com.tencent.mm.al.j bag = ag.bag();
            com.tencent.mm.al.h Nm = bag.Nm(str);
            if (Nm == null || com.tencent.mm.al.j.a(Nm)) {
                ag.bai().a(this);
                ag.bai().j(this.contact.field_username, str, 1);
                this.Bfd = true;
            }
            if (Nm == null) {
                Log.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                hVar = bag.Nn(this.contact.field_username);
            } else {
                hVar = Nm;
            }
            if (hVar == null) {
                this.screen.m38do("contact_info_kf_worker", true);
                AppMethodBeat.o(27105);
                return;
            }
            this.screen.m38do("contact_info_kf_worker", false);
            IconWidgetPreference iconWidgetPreference2 = (IconWidgetPreference) this.screen.bmg("contact_info_kf_worker");
            iconWidgetPreference2.setSummary(hVar.field_nickname);
            Bitmap a3 = com.tencent.mm.aj.c.a(hVar.field_openId, false, -1, null);
            if (a3 == null) {
                c(hVar);
                aKr(hVar.field_openId);
            } else {
                iconWidgetPreference2.al(a3);
            }
            Log.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", hVar.field_openId, hVar.field_nickname);
            AppMethodBeat.o(27105);
        }
    }

    private void aKr(final String str) {
        AppMethodBeat.i(27106);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass11 */

            public final void run() {
                Bitmap a2;
                AppMethodBeat.i(27081);
                if (c.this.screen == null) {
                    Log.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
                    AppMethodBeat.o(27081);
                    return;
                }
                IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) c.this.screen.bmg("contact_info_kf_worker");
                if (!(iconWidgetPreference == null || c.this.screen == null || (a2 = com.tencent.mm.aj.c.a(str, false, -1, null)) == null)) {
                    Log.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", str);
                    iconWidgetPreference.al(a2);
                    c.this.screen.notifyDataSetChanged();
                }
                AppMethodBeat.o(27081);
            }
        }, 2000);
        AppMethodBeat.o(27106);
    }

    private static void c(com.tencent.mm.al.h hVar) {
        AppMethodBeat.i(27107);
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.aj.j aYB = com.tencent.mm.aj.p.aYB();
        if (aYB.Mx(hVar.field_openId) == null) {
            com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
            iVar.username = hVar.field_openId;
            iVar.iKW = hVar.field_headImgUrl;
            iVar.fv(false);
            iVar.fuz = 3;
            aYB.b(iVar);
        }
        com.tencent.mm.aj.p.aYD().Mh(hVar.field_openId);
        Log.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(27107);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        dvz dvz;
        dvy dvy = null;
        AppMethodBeat.i(27108);
        Log.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + i2 + ", errCode = " + i3 + ",errMsg = " + str);
        this.Bfd = false;
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (qVar == null) {
            Log.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
            AppMethodBeat.o(27108);
            return;
        }
        bg.azz().b(qVar.getType(), this);
        if (i2 == 0 && i3 == 0) {
            Log.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", Integer.valueOf(qVar.getType()));
            if (qVar.getType() == 536) {
                bg.azz().b(536, this);
                eEp();
                AppMethodBeat.o(27108);
            } else if (qVar.getType() == 1363) {
                com.tencent.mm.plugin.profile.b.c cVar = (com.tencent.mm.plugin.profile.b.c) qVar;
                if (cVar.rr == null || cVar.rr.iLL.iLR == null) {
                    dvz = null;
                } else {
                    dvz = (dvz) cVar.rr.iLL.iLR;
                }
                com.tencent.mm.plugin.profile.b.c cVar2 = (com.tencent.mm.plugin.profile.b.c) qVar;
                if (!(cVar2.rr == null || cVar2.rr.iLK.iLR == null)) {
                    dvy = (dvy) cVar2.rr.iLK.iLR;
                }
                if (dvz == null || dvz.KTz == null || dvz.KTz.ret != 0 || dvz.KTw == null || Util.isNullOrNil(dvz.KTw.KTu)) {
                    if (dvz == null || dvz.KTz == null) {
                        Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
                        AppMethodBeat.o(27108);
                        return;
                    }
                    Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", Integer.valueOf(dvz.KTz.ret));
                    AppMethodBeat.o(27108);
                } else if (dvz.KTw == null) {
                    Log.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
                    AppMethodBeat.o(27108);
                } else {
                    com.tencent.mm.al.a.k fB = ag.bal().fB(dvz.KTw.KTu);
                    if (fB == null) {
                        fB = new com.tencent.mm.al.a.k();
                        fB.field_userId = dvz.KTw.KTu;
                    }
                    fB.field_userName = dvz.KTw.pWm;
                    fB.field_brandUserName = dvy.KTt;
                    fB.field_UserVersion = dvz.KTw.ver;
                    fB.field_headImageUrl = dvz.KTw.KTm;
                    fB.field_profileUrl = dvz.KTw.gTH;
                    fB.field_bitFlag = dvz.KTw.KTn;
                    fB.field_addMemberUrl = dvz.KTw.KTr;
                    fB.field_needToUpdate = false;
                    if (!ag.bal().b(fB)) {
                        ag.bal().a(fB);
                    }
                    AppMethodBeat.o(27108);
                }
            } else if (qVar.getType() == 1394) {
                efm eDZ = ((com.tencent.mm.plugin.profile.b.d) qVar).eDZ();
                efn eDY = ((com.tencent.mm.plugin.profile.b.d) qVar).eDY();
                if (eDY != null && eDY.KTz != null && eDY.KTz.ret == 0) {
                    if (!eDZ.neT) {
                        com.tencent.mm.api.c cVar3 = this.Bdk;
                        cVar3.field_brandFlag &= -2;
                        a(cVar3, true);
                        bg.aVF();
                        if (com.tencent.mm.model.c.aST().bjY(cVar3.field_username) == null) {
                            az azVar = new az(cVar3.field_username);
                            azVar.Co(Util.nullAsNil(this.Bdk.UN()));
                            bg.aVF();
                            ca aEx = com.tencent.mm.model.c.aSQ().aEx(cVar3.field_username);
                            if (aEx != null) {
                                bg.aVF();
                                com.tencent.mm.model.c.aST().e(azVar);
                                bg.aVF();
                                com.tencent.mm.model.c.aST().aY(aEx);
                            } else {
                                azVar.gCr();
                                bg.aVF();
                                com.tencent.mm.model.c.aST().e(azVar);
                            }
                        }
                        bg.aVF();
                        if (com.tencent.mm.model.c.aST().bjY(cVar3.field_enterpriseFather) == null) {
                            az azVar2 = new az(cVar3.field_enterpriseFather);
                            azVar2.gCr();
                            bg.aVF();
                            com.tencent.mm.model.c.aST().e(azVar2);
                            AppMethodBeat.o(27108);
                            return;
                        }
                        bg.aVF();
                        com.tencent.mm.model.c.aSS().biO(cVar3.field_enterpriseFather);
                        AppMethodBeat.o(27108);
                        return;
                    }
                    com.tencent.mm.api.c cVar4 = this.Bdk;
                    cVar4.field_brandFlag |= 1;
                    a(cVar4, true);
                    bg.aVF();
                    com.tencent.mm.model.c.aST().bjW(cVar4.field_username);
                    bg.aVF();
                    if (com.tencent.mm.model.c.aST().bkk(cVar4.field_enterpriseFather) <= 0) {
                        bg.aVF();
                        com.tencent.mm.model.c.aST().bjW(cVar4.field_enterpriseFather);
                        AppMethodBeat.o(27108);
                        return;
                    }
                    bg.aVF();
                    com.tencent.mm.model.c.aSS().biO(cVar4.field_enterpriseFather);
                    AppMethodBeat.o(27108);
                } else if (eDY == null || eDY.KTz == null) {
                    Log.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(qVar.getType()));
                    AppMethodBeat.o(27108);
                } else {
                    Log.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(qVar.getType()), Integer.valueOf(eDY.KTz.ret));
                    AppMethodBeat.o(27108);
                }
            } else if (qVar.getType() == 1343) {
                eEp();
                AppMethodBeat.o(27108);
            } else {
                if (qVar.getType() == 1228) {
                    eEp();
                }
                AppMethodBeat.o(27108);
            }
        } else {
            Log.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", Integer.valueOf(qVar.getType()));
            AppMethodBeat.o(27108);
        }
    }

    @Override // com.tencent.mm.al.i.b
    public final void e(LinkedList<fbw> linkedList) {
        AppMethodBeat.i(27109);
        ag.bai().b(this);
        if (this.screen == null) {
            Log.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
            AppMethodBeat.o(27109);
        } else if (this.contact == null) {
            Log.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
            AppMethodBeat.o(27109);
        } else if (linkedList == null || linkedList.size() <= 0) {
            Log.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
            AppMethodBeat.o(27109);
        } else {
            if (!Util.isNullOrNil(this.Bfc)) {
                Iterator<fbw> it = linkedList.iterator();
                while (it.hasNext()) {
                    fbw next = it.next();
                    if (next.NxV != null && next.NxV.equals(this.Bfc)) {
                        this.screen.m38do("contact_info_kf_worker", false);
                        this.screen.bmg("contact_info_kf_worker").setSummary(next.Nickname);
                        AppMethodBeat.o(27109);
                        return;
                    }
                }
            }
            this.screen.m38do("contact_info_kf_worker", false);
            Preference bmg = this.screen.bmg("contact_info_kf_worker");
            if (!(bmg == null || linkedList == null || linkedList.get(0) == null)) {
                bmg.setSummary(linkedList.get(0).Nickname);
            }
            AppMethodBeat.o(27109);
        }
    }

    @Override // com.tencent.mm.al.p
    public final void a(int i2, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(27110);
        if (this.Bdk == null || !this.Bdk.UH()) {
            AppMethodBeat.o(27110);
            return;
        }
        if (qVar.getType() == 1354) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("contact_info_subscribe_bizinfo");
            this.BeV = ag.bal().fB(ag.bal().fC(this.Bdk.field_username));
            if (this.BeV != null) {
                checkBoxPreference.setChecked(!this.BeV.iE(4));
                this.screen.notifyDataSetChanged();
                AppMethodBeat.o(27110);
                return;
            }
            Log.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
        }
        AppMethodBeat.o(27110);
    }

    @Override // com.tencent.mm.al.i.b
    public final String aZT() {
        return "MicroMsg.ContactWidgetBizInfo";
    }

    private void eEu() {
        AppMethodBeat.i(27111);
        Log.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
        if (this.sp == null) {
            this.sp = this.gte.getSharedPreferences(this.gte.getPackageName() + "_preferences", 0);
        }
        if (this.gtX != null) {
            if (this.contact != null) {
                this.sp.edit().putBoolean("biz_placed_to_the_top", this.contact.arE()).commit();
            } else {
                this.sp.edit().putBoolean("biz_placed_to_the_top", false).commit();
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(27111);
    }

    private static boolean UL(int i2) {
        if (i2 == 81 || i2 == 92 || i2 == 93 || i2 == 94) {
            return true;
        }
        return false;
    }

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(27112);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) cVar.gte, 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass19 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(27089);
                if (c.this.Bdk != null && c.this.Bdk.UF()) {
                    mVar.kV(1, R.string.bf6);
                    mVar.kV(3, R.string.ahk);
                    mVar.kV(4, R.string.b_t);
                    mVar.kV(5, R.string.b9p);
                    AppMethodBeat.o(27089);
                } else if (c.this.Bdk == null || !c.this.Bdk.UG()) {
                    mVar.kV(1, R.string.bf6);
                    mVar.kV(2, R.string.b_6);
                    if (!ab.JM(c.this.contact.field_username)) {
                        mVar.kV(3, R.string.ahk);
                        mVar.kV(4, R.string.b_t);
                    }
                    mVar.kV(5, R.string.b9p);
                    AppMethodBeat.o(27089);
                } else {
                    mVar.kV(5, R.string.b9p);
                    AppMethodBeat.o(27089);
                }
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass2 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(27073);
                switch (menuItem.getItemId()) {
                    case 1:
                        c.e(c.this);
                        AppMethodBeat.o(27073);
                        return;
                    case 2:
                        c.this.gte.getString(R.string.deh, new Object[]{c.this.contact.arJ()});
                        com.tencent.mm.ui.base.h.c(c.this.gte, c.this.gte.getString(R.string.b_7), "", c.this.gte.getString(R.string.b_6), c.this.gte.getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass2.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(27072);
                                c.g(c.this);
                                AppMethodBeat.o(27072);
                            }
                        }, null);
                        AppMethodBeat.o(27073);
                        return;
                    case 3:
                        c.h(c.this);
                        AppMethodBeat.o(27073);
                        return;
                    case 4:
                        c.i(c.this);
                        AppMethodBeat.o(27073);
                        return;
                    case 5:
                        c.j(c.this);
                        break;
                }
                AppMethodBeat.o(27073);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(27112);
    }

    static /* synthetic */ void e(c cVar) {
        AppMethodBeat.i(231856);
        Intent intent = new Intent();
        intent.putExtra("Select_Talker_Name", cVar.contact.field_username);
        intent.putExtra("Select_block_List", cVar.contact.field_username);
        intent.putExtra("Select_Send_Card", true);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", true);
        b.jRt.a(intent, 1, cVar.gte);
        AppMethodBeat.o(231856);
    }

    static /* synthetic */ void g(c cVar) {
        AppMethodBeat.i(231857);
        String str = cVar.contact.field_username;
        bg.aVF();
        ca aEw = com.tencent.mm.model.c.aSQ().aEw(str);
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.e(str, aEw.field_msgSvrId));
        cVar.isDeleteCancel = false;
        MMActivity mMActivity = cVar.gte;
        cVar.gte.getString(R.string.zb);
        cVar.tipDialog = com.tencent.mm.ui.base.h.a((Context) mMActivity, cVar.gte.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass9 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(231852);
                c.this.isDeleteCancel = true;
                AppMethodBeat.o(231852);
            }
        });
        bp.a(str, new bp.a() {
            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass10 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(231853);
                boolean z = c.this.isDeleteCancel;
                AppMethodBeat.o(231853);
                return z;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(27080);
                if (c.this.tipDialog != null) {
                    c.this.tipDialog.dismiss();
                    c.this.tipDialog = null;
                }
                AppMethodBeat.o(27080);
            }
        });
        AppMethodBeat.o(231857);
    }

    static /* synthetic */ void i(c cVar) {
        AppMethodBeat.i(231859);
        ((com.tencent.mm.api.m) com.tencent.mm.kernel.g.af(com.tencent.mm.api.m.class)).a(cVar.Bdk, cVar.gte, cVar.contact, true, new Runnable() {
            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(27074);
                c.a(c.this, 4);
                if (c.this.gte.getIntent().getIntExtra("Kdel_from", -1) == 1) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.br.c.b(c.this.gte, "shake", ".ui.ShakeReportUI", intent);
                }
                AppMethodBeat.o(27074);
            }
        });
        AppMethodBeat.o(231859);
    }

    static /* synthetic */ void j(c cVar) {
        AppMethodBeat.i(231860);
        Log.d("MicroMsg.ContactWidgetBizInfo", "dealAddShortcut, username = " + cVar.contact.field_username);
        com.tencent.mm.plugin.base.model.b.ai(cVar.gte, cVar.contact.field_username);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.profile.ui.c.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(27079);
                if (c.this.gte.isFinishing()) {
                    AppMethodBeat.o(27079);
                    return;
                }
                com.tencent.mm.plugin.base.model.b.ah(c.this.gte, c.this.contact.field_username);
                com.tencent.mm.plugin.base.model.b.K(c.this.gte);
                AppMethodBeat.o(27079);
            }
        }, 1000);
        AppMethodBeat.o(231860);
    }
}
