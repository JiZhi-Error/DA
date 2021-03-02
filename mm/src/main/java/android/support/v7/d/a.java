package android.support.v7.d;

import android.graphics.Color;
import android.support.v7.d.b;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* access modifiers changed from: package-private */
public final class a {
    private static final Comparator<C0044a> abd = new Comparator<C0044a>() {
        /* class android.support.v7.d.a.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(C0044a aVar, C0044a aVar2) {
            return aVar2.getVolume() - aVar.getVolume();
        }
    };
    final int[] aaY;
    final List<b.d> aaZ;
    final TimingLogger aba = null;
    final b.AbstractC0047b[] abb;
    private final float[] abc = new float[3];
    final int[] mColors;

    a(int[] iArr, int i2, b.AbstractC0047b[] bVarArr) {
        int i3;
        this.abb = bVarArr;
        int[] iArr2 = new int[32768];
        this.aaY = iArr2;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            int k = k(Color.blue(i5), 8, 5) | (k(Color.red(i5), 8, 5) << 10) | (k(Color.green(i5), 8, 5) << 5);
            iArr[i4] = k;
            iArr2[k] = iArr2[k] + 1;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < 32768; i7++) {
            if (iArr2[i7] > 0) {
                android.support.v4.graphics.b.d(bp(i7), this.abc);
                if (d(this.abc)) {
                    iArr2[i7] = 0;
                }
            }
            if (iArr2[i7] > 0) {
                i6++;
            }
        }
        int[] iArr3 = new int[i6];
        this.mColors = iArr3;
        int i8 = 0;
        int i9 = 0;
        while (i8 < 32768) {
            if (iArr2[i8] > 0) {
                i3 = i9 + 1;
                iArr3[i9] = i8;
            } else {
                i3 = i9;
            }
            i8++;
            i9 = i3;
        }
        if (i6 <= i2) {
            this.aaZ = new ArrayList();
            for (int i10 : iArr3) {
                this.aaZ.add(new b.d(bp(i10), iArr2[i10]));
            }
            return;
        }
        PriorityQueue priorityQueue = new PriorityQueue(i2, abd);
        priorityQueue.offer(new C0044a(0, this.mColors.length - 1));
        a(priorityQueue, i2);
        this.aaZ = a(priorityQueue);
    }

    private static void a(PriorityQueue<C0044a> priorityQueue, int i2) {
        C0044a poll;
        while (priorityQueue.size() < i2 && (poll = priorityQueue.poll()) != null && poll.hc()) {
            if (!poll.hc()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int hf = poll.hf();
            C0044a aVar = new C0044a(hf + 1, poll.abf);
            poll.abf = hf;
            poll.he();
            priorityQueue.offer(aVar);
            priorityQueue.offer(poll);
        }
    }

    private List<b.d> a(Collection<C0044a> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (C0044a aVar : collection) {
            b.d hg = aVar.hg();
            if (!d(hg.hn())) {
                arrayList.add(hg);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v7.d.a$a  reason: collision with other inner class name */
    public class C0044a {
        private int abe;
        int abf;
        private int abg;
        private int abh;
        private int abj;
        private int abk;
        private int abl;
        private int abm;
        private int abn;

        C0044a(int i2, int i3) {
            this.abe = i2;
            this.abf = i3;
            he();
        }

        /* access modifiers changed from: package-private */
        public final int getVolume() {
            return ((this.abj - this.abh) + 1) * ((this.abl - this.abk) + 1) * ((this.abn - this.abm) + 1);
        }

        /* access modifiers changed from: package-private */
        public final boolean hc() {
            return hd() > 1;
        }

        private int hd() {
            return (this.abf + 1) - this.abe;
        }

        /* access modifiers changed from: package-private */
        public final void he() {
            int i2;
            int[] iArr = a.this.mColors;
            int[] iArr2 = a.this.aaY;
            int i3 = 0;
            int i4 = this.abe;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = Integer.MAX_VALUE;
            int i9 = Integer.MAX_VALUE;
            int i10 = Integer.MAX_VALUE;
            while (i4 <= this.abf) {
                int i11 = iArr[i4];
                i3 += iArr2[i11];
                int bq = a.bq(i11);
                int br = a.br(i11);
                int bs = a.bs(i11);
                if (bq > i5) {
                    i5 = bq;
                }
                if (bq < i8) {
                    i8 = bq;
                }
                if (br > i6) {
                    i2 = br;
                } else {
                    i2 = i6;
                }
                if (br >= i9) {
                    br = i9;
                }
                if (bs > i7) {
                    i7 = bs;
                }
                if (bs < i10) {
                    i10 = bs;
                }
                i4++;
                i6 = i2;
                i9 = br;
            }
            this.abh = i8;
            this.abj = i5;
            this.abk = i9;
            this.abl = i6;
            this.abm = i10;
            this.abn = i7;
            this.abg = i3;
        }

        /* access modifiers changed from: package-private */
        public final b.d hg() {
            int[] iArr = a.this.mColors;
            int[] iArr2 = a.this.aaY;
            int i2 = this.abe;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i2 <= this.abf) {
                int i7 = iArr[i2];
                int i8 = iArr2[i7];
                i3 += i8;
                i6 += a.bq(i7) * i8;
                i5 += a.br(i7) * i8;
                i2++;
                i4 = (a.bs(i7) * i8) + i4;
            }
            return new b.d(a.j(Math.round(((float) i6) / ((float) i3)), Math.round(((float) i5) / ((float) i3)), Math.round(((float) i4) / ((float) i3))), i3);
        }

        /* access modifiers changed from: package-private */
        public final int hf() {
            int i2;
            int i3 = this.abj - this.abh;
            int i4 = this.abl - this.abk;
            int i5 = this.abn - this.abm;
            if (i3 >= i4 && i3 >= i5) {
                i2 = -3;
            } else if (i4 < i3 || i4 < i5) {
                i2 = -1;
            } else {
                i2 = -2;
            }
            int[] iArr = a.this.mColors;
            int[] iArr2 = a.this.aaY;
            a.a(iArr, i2, this.abe, this.abf);
            Arrays.sort(iArr, this.abe, this.abf + 1);
            a.a(iArr, i2, this.abe, this.abf);
            int i6 = this.abg / 2;
            int i7 = 0;
            for (int i8 = this.abe; i8 <= this.abf; i8++) {
                i7 += iArr2[iArr[i8]];
                if (i7 >= i6) {
                    return Math.min(this.abf - 1, i8);
                }
            }
            return this.abe;
        }
    }

