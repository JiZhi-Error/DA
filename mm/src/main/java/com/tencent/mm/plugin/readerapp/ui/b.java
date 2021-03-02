package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.readerapp.c.c;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class b implements a, MStorageEx.IOnStorageChange {
    private as contact;
    private Context context;
    private f screen;

    public b(Context context2) {
        this.context = context2;
    }

    private static boolean isOpen() {
        AppMethodBeat.i(102694);
        if ((z.aUl() & 524288) == 0) {
            AppMethodBeat.o(102694);
            return true;
        }
        AppMethodBeat.o(102694);
        return false;
    }

    static void sX(boolean z) {
        int i2;
        AppMethodBeat.i(102695);
        int aUe = z.aUe();
        if (z) {
            i2 = aUe & -1025;
        } else {
            i2 = aUe | 1024;
        }
        g.aAh().azQ().set(40, Integer.valueOf(i2));
        ((l) g.af(l.class)).aSM().d(new h(26, z ? 2 : 1));
        AppMethodBeat.o(102695);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(102696);
        Log.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = ".concat(String.valueOf(str)));
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(102696);
            return false;
        } else if (str.equals("contact_info_readerappnews_view")) {
            Intent intent = new Intent(this.context, ReaderAppUI.class);
            intent.putExtra("type", 20);
            Context context2 = this.context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "gotoViewReaderapp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "gotoViewReaderapp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.readerapp.b.a.jRu.WZ();
            AppMethodBeat.o(102696);
            return true;
        } else if (str.equals("contact_info_readerappnews_subscribe")) {
            Intent intent2 = new Intent(this.context, ReaderAppSubscribeUI.class);
            Context context3 = this.context;
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(context3, bl2.axQ(), "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context3.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context3, "com/tencent/mm/plugin/readerapp/ui/ContactWidgetReaderAppNews", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(102696);
            return true;
        } else if (str.equals("contact_info_readerappnews_clear_data")) {
            com.tencent.mm.ui.base.h.c(this.context, this.context.getString(R.string.ba4), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.readerapp.ui.b.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(102689);
                    final q a2 = com.tencent.mm.ui.base.h.a(b.this.context, b.this.context.getString(R.string.ftp), false, (DialogInterface.OnCancelListener) null);
                    com.tencent.mm.plugin.readerapp.c.g.a(new g.a() {
                        /* class com.tencent.mm.plugin.readerapp.ui.b.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.readerapp.c.g.a
                        public final void eHF() {
                            AppMethodBeat.i(102688);
                            a2.dismiss();
                            AppMethodBeat.o(102688);
                        }
                    });
                    AppMethodBeat.o(102689);
                }
            }, null);
            AppMethodBeat.o(102696);
            return true;
        } else if (str.equals("contact_info_readerappnews_recv_remind")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg(str);
            boolean eHG = c.eHG();
            if (!eHG) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15413, 7, "", "");
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15413, 6, "", "");
            }
            if (checkBoxPreference != null) {
                if (!eHG) {
                    z = true;
                } else {
                    z = false;
                }
                checkBoxPreference.setChecked(z);
            }
            if (!eHG) {
                z2 = true;
            }
            sX(z2);
            AppMethodBeat.o(102696);
            return true;
        } else if (str.equals("contact_info_readerappnews_install")) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15413, 5, "", "");
            C(this.context, true);
            AppMethodBeat.o(102696);
            return true;
        } else if (str.equals("contact_info_readerappnews_uninstall")) {
            com.tencent.mm.ui.base.h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.readerapp.ui.b.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(102690);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15413, 4, "", "");
                    b.C(b.this.context, false);
                    AppMethodBeat.o(102690);
                }
            }, null);
            AppMethodBeat.o(102696);
            return true;
        } else {
            Log.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(102696);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2 = false;
        AppMethodBeat.i(102697);
        Assert.assertTrue(fVar != null);
        if (asVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.Jj(asVar.field_username));
        com.tencent.mm.kernel.g.aAh().azQ().add(this);
        this.contact = asVar;
        this.screen = fVar;
        cCt();
        AppMethodBeat.o(102697);
        return true;
    }

    private void cCt() {
        AppMethodBeat.i(102698);
        boolean isOpen = isOpen();
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(R.xml.ad);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.beh));
        helperHeaderPreference.updateStatus(isOpen ? 1 : 0);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("contact_info_readerappnews_recv_remind");
        boolean eHG = c.eHG();
        Log.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = ".concat(String.valueOf(eHG)));
        if (checkBoxPreference != null) {
            checkBoxPreference.setChecked(eHG);
        }
        if (isOpen) {
            this.screen.bmi("contact_info_readerappnews_install");
            AppMethodBeat.o(102698);
            return;
        }
        this.screen.bmi("contact_info_readerappnews_subscribe");
        this.screen.bmi("contact_info_readerappnews_view");
        this.screen.bmi("contact_info_readerappnews_clear_data");
        this.screen.bmi("contact_info_readerappnews_uninstall");
        this.screen.bmi("contact_info_readerappnews_recv_remind");
        AppMethodBeat.o(102698);
    }

    public static void C(final Context context2, final boolean z) {
        AppMethodBeat.i(102699);
        String string = z ? context2.getString(R.string.gst) : context2.getString(R.string.gt0);
        context2.getString(R.string.zb);
        final q a2 = com.tencent.mm.ui.base.h.a(context2, string, true, (DialogInterface.OnCancelListener) null);
        final AnonymousClass3 r1 = new MMHandler() {
            /* class com.tencent.mm.plugin.readerapp.ui.b.AnonymousClass3 */
            final /* synthetic */ s znB = null;

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                int i2;
                int i3;
                AppMethodBeat.i(102692);
                if (z) {
                    b.sX(true);
                }
                int aUl = z.aUl();
                if (z) {
                    i2 = aUl & -524289;
                } else {
                    i2 = aUl | 524288;
                }
                com.tencent.mm.kernel.g.aAh().azQ().set(34, Integer.valueOf(i2));
                dbw dbw = new dbw();
                dbw.KEc = 524288;
                if (z) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                dbw.MGK = i3;
                ((l) com.tencent.mm.kernel.g.af(l.class)).aSM().d(new k.a(39, dbw));
                if (!z) {
                    final q a2 = com.tencent.mm.ui.base.h.a(context2, context2.getString(R.string.ftp), false, (DialogInterface.OnCancelListener) null);
                    com.tencent.mm.plugin.readerapp.c.g.a(new g.a() {
                        /* class com.tencent.mm.plugin.readerapp.ui.b.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.readerapp.c.g.a
                        public final void eHF() {
                            AppMethodBeat.i(102691);
                            if (a2 != null) {
                                a2.dismiss();
                            }
                            AppMethodBeat.o(102691);
                        }
                    });
                    b.sX(false);
                }
                if (this.znB != null) {
                    this.znB.onNotifyChange(null, null);
                }
                AppMethodBeat.o(102692);
            }
        };
        new Timer().schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.readerapp.ui.b.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(102693);
                if (a2 != null) {
                    a2.dismiss();
                    r1.sendEmptyMessage(0);
                }
                AppMethodBeat.o(102693);
            }
        }, 5000);
        AppMethodBeat.o(102699);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(102700);
        com.tencent.mm.kernel.g.aAh().azQ().remove(this);
        com.tencent.mm.plugin.readerapp.b.a.jRu.WZ();
        AppMethodBeat.o(102700);
        return true;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(102701);
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        if (mStorageEx != com.tencent.mm.kernel.g.aAh().azQ() || nullAsInt <= 0) {
            Log.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(102701);
        } else if (nullAsInt == 40 || nullAsInt == 34 || nullAsInt == 7) {
            cCt();
            AppMethodBeat.o(102701);
        } else {
            AppMethodBeat.o(102701);
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }
}
