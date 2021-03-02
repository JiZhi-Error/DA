package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.contact.c;
import com.tencent.mm.model.bp;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cl;

public final class q {
    public static b[] a(Context context, as asVar, int i2) {
        b[] a2;
        AppMethodBeat.i(27228);
        String nullAsNil = Util.nullAsNil(((Activity) context).getIntent().getStringExtra("Verify_ticket"));
        if (c.oR(asVar.field_type)) {
            AppMethodBeat.o(27228);
            return null;
        } else if (Util.isNullOrNil(nullAsNil)) {
            AppMethodBeat.o(27228);
            return null;
        } else {
            Log.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(i2)));
            if (i2 == 18) {
                Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
                a2 = b.a(context, d.bgO().bkx(asVar.field_username));
            } else if (bp.sb(i2)) {
                Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
                a2 = b.a(context, d.bgP().bkW(asVar.field_username));
            } else {
                Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
                a2 = b.a(context, d.bgM().bku(asVar.field_username));
            }
            if (a2 == null || a2.length == 0) {
                AppMethodBeat.o(27228);
                return null;
            }
            AppMethodBeat.o(27228);
            return a2;
        }
    }

    public static String b(Context context, as asVar, int i2) {
        String str = null;
        AppMethodBeat.i(27229);
        String nullAsNil = Util.nullAsNil(((Activity) context).getIntent().getStringExtra("Verify_ticket"));
        if (c.oR(asVar.field_type)) {
            AppMethodBeat.o(27229);
        } else if (Util.isNullOrNil(nullAsNil)) {
            AppMethodBeat.o(27229);
        } else {
            str = "";
            Log.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(i2)));
            if (i2 == 18) {
                Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
                bx[] bkx = d.bgO().bkx(asVar.field_username);
                if (bkx.length > 0) {
                    str = new StringBuilder().append(bkx[0].field_svrid).toString();
                }
            } else if (bp.sb(i2)) {
                Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
                cl[] bkW = d.bgP().bkW(asVar.field_username);
                if (bkW.length > 0) {
                    str = new StringBuilder().append(bkW[0].field_svrid).toString();
                }
            } else {
                Log.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
                bn[] bku = d.bgM().bku(asVar.field_username);
                if (bku.length > 0) {
                    str = new StringBuilder().append(bku[0].field_svrId).toString();
                }
            }
            AppMethodBeat.o(27229);
        }
        return str;
    }
}
