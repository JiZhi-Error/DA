package com.tencent.mm.choosemsgfile.compat;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MsgFile implements Parcelable {
    public static final Parcelable.Creator<MsgFile> CREATOR = new Parcelable.Creator<MsgFile>() {
        /* class com.tencent.mm.choosemsgfile.compat.MsgFile.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MsgFile[] newArray(int i2) {
            return new MsgFile[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MsgFile createFromParcel(Parcel parcel) {
            AppMethodBeat.i(127507);
            MsgFile msgFile = new MsgFile(parcel);
            AppMethodBeat.o(127507);
            return msgFile;
        }
    };
    public String fileName;
    public String filePath;
    public int fileSize;
    public String gCr;
    public long timeStamp;
    public String type;

    public MsgFile() {
    }

    public String toString() {
        AppMethodBeat.i(127508);
        String str = "MsgFile{fileSize=" + this.fileSize + ", filePath='" + this.filePath + '\'' + ", fileName='" + this.fileName + '\'' + ", timeStamp=" + this.timeStamp + ", type='" + this.type + '\'' + ", fileExt='" + this.gCr + '\'' + '}';
        AppMethodBeat.o(127508);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(127509);
        parcel.writeInt(this.fileSize);
        parcel.writeString(this.filePath);
        parcel.writeString(this.fileName);
        parcel.writeLong(this.timeStamp);
        parcel.writeString(this.type);
        parcel.writeString(this.gCr);
        AppMethodBeat.o(127509);
    }

    protected MsgFile(Parcel parcel) {
        AppMethodBeat.i(127510);
        this.fileSize = parcel.readInt();
        this.filePath = parcel.readString();
        this.fileName = parcel.readString();
        this.timeStamp = parcel.readLong();
        this.type = parcel.readString();
        this.gCr = parcel.readString();
        AppMethodBeat.o(127510);
    }

    static {
        AppMethodBeat.i(127511);
        AppMethodBeat.o(127511);
    }
}
