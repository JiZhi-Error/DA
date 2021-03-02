package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() {
        /* class com.google.android.exoplayer2.metadata.Metadata.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Metadata[] newArray(int i2) {
            return new Metadata[0];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Metadata createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92462);
            Metadata metadata = new Metadata(parcel);
            AppMethodBeat.o(92462);
            return metadata;
        }
    };
    public final Entry[] btX;

    public interface Entry extends Parcelable {
    }

    public Metadata(Entry... entryArr) {
        this.btX = entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        AppMethodBeat.i(92463);
        this.btX = new Entry[list.size()];
        list.toArray(this.btX);
        AppMethodBeat.o(92463);
    }

    Metadata(Parcel parcel) {
        AppMethodBeat.i(92464);
        this.btX = new Entry[parcel.readInt()];
        for (int i2 = 0; i2 < this.btX.length; i2++) {
            this.btX[i2] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
        }
        AppMethodBeat.o(92464);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92465);
        if (this == obj) {
            AppMethodBeat.o(92465);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92465);
            return false;
        } else {
            boolean equals = Arrays.equals(this.btX, ((Metadata) obj).btX);
            AppMethodBeat.o(92465);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(92466);
        int hashCode = Arrays.hashCode(this.btX);
        AppMethodBeat.o(92466);
        return hashCode;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92467);
        parcel.writeInt(this.btX.length);
        for (Entry entry : this.btX) {
            parcel.writeParcelable(entry, 0);
        }
        AppMethodBeat.o(92467);
    }

    static {
        AppMethodBeat.i(92468);
        AppMethodBeat.o(92468);
    }
}
