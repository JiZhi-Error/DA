package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.SourceApplicationInfo;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class ActivityLifecycleTracker {
    private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000;
    private static final String TAG = ActivityLifecycleTracker.class.getCanonicalName();
    private static String appId;
    private static final CodelessMatcher codelessMatcher = new CodelessMatcher();
    private static long currentActivityAppearTime;
    private static volatile ScheduledFuture currentFuture;
    private static final Object currentFutureLock = new Object();
    private static volatile SessionInfo currentSession;
    private static String deviceSessionID = null;
    private static AtomicInteger foregroundActivityCount = new AtomicInteger(0);
    private static Boolean isAppIndexingEnabled = Boolean.FALSE;
    private static volatile Boolean isCheckingSession = Boolean.FALSE;
    private static SensorManager sensorManager;
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    private static AtomicBoolean tracking = new AtomicBoolean(false);
    private static ViewIndexer viewIndexer;
    private static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();

    static /* synthetic */ void access$100(Activity activity) {
        AppMethodBeat.i(17593);
        onActivityPaused(activity);
        AppMethodBeat.o(17593);
    }

    static /* synthetic */ int access$400() {
        AppMethodBeat.i(17594);
        int sessionTimeoutInSeconds = getSessionTimeoutInSeconds();
        AppMethodBeat.o(17594);
        return sessionTimeoutInSeconds;
    }

    static {
        AppMethodBeat.i(17595);
        AppMethodBeat.o(17595);
    }

    public static void startTracking(Application application, String str) {
        AppMethodBeat.i(17582);
        if (!tracking.compareAndSet(false, true)) {
            AppMethodBeat.o(17582);
            return;
        }
        appId = str;
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass1 */

            public final void onActivityCreated(Activity activity, Bundle bundle) {
                AppMethodBeat.i(17569);
                Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityCreated");
                AppEventUtility.assertIsMainThread();
                ActivityLifecycleTracker.onActivityCreated(activity);
                AppMethodBeat.o(17569);
            }

            public final void onActivityStarted(Activity activity) {
                AppMethodBeat.i(17570);
                Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStarted");
                AppMethodBeat.o(17570);
            }

            public final void onActivityResumed(Activity activity) {
                AppMethodBeat.i(17571);
                Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityResumed");
                AppEventUtility.assertIsMainThread();
                ActivityLifecycleTracker.onActivityResumed(activity);
                AppMethodBeat.o(17571);
            }

            public final void onActivityPaused(Activity activity) {
                AppMethodBeat.i(17572);
                Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityPaused");
                AppEventUtility.assertIsMainThread();
                ActivityLifecycleTracker.access$100(activity);
                AppMethodBeat.o(17572);
            }

            public final void onActivityStopped(Activity activity) {
                AppMethodBeat.i(17573);
                Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStopped");
                AppEventsLogger.onContextStop();
                AppMethodBeat.o(17573);
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                AppMethodBeat.i(17574);
                Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivitySaveInstanceState");
                AppMethodBeat.o(17574);
            }

            public final void onActivityDestroyed(Activity activity) {
                AppMethodBeat.i(17575);
                Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityDestroyed");
                AppMethodBeat.o(17575);
            }
        });
        AppMethodBeat.o(17582);
    }

    public static boolean isTracking() {
        AppMethodBeat.i(17583);
        boolean z = tracking.get();
        AppMethodBeat.o(17583);
        return z;
    }

    public static UUID getCurrentSessionGuid() {
        AppMethodBeat.i(17584);
        if (currentSession != null) {
            UUID sessionId = currentSession.getSessionId();
            AppMethodBeat.o(17584);
            return sessionId;
        }
        AppMethodBeat.o(17584);
        return null;
    }

    public static void onActivityCreated(Activity activity) {
        AppMethodBeat.i(17585);
        System.currentTimeMillis();
        activity.getApplicationContext();
        Utility.getActivityName(activity);
        SourceApplicationInfo.Factory.create(activity);
        singleThreadExecutor.execute(new Runnable() {
            /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(17576);
                if (ActivityLifecycleTracker.currentSession == null) {
                    SessionInfo unused = ActivityLifecycleTracker.currentSession = SessionInfo.getStoredSessionInfo();
                }
                AppMethodBeat.o(17576);
            }
        });
        AppMethodBeat.o(17585);
    }

    public static void onActivityResumed(Activity activity) {
        AppMethodBeat.i(17586);
        foregroundActivityCount.incrementAndGet();
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        currentActivityAppearTime = currentTimeMillis;
        final String activityName = Utility.getActivityName(activity);
        codelessMatcher.add(activity);
        singleThreadExecutor.execute(new Runnable() {
            /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(17577);
                if (ActivityLifecycleTracker.currentSession == null) {
                    SessionInfo unused = ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    SessionLogger.logActivateApp(activityName, null, ActivityLifecycleTracker.appId);
                } else if (ActivityLifecycleTracker.currentSession.getSessionLastEventTime() != null) {
                    long longValue = currentTimeMillis - ActivityLifecycleTracker.currentSession.getSessionLastEventTime().longValue();
                    if (longValue > ((long) (ActivityLifecycleTracker.access$400() * 1000))) {
                        SessionLogger.logDeactivateApp(activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                        SessionLogger.logActivateApp(activityName, null, ActivityLifecycleTracker.appId);
                        SessionInfo unused2 = ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    } else if (longValue > 1000) {
                        ActivityLifecycleTracker.currentSession.incrementInterruptionCount();
                    }
                }
                ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(currentTimeMillis));
                ActivityLifecycleTracker.currentSession.writeSessionToDisk();
                AppMethodBeat.o(17577);
            }
        });
        Context applicationContext = activity.getApplicationContext();
        final String applicationId = FacebookSdk.getApplicationId();
        final FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
        if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessSetupEnabled()) {
            SensorManager sensorManager2 = (SensorManager) applicationContext.getSystemService("sensor");
            sensorManager = sensorManager2;
            if (sensorManager2 == null) {
                AppMethodBeat.o(17586);
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            viewIndexer = new ViewIndexer(activity);
            viewIndexingTrigger.setOnShakeListener(new ViewIndexingTrigger.OnShakeListener() {
                /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass4 */

                @Override // com.facebook.appevents.codeless.ViewIndexingTrigger.OnShakeListener
                public final void onShake() {
                    AppMethodBeat.i(17578);
                    if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                        ActivityLifecycleTracker.checkCodelessSession(applicationId);
                    }
                    AppMethodBeat.o(17578);
                }
            });
            sensorManager.registerListener(viewIndexingTrigger, defaultSensor, 2);
            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                viewIndexer.schedule();
            }
        }
        AppMethodBeat.o(17586);
    }

    private static void onActivityPaused(Activity activity) {
        AppMethodBeat.i(17587);
        if (foregroundActivityCount.decrementAndGet() < 0) {
            foregroundActivityCount.set(0);
        }
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        final String activityName = Utility.getActivityName(activity);
        codelessMatcher.remove(activity);
        singleThreadExecutor.execute(new Runnable() {
            /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass5 */

            public final void run() {
                long j2 = 0;
                AppMethodBeat.i(17580);
                if (ActivityLifecycleTracker.currentSession == null) {
                    SessionInfo unused = ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                }
                ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(currentTimeMillis));
                if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                    AnonymousClass1 r2 = new Runnable() {
                        /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass5.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(17579);
                            if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                                SessionLogger.logDeactivateApp(activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                                SessionInfo.clearSavedSessionFromDisk();
                                SessionInfo unused = ActivityLifecycleTracker.currentSession = null;
                            }
                            synchronized (ActivityLifecycleTracker.currentFutureLock) {
                                try {
                                    ScheduledFuture unused2 = ActivityLifecycleTracker.currentFuture = null;
                                } finally {
                                    AppMethodBeat.o(17579);
                                }
                            }
                        }
                    };
                    synchronized (ActivityLifecycleTracker.currentFutureLock) {
                        try {
                            ScheduledFuture unused2 = ActivityLifecycleTracker.currentFuture = ActivityLifecycleTracker.singleThreadExecutor.schedule(r2, (long) ActivityLifecycleTracker.access$400(), TimeUnit.SECONDS);
                        } catch (Throwable th) {
                            AppMethodBeat.o(17580);
                            throw th;
                        }
                    }
                }
                long j3 = ActivityLifecycleTracker.currentActivityAppearTime;
                if (j3 > 0) {
                    j2 = (currentTimeMillis - j3) / 1000;
                }
                AutomaticAnalyticsLogger.logActivityTimeSpentEvent(activityName, j2);
                ActivityLifecycleTracker.currentSession.writeSessionToDisk();
                AppMethodBeat.o(17580);
            }
        });
        if (viewIndexer != null) {
            viewIndexer.unschedule();
        }
        if (sensorManager != null) {
            sensorManager.unregisterListener(viewIndexingTrigger);
        }
        AppMethodBeat.o(17587);
    }

    private static int getSessionTimeoutInSeconds() {
        AppMethodBeat.i(17588);
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null) {
            int defaultAppEventsSessionTimeoutInSeconds = Constants.getDefaultAppEventsSessionTimeoutInSeconds();
            AppMethodBeat.o(17588);
            return defaultAppEventsSessionTimeoutInSeconds;
        }
        int sessionTimeoutInSeconds = appSettingsWithoutQuery.getSessionTimeoutInSeconds();
        AppMethodBeat.o(17588);
        return sessionTimeoutInSeconds;
    }

    private static void cancelCurrentTask() {
        AppMethodBeat.i(17589);
        synchronized (currentFutureLock) {
            try {
                if (currentFuture != null) {
                    currentFuture.cancel(false);
                }
                currentFuture = null;
            } finally {
                AppMethodBeat.o(17589);
            }
        }
    }

    public static void checkCodelessSession(final String str) {
        AppMethodBeat.i(17590);
        if (isCheckingSession.booleanValue()) {
            AppMethodBeat.o(17590);
            return;
        }
        isCheckingSession = Boolean.TRUE;
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(17581);
                GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/app_indexing_session", str), null, null);
                Bundle parameters = newPostRequest.getParameters();
                if (parameters == null) {
                    parameters = new Bundle();
                }
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(Build.MODEL != null ? Build.MODEL : "");
                if (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) {
                    jSONArray.put("");
                } else {
                    jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
                }
                jSONArray.put(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                jSONArray.put(AppEventUtility.isEmulator() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                Locale currentLocale = Utility.getCurrentLocale();
                jSONArray.put(currentLocale.getLanguage() + "_" + currentLocale.getCountry());
                String jSONArray2 = jSONArray.toString();
                parameters.putString(Constants.DEVICE_SESSION_ID, ActivityLifecycleTracker.getCurrentDeviceSessionID());
                parameters.putString(Constants.EXTINFO, jSONArray2);
                newPostRequest.setParameters(parameters);
                if (newPostRequest != null) {
                    JSONObject jSONObject = newPostRequest.executeAndWait().getJSONObject();
                    Boolean unused = ActivityLifecycleTracker.isAppIndexingEnabled = Boolean.valueOf(jSONObject != null && jSONObject.optBoolean(Constants.APP_INDEXING_ENABLED, false));
                    if (!ActivityLifecycleTracker.isAppIndexingEnabled.booleanValue()) {
                        String unused2 = ActivityLifecycleTracker.deviceSessionID = null;
                    } else {
                        ActivityLifecycleTracker.viewIndexer.schedule();
                    }
                }
                Boolean unused3 = ActivityLifecycleTracker.isCheckingSession = Boolean.FALSE;
                AppMethodBeat.o(17581);
            }
        });
        AppMethodBeat.o(17590);
    }

    public static String getCurrentDeviceSessionID() {
        AppMethodBeat.i(17591);
        if (deviceSessionID == null) {
            deviceSessionID = UUID.randomUUID().toString();
        }
        String str = deviceSessionID;
        AppMethodBeat.o(17591);
        return str;
    }

    public static boolean getIsAppIndexingEnabled() {
        AppMethodBeat.i(17592);
        boolean booleanValue = isAppIndexingEnabled.booleanValue();
        AppMethodBeat.o(17592);
        return booleanValue;
    }

    public static void updateAppIndexing(Boolean bool) {
        isAppIndexingEnabled = bool;
    }
}
