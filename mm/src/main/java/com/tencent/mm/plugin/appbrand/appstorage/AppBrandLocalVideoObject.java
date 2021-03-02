package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AppBrandLocalVideoObject extends AppBrandLocalMediaObject {
    public static final Parcelable.Creator<AppBrandLocalVideoObject> CREATOR = new Parcelable.Creator<AppBrandLocalVideoObject>() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandLocalVideoObject[] newArray(int i2) {
            return new AppBrandLocalVideoObject[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandLocalVideoObject createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134322);
            AppBrandLocalVideoObject appBrandLocalVideoObject = new AppBrandLocalVideoObject(parcel, (byte) 0);
            AppMethodBeat.o(134322);
            return appBrandLocalVideoObject;
        }
    };
    public int duration;
    public int height;
    public long size;
    public int width;

    /* synthetic */ AppBrandLocalVideoObject(Parcel parcel, byte b2) {
        this(parcel);
    }

    public AppBrandLocalVideoObject() {
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(134323);
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.duration);
        parcel.writeLong(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        AppMethodBeat.o(134323);
    }

    private AppBrandLocalVideoObject(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(134324);
        this.duration = parcel.readInt();
        this.size = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        AppMethodBeat.o(134324);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject
    public String toString() {
        AppMethodBeat.i(134325);
        String str = "AppBrandLocalVideoObject{duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + '}';
        AppMethodBeat.o(134325);
        return str;
    }

    static {
        AppMethodBeat.i(134326);
        AppMethodBeat.o(134326);
    }
}
