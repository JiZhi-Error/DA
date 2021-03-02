package com.tencent.mm.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.lang.reflect.Field;

public class c extends ax {
    private static a gNa = null;
    public static IAutoDBItem.MAutoDBInfo info;
    public long gMZ;
    public int versionCode;

    public interface a {
        String gu(String str);

        String gv(String str);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public c(String str) {
        this();
        AppMethodBeat.i(42666);
        setUsername(str == null ? "" : str);
        AppMethodBeat.o(42666);
    }

    public c() {
        AppMethodBeat.i(42667);
        this.versionCode = 0;
        super.setUsername("");
        super.setNickname("");
        super.BF("");
        super.BG("");
        super.BC("");
        super.BD("");
        super.BJ("");
        super.BI("");
        super.BE("");
        super.ne(0);
        super.BH("");
        super.nd(0);
        super.setType(0);
        super.nf(0);
        super.ng(0);
        super.BL("");
        super.nj(0);
        super.BY("");
        super.setFromType(0);
        super.setUin(0);
        super.BR("");
        super.BS("");
        super.nk(0);
        super.nl(0);
        super.BT("");
        super.BU("");
        super.nm(1);
        super.ni(0);
        super.nn(0);
        super.BV("");
        super.BW("");
        super.BX("");
        super.setSource(0);
        super.Ca("");
        super.BZ("");
        super.yx(0);
        super.BQ("");
        super.Cb("");
        super.no(0);
        super.Ce("");
        super.Cf("");
        super.Cg("");
        super.Cj("");
        super.BM("");
        super.BN("");
        this.versionCode = 0;
        AppMethodBeat.o(42667);
    }

    public static void a(a aVar) {
        gNa = aVar;
    }

    public static String Ew(String str) {
        AppMethodBeat.i(42668);
        if (gNa != null) {
            String gu = gNa.gu(str);
            AppMethodBeat.o(42668);
            return gu;
        }
        AppMethodBeat.o(42668);
        return null;
    }

    public final int aqN() {
        AppMethodBeat.i(42669);
        char c2 = ' ';
        if (this.field_conRemarkPYShort != null && !this.field_conRemarkPYShort.equals("")) {
            c2 = this.field_conRemarkPYShort.charAt(0);
        } else if (this.field_conRemarkPYFull != null && !this.field_conRemarkPYFull.equals("")) {
            c2 = this.field_conRemarkPYFull.charAt(0);
        } else if (super.ajz() != null && !super.ajz().equals("")) {
            c2 = super.ajz().charAt(0);
        } else if (super.ajA() != null && !super.ajA().equals("")) {
            c2 = super.ajA().charAt(0);
        } else if (this.field_nickname != null && !this.field_nickname.equals("") && isLetter(this.field_nickname.charAt(0))) {
            c2 = this.field_nickname.charAt(0);
        } else if (this.field_username != null && !this.field_username.equals("") && isLetter(this.field_username.charAt(0))) {
            c2 = this.field_username.charAt(0);
        }
        if (c2 >= 'a' && c2 <= 'z') {
            c2 = (char) (c2 - ' ');
        } else if (c2 < 'A' || c2 > 'Z') {
            c2 = '{';
        }
        AppMethodBeat.o(42669);
        return c2;
    }

    public final void aqO() {
        AppMethodBeat.i(42670);
        setType(0);
        AppMethodBeat.o(42670);
    }

    public final void aqR() {
        AppMethodBeat.i(42673);
        Log.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", this.field_username, Integer.valueOf(this.field_type), Util.getStack());
        setType(this.field_type & -2);
        AppMethodBeat.o(42673);
    }

    public static int arn() {
        return 1;
    }

    public static int aro() {
        return 8;
    }

    public static int arp() {
        return 524288;
    }

    public static int arq() {
        return TPMediaCodecProfileLevel.HEVCHighTierLevel61;
    }

    public static int arr() {
        return TPMediaCodecProfileLevel.HEVCHighTierLevel62;
    }

    public static int ars() {
        return 134217728;
    }

    public static int art() {
        return 16;
    }

    public static int aru() {
        return 32;
    }

