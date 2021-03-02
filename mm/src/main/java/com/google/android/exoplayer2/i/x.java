package com.google.android.exoplayer2.i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class x {
    public static final String DEVICE = Build.DEVICE;
    public static final String MANUFACTURER = Build.MANUFACTURER;
    public static final String MODEL = Build.MODEL;
    public static final int SDK_INT = ((Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT);
    public static final String bHH = (DEVICE + ", " + MODEL + ", " + MANUFACTURER + ", " + SDK_INT);
    private static final Pattern bHI = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    private static final Pattern bHJ = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern bHK = Pattern.compile("%([A-Fa-f0-9]{2})");
    private static final int[] bHL = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};

    static {
        AppMethodBeat.i(93244);
        AppMethodBeat.o(93244);
    }

    public static boolean o(Uri uri) {
        AppMethodBeat.i(93217);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || scheme.equals("file")) {
            AppMethodBeat.o(93217);
            return true;
        }
        AppMethodBeat.o(93217);
        return false;
    }

    public static boolean j(Object obj, Object obj2) {
        AppMethodBeat.i(93218);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.o(93218);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.o(93218);
            return true;
        } else {
            AppMethodBeat.o(93218);
            return false;
        }
    }

    public static ExecutorService bE(final String str) {
        AppMethodBeat.i(93219);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
            /* class com.google.android.exoplayer2.i.x.AnonymousClass1 */

            public final Thread newThread(Runnable runnable) {
                AppMethodBeat.i(93216);
                Thread thread = new Thread(runnable, str);
                AppMethodBeat.o(93216);
                return thread;
            }
        });
        AppMethodBeat.o(93219);
        return newSingleThreadExecutor;
    }

    public static void a(g gVar) {
        AppMethodBeat.i(93220);
        if (gVar != null) {
            try {
                gVar.close();
            } catch (IOException e2) {
                AppMethodBeat.o(93220);
                return;
            }
        }
        AppMethodBeat.o(93220);
    }

    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(93221);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                AppMethodBeat.o(93221);
                return;
            }
        }
        AppMethodBeat.o(93221);
    }

    public static String bF(String str) {
        AppMethodBeat.i(93222);
        if (str == null) {
            AppMethodBeat.o(93222);
            return null;
        }
        String language = new Locale(str).getLanguage();
        AppMethodBeat.o(93222);
        return language;
    }

    public static byte[] bG(String str) {
        AppMethodBeat.i(93223);
        byte[] bytes = str.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        AppMethodBeat.o(93223);
        return bytes;
    }

    public static boolean fd(int i2) {
        return i2 == 10 || i2 == 13;
    }

    public static String bH(String str) {
        AppMethodBeat.i(93224);
        if (str == null) {
            AppMethodBeat.o(93224);
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        AppMethodBeat.o(93224);
        return lowerCase;
    }

    public static int bi(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static int s(int i2, int i3, int i4) {
        AppMethodBeat.i(93225);
        int max = Math.max(i3, Math.min(i2, i4));
        AppMethodBeat.o(93225);
        return max;
    }

    public static long l(long j2, long j3) {
        AppMethodBeat.i(93226);
        long max = Math.max(0L, Math.min(j2, j3));
        AppMethodBeat.o(93226);
        return max;
    }

    public static float k(float f2, float f3, float f4) {
        AppMethodBeat.i(93227);
        float max = Math.max(f3, Math.min(f2, f4));
        AppMethodBeat.o(93227);
        return max;
    }

    public static int a(long[] jArr, long j2, boolean z) {
        int i2;
        AppMethodBeat.i(93228);
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (jArr[binarySearch] == j2);
            i2 = binarySearch + 1;
        }
        if (z) {
            int max = Math.max(0, i2);
            AppMethodBeat.o(93228);
            return max;
        }
        AppMethodBeat.o(93228);
        return i2;
    }

    public static int a(long[] jArr, long j2, boolean z, boolean z2) {
        AppMethodBeat.i(93229);
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            binarySearch ^= -1;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[binarySearch] == j2);
            if (z) {
                binarySearch--;
            }
        }
        if (z2) {
            int min = Math.min(jArr.length - 1, binarySearch);
            AppMethodBeat.o(93229);
            return min;
        }
        AppMethodBeat.o(93229);
        return binarySearch;
    }

    public static <T> int a(List<? extends Comparable<? super T>> list, T t, boolean z) {
        int i2;
        int i3;
        AppMethodBeat.i(93230);
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
        } else {
            while (true) {
                i2 = binarySearch - 1;
                if (i2 < 0 || ((Comparable) list.get(i2)).compareTo(t) != 0) {
                    i3 = i2 + 1;
                } else {
                    binarySearch = i2;
                }
            }
            i3 = i2 + 1;
        }
        if (z) {
            int max = Math.max(0, i3);
            AppMethodBeat.o(93230);
            return max;
        }
        AppMethodBeat.o(93230);
        return i3;
    }

    public static long bI(String str) {
        int i2;
        AppMethodBeat.i(93232);
        Matcher matcher = bHI.matcher(str);
        if (!matcher.matches()) {
            o oVar = new o("Invalid date/time format: ".concat(String.valueOf(str)));
            AppMethodBeat.o(93232);
            throw oVar;
        }
        if (matcher.group(9) == null) {
            i2 = 0;
        } else if (matcher.group(9).equalsIgnoreCase("Z")) {
            i2 = 0;
        } else {
            int parseInt = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            i2 = matcher.group(11).equals("-") ? parseInt * -1 : parseInt;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (i2 != 0) {
            timeInMillis -= (long) (60000 * i2);
        }
        AppMethodBeat.o(93232);
        return timeInMillis;
    }

    public static long b(long j2, long j3, long j4) {
        if (j4 >= j3 && j4 % j3 == 0) {
            return j2 / (j4 / j3);
        }
        if (j4 >= j3 || j3 % j4 != 0) {
            return (long) ((((double) j3) / ((double) j4)) * ((double) j2));
        }
        return (j3 / j4) * j2;
    }

    public static void a(long[] jArr, long j2) {
        int i2 = 0;
        if (j2 >= TimeUtil.SECOND_TO_US && j2 % TimeUtil.SECOND_TO_US == 0) {
            long j3 = j2 / TimeUtil.SECOND_TO_US;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j3;
                i2++;
            }
        } else if (j2 >= TimeUtil.SECOND_TO_US || TimeUtil.SECOND_TO_US % j2 != 0) {
            double d2 = 1000000.0d / ((double) j2);
            while (i2 < jArr.length) {
                jArr[i2] = (long) (((double) jArr[i2]) * d2);
                i2++;
            }
        } else {
            long j4 = TimeUtil.SECOND_TO_US / j2;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] * j4;
                i2++;
            }
        }
    }

    public static int[] y(List<Integer> list) {
        AppMethodBeat.i(93234);
        if (list == null) {
            AppMethodBeat.o(93234);
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = list.get(i2).intValue();
        }
        AppMethodBeat.o(93234);
        return iArr;
    }

    public static int bJ(String str) {
        AppMethodBeat.i(93235);
        int length = str.length();
        a.checkArgument(length <= 4);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 = str.charAt(i3) | (i2 << 8);
        }
        AppMethodBeat.o(93235);
        return i2;
    }

    public static byte[] bK(String str) {
        AppMethodBeat.i(93236);
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (Character.digit(str.charAt(i3 + 1), 16) + (Character.digit(str.charAt(i3), 16) << 4));
        }
        AppMethodBeat.o(93236);
        return bArr;
    }

    public static String d(Object[] objArr) {
        AppMethodBeat.i(93237);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            sb.append(objArr[i2].getClass().getSimpleName());
            if (i2 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(93237);
        return sb2;
    }

    public static String h(Context context, String str) {
        String str2;
        AppMethodBeat.i(93238);
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            str2 = "?";
        }
        String str3 = str + FilePathGenerator.ANDROID_DIR_SEP + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.5.4";
        AppMethodBeat.o(93238);
        return str3;
    }

    public static int fg(int i2) {
        switch (i2) {
            case 8:
                return 3;
            case 16:
                return 2;
            case 24:
                return Integer.MIN_VALUE;
            case 32:
                return 1073741824;
            default:
                return 0;
        }
    }

    public static int bj(int i2, int i3) {
        AppMethodBeat.i(93239);
        switch (i2) {
            case Integer.MIN_VALUE:
                int i4 = i3 * 3;
                AppMethodBeat.o(93239);
                return i4;
            case 2:
                int i5 = i3 * 2;
                AppMethodBeat.o(93239);
                return i5;
            case 3:
                AppMethodBeat.o(93239);
                return i3;
            case 1073741824:
                int i6 = i3 * 4;
                AppMethodBeat.o(93239);
                return i6;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                AppMethodBeat.o(93239);
                throw illegalArgumentException;
        }
    }

    public static int fh(int i2) {
        switch (i2) {
            case 1:
            case 11:
            case 12:
            case 14:
            default:
                return 3;
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 13:
                return 1;
        }
    }

    public static int fi(int i2) {
        AppMethodBeat.i(93242);
        switch (i2) {
            case 0:
                AppMethodBeat.o(93242);
                return TPMediaCodecProfileLevel.HEVCMainTierLevel62;
            case 1:
                AppMethodBeat.o(93242);
                return 3538944;
            case 2:
                AppMethodBeat.o(93242);
                return 13107200;
            case 3:
                AppMethodBeat.o(93242);
                return 131072;
            case 4:
                AppMethodBeat.o(93242);
                return 131072;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(93242);
                throw illegalStateException;
        }
    }

    public static String bL(String str) {
        int i2 = 0;
        AppMethodBeat.i(93243);
        int length = str.length();
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) == '%') {
                i3++;
            }
        }
        if (i3 == 0) {
            AppMethodBeat.o(93243);
            return str;
        }
        int i5 = length - (i3 * 2);
        StringBuilder sb = new StringBuilder(i5);
        Matcher matcher = bHK.matcher(str);
        int i6 = i3;
        while (i6 > 0 && matcher.find()) {
            sb.append((CharSequence) str, i2, matcher.start()).append((char) Integer.parseInt(matcher.group(1), 16));
            i6--;
            i2 = matcher.end();
        }
        if (i2 < length) {
            sb.append((CharSequence) str, i2, length);
        }
        if (sb.length() != i5) {
            AppMethodBeat.o(93243);
            return null;
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(93243);
        return sb2;
    }

    public static int m(byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 << 8) ^ bHL[((i3 >>> 24) ^ (bArr[i4] & 255)) & 255];
        }
        return i3;
    }

    public static void d(Throwable th) {
        throw th;
    }
}
