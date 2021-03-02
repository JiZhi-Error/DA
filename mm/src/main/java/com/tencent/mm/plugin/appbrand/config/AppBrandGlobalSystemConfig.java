package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig implements Parcelable {
    public static final Parcelable.Creator<AppBrandGlobalSystemConfig> CREATOR = new Parcelable.Creator<AppBrandGlobalSystemConfig>() {
        /* class com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandGlobalSystemConfig[] newArray(int i2) {
            return new AppBrandGlobalSystemConfig[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandGlobalSystemConfig createFromParcel(Parcel parcel) {
            AppMethodBeat.i(146968);
            AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig(parcel);
            AppMethodBeat.o(146968);
            return appBrandGlobalSystemConfig;
        }
    };
    private static volatile AppBrandGlobalSystemConfig lcG;
    public static final AppBrandGlobalSystemConfig lcH;
    public int lcI = Integer.MAX_VALUE;
    public int lcJ;
    public int lcK;
    public int lcL;
    public int lcM;
    public int lcN;
    public int lcO;
    public int lcP;
    public String lcQ;
    public String lcR;
    public HttpSetting lcS = new HttpSetting();
    public int[] lcT;
    public int lcU;
    public int lcV;
    public int lcW;
    public int lcX;
    public int lcY;
    public int lcZ;
    public int lda;
    public int ldb;
    public int ldc;
    public int ldd;
    public int lde;
    public String[] ldf;
    public double ldg;
    public int ldh;
    public int ldi;
    public WeAppSyncVersionSetting ldj;
    public PackageManager ldk;
    public long ldl;
    public String[] ldm;
    public int ldn;
    public int ldo;
    public int ldp;

    public interface a {
        public static final String ldq = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e29));
        public static final int[] ldr = new int[0];
        public static final String[] lds = {"https://wx.qlogo.cn/"};
        public static final String[] ldt = new String[0];
    }

    static {
        AppMethodBeat.i(146988);
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
        lcH = appBrandGlobalSystemConfig;
        appBrandGlobalSystemConfig.lcJ = 5;
        lcH.lcK = 1;
        lcH.lcL = 300;
        lcH.lcM = 50;
        lcH.lcN = 1048576;
        lcH.lcO = 1048576;
        lcH.lcP = 20971520;
        lcH.lcT = a.ldr;
        lcH.lcU = 50;
        lcH.lcV = 11;
        lcH.lcW = 12;
        lcH.lcY = 1800;
        lcH.lcZ = 307200;
        lcH.lda = 25;
        lcH.ldb = 10485760;
        lcH.ldc = 314572800;
        lcH.ldd = 1;
        lcH.lde = 50;
        lcH.ldf = a.lds;
        lcH.ldg = 0.0d;
        lcH.ldh = 60;
        lcH.ldi = 60;
        lcH.ldj = new WeAppSyncVersionSetting();
        lcH.ldk = new PackageManager();
        lcH.ldl = 30;
        lcH.ldm = a.ldt;
        lcH.ldn = 10;
        lcH.ldp = LocalCache.TIME_DAY;
        AppMethodBeat.o(146988);
    }

    static synchronized void bzM() {
        synchronized (AppBrandGlobalSystemConfig.class) {
            lcG = null;
        }
    }

    static String bzN() {
        AppMethodBeat.i(146981);
        o oVar = new o(b.aKC().replace("/data/user/0", "/data/data"), "wxaapp/res/");
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        String z = aa.z(new o(oVar, "AppService.conf").her());
        AppMethodBeat.o(146981);
        return z;
    }

    private static synchronized AppBrandGlobalSystemConfig bzO() {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig;
        String str;
        synchronized (AppBrandGlobalSystemConfig.class) {
            AppMethodBeat.i(146982);
            if (lcG == null) {
                try {
                    str = s.boY(bzN());
                } catch (FileNotFoundException e2) {
                    ((com.tencent.luggage.sdk.customize.a) e.M(com.tencent.luggage.sdk.customize.a.class)).NM();
                    str = null;
                } catch (IOException e3) {
                    Log.e("MicroMsg.AppBrandGlobalSystemConfig", "read config file, exp = %s", e3);
                    str = null;
                }
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(146982);
                    appBrandGlobalSystemConfig = null;
                } else {
                    lcG = WZ(str);
                }
            }
            appBrandGlobalSystemConfig = lcG;
            AppMethodBeat.o(146982);
        }
        return appBrandGlobalSystemConfig;
    }

    public static AppBrandGlobalSystemConfig bzP() {
        AppMethodBeat.i(146983);
        AppBrandGlobalSystemConfig bzO = bzO();
        if (bzO == null) {
            AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = lcH;
            AppMethodBeat.o(146983);
            return appBrandGlobalSystemConfig;
        }
        AppMethodBeat.o(146983);
        return bzO;
    }

    private static AppBrandGlobalSystemConfig WZ(String str) {
        AppMethodBeat.i(146984);
        Log.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
            JSONObject optJSONObject = jSONObject.optJSONObject("HTTPSetting");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("HTTPHeaderMode", "");
                if (optString.equals("BlackList")) {
                    appBrandGlobalSystemConfig.lcS.mode = 1;
                } else if (optString.equals("WhiteList")) {
                    appBrandGlobalSystemConfig.lcS.mode = 2;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("HeaderBlackList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.lcS.ldu = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        appBrandGlobalSystemConfig.lcS.ldu.add(optJSONArray.getString(i2));
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("HeaderWhiteList");
                if (optJSONArray2 != null) {
                    appBrandGlobalSystemConfig.lcS.ldv = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        appBrandGlobalSystemConfig.lcS.ldv.add(optJSONArray2.getString(i3));
                    }
                }
                appBrandGlobalSystemConfig.lcS.ldw = optJSONObject.optInt("WebsocketMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.lcS.ldx = optJSONObject.optInt("UploadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.lcS.ldy = optJSONObject.optInt("DownloadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.lcS.ldz = optJSONObject.optInt("RequestMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.lcS.ldA = optJSONObject.optString("HTTPHeaderReferer");
            }
            appBrandGlobalSystemConfig.ldj = new WeAppSyncVersionSetting();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("SyncVersionSetting");
            if (optJSONObject2 != null) {
                appBrandGlobalSystemConfig.ldj.ldF = optJSONObject2.optLong("PullVersionInterval", appBrandGlobalSystemConfig.ldj.ldF);
                appBrandGlobalSystemConfig.ldj.ldG = optJSONObject2.optLong("PullVersionWxaUsageLastInterval", appBrandGlobalSystemConfig.ldj.ldG);
                appBrandGlobalSystemConfig.ldj.ldH = optJSONObject2.optInt("PullVersionMaxCount", appBrandGlobalSystemConfig.ldj.ldH);
                appBrandGlobalSystemConfig.ldj.ldI = optJSONObject2.optInt("PullVersionMaxCountPerRequest", appBrandGlobalSystemConfig.ldj.ldI);
            }
            appBrandGlobalSystemConfig.ldk = new PackageManager();
            JSONObject optJSONObject3 = jSONObject.optJSONObject("PackageManager");
            if (optJSONObject3 != null) {
                appBrandGlobalSystemConfig.ldk.ldB = optJSONObject3.optLong("CheckInterval", appBrandGlobalSystemConfig.ldk.ldB);
                appBrandGlobalSystemConfig.ldk.ldC = optJSONObject3.optLong("WithoutContactClearSeconds", appBrandGlobalSystemConfig.ldk.ldC);
                appBrandGlobalSystemConfig.ldk.ldD = optJSONObject3.optLong("ClientStorageMinMB", appBrandGlobalSystemConfig.ldk.ldD);
                appBrandGlobalSystemConfig.ldk.ldE = optJSONObject3.optInt("WholeClientStoragePercent", appBrandGlobalSystemConfig.ldk.ldE);
            }
            appBrandGlobalSystemConfig.lcQ = jSONObject.optString("CDNBaseURL");
            appBrandGlobalSystemConfig.lcR = jSONObject.optString("CDNPreConnectURL", a.ldq);
            appBrandGlobalSystemConfig.lcJ = jSONObject.optInt("AppMaxRunningCount", 5);
            appBrandGlobalSystemConfig.lcK = jSONObject.optInt("AppSharedResourceBackgroundRunningCount", 1);
            appBrandGlobalSystemConfig.lcL = jSONObject.optInt("TempFileSizeLimitTotal", 300);
            appBrandGlobalSystemConfig.lcM = jSONObject.optInt("DownloadFileSizeLimit", 50);
            appBrandGlobalSystemConfig.lcN = jSONObject.optInt("MaxLocalStorageItemSize", 1048576);
            appBrandGlobalSystemConfig.lcO = jSONObject.optInt("MaxGlobalStorageItemSize", 1048576);
            appBrandGlobalSystemConfig.lcP = jSONObject.optInt("MaxGlobalStorageSize", 20971520);
            appBrandGlobalSystemConfig.ldb = jSONObject.optInt("NativeBufferSizeLimitByte", 10485760);
            appBrandGlobalSystemConfig.ldc = jSONObject.optInt("NativeBufferQueueLimitByte", 314572800);
            appBrandGlobalSystemConfig.ldp = jSONObject.optInt("WeUseRecallInterval", LocalCache.TIME_DAY);
            JSONArray optJSONArray3 = jSONObject.optJSONArray("SyncLaunchSceneList");
            if (optJSONArray3 != null) {
                appBrandGlobalSystemConfig.lcT = new int[optJSONArray3.length()];
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    appBrandGlobalSystemConfig.lcT[i4] = optJSONArray3.optInt(i4, 0);
                }
            }
            if (appBrandGlobalSystemConfig.lcT == null) {
                appBrandGlobalSystemConfig.lcT = a.ldr;
            }
            appBrandGlobalSystemConfig.lcU = jSONObject.optInt("StarNumberLimitation", 50);
            appBrandGlobalSystemConfig.lcV = jSONObject.optInt("TaskBarItemCountLimitation", 11);
            appBrandGlobalSystemConfig.lcW = jSONObject.optInt("NewTaskBarRecentsItemCountLimitation", 12);
            appBrandGlobalSystemConfig.lcX = jSONObject.optInt("TaskBarSyncUsageRecordIntervalMinute", 20);
            appBrandGlobalSystemConfig.lcY = jSONObject.optInt("WidgetImageFlowLimitDuration", 1800);
            appBrandGlobalSystemConfig.lcZ = jSONObject.optInt("WidgetImageFlowLimitMaxSize", 307200);
            appBrandGlobalSystemConfig.lda = jSONObject.optInt("WidgetDrawMinInterval", 25);
            appBrandGlobalSystemConfig.ldd = jSONObject.optInt("GameMaxRunningCount", 1);
            appBrandGlobalSystemConfig.lde = jSONObject.optInt("GameDownloadFileSizeLimit", 50);
            JSONArray optJSONArray4 = jSONObject.optJSONArray("SubContextImgDomain");
            if (optJSONArray4 == null || optJSONArray4.length() == 0) {
                appBrandGlobalSystemConfig.ldf = a.lds;
            } else {
                appBrandGlobalSystemConfig.ldf = new String[optJSONArray4.length()];
                for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                    appBrandGlobalSystemConfig.ldf[i5] = optJSONArray4.optString(i5, null);
                }
            }
            appBrandGlobalSystemConfig.ldg = jSONObject.optDouble("GamePerfCollectSamplePercentage", 0.0d);
            appBrandGlobalSystemConfig.ldh = jSONObject.optInt("GamePerfCollectInterval", 60);
            appBrandGlobalSystemConfig.ldi = jSONObject.optInt("PerformIndexReportGapInSeconds", 60);
            appBrandGlobalSystemConfig.ldl = jSONObject.optLong("OpendataMaxFileStorageSize", 30);
            JSONArray optJSONArray5 = jSONObject.optJSONArray("PreDownloadUserNameBlackList");
            if (optJSONArray5 == null || optJSONArray5.length() <= 0) {
                appBrandGlobalSystemConfig.ldm = a.ldt;
            } else {
                appBrandGlobalSystemConfig.ldm = new String[optJSONArray5.length()];
                for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                    appBrandGlobalSystemConfig.ldm[i6] = optJSONArray5.optString(i6, null);
                }
            }
            appBrandGlobalSystemConfig.ldn = jSONObject.optInt("WXDataMaxRequestConcurrent", 10);
            appBrandGlobalSystemConfig.ldo = jSONObject.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
            AppMethodBeat.o(146984);
            return appBrandGlobalSystemConfig;
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", Util.stackTraceToString(e2));
            AppMethodBeat.o(146984);
            return null;
        }
    }

    public static final class PackageManager implements Parcelable {
        public static final Parcelable.Creator<PackageManager> CREATOR = new Parcelable.Creator<PackageManager>() {
            /* class com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PackageManager[] newArray(int i2) {
                return new PackageManager[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PackageManager createFromParcel(Parcel parcel) {
                AppMethodBeat.i(146973);
                PackageManager packageManager = new PackageManager(parcel);
                AppMethodBeat.o(146973);
                return packageManager;
            }
        };
        public long ldB = 86400;
        public long ldC = 864000;
        public long ldD = 256;
        public int ldE = 5;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(146974);
            parcel.writeLong(this.ldB);
            parcel.writeLong(this.ldC);
            parcel.writeLong(this.ldD);
            parcel.writeInt(this.ldE);
            AppMethodBeat.o(146974);
        }

        public PackageManager() {
        }

        protected PackageManager(Parcel parcel) {
            AppMethodBeat.i(146975);
            this.ldB = parcel.readLong();
            this.ldC = parcel.readLong();
            this.ldD = parcel.readLong();
            this.ldE = parcel.readInt();
            AppMethodBeat.o(146975);
        }

        static {
            AppMethodBeat.i(146976);
            AppMethodBeat.o(146976);
        }
    }

    public static final class WeAppSyncVersionSetting implements Parcelable {
        public static final Parcelable.Creator<WeAppSyncVersionSetting> CREATOR = new Parcelable.Creator<WeAppSyncVersionSetting>() {
            /* class com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WeAppSyncVersionSetting[] newArray(int i2) {
                return new WeAppSyncVersionSetting[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WeAppSyncVersionSetting createFromParcel(Parcel parcel) {
                AppMethodBeat.i(146977);
                WeAppSyncVersionSetting weAppSyncVersionSetting = new WeAppSyncVersionSetting(parcel);
                AppMethodBeat.o(146977);
                return weAppSyncVersionSetting;
            }
        };
        public long ldF = 21600;
        public long ldG = 604800;
        public int ldH = 1000;
        public int ldI = 100;

        WeAppSyncVersionSetting() {
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(146978);
            parcel.writeLong(this.ldF);
            parcel.writeLong(this.ldG);
            parcel.writeInt(this.ldH);
            parcel.writeInt(this.ldI);
            AppMethodBeat.o(146978);
        }

        WeAppSyncVersionSetting(Parcel parcel) {
            AppMethodBeat.i(146979);
            this.ldF = parcel.readLong();
            this.ldG = parcel.readLong();
            this.ldH = parcel.readInt();
            this.ldI = parcel.readInt();
            AppMethodBeat.o(146979);
        }

        static {
            AppMethodBeat.i(146980);
            AppMethodBeat.o(146980);
        }
    }

    public static final class HttpSetting implements Parcelable {
        public static final Parcelable.Creator<HttpSetting> CREATOR = new Parcelable.Creator<HttpSetting>() {
            /* class com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.HttpSetting.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ HttpSetting[] newArray(int i2) {
                return new HttpSetting[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ HttpSetting createFromParcel(Parcel parcel) {
                AppMethodBeat.i(146969);
                HttpSetting httpSetting = new HttpSetting(parcel);
                AppMethodBeat.o(146969);
                return httpSetting;
            }
        };
        public String ldA;
        public ArrayList<String> ldu;
        public ArrayList<String> ldv;
        public int ldw;
        public int ldx;
        public int ldy;
        public int ldz;
        public int mode = 0;

        public HttpSetting() {
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(146970);
            parcel.writeInt(this.mode);
            parcel.writeStringList(this.ldu);
            parcel.writeStringList(this.ldv);
            parcel.writeInt(this.ldw);
            parcel.writeInt(this.ldx);
            parcel.writeInt(this.ldy);
            parcel.writeInt(this.ldz);
            parcel.writeString(this.ldA);
            AppMethodBeat.o(146970);
        }

        HttpSetting(Parcel parcel) {
            AppMethodBeat.i(146971);
            this.mode = parcel.readInt();
            this.ldu = parcel.createStringArrayList();
            this.ldv = parcel.createStringArrayList();
            this.ldw = parcel.readInt();
            this.ldx = parcel.readInt();
            this.ldy = parcel.readInt();
            this.ldz = parcel.readInt();
            this.ldA = parcel.readString();
            AppMethodBeat.o(146971);
        }

        static {
            AppMethodBeat.i(146972);
            AppMethodBeat.o(146972);
        }
    }

    private AppBrandGlobalSystemConfig() {
        AppMethodBeat.i(146985);
        AppMethodBeat.o(146985);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(146986);
        parcel.writeInt(this.lcI);
        parcel.writeInt(this.lcJ);
        parcel.writeInt(this.lcK);
        parcel.writeInt(this.lcL);
        parcel.writeInt(this.lcM);
        parcel.writeInt(this.lcN);
        parcel.writeInt(this.lcO);
        parcel.writeInt(this.lcP);
        parcel.writeString(this.lcQ);
        parcel.writeString(this.lcR);
        parcel.writeParcelable(this.lcS, i2);
        parcel.writeIntArray(this.lcT);
        parcel.writeInt(this.lcU);
        parcel.writeInt(this.lcV);
        parcel.writeInt(this.lcY);
        parcel.writeInt(this.lcZ);
        parcel.writeInt(this.lda);
        parcel.writeInt(this.ldb);
        parcel.writeInt(this.ldc);
        parcel.writeInt(this.ldd);
        parcel.writeInt(this.lde);
        parcel.writeStringArray(this.ldf);
        parcel.writeDouble(this.ldg);
        parcel.writeInt(this.ldh);
        parcel.writeParcelable(this.ldj, i2);
        parcel.writeParcelable(this.ldk, i2);
        parcel.writeLong(this.ldl);
        parcel.writeStringArray(this.ldm);
        parcel.writeInt(this.ldn);
        parcel.writeInt(this.ldp);
        parcel.writeInt(this.ldo);
        parcel.writeInt(this.ldi);
        AppMethodBeat.o(146986);
    }

    protected AppBrandGlobalSystemConfig(Parcel parcel) {
        AppMethodBeat.i(146987);
        this.lcI = parcel.readInt();
        this.lcJ = parcel.readInt();
        this.lcK = parcel.readInt();
        this.lcL = parcel.readInt();
        this.lcM = parcel.readInt();
        this.lcN = parcel.readInt();
        this.lcO = parcel.readInt();
        this.lcP = parcel.readInt();
        this.lcQ = parcel.readString();
        this.lcR = parcel.readString();
        this.lcS = (HttpSetting) parcel.readParcelable(HttpSetting.class.getClassLoader());
        this.lcT = parcel.createIntArray();
        this.lcU = parcel.readInt();
        this.lcV = parcel.readInt();
        this.lcY = parcel.readInt();
        this.lcZ = parcel.readInt();
        this.lda = parcel.readInt();
        this.ldb = parcel.readInt();
        this.ldc = parcel.readInt();
        this.ldd = parcel.readInt();
        this.lde = parcel.readInt();
        this.ldf = parcel.createStringArray();
        this.ldg = parcel.readDouble();
        this.ldh = parcel.readInt();
        this.ldj = (WeAppSyncVersionSetting) parcel.readParcelable(WeAppSyncVersionSetting.class.getClassLoader());
        this.ldk = (PackageManager) parcel.readParcelable(PackageManager.class.getClassLoader());
        this.ldl = parcel.readLong();
        this.ldm = parcel.createStringArray();
        this.ldn = parcel.readInt();
        this.ldp = parcel.readInt();
        this.ldo = parcel.readInt();
        this.ldi = parcel.readInt();
        AppMethodBeat.o(146987);
    }
}
