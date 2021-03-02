package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class o implements a, MStorageEx.IOnStorageChange {
    private as contact;
    private Context context;
    private f screen;

    public o(Context context2) {
        this.context = context2;
    }

    private static boolean eEw() {
        AppMethodBeat.i(27219);
        if ((z.aUl() & TPMediaCodecProfileLevel.HEVCHighTierLevel62) == 0) {
            AppMethodBeat.o(27219);
            return true;
        }
        AppMethodBeat.o(27219);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(27220);
        Log.d("MicroMsg.ContactWidgetVoiceInput", "handleEvent : key = ".concat(String.valueOf(str)));
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(27220);
            return false;
        } else if (str.equals("contact_info_voiceinput_install")) {
            C(this.context, true);
            AppMethodBeat.o(27220);
            return true;
        } else if (str.equals("contact_info_voiceinput_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.o.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27216);
                    o.C(o.this.context, false);
                    AppMethodBeat.o(27216);
                }
            }, null);
            AppMethodBeat.o(27220);
            return true;
        } else {
            Log.e("MicroMsg.ContactWidgetVoiceInput", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(27220);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2 = false;
        AppMethodBeat.i(27221);
        Assert.assertTrue(fVar != null);
        if (asVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.Jn(asVar.field_username));
        bg.aVF();
        c.azQ().add(this);
        this.contact = asVar;
        this.screen = fVar;
        fVar.addPreferencesFromResource(R.xml.aj);
        cCt();
        AppMethodBeat.o(27221);
        return true;
    }

    private void cCt() {
        boolean z = true;
        AppMethodBeat.i(27222);
        boolean eEw = eEw();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.screen.bmg("contact_info_header_helper");
        helperHeaderPreference.bk(this.contact.field_username, this.contact.arJ(), this.context.getString(R.string.bhm));
        helperHeaderPreference.updateStatus(eEw ? 1 : 0);
        this.screen.m38do("contact_info_voiceinput_install", eEw);
        f fVar = this.screen;
        if (eEw) {
            z = false;
        }
        fVar.m38do("contact_info_voiceinput_uninstall", z);
        AppMethodBeat.o(27222);
    }

    public static void C(Context context2, final boolean z) {
        AppMethodBeat.i(27223);
        String string = z ? context2.getString(R.string.gst) : context2.getString(R.string.gt0);
        context2.getString(R.string.zb);
        final q a2 = h.a(context2, string, true, (DialogInterface.OnCancelListener) null);
        final AnonymousClass2 r1 = new MMHandler() {
            /* class com.tencent.mm.plugin.profile.ui.o.AnonymousClass2 */
            final /* synthetic */ s znB = null;

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                int i2;
                AppMethodBeat.i(27217);
                int aUl = z.aUl();
                if (z) {
                    i2 = aUl & -33554433;
                } else {
                    i2 = aUl | TPMediaCodecProfileLevel.HEVCHighTierLevel62;
                }
                bg.aVF();
                c.azQ().set(34, Integer.valueOf(i2));
                dbw dbw = new dbw();
                dbw.KEc = TPMediaCodecProfileLevel.HEVCHighTierLevel62;
                dbw.MGK = z ? 0 : 1;
                bg.aVF();
                c.aSM().d(new k.a(39, dbw));
                if (this.znB != null) {
                    this.znB.onNotifyChange(null, null);
                }
                AppMethodBeat.o(27217);
            }
        };
        new Timer().schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.profile.ui.o.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(27218);
                if (a2 != null) {
                    a2.dismiss();
                    r1.sendEmptyMessage(0);
                }
                AppMethodBeat.o(27218);
            }
        }, 1500);
        AppMethodBeat.o(27223);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27224);
        bg.aVF();
        c.azQ().remove(this);
        b.jRu.WZ();
        AppMethodBeat.o(27224);
        return true;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(27225);
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        bg.aVF();
        if (mStorageEx != c.azQ() || nullAsInt <= 0) {
            Log.e("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(27225);
        } else if (nullAsInt == 40 || nullAsInt == 34 || nullAsInt == 7) {
            cCt();
            AppMethodBeat.o(27225);
        } else {
            AppMethodBeat.o(27225);
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }
}
