package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
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
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class b implements a, MStorageEx.IOnStorageChange {
    private boolean Bdx;
    private as contact;
    private Context context;
    private f screen;

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(232022);
        bVar.cCt();
        AppMethodBeat.o(232022);
    }

    static /* synthetic */ void f(int i2, boolean z, int i3) {
        AppMethodBeat.i(232021);
        e(i2, z, i3);
        AppMethodBeat.o(232021);
    }

    public b(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(27750);
        Log.d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = ".concat(String.valueOf(str)));
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(27750);
            return false;
        } else if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent(this.context, QConversationUI.class);
            if (this.Bdx) {
                ((Activity) this.context).setResult(-1, intent);
            } else {
                Context context2 = this.context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/qmessage/ui/ContactWidgetQMessage", "viewMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/qmessage/ui/ContactWidgetQMessage", "viewMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            ((Activity) this.context).finish();
            AppMethodBeat.o(27750);
            return true;
        } else if (str.equals("contact_info_qmessage_recv_offline_msg")) {
            final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg(str);
            if (checkBoxPreference.isChecked()) {
                e(64, true, 5);
            } else if (!Ve(8192)) {
                e(64, false, 5);
                AppMethodBeat.o(27750);
                return true;
            } else {
                h.a(this.context, (int) R.string.bdq, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.qmessage.ui.b.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(27743);
                        b.f(8192, false, 12);
                        b.f(64, false, 5);
                        AppMethodBeat.o(27743);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.qmessage.ui.b.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(27744);
                        checkBoxPreference.setChecked(true);
                        b.a(b.this);
                        AppMethodBeat.o(27744);
                    }
                });
            }
            AppMethodBeat.o(27750);
            return true;
        } else if (str.equals("contact_info_qmessage_display_weixin_online")) {
            e(8192, ((CheckBoxPreference) this.screen.bmg(str)).isChecked(), 12);
            AppMethodBeat.o(27750);
            return true;
        } else if (str.equals("contact_info_qmessage_clear_data")) {
            h.c(this.context, this.context.getString(R.string.ba3), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.qmessage.ui.b.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27745);
                    g.eGb();
                    AppMethodBeat.o(27745);
                }
            }, null);
            AppMethodBeat.o(27750);
            return true;
        } else if (str.equals("contact_info_qmessage_install")) {
            bg.aVF();
            if (Util.nullAsNil((Integer) c.azQ().get(9, (Object) null)) == 0) {
                h.b(this.context, (int) R.string.gwu, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.qmessage.ui.b.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(27746);
                        com.tencent.mm.br.c.a(b.this.context, "account", "com.tencent.mm.plugin.account.bind.ui.BindQQUI", (Intent) null);
                        AppMethodBeat.o(27746);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.qmessage.ui.b.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(27750);
                return true;
            }
            C(this.context, true);
            AppMethodBeat.o(27750);
            return true;
        } else if (str.equals("contact_info_qmessage_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.qmessage.ui.b.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27747);
                    b.C(b.this.context, false);
                    AppMethodBeat.o(27747);
                }
            }, null);
            AppMethodBeat.o(27750);
            return true;
        } else {
            Log.e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(27750);
            return false;
        }
    }

    public static void C(Context context2, final boolean z) {
        AppMethodBeat.i(27751);
        String string = z ? context2.getString(R.string.gst) : context2.getString(R.string.gt0);
        context2.getString(R.string.zb);
        final q a2 = h.a(context2, string, true, (DialogInterface.OnCancelListener) null);
        final AnonymousClass7 r1 = new MMHandler() {
            /* class com.tencent.mm.plugin.qmessage.ui.b.AnonymousClass7 */
            final /* synthetic */ s znB = null;

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                int i2;
                AppMethodBeat.i(27748);
                b.f(64, z, 5);
                b.f(8192, z, 12);
                int aUl = z.aUl();
                if (z) {
                    i2 = aUl & -33;
                } else {
                    i2 = aUl | 32;
                }
                bg.aVF();
                c.azQ().set(34, Integer.valueOf(i2));
                bg.aVF();
                c.aSM().d(new l("", "", "", "", "", "", "", "", i2, "", ""));
                if (!z) {
                    g.eGb();
                }
                if (this.znB != null) {
                    this.znB.onNotifyChange(null, null);
                }
                AppMethodBeat.o(27748);
            }
        };
        new Timer().schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.qmessage.ui.b.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(27749);
                if (a2 != null) {
                    a2.dismiss();
                    r1.sendEmptyMessage(0);
                }
                AppMethodBeat.o(27749);
            }
        }, 5000);
        AppMethodBeat.o(27751);
    }

    private static boolean isOpen() {
        AppMethodBeat.i(27752);
        if ((z.aUl() & 32) == 0) {
            AppMethodBeat.o(27752);
            return true;
        }
        AppMethodBeat.o(27752);
        return false;
    }

    private static boolean Ve(int i2) {
        AppMethodBeat.i(27753);
        if ((z.aUc() & i2) != 0) {
            AppMethodBeat.o(27753);
            return true;
        }
        AppMethodBeat.o(27753);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(27754);
        if (asVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.Ja(asVar.field_username));
        if (fVar != null) {
            z3 = true;
        }
        Assert.assertTrue(z3);
        bg.aVF();
        c.azQ().add(this);
        this.contact = asVar;
        this.Bdx = z;
        this.screen = fVar;
        cCt();
        AppMethodBeat.o(27754);
        return true;
    }

    private void cCt() {
        AppMethodBeat.i(27755);
        boolean isOpen = isOpen();
        boolean Ve = Ve(64);
        Ve(8192);
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(R.xml.a_);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.bdt));
        helperHeaderPreference.updateStatus(isOpen ? 1 : 0);
        if (!isOpen) {
            this.screen.bmi("contact_info_view_message");
            this.screen.bmi("contact_info_qmessage_recv_offline_msg");
            this.screen.bmi("contact_info_qmessage_uninstall");
            this.screen.bmi("contact_info_qmessage_clear_data");
            AppMethodBeat.o(27755);
            return;
        }
        this.screen.bmi("contact_info_qmessage_install");
        ((CheckBoxPreference) this.screen.bmg("contact_info_qmessage_recv_offline_msg")).setChecked(Ve);
        AppMethodBeat.o(27755);
    }

    private static void e(int i2, boolean z, int i3) {
        int i4;
        AppMethodBeat.i(27756);
        int aUc = z.aUc();
        if (z) {
            i4 = aUc | i2;
        } else {
            i4 = aUc & (i2 ^ -1);
        }
        bg.aVF();
        c.azQ().set(7, Integer.valueOf(i4));
        int i5 = z ? 1 : 2;
        bg.aVF();
        c.aSM().d(new com.tencent.mm.ba.h(i3, i5));
        AppMethodBeat.o(27756);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27757);
        bg.aVF();
        c.azQ().remove(this);
        com.tencent.mm.plugin.qmessage.a.Bqd.WZ();
        AppMethodBeat.o(27757);
        return true;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(27758);
        bg.aVF();
        if (mStorageEx != c.azQ()) {
            AppMethodBeat.o(27758);
            return;
        }
        cCt();
        AppMethodBeat.o(27758);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }
}
