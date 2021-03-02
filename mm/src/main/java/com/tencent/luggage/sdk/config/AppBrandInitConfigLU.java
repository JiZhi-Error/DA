package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.d;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandInitConfigLU extends AppBrandInitConfig {
    public static final Parcelable.Creator<AppBrandInitConfigLU> CREATOR = new Parcelable.Creator<AppBrandInitConfigLU>() {
        /* class com.tencent.luggage.sdk.config.AppBrandInitConfigLU.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandInitConfigLU[] newArray(int i2) {
            return new AppBrandInitConfigLU[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandInitConfigLU createFromParcel(Parcel parcel) {
            AppMethodBeat.i(146692);
            AppBrandInitConfigLU appBrandInitConfigLU = new AppBrandInitConfigLU(parcel);
            AppMethodBeat.o(146692);
            return appBrandInitConfigLU;
        }
    };
    public int appVersion;
    public transient AppBrandStatObject cyA;
    public String cym;
    public String cyn;
    public int cyo;
    public boolean cyp;
    public String cyq;
    public String cyr;
    public final AppBrandLaunchReferrer cys;
    public final AppBrandWeishiParams cyt;
    public int cyu;
    public WxaAttributes.WxaVersionInfo cyv;
    public String cyw;
    public a<?> cyx;
    public boolean cyy;
    public b cyz;
    public String extInfo;
    public long startTime;
    public int uin;
    public String username;

    @Override // com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig
    public /* synthetic */ AppBrandInitConfig NH() {
        AppMethodBeat.i(146701);
        AppBrandInitConfigLU NG = NG();
        AppMethodBeat.o(146701);
        return NG;
    }

    @Override // com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig, java.lang.Object
    public /* synthetic */ Object clone() {
        AppMethodBeat.i(146702);
        AppBrandInitConfigLU NG = NG();
        AppMethodBeat.o(146702);
        return NG;
    }

    public final boolean Ny() {
        return this.cyy;
    }

    public final void resetSession() {
        AppMethodBeat.i(146693);
        Log.i("Luggage.AppBrandInitConfigLU", "resetSession() %s", android.util.Log.getStackTraceString(new Throwable()));
        d dVar = d.a.czj;
        if (dVar == null) {
            dVar = d.czi;
        }
        this.cym = dVar.NJ();
        AppMethodBeat.o(146693);
    }

    public final void dB(String str) {
        AppMethodBeat.i(229826);
        Log.i("Luggage.AppBrandInitConfigLU", "resetSession(%s) %s", str, android.util.Log.getStackTraceString(new Throwable()));
        this.cym = str;
        AppMethodBeat.o(229826);
    }

    public final void dC(String str) {
        AppMethodBeat.i(229827);
        Assert.assertFalse(TextUtils.isEmpty(str));
        Log.i("Luggage.AppBrandInitConfigLU", "resetInstanceId(%s) %s", str, android.util.Log.getStackTraceString(new Throwable()));
        this.cyn = str;
        AppMethodBeat.o(229827);
    }

    public final void a(AppBrandStatObject appBrandStatObject) {
        this.cyA = appBrandStatObject;
    }

    public final AppBrandStatObject Nz() {
        return this.cyA;
    }

    public boolean NA() {
        return this.cyo == 4;
    }

    public final String NB() {
        return this.cym;
    }

    public final String NC() {
        return this.cyn;
    }

    public final JSONObject ND() {
        AppMethodBeat.i(146694);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shareKey", this.cyr);
            jSONObject.put("shareName", this.cyq);
            if (jSONObject.length() == 0) {
                AppMethodBeat.o(146694);
                return null;
            }
            AppMethodBeat.o(146694);
            return jSONObject;
        } catch (JSONException e2) {
            AppMethodBeat.o(146694);
            return null;
        }
    }

    public final JSONObject NE() {
        AppMethodBeat.i(146695);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
            jSONObject.put("nickname", this.brandName);
            jSONObject.put("icon", this.iconUrl);
            if (jSONObject.length() == 0) {
                AppMethodBeat.o(146695);
                return null;
            }
            AppMethodBeat.o(146695);
            return jSONObject;
        } catch (JSONException e2) {
            AppMethodBeat.o(146695);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig
    public final JSONObject NF() {
        AppMethodBeat.i(146696);
        if (this.cys == null || 2 != this.cys.leo || !TextUtils.isEmpty(this.cys.appId)) {
            JSONObject bzV = this.cys.bzV();
            AppMethodBeat.o(146696);
            return bzV;
        }
        AppMethodBeat.o(146696);
        return null;
    }

    public AppBrandInitConfigLU() {
        AppMethodBeat.i(169428);
        this.cyy = false;
        this.cyz = b.LEGACY;
        this.cys = new AppBrandLaunchReferrer();
        this.cyt = new AppBrandWeishiParams();
        AppMethodBeat.o(169428);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected AppBrandInitConfigLU(Parcel parcel) {
        super(parcel);
        boolean z = true;
        AppMethodBeat.i(146697);
        this.cyy = false;
        this.cyz = b.LEGACY;
        this.cym = parcel.readString();
        this.cyn = parcel.readString();
        this.username = parcel.readString();
        this.cyq = parcel.readString();
        this.cyr = parcel.readString();
        this.cys = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
        this.cyt = (AppBrandWeishiParams) parcel.readParcelable(AppBrandWeishiParams.class.getClassLoader());
        this.cyo = parcel.readInt();
        this.cyp = parcel.readByte() != 0;
        this.extInfo = parcel.readString();
        this.startTime = parcel.readLong();
        this.appVersion = parcel.readInt();
        this.cyu = parcel.readInt();
        this.cyv = (WxaAttributes.WxaVersionInfo) parcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader());
        this.cyw = parcel.readString();
        this.uin = parcel.readInt();
        this.cyy = parcel.readByte() == 0 ? false : z;
        this.cyx = OnWXAppResultXPCWrapper.a(parcel);
        this.cyz = b.b(parcel);
        AppMethodBeat.o(146697);
    }

    public String toString() {
        AppMethodBeat.i(146698);
        String str = "AppBrandInitConfigLU {visitingSessionId='" + this.cym + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.brandName + '\'' + ", debugType=" + this.eix + ", orientation='" + this.cBG + '\'' + ", enterPath='" + this.kHw + '\'' + ", shareName='" + this.cyq + '\'' + ", shareKey='" + this.cyr + '\'' + ", startTime=" + this.startTime + ", referrer=" + this.cys + ", extInfo=" + this.extInfo + ", appVersion=" + this.appVersion + '}';
        AppMethodBeat.o(146698);
        return str;
    }

    public AppBrandInitConfigLU NG() {
        AppMethodBeat.i(146699);
        AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) super.NH();
        AppMethodBeat.o(146699);
        return appBrandInitConfigLU;
    }

    @Override // com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig
    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = 1;
        AppMethodBeat.i(146700);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.cym);
        parcel.writeString(this.cyn);
        parcel.writeString(this.username);
        parcel.writeString(this.cyq);
        parcel.writeString(this.cyr);
        parcel.writeParcelable(this.cys, i2);
        parcel.writeParcelable(this.cyt, i2);
        parcel.writeInt(this.cyo);
        parcel.writeByte(this.cyp ? (byte) 1 : 0);
        parcel.writeString(this.extInfo);
        parcel.writeLong(this.startTime);
        parcel.writeInt(this.appVersion);
        parcel.writeInt(this.cyu);
        parcel.writeParcelable(this.cyv, i2);
        parcel.writeString(this.cyw);
        parcel.writeInt(this.uin);
        if (!this.cyy) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        OnWXAppResultXPCWrapper.a(this.cyx, parcel);
        b.a(this.cyz, parcel);
        AppMethodBeat.o(146700);
    }

    static {
        AppMethodBeat.i(146703);
        AppMethodBeat.o(146703);
    }

    public final boolean Nx() {
        AppMethodBeat.i(229825);
        if (Util.isNullOrNil(this.cyv.lgZ)) {
            AppMethodBeat.o(229825);
            return false;
        }
        try {
            JSONArray optJSONArray = new JSONObject(this.cyv.lgZ).optJSONArray("call_plugin_info");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                AppMethodBeat.o(229825);
                return false;
            }
            AppMethodBeat.o(229825);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(229825);
            return false;
        }
    }
}
