package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
        /* class android.support.v4.media.RatingCompat.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RatingCompat[] newArray(int i2) {
            return new RatingCompat[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }
    };
    private final int Ms;
    private final float Mt;

    RatingCompat(int i2, float f2) {
        this.Ms = i2;
        this.Mt = f2;
    }

    public final String toString() {
        String valueOf;
        StringBuilder append = new StringBuilder("Rating:style=").append(this.Ms).append(" rating=");
        if (this.Mt < 0.0f) {
            valueOf = "unrated";
        } else {
            valueOf = String.valueOf(this.Mt);
        }
        return append.append(valueOf).toString();
    }

    public final int describeContents() {
        return this.Ms;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.Ms);
        parcel.writeFloat(this.Mt);
    }
}
