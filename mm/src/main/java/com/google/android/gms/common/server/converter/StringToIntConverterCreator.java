package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class StringToIntConverterCreator implements Parcelable.Creator<StringToIntConverter> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public StringToIntConverter createFromParcel(Parcel parcel) {
        AppMethodBeat.i(11951);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, StringToIntConverter.Entry.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        StringToIntConverter stringToIntConverter = new StringToIntConverter(i2, arrayList);
        AppMethodBeat.o(11951);
        return stringToIntConverter;
    }

    @Override // android.os.Parcelable.Creator
    public StringToIntConverter[] newArray(int i2) {
        return new StringToIntConverter[i2];
    }
}
