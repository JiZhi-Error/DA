package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.qqmail.PluginQQMail;
import com.tencent.mm.plugin.qqmail.d.ac;
import com.tencent.mm.plugin.qqmail.d.p;
import com.tencent.mm.plugin.qqmail.d.r;
import com.tencent.mm.plugin.qqmail.d.s;
import com.tencent.mm.plugin.qqmail.d.t;
import com.tencent.mm.plugin.qqmail.d.x;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class a implements i, com.tencent.mm.pluginsdk.b.a {
    private boolean Bdx;
    private p Bvl;
    private as contact;
    Context context;
    private boolean dCs;
    private boolean enable;
    ProgressDialog gtM;
    private f screen;

    public a(Context context2) {
        AppMethodBeat.i(122992);
        Assert.assertTrue(context2 != null);
        this.context = context2;
        AppMethodBeat.o(122992);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(122993);
        Log.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = ".concat(String.valueOf(str)));
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(122993);
            return false;
        } else if (str.equals("contact_info_qqmailhelper_view")) {
            Intent intent = new Intent();
            if (this.Bdx) {
                intent.putExtra("Chat_User", this.contact.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.contact.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                com.tencent.mm.plugin.qqmail.a.a.jRt.d(intent, this.context);
            }
            ((Activity) this.context).finish();
            AppMethodBeat.o(122993);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_compose")) {
            Intent intent2 = new Intent(this.context, ComposeUI.class);
            if (this.Bdx) {
                intent2.putExtra("Chat_User", this.contact.field_username);
                intent2.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent2);
            } else {
                intent2.putExtra("Chat_User", this.contact.field_username);
                intent2.addFlags(67108864);
                Context context2 = this.context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/qqmail/ui/ContactWidgetQQMail", "composeMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            ((Activity) this.context).finish();
            AppMethodBeat.o(122993);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_set_files_view")) {
            Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(Util.nullAsNil((String) g.aAh().azQ().get(29, (Object) null))));
            intent3.putExtra("title", this.context.getString(R.string.be7));
            intent3.putExtra("zoom", false);
            intent3.putExtra("show_bottom", false);
            intent3.putExtra("showShare", false);
            intent3.putExtra("vertical_scroll", false);
            com.tencent.mm.plugin.qqmail.a.a.jRt.i(intent3, this.context);
            AppMethodBeat.o(122993);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_recv_remind")) {
            sT(((CheckBoxPreference) this.screen.bmg(str)).isChecked());
            AppMethodBeat.o(122993);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_clear_data")) {
            h.a(this.context, this.context.getString(R.string.ba5), "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.qqmail.ui.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(122986);
                    ac.eGs();
                    AppMethodBeat.o(122986);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(122993);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_install")) {
            eGM();
            AppMethodBeat.o(122993);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.qqmail.ui.a.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(122987);
                    if (!Util.isNullOrNil(a.eGL())) {
                        a aVar = a.this;
                        aVar.gtM = h.a(aVar.context, aVar.context.getString(R.string.a06), false, (DialogInterface.OnCancelListener) null);
                        g.azz().a(new t(), 0);
                        AppMethodBeat.o(122987);
                        return;
                    }
                    a.A(false, null);
                    a.this.cCt();
                    AppMethodBeat.o(122987);
                }
            }, null);
            AppMethodBeat.o(122993);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_account")) {
            eGM();
            AppMethodBeat.o(122993);
            return true;
        } else {
            Log.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(122993);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2;
        AppMethodBeat.i(122994);
        Assert.assertTrue(fVar != null);
        if (asVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.IW(asVar.field_username));
        g.aAg().hqi.a(3848, this);
        g.aAg().hqi.a(3889, this);
        g.azz().a(586, this);
        g.aAg().hqi.a(129, this);
        this.Bdx = z;
        this.contact = asVar;
        this.screen = fVar;
        fVar.addPreferencesFromResource(R.xml.ab);
        cCt();
        if (((Activity) this.context).getIntent().getBooleanExtra("key_need_rebind_xmail", false)) {
            eGM();
        }
        AppMethodBeat.o(122994);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void cCt() {
        boolean z;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        AppMethodBeat.i(122995);
        this.enable = (z.aUl() & 1) == 0;
        if (Util.nullAsNil((Integer) g.aAh().azQ().get(17, (Object) null)) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.dCs = z;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.be8));
        if (this.enable) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        helperHeaderPreference.updateStatus(i2);
        this.screen.m38do("contact_info_qqmailhelper_install", this.enable);
        f fVar = this.screen;
        if (!this.enable) {
            z2 = true;
        } else {
            z2 = false;
        }
        fVar.m38do("contact_info_qqmailhelper_view", z2);
        f fVar2 = this.screen;
        if (!this.enable) {
            z3 = true;
        } else {
            z3 = false;
        }
        fVar2.m38do("contact_info_qqmailhelper_compose", z3);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("contact_info_qqmailhelper_recv_remind");
        if (checkBoxPreference != null) {
            checkBoxPreference.setChecked(this.dCs);
        }
        f fVar3 = this.screen;
        if (!this.enable) {
            z4 = true;
        } else {
            z4 = false;
        }
        fVar3.m38do("contact_info_qqmailhelper_recv_remind", z4);
        f fVar4 = this.screen;
        if (!this.enable || !this.dCs) {
            z5 = true;
        } else {
            z5 = false;
        }
        fVar4.m38do("contact_info_qqmailhelper_set_files_view", z5);
        this.screen.m38do("contact_info_qqmailhelper_download_mgr_view", true);
        f fVar5 = this.screen;
        if (!this.enable) {
            z6 = true;
        } else {
            z6 = false;
        }
        fVar5.m38do("contact_info_qqmailhelper_clear_data", z6);
        f fVar6 = this.screen;
        if (!this.enable) {
            z7 = true;
        } else {
            z7 = false;
        }
        fVar6.m38do("contact_info_qqmailhelper_uninstall", z7);
        f fVar7 = this.screen;
        if (!this.enable) {
            z8 = true;
        } else {
            z8 = false;
        }
        fVar7.m38do("contact_info_qqmailhelper_account", z8);
        Preference bmg = this.screen.bmg("contact_info_qqmailhelper_account");
        if (this.enable) {
            bmg.alO(8);
            bmg.setEnabled(false);
            String eGL = eGL();
            int i3 = g.aAh().azQ().getInt(9, 0);
            int i4 = g.aAh().azQ().getInt(ar.a.USERINFO_EXT_USER_STATUS_INT_SYNC, 0);
            Log.i("MicroMsg.ContactWidgetQQMail", "bindXMail %s, bindQQ %d, extUserStatus %d", eGL, Integer.valueOf(i3), Integer.valueOf(i4));
            if (!Util.isNullOrNil(eGL)) {
                if ((i4 & 2) != 0) {
                    bmg.setSummary(eGL);
                } else {
                    bmg.setSummary(this.context.getString(R.string.be3));
                    bmg.alO(0);
                    bmg.setEnabled(true);
                }
            } else if (i3 != 0) {
                bmg.setSummary(i3 + "@qq.com");
            } else {
                bmg.setSummary(this.context.getString(R.string.be3));
                bmg.alO(0);
                bmg.setEnabled(true);
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(122995);
    }

    static String eGL() {
        AppMethodBeat.i(198698);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_EXT_BIND_XMAIL_STRING_SYNC, (Object) null);
        Log.i("MicroMsg.ContactWidgetQQMail", "last bind xmail %s", str);
        AppMethodBeat.o(198698);
        return str;
    }

    private void eGM() {
        AppMethodBeat.i(198699);
        this.gtM = h.a(this.context, this.context.getString(R.string.a06), false, (DialogInterface.OnCancelListener) null);
        g.azz().a(new r(eGL()), 0);
        AppMethodBeat.o(198699);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(122998);
        g.aAg().hqi.b(3848, this);
        g.aAg().hqi.b(3889, this);
        g.azz().b(586, this);
        g.aAg().hqi.b(129, this);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        AppMethodBeat.o(122998);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(198700);
        if (i2 == 291) {
            if (i3 == -1 && intent != null) {
                A(true, intent.getStringExtra("Key_Bind_XMail"));
                cCt();
                AppMethodBeat.o(198700);
                return;
            }
        } else if (i2 == 292) {
            Bundle bundle = null;
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (bundle != null) {
                final String string = bundle.getString("key_qq_mail");
                final String string2 = bundle.getString("key_bind_ticket");
                boolean z = bundle.getBoolean("key_need_second_pwd", false);
                final String string3 = bundle.getString("key_second_pwd_key");
                Log.i("MicroMsg.ContactWidgetQQMail", "mail %s, ticket %s, needSecondPwd %s, secPwdKey %s", string, string2, Boolean.valueOf(z), string3);
                if (!Util.isNullOrNil(string, string2)) {
                    if (!z) {
                        h.d(this.context, this.context.getString(R.string.be4), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.qqmail.ui.a.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(198697);
                                a.a(a.this, string, string2, "", "");
                                AppMethodBeat.o(198697);
                            }
                        });
                    } else if (!Util.isNullOrNil(string3)) {
                        h.d(this.context, this.context.getString(R.string.be4), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.qqmail.ui.a.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(122988);
                                a.this.aC(string, string2, string3);
                                AppMethodBeat.o(122988);
                            }
                        });
                        AppMethodBeat.o(198700);
                        return;
                    } else {
                        Toast.makeText(this.context, this.context.getString(R.string.gpy), 1).show();
                        AppMethodBeat.o(198700);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(198700);
    }

    /* access modifiers changed from: package-private */
    public final void aC(final String str, final String str2, final String str3) {
        AppMethodBeat.i(198701);
        View inflate = View.inflate(this.context, R.layout.bp6, null);
        final EditText editText = (EditText) inflate.findViewById(R.id.hfq);
        h.a(this.context, this.context.getString(R.string.be6), inflate, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.a.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(122991);
                if (editText.getText() != null && !Util.isNullOrNil(editText.getText())) {
                    a.a(a.this, str, str2, str3, editText.getText().toString());
                }
                AppMethodBeat.o(122991);
            }
        });
        AppMethodBeat.o(198701);
    }

    static void A(boolean z, String str) {
        int i2;
        AppMethodBeat.i(198702);
        int aUl = z.aUl();
        if (z) {
            i2 = aUl & -2;
            g.aAh().azQ().set(ar.a.USERINFO_EXT_BIND_XMAIL_STRING_SYNC, str);
            g.aAh().azQ().set(ar.a.USERINFO_EXT_USER_STATUS_INT_SYNC, Integer.valueOf(g.aAh().azQ().getInt(ar.a.USERINFO_EXT_USER_STATUS_INT_SYNC, 0) | 2));
            sT(true);
        } else {
            i2 = aUl | 1;
            g.aAh().azQ().set(ar.a.USERINFO_EXT_BIND_XMAIL_STRING_SYNC, "");
            g.aAh().azQ().set(ar.a.USERINFO_EXT_USER_STATUS_INT_SYNC, Integer.valueOf(g.aAh().azQ().getInt(ar.a.USERINFO_EXT_USER_STATUS_INT_SYNC, 0) & -3));
            ac.eGs();
        }
        g.aAh().azQ().set(34, Integer.valueOf(i2));
        ((l) g.af(l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i2, "", ""));
        com.tencent.mm.plugin.qqmail.a.a.jRu.WZ();
        AppMethodBeat.o(198702);
    }

    private static boolean sT(boolean z) {
        AppMethodBeat.i(198703);
        g.aAg().hqi.a(new s(z, ""), 0);
        AppMethodBeat.o(198703);
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(123001);
        Log.i("MicroMsg.ContactWidgetQQMail", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (qVar.getType() != 3848) {
            if (qVar.getType() == 3889) {
                if (i2 == 0 && i3 == 0) {
                    A(false, null);
                } else {
                    if (Util.isNullOrNil(str)) {
                        str = this.context.getString(R.string.gq0);
                    }
                    Toast.makeText(this.context, str, 0).show();
                    AppMethodBeat.o(123001);
                    return;
                }
            } else if (qVar.getType() != 586) {
                if (qVar.getType() == 129) {
                    if (!(i2 == 0 && i3 == 0)) {
                        if (Util.isNullOrNil(str)) {
                            str = this.context.getString(R.string.wn);
                        }
                        Toast.makeText(this.context, str, 0).show();
                    }
                }
                AppMethodBeat.o(123001);
            } else if (qVar != this.Bvl) {
                Log.i("MicroMsg.ContactWidgetQQMail", "not my scene, ignore");
                AppMethodBeat.o(123001);
                return;
            } else {
                int eGo = ((p) qVar).eGo();
                if (i2 == 0 && i3 == 0 && eGo == 0) {
                    Toast.makeText(this.context, this.context.getString(R.string.gpz), 0).show();
                    A(true, ((p) qVar).BrO);
                    cCt();
                    ((PluginQQMail) g.ah(PluginQQMail.class)).getNormalMailAppService().reset();
                    AppMethodBeat.o(123001);
                    return;
                } else if (eGo == -39006) {
                    if (Util.isNullOrNil(str)) {
                        str = this.context.getString(R.string.frf);
                    }
                    Toast.makeText(this.context, str, 0).show();
                    aC(((p) qVar).BrO, ((p) qVar).dHx, ((p) qVar).BrP);
                    AppMethodBeat.o(123001);
                    return;
                } else {
                    if (Util.isNullOrNil(str)) {
                        str = this.context.getString(R.string.gpy);
                    }
                    Toast.makeText(this.context, str, 1).show();
                    AppMethodBeat.o(123001);
                    return;
                }
            }
            cCt();
            AppMethodBeat.o(123001);
        } else if (i2 == 0 && i3 == 0) {
            String str2 = ((x) ((r) qVar).hJu.iLL.iLR).Bsh;
            String str3 = ((x) ((r) qVar).hJu.iLL.iLR).Bsi;
            String str4 = ((x) ((r) qVar).hJu.iLL.iLR).Bsg;
            Log.i("MicroMsg.ContactWidgetQQMail", "wxMail %s, wxLoginUrl %s, qqLoginUrl %s", str2, str3, str4);
            if (Util.isNullOrNil(str2)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str3);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                c.b(this.context, "webview", ".ui.tools.WebViewUI", intent, (int) com.tencent.mm.plugin.appbrand.jsapi.audio.l.CTRL_INDEX);
                AppMethodBeat.o(123001);
                return;
            }
            Intent intent2 = new Intent();
            intent2.setClass(this.context, PrepareBindXMailUI.class);
            intent2.putExtra("Key_WeXin_Mail", str2);
            intent2.putExtra("Key_QQMail_Login_Url", str4);
            intent2.putExtra("Key_Last_Bind_Mail", eGL());
            ((Activity) this.context).startActivityForResult(intent2, 291);
            AppMethodBeat.o(123001);
        } else {
            if (Util.isNullOrNil(str)) {
                str = this.context.getString(R.string.gpy);
            }
            Toast.makeText(this.context, str, 0).show();
            AppMethodBeat.o(123001);
        }
    }

    static /* synthetic */ void a(a aVar, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(198704);
        aVar.Bvl = new p(3, str, str2, str3, str4);
        g.azz().a(aVar.Bvl, 0);
        aVar.gtM = h.a(aVar.context, aVar.context.getString(R.string.a06), false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(198704);
    }
}
