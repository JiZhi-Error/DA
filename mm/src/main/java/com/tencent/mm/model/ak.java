package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;

public final class ak {
    private c iDn;

    public ak(c cVar) {
        this.iDn = cVar;
    }

    static int a(boolean z, String str, boolean z2) {
        int i2 = 3;
        AppMethodBeat.i(20318);
        as Kn = c.aSN().Kn(str);
        if (Kn == null) {
            Kn = new as();
        }
        if (((int) Kn.gMZ) == 0) {
            Kn.setUsername(str);
            Kn.aqQ();
            M(Kn);
            if (z2) {
                i2 = 4;
            }
            Kn.ni(i2);
            Kn.aqZ();
            c.aSN().ap(Kn);
            AppMethodBeat.o(20318);
            return 1;
        } else if (z) {
            Kn.aqZ();
            c.aSN().c(str, Kn);
            AppMethodBeat.o(20318);
            return 2;
        } else {
            AppMethodBeat.o(20318);
            return 3;
        }
    }

    public static void L(as asVar) {
        AppMethodBeat.i(20319);
        if (asVar == null) {
            asVar = new as();
        }
        if (((int) asVar.gMZ) == 0) {
            asVar.setUsername("filehelper");
            bg.aVF();
            if (c.aST().bjY(asVar.field_username) == null) {
                asVar.aqR();
            } else {
                asVar.aqQ();
            }
            asVar.ni(3);
            bg.aVF();
            c.aSN().ao(asVar);
        }
        AppMethodBeat.o(20319);
    }

    static void M(as asVar) {
        AppMethodBeat.i(20320);
        String str = asVar.field_username;
        Context context = MMApplicationContext.getContext();
        if (str.equals("qqsync")) {
            asVar.setNickname(context.getString(R.string.dyx));
            asVar.BF(context.getString(R.string.dyy));
            asVar.BG(context.getString(R.string.dyz));
        }
        if (str.equals("floatbottle")) {
            asVar.setNickname(context.getString(R.string.dxf));
            asVar.BF(context.getString(R.string.dxg));
            asVar.BG(context.getString(R.string.dxh));
        }
        if (str.equals("shakeapp")) {
            asVar.setNickname(context.getString(R.string.dz4));
            asVar.BF(context.getString(R.string.dz5));
            asVar.BG(context.getString(R.string.dz6));
        }
        if (str.equals("lbsapp")) {
            asVar.setNickname(context.getString(R.string.dy2));
            asVar.BF(context.getString(R.string.dy3));
            asVar.BG(context.getString(R.string.dy4));
        }
        if (str.equals("medianote")) {
            asVar.setNickname(context.getString(R.string.dya));
            asVar.BF(context.getString(R.string.dyb));
            asVar.BG(context.getString(R.string.dyc));
        }
        if (str.equals("newsapp")) {
            asVar.setNickname(context.getString(R.string.dz0));
            asVar.BF(context.getString(R.string.dz1));
            asVar.BG(context.getString(R.string.dz2));
        }
        if (str.equals("facebookapp")) {
            asVar.setNickname(context.getString(R.string.dxo));
            asVar.BF(context.getString(R.string.dxp));
            asVar.BG(context.getString(R.string.dxq));
        }
        if (str.equals("qqfriend")) {
            asVar.setNickname(context.getString(R.string.dyp));
            asVar.BF(context.getString(R.string.dyq));
            asVar.BG(context.getString(R.string.dyr));
        }
        if (str.equals("masssendapp")) {
            asVar.setNickname(context.getString(R.string.dy8));
            asVar.BF(context.getString(R.string.dy9));
            asVar.BG(context.getString(R.string.dy_));
        }
        if (str.equals("feedsapp")) {
            asVar.setNickname(context.getString(R.string.dxr));
            asVar.BF(context.getString(R.string.dxs));
            asVar.BG(context.getString(R.string.dxt));
        }
        if (str.equals("fmessage")) {
            asVar.setNickname(context.getString(R.string.dxu));
            asVar.BF(context.getString(R.string.dxv));
            asVar.BG(context.getString(R.string.dxw));
        }
        if (str.equals("voipapp")) {
            asVar.setNickname(context.getString(R.string.dzd));
            asVar.BF(context.getString(R.string.dze));
            asVar.BG(context.getString(R.string.dzf));
        }
        if (str.equals("officialaccounts")) {
            asVar.setNickname(context.getString(R.string.dyi));
            asVar.BF(context.getString(R.string.dyj));
            asVar.BG(context.getString(R.string.dyk));
        }
        if (str.equals("findersayhisessionholder")) {
            asVar.setNickname(context.getString(R.string.dyl));
            asVar.BF(context.getString(R.string.dym));
            asVar.BG(context.getString(R.string.dyn));
        }
        if (str.equals("helper_entry")) {
            asVar.setNickname(context.getString(R.string.dxz));
            asVar.BF(context.getString(R.string.dy0));
            asVar.BG(context.getString(R.string.dy1));
        }
        if (str.equals("cardpackage")) {
            asVar.setNickname(context.getString(R.string.dxi));
            asVar.BF(context.getString(R.string.dxj));
            asVar.BG(context.getString(R.string.dxk));
        }
        if (str.equals("voicevoipapp")) {
            asVar.setNickname(context.getString(R.string.dzg));
            asVar.BF(context.getString(R.string.dzh));
            asVar.BG(context.getString(R.string.dzi));
        }
        if (str.equals("voiceinputapp")) {
            asVar.setNickname(context.getString(R.string.dza));
            asVar.BF(context.getString(R.string.dzb));
            asVar.BG(context.getString(R.string.dzc));
        }
        if (str.equals("qqmail")) {
            asVar.setNickname(context.getString(R.string.dys));
            asVar.BF(context.getString(R.string.dyt));
            asVar.BG(context.getString(R.string.dyu));
        }
        if (str.equals("linkedinplugin")) {
            asVar.setNickname(context.getString(R.string.dy5));
            asVar.BF(context.getString(R.string.dy6));
            asVar.BG(context.getString(R.string.dy7));
        }
        if (str.equals("notifymessage")) {
            asVar.setNickname(context.getString(R.string.dyf));
            asVar.BF(context.getString(R.string.dyg));
            asVar.BG(context.getString(R.string.dyh));
        }
        if (str.equals("appbrandcustomerservicemsg")) {
            asVar.setNickname(context.getString(R.string.dx_));
            asVar.BF(context.getString(R.string.dxa));
            asVar.BG(context.getString(R.string.dxb));
        }
        if (str.equals("downloaderapp")) {
            asVar.setNickname(context.getString(R.string.dxl));
            asVar.BF(context.getString(R.string.dxm));
            asVar.BG(context.getString(R.string.dxn));
        }
        if (str.equals("appbrand_notify_message")) {
            asVar.setNickname(context.getString(R.string.dxc));
            asVar.BF(context.getString(R.string.dxd));
            asVar.BG(context.getString(R.string.dxe));
        }
        AppMethodBeat.o(20320);
    }
}
