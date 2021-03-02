package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppPurchaseActivityLifecycleTracker {
    private static final String BILLING_ACTIVITY_NAME = "com.android.billingclient.api.ProxyBillingActivity";
    private static final String SERVICE_INTERFACE_NAME = "com.android.vending.billing.IInAppBillingService$a";
    private static final String TAG = InAppPurchaseActivityLifecycleTracker.class.getCanonicalName();
    private static Application.ActivityLifecycleCallbacks callbacks;
    private static Boolean hasBiillingActivity = null;
    private static Boolean hasBillingService = null;
    private static Object inAppBillingObj;
    private static Intent intent;
    private static final AtomicBoolean isTracking = new AtomicBoolean(false);
    private static ServiceConnection serviceConnection;

    static /* synthetic */ void access$100(Context context, ArrayList arrayList) {
        AppMethodBeat.i(17625);
        logPurchaseInapp(context, arrayList);
        AppMethodBeat.o(17625);
    }

    static /* synthetic */ void access$200(Context context, Map map) {
        AppMethodBeat.i(17626);
        logPurchaseSubs(context, map);
        AppMethodBeat.o(17626);
    }

    static {
        AppMethodBeat.i(17627);
        AppMethodBeat.o(17627);
    }

    public static void update() {
        AppMethodBeat.i(17620);
        initializeIfNotInitialized();
        if (!hasBillingService.booleanValue()) {
            AppMethodBeat.o(17620);
            return;
        }
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            startTracking();
        }
        AppMethodBeat.o(17620);
    }

    private static void initializeIfNotInitialized() {
        AppMethodBeat.i(17621);
        if (hasBillingService != null) {
            AppMethodBeat.o(17621);
            return;
        }
        try {
            Class.forName(SERVICE_INTERFACE_NAME);
            hasBillingService = Boolean.TRUE;
            try {
                Class.forName(BILLING_ACTIVITY_NAME);
                hasBiillingActivity = Boolean.TRUE;
            } catch (ClassNotFoundException e2) {
                hasBiillingActivity = Boolean.FALSE;
            }
            InAppPurchaseEventManager.clearSkuDetailsCache();
            intent = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
            serviceConnection = new ServiceConnection() {
                /* class com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.AnonymousClass1 */

                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    AppMethodBeat.i(17615);
                    Object unused = InAppPurchaseActivityLifecycleTracker.inAppBillingObj = InAppPurchaseEventManager.asInterface(FacebookSdk.getApplicationContext(), iBinder);
                    AppMethodBeat.o(17615);
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                }
            };
            callbacks = new Application.ActivityLifecycleCallbacks() {
                /* class com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.AnonymousClass2 */

                public final void onActivityResumed(Activity activity) {
                    AppMethodBeat.i(17618);
                    FacebookSdk.getExecutor().execute(new Runnable() {
                        /* class com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(17616);
                            Context applicationContext = FacebookSdk.getApplicationContext();
                            InAppPurchaseActivityLifecycleTracker.access$100(applicationContext, InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj));
                            Map<String, SubscriptionType> purchasesSubs = InAppPurchaseEventManager.getPurchasesSubs(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                            Iterator<String> it = InAppPurchaseEventManager.getPurchasesSubsExpire(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj).iterator();
                            while (it.hasNext()) {
                                purchasesSubs.put(it.next(), SubscriptionType.EXPIRE);
                            }
                            InAppPurchaseActivityLifecycleTracker.access$200(applicationContext, purchasesSubs);
                            AppMethodBeat.o(17616);
                        }
                    });
                    AppMethodBeat.o(17618);
                }

                public final void onActivityCreated(Activity activity, Bundle bundle) {
                }

                public final void onActivityStarted(Activity activity) {
                }

                public final void onActivityPaused(Activity activity) {
                }

                public final void onActivityStopped(Activity activity) {
                    AppMethodBeat.i(17619);
                    if (InAppPurchaseActivityLifecycleTracker.hasBiillingActivity.booleanValue() && activity.getLocalClassName().equals(InAppPurchaseActivityLifecycleTracker.BILLING_ACTIVITY_NAME)) {
                        FacebookSdk.getExecutor().execute(new Runnable() {
                            /* class com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.AnonymousClass2.AnonymousClass2 */

                            public void run() {
                                AppMethodBeat.i(17617);
                                Context applicationContext = FacebookSdk.getApplicationContext();
                                ArrayList<String> purchasesInapp = InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                                if (purchasesInapp.isEmpty()) {
                                    purchasesInapp = InAppPurchaseEventManager.getPurchaseHistoryInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                                }
                                InAppPurchaseActivityLifecycleTracker.access$100(applicationContext, purchasesInapp);
                                AppMethodBeat.o(17617);
                            }
                        });
                    }
                    AppMethodBeat.o(17619);
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public final void onActivityDestroyed(Activity activity) {
                }
            };
            AppMethodBeat.o(17621);
        } catch (ClassNotFoundException e3) {
            hasBillingService = Boolean.FALSE;
            AppMethodBeat.o(17621);
        }
    }

    private static void startTracking() {
        AppMethodBeat.i(17622);
        if (!isTracking.compareAndSet(false, true)) {
            AppMethodBeat.o(17622);
            return;
        }
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(callbacks);
            applicationContext.bindService(intent, serviceConnection, 1);
        }
        AppMethodBeat.o(17622);
    }

    private static void logPurchaseInapp(Context context, ArrayList<String> arrayList) {
        AppMethodBeat.i(17623);
        if (arrayList.isEmpty()) {
            AppMethodBeat.o(17623);
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                String string = new JSONObject(next).getString("productId");
                hashMap.put(string, next);
                arrayList2.add(string);
            } catch (JSONException e2) {
            }
        }
        for (Map.Entry<String, String> entry : InAppPurchaseEventManager.getSkuDetails(context, arrayList2, inAppBillingObj, false).entrySet()) {
            AutomaticAnalyticsLogger.logPurchaseInapp((String) hashMap.get(entry.getKey()), entry.getValue());
        }
        AppMethodBeat.o(17623);
    }

    private static void logPurchaseSubs(Context context, Map<String, SubscriptionType> map) {
        AppMethodBeat.i(17624);
        if (map.isEmpty()) {
            AppMethodBeat.o(17624);
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            try {
                String string = new JSONObject(str).getString("productId");
                arrayList.add(string);
                hashMap.put(string, str);
            } catch (JSONException e2) {
            }
        }
        Map<String, String> skuDetails = InAppPurchaseEventManager.getSkuDetails(context, arrayList, inAppBillingObj, true);
        for (String str2 : skuDetails.keySet()) {
            String str3 = (String) hashMap.get(str2);
            AutomaticAnalyticsLogger.logPurchaseSubs(map.get(str3), str3, skuDetails.get(str2));
        }
        AppMethodBeat.o(17624);
    }
}
