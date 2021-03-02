package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.recovery.wx.util.WXUtil;

public final class y {
    public static void showAddrBookUploadConfirm(final Activity activity, final Runnable runnable, boolean z, final int i2) {
        AppMethodBeat.i(127745);
        if (l.bnZ() != l.a.SUCC && l.bnZ() != l.a.SUCC_UNLOAD) {
            Log.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
        } else if (Util.nullAsFalse((Boolean) g.aAh().azQ().get(12322, (Object) null))) {
            Log.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
        } else if (z || !Util.nullAsFalse((Boolean) g.aAh().azQ().get(12323, (Object) null))) {
            l.gl(false);
            Log.d("MicroMsg.PostLoginUtil", "READ_PHONE_STATE.getLine1Number %s", Util.getStack());
            String nullAsNil = Util.nullAsNil(Util.getLine1Number(activity));
            if (nullAsNil.length() <= 0 || !nullAsNil.equals(g.aAh().azQ().get(6, (Object) null))) {
                h.a(activity, (int) R.string.add, (int) R.string.zb, (int) R.string.a0_, (int) R.string.x6, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.platformtools.y.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(127740);
                        Log.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", 11438, Integer.valueOf(i2));
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11438, Integer.valueOf(i2));
                        l.gl(true);
                        y.syncUploadMContactStatus(true, false);
                        a.blm();
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                        AppMethodBeat.o(127740);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.platformtools.y.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(127741);
                        l.gl(false);
                        y.syncUploadMContactStatus(false, false);
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                        AppMethodBeat.o(127741);
                    }
                });
                g.aAh().azQ().set(12323, Boolean.TRUE);
                AppMethodBeat.o(127745);
                return;
            }
            l.gl(true);
            Log.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
        } else {
            Log.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
        }
        if (runnable != null) {
            runnable.run();
        }
        AppMethodBeat.o(127745);
    }

    public static void syncUploadMContactStatus(boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(127746);
        int aUc = z.aUc();
        if (z) {
            i2 = aUc & -131073;
        } else {
            i2 = aUc | 131072;
        }
        Log.d("MicroMsg.PostLoginUtil", "Reg By mobile update = ".concat(String.valueOf(i2)));
        g.aAh().azQ().set(7, Integer.valueOf(i2));
        int i3 = !z ? 1 : 2;
        bfx bfx = new bfx();
        bfx.LPB = 17;
        bfx.BsD = i3;
        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, bfx));
        if (z2) {
            a.jRu.WZ();
        }
        AppMethodBeat.o(127746);
    }

    public static void St(String str) {
        AppMethodBeat.i(127747);
        bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, str);
        AppMethodBeat.o(127747);
    }

    public static void dz(final Context context) {
        AppMethodBeat.i(127748);
        String string = context.getString(R.string.gz);
        final String string2 = context.getString(R.string.gy);
        h.c(context, string, "", context.getString(R.string.b98), context.getString(R.string.b96), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.platformtools.y.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(127742);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string2);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                a.jRt.i(intent, context);
                AppMethodBeat.o(127742);
            }
        }, null);
        AppMethodBeat.o(127748);
    }

    public static void m(final Context context, String str, final String str2) {
        AppMethodBeat.i(127749);
        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
        if (Dk != null) {
            Dk.a(context, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.platformtools.y.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(127743);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                    a.jRt.i(intent, context);
                    AppMethodBeat.o(127743);
                }
            }, null);
        }
        AppMethodBeat.o(127749);
    }

    public static void a(Context context, t.a aVar, int i2) {
        AppMethodBeat.i(127750);
        Intent intent = new Intent(context, BioHelperUI.class);
        intent.putExtra("k_type", aVar.type);
        intent.putExtra("KVoiceHelpCode", i2);
        intent.putExtra("Kvertify_key", aVar.dHx);
        intent.putExtra("KVoiceHelpUrl", aVar.jke);
        intent.putExtra("KVoiceHelpWording", aVar.dQx);
        intent.putExtra("Kusername", aVar.username);
        if (aVar.jkf != null) {
            intent.getExtras().putAll(aVar.jkf);
        }
        AppMethodBeat.o(127750);
    }

    public static void g(final Context context, String str, final int i2) {
        AppMethodBeat.i(127751);
        final com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
        if (Dk == null) {
            AppMethodBeat.o(127751);
        } else if (Dk.dDG == 8) {
            com.tencent.mm.plugin.account.a.b.a.b(context, Dk.url, i2, false);
            AppMethodBeat.o(127751);
        } else {
            String str2 = Dk.gpb.gpn;
            String str3 = Dk.gpb.gpo;
            if (Util.isNullOrNil(str2)) {
                str2 = context.getString(R.string.x_);
            }
            if (Util.isNullOrNil(str3)) {
                str3 = context.getString(R.string.sz);
            }
            AnonymousClass5 r5 = new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.platformtools.y.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(127744);
                    com.tencent.mm.plugin.account.a.b.a.b(context, Dk.url, i2, false);
                    AppMethodBeat.o(127744);
                }
            };
            if (Dk.dDG == 1 || Dk.dDG == 4) {
                if (Util.isNullOrNil(Dk.url)) {
                    h.c(context, Dk.desc, Dk.Title, true);
                    AppMethodBeat.o(127751);
                    return;
                }
                h.c(context, Dk.desc, Dk.Title, str2, str3, r5, null);
            }
            AppMethodBeat.o(127751);
        }
    }
}
