package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new Parcelable.Creator<ParcelableMMKV>() {
        /* class com.tencent.mmkv.ParcelableMMKV.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ParcelableMMKV[] newArray(int i2) {
            return new ParcelableMMKV[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ParcelableMMKV createFromParcel(Parcel parcel) {
            AppMethodBeat.i(13543);
            String readString = parcel.readString();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                AppMethodBeat.o(13543);
                return null;
            }
            ParcelableMMKV parcelableMMKV = new ParcelableMMKV(readString, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), readString2, (byte) 0);
            AppMethodBeat.o(13543);
            return parcelableMMKV;
        }
    };
    String RzG;
    int RzH;
    int RzI;
    String RzJ;

    /* synthetic */ ParcelableMMKV(String str, int i2, int i3, String str2, byte b2) {
        this(str, i2, i3, str2);
    }

    public ParcelableMMKV(MMKV mmkv) {
        AppMethodBeat.i(13544);
        this.RzH = -1;
        this.RzI = -1;
        this.RzJ = null;
        this.RzG = mmkv.mmapID();
        this.RzH = mmkv.ashmemFD();
        this.RzI = mmkv.ashmemMetaFD();
        this.RzJ = mmkv.cryptKey();
        AppMethodBeat.o(13544);
    }

    private ParcelableMMKV(String str, int i2, int i3, String str2) {
        this.RzH = -1;
        this.RzI = -1;
        this.RzJ = null;
        this.RzG = str;
        this.RzH = i2;
        this.RzI = i3;
        this.RzJ = str2;
    }

    public final int describeContents() {
        return 1;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(13545);
        try {
            parcel.writeString(this.RzG);
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.RzH);
            ParcelFileDescriptor fromFd2 = ParcelFileDescriptor.fromFd(this.RzI);
            int i3 = i2 | 1;
            fromFd.writeToParcel(parcel, i3);
            fromFd2.writeToParcel(parcel, i3);
            if (this.RzJ != null) {
                parcel.writeString(this.RzJ);
            }
            AppMethodBeat.o(13545);
        } catch (IOException e2) {
            AppMethodBeat.o(13545);
        }
    }

    static {
        AppMethodBeat.i(13546);
        AppMethodBeat.o(13546);
    }
}
