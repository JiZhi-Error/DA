package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.util.Base64;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;

public final class FacebookSdk {
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
    static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
    static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
    private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_KEEP_ALIVE = 1;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new ThreadFactory() {
        /* class com.facebook.FacebookSdk.AnonymousClass1 */
        private final AtomicInteger counter = new AtomicInteger(0);

        {
            AppMethodBeat.i(17033);
            AppMethodBeat.o(17033);
        }

        public final Thread newThread(Runnable runnable) {
            AppMethodBeat.i(17034);
            Thread thread = new Thread(runnable, "FacebookSdk #" + this.counter.incrementAndGet());
            AppMethodBeat.o(17034);
            return thread;
        }
    };
    private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    private static final String FACEBOOK_COM = "facebook.com";
    private static final Object LOCK = new Object();
    private static final int MAX_REQUEST_CODE_RANGE = 100;
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG = FacebookSdk.class.getCanonicalName();
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    private static volatile String appClientToken;
    private static Context applicationContext;
    private static volatile String applicationId;
    private static volatile String applicationName;
    private static volatile Boolean autoLogAppEventsEnabled;
    private static LockOnGetVariable<File> cacheDir;
    private static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;
    private static volatile Boolean codelessDebugLogEnabled;
    private static Executor executor;
    private static volatile String facebookDomain = FACEBOOK_COM;
    private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    private static volatile boolean isDebugEnabled = false;
    private static boolean isLegacyTokenUpgradeSupported = false;
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet<>(Arrays.asList(LoggingBehavior.DEVELOPER_ERRORS));
    private static AtomicLong onProgressThreshold = new AtomicLong(65536);
    private static Boolean sdkInitialized = Boolean.FALSE;

    public interface InitializeCallback {
        void onInitialized();
    }

    static {
        AppMethodBeat.i(17074);
        AppMethodBeat.o(17074);
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i2) {
        synchronized (FacebookSdk.class) {
            AppMethodBeat.i(17041);
            sdkInitialize(context, i2, null);
            AppMethodBeat.o(17041);
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i2, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            AppMethodBeat.i(17042);
            if (sdkInitialized.booleanValue() && i2 != callbackRequestCodeOffset) {
                FacebookException facebookException = new FacebookException(CALLBACK_OFFSET_CHANGED_AFTER_INIT);
                AppMethodBeat.o(17042);
                throw facebookException;
            } else if (i2 < 0) {
                FacebookException facebookException2 = new FacebookException(CALLBACK_OFFSET_NEGATIVE);
                AppMethodBeat.o(17042);
                throw facebookException2;
            } else {
                callbackRequestCodeOffset = i2;
                sdkInitialize(context, initializeCallback);
                AppMethodBeat.o(17042);
            }
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context) {
        synchronized (FacebookSdk.class) {
            AppMethodBeat.i(17043);
            sdkInitialize(context, (InitializeCallback) null);
            AppMethodBeat.o(17043);
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(final Context context, final InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            AppMethodBeat.i(17044);
            if (sdkInitialized.booleanValue()) {
                if (initializeCallback != null) {
                    initializeCallback.onInitialized();
                }
                AppMethodBeat.o(17044);
            } else {
                Validate.notNull(context, "applicationContext");
                Validate.hasFacebookActivity(context, false);
                Validate.hasInternetPermissions(context, false);
                Context applicationContext2 = context.getApplicationContext();
                applicationContext = applicationContext2;
                loadDefaultsFromMetadata(applicationContext2);
                if (Utility.isNullOrEmpty(applicationId)) {
                    FacebookException facebookException = new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
                    AppMethodBeat.o(17044);
                    throw facebookException;
                }
                if ((applicationContext instanceof Application) && autoLogAppEventsEnabled.booleanValue()) {
                    ActivityLifecycleTracker.startTracking((Application) applicationContext, applicationId);
                }
                sdkInitialized = Boolean.TRUE;
                FetchedAppSettingsManager.getAppSettingsAsync(new FetchedAppSettingsManager.FetchedAppSettingsCallback() {
                    /* class com.facebook.FacebookSdk.AnonymousClass2 */

                    @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
                    public final void onSuccess(FetchedAppSettings fetchedAppSettings) {
                        AppMethodBeat.i(17035);
                        FetchedAppGateKeepersManager.loadAppGateKeepersAsync();
                        AppMethodBeat.o(17035);
                    }

                    @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
                    public final void onError() {
                    }
                });
                NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                BoltsMeasurementEventListener.getInstance(applicationContext);
                cacheDir = new LockOnGetVariable<>(new Callable<File>() {
                    /* class com.facebook.FacebookSdk.AnonymousClass3 */

                    @Override // java.util.concurrent.Callable
                    public final File call() {
                        AppMethodBeat.i(17036);
                        File cacheDir = FacebookSdk.applicationContext.getCacheDir();
                        AppMethodBeat.o(17036);
                        return cacheDir;
                    }
                });
                getExecutor().execute(new FutureTask(new Callable<Void>() {
                    /* class com.facebook.FacebookSdk.AnonymousClass4 */

                    @Override // java.util.concurrent.Callable
                    public final Void call() {
                        AppMethodBeat.i(17038);
                        AccessTokenManager.getInstance().loadCurrentAccessToken();
                        ProfileManager.getInstance().loadCurrentProfile();
                        if (AccessToken.isCurrentAccessTokenActive() && Profile.getCurrentProfile() == null) {
                            Profile.fetchProfileForCurrentAccessToken();
                        }
                        if (initializeCallback != null) {
                            initializeCallback.onInitialized();
                        }
                        AppEventsLogger.initializeLib(FacebookSdk.applicationContext, FacebookSdk.applicationId);
                        AppEventsLogger.newLogger(context.getApplicationContext()).flush();
                        AppMethodBeat.o(17038);
                        return null;
                    }
                }));
                AppMethodBeat.o(17044);
            }
        }
    }

    public static synchronized boolean isInitialized() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            AppMethodBeat.i(17045);
            booleanValue = sdkInitialized.booleanValue();
            AppMethodBeat.o(17045);
        }
        return booleanValue;
    }

