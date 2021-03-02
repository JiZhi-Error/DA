package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.b.a, MStorageEx.IOnStorageChange {
    private as contact;
    private Context context;
    private Map<String, Preference> kkJ = new HashMap();
    private f screen;

    public a(Context context2) {
        AppMethodBeat.i(26378);
        this.context = context2;
        AppMethodBeat.o(26378);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(26379);
        Log.d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = ".concat(String.valueOf(str)));
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(26379);
            return false;
        } else if (str.equals("contact_info_masssend_view")) {
            Intent intent = new Intent(this.context, MassSendHistoryUI.class);
            Context context2 = this.context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/masssend/ui/ContactWidgetMassSend", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/masssend/ui/ContactWidgetMassSend", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(26379);
            return true;
        } else if (str.equals("contact_info_masssend_clear_data")) {
            h.c(this.context, this.context.getString(R.string.ba3), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.masssend.ui.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(26374);
                    a.clearData();
                    AppMethodBeat.o(26374);
                }
            }, null);
            AppMethodBeat.o(26379);
            return true;
        } else if (str.equals("contact_info_masssend_install")) {
            C(this.context, true);
            AppMethodBeat.o(26379);
            return true;
        } else if (str.equals("contact_info_masssend_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.masssend.ui.a.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(26375);
                    a.C(a.this.context, false);
                    AppMethodBeat.o(26375);
                }
            }, null);
            AppMethodBeat.o(26379);
            return true;
        } else {
            Log.e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(26379);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.i(26380);
        if ((z.aUl() & 65536) == 0) {
            AppMethodBeat.o(26380);
            return true;
        }
        AppMethodBeat.o(26380);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2 = false;
        AppMethodBeat.i(26381);
        Assert.assertTrue(fVar != null);
        if (asVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.Jc(asVar.field_username));
        bg.aVF();
        c.azQ().add(this);
        this.contact = asVar;
        this.screen = fVar;
        fVar.addPreferencesFromResource(R.xml.a4);
        cCt();
        AppMethodBeat.o(26381);
        return true;
    }

    private void cCt() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(26382);
        boolean isOpen = isOpen();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_masssend_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.bcm));
        helperHeaderPreference.updateStatus(isOpen ? 1 : 0);
        this.screen.m38do("contact_info_masssend_install", isOpen);
        f fVar = this.screen;
        if (!isOpen) {
            z = true;
        } else {
            z = false;
        }
        fVar.m38do("contact_info_masssend_view", z);
        f fVar2 = this.screen;
        if (!isOpen) {
            z2 = true;
        } else {
            z2 = false;
        }
        fVar2.m38do("contact_info_masssend_clear_data", z2);
        f fVar3 = this.screen;
        if (isOpen) {
            z3 = false;
        }
        fVar3.m38do("contact_info_masssend_uninstall", z3);
        AppMethodBeat.o(26382);
    }

    public static void C(Context context2, final boolean z) {
        AppMethodBeat.i(26383);
        String string = z ? context2.getString(R.string.gst) : context2.getString(R.string.gt0);
        context2.getString(R.string.zb);
        final q a2 = h.a(context2, string, true, (DialogInterface.OnCancelListener) null);
        final AnonymousClass3 r1 = new MMHandler() {
            /* class com.tencent.mm.plugin.masssend.ui.a.AnonymousClass3 */
            final /* synthetic */ s znB = null;

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                int i2;
                AppMethodBeat.i(26376);
                if (z) {
                    a.ehH();
                }
                int aUl = z.aUl();
                if (z) {
                    i2 = aUl & -65537;
                } else {
                    i2 = aUl | 65536;
                }
                bg.aVF();
                c.azQ().set(34, Integer.valueOf(i2));
                bg.aVF();
                c.aSM().d(new l("", "", "", "", "", "", "", "", i2, "", ""));
                if (!z) {
                    a.clearData();
                }
                if (this.znB != null) {
                    this.znB.onNotifyChange(null, null);
                }
                AppMethodBeat.o(26376);
            }
        };
        new Timer().schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.masssend.ui.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(26377);
                if (a2 != null) {
                    a2.dismiss();
                    r1.sendEmptyMessage(0);
                }
                AppMethodBeat.o(26377);
            }
        }, 1500);
        AppMethodBeat.o(26383);
    }

    public static void clearData() {
        AppMethodBeat.i(26384);
        b ehF = com.tencent.mm.plugin.masssend.a.h.ehF();
        if (ehF.iFy.execSQL("massendinfo", "delete from massendinfo")) {
            ehF.doNotify();
        }
        bg.aVF();
        c.aST().bjW("masssendapp");
        AppMethodBeat.o(26384);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(26385);
        bg.aVF();
        c.azQ().remove(this);
        com.tencent.mm.plugin.masssend.a.jRu.WZ();
        AppMethodBeat.o(26385);
        return true;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(26386);
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        bg.aVF();
        if (mStorageEx != c.azQ() || nullAsInt <= 0) {
            Log.e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(26386);
        } else if (nullAsInt == 40 || nullAsInt == 34 || nullAsInt == 7) {
            cCt();
            AppMethodBeat.o(26386);
        } else {
            AppMethodBeat.o(26386);
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    static void ehH() {
    }
}
