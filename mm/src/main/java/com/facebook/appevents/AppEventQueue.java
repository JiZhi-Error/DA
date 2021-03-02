package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.d;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;

/* access modifiers changed from: package-private */
public class AppEventQueue {
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    private static final String TAG = AppEventQueue.class.getName();
    private static volatile AppEventCollection appEventCollection = new AppEventCollection();
    private static final Runnable flushRunnable = new Runnable() {
        /* class com.facebook.appevents.AppEventQueue.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(17320);
            ScheduledFuture unused = AppEventQueue.scheduledFuture = null;
            if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                AppEventQueue.flushAndWait(FlushReason.TIMER);
            }
            AppMethodBeat.o(17320);
        }
    };
    private static ScheduledFuture scheduledFuture;
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    AppEventQueue() {
    }

    static /* synthetic */ void access$400(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        AppMethodBeat.i(17334);
        handleResponse(accessTokenAppIdPair, graphRequest, graphResponse, sessionEventsState, flushStatistics);
        AppMethodBeat.o(17334);
    }

    static {
        AppMethodBeat.i(17335);
        AppMethodBeat.o(17335);
    }

    public static void persistToDisk() {
        AppMethodBeat.i(17326);
        singleThreadExecutor.execute(new Runnable() {
            /* class com.facebook.appevents.AppEventQueue.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(17321);
                AppEventStore.persistEvents(AppEventQueue.appEventCollection);
                AppEventCollection unused = AppEventQueue.appEventCollection = new AppEventCollection();
                AppMethodBeat.o(17321);
            }
        });
        AppMethodBeat.o(17326);
    }

    public static void flush(final FlushReason flushReason) {
        AppMethodBeat.i(17327);
        singleThreadExecutor.execute(new Runnable() {
            /* class com.facebook.appevents.AppEventQueue.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(17322);
                AppEventQueue.flushAndWait(flushReason);
                AppMethodBeat.o(17322);
            }
        });
        AppMethodBeat.o(17327);
    }

    public static void add(final AccessTokenAppIdPair accessTokenAppIdPair, final AppEvent appEvent) {
        AppMethodBeat.i(17328);
        singleThreadExecutor.execute(new Runnable() {
            /* class com.facebook.appevents.AppEventQueue.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(17323);
                AppEventQueue.appEventCollection.addEvent(accessTokenAppIdPair, appEvent);
                if (AppEventsLogger.getFlushBehavior() == AppEventsLogger.FlushBehavior.EXPLICIT_ONLY || AppEventQueue.appEventCollection.getEventCount() <= 100) {
                    if (AppEventQueue.scheduledFuture == null) {
                        ScheduledFuture unused = AppEventQueue.scheduledFuture = AppEventQueue.singleThreadExecutor.schedule(AppEventQueue.flushRunnable, 15, TimeUnit.SECONDS);
                    }
                    AppMethodBeat.o(17323);
                    return;
                }
                AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
                AppMethodBeat.o(17323);
            }
        });
        AppMethodBeat.o(17328);
    }

    public static Set<AccessTokenAppIdPair> getKeySet() {
        AppMethodBeat.i(17329);
        Set<AccessTokenAppIdPair> keySet = appEventCollection.keySet();
        AppMethodBeat.o(17329);
        return keySet;
    }

    static void flushAndWait(FlushReason flushReason) {
        AppMethodBeat.i(17330);
        appEventCollection.addPersistedEvents(AppEventStore.readAndClearStore());
        try {
            FlushStatistics sendEventsToServer = sendEventsToServer(flushReason, appEventCollection);
            if (sendEventsToServer != null) {
                Intent intent = new Intent(AppEventsLogger.ACTION_APP_EVENTS_FLUSHED);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, sendEventsToServer.numEvents);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_FLUSH_RESULT, sendEventsToServer.result);
                d.W(FacebookSdk.getApplicationContext()).b(intent);
            }
            AppMethodBeat.o(17330);
        } catch (Exception e2) {
            AppMethodBeat.o(17330);
        }
    }

    private static FlushStatistics sendEventsToServer(FlushReason flushReason, AppEventCollection appEventCollection2) {
        AppMethodBeat.i(17331);
        FlushStatistics flushStatistics = new FlushStatistics();
        boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
        ArrayList<GraphRequest> arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection2.keySet()) {
            GraphRequest buildRequestForSession = buildRequestForSession(accessTokenAppIdPair, appEventCollection2.get(accessTokenAppIdPair), limitEventAndDataUsage, flushStatistics);
            if (buildRequestForSession != null) {
                arrayList.add(buildRequestForSession);
            }
        }
        if (arrayList.size() > 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.numEvents), flushReason.toString());
            for (GraphRequest graphRequest : arrayList) {
                graphRequest.executeAndWait();
            }
            AppMethodBeat.o(17331);
            return flushStatistics;
        }
        AppMethodBeat.o(17331);
        return null;
    }

    private static GraphRequest buildRequestForSession(final AccessTokenAppIdPair accessTokenAppIdPair, final SessionEventsState sessionEventsState, boolean z, final FlushStatistics flushStatistics) {
        boolean z2;
        AppMethodBeat.i(17332);
        String applicationId = accessTokenAppIdPair.getApplicationId();
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
        final GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format("%s/activities", applicationId), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("access_token", accessTokenAppIdPair.getAccessTokenString());
        String pushNotificationsRegistrationId = AppEventsLogger.getPushNotificationsRegistrationId();
        if (pushNotificationsRegistrationId != null) {
            parameters.putString("device_token", pushNotificationsRegistrationId);
        }
        newPostRequest.setParameters(parameters);
        if (queryAppSettings != null) {
            z2 = queryAppSettings.supportsImplicitLogging();
        } else {
            z2 = false;
        }
        int populateRequest = sessionEventsState.populateRequest(newPostRequest, FacebookSdk.getApplicationContext(), z2, z);
        if (populateRequest == 0) {
            AppMethodBeat.o(17332);
            return null;
        }
        flushStatistics.numEvents = populateRequest + flushStatistics.numEvents;
        newPostRequest.setCallback(new GraphRequest.Callback() {
            /* class com.facebook.appevents.AppEventQueue.AnonymousClass5 */

            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(17324);
                AppEventQueue.access$400(accessTokenAppIdPair, newPostRequest, graphResponse, sessionEventsState, flushStatistics);
                AppMethodBeat.o(17324);
            }
        });
        AppMethodBeat.o(17332);
        return newPostRequest;
    }

