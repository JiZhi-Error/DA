package com.tencent.mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CDNTaskState implements Parcelable {
    public static final Parcelable.Creator<CDNTaskState> CREATOR = new Parcelable.Creator<CDNTaskState>() {
        /* class com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CDNTaskState[] newArray(int i2) {
            return new CDNTaskState[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CDNTaskState createFromParcel(Parcel parcel) {
            AppMethodBeat.i(120761);
            CDNTaskState cDNTaskState = new CDNTaskState();
            cDNTaskState.taskState = parcel.readInt();
            cDNTaskState.completeSize = parcel.readLong();
            cDNTaskState.fileTotalSize = parcel.readLong();
            AppMethodBeat.o(120761);
            return cDNTaskState;
        }
    };
    public long completeSize = 0;
    public long fileTotalSize = 0;
    public int taskState = -100;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(120762);
        parcel.writeInt(this.taskState);
        parcel.writeLong(this.completeSize);
        parcel.writeLong(this.fileTotalSize);
        AppMethodBeat.o(120762);
    }

    static {
        AppMethodBeat.i(120763);
        AppMethodBeat.o(120763);
    }
}
