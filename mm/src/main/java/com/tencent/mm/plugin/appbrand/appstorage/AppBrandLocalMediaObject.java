package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;

@Deprecated
public class AppBrandLocalMediaObject implements Parcelable, q.a {
    public static final Parcelable.Creator<AppBrandLocalMediaObject> CREATOR = new Parcelable.Creator<AppBrandLocalMediaObject>() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandLocalMediaObject[] newArray(int i2) {
            return new AppBrandLocalMediaObject[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandLocalMediaObject createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134299);
            AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject(parcel);
            AppMethodBeat.o(134299);
            return appBrandLocalMediaObject;
        }
    };
    public String dJX;
    public String gCr;
    public String iGf;
    public long jPY;
    public boolean kSa;
    public long kSb;
    public String mimeType;

    public String toString() {
        AppMethodBeat.i(134300);
        String str = "AppBrandLocalMediaObject{localId='" + this.dJX + '\'' + ", fileFullPath='" + this.iGf + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.gCr + '\'' + '}';
        AppMethodBeat.o(134300);
        return str;
    }

    protected AppBrandLocalMediaObject() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(134301);
        parcel.writeString(this.dJX);
        parcel.writeString(this.iGf);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.gCr);
        parcel.writeByte(this.kSa ? (byte) 1 : 0);
        parcel.writeLong(this.jPY);
        parcel.writeLong(this.kSb);
        AppMethodBeat.o(134301);
    }

    protected AppBrandLocalMediaObject(Parcel parcel) {
        AppMethodBeat.i(134302);
        this.dJX = parcel.readString();
        this.iGf = parcel.readString();
        this.mimeType = parcel.readString();
        this.gCr = parcel.readString();
        this.kSa = parcel.readByte() != 0;
        this.jPY = parcel.readLong();
        this.kSb = parcel.readLong();
        AppMethodBeat.o(134302);
    }

    static {
        AppMethodBeat.i(134303);
        AppMethodBeat.o(134303);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q.a
    public final String getFileName() {
        return this.dJX;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q.a
    public final long bxm() {
        return this.jPY;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q.a
    public final long lastModified() {
        return this.kSb;
    }
}
