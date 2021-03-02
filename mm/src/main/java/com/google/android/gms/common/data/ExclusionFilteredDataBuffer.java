package com.google.android.gms.common.data;

import android.text.TextUtils;
import com.google.android.gms.common.data.DataBufferObserver;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@VisibleForTesting
public final class ExclusionFilteredDataBuffer<T> extends FilteredDataBuffer<T> implements DataBufferObserver.Observable, ExclusionFilterable {
    private AbstractDataBuffer<T> zzoc;
    private final String zzod;
    private final HashSet<Integer> zzoe = new HashSet<>();
    private DataBufferObserverSet zzof;

    public ExclusionFilteredDataBuffer(AbstractDataBuffer<T> abstractDataBuffer, String str) {
        super(abstractDataBuffer);
        AppMethodBeat.i(11618);
        this.zzoc = abstractDataBuffer;
        this.zzod = str;
        this.zzof = new DataBufferObserverSet();
        AppMethodBeat.o(11618);
    }

    private final ArrayList<Integer> zza(String str, ArrayList<Integer> arrayList) {
        int i2;
        int i3;
        AppMethodBeat.i(11627);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            arrayList.clear();
        }
        DataHolder dataHolder = this.zzoc.mDataHolder;
        String str2 = this.zzod;
        boolean z = this.zzoc instanceof EntityBuffer;
        int count = this.zzoc.getCount();
        int i4 = 0;
        int i5 = 0;
        while (i4 < count) {
            int zzi = z ? ((EntityBuffer) this.zzoc).zzi(i4) : i4;
            String string = dataHolder.getString(str2, zzi, dataHolder.getWindowIndex(zzi));
            if (arrayList == null) {
                i2 = i5;
                i3 = i5;
            } else if (this.zzoe.contains(Integer.valueOf(i4))) {
                i2 = (-i5) - 1;
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i2 = i5;
            }
            if (!TextUtils.isEmpty(string) && string.equals(str)) {
                arrayList2.add(Integer.valueOf(i4));
                if (arrayList != null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            i4++;
            i5 = i3;
        }
        AppMethodBeat.o(11627);
        return arrayList2;
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public final void addObserver(DataBufferObserver dataBufferObserver) {
        AppMethodBeat.i(11619);
        this.zzof.addObserver(dataBufferObserver);
        AppMethodBeat.o(11619);
    }

    @Override // com.google.android.gms.common.data.ExclusionFilterable
    public final void clearFilters() {
        int i2;
        AppMethodBeat.i(11626);
        if (!this.zzof.hasObservers()) {
            this.zzoe.clear();
            AppMethodBeat.o(11626);
            return;
        }
        int size = this.zzoe.size();
        Integer[] numArr = (Integer[]) this.zzoe.toArray(new Integer[size]);
        Arrays.sort(numArr);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < size) {
            int intValue = numArr[i3].intValue();
            this.zzoe.remove(Integer.valueOf(intValue));
            if (i4 == 0) {
                i2 = 1;
            } else if (intValue == i5 + i4) {
                i2 = i4 + 1;
                intValue = i5;
            } else {
                this.zzof.onDataRangeRemoved(i5, i4);
                i2 = 1;
            }
            i3++;
            i4 = i2;
            i5 = intValue;
        }
        if (i4 > 0) {
            this.zzof.onDataRangeRemoved(i5, i4);
        }
        AppMethodBeat.o(11626);
    }

    @Override // com.google.android.gms.common.data.FilteredDataBuffer
    public final int computeRealPosition(int i2) {
        AppMethodBeat.i(11622);
        if (this.zzoe.isEmpty()) {
            AppMethodBeat.o(11622);
            return i2;
        } else if (i2 < 0 || i2 >= getCount()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i2).append(" is out of bounds for this buffer").toString());
            AppMethodBeat.o(11622);
            throw illegalArgumentException;
        } else {
            int count = this.mDataBuffer.getCount();
            int i3 = 0;
            for (int i4 = 0; i4 < count; i4++) {
                if (!this.zzoe.contains(Integer.valueOf(i4))) {
                    if (i3 == i2) {
                        AppMethodBeat.o(11622);
                        return i4;
                    }
                    i3++;
                }
            }
            AppMethodBeat.o(11622);
            return -1;
        }
    }

    @Override // com.google.android.gms.common.data.ExclusionFilterable
    public final void filterOut(String str) {
        int i2;
        AppMethodBeat.i(11624);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(11624);
            return;
        }
        ArrayList<Integer> arrayList = this.zzof.hasObservers() ? new ArrayList<>() : null;
        ArrayList<Integer> zza = zza(str, arrayList);
        if (this.zzof.hasObservers()) {
            int size = zza.size() - 1;
            int i3 = 0;
            int i4 = 0;
            while (size >= 0) {
                int intValue = arrayList.get(size).intValue();
                if (!(intValue < 0)) {
                    this.zzoe.add(Integer.valueOf(zza.get(size).intValue()));
                    if (i3 == 0) {
                        i2 = 1;
                    } else if (intValue == i4 - 1) {
                        intValue = i4 - 1;
                        i2 = i3 + 1;
                    } else {
                        this.zzof.onDataRangeRemoved(i4, i3);
                        i2 = 1;
                    }
                } else {
                    i2 = i3;
                    intValue = i4;
                }
                size--;
                i3 = i2;
                i4 = intValue;
            }
            if (i3 > 0) {
                this.zzof.onDataRangeRemoved(i4, i3);
            }
            AppMethodBeat.o(11624);
            return;
        }
        this.zzoe.addAll(zza);
        AppMethodBeat.o(11624);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final int getCount() {
        AppMethodBeat.i(11621);
        int count = this.mDataBuffer.getCount() - this.zzoe.size();
        AppMethodBeat.o(11621);
        return count;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.FilteredDataBuffer, com.google.android.gms.common.api.Releasable
    public final void release() {
        AppMethodBeat.i(11623);
        super.release();
        this.zzof.clear();
        AppMethodBeat.o(11623);
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public final void removeObserver(DataBufferObserver dataBufferObserver) {
        AppMethodBeat.i(11620);
        this.zzof.removeObserver(dataBufferObserver);
        AppMethodBeat.o(11620);
    }

    @Override // com.google.android.gms.common.data.ExclusionFilterable
    public final void unfilter(String str) {
        int i2;
        int i3;
        AppMethodBeat.i(11625);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(11625);
            return;
        }
        ArrayList<Integer> arrayList = this.zzof.hasObservers() ? new ArrayList<>() : null;
        ArrayList<Integer> zza = zza(str, arrayList);
        if (this.zzof.hasObservers()) {
            int size = zza.size() - 1;
            int i4 = 0;
            int i5 = 0;
            while (size >= 0) {
                int intValue = arrayList.get(size).intValue();
                if (intValue < 0) {
                    this.zzoe.remove(Integer.valueOf(zza.get(size).intValue()));
                    i3 = (-intValue) - 1;
                    if (i4 == 0) {
                        i2 = 1;
                    } else if (i3 == i5) {
                        i2 = i4 + 1;
                        i3 = i5;
                    } else {
                        this.zzof.onDataRangeInserted(i5, i4);
                        i2 = 1;
                    }
                } else {
                    i2 = i4;
                    i3 = i5;
                }
                size--;
                i4 = i2;
                i5 = i3;
            }
            if (i4 > 0) {
                this.zzof.onDataRangeInserted(i5, i4);
            }
            AppMethodBeat.o(11625);
            return;
        }
        this.zzoe.removeAll(zza);
        AppMethodBeat.o(11625);
    }
}
