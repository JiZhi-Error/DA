package com.tencent.mm.plugin.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FileDownloadTaskInfo implements Parcelable {
    public static Parcelable.Creator<FileDownloadTaskInfo> CREATOR = new Parcelable.Creator<FileDownloadTaskInfo>() {
        /* class com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FileDownloadTaskInfo[] newArray(int i2) {
            return new FileDownloadTaskInfo[0];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FileDownloadTaskInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(89011);
            FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo(parcel, (byte) 0);
            AppMethodBeat.o(89011);
            return fileDownloadTaskInfo;
        }
    };
    public String appId;
    public int dNv;
    public long id;
    public String md5;
    public long oJj;
    public String path;
    public long qJe;
    public boolean qJf;
    public boolean qJg;
    public boolean qJh;
    public int status;
    public String url;

    /* synthetic */ FileDownloadTaskInfo(Parcel parcel, byte b2) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4;
        int i5 = 1;
        AppMethodBeat.i(89012);
        parcel.writeLong(this.id);
        parcel.writeString(this.url);
        parcel.writeInt(this.status);
        parcel.writeString(this.path);
        parcel.writeString(this.md5);
        parcel.writeString(this.appId);
        parcel.writeLong(this.qJe);
        parcel.writeLong(this.oJj);
        if (this.qJf) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.dNv);
        if (this.qJg) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        parcel.writeByte((byte) i4);
        if (!this.qJh) {
            i5 = 0;
        }
        parcel.writeByte((byte) i5);
        AppMethodBeat.o(89012);
    }

    public FileDownloadTaskInfo() {
        this.id = -1;
        this.url = "";
        this.status = 0;
        this.path = "";
        this.md5 = "";
        this.appId = "";
        this.qJe = 0;
        this.oJj = 0;
        this.qJf = false;
        this.dNv = 2;
        this.qJg = false;
        this.qJh = false;
    }

    private FileDownloadTaskInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(89013);
        this.id = -1;
        this.url = "";
        this.status = 0;
        this.path = "";
        this.md5 = "";
        this.appId = "";
        this.qJe = 0;
        this.oJj = 0;
        this.qJf = false;
        this.dNv = 2;
        this.qJg = false;
        this.qJh = false;
        this.id = parcel.readLong();
        this.url = parcel.readString();
        this.status = parcel.readInt();
        this.path = parcel.readString();
        this.md5 = parcel.readString();
        this.appId = parcel.readString();
        this.qJe = parcel.readLong();
        this.oJj = parcel.readLong();
        this.qJf = parcel.readByte() == 1;
        this.dNv = parcel.readInt();
        if (parcel.readByte() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.qJg = z;
        this.qJh = parcel.readByte() != 1 ? false : z2;
        AppMethodBeat.o(89013);
    }

    static {
        AppMethodBeat.i(89014);
        AppMethodBeat.o(89014);
    }
}
