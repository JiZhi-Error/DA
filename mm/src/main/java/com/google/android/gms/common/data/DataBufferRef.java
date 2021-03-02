package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataBufferRef {
    protected final DataHolder mDataHolder;
    protected int mDataRow;
    private int zznj;

    public DataBufferRef(DataHolder dataHolder, int i2) {
        AppMethodBeat.i(11541);
        this.mDataHolder = (DataHolder) Preconditions.checkNotNull(dataHolder);
        setDataRow(i2);
        AppMethodBeat.o(11541);
    }

    /* access modifiers changed from: protected */
    public void copyToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        AppMethodBeat.i(11553);
        this.mDataHolder.copyToBuffer(str, this.mDataRow, this.zznj, charArrayBuffer);
        AppMethodBeat.o(11553);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(11556);
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (!Objects.equal(Integer.valueOf(dataBufferRef.mDataRow), Integer.valueOf(this.mDataRow)) || !Objects.equal(Integer.valueOf(dataBufferRef.zznj), Integer.valueOf(this.zznj)) || dataBufferRef.mDataHolder != this.mDataHolder) {
                AppMethodBeat.o(11556);
                return false;
            }
            AppMethodBeat.o(11556);
            return true;
        }
        AppMethodBeat.o(11556);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String str) {
        AppMethodBeat.i(11547);
        boolean z = this.mDataHolder.getBoolean(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(11547);
        return z;
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String str) {
        AppMethodBeat.i(11551);
        byte[] byteArray = this.mDataHolder.getByteArray(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(11551);
        return byteArray;
    }

    /* access modifiers changed from: protected */
    public int getDataRow() {
        return this.mDataRow;
    }

    /* access modifiers changed from: protected */
    public double getDouble(String str) {
        AppMethodBeat.i(11550);
        double d2 = this.mDataHolder.getDouble(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(11550);
        return d2;
    }

    /* access modifiers changed from: protected */
    public float getFloat(String str) {
        AppMethodBeat.i(11549);
        float f2 = this.mDataHolder.getFloat(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(11549);
        return f2;
    }

    /* access modifiers changed from: protected */
    public int getInteger(String str) {
        AppMethodBeat.i(11546);
        int integer = this.mDataHolder.getInteger(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(11546);
        return integer;
    }

    /* access modifiers changed from: protected */
    public long getLong(String str) {
        AppMethodBeat.i(11545);
        long j2 = this.mDataHolder.getLong(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(11545);
        return j2;
    }

    /* access modifiers changed from: protected */
    public String getString(String str) {
        AppMethodBeat.i(11548);
        String string = this.mDataHolder.getString(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(11548);
        return string;
    }

    public boolean hasColumn(String str) {
        AppMethodBeat.i(11544);
        boolean hasColumn = this.mDataHolder.hasColumn(str);
        AppMethodBeat.o(11544);
        return hasColumn;
    }

    /* access modifiers changed from: protected */
    public boolean hasNull(String str) {
        AppMethodBeat.i(11554);
        boolean hasNull = this.mDataHolder.hasNull(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(11554);
        return hasNull;
    }

    public int hashCode() {
        AppMethodBeat.i(11555);
        int hashCode = Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.zznj), this.mDataHolder);
        AppMethodBeat.o(11555);
        return hashCode;
    }

    public boolean isDataValid() {
        AppMethodBeat.i(11543);
        if (!this.mDataHolder.isClosed()) {
            AppMethodBeat.o(11543);
            return true;
        }
        AppMethodBeat.o(11543);
        return false;
    }

    /* access modifiers changed from: protected */
    public Uri parseUri(String str) {
        AppMethodBeat.i(11552);
        Uri parseUri = this.mDataHolder.parseUri(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(11552);
        return parseUri;
    }

    /* access modifiers changed from: protected */
    public void setDataRow(int i2) {
        AppMethodBeat.i(11542);
        Preconditions.checkState(i2 >= 0 && i2 < this.mDataHolder.getCount());
        this.mDataRow = i2;
        this.zznj = this.mDataHolder.getWindowIndex(this.mDataRow);
        AppMethodBeat.o(11542);
    }
}
