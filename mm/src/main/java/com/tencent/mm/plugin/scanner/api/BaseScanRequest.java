package com.tencent.mm.plugin.scanner.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BaseScanRequest implements Parcelable {
    public static final Parcelable.Creator<BaseScanRequest> CREATOR = new Parcelable.Creator<BaseScanRequest>() {
        /* class com.tencent.mm.plugin.scanner.api.BaseScanRequest.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BaseScanRequest[] newArray(int i2) {
            return new BaseScanRequest[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BaseScanRequest createFromParcel(Parcel parcel) {
            AppMethodBeat.i(224186);
            BaseScanRequest baseScanRequest = new BaseScanRequest(parcel);
            AppMethodBeat.o(224186);
            return baseScanRequest;
        }
    };
    public boolean CAE = false;
    public boolean CAF = false;
    public boolean CAG = false;
    public boolean CAH = true;
    public boolean CAI = true;
    private Bundle CAJ;

    public BaseScanRequest() {
    }

    public final void putExtra(String str, String str2) {
        AppMethodBeat.i(224187);
        if (this.CAJ == null) {
            this.CAJ = new Bundle();
        }
        this.CAJ.putString(str, str2);
        AppMethodBeat.o(224187);
    }

    public final String getExtra(String str, String str2) {
        AppMethodBeat.i(224188);
        if (this.CAJ != null) {
            String string = this.CAJ.getString(str, str2);
            AppMethodBeat.o(224188);
            return string;
        }
        AppMethodBeat.o(224188);
        return str2;
    }

    public BaseScanRequest(Parcel parcel) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        AppMethodBeat.i(224189);
        this.CAE = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.CAF = z;
        if (parcel.readByte() != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.CAG = z2;
        if (parcel.readByte() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.CAH = z3;
        this.CAI = parcel.readByte() == 0 ? false : z4;
        this.CAJ = parcel.readBundle();
        AppMethodBeat.o(224189);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = 1;
        AppMethodBeat.i(224190);
        parcel.writeByte((byte) (this.CAE ? 1 : 0));
        if (this.CAF) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        if (this.CAG) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        parcel.writeByte((byte) i4);
        if (this.CAH) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        parcel.writeByte((byte) i5);
        if (!this.CAI) {
            i6 = 0;
        }
        parcel.writeByte((byte) i6);
        parcel.writeBundle(this.CAJ);
        AppMethodBeat.o(224190);
    }

    public String toString() {
        AppMethodBeat.i(224191);
        String format = String.format("BaseScanRequest{hideBottomTab: %b, hideScanTips: %b, hideFlashSwitcher: %b, hideGalleryButton: %b, hideOptionMenu: %b}", Boolean.valueOf(this.CAE), Boolean.valueOf(this.CAF), Boolean.valueOf(this.CAG), Boolean.valueOf(this.CAH), Boolean.valueOf(this.CAI));
        AppMethodBeat.o(224191);
        return format;
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(224192);
        AppMethodBeat.o(224192);
    }
}
