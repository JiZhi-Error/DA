package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    public static final String DATA_FIELD = "data";
    private static final String[] zznk = {"data"};
    private final Parcelable.Creator<T> zznl;

    public DataBufferSafeParcelable(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.zznl = creator;
    }

    public static <T extends SafeParcelable> void addValue(DataHolder.Builder builder, T t) {
        AppMethodBeat.i(11558);
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        builder.withRow(contentValues);
        obtain.recycle();
        AppMethodBeat.o(11558);
    }

    public static DataHolder.Builder buildDataHolder() {
        AppMethodBeat.i(11557);
        DataHolder.Builder builder = DataHolder.builder(zznk);
        AppMethodBeat.o(11557);
        return builder;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer
    public T get(int i2) {
        AppMethodBeat.i(11559);
        byte[] byteArray = this.mDataHolder.getByteArray("data", i2, this.mDataHolder.getWindowIndex(i2));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        T createFromParcel = this.zznl.createFromParcel(obtain);
        obtain.recycle();
        AppMethodBeat.o(11559);
        return createFromParcel;
    }
}
