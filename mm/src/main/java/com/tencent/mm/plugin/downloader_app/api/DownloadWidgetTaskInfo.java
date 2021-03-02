package com.tencent.mm.plugin.downloader_app.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DownloadWidgetTaskInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadWidgetTaskInfo> CREATOR = new Parcelable.Creator<DownloadWidgetTaskInfo>() {
        /* class com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DownloadWidgetTaskInfo[] newArray(int i2) {
            return new DownloadWidgetTaskInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DownloadWidgetTaskInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(175248);
            DownloadWidgetTaskInfo downloadWidgetTaskInfo = new DownloadWidgetTaskInfo(parcel, (byte) 0);
            AppMethodBeat.o(175248);
            return downloadWidgetTaskInfo;
        }
    };
    public String appId;
    public long dCa;
    public float lCT;
    public String pJC;
    public int progress;
    public boolean qJh;
    public int state;

    /* synthetic */ DownloadWidgetTaskInfo(Parcel parcel, byte b2) {
        this(parcel);
    }

    public DownloadWidgetTaskInfo() {
    }

    private DownloadWidgetTaskInfo(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(175249);
        this.appId = parcel.readString();
        this.dCa = parcel.readLong();
        this.pJC = parcel.readString();
        this.progress = parcel.readInt();
        this.qJh = parcel.readInt() != 1 ? false : z;
        this.lCT = parcel.readFloat();
        this.state = parcel.readInt();
        AppMethodBeat.o(175249);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(175250);
        parcel.writeString(this.appId);
        parcel.writeLong(this.dCa);
        parcel.writeString(this.pJC);
        parcel.writeInt(this.progress);
        parcel.writeInt(this.qJh ? 1 : 0);
        parcel.writeFloat(this.lCT);
        parcel.writeInt(this.state);
        AppMethodBeat.o(175250);
    }

    static {
        AppMethodBeat.i(175251);
        AppMethodBeat.o(175251);
    }
}
