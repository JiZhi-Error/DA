package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class WakeLockEventCreator implements Parcelable.Creator<WakeLockEvent> {
    public static final int CONTENT_DESCRIPTION = 0;

    @Override // android.os.Parcelable.Creator
    public WakeLockEvent createFromParcel(Parcel parcel) {
        AppMethodBeat.i(5003);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        long j2 = 0;
        int i3 = 0;
        String str = null;
        int i4 = 0;
        ArrayList<String> arrayList = null;
        String str2 = null;
        long j3 = 0;
        int i5 = 0;
        String str3 = null;
        String str4 = null;
        float f2 = 0.0f;
        long j4 = 0;
        String str5 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 8:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 10:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 11:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 12:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 14:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 15:
                    f2 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 16:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 17:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        WakeLockEvent wakeLockEvent = new WakeLockEvent(i2, j2, i3, str, i4, arrayList, str2, j3, i5, str3, str4, f2, j4, str5);
        AppMethodBeat.o(5003);
        return wakeLockEvent;
    }

    @Override // android.os.Parcelable.Creator
    public WakeLockEvent[] newArray(int i2) {
        return new WakeLockEvent[i2];
    }
}
