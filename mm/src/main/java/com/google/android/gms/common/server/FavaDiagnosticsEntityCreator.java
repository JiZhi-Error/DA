package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FavaDiagnosticsEntityCreator implements Parcelable.Creator<FavaDiagnosticsEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public FavaDiagnosticsEntity createFromParcel(Parcel parcel) {
        AppMethodBeat.i(11930);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        FavaDiagnosticsEntity favaDiagnosticsEntity = new FavaDiagnosticsEntity(i3, str, i2);
        AppMethodBeat.o(11930);
        return favaDiagnosticsEntity;
    }

    @Override // android.os.Parcelable.Creator
    public FavaDiagnosticsEntity[] newArray(int i2) {
        return new FavaDiagnosticsEntity[i2];
    }
}
