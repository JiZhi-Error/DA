package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.Character;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import junit.framework.Assert;

public final class Util {
    public static final int BEGIN_TIME = 22;
    public static final int BIT_OF_GB = 30;
    public static final int BIT_OF_KB = 10;
    public static final int BIT_OF_MB = 20;
    public static final int BYTE_OF_GB = 1073741824;
    public static final int BYTE_OF_KB = 1024;
    public static final int BYTE_OF_MB = 1048576;
    public static final int DAY = 0;
    public static final int END_TIME = 8;
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final char[] INVALID = {'<', '>', '\"', '\'', '&', '\r', '\n', LOWER_RANGE, '\t'};
    private static final long[] LIGHT_PATTERN = {300, 50, 300, 50};
    private static final char LOWER_RANGE = ' ';
    public static final int MASK_16BIT = 65535;
    public static final int MASK_32BIT = -1;
    public static final int MASK_4BIT = 15;
    public static final int MASK_8BIT = 255;
    public static final long MAX_32BIT_VALUE = 4294967295L;
    public static final int MAX_ACCOUNT_LENGTH = 20;
    public static final int MAX_DECODE_PICTURE_SIZE = 2764800;
    public static final int MAX_PASSWORD_LENGTH = 16;
    public static final long MILLSECONDS_OF_DAY = 86400000;
    public static final long MILLSECONDS_OF_HOUR = 3600000;
    public static final long MILLSECONDS_OF_MINUTE = 60000;
    public static final long MILLSECONDS_OF_SECOND = 1000;
    public static final long MINUTE_OF_HOUR = 60;
    public static final int MIN_ACCOUNT_LENGTH = 6;
    public static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MTU = 1462;
    private static final int NEW_QQ_PASSWORD_MAX = 16;
    public static final String PHOTO_DEFAULT_EXT = ".jpg";
    public static final long SECONDS_OF_DAY = 86400;
    public static final long SECONDS_OF_HOUR = 3600;
    public static final long SECOND_OF_MINUTE = 60;
    private static final String TAG = "MicroMsg.Util";
    private static final int TCP_HDR_FIX = 52;
    private static final int TCP_HDR_FIX_TOO = 40;
    private static final int TCP_RX_FIX_BYTES = 156;
    private static final int TCP_TX_FIX_BYTES = 172;
    private static final BigInteger TWO_64 = BigInteger.ONE.shiftLeft(64);
    private static final String[] VALID = {"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;"};
    public static final long[] VIRBRATOR_PATTERN = {300, 200, 300, 200};
    private byte _hellAccFlag_;

    private Util() {
    }

    public static String escapeSqlValue(String str) {
        AppMethodBeat.i(157856);
        if (str != null) {
            str = str.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
        }
        AppMethodBeat.o(157856);
        return str;
    }

    public static String escapeDirTraversal(String str) {
        AppMethodBeat.i(157857);
        if (str != null) {
            str = str.replace("../", "");
        }
        AppMethodBeat.o(157857);
        return str;
    }

    public static String listToString(List<String> list, String str) {
        AppMethodBeat.i(157858);
        if (list == null) {
            AppMethodBeat.o(157858);
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 == list.size() - 1) {
                sb.append(list.get(i2).trim());
            } else {
                sb.append(list.get(i2).trim() + str);
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(157858);
        return sb2;
    }

    public static List<String> stringToList(String str, String str2) {
        AppMethodBeat.i(157859);
        if (TextUtils.isEmpty(str)) {
            List<String> list = Collections.EMPTY_LIST;
            AppMethodBeat.o(157859);
            return list;
        }
        String[] split = str.split(str2);
        if (split == null) {
            List<String> list2 = Collections.EMPTY_LIST;
            AppMethodBeat.o(157859);
            return list2;
        }
        List<String> asList = Arrays.asList(split);
        AppMethodBeat.o(157859);
        return asList;
    }

    public static ArrayList<String> stringsToList(String[] strArr) {
        AppMethodBeat.i(157860);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(157860);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : strArr) {
            arrayList.add(str);
        }
        AppMethodBeat.o(157860);
        return arrayList;
    }

