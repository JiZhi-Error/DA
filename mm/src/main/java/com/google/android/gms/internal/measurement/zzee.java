package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.biometric.FaceManager;

public final class zzee implements Parcelable.Creator<zzed> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzed createFromParcel(Parcel parcel) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_NO_FOCUS);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        zzjx zzjx = null;
        long j2 = 0;
        boolean z = false;
        String str3 = null;
        zzeu zzeu = null;
        long j3 = 0;
        zzeu zzeu2 = null;
        long j4 = 0;
        zzeu zzeu3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    zzjx = (zzjx) SafeParcelReader.createParcelable(parcel, readHeader, zzjx.CREATOR);
                    break;
                case 5:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 6:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    zzeu = (zzeu) SafeParcelReader.createParcelable(parcel, readHeader, zzeu.CREATOR);
                    break;
                case 9:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 10:
                    zzeu2 = (zzeu) SafeParcelReader.createParcelable(parcel, readHeader, zzeu.CREATOR);
                    break;
                case 11:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 12:
                    zzeu3 = (zzeu) SafeParcelReader.createParcelable(parcel, readHeader, zzeu.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzed zzed = new zzed(str, str2, zzjx, j2, z, str3, zzeu, j3, zzeu2, j4, zzeu3);
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_NO_FOCUS);
        return zzed;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzed[] newArray(int i2) {
        return new zzed[i2];
    }
}
