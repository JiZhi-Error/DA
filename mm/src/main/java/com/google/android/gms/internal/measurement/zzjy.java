package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzjy implements Parcelable.Creator<zzjx> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjx createFromParcel(Parcel parcel) {
        AppMethodBeat.i(TXLiteAVCode.EVT_VOD_PLAY_SEEK_COMPLETE);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        long j2 = 0;
        Double d2 = null;
        String str = null;
        String str2 = null;
        Float f2 = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                    l = SafeParcelReader.readLongObject(parcel, readHeader);
                    break;
                case 5:
                    f2 = SafeParcelReader.readFloatObject(parcel, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    d2 = SafeParcelReader.readDoubleObject(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzjx zzjx = new zzjx(i2, str3, j2, l, f2, str2, str, d2);
        AppMethodBeat.o(TXLiteAVCode.EVT_VOD_PLAY_SEEK_COMPLETE);
        return zzjx;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjx[] newArray(int i2) {
        return new zzjx[i2];
    }
}
