package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkAppVersion;

public class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    public static final String LAST_NAME = "ln";
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    private static final String TAG = UserDataStore.class.getSimpleName();
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    public static final String ZIP = "zp";
    private static String hashedUserData;
    private static volatile boolean initialized = false;
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(17473);
        initAndWait();
        AppMethodBeat.o(17473);
    }

    static /* synthetic */ String access$300(Bundle bundle) {
        AppMethodBeat.i(17474);
        String hashUserData = hashUserData(bundle);
        AppMethodBeat.o(17474);
        return hashUserData;
    }

    static {
        AppMethodBeat.i(17475);
        AppMethodBeat.o(17475);
    }

    public static void initStore() {
        AppMethodBeat.i(17464);
        if (initialized) {
            AppMethodBeat.o(17464);
            return;
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.UserDataStore.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(17462);
                UserDataStore.access$000();
                AppMethodBeat.o(17462);
            }
        });
        AppMethodBeat.o(17464);
    }

    public static void setUserDataAndHash(final Bundle bundle) {
        AppMethodBeat.i(17465);
        if (!initialized) {
            initAndWait();
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.UserDataStore.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(17463);
                UserDataStore.lock.writeLock().lock();
                try {
                    String unused = UserDataStore.hashedUserData = UserDataStore.access$300(bundle);
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                    edit.putString(UserDataStore.USER_DATA_KEY, UserDataStore.hashedUserData);
                    edit.apply();
                } finally {
                    UserDataStore.lock.writeLock().unlock();
                    AppMethodBeat.o(17463);
                }
            }
        });
        AppMethodBeat.o(17465);
    }

    public static void setUserDataAndHash(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        AppMethodBeat.i(17466);
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(EMAIL, str);
        }
        if (str2 != null) {
            bundle.putString(FIRST_NAME, str2);
        }
        if (str3 != null) {
            bundle.putString(LAST_NAME, str3);
        }
        if (str4 != null) {
            bundle.putString(PHONE, str4);
        }
        if (str5 != null) {
            bundle.putString(DATE_OF_BIRTH, str5);
        }
        if (str6 != null) {
            bundle.putString(GENDER, str6);
        }
        if (str7 != null) {
            bundle.putString(CITY, str7);
        }
        if (str8 != null) {
            bundle.putString(STATE, str8);
        }
        if (str9 != null) {
            bundle.putString(ZIP, str9);
        }
        if (str10 != null) {
            bundle.putString(COUNTRY, str10);
        }
        setUserDataAndHash(bundle);
        AppMethodBeat.o(17466);
    }

    public static String getHashedUserData() {
        AppMethodBeat.i(17467);
        if (!initialized) {
            initAndWait();
        }
        lock.readLock().lock();
        try {
            return hashedUserData;
        } finally {
            lock.readLock().unlock();
            AppMethodBeat.o(17467);
        }
    }

    private static void initAndWait() {
        AppMethodBeat.i(17468);
        if (initialized) {
            AppMethodBeat.o(17468);
            return;
        }
        lock.writeLock().lock();
        try {
            if (!initialized) {
                hashedUserData = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(USER_DATA_KEY, null);
                initialized = true;
                lock.writeLock().unlock();
                AppMethodBeat.o(17468);
            }
        } finally {
            lock.writeLock().unlock();
            AppMethodBeat.o(17468);
        }
    }

    private static String hashUserData(Bundle bundle) {
        AppMethodBeat.i(17469);
        if (bundle == null) {
            AppMethodBeat.o(17469);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                String obj = bundle.get(str).toString();
                if (maybeSHA256Hashed(obj)) {
                    jSONObject.put(str, obj.toLowerCase());
                } else {
                    String encryptData = encryptData(normalizeData(str, bundle.get(str).toString()));
                    if (encryptData != null) {
                        jSONObject.put(str, encryptData);
                    }
                }
            } catch (JSONException e2) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(17469);
        return jSONObject2;
    }

    private static String encryptData(String str) {
        AppMethodBeat.i(17470);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(17470);
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM);
            instance.update(str.getBytes());
            String bytesToHex = AppEventUtility.bytesToHex(instance.digest());
            AppMethodBeat.o(17470);
            return bytesToHex;
        } catch (NoSuchAlgorithmException e2) {
            AppMethodBeat.o(17470);
            return null;
        }
    }

    private static String normalizeData(String str, String str2) {
        AppMethodBeat.i(17471);
        String str3 = "";
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3185:
                if (str.equals(CITY)) {
                    c2 = 3;
                    break;
                }
                break;
            case 3240:
                if (str.equals(EMAIL)) {
                    c2 = 0;
                    break;
                }
                break;
            case 3272:
                if (str.equals(FIRST_NAME)) {
                    c2 = 1;
                    break;
                }
                break;
            case 3294:
                if (str.equals(GENDER)) {
                    c2 = 7;
                    break;
                }
                break;
            case 3458:
                if (str.equals(LAST_NAME)) {
                    c2 = 2;
                    break;
                }
                break;
            case 3576:
                if (str.equals(PHONE)) {
                    c2 = 6;
                    break;
                }
                break;
            case 3681:
                if (str.equals(STATE)) {
                    c2 = 4;
                    break;
                }
                break;
            case 957831062:
                if (str.equals(COUNTRY)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                str3 = str2.trim().toLowerCase();
                break;
            case 6:
                str3 = str2.trim().replaceAll("[^0-9]", "");
                break;
            case 7:
                String lowerCase = str2.trim().toLowerCase();
                if (lowerCase.length() <= 0) {
                    str3 = "";
                    break;
                } else {
                    str3 = lowerCase.substring(0, 1);
                    break;
                }
        }
        AppMethodBeat.o(17471);
        return str3;
    }

    private static boolean maybeSHA256Hashed(String str) {
        AppMethodBeat.i(17472);
        boolean matches = str.matches("[A-Fa-f0-9]{64}");
        AppMethodBeat.o(17472);
        return matches;
    }
}
