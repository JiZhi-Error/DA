package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Toast;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.q;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.plugin.profile.d;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.DoNotCheckLeakForActivities;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.smtt.sdk.WebView;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

@DoNotCheckLeakForActivities({ContactInfoUI.class})
public final class l implements i, i.a, a {
    private boolean Bdx;
    private boolean Bdy;
    private String Bey;
    private ebj BfF;
    private boolean BfG;
    private String BfH;
    private int BfI;
    private boolean BfJ;
    private boolean BfK;
    private String BfL;
    private boolean BfM;
    private String BfN;
    private String BfO;
    private b BfP;
    private int BfQ;
    String BfR;
    IListener<bd> BfS;
    private int Bft;
    as contact;
    String dEn;
    private int dJN;
    ah gtd;
    MMActivity gte;
    String gwx;
    int kgm;
    private f screen;
    private String wZz;

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(27190);
        if (str.equals("contact_info_sns")) {
            bg.aVF();
            if (!c.isSDCardAvailable()) {
                u.g(this.gte, null);
                AppMethodBeat.o(27190);
                return true;
            }
            Intent intent = this.gte.getIntent();
            intent.putExtra("sns_source", this.dJN);
            intent.putExtra("sns_signature", this.contact.signature);
            intent.putExtra("sns_nickName", this.contact.arI());
            intent.putExtra("sns_title", this.contact.arJ());
            if (o.DCR != null) {
                intent = o.DCR.g(intent, this.contact.field_username);
            }
            if (intent == null) {
                this.gte.finish();
            } else {
                intent.putExtra("sns_adapter_type", 1);
                com.tencent.mm.br.c.b(this.gte, "sns", ".ui.SnsTimeLineUserPagerUI", intent);
                if ((intent.getFlags() & 67108864) != 0) {
                    this.gte.finish();
                }
            }
        }
        if (str.equals("contact_info_more")) {
            Intent intent2 = new Intent();
            intent2.setClass(this.gte, ContactMoreInfoUI.class);
            intent2.putExtra("Is_RoomOwner", this.gte.getIntent().getBooleanExtra("Is_RoomOwner", false));
            intent2.putExtra("Contact_User", this.contact.field_username);
            intent2.putExtra("KLinkedInAddFriendNickName", this.BfN);
            intent2.putExtra("KLinkedInAddFriendPubUrl", this.BfO);
            String stringExtra = this.gte.getIntent().getStringExtra("room_name");
            if (stringExtra == null) {
                stringExtra = this.gte.getIntent().getStringExtra("Contact_ChatRoomId");
            }
            intent2.putExtra("Contact_ChatRoomId", stringExtra);
            intent2.putExtra("verify_gmail", this.Bey);
            intent2.putExtra("profileName", this.BfL);
            long longExtra = this.gte.getIntent().getLongExtra("Contact_Uin", 0);
            String stringExtra2 = this.gte.getIntent().getStringExtra("Contact_QQNick");
            intent2.putExtra("Contact_Uin", longExtra);
            intent2.putExtra("Contact_QQNick", stringExtra2);
            MMActivity mMActivity = this.gte;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            mMActivity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else if (str.equals("contact_info_social")) {
            Intent intent3 = new Intent();
            intent3.setClass(this.gte, ContactSocialInfoUI.class);
            intent3.putExtra("Contact_User", this.contact.field_username);
            long longExtra2 = this.gte.getIntent().getLongExtra("Contact_Uin", 0);
            String stringExtra3 = this.gte.getIntent().getStringExtra("Contact_QQNick");
            intent3.putExtra("Contact_Uin", longExtra2);
            intent3.putExtra("Contact_QQNick", stringExtra3);
            intent3.putExtra("profileName", this.BfL);
            intent3.putExtra("verify_gmail", this.Bey);
            String stringExtra4 = this.gte.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra5 = this.gte.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            intent3.putExtra("Contact_Mobile_MD5", stringExtra4);
            intent3.putExtra("Contact_full_Mobile_MD5", stringExtra5);
            MMActivity mMActivity2 = this.gte;
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity2, bl2.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            mMActivity2.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity2, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else if (str.equals("contact_info_invite_source")) {
            String string = ((KeyValuePreference) this.screen.bmg("contact_info_invite_source")).getExtras().getString("inviteer");
            if (!Util.isNullOrNil(string)) {
                String displayName = getDisplayName(string);
                Intent intent4 = new Intent();
                intent4.putExtra("Contact_User", string);
                intent4.putExtra("Contact_RemarkName", displayName);
                intent4.putExtra("Contact_RoomNickname", displayName);
                intent4.putExtra("Contact_RoomMember", true);
                intent4.putExtra("room_name", this.gwx);
                bg.aVF();
                intent4.putExtra("Contact_Nick", c.aSN().Kn(string).field_nickname);
                intent4.putExtra("Contact_Scene", 14);
                intent4.putExtra("Is_RoomOwner", true);
                intent4.putExtra("Contact_ChatRoomId", this.gwx);
                com.tencent.mm.plugin.profile.b.jRt.c(intent4, this.gte);
            }
        }
        AppMethodBeat.o(27190);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    /* access modifiers changed from: package-private */
    public final void aKs(String str) {
        AppMethodBeat.i(27191);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
            AppMethodBeat.o(27191);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.kgm);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", this.contact.field_username);
        intent.putExtra("Contact_Nick", this.contact.field_nickname);
        intent.putExtra("Contact_RemarkName", this.contact.field_conRemark);
        com.tencent.mm.plugin.profile.b.jRt.m(intent, this.gte);
        AppMethodBeat.o(27191);
    }

    private void eEA() {
        boolean z;
        String str;
        String str2 = null;
        AppMethodBeat.i(27192);
        ContactSocialInfoPreference contactSocialInfoPreference = (ContactSocialInfoPreference) this.screen.bmg("contact_info_social");
        if (contactSocialInfoPreference != null) {
            if (!Util.isNullOrNil(this.BfR)) {
                contactSocialInfoPreference.UJ(0);
                this.BfQ = 1;
            } else {
                contactSocialInfoPreference.UJ(8);
            }
            bg.aVF();
            int nullAsNil = Util.nullAsNil((Integer) c.azQ().get(9, (Object) null));
            long longExtra = this.gte.getIntent().getLongExtra("Contact_Uin", 0);
            String stringExtra = this.gte.getIntent().getStringExtra("Contact_QQNick");
            if (!(longExtra == 0 || nullAsNil == 0)) {
                if (stringExtra == null || stringExtra.length() == 0) {
                    com.tencent.mm.plugin.account.friend.a.as AT = com.tencent.mm.plugin.account.a.getQQListStg().AT(longExtra);
                    if (AT == null) {
                        AT = null;
                    }
                    if (AT != null) {
                        AT.getDisplayName();
                    }
                }
                if (longExtra == -1 || new p(longExtra).longValue() <= 0) {
                    contactSocialInfoPreference.UF(8);
                } else {
                    contactSocialInfoPreference.UF(0);
                    this.BfQ = 1;
                }
            }
            if (Util.isNullOrNil(this.Bey) || Util.isNullOrNil(this.BfL)) {
                contactSocialInfoPreference.UH(8);
            } else {
                contactSocialInfoPreference.UH(0);
                this.BfQ = 1;
            }
            String value = h.aqJ().getValue("LinkedinPluginClose");
            if (Util.isNullOrNil(value) || Util.getInt(value, 0) == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z || Util.isNullOrNil(this.contact.fuT)) {
                contactSocialInfoPreference.UG(8);
            } else {
                contactSocialInfoPreference.UG(0);
                this.BfQ = 1;
            }
            if (z.aTY().equals(this.contact.field_username)) {
                bg.aVF();
                str = (String) c.azQ().get(ar.a.USERINFO_PROFILE_WEIDIANINFO_STRING, (Object) null);
            } else {
                str = this.contact.fuW;
            }
            if (!Util.isNullOrNil(str)) {
                try {
                    str2 = new JSONObject(str).optString("ShopUrl");
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.ContactWidgetNormal", e2, "", new Object[0]);
                }
            }
            Log.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", str, str2);
            if (!Util.isNullOrNil(str2)) {
                contactSocialInfoPreference.UI(0);
                this.BfQ = 1;
            } else {
                contactSocialInfoPreference.UI(8);
            }
            if (this.BfQ == 0) {
                this.screen.bmi("contact_info_social");
            }
        }
        AppMethodBeat.o(27192);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        AppMethodBeat.i(27193);
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
        this.Bdy = this.gte.getIntent().getBooleanExtra("User_Verify", false);
        this.wZz = Util.nullAsNil(this.gte.getIntent().getStringExtra("Verify_ticket"));
        this.BfG = this.gte.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.Bft = this.gte.getIntent().getIntExtra("Kdel_from", -1);
        this.BfH = this.gte.getIntent().getStringExtra("Contact_RemarkName");
        this.dJN = this.gte.getIntent().getIntExtra("Sns_from_Scene", 0);
        this.BfJ = this.gte.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.BfK = this.gte.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.BfI = this.gte.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
        long longExtra = this.gte.getIntent().getLongExtra("Contact_KSnsBgId", -1);
        String nullAs = Util.nullAs(this.gte.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
        this.Bey = Util.nullAs(this.gte.getIntent().getStringExtra("verify_gmail"), "");
        this.BfL = Util.nullAs(this.gte.getIntent().getStringExtra("profileName"), Util.subStringEmail(this.Bey));
        this.BfF.kej = this.BfI;
        this.BfF.kel = longExtra;
        this.BfF.kek = nullAs;
        this.BfN = this.gte.getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.BfO = this.gte.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        if (o.DCN != null) {
            this.BfF = o.DCN.b(asVar.field_username, this.BfF);
        }
        this.gwx = this.gte.getIntent().getStringExtra("room_name");
        bg.aVF();
        this.gtd = c.aSX().Kd(this.gwx);
        this.BfM = asVar.field_deleteFlag == 1;
        eEp();
        bg.aVF();
        c.aSN().bjG(asVar.field_username);
        boolean equals = z.aTY().equals(asVar.field_username);
        Log.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", Integer.valueOf(this.BfF.kej));
        if ((this.BfF.kej & 1) > 0) {
            z5 = true;
        }
        if (!asVar.ary() && !as.bjn(asVar.field_username) && z5 && o.DCR != null) {
            o.DCR.a(2, asVar.field_username, equals, this.dJN);
        }
        AppMethodBeat.o(27193);
        return true;
    }

    private void eEp() {
        boolean z;
        AppMethodBeat.i(27194);
        cCs();
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(R.xml.a8);
        if (o.DCR != null) {
            o.DCR.a(3, this.contact.field_username, this);
        }
        bg.azz().a(30, this);
        bg.azz().a(com.tencent.mm.plugin.appbrand.jsapi.p.u.CTRL_INDEX, this);
        this.BfR = "";
        Log.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new StringBuilder().append(this.contact.arF()).toString());
        if (!this.contact.arF()) {
            com.tencent.mm.plugin.account.friend.a.a aVar = null;
            String stringExtra = this.gte.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = this.gte.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            if (!Util.isNullOrNil(stringExtra) || !Util.isNullOrNil(stringExtra2)) {
                if (!Util.isNullOrNil(stringExtra) || !Util.isNullOrNil(stringExtra2)) {
                    Log.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", this.contact.field_username, stringExtra, stringExtra2);
                    aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(stringExtra);
                    if (aVar == null || Util.isNullOrNil(aVar.getMd5())) {
                        aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(stringExtra2);
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = this.contact.field_username;
                    objArr[1] = aVar == null ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                    Log.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", objArr);
                }
            } else if (!Util.isNullOrNil(this.contact.field_username)) {
                com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.contact.field_username);
                Object[] objArr2 = new Object[2];
                objArr2[0] = this.contact.field_username;
                objArr2[1] = SR == null ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                Log.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", objArr2);
                aVar = SR;
            }
            if (aVar != null && !Util.isNullOrNil(aVar.getMd5())) {
                this.BfR = Util.nullAsNil(aVar.bnP()).replace(" ", "");
                Log.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", this.contact.field_username, this.BfR);
            }
        }
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.screen.bmg("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.a(this.contact, this.kgm, this.wZz, this.BfR, this.contact.fuX);
            normalUserHeaderPreference.dc(this.contact.field_username, this.BfJ);
            normalUserHeaderPreference.KpZ = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.l.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27181);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    l lVar = l.this;
                    if (view.getId() == R.id.hl_) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16055, Integer.valueOf(d.aP(lVar.gte.getIntent())), 2, 1, lVar.contact.field_username);
                    }
                    if (lVar.contact == null) {
                        Log.e("MicroMsg.ContactWidgetNormal", "contact is null");
                    } else if (com.tencent.mm.contact.c.oR(lVar.contact.field_type)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_Scene", lVar.kgm);
                        intent.putExtra("Contact_User", lVar.contact.field_username);
                        intent.putExtra("Contact_RoomNickname", lVar.gte.getIntent().getStringExtra("Contact_RoomNickname"));
                        intent.putExtra("view_mode", true);
                        intent.putExtra("contact_phone_number_by_md5", lVar.BfR);
                        intent.putExtra("contact_phone_number_list", lVar.contact.fuX);
                        com.tencent.mm.plugin.profile.b.jRt.l(intent, lVar.gte);
                    } else if (!Util.isNullOrNil(lVar.contact.field_encryptUsername)) {
                        lVar.aKs(lVar.contact.field_encryptUsername);
                    } else {
                        lVar.aKs(lVar.contact.field_username);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27181);
                }
            };
            if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
                this.BfK = false;
            }
            normalUserHeaderPreference.dd(this.contact.field_username, this.BfK);
        } else {
            this.screen.e(normalUserHeaderPreference);
        }
        if (as.bjp(this.contact.field_username) && this.contact.fva != 0) {
            int indexOf = this.screen.indexOf("contact_info_category_1");
            String c2 = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).c(this.contact.field_openImAppid, "openim_custom_info_header", a.EnumC0497a.TYPE_WORDING);
            if (!TextUtils.isEmpty(c2)) {
                PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this.gte);
                preferenceTitleCategory.setTitle(c2);
                this.screen.a(preferenceTitleCategory, indexOf);
                preferenceTitleCategory.OZp = new Preference.b() {
                    /* class com.tencent.mm.plugin.profile.ui.l.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.base.preference.Preference.b
                    public final boolean a(Preference preference) {
                        return false;
                    }
                };
            }
            com.tencent.mm.openim.a.b bVar = new com.tencent.mm.openim.a.b();
            bVar.Sa(this.contact.fvb);
            for (final b.a aVar2 : bVar.jGV) {
                for (final b.C0498b bVar2 : aVar2.jGW) {
                    indexOf++;
                    AnonymousClass5 r8 = new KeyValuePreference(this.gte) {
                        /* class com.tencent.mm.plugin.profile.ui.l.AnonymousClass5 */

                        @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.KeyValuePreference
                        public final void onBindView(View view) {
                            AppMethodBeat.i(27184);
                            super.onBindView(view);
                            if (this.BfZ != null) {
                                if (bVar2.action == 2 || bVar2.action == 3) {
                                    this.BfZ.setTextColor(MMApplicationContext.getResources().getColorStateList(R.color.a3j));
                                }
                            }
                            if (this.OYH != null && !TextUtils.isEmpty(bVar2.icon)) {
                                this.OYH.setVisibility(0);
                                q.bcV().loadImage(bVar2.icon, this.OYH);
                            }
                            AppMethodBeat.o(27184);
                        }
                    };
                    r8.OFU = aVar2.title;
                    r8.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, bVar2.Sb(this.contact.field_openImAppid)));
                    this.screen.a(r8, indexOf);
                    if (bVar2.action == 0 || bVar2.action == 1) {
                        r8.setEnabled(true);
                    } else if (bVar2.action == 2) {
                        r8.OZp = new Preference.b() {
                            /* class com.tencent.mm.plugin.profile.ui.l.AnonymousClass6 */

                            @Override // com.tencent.mm.ui.base.preference.Preference.b
                            public final boolean a(Preference preference) {
                                AppMethodBeat.i(231877);
                                String str = bVar2.jGY;
                                try {
                                    str = new JSONObject(bVar2.jGY).optString("tel");
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.ContactWidgetNormal", e2, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15319, l.this.contact.field_openImAppid, Integer.valueOf(bVar2.action), aVar2.title);
                                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
                                intent.setFlags(268435456);
                                MMActivity mMActivity = l.this.gte;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                mMActivity.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(231877);
                                return true;
                            }
                        };
                    } else if (bVar2.action == 3) {
                        r8.OZp = new Preference.b() {
                            /* class com.tencent.mm.plugin.profile.ui.l.AnonymousClass7 */

                            @Override // com.tencent.mm.ui.base.preference.Preference.b
                            public final boolean a(Preference preference) {
                                AppMethodBeat.i(231878);
                                String str = "";
                                try {
                                    str = new JSONObject(bVar2.jGY).optString("mailto");
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.ContactWidgetNormal", e2, "loadProfile", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15319, l.this.contact.field_openImAppid, Integer.valueOf(bVar2.action), aVar2.title);
                                Intent intent = new Intent("android.intent.action.SENDTO");
                                intent.setData(Uri.parse(WebView.SCHEME_MAILTO.concat(String.valueOf(str))));
                                MMActivity mMActivity = l.this.gte;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                mMActivity.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(231878);
                                return true;
                            }
                        };
                    } else if (bVar2.action == 4) {
                        r8.OZp = new Preference.b() {
                            /* class com.tencent.mm.plugin.profile.ui.l.AnonymousClass8 */

                            @Override // com.tencent.mm.ui.base.preference.Preference.b
                            public final boolean a(Preference preference) {
                                AppMethodBeat.i(231879);
                                Intent intent = new Intent();
                                intent.setFlags(268435456);
                                intent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                                String str = "";
                                try {
                                    str = new JSONObject(bVar2.jGY).optString("url");
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.ContactWidgetNormal", e2, "loadProfile", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15319, l.this.contact.field_openImAppid, Integer.valueOf(bVar2.action), aVar2.title);
                                intent.putExtra("geta8key_scene", 58);
                                intent.putExtra("rawUrl", str);
                                Context context = MMApplicationContext.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$6", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$6", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(231879);
                                return true;
                            }
                        };
                    } else if (bVar2.action == 5) {
                        r8.OZp = new Preference.b() {
                            /* class com.tencent.mm.plugin.profile.ui.l.AnonymousClass9 */

                            @Override // com.tencent.mm.ui.base.preference.Preference.b
                            public final boolean a(Preference preference) {
                                AppMethodBeat.i(231880);
                                try {
                                    JSONObject jSONObject = new JSONObject(bVar2.jGY);
                                    String optString = jSONObject.optString("name");
                                    String optString2 = jSONObject.optString("pagepath");
                                    wq wqVar = new wq();
                                    wqVar.ecI.userName = optString;
                                    wqVar.ecI.ecK = Util.nullAs(optString2, "");
                                    EventCenter.instance.publish(wqVar);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15319, l.this.contact.field_openImAppid, Integer.valueOf(bVar2.action), aVar2.title);
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.ContactWidgetNormal", e2, "loadProfile", new Object[0]);
                                }
                                AppMethodBeat.o(231880);
                                return true;
                            }
                        };
                    }
                }
            }
            int i2 = indexOf + 1;
            this.screen.a(new PreferenceSmallCategory(this.gte), i2);
            int i3 = i2 + 1;
            KeyValuePreference keyValuePreference = new KeyValuePreference(this.gte);
            keyValuePreference.setTitle(R.string.bak);
            final String c3 = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).c(this.contact.field_openImAppid, "openim_intro_desc", a.EnumC0497a.TYPE_WORDING);
            keyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, c3));
            final String c4 = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).c(this.contact.field_openImAppid, "openim_intro_url", a.EnumC0497a.TYPE_URL);
            if (!TextUtils.isEmpty(c4)) {
                keyValuePreference.OZp = new Preference.b() {
                    /* class com.tencent.mm.plugin.profile.ui.l.AnonymousClass10 */

                    @Override // com.tencent.mm.ui.base.preference.Preference.b
                    public final boolean a(Preference preference) {
                        AppMethodBeat.i(231881);
                        Intent intent = new Intent();
                        intent.setFlags(268435456);
                        intent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                        intent.putExtra("rawUrl", c4);
                        intent.putExtra("geta8key_scene", 58);
                        Context context = MMApplicationContext.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$8", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$8", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15319, l.this.contact.field_openImAppid, 6, c3);
                        AppMethodBeat.o(231881);
                        return true;
                    }
                };
            }
            this.screen.a(keyValuePreference, i3);
        }
        if (!Util.isNullOrNil(this.contact.getProvince())) {
            KeyValuePreference keyValuePreference2 = (KeyValuePreference) this.screen.bmg("contact_info_district");
            if (keyValuePreference2 != null) {
                keyValuePreference2.setTitle(this.gte.getString(R.string.bai));
                keyValuePreference2.setSummary(aa.It(this.contact.getProvince()) + (Util.isNullOrNil(this.contact.getCity()) ? "" : "  " + this.contact.getCity()));
                keyValuePreference2.BC(false);
                keyValuePreference2.setEnabled(false);
            }
        } else {
            this.screen.bmi("contact_info_district");
        }
        if (this.contact.signature == null || this.contact.signature.trim().equals("") || com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            this.screen.bmi("contact_info_signature");
        } else {
            KeyValuePreference keyValuePreference3 = (KeyValuePreference) this.screen.bmg("contact_info_signature");
            if (keyValuePreference3 != null) {
                keyValuePreference3.OYB = false;
                keyValuePreference3.setTitle(this.gte.getString(R.string.bfk));
                keyValuePreference3.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.contact.signature));
                keyValuePreference3.BC(false);
            }
        }
        this.screen.bmg("contact_info_facebook");
        this.screen.bmi("contact_info_facebook");
        if ((!((this.BfF.kej & 1) > 0) || !com.tencent.mm.br.c.aZU("sns")) || as.bjn(this.contact.field_username) || this.contact.ary()) {
            this.screen.bmi("contact_info_sns");
        } else {
            com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.screen.bmg("contact_info_sns");
            if (!(gVar == null || o.DCN == null)) {
                gVar.bfe(this.contact.field_username);
            }
        }
        this.screen.bmi("contact_info_verifyuser");
        this.screen.bmi("contact_info_footer_normal");
        this.BfP = new com.tencent.mm.plugin.profile.a.b(this.gte, this.contact);
        this.BfP.eeh();
        if (this.kgm == 96) {
            this.screen.bmi("contact_info_footer_normal");
        }
        if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            eED();
            this.screen.bmi("contact_info_social");
        } else {
            eEA();
            this.screen.bmi("contact_info_more");
        }
        eEB();
        eEC();
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.screen.bmg("contact_info_footer_normal");
        boolean booleanExtra = this.gte.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean booleanExtra2 = this.gte.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.gte.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long longExtra = this.gte.getIntent().getLongExtra("Contact_Uin", -1);
        if (this.kgm == 30 || this.kgm == 45) {
            this.BfG = false;
        }
        if (normalUserFooterPreference == null || !normalUserFooterPreference.a(this.contact, this.wZz, this.Bdx, this.Bdy, this.BfG, this.kgm, this.Bft, booleanExtra2, booleanExtra, longExtra, this.BfH)) {
            this.screen.bmi("contact_info_footer_normal");
        } else {
            normalUserFooterPreference.iKx.removeAll();
            normalUserFooterPreference.iKx.add(new NormalUserFooterPreference.e() {
                /* class com.tencent.mm.plugin.profile.ui.l.AnonymousClass11 */
            }, Looper.getMainLooper());
        }
        this.screen.bmi("clear_lbs_info");
        if (this.BfM) {
            this.screen.removeAll();
            if (normalUserHeaderPreference != null) {
                this.screen.c(normalUserHeaderPreference);
            }
            if (normalUserFooterPreference != null) {
                this.screen.c(normalUserFooterPreference);
            }
        }
        AppMethodBeat.o(27194);
    }

    private void eEB() {
        AppMethodBeat.i(27195);
        if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
            this.screen.bmi("contact_info_source");
            AppMethodBeat.o(27195);
            return;
        }
        int intExtra = this.gte.getIntent().getIntExtra("Contact_Source_FMessage", 0);
        Log.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.contact.getSource() + ", sourceFMessage = " + intExtra);
        if (intExtra != 0) {
            UN(intExtra);
            AppMethodBeat.o(27195);
            return;
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.screen.bmg("contact_info_source");
        if (this.Bdy) {
            switch (this.contact.getSource()) {
                case 18:
                    if (keyValuePreference != null) {
                        keyValuePreference.OYB = false;
                        keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                        keyValuePreference.setSummary(R.string.bgb);
                        keyValuePreference.BC(false);
                        AppMethodBeat.o(27195);
                        return;
                    }
                    break;
                case 22:
                case 23:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                    if (keyValuePreference != null) {
                        keyValuePreference.OYB = false;
                        keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                        keyValuePreference.setSummary(R.string.bgt);
                        keyValuePreference.BC(false);
                        AppMethodBeat.o(27195);
                        return;
                    }
                    break;
                case 30:
                    if (keyValuePreference != null) {
                        keyValuePreference.OYB = false;
                        keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                        keyValuePreference.setSummary(R.string.bgg);
                        keyValuePreference.BC(false);
                        AppMethodBeat.o(27195);
                        return;
                    }
                    break;
                case 34:
                    if (keyValuePreference != null) {
                        keyValuePreference.OYB = false;
                        keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                        keyValuePreference.setSummary(this.gte.getString(R.string.bfw));
                        keyValuePreference.BC(false);
                        AppMethodBeat.o(27195);
                        return;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    if (keyValuePreference != null) {
                        keyValuePreference.OYB = false;
                        keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                        keyValuePreference.setSummary(this.gte.getString(R.string.bgi));
                        keyValuePreference.BC(false);
                        AppMethodBeat.o(27195);
                        return;
                    }
                    break;
                case 58:
                case bv.CTRL_INDEX:
                case 60:
                    if (keyValuePreference != null) {
                        keyValuePreference.OYB = false;
                        keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                        keyValuePreference.setSummary(this.gte.getString(R.string.du0));
                        keyValuePreference.BC(false);
                        AppMethodBeat.o(27195);
                        return;
                    }
                    break;
                case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                    if (keyValuePreference != null) {
                        keyValuePreference.OYB = false;
                        keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                        keyValuePreference.setSummary(this.gte.getString(R.string.bgd));
                        keyValuePreference.BC(false);
                        AppMethodBeat.o(27195);
                        return;
                    }
                    break;
                default:
                    this.screen.e(keyValuePreference);
                    AppMethodBeat.o(27195);
                    return;
            }
        } else {
            this.screen.e(keyValuePreference);
        }
        AppMethodBeat.o(27195);
    }

    private void eEC() {
        boolean z;
        AppMethodBeat.i(27196);
        this.screen.m38do("contact_info_invite_source", true);
        boolean booleanExtra = this.gtd == null ? this.gte.getIntent().getBooleanExtra("Is_RoomOwner", false) : this.gtd.amD();
        if (this.kgm != 14 || !booleanExtra || this.gtd == null || this.contact.field_username.equals(this.gtd.field_roomowner)) {
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.kgm);
            objArr[1] = Boolean.valueOf(booleanExtra);
            if (this.gtd == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            Log.i("MicroMsg.ContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", objArr);
            this.screen.m38do("contact_info_invite_source", true);
            AppMethodBeat.o(27196);
            return;
        }
        this.dEn = this.gte.getIntent().getStringExtra("inviteer");
        if (Util.isNullOrNil(this.dEn)) {
            this.dEn = this.gtd.bjg(this.contact.field_username);
        }
        if (Util.isNullOrNil(this.dEn)) {
            this.dEn = v.aF(this.contact.field_username, this.gwx);
        }
        if (Util.isNullOrNil(this.dEn)) {
            Log.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", this.gwx, this.contact.field_username);
            this.BfS.alive();
            ay.a.iDq.a(this.contact.field_username, this.gwx, new ay.b.a() {
                /* class com.tencent.mm.plugin.profile.ui.l.AnonymousClass2 */

                @Override // com.tencent.mm.model.ay.b.a
                public final void p(String str, boolean z) {
                    AppMethodBeat.i(27182);
                    Log.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, l.this.gwx, Boolean.valueOf(z));
                    l.this.BfS.dead();
                    AppMethodBeat.o(27182);
                }
            });
            AppMethodBeat.o(27196);
            return;
        }
        this.gte.getIntent().putExtra("inviteer", this.dEn);
        String displayName = getDisplayName(this.dEn);
        if (Util.isNullOrNil(displayName)) {
            ay.a.iDq.a(this.contact.field_username, "", new ay.b.a() {
                /* class com.tencent.mm.plugin.profile.ui.l.AnonymousClass3 */

                @Override // com.tencent.mm.model.ay.b.a
                public final void p(String str, boolean z) {
                    AppMethodBeat.i(27183);
                    Log.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, l.this.gwx, Boolean.valueOf(z));
                    if (z) {
                        bg.aVF();
                        l.this.jv(l.this.dEn, c.aSN().Kn(str).arI());
                    }
                    AppMethodBeat.o(27183);
                }
            });
            AppMethodBeat.o(27196);
            return;
        }
        jv(this.dEn, displayName);
        AppMethodBeat.o(27196);
    }

    /* access modifiers changed from: package-private */
    public final void jv(String str, String str2) {
        AppMethodBeat.i(27197);
        Log.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", str, str2);
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.screen.bmg("contact_info_invite_source");
        TextPreference textPreference = (TextPreference) this.screen.bmg("contact_info_hint");
        this.screen.m38do("contact_info_invite_source", false);
        SpannableString spannableString = new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.gte.getResources().getString(R.string.bbt, str2)));
        spannableString.setSpan(new ForegroundColorSpan(this.gte.getResources().getColor(R.color.g7)), 0, str2.length(), 33);
        keyValuePreference.setSummary(spannableString);
        keyValuePreference.getExtras().putString("inviteer", str);
        this.gte.getIntent().putExtra("inviteer", str);
        if (this.gtd == null || this.gtd.bax().contains(this.contact.field_username)) {
            this.screen.m38do("contact_info_footer_normal", false);
            AppMethodBeat.o(27197);
            return;
        }
        this.screen.m38do("contact_info_footer_normal", true);
        textPreference.ar(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.gte.getResources().getString(R.string.bde, getDisplayName(this.contact.field_username))));
        AppMethodBeat.o(27197);
    }

    private String getDisplayName(String str) {
        String str2 = null;
        AppMethodBeat.i(27198);
        if (this.gtd == null) {
            AppMethodBeat.o(27198);
        } else {
            bg.aVF();
            as Kn = c.aSN().Kn(str);
            if (Kn != null && ((int) Kn.gMZ) > 0) {
                str2 = Kn.field_conRemark;
            }
            if (Util.isNullOrNil(str2)) {
                str2 = this.gtd.getDisplayName(str);
            }
            if (Util.isNullOrNil(str2) && Kn != null) {
                str2 = Kn.arI();
            }
            AppMethodBeat.o(27198);
        }
        return str2;
    }

    private void UN(int i2) {
        String str;
        AppMethodBeat.i(27199);
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.screen.bmg("contact_info_source");
        if (!this.Bdy) {
            if (keyValuePreference != null) {
                if (i2 == 10) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    keyValuePreference.setSummary(this.gte.getString(R.string.ddh));
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                this.screen.e(keyValuePreference);
            }
            AppMethodBeat.o(27199);
            return;
        }
        switch (i2) {
            case 1:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    keyValuePreference.setSummary(R.string.bgn);
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            case 3:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    keyValuePreference.setSummary(R.string.bgq);
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            case 4:
            case 12:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    keyValuePreference.setSummary(this.gte.getString(R.string.ddi));
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            case 8:
            case 14:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    bn aEm = com.tencent.mm.bj.d.bgM().aEm(this.contact.field_username);
                    bg.aVF();
                    as Kn = c.aSN().Kn(aEm == null ? "" : aEm.field_chatroomName);
                    if (Kn != null) {
                        str = Kn.field_nickname;
                    } else {
                        str = null;
                    }
                    if (!Util.isNullOrNil(str)) {
                        keyValuePreference.setSummary(this.gte.getString(R.string.bg_, new Object[]{str}));
                    } else {
                        keyValuePreference.setSummary(R.string.bg8);
                    }
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            case 10:
            case 13:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    keyValuePreference.setSummary(R.string.bgw);
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            case 15:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    keyValuePreference.setSummary(R.string.bgk);
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            case 17:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    String displayName = aa.getDisplayName(this.gte.getIntent().getStringExtra("source_from_user_name"));
                    if (Util.isNullOrNil(displayName)) {
                        displayName = this.gte.getIntent().getStringExtra("source_from_nick_name");
                    }
                    if (Util.isNullOrNil(displayName)) {
                        keyValuePreference.setSummary(R.string.bg4);
                    } else {
                        keyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.gte.getString(R.string.bg3, new Object[]{displayName})));
                    }
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            case 18:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    keyValuePreference.setSummary(R.string.bgb);
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            case 25:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    keyValuePreference.setSummary(R.string.bfz);
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            case 30:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    keyValuePreference.setSummary(R.string.bgg);
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    keyValuePreference.setSummary(this.gte.getString(R.string.bgi));
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            case 58:
            case bv.CTRL_INDEX:
            case 60:
                if (keyValuePreference != null) {
                    keyValuePreference.OYB = false;
                    keyValuePreference.setTitle(this.gte.getString(R.string.bgz));
                    keyValuePreference.setSummary(this.gte.getString(R.string.du0));
                    keyValuePreference.BC(false);
                    AppMethodBeat.o(27199);
                    return;
                }
                break;
            default:
                this.screen.e(keyValuePreference);
                break;
        }
        AppMethodBeat.o(27199);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void eED() {
        /*
        // Method dump skipped, instructions count: 286
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.l.eED():void");
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(27202);
        if (qVar.getType() == 30 || qVar.getType() == 458) {
            if (i2 == 0 && i3 == 0) {
                if (qVar.getType() == 30) {
                    com.tencent.mm.pluginsdk.model.p pVar = (com.tencent.mm.pluginsdk.model.p) qVar;
                    if (pVar.dKy != 1 && pVar.dKy != 3) {
                        AppMethodBeat.o(27202);
                        return;
                    } else if (pVar.JVj == null || pVar.JVj.contains(this.contact.field_username)) {
                        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.screen.bmg("contact_info_header_normal");
                        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.screen.bmg("contact_info_footer_normal");
                        if (!(normalUserHeaderPreference == null || normalUserFooterPreference == null || !normalUserFooterPreference.Bhz)) {
                            Log.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
                            this.BfJ = false;
                            this.BfK = false;
                            normalUserHeaderPreference.dc(this.contact.field_username, false);
                            normalUserHeaderPreference.dd(this.contact.field_username, false);
                            normalUserHeaderPreference.Mr(this.contact.field_username);
                            this.gte.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.BfJ);
                            this.gte.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.BfK);
                        }
                    } else {
                        AppMethodBeat.o(27202);
                        return;
                    }
                }
                if (qVar.getType() == 453) {
                    eEp();
                    AppMethodBeat.o(27202);
                    return;
                }
            } else if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
                Toast.makeText(this.gte, str, 1).show();
            }
            AppMethodBeat.o(27202);
            return;
        }
        Log.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + qVar.getType());
        AppMethodBeat.o(27202);
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void a(String str, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
        AppMethodBeat.i(27203);
        com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.screen.bmg("contact_info_sns");
        if (!(gVar == null || o.DCN == null)) {
            gVar.bfe(this.contact.field_username);
        }
        this.BfF = o.DCN.b(this.contact.field_username, this.BfF);
        this.screen.notifyDataSetChanged();
        if (bVar.eZe()) {
            Log.d("MicroMsg.ContactWidgetNormal", "bg Change!");
            if (o.DCR != null) {
                o.DCR.aNX(this.contact.field_username);
            }
        }
        AppMethodBeat.o(27203);
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void b(String str, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void a(String str, String str2, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27201);
        if (o.DCR != null) {
            o.DCR.a(this, 3);
        }
        bg.azz().b(30, this);
        bg.azz().b(com.tencent.mm.plugin.appbrand.jsapi.p.u.CTRL_INDEX, this);
        NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.screen.bmg("contact_profile_header_normal");
        if (normalProfileHeaderPreference != null) {
            normalProfileHeaderPreference.onDetach();
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.screen.bmg("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.cCs();
        }
        FriendPreference friendPreference = (FriendPreference) this.screen.bmg("contact_info_friend_qq");
        if (friendPreference != null) {
            friendPreference.cCs();
        }
        FriendPreference friendPreference2 = (FriendPreference) this.screen.bmg("contact_info_friend_mobile");
        if (friendPreference2 != null) {
            friendPreference2.cCs();
        }
        FriendPreference friendPreference3 = (FriendPreference) this.screen.bmg("contact_info_facebook");
        if (friendPreference3 != null) {
            friendPreference3.cCs();
        }
        if (this.BfP != null) {
            this.BfP.destroy();
        }
        this.screen.bmg("contact_info_sns");
        AppMethodBeat.o(27201);
        return true;
    }
}
