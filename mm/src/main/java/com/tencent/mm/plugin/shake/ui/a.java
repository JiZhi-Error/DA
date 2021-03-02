package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements bc, com.tencent.mm.pluginsdk.b.a, MStorageEx.IOnStorageChange {
    private as contact;
    private Context context;
    private f screen;

    public a(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(28362);
        Log.d("MicroMsg.ContactWidgetShake", "handleEvent : key = ".concat(String.valueOf(str)));
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(28362);
            return false;
        } else if (str.equals("contact_info_shake_go_shake")) {
            Intent intent = new Intent();
            intent.setClass(this.context, ShakeReportUI.class);
            Context context2 = this.context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/shake/ui/ContactWidgetShake", "goShake", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/shake/ui/ContactWidgetShake", "goShake", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity) this.context).finish();
            AppMethodBeat.o(28362);
            return true;
        } else if (str.equals("contact_info_shake_install")) {
            C(this.context, true);
            AppMethodBeat.o(28362);
            return true;
        } else if (str.equals("contact_info_shake_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.shake.ui.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(28359);
                    a.C(a.this.context, false);
                    AppMethodBeat.o(28359);
                }
            }, null);
            AppMethodBeat.o(28362);
            return true;
        } else {
            Log.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(28362);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.i(28363);
        if ((z.aUl() & 256) == 0) {
            AppMethodBeat.o(28363);
            return true;
        }
        AppMethodBeat.o(28363);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2 = false;
        AppMethodBeat.i(28364);
        Assert.assertTrue(fVar != null);
        if (asVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.Jh(asVar.field_username));
        bg.aVF();
        c.azQ().add(this);
        bg.aVF();
        c.a(this);
        this.contact = asVar;
        this.screen = fVar;
        fVar.addPreferencesFromResource(R.xml.af);
        cCt();
        AppMethodBeat.o(28364);
        return true;
    }

    private void cCt() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(28365);
        boolean isOpen = isOpen();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.bfj));
            helperHeaderPreference.updateStatus(isOpen ? 1 : 0);
        }
        this.screen.m38do("contact_info_shake_install", isOpen);
        f fVar = this.screen;
        if (!isOpen) {
            z = true;
        } else {
            z = false;
        }
        fVar.m38do("contact_info_shake_go_shake", z);
        f fVar2 = this.screen;
        if (isOpen) {
            z2 = false;
        }
        fVar2.m38do("contact_info_shake_uninstall", z2);
        AppMethodBeat.o(28365);
    }

    public static void C(Context context2, final boolean z) {
        AppMethodBeat.i(28366);
        String string = z ? context2.getString(R.string.gst) : context2.getString(R.string.gt0);
        context2.getString(R.string.zb);
        final q a2 = h.a(context2, string, true, (DialogInterface.OnCancelListener) null);
        final AnonymousClass2 r1 = new MMHandler() {
            /* class com.tencent.mm.plugin.shake.ui.a.AnonymousClass2 */
            final /* synthetic */ s znB = null;

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                int i2;
                AppMethodBeat.i(28360);
                int aUl = z.aUl();
                if (z) {
                    i2 = aUl & -257;
                } else {
                    i2 = aUl | 256;
                }
                Log.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", Boolean.valueOf(z), Integer.valueOf(aUl), Integer.valueOf(i2));
                bg.aVF();
                c.azQ().set(34, Integer.valueOf(i2));
                bg.aVF();
                c.aSM().d(new l("", "", "", "", "", "", "", "", i2, "", ""));
                if (!z) {
                    m.eUp();
                }
                if (this.znB != null) {
                    this.znB.onNotifyChange(null, null);
                }
                AppMethodBeat.o(28360);
            }
        };
        new Timer().schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.shake.ui.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(28361);
                if (a2 != null) {
                    a2.dismiss();
                    r1.sendEmptyMessage(0);
                }
                AppMethodBeat.o(28361);
            }
        }, 1500);
        AppMethodBeat.o(28366);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(28367);
        bg.aVF();
        c.azQ().remove(this);
        bg.aVF();
        c.b(this);
        com.tencent.mm.plugin.shake.a.jRu.WZ();
        AppMethodBeat.o(28367);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.model.bc
    public final void aVw() {
        AppMethodBeat.i(28368);
        cCt();
        AppMethodBeat.o(28368);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(28369);
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        bg.aVF();
        if (mStorageEx != c.azQ() || nullAsInt <= 0) {
            Log.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(28369);
        } else if (nullAsInt == 7 || nullAsInt == 34) {
            cCt();
            AppMethodBeat.o(28369);
        } else {
            AppMethodBeat.o(28369);
        }
    }
}
