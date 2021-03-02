package com.tencent.mm.plugin.sns.storage;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Keep
public class ADInfo {
    public static int ADChainStrengthenDefaultWording = 0;
    public static int ADChainStrengthenUserInfoFormatWording = 1;
    public static final int AD_ACTION_TYPE_FINDER = 9;
    public static final int AD_ACTION_TYPE_FINDER_LIVE = 10;
    public static final int AD_ACTION_TYPE_FINDER_TOPIC = 11;
    public static final int AD_ACTION_TYPE_SCAN = 8;
    public static final int AD_ACTION_TYPE_WEAPP = 4;
    public static final String TAG = "MicroMsg.ADInfo";
    private static HashMap<String, String> waidPkgCache = new HashMap<>();
    public a actionExtAppJump;
    public b actionExtWeApp;
    public String adActionCardExt;
    public String adActionCardTitle;
    public String adActionCardTpId;
    public String adActionExtTailFormattedWording;
    public String adActionExtTailLink;
    public int adActionExtTailType;
    public String adActionExtTailUserDisplayName;
    public String adActionExtTailWording;
    public LinkedList<String> adActionExtUserList;
    public String adActionLink;
    public String adActionPOIId;
    public String adActionPOILink;
    public String adActionPOIName;
    public int adActionPOIType;
    public int adActionType;
    public String adCanvasExtXml;
    public int adChainType;
    public int adChainTypeExpireTime;
    public String adDislikeInfoTitle_cn;
    public String adDislikeInfoTitle_en;
    public String adDislikeInfoTitle_tw;
    public int adDupSnsIdDel;
    public String adInfoSyncBuffer;
    public boolean adInfoSyncBufferImm;
    public c adUnlikeInfo;
    public d adVoteInfoExt;
    public int ad_sns_pos;
    public String aid;
    boolean bLandingPagesAd;
    public int contractAdEndTime;
    public long exposureNoActionExpireTime;
    public boolean forbidClick;
    public HashMap<String, String> mappedCanvasCardExt;
    public long noExposureExpireTime;
    public String traceid;
    public String uxInfo;
    public String viewId;
    public String waidPkg;
    public String xml;

    public static class b {
        public String appUserName;
        public String appVersion;
        public String dCx;
        public int weAppType;
    }

    static {
        AppMethodBeat.i(202813);
        AppMethodBeat.o(202813);
    }

    public boolean isWeapp() {
        return this.adActionType == 4 && this.actionExtWeApp != null;
    }

    public static class a {
        public String LG;
        public String appId;
        public String appName;
        public String appPageUrl;

        public final String toString() {
            AppMethodBeat.i(202810);
            String str = "appId=" + this.appId + ", pkg=" + this.LG + ", appName=" + this.appName + ", pageUrl=" + this.appPageUrl;
            AppMethodBeat.o(202810);
            return str;
        }
    }

    public ADInfo() {
        AppMethodBeat.i(96259);
        this.xml = "";
        this.uxInfo = "";
        this.adActionType = 0;
        this.adActionCardTitle = "";
        this.adActionCardTpId = "";
        this.adActionCardExt = "";
        this.adActionLink = "";
        this.adActionPOIType = 0;
        this.adActionPOIId = "";
        this.adActionPOIName = "";
        this.adActionPOILink = "";
        this.adActionExtTailType = ADChainStrengthenDefaultWording;
        this.adActionExtTailWording = "";
        this.adActionExtTailLink = "";
        this.adActionExtUserList = new LinkedList<>();
        this.adCanvasExtXml = "";
        this.adUnlikeInfo = new c();
        this.adDislikeInfoTitle_cn = "";
        this.adDislikeInfoTitle_en = "";
        this.adDislikeInfoTitle_tw = "";
        this.forbidClick = false;
        this.adInfoSyncBuffer = "";
        this.adInfoSyncBufferImm = false;
        AppMethodBeat.o(96259);
    }

