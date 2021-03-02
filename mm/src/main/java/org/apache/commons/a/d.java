package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class d {
    public static final String UeB = Character.toString('.');
    private static final char UeC;
    private static final char UeD;

    static {
        boolean z;
        AppMethodBeat.i(10303);
        char c2 = File.separatorChar;
        UeC = c2;
        if (c2 == '\\') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            UeD = '/';
            AppMethodBeat.o(10303);
            return;
        }
        UeD = '\\';
        AppMethodBeat.o(10303);
    }

    private static boolean isSeparator(char c2) {
        return c2 == '/' || c2 == '\\';
    }

    private static String normalize(String str) {
        boolean z;
        int i2;
        AppMethodBeat.i(10296);
        char c2 = UeC;
        if (str == null) {
            AppMethodBeat.o(10296);
            return null;
        }
        bvb(str);
        int length = str.length();
        if (length == 0) {
            AppMethodBeat.o(10296);
            return str;
        }
        int buZ = buZ(str);
        if (buZ < 0) {
            AppMethodBeat.o(10296);
            return null;
        }
        char[] cArr = new char[(length + 2)];
        str.getChars(0, str.length(), cArr, 0);
        char c3 = c2 == UeC ? UeD : UeC;
        for (int i3 = 0; i3 < cArr.length; i3++) {
            if (cArr[i3] == c3) {
                cArr[i3] = c2;
            }
        }
        if (cArr[length - 1] != c2) {
            i2 = length + 1;
            cArr[length] = c2;
            z = false;
        } else {
            z = true;
            i2 = length;
        }
        int i4 = buZ + 1;
        while (i4 < i2) {
            if (cArr[i4] == c2 && cArr[i4 - 1] == c2) {
                System.arraycopy(cArr, i4, cArr, i4 - 1, i2 - i4);
                i2--;
                i4--;
            }
            i4++;
        }
        int i5 = buZ + 1;
        while (i5 < i2) {
            if (cArr[i5] == c2 && cArr[i5 - 1] == '.' && (i5 == buZ + 1 || cArr[i5 - 2] == c2)) {
                if (i5 == i2 - 1) {
                    z = true;
                }
                System.arraycopy(cArr, i5 + 1, cArr, i5 - 1, i2 - i5);
                i2 -= 2;
                i5--;
            }
            i5++;
        }
        int i6 = buZ + 2;
        while (i6 < i2) {
            if (cArr[i6] == c2 && cArr[i6 - 1] == '.' && cArr[i6 - 2] == '.' && (i6 == buZ + 2 || cArr[i6 - 3] == c2)) {
                if (i6 != buZ + 2) {
                    if (i6 == i2 - 1) {
                        z = true;
                    }
                    int i7 = i6 - 4;
                    while (true) {
                        if (i7 < buZ) {
                            System.arraycopy(cArr, i6 + 1, cArr, buZ, i2 - i6);
                            i2 -= (i6 + 1) - buZ;
                            i6 = buZ + 1;
                            break;
                        } else if (cArr[i7] == c2) {
                            System.arraycopy(cArr, i6 + 1, cArr, i7 + 1, i2 - i6);
                            i2 -= i6 - i7;
                            i6 = i7 + 1;
                            break;
                        } else {
                            i7--;
                        }
                    }
                } else {
                    AppMethodBeat.o(10296);
                    return null;
                }
            }
            i6++;
        }
        if (i2 <= 0) {
            AppMethodBeat.o(10296);
            return "";
        } else if (i2 <= buZ) {
            String str2 = new String(cArr, 0, i2);
            AppMethodBeat.o(10296);
            return str2;
        } else if (z) {
            String str3 = new String(cArr, 0, i2);
            AppMethodBeat.o(10296);
            return str3;
        } else {
            String str4 = new String(cArr, 0, i2 - 1);
            AppMethodBeat.o(10296);
            return str4;
        }
    }

    public static String oH(String str, String str2) {
        AppMethodBeat.i(10297);
        int buZ = buZ(str2);
        if (buZ < 0) {
            AppMethodBeat.o(10297);
            return null;
        } else if (buZ > 0) {
            String normalize = normalize(str2);
            AppMethodBeat.o(10297);
            return normalize;
        } else if (str == null) {
            AppMethodBeat.o(10297);
            return null;
        } else {
            int length = str.length();
            if (length == 0) {
                String normalize2 = normalize(str2);
                AppMethodBeat.o(10297);
                return normalize2;
            } else if (isSeparator(str.charAt(length - 1))) {
                String normalize3 = normalize(str + str2);
                AppMethodBeat.o(10297);
                return normalize3;
            } else {
                String normalize4 = normalize(str + '/' + str2);
                AppMethodBeat.o(10297);
                return normalize4;
            }
        }
    }

    private static int buZ(String str) {
        int i2;
        AppMethodBeat.i(10298);
        if (str == null) {
            AppMethodBeat.o(10298);
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            AppMethodBeat.o(10298);
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == ':') {
            AppMethodBeat.o(10298);
            return -1;
        } else if (length == 1) {
            if (charAt == '~') {
                AppMethodBeat.o(10298);
                return 2;
            } else if (isSeparator(charAt)) {
                AppMethodBeat.o(10298);
                return 1;
            } else {
                AppMethodBeat.o(10298);
                return 0;
            }
        } else if (charAt == '~') {
            int indexOf = str.indexOf(47, 1);
            int indexOf2 = str.indexOf(92, 1);
            if (indexOf == -1 && indexOf2 == -1) {
                int i3 = length + 1;
                AppMethodBeat.o(10298);
                return i3;
            }
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            int min = Math.min(indexOf, indexOf2) + 1;
            AppMethodBeat.o(10298);
            return min;
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 == ':') {
                char upperCase = Character.toUpperCase(charAt);
                if (upperCase < 'A' || upperCase > 'Z') {
                    if (upperCase == '/') {
                        AppMethodBeat.o(10298);
                        return 1;
                    }
                    AppMethodBeat.o(10298);
                    return -1;
                } else if (length == 2 || !isSeparator(str.charAt(2))) {
                    AppMethodBeat.o(10298);
                    return 2;
                } else {
                    AppMethodBeat.o(10298);
                    return 3;
                }
            } else if (isSeparator(charAt) && isSeparator(charAt2)) {
                int indexOf3 = str.indexOf(47, 2);
                int indexOf4 = str.indexOf(92, 2);
                if ((indexOf3 == -1 && indexOf4 == -1) || indexOf3 == 2 || indexOf4 == 2) {
                    AppMethodBeat.o(10298);
                    return -1;
                }
                if (indexOf3 == -1) {
                    i2 = indexOf4;
                } else {
                    i2 = indexOf3;
                }
                if (indexOf4 == -1) {
                    indexOf4 = i2;
                }
                int min2 = Math.min(i2, indexOf4) + 1;
                AppMethodBeat.o(10298);
                return min2;
            } else if (isSeparator(charAt)) {
                AppMethodBeat.o(10298);
                return 1;
            } else {
                AppMethodBeat.o(10298);
                return 0;
            }
        }
    }

    private static int bva(String str) {
        AppMethodBeat.i(10299);
        if (str == null) {
            AppMethodBeat.o(10299);
            return -1;
        }
        int max = Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
        AppMethodBeat.o(10299);
        return max;
    }

    public static String getName(String str) {
        AppMethodBeat.i(10300);
        if (str == null) {
            AppMethodBeat.o(10300);
            return null;
        }
        bvb(str);
        String substring = str.substring(bva(str) + 1);
        AppMethodBeat.o(10300);
        return substring;
    }

    private static void bvb(String str) {
        AppMethodBeat.i(10301);
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) == 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
                AppMethodBeat.o(10301);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(10301);
    }

    public static String getExtension(String str) {
        int lastIndexOf;
        AppMethodBeat.i(10302);
        if (str == null) {
            AppMethodBeat.o(10302);
            return null;
        }
        if (str == null) {
            lastIndexOf = -1;
        } else {
            lastIndexOf = str.lastIndexOf(46);
            if (bva(str) > lastIndexOf) {
                lastIndexOf = -1;
            }
        }
        if (lastIndexOf == -1) {
            AppMethodBeat.o(10302);
            return "";
        }
        String substring = str.substring(lastIndexOf + 1);
        AppMethodBeat.o(10302);
        return substring;
    }
}
