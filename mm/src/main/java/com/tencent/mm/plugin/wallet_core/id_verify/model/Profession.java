package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Profession implements Parcelable {
    public static final Parcelable.Creator<Profession> CREATOR = new Parcelable.Creator<Profession>() {
        /* class com.tencent.mm.plugin.wallet_core.id_verify.model.Profession.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Profession[] newArray(int i2) {
            return new Profession[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Profession createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70160);
            Profession profession = new Profession(parcel);
            AppMethodBeat.o(70160);
            return profession;
        }
    };
    public String HTX;
    public int HTY;

    public Profession(String str, int i2) {
        this.HTX = str;
        this.HTY = i2;
    }

    protected Profession(Parcel parcel) {
        AppMethodBeat.i(70161);
        this.HTX = parcel.readString();
        this.HTY = parcel.readInt();
        AppMethodBeat.o(70161);
    }

    static {
        AppMethodBeat.i(70163);
        AppMethodBeat.o(70163);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70162);
        parcel.writeString(this.HTX);
        parcel.writeInt(this.HTY);
        AppMethodBeat.o(70162);
    }
}
