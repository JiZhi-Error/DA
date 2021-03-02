package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    public static boolean ay(Context context, String str) {
        AppMethodBeat.i(23315);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
            AppMethodBeat.o(23315);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(23315);
        return true;
    }

    public static void a(b bVar, cat cat, cau cau) {
        AppMethodBeat.i(23316);
        if (cau != null) {
            bVar.field_connProto = cau.MfZ;
            bVar.field_connStrategy = cau.Mga;
            bVar.field_closeStrategy = cau.Mgb;
            bVar.field_mac = com.tencent.mm.plugin.exdevice.k.b.anY(com.tencent.mm.plugin.exdevice.k.b.anZ(cau.KOS));
            bVar.field_authKey = cau.KLg;
            bVar.field_brandName = cau.MfY;
            bVar.BC(cau.ked);
            bVar.yE(cau.fMg);
            bVar.Ct(cau.Mgh);
            bVar.Cs(cau.Mgg);
            bVar.Cr(cau.Mgf);
            bVar.nE(cau.Mgi);
            bVar.setIconUrl(cau.IconUrl);
            bVar.nF(cau.fMf);
            bVar.Cq(cau.xIy);
            bVar.Cu(cau.fMh);
            bVar.Cv(cau.fMi);
            bVar.Cw(cau.fMj);
            bVar.Cx(cau.fMk);
        }
        if (cat != null) {
            bVar.field_deviceID = cat.oTH;
            bVar.field_deviceType = cat.KLO;
            bVar.field_md5Str = g.getMessageDigest(new String(cat.KLO + cat.oTH).getBytes());
            if (Util.isNullOrNil(bVar.field_brandName)) {
                bVar.field_brandName = cat.KLO;
            }
        }
        AppMethodBeat.o(23316);
    }

    public static boolean b(b bVar) {
        return bVar != null && (bVar.fMg & 1) == 1;
    }
}
