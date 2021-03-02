package com.tencent.mm.plugin.profile;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.profile.a.a;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.plugin.profile.ui.MultiButtonPreference;
import com.tencent.mm.plugin.profile.ui.MultiSummaryPreference;
import com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.plugin.story.api.d;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.pluginsdk.ui.preference.FinderPreference;
import com.tencent.mm.pluginsdk.ui.preference.FinderRecentLikePreference;
import com.tencent.mm.pluginsdk.ui.preference.LabelPreference;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.eoy;
import com.tencent.mm.protocal.protobuf.eoz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.WebView;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements i.a, d, com.tencent.mm.pluginsdk.b.a {
    b Bcm;
    private boolean Bcn;
    final List<String> Bco = new LinkedList();
    private e Bcp;
    String Bcq = null;
    IListener<bd> Bcr = new IListener<bd>() {
        /* class com.tencent.mm.plugin.profile.a.AnonymousClass7 */

        {
            AppMethodBeat.i(231785);
            this.__eventId = bd.class.getName().hashCode();
            AppMethodBeat.o(231785);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bd bdVar) {
            AppMethodBeat.i(231786);
            final bd bdVar2 = bdVar;
            Log.i("MicroMsg.NewContactWidgetNormal", "[ChatroomMemberInviterUpdatedEvent callback] username:%s inviter:%s", bdVar2.dEm.username, bdVar2.dEm.dEn);
            if (!Util.isNullOrNil(bdVar2.dEm.username) && bdVar2.dEm.username.equals(a.this.rjX.field_username) && !Util.isNullOrNil(bdVar2.dEm.dEn)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.profile.a.AnonymousClass7.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(231784);
                        final String str = bdVar2.dEm.dEn;
                        a.this.pQZ.getIntent().putExtra("inviteer", str);
                        String b2 = a.b(a.this.gtd, bdVar2.dEm.dEn);
                        Log.i("MicroMsg.NewContactWidgetNormal", "[ChatroomMemberInviterUpdatedEvent callback] inviter:%s inviterDisplayName:%s", str, b2);
                        if (Util.isNullOrNil(b2)) {
                            a.this.Bco.add(str);
                            ay.a.iDq.a(str, "", new ay.b.a() {
                                /* class com.tencent.mm.plugin.profile.a.AnonymousClass7.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.model.ay.b.a
                                public final void p(String str, boolean z) {
                                    AppMethodBeat.i(231783);
                                    Log.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, a.this.gwx, Boolean.valueOf(z));
                                    if (z) {
                                        bg.aVF();
                                        a.a(a.this.nRm, a.this.pQZ, str, c.aSN().Kn(str).arI());
                                    }
                                    AppMethodBeat.o(231783);
                                }
                            });
                            AppMethodBeat.o(231784);
                            return;
                        }
                        a.a(a.this.nRm, a.this.pQZ, str, b2);
                        AppMethodBeat.o(231784);
                    }
                });
            }
            AppMethodBeat.o(231786);
            return false;
        }
    };
    private boolean Bcs = false;
    ah gtd;
    String gwx;
    private long lastUpdateTime = 0;
    private int mScene;
    f nRm;
    MMActivity pQZ;
    private boolean readOnly = false;
    as rjX;

    public a(MMActivity mMActivity) {
        AppMethodBeat.i(26836);
        this.pQZ = mMActivity;
        AppMethodBeat.o(26836);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(final f fVar, as asVar, boolean z, int i2) {
        CharSequence charSequence;
        boolean z2;
        boolean z3;
        boolean z4;
        String string;
        boolean z5;
        AppMethodBeat.i(26837);
        this.readOnly = this.readOnly;
        this.nRm = fVar;
        this.rjX = asVar;
        this.mScene = i2;
        this.gwx = this.pQZ.getIntent().getStringExtra("room_name");
        bg.aVF();
        this.gtd = c.aSX().Kd(this.gwx);
        this.Bcn = this.pQZ.getIntent().getBooleanExtra("key_forward_flag", false);
        if (this.Bcm == null) {
            this.Bcm = new b(this.pQZ, asVar);
            this.Bcm.eeh();
        }
        Log.i("MicroMsg.NewContactWidgetNormal", "[onAttach] username:%s", asVar.field_username);
        fVar.removeAll();
        fVar.addPreferencesFromResource(R.xml.bo);
        NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) fVar.bmg("contact_profile_header_normal");
        normalProfileHeaderPreference.nRm = fVar;
        normalProfileHeaderPreference.a(asVar, i2, z, this.Bcm);
        ButtonPreference buttonPreference = (ButtonPreference) fVar.bmg("contact_profile_send");
        if (buttonPreference != null) {
            buttonPreference.OXn = R.id.bd6;
        }
        Preference preference = (ButtonPreference) fVar.bmg("contact_profile_add_contact");
        MMActivity mMActivity = this.pQZ;
        as asVar2 = this.rjX;
        if (as.bjp(asVar2.field_username) && asVar2.fva != 0) {
            int indexOf = fVar.indexOf("contact_info_category_1");
            CharSequence c2 = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).c(asVar2.field_openImAppid, "openim_custom_info_header", a.EnumC0497a.TYPE_WORDING);
            if (!TextUtils.isEmpty(c2)) {
                Preference preferenceTitleCategory = new PreferenceTitleCategory(mMActivity);
                preferenceTitleCategory.setTitle(c2);
                fVar.a(preferenceTitleCategory, indexOf);
                preferenceTitleCategory.OZp = new Preference.b() {
                    /* class com.tencent.mm.plugin.profile.a.a.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.preference.Preference.b
                    public final boolean a(Preference preference) {
                        return false;
                    }
                };
            }
            com.tencent.mm.openim.a.b bVar = new com.tencent.mm.openim.a.b();
            bVar.Sa(asVar2.fvb);
            for (b.a aVar : bVar.jGV) {
                int i3 = indexOf;
                for (b.C0498b bVar2 : aVar.jGW) {
                    i3++;
                    a.AnonymousClass2 r14 = new KeyValuePreference(mMActivity, bVar2) {
                        /* class com.tencent.mm.plugin.profile.a.a.AnonymousClass2 */
                        final /* synthetic */ b.C0498b BcI;

                        {
                            this.BcI = r2;
                        }

                        @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.KeyValuePreference
                        public final void onBindView(View view) {
                            AppMethodBeat.i(26867);
                            super.onBindView(view);
                            if (this.BfZ != null) {
                                if (this.BcI.action == 2 || this.BcI.action == 3) {
                                    this.BfZ.setTextColor(MMApplicationContext.getResources().getColorStateList(R.color.a3j));
                                }
                            }
                            if (this.OYH != null && !TextUtils.isEmpty(this.BcI.icon)) {
                                this.OYH.setVisibility(0);
                                q.bcV().loadImage(this.BcI.icon, this.OYH);
                            }
                            AppMethodBeat.o(26867);
                        }
                    };
                    r14.OFU = aVar.title;
                    r14.alL(2);
                    r14.OYB = false;
                    r14.setSummary(l.c(mMActivity, bVar2.Sb(asVar2.field_openImAppid)));
                    fVar.a(r14, i3);
                    if (bVar2.action == 0 || bVar2.action == 1) {
                        r14.setEnabled(true);
                        r14.alO(8);
                    } else if (bVar2.action == 2) {
                        r14.OZp = new Preference.b(bVar2, asVar2, aVar, mMActivity) {
                            /* class com.tencent.mm.plugin.profile.a.a.AnonymousClass3 */
                            final /* synthetic */ b.C0498b BcI;
                            final /* synthetic */ b.a BcJ;
                            final /* synthetic */ as gAi;
                            final /* synthetic */ Context val$context;

                            {
                                this.BcI = r1;
                                this.gAi = r2;
                                this.BcJ = r3;
                                this.val$context = r4;
                            }

                            @Override // com.tencent.mm.ui.base.preference.Preference.b
                            public final boolean a(Preference preference) {
                                AppMethodBeat.i(231800);
                                String str = this.BcI.jGY;
                                try {
                                    str = new JSONObject(this.BcI.jGY).optString("tel");
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e2, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
                                }
                                h.INSTANCE.a(15319, this.gAi.field_openImAppid, Integer.valueOf(this.BcI.action), this.BcJ.title);
                                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
                                intent.setFlags(268435456);
                                Context context = this.val$context;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$3", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$3", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(231800);
                                return true;
                            }
                        };
                    } else if (bVar2.action == 3) {
                        r14.OZp = new Preference.b(bVar2, asVar2, aVar, mMActivity) {
                            /* class com.tencent.mm.plugin.profile.a.a.AnonymousClass4 */
                            final /* synthetic */ b.C0498b BcI;
                            final /* synthetic */ b.a BcJ;
                            final /* synthetic */ as gAi;
                            final /* synthetic */ Context val$context;

                            {
                                this.BcI = r1;
                                this.gAi = r2;
                                this.BcJ = r3;
                                this.val$context = r4;
                            }

                            @Override // com.tencent.mm.ui.base.preference.Preference.b
                            public final boolean a(Preference preference) {
                                AppMethodBeat.i(231801);
                                String str = "";
                                try {
                                    str = new JSONObject(this.BcI.jGY).optString("mailto");
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e2, "loadProfile", new Object[0]);
                                }
                                h.INSTANCE.a(15319, this.gAi.field_openImAppid, Integer.valueOf(this.BcI.action), this.BcJ.title);
                                Intent intent = new Intent("android.intent.action.SENDTO");
                                intent.setData(Uri.parse(WebView.SCHEME_MAILTO.concat(String.valueOf(str))));
                                try {
                                    Context context = this.val$context;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    context.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                } catch (Exception e3) {
                                    Log.e("MicroMsg.Profile.OpenIMProfileLogic", "onPreferenceClick OPENIM_ACTION_OPEN_MAIL_BOX Exception:%s %s", e3.getClass().getSimpleName(), e3.getMessage());
                                }
                                AppMethodBeat.o(231801);
                                return true;
                            }
                        };
                    } else if (bVar2.action == 4) {
                        r14.OZp = new Preference.b(bVar2, asVar2, aVar) {
                            /* class com.tencent.mm.plugin.profile.a.a.AnonymousClass5 */
                            final /* synthetic */ b.C0498b BcI;
                            final /* synthetic */ b.a BcJ;
                            final /* synthetic */ as gAi;

                            {
                                this.BcI = r1;
                                this.gAi = r2;
                                this.BcJ = r3;
                            }

                            @Override // com.tencent.mm.ui.base.preference.Preference.b
                            public final boolean a(Preference preference) {
                                AppMethodBeat.i(231802);
                                Intent intent = new Intent();
                                intent.setFlags(268435456);
                                intent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                                String str = "";
                                try {
                                    str = new JSONObject(this.BcI.jGY).optString("url");
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e2, "loadProfile", new Object[0]);
                                }
                                h.INSTANCE.a(15319, this.gAi.field_openImAppid, Integer.valueOf(this.BcI.action), this.BcJ.title);
                                intent.putExtra("geta8key_scene", 58);
                                intent.putExtra("rawUrl", str);
                                Context context = MMApplicationContext.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(231802);
                                return true;
                            }
                        };
                    } else if (bVar2.action == 5) {
                        r14.OZp = new Preference.b(bVar2, asVar2, aVar) {
                            /* class com.tencent.mm.plugin.profile.a.a.AnonymousClass6 */
                            final /* synthetic */ b.C0498b BcI;
                            final /* synthetic */ b.a BcJ;
                            final /* synthetic */ as gAi;

                            {
                                this.BcI = r1;
                                this.gAi = r2;
                                this.BcJ = r3;
                            }

                            @Override // com.tencent.mm.ui.base.preference.Preference.b
                            public final boolean a(Preference preference) {
                                AppMethodBeat.i(231803);
                                try {
                                    JSONObject jSONObject = new JSONObject(this.BcI.jGY);
                                    String optString = jSONObject.optString("name");
                                    String optString2 = jSONObject.optString("pagepath");
                                    wq wqVar = new wq();
                                    wqVar.ecI.userName = optString;
                                    wqVar.ecI.ecK = Util.nullAs(optString2, "");
                                    EventCenter.instance.publish(wqVar);
                                    h.INSTANCE.a(15319, this.gAi.field_openImAppid, Integer.valueOf(this.BcI.action), this.BcJ.title);
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", e2, "loadProfile", new Object[0]);
                                }
                                AppMethodBeat.o(231803);
                                return true;
                            }
                        };
                    }
                }
                indexOf = i3;
            }
            int i4 = indexOf + 1;
            fVar.a(new PreferenceSmallCategory(mMActivity), i4);
            int i5 = i4 + 1;
            KeyValuePreference keyValuePreference = new KeyValuePreference(mMActivity);
            keyValuePreference.setTitle(R.string.bak);
            String c3 = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).c(asVar2.field_openImAppid, "openim_intro_desc", a.EnumC0497a.TYPE_WORDING);
            keyValuePreference.setSummary(l.c(mMActivity, c3));
            String c4 = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).c(asVar2.field_openImAppid, "openim_intro_url", a.EnumC0497a.TYPE_URL);
            if (!TextUtils.isEmpty(c4)) {
                keyValuePreference.OZp = new Preference.b(c4, asVar2, c3) {
                    /* class com.tencent.mm.plugin.profile.a.a.AnonymousClass7 */
                    final /* synthetic */ String BcK;
                    final /* synthetic */ as gAi;
                    final /* synthetic */ String val$url;

                    {
                        this.val$url = r1;
                        this.gAi = r2;
                        this.BcK = r3;
                    }

                    @Override // com.tencent.mm.ui.base.preference.Preference.b
                    public final boolean a(Preference preference) {
                        AppMethodBeat.i(231804);
                        if (!WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(preference.mContext)) {
                            AppMethodBeat.o(231804);
                        } else {
                            Intent intent = new Intent();
                            intent.setFlags(268435456);
                            intent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                            intent.putExtra("rawUrl", this.val$url);
                            intent.putExtra("geta8key_scene", 58);
                            Context context = MMApplicationContext.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$7", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$7", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            h.INSTANCE.a(15319, this.gAi.field_openImAppid, 6, this.BcK);
                            AppMethodBeat.o(231804);
                        }
                        return true;
                    }
                };
            }
            fVar.a(keyValuePreference, i5);
        }
        if (eDG()) {
            fVar.removeAll();
            fVar.c(normalProfileHeaderPreference);
            fVar.c(new PreferenceSmallCategory(this.pQZ));
            KeyValuePreference keyValuePreference2 = new KeyValuePreference(this.pQZ);
            keyValuePreference2.setTitle(R.string.bbv);
            keyValuePreference2.setSummary(R.string.bi4);
            keyValuePreference2.alL(Integer.MAX_VALUE);
            keyValuePreference2.OYB = false;
            keyValuePreference2.alO(8);
            fVar.c(keyValuePreference2);
            fVar.c(new PreferenceSmallCategory(this.pQZ));
            if (com.tencent.mm.contact.c.oR(this.rjX.field_type)) {
                fVar.c(buttonPreference);
            } else {
                fVar.c(preference);
            }
            this.Bcm.qdG.removeAllOptionMenu();
            AppMethodBeat.o(26837);
            return true;
        }
        as asVar3 = this.rjX;
        int intExtra = this.pQZ.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
        long longExtra = this.pQZ.getIntent().getLongExtra("Contact_KSnsBgId", -1);
        String nullAs = Util.nullAs(this.pQZ.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
        ebj ebj = new ebj();
        ebj.kej = intExtra;
        ebj.kel = longExtra;
        ebj.kek = nullAs;
        if (o.DCN != null) {
            ebj = o.DCN.b(asVar3.field_username, ebj);
        }
        bg.aVF();
        boolean bjG = c.aSN().bjG(asVar3.field_username);
        boolean equals = z.aTY().equals(asVar3.field_username);
        boolean z6 = (ebj.kej & 1) > 0;
        Log.i("MicroMsg.NewContactWidgetNormal", "isFriend:%s isSelf:%s openAlbum:%s", Boolean.valueOf(bjG), Boolean.valueOf(equals), Boolean.valueOf(z6));
        if ((as.bjn(asVar3.field_username) || !z6) && !eDJ() && !equals) {
            this.nRm.m38do("contact_profile_sns", true);
        } else {
            this.nRm.m38do("contact_profile_sns", false);
            com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.nRm.bmg("contact_profile_sns");
            if (o.DCR != null) {
                o.DCR.a(3, asVar3.field_username, this);
                o.DCR.a(2, asVar3.field_username, equals, this.pQZ.getIntent().getIntExtra("Sns_from_Scene", 0));
            }
            gVar.bfe(asVar3.field_username);
        }
        if (as.bjp(asVar3.field_username)) {
            this.nRm.m38do("contact_profile_sns", true);
        }
        Preference bmg = fVar.bmg("contact_profile_setting_desc");
        if (as.bjp(this.rjX.field_username)) {
            charSequence = this.pQZ.getText(R.string.bid).toString();
        } else {
            charSequence = this.pQZ.getText(R.string.bic).toString();
        }
        bmg.setTitle(charSequence);
        MultiSummaryPreference multiSummaryPreference = (MultiSummaryPreference) fVar.bmg("contact_profile_setting_permission");
        multiSummaryPreference.title = this.pQZ.getString(R.string.flj);
        if (this.rjX.arD()) {
            multiSummaryPreference.Bgt = new String[]{this.pQZ.getString(R.string.fq_)};
        } else {
            boolean arB = asVar.arB();
            boolean aKt = o.DCP.aKt(asVar.field_username);
            LinkedList linkedList = new LinkedList();
            int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 0);
            if (arB) {
                if (a2 == 0) {
                    linkedList.add(this.pQZ.getString(asVar.fuA == 2 ? R.string.fq4 : R.string.fq6));
                } else {
                    linkedList.add(this.pQZ.getString(asVar.fuA == 2 ? R.string.fq5 : R.string.fq7));
                }
            }
            if (aKt) {
                if (a2 == 0) {
                    linkedList.add(this.pQZ.getString(asVar.fuA == 2 ? R.string.fpz : R.string.fq1));
                } else {
                    linkedList.add(this.pQZ.getString(asVar.fuA == 2 ? R.string.fq0 : R.string.fq2));
                }
            }
            multiSummaryPreference.Bgt = (String[]) linkedList.toArray(new String[0]);
        }
        KeyValuePreference keyValuePreference3 = (KeyValuePreference) fVar.bmg("contact_profile_source");
        CharSequence a3 = NormalProfileHeaderPreference.a(this.pQZ, this.rjX, this.pQZ.getIntent().getIntExtra("Contact_Source_FMessage", i2), this.rjX.field_username, eDJ());
        keyValuePreference3.setSummary(a3);
        keyValuePreference3.alL(2);
        keyValuePreference3.OYB = false;
        keyValuePreference3.gPN = ((float) com.tencent.mm.cb.a.E(this.pQZ, (int) this.pQZ.getResources().getDimension(R.dimen.is))) * com.tencent.mm.cb.a.ez(this.pQZ);
        keyValuePreference3.alO(8);
        fVar.m38do("contact_profile_source", com.tencent.mm.contact.c.oR(asVar.field_type) || Util.isNullOrNil(a3) || (eDK() && !eDJ()));
        LabelPreference labelPreference = (LabelPreference) fVar.bmg("contact_profile_label");
        labelPreference.rjX = asVar;
        if (!com.tencent.mm.contact.c.oR(labelPreference.rjX.field_type)) {
            String str = labelPreference.rjX.field_encryptUsername;
            if (!Util.isNullOrNil(str)) {
                bg.aVF();
                labelPreference.BzG = c.aSO().aEZ(str);
            }
            if (labelPreference.BzG != null && labelPreference.BzG.systemRowid < 0) {
                bg.aVF();
                labelPreference.BzG = c.aSO().aEZ(labelPreference.rjX.field_username);
            }
        }
        if (com.tencent.mm.contact.c.oR(labelPreference.rjX.field_type) && !Util.isNullOrNil(labelPreference.rjX.field_contactLabelIds)) {
            z2 = true;
        } else if (labelPreference.BzG == null || Util.isNullOrNil(labelPreference.BzG.field_contactLabels)) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.m38do("contact_profile_label", !z2);
        PhoneNumPreference phoneNumPreference = (PhoneNumPreference) fVar.bmg("contact_profile_phone");
        phoneNumPreference.nRm = fVar;
        Intent intent = this.pQZ.getIntent();
        phoneNumPreference.rjX = asVar;
        phoneNumPreference.intent = intent;
        Log.i("MicroMsg.PhoneNumPreference", "isCancelMatchPhoneMD5 %s", new StringBuilder().append(asVar.arF()).toString());
        if (!asVar.arF()) {
            com.tencent.mm.plugin.account.friend.a.a aVar2 = null;
            String stringExtra = intent.getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = intent.getStringExtra("Contact_full_Mobile_MD5");
            if (!Util.isNullOrNil(stringExtra) || !Util.isNullOrNil(stringExtra2)) {
                if (!Util.isNullOrNil(stringExtra) || !Util.isNullOrNil(stringExtra2)) {
                    Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", asVar.field_username, stringExtra, stringExtra2);
                    aVar2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(stringExtra);
                    if (aVar2 == null || Util.isNullOrNil(aVar2.getMd5())) {
                        aVar2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(stringExtra2);
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = asVar.field_username;
                    objArr[1] = aVar2 == null ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                    Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", objArr);
                }
            } else if (!Util.isNullOrNil(asVar.field_username)) {
                com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(asVar.field_username);
                Object[] objArr2 = new Object[2];
                objArr2[0] = asVar.field_username;
                objArr2[1] = SR == null ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", objArr2);
                aVar2 = SR;
            }
            if (aVar2 != null && !Util.isNullOrNil(aVar2.getMd5())) {
                phoneNumPreference.KcI = Util.nullAsNil(aVar2.bnP()).replace(" ", "");
                Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s", asVar.field_username, phoneNumPreference.KcI);
            }
            phoneNumPreference.grR();
        }
        phoneNumPreference.KcJ = PhoneNumPreference.b(phoneNumPreference.KcI, asVar);
        phoneNumPreference.nRm.m38do("contact_profile_phone", true);
        phoneNumPreference.grR();
        phoneNumPreference.alO(8);
        ProfileDescribePreference profileDescribePreference = (ProfileDescribePreference) fVar.bmg("contact_profile_desc");
        profileDescribePreference.rjX = asVar;
        if (!com.tencent.mm.contact.c.oR(profileDescribePreference.rjX.field_type)) {
            String str2 = profileDescribePreference.rjX.field_encryptUsername;
            if (!Util.isNullOrNil(str2)) {
                bg.aVF();
                profileDescribePreference.BzG = c.aSO().aEZ(str2);
            }
            if (profileDescribePreference.BzG != null && profileDescribePreference.BzG.systemRowid < 0) {
                bg.aVF();
                profileDescribePreference.BzG = c.aSO().aEZ(profileDescribePreference.rjX.field_username);
            }
        }
        if (!com.tencent.mm.contact.c.oR(profileDescribePreference.rjX.field_type)) {
            z3 = profileDescribePreference.BzG != null && !Util.isNullOrNil(profileDescribePreference.BzG.field_conDescription);
        } else {
            z3 = !Util.isNullOrNil(profileDescribePreference.rjX.fuR) || (!Util.isNullOrNil(profileDescribePreference.rjX.fuS));
        }
        if (!z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        fVar.m38do("contact_profile_desc", z4);
        if (com.tencent.mm.contact.c.oR(asVar.field_type) || Util.isNullOrNil(asVar.signature)) {
            fVar.bmi("contact_info_signature");
        } else {
            KeyValuePreference keyValuePreference4 = (KeyValuePreference) fVar.bmg("contact_info_signature");
            if (keyValuePreference4 != null) {
                keyValuePreference4.gPN = ((float) com.tencent.mm.cb.a.E(this.pQZ, (int) this.pQZ.getResources().getDimension(R.dimen.is))) * com.tencent.mm.cb.a.ez(this.pQZ);
                keyValuePreference4.OYB = false;
                keyValuePreference4.setTitle(this.pQZ.getString(R.string.bfk));
                keyValuePreference4.setSummary(l.c(this.pQZ, asVar.signature));
                keyValuePreference4.BC(false);
                keyValuePreference4.alL(5);
                keyValuePreference4.alO(8);
            }
        }
        if (fVar.bmj("contact_profile_desc") >= 0 || fVar.bmj("contact_profile_label") >= 0) {
            fVar.m38do("contact_profile_setting_desc", true);
        } else {
            fVar.m38do("contact_profile_setting_desc", false);
        }
        if (!com.tencent.mm.contact.c.oR(asVar.field_type)) {
            fVar.m38do("contact_profile_setting_desc", false);
        }
        fVar.m38do("contact_profile_set_des_category", true);
        if (as.bjp(this.rjX.field_username) && Util.isNullOrNil(this.rjX.field_conRemark)) {
            fVar.m38do("contact_profile_setting_desc", false);
            fVar.m38do("contact_profile_set_des_category", true);
        } else if (as.bjp(this.rjX.field_username) || eDH()) {
            fVar.m38do("contact_profile_setting_desc", true);
            fVar.m38do("contact_profile_set_des_category", true);
        }
        fVar.bmg("contact_profile_info_more").setTitle(this.pQZ.getText(R.string.bd5).toString());
        ((TextPreference) fVar.bmg("contact_profile_hint")).ar(this.pQZ.getText(R.string.bd_));
        if (asVar.ary()) {
            fVar.m38do("contact_profile_hint", false);
        } else {
            fVar.m38do("contact_profile_hint", true);
        }
        MultiButtonPreference multiButtonPreference = (MultiButtonPreference) fVar.bmg("contact_profile_multi_button");
        if (eDH()) {
            multiButtonPreference.a(this.pQZ.getString(R.string.bbc), new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(26820);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(26820);
                }
            });
        } else {
            if (!eDJ()) {
                if (com.tencent.mm.contact.c.oR(this.rjX.field_type) || this.pQZ.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 2) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (!z5) {
                    if (asVar.ary() || eDM() || eDL()) {
                        multiButtonPreference.a(this.pQZ.getString(R.string.ahk), new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.profile.a.AnonymousClass12 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(231789);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                a.this.Bcm.eDX();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(231789);
                            }
                        });
                    }
                }
            }
            if (this.rjX.ary()) {
                string = this.pQZ.getString(R.string.bda);
            } else {
                string = this.pQZ.getString(R.string.bd6);
            }
            multiButtonPreference.a(string, new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.a.AnonymousClass10 */

                public final void onClick(View view) {
                    AppMethodBeat.i(26828);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    a.this.Bcm.sE(true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(26828);
                }
            });
            String string2 = this.pQZ.getString(R.string.ahk);
            AnonymousClass11 r6 = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.a.AnonymousClass11 */

                public final void onClick(View view) {
                    AppMethodBeat.i(26829);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    a.this.Bcm.eDX();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(26829);
                }
            };
            multiButtonPreference.Bgo = string2;
            multiButtonPreference.Bgr = r6;
        }
        if (eDF() || ((com.tencent.mm.contact.c.oR(asVar.field_type) && !asVar.ary()) || (!eDJ() && eDK()))) {
            fVar.m38do("contact_profile_multi_button", true);
        }
        if (!com.tencent.mm.contact.c.oR(this.rjX.field_type) || eDJ() || eDN() || eDI()) {
            fVar.m38do("contact_profile_send", true);
            fVar.m38do("contact_profile_voip", true);
        } else {
            fVar.m38do("contact_profile_send", false);
            fVar.m38do("contact_profile_voip", this.rjX.ary());
        }
        if (com.tencent.mm.contact.c.oR(this.rjX.field_type) || eDJ() || eDN() || eDM() || eDL() || z.aTY().equals(this.rjX.field_username)) {
            fVar.m38do("contact_profile_add_contact", true);
        } else {
            fVar.m38do("contact_profile_add_contact", false);
            fVar.m38do("contact_profile_setting_desc", false);
            fVar.m38do("contact_profile_setting_permission", true);
            fVar.m38do("contact_profile_phone", true);
            fVar.m38do("contact_profile_info_more", true);
        }
        a(fVar, asVar, false);
        if (eDJ() || com.tencent.mm.contact.c.oR(asVar.field_type) || (!eDI() && !eDM() && !eDL())) {
            fVar.m38do("contact_profile_say_hi", true);
            if (!com.tencent.mm.contact.c.oR(asVar.field_type)) {
                fVar.m38do("contact_profile_info_more", true);
            } else {
                fVar.m38do("contact_profile_info_more", false);
            }
        } else {
            fVar.m38do("contact_profile_info_more", true);
            fVar.m38do("contact_profile_say_hi", false);
        }
        if (z.Im(this.rjX.field_username)) {
            fVar.m38do("contact_profile_multi_button", true);
            fVar.m38do("contact_profile_info_more", Util.isNullOrNil(asVar.signature));
            fVar.m38do("contact_profile_setting_desc", true);
            fVar.m38do("contact_profile_setting_permission", true);
            fVar.m38do("contact_profile_voip", true);
            this.Bcm.qdG.removeAllOptionMenu();
        }
        as asVar4 = this.rjX;
        fVar.m38do("contact_info_invite_source", true);
        boolean booleanExtra = this.gtd == null ? this.pQZ.getIntent().getBooleanExtra("Is_RoomOwner", false) : this.gtd.amD();
        if (this.mScene != 14 || !booleanExtra || this.gtd == null || asVar4.field_username.equals(this.gtd.field_roomowner)) {
            Object[] objArr3 = new Object[3];
            objArr3[0] = Integer.valueOf(this.mScene);
            objArr3[1] = Boolean.valueOf(booleanExtra);
            objArr3[2] = Boolean.valueOf(this.gtd == null);
            Log.i("MicroMsg.NewContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", objArr3);
            fVar.m38do("contact_info_invite_source", true);
        } else {
            this.Bcq = this.pQZ.getIntent().getStringExtra("inviteer");
            if (Util.isNullOrNil(this.Bcq)) {
                this.Bcq = this.gtd.bjg(asVar4.field_username);
            }
            if (Util.isNullOrNil(this.Bcq)) {
                this.Bcq = v.aF(asVar4.field_username, this.gwx);
            }
            if (Util.isNullOrNil(this.Bcq)) {
                Log.w("MicroMsg.NewContactWidgetNormal", "mRoomId:%s member:%s , inviter is null!", this.gwx, asVar4.field_username);
                this.Bcr.alive();
                this.Bco.add(asVar4.field_username);
                ay.a.iDq.a(asVar4.field_username, this.gwx, new ay.b.a() {
                    /* class com.tencent.mm.plugin.profile.a.AnonymousClass5 */

                    @Override // com.tencent.mm.model.ay.b.a
                    public final void p(String str, boolean z) {
                        AppMethodBeat.i(26824);
                        Log.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, a.this.gwx, Boolean.valueOf(z));
                        a.this.Bcr.dead();
                        AppMethodBeat.o(26824);
                    }
                });
            } else {
                this.pQZ.getIntent().putExtra("inviteer", this.Bcq);
                String b2 = b(this.gtd, this.Bcq);
                if (Util.isNullOrNil(b2)) {
                    this.Bco.add(asVar4.field_username);
                    ay.a.iDq.a(asVar4.field_username, "", new ay.b.a() {
                        /* class com.tencent.mm.plugin.profile.a.AnonymousClass6 */

                        @Override // com.tencent.mm.model.ay.b.a
                        public final void p(String str, boolean z) {
                            AppMethodBeat.i(231782);
                            Log.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", str, a.this.gwx, Boolean.valueOf(z));
                            if (z) {
                                bg.aVF();
                                a.a(fVar, a.this.pQZ, a.this.Bcq, c.aSN().Kn(str).arI());
                            }
                            AppMethodBeat.o(231782);
                        }
                    });
                } else {
                    a(fVar, this.pQZ, this.Bcq, b2);
                }
            }
        }
        this.nRm.m38do("contact_profile_story", true);
        bg.aVF();
        boolean bjG2 = c.aSN().bjG(asVar.field_username);
        boolean equals2 = z.aTY().equals(asVar.field_username);
        if (((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().fnd()) {
            Log.i("MicroMsg.NewContactWidgetNormal", "updateStoryVisible isFriend:%s isSelf:%s ", Boolean.valueOf(bjG2), Boolean.valueOf(equals2));
            if ((!as.bjn(asVar.field_username) && bjG2) || equals2) {
                AbsStoryPreference absStoryPreference = (AbsStoryPreference) this.nRm.bmg("contact_profile_story");
                absStoryPreference.onCreate(asVar.field_username);
                absStoryPreference.a(this);
                absStoryPreference.fmY();
                absStoryPreference.fmX();
            }
        }
        f fVar2 = this.nRm;
        if (eDH()) {
            fVar2.m38do("contact_profile_add_contact", true);
            fVar2.m38do("contact_profile_accept_contact_by_wework", true);
            fVar2.m38do("contact_profile_setting_desc", true);
            fVar2.m38do("contact_profile_send", true);
            fVar2.m38do("contact_profile_voip", true);
            fVar2.m38do("contact_profile_say_hi", true);
            fVar2.m38do("contact_profile_info_more", true);
            fVar2.m38do("contact_profile_setting_permission", true);
            fVar2.m38do("contact_profile_voip", true);
            fVar2.m38do("contact_profile_multi_button", false);
            fVar2.m38do("contact_profile_set_des_category", true);
            fVar2.m38do("contact_info_category_1", true);
            fVar2.m38do("line1", false);
            fVar2.m38do("line2", false);
            fVar2.m38do("line3", false);
            fVar2.m38do("line4", false);
            this.Bcm.qdG.removeAllOptionMenu();
        } else {
            fVar2.m38do("line4", true);
        }
        final f fVar3 = this.nRm;
        boolean z7 = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderWxNameCardFinderAndRecentLikeFinderClose", 0) == 1;
        final boolean dCu = ((aj) g.ah(aj.class)).getFinderSwitchApi().dCu();
        Log.i("MicroMsg.NewContactWidgetNormal", "updateFinderPreview, dontRequestCgi:" + z7 + ", switchC:" + dCu);
        if (z7) {
            fVar3.m38do(FinderPreference.NAME, true);
            fVar3.m38do("contact_profile_finder_recent_like", true);
        } else {
            long aWy = cl.aWy();
            if (aWy - this.lastUpdateTime < 1000) {
                Log.i("MicroMsg.NewContactWidgetNormal", "updateFinderPreview, lastUpdateTime:" + this.lastUpdateTime + ", curTime:" + aWy);
            } else {
                this.lastUpdateTime = aWy;
                Object a4 = ((aj) g.ah(aj.class)).getFinderUtilApi().a(asVar.field_username, this.pQZ, new af.a<Object>() {
                    /* class com.tencent.mm.plugin.profile.a.AnonymousClass8 */

                    @Override // com.tencent.mm.plugin.i.a.af.a
                    public final void bn(Object obj) {
                        AppMethodBeat.i(231787);
                        if (dCu) {
                            a.this.a(fVar3, obj);
                        }
                        a.b(fVar3, obj);
                        AppMethodBeat.o(231787);
                    }
                }, new af.a<Integer>() {
                    /* class com.tencent.mm.plugin.profile.a.AnonymousClass9 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.plugin.i.a.af.a
                    public final /* synthetic */ void bn(Integer num) {
                        AppMethodBeat.i(231788);
                        if (dCu) {
                            a.this.a(fVar3, (Object) null);
                        }
                        a.b(fVar3, (Object) null);
                        AppMethodBeat.o(231788);
                    }
                });
                if (dCu) {
                    a(fVar3, a4);
                } else {
                    fVar3.m38do(FinderPreference.NAME, true);
                }
                b(fVar3, a4);
            }
        }
        AppMethodBeat.o(26837);
        return true;
    }

    private void a(f fVar, as asVar, boolean z) {
        String str;
        AppMethodBeat.i(26838);
        if (eDJ()) {
            fVar.m38do("contact_profile_setting_desc", true);
            fVar.m38do("contact_profile_setting_permission", true);
            fVar.m38do("contact_profile_phone", true);
            fVar.m38do("contact_profile_info_more", true);
            fVar.m38do("contact_profile_sns", as.bjp(asVar.field_username));
            boolean z2 = (z.aUd() & 268435456) != 0;
            boolean s = com.tencent.mm.pluginsdk.model.app.q.s(this.pQZ, "com.tencent.wework");
            bg.aVF();
            Log.i("MicroMsg.NewContactWidgetNormal", "ExtStatus:%s openAddByWework:%s isInstallWework:%s", Long.valueOf(z.aUd()), Boolean.valueOf(z2), Boolean.valueOf(s));
            if (Util.isEqual(((Integer) c.azQ().get(ar.a.USERINFO_ADD_CONTACT_BY_WEWORK_SWITCH_INT, (Object) 0)).intValue(), 1) || (z2 && com.tencent.mm.pluginsdk.model.app.q.s(this.pQZ, "com.tencent.wework"))) {
                fVar.m38do("contact_profile_accept_contact_by_wework", false);
                com.tencent.mm.pluginsdk.ui.preference.b[] a2 = com.tencent.mm.plugin.profile.ui.q.a(this.pQZ, asVar, this.mScene);
                if (a2 == null || a2.length <= 0) {
                    str = "";
                } else {
                    str = com.tencent.mm.plugin.profile.ui.q.b(this.pQZ, asVar, this.mScene);
                }
                if (com.tencent.mm.plugin.profile.b.e.aKm(this.rjX.field_username)) {
                    ((ButtonPreference) fVar.bmg("contact_profile_accept_contact_by_wework")).gX(this.pQZ.getString(R.string.bbq), this.pQZ.getResources().getColor(R.color.g7));
                }
                if (!Util.isNullOrNil(str) && com.tencent.mm.plugin.profile.b.e.aKl(str) == 2 && z) {
                    fVar.m38do("contact_profile_accept_contact", true);
                }
                AppMethodBeat.o(26838);
                return;
            }
            if (this.pQZ.getIntent().getBooleanExtra("isVerifyExpired", false)) {
                ButtonPreference buttonPreference = (ButtonPreference) fVar.bmg("contact_profile_accept_contact");
                buttonPreference.gX(this.pQZ.getString(R.string.f6), this.pQZ.getResources().getColor(R.color.m5));
                buttonPreference.setEnabled(false);
            }
            fVar.m38do("contact_profile_accept_contact_by_wework", true);
            AppMethodBeat.o(26838);
            return;
        }
        fVar.m38do("contact_profile_accept_contact", true);
        fVar.m38do("contact_profile_accept_contact_by_wework", true);
        AppMethodBeat.o(26838);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(26839);
        this.nRm.bmg("contact_profile_sns");
        if (o.DCR != null) {
            o.DCR.a(this, 3);
        }
        NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.nRm.bmg("contact_profile_header_normal");
        if (normalProfileHeaderPreference != null) {
            normalProfileHeaderPreference.onDetach();
        }
        AbsStoryPreference absStoryPreference = (AbsStoryPreference) this.nRm.bmg("contact_profile_story");
        if (absStoryPreference != null) {
            absStoryPreference.onDestroy();
        }
        this.Bcr.dead();
        if (this.Bcm != null) {
            this.Bcm.destroy();
        }
        for (String str : this.Bco) {
            ay.a.iDq.JZ(str);
        }
        AppMethodBeat.o(26839);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        Intent intent;
        AppMethodBeat.i(26840);
        if (str.equals("contact_profile_sns")) {
            bg.aVF();
            if (!c.isSDCardAvailable()) {
                u.g(this.pQZ, null);
            } else {
                h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.pQZ.getIntent())), 3, 1, this.rjX.field_username);
                boolean z = this.pQZ.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 12;
                Intent intent2 = this.pQZ.getIntent();
                intent2.putExtra("sns_source", this.pQZ.getIntent().getIntExtra("Sns_from_Scene", 0));
                intent2.putExtra("sns_signature", this.rjX.signature);
                intent2.putExtra("sns_nickName", this.rjX.arI());
                intent2.putExtra("sns_title", this.rjX.arJ());
                intent2.putExtra("sns_rpt_scene", d.aP(this.pQZ.getIntent()));
                if (o.DCR == null || !z) {
                    intent2.putExtra("sns_userName", this.rjX.field_username);
                    intent = intent2;
                } else {
                    intent = o.DCR.g(intent2, this.rjX.field_username);
                }
                if (intent == null) {
                    this.pQZ.finish();
                } else {
                    com.tencent.mm.br.c.b(this.pQZ, "sns", ".ui.SnsUserUI", intent);
                    if ((intent.getFlags() & 67108864) != 0) {
                        this.pQZ.finish();
                    }
                }
                com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.nRm.bmg("contact_profile_sns");
                if (gVar != null) {
                    com.tencent.mm.plugin.sns.k.e.DUQ.DVe.ePP = (long) gVar.grS();
                }
            }
        } else if (str.equals("contact_profile_label") || str.equals("contact_profile_desc") || str.equals("contact_profile_phone") || str.equals("contact_profile_setting_desc")) {
            as asVar = this.rjX;
            if (asVar == null) {
                Log.e("MicroMsg.NewContactWidgetNormal", "contact is null");
            } else if (com.tencent.mm.contact.c.oR(asVar.field_type)) {
                Intent intent3 = new Intent();
                intent3.putExtra("Contact_Scene", this.mScene);
                intent3.putExtra("Contact_User", asVar.field_username);
                intent3.putExtra("Contact_RoomNickname", this.pQZ.getIntent().getStringExtra("Contact_RoomNickname"));
                intent3.putExtra("view_mode", true);
                intent3.putExtra("contact_phone_number_by_md5", ((PhoneNumPreference) this.nRm.bmg("contact_profile_phone")).KcI);
                intent3.putExtra("contact_phone_number_list", asVar.fuX);
                b.jRt.l(intent3, this.pQZ);
            } else if (!Util.isNullOrNil(asVar.field_encryptUsername)) {
                a(asVar.field_encryptUsername, asVar);
            } else {
                a(asVar.field_username, asVar);
            }
            if (str.equals("contact_profile_setting_desc")) {
                h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.pQZ.getIntent())), 2, 1, this.rjX.field_username);
            }
        } else if (str.equals("contact_profile_setting_permission")) {
            Intent intent4 = new Intent(this.pQZ, ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 0) == 0 ? PermissionSettingUI.class : PermissionSettingUI2.class);
            intent4.putExtra("sns_permission_userName", this.rjX.field_username);
            intent4.putExtra("CONTACT_INFO_UI_SOURCE", this.pQZ.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
            intent4.putExtra("sns_permission_anim", true);
            intent4.putExtra("sns_permission_block_scene", 1);
            MMActivity mMActivity = this.pQZ;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent4);
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            mMActivity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else if (str.equals("contact_profile_power")) {
            if (this.Bcm != null) {
                this.Bcm.eDQ();
            }
        } else if (str.equals("contact_profile_send")) {
            as asVar2 = this.rjX;
            if (Util.nullAs(Boolean.valueOf(ab.IQ(asVar2.field_username)), false)) {
                String str2 = asVar2.field_username;
                Intent intent5 = new Intent();
                intent5.addFlags(67108864);
                if (this.readOnly) {
                    intent5.putExtra("Chat_User", str2);
                    intent5.putExtra("Chat_Mode", 1);
                    this.pQZ.setResult(-1, intent5);
                } else {
                    intent5.putExtra("Chat_User", str2);
                    intent5.putExtra("Chat_Mode", 1);
                    intent5.setClassName(this.pQZ, "com.tencent.mm.ui.chatting.ChattingUI");
                    MMActivity mMActivity2 = this.pQZ;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent5);
                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity2, bl2.axQ(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    mMActivity2.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity2, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
            } else {
                Intent intent6 = new Intent();
                intent6.addFlags(67108864);
                if (this.readOnly) {
                    intent6.putExtra("Chat_User", asVar2.field_username);
                    intent6.putExtra("Chat_Mode", 1);
                    this.pQZ.setResult(-1, intent6);
                } else {
                    intent6.putExtra("Chat_User", asVar2.field_username);
                    intent6.putExtra("Chat_Mode", 1);
                    intent6.setClassName(this.pQZ, "com.tencent.mm.ui.chatting.ChattingUI");
                    MMActivity mMActivity3 = this.pQZ;
                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent6);
                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity3, bl3.axQ(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    mMActivity3.startActivity((Intent) bl3.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity3, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
            }
            h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.pQZ.getIntent())), 4, 1, this.rjX.field_username);
        } else if (str.equals("contact_profile_voip")) {
            final as asVar3 = this.rjX;
            zi ziVar = new zi();
            EventCenter.instance.publish(ziVar);
            h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.pQZ.getIntent())), 5, 1, this.rjX.field_username);
            if (!asVar3.field_username.equals(ziVar.efv.talker) && (ziVar.efv.dCH || ziVar.efv.dCI)) {
                Toast.makeText(this.pQZ, ziVar.efv.efw ? R.string.an0 : R.string.an1, 0).show();
                Log.i("MicroMsg.NewContactWidgetNormal", "voip is running, can't do this");
            } else if (!com.tencent.mm.q.a.cA(this.pQZ) && !com.tencent.mm.q.a.cE(this.pQZ) && !com.tencent.mm.q.a.p(this.pQZ, true)) {
                xq xqVar = new xq();
                xqVar.edR.edT = true;
                EventCenter.instance.publish(xqVar);
                String str3 = xqVar.edS.edV;
                if (!Util.isNullOrNil(str3)) {
                    Log.v("MicroMsg.NewContactWidgetNormal", "Talkroom is on: ".concat(String.valueOf(str3)));
                    com.tencent.mm.ui.base.h.c(this.pQZ, this.pQZ.getString(R.string.hke), "", this.pQZ.getString(R.string.x_), this.pQZ.getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.profile.a.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(26822);
                            xq xqVar = new xq();
                            xqVar.edR.edU = true;
                            EventCenter.instance.publish(xqVar);
                            fo foVar = new fo();
                            foVar.dIN.username = com.tencent.mm.bi.d.jpB.bgL();
                            EventCenter.instance.publish(foVar);
                            a.this.a(asVar3, a.this.pQZ);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(26822);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.profile.a.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(231781);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(231781);
                        }
                    });
                } else {
                    a(asVar3, this.pQZ);
                }
            }
        } else if (str.equals("contact_profile_add_contact")) {
            final MMActivity mMActivity4 = this.pQZ;
            final as asVar4 = this.rjX;
            final int i2 = this.mScene;
            if (i2 != 17 || !this.Bcn) {
                if (((int) asVar4.gMZ) == 0) {
                    bg.aVF();
                    if (c.aSN().aq(asVar4) != -1) {
                        bg.aVF();
                        asVar4 = c.aSN().Kn(asVar4.field_username);
                    }
                }
                String stringExtra = this.pQZ.getIntent().getStringExtra("Contact_Mobile_MD5");
                String stringExtra2 = this.pQZ.getIntent().getStringExtra("Contact_full_Mobile_MD5");
                String nullAsNil = Util.nullAsNil(stringExtra);
                String nullAsNil2 = Util.nullAsNil(stringExtra2);
                if (!nullAsNil.equals("") || !nullAsNil2.equals("")) {
                    com.tencent.mm.plugin.account.friend.a.a SU = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(nullAsNil);
                    if (SU == null) {
                        SU = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(nullAsNil2);
                    } else {
                        nullAsNil2 = nullAsNil;
                    }
                    if (SU != null) {
                        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(nullAsNil2, SU);
                    }
                }
                final com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.pQZ, new a.AbstractC2025a() {
                    /* class com.tencent.mm.plugin.profile.a.AnonymousClass16 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.a.AbstractC2025a
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        com.tencent.mm.plugin.account.friend.a.a SR;
                        AppMethodBeat.i(231793);
                        if (z) {
                            a aVar = a.this;
                            as asVar = asVar4;
                            int i2 = i2;
                            if (Util.isNullOrNil(str)) {
                                Log.w("MicroMsg.NewContactWidgetNormal", "addContact respUsername is empty");
                                h.INSTANCE.dN(931, 21);
                            }
                            if (((int) asVar.gMZ) == 0) {
                                if (!Util.isNullOrNil(str)) {
                                    asVar.setUsername(str);
                                }
                                bg.aVF();
                                c.aSN().aq(asVar);
                                bg.aVF();
                                c.aSN().Kn(asVar.field_username);
                            }
                            if (((int) asVar.gMZ) <= 0) {
                                Log.e("MicroMsg.NewContactWidgetNormal", "addContact : insert contact failed");
                                AppMethodBeat.o(231793);
                                return;
                            }
                            if (!com.tencent.mm.contact.c.oR(asVar.field_type) && i2 == 15 && (SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(asVar.field_username)) != null && !Util.isNullOrNil(asVar.fuX)) {
                                h hVar = h.INSTANCE;
                                Object[] objArr = new Object[4];
                                objArr[0] = asVar.field_username;
                                objArr[1] = 3;
                                objArr[2] = Integer.valueOf(Util.isNullOrNil(SR.getMd5()) ? 0 : 1);
                                objArr[3] = Integer.valueOf(com.tencent.mm.contact.a.f(asVar));
                                hVar.a(12040, objArr);
                            }
                            ab.B(asVar);
                            aVar.nRm.notifyDataSetChanged();
                            au.aI(asVar.field_encryptUsername, 0);
                            re reVar = new re();
                            reVar.dXU.username = asVar.field_encryptUsername;
                            reVar.dXU.type = 1;
                            EventCenter.instance.publish(reVar);
                            AppMethodBeat.o(231793);
                        } else if (z2) {
                            com.tencent.mm.bj.d.bgN().gP(str, 2);
                            au.aI(asVar4.field_encryptUsername, 1);
                            re reVar2 = new re();
                            reVar2.dXU.username = asVar4.field_encryptUsername;
                            reVar2.dXU.type = 1;
                            EventCenter.instance.publish(reVar2);
                            AppMethodBeat.o(231793);
                        } else {
                            Log.e("MicroMsg.NewContactWidgetNormal", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(str)));
                            AppMethodBeat.o(231793);
                        }
                    }
                });
                final LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(Integer.valueOf(i2));
                final String stringExtra3 = mMActivity4.getIntent().getStringExtra("source_from_user_name");
                final String stringExtra4 = mMActivity4.getIntent().getStringExtra("source_from_nick_name");
                final long longExtra = mMActivity4.getIntent().getLongExtra("key_msg_id", 0);
                aVar.mz(stringExtra3, stringExtra4);
                aVar.Kea = new a.b() {
                    /* class com.tencent.mm.plugin.profile.a.AnonymousClass17 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.a.b
                    public final boolean aE(String str, int i2) {
                        AppMethodBeat.i(231794);
                        String stringExtra = mMActivity4.getIntent().getStringExtra("room_name");
                        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 2);
                        int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_add_friends_without_choose_permission_threshold, 1000);
                        Class cls = SayHiWithSnsPermissionUI.class;
                        if (!as.bjp(asVar4.field_username) && a2 == 1) {
                            cls = SayHiWithSnsPermissionUI2.class;
                        } else if (!as.bjp(asVar4.field_username) && a2 == 2 && ab.aVc() >= a3) {
                            cls = SayHiWithSnsPermissionUI3.class;
                        }
                        Intent intent = new Intent(mMActivity4, cls);
                        intent.putExtra("Contact_User", asVar4.field_username);
                        intent.putExtra("Contact_Nick", asVar4.field_nickname);
                        intent.putExtra("Contact_RemarkName", asVar4.field_conRemark);
                        if (i2 == 14 || i2 == 8) {
                            intent.putExtra("Contact_RoomNickname", mMActivity4.getIntent().getStringExtra("Contact_RoomNickname"));
                        } else if (i2 == 17) {
                            intent.putExtra("key_msg_id", mMActivity4.getIntent().getLongExtra("key_msg_id", 0));
                        }
                        intent.putExtra("Contact_Scene", i2);
                        intent.putExtra("room_name", stringExtra);
                        intent.putExtra("source_from_user_name", stringExtra3);
                        intent.putExtra("source_from_nick_name", stringExtra4);
                        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                        intent.putExtra("sayhi_with_sns_perm_set_label", false);
                        intent.putExtra(e.d.OyT, str);
                        intent.putExtra("sayhi_verify_add_errcode", i2);
                        intent.putExtra("key_msg_id", longExtra);
                        MMActivity mMActivity = mMActivity4;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal$9", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        mMActivity.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$9", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(231794);
                        return true;
                    }
                };
                final String stringExtra5 = mMActivity4.getIntent().getStringExtra("room_name");
                String stringExtra6 = mMActivity4.getIntent().getStringExtra(e.d.OyT);
                if (!TextUtils.isEmpty(stringExtra6)) {
                    aVar.beC(stringExtra6);
                    aVar.d(asVar4.field_username, "", linkedList);
                } else if (TextUtils.isEmpty(stringExtra5)) {
                    aVar.beC(asVar4.fuY);
                    aVar.h(asVar4.field_username, linkedList);
                } else if (!TextUtils.isEmpty(aVar.wZz)) {
                    aVar.d(asVar4.field_username, stringExtra5, linkedList);
                } else {
                    bg.aVF();
                    as Kn = c.aSN().Kn(asVar4.field_username);
                    String nullAs = Kn != null ? Util.nullAs(Kn.fuY, "") : "";
                    Log.i("MicroMsg.NewContactWidgetNormal", "dkverify footer add:%s chat:%s ticket:%s", asVar4.field_username, stringExtra5, nullAs);
                    if (!TextUtils.isEmpty(nullAs)) {
                        aVar.beC(nullAs);
                        aVar.d(asVar4.field_username, stringExtra5, linkedList);
                    } else {
                        this.Bco.add(asVar4.field_username);
                        ay.a.iDq.a(asVar4.field_username, stringExtra5, new ay.b.a() {
                            /* class com.tencent.mm.plugin.profile.a.AnonymousClass2 */

                            @Override // com.tencent.mm.model.ay.b.a
                            public final void p(String str, boolean z) {
                                AppMethodBeat.i(231780);
                                bg.aVF();
                                as Kn = c.aSN().Kn(asVar4.field_username);
                                aVar.beC(Kn != null ? Util.nullAs(Kn.fuY, "") : "");
                                aVar.d(asVar4.field_username, stringExtra5, linkedList);
                                AppMethodBeat.o(231780);
                            }
                        });
                    }
                }
                if (com.tencent.mm.plugin.messenger.e.a.Hh(longExtra)) {
                    com.tencent.mm.plugin.messenger.e.a.Q(longExtra, 3);
                }
            } else {
                com.tencent.mm.ui.base.h.a(this.pQZ, this.pQZ.getString(R.string.fpr), "", this.pQZ.getString(R.string.j34), (DialogInterface.OnClickListener) null);
            }
        } else if (str.equals("contact_profile_accept_contact")) {
            MMActivity mMActivity5 = this.pQZ;
            as asVar5 = this.rjX;
            mMActivity5.getIntent().removeExtra("Accept_NewFriend_FromOutside");
            int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 2);
            int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_add_friends_without_choose_permission_threshold, 1000);
            Class cls = SayHiWithSnsPermissionUI.class;
            if (!as.bjp(asVar5.field_username) && a2 == 1) {
                cls = SayHiWithSnsPermissionUI2.class;
            } else if (!as.bjp(asVar5.field_username) && a2 == 2 && ab.aVc() >= a3) {
                cls = SayHiWithSnsPermissionUI3.class;
            }
            Intent intent7 = new Intent(mMActivity5, cls);
            intent7.putExtra("Contact_User", asVar5.field_username);
            intent7.putExtra("room_name", this.gwx);
            intent7.putExtra("Contact_Nick", asVar5.field_nickname);
            intent7.putExtra("Contact_RemarkName", asVar5.field_conRemark);
            if (this.mScene == 14 || this.mScene == 8) {
                intent7.putExtra("Contact_RoomNickname", mMActivity5.getIntent().getStringExtra("Contact_RoomNickname"));
            }
            intent7.putExtra("Contact_Scene", this.mScene);
            intent7.putExtra("Verify_ticket", Util.nullAsNil(mMActivity5.getIntent().getStringExtra("Verify_ticket")));
            intent7.putExtra("sayhi_with_sns_perm_send_verify", false);
            intent7.putExtra("sayhi_with_sns_perm_add_remark", true);
            intent7.putExtra("sayhi_with_sns_perm_set_label", true);
            intent7.putExtra("sayhi_with_sns_permission", asVar5.arB());
            com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(intent7);
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity5, bl4.axQ(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            mMActivity5.startActivity((Intent) bl4.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity5, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else if (str.equals("contact_profile_say_hi")) {
            as asVar6 = this.rjX;
            Intent intent8 = new Intent();
            intent8.putExtra("Contact_User", asVar6.field_username);
            intent8.putExtra("Contact_Scene", this.mScene);
            intent8.putExtra(e.d.OyT, asVar6.fuY);
            b.jRt.a(intent8, (Context) this.pQZ);
        } else if (str.equals("contact_profile_info_more")) {
            if (this.Bcm != null) {
                com.tencent.mm.plugin.profile.a.b.a(this.pQZ, this.rjX);
                h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.pQZ.getIntent())), 6, 1, this.rjX.field_username);
            }
        } else if (str.equals("contact_info_invite_source")) {
            String string = ((KeyValuePreference) this.nRm.bmg("contact_info_invite_source")).getExtras().getString("inviter");
            if (!Util.isNullOrNil(string)) {
                String b2 = b(this.gtd, string);
                Intent intent9 = new Intent();
                intent9.putExtra("Contact_User", string);
                intent9.putExtra("Contact_RemarkName", b2);
                intent9.putExtra("Contact_RoomNickname", b2);
                intent9.putExtra("Contact_RoomMember", true);
                intent9.putExtra("room_name", this.gwx);
                bg.aVF();
                intent9.putExtra("Contact_Nick", c.aSN().Kn(string).field_nickname);
                intent9.putExtra("Contact_Scene", 14);
                intent9.putExtra("Is_RoomOwner", true);
                intent9.putExtra("Contact_ChatRoomId", this.gwx);
                b.jRt.c(intent9, this.pQZ);
            }
        } else if (str.equals("contact_profile_accept_contact_by_wework")) {
            as asVar7 = this.rjX;
            String nullAsNil3 = Util.nullAsNil(this.pQZ.getIntent().getStringExtra("Verify_ticket"));
            com.tencent.mm.pluginsdk.ui.preference.b[] a4 = com.tencent.mm.plugin.profile.ui.q.a(this.pQZ, asVar7, this.mScene);
            String str4 = "";
            String str5 = "";
            if (a4.length > 0) {
                str4 = a4[a4.length - 1].iAq;
                str5 = com.tencent.mm.plugin.profile.ui.q.b(this.pQZ, asVar7, this.mScene);
            }
            new com.tencent.mm.plugin.profile.b.a(asVar7.field_username, nullAsNil3, str5, str4).doScene(g.aAg().hqi.iMw, new com.tencent.mm.ak.i() {
                /* class com.tencent.mm.plugin.profile.a.AnonymousClass13 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                    String str2;
                    AppMethodBeat.i(231790);
                    qVar.setHasCallbackToQueue(true);
                    com.tencent.mm.plugin.profile.b.a aVar = (com.tencent.mm.plugin.profile.b.a) qVar;
                    if (i2 == 0 && i3 == 0) {
                        if (aVar.BcU == null) {
                            aVar.BcU = (brt) aVar.rr.iLL.iLR;
                        }
                        String str3 = aVar.BcU.LYY;
                        Uri uri = null;
                        try {
                            uri = Uri.parse(str3);
                        } catch (Exception e2) {
                            Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() Exception:%s", e2.getMessage());
                        }
                        a.this.pQZ.startActivityForResult(new Intent("android.intent.action.VIEW", uri), 111);
                        Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() success! openurl:%s", str3);
                        AppMethodBeat.o(231790);
                        return;
                    }
                    Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() fail!");
                    if (aVar.BcU == null) {
                        aVar.BcU = (brt) aVar.rr.iLL.iLR;
                    }
                    if (aVar.BcU.BaseResponse == null || aVar.BcU.BaseResponse.ErrMsg == null) {
                        str2 = aVar.errMsg;
                    } else {
                        str2 = Util.nullAsNil(aVar.BcU.BaseResponse.ErrMsg.MTo);
                    }
                    if (Util.isNullOrNil(str2)) {
                        str2 = a.this.pQZ.getString(R.string.fj6);
                    }
                    com.tencent.mm.ui.base.h.c(a.this.pQZ, str2, a.this.pQZ.getString(R.string.hoz), false);
                    AppMethodBeat.o(231790);
                }
            });
        } else if (str.equals("contact_profile_story")) {
            AbsStoryPreference absStoryPreference = (AbsStoryPreference) this.nRm.bmg("contact_profile_story");
            if (absStoryPreference != null) {
                absStoryPreference.fmZ();
            }
        } else if (str.equals(FinderPreference.NAME)) {
            FinderPreference finderPreference = (FinderPreference) this.nRm.bmg(FinderPreference.NAME);
            if (!(finderPreference.Kpr == null || finderPreference.Kpr.contact == null)) {
                String str6 = finderPreference.Kpr.contact.username;
                if (!Util.isNullOrNil(str6)) {
                    Intent intent10 = new Intent();
                    intent10.putExtra("finder_username", str6);
                    intent10.putExtra("key_enter_profile_type", 14);
                    boolean equals = str6.equals(z.aUg());
                    ((aj) g.ah(aj.class)).fillContextIdToIntent(14, 2, equals ? 33 : 32, intent10);
                    intent10.putExtra("KEY_FINDER_SELF_FLAG", equals);
                    ((aj) g.ah(aj.class)).enterFinderProfileUI(finderPreference.mContext, intent10);
                    h.INSTANCE.n(1585, 2, 1);
                }
            }
            ((aj) g.ah(aj.class)).getFinderUtilApi().awv(this.rjX.field_username);
            h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.pQZ.getIntent())), 24, 1, this.rjX.field_username);
            h.INSTANCE.a(21908, 2, 2, 2);
        } else if (str.equals("contact_profile_finder_recent_like")) {
            ((aj) g.ah(aj.class)).getFinderUtilApi().b(this.pQZ, this.rjX.field_username, this.rjX.field_nickname, 79);
            h.INSTANCE.a(16055, Integer.valueOf(d.aP(this.pQZ.getIntent())), 25, 1, this.rjX.field_username);
            ((aj) g.ah(aj.class)).getFinderUtilApi().awv(this.rjX.field_username);
        }
        AppMethodBeat.o(26840);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(26841);
        a(this.nRm, this.rjX, true);
        AppMethodBeat.o(26841);
    }

    private boolean eDF() {
        AppMethodBeat.i(26842);
        for (String str : ab.iCO) {
            if (str.equalsIgnoreCase(this.rjX.field_username)) {
                AppMethodBeat.o(26842);
                return true;
            }
        }
        boolean eDG = eDG();
        AppMethodBeat.o(26842);
        return eDG;
    }

    private boolean eDG() {
        AppMethodBeat.i(26843);
        boolean Jv = ab.Jv(this.rjX.field_username);
        AppMethodBeat.o(26843);
        return Jv;
    }

    private boolean eDH() {
        AppMethodBeat.i(231795);
        boolean avl = ((aa) g.af(aa.class)).avl(this.rjX.field_username);
        AppMethodBeat.o(231795);
        return avl;
    }

    private boolean eDI() {
        AppMethodBeat.i(26844);
        boolean IG = as.IG(this.rjX.field_username);
        AppMethodBeat.o(26844);
        return IG;
    }

    private boolean eDJ() {
        AppMethodBeat.i(26845);
        if (com.tencent.mm.contact.c.oR(this.rjX.field_type) || !this.pQZ.getIntent().getBooleanExtra("User_Verify", false)) {
            AppMethodBeat.o(26845);
            return false;
        }
        AppMethodBeat.o(26845);
        return true;
    }

    private boolean eDK() {
        AppMethodBeat.i(26846);
        if (this.pQZ.getIntent().getIntExtra("Contact_Scene", -1) == 14) {
            AppMethodBeat.o(26846);
            return true;
        }
        AppMethodBeat.o(26846);
        return false;
    }

    private boolean eDL() {
        AppMethodBeat.i(26847);
        if (this.pQZ.getIntent().getIntExtra("Contact_Scene", 0) == 18) {
            AppMethodBeat.o(26847);
            return true;
        }
        AppMethodBeat.o(26847);
        return false;
    }

    private boolean eDM() {
        AppMethodBeat.i(26848);
        int intExtra = this.pQZ.getIntent().getIntExtra("Contact_Scene", 0);
        if (26 > intExtra || intExtra > 29) {
            AppMethodBeat.o(26848);
            return false;
        }
        AppMethodBeat.o(26848);
        return true;
    }

    private boolean eDN() {
        return this.rjX.field_deleteFlag == 1;
    }

    private void a(String str, as asVar) {
        AppMethodBeat.i(26849);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.NewContactWidgetNormal", "view stranger remark, username is null");
            AppMethodBeat.o(26849);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.mScene);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", asVar.field_username);
        intent.putExtra("Contact_Nick", asVar.field_nickname);
        intent.putExtra("Contact_RemarkName", asVar.field_conRemark);
        b.jRt.m(intent, this.pQZ);
        AppMethodBeat.o(26849);
    }

    /* access modifiers changed from: package-private */
    public final void a(final as asVar, final Context context) {
        AppMethodBeat.i(26850);
        this.Bcp = new com.tencent.mm.ui.widget.a.e((Context) this.pQZ, 1, false);
        this.Bcp.HLX = new o.f() {
            /* class com.tencent.mm.plugin.profile.a.AnonymousClass14 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(231791);
                mVar.aS(2, R.string.v4, R.raw.sharemore_videovoip);
                mVar.aS(1, R.string.v6, R.raw.sharemore_voipvoice);
                AppMethodBeat.o(231791);
            }
        };
        this.Bcp.HLY = new o.g() {
            /* class com.tencent.mm.plugin.profile.a.AnonymousClass15 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(231792);
                switch (menuItem.getItemId()) {
                    case 1:
                        as asVar = asVar;
                        Context context = context;
                        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.RECORD_AUDIO", 82, "", "");
                        Log.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), context);
                        if (a2) {
                            zj zjVar = new zj();
                            zjVar.efx.dKy = 5;
                            zjVar.efx.talker = asVar.field_username;
                            zjVar.efx.context = context;
                            zjVar.efx.eft = 4;
                            EventCenter.instance.publish(zjVar);
                        }
                        AppMethodBeat.o(231792);
                        return;
                    case 2:
                        as asVar2 = asVar;
                        Context context2 = context;
                        boolean a3 = com.tencent.mm.pluginsdk.permission.b.a((Activity) context2, "android.permission.CAMERA", 19, "", "");
                        Log.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a3), Util.getStack(), context2);
                        if (a3) {
                            boolean a4 = com.tencent.mm.pluginsdk.permission.b.a((Activity) context2, "android.permission.RECORD_AUDIO", 19, "", "");
                            Log.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a4), Util.getStack(), context2);
                            if (a4) {
                                zj zjVar2 = new zj();
                                zjVar2.efx.dKy = 5;
                                zjVar2.efx.talker = asVar2.field_username;
                                zjVar2.efx.context = context2;
                                zjVar2.efx.eft = 2;
                                EventCenter.instance.publish(zjVar2);
                                break;
                            }
                        }
                        break;
                }
                AppMethodBeat.o(231792);
            }
        };
        this.Bcp.dGm();
        AppMethodBeat.o(26850);
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void a(String str, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
        AppMethodBeat.i(26851);
        com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.nRm.bmg("contact_profile_sns");
        if (!(gVar == null || com.tencent.mm.plugin.sns.b.o.DCN == null)) {
            gVar.bfe(this.rjX.field_username);
            com.tencent.mm.plugin.sns.k.e.DUQ.DVe.ePP = (long) gVar.grS();
            if (com.tencent.mm.plugin.sns.b.o.DCR != null) {
                com.tencent.mm.plugin.sns.b.o.DCR.a(this, 3);
            }
            this.nRm.notifyDataSetChanged();
            if (bVar.eZe()) {
                Log.d("MicroMsg.NewContactWidgetNormal", "bg Change!");
                if (com.tencent.mm.plugin.sns.b.o.DCR != null) {
                    com.tencent.mm.plugin.sns.b.o.DCR.aNX(this.rjX.field_username);
                }
            }
        }
        AppMethodBeat.o(26851);
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void b(String str, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void a(String str, String str2, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
    }

    @Override // com.tencent.mm.plugin.story.api.d
    public final void fP(List list) {
        AppMethodBeat.i(26852);
        if (list == null || list.isEmpty()) {
            Log.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish hideStoryPreference");
            this.nRm.m38do("contact_profile_story", true);
            AppMethodBeat.o(26852);
            return;
        }
        Log.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish showStoryPreference");
        this.nRm.m38do("contact_profile_story", false);
        AppMethodBeat.o(26852);
    }

    static void a(f fVar, Activity activity, String str, String str2) {
        AppMethodBeat.i(26853);
        Log.i("MicroMsg.NewContactWidgetNormal", "[showInviterView] inviter:%s inviterDisplayName:%s", str, str2);
        KeyValuePreference keyValuePreference = (KeyValuePreference) fVar.bmg("contact_info_invite_source");
        fVar.m38do("contact_info_invite_source", false);
        SpannableString spannableString = new SpannableString(l.c(activity, activity.getResources().getString(R.string.bbt, str2)));
        spannableString.setSpan(new ForegroundColorSpan(activity.getResources().getColor(R.color.g7)), 0, str2.length(), 33);
        keyValuePreference.alL(2);
        keyValuePreference.OYB = false;
        keyValuePreference.setSummary(spannableString);
        keyValuePreference.getExtras().putString("inviter", str);
        activity.getIntent().putExtra("inviteer", str);
        AppMethodBeat.o(26853);
    }

    static String b(ah ahVar, String str) {
        String str2 = null;
        AppMethodBeat.i(26854);
        if (ahVar == null) {
            AppMethodBeat.o(26854);
        } else {
            bg.aVF();
            as Kn = c.aSN().Kn(str);
            if (Kn != null && ((int) Kn.gMZ) > 0) {
                str2 = Kn.field_conRemark;
            }
            if (Util.isNullOrNil(str2)) {
                str2 = ahVar.getDisplayName(str);
            }
            if (Util.isNullOrNil(str2) && Kn != null) {
                str2 = Kn.arI();
            }
            AppMethodBeat.o(26854);
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    public final void a(f fVar, Object obj) {
        AppMethodBeat.i(231796);
        if (obj instanceof eoy) {
            eoy eoy = (eoy) obj;
            FinderPreference finderPreference = (FinderPreference) fVar.bmg(FinderPreference.NAME);
            if (eoy.contact == null) {
                fVar.m38do(FinderPreference.NAME, true);
                AppMethodBeat.o(231796);
                return;
            }
            if (!this.Bcs) {
                h.INSTANCE.a(21908, 2, 2, 1);
            }
            fVar.m38do(FinderPreference.NAME, false);
            finderPreference.a(eoy);
            this.Bcs = true;
            AppMethodBeat.o(231796);
            return;
        }
        fVar.m38do(FinderPreference.NAME, true);
        AppMethodBeat.o(231796);
    }

    static void b(f fVar, Object obj) {
        eoz eoz = null;
        AppMethodBeat.i(231797);
        if (obj instanceof eoy) {
            eoy eoy = (eoy) obj;
            if (eoy.LNI == 1) {
                fVar.m38do("contact_profile_finder_recent_like", false);
                FinderRecentLikePreference finderRecentLikePreference = (FinderRecentLikePreference) fVar.bmg("contact_profile_finder_recent_like");
                if (!fVar.bmh(FinderPreference.NAME)) {
                    if (eoy.LNJ != null && !Util.isNullOrNil(eoy.LNJ.LDv)) {
                        eoz = new eoz();
                        eoz.LCW.addAll(eoy.LNJ.LDv);
                    }
                    finderRecentLikePreference.a(eoz);
                    AppMethodBeat.o(231797);
                    return;
                }
                finderRecentLikePreference.a((eoz) null);
                AppMethodBeat.o(231797);
                return;
            }
        }
        fVar.m38do("contact_profile_finder_recent_like", true);
        AppMethodBeat.o(231797);
    }
}
