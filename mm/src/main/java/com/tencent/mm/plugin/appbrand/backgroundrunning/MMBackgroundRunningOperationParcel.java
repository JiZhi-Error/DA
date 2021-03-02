package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMBackgroundRunningOperationParcel implements Parcelable {
    public static final Parcelable.Creator<MMBackgroundRunningOperationParcel> CREATOR = new Parcelable.Creator<MMBackgroundRunningOperationParcel>() {
        /* class com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MMBackgroundRunningOperationParcel[] newArray(int i2) {
            return new MMBackgroundRunningOperationParcel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MMBackgroundRunningOperationParcel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(153214);
            MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel(parcel);
            AppMethodBeat.o(153214);
            return mMBackgroundRunningOperationParcel;
        }
    };
    public String appId;
    public int beL;
    public int dDe;

    public MMBackgroundRunningOperationParcel() {
    }

    protected MMBackgroundRunningOperationParcel(Parcel parcel) {
        AppMethodBeat.i(153215);
        this.appId = parcel.readString();
        this.beL = parcel.readInt();
        this.dDe = parcel.readInt();
        AppMethodBeat.o(153215);
    }

    public String toString() {
        AppMethodBeat.i(153216);
        String str = "operation{appId='" + this.appId + '\'' + ", usage=" + this.beL + ", operation=" + this.dDe + '}';
        AppMethodBeat.o(153216);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(153217);
        parcel.writeString(this.appId);
        parcel.writeInt(this.beL);
        parcel.writeInt(this.dDe);
        AppMethodBeat.o(153217);
    }

    static {
        AppMethodBeat.i(153218);
        AppMethodBeat.o(153218);
    }
}