    static void a(int[] iArr, int i2, int i3, int i4) {
        switch (i2) {
            case -3:
            default:
                return;
            case -2:
                while (i3 <= i4) {
                    int i5 = iArr[i3];
                    iArr[i3] = (i5 & 31) | (((i5 >> 5) & 31) << 10) | (((i5 >> 10) & 31) << 5);
                    i3++;
                }
                return;
            case -1:
                while (i3 <= i4) {
                    int i6 = iArr[i3];
                    iArr[i3] = ((i6 >> 10) & 31) | ((i6 & 31) << 10) | (((i6 >> 5) & 31) << 5);
                    i3++;
                }
                return;
        }
    }

    private boolean d(float[] fArr) {
        if (this.abb == null || this.abb.length <= 0) {
            return false;
        }
        int length = this.abb.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!this.abb[i2].e(fArr)) {
                return true;
            }
        }
        return false;
    }

    static int j(int i2, int i3, int i4) {
        return Color.rgb(k(i2, 5, 8), k(i3, 5, 8), k(i4, 5, 8));
    }

    static int bq(int i2) {
        return (i2 >> 10) & 31;
    }

    static int br(int i2) {
        return (i2 >> 5) & 31;
    }

    static int bs(int i2) {
        return i2 & 31;
    }

    private static int k(int i2, int i3, int i4) {
        int i5;
        if (i4 > i3) {
            i5 = i2 << (i4 - i3);
        } else {
            i5 = i2 >> (i3 - i4);
        }
        return i5 & ((1 << i4) - 1);
    }

    private static int bp(int i2) {
        return j((i2 >> 10) & 31, (i2 >> 5) & 31, i2 & 31);
    }
}
