package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.ba.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class f implements a, MStorageEx.IOnStorageChange {
    private as contact;
    private Context context;
    private Map<String, Preference> kkJ = new HashMap();
    private com.tencent.mm.ui.base.preference.f screen;

    public f(Context context2) {
        AppMethodBeat.i(27127);
        this.context = context2;
        bg.aVF();
        c.aST().bka("facebookapp");
        AppMethodBeat.o(27127);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(27128);
        Log.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = ".concat(String.valueOf(str)));
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(27128);
            return false;
        } else if (str.equals("contact_info_facebookapp_install")) {
            C(this.context, true);
            AppMethodBeat.o(27128);
            return true;
        } else if (str.equals("contact_info_facebookapp_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.f.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27124);
                    f.C(f.this.context, false);
                    AppMethodBeat.o(27124);
                }
            }, null);
            AppMethodBeat.o(27128);
            return true;
        } else if (str.equals("contact_info_facebookapp_listfriend")) {
            Intent intent = new Intent(this.context, FacebookFriendUI.class);
            Context context2 = this.context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/profile/ui/ContactWidgetFacebookapp", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(27128);
            return true;
        } else if (str.equals("contact_info_facebookapp_account")) {
            com.tencent.mm.br.c.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.o(27128);
            return true;
        } else if (str.equals("contact_info_facebookapp_addr")) {
            com.tencent.mm.br.c.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.o(27128);
            return true;
        } else {
            Log.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(27128);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, as asVar, boolean z, int i2) {
        boolean z2 = false;
        AppMethodBeat.i(27129);
        Assert.assertTrue(fVar != null);
        if (asVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.Jb(asVar.field_username));
        bg.aVF();
        c.azQ().add(this);
        this.contact = asVar;
        this.screen = fVar;
        fVar.addPreferencesFromResource(R.xml.y);
        Preference bmg = fVar.bmg("contact_info_header_helper");
        if (bmg != null) {
            this.kkJ.put("contact_info_header_helper", bmg);
        }
        Preference bmg2 = fVar.bmg("contact_info_facebookapp_listfriend");
        if (bmg2 != null) {
            this.kkJ.put("contact_info_facebookapp_listfriend", bmg2);
        }
        Preference bmg3 = fVar.bmg("contact_info_facebookapp_account");
        if (bmg3 != null) {
            this.kkJ.put("contact_info_facebookapp_account", bmg3);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.bmg("contact_info_facebookapp_cat");
        if (preferenceCategory != null) {
            this.kkJ.put("contact_info_facebookapp_cat", preferenceCategory);
        }
        Preference bmg4 = fVar.bmg("contact_info_facebookapp_addr");
        if (bmg4 != null) {
            this.kkJ.put("contact_info_facebookapp_addr", bmg4);
        }
        PreferenceCategory preferenceCategory2 = (PreferenceCategory) fVar.bmg("contact_info_facebookapp_cat2");
        if (preferenceCategory2 != null) {
            this.kkJ.put("contact_info_facebookapp_cat2", preferenceCategory2);
        }
        Preference bmg5 = fVar.bmg("contact_info_facebookapp_install");
        if (bmg5 != null) {
            this.kkJ.put("contact_info_facebookapp_install", bmg5);
        }
        Preference bmg6 = fVar.bmg("contact_info_facebookapp_uninstall");
        if (bmg6 != null) {
            this.kkJ.put("contact_info_facebookapp_uninstall", bmg6);
        }
        cCt();
        AppMethodBeat.o(27129);
        return true;
    }

    private static boolean isOpen() {
        AppMethodBeat.i(27130);
        if ((z.aUl() & 8192) == 0) {
            AppMethodBeat.o(27130);
            return true;
        }
        AppMethodBeat.o(27130);
        return false;
    }

    private void cCt() {
        AppMethodBeat.i(27131);
        this.screen.removeAll();
        if (this.kkJ.containsKey("contact_info_header_helper")) {
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.kkJ.get("contact_info_header_helper");
            this.screen.c(helperHeaderPreference);
            helperHeaderPreference.bk(this.contact.field_username, this.contact.arI(), this.context.getString(R.string.baw));
            helperHeaderPreference.updateStatus(isOpen() ? 1 : 0);
        }
        if (this.kkJ.containsKey("contact_info_facebookapp_cat")) {
            this.screen.c(this.kkJ.get("contact_info_facebookapp_cat"));
        }
        if (!isOpen()) {
            if (this.kkJ.containsKey("contact_info_facebookapp_install")) {
                this.screen.c(this.kkJ.get("contact_info_facebookapp_install"));
            }
            AppMethodBeat.o(27131);
            return;
        }
        if (this.kkJ.containsKey("contact_info_facebookapp_account")) {
            Preference preference = this.kkJ.get("contact_info_facebookapp_account");
            this.screen.c(preference);
            if (z.aUF()) {
                preference.setSummary(R.string.glb);
            } else {
                preference.setSummary(R.string.gm4);
            }
        }
        if (z.aUF()) {
            b.bdF();
            if (this.kkJ.containsKey("contact_info_facebookapp_addr")) {
                Preference preference2 = this.kkJ.get("contact_info_facebookapp_addr");
                this.screen.c(preference2);
                bg.aVF();
                preference2.setSummary((String) c.azQ().get(65826, (Object) null));
            }
        }
        if (this.kkJ.containsKey("contact_info_facebookapp_cat2")) {
            this.screen.c(this.kkJ.get("contact_info_facebookapp_cat2"));
        }
        if (this.kkJ.containsKey("contact_info_facebookapp_uninstall")) {
            this.screen.c(this.kkJ.get("contact_info_facebookapp_uninstall"));
        }
        AppMethodBeat.o(27131);
    }

    public static void C(Context context2, final boolean z) {
        AppMethodBeat.i(27132);
        String string = z ? context2.getString(R.string.gst) : context2.getString(R.string.gt0);
        context2.getString(R.string.zb);
        final q a2 = h.a(context2, string, true, (DialogInterface.OnCancelListener) null);
        final AnonymousClass2 r1 = new MMHandler() {
            /* class com.tencent.mm.plugin.profile.ui.f.AnonymousClass2 */
            final /* synthetic */ s znB = null;

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                int i2;
                AppMethodBeat.i(27125);
                int aUl = z.aUl();
                if (z) {
                    i2 = aUl & -8193;
                } else {
                    i2 = aUl | 8192;
                }
                bg.aVF();
                c.azQ().set(34, Integer.valueOf(i2));
                bg.aVF();
                c.aSM().d(new l("", "", "", "", "", "", "", "", i2, "", ""));
                if (!z) {
                    f.clearData();
                }
                if (this.znB != null) {
                    this.znB.onNotifyChange(null, null);
                }
                AppMethodBeat.o(27125);
            }
        };
        new Timer().schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.profile.ui.f.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(27126);
                if (a2 != null) {
                    a2.dismiss();
                    r1.sendEmptyMessage(0);
                }
                AppMethodBeat.o(27126);
            }
        }, 1500);
        AppMethodBeat.o(27132);
    }

    public static void clearData() {
        AppMethodBeat.i(231864);
        com.tencent.mm.plugin.account.a.getFacebookFrdStg().bnU();
        bg.aVF();
        c.azQ().set(65828, "");
        bg.aVF();
        c.aST().bjW("facebookapp");
        bg.aVF();
        c.aSQ().aEE("facebookapp");
        AppMethodBeat.o(231864);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27133);
        bg.aVF();
        c.azQ().remove(this);
        com.tencent.mm.plugin.profile.b.jRu.WZ();
        AppMethodBeat.o(27133);
        return true;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(27134);
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        bg.aVF();
        if (mStorageEx != c.azQ() || nullAsInt <= 0) {
            Log.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(27134);
        } else if (nullAsInt == 40 || nullAsInt == 34 || nullAsInt == 65825) {
            cCt();
            AppMethodBeat.o(27134);
        } else {
            AppMethodBeat.o(27134);
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }
}
