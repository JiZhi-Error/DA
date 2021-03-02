package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class Snack implements Parcelable {
    public static final Parcelable.Creator<Snack> CREATOR = new Parcelable.Creator<Snack>() {
        /* class com.tencent.mm.ui.widget.snackbar.Snack.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Snack[] newArray(int i2) {
            return new Snack[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Snack createFromParcel(Parcel parcel) {
            AppMethodBeat.i(159696);
            Snack snack = new Snack(parcel);
            AppMethodBeat.o(159696);
            return snack;
        }
    };
    final String QVo;
    final int QVp;
    final Parcelable QVq;
    final short QVr;
    final int QVs;
    final String mMessage;

    static {
        AppMethodBeat.i(159699);
        AppMethodBeat.o(159699);
    }

    Snack(String str, String str2, int i2, Parcelable parcelable, short s, int i3) {
        this.mMessage = str;
        this.QVo = str2;
        this.QVp = i2;
        this.QVq = parcelable;
        this.QVr = s;
        this.QVs = i3;
    }

    Snack(Parcel parcel) {
        AppMethodBeat.i(159697);
        this.mMessage = parcel.readString();
        this.QVo = parcel.readString();
        this.QVp = parcel.readInt();
        this.QVq = parcel.readParcelable(parcel.getClass().getClassLoader());
        this.QVr = (short) parcel.readInt();
        this.QVs = parcel.readInt();
        AppMethodBeat.o(159697);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(159698);
        parcel.writeString(this.mMessage);
        parcel.writeString(this.QVo);
        parcel.writeInt(this.QVp);
        parcel.writeParcelable(this.QVq, 0);
        parcel.writeInt(this.QVr);
        parcel.writeInt(this.QVs);
        AppMethodBeat.o(159698);
    }

    public int describeContents() {
        return 0;
    }
}