    public static Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        AppMethodBeat.i(17046);
        synchronized (loggingBehaviors) {
            try {
                unmodifiableSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
            } finally {
                AppMethodBeat.o(17046);
            }
        }
        return unmodifiableSet;
    }

    public static void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        AppMethodBeat.i(17047);
        synchronized (loggingBehaviors) {
            try {
                loggingBehaviors.add(loggingBehavior);
                updateGraphDebugBehavior();
            } finally {
                AppMethodBeat.o(17047);
            }
        }
    }

    public static void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        AppMethodBeat.i(17048);
        synchronized (loggingBehaviors) {
            try {
                loggingBehaviors.remove(loggingBehavior);
            } finally {
                AppMethodBeat.o(17048);
            }
        }
    }

    public static void clearLoggingBehaviors() {
        AppMethodBeat.i(17049);
        synchronized (loggingBehaviors) {
            try {
                loggingBehaviors.clear();
            } finally {
                AppMethodBeat.o(17049);
            }
        }
    }

    public static boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean z;
        AppMethodBeat.i(17050);
        synchronized (loggingBehaviors) {
            try {
                z = isDebugEnabled() && loggingBehaviors.contains(loggingBehavior);
            } finally {
                AppMethodBeat.o(17050);
            }
        }
        return z;
    }

    public static boolean isDebugEnabled() {
        return isDebugEnabled;
    }

    public static void setIsDebugEnabled(boolean z) {
        isDebugEnabled = z;
    }

    public static boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    private static void updateGraphDebugBehavior() {
        AppMethodBeat.i(17051);
        if (loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
        }
        AppMethodBeat.o(17051);
    }

    public static void setLegacyTokenUpgradeSupported(boolean z) {
        isLegacyTokenUpgradeSupported = z;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return executor;
    }

    public static void setExecutor(Executor executor2) {
        AppMethodBeat.i(17052);
        Validate.notNull(executor2, "executor");
        synchronized (LOCK) {
            try {
                executor = executor2;
            } finally {
                AppMethodBeat.o(17052);
            }
        }
    }

    public static String getFacebookDomain() {
        return facebookDomain;
    }

    public static void setFacebookDomain(String str) {
        facebookDomain = str;
    }

    public static Context getApplicationContext() {
        AppMethodBeat.i(17053);
        Validate.sdkInitialized();
        Context context = applicationContext;
        AppMethodBeat.o(17053);
        return context;
    }

    public static void setGraphApiVersion(String str) {
        AppMethodBeat.i(17054);
        if (!Utility.isNullOrEmpty(str) && !graphApiVersion.equals(str)) {
            graphApiVersion = str;
        }
        AppMethodBeat.o(17054);
    }

    public static String getGraphApiVersion() {
        AppMethodBeat.i(17055);
        Utility.logd(TAG, String.format("getGraphApiVersion: %s", graphApiVersion));
        String str = graphApiVersion;
        AppMethodBeat.o(17055);
        return str;
    }

    public static void publishInstallAsync(Context context, final String str) {
        AppMethodBeat.i(17056);
        final Context applicationContext2 = context.getApplicationContext();
        getExecutor().execute(new Runnable() {
            /* class com.facebook.FacebookSdk.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(17040);
                FacebookSdk.publishInstallAndWaitForResponse(applicationContext2, str);
                AppMethodBeat.o(17040);
            }
        });
        AppMethodBeat.o(17056);
    }

    static void publishInstallAndWaitForResponse(Context context, String str) {
        AppMethodBeat.i(17057);
        if (context == null || str == null) {
            try {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both context and applicationId must be non-null");
                AppMethodBeat.o(17057);
                throw illegalArgumentException;
            } catch (Exception e2) {
                Utility.logd("Facebook-publish", e2);
                AppMethodBeat.o(17057);
            }
        } else {
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
            String str2 = str + "ping";
            long j2 = sharedPreferences.getLong(str2, 0);
            try {
                GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(PUBLISH_ACTIVITY_PATH, str), AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context), null);
                if (j2 == 0) {
                    newPostRequest.executeAndWait();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong(str2, System.currentTimeMillis());
                    edit.apply();
                }
                AppMethodBeat.o(17057);
            } catch (JSONException e3) {
                FacebookException facebookException = new FacebookException("An error occurred while publishing install.", e3);
                AppMethodBeat.o(17057);
                throw facebookException;
            }
        }
    }

    public static String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    public static boolean getLimitEventAndDataUsage(Context context) {
        AppMethodBeat.i(17058);
        Validate.sdkInitialized();
        boolean z = context.getSharedPreferences(AppEventsLogger.APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
        AppMethodBeat.o(17058);
        return z;
    }

    public static void setLimitEventAndDataUsage(Context context, boolean z) {
        AppMethodBeat.i(17059);
        context.getSharedPreferences(AppEventsLogger.APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z).apply();
        AppMethodBeat.o(17059);
    }

    public static long getOnProgressThreshold() {
        AppMethodBeat.i(17060);
        Validate.sdkInitialized();
        long j2 = onProgressThreshold.get();
        AppMethodBeat.o(17060);
        return j2;
    }

    public static void setOnProgressThreshold(long j2) {
        AppMethodBeat.i(17061);
        onProgressThreshold.set(j2);
        AppMethodBeat.o(17061);
    }

    static void loadDefaultsFromMetadata(Context context) {
        AppMethodBeat.i(17062);
        if (context == null) {
            AppMethodBeat.o(17062);
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                AppMethodBeat.o(17062);
                return;
            }
            if (applicationId == null) {
                Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                        applicationId = str.substring(2);
                    } else {
                        applicationId = str;
                    }
                } else if (obj instanceof Integer) {
                    FacebookException facebookException = new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                    AppMethodBeat.o(17062);
                    throw facebookException;
                }
            }
            if (applicationName == null) {
                applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
            }
            if (appClientToken == null) {
                appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
            }
            if (callbackRequestCodeOffset == DEFAULT_CALLBACK_REQUEST_CODE_OFFSET) {
                callbackRequestCodeOffset = applicationInfo.metaData.getInt(CALLBACK_OFFSET_PROPERTY, DEFAULT_CALLBACK_REQUEST_CODE_OFFSET);
            }
            if (autoLogAppEventsEnabled == null) {
                autoLogAppEventsEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY, true));
            }
            if (codelessDebugLogEnabled == null) {
                codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(CODELESS_DEBUG_LOG_ENABLED_PROPERTY, false));
            }
            AppMethodBeat.o(17062);
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(17062);
        }
    }

    public static String getApplicationSignature(Context context) {
        AppMethodBeat.i(17063);
        Validate.sdkInitialized();
        if (context == null) {
            AppMethodBeat.o(17063);
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            AppMethodBeat.o(17063);
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                AppMethodBeat.o(17063);
                return null;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(packageInfo.signatures[0].toByteArray());
                String encodeToString = Base64.encodeToString(instance.digest(), 9);
                AppMethodBeat.o(17063);
                return encodeToString;
            } catch (NoSuchAlgorithmException e2) {
                AppMethodBeat.o(17063);
                return null;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            AppMethodBeat.o(17063);
            return null;
        }
    }

    public static String getApplicationId() {
        AppMethodBeat.i(17064);
        Validate.sdkInitialized();
        String str = applicationId;
        AppMethodBeat.o(17064);
        return str;
    }

    public static void setApplicationId(String str) {
        applicationId = str;
    }

    public static String getApplicationName() {
        AppMethodBeat.i(17065);
        Validate.sdkInitialized();
        String str = applicationName;
        AppMethodBeat.o(17065);
        return str;
    }

    public static void setApplicationName(String str) {
        applicationName = str;
    }

    public static String getClientToken() {
        AppMethodBeat.i(17066);
        Validate.sdkInitialized();
        String str = appClientToken;
        AppMethodBeat.o(17066);
        return str;
    }

    public static void setClientToken(String str) {
        appClientToken = str;
    }

    public static boolean getAutoLogAppEventsEnabled() {
        AppMethodBeat.i(17067);
        Validate.sdkInitialized();
        boolean booleanValue = autoLogAppEventsEnabled.booleanValue();
        AppMethodBeat.o(17067);
        return booleanValue;
    }

    public static void setAutoLogAppEventsEnabled(boolean z) {
        AppMethodBeat.i(17068);
        autoLogAppEventsEnabled = Boolean.valueOf(z);
        AppMethodBeat.o(17068);
    }

    public static boolean getCodelessDebugLogEnabled() {
        AppMethodBeat.i(17069);
        Validate.sdkInitialized();
        boolean booleanValue = codelessDebugLogEnabled.booleanValue();
        AppMethodBeat.o(17069);
        return booleanValue;
    }

    public static void setCodelessDebugLogEnabled(boolean z) {
        AppMethodBeat.i(17070);
        codelessDebugLogEnabled = Boolean.valueOf(z);
        AppMethodBeat.o(17070);
    }

    public static File getCacheDir() {
        AppMethodBeat.i(17071);
        Validate.sdkInitialized();
        File value = cacheDir.getValue();
        AppMethodBeat.o(17071);
        return value;
    }

    public static void setCacheDir(File file) {
        AppMethodBeat.i(17072);
        cacheDir = new LockOnGetVariable<>(file);
        AppMethodBeat.o(17072);
    }

    public static int getCallbackRequestCodeOffset() {
        AppMethodBeat.i(17073);
        Validate.sdkInitialized();
        int i2 = callbackRequestCodeOffset;
        AppMethodBeat.o(17073);
        return i2;
    }

    public static boolean isFacebookRequestCode(int i2) {
        return i2 >= callbackRequestCodeOffset && i2 < callbackRequestCodeOffset + 100;
    }
}
