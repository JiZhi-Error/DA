package com.google.android.exoplayer2.source.dash.manifest;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RepresentationKey implements Parcelable, Comparable<RepresentationKey> {
    public static final Parcelable.Creator<RepresentationKey> CREATOR = new Parcelable.Creator<RepresentationKey>() {
        /* class com.google.android.exoplayer2.source.dash.manifest.RepresentationKey.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RepresentationKey[] newArray(int i2) {
            return new RepresentationKey[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RepresentationKey createFromParcel(Parcel parcel) {
            AppMethodBeat.i(10567);
            RepresentationKey representationKey = new RepresentationKey(parcel.readInt(), parcel.readInt(), parcel.readInt());
            AppMethodBeat.o(10567);
            return representationKey;
        }
    };
    public final int bwx;
    public final int bxq;
    public final int bxr;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(RepresentationKey representationKey) {
        RepresentationKey representationKey2 = representationKey;
        int i2 = this.bwx - representationKey2.bwx;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.bxq - representationKey2.bxq;
        return i3 == 0 ? this.bxr - representationKey2.bxr : i3;
    }

    public RepresentationKey(int i2, int i3, int i4) {
        this.bwx = i2;
        this.bxq = i3;
        this.bxr = i4;
    }

    public final String toString() {
        AppMethodBeat.i(10568);
        String str = this.bwx + "." + this.bxq + "." + this.bxr;
        AppMethodBeat.o(10568);
        return str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10569);
        parcel.writeInt(this.bwx);
        parcel.writeInt(this.bxq);
        parcel.writeInt(this.bxr);
        AppMethodBeat.o(10569);
    }

    static {
        AppMethodBeat.i(10570);
        AppMethodBeat.o(10570);
    }
}
