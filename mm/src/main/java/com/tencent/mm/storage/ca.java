package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.ab;
import com.tencent.mm.az.a;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import junit.framework.Assert;

public final class ca extends ab {
    public static String OqB = "voip_content_voice";
    public static String OqC = "voip_content_video";
    public jo OqD = null;
    public boolean OqE = false;
    public boolean OqF = false;
    private String OqG;
    public boolean ZA = false;
    public String sessionId;

    public ca() {
    }

    public ca(String str) {
        AppMethodBeat.i(43216);
        super.Cy(str);
        AppMethodBeat.o(43216);
    }

    public final boolean gDz() {
        AppMethodBeat.i(43246);
        if (!Xn() || Util.isNullOrNil(this.field_transContent)) {
            AppMethodBeat.o(43246);
            return false;
        }
        AppMethodBeat.o(43246);
        return true;
    }

    public static final class c {
        public String BqZ;
        public String OqW = "";
        public String content = "";
        public String jje = "";
        public String title = "";
        public boolean tmn = false;

        private c() {
        }

        public static c bkC(String str) {
            AppMethodBeat.i(43211);
            c cVar = new c();
            Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
            if (parseXml != null) {
                try {
                    cVar.title = parseXml.get(".msg.pushmail.content.subject");
                    cVar.content = parseXml.get(".msg.pushmail.content.digest");
                    cVar.jje = parseXml.get(".msg.pushmail.content.sender");
                    cVar.OqW = parseXml.get(".msg.pushmail.waplink");
                    cVar.tmn = Util.nullAsNil(parseXml.get(".msg.pushmail.content.attach")).equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    cVar.BqZ = parseXml.get(".msg.pushmail.mailid");
                } catch (Exception e2) {
                    Log.e("MicroMsg.MsgInfo", "exception:%s", Util.stackTraceToString(e2));
                }
            }
            AppMethodBeat.o(43211);
            return cVar;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSender() {
            return this.jje;
        }
    }

    public static final class d {
        public long Bge = 0;
        public int OqJ = 0;
        public String OqK = "";
        public String OqL = "";
        public String OqM = "";
        public String OqN = "";
        public int OqX = 0;
        public String OqY;
        public String OqZ;
        public int Ora;
        public String Orb;
        public String Orc;
        public String Ord;
        public String Ore;
        public String chatroomName = "";
        private String cityCode;
        public String content = "";
        private String countryCode;
        public int dKy;
        public String dkU = "";
        public String fMb = "";
        public int fuA;
        public String kcp;
        public String kfQ = "";
        public String kfR = "";
        public String kfS = "";
        private String kfV = "";
        public String nickname = "";
        private String provinceCode;
        public int scene = 0;
        public String signature;
        public String sourceNickName;
        public String sourceUserName;
        public String wZz;

        private d() {
        }

