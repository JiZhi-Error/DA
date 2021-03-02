package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.i.w;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.b.a.a;
import com.google.android.exoplayer2.source.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public final class e implements t.a<u<c>> {
    public a bxQ;
    public final com.google.android.exoplayer2.source.b.d byk;
    final b.a byl;
    public final u.a<c> byt;
    public final Uri bzH;
    public final int bzI;
    public final IdentityHashMap<a.C0114a, a> bzJ = new IdentityHashMap<>();
    public final Handler bzK = new Handler();
    final AbstractC0115e bzL;
    public final t bzM = new t("HlsPlaylistTracker:MasterPlaylist");
    public a.C0114a bzN;
    b bzO;
    public boolean bzP;
    public final List<b> listeners = new ArrayList();

    public interface b {
        void b(a.C0114a aVar);

        void vR();
    }

    /* renamed from: com.google.android.exoplayer2.source.b.a.e$e  reason: collision with other inner class name */
    public interface AbstractC0115e {
        void a(b bVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long, java.io.IOException] */
    @Override // com.google.android.exoplayer2.h.t.a
    public final /* bridge */ /* synthetic */ int a(u<c> uVar, long j2, long j3, IOException iOException) {
        AppMethodBeat.i(62920);
        u<c> uVar2 = uVar;
        boolean z = iOException instanceof o;
        this.byl.a(uVar2.bxj, j2, j3, uVar2.bFR, iOException, z);
        if (z) {
            AppMethodBeat.o(62920);
            return 3;
        }
        AppMethodBeat.o(62920);
        return 0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.android.exoplayer2.source.b.a.e] */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.google.android.exoplayer2.source.b.a.a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.exoplayer2.h.t.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.google.android.exoplayer2.h.u<com.google.android.exoplayer2.source.b.a.c> r11, long r12, long r14) {
        /*
        // Method dump skipped, instructions count: 148
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.a.e.a(com.google.android.exoplayer2.h.t$c, long, long):void");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long, boolean] */
    @Override // com.google.android.exoplayer2.h.t.a
    public final /* synthetic */ void a(u<c> uVar, long j2, long j3, boolean z) {
        AppMethodBeat.i(62921);
        u<c> uVar2 = uVar;
        this.byl.b(uVar2.bxj, j2, j3, uVar2.bFR);
        AppMethodBeat.o(62921);
    }

    public static final class d extends IOException {
        public final String url;

        /* synthetic */ d(String str, byte b2) {
            this(str);
        }

        private d(String str) {
            this.url = str;
        }
    }

    public static final class c extends IOException {
        public final String url;

        /* synthetic */ c(String str, byte b2) {
            this(str);
        }

        private c(String str) {
            this.url = str;
        }
    }

    public e(Uri uri, com.google.android.exoplayer2.source.b.d dVar, b.a aVar, int i2, AbstractC0115e eVar, u.a<c> aVar2) {
        AppMethodBeat.i(62914);
        this.bzH = uri;
        this.byk = dVar;
        this.byl = aVar;
        this.bzI = i2;
        this.bzL = eVar;
        this.byt = aVar2;
        AppMethodBeat.o(62914);
    }

    public final b c(a.C0114a aVar) {
        AppMethodBeat.i(62915);
        b bVar = this.bzJ.get(aVar).bzT;
        if (bVar != null) {
            e(aVar);
        }
        AppMethodBeat.o(62915);
        return bVar;
    }

    public final void d(a.C0114a aVar) {
        AppMethodBeat.i(62916);
        this.bzJ.get(aVar);
        AppMethodBeat.o(62916);
    }

    private void e(a.C0114a aVar) {
        AppMethodBeat.i(62917);
        if (aVar == this.bzN || !this.bxQ.byO.contains(aVar) || (this.bzO != null && this.bzO.byX)) {
            AppMethodBeat.o(62917);
            return;
        }
        this.bzN = aVar;
        this.bzJ.get(this.bzN).vX();
        AppMethodBeat.o(62917);
    }

    private void v(List<a.C0114a> list) {
        AppMethodBeat.i(62918);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0114a aVar = list.get(i2);
            this.bzJ.put(aVar, new a(aVar));
        }
        AppMethodBeat.o(62918);
    }

    static b.a a(b bVar, b bVar2) {
        AppMethodBeat.i(62919);
        int i2 = bVar2.byU - bVar.byU;
        List<b.a> list = bVar.segments;
        if (i2 < list.size()) {
            b.a aVar = list.get(i2);
            AppMethodBeat.o(62919);
            return aVar;
        }
        AppMethodBeat.o(62919);
        return null;
    }

    public final class a implements t.a<u<c>>, Runnable {
        private final a.C0114a bzQ;
        public final t bzR = new t("HlsPlaylistTracker:MediaPlaylist");
        private final u<c> bzS;
        public b bzT;
        public long bzU;
        private long bzV;
        private long bzW;
        private long bzX;
        private boolean bzY;
        private IOException bzZ;

        static /* synthetic */ void a(a aVar, b bVar) {
            AppMethodBeat.i(62913);
            aVar.b(bVar);
            AppMethodBeat.o(62913);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long, java.io.IOException] */
        @Override // com.google.android.exoplayer2.h.t.a
        public final /* synthetic */ int a(u<c> uVar, long j2, long j3, IOException iOException) {
            AppMethodBeat.i(62910);
            u<c> uVar2 = uVar;
            boolean z = iOException instanceof o;
            e.this.byl.a(uVar2.bxj, j2, j3, uVar2.bFR, iOException, z);
            if (z) {
                AppMethodBeat.o(62910);
                return 3;
            }
            boolean z2 = true;
            if (com.google.android.exoplayer2.source.a.b.f(iOException)) {
                z2 = vZ();
            }
            if (z2) {
                AppMethodBeat.o(62910);
                return 0;
            }
            AppMethodBeat.o(62910);
            return 2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long] */
        @Override // com.google.android.exoplayer2.h.t.a
        public final /* synthetic */ void a(u<c> uVar, long j2, long j3) {
            AppMethodBeat.i(62912);
            u<c> uVar2 = uVar;
            T t = uVar2.result;
            if (t instanceof b) {
                b((b) t);
                if (t.byX) {
                    e.this.byl.vm();
                }
                e.this.byl.a(uVar2.bxj, j2, j3, uVar2.bFR);
                AppMethodBeat.o(62912);
                return;
            }
            this.bzZ = new o("Loaded playlist has unexpected type.");
            AppMethodBeat.o(62912);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long, boolean] */
        @Override // com.google.android.exoplayer2.h.t.a
        public final /* synthetic */ void a(u<c> uVar, long j2, long j3, boolean z) {
            AppMethodBeat.i(62911);
            u<c> uVar2 = uVar;
            e.this.byl.b(uVar2.bxj, j2, j3, uVar2.bFR);
            AppMethodBeat.o(62911);
        }

        public a(a.C0114a aVar) {
            AppMethodBeat.i(62904);
            this.bzQ = aVar;
            this.bzS = new u<>(e.this.byk.vO(), w.m(e.this.bxQ.bzg, aVar.url), e.this.byt);
            AppMethodBeat.o(62904);
        }

        public final void vX() {
            AppMethodBeat.i(62905);
            this.bzX = 0;
            if (this.bzY || this.bzR.isLoading()) {
                AppMethodBeat.o(62905);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime < this.bzW) {
                this.bzY = true;
                e.this.bzK.postDelayed(this, this.bzW - elapsedRealtime);
                AppMethodBeat.o(62905);
                return;
            }
            vY();
            AppMethodBeat.o(62905);
        }

        public final void run() {
            AppMethodBeat.i(62906);
            this.bzY = false;
            vY();
            AppMethodBeat.o(62906);
        }

        private void vY() {
            AppMethodBeat.i(62907);
            this.bzR.a(this.bzS, this, e.this.bzI);
            AppMethodBeat.o(62907);
        }

        private void b(b bVar) {
            boolean z;
            long j2;
            int i2;
            b.a a2;
            b bVar2;
            int size;
            int size2;
            AppMethodBeat.i(62908);
            b bVar3 = this.bzT;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.bzU = elapsedRealtime;
            e eVar = e.this;
            if (bVar3 == null || bVar.byU > bVar3.byU) {
                z = true;
            } else {
                z = bVar.byU >= bVar3.byU && ((size = bVar.segments.size()) > (size2 = bVar3.segments.size()) || (size == size2 && bVar.byX && !bVar3.byX));
            }
            if (z) {
                if (bVar.byY) {
                    j2 = bVar.bxn;
                } else {
                    j2 = eVar.bzO != null ? eVar.bzO.bxn : 0;
                    if (bVar3 != null) {
                        int size3 = bVar3.segments.size();
                        b.a a3 = e.a(bVar3, bVar);
                        if (a3 != null) {
                            j2 = bVar3.bxn + a3.bzb;
                        } else if (size3 == bVar.byU - bVar3.byU) {
                            j2 = bVar3.vW();
                        }
                    }
                }
                if (bVar.byS) {
                    i2 = bVar.byT;
                } else {
                    i2 = eVar.bzO != null ? eVar.bzO.byT : 0;
                    if (!(bVar3 == null || (a2 = e.a(bVar3, bVar)) == null)) {
                        i2 = (bVar3.byT + a2.bza) - bVar.segments.get(0).bza;
                    }
                }
                bVar2 = new b(bVar.byQ, bVar.bzg, bVar.bzh, bVar.byR, j2, true, i2, bVar.byU, bVar.version, bVar.byV, bVar.byW, bVar.byX, bVar.byY, bVar.byZ, bVar.segments);
            } else if (bVar.byX) {
                bVar2 = bVar3.byX ? bVar3 : new b(bVar3.byQ, bVar3.bzg, bVar3.bzh, bVar3.byR, bVar3.bxn, bVar3.byS, bVar3.byT, bVar3.byU, bVar3.version, bVar3.byV, bVar3.byW, true, bVar3.byY, bVar3.byZ, bVar3.segments);
            } else {
                bVar2 = bVar3;
            }
            this.bzT = bVar2;
            if (this.bzT != bVar3) {
                this.bzZ = null;
                this.bzV = elapsedRealtime;
                e eVar2 = e.this;
                a.C0114a aVar = this.bzQ;
                b bVar4 = this.bzT;
                if (aVar == eVar2.bzN) {
                    if (eVar2.bzO == null) {
                        eVar2.bzP = !bVar4.byX;
                    }
                    eVar2.bzO = bVar4;
                    eVar2.bzL.a(bVar4);
                }
                int size4 = eVar2.listeners.size();
                for (int i3 = 0; i3 < size4; i3++) {
                    eVar2.listeners.get(i3).vR();
                }
            } else if (!this.bzT.byX) {
                if (bVar.byU + bVar.segments.size() < this.bzT.byU) {
                    this.bzZ = new c(this.bzQ.url, (byte) 0);
                } else if (((double) (elapsedRealtime - this.bzV)) > ((double) com.google.android.exoplayer2.b.v(this.bzT.byV)) * 3.5d) {
                    this.bzZ = new d(this.bzQ.url, (byte) 0);
                    vZ();
                }
            }
            this.bzW = com.google.android.exoplayer2.b.v(this.bzT != bVar3 ? this.bzT.byV : this.bzT.byV / 2) + elapsedRealtime;
            if (this.bzQ == e.this.bzN && !this.bzT.byX) {
                vX();
            }
            AppMethodBeat.o(62908);
        }

        private boolean vZ() {
            AppMethodBeat.i(62909);
            this.bzX = SystemClock.elapsedRealtime() + Util.MILLSECONDS_OF_MINUTE;
            e.a(e.this, this.bzQ);
            if (e.this.bzN != this.bzQ || e.a(e.this)) {
                AppMethodBeat.o(62909);
                return false;
            }
            AppMethodBeat.o(62909);
            return true;
        }
    }

    static /* synthetic */ void a(e eVar, a.C0114a aVar) {
        AppMethodBeat.i(62923);
        int size = eVar.listeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            eVar.listeners.get(i2).b(aVar);
        }
        AppMethodBeat.o(62923);
    }

    static /* synthetic */ boolean a(e eVar) {
        AppMethodBeat.i(62924);
        List<a.C0114a> list = eVar.bxQ.byO;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = eVar.bzJ.get(list.get(i2));
            if (elapsedRealtime > aVar.bzX) {
                eVar.bzN = aVar.bzQ;
                aVar.vX();
                AppMethodBeat.o(62924);
                return true;
            }
        }
        AppMethodBeat.o(62924);
        return false;
    }
}
