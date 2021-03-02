package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.google.b.g;
import java.util.Map;

public abstract class o implements g {
    public abstract boolean[] ct(String str);

    @Override // com.google.b.g
    public b a(String str, a aVar, int i2, int i3, Map<c, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i2 + 'x' + i3);
        } else {
            int Ix = Ix();
            if (map != null && map.containsKey(c.MARGIN)) {
                Ix = Integer.parseInt(map.get(c.MARGIN).toString());
            }
            return a(ct(str), i2, i3, Ix);
        }
    }

    private static b a(boolean[] zArr, int i2, int i3, int i4) {
        int length = zArr.length;
        int i5 = length + i4;
        int max = Math.max(i2, i5);
        int max2 = Math.max(1, i3);
        int i6 = max / i5;
        int i7 = (max - (length * i6)) / 2;
        b bVar = new b(max, max2);
        int i8 = 0;
        while (i8 < length) {
            if (zArr[i8]) {
                bVar.p(i7, 0, i6, max2);
            }
            i8++;
            i7 += i6;
        }
        return bVar;
    }

    protected static int a(boolean[] zArr, int i2, int[] iArr, boolean z) {
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        while (i3 < length) {
            int i6 = iArr[i3];
            int i7 = 0;
            while (i7 < i6) {
                zArr[i5] = z;
                i7++;
                i5++;
            }
            i4 += i6;
            i3++;
            z = !z;
        }
        return i4;
    }

    public int Ix() {
        return 10;
    }
}
