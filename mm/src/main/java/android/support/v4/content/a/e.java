package android.support.v4.content.a;

import java.lang.reflect.Array;

final class e {
    static final /* synthetic */ boolean $assertionsDisabled = (!e.class.desiredAssertionStatus());

    public static <T> T[] a(T[] tArr, int i2, T t) {
        T[] tArr2;
        if ($assertionsDisabled || i2 <= tArr.length) {
            if (i2 + 1 > tArr.length) {
                tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), av(i2)));
                System.arraycopy(tArr, 0, tArr2, 0, i2);
            } else {
                tArr2 = tArr;
            }
            tArr2[i2] = t;
            return tArr2;
        }
        throw new AssertionError();
    }

    public static int[] a(int[] iArr, int i2, int i3) {
        if ($assertionsDisabled || i2 <= iArr.length) {
            if (i2 + 1 > iArr.length) {
                int[] iArr2 = new int[av(i2)];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                iArr = iArr2;
            }
            iArr[i2] = i3;
            return iArr;
        }
        throw new AssertionError();
    }

    private static int av(int i2) {
        if (i2 <= 4) {
            return 8;
        }
        return i2 * 2;
    }

    private e() {
    }
}
