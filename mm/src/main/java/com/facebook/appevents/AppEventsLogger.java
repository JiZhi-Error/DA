package com.facebook.appevents;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
    private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
    private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
    private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private static final String TAG = AppEventsLogger.class.getCanonicalName();
    private static String anonymousAppDeviceGUID;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private static FlushBehavior flushBehavior = FlushBehavior.AUTO;
    private static boolean isActivateAppEventRequested;
    private static boolean isOpenedByAppLink;
    private static String pushNotificationsRegistrationId;
    private static String sourceApplication;
    private static Object staticLock = new Object();
    private final AccessTokenAppIdPair accessTokenAppId;
    private final String contextName;

    static /* synthetic */ void access$000(AppEventsLogger appEventsLogger, long j2, String str) {
        AppMethodBeat.i(17417);
        appEventsLogger.logAppSessionResumeEvent(j2, str);
        AppMethodBeat.o(17417);
    }

    static /* synthetic */ void access$100(AppEventsLogger appEventsLogger, long j2) {
        AppMethodBeat.i(17418);
        appEventsLogger.logAppSessionSuspendEvent(j2);
        AppMethodBeat.o(17418);
    }

    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY;

        public static FlushBehavior valueOf(String str) {
            AppMethodBeat.i(17348);
            FlushBehavior flushBehavior = (FlushBehavior) Enum.valueOf(FlushBehavior.class, str);
            AppMethodBeat.o(17348);
            return flushBehavior;
        }

        static {
            AppMethodBeat.i(17349);
            AppMethodBeat.o(17349);
        }
    }

    public enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED;

        public static ProductAvailability valueOf(String str) {
            AppMethodBeat.i(17359);
            ProductAvailability productAvailability = (ProductAvailability) Enum.valueOf(ProductAvailability.class, str);
            AppMethodBeat.o(17359);
            return productAvailability;
        }

        static {
            AppMethodBeat.i(17360);
            AppMethodBeat.o(17360);
        }
    }

    public enum ProductCondition {
        NEW,
        REFURBISHED,
        USED;

        public static ProductCondition valueOf(String str) {
            AppMethodBeat.i(17362);
            ProductCondition productCondition = (ProductCondition) Enum.valueOf(ProductCondition.class, str);
            AppMethodBeat.o(17362);
            return productCondition;
        }

        static {
            AppMethodBeat.i(17363);
            AppMethodBeat.o(17363);
        }
    }

    static {
        AppMethodBeat.i(17419);
        AppMethodBeat.o(17419);
    }

    public static void activateApp(Application application) {
        AppMethodBeat.i(17364);
        activateApp(application, (String) null);
        AppMethodBeat.o(17364);
    }

    public static void activateApp(Application application, String str) {
        AppMethodBeat.i(17365);
        if (!FacebookSdk.isInitialized()) {
            FacebookException facebookException = new FacebookException("The Facebook sdk must be initialized before calling activateApp");
            AppMethodBeat.o(17365);
            throw facebookException;
        }
        AnalyticsUserIDStore.initStore();
        UserDataStore.initStore();
        if (str == null) {
            str = FacebookSdk.getApplicationId();
        }
        FacebookSdk.publishInstallAsync(application, str);
        ActivityLifecycleTracker.startTracking(application, str);
        AppMethodBeat.o(17365);
    }

    @Deprecated
    public static void activateApp(Context context) {
        AppMethodBeat.i(17366);
        if (ActivityLifecycleTracker.isTracking()) {
            AppMethodBeat.o(17366);
            return;
        }
        FacebookSdk.sdkInitialize(context);
        activateApp(context, Utility.getMetadataApplicationId(context));
        AppMethodBeat.o(17366);
    }

    @Deprecated
    public static void activateApp(Context context, String str) {
        AppMethodBeat.i(17367);
        if (ActivityLifecycleTracker.isTracking()) {
            AppMethodBeat.o(17367);
        } else if (context == null || str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both context and applicationId must be non-null");
            AppMethodBeat.o(17367);
            throw illegalArgumentException;
        } else {
            AnalyticsUserIDStore.initStore();
            UserDataStore.initStore();
            if (context instanceof Activity) {
                setSourceApplication((Activity) context);
            } else {
                resetSourceApplication();
                Utility.logd(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
            }
            FacebookSdk.publishInstallAsync(context, str);
            AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, (AccessToken) null);
            final long currentTimeMillis = System.currentTimeMillis();
            final String sourceApplication2 = getSourceApplication();
            backgroundExecutor.execute(new Runnable(appEventsLogger) {
                /* class com.facebook.appevents.AppEventsLogger.AnonymousClass1 */
                final /* synthetic */ AppEventsLogger val$logger;

                {
                    this.val$logger = r1;
                }

                public final void run() {
                    AppMethodBeat.i(17342);
                    AppEventsLogger.access$000(this.val$logger, currentTimeMillis, sourceApplication2);
                    AppMethodBeat.o(17342);
                }
            });
            AppMethodBeat.o(17367);
        }
    }

    @Deprecated
    public static void deactivateApp(Context context) {
        AppMethodBeat.i(17368);
        if (ActivityLifecycleTracker.isTracking()) {
            AppMethodBeat.o(17368);
            return;
        }
        deactivateApp(context, Utility.getMetadataApplicationId(context));
        AppMethodBeat.o(17368);
    }

    @Deprecated
    public static void deactivateApp(Context context, String str) {
        AppMethodBeat.i(17369);
        if (ActivityLifecycleTracker.isTracking()) {
            AppMethodBeat.o(17369);
        } else if (context == null || str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both context and applicationId must be non-null");
            AppMethodBeat.o(17369);
            throw illegalArgumentException;
        } else {
            resetSourceApplication();
            AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, (AccessToken) null);
            final long currentTimeMillis = System.currentTimeMillis();
            backgroundExecutor.execute(new Runnable(appEventsLogger) {
                /* class com.facebook.appevents.AppEventsLogger.AnonymousClass2 */
                final /* synthetic */ AppEventsLogger val$logger;

                {
                    this.val$logger = r1;
                }

                public final void run() {
                    AppMethodBeat.i(17343);
                    AppEventsLogger.access$100(this.val$logger, currentTimeMillis);
                    AppMethodBeat.o(17343);
                }
            });
            AppMethodBeat.o(17369);
        }
    }

    private void logAppSessionResumeEvent(long j2, String str) {
        AppMethodBeat.i(17370);
        PersistedAppSessionInfo.onResume(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, j2, str);
        AppMethodBeat.o(17370);
    }

    private void logAppSessionSuspendEvent(long j2) {
        AppMethodBeat.i(17371);
        PersistedAppSessionInfo.onSuspend(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, j2);
        AppMethodBeat.o(17371);
    }

    public static void initializeLib(Context context, String str) {
        AppMethodBeat.i(17372);
        if (!FacebookSdk.getAutoLogAppEventsEnabled()) {
            AppMethodBeat.o(17372);
            return;
        }
        backgroundExecutor.execute(new Runnable(new AppEventsLogger(context, str, (AccessToken) null)) {
            /* class com.facebook.appevents.AppEventsLogger.AnonymousClass3 */
            final /* synthetic */ AppEventsLogger val$logger;

            {
                this.val$logger = r1;
            }

            public final void run() {
                AppMethodBeat.i(17344);
                Bundle bundle = new Bundle();
                try {
                    Class.forName("com.facebook.core.Core");
                    bundle.putInt("core_lib_included", 1);
                } catch (ClassNotFoundException e2) {
                }
                try {
                    Class.forName("com.facebook.login.Login");
                    bundle.putInt("login_lib_included", 1);
                } catch (ClassNotFoundException e3) {
                }
                try {
                    Class.forName("com.facebook.share.Share");
                    bundle.putInt("share_lib_included", 1);
                } catch (ClassNotFoundException e4) {
                }
                try {
                    Class.forName("com.facebook.places.Places");
                    bundle.putInt("places_lib_included", 1);
                } catch (ClassNotFoundException e5) {
                }
                try {
                    Class.forName("com.facebook.messenger.Messenger");
                    bundle.putInt("messenger_lib_included", 1);
                } catch (ClassNotFoundException e6) {
                }
                try {
                    Class.forName("com.facebook.applinks.AppLinks");
                    bundle.putInt("applinks_lib_included", 1);
                } catch (ClassNotFoundException e7) {
                }
                try {
                    Class.forName("com.facebook.marketing.Marketing");
                    bundle.putInt("marketing_lib_included", 1);
                } catch (ClassNotFoundException e8) {
                }
                try {
                    Class.forName("com.facebook.all.All");
                    bundle.putInt("all_lib_included", 1);
                } catch (ClassNotFoundException e9) {
                }
                try {
                    Class.forName("com.android.billingclient.api.BillingClient");
                    bundle.putInt("billing_client_lib_included", 1);
                } catch (ClassNotFoundException e10) {
                }
                try {
                    Class.forName("com.android.vending.billing.IInAppBillingService");
                    bundle.putInt("billing_service_lib_included", 1);
                } catch (ClassNotFoundException e11) {
                }
                this.val$logger.logSdkEvent(AnalyticsEvents.EVENT_SDK_INITIALIZE, null, bundle);
                AppMethodBeat.o(17344);
            }
        });
        AppMethodBeat.o(17372);
    }

    public static AppEventsLogger newLogger(Context context) {
        AppMethodBeat.i(17373);
        AppEventsLogger appEventsLogger = new AppEventsLogger(context, (String) null, (AccessToken) null);
        AppMethodBeat.o(17373);
        return appEventsLogger;
    }

    public static AppEventsLogger newLogger(Context context, AccessToken accessToken) {
        AppMethodBeat.i(17374);
        AppEventsLogger appEventsLogger = new AppEventsLogger(context, (String) null, accessToken);
        AppMethodBeat.o(17374);
        return appEventsLogger;
    }

    public static AppEventsLogger newLogger(Context context, String str, AccessToken accessToken) {
        AppMethodBeat.i(17375);
        AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, accessToken);
        AppMethodBeat.o(17375);
        return appEventsLogger;
    }

    public static AppEventsLogger newLogger(Context context, String str) {
        AppMethodBeat.i(17376);
        AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, (AccessToken) null);
        AppMethodBeat.o(17376);
        return appEventsLogger;
    }

    public static FlushBehavior getFlushBehavior() {
        FlushBehavior flushBehavior2;
        synchronized (staticLock) {
            flushBehavior2 = flushBehavior;
        }
        return flushBehavior2;
    }

    public static void setFlushBehavior(FlushBehavior flushBehavior2) {
        synchronized (staticLock) {
            flushBehavior = flushBehavior2;
        }
    }

    public void logEvent(String str) {
        AppMethodBeat.i(17377);
        logEvent(str, (Bundle) null);
        AppMethodBeat.o(17377);
    }

    public void logEvent(String str, double d2) {
        AppMethodBeat.i(17378);
        logEvent(str, d2, null);
        AppMethodBeat.o(17378);
    }

    public void logEvent(String str, Bundle bundle) {
        AppMethodBeat.i(17379);
        logEvent(str, null, bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
        AppMethodBeat.o(17379);
    }

    public void logEvent(String str, double d2, Bundle bundle) {
        AppMethodBeat.i(17380);
        logEvent(str, Double.valueOf(d2), bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
        AppMethodBeat.o(17380);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        AppMethodBeat.i(17381);
        AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
        logPurchase(bigDecimal, currency, null, false);
        AppMethodBeat.o(17381);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(17382);
        AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
        logPurchase(bigDecimal, currency, bundle, false);
        AppMethodBeat.o(17382);
    }

    @Deprecated
    public void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(17383);
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            new StringBuilder().append("Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. ").append("Auto-logging of in-app purchase has been enabled in the SDK, so you don't have to manually log purchases");
            AppMethodBeat.o(17383);
            return;
        }
        new StringBuilder().append("Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. ").append("Please use logPurchase() function instead.");
        AppMethodBeat.o(17383);
    }

    /* access modifiers changed from: protected */
    public void logPurchaseImplicitlyInternal(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(17384);
        logPurchase(bigDecimal, currency, bundle, true);
        AppMethodBeat.o(17384);
    }

    private void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
        Bundle bundle2;
        AppMethodBeat.i(17385);
        if (bigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
            AppMethodBeat.o(17385);
        } else if (currency == null) {
            notifyDeveloperError("currency cannot be null");
            AppMethodBeat.o(17385);
        } else {
            if (bundle == null) {
                bundle2 = new Bundle();
            } else {
                bundle2 = bundle;
            }
            bundle2.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
            logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, Double.valueOf(bigDecimal.doubleValue()), bundle2, z, ActivityLifecycleTracker.getCurrentSessionGuid());
            eagerFlush();
            AppMethodBeat.o(17385);
        }
    }

    public void logPushNotificationOpen(Bundle bundle) {
        AppMethodBeat.i(17386);
        logPushNotificationOpen(bundle, null);
        AppMethodBeat.o(17386);
    }

    public void logPushNotificationOpen(Bundle bundle, String str) {
        AppMethodBeat.i(17387);
        String str2 = null;
        try {
            String string = bundle.getString(PUSH_PAYLOAD_KEY);
            if (Utility.isNullOrEmpty(string)) {
                AppMethodBeat.o(17387);
                return;
            }
            str2 = new JSONObject(string).getString("campaign");
            if (str2 == null) {
                Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Malformed payload specified for logging a push notification open.");
                AppMethodBeat.o(17387);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(APP_EVENT_PUSH_PARAMETER_CAMPAIGN, str2);
            if (str != null) {
                bundle2.putString(APP_EVENT_PUSH_PARAMETER_ACTION, str);
            }
            logEvent(APP_EVENT_NAME_PUSH_OPENED, bundle2);
            AppMethodBeat.o(17387);
        } catch (JSONException e2) {
        }
    }

    public void logProductItem(String str, ProductAvailability productAvailability, ProductCondition productCondition, String str2, String str3, String str4, String str5, BigDecimal bigDecimal, Currency currency, String str6, String str7, String str8, Bundle bundle) {
        AppMethodBeat.i(17388);
        if (str == null) {
            notifyDeveloperError("itemID cannot be null");
            AppMethodBeat.o(17388);
        } else if (productAvailability == null) {
            notifyDeveloperError("availability cannot be null");
            AppMethodBeat.o(17388);
        } else if (productCondition == null) {
            notifyDeveloperError("condition cannot be null");
            AppMethodBeat.o(17388);
        } else if (str2 == null) {
            notifyDeveloperError("description cannot be null");
            AppMethodBeat.o(17388);
        } else if (str3 == null) {
            notifyDeveloperError("imageLink cannot be null");
            AppMethodBeat.o(17388);
        } else if (str4 == null) {
            notifyDeveloperError("link cannot be null");
            AppMethodBeat.o(17388);
        } else if (str5 == null) {
            notifyDeveloperError("title cannot be null");
            AppMethodBeat.o(17388);
        } else if (bigDecimal == null) {
            notifyDeveloperError("priceAmount cannot be null");
            AppMethodBeat.o(17388);
        } else if (currency == null) {
            notifyDeveloperError("currency cannot be null");
            AppMethodBeat.o(17388);
        } else if (str6 == null && str7 == null && str8 == null) {
            notifyDeveloperError("Either gtin, mpn or brand is required");
            AppMethodBeat.o(17388);
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_ITEM_ID, str);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_AVAILABILITY, productAvailability.name());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_CONDITION, productCondition.name());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_DESCRIPTION, str2);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_IMAGE_LINK, str3);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_LINK, str4);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_TITLE, str5);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_AMOUNT, bigDecimal.setScale(3, 4).toString());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_CURRENCY, currency.getCurrencyCode());
            if (str6 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_GTIN, str6);
            }
            if (str7 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_MPN, str7);
            }
            if (str8 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_BRAND, str8);
            }
            logEvent(AppEventsConstants.EVENT_NAME_PRODUCT_CATALOG_UPDATE, bundle);
            eagerFlush();
            AppMethodBeat.o(17388);
        }
    }

    public void flush() {
        AppMethodBeat.i(17389);
        AppEventQueue.flush(FlushReason.EXPLICIT);
        AppMethodBeat.o(17389);
    }

    public static void onContextStop() {
        AppMethodBeat.i(17390);
        AppEventQueue.persistToDisk();
        AppMethodBeat.o(17390);
    }

    public boolean isValidForAccessToken(AccessToken accessToken) {
        AppMethodBeat.i(17391);
        boolean equals = this.accessTokenAppId.equals(new AccessTokenAppIdPair(accessToken));
        AppMethodBeat.o(17391);
        return equals;
    }

    public static void setPushNotificationsRegistrationId(String str) {
        AppMethodBeat.i(17392);
        synchronized (staticLock) {
            try {
                if (!Utility.stringsEqualOrEmpty(pushNotificationsRegistrationId, str)) {
                    pushNotificationsRegistrationId = str;
                    AppEventsLogger newLogger = newLogger(FacebookSdk.getApplicationContext());
                    newLogger.logEvent(AppEventsConstants.EVENT_NAME_PUSH_TOKEN_OBTAINED);
                    if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                        newLogger.flush();
                    }
                }
            } finally {
                AppMethodBeat.o(17392);
            }
        }
    }

    static String getPushNotificationsRegistrationId() {
        String str;
        synchronized (staticLock) {
            str = pushNotificationsRegistrationId;
        }
        return str;
    }

    public static void augmentWebView(WebView webView, Context context) {
        int i2 = 0;
        AppMethodBeat.i(17393);
        String[] split = Build.VERSION.RELEASE.split("\\.");
        int parseInt = split.length > 0 ? Integer.parseInt(split[0]) : 0;
        if (split.length > 1) {
            i2 = Integer.parseInt(split[1]);
        }
        if (Build.VERSION.SDK_INT < 17 || parseInt < 4 || (parseInt == 4 && i2 <= 1)) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "augmentWebView is only available for Android SDK version >= 17 on devices running Android >= 4.2");
            AppMethodBeat.o(17393);
            return;
        }
        webView.addJavascriptInterface(new FacebookSDKJSInterface(context), "fbmq_" + FacebookSdk.getApplicationId());
        AppMethodBeat.o(17393);
    }

    public static void setUserID(String str) {
        AppMethodBeat.i(17394);
        AnalyticsUserIDStore.setUserID(str);
        AppMethodBeat.o(17394);
    }

    public static String getUserID() {
        AppMethodBeat.i(17395);
        String userID = AnalyticsUserIDStore.getUserID();
        AppMethodBeat.o(17395);
        return userID;
    }

    public static void clearUserID() {
        AppMethodBeat.i(17396);
        AnalyticsUserIDStore.setUserID(null);
        AppMethodBeat.o(17396);
    }

    @Deprecated
    public static void setUserData(Bundle bundle) {
        AppMethodBeat.i(17397);
        UserDataStore.setUserDataAndHash(bundle);
        AppMethodBeat.o(17397);
    }

    public static void setUserData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        AppMethodBeat.i(17398);
        UserDataStore.setUserDataAndHash(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
        AppMethodBeat.o(17398);
    }

    public static String getUserData() {
        AppMethodBeat.i(17399);
        String hashedUserData = UserDataStore.getHashedUserData();
        AppMethodBeat.o(17399);
        return hashedUserData;
    }

    public static void clearUserData() {
        AppMethodBeat.i(17400);
        UserDataStore.setUserDataAndHash(null);
        AppMethodBeat.o(17400);
    }

    public static void updateUserProperties(Bundle bundle, GraphRequest.Callback callback) {
        AppMethodBeat.i(17401);
        updateUserProperties(bundle, FacebookSdk.getApplicationId(), callback);
        AppMethodBeat.o(17401);
    }

    public static void updateUserProperties(final Bundle bundle, final String str, final GraphRequest.Callback callback) {
        AppMethodBeat.i(17402);
        getAnalyticsExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.AppEventsLogger.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(17345);
                String userID = AppEventsLogger.getUserID();
                if (userID == null || userID.isEmpty()) {
                    Logger.log(LoggingBehavior.APP_EVENTS, AppEventsLogger.TAG, "AppEventsLogger userID cannot be null or empty");
                    AppMethodBeat.o(17345);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("user_unique_id", userID);
                bundle.putBundle("custom_data", bundle);
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null)) {
                    bundle.putString("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                }
                Bundle bundle2 = new Bundle();
                try {
                    JSONObject convertToJSON = BundleJSONConverter.convertToJSON(bundle);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(convertToJSON);
                    bundle2.putString("data", jSONArray.toString());
                    GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(Locale.US, "%s/user_properties", str), bundle2, HttpMethod.POST, callback);
                    graphRequest.setSkipClientToken(true);
                    graphRequest.executeAsync();
                    AppMethodBeat.o(17345);
                } catch (JSONException e2) {
                    FacebookException facebookException = new FacebookException("Failed to construct request", e2);
                    AppMethodBeat.o(17345);
                    throw facebookException;
                }
            }
        });
        AppMethodBeat.o(17402);
    }

    public void logSdkEvent(String str, Double d2, Bundle bundle) {
        AppMethodBeat.i(17403);
        logEvent(str, d2, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
        AppMethodBeat.o(17403);
    }

    public String getApplicationId() {
        AppMethodBeat.i(17404);
        String applicationId = this.accessTokenAppId.getApplicationId();
        AppMethodBeat.o(17404);
        return applicationId;
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this(Utility.getActivityName(context), str, accessToken);
        AppMethodBeat.i(17405);
        AppMethodBeat.o(17405);
    }

    protected AppEventsLogger(String str, String str2, AccessToken accessToken) {
        AppMethodBeat.i(17406);
        Validate.sdkInitialized();
        this.contextName = str;
        accessToken = accessToken == null ? AccessToken.getCurrentAccessToken() : accessToken;
        if (!AccessToken.isCurrentAccessTokenActive() || (str2 != null && !str2.equals(accessToken.getApplicationId()))) {
            this.accessTokenAppId = new AccessTokenAppIdPair(null, str2 == null ? Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext()) : str2);
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(accessToken);
        }
        initializeTimersIfNeeded();
        AppMethodBeat.o(17406);
    }

    private static void initializeTimersIfNeeded() {
        AppMethodBeat.i(17407);
        synchronized (staticLock) {
            try {
                if (backgroundExecutor == null) {
                    backgroundExecutor = new ScheduledThreadPoolExecutor(1);
                    backgroundExecutor.scheduleAtFixedRate(new Runnable() {
                        /* class com.facebook.appevents.AppEventsLogger.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(17346);
                            HashSet<String> hashSet = new HashSet();
                            for (AccessTokenAppIdPair accessTokenAppIdPair : AppEventQueue.getKeySet()) {
                                hashSet.add(accessTokenAppIdPair.getApplicationId());
                            }
                            for (String str : hashSet) {
                                FetchedAppSettingsManager.queryAppSettings(str, true);
                            }
                            AppMethodBeat.o(17346);
                        }
                    }, 0, 86400, TimeUnit.SECONDS);
                    AppMethodBeat.o(17407);
                }
            } finally {
                AppMethodBeat.o(17407);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(17408);
        logEvent(str, Double.valueOf(bigDecimal.doubleValue()), bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
        AppMethodBeat.o(17408);
    }

    private void logEvent(String str, Double d2, Bundle bundle, boolean z, UUID uuid) {
        AppMethodBeat.i(17409);
        try {
            logEvent(new AppEvent(this.contextName, str, d2, bundle, z, uuid), this.accessTokenAppId);
            AppMethodBeat.o(17409);
        } catch (JSONException e2) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e2.toString());
            AppMethodBeat.o(17409);
        } catch (FacebookException e3) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", e3.toString());
            AppMethodBeat.o(17409);
        }
    }

    private static void logEvent(AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        AppMethodBeat.i(17410);
        AppEventQueue.add(accessTokenAppIdPair, appEvent);
        if (!appEvent.getIsImplicit() && !isActivateAppEventRequested) {
            if (appEvent.getName().equals(AppEventsConstants.EVENT_NAME_ACTIVATED_APP)) {
                isActivateAppEventRequested = true;
                AppMethodBeat.o(17410);
                return;
            }
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
        }
        AppMethodBeat.o(17410);
    }

    static void eagerFlush() {
        AppMethodBeat.i(17411);
        if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
            AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
        }
        AppMethodBeat.o(17411);
    }

    private static void notifyDeveloperError(String str) {
        AppMethodBeat.i(17412);
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
        AppMethodBeat.o(17412);
    }

    private static void setSourceApplication(Activity activity) {
        AppMethodBeat.i(17413);
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            String packageName = callingActivity.getPackageName();
            if (packageName.equals(activity.getPackageName())) {
                resetSourceApplication();
                AppMethodBeat.o(17413);
                return;
            }
            sourceApplication = packageName;
        }
        Intent intent = activity.getIntent();
        if (intent == null || intent.getBooleanExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, false)) {
            resetSourceApplication();
            AppMethodBeat.o(17413);
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("al_applink_data");
        if (bundleExtra == null) {
            resetSourceApplication();
            AppMethodBeat.o(17413);
            return;
        }
        isOpenedByAppLink = true;
        Bundle bundle = bundleExtra.getBundle("referer_app_link");
        if (bundle == null) {
            sourceApplication = null;
            AppMethodBeat.o(17413);
            return;
        }
        sourceApplication = bundle.getString("package");
        intent.putExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
        AppMethodBeat.o(17413);
    }

    static void setSourceApplication(String str, boolean z) {
        sourceApplication = str;
        isOpenedByAppLink = z;
    }

    static String getSourceApplication() {
        AppMethodBeat.i(17414);
        String str = "Unclassified";
        if (isOpenedByAppLink) {
            str = "Applink";
        }
        if (sourceApplication != null) {
            String str2 = str + "(" + sourceApplication + ")";
            AppMethodBeat.o(17414);
            return str2;
        }
        AppMethodBeat.o(17414);
        return str;
    }

    static void resetSourceApplication() {
        sourceApplication = null;
        isOpenedByAppLink = false;
    }

    static Executor getAnalyticsExecutor() {
        AppMethodBeat.i(17415);
        if (backgroundExecutor == null) {
            initializeTimersIfNeeded();
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = backgroundExecutor;
        AppMethodBeat.o(17415);
        return scheduledThreadPoolExecutor;
    }

    public static String getAnonymousAppDeviceGUID(Context context) {
        AppMethodBeat.i(17416);
        if (anonymousAppDeviceGUID == null) {
            synchronized (staticLock) {
                try {
                    if (anonymousAppDeviceGUID == null) {
                        String string = context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getString("anonymousAppDeviceGUID", null);
                        anonymousAppDeviceGUID = string;
                        if (string == null) {
                            anonymousAppDeviceGUID = "XZ" + UUID.randomUUID().toString();
                            context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putString("anonymousAppDeviceGUID", anonymousAppDeviceGUID).apply();
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(17416);
                    throw th;
                }
            }
        }
        String str = anonymousAppDeviceGUID;
        AppMethodBeat.o(17416);
        return str;
    }

    /* access modifiers changed from: package-private */
    public static class PersistedAppSessionInfo {
        private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
        private static final Runnable appSessionInfoFlushRunnable = new Runnable() {
            /* class com.facebook.appevents.AppEventsLogger.PersistedAppSessionInfo.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(17350);
                PersistedAppSessionInfo.saveAppSessionInformation(FacebookSdk.getApplicationContext());
                AppMethodBeat.o(17350);
            }
        };
        private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap;
        private static boolean hasChanges = false;
        private static boolean isLoaded = false;
        private static final Object staticLock = new Object();

        PersistedAppSessionInfo() {
        }

        static {
            AppMethodBeat.i(17357);
            AppMethodBeat.o(17357);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ad  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void restoreAppSessionInformation(android.content.Context r6) {
            /*
            // Method dump skipped, instructions count: 207
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventsLogger.PersistedAppSessionInfo.restoreAppSessionInformation(android.content.Context):void");
        }

        static void saveAppSessionInformation(Context context) {
            ObjectOutputStream objectOutputStream;
            Throwable th;
            Exception e2;
            AppMethodBeat.i(17352);
            synchronized (staticLock) {
                try {
                    if (hasChanges) {
                        try {
                            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput(PERSISTED_SESSION_INFO_FILENAME, 0)));
                            try {
                                objectOutputStream.writeObject(appSessionInfoMap);
                                hasChanges = false;
                                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info saved");
                                Utility.closeQuietly(objectOutputStream);
                            } catch (Exception e3) {
                                e2 = e3;
                                try {
                                    String unused = AppEventsLogger.TAG;
                                    new StringBuilder("Got unexpected exception while writing app session info: ").append(e2.toString());
                                    Utility.closeQuietly(objectOutputStream);
                                } catch (Throwable th2) {
                                    th = th2;
                                    Utility.closeQuietly(objectOutputStream);
                                    AppMethodBeat.o(17352);
                                    throw th;
                                }
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            objectOutputStream = null;
                            String unused2 = AppEventsLogger.TAG;
                            new StringBuilder("Got unexpected exception while writing app session info: ").append(e2.toString());
                            Utility.closeQuietly(objectOutputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            objectOutputStream = null;
                            Utility.closeQuietly(objectOutputStream);
                            AppMethodBeat.o(17352);
                            throw th;
                        }
                    }
                } finally {
                    AppMethodBeat.o(17352);
                }
            }
        }

        static void onResume(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j2, String str) {
            AppMethodBeat.i(17353);
            synchronized (staticLock) {
                try {
                    getTimeSpentData(context, accessTokenAppIdPair).onResume(appEventsLogger, j2, str);
                    onTimeSpentDataUpdate();
                } finally {
                    AppMethodBeat.o(17353);
                }
            }
        }

        static void onSuspend(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j2) {
            AppMethodBeat.i(17354);
            synchronized (staticLock) {
                try {
                    getTimeSpentData(context, accessTokenAppIdPair).onSuspend(appEventsLogger, j2);
                    onTimeSpentDataUpdate();
                } finally {
                    AppMethodBeat.o(17354);
                }
            }
        }

        private static FacebookTimeSpentData getTimeSpentData(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
            AppMethodBeat.i(17355);
            restoreAppSessionInformation(context);
            FacebookTimeSpentData facebookTimeSpentData = appSessionInfoMap.get(accessTokenAppIdPair);
            if (facebookTimeSpentData == null) {
                facebookTimeSpentData = new FacebookTimeSpentData();
                appSessionInfoMap.put(accessTokenAppIdPair, facebookTimeSpentData);
            }
            AppMethodBeat.o(17355);
            return facebookTimeSpentData;
        }

        private static void onTimeSpentDataUpdate() {
            AppMethodBeat.i(17356);
            if (!hasChanges) {
                hasChanges = true;
                AppEventsLogger.backgroundExecutor.schedule(appSessionInfoFlushRunnable, 30, TimeUnit.SECONDS);
            }
            AppMethodBeat.o(17356);
        }
    }
}
