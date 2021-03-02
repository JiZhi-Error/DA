package com.tencent.mm.plugin.exdevice.k;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public final class b {
    public static long anY(String str) {
        int i2 = 0;
        AppMethodBeat.i(24317);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.exdevice.Util", "mac string is null or nil");
            AppMethodBeat.o(24317);
            return 0;
        }
        String[] split = str.toUpperCase(Locale.US).split(":");
        Byte[] bArr = new Byte[split.length];
        int length = split.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            String str2 = split[i3];
            if (str2.length() == 0) {
                Log.e("MicroMsg.exdevice.Util", "mac string parse fail");
                AppMethodBeat.o(24317);
                return 0;
            }
            bArr[i4] = Byte.valueOf((byte) ((((byte) str2.charAt(0)) >= 65 ? ((str2.charAt(0) - 'A') + 10) << 4 : (str2.charAt(0) - '0') << 4) | (((byte) str2.charAt(1)) >= 65 ? (str2.charAt(1) - 'A') + 10 : str2.charAt(1) - '0')));
            i3++;
            i4++;
        }
        int length2 = split.length - 1;
        int length3 = bArr.length;
        long j2 = 0;
        while (i2 < length3) {
            j2 |= (bArr[i2].longValue() & 255) << (length2 << 3);
            i2++;
            length2--;
        }
        AppMethodBeat.o(24317);
        return j2;
    }

    public static String Dj(long j2) {
        AppMethodBeat.i(24318);
        byte[] bArr = new byte[6];
        for (int i2 = 0; i2 < 6; i2++) {
            bArr[i2] = (byte) ((int) (j2 >> (40 - (i2 << 3))));
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < 6; i3++) {
            if (i3 != 0) {
                sb.append(":");
            }
            int i4 = bArr[i3] & 255;
            if (i4 < 16) {
                sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            sb.append(Integer.toHexString(i4));
        }
        String upperCase = sb.toString().toUpperCase(Locale.US);
        AppMethodBeat.o(24318);
        return upperCase;
    }

    public static String bw(byte[] bArr) {
        AppMethodBeat.i(24319);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(24319);
            return null;
        }
        String V = V(bArr, bArr.length);
        AppMethodBeat.o(24319);
        return V;
    }

    public static String V(byte[] bArr, int i2) {
        AppMethodBeat.i(24320);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(24320);
            return null;
        }
        if (bArr.length < i2) {
            Log.w("MicroMsg.exdevice.Util", "data length is shorter then print command length");
            i2 = bArr.length;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & 255;
            if (i4 < 16) {
                sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            sb.append(Integer.toHexString(i4));
        }
        String upperCase = sb.toString().toUpperCase(Locale.US);
        AppMethodBeat.o(24320);
        return upperCase;
    }

    public static long bx(byte[] bArr) {
        long j2 = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            j2 |= (((long) bArr[i2]) & 255) << ((7 - i2) << 3);
        }
        return j2;
    }

    public static String cMi() {
        int i2 = 7;
        AppMethodBeat.i(24321);
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        try {
            int i3 = Util.getInt(String.valueOf(Calendar.getInstance().get(7)), 0);
            if (i3 != 1) {
                i2 = i3 - 1;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.exdevice.Util", "parse day failed : %s", e2.getMessage());
            i2 = 0;
        }
        String str = format + i2;
        AppMethodBeat.o(24321);
        return str;
    }

    public static String Dk(long j2) {
        AppMethodBeat.i(24322);
        byte[] bArr = new byte[6];
        for (int i2 = 0; i2 < 6; i2++) {
            bArr[i2] = (byte) ((int) (j2 >> (40 - (i2 << 3))));
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < 6; i3++) {
            int i4 = bArr[i3] & 255;
            if (i4 < 16) {
                sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            sb.append(Integer.toHexString(i4));
        }
        String upperCase = sb.toString().toUpperCase(Locale.US);
        AppMethodBeat.o(24322);
        return upperCase;
    }

    public static String anZ(String str) {
        AppMethodBeat.i(24323);
        if (str == null || 12 != str.length()) {
            Log.e("MicroMsg.exdevice.Util", "%s is not server string mac", str);
            AppMethodBeat.o(24323);
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(str.charAt(i2));
            if (i2 % 2 != 0 && i2 < str.length() - 1) {
                sb.append(":");
            }
        }
        Log.i("MicroMsg.exdevice.Util", "%s to %s is ok", str, sb.toString());
        String sb2 = sb.toString();
        AppMethodBeat.o(24323);
        return sb2;
    }

    public static long cMj() {
        long j2;
        AppMethodBeat.i(24324);
        String value = h.aqJ().getValue("DeviceAutoSyncDuration");
        if (!Util.isNullOrNil(value)) {
            try {
                j2 = Long.parseLong(value) * 1000;
            } catch (Exception e2) {
                Log.e("MicroMsg.exdevice.Util", "parse string to time out long failed : %s", e2.getMessage());
                j2 = 60000;
            }
        } else {
            j2 = 60000;
        }
        Log.i("MicroMsg.exdevice.Util", "now sync time out is %d", Long.valueOf(j2));
        if (j2 == 0) {
            AppMethodBeat.o(24324);
            return Util.MILLSECONDS_OF_MINUTE;
        }
        AppMethodBeat.o(24324);
        return j2;
    }

    public static boolean gg(String str, String str2) {
        AppMethodBeat.i(24325);
        Log.i("MicroMsg.exdevice.Util", "isDeviceInDeviceList, device = %s, device list = %s", str, str2);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(24325);
            return false;
        }
        try {
            String[] split = str2.split("\\|");
            if (split == null) {
                Log.e("MicroMsg.exdevice.Util", "null == deviceArray");
                AppMethodBeat.o(24325);
                return false;
            }
            for (String str3 : split) {
                if (str3.equalsIgnoreCase(str)) {
                    AppMethodBeat.o(24325);
                    return true;
                }
            }
            AppMethodBeat.o(24325);
            return false;
        } catch (Exception e2) {
            Log.e("MicroMsg.exdevice.Util", "aDeviceList.split failed, %s", e2.getMessage());
            AppMethodBeat.o(24325);
            return false;
        }
    }

    public static String gh(String str, String str2) {
        AppMethodBeat.i(24326);
        Log.i("MicroMsg.exdevice.Util", "addDeviceToDeviceList, device = %s, device list = %s", str, str2);
        if (Util.isNullOrNil(str) || str2 == null) {
            Log.e("MicroMsg.exdevice.Util", "Error parameters!!!");
            AppMethodBeat.o(24326);
            return null;
        }
        String str3 = ((new String() + str2) + str) + "|";
        Log.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", str3);
        AppMethodBeat.o(24326);
        return str3;
    }

    public static String gi(String str, String str2) {
        AppMethodBeat.i(24327);
        Log.i("MicroMsg.exdevice.Util", "moveDevicefromDeviceList, device = %s, device list = %s", str, str2);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.exdevice.Util", "parameters is null or nil");
            AppMethodBeat.o(24327);
            return null;
        }
        try {
            String[] split = str2.split("\\|");
            if (split == null) {
                Log.e("MicroMsg.exdevice.Util", "null == strArray");
                AppMethodBeat.o(24327);
                return null;
            }
            String str3 = new String();
            boolean z = false;
            for (String str4 : split) {
                if (!str4.equalsIgnoreCase(str)) {
                    str3 = (str3 + str4) + "|";
                } else {
                    z = true;
                }
            }
            if (!z) {
                Log.e("MicroMsg.exdevice.Util", "remove failed!!!, this device is not in the list");
                AppMethodBeat.o(24327);
                return null;
            }
            Log.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", str2);
            AppMethodBeat.o(24327);
            return str3;
        } catch (Exception e2) {
            Log.e("MicroMsg.exdevice.Util", "aDeviceList.split failed!!!, %s", e2.getMessage());
            AppMethodBeat.o(24327);
            return null;
        }
    }

    public static UUID by(byte[] bArr) {
        AppMethodBeat.i(24328);
        Log.d("MicroMsg.exdevice.Util", "parseUUIDFromByteArray, uuid byte array = %s", bw(bArr));
        if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.exdevice.Util", "aUUIDByteArray is null or nil");
            AppMethodBeat.o(24328);
            return null;
        } else if (16 != bArr.length) {
            Log.e("MicroMsg.exdevice.Util", "the length (%d) of this byte array is not 16", Integer.valueOf(bArr.length));
            AppMethodBeat.o(24328);
            return null;
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            ByteBuffer allocate2 = ByteBuffer.allocate(8);
            try {
                allocate.put(bArr, 0, 8);
                allocate.flip();
                allocate2.put(bArr, 8, 8);
                allocate2.flip();
                UUID uuid = new UUID(allocate.getLong(), allocate2.getLong());
                Log.d("MicroMsg.exdevice.Util", "parse successful, string of uuid = %s", uuid.toString());
                AppMethodBeat.o(24328);
                return uuid;
            } catch (Exception e2) {
                Log.e("MicroMsg.exdevice.Util", "%s", e2.getMessage());
                AppMethodBeat.o(24328);
                return null;
            }
        }
    }

    public static boolean c(byte[] bArr, int i2, byte[] bArr2) {
        AppMethodBeat.i(24329);
        if (Util.isNullOrNil(bArr) || Util.isNullOrNil(bArr2) || bArr2.length + i2 > bArr.length || i2 < 0 || i2 >= bArr.length) {
            AppMethodBeat.o(24329);
            return false;
        }
        int i3 = 0;
        while (i3 < bArr2.length && bArr2[i3] == bArr[i3 + i2]) {
            i3++;
        }
        if (i3 != bArr2.length) {
            AppMethodBeat.o(24329);
            return false;
        }
        AppMethodBeat.o(24329);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[SYNTHETIC, Splitter:B:25:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009d A[SYNTHETIC, Splitter:B:37:0x009d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] de(java.lang.Object r9) {
        /*
        // Method dump skipped, instructions count: 200
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.k.b.de(java.lang.Object):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0069 A[SYNTHETIC, Splitter:B:24:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b4 A[SYNTHETIC, Splitter:B:36:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0101 A[SYNTHETIC, Splitter:B:48:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0128 A[SYNTHETIC, Splitter:B:59:0x0128] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object bz(byte[] r9) {
        /*
        // Method dump skipped, instructions count: 343
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.k.b.bz(byte[]):java.lang.Object");
    }

    public static int D(Context context, int i2) {
        int i3;
        int i4 = 0;
        AppMethodBeat.i(24332);
        try {
            Rect rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = ((Activity) context).getWindow().getDecorView().getHeight();
            if (height - rect.height() >= 0) {
                i3 = height - rect.height();
            } else {
                i3 = rect.top;
            }
            if (i3 > 0) {
                i4 = i3;
            }
            AppMethodBeat.o(24332);
        } catch (Exception e2) {
            Log.i("MicroMsg.exdevice.Util", "getStatusHeight err: %s", e2.toString());
            AppMethodBeat.o(24332);
        } catch (Throwable th) {
            AppMethodBeat.o(24332);
        }
        return i4;
    }
}