    public ADInfo(String str) {
        AppMethodBeat.i(96260);
        this.xml = "";
        this.uxInfo = "";
        this.adActionType = 0;
        this.adActionCardTitle = "";
        this.adActionCardTpId = "";
        this.adActionCardExt = "";
        this.adActionLink = "";
        this.adActionPOIType = 0;
        this.adActionPOIId = "";
        this.adActionPOIName = "";
        this.adActionPOILink = "";
        this.adActionExtTailType = ADChainStrengthenDefaultWording;
        this.adActionExtTailWording = "";
        this.adActionExtTailLink = "";
        this.adActionExtUserList = new LinkedList<>();
        this.adCanvasExtXml = "";
        this.adUnlikeInfo = new c();
        this.adDislikeInfoTitle_cn = "";
        this.adDislikeInfoTitle_en = "";
        this.adDislikeInfoTitle_tw = "";
        this.forbidClick = false;
        this.adInfoSyncBuffer = "";
        this.adInfoSyncBufferImm = false;
        this.bLandingPagesAd = false;
        feed(str);
        AppMethodBeat.o(96260);
    }

    private void feed(String str) {
        String str2;
        String nullAs;
        boolean z = true;
        AppMethodBeat.i(96261);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(96261);
            return;
        }
        Log.i(TAG, "feed xml %s", str);
        Map<String, String> parseXml = XmlParser.parseXml(str, "ADInfo", null);
        if (parseXml == null) {
            AppMethodBeat.o(96261);
            return;
        }
        this.viewId = Util.nullAs(parseXml.get(".ADInfo.viewid"), "");
        if (parseXml.get(".ADInfo.ad_sns_pos") == null) {
            AppMethodBeat.o(96261);
            return;
        }
        this.ad_sns_pos = Util.safeParseInt(parseXml.get(".ADInfo.ad_sns_pos"));
        this.noExposureExpireTime = Util.safeParseLong(parseXml.get(".ADInfo.noExposureExpireTime"));
        this.exposureNoActionExpireTime = Util.safeParseLong(parseXml.get(".ADInfo.exposureNoActionExpireTime"));
        this.uxInfo = Util.nullAs(parseXml.get(".ADInfo.uxInfo"), "");
        this.adActionType = Util.safeParseInt(parseXml.get(".ADInfo.adActionType"));
        this.adActionCardTitle = Util.nullAs(parseXml.get(".ADInfo.adActionCardTitle"), "");
        this.adActionCardTpId = Util.nullAs(parseXml.get(".ADInfo.adActionCardTpId"), "");
        this.adActionCardExt = Util.nullAs(parseXml.get(".ADInfo.adActionCardExt"), "");
        this.adActionLink = Util.nullAs(parseXml.get(".ADInfo.adActionLink"), "");
        this.adActionPOIType = Util.safeParseInt(parseXml.get(".ADInfo.adActionExt.adActionExtPOI.POIType"));
        this.adActionPOIId = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adActionExtPOI.POIId"), "");
        this.adActionPOIName = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adActionExtPOI.POIName"), "");
        this.adActionPOILink = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adActionExtPOI.POILink"), "");
        this.adChainType = Util.safeParseInt(parseXml.get(".ADInfo.adActionExt.adChainType"));
        this.adChainTypeExpireTime = Util.safeParseInt(parseXml.get(".ADInfo.adActionExt.adChainTypeExpireTime"));
        String nullAs2 = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adChainStrengthen.Wording"), "");
        this.adActionExtTailType = Util.safeParseInt(parseXml.get(".ADInfo.adActionExt.adChainStrengthen.WordingType"));
        this.adActionExtTailLink = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adChainStrengthen.WordingLink"), "");
        if (this.adActionExtTailType == ADChainStrengthenUserInfoFormatWording) {
            String nullAs3 = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adChainStrengthen.WordingRepAndroid"), "");
            this.adActionExtUserList.clear();
            int i2 = 0;
            while (true) {
                if (i2 == 0) {
                    nullAs = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName"), "");
                } else {
                    nullAs = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adChainStrengthen.UserNameList.UserName" + i2), "");
                }
                if (Util.isNullOrNil(nullAs)) {
                    break;
                }
                this.adActionExtUserList.add(nullAs);
                i2++;
            }
            boolean z2 = nullAs3.indexOf("%s") >= 0;
            int indexOf = nullAs3.indexOf("%");
            int lastIndexOf = nullAs3.lastIndexOf("%");
            if (Util.isNullOrNil(nullAs3) || !z2 || indexOf != lastIndexOf) {
                this.adActionExtTailWording = nullAs2;
                this.adActionExtTailType = ADChainStrengthenDefaultWording;
            } else {
                this.adActionExtTailWording = nullAs3;
            }
        } else {
            this.adActionExtTailWording = nullAs2;
            this.adActionExtTailType = ADChainStrengthenDefaultWording;
        }
        this.bLandingPagesAd = parseXml.containsKey(".ADInfo.adCanvasInfo");
        this.aid = parseXml.get(".ADInfo.session_data.aid");
        this.traceid = parseXml.get(".ADInfo.session_data.trace_id");
        this.mappedCanvasCardExt = new HashMap<>();
        int i3 = 0;
        while (true) {
            if (i3 == 0) {
                str2 = ".ADInfo.adCanvasExt.adCardItemList.cardItem";
            } else {
                str2 = ".ADInfo.adCanvasExt.adCardItemList.cardItem" + i3;
            }
            String str3 = parseXml.get(str2 + ".cardTpId");
            String str4 = parseXml.get(str2 + ".cardExt");
            if (Util.isNullOrNil(str3)) {
                break;
            }
            this.mappedCanvasCardExt.put(str3, str4);
            i3++;
        }
        Matcher matcher = Pattern.compile("<adCanvasExt>[\\s\\S]*</adCanvasExt>").matcher(str);
        if (matcher.find()) {
            String group = matcher.group();
            if (!Util.isNullOrNil(group)) {
                this.adCanvasExtXml = group.replaceAll("</?adCanvasExt>", "");
            }
        }
        String str5 = parseXml.get(".ADInfo.adActionExt.adActionExtWeApp.appUserName");
        if (!TextUtils.isEmpty(str5)) {
            this.actionExtWeApp = new b();
            this.actionExtWeApp.appUserName = str5;
            this.actionExtWeApp.appVersion = parseXml.get(".ADInfo.adActionExt.adActionExtWeApp.appVersion");
            this.actionExtWeApp.dCx = parseXml.get(".ADInfo.adActionExt.adActionExtWeApp.relativePagePath");
            this.actionExtWeApp.weAppType = Util.safeParseInt(parseXml.get(".ADInfo.adActionExt.adActionExtWeApp.miniProgramType"));
        }
        this.adUnlikeInfo = new c(parseXml, ".ADInfo");
        this.adDislikeInfoTitle_cn = Util.nullAs(parseXml.get(".ADInfo.dislikeInfo.Title.zh"), "");
        this.adDislikeInfoTitle_tw = Util.nullAs(parseXml.get(".ADInfo.dislikeInfo.Title.tw"), "");
        this.adDislikeInfoTitle_en = Util.nullAs(parseXml.get(".ADInfo.dislikeInfo.Title.en"), "");
        this.forbidClick = Util.safeParseInt(parseXml.get(".ADInfo.dislikeInfo.forbidClick")) > 0;
        this.adInfoSyncBuffer = Util.nullAs(parseXml.get(".ADInfo.adInfoSyncBuffer"), "");
        if (Util.safeParseInt(parseXml.get(".ADInfo.adInfoSyncBuffer.$imm")) != 1) {
            z = false;
        }
        this.adInfoSyncBufferImm = z;
        this.adVoteInfoExt = new d(parseXml);
        this.waidPkg = Util.nullAsNil(parseXml.get(".ADInfo.appWaid.pkg"));
        String aOb = k.aOb(this.uxInfo);
        if (TextUtils.isEmpty(aOb)) {
            Log.w(TAG, "aid from uxinfo is empty, uxinfo=" + this.uxInfo + ", aid=" + this.aid);
            aOb = this.aid;
        }
        synchronized (waidPkgCache) {
            try {
                if (!TextUtils.isEmpty(aOb) && !TextUtils.isEmpty(this.waidPkg)) {
                    Log.i(TAG, "cache waidPkg, key=" + aOb + ", value=" + this.waidPkg);
                    waidPkgCache.put(aOb, this.waidPkg);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(96261);
                throw th;
            }
        }
        if (parseXml.containsKey(".ADInfo.adActionExt.adActionSchemaJump")) {
            String nullAs4 = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adActionSchemaJump" + ".packageName"), "");
            String nullAs5 = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adActionSchemaJump" + ".openSdkAppIdAndroid"), "");
            if (!TextUtils.isEmpty(nullAs4) && !TextUtils.isEmpty(nullAs5)) {
                this.actionExtAppJump = new a();
                this.actionExtAppJump.LG = nullAs4;
                this.actionExtAppJump.appId = nullAs5;
                this.actionExtAppJump.appPageUrl = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appPageUrlAndroid"), "");
                this.actionExtAppJump.appName = Util.nullAs(parseXml.get(".ADInfo.adActionExt.adActionSchemaJump" + ".appName"), "");
            }
        }
        this.contractAdEndTime = Util.safeParseInt(parseXml.get(".ADInfo.adGroupEndTime"));
        this.adDupSnsIdDel = Util.safeParseInt(parseXml.get(".ADInfo.adDupSnsIdDel"));
        AppMethodBeat.o(96261);
    }

