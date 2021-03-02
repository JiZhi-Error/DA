package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.k.ac;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import java.util.Iterator;
import java.util.Map;

public final class o extends q implements m {
    public static String jjB;
    public static String jjC;
    public static String jjD;
    public static String jjE;
    public static String jjF;
    public static String jjG;
    public static String jjH;
    public static String jjI;
    public static String jjJ;
    public static String jjK;
    public static String jjL;
    private static int jjM;
    private static int jjN = -1;
    private static int jjO = 22;
    private static int jjP = 0;
    private static boolean jjQ = false;
    private static int jjR = 0;
    private static int jjS = 0;
    private i callback;

    public static boolean tK(int i2) {
        if (jjM == i2) {
            return false;
        }
        return true;
    }

    public static int bfc() {
        return jjN;
    }

    public static int beM() {
        return jjS;
    }

    public static boolean bfd() {
        return (jjP & 2) != 0;
    }

    public static boolean bfe() {
        return (jjO & 4) != 0;
    }

    public static void fK(boolean z) {
        if (z) {
            jjO |= 4;
        } else {
            jjO &= -5;
        }
    }

    public static int bff() {
        return jjM;
    }

    public static int getDeviceType() {
        return jjR;
    }

    public static boolean bfg() {
        return (jjP & 512) != 0;
    }

    public static boolean bfh() {
        return (jjP & 1024) != 0;
    }

    public static boolean bfi() {
        return (jjP & 32) != 0;
    }

    public o(int i2) {
        jjM = i2;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return ac.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20633);
        d.a aVar = new d.a();
        brg brg = new brg();
        brg.rBI = LocaleUtil.getApplicationLanguage();
        Log.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", brg.rBI);
        aVar.iLN = brg;
        aVar.iLO = new brh();
        aVar.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
        aVar.funcId = ac.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.callback = iVar;
        int dispatch = dispatch(gVar, aVar.aXF(), this);
        AppMethodBeat.o(20633);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int i5;
        AppMethodBeat.i(20634);
        Log.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            brh brh = (brh) ((d) sVar).iLL.iLR;
            jjN = brh.LYM;
            Log.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", Integer.valueOf(jjN), Integer.valueOf(brh.KHa));
            Map<String, String> parseXml = XmlParser.parseXml(brh.LYL, "summary", null);
            int i6 = jjO;
            if (parseXml != null) {
                jjB = parseXml.get(".summary.banner");
                jjC = Util.nullAsNil(parseXml.get(".summary.device_name"));
                Log.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", Integer.valueOf(brh.LYJ), brh.LYL);
                brg brg = (brg) ((d) sVar).iLK.iLR;
                Iterator<cva> it = brh.LYK.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i5 = i6;
                        break;
                    }
                    cva next = it.next();
                    if (next.KOi.yO().hashCode() != brg.BaseRequest.KOi.yO().hashCode()) {
                        jjR = next.MAt;
                        Log.i("MicroMsg.NetSceneGetOnlineInfo", "device type %d", Integer.valueOf(jjR));
                        Map<String, String> parseXml2 = XmlParser.parseXml(next.MAu, "wording", null);
                        Log.d("MicroMsg.NetSceneGetOnlineInfo", next.MAu);
                        if (parseXml2 != null) {
                            jjD = parseXml2.get(".wording.title");
                            jjE = parseXml2.get(".wording.notify");
                            jjF = parseXml2.get(".wording.mute_title");
                            jjG = parseXml2.get(".wording.mute_tips");
                            jjK = parseXml2.get(".wording.exit_confirm");
                            jjH = parseXml2.get(".wording.lock_title");
                            jjI = parseXml2.get(".wording.mute_lock_title");
                            jjJ = parseXml2.get(".wording.exit");
                            jjL = parseXml2.get(".wording.usage_link");
                        }
                        i5 = next.MAw;
                        jjS = next.KOj;
                    }
                }
                int i7 = brh.KHa;
                jjP = i7;
                if ((i7 & 2) == 0) {
                    jjQ = true;
                } else {
                    jjQ = false;
                }
                if (i5 != jjO) {
                    jjO = i5;
                    bg.aVF();
                    c.azl();
                }
            }
            int i8 = brh.KHa;
            int i9 = brh.LYM;
            if ((i8 & 64) != 0 || 7 == i9 || 8 == i9) {
                bg.aVF();
                as Kn = c.aSN().Kn("filehelper");
                if (Kn == null || Util.isNullOrNil(Kn.field_username)) {
                    ak.L(Kn);
                    bg.aVF();
                    Kn = c.aSN().Kn("filehelper");
                }
                if (Kn != null && !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    Kn.aqQ();
                    bg.aVF();
                    c.aSN().c(Kn.field_username, Kn);
                }
                bg.aVF();
                az bjY = c.aST().bjY("filehelper");
                if (bjY == null) {
                    az azVar = new az("filehelper");
                    azVar.yA(Util.nowMilliSecond());
                    bg.aVF();
                    c.aST().e(azVar);
                } else {
                    bjY.yA(Util.nowMilliSecond());
                    bg.aVF();
                    c.aST().a(bjY, "filehelper");
                }
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20634);
    }
}
