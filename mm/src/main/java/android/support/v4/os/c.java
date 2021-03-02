package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class c {
    @Deprecated
    public static <T> Parcelable.Creator<T> a(d<T> dVar) {
        return new a(dVar);
    }

    static class a<T> implements Parcelable.ClassLoaderCreator<T> {
        private final d<T> No;

        a(d<T> dVar) {
            this.No = dVar;
        }

        @Override // android.os.Parcelable.Creator
        public final T createFromParcel(Parcel parcel) {
            return this.No.createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.No.createFromParcel(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public final T[] newArray(int i2) {
            return this.No.newArray(i2);
        }
    }
}
