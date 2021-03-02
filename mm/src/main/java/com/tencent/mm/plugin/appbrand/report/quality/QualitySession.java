package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;

public class QualitySession implements Parcelable {
    public static final Parcelable.Creator<QualitySession> CREATOR = new Parcelable.Creator<QualitySession>() {
        /* class com.tencent.mm.plugin.appbrand.report.quality.QualitySession.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ QualitySession[] newArray(int i2) {
            return new QualitySession[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ QualitySession createFromParcel(Parcel parcel) {
            AppMethodBeat.i(48225);
            QualitySession qualitySession = new QualitySession(parcel);
            AppMethodBeat.o(48225);
            return qualitySession;
        }
    };
    public String appId;
    public int apptype;
    public final String kEY;
    public int nJE;
    public int nLk;
    public long nLl = 0;
    public boolean nLm = false;
    public int scene;

    public QualitySession(String str, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(48226);
        this.kEY = str;
        this.appId = appBrandInitConfigWC.appId;
        switch (appBrandInitConfigWC.eix) {
            case 0:
                this.nJE = 1;
                break;
            case 1:
                this.nJE = 2;
                break;
            case 2:
                this.nJE = 3;
                break;
        }
        this.apptype = appBrandInitConfigWC.cyo + 1000;
        this.scene = appBrandStatObject.scene;
        this.nLk = appBrandInitConfigWC.appVersion;
        Log.i("MicroMsg.AppBrand.QualitySession", "primary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d]", this.kEY, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.nLk));
        AppMethodBeat.o(48226);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(48227);
        parcel.writeString(this.kEY);
        parcel.writeString(this.appId);
        parcel.writeInt(this.nJE);
        parcel.writeInt(this.apptype);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.nLk);
        parcel.writeLong(this.nLl);
        parcel.writeByte((byte) (this.nLm ? 1 : 0));
        AppMethodBeat.o(48227);
    }

    protected QualitySession(Parcel parcel) {
        boolean z;
        AppMethodBeat.i(48228);
        this.kEY = parcel.readString();
        this.appId = parcel.readString();
        this.nJE = parcel.readInt();
        this.apptype = parcel.readInt();
        this.scene = parcel.readInt();
        this.nLk = parcel.readInt();
        this.nLl = parcel.readLong();
        if (parcel.readByte() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.nLm = z;
        Log.i("MicroMsg.AppBrand.QualitySession", "secondary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d] UIReadyT[%d] isNewUser[%b]", this.kEY, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.nLk), Long.valueOf(this.nLl), Boolean.valueOf(this.nLm));
        AppMethodBeat.o(48228);
    }

    static {
        AppMethodBeat.i(48229);
        AppMethodBeat.o(48229);
    }
}
