package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBufferObserver;
import com.google.android.gms.common.internal.Asserts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class ObjectDataBuffer<T> extends AbstractDataBuffer<T> implements DataBufferObserver.Observable, ObjectExclusionFilterable<T> {
    private final ArrayList<Integer> zzob;
    private final HashSet<Integer> zzoe;
    private DataBufferObserverSet zzof;
    private final ArrayList<T> zzog;

    public ObjectDataBuffer() {
        super(null);
        AppMethodBeat.i(11631);
        this.zzoe = new HashSet<>();
        this.zzob = new ArrayList<>();
        this.zzog = new ArrayList<>();
        this.zzof = new DataBufferObserverSet();
        zzcl();
        AppMethodBeat.o(11631);
    }

    public ObjectDataBuffer(ArrayList<T> arrayList) {
        super(null);
        AppMethodBeat.i(11633);
        this.zzoe = new HashSet<>();
        this.zzob = new ArrayList<>();
        this.zzog = arrayList;
        this.zzof = new DataBufferObserverSet();
        zzcl();
        AppMethodBeat.o(11633);
    }

    public ObjectDataBuffer(T... tArr) {
        super(null);
        AppMethodBeat.i(11632);
        this.zzoe = new HashSet<>();
        this.zzob = new ArrayList<>();
        this.zzog = new ArrayList<>(Arrays.asList(tArr));
        this.zzof = new DataBufferObserverSet();
        zzcl();
        AppMethodBeat.o(11632);
    }

    private final void zzcl() {
        AppMethodBeat.i(11653);
        this.zzob.clear();
        int size = this.zzog.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.zzoe.contains(Integer.valueOf(i2))) {
                this.zzob.add(Integer.valueOf(i2));
            }
        }
        AppMethodBeat.o(11653);
    }

    public final void add(T t) {
        boolean z = false;
        AppMethodBeat.i(11636);
        int size = this.zzog.size();
        this.zzog.add(t);
        zzcl();
        if (this.zzof.hasObservers()) {
            Asserts.checkState(!this.zzoe.contains(Integer.valueOf(size)));
            int size2 = this.zzob.size();
            Asserts.checkState(size2 > 0);
            if (this.zzob.get(size2 - 1).intValue() == size) {
                z = true;
            }
            Asserts.checkState(z);
            this.zzof.onDataRangeInserted(size2 - 1, 1);
        }
        AppMethodBeat.o(11636);
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public final void addObserver(DataBufferObserver dataBufferObserver) {
        AppMethodBeat.i(11634);
        this.zzof.addObserver(dataBufferObserver);
        AppMethodBeat.o(11634);
    }

    @Override // com.google.android.gms.common.data.ObjectExclusionFilterable
    public final void filterOut(T t) {
        AppMethodBeat.i(11648);
        int size = this.zzog.size();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        boolean z = false;
        int i5 = -1;
        while (i2 < size) {
            if (!this.zzoe.contains(Integer.valueOf(i2))) {
                i5++;
                if (t.equals(this.zzog.get(i2))) {
                    this.zzoe.add(Integer.valueOf(i2));
                    if (!this.zzof.hasObservers()) {
                        z = true;
                    } else if (i4 < 0) {
                        i3 = 1;
                        i4 = i5;
                        z = true;
                    } else {
                        i3++;
                        z = true;
                    }
                } else if (i4 >= 0) {
                    zzcl();
                    this.zzof.onDataRangeRemoved(i4, i3);
                    i5 -= i3;
                    i3 = -1;
                    i4 = -1;
                    z = false;
                }
            }
            i2++;
            i5 = i5;
        }
        if (z) {
            zzcl();
        }
        if (i4 >= 0) {
            this.zzof.onDataRangeRemoved(i4, i3);
        }
        AppMethodBeat.o(11648);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void filterOutRaw(int r6) {
        /*
            r5 = this;
            r4 = 11649(0x2d81, float:1.6324E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.util.HashSet<java.lang.Integer> r0 = r5.zzoe
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            boolean r0 = r0.add(r1)
            r2 = -1
            com.google.android.gms.common.data.DataBufferObserverSet r1 = r5.zzof
            boolean r1 = r1.hasObservers()
            if (r1 == 0) goto L_0x0044
            if (r0 == 0) goto L_0x0044
            r1 = 0
            java.util.ArrayList<java.lang.Integer> r0 = r5.zzob
            int r3 = r0.size()
        L_0x0021:
            if (r1 >= r3) goto L_0x0044
            java.util.ArrayList<java.lang.Integer> r0 = r5.zzob
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r0 != r6) goto L_0x0041
            r0 = r1
        L_0x0032:
            r5.zzcl()
            if (r0 < 0) goto L_0x003d
            com.google.android.gms.common.data.DataBufferObserverSet r1 = r5.zzof
            r2 = 1
            r1.onDataRangeRemoved(r0, r2)
        L_0x003d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        L_0x0041:
            int r1 = r1 + 1
            goto L_0x0021
        L_0x0044:
            r0 = r2
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.ObjectDataBuffer.filterOutRaw(int):void");
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer
    public final T get(int i2) {
        AppMethodBeat.i(11640);
        T t = this.zzog.get(getRawPosition(i2));
        AppMethodBeat.o(11640);
        return t;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer
    public final int getCount() {
        AppMethodBeat.i(11639);
        int size = this.zzog.size() - this.zzoe.size();
        AppMethodBeat.o(11639);
        return size;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer
    public final Bundle getMetadata() {
        return null;
    }

    public final int getPositionFromRawPosition(int i2) {
        AppMethodBeat.i(11644);
        int i3 = -1;
        for (int i4 = 0; i4 <= i2; i4++) {
            if (!this.zzoe.contains(Integer.valueOf(i4))) {
                i3++;
            }
        }
        AppMethodBeat.o(11644);
        return i3;
    }

    public final T getRaw(int i2) {
        AppMethodBeat.i(11642);
        T t = this.zzog.get(i2);
        AppMethodBeat.o(11642);
        return t;
    }

    public final int getRawCount() {
        AppMethodBeat.i(11641);
        int size = this.zzog.size();
        AppMethodBeat.o(11641);
        return size;
    }

    public final int getRawPosition(int i2) {
        AppMethodBeat.i(11643);
        if (i2 < 0 || i2 >= getCount()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i2).append(" is out of bounds for this buffer").toString());
            AppMethodBeat.o(11643);
            throw illegalArgumentException;
        }
        int intValue = this.zzob.get(i2).intValue();
        AppMethodBeat.o(11643);
        return intValue;
    }

    public final void insertRaw(int i2, T t) {
        AppMethodBeat.i(11637);
        this.zzog.add(i2, t);
        HashSet hashSet = new HashSet(this.zzoe.size());
        Iterator<Integer> it = this.zzoe.iterator();
        int i3 = i2;
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() < i2) {
                i3--;
            } else {
                hashSet.add(Integer.valueOf(next.intValue() + 1));
                it.remove();
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.zzoe.add((Integer) it2.next());
        }
        zzcl();
        if (this.zzof.hasObservers()) {
            this.zzof.onDataRangeInserted(i3, 1);
        }
        AppMethodBeat.o(11637);
    }

    public final boolean isRawPositionFiltered(int i2) {
        AppMethodBeat.i(11645);
        boolean contains = this.zzoe.contains(Integer.valueOf(i2));
        AppMethodBeat.o(11645);
        return contains;
    }

    public final void notifyChanged(T t) {
        AppMethodBeat.i(11652);
        if (!this.zzof.hasObservers()) {
            AppMethodBeat.o(11652);
            return;
        }
        int size = this.zzob.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (t.equals(this.zzog.get(this.zzob.get(i2).intValue()))) {
                this.zzof.onDataRangeChanged(i2, 1);
            }
        }
        AppMethodBeat.o(11652);
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.api.Releasable
    public final void release() {
        AppMethodBeat.i(11646);
        this.zzof.clear();
        AppMethodBeat.o(11646);
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public final void removeObserver(DataBufferObserver dataBufferObserver) {
        AppMethodBeat.i(11635);
        this.zzof.removeObserver(dataBufferObserver);
        AppMethodBeat.o(11635);
    }

    public final void removeRaw(int i2) {
        AppMethodBeat.i(11647);
        this.zzog.remove(i2);
        boolean remove = this.zzoe.remove(Integer.valueOf(i2));
        HashSet hashSet = new HashSet(this.zzoe.size());
        Iterator<Integer> it = this.zzoe.iterator();
        int i3 = i2;
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() < i2) {
                i3--;
            } else {
                it.remove();
                hashSet.add(Integer.valueOf(next.intValue() - 1));
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.zzoe.add((Integer) it2.next());
        }
        zzcl();
        if (!remove && this.zzof.hasObservers()) {
            this.zzof.onDataRangeRemoved(i3, 1);
        }
        AppMethodBeat.o(11647);
    }

    public final boolean setRaw(int i2, T t) {
        AppMethodBeat.i(11638);
        this.zzog.set(i2, t);
        boolean z = !this.zzoe.contains(Integer.valueOf(i2));
        if (z && this.zzof.hasObservers()) {
            int size = this.zzob.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                } else if (this.zzob.get(i3).intValue() == i2) {
                    this.zzof.onDataRangeChanged(i3, 1);
                    break;
                } else {
                    i3++;
                }
            }
        }
        AppMethodBeat.o(11638);
        return z;
    }

    public final void unfilter(T t) {
        AppMethodBeat.i(11650);
        int size = this.zzog.size();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        boolean z = false;
        int i5 = 0;
        while (i2 < size) {
            if (!this.zzoe.contains(Integer.valueOf(i2))) {
                i5++;
                if (i4 >= 0) {
                    zzcl();
                    this.zzof.onDataRangeInserted(i4, i3);
                    i5 += i3;
                    i3 = -1;
                    i4 = -1;
                    z = false;
                }
            } else if (t.equals(this.zzog.get(i2))) {
                this.zzoe.remove(Integer.valueOf(i2));
                if (!this.zzof.hasObservers()) {
                    z = true;
                } else if (i4 < 0) {
                    i3 = 1;
                    i4 = i5;
                    z = true;
                } else {
                    i3++;
                    z = true;
                }
            } else if (this.zzof.hasObservers() && i4 >= 0) {
                zzcl();
                this.zzof.onDataRangeInserted(i4, i3);
                i5 += i3;
                i3 = -1;
                i4 = -1;
                z = false;
            }
            i2++;
            i5 = i5;
        }
        if (z) {
            zzcl();
        }
        if (i4 >= 0) {
            this.zzof.onDataRangeInserted(i4, i3);
        }
        AppMethodBeat.o(11650);
    }

    public final void unfilterRaw(int i2) {
        int i3;
        AppMethodBeat.i(11651);
        boolean remove = this.zzoe.remove(Integer.valueOf(i2));
        zzcl();
        if (!this.zzof.hasObservers() || !remove) {
            AppMethodBeat.o(11651);
            return;
        }
        int i4 = 0;
        int size = this.zzob.size();
        while (true) {
            if (i4 >= size) {
                i3 = -1;
                break;
            } else if (this.zzob.get(i4).intValue() == i2) {
                i3 = i4;
                break;
            } else {
                i4++;
            }
        }
        if (i3 >= 0) {
            this.zzof.onDataRangeInserted(i3, 1);
        }
        AppMethodBeat.o(11651);
    }
}
