package com.tencent.mm.plugin.wear.model;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.eyi;
import com.tencent.mm.protocal.protobuf.eyz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class h {
    public static final Bitmap aWn(String str) {
        AppMethodBeat.i(30021);
        Bitmap fZ = a.b.gov().fZ(str);
        if (fZ == null) {
            p.aYn();
            String M = e.M(str, false);
            Log.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", M);
            fZ = e.Mq(M);
        } else {
            Log.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", str);
        }
        AppMethodBeat.o(30021);
        return fZ;
    }

    public static String aWo(String str) {
        String b2;
        AppMethodBeat.i(30022);
        bg.aVF();
        as Kn = c.aSN().Kn(str);
        if (ab.Eq(str)) {
            String string = MMApplicationContext.getContext().getString(R.string.b25);
            b2 = aa.b(Kn, str);
            if (Kn.field_username.equals(b2) || Util.isNullOrNil(b2)) {
                b2 = string;
            }
        } else {
            b2 = aa.b(Kn, str);
        }
        AppMethodBeat.o(30022);
        return b2;
    }

    public static eyz aP(ca caVar) {
        String str;
        boolean z;
        boolean z2;
        AppMethodBeat.i(30023);
        eyz eyz = new eyz();
        eyz.KMm = caVar.field_msgId;
        eyz.KMc = caVar.field_createTime;
        eyz.xKb = 1;
        eyz.NvA = true;
        if (caVar.field_isSend == 1) {
            eyz.Nickname = aWo(z.aTY());
            eyz.MRZ = z.aTY();
        } else if (ab.Eq(caVar.field_talker)) {
            String str2 = caVar.field_talker;
            int Kp = bp.Kp(caVar.field_content);
            if (Kp == -1 || (str = caVar.field_content.substring(0, Kp).trim()) == null || str.length() <= 0) {
                str = str2;
            }
            eyz.Nickname = aWo(str);
            eyz.MRZ = str;
        } else {
            eyz.Nickname = aWo(caVar.field_talker);
            eyz.MRZ = caVar.field_talker;
        }
        String str3 = null;
        if (caVar.isSystem()) {
            str3 = MMApplicationContext.getContext().getString(R.string.fgl);
            eyz.xKb = 3;
        } else if (caVar.gAz()) {
            str3 = MMApplicationContext.getContext().getString(R.string.ffo);
            eyz.xKb = 4;
        } else if (caVar.isText()) {
            if (!ab.Eq(caVar.field_talker) || caVar.field_isSend == 1) {
                str3 = caVar.field_content;
            } else {
                int Kp2 = bp.Kp(caVar.field_content);
                str3 = Kp2 != -1 ? caVar.field_content.substring(Kp2 + 1).trim() : caVar.field_content;
            }
        } else if (caVar.gAy()) {
            str3 = MMApplicationContext.getContext().getString(R.string.fgn);
            eyz.xKb = 6;
            eyz.NvA = s.ai(caVar);
            eyz.NvB = new b(MMApplicationContext.getContext().getString(R.string.dgc, Integer.valueOf((int) s.AO(new com.tencent.mm.modelvoice.p(caVar.field_content).time))).getBytes());
        } else if (caVar.cWJ()) {
            str3 = MMApplicationContext.getContext().getString(R.string.fgm);
        } else if (caVar.cWL()) {
            str3 = MMApplicationContext.getContext().getString(R.string.fgd);
        } else if (caVar.gDe()) {
            k.b HD = k.b.HD(caVar.field_content);
            if (HD != null) {
                if (HD.iyr.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                    eyz.xKb = 5;
                    str3 = caVar.field_isSend == 1 ? HD.iyl : HD.iyk;
                } else {
                    str3 = MMApplicationContext.getContext().getString(R.string.ff4, caVar.field_isSend == 1 ? HD.iyl : HD.iyk);
                }
            }
        } else if (caVar.gDf()) {
            str3 = MMApplicationContext.getContext().getString(R.string.ff3);
            eyz.xKb = 5;
        } else if (caVar.dOQ()) {
            k.b HD2 = k.b.HD(caVar.field_content);
            if (HD2 != null) {
                switch (HD2.type) {
                    case 2:
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.ffo), new Object[0]);
                        break;
                    case 3:
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.fex), Util.nullAs(HD2.title, ""));
                        break;
                    case 4:
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.ff1), Util.nullAs(HD2.title, ""));
                        break;
                    case 5:
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.feu), Util.nullAs(HD2.title, ""));
                        break;
                    case 6:
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.fet), Util.nullAs(HD2.title, ""));
                        break;
                    case 8:
                        str3 = MMApplicationContext.getContext().getString(R.string.ff6, Util.nullAs(HD2.title, ""));
                        break;
                    case 10:
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.fey), Util.nullAs(HD2.title, ""));
                        break;
                    case 13:
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.few), Util.nullAs(HD2.title, ""));
                        break;
                    case 15:
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.fes), Util.nullAs(HD2.title, ""));
                        break;
                    case 16:
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.ff5), Util.nullAs(HD2.title, ""));
                        break;
                    case 19:
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.fez), Util.nullAs(HD2.title, ""));
                        break;
                    case 20:
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.ff0), Util.nullAs(HD2.title, ""));
                        break;
                }
            }
        } else if (caVar.gDn()) {
            String string = MMApplicationContext.getContext().getString(R.string.ffd);
            if (((d) g.ah(d.class)).getEmojiMgr() != null) {
                EmojiInfo aml = ((d) g.ah(d.class)).getEmojiMgr().aml(caVar.field_imgPath);
                if (Util.isNullOrNil(((d) g.ah(d.class)).getEmojiMgr().amp(aml.getMd5()))) {
                    str3 = MMApplicationContext.getContext().getString(R.string.ffd);
                } else {
                    str3 = "[" + ((d) g.ah(d.class)).getEmojiMgr().amp(aml.getMd5()) + "]";
                }
                eyi eyi = new eyi();
                eyi.MD5 = aml.getMd5();
                if (aml.isGif()) {
                    eyi.oUv = 1;
                } else {
                    eyi.oUv = 2;
                }
                try {
                    eyz.NvB = new b(eyi.toByteArray());
                } catch (IOException e2) {
                }
                eyz.xKb = 2;
            } else {
                str3 = string;
            }
        } else if (caVar.dOS()) {
            str3 = MMApplicationContext.getContext().getString(R.string.ffp);
        } else {
            if (!caVar.gDh() && !caVar.gDi()) {
                if (caVar.getType() == 64) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (caVar.gDl()) {
                        bg.aVF();
                        str3 = String.format(MMApplicationContext.getContext().getString(R.string.ff5), c.aSQ().aEK(caVar.field_content).getDisplayName());
                    } else if (caVar.getType() == -1879048186) {
                        str3 = MMApplicationContext.getContext().getString(R.string.fev);
                    }
                }
            }
            if (!caVar.field_content.equals(ca.OqB)) {
                String str4 = caVar.field_content;
                zj zjVar = new zj();
                zjVar.efx.dKy = 1;
                zjVar.efx.content = str4;
                EventCenter.instance.publish(zjVar);
                if (zjVar.efy.type == 3) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    str3 = MMApplicationContext.getContext().getString(R.string.fgq);
                }
            }
            str3 = MMApplicationContext.getContext().getString(R.string.fgr);
        }
        if (str3 == null) {
            str3 = MMApplicationContext.getContext().getString(R.string.fge);
        }
        eyz.iAc = str3;
        AppMethodBeat.o(30023);
        return eyz;
    }

    public static byte[] aF(Bitmap bitmap) {
        AppMethodBeat.i(30024);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(30024);
        return byteArray;
    }

    public static boolean avj() {
        boolean z = true;
        AppMethodBeat.i(30025);
        try {
            MMApplicationContext.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
        } catch (PackageManager.NameNotFoundException e2) {
            z = false;
        }
        AppMethodBeat.o(30025);
        return z;
    }

    public static boolean avk() {
        boolean z = true;
        AppMethodBeat.i(30026);
        try {
            MMApplicationContext.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
        } catch (PackageManager.NameNotFoundException e2) {
            z = false;
        }
        AppMethodBeat.o(30026);
        return z;
    }

    public static byte[] aWp(String str) {
        AppMethodBeat.i(30027);
        byte[] aW = com.tencent.mm.vfs.s.aW(com.tencent.mm.vfs.aa.z(new o(new o(com.tencent.mm.loader.j.b.aKA(), ShareConstants.SO_PATH), ShareConstants.SO_PATH + str + ".so").her()), 0, -1);
        AppMethodBeat.o(30027);
        return aW;
    }
}
