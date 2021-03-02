package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() {
        /* class android.support.v4.media.session.ParcelableVolumeInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ParcelableVolumeInfo[] newArray(int i2) {
            return new ParcelableVolumeInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }
    };
    public int MY;
    public int MZ;
    public int Na;
    public int Nb;
    public int Nc;

    public ParcelableVolumeInfo(Parcel parcel) {
        this.MY = parcel.readInt();
        this.Na = parcel.readInt();
        this.Nb = parcel.readInt();
        this.Nc = parcel.readInt();
        this.MZ = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.MY);
        parcel.writeInt(this.Na);
        parcel.writeInt(this.Nb);
        parcel.writeInt(this.Nc);
        parcel.writeInt(this.MZ);
    }
}
