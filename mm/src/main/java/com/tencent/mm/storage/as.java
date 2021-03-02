package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class as extends c implements Cloneable {
    public CharSequence NON;
    public String Ooy = null;

    public final CharSequence gBL() {
        return this.NON;
    }

    public final void ao(CharSequence charSequence) {
        this.NON = charSequence;
    }

    public as(String str) {
        super(str);
    }

    public as() {
    }

    public static boolean bjm(String str) {
        AppMethodBeat.i(43168);
        if (str != null) {
            boolean endsWith = str.endsWith("@t.qq.com");
            AppMethodBeat.o(43168);
            return endsWith;
        }
        AppMethodBeat.o(43168);
        return false;
    }

    public static boolean bjn(String str) {
        AppMethodBeat.i(43169);
        if (str != null) {
            boolean endsWith = str.endsWith("@qr");
            AppMethodBeat.o(43169);
            return endsWith;
        }
        AppMethodBeat.o(43169);
        return false;
    }

    public static boolean bjo(String str) {
        AppMethodBeat.i(43170);
        if (str != null) {
            boolean endsWith = str.endsWith("@qqim");
            AppMethodBeat.o(43170);
            return endsWith;
        }
        AppMethodBeat.o(43170);
        return false;
    }

    public static boolean bjp(String str) {
        AppMethodBeat.i(43171);
        if (str != null) {
            boolean endsWith = str.endsWith("@openim");
            AppMethodBeat.o(43171);
            return endsWith;
        }
        AppMethodBeat.o(43171);
        return false;
    }

    public static boolean bjq(String str) {
        AppMethodBeat.i(43172);
        if (str != null) {
            boolean endsWith = str.endsWith("@im.chatroom");
            AppMethodBeat.o(43172);
            return endsWith;
        }
        AppMethodBeat.o(43172);
        return false;
    }

    public static boolean bjr(String str) {
        AppMethodBeat.i(43173);
        if (str != null) {
            boolean endsWith = str.endsWith("@fb");
            AppMethodBeat.o(43173);
            return endsWith;
        }
        AppMethodBeat.o(43173);
        return false;
    }

    public static boolean IG(String str) {
        AppMethodBeat.i(43174);
        if (str == null) {
            AppMethodBeat.o(43174);
            return false;
        } else if (str.contains("@bottle:") || str.endsWith("@bottle")) {
            AppMethodBeat.o(43174);
            return true;
        } else {
            AppMethodBeat.o(43174);
            return false;
        }
    }

    public static boolean akh(int i2) {
        return (i2 & 8) > 0;
    }

    public static boolean HF(String str) {
        AppMethodBeat.i(43175);
        if (str != null) {
            boolean endsWith = str.endsWith("@app");
            AppMethodBeat.o(43175);
            return endsWith;
        }
        AppMethodBeat.o(43175);
        return false;
    }

    public static boolean avl(String str) {
        AppMethodBeat.i(225982);
        if (str != null) {
            boolean endsWith = str.endsWith("@findermsg");
            AppMethodBeat.o(225982);
            return endsWith;
        }
        AppMethodBeat.o(225982);
        return false;
    }

    public static boolean bjs(String str) {
        AppMethodBeat.i(225983);
        if (str == null || !str.endsWith("@findermsgstranger")) {
            AppMethodBeat.o(225983);
            return false;
        }
        AppMethodBeat.o(225983);
        return true;
    }

    public static boolean bjt(String str) {
        AppMethodBeat.i(225984);
        if (str != null) {
            boolean endsWith = str.endsWith("@finder");
            AppMethodBeat.o(225984);
            return endsWith;
        }
        AppMethodBeat.o(225984);
        return false;
    }

    public static boolean bju(String str) {
        AppMethodBeat.i(225985);
        if (str != null) {
            boolean endsWith = str.endsWith("@gamelifesess");
            AppMethodBeat.o(225985);
            return endsWith;
        }
        AppMethodBeat.o(225985);
        return false;
    }

    public static boolean bjv(String str) {
        AppMethodBeat.i(225986);
        if (str != null) {
            boolean endsWith = str.endsWith("@gamelife");
            AppMethodBeat.o(225986);
            return endsWith;
        }
        AppMethodBeat.o(225986);
        return false;
    }

    public static boolean bjw(String str) {
        AppMethodBeat.i(225987);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(225987);
            return false;
        } else if (str.endsWith("@findermsg") || str.endsWith("@gamelifesess")) {
            AppMethodBeat.o(225987);
            return true;
        } else {
            AppMethodBeat.o(225987);
            return false;
        }
    }

    public static boolean bjx(String str) {
        AppMethodBeat.i(43176);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
            AppMethodBeat.o(43176);
            return false;
        } else if (bjp(str)) {
            AppMethodBeat.o(43176);
            return true;
        } else {
            String aj = ((a) g.af(a.class)).aqK().aj("HideWechatID", "idprefix");
            if (aj != null) {
                String[] split = aj.split(";");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (split[i2] != null && str.startsWith(split[i2])) {
                        AppMethodBeat.o(43176);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(43176);
            return false;
        }
    }

    public static boolean bjy(String str) {
        AppMethodBeat.i(43177);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(43177);
            return true;
        }
        String[] split = "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;".split(";");
        for (String str2 : split) {
            if (!Util.isNullOrNil(str2) && str.startsWith(str2)) {
                AppMethodBeat.o(43177);
                return true;
            }
        }
        AppMethodBeat.o(43177);
        return false;
    }

    public static String bjz(String str) {
        AppMethodBeat.i(43178);
        if (IG(str)) {
            String[] split = str.split(":");
            if (split == null || split.length <= 0) {
                AppMethodBeat.o(43178);
                return str;
            }
            String str2 = split[0];
            AppMethodBeat.o(43178);
            return str2;
        } else if (str == null || !str.contains("@")) {
            String str3 = str + "@bottle";
            AppMethodBeat.o(43178);
            return str3;
        } else {
            AppMethodBeat.o(43178);
            return "";
        }
    }

    public static int gBO() {
        return 16;
    }

    public static int gBP() {
        return 8;
    }

    public final boolean gBQ() {
        AppMethodBeat.i(43179);
        if (((long) (((int) Util.nowSecond()) - this.fuP)) > 86400) {
            AppMethodBeat.o(43179);
            return true;
        }
        AppMethodBeat.o(43179);
        return false;
    }

    public static String p(Cursor cursor) {
        AppMethodBeat.i(43180);
        String string = cursor.getString(cursor.getColumnIndex(ch.COL_USERNAME));
        AppMethodBeat.o(43180);
        return string;
    }

    @Override // com.tencent.mm.contact.c, com.tencent.mm.g.c.ax
    public final void Cb(String str) {
        AppMethodBeat.i(43181);
        super.Cb(str);
        gBS();
        AppMethodBeat.o(43181);
    }

    @Override // com.tencent.mm.contact.c, com.tencent.mm.g.c.ax
    @Deprecated
    public final void BW(String str) {
        AppMethodBeat.i(43185);
        super.BW(str);
        AppMethodBeat.o(43185);
    }

    @Override // com.tencent.mm.contact.c, com.tencent.mm.g.c.ax
    @Deprecated
    public final void BX(String str) {
        AppMethodBeat.i(43186);
        super.BX(str);
        AppMethodBeat.o(43186);
    }

    @Override // com.tencent.mm.g.c.ax
    public final String getProvince() {
        AppMethodBeat.i(43187);
        String province = super.getProvince();
        AppMethodBeat.o(43187);
        return province;
    }

    @Override // com.tencent.mm.g.c.ax
    public final String getCity() {
        AppMethodBeat.i(43188);
        String city = super.getCity();
        AppMethodBeat.o(43188);
        return city;
    }

    public final as gBT() {
        as asVar;
        AppMethodBeat.i(43190);
        try {
            asVar = (as) super.clone();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Contact", e2, "", new Object[0]);
            Log.e("MicroMsg.Contact", "clone Contact error. e: " + e2.toString());
            asVar = null;
        }
        AppMethodBeat.o(43190);
        return asVar;
    }

    public final boolean gBM() {
        return (this.field_verifyFlag & 8) > 0;
    }

    public final boolean gBN() {
        return (this.field_verifyFlag & 128) > 0;
    }

    public final String getCountryCode() {
        AppMethodBeat.i(43182);
        String str = this.fuO;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(43182);
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length <= 0) {
            AppMethodBeat.o(43182);
            return "";
        }
        String nullAsNil = Util.nullAsNil(split[0]);
        AppMethodBeat.o(43182);
        return nullAsNil;
    }

    public final String gBR() {
        AppMethodBeat.i(43183);
        String str = this.fuO;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(43183);
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length < 2) {
            AppMethodBeat.o(43183);
            return "";
        }
        String nullAsNil = Util.nullAsNil(split[1]);
        AppMethodBeat.o(43183);
        return nullAsNil;
    }

    public final String getCityCode() {
        AppMethodBeat.i(43184);
        String str = this.fuO;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(43184);
            return "";
        }
        String[] split = str.split("_");
        if (split == null || split.length < 3) {
            AppMethodBeat.o(43184);
            return "";
        }
        String nullAsNil = Util.nullAsNil(split[2]);
        AppMethodBeat.o(43184);
        return nullAsNil;
    }

    public final void gBS() {
        AppMethodBeat.i(43189);
        String str = this.fuO;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(43189);
            return;
        }
        String[] split = str.split("_");
        if (split.length > 0) {
            if (split.length > 2) {
                if (RegionCodeDecoder.bkO(split[0])) {
                    RegionCodeDecoder.gEm();
                    super.BW(RegionCodeDecoder.mW(split[0], split[1]));
                } else {
                    RegionCodeDecoder.gEm();
                    super.BW(RegionCodeDecoder.bkP(split[0]));
                }
                RegionCodeDecoder.gEm();
                super.BX(RegionCodeDecoder.bs(split[0], split[1], split[2]));
                AppMethodBeat.o(43189);
                return;
            } else if (split.length == 2) {
                RegionCodeDecoder.gEm();
                super.BW(RegionCodeDecoder.bkP(split[0]));
                RegionCodeDecoder.gEm();
                super.BX(RegionCodeDecoder.mW(split[0], split[1]));
                AppMethodBeat.o(43189);
                return;
            } else {
                RegionCodeDecoder.gEm();
                super.BW(RegionCodeDecoder.bkP(split[0]));
                super.BX("");
            }
        }
        AppMethodBeat.o(43189);
    }
}
