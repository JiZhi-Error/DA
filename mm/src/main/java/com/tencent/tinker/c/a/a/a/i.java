package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.b.a;
import com.tencent.tinker.c.a.c.c;
import java.lang.Comparable;
import java.util.Arrays;

public abstract class i<T extends Comparable<T>> {
    protected final com.tencent.tinker.a.a.i Shw;
    protected final a Shy;
    private final c Shz;

    /* access modifiers changed from: protected */
    public abstract T a(com.tencent.tinker.a.a.a.a aVar);

    /* access modifiers changed from: protected */
    public abstract s.a c(com.tencent.tinker.a.a.i iVar);

    /* access modifiers changed from: protected */
    public abstract int f(T t);

    public i(a aVar, com.tencent.tinker.a.a.i iVar, c cVar) {
        this.Shy = aVar;
        this.Shw = iVar;
        this.Shz = cVar;
    }

    /* access modifiers changed from: protected */
    public T a(com.tencent.tinker.c.a.c.a aVar, T t) {
        return t;
    }

    /* access modifiers changed from: protected */
    public void a(c cVar, int i2, int i3, int i4, int i5) {
    }

    /* access modifiers changed from: protected */
    public void a(c cVar, int i2, int i3) {
    }

    private int[] asf(int i2) {
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int a2 = o.a(this.Shy.Siv) + i4;
            iArr[i3] = a2;
            i3++;
            i4 = a2;
        }
        return iArr;
    }

    private static int a(int i2, T t) {
        if (t instanceof s.a.AbstractC2212a) {
            return ((s.a.AbstractC2212a) t).off;
        }
        return i2;
    }

    public final void execute() {
        int i2;
        i.e eVar;
        int[] asf = asf(o.b(this.Shy.Siv));
        int[] asf2 = asf(o.b(this.Shy.Siv));
        int[] asf3 = asf(o.b(this.Shy.Siv));
        s.a c2 = c(this.Shw);
        if (c2.exists()) {
            i.e a2 = this.Shw.a(c2);
            i2 = c2.size;
            eVar = a2;
        } else {
            i2 = 0;
            eVar = null;
        }
        int length = asf.length;
        int length2 = asf2.length;
        int length3 = asf3.length;
        int i3 = (i2 + length2) - length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i4 >= i2 && i5 >= i3) {
                break;
            } else if (i7 < length2 && asf2[i7] == i5) {
                f(a(this.Shy.Siv));
                i5++;
                i7++;
            } else if (i6 < length3 && asf3[i6] == i5) {
                f(a(this.Shy.Siv));
                i5++;
                i6++;
            } else if (Arrays.binarySearch(asf, i4) >= 0) {
                a(this.Shz, i4, a(i4, a(eVar)));
                i4++;
                i8++;
            } else if (Arrays.binarySearch(asf3, i4) >= 0) {
                a(this.Shz, i4, a(i4, a(eVar)));
                i4++;
            } else if (i4 < i2) {
                T a3 = a(this.Shz, a(eVar));
                a(this.Shz, i4, a(i4, a3), i5, f(a3));
                i4++;
                i5++;
            }
        }
        if (i7 != length2 || i8 != length || i6 != length3) {
            throw new IllegalStateException(String.format("bad patch operation sequence. addCounter: %d, addCount: %d, delCounter: %d, delCount: %d, replaceCounter: %d, replaceCount:%d", Integer.valueOf(i7), Integer.valueOf(length2), Integer.valueOf(i8), Integer.valueOf(length), Integer.valueOf(i6), Integer.valueOf(length3)));
        }
    }
}