        public static d bkD(String str) {
            AppMethodBeat.i(43212);
            d dVar = new d();
            Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
            if (parseXml != null) {
                try {
                    dVar.dkU = parseXml.get(".msg.$fromusername");
                    dVar.fMb = parseXml.get(".msg.$alias");
                    dVar.nickname = parseXml.get(".msg.$fromnickname");
                    dVar.kfR = parseXml.get(".msg.$fullpy");
                    dVar.kfQ = parseXml.get(".msg.$shortpy");
                    dVar.content = parseXml.get(".msg.$content");
                    dVar.OqJ = Util.getInt(parseXml.get(".msg.$imagestatus"), 0);
                    dVar.scene = Util.getInt(parseXml.get(".msg.$scene"), 0);
                    dVar.OqK = parseXml.get(".msg.$mhash");
                    dVar.OqL = parseXml.get(".msg.$mfullhash");
                    if (parseXml.get(parseXml.get(".msg.$qqnum")) != null && parseXml.get(parseXml.get(".msg.$qqnum")).length() > 0) {
                        dVar.Bge = Util.getLong(parseXml.get(".msg.$qqnum"), 0);
                    }
                    dVar.kfS = parseXml.get(".msg.$qqnickname");
                    dVar.kfV = parseXml.get(".msg.$qqremark");
                    dVar.signature = parseXml.get(".msg.$sign");
                    if (parseXml.get(".msg.$sex") != null && parseXml.get(".msg.$sex").length() > 0) {
                        dVar.fuA = Util.getInt(parseXml.get(".msg.$sex"), 0);
                    }
                    dVar.cityCode = parseXml.get(".msg.$city");
                    dVar.provinceCode = parseXml.get(".msg.$province");
                    dVar.countryCode = parseXml.get(".msg.$country");
                    if (parseXml.get(".msg.$snsflag") != null) {
                        dVar.OqX = Util.getInt(parseXml.get(".msg.$snsflag"), 0);
                        dVar.OqY = parseXml.get(".msg.$snsbgimgid");
                    }
                    dVar.wZz = parseXml.get(".msg.$ticket");
                    Log.d("MicroMsg.MsgInfo", "dkverify ticket:%s", dVar.wZz);
                    dVar.OqM = Util.nullAsNil(parseXml.get(".msg.$bigheadimgurl"));
                    dVar.OqN = Util.nullAsNil(parseXml.get(".msg.$smallheadimgurl"));
                    dVar.dKy = Util.getInt(parseXml.get(".msg.$opcode"), 0);
                    dVar.OqZ = Util.nullAsNil(parseXml.get(".msg.$encryptusername"));
                    dVar.kcp = Util.nullAsNil(parseXml.get(".msg.$googlecontact"));
                    Log.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", dVar.dkU, dVar.OqM, dVar.OqN);
                    dVar.chatroomName = Util.nullAsNil(parseXml.get(".msg.$chatroomusername"));
                    dVar.sourceUserName = parseXml.get(".msg.$sourceusername");
                    dVar.sourceNickName = parseXml.get(".msg.$sourcenickname");
                    dVar.Ord = parseXml.get(".msg.$sharecardusername");
                    dVar.Ore = parseXml.get(".msg.$sharecardnickname");
                    dVar.Ora = Util.getInt(parseXml.get(".msg.Antispam.$isSuspiciousUser"), 0);
                    if (dVar.Ora == 1) {
                        dVar.Orb = parseXml.get(".msg.Antispam.safetyWarning");
                        dVar.Orc = parseXml.get(".msg.Antispam.safetyWarningDetail");
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.MsgInfo", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(43212);
            return dVar;
        }

        public final String gEc() {
            return this.wZz;
        }

        public final String ajx() {
            return this.fMb;
        }

        public final String gDY() {
            return this.dkU;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final String getDisplayName() {
            AppMethodBeat.i(43213);
            if (this.nickname == null || this.nickname.length() <= 0) {
                Log.f("MicroMsg.MsgInfo", "username is nullOrNil");
                String str = this.dkU;
                AppMethodBeat.o(43213);
                return str;
            }
            String str2 = this.nickname;
            AppMethodBeat.o(43213);
            return str2;
        }

        public final String ajA() {
            return this.kfR;
        }

        public final String ajz() {
            return this.kfQ;
        }

        public final int getScene() {
            return this.scene;
        }

        public final int ajE() {
            return this.fuA;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final String getCity() {
            AppMethodBeat.i(43214);
            if (Util.isNullOrNil(this.countryCode) || Util.isNullOrNil(this.provinceCode)) {
                String str = this.cityCode;
                AppMethodBeat.o(43214);
                return str;
            } else if (Util.isNullOrNil(this.cityCode)) {
                RegionCodeDecoder.gEm();
                String mW = RegionCodeDecoder.mW(this.countryCode, this.provinceCode);
                AppMethodBeat.o(43214);
                return mW;
            } else {
                RegionCodeDecoder.gEm();
                String bs = RegionCodeDecoder.bs(this.countryCode, this.provinceCode, this.cityCode);
                AppMethodBeat.o(43214);
                return bs;
            }
        }

        public final String getProvince() {
            AppMethodBeat.i(43215);
            if (Util.isNullOrNil(this.countryCode)) {
                String str = this.provinceCode;
                AppMethodBeat.o(43215);
                return str;
            } else if (Util.isNullOrNil(this.provinceCode) || Util.isNullOrNil(this.cityCode) || !RegionCodeDecoder.bkO(this.countryCode)) {
                RegionCodeDecoder.gEm();
                String bkP = RegionCodeDecoder.bkP(this.countryCode);
                AppMethodBeat.o(43215);
                return bkP;
            } else {
                RegionCodeDecoder.gEm();
                String mW = RegionCodeDecoder.mW(this.countryCode, this.provinceCode);
                AppMethodBeat.o(43215);
                return mW;
            }
        }

        public final String gEd() {
            return this.OqZ;
        }
    }

    public static final class a {
        public String BdC = "";
        public long Bge = 0;
        public int IOs = 0;
        public String Kpf = "";
        public int OqJ = 0;
        public String OqK = "";
        public String OqL = "";
        public String OqM = "";
        public String OqN = "";
        public String OqO = "";
        public String OqP = "";
        public String OqQ = "";
        public String OqR = "";
        public String dkU = "";
        public String fMb = "";
        public int fuA;
        private String fuJ;
        private String fuK;
        public String fuN = "";
        private String fuO = "";
        public String kcp = "";
        public String kfQ = "";
        public String kfR = "";
        public String kfS = "";
        public String kfV = "";
        public String nickname = "";
        public int scene = 0;
        public String signature;
        private String source = "";

        private a() {
        }

        public static a bkA(String str) {
            String str2;
            int indexOf;
            AppMethodBeat.i(43202);
            a aVar = new a();
            String trim = Util.nullAs(str, "").trim();
            if (!trim.startsWith("<") && (indexOf = trim.indexOf(":")) != -1) {
                trim = trim.substring(indexOf + 1);
            }
            Map<String, String> parseXml = XmlParser.parseXml(trim, "msg", null);
            if (parseXml != null) {
                try {
                    if (parseXml.get(".msg.$fromusername") == null) {
                        aVar.dkU = parseXml.get(".msg.$username");
                    } else {
                        aVar.dkU = parseXml.get(".msg.$fromusername");
                    }
                    if (parseXml.get(".msg.$fromnickname") == null) {
                        aVar.nickname = parseXml.get(".msg.$nickname");
                    } else {
                        aVar.nickname = parseXml.get(".msg.$fromnickname");
                    }
                    aVar.fMb = parseXml.get(".msg.$alias");
                    aVar.kfR = parseXml.get(".msg.$fullpy");
                    aVar.kfQ = parseXml.get(".msg.$shortpy");
                    aVar.source = parseXml.get(".msg.$source");
                    aVar.OqJ = Util.getInt(parseXml.get(".msg.$imagestatus"), 0);
                    aVar.scene = Util.getInt(parseXml.get(".msg.$scene"), 0);
                    aVar.OqK = parseXml.get(".msg.$mobileidentify");
                    aVar.OqL = parseXml.get(".msg.$mobilelongidentify");
                    if (parseXml.get(".msg.$qqnum") != null && parseXml.get(".msg.$qqnum").length() > 0) {
                        aVar.Bge = Util.getLong(parseXml.get(".msg.$qqnum"), 0);
                    }
                    aVar.signature = parseXml.get(".msg.$sign");
                    if (parseXml.get(".msg.$sex") != null && parseXml.get(".msg.$sex").length() > 0) {
                        aVar.fuA = Util.getInt(parseXml.get(".msg.$sex"), 0);
                    }
                    aVar.fuK = parseXml.get(".msg.$city");
                    aVar.fuJ = parseXml.get(".msg.$province");
                    aVar.kfS = parseXml.get(".msg.$qqnickname");
                    aVar.kfV = parseXml.get(".msg.$qqremark");
                    if (TextUtils.isEmpty(parseXml.get(".msg.$certflag"))) {
                        str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    } else {
                        str2 = parseXml.get(".msg.$certflag");
                    }
                    aVar.IOs = Util.getInt(str2, 0);
                    aVar.fuN = Util.nullAsNil(parseXml.get(".msg.$certinfo"));
                    aVar.BdC = Util.nullAsNil(parseXml.get(".msg.$brandIconUrl"));
                    aVar.fuO = Util.nullAsNil(parseXml.get(".msg.$regionCode"));
                    aVar.OqM = Util.nullAsNil(parseXml.get(".msg.$bigheadimgurl"));
                    aVar.OqN = Util.nullAsNil(parseXml.get(".msg.$smallheadimgurl"));
                    aVar.kcp = Util.nullAsNil(parseXml.get(".msg.$googlecontact"));
                    aVar.Kpf = Util.nullAsNil(parseXml.get(".msg.$antispamticket"));
                    aVar.OqO = Util.nullAsNil(parseXml.get(".msg.$openimappid"));
                    aVar.OqP = Util.nullAsNil(parseXml.get(".msg.$openimdesc"));
                    aVar.OqQ = Util.nullAsNil(parseXml.get(".msg.$openimdescicon"));
                    aVar.OqR = Util.nullAsNil(parseXml.get(".msg.$openimcustominfo"));
                    if (as.bjp(aVar.dkU)) {
                        aVar.Kpf = Util.nullAsNil(parseXml.get(".msg.$ticket"));
                    }
                    Log.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", aVar.dkU, aVar.Kpf, aVar.OqM, aVar.OqN);
                } catch (Exception e2) {
                    Log.e("MicroMsg.MsgInfo", "exception:%s", Util.stackTraceToString(e2));
                }
            }
            AppMethodBeat.o(43202);
            return aVar;
        }

        public final String gDY() {
            return this.dkU;
        }

        public final String getDisplayName() {
            AppMethodBeat.i(43203);
            if (!TextUtils.isEmpty(this.nickname)) {
                String str = this.nickname;
                AppMethodBeat.o(43203);
                return str;
            } else if (!TextUtils.isEmpty(this.fMb)) {
                String str2 = this.fMb;
                AppMethodBeat.o(43203);
                return str2;
            } else {
                Log.f("MicroMsg.MsgInfo", "username is nullOrNil");
                String nullAsNil = Util.nullAsNil(this.dkU);
                AppMethodBeat.o(43203);
                return nullAsNil;
            }
        }

        public final String gDZ() {
            AppMethodBeat.i(43204);
            if (this.kfV != null && this.kfV.length() > 0) {
                String str = this.kfV;
                AppMethodBeat.o(43204);
                return str;
            } else if (this.kfS == null || this.kfS.length() <= 0) {
                String l = Long.toString(this.Bge);
                AppMethodBeat.o(43204);
                return l;
            } else {
                String str2 = this.kfS;
                AppMethodBeat.o(43204);
                return str2;
            }
        }

        public final String getCity() {
            AppMethodBeat.i(43205);
            if (!Util.isNullOrNil(this.fuO)) {
                String[] split = this.fuO.split("_");
                if (split.length > 0) {
                    if (split.length > 2) {
                        RegionCodeDecoder.gEm();
                        this.fuK = RegionCodeDecoder.bs(split[0], split[1], split[2]);
                    } else if (split.length == 2) {
                        RegionCodeDecoder.gEm();
                        this.fuK = RegionCodeDecoder.mW(split[0], split[1]);
                    } else {
                        this.fuK = "";
                    }
                }
            }
            String str = this.fuK;
            AppMethodBeat.o(43205);
            return str;
        }

        public final String getProvince() {
            AppMethodBeat.i(43206);
            if (!Util.isNullOrNil(this.fuO)) {
                String[] split = this.fuO.split("_");
                if (split.length > 0) {
                    if (split.length <= 2 || !RegionCodeDecoder.bkO(split[0])) {
                        RegionCodeDecoder.gEm();
                        this.fuJ = RegionCodeDecoder.bkP(split[0]);
                    } else {
                        RegionCodeDecoder.gEm();
                        this.fuJ = RegionCodeDecoder.mW(split[0], split[1]);
                    }
                }
            }
            String str = this.fuJ;
            AppMethodBeat.o(43206);
            return str;
        }
    }

    public static final class b {
        public String JTr = "";
        public String OqS = "";
        public String OqT = null;
        public String OqU = null;
        public String OqV = null;
        public int dRt = 0;
        public String dkU = "";
        public String kHV = "";
        public String label = "";
        public String yFB = "";
        public double yFu = 0.0d;
        public double yFv = 0.0d;

        public final String toString() {
            AppMethodBeat.i(43207);
            String format = String.format("%d-%d-%d", Integer.valueOf((int) (this.yFu * 1000000.0d)), Integer.valueOf((int) (this.yFv * 1000000.0d)), Integer.valueOf(this.dRt));
            AppMethodBeat.o(43207);
            return format;
        }

        public static b bkB(String str) {
            AppMethodBeat.i(43208);
            b bVar = new b();
            Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
            if (parseXml != null) {
                bVar.dkU = Util.nullAs(parseXml.get(".msg.location.$fromusername"), "");
                bVar.yFu = Util.safeParseDouble(parseXml.get(".msg.location.$x"));
                bVar.yFv = Util.safeParseDouble(parseXml.get(".msg.location.$y"));
                bVar.label = Util.nullAs(parseXml.get(".msg.location.$label"), "");
                bVar.OqS = Util.nullAs(parseXml.get(".msg.location.$maptype"), "");
                bVar.dRt = Util.safeParseInt(parseXml.get(".msg.location.$scale"));
                bVar.OqV = Util.nullAs(parseXml.get(".msg.location.$localLocationen"), "");
                bVar.OqT = Util.nullAs(parseXml.get(".msg.location.$localLocationcn"), "");
                bVar.OqU = Util.nullAs(parseXml.get(".msg.location.$localLocationtw"), "");
                bVar.kHV = Util.nullAs(parseXml.get(".msg.location.$poiname"), "");
                bVar.JTr = Util.nullAs(parseXml.get(".msg.location.$infourl"), "");
                bVar.yFB = Util.nullAs(parseXml.get(".msg.location.$poiid"), "");
            }
            AppMethodBeat.o(43208);
            return bVar;
        }

        public final boolean gEa() {
            AppMethodBeat.i(43209);
            if (this.kHV == null || this.kHV.equals("") || this.kHV.equals("[位置]")) {
                AppMethodBeat.o(43209);
                return false;
            }
            AppMethodBeat.o(43209);
            return true;
        }

        public final boolean gEb() {
            AppMethodBeat.i(43210);
            if (Math.abs(this.yFv) > 180.0d || Math.abs(this.yFu) > 90.0d) {
                AppMethodBeat.o(43210);
                return false;
            }
            AppMethodBeat.o(43210);
            return true;
        }
    }

    public static ca aZ(ca caVar) {
        AppMethodBeat.i(43247);
        if (caVar == null) {
            Log.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
            AppMethodBeat.o(43247);
            return null;
        }
        ca caVar2 = new ca();
        caVar2.setMsgId(caVar.field_msgId);
        caVar2.yF(caVar.field_msgSvrId);
        caVar2.setType(super.getType());
        caVar2.setStatus(caVar.field_status);
        caVar2.nv(caVar.field_isSend);
        caVar2.field_isShowTimer = caVar.field_isShowTimer;
        caVar2.fqN = true;
        caVar2.setCreateTime(caVar.field_createTime);
        caVar2.Cy(caVar.field_talker);
        caVar2.setContent(caVar.field_content);
        caVar2.Cz(caVar.field_imgPath);
        caVar2.CA(caVar.field_reserved);
        caVar2.aa(caVar.field_lvbuffer);
        caVar2.CB(caVar.field_transContent);
        caVar2.CG(caVar.fQR);
        caVar2.nc(caVar.fqJ);
        caVar2.BB(caVar.fqK);
        AppMethodBeat.o(43247);
        return caVar2;
    }

    @Override // com.tencent.mm.g.c.eo
    public final void setStatus(int i2) {
        AppMethodBeat.i(43248);
        super.setStatus(i2);
        if (this.field_isSend != 1 || !gDA()) {
            if (this.field_isSend == 0) {
                qs qsVar = new qs();
                qsVar.dXi.dCM = this;
                EventCenter.instance.publish(qsVar);
            }
        } else if (this.field_status == 5) {
            Log.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()), this.field_talker, Util.getStack());
            tx txVar = new tx();
            txVar.ear.dCM = this;
            EventCenter.instance.publish(txVar);
            AppMethodBeat.o(43248);
            return;
        } else if (this.field_status == 2) {
            Log.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()));
            tz tzVar = new tz();
            tzVar.eat.dCM = this;
            EventCenter.instance.publish(tzVar);
            AppMethodBeat.o(43248);
            return;
        }
        AppMethodBeat.o(43248);
    }

