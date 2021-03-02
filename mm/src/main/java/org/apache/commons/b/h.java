package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.BuildConfig;
import java.util.ArrayList;

public final class h {
    public static final String KyL = getSystemProperty("os.name");
    public static final String KyM = getSystemProperty("os.version");
    public static final String TTr = getSystemProperty("line.separator");
    public static final String UfA = getSystemProperty("file.encoding");
    public static final String UfB = getSystemProperty("file.separator");
    public static final String UfC = getSystemProperty("java.awt.fonts");
    public static final String UfD = getSystemProperty("java.awt.graphicsenv");
    public static final String UfE = getSystemProperty("java.awt.headless");
    public static final String UfF = getSystemProperty("java.awt.printerjob");
    public static final String UfG = getSystemProperty("java.class.path");
    public static final String UfH = getSystemProperty("java.class.version");
    public static final String UfI = getSystemProperty("java.compiler");
    public static final String UfJ = getSystemProperty("java.endorsed.dirs");
    public static final String UfK = getSystemProperty("java.ext.dirs");
    public static final String UfL = getSystemProperty("java.home");
    public static final String UfM = getSystemProperty("java.io.tmpdir");
    public static final String UfN = getSystemProperty("java.library.path");
    public static final String UfO = getSystemProperty("java.runtime.name");
    public static final String UfP = getSystemProperty("java.runtime.version");
    public static final String UfQ = getSystemProperty("java.specification.name");
    public static final String UfR = getSystemProperty("java.specification.vendor");
    public static final String UfS = getSystemProperty("java.specification.version");
    public static final String UfT = getSystemProperty("java.util.prefs.PreferencesFactory");
    public static final String UfU = getSystemProperty("java.vendor");
    public static final String UfV = getSystemProperty("java.vendor.url");
    public static final String UfW = getSystemProperty("java.version");
    public static final String UfX = getSystemProperty("java.vm.info");
    public static final String UfY = getSystemProperty("java.vm.name");
    public static final String UfZ = getSystemProperty("java.vm.specification.name");
    public static final String Ufz = getSystemProperty("awt.toolkit");
    public static final boolean UgA = bvk("Mac OS X");
    public static final boolean UgB = bvk("OS/2");
    public static final boolean UgC = bvk("Solaris");
    public static final boolean UgD = bvk("SunOS");
    public static final boolean UgE;
    public static final boolean UgF = bvk("Windows");
    public static final boolean UgG = oJ("Windows", "5.0");
    public static final boolean UgH = oJ("Windows 9", "4.0");
    public static final boolean UgI = oJ("Windows 9", "4.1");
    public static final boolean UgJ = oJ("Windows", "4.9");
    public static final boolean UgK = bvk("Windows NT");
    public static final boolean UgL = oJ("Windows", "5.1");
    public static final boolean UgM = oJ("Windows", "6.0");
    public static final boolean UgN = oJ("Windows", "6.1");
    public static final String Uga = getSystemProperty("java.vm.specification.vendor");
    public static final String Ugb = getSystemProperty("java.vm.specification.version");
    public static final String Ugc = getSystemProperty("java.vm.vendor");
    public static final String Ugd = getSystemProperty("java.vm.version");
    public static final String Uge = getSystemProperty("os.arch");
    public static final String Ugf = getSystemProperty("path.separator");
    public static final String Ugg;
    public static final String Ugh = getSystemProperty("user.dir");
    public static final String Ugi = getSystemProperty("user.home");
    public static final String Ugj = getSystemProperty("user.language");
    public static final String Ugk = getSystemProperty("user.timezone");
    public static final String Ugl;
    public static final float Ugm = ab(bvl(UfW));
    public static final int Ugn;
    public static final boolean Ugo = bvj(BuildConfig.VERSION_NAME);
    public static final boolean Ugp = bvj("1.2");
    public static final boolean Ugq = bvj("1.3");
    public static final boolean Ugr = bvj("1.4");
    public static final boolean Ugs = bvj("1.5");
    public static final boolean Ugt = bvj("1.6");
    public static final boolean Ugu = bvj("1.7");
    public static final boolean Ugv = bvk("AIX");
    public static final boolean Ugw = bvk("HP-UX");
    public static final boolean Ugx = bvk("Irix");
    public static final boolean Ugy;
    public static final boolean Ugz = bvk("Mac");
    public static final String cnm = getSystemProperty("user.name");

