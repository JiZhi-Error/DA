package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final String LAST_LOGGED_TIME_SEC = "LAST_LOGGED_TIME_SEC";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final int PURCHASE_EXPIRE_TIME_SEC = 43200;
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String PURCHASE_SUBS_STORE = "com.facebook.internal.PURCHASE_SUBS";
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    private static final long SUBSCRIPTION_HARTBEAT_INTERVAL = 86400;
    private static final String TAG = InAppPurchaseEventManager.class.getCanonicalName();
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);
    private static final SharedPreferences purchaseSubsSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_SUBS_STORE, 0);
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);

    InAppPurchaseEventManager() {
    }

    static {
        AppMethodBeat.i(17646);
        AppMethodBeat.o(17646);
    }

    public static Object asInterface(Context context, IBinder iBinder) {
        AppMethodBeat.i(17628);
        Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, new Object[]{iBinder});
        AppMethodBeat.o(17628);
        return invokeMethod;
    }

    public static Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        AppMethodBeat.i(17629);
        Map<String, String> readSkuDetailsFromCache = readSkuDetailsFromCache(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!readSkuDetailsFromCache.containsKey(next)) {
                arrayList2.add(next);
            }
        }
        readSkuDetailsFromCache.putAll(getSkuDetailsFromGoogle(context, arrayList2, obj, z));
        AppMethodBeat.o(17629);
        return readSkuDetailsFromCache;
    }

    private static Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        AppMethodBeat.i(17630);
        HashMap hashMap = new HashMap();
        if (obj == null || arrayList.isEmpty()) {
            AppMethodBeat.o(17630);
            return hashMap;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
        Object[] objArr = new Object[4];
        objArr[0] = 3;
        objArr[1] = PACKAGE_NAME;
        objArr[2] = z ? SUBSCRIPTION : INAPP;
        objArr[3] = bundle;
        Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
        if (invokeMethod != null) {
            Bundle bundle2 = (Bundle) invokeMethod;
            if (bundle2.getInt(RESPONSE_CODE) == 0) {
                ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        hashMap.put(arrayList.get(i2), stringArrayList.get(i2));
                    }
                }
                writeSkuDetailsToCache(hashMap);
            }
        }
        AppMethodBeat.o(17630);
        return hashMap;
    }

    private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        AppMethodBeat.i(17631);
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String string = skuDetailSharedPrefs.getString(next, null);
            if (string != null) {
                String[] split = string.split(";", 2);
                if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                    hashMap.put(next, split[1]);
                }
            }
        }
        AppMethodBeat.o(17631);
        return hashMap;
    }

    private static void writeSkuDetailsToCache(Map<String, String> map) {
        AppMethodBeat.i(17632);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor edit = skuDetailSharedPrefs.edit();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            edit.putString(entry.getKey(), currentTimeMillis + ";" + entry.getValue());
        }
        edit.apply();
        AppMethodBeat.o(17632);
    }

    private static Boolean isBillingSupported(Context context, Object obj, String str) {
        AppMethodBeat.i(17633);
        if (obj == null) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(17633);
            return bool;
        }
        Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str});
        Boolean valueOf = Boolean.valueOf(invokeMethod != null && ((Integer) invokeMethod).intValue() == 0);
        AppMethodBeat.o(17633);
        return valueOf;
    }

    public static ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        AppMethodBeat.i(17634);
        ArrayList<String> filterPurchasesInapp = filterPurchasesInapp(getPurchases(context, obj, INAPP));
        AppMethodBeat.o(17634);
        return filterPurchasesInapp;
    }

    public static ArrayList<String> getPurchasesSubsExpire(Context context, Object obj) {
        AppMethodBeat.i(17635);
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, ?> all = purchaseSubsSharedPrefs.getAll();
        if (all.isEmpty()) {
            AppMethodBeat.o(17635);
            return arrayList;
        }
        ArrayList<String> purchases = getPurchases(context, obj, SUBSCRIPTION);
        HashSet hashSet = new HashSet();
        Iterator<String> it = purchases.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(new JSONObject(it.next()).getString("productId"));
            } catch (JSONException e2) {
            }
        }
        HashSet<String> hashSet2 = new HashSet();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            if (!hashSet.contains(key)) {
                hashSet2.add(key);
            }
        }
        SharedPreferences.Editor edit = purchaseSubsSharedPrefs.edit();
        for (String str : hashSet2) {
            String string = purchaseSubsSharedPrefs.getString(str, "");
            edit.remove(str);
            if (!string.isEmpty()) {
                arrayList.add(purchaseSubsSharedPrefs.getString(str, ""));
            }
        }
        edit.apply();
        AppMethodBeat.o(17635);
        return arrayList;
    }

    public static Map<String, SubscriptionType> getPurchasesSubs(Context context, Object obj) {
        AppMethodBeat.i(17636);
        HashMap hashMap = new HashMap();
        Iterator<String> it = getPurchases(context, obj, SUBSCRIPTION).iterator();
        while (it.hasNext()) {
            String next = it.next();
            SubscriptionType subsType = getSubsType(next);
            if (!(subsType == SubscriptionType.DUPLICATED || subsType == SubscriptionType.UNKNOWN)) {
                hashMap.put(next, subsType);
            }
        }
        AppMethodBeat.o(17636);
        return hashMap;
    }

    private static SubscriptionType getSubsType(String str) {
        JSONObject jSONObject;
        AppMethodBeat.i(17637);
        SubscriptionType subscriptionType = null;
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject2 = new JSONObject(str);
            String string = jSONObject2.getString("productId");
            String string2 = purchaseSubsSharedPrefs.getString(string, "");
            if (string2.isEmpty()) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string2);
            }
            if (!jSONObject.optString("purchaseToken").equals(jSONObject2.get("purchaseToken"))) {
                subscriptionType = currentTimeMillis - (jSONObject2.getLong("purchaseTime") / 1000) < 43200 ? SubscriptionType.NEW : SubscriptionType.HEARTBEAT;
            }
            if (subscriptionType == null && !string2.isEmpty()) {
                boolean z = jSONObject.getBoolean("autoRenewing");
                boolean z2 = jSONObject2.getBoolean("autoRenewing");
                if (!z2 && z) {
                    subscriptionType = SubscriptionType.CANCEL;
                } else if (!z && z2) {
                    subscriptionType = SubscriptionType.RESTORE;
                }
            }
            if (subscriptionType == null && !string2.isEmpty()) {
                if (currentTimeMillis - jSONObject.getLong(LAST_LOGGED_TIME_SEC) > 86400) {
                    subscriptionType = SubscriptionType.HEARTBEAT;
                } else {
                    subscriptionType = SubscriptionType.DUPLICATED;
                }
            }
            if (subscriptionType != SubscriptionType.DUPLICATED) {
                jSONObject2.put(LAST_LOGGED_TIME_SEC, currentTimeMillis);
                purchaseSubsSharedPrefs.edit().putString(string, jSONObject2.toString()).apply();
            }
            AppMethodBeat.o(17637);
            return subscriptionType;
        } catch (JSONException e2) {
            SubscriptionType subscriptionType2 = SubscriptionType.UNKNOWN;
            AppMethodBeat.o(17637);
            return subscriptionType2;
        }
    }

    private static ArrayList<String> getPurchases(Context context, Object obj, String str) {
        int i2;
        AppMethodBeat.i(17638);
        ArrayList<String> arrayList = new ArrayList<>();
        if (obj == null) {
            AppMethodBeat.o(17638);
            return arrayList;
        }
        if (isBillingSupported(context, obj, str).booleanValue()) {
            int i3 = 0;
            String str2 = null;
            while (true) {
                Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASES, obj, new Object[]{3, PACKAGE_NAME, str, str2});
                if (invokeMethod != null) {
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) == 0) {
                        ArrayList<String> stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST);
                        if (stringArrayList == null) {
                            break;
                        }
                        arrayList.addAll(stringArrayList);
                        str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                        i2 = i3 + stringArrayList.size();
                        if (i2 >= 30 || str2 == null) {
                            break;
                        }
                        i3 = i2;
                    }
                }
                i2 = i3;
                str2 = null;
                i3 = i2;
            }
        }
        AppMethodBeat.o(17638);
        return arrayList;
    }

    public static ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        AppMethodBeat.i(17639);
        ArrayList<String> arrayList = new ArrayList<>();
        if (obj == null) {
            AppMethodBeat.o(17639);
            return arrayList;
        }
        Class<?> cls = getClass(context, IN_APP_BILLING_SERVICE);
        if (cls == null) {
            AppMethodBeat.o(17639);
            return arrayList;
        } else if (getMethod(cls, GET_PURCHASE_HISTORY) == null) {
            AppMethodBeat.o(17639);
            return arrayList;
        } else {
            ArrayList<String> filterPurchasesInapp = filterPurchasesInapp(getPurchaseHistory(context, obj, INAPP));
            AppMethodBeat.o(17639);
            return filterPurchasesInapp;
        }
    }

    private static ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        int i2;
        Boolean bool;
        AppMethodBeat.i(17640);
        ArrayList<String> arrayList = new ArrayList<>();
        if (isBillingSupported(context, obj, str).booleanValue()) {
            int i3 = 0;
            Boolean bool2 = Boolean.FALSE;
            String str2 = null;
            while (true) {
                String str3 = null;
                Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, new Object[]{6, PACKAGE_NAME, str, str2, new Bundle()});
                if (invokeMethod != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) == 0) {
                        Iterator<String> it = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST).iterator();
                        int i4 = i3;
                        while (true) {
                            if (!it.hasNext()) {
                                bool = bool2;
                                break;
                            }
                            String next = it.next();
                            try {
                                if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                                arrayList.add(next);
                                i4++;
                            } catch (JSONException e2) {
                            }
                        }
                        str3 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                        bool2 = bool;
                        i2 = i4;
                        if (i2 >= 30 || str3 == null || bool2.booleanValue()) {
                            break;
                        }
                        i3 = i2;
                        str2 = str3;
                    }
                }
                i2 = i3;
                i3 = i2;
                str2 = str3;
            }
        }
        AppMethodBeat.o(17640);
        return arrayList;
    }

    private static ArrayList<String> filterPurchasesInapp(ArrayList<String> arrayList) {
        AppMethodBeat.i(17641);
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor edit = purchaseInappSharedPrefs.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                JSONObject jSONObject = new JSONObject(next);
                String string = jSONObject.getString("productId");
                long j2 = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j2 / 1000) <= 43200 && !purchaseInappSharedPrefs.getString(string, "").equals(string2)) {
                    edit.putString(string, string2);
                    arrayList2.add(next);
                }
            } catch (JSONException e2) {
            }
        }
        edit.apply();
        AppMethodBeat.o(17641);
        return arrayList2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r10.equals(com.facebook.appevents.internal.InAppPurchaseEventManager.AS_INTERFACE) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Method getMethod(java.lang.Class<?> r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 286
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.InAppPurchaseEventManager.getMethod(java.lang.Class, java.lang.String):java.lang.reflect.Method");
    }

    private static Class<?> getClass(Context context, String str) {
        AppMethodBeat.i(17643);
        Class<?> cls = classMap.get(str);
        if (cls != null) {
            AppMethodBeat.o(17643);
        } else {
            try {
                cls = context.getClassLoader().loadClass(str);
                classMap.put(str, cls);
            } catch (ClassNotFoundException e2) {
                new StringBuilder().append(str).append(" is not available, please add ").append(str).append(" to the project.");
            }
            AppMethodBeat.o(17643);
        }
        return cls;
    }

    private static Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Object obj2 = null;
        AppMethodBeat.i(17644);
        Class<?> cls = getClass(context, str);
        if (cls == null) {
            AppMethodBeat.o(17644);
        } else {
            Method method = getMethod(cls, str2);
            if (method == null) {
                AppMethodBeat.o(17644);
            } else {
                if (obj != null) {
                    obj = cls.cast(obj);
                }
                try {
                    obj2 = method.invoke(obj, objArr);
                    AppMethodBeat.o(17644);
                } catch (IllegalAccessException e2) {
                    new StringBuilder("Illegal access to method ").append(cls.getName()).append(".").append(method.getName());
                    AppMethodBeat.o(17644);
                    return obj2;
                } catch (InvocationTargetException e3) {
                    new StringBuilder("Invocation target exception in ").append(cls.getName()).append(".").append(method.getName());
                    AppMethodBeat.o(17644);
                    return obj2;
                }
            }
        }
        return obj2;
    }

    public static void clearSkuDetailsCache() {
        AppMethodBeat.i(17645);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j2 = skuDetailSharedPrefs.getLong(LAST_CLEARED_TIME, 0);
        if (j2 == 0) {
            skuDetailSharedPrefs.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
            AppMethodBeat.o(17645);
            return;
        }
        if (currentTimeMillis - j2 > 604800) {
            skuDetailSharedPrefs.edit().clear().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        }
        AppMethodBeat.o(17645);
    }
}