    private boolean gDA() {
        AppMethodBeat.i(43249);
        if (isText() || dOS() || gDl()) {
            AppMethodBeat.o(43249);
            return false;
        }
        AppMethodBeat.o(43249);
        return true;
    }

    public final void unsetOmittedFailResend() {
        AppMethodBeat.i(43252);
        if (isOmittedFailResend()) {
            nc(this.fqJ & -33);
        }
        AppMethodBeat.o(43252);
    }

    public final boolean gDI() {
        AppMethodBeat.i(43254);
        if (!gDz() || (this.fqJ & 16) <= 0) {
            AppMethodBeat.o(43254);
            return false;
        }
        AppMethodBeat.o(43254);
        return true;
    }

    public final void gDJ() {
        AppMethodBeat.i(43255);
        if (!gDz()) {
            AppMethodBeat.o(43255);
            return;
        }
        nc(this.fqJ | 16);
        AppMethodBeat.o(43255);
    }

    public final void gDK() {
        AppMethodBeat.i(43256);
        if (!gDz()) {
            AppMethodBeat.o(43256);
            return;
        }
        nc(this.fqJ & -17);
        AppMethodBeat.o(43256);
    }

    public final boolean gDL() {
        AppMethodBeat.i(43257);
        if (!gDz() || (this.fqJ & 1024) <= 0) {
            AppMethodBeat.o(43257);
            return false;
        }
        AppMethodBeat.o(43257);
        return true;
    }

