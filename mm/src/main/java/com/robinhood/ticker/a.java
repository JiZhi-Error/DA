package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class a {
    public static int[] a(char[] cArr, char[] cArr2, Set<Character> set) {
        AppMethodBeat.i(39838);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean z = i3 == cArr.length;
            boolean z2 = i2 == cArr2.length;
            if (z && z2) {
                break;
            } else if (z) {
                b(arrayList, cArr2.length - i2, 1);
                break;
            } else if (z2) {
                b(arrayList, cArr.length - i3, 2);
                break;
            } else {
                boolean contains = set.contains(Character.valueOf(cArr[i3]));
                boolean contains2 = set.contains(Character.valueOf(cArr2[i2]));
                if (contains && contains2) {
                    int a2 = a(cArr, i3 + 1, set);
                    int a3 = a(cArr2, i2 + 1, set);
                    a(arrayList, cArr, cArr2, i3, a2, i2, a3);
                    i2 = a3;
                    i3 = a2;
                } else if (contains) {
                    arrayList.add(1);
                    i2++;
                } else if (contains2) {
                    arrayList.add(2);
                    i3++;
                } else {
                    arrayList.add(0);
                    i3++;
                    i2++;
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
        AppMethodBeat.o(39838);
        return iArr;
    }

    private static int a(char[] cArr, int i2, Set<Character> set) {
        AppMethodBeat.i(39839);
        while (i2 < cArr.length) {
            if (!set.contains(Character.valueOf(cArr[i2]))) {
                AppMethodBeat.o(39839);
                return i2;
            }
            i2++;
        }
        int length = cArr.length;
        AppMethodBeat.o(39839);
        return length;
    }

    private static void b(List<Integer> list, int i2, int i3) {
        AppMethodBeat.i(39840);
        for (int i4 = 0; i4 < i2; i4++) {
            list.add(Integer.valueOf(i3));
        }
        AppMethodBeat.o(39840);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: java.util.List<java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    private static void a(List<Integer> list, char[] cArr, char[] cArr2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(39841);
        int i6 = i3 - i2;
        int i7 = i5 - i4;
        int max = Math.max(i6, i7);
        if (i6 == i7) {
            b(list, max, 0);
            AppMethodBeat.o(39841);
            return;
        }
        int i8 = i6 + 1;
        int i9 = i7 + 1;
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, i8, i9);
        for (int i10 = 0; i10 < i8; i10++) {
            iArr[i10][0] = i10;
        }
        for (int i11 = 0; i11 < i9; i11++) {
            iArr[0][i11] = i11;
        }
        for (int i12 = 1; i12 < i8; i12++) {
            for (int i13 = 1; i13 < i9; i13++) {
                iArr[i12][i13] = Math.min(iArr[i12 - 1][i13] + 1, Math.min(iArr[i12][i13 - 1] + 1, (cArr[(i12 + -1) + i2] == cArr2[(i13 + -1) + i4] ? 0 : 1) + iArr[i12 - 1][i13 - 1]));
            }
        }
        ArrayList arrayList = new ArrayList(max * 2);
        int i14 = i8 - 1;
        int i15 = i9 - 1;
        while (true) {
            if (i14 <= 0 && i15 <= 0) {
                break;
            } else if (i14 == 0) {
                arrayList.add(1);
                i15--;
            } else if (i15 == 0) {
                arrayList.add(2);
                i14--;
            } else {
                int i16 = iArr[i14][i15 - 1];
                int i17 = iArr[i14 - 1][i15];
                int i18 = iArr[i14 - 1][i15 - 1];
                if (i16 < i17 && i16 < i18) {
                    arrayList.add(1);
                    i15--;
                } else if (i17 < i18) {
                    arrayList.add(2);
                    i14--;
                } else {
                    arrayList.add(0);
                    i14--;
                    i15--;
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            list.add(arrayList.get(size));
        }
        AppMethodBeat.o(39841);
    }
}
