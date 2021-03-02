package com.tencent.mm.aj;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class c {
    public static String ba(String str, String str2) {
        AppMethodBeat.i(150196);
        String str3 = str + "?access_token=" + str2;
        AppMethodBeat.o(150196);
        return str3;
    }

    public static Bitmap LV(String str) {
        AppMethodBeat.i(150197);
        Bitmap a2 = a(str + "@google", false, -1, null);
        AppMethodBeat.o(150197);
        return a2;
    }

    private static String LW(String str) {
        AppMethodBeat.i(150198);
        String str2 = "http://graph.facebook.com/" + str + "/picture";
        AppMethodBeat.o(150198);
        return str2;
    }

    public static void LX(String str) {
        AppMethodBeat.i(150199);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150199);
            return;
        }
        String str2 = str + "@fb";
        i Mx = p.aYB().Mx(str2);
        if (Mx == null || !str2.equals(Mx.getUsername()) || 3 != Mx.fuz) {
            if (Mx == null) {
                Mx = new i();
            }
            Mx.username = str2;
            Mx.fuz = 3;
            Mx.iKX = LW(str);
            Mx.iKW = LW(str);
            Mx.fv(true);
            Mx.cSx = 31;
            p.aYB().b(Mx);
            AppMethodBeat.o(150199);
            return;
        }
        AppMethodBeat.o(150199);
    }

    public static Bitmap LY(String str) {
        AppMethodBeat.i(150200);
        Bitmap a2 = a(str + "@fb", false, -1, null);
        AppMethodBeat.o(150200);
        return a2;
    }

    public static long LZ(String str) {
        long j2 = -1;
        AppMethodBeat.i(150201);
        if (!as.bjr(str)) {
            AppMethodBeat.o(150201);
        } else {
            try {
                j2 = Util.getLong(str.split("@")[0], -1);
                AppMethodBeat.o(150201);
            } catch (Exception e2) {
                AppMethodBeat.o(150201);
            }
        }
        return j2;
    }

    private static String Ag(long j2) {
        AppMethodBeat.i(150202);
        String str = new p(j2) + "@qqim";
        AppMethodBeat.o(150202);
        return str;
    }

    public static long Ma(String str) {
        long j2 = -1;
        AppMethodBeat.i(150203);
        if (!as.bjo(str)) {
            AppMethodBeat.o(150203);
        } else {
            try {
                j2 = Util.getLong(str.split("@")[0], -1);
                AppMethodBeat.o(150203);
            } catch (Exception e2) {
                AppMethodBeat.o(150203);
            }
        }
        return j2;
    }

    public static boolean e(long j2, int i2) {
        AppMethodBeat.i(150204);
        if (i2 != 3) {
            AppMethodBeat.o(150204);
            return false;
        }
        boolean Mb = Mb(Ag(j2));
        AppMethodBeat.o(150204);
        return Mb;
    }

    public static boolean Mb(String str) {
        AppMethodBeat.i(150205);
        if (str == null) {
            Log.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            AppMethodBeat.o(150205);
            return false;
        } else if (!str.endsWith("@qqim")) {
            Log.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            AppMethodBeat.o(150205);
            return false;
        } else {
            i iVar = new i();
            iVar.username = str;
            iVar.fuz = 3;
            iVar.cSx = 3;
            boolean b2 = p.aYB().b(iVar);
            AppMethodBeat.o(150205);
            return b2;
        }
    }

    public static Bitmap Ah(long j2) {
        AppMethodBeat.i(150206);
        Bitmap a2 = a(Ag(j2), false, -1, null);
        AppMethodBeat.o(150206);
        return a2;
    }

    public static boolean ap(String str, int i2) {
        AppMethodBeat.i(150207);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150207);
            return false;
        }
        i Mx = p.aYB().Mx(str);
        if (Mx == null || !str.equals(Mx.getUsername()) || i2 != Mx.fuz) {
            if (Mx == null) {
                Mx = new i();
            }
            Mx.username = str;
            Mx.fuz = i2;
            Mx.cSx = 3;
            boolean b2 = p.aYB().b(Mx);
            AppMethodBeat.o(150207);
            return b2;
        }
        AppMethodBeat.o(150207);
        return true;
    }

    public static Bitmap e(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(150209);
        if (Util.isNullOrNil(str) || !g.aAf().azp()) {
            AppMethodBeat.o(150209);
            return null;
        }
        p.aYn();
        Bitmap o = e.o(str, i2, i3);
        if (o == null) {
            final f fVar = new f();
            fVar.a(str, new f.c() {
                /* class com.tencent.mm.aj.c.AnonymousClass1 */

                @Override // com.tencent.mm.aj.f.c
                public final int dp(int i2, int i3) {
                    AppMethodBeat.i(150195);
                    fVar.sQ();
                    Log.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    AppMethodBeat.o(150195);
                    return 0;
                }
            });
            Bitmap a2 = a(str, false, i4, null);
            AppMethodBeat.o(150209);
            return a2;
        }
        if (i4 > 5) {
            o = BitmapUtil.getRoundedCornerBitmap(o, false, (float) i4);
        }
        AppMethodBeat.o(150209);
        return o;
    }

    public static Bitmap a(String str, boolean z, int i2, b bVar) {
        AppMethodBeat.i(223530);
        if (Util.isNullOrNil(str) || !g.aAf().azp()) {
            AppMethodBeat.o(223530);
            return null;
        }
        if (as.IG(str)) {
            str = as.bjz(str);
        }
        if (ab.IN(str)) {
            str = "weixin";
        }
        Bitmap b2 = p.aYD().b(str, z, i2, bVar);
        AppMethodBeat.o(223530);
        return b2;
    }

    public static String Md(String str) {
        AppMethodBeat.i(184252);
        String Me = Me(str);
        AppMethodBeat.o(184252);
        return Me;
    }

    public static String Me(String str) {
        AppMethodBeat.i(150211);
        if (Util.isNullOrNil(str) || !g.aAf().azp()) {
            AppMethodBeat.o(150211);
            return null;
        } else if (as.IG(str)) {
            p.aYn();
            String L = e.L(as.bjz(str), false);
            AppMethodBeat.o(150211);
            return L;
        } else {
            p.aYn();
            String L2 = e.L(str, false);
            AppMethodBeat.o(150211);
            return L2;
        }
    }

    public static void Mf(String str) {
        AppMethodBeat.i(150212);
        i Mx = p.aYB().Mx(str);
        if (Mx == null) {
            AppMethodBeat.o(150212);
        } else if (!str.equals(Mx.getUsername())) {
            AppMethodBeat.o(150212);
        } else {
            Mx.iKZ = 0;
            Mx.cSx = 64;
            p.aYB().b(Mx);
            AppMethodBeat.o(150212);
        }
    }

    public static i a(String str, cpl cpl) {
        AppMethodBeat.i(150213);
        i iVar = new i();
        iVar.cSx = -1;
        iVar.username = str;
        iVar.iKW = cpl.Lis;
        iVar.iKX = cpl.Lir;
        Log.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", iVar.getUsername(), iVar.aYt(), iVar.aYu());
        iVar.fv(cpl.Mvi != 0);
        if (cpl.Mvd == 3 || cpl.Mvd == 4) {
            iVar.fuz = cpl.Mvd;
        } else if (cpl.Mvd == 2) {
            iVar.fuz = 3;
            if (!z.aTY().equals(str)) {
                p.aYn();
                e.N(str, false);
                p.aYn();
                e.N(str, true);
                p.aYB().b(iVar);
                p.aYD().Mg(str);
            }
        }
        AppMethodBeat.o(150213);
        return iVar;
    }

    public static Bitmap Mc(String str) {
        AppMethodBeat.i(263516);
        Bitmap a2 = a(str, false, -1, null);
        AppMethodBeat.o(263516);
        return a2;
    }
}