    public static String[] listToStrings(List<String> list) {
        AppMethodBeat.i(157861);
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr[i2] = list.get(i2);
        }
        AppMethodBeat.o(157861);
        return strArr;
    }

    public static int getIntRandom(int i2, int i3) {
        AppMethodBeat.i(157862);
        Assert.assertTrue(i2 > i3);
        int nextInt = new Random(System.currentTimeMillis()).nextInt((i2 - i3) + 1) + i3;
        AppMethodBeat.o(157862);
        return nextInt;
    }

    public static byte[] getUuidRandom() {
        AppMethodBeat.i(157863);
        try {
            InputStream openRead = s.openRead("/dev/urandom");
            byte[] bArr = new byte[16];
            int read = openRead.read(bArr);
            openRead.close();
            if (read == 16) {
                AppMethodBeat.o(157863);
                return bArr;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        byte[] Q = g.Q((UUID.randomUUID().toString() + nowMilliSecond()).getBytes());
        AppMethodBeat.o(157863);
        return Q;
    }

    public static boolean isDayTimeNow() {
        AppMethodBeat.i(230409);
        int i2 = new GregorianCalendar().get(11);
        if (((long) i2) < 6 || ((long) i2) >= 18) {
            AppMethodBeat.o(230409);
            return false;
        }
        AppMethodBeat.o(230409);
        return true;
    }

    public static String getTimeZoneOffset() {
        int i2;
        AppMethodBeat.i(157864);
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset() / 1000;
        if (!timeZone.useDaylightTime() || !timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        String format = String.format("%.2f", Double.valueOf((((double) rawOffset) / 3600.0d) + ((double) i2)));
        AppMethodBeat.o(157864);
        return format;
    }

    public static String unixTimeMsToTime(long j2) {
        AppMethodBeat.i(157865);
        String format = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date(j2));
        AppMethodBeat.o(157865);
        return format;
    }

    public static String formatUnixTime(long j2) {
        AppMethodBeat.i(157866);
        String format = new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(1000 * j2));
        AppMethodBeat.o(157866);
        return format;
    }

    public static boolean isChinese(char c2) {
        AppMethodBeat.i(157867);
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c2);
        if (of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            AppMethodBeat.o(157867);
            return true;
        }
        AppMethodBeat.o(157867);
        return false;
    }

    public static boolean isChinese(String str) {
        AppMethodBeat.i(157868);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(157868);
            return false;
        }
        boolean find = Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(str).find();
        AppMethodBeat.o(157868);
        return find;
    }

    public static boolean isAlpha(char c2) {
        return (c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z');
    }

    public static boolean isAllAlpha(String str) {
        AppMethodBeat.i(157869);
        char[] charArray = str.toCharArray();
        for (char c2 : charArray) {
            if ((c2 < 'a' || c2 > 'z') && (c2 < 'A' || c2 > 'Z')) {
                AppMethodBeat.o(157869);
                return false;
            }
        }
        AppMethodBeat.o(157869);
        return true;
    }

    public static boolean isNum(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean isValidQQNum(String str) {
        AppMethodBeat.i(157870);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(157870);
            return false;
        }
        try {
            long longValue = Long.valueOf(str.trim()).longValue();
            if (longValue <= 0 || longValue > MAX_32BIT_VALUE) {
                AppMethodBeat.o(157870);
                return false;
            }
            AppMethodBeat.o(157870);
            return true;
        } catch (NumberFormatException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157870);
            return false;
        }
    }

    public static boolean isValidEmail(String str) {
        AppMethodBeat.i(157871);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(157871);
            return false;
        }
        boolean matches = str.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
        AppMethodBeat.o(157871);
        return matches;
    }

    public static byte[] bmpToByteArray(Bitmap bitmap, boolean z) {
        AppMethodBeat.i(230410);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (z) {
            Log.i(TAG, "recycle bitmap:%s", bitmap);
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        AppMethodBeat.o(230410);
        return byteArray;
    }

    public static boolean isValidAccount(String str) {
        AppMethodBeat.i(157873);
        if (str == null) {
            AppMethodBeat.o(157873);
            return false;
        }
        String trim = str.trim();
        if (trim.length() < 6 || trim.length() > 20) {
            AppMethodBeat.o(157873);
            return false;
        } else if (!isAlpha(trim.charAt(0))) {
            AppMethodBeat.o(157873);
            return false;
        } else {
            for (int i2 = 0; i2 < trim.length(); i2++) {
                char charAt = trim.charAt(i2);
                if (!isAlpha(charAt) && !isNum(charAt) && charAt != '-' && charAt != '_') {
                    AppMethodBeat.o(157873);
                    return false;
                }
            }
            AppMethodBeat.o(157873);
            return true;
        }
    }

    public static boolean isValidPassword(String str) {
        AppMethodBeat.i(157874);
        if (str == null) {
            AppMethodBeat.o(157874);
            return false;
        } else if (str.length() < 8) {
            AppMethodBeat.o(157874);
            return false;
        } else {
            try {
                Long.parseLong(str);
                AppMethodBeat.o(157874);
                return false;
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(157874);
                return true;
            }
        }
    }

    public static String getSizeKB(long j2, double d2) {
        AppMethodBeat.i(230411);
        if ((j2 >> 30) > 0) {
            String sizeGB = getSizeGB(j2, d2);
            AppMethodBeat.o(230411);
            return sizeGB;
        } else if ((j2 >> 20) > 0) {
            String sizeMB = getSizeMB(j2, d2);
            AppMethodBeat.o(230411);
            return sizeMB;
        } else if ((j2 >> 9) > 0) {
            String str = (((double) Math.round((((double) j2) * d2) / 1024.0d)) / d2) + " KB";
            AppMethodBeat.o(230411);
            return str;
        } else {
            String str2 = j2 + " B";
            AppMethodBeat.o(230411);
            return str2;
        }
    }

    public static String getSizeKB(long j2) {
        AppMethodBeat.i(157875);
        String sizeKB = getSizeKB(j2, 10.0d);
        AppMethodBeat.o(157875);
        return sizeKB;
    }

    public static String getSizeMB(long j2, double d2) {
        AppMethodBeat.i(157876);
        String str = (((double) Math.round((((double) j2) * d2) / 1048576.0d)) / d2) + " MB";
        AppMethodBeat.o(157876);
        return str;
    }

    public static String getSizeMB(long j2) {
        AppMethodBeat.i(157877);
        String sizeMB = getSizeMB(j2, 10.0d);
        AppMethodBeat.o(157877);
        return sizeMB;
    }

    public static String getSizeGB(long j2, double d2) {
        AppMethodBeat.i(157878);
        String str = (((double) Math.round((((double) j2) * d2) / 1.073741824E9d)) / d2) + " GB";
        AppMethodBeat.o(157878);
        return str;
    }

    public static String getSizeGB(long j2) {
        AppMethodBeat.i(230412);
        String sizeGB = getSizeGB(j2, 10.0d);
        AppMethodBeat.o(230412);
        return sizeGB;
    }

    public static String dumpHexBuf(byte[] bArr) {
        AppMethodBeat.i(157879);
        String dumpHexBuf = dumpHexBuf(bArr, 0, 0);
        AppMethodBeat.o(157879);
        return dumpHexBuf;
    }

    public static String dumpHexBuf(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(230413);
        if (bArr == null) {
            AppMethodBeat.o(230413);
            return "(null)";
        }
        if (i3 <= 0) {
            i3 = bArr.length;
        }
        if (i2 > i3) {
            i2 = 0;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[((i3 * 3) + (i3 / 16))];
        for (int i5 = i2; i5 < i3 + i2; i5++) {
            byte b2 = bArr[i5];
            int i6 = i4 + 1;
            cArr2[i4] = LOWER_RANGE;
            int i7 = i6 + 1;
            cArr2[i6] = cArr[(b2 >>> 4) & 15];
            int i8 = i7 + 1;
            cArr2[i7] = cArr[b2 & 15];
            if (i5 % 16 != 0 || i5 <= 0) {
                i4 = i8;
            } else {
                i4 = i8 + 1;
                cArr2[i8] = '\n';
            }
        }
        String str = new String(cArr2);
        AppMethodBeat.o(230413);
        return str;
    }

    public static String dumpHex(byte[] bArr) {
        AppMethodBeat.i(157881);
        if (bArr == null) {
            AppMethodBeat.o(157881);
            return "(null)";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int length = bArr.length;
        char[] cArr2 = new char[(length * 3)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i3 + 1;
            cArr2[i3] = LOWER_RANGE;
            int i5 = i4 + 1;
            cArr2[i4] = cArr[(b2 >>> 4) & 15];
            cArr2[i5] = cArr[b2 & 15];
            i2++;
            i3 = i5 + 1;
        }
        String str = new String(cArr2);
        AppMethodBeat.o(157881);
        return str;
    }

    static {
        AppMethodBeat.i(158002);
        AppMethodBeat.o(158002);
    }

    public static void shake(Context context, boolean z) {
        AppMethodBeat.i(157883);
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            Log.w(TAG, "shake:vibrator is null!");
            AppMethodBeat.o(157883);
        } else if (z) {
            vibrator.vibrate(VIRBRATOR_PATTERN, -1);
            AppMethodBeat.o(157883);
        } else {
            vibrator.cancel();
            AppMethodBeat.o(157883);
        }
    }

    public static void lightShake(Context context) {
        AppMethodBeat.i(157884);
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            AppMethodBeat.o(157884);
            return;
        }
        vibrator.vibrate(LIGHT_PATTERN, -1);
        AppMethodBeat.o(157884);
    }

    public static long nowSecond() {
        AppMethodBeat.i(157885);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        AppMethodBeat.o(157885);
        return currentTimeMillis;
    }

    public static String formatSecToMin(int i2) {
        AppMethodBeat.i(157886);
        String format = String.format("%d:%02d", Long.valueOf(((long) i2) / 60), Long.valueOf(((long) i2) % 60));
        AppMethodBeat.o(157886);
        return format;
    }

    public static long secondsToNow(long j2) {
        AppMethodBeat.i(157887);
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - j2;
        AppMethodBeat.o(157887);
        return currentTimeMillis;
    }

    public static long ticksToNow(long j2) {
        AppMethodBeat.i(157888);
        long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
        AppMethodBeat.o(157888);
        return elapsedRealtime;
    }

    public static long currentTicks() {
        AppMethodBeat.i(157889);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.o(157889);
        return elapsedRealtime;
    }

    public static long currentDayInMills() {
        AppMethodBeat.i(157890);
        long nowMilliSecond = (nowMilliSecond() / MILLSECONDS_OF_DAY) * MILLSECONDS_OF_DAY;
        AppMethodBeat.o(157890);
        return nowMilliSecond;
    }

    public static long getBeginTimeOfToday() {
        AppMethodBeat.i(157891);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.o(157891);
        return timeInMillis;
    }

    public static boolean isSameDay(long j2, long j3) {
        AppMethodBeat.i(157892);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j3);
        if (instance.get(1) == instance2.get(1) && instance.get(5) == instance2.get(5) && instance.get(2) == instance2.get(2)) {
            AppMethodBeat.o(157892);
            return true;
        }
        AppMethodBeat.o(157892);
        return false;
    }

    public static String getDeviceId(Context context) {
        AppMethodBeat.i(230414);
        if (context == null) {
            AppMethodBeat.o(230414);
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                AppMethodBeat.o(230414);
                return null;
            }
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId == null) {
                AppMethodBeat.o(230414);
                return null;
            }
            String trim = deviceId.trim();
            AppMethodBeat.o(230414);
            return trim;
        } catch (SecurityException e2) {
            Log.e(TAG, "summerdeviceid getDeviceId failed, security exception[%s]", e2);
            AppMethodBeat.o(230414);
            return null;
        } catch (Exception e3) {
            Log.printErrStackTrace(TAG, e3, "summerdeviceid", new Object[0]);
            AppMethodBeat.o(230414);
            return null;
        }
    }

    public static long getDataAvailableSize() {
        AppMethodBeat.i(157893);
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT < 18) {
                long availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
                AppMethodBeat.o(157893);
                return availableBlocks;
            }
            long availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            AppMethodBeat.o(157893);
            return availableBlocksLong;
        } catch (Exception e2) {
            Log.e(TAG, "getDataAvailableSize exception:%s", e2.getMessage());
            AppMethodBeat.o(157893);
            return 0;
        }
    }

    public static long getAvailableMemoryMB(Context context) {
        AppMethodBeat.i(157894);
        ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (activityManager == null) {
            AppMethodBeat.o(157894);
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j2 = (memoryInfo.availMem / 1024) / 1024;
        AppMethodBeat.o(157894);
        return j2;
    }

    public static String getLine1Number(Context context) {
        AppMethodBeat.i(157895);
        if (context == null) {
            AppMethodBeat.o(157895);
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                Log.e(TAG, "getLine1Number failed, null tm");
                AppMethodBeat.o(157895);
                return null;
            }
            String line1Number = telephonyManager.getLine1Number();
            AppMethodBeat.o(157895);
            return line1Number;
        } catch (Exception e2) {
            Log.e(TAG, "getLine1Number failed:%s ", stackTraceToString(e2));
            AppMethodBeat.o(157895);
            return null;
        }
    }

    public static String getNetworkCountryCode(Context context) {
        AppMethodBeat.i(230415);
        if (context == null) {
            Log.w(TAG, "getNetworkCountryCode context is null.");
            AppMethodBeat.o(230415);
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (isNullOrNil(networkCountryIso)) {
                AppMethodBeat.o(230415);
                return null;
            }
            String trim = networkCountryIso.toLowerCase().trim();
            AppMethodBeat.o(230415);
            return trim;
        }
        AppMethodBeat.o(230415);
        return null;
    }

    public static String getSimCountryCode(Context context) {
        AppMethodBeat.i(157896);
        if (context == null) {
            Log.w(TAG, "getSimCountryCode context is null.");
            AppMethodBeat.o(157896);
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (isNullOrNil(simCountryIso)) {
                AppMethodBeat.o(157896);
                return "";
            }
            String trim = simCountryIso.toUpperCase().trim();
            AppMethodBeat.o(157896);
            return trim;
        }
        AppMethodBeat.o(157896);
        return "";
    }

    public static boolean isTopActivity(Context context) {
        AppMethodBeat.i(157897);
        String name = context.getClass().getName();
        String topActivityName = getTopActivityName(context);
        Log.d(TAG, "top activity=" + topActivityName + ", context=" + name);
        boolean equalsIgnoreCase = topActivityName.equalsIgnoreCase(name);
        AppMethodBeat.o(157897);
        return equalsIgnoreCase;
    }

    public static boolean isServiceRunning(Context context, String str) {
        AppMethodBeat.i(157898);
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningServices(Integer.MAX_VALUE)) {
            if (!(runningServiceInfo == null || runningServiceInfo.service == null || !runningServiceInfo.service.getClassName().toString().equals(str))) {
                Log.w(TAG, "service " + str + " is running");
                AppMethodBeat.o(157898);
                return true;
            }
        }
        Log.w(TAG, "service " + str + " is not running");
        AppMethodBeat.o(157898);
        return false;
    }

    public static boolean isProcessRunning(Context context, String str) {
        AppMethodBeat.i(157899);
        try {
            if (str.equals(context.getPackageName()) || str.startsWith(context.getPackageName() + ":") || Build.VERSION.SDK_INT < 21) {
                Log.i(TAG, "isProcessRunning, use ActivityManager. process = %s", str);
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    AppMethodBeat.o(157899);
                    return false;
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (!(runningAppProcessInfo == null || runningAppProcessInfo.processName == null || !runningAppProcessInfo.processName.equals(str))) {
                        Log.w(TAG, "process " + str + " is running");
                        AppMethodBeat.o(157899);
                        return true;
                    }
                }
            } else {
                Log.i(TAG, "isProcessRunning, use ps command. process = %s", str);
                for (String str2 : getRunningAppProcessesByPs()) {
                    Log.d(TAG, "isProcessRunning, process command line = %s", str2);
                    if (str2 != null && str2.contains(str)) {
                        String[] split = str2.split("\\s+");
                        for (String str3 : split) {
                            if (str.equals(str3)) {
                                Log.i(TAG, "process %s is running", str);
                                AppMethodBeat.o(157899);
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            Log.w(TAG, "process " + str + " is not running");
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        AppMethodBeat.o(157899);
        return false;
    }

    public static String getTopActivityName(Context context) {
        AppMethodBeat.i(157900);
        try {
            String className = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1).get(0).topActivity.getClassName();
            AppMethodBeat.o(157900);
            return className;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157900);
            return "(null)";
        }
    }

    public static boolean isTopApplication(Context context) {
        AppMethodBeat.i(157901);
        try {
            String className = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1).get(0).topActivity.getClassName();
            String packageName = context.getPackageName();
            Log.d(TAG, "top activity=" + className + ", context=" + packageName);
            boolean contains = className.contains(packageName);
            AppMethodBeat.o(157901);
            return contains;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157901);
            return false;
        }
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        AppMethodBeat.i(157902);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            AppMethodBeat.o(157902);
            return false;
        }
        AppMethodBeat.o(157902);
        return true;
    }

    public static List<ResolveInfo> queryIntentActivities(Context context, Intent intent) {
        AppMethodBeat.i(157903);
        if (context == null || intent == null) {
            AppMethodBeat.o(157903);
            return null;
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        AppMethodBeat.o(157903);
        return queryIntentActivities;
    }

    public static void selectPicture(Context context, int i2) {
        AppMethodBeat.i(230416);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        ((Activity) context).startActivityForResult(Intent.createChooser(intent, null), i2);
        AppMethodBeat.o(230416);
    }

    public static String notNullToString(Object obj) {
        AppMethodBeat.i(157904);
        if (obj != null) {
            String obj2 = obj.toString();
            AppMethodBeat.o(157904);
            return obj2;
        }
        AppMethodBeat.o(157904);
        return BuildConfig.COMMAND;
    }

    public static int nullAsNil(Integer num) {
        AppMethodBeat.i(157905);
        if (num == null) {
            AppMethodBeat.o(157905);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(157905);
        return intValue;
    }

    public static long nullAsNil(Long l) {
        AppMethodBeat.i(157906);
        if (l == null) {
            AppMethodBeat.o(157906);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(157906);
        return longValue;
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    public static boolean nullAsTrue(Boolean bool) {
        AppMethodBeat.i(157907);
        if (bool == null) {
            AppMethodBeat.o(157907);
            return true;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(157907);
        return booleanValue;
    }

    public static boolean nullAsFalse(Boolean bool) {
        AppMethodBeat.i(157908);
        if (bool == null) {
            AppMethodBeat.o(157908);
            return false;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(157908);
        return booleanValue;
    }

    public static int nullAs(Integer num, int i2) {
        AppMethodBeat.i(157909);
        if (num == null) {
            AppMethodBeat.o(157909);
            return i2;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(157909);
        return intValue;
    }

    public static byte[] nullAs(byte[] bArr, byte[] bArr2) {
        return bArr == null ? bArr2 : bArr;
    }

    public static long nullAs(Long l, long j2) {
        AppMethodBeat.i(157910);
        if (l == null) {
            AppMethodBeat.o(157910);
            return j2;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(157910);
        return longValue;
    }

    public static boolean nullAs(Boolean bool, boolean z) {
        AppMethodBeat.i(157911);
        if (bool == null) {
            AppMethodBeat.o(157911);
            return z;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(157911);
        return booleanValue;
    }

    public static String nullAs(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static int nullAsInt(Object obj, int i2) {
        AppMethodBeat.i(157912);
        if (obj == null) {
            AppMethodBeat.o(157912);
            return i2;
        } else if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            AppMethodBeat.o(157912);
            return intValue;
        } else if (obj instanceof Long) {
            int intValue2 = ((Long) obj).intValue();
            AppMethodBeat.o(157912);
            return intValue2;
        } else {
            AppMethodBeat.o(157912);
            return i2;
        }
    }

    public static long nullAsLong(Object obj, int i2) {
        AppMethodBeat.i(230417);
        if (obj == null) {
            long j2 = (long) i2;
            AppMethodBeat.o(230417);
            return j2;
        } else if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            AppMethodBeat.o(230417);
            return longValue;
        } else {
            long j3 = (long) i2;
            AppMethodBeat.o(230417);
            return j3;
        }
    }

    public static boolean isNullOrNil(List list) {
        AppMethodBeat.i(157914);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(157914);
            return true;
        }
        AppMethodBeat.o(157914);
        return false;
    }

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(157915);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(157915);
            return true;
        }
        AppMethodBeat.o(157915);
        return false;
    }

    public static boolean isNullOrNil(CharSequence charSequence) {
        AppMethodBeat.i(157916);
        if (charSequence == null || charSequence.length() <= 0) {
            AppMethodBeat.o(157916);
            return true;
        }
        AppMethodBeat.o(157916);
        return false;
    }

    public static boolean isNullOrNil(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrNil(String... strArr) {
        boolean z = false;
        AppMethodBeat.i(157917);
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (isNullOrNil(strArr[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(157917);
        return z;
    }

    public static int getLength(String str) {
        AppMethodBeat.i(157918);
        if (str == null) {
            AppMethodBeat.o(157918);
            return -1;
        }
        int length = str.length();
        AppMethodBeat.o(157918);
        return length;
    }

    public static int getUTF8ByteLength(String str) {
        AppMethodBeat.i(157919);
        if (str == null) {
            AppMethodBeat.o(157919);
            return -1;
        }
        int length = str.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)).length;
        AppMethodBeat.o(157919);
        return length;
    }

    public static int getLength(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        return bArr.length;
    }

    public static int getSeconds(String str, int i2) {
        AppMethodBeat.i(230418);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(230418);
            return i2;
        }
        try {
            int time = (int) (new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime() / 1000);
            AppMethodBeat.o(230418);
            return time;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(230418);
            return i2;
        }
    }

    public static int getInt(String str, int i2) {
        AppMethodBeat.i(157921);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i2 = Integer.decode(str).intValue();
                    AppMethodBeat.o(157921);
                    return i2;
                }
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(157921);
            }
        }
        AppMethodBeat.o(157921);
        return i2;
    }

    public static long getLong(String str, long j2) {
        AppMethodBeat.i(157922);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    j2 = Long.decode(str).longValue();
                    AppMethodBeat.o(157922);
                    return j2;
                }
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(157922);
            }
        }
        AppMethodBeat.o(157922);
        return j2;
    }

    public static String getUnsignedLongString(long j2) {
        AppMethodBeat.i(157923);
        BigInteger valueOf = BigInteger.valueOf(j2);
        if (valueOf.signum() < 0) {
            valueOf = valueOf.add(TWO_64);
        }
        String bigInteger = valueOf.toString();
        AppMethodBeat.o(157923);
        return bigInteger;
    }

    public static boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(157924);
        if (str == null) {
            try {
                AppMethodBeat.o(157924);
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(157924);
            }
        } else {
            z = Boolean.parseBoolean(str);
            AppMethodBeat.o(157924);
        }
        return z;
    }

    public static float getFloat(String str, float f2) {
        AppMethodBeat.i(157925);
        if (str == null) {
            try {
                AppMethodBeat.o(157925);
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(157925);
            }
        } else {
            f2 = Float.parseFloat(str);
            AppMethodBeat.o(157925);
        }
        return f2;
    }

    public static double getDouble(String str, double d2) {
        AppMethodBeat.i(157926);
        if (str == null) {
            try {
                AppMethodBeat.o(157926);
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(157926);
            }
        } else {
            d2 = Double.parseDouble(str);
            AppMethodBeat.o(157926);
        }
        return d2;
    }

    public static int getHex(String str, int i2) {
        AppMethodBeat.i(157927);
        if (str == null) {
            AppMethodBeat.o(157927);
            return i2;
        }
        try {
            int longValue = (int) (Long.decode(str).longValue() & MAX_32BIT_VALUE);
            AppMethodBeat.o(157927);
            return longValue;
        } catch (NumberFormatException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157927);
            return i2;
        }
    }

    public static boolean hideVKB(View view) {
        boolean z;
        AppMethodBeat.i(157928);
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager == null) {
                AppMethodBeat.o(157928);
                return false;
            }
            z = inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
            Log.v(TAG, "hide VKB result %B", Boolean.valueOf(z));
            AppMethodBeat.o(157928);
            return z;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            Log.e(TAG, "hide VKB exception %s", e2);
            z = false;
        }
    }

    public static String getCutPasswordMD5(String str) {
        AppMethodBeat.i(157929);
        if (str == null) {
            str = "";
        }
        if (str.length() <= 16) {
            String fullPasswordMD5 = getFullPasswordMD5(str);
            AppMethodBeat.o(157929);
            return fullPasswordMD5;
        }
        String fullPasswordMD52 = getFullPasswordMD5(str.substring(0, 16));
        AppMethodBeat.o(157929);
        return fullPasswordMD52;
    }

    public static String getFullPasswordMD5(String str) {
        AppMethodBeat.i(186052);
        String messageDigest = g.getMessageDigest(str.getBytes());
        AppMethodBeat.o(186052);
        return messageDigest;
    }

    public static String encodeHexString(byte[] bArr) {
        AppMethodBeat.i(157931);
        StringBuilder sb = new StringBuilder("");
        if (bArr != null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                sb.append(String.format("%02x", Integer.valueOf(bArr[i2] & 255)));
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(157931);
        return sb2;
    }

    public static byte[] decodeHexString(String str) {
        AppMethodBeat.i(157932);
        if (str == null || str.length() <= 0) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(157932);
            return bArr;
        }
        try {
            byte[] bArr2 = new byte[(str.length() / 2)];
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                bArr2[i2] = (byte) (Integer.parseInt(str.substring(i2 * 2, (i2 * 2) + 2), 16) & 255);
            }
            AppMethodBeat.o(157932);
            return bArr2;
        } catch (NumberFormatException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            byte[] bArr3 = new byte[0];
            AppMethodBeat.o(157932);
            return bArr3;
        }
    }

    public static int[] splitToIntArray(String str) {
        AppMethodBeat.i(157933);
        if (str == null) {
            AppMethodBeat.o(157933);
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (str2 != null && str2.length() > 0) {
                try {
                    arrayList.add(Integer.valueOf(Integer.valueOf(str2).intValue()));
                } catch (Exception e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    Log.e(TAG, "invalid port num, ignore");
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        AppMethodBeat.o(157933);
        return iArr;
    }

    public static int UnZipFolder(String str, String str2) {
        AppMethodBeat.i(157934);
        int fW = s.fW(str, str2);
        AppMethodBeat.o(157934);
        return fW;
    }

    public static final String getHost(String str) {
        AppMethodBeat.i(157935);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(157935);
            return "";
        }
        try {
            String host = new URL(str).getHost();
            AppMethodBeat.o(157935);
            return host;
        } catch (MalformedURLException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            Log.w(TAG, "get host error");
            AppMethodBeat.o(157935);
            return str;
        }
    }

    public static boolean checkPermission(Context context, String str) {
        AppMethodBeat.i(157936);
        Assert.assertNotNull(context);
        String packageName = context.getPackageName();
        boolean z = context.getPackageManager().checkPermission(str, packageName) == 0;
        Log.d(TAG, packageName + " has " + (z ? "permission " : "no permission ") + str);
        AppMethodBeat.o(157936);
        return z;
    }

    public static boolean jump(Context context, String str) {
        AppMethodBeat.i(157937);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!isIntentAvailable(context, intent)) {
            Log.e(TAG, "jump to url failed, ".concat(String.valueOf(str)));
            AppMethodBeat.o(157937);
            return false;
        }
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/sdk/platformtools/Util", "jump", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/sdk/platformtools/Util", "jump", "(Landroid/content/Context;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(157937);
        return true;
    }

    public static String escapeStringForXml(String str) {
        AppMethodBeat.i(157938);
        if (str == null) {
            AppMethodBeat.o(157938);
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            boolean z = true;
            int length2 = INVALID.length - 1;
            while (true) {
                if (length2 < 0) {
                    break;
                } else if (INVALID[length2] == charAt) {
                    stringBuffer.append(VALID[length2]);
                    z = false;
                    break;
                } else {
                    length2--;
                }
            }
            if (i2 == length - 1 && Character.isHighSurrogate(charAt)) {
                z = false;
            }
            if (z) {
                stringBuffer.append(charAt);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(157938);
        return stringBuffer2;
    }

    public static String processXml(String str) {
        AppMethodBeat.i(157939);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(157939);
            return str;
        } else if (Build.VERSION.SDK_INT < 8) {
            String expandEntities = expandEntities(str);
            AppMethodBeat.o(157939);
            return expandEntities;
        } else {
            AppMethodBeat.o(157939);
            return str;
        }
    }

    private static String expandEntities(String str) {
        int i2;
        AppMethodBeat.i(230419);
        int length = str.length();
        char[] cArr = new char[length];
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            int i6 = i4 + 1;
            cArr[i4] = charAt;
            if (charAt == '&' && i5 == -1) {
                i4 = i6;
                i2 = i6;
            } else if (i5 == -1 || Character.isLetter(charAt) || Character.isDigit(charAt) || charAt == '#') {
                i4 = i6;
                i2 = i5;
            } else if (charAt == ';') {
                int lookupEntity = lookupEntity(cArr, i5, (i6 - i5) - 1);
                if (lookupEntity > 65535) {
                    int i7 = lookupEntity - 65536;
                    cArr[i5 - 1] = (char) ((i7 >> 10) + 55296);
                    cArr[i5] = (char) ((i7 & TXLiteAVCode.EVT_CAMERA_REMOVED) + 56320);
                    i5++;
                } else if (lookupEntity != 0) {
                    cArr[i5 - 1] = (char) lookupEntity;
                } else {
                    i5 = i6;
                }
                i4 = i5;
                i2 = -1;
            } else {
                i4 = i6;
                i2 = -1;
            }
            i3++;
            i5 = i2;
        }
        String str2 = new String(cArr, 0, i4);
        AppMethodBeat.o(230419);
        return str2;
    }

    private static int lookupEntity(char[] cArr, int i2, int i3) {
        AppMethodBeat.i(157940);
        if (i3 <= 0) {
            AppMethodBeat.o(157940);
            return 0;
        } else if (cArr[i2] != '#') {
            int entity = getEntity(new String(cArr, i2, i3));
            AppMethodBeat.o(157940);
            return entity;
        } else if (i3 <= 1 || !(cArr[i2 + 1] == 'x' || cArr[i2 + 1] == 'X')) {
            try {
                int parseInt = Integer.parseInt(new String(cArr, i2 + 1, i3 - 1), 10);
                AppMethodBeat.o(157940);
                return parseInt;
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(157940);
                return 0;
            }
        } else {
            try {
                int parseInt2 = Integer.parseInt(new String(cArr, i2 + 2, i3 - 2), 16);
                AppMethodBeat.o(157940);
                return parseInt2;
            } catch (NumberFormatException e3) {
                AppMethodBeat.o(157940);
                return 0;
            }
        }
    }

    private static int getEntity(String str) {
        return 0;
    }

    public static String mapToXml(String str, LinkedHashMap<String, String> linkedHashMap) {
        AppMethodBeat.i(230420);
        StringBuilder sb = new StringBuilder();
        sb.append("<key>");
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                key = "unknow";
            }
            if (value == null) {
                value = "unknow";
            }
            sb.append("<" + ((Object) key) + ">");
            sb.append((Object) value);
            sb.append("</" + ((Object) key) + ">");
        }
        sb.append("</key>");
        String sb2 = sb.toString();
        AppMethodBeat.o(230420);
        return sb2;
    }

    public static int safeParseInt(String str) {
        AppMethodBeat.i(157942);
        int i2 = 0;
        try {
            i2 = Integer.parseInt(str);
        } catch (Exception e2) {
            if (str != null) {
                Log.e(TAG, "parserInt error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.o(157942);
        return i2;
    }

    public static long safeParseLong(String str) {
        AppMethodBeat.i(157943);
        long j2 = 0;
        try {
            j2 = Long.parseLong(str);
        } catch (Exception e2) {
            if (str != null) {
                Log.e(TAG, "parseLong error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.o(157943);
        return j2;
    }

    public static double safeParseDouble(String str) {
        AppMethodBeat.i(157944);
        double d2 = 0.0d;
        try {
            d2 = Double.parseDouble(str);
        } catch (Exception e2) {
            if (str != null) {
                Log.e(TAG, "parseDouble error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.o(157944);
        return d2;
    }

    public static float safeParseFloat(String str) {
        AppMethodBeat.i(157945);
        float f2 = 0.0f;
        try {
            f2 = Float.parseFloat(str);
        } catch (Exception e2) {
            if (str != null) {
                Log.e(TAG, "parseFloat error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.o(157945);
        return f2;
    }

    public static boolean deleteFile(String str) {
        AppMethodBeat.i(157946);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(157946);
            return false;
        }
        o oVar = new o(str);
        if (!oVar.exists()) {
            AppMethodBeat.o(157946);
            return true;
        } else if (oVar.isDirectory()) {
            AppMethodBeat.o(157946);
            return false;
        } else {
            boolean delete = oVar.delete();
            AppMethodBeat.o(157946);
            return delete;
        }
    }

    public static void deleteOutOfDateFile(String str, String str2, long j2) {
        AppMethodBeat.i(157947);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(157947);
            return;
        }
        o oVar = new o(str);
        if (!oVar.exists() || !oVar.isDirectory()) {
            AppMethodBeat.o(157947);
            return;
        }
        o[] het = oVar.het();
        if (het == null || het.length == 0) {
            AppMethodBeat.o(157947);
            return;
        }
        for (o oVar2 : het) {
            if (oVar2.isFile() && oVar2.getName().startsWith(str2) && (nowMilliSecond() - oVar2.lastModified()) - j2 >= 0) {
                oVar2.delete();
            }
        }
        AppMethodBeat.o(157947);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ac A[SYNTHETIC, Splitter:B:31:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c5 A[SYNTHETIC, Splitter:B:39:0x00c5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFromFile(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.Util.readFromFile(java.lang.String):byte[]");
    }

    public static boolean writeToFile(String str, byte[] bArr) {
        AppMethodBeat.i(157949);
        if (isNullOrNil(str) || isNullOrNil(bArr)) {
            Log.w(TAG, "write to file error, path is null or empty, or data is empty");
            AppMethodBeat.o(157949);
            return false;
        }
        OutputStream outputStream = null;
        try {
            outputStream = s.dw(str, false);
            outputStream.write(bArr);
            outputStream.flush();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                }
            }
            Log.d(TAG, "writeToFile ok!");
            AppMethodBeat.o(157949);
            return true;
        } catch (Exception e3) {
            Log.printErrStackTrace(TAG, e3, "", new Object[0]);
            Log.w(TAG, "write to file error");
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    Log.printErrStackTrace(TAG, e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(157949);
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace(TAG, e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(157949);
            throw th;
        }
    }

    public static String getSourceeMd5(Context context) {
        AppMethodBeat.i(157950);
        if (context == null) {
            AppMethodBeat.o(157950);
            return null;
        }
        String signaturesMd5 = getSignaturesMd5(context.getPackageName(), context);
        AppMethodBeat.o(157950);
        return signaturesMd5;
    }

    public static String getSignaturesMd5(String str, Context context) {
        AppMethodBeat.i(157951);
        if (context == null || isNullOrNil(str)) {
            AppMethodBeat.o(157951);
            return null;
        }
        try {
            String messageDigest = g.getMessageDigest(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
            AppMethodBeat.o(157951);
            return messageDigest;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157951);
            return null;
        }
    }

    public static boolean isOverseasUser(Context context) {
        AppMethodBeat.i(157952);
        if (!Locale.getDefault().getCountry().equalsIgnoreCase(WeChatBrands.AppInfo.LANG_CN)) {
            AppMethodBeat.o(157952);
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            AppMethodBeat.o(157952);
            return true;
        } else if (context == null) {
            Log.w(TAG, "isOverseasUser context is null");
            AppMethodBeat.o(157952);
            return false;
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                if (!isNullOrNil(networkCountryIso) && !networkCountryIso.contains("cn") && !networkCountryIso.contains(WeChatBrands.AppInfo.LANG_CN)) {
                    AppMethodBeat.o(157952);
                    return true;
                }
            }
            AppMethodBeat.o(157952);
            return false;
        }
    }

    public static void invoke(String str, String str2, Object... objArr) {
        AppMethodBeat.i(230421);
        try {
            Class<?> cls = Class.forName(str);
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                if (method.getName().equals(str2)) {
                    try {
                        method.invoke(cls.newInstance(), objArr);
                        AppMethodBeat.o(230421);
                        return;
                    } catch (Exception e2) {
                        Log.e(TAG, "invoke failed, %s::%s", str, str2);
                        Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    }
                }
            }
            Log.e(TAG, "invoke failed, no method matched");
            AppMethodBeat.o(230421);
        } catch (Exception e3) {
            Log.e(TAG, "invoke failed, %s::%s", str, str2);
            Log.printErrStackTrace(TAG, e3, "", new Object[0]);
            AppMethodBeat.o(230421);
        }
    }

    public static View.OnTouchListener genLinearPressedListener() {
        AppMethodBeat.i(157953);
        AnonymousClass1 r0 = new View.OnTouchListener() {
            /* class com.tencent.mm.sdk.platformtools.Util.AnonymousClass1 */

            public final boolean onTouch(final View view, MotionEvent motionEvent) {
                AppMethodBeat.i(157853);
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        break;
                    case 1:
                    case 3:
                    case 4:
                        view.post(new Runnable() {
                            /* class com.tencent.mm.sdk.platformtools.Util.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                AppMethodBeat.i(157852);
                                view.setPressed(false);
                                AppMethodBeat.o(157852);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(157853);
                return false;
            }
        };
        AppMethodBeat.o(157953);
        return r0;
    }

    public static byte[] httpGet(String str) {
        AppMethodBeat.i(157954);
        if (str == null || str.length() == 0) {
            Log.e(TAG, "httpGet, url is null");
            AppMethodBeat.o(157954);
            return null;
        } else if (URLUtil.isDataUrl(str)) {
            byte[] base64Data = getBase64Data(str);
            AppMethodBeat.o(157954);
            return base64Data;
        } else if (URLUtil.isHttpsUrl(str)) {
            byte[] httpsData = getHttpsData(str);
            AppMethodBeat.o(157954);
            return httpsData;
        } else {
            byte[] httpData = getHttpData(str);
            AppMethodBeat.o(157954);
            return httpData;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] getHttpData(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 208
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.Util.getHttpData(java.lang.String):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] getHttpsData(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 214
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.Util.getHttpsData(java.lang.String):byte[]");
    }

    private static byte[] getBase64Data(String str) {
        AppMethodBeat.i(157957);
        try {
            int indexOf = str.indexOf("base64");
            if (indexOf > 0) {
                str = str.substring(indexOf + 7);
            }
            byte[] decode = Base64.decode(str, 0);
            AppMethodBeat.o(157957);
            return decode;
        } catch (Exception e2) {
            Log.e(TAG, "decode base64 url failed : %s", e2.getMessage());
            AppMethodBeat.o(157957);
            return null;
        }
    }

    public static CharSequence filterNumber(CharSequence charSequence) {
        AppMethodBeat.i(157958);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                stringBuffer.append(charAt);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(157958);
        return stringBuffer2;
    }

    public static String trimPhoneNumber(String str) {
        AppMethodBeat.i(157959);
        String trim = str.replaceAll("[\\.\\-]", "").trim();
        AppMethodBeat.o(157959);
        return trim;
    }

    public static String getPrivacyPhoneNum(String str) {
        AppMethodBeat.i(157960);
        if (isNullOrNil(str) || str.startsWith("+")) {
            AppMethodBeat.o(157960);
            return "";
        } else if (str.length() > 5) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.subSequence(0, 3));
            for (int i2 = 0; i2 < str.length() - 5; i2++) {
                char charAt = str.charAt(i2 + 3);
                if (charAt < '0' || charAt > '9') {
                    stringBuffer.append(charAt);
                } else {
                    stringBuffer.append('*');
                }
            }
            stringBuffer.append(str.charAt(str.length() - 2));
            stringBuffer.append(str.charAt(str.length() - 1));
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(157960);
            return stringBuffer2;
        } else {
            AppMethodBeat.o(157960);
            return str;
        }
    }

    public static Boolean isPhoneNumber(String str) {
        AppMethodBeat.i(157961);
        Boolean valueOf = Boolean.valueOf(Pattern.compile("^[+][0-9]{10,13}$").matcher(str).matches() || Pattern.compile("^1[0-9]{10}$").matcher(str).matches());
        AppMethodBeat.o(157961);
        return valueOf;
    }

    public static String formatNumber(String str) {
        AppMethodBeat.i(230422);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(230422);
            return "";
        }
        String replaceAll = str.replaceAll(",", "");
        if (replaceAll.length() <= 3) {
            AppMethodBeat.o(230422);
            return replaceAll;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int length = replaceAll.length() - 1; length >= 0; length--) {
            stringBuffer.append(replaceAll.charAt(length));
            if ((replaceAll.length() - length) % 3 == 0 && length != 0) {
                stringBuffer.append(",");
            }
        }
        String stringBuffer2 = stringBuffer.reverse().toString();
        AppMethodBeat.o(230422);
        return stringBuffer2;
    }

    public static String streamToString(InputStream inputStream) {
        AppMethodBeat.i(157962);
        if (inputStream == null) {
            AppMethodBeat.o(157962);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    stringBuffer.append(new String(bArr, 0, read));
                } else {
                    try {
                        break;
                    } catch (IOException e2) {
                        Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    }
                }
            }
            inputStream.close();
        } catch (Exception e3) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                Log.printErrStackTrace(TAG, e4, "", new Object[0]);
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                Log.printErrStackTrace(TAG, e5, "", new Object[0]);
            }
            AppMethodBeat.o(157962);
            throw th;
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(157962);
        return stringBuffer2;
    }

    public static String subStringEmail(String str) {
        int lastIndexOf;
        AppMethodBeat.i(157963);
        if (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf("@")) == -1) {
            AppMethodBeat.o(157963);
            return str;
        }
        String substring = str.substring(0, lastIndexOf);
        AppMethodBeat.o(157963);
        return substring;
    }

    public static long milliSecondsToDate(String str) {
        AppMethodBeat.i(230423);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(230423);
            return 0;
        }
        try {
            long time = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS).parse(str).getTime();
            long currentTimeMillis = System.currentTimeMillis();
            Log.i(TAG, "todate:[%d], now date:[%d]", Long.valueOf(time), Long.valueOf(currentTimeMillis));
            long j2 = currentTimeMillis - time;
            AppMethodBeat.o(230423);
            return j2;
        } catch (ParseException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(230423);
            return 0;
        }
    }

    public static String secPrint(String str) {
        AppMethodBeat.i(157964);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(157964);
            return "";
        }
        int length = str.length();
        if (length < 4) {
            String concat = "*~".concat(String.valueOf(length));
            AppMethodBeat.o(157964);
            return concat;
        } else if (length < 8) {
            String str2 = str.substring(0, 1) + "*" + str.substring(length - 2, length - 1) + "~" + length;
            AppMethodBeat.o(157964);
            return str2;
        } else {
            String str3 = str.substring(0, 2) + "*" + str.substring(length - 3, length - 1) + "~" + length;
            AppMethodBeat.o(157964);
            return str3;
        }
    }

    public static String stackTraceToString(Throwable th) {
        AppMethodBeat.i(186053);
        String stackTraceToString = MMStack.stackTraceToString(th);
        AppMethodBeat.o(186053);
        return stackTraceToString;
    }

    public static int random() {
        AppMethodBeat.i(157966);
        int nextInt = new Random().nextInt();
        AppMethodBeat.o(157966);
        return nextInt;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        AppMethodBeat.i(230424);
        boolean equals = "com.android.externalstorage.documents".equals(uri.getAuthority());
        AppMethodBeat.o(230424);
        return equals;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        AppMethodBeat.i(230425);
        boolean equals = "com.android.providers.downloads.documents".equals(uri.getAuthority());
        AppMethodBeat.o(230425);
        return equals;
    }

    public static boolean isMediaDocument(Uri uri) {
        AppMethodBeat.i(230426);
        boolean equals = "com.android.providers.media.documents".equals(uri.getAuthority());
        AppMethodBeat.o(230426);
        return equals;
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        AppMethodBeat.i(230427);
        boolean equals = "com.google.android.apps.photos.content".equals(uri.getAuthority());
        AppMethodBeat.o(230427);
        return equals;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.Util.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static String getPathFromUri(String str) {
        AppMethodBeat.i(230428);
        if (d.oD(24)) {
            String replace = str.replace("external_files", "");
            AppMethodBeat.o(230428);
            return replace;
        }
        AppMethodBeat.o(230428);
        return str;
    }

    @TargetApi(19)
    public static String getFilePath(Context context, Uri uri) {
        String str;
        Uri uri2 = null;
        AppMethodBeat.i(157968);
        if (context == null || uri == null) {
            Log.e(TAG, "getFilePath : context is null or uri is null");
            AppMethodBeat.o(157968);
            return null;
        }
        String scheme = uri.getScheme();
        if (isNullOrNil(scheme)) {
            Log.e(TAG, "input uri error. %s", uri);
            AppMethodBeat.o(157968);
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            Log.i(TAG, "getFilePath : scheme is SCHEME_FILE");
            String path = uri.getPath();
            AppMethodBeat.o(157968);
            return path;
        } else {
            if (scheme.equalsIgnoreCase("content")) {
                Log.i(TAG, "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
                if (isGooglePhotosUri(uri)) {
                    String lastPathSegment = uri.getLastPathSegment();
                    AppMethodBeat.o(157968);
                    return lastPathSegment;
                }
                try {
                    context.grantUriPermission(uri.getAuthority(), uri, 1);
                    str = getDataColumn(context, uri, null, null);
                } catch (SecurityException e2) {
                    Log.e(TAG, "getFilePath : exception = ".concat(String.valueOf(e2)));
                    str = null;
                }
                if (!isNullOrNil(str)) {
                    AppMethodBeat.o(157968);
                    return str;
                } else if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, uri)) {
                    if (isExternalStorageDocument(uri)) {
                        String[] split = DocumentsContract.getDocumentId(uri).split(":");
                        if ("primary".equalsIgnoreCase(split[0])) {
                            String str2 = Environment.getExternalStorageDirectory() + FilePathGenerator.ANDROID_DIR_SEP + split[1];
                            AppMethodBeat.o(157968);
                            return str2;
                        }
                        AppMethodBeat.o(157968);
                        return null;
                    } else if (isDownloadsDocument(uri)) {
                        String dataColumn = getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                        AppMethodBeat.o(157968);
                        return dataColumn;
                    } else if (isMediaDocument(uri)) {
                        String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str3 = split2[0];
                        if ("image".equals(str3)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if ("video".equals(str3)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else if (SlookAirButtonRecentMediaAdapter.AUDIO_TYPE.equals(str3)) {
                            uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        String dataColumn2 = getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
                        AppMethodBeat.o(157968);
                        return dataColumn2;
                    }
                }
            }
            Log.e(TAG, "unknown scheme");
            AppMethodBeat.o(157968);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (new java.io.File(r0).exists() == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isUriSafeToBeCopySrc(android.net.Uri r3) {
        /*
            r2 = 157969(0x26911, float:2.21362E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 != 0) goto L_0x000d
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x000c:
            return r0
        L_0x000d:
            java.lang.String r0 = "file"
            java.lang.String r1 = r3.getScheme()
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x002c
            java.lang.String r0 = "content"
            java.lang.String r1 = r3.getScheme()
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x002c
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x000c
        L_0x002c:
            r0 = 30
            boolean r0 = com.tencent.mm.compatible.util.d.oD(r0)
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = r3.getPath()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x004b
        L_0x0043:
            android.app.Application r0 = com.tencent.mm.sdk.platformtools.ApplicationGlobal.context()
            java.lang.String r0 = getFilePath(r0, r3)
        L_0x004b:
            boolean r0 = isFilePathSafeToBeCopySrc(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.Util.isUriSafeToBeCopySrc(android.net.Uri):boolean");
    }

    public static boolean isFilePathSafeToBeCopySrc(String str) {
        AppMethodBeat.i(157970);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(157970);
            return false;
        }
        try {
            boolean isResolvedPathSafeToBeCopySrc = isResolvedPathSafeToBeCopySrc(new File(s.k(str, false)).getCanonicalPath());
            AppMethodBeat.o(157970);
            return isResolvedPathSafeToBeCopySrc;
        } catch (NullPointerException e2) {
            Log.printErrStackTrace(TAG, e2, "[-] Fail to resolve canonical path of %s", str);
            AppMethodBeat.o(157970);
            return false;
        } catch (IOException e3) {
            Log.printErrStackTrace(TAG, e3, "[-] Fail to resolve canonical path of %s", str);
            AppMethodBeat.o(157970);
            return false;
        }
    }

    public static boolean isResolvedPathSafeToBeCopySrc(String str) {
        AppMethodBeat.i(230429);
        String packageName = ApplicationGlobal.context().getPackageName();
        if (str.contains(FilePathGenerator.ANDROID_DIR_SEP + packageName + "/cache/")) {
            AppMethodBeat.o(230429);
            return true;
        }
        String str2 = FilePathGenerator.ANDROID_DIR_SEP + packageName + "-";
        int indexOf = str.indexOf(str2);
        if (indexOf >= 0 && str.startsWith("/cache/", str.indexOf(FilePathGenerator.ANDROID_DIR_SEP, str2.length() + indexOf))) {
            AppMethodBeat.o(230429);
            return true;
        } else if (!str.contains("/data/data/") && !str.contains("/data/user/")) {
            AppMethodBeat.o(230429);
            return true;
        } else if (str.contains(FilePathGenerator.ANDROID_DIR_SEP + packageName + FilePathGenerator.ANDROID_DIR_SEP) || str.contains(FilePathGenerator.ANDROID_DIR_SEP + packageName + "-")) {
            AppMethodBeat.o(230429);
            return false;
        } else {
            AppMethodBeat.o(230429);
            return true;
        }
    }

    public static boolean isImageFilename(String str) {
        AppMethodBeat.i(157971);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(157971);
            return false;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            AppMethodBeat.o(157971);
            return false;
        }
        boolean isImageExt = isImageExt(str.substring(lastIndexOf + 1));
        AppMethodBeat.o(157971);
        return isImageExt;
    }

    public static boolean isImageExt(String str) {
        AppMethodBeat.i(157972);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(157972);
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("webp") && Build.VERSION.SDK_INT >= 14) {
            AppMethodBeat.o(157972);
            return true;
        } else if (lowerCase.equals("heic") && Build.VERSION.SDK_INT >= 28) {
            AppMethodBeat.o(157972);
            return true;
        } else if (lowerCase.equals("jpg") || lowerCase.equals("gif") || lowerCase.equals("bmp") || lowerCase.equals("jpeg") || lowerCase.equals("png")) {
            AppMethodBeat.o(157972);
            return true;
        } else {
            AppMethodBeat.o(157972);
            return false;
        }
    }

    public static ActivityTaskInfo getActivityTaskInfo(Context context) {
        AppMethodBeat.i(157973);
        ActivityTaskInfo activityTaskInfo = new ActivityTaskInfo(context);
        AppMethodBeat.o(157973);
        return activityTaskInfo;
    }

    public static ComponentName getTopActivity(Context context) {
        AppMethodBeat.i(157974);
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1);
            if (runningTasks == null || runningTasks.size() <= 0) {
                AppMethodBeat.o(157974);
                return null;
            }
            ComponentName componentName = runningTasks.get(0).topActivity;
            AppMethodBeat.o(157974);
            return componentName;
        } catch (Exception e2) {
            Log.e(TAG, "get Top Activity Exception:%s", e2.getMessage());
            AppMethodBeat.o(157974);
            return null;
        }
    }

    public static ComponentName getTopActivityByAppTasks(Context context) {
        AppMethodBeat.i(230430);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (Build.VERSION.SDK_INT >= 23) {
                List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    AppMethodBeat.o(230430);
                    return null;
                }
                Iterator<ActivityManager.AppTask> it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = it.next().getTaskInfo().topActivity;
                    if (componentName == null) {
                        AppMethodBeat.o(230430);
                        return null;
                    }
                    AppMethodBeat.o(230430);
                    return componentName;
                }
                AppMethodBeat.o(230430);
                return null;
            }
            ComponentName topActivity = getTopActivity(context);
            AppMethodBeat.o(230430);
            return topActivity;
        } catch (Exception e2) {
            Log.e(TAG, "get Top Activity Exception:%s", e2.getMessage());
            AppMethodBeat.o(230430);
            return null;
        }
    }

    public static String getTopActivityName2(Context context) {
        AppMethodBeat.i(157975);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (Build.VERSION.SDK_INT >= 23) {
                List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    AppMethodBeat.o(157975);
                    return "";
                }
                Iterator<ActivityManager.AppTask> it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = it.next().getTaskInfo().topActivity;
                    if (componentName == null) {
                        AppMethodBeat.o(157975);
                        return null;
                    }
                    String className = componentName.getClassName();
                    if (className.contains(".")) {
                        className = className.substring(className.lastIndexOf(".") + 1);
                    }
                    AppMethodBeat.o(157975);
                    return className;
                }
                AppMethodBeat.o(157975);
                return "";
            }
            String className2 = activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
            if (className2.contains(".")) {
                className2 = className2.substring(className2.lastIndexOf(".") + 1);
            }
            AppMethodBeat.o(157975);
            return className2;
        } catch (Exception e2) {
            Log.e(TAG, "getTopActivityName Exception:%s stack:%s", e2.getMessage(), stackTraceToString(e2));
        }
    }

    public static ActivityManager.RunningTaskInfo getCurrentTaskInfo(Context context, int i2) {
        AppMethodBeat.i(157976);
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1000)) {
            if (runningTaskInfo.id == i2) {
                AppMethodBeat.o(157976);
                return runningTaskInfo;
            }
        }
        AppMethodBeat.o(157976);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b8 A[SYNTHETIC, Splitter:B:46:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c1 A[SYNTHETIC, Splitter:B:51:0x00c1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getProcessNameByPid(android.content.Context r9, int r10) {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.Util.getProcessNameByPid(android.content.Context, int):java.lang.String");
    }

    public static MMStack getStack() {
        AppMethodBeat.i(157978);
        MMStack mMStack = new MMStack();
        AppMethodBeat.o(157978);
        return mMStack;
    }

    public static long nowMilliSecond() {
        AppMethodBeat.i(186054);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(186054);
        return currentTimeMillis;
    }

    public static long milliSecondsToNow(long j2) {
        AppMethodBeat.i(157980);
        long currentTimeMillis = System.currentTimeMillis() - j2;
        AppMethodBeat.o(157980);
        return currentTimeMillis;
    }

    public static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.i(157981);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine + "\n");
                } else {
                    try {
                        break;
                    } catch (IOException e2) {
                        Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    }
                }
            } catch (IOException e3) {
                Log.printErrStackTrace(TAG, e3, "", new Object[0]);
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    Log.printErrStackTrace(TAG, e4, "", new Object[0]);
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace(TAG, e5, "", new Object[0]);
                }
                AppMethodBeat.o(157981);
                throw th;
            }
        }
        inputStream.close();
        String sb2 = sb.toString();
        AppMethodBeat.o(157981);
        return sb2;
    }

    public static class ActivityTaskInfo {
        private Context context;

        public ActivityTaskInfo(Context context2) {
            this.context = context2;
        }

        public String toString() {
            AppMethodBeat.i(157854);
            String taskInfo = getTaskInfo(this.context);
            AppMethodBeat.o(157854);
            return taskInfo;
        }

        public static String getTaskInfo(Context context2) {
            AppMethodBeat.i(157855);
            if (context2 == null) {
                AppMethodBeat.o(157855);
                return null;
            }
            ActivityManager activityManager = (ActivityManager) context2.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            String packageName = context2.getPackageName();
            if (activityManager == null || Util.isNullOrNil(packageName)) {
                AppMethodBeat.o(157855);
                return null;
            }
            try {
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(100);
                StringBuffer stringBuffer = new StringBuffer();
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo.baseActivity.getClassName().startsWith(packageName) || runningTaskInfo.topActivity.getClassName().startsWith(packageName)) {
                        stringBuffer.append(String.format("{id:%d num:%d/%d top:%s base:%s}", Integer.valueOf(runningTaskInfo.id), Integer.valueOf(runningTaskInfo.numRunning), Integer.valueOf(runningTaskInfo.numActivities), runningTaskInfo.topActivity.getShortClassName(), runningTaskInfo.baseActivity.getShortClassName()));
                    }
                }
                String stringBuffer2 = stringBuffer.toString();
                AppMethodBeat.o(157855);
                return stringBuffer2;
            } catch (Exception e2) {
                Log.printErrStackTrace(Util.TAG, e2, "", new Object[0]);
                AppMethodBeat.o(157855);
                return "";
            }
        }
    }

    public static String getLengthStr(float f2) {
        AppMethodBeat.i(157982);
        if (f2 < 1024.0f) {
            String format = String.format("%.1fB", Float.valueOf(f2));
            AppMethodBeat.o(157982);
            return format;
        } else if (f2 < 1048576.0f) {
            String format2 = String.format("%.1fKB", Float.valueOf(f2 / 1024.0f));
            AppMethodBeat.o(157982);
            return format2;
        } else if (f2 < 1.07374182E9f) {
            String format3 = String.format("%.1fMB", Float.valueOf((f2 / 1024.0f) / 1024.0f));
            AppMethodBeat.o(157982);
            return format3;
        } else {
            String format4 = String.format("%.1fGB", Float.valueOf(((f2 / 1024.0f) / 1024.0f) / 1024.0f));
            AppMethodBeat.o(157982);
            return format4;
        }
    }

    public static String getFilterString(String str) {
        AppMethodBeat.i(157983);
        if (str == null) {
            AppMethodBeat.o(157983);
            return null;
        }
        for (int length = str.length(); length > 0; length--) {
            if (str.charAt(length - 1) != '\n' && str.charAt(length - 1) != '\r') {
                String substring = str.substring(0, length);
                AppMethodBeat.o(157983);
                return substring;
            }
        }
        AppMethodBeat.o(157983);
        return str;
    }

    public static boolean compare(Object obj, Object obj2) {
        boolean z = true;
        AppMethodBeat.i(157984);
        if (obj != obj2 && (obj == null || obj2 == null || !obj.equals(obj2))) {
            z = false;
        }
        AppMethodBeat.o(157984);
        return z;
    }

    public static void qualityClose(Closeable closeable) {
        AppMethodBeat.i(157985);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                Log.printErrStackTrace(TAG, e2, "qualityClose", new Object[0]);
                AppMethodBeat.o(157985);
                return;
            }
        }
        AppMethodBeat.o(157985);
    }

    public static String getRandomString(int i2) {
        AppMethodBeat.i(157986);
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(157986);
        return stringBuffer2;
    }

    public static void expandViewTouchArea(View view, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(157987);
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i5;
        rect.left -= i2;
        rect.right += i4;
        TouchDelegate touchDelegate = new TouchDelegate(rect, view);
        if (View.class.isInstance(view.getParent())) {
            ((View) view.getParent()).setTouchDelegate(touchDelegate);
        }
        AppMethodBeat.o(157987);
    }

    public static String escapeStringForUCC(String str) {
        AppMethodBeat.i(157988);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(157988);
            return str;
        }
        String replaceAll = str.replaceAll("‮", "");
        AppMethodBeat.o(157988);
        return replaceAll;
    }

    public static long getDataCRC32(byte[] bArr) {
        AppMethodBeat.i(230431);
        if (isNullOrNil(bArr)) {
            AppMethodBeat.o(230431);
            return 0;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        AppMethodBeat.o(230431);
        return value;
    }

    public static int byteArrayToInt(byte[] bArr) {
        AppMethodBeat.i(157989);
        if (bArr == null) {
            AppMethodBeat.o(157989);
            return 0;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        int i2 = wrap.getInt();
        AppMethodBeat.o(157989);
        return i2;
    }

    public static boolean isMobileNO(String str) {
        AppMethodBeat.i(230432);
        if (str == null) {
            AppMethodBeat.o(230432);
            return false;
        }
        boolean matches = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$").matcher(str).matches();
        AppMethodBeat.o(230432);
        return matches;
    }

    public static final String getDomin(String str) {
        AppMethodBeat.i(157990);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(157990);
            return null;
        }
        String host = Uri.parse(str).getHost();
        AppMethodBeat.o(157990);
        return host;
    }

    public static boolean isART() {
        AppMethodBeat.i(157991);
        String property = System.getProperty("java.vm.version");
        if (isNullOrNil(property) || !property.startsWith("2")) {
            AppMethodBeat.o(157991);
            return false;
        }
        AppMethodBeat.o(157991);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A[SYNTHETIC, Splitter:B:14:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d A[SYNTHETIC, Splitter:B:28:0x009d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.String> getRunningAppProcessesByPs() {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.Util.getRunningAppProcessesByPs():java.util.List");
    }

    public static boolean isEqual(String str, String str2) {
        AppMethodBeat.i(157993);
        if (isNullOrNil(str) && isNullOrNil(str2)) {
            AppMethodBeat.o(157993);
            return true;
        } else if (isNullOrNil(str) && !isNullOrNil(str2)) {
            AppMethodBeat.o(157993);
            return false;
        } else if (isNullOrNil(str) || !isNullOrNil(str2)) {
            boolean equals = str.equals(str2);
            AppMethodBeat.o(157993);
            return equals;
        } else {
            AppMethodBeat.o(157993);
            return false;
        }
    }

    public static boolean isEqual(int i2, int i3) {
        return i2 == i3;
    }

    public static boolean isEqual(long j2, long j3) {
        return j2 == j3;
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(157994);
        boolean equals = Arrays.equals(bArr, bArr2);
        AppMethodBeat.o(157994);
        return equals;
    }

    public static boolean isEqual(Object obj, Object obj2) {
        AppMethodBeat.i(157995);
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            AppMethodBeat.o(157995);
            return true;
        }
        AppMethodBeat.o(157995);
        return false;
    }

    public static int getSelfMemInMB(Context context) {
        AppMethodBeat.i(157996);
        if (context == null) {
            Log.i(TAG, "getSelfMemInMB context is null.");
            AppMethodBeat.o(157996);
            return -1;
        }
        Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo == null || processMemoryInfo.length <= 0) {
            AppMethodBeat.o(157996);
            return 0;
        }
        int totalPss = processMemoryInfo[0].getTotalPss() / 1024;
        AppMethodBeat.o(157996);
        return totalPss;
    }

    public static String safeFormatString(String str, Object... objArr) {
        AppMethodBeat.i(157997);
        try {
            str = String.format(str, objArr);
        } catch (Exception e2) {
            Log.i(TAG, "error safeFormatString %s", e2.getMessage());
        }
        AppMethodBeat.o(157997);
        return str;
    }

    public static Intent createExplicitFromImplicitIntent(Context context, Intent intent) {
        AppMethodBeat.i(157998);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            AppMethodBeat.o(157998);
            return null;
        }
        ResolveInfo resolveInfo = queryIntentServices.get(0);
        String str = resolveInfo.serviceInfo.packageName;
        String str2 = resolveInfo.serviceInfo.name;
        Log.d(TAG, "createExplicitFromImplicitIntent pa:%s, cl:%s", str, str2);
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        AppMethodBeat.o(157998);
        return intent2;
    }

    public static int convertStringToRGB(String str, int i2) {
        AppMethodBeat.i(157999);
        try {
            i2 = Color.parseColor(str);
            AppMethodBeat.o(157999);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "colorString:%s", str);
            AppMethodBeat.o(157999);
        }
        return i2;
    }

    public static int videoMsToSec(long j2) {
        AppMethodBeat.i(158000);
        int round = Math.round(((float) j2) / 1000.0f);
        AppMethodBeat.o(158000);
        return round;
    }

    public static String formatMoney2f(double d2) {
        AppMethodBeat.i(158001);
        String format = String.format("%.2f", Double.valueOf(d2));
        AppMethodBeat.o(158001);
        return format;
    }
}