    public static class c {
        public int DVT = 0;
        private List<a> DVU = new ArrayList();
        public Map<String, List<a>> DVV = new HashMap();
        public String DVW = "";
        public String DVX = "";
        public String DVY = "";

        public static class a {
            public static int DVZ = 101;
            public long DDs = 0;
            public String DWa = "";
            public String DWb = "";
            public String DWc = "";
            public int DWd = 0;
            public long DWe = 0;

            public a(String str, String str2, String str3, int i2) {
                this.DWa = str;
                this.DWb = str2;
                this.DWc = str3;
                this.DWd = i2;
            }

            public a() {
            }
        }

        public final List<a> fcH() {
            AppMethodBeat.i(96251);
            String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            String str = (LocaleUtil.CHINA.equals(currentLanguage) || LocaleUtil.TAIWAN.equals(currentLanguage) || LocaleUtil.HONGKONG.equals(currentLanguage)) ? currentLanguage : LocaleUtil.ENGLISH;
            if (!this.DVV.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                for (a aVar : this.DVU) {
                    if (LocaleUtil.CHINA.equals(str) && !Util.isNullOrNil(aVar.DWa)) {
                        arrayList.add(aVar);
                    } else if ((LocaleUtil.TAIWAN.equals(str) || LocaleUtil.HONGKONG.equals(str)) && !Util.isNullOrNil(aVar.DWb)) {
                        arrayList.add(aVar);
                    } else if (LocaleUtil.ENGLISH.equals(str) && !Util.isNullOrNil(aVar.DWc)) {
                        arrayList.add(aVar);
                    }
                }
                this.DVV.put(str, arrayList);
            }
            List<a> list = this.DVV.get(str);
            AppMethodBeat.o(96251);
            return list;
        }

