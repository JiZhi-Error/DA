package com.tencent.mm.plugin.exdevice.i;

import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    private static void b(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(23774);
        Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "tryToClearDirtyData");
        if (Build.VERSION.SDK_INT < 11) {
            AppMethodBeat.o(23774);
        } else if (sharedPreferences == null) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == aSP");
            AppMethodBeat.o(23774);
        } else {
            String[] strArr = {"conneted_device", "shut_down_device"};
            for (int i2 = 0; i2 < 2; i2++) {
                String str = strArr[i2];
                try {
                    if (sharedPreferences.getStringSet(str, null) != null) {
                        Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "find dirty data, remove it, key = %s", str);
                        if (!sharedPreferences.edit().remove(str).commit()) {
                            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove dirty data failed!!!");
                        }
                    }
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(23774);
        }
    }

    public static boolean ac(String str, long j2) {
        AppMethodBeat.i(23775);
        Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "isItemInSharedPreferences, key = %s, device id = %d", str, Long.valueOf(j2));
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.o(23775);
            return false;
        }
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.o(23775);
            return false;
        }
        b(sharedPreferences);
        if (!b.gg(String.valueOf(j2), sharedPreferences.getString(str, new String()))) {
            AppMethodBeat.o(23775);
            return false;
        }
        AppMethodBeat.o(23775);
        return true;
    }

    public static boolean ad(String str, long j2) {
        AppMethodBeat.i(23776);
        Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addToSharedPreferences, key = %s, deviceId = %d", str, Long.valueOf(j2));
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.o(23776);
            return false;
        }
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.o(23776);
            return false;
        }
        b(sharedPreferences);
        String gh = b.gh(String.valueOf(j2), sharedPreferences.getString(str, new String()));
        if (gh == null) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addDeviceToDeviceList failed!!!");
            AppMethodBeat.o(23776);
            return false;
        } else if (!sharedPreferences.edit().putString(str, gh).commit()) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit() Failed!!!");
            AppMethodBeat.o(23776);
            return false;
        } else {
            Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "add to sharepreference successful, new device list is %s", gh);
            AppMethodBeat.o(23776);
            return true;
        }
    }

    public static boolean ae(String str, long j2) {
        boolean commit;
        AppMethodBeat.i(23777);
        Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "removeFromSharedPreferences, key = %s, deviceId = %d", str, Long.valueOf(j2));
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.o(23777);
            return false;
        }
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.o(23777);
            return false;
        }
        b(sharedPreferences);
        String gi = b.gi(String.valueOf(j2), sharedPreferences.getString(str, new String()));
        if (gi == null) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove device from device list failed!!!");
            AppMethodBeat.o(23777);
            return false;
        }
        if (gi.length() == 0) {
            commit = sharedPreferences.edit().remove(str).commit();
        } else {
            commit = sharedPreferences.edit().putString(str, gi).commit();
        }
        if (!commit) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit()");
            AppMethodBeat.o(23777);
            return false;
        }
        Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove from sharepreference successful, new device list is %s", gi);
        AppMethodBeat.o(23777);
        return true;
    }

    public static long[] anH(String str) {
        Exception e2;
        AppMethodBeat.i(23778);
        Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "getListFromSharedPreferences, key = %s", str);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.o(23778);
            return null;
        }
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.o(23778);
            return null;
        }
        b(sharedPreferences);
        try {
            String[] split = sharedPreferences.getString(str, new String()).split("\\|");
            if (split == null || split.length == 0) {
                Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == strDeviceList || 0 == strDeviceList.length");
                AppMethodBeat.o(23778);
                return null;
            }
            long[] jArr = new long[split.length];
            int i2 = 0;
            for (String str2 : split) {
                try {
                    Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "parse %s to long", str2);
                    if (str2.length() != 0) {
                        int i3 = i2 + 1;
                        try {
                            jArr[i2] = Util.getLong(str2, 0);
                            i2 = i3;
                        } catch (Exception e3) {
                            e2 = e3;
                            i2 = i3;
                            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "try pase string device id to long failed : " + e2.getMessage());
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "try pase string device id to long failed : " + e2.getMessage());
                }
            }
            if (i2 == 0) {
                AppMethodBeat.o(23778);
                return null;
            }
            AppMethodBeat.o(23778);
            return jArr;
        } catch (Exception e5) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "split failed!!!, %s", e5.getMessage());
            AppMethodBeat.o(23778);
            return null;
        }
    }
}
