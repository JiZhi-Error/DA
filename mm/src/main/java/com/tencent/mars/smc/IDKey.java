package com.tencent.mars.smc;

import android.os.Parcel;
import android.os.Parcelable;

public class IDKey implements Parcelable {
    public static final Parcelable.Creator<IDKey> CREATOR = new Parcelable.Creator<IDKey>() {
        /* class com.tencent.mars.smc.IDKey.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final IDKey createFromParcel(Parcel parcel) {
            return new IDKey(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final IDKey[] newArray(int i2) {
            return new IDKey[i2];
        }
    };
    private long id;
    private long key;
    private long value;

    public IDKey(int i2, int i3, int i4) {
        this.id = (long) i2;
        this.key = (long) i3;
        this.value = (long) i4;
    }

    public IDKey(long j2, long j3, long j4) {
        this.id = j2;
        this.key = j3;
        this.value = j4;
    }

    public IDKey() {
        this.id = 0;
        this.key = 0;
        this.value = 0;
    }

    protected IDKey(Parcel parcel) {
        this.id = parcel.readLong();
        this.key = parcel.readLong();
        this.value = parcel.readLong();
    }

    public long GetID() {
        return this.id;
    }

    public void SetID(int i2) {
        this.id = (long) i2;
    }

    public long GetKey() {
        return this.key;
    }

    public void SetKey(int i2) {
        this.key = (long) i2;
    }

    public long GetValue() {
        return this.value;
    }

    public void SetValue(long j2) {
        this.value = j2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.id);
        parcel.writeLong(this.key);
        parcel.writeLong(this.value);
    }
}
