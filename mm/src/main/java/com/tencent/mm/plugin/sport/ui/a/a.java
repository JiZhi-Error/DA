package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.m;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.plugin.newtips.a.d;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.plugin.sport.model.g;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.LinkedList;

public final class a implements i, com.tencent.mm.pluginsdk.b.a {
    private static final String Fkh = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
    private CheckBoxPreference Fki;
    private as contact;
    private Context context;
    private q nUq;
    private CheckBoxPreference qNs;
    private f screen;

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(232063);
        aVar.cCt();
        AppMethodBeat.o(232063);
    }

    static {
        AppMethodBeat.i(232064);
        AppMethodBeat.o(232064);
    }

    public a(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        AppMethodBeat.i(28822);
        this.screen = fVar;
        this.contact = asVar;
        fVar.addPreferencesFromResource(R.xml.ag);
        this.Fki = (CheckBoxPreference) fVar.bmg("contact_info_top_sport");
        this.qNs = (CheckBoxPreference) fVar.bmg("contact_info_not_disturb");
        cCt();
        AppMethodBeat.o(28822);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(28823);
        if ("contact_info_record_data".equals(str)) {
            Intent intent = new Intent(this.context, ExdeviceRankDataSourceUI.class);
            Context context2 = this.context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/sport/ui/widget/ContactWidgetSport", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else if ("contact_info_top_sport".equals(str)) {
            if (this.Fki.isChecked()) {
                c.pl(20);
                ab.E(this.contact.field_username, true);
            } else {
                c.pl(21);
                ab.F(this.contact.field_username, true);
            }
        } else if ("contact_info_not_disturb".equals(str)) {
            if (this.qNs.isChecked()) {
                c.pl(22);
                ab.z(this.contact);
            } else {
                c.pl(23);
                ab.A(this.contact);
            }
        } else if ("contact_info_go_to_sport".equals(str)) {
            Intent intent2 = new Intent();
            intent2.putExtra("Chat_User", this.contact.field_username);
            intent2.putExtra("finish_direct", true);
            com.tencent.mm.br.c.f(this.context, ".ui.chatting.ChattingUI", intent2);
            c.pl(19);
        } else if ("contact_info_go_to_my_profile".equals(str)) {
            String aTY = z.aTY();
            if (Util.isNullOrNil(aTY)) {
                Log.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
                AppMethodBeat.o(28823);
                return false;
            }
            Intent intent3 = new Intent();
            intent3.putExtra(ch.COL_USERNAME, aTY);
            com.tencent.mm.br.c.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", intent3);
            c.pl(3);
        } else if ("contact_info_invite_friend".equals(str)) {
            Intent intent4 = new Intent();
            intent4.putExtra("Select_Talker_Name", this.contact.field_username);
            intent4.putExtra("Select_block_List", this.contact.field_username);
            intent4.putExtra("Select_Conv_Type", 3);
            intent4.putExtra("Select_Send_Card", true);
            intent4.putExtra("mutil_select_is_ret", true);
            com.tencent.mm.br.c.c(this.context, ".ui.transmit.SelectConversationUI", intent4, 1);
            c.pl(4);
        } else if ("contact_info_common_problem".equals(str)) {
            Intent intent5 = new Intent();
            intent5.putExtra("KPublisherId", "custom_menu");
            intent5.putExtra("pre_username", this.contact.field_username);
            intent5.putExtra("prePublishId", "custom_menu");
            intent5.putExtra("preUsername", this.contact.field_username);
            intent5.putExtra("preChatName", this.contact.field_username);
            intent5.putExtra("preChatTYPE", ac.aJ(this.contact.field_username, this.contact.field_username));
            intent5.putExtra("rawUrl", Fkh);
            intent5.putExtra("geta8key_username", this.contact.field_username);
            intent5.putExtra("from_scence", 1);
            com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.WebViewUI", intent5);
            c.pl(5);
        } else if ("contact_info_privacy_and_notification".equals(str)) {
            com.tencent.mm.br.c.V(this.context, "exdevice", ".ui.ExdeviceSettingUI");
        } else if ("contact_info_sport_install".equals(str)) {
            c.pl(13);
            Context context3 = this.context;
            this.context.getString(R.string.zb);
            this.nUq = h.a(context3, this.context.getString(R.string.gst), true, (DialogInterface.OnCancelListener) null);
            this.nUq.show();
            bg.azz().a(30, this);
            LinkedList linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(1);
            bg.azz().a(new p(linkedList, linkedList2, "", ""), 0);
            g.vH(true);
        } else if ("contact_info_sport_uninstall".equals(str)) {
            c.pl(14);
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sport.ui.a.a.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(28821);
                    ((m) com.tencent.mm.kernel.g.af(m.class)).a(com.tencent.mm.al.g.fJ(a.this.contact.field_username), (Activity) a.this.context, a.this.contact);
                    a.c(a.this);
                    g.vH(false);
                    AppMethodBeat.o(28821);
                }
            }, null);
        } else if ("contact_info_clear_data".equals(str)) {
            h.c(this.context, this.context.getString(R.string.ba3), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sport.ui.a.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(28820);
                    c.pl(25);
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().aEE("gh_43f2581f6fd6");
                    AppMethodBeat.o(28820);
                }
            }, null);
        }
        AppMethodBeat.o(28823);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(28824);
        if (i3 == -1) {
            switch (i2) {
                case 1:
                    if (intent != null) {
                        ArrayList<String> stringsToList = Util.stringsToList(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra = intent.getStringExtra("custom_send_text");
                        for (String str : stringsToList) {
                            com.tencent.mm.plugin.messenger.a.g.eir().s("gh_43f2581f6fd6", str, ab.Eq(str));
                            if (!Util.isNullOrNil(stringExtra)) {
                                tw twVar = new tw();
                                twVar.eaq.dkV = str;
                                twVar.eaq.content = stringExtra;
                                twVar.eaq.type = ab.JG(str);
                                twVar.eaq.flags = 0;
                                EventCenter.instance.publish(twVar);
                            }
                        }
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(28824);
    }

    private void cCt() {
        AppMethodBeat.i(28825);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.bh0));
        if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            helperHeaderPreference.updateStatus(1);
            this.screen.m38do("contact_info_sport_install", true);
            this.screen.m38do("contact_info_sport_uninstall", false);
            this.screen.m38do("contact_info_go_to_sport", false);
            this.screen.m38do("contact_info_go_to_my_profile", false);
            this.screen.m38do("contact_info_invite_friend", false);
            this.screen.m38do("contact_info_common_problem", false);
            this.screen.m38do("contact_info_record_data", false);
            this.screen.m38do("contact_info_privacy_and_notification", false);
            this.screen.m38do("contact_info_top_sport", false);
            this.screen.m38do("contact_info_not_disturb", false);
            bg.aVF();
            if (com.tencent.mm.model.c.aST().bkg(this.contact.field_username)) {
                this.Fki.setChecked(true);
            } else {
                this.Fki.setChecked(false);
            }
            if (this.contact.Zx()) {
                this.qNs.setChecked(true);
                AppMethodBeat.o(28825);
                return;
            }
            this.qNs.setChecked(false);
            AppMethodBeat.o(28825);
            return;
        }
        helperHeaderPreference.updateStatus(0);
        this.screen.m38do("contact_info_sport_install", false);
        this.screen.m38do("contact_info_sport_uninstall", true);
        this.screen.m38do("contact_info_go_to_sport", true);
        this.screen.m38do("contact_info_go_to_my_profile", true);
        this.screen.m38do("contact_info_invite_friend", true);
        this.screen.m38do("contact_info_common_problem", true);
        this.screen.m38do("contact_info_record_data", true);
        this.screen.m38do("contact_info_privacy_and_notification", true);
        this.screen.m38do("contact_info_top_sport", true);
        this.screen.m38do("contact_info_not_disturb", true);
        AppMethodBeat.o(28825);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(28826);
        if (qVar instanceof p) {
            bg.azz().b(30, this);
            if (i2 == 0 && i3 == 0) {
                String gmD = ((p) qVar).gmD();
                Log.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", gmD);
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn("gh_43f2581f6fd6");
                if (Kn == null || Util.isNullOrNil(gmD)) {
                    Log.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + gmD + ", contact = " + Kn);
                } else {
                    com.tencent.mm.api.c cVar = null;
                    if (ab.IR(Kn.field_username)) {
                        String nullAsNil = Util.nullAsNil(Kn.field_username);
                        cVar = com.tencent.mm.al.g.fJ(nullAsNil);
                        if (cVar != null) {
                            cVar.field_username = gmD;
                        }
                        ag.bah().delete(nullAsNil);
                        Kn.BK(nullAsNil);
                    }
                    Kn.setUsername(gmD);
                    if (((int) Kn.gMZ) == 0) {
                        bg.aVF();
                        com.tencent.mm.model.c.aSN().aq(Kn);
                    }
                    if (((int) Kn.gMZ) <= 0) {
                        Log.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
                    } else {
                        ab.B(Kn);
                        bg.aVF();
                        as Kn2 = com.tencent.mm.model.c.aSN().Kn(Kn.field_username);
                        if (cVar != null) {
                            ag.bah().g(cVar);
                        } else {
                            com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(Kn2.field_username);
                            if (fJ == null || fJ.Uz()) {
                                Log.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
                                ay.a.iDq.aL(Kn2.field_username, "");
                                com.tencent.mm.aj.c.Mf(Kn2.field_username);
                            } else if (Kn2.gBQ()) {
                                Log.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", Integer.valueOf(Kn2.fuP));
                                ay.a.iDq.aL(Kn2.field_username, "");
                                com.tencent.mm.aj.c.Mf(Kn2.field_username);
                            }
                        }
                    }
                }
                ag.bah().h(ag.bah().MT(Kn.field_username));
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(327825, Boolean.TRUE);
                com.tencent.mm.plugin.newtips.a.exl();
                int i4 = d.ADd;
                com.tencent.mm.plugin.newtips.a.i.f(i4, d.ACZ, "", null);
                Log.i("MicroMsg.NewTips.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", Integer.valueOf(i4), 1, "");
            } else {
                Log.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 4 && ((i3 == -2 || i3 == -101 || i3 == -24) && !Util.isNullOrNil(str))) {
                    Toast.makeText(MMApplicationContext.getContext(), str, 1).show();
                }
            }
            if (this.nUq != null) {
                this.nUq.dismiss();
            }
            cCt();
        }
        AppMethodBeat.o(28826);
    }
}