    private static void handleResponse(final AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, final SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        FlushResult flushResult;
        String str;
        AppMethodBeat.i(17333);
        FacebookRequestError error = graphResponse.getError();
        String str2 = "Success";
        FlushResult flushResult2 = FlushResult.SUCCESS;
        if (error == null) {
            flushResult = flushResult2;
        } else if (error.getErrorCode() == -1) {
            str2 = "Failed: No Connectivity";
            flushResult = FlushResult.NO_CONNECTIVITY;
        } else {
            str2 = String.format("Failed:\n  Response: %s\n  Error %s", graphResponse.toString(), error.toString());
            flushResult = FlushResult.SERVER_ERROR;
        }
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
            try {
                str = new JSONArray((String) graphRequest.getTag()).toString(2);
            } catch (JSONException e2) {
                str = "<Can't encode events for debug logging>";
            }
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.getGraphObject().toString(), str2, str);
        }
        sessionEventsState.clearInFlightAndStats(error != null);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            FacebookSdk.getExecutor().execute(new Runnable() {
                /* class com.facebook.appevents.AppEventQueue.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(17325);
                    AppEventStore.persistEvents(accessTokenAppIdPair, sessionEventsState);
                    AppMethodBeat.o(17325);
                }
            });
        }
        if (!(flushResult == FlushResult.SUCCESS || flushStatistics.result == FlushResult.NO_CONNECTIVITY)) {
            flushStatistics.result = flushResult;
        }
        AppMethodBeat.o(17333);
    }
}
