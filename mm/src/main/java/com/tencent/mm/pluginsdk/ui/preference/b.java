package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cl;
import junit.framework.Assert;

public final class b {
    public int Dkc;
    public String Kpp;
    public boolean ehd;
    public String iAq;
    public long id;
    public String kcp;
    public String nickname;
    public String username;

    public static b c(Context context, bn bnVar) {
        AppMethodBeat.i(31840);
        b a2 = a(context, bnVar.systemRowid, bnVar.gCT(), bnVar.field_talker, bnVar.field_msgContent, bnVar.field_type);
        AppMethodBeat.o(31840);
        return a2;
    }

    private static b a(Context context, long j2, boolean z, String str, String str2, int i2) {
        AppMethodBeat.i(31841);
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i3 = 0;
        if (i2 == 0) {
            ca.a bkA = ca.a.bkA(str2);
            str3 = bkA.dkU;
            str4 = bkA.nickname;
            str5 = bkA.OqK;
            str6 = bkA.OqL;
            i3 = bkA.scene;
        } else if (z) {
            ca.d bkD = ca.d.bkD(str2);
            str3 = bkD.dkU;
            str4 = bkD.nickname;
            str7 = bkD.content;
            if (bkD.Ora == 1) {
                str8 = bkD.Orc;
            }
        }
        b a2 = a(context, j2, z, str, str2, i2, str3, str4, str5, str6, str7, i3);
        a2.Kpp = str8;
        AppMethodBeat.o(31841);
        return a2;
    }

    public static b a(Context context, long j2, boolean z, String str, String str2, int i2, String str3, String str4, String str5, String str6, String str7, int i3) {
        AppMethodBeat.i(31842);
        b bVar = new b();
        bVar.id = j2;
        bVar.ehd = !z;
        Log.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", Integer.valueOf(i2), str, Integer.valueOf(i3));
        if (i2 == 0) {
            if (str2 != null) {
                bVar.username = str3;
                bVar.nickname = str4;
                switch (i3) {
                    case 4:
                        bVar.iAq = context.getString(R.string.aya);
                        break;
                    case 10:
                    case 11:
                        gq gqVar = new gq();
                        gqVar.dKE.dKB = str5;
                        gqVar.dKE.dKC = str6;
                        EventCenter.instance.publish(gqVar);
                        bVar.iAq = context.getString(R.string.ayf, Util.nullAs(gqVar.dKF.dKG, ""));
                        break;
                    case 31:
                        bVar.iAq = context.getString(R.string.ayq);
                        break;
                    case 32:
                        bVar.iAq = context.getString(R.string.ayk);
                        break;
                    case 58:
                    case bv.CTRL_INDEX:
                    case 60:
                        bVar.kcp = ca.a.bkA(str2).kcp;
                        bVar.iAq = context.getString(R.string.ayd);
                        break;
                    default:
                        bVar.iAq = context.getString(R.string.ayj);
                        break;
                }
            } else {
                Log.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = ".concat(String.valueOf(str)));
                AppMethodBeat.o(31842);
                return null;
            }
        } else if (!z) {
            bVar.username = str;
            bVar.iAq = str2;
        } else {
            bVar.username = str3;
            bVar.nickname = str4;
            if (str7 == null || str7.trim().equals("")) {
                bVar.iAq = context.getString(R.string.fg2);
            } else {
                bVar.iAq = str7;
            }
        }
        AppMethodBeat.o(31842);
        return bVar;
    }

    public static b a(Context context, eb ebVar) {
        AppMethodBeat.i(31843);
        Log.d("MicroMsg.FMessageProvider", "build lbs, talker = " + ebVar.field_sayhiuser + ", scene = " + ebVar.field_scene);
        b bVar = new b();
        bVar.id = ebVar.systemRowid;
        bVar.ehd = ebVar.field_isSend == 1;
        bVar.username = ebVar.field_sayhiuser;
        bVar.Dkc = ebVar.field_scene;
        if (ebVar.field_isSend == 1) {
            bVar.iAq = ebVar.field_content;
        } else {
            ca.d bkD = ca.d.bkD(ebVar.field_content);
            if (bkD.content == null || bkD.content.trim().equals("")) {
                bVar.iAq = context.getString(R.string.ays);
            } else {
                bVar.iAq = bkD.content;
            }
            bVar.nickname = bkD.nickname;
        }
        AppMethodBeat.o(31843);
        return bVar;
    }

