package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import java.util.ArrayList;
import java.util.List;

public class AppBrandInitConfigWC extends AppBrandInitConfigLU implements Parcelable {
    public static final Parcelable.Creator<AppBrandInitConfigWC> CREATOR = new Parcelable.Creator<AppBrandInitConfigWC>() {
        /* class com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandInitConfigWC[] newArray(int i2) {
            return new AppBrandInitConfigWC[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandInitConfigWC createFromParcel(Parcel parcel) {
            AppMethodBeat.i(44833);
            AppBrandInitConfigWC appBrandInitConfigWC = new AppBrandInitConfigWC(parcel);
            AppMethodBeat.o(44833);
            return appBrandInitConfigWC;
        }
    };
    public String kHG;
    public String kHH;
    public AppBrandLaunchFromNotifyReferrer kHI;
    public List<String> kHK = new ArrayList();
    public HalfScreenConfig kHL = HalfScreenConfig.lfr;
    public boolean kHM = false;
    public ParcelableMultiTaskData kHP = null;
    public String kHQ = "";
    public int launchMode;
    public boolean ldN;
    public long ldO;
    public String ldP;
    public PersistableBundle ldQ = new PersistableBundle();
    public String ldR;
    public String ldS;
    public String ldT;
    public boolean ldU = false;
    public WebRenderingCacheDirectoryDescriptor ldV;
    public volatile QualitySession ldW;
    public transient int ldX;
    public boolean ldY;
    public int ldZ;
    public String lea;
    public int leb;
    public int lec;
    public boolean led = false;
    public WeAppOpenDeclarePromptBundle lee;
    public AppBrandRuntimeReloadReportBundle lef;
    public boolean leg = false;
    public WeAppOpenUICallbackIPCProxy leh;
    public boolean lei = false;

    @Override // com.tencent.luggage.sdk.config.AppBrandInitConfigLU
    public final /* synthetic */ AppBrandInitConfigLU NG() {
        AppMethodBeat.i(44840);
        AppBrandInitConfigWC bzU = bzU();
        AppMethodBeat.o(44840);
        return bzU;
    }

    @Override // com.tencent.luggage.sdk.config.AppBrandInitConfigLU, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig
    public final /* synthetic */ AppBrandInitConfig NH() {
        AppMethodBeat.i(44841);
        AppBrandInitConfigWC bzU = bzU();
        AppMethodBeat.o(44841);
        return bzU;
    }

    @Override // com.tencent.luggage.sdk.config.AppBrandInitConfigLU, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig, java.lang.Object
    public /* synthetic */ Object clone() {
        AppMethodBeat.i(44842);
        AppBrandInitConfigWC bzU = bzU();
        AppMethodBeat.o(44842);
        return bzU;
    }

    @Override // com.tencent.luggage.sdk.config.AppBrandInitConfigLU
    public final boolean NA() {
        return this.cyo == 4;
    }

    public AppBrandInitConfigWC() {
        AppMethodBeat.i(44834);
        AppMethodBeat.o(44834);
    }

    @Override // com.tencent.luggage.sdk.config.AppBrandInitConfigLU
    public String toString() {
        AppMethodBeat.i(44835);
        String str = "AppBrandInitConfigWC {visitingSessionId='" + this.cym + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.brandName + '\'' + ", debugType=" + this.eix + ", uin=" + p.getString(this.uin) + ", isPluginApp=" + this.ldN + ", isAdContact=" + this.ldY + ", performanceValue=" + this.ldZ + ", orientation='" + this.cBG + '\'' + ", enterPath='" + this.kHw + '\'' + ", shareName='" + this.cyq + '\'' + ", shareKey='" + this.cyr + '\'' + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.cyy + ", referrer=" + this.cys + ", extInfo=" + this.extInfo + ", appVersion=" + this.appVersion + ", launchMode=" + this.launchMode + "， triggerServiceName=" + this.ldT + "， createdAsHalfScreen=" + this.leg + ", halfScreenConfig=" + this.kHL + '}';
        AppMethodBeat.o(44835);
        return str;
    }

    public final AppBrandInitConfigWC bzU() {
        AppMethodBeat.i(44836);
        Parcel bzR = bzR();
        AppBrandInitConfigWC appBrandInitConfigWC = new AppBrandInitConfigWC(bzR);
        bzR.recycle();
        AppMethodBeat.o(44836);
        return appBrandInitConfigWC;
    }

    @Override // com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig
    public final Parcel bzR() {
        AppMethodBeat.i(44837);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        AppMethodBeat.o(44837);
        return obtain;
    }

    @Override // com.tencent.luggage.sdk.config.AppBrandInitConfigLU, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig
    public void writeToParcel(Parcel parcel, int i2) {
        byte b2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 1;
        AppMethodBeat.i(44838);
        super.writeToParcel(parcel, i2);
        parcel.writeByte(this.ldN ? (byte) 1 : 0);
        if (this.ldY) {
            b2 = 1;
        } else {
            b2 = 0;
        }
        parcel.writeByte(b2);
        parcel.writeInt(this.ldZ);
        parcel.writeLong(this.ldO);
        parcel.writeString(this.ldP);
        parcel.writeParcelable(this.ldW, i2);
        parcel.writeString(this.ldR);
        parcel.writePersistableBundle(this.ldQ);
        parcel.writeString(this.ldS);
        if (this.ldU) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.ldT);
        parcel.writeParcelable(this.ldV, i2);
        parcel.writeString(this.kHG);
        parcel.writeInt(this.launchMode);
        parcel.writeString(this.kHH);
        parcel.writeParcelable(this.kHI, i2);
        parcel.writeString(this.lea);
        parcel.writeInt(this.leb);
        parcel.writeInt(this.lec);
        if (this.led) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        parcel.writeByte((byte) i4);
        parcel.writeParcelable(this.lee, i2);
        parcel.writeParcelable(this.lef, i2);
        parcel.writeStringList(this.kHK);
        parcel.writeParcelable(this.kHL, i2);
        if (this.leg) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        parcel.writeByte((byte) i5);
        if (this.kHM) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        parcel.writeByte((byte) i6);
        parcel.writeParcelable(this.leh, i2);
        if (!this.lei) {
            i7 = 0;
        }
        parcel.writeByte((byte) i7);
        parcel.writeString(this.kHQ);
        parcel.writeParcelable(this.kHP, i2);
        AppMethodBeat.o(44838);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected AppBrandInitConfigWC(Parcel parcel) {
        super(parcel);
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = true;
        AppMethodBeat.i(44839);
        this.ldN = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.ldY = z;
        this.ldZ = parcel.readInt();
        this.ldO = parcel.readLong();
        this.ldP = parcel.readString();
        this.ldW = (QualitySession) parcel.readParcelable(QualitySession.class.getClassLoader());
        this.ldR = parcel.readString();
        this.ldQ = parcel.readPersistableBundle(AppBrandInitConfigWC.class.getClassLoader());
        this.ldS = parcel.readString();
        if (parcel.readByte() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.ldU = z2;
        this.ldT = parcel.readString();
        this.ldV = (WebRenderingCacheDirectoryDescriptor) parcel.readParcelable(WebRenderingCacheDirectoryDescriptor.class.getClassLoader());
        this.kHG = parcel.readString();
        this.launchMode = parcel.readInt();
        this.kHH = parcel.readString();
        this.kHI = (AppBrandLaunchFromNotifyReferrer) parcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader());
        this.lea = parcel.readString();
        this.leb = parcel.readInt();
        this.lec = parcel.readInt();
        if (parcel.readByte() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.led = z3;
        this.lee = (WeAppOpenDeclarePromptBundle) parcel.readParcelable(WeAppOpenDeclarePromptBundle.class.getClassLoader());
        this.lef = (AppBrandRuntimeReloadReportBundle) parcel.readParcelable(AppBrandRuntimeReloadReportBundle.class.getClassLoader());
        parcel.readStringList(this.kHK);
        HalfScreenConfig halfScreenConfig = (HalfScreenConfig) parcel.readParcelable(HalfScreenConfig.class.getClassLoader());
        this.kHL = halfScreenConfig == null ? HalfScreenConfig.lfr : halfScreenConfig;
        if (parcel.readByte() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.leg = z4;
        if (parcel.readByte() > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.kHM = z5;
        this.leh = (WeAppOpenUICallbackIPCProxy) parcel.readParcelable(WeAppOpenUICallbackIPCProxy.class.getClassLoader());
        this.lei = parcel.readByte() <= 0 ? false : z6;
        this.kHQ = parcel.readString();
        this.kHP = (ParcelableMultiTaskData) parcel.readParcelable(ParcelableMultiTaskData.class.getClassLoader());
        AppMethodBeat.o(44839);
    }

    static {
        AppMethodBeat.i(44843);
        AppMethodBeat.o(44843);
    }
}
