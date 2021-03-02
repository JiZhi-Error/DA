package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WePkgDiffInfo implements Parcelable {
    public static final Parcelable.Creator<WePkgDiffInfo> CREATOR = new Parcelable.Creator<WePkgDiffInfo>() {
        /* class com.tencent.mm.plugin.wepkg.model.WePkgDiffInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WePkgDiffInfo createFromParcel(Parcel parcel) {
            return null;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WePkgDiffInfo[] newArray(int i2) {
            return new WePkgDiffInfo[i2];
        }
    };
    public String JMY;
    public int JMZ;
    public String downloadUrl;
    public int fileSize;
    public String hhD;
    public String md5;
    public String oldVersion;
    public String version;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(110681);
        parcel.writeString(this.hhD);
        parcel.writeString(this.oldVersion);
        parcel.writeString(this.JMY);
        parcel.writeString(this.version);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.md5);
        parcel.writeInt(this.fileSize);
        parcel.writeInt(this.JMZ);
        AppMethodBeat.o(110681);
    }

    static {
        AppMethodBeat.i(110682);
        AppMethodBeat.o(110682);
    }
}
