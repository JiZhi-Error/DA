package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.google.b.e;
import com.google.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.util.EnumMap;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceRequestsHelper {
    static final String DEVICE_INFO_DEVICE = "device";
    static final String DEVICE_INFO_MODEL = "model";
    public static final String DEVICE_INFO_PARAM = "device_info";
    public static final String DEVICE_TARGET_USER_ID = "target_user_id";
    static final String SDK_FLAVOR = "android";
    static final String SDK_HEADER = "fbsdk";
    static final String SERVICE_TYPE = "_fb._tcp.";
    private static final String TAG = DeviceRequestsHelper.class.getCanonicalName();
    private static HashMap<String, NsdManager.RegistrationListener> deviceRequestsListeners = new HashMap<>();

    static {
        AppMethodBeat.i(7632);
        AppMethodBeat.o(7632);
    }

    public static String getDeviceInfo() {
        AppMethodBeat.i(7625);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DEVICE_INFO_DEVICE, Build.DEVICE);
            jSONObject.put(DEVICE_INFO_MODEL, Build.MODEL);
        } catch (JSONException e2) {
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(7625);
        return jSONObject2;
    }

    public static boolean startAdvertisementService(String str) {
        AppMethodBeat.i(7626);
        if (isAvailable()) {
            boolean startAdvertisementServiceImpl = startAdvertisementServiceImpl(str);
            AppMethodBeat.o(7626);
            return startAdvertisementServiceImpl;
        }
        AppMethodBeat.o(7626);
        return false;
    }

    public static boolean isAvailable() {
        AppMethodBeat.i(7627);
        if (Build.VERSION.SDK_INT < 16 || !FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.Enabled)) {
            AppMethodBeat.o(7627);
            return false;
        }
        AppMethodBeat.o(7627);
        return true;
    }

    public static Bitmap generateQRCode(String str) {
        Bitmap bitmap;
        AppMethodBeat.i(7628);
        EnumMap enumMap = new EnumMap(c.class);
        enumMap.put((Object) c.MARGIN, (Object) 2);
        try {
            b a2 = new e().a(str, a.QR_CODE, 200, 200, enumMap);
            int i2 = a2.height;
            int i3 = a2.width;
            int[] iArr = new int[(i2 * i3)];
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = i4 * i3;
                for (int i6 = 0; i6 < i3; i6++) {
                    iArr[i5 + i6] = a2.bI(i6, i4) ? WebView.NIGHT_MODE_COLOR : -1;
                }
            }
            bitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
            try {
                bitmap.setPixels(iArr, 0, i3, 0, 0, i3, i2);
            } catch (h e2) {
            }
        } catch (h e3) {
            bitmap = null;
        }
        AppMethodBeat.o(7628);
        return bitmap;
    }

    public static void cleanUpAdvertisementService(String str) {
        AppMethodBeat.i(7629);
        cleanUpAdvertisementServiceImpl(str);
        AppMethodBeat.o(7629);
    }

    @TargetApi(16)
    private static boolean startAdvertisementServiceImpl(final String str) {
        AppMethodBeat.i(7630);
        if (deviceRequestsListeners.containsKey(str)) {
            AppMethodBeat.o(7630);
        } else {
            final String format = String.format("%s_%s_%s", SDK_HEADER, String.format("%s-%s", "android", FacebookSdk.getSdkVersion().replace('.', '|')), str);
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceType(SERVICE_TYPE);
            nsdServiceInfo.setServiceName(format);
            nsdServiceInfo.setPort(80);
            AnonymousClass1 r3 = new NsdManager.RegistrationListener() {
                /* class com.facebook.devicerequests.internal.DeviceRequestsHelper.AnonymousClass1 */

                public final void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                    AppMethodBeat.i(7623);
                    if (!format.equals(nsdServiceInfo.getServiceName())) {
                        DeviceRequestsHelper.cleanUpAdvertisementService(str);
                    }
                    AppMethodBeat.o(7623);
                }

                public final void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
                }

                public final void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i2) {
                    AppMethodBeat.i(7624);
                    DeviceRequestsHelper.cleanUpAdvertisementService(str);
                    AppMethodBeat.o(7624);
                }

                public final void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i2) {
                }
            };
            deviceRequestsListeners.put(str, r3);
            ((NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery")).registerService(nsdServiceInfo, 1, r3);
            AppMethodBeat.o(7630);
        }
        return true;
    }

    @TargetApi(16)
    private static void cleanUpAdvertisementServiceImpl(String str) {
        AppMethodBeat.i(7631);
        NsdManager.RegistrationListener registrationListener = deviceRequestsListeners.get(str);
        if (registrationListener != null) {
            try {
                ((NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery")).unregisterService(registrationListener);
            } catch (IllegalArgumentException e2) {
                Utility.logd(TAG, e2);
            }
            deviceRequestsListeners.remove(str);
        }
        AppMethodBeat.o(7631);
    }
}
