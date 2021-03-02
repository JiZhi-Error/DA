package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FieldMappingDictionary;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class FieldMappingDictionaryEntryCreator implements Parcelable.Creator<FieldMappingDictionary.Entry> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public FieldMappingDictionary.Entry createFromParcel(Parcel parcel) {
        AppMethodBeat.i(12070);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        ArrayList arrayList = null;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, FieldMappingDictionary.FieldMapPair.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        FieldMappingDictionary.Entry entry = new FieldMappingDictionary.Entry(i2, str, arrayList);
        AppMethodBeat.o(12070);
        return entry;
    }

    @Override // android.os.Parcelable.Creator
    public FieldMappingDictionary.Entry[] newArray(int i2) {
        return new FieldMappingDictionary.Entry[i2];
    }
}
