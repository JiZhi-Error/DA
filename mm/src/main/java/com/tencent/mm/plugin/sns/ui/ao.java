package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ao {
    private static String a(Context context, be beVar) {
        AppMethodBeat.i(203353);
        if (beVar == null) {
            AppMethodBeat.o(203353);
            return "";
        } else if (beVar.oUv != 6) {
            String str = beVar.KEx;
            AppMethodBeat.o(203353);
            return str;
        } else if (beVar.KEz == null) {
            AppMethodBeat.o(203353);
            return "";
        } else if (a.jRu.s(context, beVar.KEw.jfi)) {
            String str2 = beVar.KEz.KIw;
            AppMethodBeat.o(203353);
            return str2;
        } else {
            String str3 = beVar.KEz.KIx;
            AppMethodBeat.o(203353);
            return str3;
        }
    }

    public static int b(Context context, be beVar) {
        AppMethodBeat.i(98140);
        if (beVar == null) {
            AppMethodBeat.o(98140);
            return 0;
        } else if (beVar.oUv != 6) {
            int i2 = beVar.Scene;
            AppMethodBeat.o(98140);
            return i2;
        } else if (beVar.KEy == null) {
            AppMethodBeat.o(98140);
            return 0;
        } else if (beVar.KEw == null) {
            AppMethodBeat.o(98140);
            return 0;
        } else if (a.jRu.s(context, beVar.KEw.jfi)) {
            int i3 = beVar.KEy.KIc;
            AppMethodBeat.o(98140);
            return i3;
        } else {
            int i4 = beVar.KEy.KIe;
            AppMethodBeat.o(98140);
            return i4;
        }
    }

    public static void a(Context context, bl blVar, be beVar) {
        int identifier;
        fb fbVar;
        AppMethodBeat.i(98141);
        if (beVar == null || beVar.KEw == null || !h.bdA(beVar.KEw.jfi)) {
            blVar.EOf = false;
            AppMethodBeat.o(98141);
            return;
        }
        blVar.EOf = false;
        String str = "";
        if (beVar.KEA == null || beVar.KEB == null) {
            String a2 = a(context, beVar);
            try {
                if (!Util.isNullOrNil(a2) && (identifier = context.getResources().getIdentifier(a2, "string", context.getPackageName())) > 0) {
                    str = context.getString(identifier);
                }
            } catch (Exception e2) {
            }
        } else {
            if (a.jRu.s(context, beVar.KEw.jfi)) {
                fbVar = beVar.KEA;
            } else {
                fbVar = beVar.KEB;
            }
            String applicationLanguage = LocaleUtil.getApplicationLanguage();
            str = applicationLanguage.equals(LocaleUtil.CHINA) ? fbVar.KIu : (applicationLanguage.equals(LocaleUtil.TAIWAN) || applicationLanguage.equals(LocaleUtil.HONGKONG)) ? fbVar.KIv : fbVar.KIt;
        }
        switch (beVar.oUv) {
            case 4:
                blVar.EOg = str;
                blVar.EOf = true;
                break;
            case 5:
                if (beVar.Scene == 1) {
                    blVar.EOg = str;
                    blVar.EOf = true;
                    break;
                }
                break;
            case 6:
                blVar.EOg = str;
                blVar.EOf = true;
                break;
            default:
                blVar.EOf = false;
                break;
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.OpenActionContent", "text can not load ?");
            blVar.EOf = false;
        }
        AppMethodBeat.o(98141);
    }
}
