package com.tencent.mm.pluginsdk.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NfcAID implements Parcelable {
    public static final Parcelable.Creator<NfcAID> CREATOR = new Parcelable.Creator<NfcAID>() {
        /* class com.tencent.mm.pluginsdk.nfc.NfcAID.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ NfcAID[] newArray(int i2) {
            return new NfcAID[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ NfcAID createFromParcel(Parcel parcel) {
            AppMethodBeat.i(31135);
            NfcAID nfcAID = new NfcAID(parcel);
            AppMethodBeat.o(31135);
            return nfcAID;
        }
    };
    public String JXD = null;
    public String mURL = null;

    public int describeContents() {
        return 0;
    }

    public NfcAID(Parcel parcel) {
        AppMethodBeat.i(31136);
        this.JXD = parcel.readString();
        this.mURL = parcel.readString();
        AppMethodBeat.o(31136);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(31137);
        parcel.writeString(this.JXD);
        parcel.writeString(this.mURL);
        AppMethodBeat.o(31137);
    }

    static {
        AppMethodBeat.i(31138);
        AppMethodBeat.o(31138);
    }
}
