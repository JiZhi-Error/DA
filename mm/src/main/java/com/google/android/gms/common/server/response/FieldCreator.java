package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FieldCreator implements Parcelable.Creator<FastJsonResponse.Field> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public FastJsonResponse.Field createFromParcel(Parcel parcel) {
        AppMethodBeat.i(12045);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ConverterWrapper converterWrapper = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) SafeParcelReader.createParcelable(parcel, readHeader, ConverterWrapper.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        FastJsonResponse.Field field = new FastJsonResponse.Field(i5, i4, z2, i3, z, str2, i2, str, converterWrapper);
        AppMethodBeat.o(12045);
        return field;
    }

    @Override // android.os.Parcelable.Creator
    public FastJsonResponse.Field[] newArray(int i2) {
        return new FastJsonResponse.Field[i2];
    }
}
