package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.b.a.a;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.b.j;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class g implements e.b, j.a, com.google.android.exoplayer2.source.j {
    private r bcq;
    private final int bvE;
    private final b bvH;
    private j.a bvs;
    private final k bxx = new k();
    final e bxz;
    private final d byk;
    private final b.a byl;
    private final IdentityHashMap<n, Integer> bym = new IdentityHashMap<>();
    final Handler byn = new Handler();
    private int byo;
    j[] byp = new j[0];
    private j[] byq = new j[0];
    private f byr;

    public g(e eVar, d dVar, int i2, b.a aVar, com.google.android.exoplayer2.h.b bVar) {
        AppMethodBeat.i(62834);
        this.bxz = eVar;
        this.byk = dVar;
        this.bvE = i2;
        this.byl = aVar;
        this.bvH = bVar;
        AppMethodBeat.o(62834);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void a(j.a aVar, long j2) {
        ArrayList arrayList;
        int i2;
        AppMethodBeat.i(62835);
        this.bvs = aVar;
        this.bxz.listeners.add(this);
        a aVar2 = this.bxz.bxQ;
        ArrayList arrayList2 = new ArrayList(aVar2.byO);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            a.C0114a aVar3 = (a.C0114a) arrayList2.get(i3);
            if (aVar3.bdF.height > 0 || a(aVar3, "avc")) {
                arrayList3.add(aVar3);
            } else if (a(aVar3, "mp4a")) {
                arrayList4.add(aVar3);
            }
        }
        if (!arrayList3.isEmpty()) {
            arrayList = arrayList3;
        } else {
            if (arrayList4.size() < arrayList2.size()) {
                arrayList2.removeAll(arrayList4);
            }
            arrayList = arrayList2;
        }
        List<a.C0114a> list = aVar2.audios;
        List<a.C0114a> list2 = aVar2.byP;
        this.byp = new j[(list.size() + 1 + list2.size())];
        this.byo = this.byp.length;
        com.google.android.exoplayer2.i.a.checkArgument(!arrayList.isEmpty());
        a.C0114a[] aVarArr = new a.C0114a[arrayList.size()];
        arrayList.toArray(aVarArr);
        j a2 = a(0, aVarArr, aVar2.byy, aVar2.bxB, j2);
        int i4 = 1;
        this.byp[0] = a2;
        a2.aT(true);
        a2.vT();
        int i5 = 0;
        while (true) {
            i2 = i4;
            if (i5 >= list.size()) {
                break;
            }
            j a3 = a(1, new a.C0114a[]{list.get(i5)}, (Format) null, Collections.emptyList(), j2);
            i4 = i2 + 1;
            this.byp[i2] = a3;
            a3.vT();
            i5++;
        }
        for (int i6 = 0; i6 < list2.size(); i6++) {
            a.C0114a aVar4 = list2.get(i6);
            j a4 = a(3, new a.C0114a[]{aVar4}, (Format) null, Collections.emptyList(), j2);
            a4.eG(0).f(aVar4.bdF);
            a4.bvS = true;
            a4.vV();
            this.byp[i2] = a4;
            i2++;
        }
        this.byq = this.byp;
        AppMethodBeat.o(62835);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void vn() {
        AppMethodBeat.i(62836);
        for (j jVar : this.byp) {
            jVar.byx.vs();
        }
        AppMethodBeat.o(62836);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final r vo() {
        return this.bcq;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0213  */
    @Override // com.google.android.exoplayer2.source.j
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(com.google.android.exoplayer2.g.f[] r24, boolean[] r25, com.google.android.exoplayer2.source.n[] r26, boolean[] r27, long r28) {
        /*
        // Method dump skipped, instructions count: 678
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.g.a(com.google.android.exoplayer2.g.f[], boolean[], com.google.android.exoplayer2.source.n[], boolean[], long):long");
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void V(long j2) {
        AppMethodBeat.i(62838);
        j[] jVarArr = this.byq;
        for (j jVar : jVarArr) {
            int length = jVar.bvQ.length;
            for (int i2 = 0; i2 < length; i2++) {
                jVar.bvQ[i2].h(j2, jVar.byF[i2]);
            }
        }
        AppMethodBeat.o(62838);
    }

    @Override // com.google.android.exoplayer2.source.o, com.google.android.exoplayer2.source.j
    public final boolean X(long j2) {
        AppMethodBeat.i(62839);
        boolean X = this.byr.X(j2);
        AppMethodBeat.o(62839);
        return X;
    }

    @Override // com.google.android.exoplayer2.source.o, com.google.android.exoplayer2.source.j
    public final long vr() {
        AppMethodBeat.i(62840);
        long vr = this.byr.vr();
        AppMethodBeat.o(62840);
        return vr;
    }

    @Override // com.google.android.exoplayer2.source.j
    public final long vp() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.o, com.google.android.exoplayer2.source.j
    public final long vq() {
        AppMethodBeat.i(62841);
        long vq = this.byr.vq();
        AppMethodBeat.o(62841);
        return vq;
    }

    @Override // com.google.android.exoplayer2.source.j
    public final long W(long j2) {
        AppMethodBeat.i(62842);
        if (this.byq.length > 0) {
            boolean i2 = this.byq[0].i(j2, false);
            for (int i3 = 1; i3 < this.byq.length; i3++) {
                this.byq[i3].i(j2, i2);
            }
            if (i2) {
                this.bxx.byJ.clear();
            }
        }
        AppMethodBeat.o(62842);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.b.j.a
    public final void tf() {
        AppMethodBeat.i(62843);
        int i2 = this.byo - 1;
        this.byo = i2;
        if (i2 > 0) {
            AppMethodBeat.o(62843);
            return;
        }
        int i3 = 0;
        for (j jVar : this.byp) {
            i3 += jVar.bcq.length;
        }
        q[] qVarArr = new q[i3];
        j[] jVarArr = this.byp;
        int i4 = 0;
        for (j jVar2 : jVarArr) {
            int i5 = jVar2.bcq.length;
            int i6 = 0;
            while (i6 < i5) {
                qVarArr[i4] = jVar2.bcq.bxi[i6];
                i6++;
                i4++;
            }
        }
        this.bcq = new r(qVarArr);
        this.bvs.a((com.google.android.exoplayer2.source.j) this);
        AppMethodBeat.o(62843);
    }

    @Override // com.google.android.exoplayer2.source.b.j.a
    public final void a(a.C0114a aVar) {
        AppMethodBeat.i(62844);
        this.bxz.bzJ.get(aVar).vX();
        AppMethodBeat.o(62844);
    }

    @Override // com.google.android.exoplayer2.source.b.a.e.b
    public final void vR() {
        AppMethodBeat.i(62845);
        vS();
        AppMethodBeat.o(62845);
    }

    @Override // com.google.android.exoplayer2.source.b.a.e.b
    public final void b(a.C0114a aVar) {
        int indexOf;
        AppMethodBeat.i(62846);
        for (j jVar : this.byp) {
            c cVar = jVar.byx;
            int j2 = cVar.bxA.j(aVar.bdF);
            if (!(j2 == -1 || (indexOf = cVar.bxJ.indexOf(j2)) == -1)) {
                cVar.bxJ.k(indexOf, Util.MILLSECONDS_OF_MINUTE);
            }
        }
        vS();
        AppMethodBeat.o(62846);
    }

    private j a(int i2, a.C0114a[] aVarArr, Format format, List<Format> list, long j2) {
        AppMethodBeat.i(62847);
        j jVar = new j(i2, this, new c(this.bxz, aVarArr, this.byk, this.bxx, list), this.bvH, j2, format, this.bvE, this.byl);
        AppMethodBeat.o(62847);
        return jVar;
    }

    private void vS() {
        AppMethodBeat.i(62848);
        if (this.bcq != null) {
            this.bvs.a((o) this);
            AppMethodBeat.o(62848);
            return;
        }
        for (j jVar : this.byp) {
            jVar.vT();
        }
        AppMethodBeat.o(62848);
    }

    private static boolean a(a.C0114a aVar, String str) {
        AppMethodBeat.i(62849);
        String str2 = aVar.bdF.bdn;
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(62849);
            return false;
        }
        String[] split = str2.split("(\\s*,\\s*)|(\\s*$)");
        for (String str3 : split) {
            if (str3.startsWith(str)) {
                AppMethodBeat.o(62849);
                return true;
            }
        }
        AppMethodBeat.o(62849);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.source.o] */
    @Override // com.google.android.exoplayer2.source.o.a
    public final /* bridge */ /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(62850);
        if (this.bcq != null) {
            this.bvs.a((o) this);
        }
        AppMethodBeat.o(62850);
    }
}
