package com.google.android.exoplayer2.f.e;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class e implements d {
    private final b bDf;
    private final long[] bDg;
    private final Map<String, d> bDh;
    private final Map<String, c> bDi;

    public e(b bVar, Map<String, d> map, Map<String, c> map2) {
        AppMethodBeat.i(92862);
        this.bDf = bVar;
        this.bDi = map2;
        this.bDh = Collections.unmodifiableMap(map);
        this.bDg = bVar.wu();
        AppMethodBeat.o(92862);
    }

    @Override // com.google.android.exoplayer2.f.d
    public final int ai(long j2) {
        AppMethodBeat.i(92863);
        int a2 = x.a(this.bDg, j2, false, false);
        if (a2 < this.bDg.length) {
            AppMethodBeat.o(92863);
            return a2;
        }
        AppMethodBeat.o(92863);
        return -1;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final int wa() {
        return this.bDg.length;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final long eH(int i2) {
        return this.bDg[i2];
    }

    @Override // com.google.android.exoplayer2.f.d
    public final List<a> aj(long j2) {
        AppMethodBeat.i(92864);
        b bVar = this.bDf;
        Map<String, d> map = this.bDh;
        Map<String, c> map2 = this.bDi;
        TreeMap treeMap = new TreeMap();
        bVar.a(j2, false, bVar.bCR, treeMap);
        bVar.a(map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            c cVar = map2.get(entry.getKey());
            arrayList.add(new a(b.a((SpannableStringBuilder) entry.getValue()), null, cVar.bAc, cVar.lineType, cVar.bAd, cVar.bAe, Integer.MIN_VALUE, cVar.width));
        }
        AppMethodBeat.o(92864);
        return arrayList;
    }
}
