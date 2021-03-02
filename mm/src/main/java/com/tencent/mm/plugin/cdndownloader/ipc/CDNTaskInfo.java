package com.tencent.mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CDNTaskInfo implements Parcelable {
    public static final Parcelable.Creator<CDNTaskInfo> CREATOR = new Parcelable.Creator<CDNTaskInfo>() {
        /* class com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CDNTaskInfo[] newArray(int i2) {
            return new CDNTaskInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CDNTaskInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(120755);
            CDNTaskInfo cDNTaskInfo = new CDNTaskInfo(parcel, (byte) 0);
            AppMethodBeat.o(120755);
            return cDNTaskInfo;
        }
    };
    public String downloadUrl;
    public String filePath;
    public boolean gqH;
    public String mediaId;
    public String qmH;
    public String qmI;
    public int qmJ;
    public int qmK;
    public boolean qmL;
    public boolean qmM;
    public boolean qmN;

    /* synthetic */ CDNTaskInfo(Parcel parcel, byte b2) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        byte b2;
        byte b3 = 1;
        AppMethodBeat.i(120756);
        parcel.writeByte(this.gqH ? (byte) 1 : 0);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.mediaId);
        parcel.writeString(this.filePath);
        parcel.writeString(this.qmH);
        parcel.writeString(this.qmI);
        parcel.writeInt(this.qmJ);
        parcel.writeInt(this.qmK);
        if (this.qmL) {
            b2 = 1;
        } else {
            b2 = 0;
        }
        parcel.writeByte(b2);
        if (!this.qmN) {
            b3 = 0;
        }
        parcel.writeByte(b3);
        AppMethodBeat.o(120756);
    }

    private CDNTaskInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(120757);
        this.gqH = parcel.readByte() == 1;
        this.downloadUrl = parcel.readString();
        this.mediaId = parcel.readString();
        this.filePath = parcel.readString();
        this.qmH = parcel.readString();
        this.qmI = parcel.readString();
        this.qmJ = parcel.readInt();
        this.qmK = parcel.readInt();
        if (parcel.readByte() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.qmL = z;
        this.qmN = parcel.readByte() != 1 ? false : z2;
        AppMethodBeat.o(120757);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(120758);
        if (obj == this || (obj != null && (obj instanceof CDNTaskInfo) && ((CDNTaskInfo) obj).downloadUrl.equals(this.downloadUrl))) {
            AppMethodBeat.o(120758);
            return true;
        }
        AppMethodBeat.o(120758);
        return false;
    }

    public int hashCode() {
        AppMethodBeat.i(120759);
        int hashCode = this.downloadUrl.hashCode();
        AppMethodBeat.o(120759);
        return hashCode;
    }

    public CDNTaskInfo() {
    }

    public CDNTaskInfo(String str) {
        this.downloadUrl = str;
    }

    static {
        AppMethodBeat.i(120760);
        AppMethodBeat.o(120760);
    }
}
