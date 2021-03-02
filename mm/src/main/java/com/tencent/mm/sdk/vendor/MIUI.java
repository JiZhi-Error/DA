package com.tencent.mm.sdk.vendor;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.util.Properties;

public class MIUI {
    private static final String TAG = "Vendor.MIUI";
    private static Boolean ifMIUI = null;
    private static Boolean ifNotificationChannelSupportNativeActionJump = null;
    private static Boolean isMIUI = null;
    private static Boolean isMIUIV10 = null;
    private static Boolean isMIUIV8 = null;

    public static boolean isMIUI() {
        AppMethodBeat.i(153474);
        if (isMIUI == null) {
            InputStream inputStream = null;
            try {
                inputStream = s.ao(new o(Environment.getRootDirectory(), "build.prop"));
                Properties properties = new Properties();
                properties.load(inputStream);
                isMIUI = Boolean.valueOf(properties.containsKey("ro.miui.ui.version.name"));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                Log.e(TAG, "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e3);
                isMIUI = Boolean.FALSE;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                    }
                }
                AppMethodBeat.o(153474);
                throw th;
            }
        }
        boolean booleanValue = isMIUI.booleanValue();
        AppMethodBeat.o(153474);
        return booleanValue;
    }

    public static boolean isMIUIV8() {
        AppMethodBeat.i(153475);
        if (isMIUIV8 == null) {
            InputStream inputStream = null;
            try {
                inputStream = s.ao(new o(Environment.getRootDirectory(), "build.prop"));
                Properties properties = new Properties();
                properties.load(inputStream);
                Log.e(TAG, "ro.miui.ui.version.name %s", properties.getProperty("ro.miui.ui.version.name", ""));
                isMIUIV8 = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                Log.e(TAG, "e = %s, ** failed to fetch miui prop, assume we are not on miui. **", e3);
                isMIUIV8 = Boolean.FALSE;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                    }
                }
                AppMethodBeat.o(153475);
                throw th;
            }
        }
        boolean booleanValue = isMIUIV8.booleanValue();
        AppMethodBeat.o(153475);
        return booleanValue;
    }

    public static boolean isMIUI10() {
        AppMethodBeat.i(153476);
        if (isMIUIV10 == null) {
            String str = Build.MANUFACTURER;
            Log.i(TAG, "Build.MANUFACTURER = %s", str);
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("Xiaomi")) {
                isMIUIV10 = Boolean.FALSE;
            } else if (Util.isEqual(af.get("ro.miui.ui.version.code"), "8")) {
                isMIUIV10 = Boolean.TRUE;
            } else {
                isMIUIV10 = Boolean.FALSE;
            }
        }
        boolean booleanValue = isMIUIV10.booleanValue();
        AppMethodBeat.o(153476);
        return booleanValue;
    }

    public static boolean ifMIUI() {
        AppMethodBeat.i(153477);
        if (ifMIUI == null) {
            String str = Build.MANUFACTURER;
            Log.i(TAG, "Build.MANUFACTURER = %s", str);
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("Xiaomi")) {
                ifMIUI = Boolean.FALSE;
            } else {
                ifMIUI = Boolean.TRUE;
            }
        }
        boolean booleanValue = ifMIUI.booleanValue();
        AppMethodBeat.o(153477);
        return booleanValue;
    }

    public static boolean ifNotificationChannelSupportNativeActionJump() {
        AppMethodBeat.i(153478);
        if (ifNotificationChannelSupportNativeActionJump == null) {
            String str = Build.MANUFACTURER;
            Log.i(TAG, "Build.MANUFACTURER = %s, Build.MODEL = %s", str, Build.MODEL);
            if (TextUtils.isEmpty(str) || !str.equals("Xiaomi")) {
                ifNotificationChannelSupportNativeActionJump = Boolean.FALSE;
            } else {
                String systemProperty = getSystemProperty("ro.miui.version.code_time");
                Log.w(TAG, "ifNotificationChannelSupportNativeActionJump() versionCode:%s", systemProperty);
                if (Long.valueOf(systemProperty).longValue() > Long.valueOf("1536681600").longValue()) {
                    ifNotificationChannelSupportNativeActionJump = Boolean.TRUE;
                } else {
                    ifNotificationChannelSupportNativeActionJump = Boolean.FALSE;
                }
            }
        }
        Log.i(TAG, "ifNotificationChannelSupportNativeActionJump() ifNotificationChannelSupportNativeActionJump:%s", Boolean.valueOf(ifNotificationChannelSupportNativeActionJump.booleanValue()));
        boolean booleanValue = ifNotificationChannelSupportNativeActionJump.booleanValue();
        AppMethodBeat.o(153478);
        return booleanValue;
    }

    public static boolean ifLessThanVersinCode(String str) {
        boolean z = true;
        AppMethodBeat.i(214374);
        String systemProperty = getSystemProperty("ro.miui.version.code_time");
        if (!Util.isNullOrNil(str) && Long.valueOf(systemProperty).longValue() >= Long.valueOf(str).longValue()) {
            z = false;
        }
        AppMethodBeat.o(214374);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        if (ifLessThanVersinCode(r7) == false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ifInMinAndMax(int r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = 153479(0x25787, float:2.1507E-40)
            r0 = 1
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            int r2 = java.lang.Integer.parseInt(r5)
            if (r4 < r2) goto L_0x0023
            java.lang.String r2 = ""
            boolean r2 = com.tencent.mm.sdk.platformtools.Util.isEqual(r6, r2)
            if (r2 == 0) goto L_0x0028
            boolean r2 = ifMIUI()
            if (r2 == 0) goto L_0x0024
            boolean r2 = ifLessThanVersinCode(r7)
            if (r2 != 0) goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r0
        L_0x0028:
            int r2 = java.lang.Integer.parseInt(r6)
            if (r4 <= r2) goto L_0x0024
            r0 = r1
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.vendor.MIUI.ifInMinAndMax(int, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0077 A[SYNTHETIC, Splitter:B:20:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0095 A[SYNTHETIC, Splitter:B:28:0x0095] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getSystemProperty(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.vendor.MIUI.getSystemProperty(java.lang.String):java.lang.String");
    }
}
