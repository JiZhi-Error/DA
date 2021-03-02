package com.google.android.gms.common.data;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.data.TextFilterable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

@VisibleForTesting
public final class ConcatenatedDataBuffer<T> implements DataBuffer<T>, ExclusionFilterable, TextFilterable {
    private Bundle mBundle;
    private final ArrayList<DataBuffer<T>> zznf = new ArrayList<>();
    private final ArrayList<Integer> zzng = new ArrayList<>();
    private int zznh;

    public ConcatenatedDataBuffer() {
        AppMethodBeat.i(11512);
        AppMethodBeat.o(11512);
    }

    public ConcatenatedDataBuffer(DataBuffer<T> dataBuffer) {
        AppMethodBeat.i(11513);
        append(dataBuffer);
        AppMethodBeat.o(11513);
    }

    public static <T> ConcatenatedDataBuffer<T> extend(ConcatenatedDataBuffer<T> concatenatedDataBuffer, DataBuffer<T> dataBuffer) {
        AppMethodBeat.i(11521);
        ConcatenatedDataBuffer<T> concatenatedDataBuffer2 = new ConcatenatedDataBuffer<>();
        ArrayList<DataBuffer<T>> arrayList = ((ConcatenatedDataBuffer) concatenatedDataBuffer).zznf;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            DataBuffer<T> dataBuffer2 = arrayList.get(i2);
            i2++;
            concatenatedDataBuffer2.append(dataBuffer2);
        }
        concatenatedDataBuffer2.append(dataBuffer);
        AppMethodBeat.o(11521);
        return concatenatedDataBuffer2;
    }

    public final void append(DataBuffer<T> dataBuffer) {
        AppMethodBeat.i(11516);
        if (dataBuffer == null) {
            AppMethodBeat.o(11516);
            return;
        }
        synchronized (this) {
            try {
                if (this.zznf.isEmpty()) {
                    this.mBundle = new Bundle();
                    Bundle metadata = dataBuffer.getMetadata();
                    if (metadata != null) {
                        this.mBundle.putString(DataBufferUtils.KEY_PREV_PAGE_TOKEN, metadata.getString(DataBufferUtils.KEY_PREV_PAGE_TOKEN));
                    }
                }
                this.zznf.add(dataBuffer);
                computeCounts();
                Bundle metadata2 = dataBuffer.getMetadata();
                if (metadata2 != null) {
                    this.mBundle.putString(DataBufferUtils.KEY_NEXT_PAGE_TOKEN, metadata2.getString(DataBufferUtils.KEY_NEXT_PAGE_TOKEN));
                } else {
                    this.mBundle.remove(DataBufferUtils.KEY_NEXT_PAGE_TOKEN);
                }
            } finally {
                AppMethodBeat.o(11516);
            }
        }
    }

    @Override // com.google.android.gms.common.data.ExclusionFilterable
    public final void clearFilters() {
        AppMethodBeat.i(11524);
        int size = this.zznf.size();
        for (int i2 = 0; i2 < size; i2++) {
            DataBuffer<T> dataBuffer = this.zznf.get(i2);
            if (dataBuffer instanceof ExclusionFilterable) {
                ((ExclusionFilterable) dataBuffer).clearFilters();
            }
        }
        computeCounts();
        AppMethodBeat.o(11524);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    @Deprecated
    public final void close() {
        AppMethodBeat.i(11517);
        release();
        AppMethodBeat.o(11517);
    }

    public final void computeCounts() {
        AppMethodBeat.i(11520);
        this.zzng.clear();
        int size = this.zznf.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            DataBuffer<T> dataBuffer = this.zznf.get(i2);
            int count = dataBuffer != null ? dataBuffer.getCount() + i3 : i3;
            this.zzng.add(Integer.valueOf(count));
            i2++;
            i3 = count;
        }
        this.zznh = i3;
        AppMethodBeat.o(11520);
    }

    @Override // com.google.android.gms.common.data.ExclusionFilterable
    public final void filterOut(String str) {
        AppMethodBeat.i(11522);
        int size = this.zznf.size();
        for (int i2 = 0; i2 < size; i2++) {
            DataBuffer<T> dataBuffer = this.zznf.get(i2);
            if (dataBuffer instanceof ExclusionFilterable) {
                ((ExclusionFilterable) dataBuffer).filterOut(str);
            }
        }
        computeCounts();
        AppMethodBeat.o(11522);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final T get(int i2) {
        T t;
        DataBuffer<T> dataBuffer;
        AppMethodBeat.i(11514);
        synchronized (this) {
            try {
                int size = this.zznf.size();
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        int intValue = this.zzng.get(i3).intValue();
                        if (i2 < intValue && (dataBuffer = this.zznf.get(i3)) != null) {
                            t = dataBuffer.get((i2 - intValue) + dataBuffer.getCount());
                            break;
                        }
                        i3++;
                    } else {
                        t = null;
                        AppMethodBeat.o(11514);
                        break;
                    }
                }
            } finally {
                AppMethodBeat.o(11514);
            }
        }
        return t;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final int getCount() {
        int i2;
        synchronized (this) {
            i2 = this.zznh;
        }
        return i2;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final Bundle getMetadata() {
        Bundle bundle;
        synchronized (this) {
            bundle = this.mBundle;
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    @Deprecated
    public final boolean isClosed() {
        return false;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, java.lang.Iterable
    public final Iterator<T> iterator() {
        AppMethodBeat.i(11518);
        DataBufferIterator dataBufferIterator = new DataBufferIterator(this);
        AppMethodBeat.o(11518);
        return dataBufferIterator;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public final void release() {
        AppMethodBeat.i(11515);
        synchronized (this) {
            try {
                int size = this.zznf.size();
                for (int i2 = 0; i2 < size; i2++) {
                    DataBuffer<T> dataBuffer = this.zznf.get(i2);
                    if (dataBuffer != null) {
                        dataBuffer.release();
                    }
                }
                this.zznf.clear();
                this.zzng.clear();
                this.mBundle = null;
            } finally {
                AppMethodBeat.o(11515);
            }
        }
    }

    @Override // com.google.android.gms.common.data.TextFilterable
    public final void setFilterTerm(Context context, TextFilterable.StringFilter stringFilter, String str) {
        AppMethodBeat.i(11526);
        int size = this.zznf.size();
        for (int i2 = 0; i2 < size; i2++) {
            DataBuffer<T> dataBuffer = this.zznf.get(i2);
            if (dataBuffer instanceof TextFilterable) {
                ((TextFilterable) dataBuffer).setFilterTerm(context, stringFilter, str);
            }
        }
        computeCounts();
        AppMethodBeat.o(11526);
    }

    @Override // com.google.android.gms.common.data.TextFilterable
    public final void setFilterTerm(Context context, String str) {
        AppMethodBeat.i(11525);
        int size = this.zznf.size();
        for (int i2 = 0; i2 < size; i2++) {
            DataBuffer<T> dataBuffer = this.zznf.get(i2);
            if (dataBuffer instanceof TextFilterable) {
                ((TextFilterable) dataBuffer).setFilterTerm(context, str);
            }
        }
        computeCounts();
        AppMethodBeat.o(11525);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final Iterator<T> singleRefIterator() {
        AppMethodBeat.i(11519);
        Iterator<T> it = iterator();
        AppMethodBeat.o(11519);
        return it;
    }

    @Override // com.google.android.gms.common.data.ExclusionFilterable
    public final void unfilter(String str) {
        AppMethodBeat.i(11523);
        int size = this.zznf.size();
        for (int i2 = 0; i2 < size; i2++) {
            DataBuffer<T> dataBuffer = this.zznf.get(i2);
            if (dataBuffer instanceof ExclusionFilterable) {
                ((ExclusionFilterable) dataBuffer).unfilter(str);
            }
        }
        computeCounts();
        AppMethodBeat.o(11523);
    }
}