    public final boolean gDO() {
        return ((this.fqJ & 128) == 0 && (this.fqJ & 768) == 0) ? false : true;
    }

    public final void akm(int i2) {
        AppMethodBeat.i(43260);
        switch (i2) {
            case 0:
            case 1:
                nc(this.fqJ | i2);
                AppMethodBeat.o(43260);
                return;
            default:
                Log.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
                AppMethodBeat.o(43260);
                return;
        }
    }

    private static boolean Xn() {
        AppMethodBeat.i(43261);
        String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("TranslateMsgOff");
        if (Util.isNullOrNil(value)) {
            AppMethodBeat.o(43261);
            return true;
        } else if (Util.safeParseInt(value) != 0) {
            Log.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
            AppMethodBeat.o(43261);
            return false;
        } else {
            AppMethodBeat.o(43261);
            return true;
        }
    }

    public static boolean cd(Map<String, String> map) {
        boolean z;
        AppMethodBeat.i(43266);
        if (map == null || !map.containsKey(".sysmsg.$type") || !map.get(".sysmsg.$type").equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            z = false;
        } else {
            z = true;
        }
        Log.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", Boolean.valueOf(z));
        AppMethodBeat.o(43266);
        return z;
    }

    public static boolean ce(Map<String, String> map) {
        boolean z;
        AppMethodBeat.i(43267);
        if (map == null || !map.containsKey(".sysmsg.$type") || !map.get(".sysmsg.$type").equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            z = false;
        } else {
            z = true;
        }
        Log.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", Boolean.valueOf(z));
        AppMethodBeat.o(43267);
        return z;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem, com.tencent.mm.g.c.eo
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(43268);
        super.convertFrom(cursor);
        String str = this.field_content;
        if (str != null && str.length() > 2097152) {
            final long j2 = this.field_msgId;
            StringBuilder sb = new StringBuilder(1024);
            sb.append("Very big message: \nmsgId = ").append(j2).append('\n').append("msgSvrId = ").append(this.field_msgSvrId).append('\n').append("type = ").append(super.getType()).append('\n').append("createTime = ").append(this.field_createTime).append('\n').append("talker = ").append(this.field_talker).append('\n').append("flag = ").append(this.field_flag).append('\n').append("content.length() = ").append(str.length()).append('\n').append("content = ").append(str.substring(0, 256));
            Log.e("MicroMsg.MsgInfo", sb.toString());
            setType(1);
            setContent("");
            final ca aZ = aZ(this);
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.storage.ca.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(43201);
                    ((l) g.af(l.class)).eiy().a(j2, aZ);
                    AppMethodBeat.o(43201);
                }
            });
        }
        Nj(this.field_msgId);
        AppMethodBeat.o(43268);
    }

    public static void Nj(long j2) {
        AppMethodBeat.i(43269);
        Assert.assertTrue("msgId not in the reasonable scope", 100000000 > j2 && -10 < j2);
        AppMethodBeat.o(43269);
    }

    public final String gDW() {
        AppMethodBeat.i(43271);
        if (!gDk()) {
            AppMethodBeat.o(43271);
            return "";
        }
        if (this.OqG == null) {
            gDX();
        }
        String str = this.OqG;
        AppMethodBeat.o(43271);
        return str;
    }

    public final com.tencent.mm.az.a gDX() {
        AppMethodBeat.i(43272);
        Log.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
        com.tencent.mm.az.a b2 = a.AbstractC0276a.b(XmlParser.parseXml(this.field_content, "sysmsg", null), this);
        if (b2 != null) {
            Log.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", b2);
            b2.ben();
            this.OqG = b2.TEXT;
        } else {
            Log.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
        }
        AppMethodBeat.o(43272);
        return b2;
    }

    @Override // com.tencent.mm.g.c.eo
    public final int getType() {
        AppMethodBeat.i(259836);
        int type = super.getType();
        AppMethodBeat.o(259836);
        return type;
    }

    public final boolean dOQ() {
        AppMethodBeat.i(43217);
        if ((super.getType() & 65535) == 49) {
            AppMethodBeat.o(43217);
            return true;
        }
        AppMethodBeat.o(43217);
        return false;
    }

    public final boolean gAt() {
        AppMethodBeat.i(43218);
        if (super.getType() == 285212721) {
            AppMethodBeat.o(43218);
            return true;
        }
        AppMethodBeat.o(43218);
        return false;
    }

    public final boolean cWK() {
        AppMethodBeat.i(43219);
        if (super.getType() == 486539313) {
            AppMethodBeat.o(43219);
            return true;
        }
        AppMethodBeat.o(43219);
        return false;
    }

    public final boolean gDd() {
        AppMethodBeat.i(43220);
        if (super.getType() != 486539313 || !this.OqE || this.OqD == null) {
            AppMethodBeat.o(43220);
            return false;
        }
        AppMethodBeat.o(43220);
        return true;
    }

    public final boolean gAy() {
        AppMethodBeat.i(43221);
        if (super.getType() == 34) {
            AppMethodBeat.o(43221);
            return true;
        }
        AppMethodBeat.o(43221);
        return false;
    }

    public final boolean gDe() {
        AppMethodBeat.i(43222);
        if (super.getType() == 436207665) {
            AppMethodBeat.o(43222);
            return true;
        }
        AppMethodBeat.o(43222);
        return false;
    }

    public final boolean gDf() {
        AppMethodBeat.i(43223);
        if (super.getType() == 469762097) {
            AppMethodBeat.o(43223);
            return true;
        }
        AppMethodBeat.o(43223);
        return false;
    }

    public final boolean gDg() {
        AppMethodBeat.i(43224);
        if (super.getType() == 301989937) {
            AppMethodBeat.o(43224);
            return true;
        }
        AppMethodBeat.o(43224);
        return false;
    }

    public final boolean gDh() {
        AppMethodBeat.i(43225);
        if (super.getType() == 50 || super.getType() == 53) {
            AppMethodBeat.o(43225);
            return true;
        }
        AppMethodBeat.o(43225);
        return false;
    }

    public final boolean gDi() {
        AppMethodBeat.i(43226);
        if (super.getType() == 52) {
            AppMethodBeat.o(43226);
            return true;
        }
        AppMethodBeat.o(43226);
        return false;
    }

    public final boolean gDj() {
        AppMethodBeat.i(43227);
        if (super.getType() == 318767153) {
            AppMethodBeat.o(43227);
            return true;
        }
        AppMethodBeat.o(43227);
        return false;
    }

    public final boolean gDk() {
        AppMethodBeat.i(43228);
        if (super.getType() == 10002) {
            AppMethodBeat.o(43228);
            return true;
        }
        AppMethodBeat.o(43228);
        return false;
    }

    public final boolean gAz() {
        AppMethodBeat.i(43229);
        switch (super.getType()) {
            case 3:
            case 13:
            case 23:
            case 33:
            case 39:
                AppMethodBeat.o(43229);
                return true;
            default:
                AppMethodBeat.o(43229);
                return false;
        }
    }

    public final boolean gDl() {
        AppMethodBeat.i(43230);
        if (super.getType() == 42 || super.getType() == 66) {
            AppMethodBeat.o(43230);
            return true;
        }
        AppMethodBeat.o(43230);
        return false;
    }

    public final boolean dOS() {
        AppMethodBeat.i(43231);
        if (super.getType() == 48) {
            AppMethodBeat.o(43231);
            return true;
        }
        AppMethodBeat.o(43231);
        return false;
    }

    public final boolean isText() {
        AppMethodBeat.i(43232);
        switch (super.getType()) {
            case 1:
            case 11:
            case 21:
            case 31:
            case 36:
                AppMethodBeat.o(43232);
                return true;
            default:
                AppMethodBeat.o(43232);
                return false;
        }
    }

    @Deprecated
    public final boolean isSystem() {
        AppMethodBeat.i(43233);
        if (super.getType() == 10000) {
            AppMethodBeat.o(43233);
            return true;
        }
        AppMethodBeat.o(43233);
        return false;
    }

    public final boolean gDm() {
        AppMethodBeat.i(225991);
        if (super.getType() == 10000 || super.getType() == 10002 || super.getType() == 570425393 || super.getType() == 64 || super.getType() == 603979825 || super.getType() == 889192497 || super.getType() == 922746929) {
            AppMethodBeat.o(225991);
            return true;
        }
        AppMethodBeat.o(225991);
        return false;
    }

    public final boolean cWJ() {
        AppMethodBeat.i(43234);
        if (super.getType() == 43) {
            AppMethodBeat.o(43234);
            return true;
        }
        AppMethodBeat.o(43234);
        return false;
    }

    public final boolean cWL() {
        AppMethodBeat.i(43235);
        if (super.getType() == 62) {
            AppMethodBeat.o(43235);
            return true;
        }
        AppMethodBeat.o(43235);
        return false;
    }

    public final boolean gDn() {
        AppMethodBeat.i(43236);
        if (super.getType() == 47) {
            AppMethodBeat.o(43236);
            return true;
        }
        AppMethodBeat.o(43236);
        return false;
    }

    public final boolean gDo() {
        AppMethodBeat.i(43237);
        if (super.getType() == 1048625) {
            AppMethodBeat.o(43237);
            return true;
        }
        AppMethodBeat.o(43237);
        return false;
    }

    public final boolean gDp() {
        AppMethodBeat.i(225992);
        if (super.getType() == 855638065) {
            AppMethodBeat.o(225992);
            return true;
        }
        AppMethodBeat.o(225992);
        return false;
    }

    public final boolean gDq() {
        AppMethodBeat.i(43238);
        if (super.getType() == 16777265) {
            AppMethodBeat.o(43238);
            return true;
        }
        AppMethodBeat.o(43238);
        return false;
    }

    public final boolean gDr() {
        AppMethodBeat.i(43239);
        if (super.getType() == 268435505) {
            AppMethodBeat.o(43239);
            return true;
        }
        AppMethodBeat.o(43239);
        return false;
    }

    public final boolean gDs() {
        AppMethodBeat.i(43240);
        if (super.getType() == -1879048191) {
            AppMethodBeat.o(43240);
            return true;
        }
        AppMethodBeat.o(43240);
        return false;
    }

    public final boolean gDt() {
        AppMethodBeat.i(43241);
        if (super.getType() == -1879048190) {
            AppMethodBeat.o(43241);
            return true;
        }
        AppMethodBeat.o(43241);
        return false;
    }

    public final boolean gDu() {
        AppMethodBeat.i(43242);
        if (super.getType() == -1879048189) {
            AppMethodBeat.o(43242);
            return true;
        }
        AppMethodBeat.o(43242);
        return false;
    }

    public final boolean gDv() {
        AppMethodBeat.i(43243);
        switch (super.getType()) {
            case 55:
            case n.CTRL_INDEX:
                AppMethodBeat.o(43243);
                return true;
            case 56:
            default:
                AppMethodBeat.o(43243);
                return false;
        }
    }

    public final boolean gDw() {
        AppMethodBeat.i(225993);
        if (super.getType() == 889192497 || super.getType() == 922746929) {
            AppMethodBeat.o(225993);
            return true;
        }
        AppMethodBeat.o(225993);
        return false;
    }

    public final boolean gDx() {
        AppMethodBeat.i(43244);
        if (super.getType() == 805306417) {
            AppMethodBeat.o(43244);
            return true;
        }
        AppMethodBeat.o(43244);
        return false;
    }

    public final boolean gDy() {
        AppMethodBeat.i(43245);
        if (super.getType() == 822083633) {
            AppMethodBeat.o(43245);
            return true;
        }
        AppMethodBeat.o(43245);
        return false;
    }

    public final boolean gDB() {
        return (this.fQU & 1) > 0;
    }

    public final void gDC() {
        AppMethodBeat.i(43250);
        nI(this.fQU | 1);
        AppMethodBeat.o(43250);
    }

    public final boolean gDD() {
        return (this.fqJ & 512) > 0;
    }

    public final void gDE() {
        AppMethodBeat.i(43251);
        nc(this.fqJ | 512);
        AppMethodBeat.o(43251);
    }

    public final void gDF() {
        AppMethodBeat.i(178875);
        nc(this.fqJ | 2048);
        AppMethodBeat.o(178875);
    }

    public final int gDG() {
        return this.fqJ & 4;
    }

    public final boolean isOmittedFailResend() {
        return (this.fqJ & 32) > 0;
    }

    public final void gDH() {
        AppMethodBeat.i(43253);
        nc(this.fqJ | 8);
        AppMethodBeat.o(43253);
    }

    public final void gDM() {
        AppMethodBeat.i(43258);
        nc(this.fqJ | 128);
        AppMethodBeat.o(43258);
    }

    public final void gDN() {
        AppMethodBeat.i(43259);
        nc(this.fqJ & -129);
        AppMethodBeat.o(43259);
    }

    public final boolean gDP() {
        return (this.fqJ & 8192) > 0;
    }

    public final void gDQ() {
        AppMethodBeat.i(225994);
        nc(this.fqJ | 8192);
        AppMethodBeat.o(225994);
    }

    public final void gDR() {
        AppMethodBeat.i(225995);
        nc(this.fqJ & -8193);
        AppMethodBeat.o(225995);
    }

    public final boolean gDS() {
        return (this.fqJ & 4096) > 0;
    }

    public final void gDT() {
        AppMethodBeat.i(43262);
        nc(this.fqJ & -65);
        AppMethodBeat.o(43262);
    }

    public final void gDU() {
        AppMethodBeat.i(43263);
        nc(this.fqJ | 64);
        AppMethodBeat.o(43263);
    }

    public final boolean bkz(String str) {
        AppMethodBeat.i(43264);
        if (!Util.isNullOrNil(this.fqK) && !Util.isNullOrNil(str)) {
            Map<String, String> parseXml = XmlParser.parseXml(this.fqK, "msgsource", null);
            if (parseXml == null) {
                AppMethodBeat.o(43264);
                return false;
            }
            String str2 = parseXml.get(".msgsource.atuserlist");
            if (!Util.isNullOrNil(str2)) {
                String[] split = str2.split(",");
                for (String str3 : split) {
                    if (str3.trim().equals(str)) {
                        AppMethodBeat.o(43264);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(43264);
        return false;
    }

    public final boolean gDV() {
        boolean z;
        AppMethodBeat.i(43265);
        if (Util.isNullOrNil(this.fqK) || (!this.fqK.contains("announcement@all") && !this.fqK.contains("notify@all"))) {
            z = false;
        } else {
            z = true;
        }
        Log.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", Boolean.valueOf(z));
        AppMethodBeat.o(43265);
        return z;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem, com.tencent.mm.g.c.eo
    public final ContentValues convertTo() {
        AppMethodBeat.i(43270);
        Nj(this.field_msgId);
        ContentValues convertTo = super.convertTo();
        AppMethodBeat.o(43270);
        return convertTo;
    }
}
