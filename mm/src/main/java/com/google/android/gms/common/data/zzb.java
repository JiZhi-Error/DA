package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class zzb implements Comparator<Integer> {
    private final /* synthetic */ Comparator zzom;
    private final /* synthetic */ SortedDataBuffer zzon;

    zzb(SortedDataBuffer sortedDataBuffer, Comparator comparator) {
        this.zzon = sortedDataBuffer;
        this.zzom = comparator;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Integer num, Integer num2) {
        AppMethodBeat.i(11691);
        int compare = this.zzom.compare(SortedDataBuffer.zza(this.zzon).get(num.intValue()), SortedDataBuffer.zza(this.zzon).get(num2.intValue()));
        AppMethodBeat.o(11691);
        return compare;
    }
}
