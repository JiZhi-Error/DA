package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DownloadBigPkgCompleteNotify implements Parcelable {
    public static final Parcelable.Creator<DownloadBigPkgCompleteNotify> CREATOR = new Parcelable.Creator<DownloadBigPkgCompleteNotify>() {
        /* class com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DownloadBigPkgCompleteNotify[] newArray(int i2) {
            return new DownloadBigPkgCompleteNotify[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DownloadBigPkgCompleteNotify createFromParcel(Parcel parcel) {
            AppMethodBeat.i(110627);
            DownloadBigPkgCompleteNotify downloadBigPkgCompleteNotify = new DownloadBigPkgCompleteNotify(parcel, (byte) 0);
            AppMethodBeat.o(110627);
            return downloadBigPkgCompleteNotify;
        }
    };
    public boolean JML;
    public String hhD;
    public boolean success;

    /* synthetic */ DownloadBigPkgCompleteNotify(Parcel parcel, byte b2) {
        this(parcel);
    }

    public DownloadBigPkgCompleteNotify(String str, boolean z, boolean z2) {
        this.hhD = str;
        this.success = z;
        this.JML = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(110628);
        parcel.writeString(this.hhD);
        if (this.success) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (!this.JML) {
            i4 = 0;
        }
        parcel.writeInt(i4);
        AppMethodBeat.o(110628);
    }

    private DownloadBigPkgCompleteNotify(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(110629);
        this.hhD = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.success = z;
        this.JML = parcel.readInt() != 1 ? false : z2;
        AppMethodBeat.o(110629);
    }

    static {
        AppMethodBeat.i(110630);
        AppMethodBeat.o(110630);
    }
}
