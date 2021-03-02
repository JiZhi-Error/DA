package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i implements k {
    private final k bwq;
    int bwr;
    final int loopCount = 50;

    public i(k kVar) {
        AppMethodBeat.i(196054);
        com.google.android.exoplayer2.i.a.checkArgument(true);
        this.bwq = kVar;
        AppMethodBeat.o(196054);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void a(f fVar, final k.a aVar) {
        AppMethodBeat.i(196055);
        this.bwq.a(fVar, new k.a() {
            /* class com.google.android.exoplayer2.source.i.AnonymousClass1 */

            @Override // com.google.android.exoplayer2.source.k.a
            public final void a(w wVar, Object obj) {
                AppMethodBeat.i(196044);
                i.this.bwr = wVar.tE();
                aVar.a(i.this.loopCount != Integer.MAX_VALUE ? new b(wVar, i.this.loopCount) : new a(wVar), obj);
                AppMethodBeat.o(196044);
            }
        });
        AppMethodBeat.o(196055);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void vt() {
        AppMethodBeat.i(196056);
        this.bwq.vt();
        AppMethodBeat.o(196056);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final j a(k.b bVar, com.google.android.exoplayer2.h.b bVar2) {
        AppMethodBeat.i(196057);
        if (this.loopCount != Integer.MAX_VALUE) {
            j a2 = this.bwq.a(new k.b(bVar.bwx % this.bwr), bVar2);
            AppMethodBeat.o(196057);
            return a2;
        }
        j a3 = this.bwq.a(bVar, bVar2);
        AppMethodBeat.o(196057);
        return a3;
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void b(j jVar) {
        AppMethodBeat.i(196058);
        this.bwq.b(jVar);
        AppMethodBeat.o(196058);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void vu() {
        AppMethodBeat.i(196059);
        this.bwq.vu();
        AppMethodBeat.o(196059);
    }

    static final class b extends a {
        private final int bwr;
        private final w bwu;
        private final int bwv;
        private final int loopCount;

        public b(w wVar, int i2) {
            super(i2);
            AppMethodBeat.i(196051);
            this.bwu = wVar;
            this.bwr = wVar.tE();
            this.bwv = wVar.tD();
            this.loopCount = i2;
            com.google.android.exoplayer2.i.a.checkState(i2 <= Integer.MAX_VALUE / this.bwr, "LoopingMediaSource contains too many periods");
            AppMethodBeat.o(196051);
        }

        @Override // com.google.android.exoplayer2.w
        public final int tD() {
            return this.bwv * this.loopCount;
        }

        @Override // com.google.android.exoplayer2.w
        public final int tE() {
            return this.bwr * this.loopCount;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.exoplayer2.source.a
        public final int ev(int i2) {
            return i2 / this.bwr;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.exoplayer2.source.a
        public final int ew(int i2) {
            return i2 / this.bwv;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.exoplayer2.source.a
        public final int ag(Object obj) {
            AppMethodBeat.i(196052);
            if (!(obj instanceof Integer)) {
                AppMethodBeat.o(196052);
                return -1;
            }
            int intValue = ((Integer) obj).intValue();
            AppMethodBeat.o(196052);
            return intValue;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.exoplayer2.source.a
        public final w vk() {
            return this.bwu;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.exoplayer2.source.a
        public final int ex(int i2) {
            return this.bwr * i2;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.exoplayer2.source.a
        public final int ey(int i2) {
            return this.bwv * i2;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.exoplayer2.source.a
        public final Object ez(int i2) {
            AppMethodBeat.i(196053);
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(196053);
            return valueOf;
        }
    }

    static final class a extends w {
        private final w bwu;

        public a(w wVar) {
            this.bwu = wVar;
        }

        @Override // com.google.android.exoplayer2.w
        public final int tD() {
            AppMethodBeat.i(196045);
            int tD = this.bwu.tD();
            AppMethodBeat.o(196045);
            return tD;
        }

        @Override // com.google.android.exoplayer2.w
        public final int aZ(int i2, int i3) {
            AppMethodBeat.i(196046);
            int aZ = this.bwu.aZ(i2, i3);
            if (aZ == -1) {
                AppMethodBeat.o(196046);
                return 0;
            }
            AppMethodBeat.o(196046);
            return aZ;
        }

        @Override // com.google.android.exoplayer2.w
        public final w.b a(int i2, w.b bVar, boolean z, long j2) {
            AppMethodBeat.i(196047);
            w.b a2 = this.bwu.a(i2, bVar, z, j2);
            AppMethodBeat.o(196047);
            return a2;
        }

        @Override // com.google.android.exoplayer2.w
        public final int tE() {
            AppMethodBeat.i(196048);
            int tE = this.bwu.tE();
            AppMethodBeat.o(196048);
            return tE;
        }

        @Override // com.google.android.exoplayer2.w
        public final w.a a(int i2, w.a aVar, boolean z) {
            AppMethodBeat.i(196049);
            w.a a2 = this.bwu.a(i2, aVar, z);
            AppMethodBeat.o(196049);
            return a2;
        }

        @Override // com.google.android.exoplayer2.w
        public final int ae(Object obj) {
            AppMethodBeat.i(196050);
            int ae = this.bwu.ae(obj);
            AppMethodBeat.o(196050);
            return ae;
        }
    }
}
