package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean zzoa = false;
    private ArrayList<Integer> zzob;

    protected EntityBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void zzck() {
        synchronized (this) {
            if (!this.zzoa) {
                int count = this.mDataHolder.getCount();
                this.zzob = new ArrayList<>();
                if (count > 0) {
                    this.zzob.add(0);
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String string = this.mDataHolder.getString(primaryDataMarkerColumn, 0, this.mDataHolder.getWindowIndex(0));
                    int i2 = 1;
                    while (i2 < count) {
                        int windowIndex = this.mDataHolder.getWindowIndex(i2);
                        String string2 = this.mDataHolder.getString(primaryDataMarkerColumn, i2, windowIndex);
                        if (string2 == null) {
                            throw new NullPointerException(new StringBuilder(String.valueOf(primaryDataMarkerColumn).length() + 78).append("Missing value for markerColumn: ").append(primaryDataMarkerColumn).append(", at row: ").append(i2).append(", for window: ").append(windowIndex).toString());
                        }
                        if (!string2.equals(string)) {
                            this.zzob.add(Integer.valueOf(i2));
                        } else {
                            string2 = string;
                        }
                        i2++;
                        string = string2;
                    }
                }
                this.zzoa = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer
    public final T get(int i2) {
        zzck();
        return getEntry(zzi(i2), getChildCount(i2));
    }

    /* access modifiers changed from: protected */
    public int getChildCount(int i2) {
        if (i2 < 0 || i2 == this.zzob.size()) {
            return 0;
        }
        int count = i2 == this.zzob.size() + -1 ? this.mDataHolder.getCount() - this.zzob.get(i2).intValue() : this.zzob.get(i2 + 1).intValue() - this.zzob.get(i2).intValue();
        if (count != 1) {
            return count;
        }
        int zzi = zzi(i2);
        int windowIndex = this.mDataHolder.getWindowIndex(zzi);
        String childDataMarkerColumn = getChildDataMarkerColumn();
        if (childDataMarkerColumn == null || this.mDataHolder.getString(childDataMarkerColumn, zzi, windowIndex) != null) {
            return count;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public String getChildDataMarkerColumn() {
        return null;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer
    public int getCount() {
        zzck();
        return this.zzob.size();
    }

    /* access modifiers changed from: protected */
    public abstract T getEntry(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String getPrimaryDataMarkerColumn();

    /* access modifiers changed from: package-private */
    public final int zzi(int i2) {
        if (i2 >= 0 && i2 < this.zzob.size()) {
            return this.zzob.get(i2).intValue();
        }
        throw new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i2).append(" is out of bounds for this buffer").toString());
    }
}