        public c() {
            AppMethodBeat.i(96252);
            AppMethodBeat.o(96252);
        }

        public c(Map<String, String> map, String str) {
            String str2;
            int i2 = 0;
            AppMethodBeat.i(96253);
            String str3 = str + ".dislikeInfo.ReasonList";
            while (true) {
                String str4 = str3 + ".Reason";
                if (i2 > 0) {
                    str2 = str4 + i2;
                } else {
                    str2 = str4;
                }
                if (map.get(str2 + ".ReasonId") != null) {
                    this.DVU.add(new a(Util.nullAs(map.get(str2 + ".Wording.zh"), ""), Util.nullAs(map.get(str2 + ".Wording.tw"), ""), Util.nullAs(map.get(str2 + ".Wording.en"), ""), Util.safeParseInt(map.get(str2 + ".ReasonId"))));
                    i2++;
                } else {
                    this.DVT = Util.safeParseInt(map.get(str + ".dislikeInfo.unReceiveAdInterval"));
                    this.DVW = Util.nullAs(map.get(str + ".dislikeInfo.forbidClickReason.zh"), "");
                    this.DVX = Util.nullAs(map.get(str + ".dislikeInfo.forbidClickReason.tw"), "");
                    this.DVY = Util.nullAs(map.get(str + ".dislikeInfo.forbidClickReason.en"), "");
                    AppMethodBeat.o(96253);
                    return;
                }
            }
        }