    public static boolean oR(int i2) {
        if ((i2 & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean arz() {
        return (524288 & this.field_type) != 0;
    }

    public final boolean arC() {
        return (65536 & this.field_type) != 0;
    }

    public final boolean arD() {
        return (8388608 & this.field_type) != 0;
    }

    public final boolean arF() {
        return (32768 & this.field_type) != 0;
    }

    private static boolean isLetter(char c2) {
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z');
    }

    public final int arH() {
        return (int) this.gMZ;
    }

    @Override // com.tencent.mm.g.c.ax
    public final String ajz() {
        AppMethodBeat.i(42693);
        if (super.ajz() == null || super.ajz().length() < 0) {
            String ajA = ajA();
            AppMethodBeat.o(42693);
            return ajA;
        }
        String ajz = super.ajz();
        AppMethodBeat.o(42693);
        return ajz;
    }

    @Override // com.tencent.mm.g.c.ax
    public final String ajA() {
        AppMethodBeat.i(42694);
        if (super.ajA() == null || super.ajA().length() < 0) {
            String str = this.field_nickname;
            AppMethodBeat.o(42694);
            return str;
        }
        String ajA = super.ajA();
        AppMethodBeat.o(42694);
        return ajA;
    }

    @Override // com.tencent.mm.g.c.ax
    public final String ajx() {
        AppMethodBeat.i(42695);
        String gv = gNa != null ? gNa.gv(this.field_username) : null;
        if (gv == null) {
            String ajx = super.ajx();
            AppMethodBeat.o(42695);
            return ajx;
        }
        AppMethodBeat.o(42695);
        return gv;
    }

    public final String arI() {
        AppMethodBeat.i(42696);
        String gu = gNa != null ? gNa.gu(this.field_username) : null;
        if (gu != null) {
            AppMethodBeat.o(42696);
            return gu;
        } else if (this.field_nickname == null || this.field_nickname.length() <= 0) {
            String arK = arK();
            AppMethodBeat.o(42696);
            return arK;
        } else {
            String str = this.field_nickname;
            AppMethodBeat.o(42696);
            return str;
        }
    }

    public final String arK() {
        AppMethodBeat.i(42698);
        String ajx = ajx();
        if (!Util.isNullOrNil(ajx)) {
            AppMethodBeat.o(42698);
            return ajx;
        }
        String Ex = Ex(this.field_username);
        if (Ex == null || Ex.length() == 0) {
            String str = this.field_username;
            AppMethodBeat.o(42698);
            return str;
        }
        AppMethodBeat.o(42698);
        return Ex;
    }

    @Override // com.tencent.mm.g.c.ax
    public final int getSource() {
        AppMethodBeat.i(42699);
        int source = super.getSource() % 1000000;
        AppMethodBeat.o(42699);
        return source;
    }

    public final int arL() {
        AppMethodBeat.i(42700);
        int source = super.getSource();
        AppMethodBeat.o(42700);
        return source;
    }

    private static String Ex(String str) {
        AppMethodBeat.i(42701);
        if (str == null) {
            AppMethodBeat.o(42701);
            return null;
        } else if (str.toLowerCase().endsWith("@t.qq.com")) {
            String str2 = "@" + str.replace("@t.qq.com", "");
            AppMethodBeat.o(42701);
            return str2;
        } else if (str.toLowerCase().endsWith("@qqim")) {
            String replace = str.replace("@qqim", "");
            long longValue = Long.valueOf(replace).longValue();
            if (longValue < 0) {
                String pVar = new p(longValue).toString();
                AppMethodBeat.o(42701);
                return pVar;
            }
            AppMethodBeat.o(42701);
            return replace;
        } else if (str.toLowerCase().endsWith("@stranger")) {
            AppMethodBeat.o(42701);
            return " ";
        } else {
            AppMethodBeat.o(42701);
            return str;
        }
    }

    @Override // com.tencent.mm.g.c.ax, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        AppMethodBeat.i(42703);
        super.convertFrom(cursor);
        this.gMZ = this.systemRowid;
        super.Z(null);
        AppMethodBeat.o(42703);
    }

    private int arM() {
        int i2 = this.versionCode + 1;
        this.versionCode = i2;
        return i2;
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BC(String str) {
        AppMethodBeat.i(42705);
        if (!Util.isEqual(ajx(), str)) {
            super.BC(str);
            arM();
        }
        AppMethodBeat.o(42705);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BF(String str) {
        AppMethodBeat.i(42709);
        if (!Util.isEqual(ajz(), str)) {
            super.BF(str);
            arM();
        }
        AppMethodBeat.o(42709);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BG(String str) {
        AppMethodBeat.i(42710);
        if (!Util.isEqual(ajA(), str)) {
            super.BG(str);
            arM();
        }
        AppMethodBeat.o(42710);
    }

    @Override // com.tencent.mm.g.c.ax
    public void BW(String str) {
        AppMethodBeat.i(42737);
        if (!Util.isEqual(getProvince(), str)) {
            super.BW(str);
            arM();
        }
        AppMethodBeat.o(42737);
    }

    @Override // com.tencent.mm.g.c.ax
    public void BX(String str) {
        AppMethodBeat.i(42738);
        if (!Util.isEqual(getCity(), str)) {
            super.BX(str);
            arM();
        }
        AppMethodBeat.o(42738);
    }

    public final void aqP() {
        AppMethodBeat.i(42671);
        setType(this.field_type | 4);
        AppMethodBeat.o(42671);
    }

    public final void aqQ() {
        AppMethodBeat.i(42672);
        setType(this.field_type | 1);
        AppMethodBeat.o(42672);
    }

    public final void aqS() {
        AppMethodBeat.i(42674);
        setType(this.field_type | 8);
        AppMethodBeat.o(42674);
    }

    public final void aqT() {
        AppMethodBeat.i(42675);
        setType(this.field_type & -9);
        AppMethodBeat.o(42675);
    }

    public final void aqU() {
        AppMethodBeat.i(42676);
        setType(this.field_type | 524288);
        AppMethodBeat.o(42676);
    }

    public final void aqV() {
        AppMethodBeat.i(42677);
        setType(this.field_type & -524289);
        AppMethodBeat.o(42677);
    }

    public final void aqW() {
        AppMethodBeat.i(42678);
        setType(this.field_type | 2);
        AppMethodBeat.o(42678);
    }

    public final void aqX() {
        AppMethodBeat.i(42679);
        setType(this.field_type & -3);
        AppMethodBeat.o(42679);
    }

    public final void aqY() {
        AppMethodBeat.i(42680);
        setType(this.field_type & -2049);
        AppMethodBeat.o(42680);
    }

    public final void aqZ() {
        AppMethodBeat.i(42681);
        setType(this.field_type | 32);
        AppMethodBeat.o(42681);
    }

    public final void ara() {
        AppMethodBeat.i(42682);
        setType(this.field_type & -33);
        AppMethodBeat.o(42682);
    }

    public final void arb() {
        AppMethodBeat.i(42683);
        setType(this.field_type | 64);
        AppMethodBeat.o(42683);
    }

    public final void arc() {
        AppMethodBeat.i(42684);
        setType(this.field_type & -65);
        AppMethodBeat.o(42684);
    }

    public final void ard() {
        AppMethodBeat.i(42685);
        setType(this.field_type | 512);
        AppMethodBeat.o(42685);
    }

    public final void are() {
        AppMethodBeat.i(42686);
        setType(this.field_type & -513);
        AppMethodBeat.o(42686);
    }

    public final void arf() {
        AppMethodBeat.i(42687);
        setType(this.field_type | 256);
        AppMethodBeat.o(42687);
    }

    public final void arg() {
        AppMethodBeat.i(42688);
        setType(this.field_type & -257);
        AppMethodBeat.o(42688);
    }

    public final void arh() {
        AppMethodBeat.i(42689);
        setType(this.field_type | TPMediaCodecProfileLevel.HEVCHighTierLevel61);
        AppMethodBeat.o(42689);
    }

    public final void ari() {
        AppMethodBeat.i(42690);
        setType(this.field_type & -8388609);
        AppMethodBeat.o(42690);
    }

    public final void arj() {
        AppMethodBeat.i(225908);
        setType(this.field_type | TPMediaCodecProfileLevel.HEVCHighTierLevel62);
        AppMethodBeat.o(225908);
    }

    public final void ark() {
        AppMethodBeat.i(225909);
        setType(this.field_type & -33554433);
        AppMethodBeat.o(225909);
    }

    public final void arl() {
        AppMethodBeat.i(225910);
        setType(this.field_type | 134217728);
        AppMethodBeat.o(225910);
    }

    public final void arm() {
        AppMethodBeat.i(225911);
        setType(this.field_type & -134217729);
        AppMethodBeat.o(225911);
    }

    public final boolean arv() {
        AppMethodBeat.i(259834);
        boolean oR = oR(this.field_type);
        AppMethodBeat.o(259834);
        return oR;
    }

    public final boolean arw() {
        if ((this.field_type & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isHidden() {
        return (this.field_type & 32) != 0;
    }

    public final boolean arx() {
        return (this.field_type & 4) != 0;
    }

    public final boolean ary() {
        return (this.field_type & 8) != 0;
    }

    public final boolean arA() {
        return (this.field_type & 64) != 0;
    }

    public final boolean Zx() {
        return (this.field_type & 512) != 0;
    }

    public final boolean amU() {
        return (this.field_type & 1024) == 0;
    }

    public final boolean arB() {
        return (this.field_type & 256) != 0;
    }

    public final boolean arE() {
        return (this.field_type & 2048) != 0;
    }

    public final void arG() {
        AppMethodBeat.i(42692);
        setType(this.field_type | 32768);
        AppMethodBeat.o(42692);
    }

    public final String arJ() {
        AppMethodBeat.i(42697);
        if (this.field_conRemark == null || this.field_conRemark.trim().equals("")) {
            String arI = arI();
            AppMethodBeat.o(42697);
            return arI;
        }
        String str = this.field_conRemark;
        AppMethodBeat.o(42697);
        return str;
    }

    public final void oS(int i2) {
        AppMethodBeat.i(42702);
        ng((this.field_chatroomFlag & -2) | (i2 & 1));
        AppMethodBeat.o(42702);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void setUsername(String str) {
        AppMethodBeat.i(42704);
        if (!Util.isEqual(this.field_username, str)) {
            super.setUsername(str);
            arM();
        }
        AppMethodBeat.o(42704);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BD(String str) {
        AppMethodBeat.i(42706);
        if (!Util.isEqual(this.field_conRemark, str)) {
            super.BD(str);
            arM();
        }
        AppMethodBeat.o(42706);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BE(String str) {
        AppMethodBeat.i(42707);
        if (!Util.isEqual(this.field_domainList, str)) {
            super.BE(str);
            arM();
        }
        AppMethodBeat.o(42707);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void setNickname(String str) {
        AppMethodBeat.i(42708);
        if (!Util.isEqual(this.field_nickname, str)) {
            super.setNickname(str);
            arM();
        }
        AppMethodBeat.o(42708);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void nd(int i2) {
        AppMethodBeat.i(42711);
        if (!Util.isEqual(this.field_showHead, i2)) {
            super.nd(i2);
            arM();
        }
        AppMethodBeat.o(42711);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void setType(int i2) {
        AppMethodBeat.i(42712);
        if (!Util.isEqual(this.field_type, i2)) {
            super.setType(i2);
            arM();
        }
        AppMethodBeat.o(42712);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void ne(int i2) {
        AppMethodBeat.i(42713);
        if (!Util.isEqual(this.field_weiboFlag, i2)) {
            super.ne(i2);
            arM();
        }
        AppMethodBeat.o(42713);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BH(String str) {
        AppMethodBeat.i(42714);
        if (!Util.isEqual(this.field_weiboNickname, str)) {
            super.BH(str);
            arM();
        }
        AppMethodBeat.o(42714);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BI(String str) {
        AppMethodBeat.i(42715);
        if (!Util.isEqual(this.field_conRemarkPYFull, str)) {
            super.BI(str);
            arM();
        }
        AppMethodBeat.o(42715);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BJ(String str) {
        AppMethodBeat.i(42716);
        if (!Util.isEqual(this.field_conRemarkPYShort, str)) {
            super.BJ(str);
            arM();
        }
        AppMethodBeat.o(42716);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void Z(byte[] bArr) {
        AppMethodBeat.i(42717);
        if (!Util.isEqual(this.field_lvbuff, bArr)) {
            super.Z(bArr);
            arM();
        }
        AppMethodBeat.o(42717);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void nf(int i2) {
        AppMethodBeat.i(42718);
        if (!Util.isEqual(this.field_verifyFlag, i2)) {
            super.nf(i2);
            arM();
        }
        AppMethodBeat.o(42718);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BK(String str) {
        AppMethodBeat.i(42719);
        if (!Util.isEqual(this.field_encryptUsername, str)) {
            super.BK(str);
            arM();
        }
        AppMethodBeat.o(42719);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void ng(int i2) {
        AppMethodBeat.i(42720);
        if (!Util.isEqual(this.field_chatroomFlag, i2)) {
            super.ng(i2);
            arM();
        }
        AppMethodBeat.o(42720);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void nh(int i2) {
        AppMethodBeat.i(42721);
        if (!Util.isEqual(this.field_deleteFlag, i2)) {
            super.nh(i2);
            arM();
        }
        AppMethodBeat.o(42721);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BL(String str) {
        AppMethodBeat.i(42722);
        if (!Util.isEqual(this.field_contactLabelIds, str)) {
            super.BL(str);
            arM();
        }
        AppMethodBeat.o(42722);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void ni(int i2) {
        AppMethodBeat.i(42723);
        if (!Util.isEqual(this.fuz, i2)) {
            super.ni(i2);
            arM();
        }
        AppMethodBeat.o(42723);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void nj(int i2) {
        AppMethodBeat.i(42724);
        if (!Util.isEqual(this.fuA, i2)) {
            super.nj(i2);
            arM();
        }
        AppMethodBeat.o(42724);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BQ(String str) {
        AppMethodBeat.i(42725);
        if (!Util.isEqual(this.fuB, str)) {
            super.BQ(str);
            arM();
        }
        AppMethodBeat.o(42725);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void yx(long j2) {
        AppMethodBeat.i(42726);
        if (!Util.isEqual(this.fuC, j2)) {
            super.yx(j2);
            arM();
        }
        AppMethodBeat.o(42726);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void setUin(int i2) {
        AppMethodBeat.i(42727);
        if (!Util.isEqual(this.uin, i2)) {
            super.setUin(i2);
            arM();
        }
        AppMethodBeat.o(42727);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BR(String str) {
        AppMethodBeat.i(42728);
        if (!Util.isEqual(this.fuD, str)) {
            super.BR(str);
            arM();
        }
        AppMethodBeat.o(42728);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BS(String str) {
        AppMethodBeat.i(42729);
        if (!Util.isEqual(this.dSf, str)) {
            super.BS(str);
            arM();
        }
        AppMethodBeat.o(42729);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void nk(int i2) {
        AppMethodBeat.i(42730);
        if (!Util.isEqual(this.showFlag, i2)) {
            super.nk(i2);
            arM();
        }
        AppMethodBeat.o(42730);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void nl(int i2) {
        AppMethodBeat.i(42731);
        if (!Util.isEqual(this.fuE, i2)) {
            super.nl(i2);
            arM();
        }
        AppMethodBeat.o(42731);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BT(String str) {
        AppMethodBeat.i(42732);
        if (!Util.isEqual(this.fuF, str)) {
            super.BT(str);
            arM();
        }
        AppMethodBeat.o(42732);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BU(String str) {
        AppMethodBeat.i(42733);
        if (!Util.isEqual(this.fuG, str)) {
            super.BU(str);
            arM();
        }
        AppMethodBeat.o(42733);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void nm(int i2) {
        AppMethodBeat.i(42734);
        if (!Util.isEqual(this.fuH, i2)) {
            super.nm(i2);
            arM();
        }
        AppMethodBeat.o(42734);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void nn(int i2) {
        AppMethodBeat.i(42735);
        if (!Util.isEqual(this.fuI, i2)) {
            super.nn(i2);
            arM();
        }
        AppMethodBeat.o(42735);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BV(String str) {
        AppMethodBeat.i(42736);
        if (!Util.isEqual(this.signature, str)) {
            super.BV(str);
            arM();
        }
        AppMethodBeat.o(42736);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BY(String str) {
        AppMethodBeat.i(42739);
        if (!Util.isEqual(this.fuL, str)) {
            super.BY(str);
            arM();
        }
        AppMethodBeat.o(42739);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void setFromType(int i2) {
        AppMethodBeat.i(42740);
        if (!Util.isEqual(this.fromType, i2)) {
            super.setFromType(i2);
            arM();
        }
        AppMethodBeat.o(42740);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void setSource(int i2) {
        AppMethodBeat.i(42741);
        if (!Util.isEqual(super.getSource(), i2)) {
            super.setSource(i2);
            arM();
        }
        AppMethodBeat.o(42741);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BZ(String str) {
        AppMethodBeat.i(42742);
        if (!Util.isEqual(this.fuM, str)) {
            super.BZ(str);
            arM();
        }
        AppMethodBeat.o(42742);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void Ca(String str) {
        AppMethodBeat.i(42743);
        if (!Util.isEqual(this.fuN, str)) {
            super.Ca(str);
            arM();
        }
        AppMethodBeat.o(42743);
    }

    @Override // com.tencent.mm.g.c.ax
    public void Cb(String str) {
        AppMethodBeat.i(42744);
        if (!Util.isEqual(this.fuO, str)) {
            super.Cb(str);
            arM();
        }
        AppMethodBeat.o(42744);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void no(int i2) {
        AppMethodBeat.i(42745);
        if (!Util.isEqual(this.fuP, i2)) {
            super.no(i2);
            arM();
        }
        AppMethodBeat.o(42745);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void np(int i2) {
        AppMethodBeat.i(42746);
        if (!Util.isEqual(this.fuQ, i2)) {
            super.np(i2);
            arM();
        }
        AppMethodBeat.o(42746);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void Cc(String str) {
        AppMethodBeat.i(42747);
        if (!Util.isEqual(this.fuR, str)) {
            super.Cc(str);
            arM();
        }
        AppMethodBeat.o(42747);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void Cd(String str) {
        AppMethodBeat.i(42748);
        if (!Util.isEqual(this.fuS, str)) {
            super.Cd(str);
            arM();
        }
        AppMethodBeat.o(42748);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void Ce(String str) {
        AppMethodBeat.i(42749);
        if (!Util.isEqual(this.fuT, str)) {
            super.Ce(str);
            arM();
        }
        AppMethodBeat.o(42749);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void Cf(String str) {
        AppMethodBeat.i(42750);
        if (!Util.isEqual(this.fuU, str)) {
            super.Cf(str);
            arM();
        }
        AppMethodBeat.o(42750);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void Cg(String str) {
        AppMethodBeat.i(42751);
        if (!Util.isEqual(this.fuV, str)) {
            super.Cg(str);
            arM();
        }
        AppMethodBeat.o(42751);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void Ch(String str) {
        AppMethodBeat.i(42752);
        if (!Util.isEqual(this.fuW, str)) {
            super.Ch(str);
            arM();
        }
        AppMethodBeat.o(42752);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void Ci(String str) {
        AppMethodBeat.i(42753);
        if (!Util.isEqual(this.fuX, str)) {
            super.Ci(str);
            arM();
        }
        AppMethodBeat.o(42753);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void Cj(String str) {
        AppMethodBeat.i(42754);
        if (!Util.isEqual(this.fuY, str)) {
            super.Cj(str);
            arM();
        }
        AppMethodBeat.o(42754);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BN(String str) {
        AppMethodBeat.i(42755);
        if (!Util.isEqual(this.field_openImAppid, str)) {
            super.BN(str);
            arM();
        }
        AppMethodBeat.o(42755);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BO(String str) {
        AppMethodBeat.i(42756);
        if (!Util.isEqual(this.field_sourceExtInfo, str)) {
            super.BO(str);
            arM();
        }
        AppMethodBeat.o(42756);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void BP(String str) {
        AppMethodBeat.i(42757);
        if (!Util.isEqual(this.field_ticket, str)) {
            super.BP(str);
            arM();
        }
        AppMethodBeat.o(42757);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void yy(long j2) {
        AppMethodBeat.i(163506);
        if (!Util.isEqual(this.fvd, j2)) {
            super.yy(j2);
            arM();
        }
        AppMethodBeat.o(163506);
    }

    @Override // com.tencent.mm.g.c.ax
    public final void yz(long j2) {
        AppMethodBeat.i(178862);
        if (!Util.isEqual(this.fve, j2)) {
            super.yz(j2);
            arM();
        }
        AppMethodBeat.o(178862);
    }

    static {
        AppMethodBeat.i(42758);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[23];
        mAutoDBInfo.columns = new String[24];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT default ''  PRIMARY KEY ");
        sb.append(" username TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_USERNAME;
        mAutoDBInfo.columns[1] = "alias";
        mAutoDBInfo.colsMap.put("alias", "TEXT default '' ");
        sb.append(" alias TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "conRemark";
        mAutoDBInfo.colsMap.put("conRemark", "TEXT default '' ");
        sb.append(" conRemark TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "domainList";
        mAutoDBInfo.colsMap.put("domainList", "TEXT default '' ");
        sb.append(" domainList TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "nickname";
        mAutoDBInfo.colsMap.put("nickname", "TEXT default '' ");
        sb.append(" nickname TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "pyInitial";
        mAutoDBInfo.colsMap.put("pyInitial", "TEXT default '' ");
        sb.append(" pyInitial TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "quanPin";
        mAutoDBInfo.colsMap.put("quanPin", "TEXT default '' ");
        sb.append(" quanPin TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "showHead";
        mAutoDBInfo.colsMap.put("showHead", "INTEGER default '0' ");
        sb.append(" showHead INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
        sb.append(" type INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "weiboFlag";
        mAutoDBInfo.colsMap.put("weiboFlag", "INTEGER default '0' ");
        sb.append(" weiboFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "weiboNickname";
        mAutoDBInfo.colsMap.put("weiboNickname", "TEXT default '' ");
        sb.append(" weiboNickname TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "conRemarkPYFull";
        mAutoDBInfo.colsMap.put("conRemarkPYFull", "TEXT default '' ");
        sb.append(" conRemarkPYFull TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "conRemarkPYShort";
        mAutoDBInfo.colsMap.put("conRemarkPYShort", "TEXT default '' ");
        sb.append(" conRemarkPYShort TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "lvbuff";
        mAutoDBInfo.colsMap.put("lvbuff", "BLOB");
        sb.append(" lvbuff BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "verifyFlag";
        mAutoDBInfo.colsMap.put("verifyFlag", "INTEGER default '0' ");
        sb.append(" verifyFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "encryptUsername";
        mAutoDBInfo.colsMap.put("encryptUsername", "TEXT default '' ");
        sb.append(" encryptUsername TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "chatroomFlag";
        mAutoDBInfo.colsMap.put("chatroomFlag", "INTEGER");
        sb.append(" chatroomFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "deleteFlag";
        mAutoDBInfo.colsMap.put("deleteFlag", "INTEGER default '0' ");
        sb.append(" deleteFlag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "contactLabelIds";
        mAutoDBInfo.colsMap.put("contactLabelIds", "TEXT default '' ");
        sb.append(" contactLabelIds TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "descWordingId";
        mAutoDBInfo.colsMap.put("descWordingId", "TEXT default '' ");
        sb.append(" descWordingId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "openImAppid";
        mAutoDBInfo.colsMap.put("openImAppid", "TEXT");
        sb.append(" openImAppid TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "sourceExtInfo";
        mAutoDBInfo.colsMap.put("sourceExtInfo", "TEXT");
        sb.append(" sourceExtInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "ticket";
        mAutoDBInfo.colsMap.put("ticket", "TEXT default '' ");
        sb.append(" ticket TEXT default '' ");
        mAutoDBInfo.columns[23] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(42758);
    }
}