    static {
        String systemProperty;
        String str;
        int i2;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(40756);
        if (getSystemProperty("user.country") == null) {
            systemProperty = getSystemProperty("user.region");
        } else {
            systemProperty = getSystemProperty("user.country");
        }
        Ugg = systemProperty;
        if (UfW != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= UfW.length()) {
                    break;
                }
                char charAt = UfW.charAt(i3);
                if (charAt >= '0' && charAt <= '9') {
                    str = UfW.substring(i3);
                    break;
                }
                i3++;
            }
        }
        str = null;
        Ugl = str;
        int[] bvl = bvl(UfW);
        if (bvl == null) {
            i2 = 0;
        } else {
            int length = bvl.length;
            if (length > 0) {
                i2 = bvl[0] * 100;
            } else {
                i2 = 0;
            }
            if (length >= 2) {
                i2 += bvl[1] * 10;
            }
            if (length >= 3) {
                i2 += bvl[2];
            }
        }
        Ugn = i2;
        if (bvk("Linux") || bvk("LINUX")) {
            z = true;
        } else {
            z = false;
        }
        Ugy = z;
        if (Ugv || Ugw || Ugx || Ugy || UgA || UgC || UgD) {
            z2 = true;
        }
        UgE = z2;
        AppMethodBeat.o(40756);
    }

    private static boolean bvj(String str) {
        AppMethodBeat.i(40750);
        String str2 = Ugl;
        if (str2 == null) {
            AppMethodBeat.o(40750);
            return false;
        }
        boolean startsWith = str2.startsWith(str);
        AppMethodBeat.o(40750);
        return startsWith;
    }

    private static boolean oJ(String str, String str2) {
        AppMethodBeat.i(40751);
        String str3 = KyL;
        String str4 = KyM;
        if (str3 == null || str4 == null) {
            AppMethodBeat.o(40751);
            return false;
        } else if (!str3.startsWith(str) || !str4.startsWith(str2)) {
            AppMethodBeat.o(40751);
            return false;
        } else {
            AppMethodBeat.o(40751);
            return true;
        }
    }

    private static boolean bvk(String str) {
        AppMethodBeat.i(40752);
        String str2 = KyL;
        if (str2 == null) {
            AppMethodBeat.o(40752);
            return false;
        }
        boolean startsWith = str2.startsWith(str);
        AppMethodBeat.o(40752);
        return startsWith;
    }

    private static String getSystemProperty(String str) {
        AppMethodBeat.i(40753);
        try {
            String property = System.getProperty(str);
            AppMethodBeat.o(40753);
            return property;
        } catch (SecurityException e2) {
            System.err.println(new StringBuffer("Caught a SecurityException reading the system property '").append(str).append("'; the SystemUtils property value will default to null.").toString());
            AppMethodBeat.o(40753);
            return null;
        }
    }

    private static int[] bvl(String str) {
        boolean z;
        int i2;
        int i3;
        int i4;
        String[] strArr;
        int i5;
        int[] iArr;
        AppMethodBeat.i(40754);
        if (str == null) {
            int[] iArr2 = a.bYn;
            AppMethodBeat.o(40754);
            return iArr2;
        }
        if (str == null) {
            strArr = null;
        } else {
            int length = str.length();
            if (length == 0) {
                strArr = a.EMPTY_STRING_ARRAY;
            } else {
                ArrayList arrayList = new ArrayList();
                if ("._- ".length() == 1) {
                    char charAt = "._- ".charAt(0);
                    z = false;
                    int i6 = 0;
                    i2 = 0;
                    int i7 = 1;
                    while (i2 < length) {
                        if (str.charAt(i2) == charAt) {
                            if (z) {
                                i5 = i7 + 1;
                                if (i7 == -1) {
                                    i2 = length;
                                }
                                arrayList.add(str.substring(i6, i2));
                                z = false;
                            } else {
                                i5 = i7;
                            }
                            int i8 = i2 + 1;
                            i6 = i8;
                            i2 = i8;
                            i7 = i5;
                        } else {
                            i2++;
                            z = true;
                        }
                    }
                    i3 = i6;
                } else {
                    z = false;
                    int i9 = 0;
                    i2 = 0;
                    int i10 = 1;
                    while (i2 < length) {
                        if ("._- ".indexOf(str.charAt(i2)) >= 0) {
                            if (z) {
                                i4 = i10 + 1;
                                if (i10 == -1) {
                                    i2 = length;
                                }
                                arrayList.add(str.substring(i9, i2));
                                z = false;
                            } else {
                                i4 = i10;
                            }
                            int i11 = i2 + 1;
                            i9 = i11;
                            i2 = i11;
                            i10 = i4;
                        } else {
                            i2++;
                            z = true;
                        }
                    }
                    i3 = i9;
                }
                if (z) {
                    arrayList.add(str.substring(i3, i2));
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
        int[] iArr3 = new int[Math.min(3, strArr.length)];
        int i12 = 0;
        for (int i13 = 0; i13 < strArr.length && i12 < 3; i13++) {
            String str2 = strArr[i13];
            if (str2.length() > 0) {
                try {
                    iArr3[i12] = Integer.parseInt(str2);
                    i12++;
                } catch (Exception e2) {
                }
            }
        }
        if (iArr3.length > i12) {
            iArr = new int[i12];
            System.arraycopy(iArr3, 0, iArr, 0, i12);
        } else {
            iArr = iArr3;
        }
        AppMethodBeat.o(40754);
        return iArr;
    }

    private static float ab(int[] iArr) {
        AppMethodBeat.i(40755);
        if (iArr == null || iArr.length == 0) {
            AppMethodBeat.o(40755);
            return 0.0f;
        } else if (iArr.length == 1) {
            float f2 = (float) iArr[0];
            AppMethodBeat.o(40755);
            return f2;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(iArr[0]);
            stringBuffer.append('.');
            for (int i2 = 1; i2 < iArr.length; i2++) {
                stringBuffer.append(iArr[i2]);
            }
            try {
                float parseFloat = Float.parseFloat(stringBuffer.toString());
                AppMethodBeat.o(40755);
                return parseFloat;
            } catch (Exception e2) {
                AppMethodBeat.o(40755);
                return 0.0f;
            }
        }
    }
}
