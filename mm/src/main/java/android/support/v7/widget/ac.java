package android.support.v7.widget;

import android.support.v4.os.e;
import android.support.v7.widget.RecyclerView;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
public final class ac implements Runnable {
    static final ThreadLocal<ac> anQ = new ThreadLocal<>();
    static Comparator<b> anV = new Comparator<b>() {
        /* class android.support.v7.widget.ac.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(b bVar, b bVar2) {
            b bVar3 = bVar;
            b bVar4 = bVar2;
            if ((bVar3.aoc == null) != (bVar4.aoc == null)) {
                return bVar3.aoc == null ? 1 : -1;
            }
            if (bVar3.anZ != bVar4.anZ) {
                return bVar3.anZ ? -1 : 1;
            }
            int i2 = bVar4.aoa - bVar3.aoa;
            if (i2 != 0) {
                return i2;
            }
            int i3 = bVar3.aob - bVar4.aob;
            if (i3 == 0) {
                return 0;
            }
            return i3;
        }
    };
    ArrayList<RecyclerView> anR = new ArrayList<>();
    long anS;
    long anT;
    private ArrayList<b> anU = new ArrayList<>();

    ac() {
    }

    static class b {
        public boolean anZ;
        public int aoa;
        public int aob;
        public RecyclerView aoc;
        public int position;

        b() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements RecyclerView.LayoutManager.a {
        int anW;
        int anX;
        int[] anY;
        int mCount;

        a() {
        }

        /* access modifiers changed from: package-private */
        public final void a(RecyclerView recyclerView, boolean z) {
            this.mCount = 0;
            if (this.anY != null) {
                Arrays.fill(this.anY, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.asc;
            if (recyclerView.adj != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.arX.jc()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.adj.getItemCount(), this);
                    }
                } else if (!recyclerView.lt()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.anW, this.anX, recyclerView.asR, this);
                }
                if (this.mCount > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = this.mCount;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.arV.lI();
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.LayoutManager.a
        public final void S(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i3 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            } else {
                int i4 = this.mCount * 2;
                if (this.anY == null) {
                    this.anY = new int[4];
                    Arrays.fill(this.anY, -1);
                } else if (i4 >= this.anY.length) {
                    int[] iArr = this.anY;
                    this.anY = new int[(i4 * 2)];
                    System.arraycopy(iArr, 0, this.anY, 0, iArr.length);
                }
                this.anY[i4] = i2;
                this.anY[i4 + 1] = i3;
                this.mCount++;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean bP(int i2) {
            if (this.anY == null) {
                return false;
            }
            int i3 = this.mCount * 2;
            for (int i4 = 0; i4 < i3; i4 += 2) {
                if (this.anY[i4] == i2) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void jL() {
            if (this.anY != null) {
                Arrays.fill(this.anY, -1);
            }
            this.mCount = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.anS == 0) {
            this.anS = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        a aVar = recyclerView.asQ;
        aVar.anW = i2;
        aVar.anX = i3;
    }

    private static RecyclerView.v a(RecyclerView recyclerView, int i2, long j2) {
        boolean z;
        int jA = recyclerView.mChildHelper.jA();
        int i3 = 0;
        while (true) {
            if (i3 >= jA) {
                z = false;
                break;
            }
            RecyclerView.v bv = RecyclerView.bv(recyclerView.mChildHelper.bM(i3));
            if (bv.mPosition == i2 && !bv.isInvalid()) {
                z = true;
                break;
            }
            i3++;
        }
        if (z) {
            return null;
        }
        RecyclerView.n nVar = recyclerView.arV;
        try {
            recyclerView.la();
            RecyclerView.v e2 = nVar.e(i2, j2);
            if (e2 != null) {
                if (!e2.isBound() || e2.isInvalid()) {
                    nVar.a(e2, false);
                } else {
                    nVar.bF(e2.aus);
                }
            }
            return e2;
        } finally {
            recyclerView.as(false);
        }
    }

    public final void run() {
        RecyclerView recyclerView;
        int i2;
        b bVar;
        int i3;
        long j2;
        try {
            e.beginSection("RV Prefetch");
            if (!this.anR.isEmpty()) {
                int size = this.anR.size();
                long j3 = 0;
                int i4 = 0;
                while (i4 < size) {
                    RecyclerView recyclerView2 = this.anR.get(i4);
                    if (recyclerView2.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView2.getDrawingTime(), j3);
                    } else {
                        j2 = j3;
                    }
                    i4++;
                    j3 = j2;
                }
                if (j3 == 0) {
                    this.anS = 0;
                    e.endSection();
                    return;
                }
                long nanos = TimeUnit.MILLISECONDS.toNanos(j3) + this.anT;
                int size2 = this.anR.size();
                int i5 = 0;
                int i6 = 0;
                while (i6 < size2) {
                    RecyclerView recyclerView3 = this.anR.get(i6);
                    if (recyclerView3.getWindowVisibility() == 0) {
                        recyclerView3.asQ.a(recyclerView3, false);
                        i3 = recyclerView3.asQ.mCount + i5;
                    } else {
                        i3 = i5;
                    }
                    i6++;
                    i5 = i3;
                }
                this.anU.ensureCapacity(i5);
                int i7 = 0;
                for (int i8 = 0; i8 < size2; i8++) {
                    RecyclerView recyclerView4 = this.anR.get(i8);
                    if (recyclerView4.getWindowVisibility() == 0) {
                        a aVar = recyclerView4.asQ;
                        int abs = Math.abs(aVar.anW) + Math.abs(aVar.anX);
                        int i9 = i7;
                        for (int i10 = 0; i10 < aVar.mCount * 2; i10 += 2) {
                            if (i9 >= this.anU.size()) {
                                b bVar2 = new b();
                                this.anU.add(bVar2);
                                bVar = bVar2;
                            } else {
                                bVar = this.anU.get(i9);
                            }
                            int i11 = aVar.anY[i10 + 1];
                            bVar.anZ = i11 <= abs;
                            bVar.aoa = abs;
                            bVar.aob = i11;
                            bVar.aoc = recyclerView4;
                            bVar.position = aVar.anY[i10];
                            i9++;
                        }
                        i2 = i9;
                    } else {
                        i2 = i7;
                    }
                    i7 = i2;
                }
                Collections.sort(this.anU, anV);
                for (int i12 = 0; i12 < this.anU.size(); i12++) {
                    b bVar3 = this.anU.get(i12);
                    if (bVar3.aoc == null) {
                        break;
                    }
                    RecyclerView.v a2 = a(bVar3.aoc, bVar3.position, bVar3.anZ ? MAlarmHandler.NEXT_FIRE_INTERVAL : nanos);
                    if (!(a2 == null || a2.aut == null || !a2.isBound() || a2.isInvalid() || (recyclerView = a2.aut.get()) == null)) {
                        if (recyclerView.ast && recyclerView.mChildHelper.jA() != 0) {
                            recyclerView.kM();
                        }
                        a aVar2 = recyclerView.asQ;
                        aVar2.a(recyclerView, true);
                        if (aVar2.mCount != 0) {
                            try {
                                e.beginSection("RV Nested Prefetch");
                                RecyclerView.s sVar = recyclerView.asR;
                                RecyclerView.a aVar3 = recyclerView.adj;
                                sVar.aub = 1;
                                sVar.auc = aVar3.getItemCount();
                                sVar.aue = false;
                                sVar.auf = false;
                                sVar.aug = false;
                                for (int i13 = 0; i13 < aVar2.mCount * 2; i13 += 2) {
                                    a(recyclerView, aVar2.anY[i13], nanos);
                                }
                            } finally {
                                e.endSection();
                            }
                        }
                    }
                    bVar3.anZ = false;
                    bVar3.aoa = 0;
                    bVar3.aob = 0;
                    bVar3.aoc = null;
                    bVar3.position = 0;
                }
                this.anS = 0;
                e.endSection();
            }
        } finally {
            this.anS = 0;
            e.endSection();
        }
    }
}