        public final boolean fcI() {
            AppMethodBeat.i(202811);
            if (fcH().size() > 0) {
                AppMethodBeat.o(202811);
                return true;
            }
            AppMethodBeat.o(202811);
            return false;
        }
    }

    public static class e {
        public int DWg;
        public int DWh;
        public ArrayList<String> DWi = new ArrayList<>();
        public String id;

        public e() {
            AppMethodBeat.i(96258);
            AppMethodBeat.o(96258);
        }
    }

    public static class d {
        public ArrayList<e> DWf = new ArrayList<>();

        public d(Map<String, String> map) {
            String str;
            AppMethodBeat.i(96254);
            int i2 = 0;
            while (true) {
                if (i2 == 0) {
                    str = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo";
                } else {
                    str = ".ADInfo.adActionExt.adVoteInfoExt.voteItemList.voteResultInfo" + i2;
                }
                String nullAs = Util.nullAs(map.get(str + ".id"), "");
                if (!TextUtils.isEmpty(nullAs)) {
                    e eVar = new e();
                    eVar.id = nullAs;
                    eVar.DWg = Util.safeParseInt(map.get(str + ".scoring"));
                    eVar.DWh = Util.safeParseInt(map.get(str + ".friends"));
                    String str2 = str + ".friendsList.userName";
                    int i3 = 0;
                    while (true) {
                        String nullAs2 = Util.nullAs(map.get(i3 == 0 ? str2 : str2 + i3), "");
                        if (TextUtils.isEmpty(nullAs2)) {
                            break;
                        }
                        eVar.DWi.add(nullAs2);
                        i3++;
                    }
                    this.DWf.add(eVar);
                    i2++;
                } else {
                    AppMethodBeat.o(96254);
                    return;
                }
            }
        }

        public d() {
            AppMethodBeat.i(96255);
            AppMethodBeat.o(96255);
        }

        public final int kr(String str, String str2) {
            int i2 = 0;
            AppMethodBeat.i(96256);
            e aPS = aPS(str);
            e aPS2 = aPS(str2);
            int i3 = aPS == null ? 0 : aPS.DWg;
            if (aPS2 != null) {
                i2 = aPS2.DWg;
            }
            if (i3 + i2 > 0) {
                int i4 = (i3 * 100) / (i2 + i3);
                AppMethodBeat.o(96256);
                return i4;
            }
            AppMethodBeat.o(96256);
            return 50;
        }

        private e aPS(String str) {
            AppMethodBeat.i(96257);
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(96257);
                return null;
            }
            Iterator<e> it = this.DWf.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (str.equals(next.id)) {
                    AppMethodBeat.o(96257);
                    return next;
                }
            }
            AppMethodBeat.o(96257);
            return null;
        }
    }

    public static String getWaidPkgByUxInfo(String str) {
        AppMethodBeat.i(202812);
        String str2 = "";
        String aOb = k.aOb(str);
        if (!TextUtils.isEmpty(aOb)) {
            synchronized (waidPkgCache) {
                try {
                    str2 = Util.nullAsNil(waidPkgCache.get(aOb));
                } finally {
                    AppMethodBeat.o(202812);
                }
            }
        } else {
            Log.e(TAG, "getWaidPkgByUxInfo, aid is empty, uxinfo=".concat(String.valueOf(str)));
        }
        return str2;
    }
}
