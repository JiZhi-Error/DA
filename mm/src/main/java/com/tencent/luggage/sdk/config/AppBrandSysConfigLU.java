package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import java.util.ArrayList;
import java.util.HashMap;

public class AppBrandSysConfigLU extends l implements Parcelable, m {
    public static final Parcelable.Creator<AppBrandSysConfigLU> CREATOR = new Parcelable.Creator<AppBrandSysConfigLU>() {
        /* class com.tencent.luggage.sdk.config.AppBrandSysConfigLU.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandSysConfigLU[] newArray(int i2) {
            return new AppBrandSysConfigLU[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandSysConfigLU createFromParcel(Parcel parcel) {
            AppMethodBeat.i(146704);
            AppBrandSysConfigLU appBrandSysConfigLU = new AppBrandSysConfigLU(parcel);
            AppMethodBeat.o(146704);
            return appBrandSysConfigLU;
        }
    };
    public String cyB;
    public boolean cyC;
    public boolean cyD;
    @Deprecated
    public boolean cyE;
    public boolean cyF;
    public AppRuntimeApiPermissionBundle cyG;
    public HashMap<String, AppRuntimeApiPermissionBundle> cyH;
    public String cyI;
    public int cyJ;
    public int cyK;
    public int cyL;
    public int cyM;
    public int cyN;
    public int cyO;
    public boolean cyP;
    public boolean cyQ;
    public long cyR;
    public int cyS;
    public ArrayList<String> cyT;
    public ArrayList<String> cyU;
    public ArrayList<String> cyV;
    public ArrayList<String> cyW;
    public ArrayList<String> cyX;
    public boolean cyY;
    public int cyZ;
    public boolean cyp;
    public int cza;
    public int czb;
    public long czc;
    public AppBrandGlobalSystemConfig czd;
    public String[] cze;
    public long czf;

    public AppBrandSysConfigLU() {
        AppMethodBeat.i(146705);
        this.cyC = false;
        this.cyD = false;
        this.cyE = false;
        this.cyF = false;
        this.cyp = false;
        this.czc = 0;
        this.cze = new String[0];
        AppMethodBeat.o(146705);
    }

    public String toString() {
        AppMethodBeat.i(146706);
        String str = "AppBrandSysConfigLU{, brandName='" + this.brandName + '\'' + ", appId='" + this.appId + '\'' + ", appIconUrl='" + this.jyi + '\'' + ", debugEnabled=" + this.cyC + ", performancePanelEnabled=" + this.cyD + ", maxWebViewDepth=" + this.lex + ", maxBackgroundLifeSpan=" + this.cyJ + ", maxRequestConcurrent=" + this.cyK + ", maxUploadConcurrent=" + this.cyL + ", maxDownloadConcurrent=" + this.cyM + ", maxWebsocketConnect=" + this.cyN + ", websocketSkipPortCheck=" + this.cyP + ", requestDomains=" + this.cyT + ", socketDomains=" + this.cyU + ", uploadDomains=" + this.cyV + ", downloadDomains=" + this.cyW + ", downloadDomains=" + this.cyX + ", appPkgInfo=" + this.leE + ", systemSettings=" + this.czd + ", runningFlag=" + this.czf + ", operationInfo=" + this.cyI + ", kvStorageScheme=" + this.leF + ", TLSSkipHostnameCheck=" + this.cyQ + ", kvStoragePerformanceReportOn=" + this.leG + ", pluginPermissionBundleMap=" + (this.cyH == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : String.valueOf(this.cyH.size())) + '}';
        AppMethodBeat.o(146706);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        int i3;
        int i4;
        int i5;
        int i6 = 1;
        AppMethodBeat.i(146707);
        parcel.writeString(this.brandName);
        parcel.writeString(this.cyB);
        parcel.writeString(this.appId);
        parcel.writeString(this.jyi);
        parcel.writeByte(this.cyC ? (byte) 1 : 0);
        if (this.cyD) {
            b2 = 1;
        } else {
            b2 = 0;
        }
        parcel.writeByte(b2);
        if (this.cyE) {
            b3 = 1;
        } else {
            b3 = 0;
        }
        parcel.writeByte(b3);
        parcel.writeParcelable(this.cyG, i2);
        parcel.writeInt(this.lex);
        parcel.writeInt(this.cyJ);
        parcel.writeInt(this.cyK);
        parcel.writeInt(this.cyL);
        parcel.writeInt(this.cyM);
        parcel.writeInt(this.cyN);
        parcel.writeInt(this.cyO);
        if (this.cyP) {
            b4 = 1;
        } else {
            b4 = 0;
        }
        parcel.writeByte(b4);
        if (this.cyQ) {
            b5 = 1;
        } else {
            b5 = 0;
        }
        parcel.writeByte(b5);
        parcel.writeLong(this.cyR);
        parcel.writeInt(this.cyS);
        parcel.writeStringList(this.cyT);
        parcel.writeStringList(this.cyU);
        parcel.writeStringList(this.cyV);
        parcel.writeStringList(this.cyW);
        parcel.writeStringList(this.cyX);
        parcel.writeParcelable(this.leE, i2);
        parcel.writeParcelable(this.czd, i2);
        parcel.writeByte(this.ley ? (byte) 1 : 0);
        if (this.lez) {
            b6 = 1;
        } else {
            b6 = 0;
        }
        parcel.writeByte(b6);
        parcel.writeInt(this.leC);
        parcel.writeInt(this.leD);
        parcel.writeInt(this.cyZ);
        if (this.cyY) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeLong(this.czc);
        parcel.writeString(this.cyI);
        parcel.writeInt(this.cze.length);
        parcel.writeStringArray(this.cze);
        parcel.writeInt(this.cza);
        parcel.writeInt(this.czb);
        parcel.writeInt(this.leF);
        if (this.leG) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        parcel.writeInt(i4);
        if (this.leA) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        parcel.writeInt(i5);
        if (!this.leB) {
            i6 = 0;
        }
        parcel.writeInt(i6);
        parcel.writeLong(this.czf);
        parcel.writeMap(this.cyH);
        AppMethodBeat.o(146707);
    }

    protected AppBrandSysConfigLU(Parcel parcel) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9 = true;
        AppMethodBeat.i(146708);
        this.cyC = false;
        this.cyD = false;
        this.cyE = false;
        this.cyF = false;
        this.cyp = false;
        this.czc = 0;
        this.cze = new String[0];
        this.brandName = parcel.readString();
        this.cyB = parcel.readString();
        this.appId = parcel.readString();
        this.jyi = parcel.readString();
        this.cyC = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.cyD = z;
        if (parcel.readByte() != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.cyE = z2;
        this.cyG = (AppRuntimeApiPermissionBundle) parcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader());
        this.lex = parcel.readInt();
        this.cyJ = parcel.readInt();
        this.cyK = parcel.readInt();
        this.cyL = parcel.readInt();
        this.cyM = parcel.readInt();
        this.cyN = parcel.readInt();
        this.cyO = parcel.readInt();
        if (parcel.readByte() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.cyP = z3;
        if (parcel.readByte() != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.cyQ = z4;
        this.cyR = parcel.readLong();
        this.cyS = parcel.readInt();
        this.cyT = parcel.createStringArrayList();
        this.cyU = parcel.createStringArrayList();
        this.cyV = parcel.createStringArrayList();
        this.cyW = parcel.createStringArrayList();
        this.cyX = parcel.createStringArrayList();
        this.leE = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
        this.czd = (AppBrandGlobalSystemConfig) parcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader());
        this.ley = parcel.readByte() > 0;
        if (parcel.readByte() > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.lez = z5;
        this.leC = parcel.readInt();
        this.leD = parcel.readInt();
        this.cyZ = parcel.readInt();
        if (parcel.readInt() == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.cyY = z6;
        this.czc = parcel.readLong();
        this.cyI = parcel.readString();
        this.cze = new String[parcel.readInt()];
        parcel.readStringArray(this.cze);
        this.cza = parcel.readInt();
        this.czb = parcel.readInt();
        this.leF = parcel.readInt();
        if (parcel.readInt() == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.leG = z7;
        if (parcel.readInt() == 1) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.leA = z8;
        this.leB = parcel.readInt() != 1 ? false : z9;
        this.czf = parcel.readLong();
        this.cyH = parcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
        AppMethodBeat.o(146708);
    }

    static {
        AppMethodBeat.i(146709);
        AppMethodBeat.o(146709);
    }
}
