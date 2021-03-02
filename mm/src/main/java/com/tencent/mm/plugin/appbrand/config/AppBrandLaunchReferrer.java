package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class AppBrandLaunchReferrer implements Parcelable {
    public static final Parcelable.Creator<AppBrandLaunchReferrer> CREATOR = new Parcelable.Creator<AppBrandLaunchReferrer>() {
        /* class com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandLaunchReferrer[] newArray(int i2) {
            return new AppBrandLaunchReferrer[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandLaunchReferrer createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134791);
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer(parcel, (byte) 0);
            AppMethodBeat.o(134791);
            return appBrandLaunchReferrer;
        }
    };
    public String appId;
    public String businessType;
    public String dSJ;
    public String eda;
    public int leo;
    public String lep;
    public String leq;
    public String ler;
    public String les;
    public int sourceType;
    public String url;

    /* synthetic */ AppBrandLaunchReferrer(Parcel parcel, byte b2) {
        this(parcel);
    }

    public AppBrandLaunchReferrer() {
    }

    public final String toString() {
        AppMethodBeat.i(134792);
        String str = "AppBrandLaunchReferrer{launchScene=" + this.leo + ", appId='" + this.appId + '\'' + ", extraData='" + this.dSJ + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.leq + '\'' + ", sourceType='" + this.sourceType + '\'' + ", businessType='" + this.businessType + '\'' + '}';
        AppMethodBeat.o(134792);
        return str;
    }

    private void j(Parcel parcel) {
        AppMethodBeat.i(134793);
        this.leo = parcel.readInt();
        this.appId = parcel.readString();
        this.dSJ = parcel.readString();
        this.lep = parcel.readString();
        this.url = parcel.readString();
        this.leq = parcel.readString();
        this.sourceType = parcel.readInt();
        this.businessType = parcel.readString();
        this.eda = parcel.readString();
        this.ler = parcel.readString();
        this.les = parcel.readString();
        AppMethodBeat.o(134793);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(134794);
        parcel.writeInt(this.leo);
        parcel.writeString(this.appId);
        parcel.writeString(this.dSJ);
        parcel.writeString(this.lep);
        parcel.writeString(this.url);
        parcel.writeString(this.leq);
        parcel.writeInt(this.sourceType);
        parcel.writeString(this.businessType);
        parcel.writeString(this.eda);
        parcel.writeString(this.ler);
        parcel.writeString(this.les);
        AppMethodBeat.o(134794);
    }

    public final void a(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        AppMethodBeat.i(134795);
        if (appBrandLaunchReferrer == null) {
            AppMethodBeat.o(134795);
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        appBrandLaunchReferrer.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        j(obtain);
        obtain.recycle();
        AppMethodBeat.o(134795);
    }

    public final JSONObject bzV() {
        Object obj;
        AppMethodBeat.i(134796);
        try {
            obj = new JSONObject(this.dSJ);
        } catch (Exception e2) {
            obj = this.dSJ;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
            jSONObject.put("extraData", obj);
            if ((this.leo == 1 || this.leo == 3 || this.leo == 2) && !Util.isNullOrNil(this.lep)) {
                jSONObject.put("privateExtraData", new JSONObject(this.lep));
            }
            if (this.leo == 6 && !Util.isNullOrNil(this.eda)) {
                jSONObject.put("messageExtraData", new JSONObject(this.eda));
            }
            if (this.leo == 7 && !Util.isNullOrNil(this.ler)) {
                jSONObject.put("openapiInvokeData", new JSONObject(this.ler));
            }
            if (this.leo == 7 && !Util.isNullOrNil(this.les)) {
                jSONObject.put("transitiveData", new JSONObject(this.les));
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.AppBrandLaunchReferrer", "toJsonObj exception: %s", e3);
        }
        if (jSONObject.length() == 0) {
            AppMethodBeat.o(134796);
            return null;
        }
        AppMethodBeat.o(134796);
        return jSONObject;
    }

    public final int describeContents() {
        return 0;
    }

    private AppBrandLaunchReferrer(Parcel parcel) {
        AppMethodBeat.i(134797);
        j(parcel);
        AppMethodBeat.o(134797);
    }

    static {
        AppMethodBeat.i(134798);
        AppMethodBeat.o(134798);
    }
}
