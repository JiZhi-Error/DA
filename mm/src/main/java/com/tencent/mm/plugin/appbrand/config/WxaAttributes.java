package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.hz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WxaAttributes extends hz {
    public static final IAutoDBItem.MAutoDBInfo kLR;
    private a lgo;
    private c lgp;
    private WxaVersionInfo lgq;
    private List<WxaEntryInfo> lgr = null;
    private b lgs;

    public static final class b {
        public int dhT;
        public List<a> lgB;
        public int type;

        public static final class a {
            public String dCx;
            public List<a> lgC;
            public String name;
            public int type;
            public String userName;
            public int version;
        }
    }

    @Override // com.tencent.mm.g.c.hz, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(123517);
        super.convertFrom(cursor);
        this.lgo = null;
        this.lgp = null;
        this.lgq = null;
        this.lgr = null;
        this.lgs = null;
        AppMethodBeat.o(123517);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return kLR;
    }

    public final a bAn() {
        AppMethodBeat.i(123518);
        if (this.lgo == null) {
            this.lgo = a.XI(this.field_appInfo);
        }
        a aVar = this.lgo;
        AppMethodBeat.o(123518);
        return aVar;
    }

    public static final class a {
        public long czf = 0;
        public long kWb = 0;
        public String ldJ;
        public String lgA;
        public String lgt;
        private int lgu;
        public List<String> lgv;
        public List<String> lgw;
        public List<String> lgx;
        public List<String> lgy;
        public List<String> lgz;
        public int originalFlag;
        public int serviceType;

        public final boolean bAt() {
            return this.lgu > 0 || this.serviceType == 7;
        }

        public final boolean NA() {
            return this.serviceType == 4;
        }

        public static a XI(String str) {
            a aVar;
            AppMethodBeat.i(123490);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
                AppMethodBeat.o(123490);
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                aVar = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject("RunningFlagInfo");
                if (optJSONObject != null) {
                    aVar.czf = optJSONObject.optLong("RunningFlag");
                    aVar.lgt = optJSONObject.optString("AppOpenForbiddenUrl");
                    aVar.kWb = optJSONObject.optLong("CanNotStarWxaBeforeTime", 0);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("Network");
                if (optJSONObject2 != null) {
                    aVar.lgv = ad.n(optJSONObject2.optJSONArray("RequestDomain"));
                    aVar.lgw = ad.n(optJSONObject2.optJSONArray("WsRequestDomain"));
                    aVar.lgx = ad.n(optJSONObject2.optJSONArray("UploadDomain"));
                    aVar.lgy = ad.n(optJSONObject2.optJSONArray("DownloadDomain"));
                    aVar.lgz = ad.n(optJSONObject2.optJSONArray("UDPDomain"));
                }
                aVar.lgu = jSONObject.optInt("WechatPluginApp", 0);
                aVar.serviceType = jSONObject.optInt("AppServiceType", 0);
                aVar.lgA = jSONObject.optString("fromBusinessUsername");
                aVar.originalFlag = jSONObject.optInt("OriginalFlag", 0);
                aVar.ldJ = jSONObject.optString("OriginalRedirectUrl");
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", str, e2);
                aVar = null;
            }
            AppMethodBeat.o(123490);
            return aVar;
        }
    }

    public static final class c {
        public a lgD = new a();
        public List<Pair<String, String>> lgE;

        public static final class a {
            public int cyJ;
            public int cyK;
            public int cyL;
            public int cyM;
            public int cyN;
            public int cyO;
            public boolean cyP;
            public boolean cyQ;
            public boolean cyY;
            public int cza;
            public boolean kXI;
            public boolean kXJ;
            public int kXK;
            public int kXL;
            public int leC;
            public int leD;
            public int leb;
            public int lec;
            public int lex;
            public boolean ley;
            public int lgF;
            public int lgG;
            public int lgH;
            public int lgI;
            public boolean lgJ;
            public long lgK;
            public long lgL;
            public long lgM;
            public long lgN;
        }

        public c() {
            AppMethodBeat.i(123491);
            AppMethodBeat.o(123491);
        }
    }

    public final c bAo() {
        JSONObject jSONObject;
        boolean z = true;
        AppMethodBeat.i(123519);
        if (this.lgp == null) {
            try {
                jSONObject = new JSONObject(this.field_dynamicInfo);
            } catch (Exception e2) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.lgp = new c();
            JSONObject optJSONObject = jSONObject.optJSONObject("NewSetting");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.lgp.lgD.cza = optJSONObject.optInt("MaxLocalstorageSize", 5);
            this.lgp.lgD.lgF = optJSONObject.optInt("OpendataMaxLocalstorageSize", 5);
            this.lgp.lgD.lgG = optJSONObject.optInt("MaxCodeSize", 5);
            this.lgp.lgD.lex = optJSONObject.optInt("ExpendedMaxWebviewDepth", 5);
            this.lgp.lgD.cyJ = optJSONObject.optInt("MaxBackgroundLifespan", 600);
            this.lgp.lgD.cyK = optJSONObject.optInt("MaxRequestConcurrent", 5);
            this.lgp.lgD.cyL = optJSONObject.optInt("MaxUploadConcurrent", 5);
            this.lgp.lgD.cyM = optJSONObject.optInt("MaxDownloadConcurrent", 5);
            this.lgp.lgD.cyN = optJSONObject.optInt("MaxWebsocketConnect", 2);
            this.lgp.lgD.cyO = optJSONObject.optInt("MaxWorkerConcurrent", 1);
            this.lgp.lgD.cyP = optJSONObject.optInt("WebsocketSkipPortCheck", 0) != 0;
            this.lgp.lgD.cyQ = optJSONObject.optInt("TLSSkipHostnameCheck", 0) != 0;
            this.lgp.lgD.lgH = optJSONObject.optInt("MaxFileStorageSize", 10);
            this.lgp.lgD.lgI = optJSONObject.optInt("BackgroundNetworkInterruptedTimeout", 5);
            this.lgp.lgD.ley = optJSONObject.optInt("CanKeepAliveByAudioPlay", 0) > 0;
            this.lgp.lgD.leC = optJSONObject.optInt("LifeSpanBeforeSuspend", 5);
            this.lgp.lgD.leD = optJSONObject.optInt("LifeSpanAfterSuspend", 300);
            this.lgp.lgD.cyY = optJSONObject.optInt("ScanCodeEnableZZM", 0) != 0;
            this.lgp.lgD.kXI = optJSONObject.optInt("CanPreFetchData", 0) > 0;
            c.a aVar = this.lgp.lgD;
            aVar.kXJ = optJSONObject.optInt("CanPeriodFetchData", 0) > 0;
            this.lgp.lgD.kXK = optJSONObject.optInt("PeriodFetchData", 0);
            this.lgp.lgD.kXL = optJSONObject.optInt("PeriodFetchDataDay", 7);
            this.lgp.lgD.leb = optJSONObject.optInt("GuaranteeFlag", 0);
            c.a aVar2 = this.lgp.lgD;
            if (optJSONObject.optInt("CanShowLoadingAdvert", 0) <= 0) {
                z = false;
            }
            aVar2.lgJ = z;
            this.lgp.lgD.lec = optJSONObject.optInt("BrandOfficialLabel", 0);
            this.lgp.lgD.lgK = optJSONObject.optLong("OpenWxaWaitUpdateMaxMicSec", 13000);
            this.lgp.lgD.lgL = optJSONObject.optLong("OpenWxaWaitUpdateMaxMicSecForWeakNet", 10000);
            this.lgp.lgD.lgM = optJSONObject.optLong("OpenWxaWaitUpdateMinMicSec", 0);
            this.lgp.lgD.lgN = optJSONObject.optLong("NextTryOpenWxaDisMicSec", 10000);
            JSONArray optJSONArray = jSONObject.optJSONArray("NewCategories");
            if (optJSONArray != null) {
                this.lgp.lgE = new LinkedList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        this.lgp.lgE.add(new Pair<>(optJSONObject2.optString("first"), optJSONObject2.optString("second")));
                    }
                }
            }
        }
        c cVar = this.lgp;
        AppMethodBeat.o(123519);
        return cVar;
    }

    public static final class WxaVersionCoverImageInfo implements Parcelable {
        public static final Parcelable.Creator<WxaVersionCoverImageInfo> CREATOR = new Parcelable.Creator<WxaVersionCoverImageInfo>() {
            /* class com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionCoverImageInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxaVersionCoverImageInfo[] newArray(int i2) {
                return new WxaVersionCoverImageInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxaVersionCoverImageInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(123501);
                WxaVersionCoverImageInfo wxaVersionCoverImageInfo = new WxaVersionCoverImageInfo(parcel);
                AppMethodBeat.o(123501);
                return wxaVersionCoverImageInfo;
            }
        };
        public String lgQ;
        public String lgR;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(123502);
            parcel.writeString(this.lgQ);
            parcel.writeString(this.lgR);
            AppMethodBeat.o(123502);
        }

        public WxaVersionCoverImageInfo() {
        }

        protected WxaVersionCoverImageInfo(Parcel parcel) {
            AppMethodBeat.i(123503);
            this.lgQ = parcel.readString();
            this.lgR = parcel.readString();
            AppMethodBeat.o(123503);
        }

        static {
            AppMethodBeat.i(123504);
            AppMethodBeat.o(123504);
        }
    }

    public static final class WxaVersionInfo implements Parcelable {
        public static final Parcelable.Creator<WxaVersionInfo> CREATOR = new Parcelable.Creator<WxaVersionInfo>() {
            /* class com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxaVersionInfo[] newArray(int i2) {
                return new WxaVersionInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxaVersionInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(123505);
                WxaVersionInfo wxaVersionInfo = new WxaVersionInfo(parcel);
                AppMethodBeat.o(123505);
                return wxaVersionInfo;
            }
        };
        public int appVersion;
        public boolean cBF = false;
        public int cyu;
        public List<WxaWidgetInfo> jmL;
        public String lgS;
        public String lgT;
        public WxaVersionCoverImageInfo lgU;
        public List<WxaPluginCodeInfo> lgV;
        public int lgW;
        public boolean lgX;
        public String lgY;
        public String lgZ;
        public String lha;
        public long lhb;
        public String lhc = "";
        public String lhd = "";
        public String lhe = "";
        public String lhf = "";
        public List<WxaVersionModuleInfo> moduleList;

        public static WxaVersionInfo XJ(String str) {
            WxaVersionInfo wxaVersionInfo;
            AppMethodBeat.i(123506);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(123506);
                return null;
            }
            long currentTicks = Util.currentTicks();
            try {
                JSONObject jSONObject = new JSONObject(str);
                wxaVersionInfo = new WxaVersionInfo();
                wxaVersionInfo.appVersion = jSONObject.optInt("AppVersion", 0);
                wxaVersionInfo.cyu = jSONObject.optInt("VersionState", -1);
                wxaVersionInfo.lgS = jSONObject.optString("VersionMD5");
                wxaVersionInfo.lgT = jSONObject.optString("device_orientation");
                wxaVersionInfo.lgZ = jSONObject.optString("client_js_ext_info");
                wxaVersionInfo.lgW = jSONObject.optInt("code_size");
                JSONObject optJSONObject = jSONObject.optJSONObject("loading_image_info");
                if (optJSONObject != null) {
                    wxaVersionInfo.lgU = new WxaVersionCoverImageInfo();
                    wxaVersionInfo.lgU.lgQ = optJSONObject.optString("url");
                    wxaVersionInfo.lgU.lgR = optJSONObject.optString("progressbar_color");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("fake_native_loading_style_info");
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("white_style");
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("black_style");
                    if (optJSONObject3 != null) {
                        if (optJSONObject3.has("navigation_bar_text_color")) {
                            wxaVersionInfo.lhc = optJSONObject3.optString("navigation_bar_text_color");
                        }
                        if (optJSONObject3.has("background_color")) {
                            wxaVersionInfo.lhd = optJSONObject3.optString("background_color");
                        }
                    }
                    if (optJSONObject4 != null) {
                        if (optJSONObject4.has("navigation_bar_text_color")) {
                            wxaVersionInfo.lhe = optJSONObject4.optString("navigation_bar_text_color");
                        }
                        if (optJSONObject4.has("background_color")) {
                            wxaVersionInfo.lhf = optJSONObject4.optString("background_color");
                        }
                    }
                }
                wxaVersionInfo.moduleList = WxaVersionModuleInfo.l(jSONObject.optJSONArray("module_list"));
                wxaVersionInfo.lgX = jSONObject.optBoolean("UseModule", false);
                wxaVersionInfo.lgY = jSONObject.optString("EntranceModule");
                wxaVersionInfo.lha = jSONObject.optString("without_lib_md5");
                wxaVersionInfo.jmL = WxaWidgetInfo.m(jSONObject.optJSONArray("widget_list"));
                wxaVersionInfo.lgV = WxaPluginCodeInfo.a(wxaVersionInfo.jmL, jSONObject.opt("separated_plugin_list"), 22);
                wxaVersionInfo.lhb = jSONObject.optLong("ForceSyncUpdateWhenLaunchLastInterval", -1);
                wxaVersionInfo.cBF = jSONObject.optBoolean("resizable", false);
                Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", Long.valueOf(Util.currentTicks() - currentTicks), Integer.valueOf(str.length()));
            } catch (Exception e2) {
                Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", Long.valueOf(Util.currentTicks() - currentTicks), Integer.valueOf(str.length()));
                wxaVersionInfo = null;
            } catch (Throwable th) {
                Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", Long.valueOf(Util.currentTicks() - currentTicks), Integer.valueOf(str.length()));
                AppMethodBeat.o(123506);
                throw th;
            }
            AppMethodBeat.o(123506);
            return wxaVersionInfo;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(123507);
            parcel.writeInt(this.appVersion);
            parcel.writeInt(this.cyu);
            parcel.writeString(this.lgS);
            parcel.writeString(this.lgT);
            parcel.writeParcelable(this.lgU, i2);
            parcel.writeTypedList(this.lgV);
            parcel.writeInt(this.lgW);
            parcel.writeTypedList(this.moduleList);
            parcel.writeByte(this.lgX ? (byte) 1 : 0);
            parcel.writeString(this.lgY);
            parcel.writeString(this.lgZ);
            parcel.writeString(this.lha);
            parcel.writeTypedList(this.jmL);
            parcel.writeString(this.lhc);
            parcel.writeString(this.lhd);
            parcel.writeString(this.lhe);
            parcel.writeString(this.lhf);
            parcel.writeBooleanArray(new boolean[]{this.cBF});
            AppMethodBeat.o(123507);
        }

        public WxaVersionInfo() {
        }

        protected WxaVersionInfo(Parcel parcel) {
            AppMethodBeat.i(123508);
            this.appVersion = parcel.readInt();
            this.cyu = parcel.readInt();
            this.lgS = parcel.readString();
            this.lgT = parcel.readString();
            this.lgU = (WxaVersionCoverImageInfo) parcel.readParcelable(WxaVersionCoverImageInfo.class.getClassLoader());
            this.lgV = parcel.createTypedArrayList(WxaPluginCodeInfo.CREATOR);
            this.lgW = parcel.readInt();
            this.moduleList = parcel.createTypedArrayList(WxaVersionModuleInfo.CREATOR);
            this.lgX = parcel.readByte() != 0;
            this.lgY = parcel.readString();
            this.lgZ = parcel.readString();
            this.lha = parcel.readString();
            this.jmL = parcel.createTypedArrayList(WxaWidgetInfo.CREATOR);
            this.lhc = parcel.readString();
            this.lhd = parcel.readString();
            this.lhe = parcel.readString();
            this.lhf = parcel.readString();
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            this.cBF = zArr[0];
            AppMethodBeat.o(123508);
        }

        static {
            AppMethodBeat.i(123509);
            AppMethodBeat.o(123509);
        }
    }

    public static class WxaPluginCodeInfo implements Parcelable {
        public static final Parcelable.Creator<WxaPluginCodeInfo> CREATOR = new Parcelable.Creator<WxaPluginCodeInfo>() {
            /* class com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxaPluginCodeInfo[] newArray(int i2) {
                return new WxaPluginCodeInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxaPluginCodeInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(123496);
                WxaPluginCodeInfo wxaPluginCodeInfo = new WxaPluginCodeInfo(parcel);
                AppMethodBeat.o(123496);
                return wxaPluginCodeInfo;
            }
        };
        public List<Integer> contexts = new LinkedList();
        public boolean lgP;
        public String md5;
        public String prefixPath;
        public String provider;
        public int version;

        public static List<WxaPluginCodeInfo> a(List<WxaWidgetInfo> list, Object obj, int i2) {
            List<WxaPluginCodeInfo> list2;
            List<WxaPluginCodeInfo> list3;
            AppMethodBeat.i(225281);
            List<WxaPluginCodeInfo> list4 = null;
            if (list != null) {
                for (WxaWidgetInfo wxaWidgetInfo : list) {
                    if (wxaWidgetInfo.packageType == i2) {
                        list3 = wxaWidgetInfo.lhk;
                    } else {
                        list3 = list4;
                    }
                    list4 = list3;
                }
                list2 = list4;
            } else {
                list2 = null;
            }
            if (list2 == null) {
                list2 = cz(obj);
            }
            AppMethodBeat.o(225281);
            return list2;
        }

        public static List<WxaPluginCodeInfo> cz(Object obj) {
            JSONArray jSONArray;
            AppMethodBeat.i(225282);
            if (obj == null) {
                AppMethodBeat.o(225282);
                return null;
            }
            try {
                if (obj instanceof String) {
                    jSONArray = new JSONArray((String) obj);
                } else if (obj instanceof JSONArray) {
                    jSONArray = (JSONArray) obj;
                } else {
                    Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "WxaPluginCodeInfo.optPluginCodeInfoList() invalid pluginCodeObj:%s", obj.getClass().getName());
                    jSONArray = null;
                }
                if (jSONArray == null || jSONArray.length() == 0) {
                    AppMethodBeat.o(225282);
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        WxaPluginCodeInfo wxaPluginCodeInfo = new WxaPluginCodeInfo();
                        wxaPluginCodeInfo.provider = jSONObject.optString("plugin_id");
                        wxaPluginCodeInfo.version = jSONObject.optInt("inner_version");
                        wxaPluginCodeInfo.md5 = jSONObject.optString("md5");
                        wxaPluginCodeInfo.prefixPath = jSONObject.optString("prefix_path");
                        wxaPluginCodeInfo.lgP = jSONObject.optBoolean("auto_update") || jSONObject.optInt("auto_update", 0) > 0;
                        JSONArray optJSONArray = jSONObject.optJSONArray("contexts");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            wxaPluginCodeInfo.contexts.add(0);
                        } else {
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                wxaPluginCodeInfo.contexts.add(Integer.valueOf(optJSONArray.optInt(i3)));
                            }
                        }
                        linkedList.add(wxaPluginCodeInfo);
                    }
                }
                AppMethodBeat.o(225282);
                return linkedList;
            } catch (JSONException e2) {
                Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", e2);
                AppMethodBeat.o(225282);
                return null;
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(123498);
            parcel.writeString(this.provider);
            parcel.writeInt(this.version);
            parcel.writeString(this.md5);
            parcel.writeString(this.prefixPath);
            parcel.writeByte((byte) (this.lgP ? 1 : 0));
            parcel.writeList(this.contexts);
            AppMethodBeat.o(123498);
        }

        public WxaPluginCodeInfo() {
            AppMethodBeat.i(175234);
            AppMethodBeat.o(175234);
        }

        protected WxaPluginCodeInfo(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(123499);
            this.provider = parcel.readString();
            this.version = parcel.readInt();
            this.md5 = parcel.readString();
            this.prefixPath = parcel.readString();
            this.lgP = parcel.readByte() != 1 ? false : z;
            if (this.contexts == null) {
                this.contexts = new LinkedList();
            }
            parcel.readList(this.contexts, Integer.class.getClassLoader());
            AppMethodBeat.o(123499);
        }

        static {
            AppMethodBeat.i(123500);
            AppMethodBeat.o(123500);
        }
    }

    public static class WxaWidgetInfo implements Parcelable {
        public static final Parcelable.Creator<WxaWidgetInfo> CREATOR = new Parcelable.Creator<WxaWidgetInfo>() {
            /* class com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxaWidgetInfo[] newArray(int i2) {
                return new WxaWidgetInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxaWidgetInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(175235);
                WxaWidgetInfo wxaWidgetInfo = new WxaWidgetInfo(parcel);
                AppMethodBeat.o(175235);
                return wxaWidgetInfo;
            }
        };
        public String lhj;
        public List<WxaPluginCodeInfo> lhk;
        public int packageType;

        public static List<WxaWidgetInfo> XL(String str) {
            List<WxaWidgetInfo> list = null;
            AppMethodBeat.i(175236);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(175236);
            } else {
                try {
                    list = m(new JSONArray(str));
                    AppMethodBeat.o(175236);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", e2);
                    AppMethodBeat.o(175236);
                }
            }
            return list;
        }

        public static List<WxaWidgetInfo> m(JSONArray jSONArray) {
            AppMethodBeat.i(225283);
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        LinkedList linkedList = new LinkedList();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            if (jSONObject != null) {
                                WxaWidgetInfo wxaWidgetInfo = new WxaWidgetInfo();
                                wxaWidgetInfo.packageType = jSONObject.optInt("package_type");
                                wxaWidgetInfo.lhj = jSONObject.optString("wxapkg_md5");
                                if (org.apache.commons.b.a.contains(com.tencent.mm.cp.a.RwY, wxaWidgetInfo.packageType)) {
                                    wxaWidgetInfo.lhk = WxaPluginCodeInfo.cz(jSONObject.opt("separated_plugin_list"));
                                    linkedList.add(wxaWidgetInfo);
                                }
                            }
                        }
                        AppMethodBeat.o(225283);
                        return linkedList;
                    }
                } catch (JSONException e2) {
                    Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", e2);
                    AppMethodBeat.o(225283);
                    return null;
                }
            }
            AppMethodBeat.o(225283);
            return null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(175237);
            parcel.writeInt(this.packageType);
            parcel.writeString(this.lhj);
            parcel.writeTypedList(this.lhk);
            AppMethodBeat.o(175237);
        }

        public WxaWidgetInfo() {
        }

        protected WxaWidgetInfo(Parcel parcel) {
            AppMethodBeat.i(175238);
            this.packageType = parcel.readInt();
            this.lhj = parcel.readString();
            this.lhk = parcel.createTypedArrayList(WxaPluginCodeInfo.CREATOR);
            AppMethodBeat.o(175238);
        }

        static {
            AppMethodBeat.i(175239);
            AppMethodBeat.o(175239);
        }
    }

    public static class WxaVersionModuleInfo implements Parcelable {
        public static final Parcelable.Creator<WxaVersionModuleInfo> CREATOR = new Parcelable.Creator<WxaVersionModuleInfo>() {
            /* class com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxaVersionModuleInfo[] newArray(int i2) {
                return new WxaVersionModuleInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxaVersionModuleInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(123510);
                WxaVersionModuleInfo wxaVersionModuleInfo = new WxaVersionModuleInfo(parcel);
                AppMethodBeat.o(123510);
                return wxaVersionModuleInfo;
            }
        };
        public String[] aliases;
        public boolean independent;
        public String lha;
        public List<WxaPluginCodeInfo> lhg;
        public List<WxaWidgetInfo> lhh;
        private JSONObject lhi;
        public String md5;
        public String name;
        public int size;

        public static List<WxaVersionModuleInfo> l(JSONArray jSONArray) {
            AppMethodBeat.i(123511);
            if (jSONArray == null) {
                AppMethodBeat.o(123511);
                return null;
            }
            try {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        WxaVersionModuleInfo wxaVersionModuleInfo = new WxaVersionModuleInfo();
                        wxaVersionModuleInfo.lhi = jSONObject;
                        wxaVersionModuleInfo.name = jSONObject.getString("name");
                        wxaVersionModuleInfo.md5 = jSONObject.getString("md5");
                        wxaVersionModuleInfo.size = jSONObject.optInt("size", 0);
                        wxaVersionModuleInfo.independent = jSONObject.optBoolean("independent", false);
                        wxaVersionModuleInfo.aliases = F(jSONObject);
                        wxaVersionModuleInfo.lha = jSONObject.optString("without_lib_md5");
                        wxaVersionModuleInfo.lhh = WxaWidgetInfo.m(jSONObject.optJSONArray("widget_list"));
                        wxaVersionModuleInfo.lhg = WxaPluginCodeInfo.a(wxaVersionModuleInfo.lhh, jSONObject.opt("separated_plugin_list"), 23);
                        linkedList.add(wxaVersionModuleInfo);
                    }
                }
                AppMethodBeat.o(123511);
                return linkedList;
            } catch (JSONException e2) {
                Log.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", e2);
                AppMethodBeat.o(123511);
                return null;
            }
        }

        public static List<WxaVersionModuleInfo> XK(String str) {
            AppMethodBeat.i(123512);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(123512);
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    AppMethodBeat.o(123512);
                    return null;
                }
                List<WxaVersionModuleInfo> l = l(jSONArray);
                AppMethodBeat.o(123512);
                return l;
            } catch (JSONException e2) {
                Log.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, json = %s, e = %s", str, e2);
                AppMethodBeat.o(123512);
                return null;
            }
        }

        private static String[] F(JSONObject jSONObject) {
            AppMethodBeat.i(123513);
            JSONArray optJSONArray = jSONObject.optJSONArray("alias");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                String[] strArr = new String[0];
                AppMethodBeat.o(123513);
                return strArr;
            }
            String[] strArr2 = new String[optJSONArray.length()];
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                strArr2[i2] = optJSONArray.optString(i2);
            }
            AppMethodBeat.o(123513);
            return strArr2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(123514);
            parcel.writeString(this.name);
            parcel.writeString(this.md5);
            parcel.writeByte(this.independent ? (byte) 1 : 0);
            parcel.writeInt(this.size);
            parcel.writeStringArray(this.aliases);
            parcel.writeTypedList(this.lhg);
            parcel.writeString(this.lha);
            parcel.writeTypedList(this.lhh);
            AppMethodBeat.o(123514);
        }

        public WxaVersionModuleInfo() {
        }

        protected WxaVersionModuleInfo(Parcel parcel) {
            AppMethodBeat.i(123515);
            this.name = parcel.readString();
            this.md5 = parcel.readString();
            this.independent = parcel.readByte() != 0;
            this.size = parcel.readInt();
            this.aliases = parcel.createStringArray();
            this.lhg = parcel.createTypedArrayList(WxaPluginCodeInfo.CREATOR);
            this.lha = parcel.readString();
            this.lhh = parcel.createTypedArrayList(WxaWidgetInfo.CREATOR);
            AppMethodBeat.o(123515);
        }

        static {
            AppMethodBeat.i(123516);
            AppMethodBeat.o(123516);
        }
    }

    public final WxaVersionInfo bAp() {
        AppMethodBeat.i(123520);
        if (this.lgq != null || Util.isNullOrNil(this.field_versionInfo)) {
            WxaVersionInfo wxaVersionInfo = this.lgq;
            AppMethodBeat.o(123520);
            return wxaVersionInfo;
        }
        WxaVersionInfo XJ = WxaVersionInfo.XJ(this.field_versionInfo);
        this.lgq = XJ;
        AppMethodBeat.o(123520);
        return XJ;
    }

    public static final class WxaEntryInfo implements Parcelable {
        public static final Parcelable.Creator<WxaEntryInfo> CREATOR = new Parcelable.Creator<WxaEntryInfo>() {
            /* class com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxaEntryInfo[] newArray(int i2) {
                return new WxaEntryInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxaEntryInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(123492);
                WxaEntryInfo wxaEntryInfo = new WxaEntryInfo(parcel);
                AppMethodBeat.o(123492);
                return wxaEntryInfo;
            }
        };
        public String iconUrl;
        public String lgO;
        public String title;
        public String username;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(123493);
            parcel.writeString(this.username);
            parcel.writeString(this.title);
            parcel.writeString(this.lgO);
            parcel.writeString(this.iconUrl);
            AppMethodBeat.o(123493);
        }

        public WxaEntryInfo() {
        }

        protected WxaEntryInfo(Parcel parcel) {
            AppMethodBeat.i(123494);
            this.username = parcel.readString();
            this.title = parcel.readString();
            this.lgO = parcel.readString();
            this.iconUrl = parcel.readString();
            AppMethodBeat.o(123494);
        }

        static {
            AppMethodBeat.i(123495);
            AppMethodBeat.o(123495);
        }
    }

    public final List<WxaEntryInfo> bAq() {
        AppMethodBeat.i(123521);
        if (this.lgr == null && !Util.isNullOrNil(this.field_bindWxaInfo)) {
            try {
                JSONArray optJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
                if (optJSONArray != null) {
                    this.lgr = new LinkedList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString(ch.COL_USERNAME);
                            if (!Util.isNullOrNil(optString)) {
                                WxaEntryInfo wxaEntryInfo = new WxaEntryInfo();
                                wxaEntryInfo.username = optString;
                                wxaEntryInfo.title = optJSONObject.optString("title");
                                wxaEntryInfo.iconUrl = optJSONObject.optString("icon_url");
                                this.lgr.add(wxaEntryInfo);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                this.lgr = null;
            }
        }
        List<WxaEntryInfo> list = this.lgr;
        AppMethodBeat.o(123521);
        return list;
    }

    public final b bAr() {
        AppMethodBeat.i(123522);
        if (this.lgs == null && !Util.isNullOrNil(this.field_bizMenu)) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_bizMenu);
                this.lgs = new b();
                this.lgs.dhT = jSONObject.optInt("interactive_mode", 0);
                this.lgs.type = jSONObject.optInt("type", 0);
                this.lgs.lgB = k(jSONObject.optJSONArray("button_list"));
            } catch (Exception e2) {
                this.lgs = null;
            }
        }
        b bVar = this.lgs;
        AppMethodBeat.o(123522);
        return bVar;
    }

    private List<b.a> k(JSONArray jSONArray) {
        ArrayList arrayList;
        AppMethodBeat.i(123523);
        if (jSONArray != null) {
            arrayList = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    b.a aVar = new b.a();
                    aVar.name = jSONObject.optString("name", "");
                    aVar.type = jSONObject.optInt("type");
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("value", ""));
                    aVar.userName = jSONObject2.optString("userName", "");
                    aVar.dCx = jSONObject2.optString("pagePath", "");
                    aVar.version = jSONObject2.optInt("version");
                    aVar.lgC = k(jSONObject.optJSONArray("sub_button_list"));
                    arrayList.add(aVar);
                }
            } catch (JSONException e2) {
                AppMethodBeat.o(123523);
                return null;
            }
        } else {
            arrayList = null;
        }
        AppMethodBeat.o(123523);
        return arrayList;
    }

    public final String toString() {
        AppMethodBeat.i(123524);
        String str = "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + ", field_bizMenu='" + this.field_bizMenu + '\'' + '}';
        AppMethodBeat.o(123524);
        return str;
    }

    public final void bAs() {
        AppMethodBeat.i(225284);
        String[] strArr = {String.format(Locale.ENGLISH, ">>>>>> WxaAttributes(%s|%s|%s)START >>>>>>", this.field_username, this.field_appId, this.field_nickname), ">>> field_appInfo=" + this.field_appInfo, ">>> field_versionInfo=" + this.field_versionInfo, ">>> field_dynamicInfo=" + this.field_dynamicInfo, String.format(Locale.ENGLISH, ">>>>>> WxaAttributes(%s|%s|%s) END >>>>>>", this.field_username, this.field_appId, this.field_nickname)};
        for (int i2 = 0; i2 < 5; i2++) {
            com.tencent.stubs.logger.Log.println(4, "MicroMsg.AppBrand.WxaAttributes", strArr[i2]);
        }
        AppMethodBeat.o(225284);
    }

    public final String bua() {
        AppMethodBeat.i(225285);
        HashMap hashMap = new HashMap();
        hashMap.put("NickName", this.field_nickname);
        hashMap.put("BrandIconURL", this.field_brandIconURL);
        hashMap.put("BigHeadImgUrl", this.field_bigHeadURL);
        hashMap.put("SmallHeadImgUrl", this.field_smallHeadURL);
        hashMap.put("Signature", this.field_signature);
        hashMap.put("WxAppOpt", Integer.valueOf(this.field_appOpt));
        hashMap.put("RegisterSource", XH(this.field_registerSource));
        hashMap.put("WxaAppInfo", XH(this.field_appInfo));
        hashMap.put("WxaAppVersionInfo", XH(this.field_versionInfo));
        hashMap.put("BindWxaInfo", XH(this.field_bindWxaInfo));
        hashMap.put("WxaAppDynamic", XH(this.field_dynamicInfo));
        hashMap.put("MMBizMenu", XH(this.field_bizMenu));
        String jSONObject = new JSONObject(hashMap).toString();
        AppMethodBeat.o(225285);
        return jSONObject;
    }

    private static JSONObject XH(String str) {
        AppMethodBeat.i(225286);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(225286);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppMethodBeat.o(225286);
            return jSONObject;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrand.WxaAttributes", e2, "createJsonObjectOrNull", new Object[0]);
            AppMethodBeat.o(225286);
            return null;
        }
    }

    static {
        AppMethodBeat.i(123525);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[21];
        mAutoDBInfo.columns = new String[22];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "usernameHash";
        mAutoDBInfo.colsMap.put("usernameHash", "INTEGER PRIMARY KEY ");
        sb.append(" usernameHash INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "usernameHash";
        mAutoDBInfo.columns[1] = ch.COL_USERNAME;
        mAutoDBInfo.colsMap.put(ch.COL_USERNAME, "TEXT");
        sb.append(" username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "appId";
        mAutoDBInfo.colsMap.put("appId", "TEXT");
        sb.append(" appId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "nickname";
        mAutoDBInfo.colsMap.put("nickname", "TEXT");
        sb.append(" nickname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "shortNickname";
        mAutoDBInfo.colsMap.put("shortNickname", "TEXT");
        sb.append(" shortNickname TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "brandIconURL";
        mAutoDBInfo.colsMap.put("brandIconURL", "TEXT");
        sb.append(" brandIconURL TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "roundedSquareIconURL";
        mAutoDBInfo.colsMap.put("roundedSquareIconURL", "TEXT");
        sb.append(" roundedSquareIconURL TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "bigHeadURL";
        mAutoDBInfo.colsMap.put("bigHeadURL", "TEXT");
        sb.append(" bigHeadURL TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "smallHeadURL";
        mAutoDBInfo.colsMap.put("smallHeadURL", "TEXT");
        sb.append(" smallHeadURL TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "signature";
        mAutoDBInfo.colsMap.put("signature", "TEXT");
        sb.append(" signature TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "appOpt";
        mAutoDBInfo.colsMap.put("appOpt", "INTEGER default '0' ");
        sb.append(" appOpt INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "registerSource";
        mAutoDBInfo.colsMap.put("registerSource", "TEXT");
        sb.append(" registerSource TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "appInfo";
        mAutoDBInfo.colsMap.put("appInfo", "TEXT");
        sb.append(" appInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "versionInfo";
        mAutoDBInfo.colsMap.put("versionInfo", "TEXT");
        sb.append(" versionInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "passThroughInfo";
        mAutoDBInfo.colsMap.put("passThroughInfo", "TEXT");
        sb.append(" passThroughInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "bindWxaInfo";
        mAutoDBInfo.colsMap.put("bindWxaInfo", "TEXT");
        sb.append(" bindWxaInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "dynamicInfo";
        mAutoDBInfo.colsMap.put("dynamicInfo", "TEXT");
        sb.append(" dynamicInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "reserved";
        mAutoDBInfo.colsMap.put("reserved", "TEXT");
        sb.append(" reserved TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "syncTimeSecond";
        mAutoDBInfo.colsMap.put("syncTimeSecond", "LONG default '0' ");
        sb.append(" syncTimeSecond LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "syncVersion";
        mAutoDBInfo.colsMap.put("syncVersion", "TEXT");
        sb.append(" syncVersion TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "bizMenu";
        mAutoDBInfo.colsMap.put("bizMenu", "TEXT");
        sb.append(" bizMenu TEXT");
        mAutoDBInfo.columns[21] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        kLR = mAutoDBInfo;
        AppMethodBeat.o(123525);
    }
}
