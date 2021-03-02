package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() {
        /* class androidx.versionedparcelable.ParcelImpl.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ParcelImpl[] newArray(int i2) {
            return new ParcelImpl[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ParcelImpl createFromParcel(Parcel parcel) {
            AppMethodBeat.i(62406);
            ParcelImpl parcelImpl = new ParcelImpl(parcel);
            AppMethodBeat.o(62406);
            return parcelImpl;
        }
    };
    private final c aBs;

    protected ParcelImpl(Parcel parcel) {
        AppMethodBeat.i(62407);
        this.aBs = new b(parcel).nA();
        AppMethodBeat.o(62407);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(62408);
        new b(parcel).b(this.aBs);
        AppMethodBeat.o(62408);
    }

    static {
        AppMethodBeat.i(62409);
        AppMethodBeat.o(62409);
    }
}
