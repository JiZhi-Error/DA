package com.tencent.mm.plugin.appbrand.launching.params;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import java.util.ArrayList;
import java.util.List;

public final class LaunchParcel implements Parcelable {
    public static final Parcelable.Creator<LaunchParcel> CREATOR = new Parcelable.Creator<LaunchParcel>() {
        /* class com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LaunchParcel[] newArray(int i2) {
            return new LaunchParcel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LaunchParcel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(147321);
            LaunchParcel launchParcel = new LaunchParcel(parcel, (byte) 0);
            AppMethodBeat.o(147321);
            return launchParcel;
        }
    };
    public String appId;
    private String cym;
    public AppBrandLaunchReferrer cys;
    public b cyz;
    public int iOo;
    public int kHC;
    public String kHG;
    public AppBrandLaunchFromNotifyReferrer kHI;
    public List<String> kHK;
    public HalfScreenConfig kHL;
    public boolean kHM;
    public String kHQ;
    public String kHw;
    public int launchMode;
    public PersistableBundle ldQ;
    public String ldR;
    public ActivityStarterIpcDelegate mQC;
    public AppBrandStatObject mYK;
    public LaunchParamsOptional mYL;
    public long mYM;
    public a<?> mYN;
    public a<Bundle> mYO;
    public PersistableBundle mYP;
    public Parcelable mYQ;
    public Parcelable mYR;
    public int mYS;
    public String username;
    public int version;

    /* synthetic */ LaunchParcel(Parcel parcel, byte b2) {
        this(parcel);
    }

    public final void acj(String str) {
        this.cym = str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(147322);
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.version);
        parcel.writeInt(this.iOo);
        parcel.writeString(this.kHw);
        parcel.writeString(this.cym);
        parcel.writeParcelable(this.mYK, i2);
        parcel.writeParcelable(this.cys, i2);
        parcel.writeParcelable(this.mYL, i2);
        parcel.writeLong(this.mYM);
        parcel.writeString(this.ldR);
        parcel.writePersistableBundle(this.ldQ);
        parcel.writeParcelable(this.mQC, i2);
        OnWXAppResultXPCWrapper.a(this.mYN, parcel);
        parcel.writeInt(this.kHC);
        OnWXAppResultXPCWrapper.a(this.mYO, parcel);
        parcel.writePersistableBundle(this.mYP);
        parcel.writeString(this.kHG);
        parcel.writeInt(this.launchMode);
        parcel.writeParcelable(this.kHI, i2);
        parcel.writeParcelable(this.mYQ, i2);
        parcel.writeParcelable(this.mYR, i2);
        parcel.writeStringList(this.kHK);
        parcel.writeParcelable(this.kHL, i2);
        b.a(this.cyz, parcel);
        parcel.writeInt(this.kHM ? 1 : 0);
        parcel.writeInt(this.mYS);
        parcel.writeString(this.kHQ);
        AppMethodBeat.o(147322);
    }

    public LaunchParcel() {
        AppMethodBeat.i(229921);
        this.kHC = -1;
        this.mYP = null;
        this.kHG = null;
        this.kHL = HalfScreenConfig.lfr;
        this.kHM = false;
        this.kHK = new ArrayList();
        this.cyz = b.LEGACY;
        this.mYS = 0;
        this.kHQ = "";
        AppMethodBeat.o(229921);
    }

    private LaunchParcel(Parcel parcel) {
        boolean z;
        AppMethodBeat.i(147323);
        this.kHC = -1;
        this.mYP = null;
        this.kHG = null;
        this.kHL = HalfScreenConfig.lfr;
        this.kHM = false;
        this.kHK = new ArrayList();
        this.cyz = b.LEGACY;
        this.mYS = 0;
        this.kHQ = "";
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readInt();
        this.iOo = parcel.readInt();
        this.kHw = parcel.readString();
        this.cym = parcel.readString();
        this.mYK = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
        this.cys = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
        this.mYL = (LaunchParamsOptional) parcel.readParcelable(LaunchParamsOptional.class.getClassLoader());
        this.mYM = parcel.readLong();
        this.ldR = parcel.readString();
        this.ldQ = parcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
        this.mQC = (ActivityStarterIpcDelegate) parcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader());
        this.mYN = OnWXAppResultXPCWrapper.a(parcel);
        this.kHC = parcel.readInt();
        this.mYO = OnWXAppResultXPCWrapper.a(parcel);
        this.mYP = parcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
        this.kHG = parcel.readString();
        this.launchMode = parcel.readInt();
        this.kHI = (AppBrandLaunchFromNotifyReferrer) parcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader());
        this.mYQ = parcel.readParcelable(LaunchParcel.class.getClassLoader());
        this.mYR = parcel.readParcelable(LaunchParcel.class.getClassLoader());
        parcel.readStringList(this.kHK);
        this.kHL = (HalfScreenConfig) parcel.readParcelable(HalfScreenConfig.class.getClassLoader());
        this.cyz = b.b(parcel);
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.kHM = z;
        this.mYS = parcel.readInt();
        this.kHQ = parcel.readString();
        AppMethodBeat.o(147323);
    }

    public final String toString() {
        AppMethodBeat.i(169496);
        String str = "LaunchParcel{username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", version=" + this.version + ", versionType=" + this.iOo + ", enterPath='" + this.kHw + '\'' + ", statObj=" + this.mYK + ", referrer=" + this.cys + ", startClickTimestamp=" + this.mYM + ", forceKeepOpaque=" + this.kHM + '}';
        AppMethodBeat.o(169496);
        return str;
    }

    static {
        AppMethodBeat.i(147326);
        AppMethodBeat.o(147326);
    }

    public final void f(AppBrandInitConfigLU appBrandInitConfigLU) {
        String str = null;
        AppMethodBeat.i(147324);
        if (appBrandInitConfigLU == null) {
            AppMethodBeat.o(147324);
            return;
        }
        if (TextUtils.isEmpty(appBrandInitConfigLU.username)) {
            appBrandInitConfigLU.username = this.username;
        }
        if (!(this.mYL == null || this.mYL.cyt == null)) {
            appBrandInitConfigLU.cyt.a(this.mYL.cyt);
        }
        appBrandInitConfigLU.kHw = n.Wf(this.kHw);
        appBrandInitConfigLU.cys.a(this.cys);
        appBrandInitConfigLU.cyq = this.mYL == null ? null : this.mYL.cyq;
        if (this.mYL != null) {
            str = this.mYL.cyr;
        }
        appBrandInitConfigLU.cyr = str;
        appBrandInitConfigLU.startTime = this.mYM;
        appBrandInitConfigLU.cyx = this.mYN;
        appBrandInitConfigLU.cyz = this.cyz;
        appBrandInitConfigLU.dB(this.cym);
        AppMethodBeat.o(147324);
    }

    public static String Wf(String str) {
        AppMethodBeat.i(261894);
        String Wf = n.Wf(str);
        AppMethodBeat.o(261894);
        return Wf;
    }

    public static String ack(String str) {
        String str2;
        AppMethodBeat.i(229923);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(229923);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String Wf = Wf(str);
        String str3 = "";
        int lastIndexOf = Wf.lastIndexOf("?");
        if (lastIndexOf != -1) {
            str2 = Wf.substring(0, lastIndexOf);
            str3 = Wf.substring(lastIndexOf);
        } else {
            str2 = Wf;
        }
        if (TextUtils.isEmpty(str2) || str2.endsWith(".html")) {
            sb.append(str2).append(str3);
        } else {
            sb.append(str2).append(".html").append(str3);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(229923);
        return sb2;
    }
}
