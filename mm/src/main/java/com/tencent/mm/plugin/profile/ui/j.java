package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.profile.b;
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

public final class j implements a, MStorageEx.IOnStorageChange {
    private static boolean isDeleteCancel = false;
    private as contact;
    private Context context;
    private f screen;

    public j(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(27171);
        Log.d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = ".concat(String.valueOf(str)));
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(27171);
            return false;
        } else if (str.equals("contact_info_medianote_view")) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", "medianote");
            b.jRt.d(intent, this.context);
            b.jRu.WZ();
            AppMethodBeat.o(27171);
            return true;
        } else if (str.equals("contact_info_medianote_sync_to_qqmail")) {
            if (!z.aUM()) {
                h.a(this.context, (int) R.string.bcp, (int) R.string.bco, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.profile.ui.j.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(27163);
                        b.jRt.g(new Intent(), j.this.context);
                        AppMethodBeat.o(27163);
                    }
                }, (DialogInterface.OnClickListener) null);
                cCt();
            } else {
                sI(((CheckBoxPreference) this.screen.bmg(str)).isChecked());
            }
            AppMethodBeat.o(27171);
            return true;
        } else if (str.equals("contact_info_medianote_clear_data")) {
            h.c(this.context, this.context.getString(R.string.ba3), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.j.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27164);
                    j.access$100(j.this.context);
                    AppMethodBeat.o(27164);
                }
            }, null);
            AppMethodBeat.o(27171);
            return true;
        } else if (str.equals("contact_info_medianote_install")) {
            C(this.context, true);
            AppMethodBeat.o(27171);
            return true;
        } else if (str.equals("contact_info_medianote_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.j.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27165);
                    j.C(j.this.context, false);
                    AppMethodBeat.o(27165);
                }
            }, null);
            AppMethodBeat.o(27171);
            return true;
        } else {
            Log.e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(27171);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.i(27172);
        if ((z.aUl() & 16) == 0) {
            AppMethodBeat.o(27172);
            return true;
        }
        AppMethodBeat.o(27172);
        return false;
    }

    private static boolean eEx() {
        AppMethodBeat.i(27173);
        int aUc = z.aUc();
        if (!z.aUM()) {
            if ((aUc & 16384) != 0) {
                bg.aVF();
                c.azQ().set(7, Integer.valueOf(aUc & -16385));
            }
            AppMethodBeat.o(27173);
            return false;
        } else if ((aUc & 16384) != 0) {
            AppMethodBeat.o(27173);
            return true;
        } else {
            AppMethodBeat.o(27173);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2 = false;
        AppMethodBeat.i(27174);
        Assert.assertTrue(fVar != null);
        if (asVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.Ji(asVar.field_username));
        bg.aVF();
        c.azQ().add(this);
        this.contact = asVar;
        this.screen = fVar;
        fVar.addPreferencesFromResource(R.xml.a5);
        cCt();
        AppMethodBeat.o(27174);
        return true;
    }

    private void cCt() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        AppMethodBeat.i(27175);
        boolean isOpen = isOpen();
        boolean eEx = eEx();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.bcq));
        helperHeaderPreference.updateStatus(isOpen ? 1 : 0);
        this.screen.m38do("contact_info_medianote_install", isOpen);
        f fVar = this.screen;
        if (!isOpen) {
            z = true;
        } else {
            z = false;
        }
        fVar.m38do("contact_info_medianote_view", z);
        if (!isOpen || z.aUM()) {
            z2 = isOpen;
        } else {
            if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("BindQQSwitch"), 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Log.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
        }
        f fVar2 = this.screen;
        if (!z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        fVar2.m38do("contact_info_medianote_sync_to_qqmail", z3);
        f fVar3 = this.screen;
        if (!isOpen) {
            z4 = true;
        } else {
            z4 = false;
        }
        fVar3.m38do("contact_info_medianote_clear_data", z4);
        f fVar4 = this.screen;
        if (isOpen) {
            z5 = false;
        }
        fVar4.m38do("contact_info_medianote_uninstall", z5);
        ((CheckBoxPreference) this.screen.bmg("contact_info_medianote_sync_to_qqmail")).setChecked(eEx);
        AppMethodBeat.o(27175);
    }

    public static void C(final Context context2, final boolean z) {
        AppMethodBeat.i(27176);
        String string = z ? context2.getString(R.string.gst) : context2.getString(R.string.gt0);
        context2.getString(R.string.zb);
        final q a2 = h.a(context2, string, true, (DialogInterface.OnCancelListener) null);
        final AnonymousClass4 r1 = new MMHandler() {
            /* class com.tencent.mm.plugin.profile.ui.j.AnonymousClass4 */
            final /* synthetic */ s znB = null;

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                int i2;
                AppMethodBeat.i(27166);
                if (z) {
                    j.sI(true);
                }
                int aUl = z.aUl();
                if (z) {
                    i2 = aUl & -17;
                } else {
                    i2 = aUl | 16;
                }
                bg.aVF();
                c.azQ().set(34, Integer.valueOf(i2));
                bg.aVF();
                c.aSM().d(new l("", "", "", "", "", "", "", "", i2, "", ""));
                if (!z) {
                    j.access$100(context2);
                }
                if (this.znB != null) {
                    this.znB.onNotifyChange(null, null);
                }
                AppMethodBeat.o(27166);
            }
        };
        new Timer().schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.profile.ui.j.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(27167);
                if (a2 != null) {
                    a2.dismiss();
                    r1.sendEmptyMessage(0);
                }
                AppMethodBeat.o(27167);
            }
        }, 1500);
        AppMethodBeat.o(27176);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27177);
        bg.aVF();
        c.azQ().remove(this);
        b.jRu.WZ();
        AppMethodBeat.o(27177);
        return true;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(27178);
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        bg.aVF();
        if (mStorageEx != c.azQ() || nullAsInt <= 0) {
            Log.e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(27178);
        } else if (nullAsInt == 40 || nullAsInt == 34 || nullAsInt == 7) {
            cCt();
            AppMethodBeat.o(27178);
        } else {
            AppMethodBeat.o(27178);
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    static void sI(boolean z) {
        int i2;
        AppMethodBeat.i(27179);
        int aUc = z.aUc();
        if (z) {
            i2 = aUc | 16384;
        } else {
            i2 = aUc & -16385;
        }
        bg.aVF();
        c.azQ().set(7, Integer.valueOf(i2));
        int i3 = z ? 1 : 2;
        bg.aVF();
        c.aSM().d(new com.tencent.mm.ba.h(13, i3));
        AppMethodBeat.o(27179);
    }

    static /* synthetic */ void access$100(Context context2) {
        AppMethodBeat.i(27180);
        isDeleteCancel = false;
        context2.getString(R.string.zb);
        final q a2 = h.a(context2, context2.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.profile.ui.j.AnonymousClass6 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(27168);
                boolean unused = j.isDeleteCancel = true;
                AppMethodBeat.o(27168);
            }
        });
        bp.a("medianote", new bp.a() {
            /* class com.tencent.mm.plugin.profile.ui.j.AnonymousClass7 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(27169);
                boolean z = j.isDeleteCancel;
                AppMethodBeat.o(27169);
                return z;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(27170);
                if (a2 != null) {
                    a2.dismiss();
                }
                AppMethodBeat.o(27170);
            }
        });
        bg.aVF();
        c.aST().bjW("medianote");
        AppMethodBeat.o(27180);
    }
}
