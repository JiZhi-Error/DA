package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;

public final class h {
    public static String cz(String str, boolean z) {
        AppMethodBeat.i(28964);
        bg.aVF();
        String genPath = FilePathGenerator.genPath(c.aTb(), "recbiz_", str, ".rec", 2);
        if (Util.isNullOrNil(genPath)) {
            AppMethodBeat.o(28964);
            return null;
        } else if (z) {
            AppMethodBeat.o(28964);
            return genPath;
        } else if (new o(genPath).exists()) {
            AppMethodBeat.o(28964);
            return genPath;
        } else {
            AppMethodBeat.o(28964);
            return genPath;
        }
    }

    public static boolean Rk(String str) {
        AppMethodBeat.i(28965);
        if (str == null) {
            AppMethodBeat.o(28965);
            return false;
        }
        g aSP = d.fth().aSP(str);
        if (aSP == null) {
            Log.d("MicroMsg.VoiceRemindLogic", "cancel null record : ".concat(String.valueOf(str)));
            AppMethodBeat.o(28965);
            return true;
        }
        Log.d("MicroMsg.VoiceRemindLogic", "cancel record : " + str + " LocalId:" + aSP.field_msglocalid);
        if (aSP.field_msglocalid != 0) {
            bg.aVF();
            c.aSQ().Hc((long) aSP.field_msglocalid);
        }
        boolean aSL = aSL(str);
        AppMethodBeat.o(28965);
        return aSL;
    }

    private static boolean aSL(String str) {
        AppMethodBeat.i(28966);
        if (str == null) {
            AppMethodBeat.o(28966);
            return false;
        }
        d.fth().gC(str);
        Rg(str);
        boolean delete = new o(cz(str, false)).delete();
        AppMethodBeat.o(28966);
        return delete;
    }

    static void Rg(String str) {
        AppMethodBeat.i(28967);
        d.fth().Rg(cz(str, false));
        AppMethodBeat.o(28967);
    }

    public static boolean QE(String str) {
        boolean z = false;
        AppMethodBeat.i(28968);
        if (str == null) {
            AppMethodBeat.o(28968);
        } else {
            g aSP = d.fth().aSP(str);
            if (aSP == null) {
                Log.e("MicroMsg.VoiceRemindLogic", "Set error failed file:".concat(String.valueOf(str)));
                AppMethodBeat.o(28968);
            } else {
                aSP.field_status = 98;
                aSP.field_lastmodifytime = System.currentTimeMillis() / 1000;
                aSP.cSx = 320;
                z = a(aSP);
                Log.d("MicroMsg.VoiceRemindLogic", "setError file:" + str + " msgid:" + aSP.field_msglocalid + " old stat:" + aSP.field_status);
                if (aSP.field_msglocalid == 0 || Util.isNullOrNil(aSP.field_user)) {
                    Log.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + aSP.field_msglocalid + " user:" + aSP.field_user);
                    AppMethodBeat.o(28968);
                } else {
                    bg.aVF();
                    ca Hb = c.aSQ().Hb((long) aSP.field_msglocalid);
                    Hb.setMsgId((long) aSP.field_msglocalid);
                    Hb.setStatus(5);
                    Hb.Cy(aSP.field_user);
                    Hb.setContent(f.b(aSP.field_human, -1, true));
                    bg.aVF();
                    c.aSQ().a(Hb.field_msgId, Hb);
                    AppMethodBeat.o(28968);
                }
            }
        }
        return z;
    }

    static boolean a(g gVar) {
        AppMethodBeat.i(28969);
        if (gVar == null) {
            AppMethodBeat.o(28969);
            return false;
        } else if (gVar.cSx == -1) {
            AppMethodBeat.o(28969);
            return false;
        } else {
            boolean a2 = d.fth().a(gVar.field_filename, gVar);
            AppMethodBeat.o(28969);
            return a2;
        }
    }

    public static c aSM(String str) {
        AppMethodBeat.i(28970);
        c aSO = d.fth().aSO(cz(str, false));
        AppMethodBeat.o(28970);
        return aSO;
    }
}
