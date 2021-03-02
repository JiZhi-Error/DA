package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SafeParcelResponseCreator implements Parcelable.Creator<SafeParcelResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public SafeParcelResponse createFromParcel(Parcel parcel) {
        AppMethodBeat.i(12115);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        FieldMappingDictionary fieldMappingDictionary = null;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    parcel2 = SafeParcelReader.createParcel(parcel, readHeader);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) SafeParcelReader.createParcelable(parcel, readHeader, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        SafeParcelResponse safeParcelResponse = new SafeParcelResponse(i2, parcel2, fieldMappingDictionary);
        AppMethodBeat.o(12115);
        return safeParcelResponse;
    }

    @Override // android.os.Parcelable.Creator
    public SafeParcelResponse[] newArray(int i2) {
        return new SafeParcelResponse[i2];
    }
}
