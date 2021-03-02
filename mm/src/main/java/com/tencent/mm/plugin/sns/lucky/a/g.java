package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.appbrand.game.e.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.af.h;
import com.tencent.mm.plugin.sns.j.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.c;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g {
    private static int[] DFW = {50, 66, 68, 88, 99, 121, 123, 166, 168, 188, 199, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, 266, 268, 288, h.CTRL_INDEX, 369, 419, 520, e.CTRL_INDEX, 1024};
    private static String DFq = "";
    private static g DFr = null;
    public String DFA = "";
    public String DFB = "";
    public String DFC = "";
    public String DFD = "";
    public String DFE = "";
    public String DFF = "";
    public String DFG = "";
    public String DFH = "";
    public String DFI = "";
    public String DFJ = "";
    public String DFK = "";
    public String DFL = "";
    public String DFM = "";
    public String DFN = "";
    public String DFO = "";
    public String DFP = "";
    public String DFQ = "";
    public String DFR = "";
    public int DFS = -1;
    public String DFT = "";
    private List<List<Integer>> DFU = new LinkedList();
    private List<Integer> DFV = new LinkedList();
    private LinkedList<c> DFX = new LinkedList<>();
    public String DFo = "";
    public String DFs = "";
    public int DFt = 0;
    public int DFu = 0;
    public long DFv = 0;
    public long DFw = 0;
    public String DFx = "";
    public long DFy = 0;
    public long DFz = 0;
    public long jfo = 0;
    public long oUH = 0;
    private StringBuffer sb = new StringBuffer();

    public g() {
        AppMethodBeat.i(95180);
        AppMethodBeat.o(95180);
    }

    public static g eZK() {
        AppMethodBeat.i(95181);
        com.tencent.mm.kernel.g.aAi();
        if (!com.tencent.mm.kernel.g.aAf().azp()) {
            g gVar = new g();
            AppMethodBeat.o(95181);
            return gVar;
        }
        c Fu = d.aXu().Fu("100068");
        String str = Fu.field_rawXML;
        if (Util.isNullOrNil(str)) {
            str = "";
        }
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(str.getBytes());
        if (DFr == null || !messageDigest.equals(DFq)) {
            Log.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
            DFr = new g();
            try {
                Map<String, String> gzz = Fu.gzz();
                String str2 = "";
                if (gzz != null) {
                    str2 = gzz.get("SnsHBConfig");
                }
                if (Util.isNullOrNil(str2)) {
                    str2 = "";
                }
                String decode = URLDecoder.decode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                g gVar2 = DFr;
                gVar2.sb = new StringBuffer();
                gVar2.DFX.clear();
                Map<String, String> parseXml = XmlParser.parseXml(decode, "sysmsg", null);
                if (parseXml == null) {
                    Log.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", decode);
                } else {
                    gVar2.jfo = Util.safeParseLong(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
                    gVar2.sb.append("BeginTime:" + gVar2.jfo + ";");
                    gVar2.oUH = Util.safeParseLong(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
                    gVar2.sb.append("EndTime:" + gVar2.oUH + ";\n");
                    gVar2.DFt = Util.safeParseInt(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
                    gVar2.DFu = Util.safeParseInt(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
                    gVar2.sb.append("SvrDownReqLimitLevelMin:" + gVar2.DFt + " SvrDownReqLimitLevelMax: " + gVar2.DFu + ";\n");
                    gVar2.DFy = Util.safeParseLong(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
                    gVar2.DFz = Util.safeParseLong(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
                    gVar2.DFA = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
                    gVar2.DFB = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
                    gVar2.DFC = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
                    gVar2.DFD = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
                    gVar2.DFE = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
                    gVar2.DFF = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
                    gVar2.DFH = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
                    gVar2.DFI = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
                    gVar2.DFG = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
                    gVar2.DFJ = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
                    gVar2.DFK = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
                    gVar2.DFR = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
                    gVar2.DFS = Util.safeParseInt(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
                    gVar2.DFT = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
                    if (gVar2.DFS <= 0) {
                        Log.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + gVar2.DFS);
                        gVar2.DFS = 1;
                    }
                    gVar2.sb.append("FullScreenID:" + gVar2.DFT + " BrowseBeginTime:" + gVar2.DFy + " BrowseEndTime:" + gVar2.DFz + " FullScreenTitle:" + gVar2.DFA + " FullScreenDescription:" + gVar2.DFB + " FullScreenQueryTips:" + gVar2.DFC + " FullScreenAcceptButtonText: " + gVar2.DFD);
                    gVar2.sb.append("FullScreenRejectButtonText:" + gVar2.DFE + " ActionSheetOpenTips:" + gVar2.DFF + " ActionSheetOpenSuccTips:" + gVar2.DFH + " ActionSheetOpenFailTips:" + gVar2.DFI + " ActionSheetCloseTips:" + gVar2.DFG + " ActionSheetCloseSuccTips: " + gVar2.DFJ + " ActionSheetCloseFailTips: " + gVar2.DFK + "MaxPostFeedID: " + gVar2.DFR + " MaxPostFeedCount:" + gVar2.DFS);
                    gVar2.DFL = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
                    gVar2.DFM = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
                    gVar2.DFN = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
                    gVar2.DFO = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
                    gVar2.DFP = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
                    gVar2.DFQ = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
                    gVar2.sb.append("AlertTipForHasUsed:" + gVar2.DFL + " AlertTipForObtainUsedRight:" + gVar2.DFM + " AlertTipForClosedBrowseSwitch:" + gVar2.DFN + " AlertButtonText:" + gVar2.DFO + " GoldenCameraTip:" + gVar2.DFP + " GoldenCameraTipID:" + gVar2.DFQ);
                    int i2 = 0;
                    while (true) {
                        Object[] objArr = new Object[2];
                        objArr[0] = i2 == 0 ? "" : String.valueOf(i2);
                        objArr[1] = "RedPointID";
                        gVar2.DFo = Util.nullAs(parseXml.get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", objArr)), "");
                        gVar2.sb.append("RedPointID:" + gVar2.DFo + ";");
                        if (Util.isNullOrNil(gVar2.DFo)) {
                            break;
                        }
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = i2 == 0 ? "" : String.valueOf(i2);
                        objArr2[1] = "BeginTime";
                        gVar2.DFv = Util.safeParseLong(parseXml.get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", objArr2)));
                        gVar2.sb.append("RedPointID_BeginTime:" + gVar2.DFv + ";");
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = i2 == 0 ? "" : String.valueOf(i2);
                        objArr3[1] = "EndTime";
                        gVar2.DFw = Util.safeParseLong(parseXml.get(String.format(".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s", objArr3)));
                        gVar2.sb.append("RedPointID_EndTime:" + gVar2.DFw + ";\n");
                        c cVar = new c();
                        cVar.DFo = gVar2.DFo;
                        cVar.jfo = gVar2.DFv;
                        cVar.oUH = gVar2.DFw;
                        gVar2.DFX.add(cVar);
                        i2++;
                    }
                    gVar2.DFx = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
                    gVar2.sb.append("PostTips:" + gVar2.DFx + ";");
                    gVar2.DFs = Util.nullAs(parseXml.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
                    gVar2.sb.append("EntranceTips:" + gVar2.DFs + ";");
                    gVar2.DFU.clear();
                    int i3 = 0;
                    while (true) {
                        int safeParseInt = Util.safeParseInt(parseXml.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i3 + ".Count"));
                        gVar2.sb.append("count: " + i3 + APLogFileUtil.SEPARATOR_LOG + safeParseInt + ";\n");
                        if (safeParseInt == 0) {
                            break;
                        }
                        LinkedList linkedList = new LinkedList();
                        int i4 = 0;
                        while (i4 < safeParseInt) {
                            int safeParseInt2 = Util.safeParseInt(parseXml.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i3 + ".Amount" + (i4 == 0 ? "" : Integer.valueOf(i4))));
                            linkedList.add(Integer.valueOf(safeParseInt2));
                            gVar2.sb.append("AmountLevel : " + i3 + " index " + i4 + " val: " + safeParseInt2 + ";");
                            i4++;
                        }
                        gVar2.DFU.add(linkedList);
                        i3++;
                    }
                    Log.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + gVar2.sb.toString());
                }
                DFq = messageDigest;
            } catch (Exception e2) {
                Log.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + e2.getMessage());
            }
        }
        g gVar3 = DFr;
        AppMethodBeat.o(95181);
        return gVar3;
    }

    public static boolean eZL() {
        AppMethodBeat.i(95182);
        com.tencent.mm.kernel.g.aAi();
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
        AppMethodBeat.o(95182);
        return booleanValue;
    }

    public final void eZM() {
        AppMethodBeat.i(95183);
        i h2 = k.h(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKPOST_STRING_SYNC);
        if (h2.DRX == null || Util.isNullOrNil(h2.DRX.postId)) {
            h2.DRX = new com.tencent.mm.plugin.sns.j.g();
            h2.DRX.postId = this.DFR;
            h2.DRX.DRV = 0;
        }
        if (Util.isNullOrNil(h2.DRX.postId) || !h2.DRX.postId.equals(this.DFR)) {
            h2.DRX = new com.tencent.mm.plugin.sns.j.g();
            h2.DRX.postId = this.DFR;
            h2.DRX.DRV = 0;
        } else {
            com.tencent.mm.plugin.sns.j.g gVar = h2.DRX;
            gVar.DRV--;
            if (h2.DRX.DRV < 0) {
                h2.DRX.DRV = 0;
            }
        }
        Log.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + h2.DRX.DRV + " postId: " + this.DFR + " " + Util.getStack().toString());
        try {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKPOST_STRING_SYNC, new String(h2.toByteArray(), Charset.forName(KindaConfigCacheStg.SAVE_CHARSET)));
        } catch (IOException e2) {
            Log.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + e2.getLocalizedMessage());
        }
        EventCenter.instance.publish(new vg());
        AppMethodBeat.o(95183);
    }
}
