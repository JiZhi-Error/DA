package com.tencent.mmkv;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;

public class MMKVContentProvider extends ContentProvider {
    private static Uri Rzw;

    protected static Uri kU(Context context) {
        AppMethodBeat.i(13528);
        if (Rzw != null) {
            Uri uri = Rzw;
            AppMethodBeat.o(13528);
            return uri;
        } else if (context == null) {
            AppMethodBeat.o(13528);
            return null;
        } else {
            String queryAuthority = queryAuthority(context);
            if (queryAuthority == null) {
                AppMethodBeat.o(13528);
                return null;
            }
            Uri parse = Uri.parse("content://".concat(String.valueOf(queryAuthority)));
            Rzw = parse;
            AppMethodBeat.o(13528);
            return parse;
        }
    }

    private static String queryAuthority(Context context) {
        ProviderInfo providerInfo;
        AppMethodBeat.i(13529);
        try {
            ComponentName componentName = new ComponentName(context, MMKVContentProvider.class.getName());
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (providerInfo = packageManager.getProviderInfo(componentName, 0)) == null)) {
                String str = providerInfo.authority;
                AppMethodBeat.o(13529);
                return str;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(13529);
        return null;
    }

    public boolean onCreate() {
        AppMethodBeat.i(13530);
        Context context = getContext();
        if (context == null) {
            AppMethodBeat.o(13530);
            return false;
        }
        String queryAuthority = queryAuthority(context);
        if (queryAuthority == null) {
            AppMethodBeat.o(13530);
            return false;
        }
        if (Rzw == null) {
            Rzw = Uri.parse("content://".concat(String.valueOf(queryAuthority)));
        }
        AppMethodBeat.o(13530);
        return true;
    }

    protected static String aT(Context context, int i2) {
        AppMethodBeat.i(13531);
        ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (activityManager != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i2) {
                    String str = runningAppProcessInfo.processName;
                    AppMethodBeat.o(13531);
                    return str;
                }
            }
        }
        AppMethodBeat.o(13531);
        return "";
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(13532);
        if (!str.equals("mmkvFromAshmemID") || bundle == null) {
            AppMethodBeat.o(13532);
            return null;
        }
        MMKV mmkvWithAshmemID = MMKV.mmkvWithAshmemID(getContext(), str2, bundle.getInt("KEY_SIZE"), bundle.getInt("KEY_MODE"), bundle.getString("KEY_CRYPT"));
        if (mmkvWithAshmemID != null) {
            ParcelableMMKV parcelableMMKV = new ParcelableMMKV(mmkvWithAshmemID);
            new StringBuilder().append(str2).append(" fd = ").append(mmkvWithAshmemID.ashmemFD()).append(", meta fd = ").append(mmkvWithAshmemID.ashmemMetaFD());
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("KEY", parcelableMMKV);
            AppMethodBeat.o(13532);
            return bundle2;
        }
        AppMethodBeat.o(13532);
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(13533);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.o(13533);
        throw unsupportedOperationException;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AppMethodBeat.i(13534);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.o(13534);
        throw unsupportedOperationException;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(13535);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.o(13535);
        throw unsupportedOperationException;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(13536);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.o(13536);
        throw unsupportedOperationException;
    }
}