    public static b a(Context context, cl clVar) {
        AppMethodBeat.i(31844);
        Log.d("MicroMsg.FMessageProvider", "build shake, talker = " + clVar.field_talker + ", scene = " + clVar.field_scene);
        b bVar = new b();
        bVar.id = clVar.systemRowid;
        bVar.ehd = clVar.field_isSend == 1;
        bVar.username = clVar.field_sayhiuser;
        bVar.Dkc = clVar.field_scene;
        if (clVar.field_isSend == 1) {
            bVar.iAq = clVar.field_content;
        } else {
            ca.d bkD = ca.d.bkD(clVar.field_content);
            if (bkD.content == null || bkD.content.trim().equals("")) {
                bVar.iAq = context.getString(R.string.ays);
            } else {
                bVar.iAq = bkD.content;
            }
            bVar.nickname = bkD.nickname;
        }
        AppMethodBeat.o(31844);
        return bVar;
    }

    public static b[] a(Context context, bn[] bnVarArr) {
        AppMethodBeat.i(31845);
        Log.d("MicroMsg.FMessageProvider", "convert fmsgList, talker = " + ((bnVarArr == null || bnVarArr.length == 0 || bnVarArr[0] == null) ? BuildConfig.COMMAND : bnVarArr[0].field_talker));
        if (bnVarArr == null || bnVarArr.length == 0) {
            Log.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
            AppMethodBeat.o(31845);
            return null;
        }
        b[] bVarArr = new b[bnVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr[(bVarArr.length - i2) - 1] = c(context, bnVarArr[i2]);
        }
        AppMethodBeat.o(31845);
        return bVarArr;
    }

    public static b[] a(Context context, eb[] ebVarArr) {
        AppMethodBeat.i(31846);
        Log.d("MicroMsg.FMessageProvider", "convert lbsList, talker = " + ((ebVarArr == null || ebVarArr.length == 0 || ebVarArr[0] == null) ? BuildConfig.COMMAND : ebVarArr[0].field_sayhiuser));
        if (ebVarArr == null || ebVarArr.length == 0) {
            Log.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
            AppMethodBeat.o(31846);
            return null;
        }
        b[] bVarArr = new b[ebVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr[(bVarArr.length - i2) - 1] = a(context, ebVarArr[i2]);
        }
        AppMethodBeat.o(31846);
        return bVarArr;
    }

    public static b[] a(Context context, cl[] clVarArr) {
        AppMethodBeat.i(31847);
        Log.d("MicroMsg.FMessageProvider", "convert shakeList, talker = " + ((clVarArr == null || clVarArr.length == 0 || clVarArr[0] == null) ? BuildConfig.COMMAND : clVarArr[0].field_sayhiuser));
        if (clVarArr == null || clVarArr.length == 0) {
            Log.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
            AppMethodBeat.o(31847);
            return null;
        }
        b[] bVarArr = new b[clVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr[(bVarArr.length - i2) - 1] = a(context, clVarArr[i2]);
        }
        AppMethodBeat.o(31847);
        return bVarArr;
    }

