package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

/* access modifiers changed from: package-private */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {
        /* class android.support.v4.app.FragmentManagerState.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FragmentManagerState[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }
    };
    FragmentState[] Gc;
    int[] Gd;
    BackStackState[] Ge;
    int Gf = -1;
    int mNextFragmentIndex;

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.Gc = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.Gd = parcel.createIntArray();
        this.Ge = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.Gf = parcel.readInt();
        this.mNextFragmentIndex = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedArray(this.Gc, i2);
        parcel.writeIntArray(this.Gd);
        parcel.writeTypedArray(this.Ge, i2);
        parcel.writeInt(this.Gf);
        parcel.writeInt(this.mNextFragmentIndex);
    }
}
