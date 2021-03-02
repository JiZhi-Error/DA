package com.google.android.exoplayer2.f.g;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i implements d {
    private final List<e> bAF;
    private final long[] bCE = new long[(this.bDR * 2)];
    private final int bDR;
    private final long[] bDS;

    public i(List<e> list) {
        AppMethodBeat.i(92917);
        this.bAF = list;
        this.bDR = list.size();
        for (int i2 = 0; i2 < this.bDR; i2++) {
            e eVar = list.get(i2);
            int i3 = i2 * 2;
            this.bCE[i3] = eVar.startTime;
            this.bCE[i3 + 1] = eVar.endTime;
        }
        this.bDS = Arrays.copyOf(this.bCE, this.bCE.length);
        Arrays.sort(this.bDS);
        AppMethodBeat.o(92917);
    }

    @Override // com.google.android.exoplayer2.f.d
    public final int ai(long j2) {
        AppMethodBeat.i(92918);
        int a2 = x.a(this.bDS, j2, false, false);
        if (a2 < this.bDS.length) {
            AppMethodBeat.o(92918);
            return a2;
        }
        AppMethodBeat.o(92918);
        return -1;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final int wa() {
        return this.bDS.length;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final long eH(int i2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(92919);
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        a.checkArgument(z);
        if (i2 >= this.bDS.length) {
            z2 = false;
        }
        a.checkArgument(z2);
        long j2 = this.bDS[i2];
        AppMethodBeat.o(92919);
        return j2;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final List<com.google.android.exoplayer2.f.a> aj(long j2) {
        e eVar;
        boolean z;
        AppMethodBeat.i(92920);
        int i2 = 0;
        SpannableStringBuilder spannableStringBuilder = null;
        e eVar2 = null;
        ArrayList arrayList = null;
        while (i2 < this.bDR) {
            if (this.bCE[i2 * 2] <= j2 && j2 < this.bCE[(i2 * 2) + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                eVar = this.bAF.get(i2);
                if (eVar.bAc == Float.MIN_VALUE && eVar.bAe == Float.MIN_VALUE) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (eVar2 != null) {
                        if (spannableStringBuilder == null) {
                            spannableStringBuilder = new SpannableStringBuilder();
                            spannableStringBuilder.append(eVar2.text).append((CharSequence) "\n").append(eVar.text);
                            eVar = eVar2;
                        } else {
                            spannableStringBuilder.append((CharSequence) "\n").append(eVar.text);
                            eVar = eVar2;
                        }
                    }
                    i2++;
                    eVar2 = eVar;
                } else {
                    arrayList.add(eVar);
                }
            }
            eVar = eVar2;
            i2++;
            eVar2 = eVar;
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new e(spannableStringBuilder));
        } else if (eVar2 != null) {
            arrayList.add(eVar2);
        }
        if (arrayList != null) {
            AppMethodBeat.o(92920);
            return arrayList;
        }
        List<com.google.android.exoplayer2.f.a> emptyList = Collections.emptyList();
        AppMethodBeat.o(92920);
        return emptyList;
    }
}
