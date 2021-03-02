package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.b.p;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactSocialInfoUI extends MMPreference {
    private long BeA;
    private String BeB;
    private a BeK;
    private String BeL;
    private String BeM;
    private String BeN;
    private String BeO;
    private String BeP;
    private String BeQ;
    private String BeR;
    private JSONObject BeS;
    private String dWq;
    private f nRm;
    private as rjX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(ContactSocialInfoUI contactSocialInfoUI, String str) {
        AppMethodBeat.i(27067);
        contactSocialInfoUI.aKo(str);
        AppMethodBeat.o(27067);
    }

    static /* synthetic */ boolean a(ContactSocialInfoUI contactSocialInfoUI, String str, Bitmap bitmap) {
        AppMethodBeat.i(27069);
        boolean q = contactSocialInfoUI.q(str, bitmap);
        AppMethodBeat.o(27069);
        return q;
    }

    static /* synthetic */ void d(ContactSocialInfoUI contactSocialInfoUI) {
        AppMethodBeat.i(27070);
        contactSocialInfoUI.eEo();
        AppMethodBeat.o(27070);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.aq;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27060);
        super.onCreate(bundle);
        this.dWq = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
        bg.aVF();
        this.rjX = c.aSN().Kn(this.dWq);
        initView();
        AppMethodBeat.o(27060);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        AppMethodBeat.i(27061);
        setMMTitle(R.string.bfs);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27056);
                ContactSocialInfoUI.this.finish();
                AppMethodBeat.o(27056);
                return true;
            }
        });
        this.nRm = getPreferenceScreen();
        String stringExtra = getIntent().getStringExtra("Contact_Mobile_MD5");
        String stringExtra2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
        if (!Util.isNullOrNil(stringExtra) || !Util.isNullOrNil(stringExtra2)) {
            if ((stringExtra != null && stringExtra.length() > 0) || (stringExtra2 != null && stringExtra2.length() > 0)) {
                this.BeK = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(stringExtra);
                if (this.BeK == null || this.BeK.getMd5() == null || this.BeK.getMd5().length() <= 0) {
                    this.BeK = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(stringExtra2);
                    if (!(this.BeK == null || this.BeK.getMd5() == null)) {
                        this.BeK.getMd5().length();
                    }
                }
            }
        } else if (Util.isNullOrNil(this.rjX.field_username)) {
            this.BeK = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.dWq);
        } else {
            this.BeK = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.rjX.field_username);
        }
        if (this.BeK == null || this.BeK.getMd5() == null || this.BeK.getMd5().length() <= 0) {
            Log.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.BeL);
        } else {
            this.BeM = Util.nullAsNil(this.BeK.bnK()) + " " + Util.nullAsNil(this.BeK.bnP()).replace(" ", "");
        }
        u("contact_info_social_mobile", this.BeM, true);
        bg.aVF();
        int nullAsNil = Util.nullAsNil((Integer) c.azQ().get(9, (Object) null));
        this.BeA = getIntent().getLongExtra("Contact_Uin", 0);
        this.BeB = getIntent().getStringExtra("Contact_QQNick");
        if (!(this.BeA == 0 || nullAsNil == 0)) {
            if (this.BeB == null || this.BeB.length() == 0) {
                com.tencent.mm.plugin.account.friend.a.as AT = com.tencent.mm.plugin.account.a.getQQListStg().AT(this.BeA);
                if (AT == null) {
                    AT = null;
                }
                if (AT != null) {
                    this.BeB = AT.getDisplayName();
                }
            }
            this.BeN = Util.nullAsNil(this.BeB);
            this.BeN += " " + new p(this.BeA).longValue();
        }
        u("contact_info_social_qq", this.BeN, true);
        String value = h.aqJ().getValue("LinkedinPluginClose");
        if (!(Util.isNullOrNil(value) || Util.getInt(value, 0) == 0) || Util.isNullOrNil(this.rjX.fuT)) {
            this.BeO = "";
        } else {
            this.BeO = this.rjX.fuU;
        }
        u("contact_info_social_linkedin", this.BeO, true);
        u("contact_info_social_facebook", this.BeP, false);
        this.BeR = Util.nullAs(getIntent().getStringExtra("verify_gmail"), "");
        this.BeQ = Util.nullAs(getIntent().getStringExtra("profileName"), Util.subStringEmail(this.BeR));
        if (Util.isNullOrNil(this.BeR) || Util.isNullOrNil(this.BeQ)) {
            u("contact_info_social_googlecontacts", "", false);
        } else {
            u("contact_info_social_googlecontacts", this.BeQ + '\n' + this.BeR, false);
        }
        if (z.aTY().equals(this.rjX.field_username)) {
            bg.aVF();
            str = (String) c.azQ().get(ar.a.USERINFO_PROFILE_WEIDIANINFO_STRING, (Object) null);
            Log.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", str);
        } else {
            str = this.rjX.fuW;
            Log.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", str);
        }
        if (!Util.isNullOrNil(str)) {
            try {
                this.BeS = new JSONObject(str);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.ContactSocialInfoUI", e2, "", new Object[0]);
                this.BeS = null;
            }
        }
        if (this.BeS != null) {
            u("contact_info_social_weishop", this.BeS.optString("ShopName"), true);
            AppMethodBeat.o(27061);
            return;
        }
        u("contact_info_social_weishop", "", false);
        AppMethodBeat.o(27061);
    }

    private void u(String str, String str2, boolean z) {
        AppMethodBeat.i(27062);
        if (Util.isNullOrNil(str2) || Util.isNullOrNil(str)) {
            this.nRm.bmi(str);
            AppMethodBeat.o(27062);
            return;
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.nRm.bmg(str);
        if (keyValuePreference != null) {
            keyValuePreference.gLI();
            if (z) {
                keyValuePreference.qlp = getResources().getColor(R.color.x0);
            }
            keyValuePreference.setSummary(str2);
            keyValuePreference.BC(false);
        }
        AppMethodBeat.o(27062);
    }

    private boolean q(String str, Bitmap bitmap) {
        AppMethodBeat.i(27064);
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            boolean a2 = l.a(str, getContext(), byteArrayOutputStream.toByteArray());
            AppMethodBeat.o(27064);
            return a2;
        }
        AppMethodBeat.o(27064);
        return false;
    }

    private void aKo(String str) {
        AppMethodBeat.i(27065);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(27065);
    }

    private void eEo() {
        AppMethodBeat.i(27066);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.BeS.optString("ShopUrl"));
        intent.putExtra("geta8key_username", z.aTY());
        com.tencent.mm.br.c.b(getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(27066);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int lastIndexOf;
        final String[] stringArray;
        AppMethodBeat.i(27063);
        String str = preference.mKey;
        Log.i("MicroMsg.ContactSocialInfoUI", str + " item has been clicked!");
        if (str.equals("contact_info_social_mobile")) {
            if (!(this.BeK == null || this.rjX == null)) {
                bg.aVF();
                if (c.aSN().bjG(this.BeK.getUsername())) {
                    if (this.BeK == null || Util.isNullOrNil(this.BeK.iKR)) {
                        stringArray = getResources().getStringArray(R.array.ab);
                    } else {
                        stringArray = getResources().getStringArray(R.array.aa);
                    }
                    com.tencent.mm.ui.base.h.a(this, (String) null, stringArray, (String) null, new h.d() {
                        /* class com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.h.d
                        public final void oj(int i2) {
                            AppMethodBeat.i(27057);
                            switch (i2) {
                                case 0:
                                    if (ContactSocialInfoUI.this.BeM == null || ContactSocialInfoUI.this.BeM.length() == 0) {
                                        AppMethodBeat.o(27057);
                                        return;
                                    }
                                    int lastIndexOf = ContactSocialInfoUI.this.BeM.lastIndexOf(32) + 1;
                                    if (lastIndexOf > 0) {
                                        ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.this.BeM.substring(lastIndexOf));
                                        AppMethodBeat.o(27057);
                                        return;
                                    }
                                    break;
                                case 1:
                                    if (ContactSocialInfoUI.this.BeM == null || ContactSocialInfoUI.this.BeM.length() == 0) {
                                        AppMethodBeat.o(27057);
                                        return;
                                    }
                                    String substring = ContactSocialInfoUI.this.BeM.substring(0, ContactSocialInfoUI.this.BeM.lastIndexOf(32));
                                    if (substring == null || substring.length() == 0) {
                                        AppMethodBeat.o(27057);
                                        return;
                                    }
                                    ab.c(ContactSocialInfoUI.this.rjX, substring.trim());
                                    AppMethodBeat.o(27057);
                                    return;
                                case 2:
                                    if (stringArray == null || stringArray.length <= 2 || ContactSocialInfoUI.this.BeK == null || ContactSocialInfoUI.this.rjX == null) {
                                        AppMethodBeat.o(27057);
                                        return;
                                    } else if (ContactSocialInfoUI.this.BeK != null && !Util.isNullOrNil(ContactSocialInfoUI.this.BeK.iKR)) {
                                        ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.this.rjX.field_username, ContactSocialInfoUI.this.BeK.iKR);
                                        AppMethodBeat.o(27057);
                                        return;
                                    }
                                    break;
                                case 3:
                                    Intent intent = new Intent();
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("fromScene", 2);
                                    intent.putExtra("reportArgs", bundle);
                                    b.jRt.j(intent, ContactSocialInfoUI.this);
                                    break;
                            }
                            AppMethodBeat.o(27057);
                        }
                    });
                } else if (!(this.BeM == null || this.BeM.length() == 0 || (lastIndexOf = this.BeM.lastIndexOf(32) + 1) <= 0)) {
                    aKo(this.BeM.substring(lastIndexOf));
                }
            }
        } else if (!str.equals("contact_info_social_qq")) {
            if (str.equals("contact_info_social_linkedin")) {
                String str2 = this.rjX.fuV;
                if (Util.isNullOrNil(str2)) {
                    Log.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("geta8key_username", z.aTY());
                    com.tencent.mm.br.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            } else if (!str.equals("contact_info_social_facebook") && !str.equals("contact_info_social_googlecontacts") && str.equals("contact_info_social_weishop") && this.BeS != null) {
                bg.aVF();
                if (c.azQ().get(ar.a.USERINFO_PROFILE_WEIDIANINFO_ALERT_INT, (Object) null) == null) {
                    com.tencent.mm.ui.base.h.a(this, (int) R.string.bfu, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(27059);
                            ContactSocialInfoUI.d(ContactSocialInfoUI.this);
                            bg.aVF();
                            c.azQ().set(ar.a.USERINFO_PROFILE_WEIDIANINFO_ALERT_INT, (Object) 1);
                            AppMethodBeat.o(27059);
                        }
                    }, (DialogInterface.OnClickListener) null);
                } else {
                    eEo();
                }
            }
        }
        AppMethodBeat.o(27063);
        return false;
    }

    static /* synthetic */ void a(ContactSocialInfoUI contactSocialInfoUI, final String str, final String str2) {
        AppMethodBeat.i(27068);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Toast.makeText(contactSocialInfoUI.getContext(), contactSocialInfoUI.getContext().getString(R.string.bez), 0).show();
            AppMethodBeat.o(27068);
            return;
        }
        com.tencent.mm.aj.p.aYn();
        Bitmap Mo = e.Mo(str);
        if (Mo == null) {
            Toast.makeText(contactSocialInfoUI.getContext(), contactSocialInfoUI.getContext().getString(R.string.bf0), 0).show();
            final com.tencent.mm.aj.f fVar = new com.tencent.mm.aj.f();
            fVar.a(str, new f.c() {
                /* class com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI.AnonymousClass3 */

                @Override // com.tencent.mm.aj.f.c
                public final int dp(int i2, int i3) {
                    AppMethodBeat.i(27058);
                    fVar.sQ();
                    Log.i("MicroMsg.ContactSocialInfoUI", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 == 0 && i3 == 0) {
                        com.tencent.mm.aj.p.aYn();
                        if (ContactSocialInfoUI.a(ContactSocialInfoUI.this, str2, e.Mo(str))) {
                            Toast.makeText(ContactSocialInfoUI.this.getContext(), ContactSocialInfoUI.this.getContext().getString(R.string.bf1), 0).show();
                            AppMethodBeat.o(27058);
                            return 0;
                        }
                    }
                    Toast.makeText(ContactSocialInfoUI.this.getContext(), ContactSocialInfoUI.this.getContext().getString(R.string.bez), 0).show();
                    AppMethodBeat.o(27058);
                    return 0;
                }
            });
            AppMethodBeat.o(27068);
        } else if (contactSocialInfoUI.q(str2, Mo)) {
            Toast.makeText(contactSocialInfoUI.getContext(), contactSocialInfoUI.getContext().getString(R.string.bf1), 0).show();
            AppMethodBeat.o(27068);
        } else {
            Toast.makeText(contactSocialInfoUI.getContext(), contactSocialInfoUI.getContext().getString(R.string.bez), 0).show();
            AppMethodBeat.o(27068);
        }
    }
}
