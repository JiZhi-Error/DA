package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataHolderCreator implements Parcelable.Creator<DataHolder> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public DataHolder createFromParcel(Parcel parcel) {
        AppMethodBeat.i(11615);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundle = null;
        int i2 = 0;
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    strArr = SafeParcelReader.createStringArray(parcel, readHeader);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) SafeParcelReader.createTypedArray(parcel, readHeader, CursorWindow.CREATOR);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 1000:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        DataHolder dataHolder = new DataHolder(i3, strArr, cursorWindowArr, i2, bundle);
        dataHolder.validateContents();
        AppMethodBeat.o(11615);
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public DataHolder[] newArray(int i2) {
        return new DataHolder[i2];
    }
}
