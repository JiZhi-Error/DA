package com.google.android.exoplayer2.i;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;

public final class w {
    public static Uri m(String str, String str2) {
        AppMethodBeat.i(93212);
        Uri parse = Uri.parse(n(str, str2));
        AppMethodBeat.o(93212);
        return parse;
    }

    private static String n(String str, String str2) {
        AppMethodBeat.i(93213);
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] bD = bD(str2);
        if (bD[0] != -1) {
            sb.append(str2);
            a(sb, bD[1], bD[2]);
            String sb2 = sb.toString();
            AppMethodBeat.o(93213);
            return sb2;
        }
        int[] bD2 = bD(str);
        if (bD[3] == 0) {
            String sb3 = sb.append((CharSequence) str, 0, bD2[3]).append(str2).toString();
            AppMethodBeat.o(93213);
            return sb3;
        } else if (bD[2] == 0) {
            String sb4 = sb.append((CharSequence) str, 0, bD2[2]).append(str2).toString();
            AppMethodBeat.o(93213);
            return sb4;
        } else if (bD[1] != 0) {
            int i2 = bD2[0] + 1;
            sb.append((CharSequence) str, 0, i2).append(str2);
            String a2 = a(sb, bD[1] + i2, i2 + bD[2]);
            AppMethodBeat.o(93213);
            return a2;
        } else if (str2.charAt(bD[1]) == '/') {
            sb.append((CharSequence) str, 0, bD2[1]).append(str2);
            String a3 = a(sb, bD2[1], bD[2] + bD2[1]);
            AppMethodBeat.o(93213);
            return a3;
        } else if (bD2[0] + 2 >= bD2[1] || bD2[1] != bD2[2]) {
            int lastIndexOf = str.lastIndexOf(47, bD2[2] - 1);
            int i3 = lastIndexOf == -1 ? bD2[1] : lastIndexOf + 1;
            sb.append((CharSequence) str, 0, i3).append(str2);
            String a4 = a(sb, bD2[1], i3 + bD[2]);
            AppMethodBeat.o(93213);
            return a4;
        } else {
            sb.append((CharSequence) str, 0, bD2[1]).append('/').append(str2);
            String a5 = a(sb, bD2[1], bD[2] + bD2[1] + 1);
            AppMethodBeat.o(93213);
            return a5;
        }
    }

    private static String a(StringBuilder sb, int i2, int i3) {
        int i4;
        AppMethodBeat.i(93214);
        if (i2 >= i3) {
            String sb2 = sb.toString();
            AppMethodBeat.o(93214);
            return sb2;
        }
        if (sb.charAt(i2) == '/') {
            i2++;
        }
        int i5 = i2;
        int i6 = i2;
        while (i5 <= i3) {
            if (i5 == i3) {
                i4 = i5;
            } else if (sb.charAt(i5) == '/') {
                i4 = i5 + 1;
            } else {
                i5++;
            }
            if (i5 == i6 + 1 && sb.charAt(i6) == '.') {
                sb.delete(i6, i4);
                i3 -= i4 - i6;
                i5 = i6;
            } else if (i5 == i6 + 2 && sb.charAt(i6) == '.' && sb.charAt(i6 + 1) == '.') {
                int lastIndexOf = sb.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP, i6 - 2) + 1;
                int i7 = lastIndexOf > i2 ? lastIndexOf : i2;
                sb.delete(i7, i4);
                i3 -= i4 - i7;
                i5 = lastIndexOf;
                i6 = lastIndexOf;
            } else {
                int i8 = i5 + 1;
                i5 = i8;
                i6 = i8;
            }
        }
        String sb3 = sb.toString();
        AppMethodBeat.o(93214);
        return sb3;
    }

    private static int[] bD(String str) {
        int i2;
        AppMethodBeat.i(93215);
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            AppMethodBeat.o(93215);
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        if (indexOf4 + 2 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(indexOf4 + 2) == '/') {
            i2 = str.indexOf(47, indexOf4 + 3);
            if (i2 == -1 || i2 > indexOf2) {
                i2 = indexOf2;
            }
        } else {
            i2 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i2;
        iArr[2] = indexOf2;
        iArr[3] = length;
        AppMethodBeat.o(93215);
        return iArr;
    }
}
