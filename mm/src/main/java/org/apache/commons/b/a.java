package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import org.apache.commons.b.a.b;

public final class a {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final short[] Sgj = new short[0];
    public static final Object[] UeK = new Object[0];
    public static final Class[] UeL = new Class[0];
    public static final Long[] UeM = new Long[0];
    public static final Integer[] UeN = new Integer[0];
    public static final Short[] UeO = new Short[0];
    public static final Byte[] UeP = new Byte[0];
    public static final Double[] UeQ = new Double[0];
    public static final Float[] UeR = new Float[0];
    public static final Boolean[] UeS = new Boolean[0];
    public static final char[] UeT = new char[0];
    public static final Character[] UeU = new Character[0];
    public static final int[] bYn = new int[0];
    public static final long[] cbp = new long[0];
    public static final float[] cbq = new float[0];
    public static final double[] cbr = new double[0];
    public static final boolean[] cbs = new boolean[0];

    public static String toString(Object obj) {
        AppMethodBeat.i(40692);
        String aVar = toString(obj, "{}");
        AppMethodBeat.o(40692);
        return aVar;
    }

    public static String toString(Object obj, String str) {
        AppMethodBeat.i(40693);
        if (obj == null) {
            AppMethodBeat.o(40693);
            return str;
        }
        String aVar = new org.apache.commons.b.a.a(obj, b.UgV).gB(obj).toString();
        AppMethodBeat.o(40693);
        return aVar;
    }

    public static Object[] g(Object[] objArr, int i2) {
        AppMethodBeat.i(193641);
        if (objArr == null) {
            AppMethodBeat.o(193641);
            return null;
        }
        if (i2 > objArr.length) {
            i2 = objArr.length;
        }
        int i3 = i2 - 1;
        Class<?> componentType = objArr.getClass().getComponentType();
        if (i3 <= 0) {
            Object[] objArr2 = (Object[]) Array.newInstance(componentType, 0);
            AppMethodBeat.o(193641);
            return objArr2;
        }
        Object[] objArr3 = (Object[]) Array.newInstance(componentType, i3);
        System.arraycopy(objArr, 1, objArr3, 0, i3);
        AppMethodBeat.o(193641);
        return objArr3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000e A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean contains(int[] r4, int r5) {
        /*
            r1 = 0
            r2 = -1
            if (r4 == 0) goto L_0x0013
            r0 = r1
        L_0x0005:
            int r3 = r4.length
            if (r0 >= r3) goto L_0x0013
            r3 = r4[r0]
            if (r5 != r3) goto L_0x0010
        L_0x000c:
            if (r0 == r2) goto L_0x000f
            r1 = 1
        L_0x000f:
            return r1
        L_0x0010:
            int r0 = r0 + 1
            goto L_0x0005
        L_0x0013:
            r0 = r2
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.b.a.contains(int[], int):boolean");
    }

    public static boolean contains(Object[] objArr, Object obj) {
        int i2;
        AppMethodBeat.i(40694);
        if (objArr != null) {
            if (obj == null) {
                i2 = 0;
                while (true) {
                    if (i2 >= objArr.length) {
                        break;
                    } else if (objArr[i2] == null) {
                        break;
                    } else {
                        i2++;
                    }
                }
            } else if (objArr.getClass().getComponentType().isInstance(obj)) {
                i2 = 0;
                while (true) {
                    if (i2 < objArr.length) {
                        if (obj.equals(objArr[i2])) {
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
        }
        i2 = -1;
        if (i2 != -1) {
            AppMethodBeat.o(40694);
            return true;
        }
        AppMethodBeat.o(40694);
        return false;
    }
}
