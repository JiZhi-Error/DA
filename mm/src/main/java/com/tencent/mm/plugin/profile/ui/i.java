package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import junit.framework.Assert;

public final class i implements a, MStorageEx.IOnStorageChange {
    private HelperHeaderPreference.a Bfw;
    private as contact;
    private Context context;
    private f screen;

    public i(Context context2) {
        AppMethodBeat.i(27154);
        this.context = context2;
        this.Bfw = new s(context2);
        AppMethodBeat.o(27154);
    }

    private static boolean eEw() {
        AppMethodBeat.i(27155);
        if ((z.aUl() & TPMediaCodecProfileLevel.HEVCMainTierLevel62) == 0) {
            AppMethodBeat.o(27155);
            return true;
        }
        AppMethodBeat.o(27155);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean alD(String str) {
        AppMethodBeat.i(27156);
        Log.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = ".concat(String.valueOf(str)));
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(27156);
            return false;
        } else if (str.equals("contact_info_linkedin_install")) {
            C(this.context, true);
            AppMethodBeat.o(27156);
            return true;
        } else if (str.equals("contact_info_linkedin_uninstall")) {
            h.c(this.context, this.context.getString(R.string.gsw), "", this.context.getString(R.string.t2), this.context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.i.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(27152);
                    i.C(i.this.context, false);
                    AppMethodBeat.o(27152);
                }
            }, null);
            AppMethodBeat.o(27156);
            return true;
        } else {
            if (str.equals("contact_info_linkedin_account")) {
                ((Activity) this.context).startActivityForResult(new Intent(this.context, BindLinkedInUI.class), 1);
            }
            Log.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(27156);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean a(f fVar, as asVar, boolean z, int i2) {
        boolean z2 = false;
        AppMethodBeat.i(27157);
        Assert.assertTrue(fVar != null);
        if (asVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.Jo(asVar.field_username));
        bg.aVF();
        c.azQ().add(this);
        this.contact = asVar;
        this.screen = fVar;
        cCt();
        AppMethodBeat.o(27157);
        return true;
    }

    private void cCt() {
        AppMethodBeat.i(27158);
        boolean eEw = eEw();
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(R.xml.a3);
        ((HelperHeaderPreference) this.screen.bmg("contact_info_header_helper")).a(this.contact, this.Bfw);
        if (eEw) {
            this.screen.m38do("contact_info_linkedin_account", false);
            this.screen.bmi("contact_info_linkedin_install");
            AppMethodBeat.o(27158);
            return;
        }
        this.screen.m38do("contact_info_linkedin_account", true);
        this.screen.bmi("contact_info_linkedin_uninstall");
        AppMethodBeat.o(27158);
    }

    public static void C(Context context2, final boolean z) {
        AppMethodBeat.i(27159);
        String string = z ? context2.getString(R.string.gst) : context2.getString(R.string.gt0);
        context2.getString(R.string.zb);
        final q a2 = h.a(context2, string, true, (DialogInterface.OnCancelListener) null);
        new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.profile.ui.i.AnonymousClass2 */
            final /* synthetic */ s znB = null;

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                int i2;
                AppMethodBeat.i(27153);
                if (a2 != null) {
                    a2.dismiss();
                }
                int aUl = z.aUl();
                if (z) {
                    i2 = aUl & -16777217;
                } else {
                    i2 = aUl | TPMediaCodecProfileLevel.HEVCMainTierLevel62;
                    bg.aVF();
                    c.azQ().set(286722, "");
                    bg.aVF();
                    c.azQ().set(286721, "");
                    bg.aVF();
                    c.azQ().set(286723, "");
                }
                bg.aVF();
                c.azQ().set(34, Integer.valueOf(i2));
                dbw dbw = new dbw();
                dbw.KEc = TPMediaCodecProfileLevel.HEVCMainTierLevel62;
                dbw.MGK = z ? 0 : 1;
                bg.aVF();
                c.aSM().d(new k.a(39, dbw));
                if (this.znB != null) {
                    this.znB.onNotifyChange(null, null);
                }
                AppMethodBeat.o(27153);
                return false;
            }
        }, false).startTimer(1500);
        AppMethodBeat.o(27159);
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final boolean cCs() {
        AppMethodBeat.i(27160);
        bg.aVF();
        c.azQ().remove(this);
        this.screen.bmg("contact_info_header_helper");
        b.jRu.WZ();
        AppMethodBeat.o(27160);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.b.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(27161);
        if (i2 == 1 && i3 == -1) {
            cCt();
        }
        AppMethodBeat.o(27161);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        int intValue;
        AppMethodBeat.i(27162);
        if ((obj instanceof Integer) && ((intValue = ((Integer) obj).intValue()) == 40 || intValue == 34)) {
            cCt();
        }
        AppMethodBeat.o(27162);
    }
}