    public static String a(Context context, int i2, int i3, String str, boolean z) {
        AppMethodBeat.i(31848);
        Log.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(z));
        if (i2 == 0) {
            if (str != null) {
                ca.a bkA = ca.a.bkA(str);
                switch (bkA.scene) {
                    case 4:
                        str = context.getString(R.string.aya);
                        break;
                    case 10:
                    case 11:
                        gq gqVar = new gq();
                        gqVar.dKE.dKB = bkA.OqK;
                        gqVar.dKE.dKC = bkA.OqL;
                        EventCenter.instance.publish(gqVar);
                        str = context.getString(R.string.ayf, Util.nullAs(gqVar.dKF.dKG, ""));
                        break;
                    case 31:
                        str = context.getString(R.string.ayq);
                        break;
                    case 32:
                        str = context.getString(R.string.ayk);
                        break;
                    case 58:
                    case bv.CTRL_INDEX:
                    case 60:
                        str = context.getString(R.string.ayd);
                        break;
                    default:
                        str = context.getString(R.string.ayj);
                        break;
                }
            } else {
                Log.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
                AppMethodBeat.o(31848);
                return null;
            }
        } else if (!z) {
            ca.d bkD = ca.d.bkD(str);
            if (bkD.content == null || bkD.content.trim().equals("")) {
                str = context.getString(R.string.ddm);
            } else {
                str = bkD.content;
            }
        }
        AppMethodBeat.o(31848);
        return str;
    }

    public static void cC(String str, int i2) {
        bn[] bnVarArr;
        cl[] clVarArr;
        b[] bVarArr;
        int i3;
        AppMethodBeat.i(31849);
        bx[] bxVarArr = null;
        if (i2 == 26 || i2 == 27 || i2 == 28 || i2 == 29) {
            Log.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
            cl[] bkW = d.bgP().bkW(str);
            bVarArr = a(MMApplicationContext.getContext(), bkW);
            clVarArr = bkW;
            bnVarArr = null;
        } else if (i2 == 18) {
            Log.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
            bxVarArr = d.bgO().bkx(str);
            bVarArr = a(MMApplicationContext.getContext(), bxVarArr);
            clVarArr = null;
            bnVarArr = null;
        } else {
            bn[] bku = d.bgM().bku(str);
            bVarArr = a(MMApplicationContext.getContext(), bku);
            clVarArr = null;
            bnVarArr = bku;
        }
        if (bVarArr == null) {
            AppMethodBeat.o(31849);
            return;
        }
        int i4 = 0;
        int length = bVarArr.length;
        int i5 = 0;
        while (i5 < length) {
            b bVar = bVarArr[i5];
            ca caVar = new ca();
            caVar.setContent(bVar.iAq);
            int JG = ab.JG(bVar.username);
            if (bnVarArr != null) {
                i3 = i4 + 1;
                caVar.setCreateTime(bnVarArr[i4].field_createTime);
            } else if (bxVarArr != null) {
                i3 = i4 + 1;
                caVar.setCreateTime(bxVarArr[i4].field_createtime * 1000);
            } else if (clVarArr != null) {
                i3 = i4 + 1;
                caVar.setCreateTime(clVarArr[i4].field_createtime * 1000);
            } else {
                i3 = i4;
            }
            caVar.Cy(bVar.username);
            caVar.setType(JG);
            if (bVar.ehd) {
                caVar.setStatus(2);
                caVar.nv(1);
            } else {
                caVar.setStatus(6);
                caVar.nv(0);
            }
            bg.aVF();
            long aC = c.aSQ().aC(caVar);
            Assert.assertTrue(aC != -1);
            Log.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(aC)));
            i5++;
            i4 = i3;
        }
        ca caVar2 = new ca();
        if (bnVarArr != null) {
            caVar2.setCreateTime(bnVarArr[0].field_createTime + 1);
        } else if (bxVarArr != null) {
            caVar2.setCreateTime((bxVarArr[0].field_createtime * 1000) + 1);
        } else if (clVarArr != null) {
            caVar2.setCreateTime((clVarArr[0].field_createtime * 1000) + 1);
        }
        caVar2.Cy(str);
        caVar2.setContent(MMApplicationContext.getContext().getString(R.string.hrm));
        caVar2.setType(10000);
        caVar2.setStatus(6);
        caVar2.nv(0);
        bg.aVF();
        Log.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(c.aSQ().aC(caVar2))));
        AppMethodBeat.o(31849);
    }

    public static as a(bn bnVar) {
        AppMethodBeat.i(31850);
        as asVar = new as();
        if (bnVar == null) {
            AppMethodBeat.o(31850);
            return asVar;
        } else if (bnVar.field_type == 0) {
            as bfc = bfc(bnVar.field_msgContent);
            AppMethodBeat.o(31850);
            return bfc;
        } else {
            as bfd = bfd(bnVar.field_msgContent);
            AppMethodBeat.o(31850);
            return bfd;
        }
    }

    private static as bfc(String str) {
        AppMethodBeat.i(31851);
        ca.a bkA = ca.a.bkA(str);
        as asVar = new as();
        asVar.setUsername(bkA.dkU);
        asVar.BC(bkA.fMb);
        asVar.setNickname(bkA.getDisplayName());
        asVar.BF(bkA.kfQ);
        asVar.BG(bkA.kfR);
        asVar.nj(bkA.fuA);
        asVar.BW(bkA.getProvince());
        asVar.BX(bkA.getCity());
        asVar.BV(bkA.signature);
        asVar.nf(bkA.IOs);
        asVar.Ca(bkA.fuN);
        asVar.Cj(bkA.Kpf);
        AppMethodBeat.o(31851);
        return asVar;
    }

    private static as bfd(String str) {
        AppMethodBeat.i(31852);
        ca.d bkD = ca.d.bkD(str);
        as asVar = new as();
        asVar.setUsername(bkD.dkU);
        asVar.BC(bkD.fMb);
        asVar.setNickname(bkD.nickname);
        asVar.BF(bkD.kfQ);
        asVar.BG(bkD.kfR);
        asVar.nj(bkD.fuA);
        asVar.BV(bkD.signature);
        asVar.BW(bkD.getProvince());
        asVar.BX(bkD.getCity());
        AppMethodBeat.o(31852);
        return asVar;
    }
}
