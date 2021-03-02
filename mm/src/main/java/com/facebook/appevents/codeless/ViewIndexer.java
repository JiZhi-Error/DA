package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewIndexer {
    private static final String APP_VERSION_PARAM = "app_version";
    private static final String PLATFORM_PARAM = "platform";
    private static final String REQUEST_TYPE = "request_type";
    private static final String SUCCESS = "success";
    private static final String TAG = ViewIndexer.class.getCanonicalName();
    private static final String TREE_PARAM = "tree";
    private WeakReference<Activity> activityReference;
    private Timer indexingTimer;
    private String previousDigest = null;
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    static /* synthetic */ void access$200(ViewIndexer viewIndexer, String str, String str2) {
        AppMethodBeat.i(17524);
        viewIndexer.sendToServer(str, str2);
        AppMethodBeat.o(17524);
    }

    static {
        AppMethodBeat.i(17525);
        AppMethodBeat.o(17525);
    }

    public ViewIndexer(Activity activity) {
        AppMethodBeat.i(17518);
        this.activityReference = new WeakReference<>(activity);
        AppMethodBeat.o(17518);
    }

    public void schedule() {
        AppMethodBeat.i(17519);
        final Activity activity = this.activityReference.get();
        if (activity == null) {
            AppMethodBeat.o(17519);
            return;
        }
        final String simpleName = activity.getClass().getSimpleName();
        FacebookSdk.getApplicationId();
        final AnonymousClass1 r2 = new TimerTask() {
            /* class com.facebook.appevents.codeless.ViewIndexer.AnonymousClass1 */

            public void run() {
                String str;
                AppMethodBeat.i(17511);
                try {
                    View rootView = activity.getWindow().getDecorView().getRootView();
                    if (!ActivityLifecycleTracker.getIsAppIndexingEnabled()) {
                        AppMethodBeat.o(17511);
                    } else if (InternalSettings.isUnityApp()) {
                        UnityReflection.captureViewHierarchy();
                        AppMethodBeat.o(17511);
                    } else {
                        FutureTask futureTask = new FutureTask(new ScreenshotTaker(rootView));
                        ViewIndexer.this.uiThreadHandler.post(futureTask);
                        try {
                            str = (String) futureTask.get(1, TimeUnit.SECONDS);
                        } catch (Exception e2) {
                            String unused = ViewIndexer.TAG;
                            str = "";
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("screenname", simpleName);
                            jSONObject.put("screenshot", str);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(ViewHierarchy.getDictionaryOfView(rootView));
                            jSONObject.put("view", jSONArray);
                        } catch (JSONException e3) {
                            String unused2 = ViewIndexer.TAG;
                        }
                        ViewIndexer.access$200(ViewIndexer.this, jSONObject.toString(), simpleName);
                        AppMethodBeat.o(17511);
                    }
                } catch (Exception e4) {
                    String unused3 = ViewIndexer.TAG;
                    AppMethodBeat.o(17511);
                }
            }
        };
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.codeless.ViewIndexer.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(17512);
                try {
                    if (ViewIndexer.this.indexingTimer != null) {
                        ViewIndexer.this.indexingTimer.cancel();
                    }
                    ViewIndexer.this.previousDigest = null;
                    ViewIndexer.this.indexingTimer = new Timer();
                    ViewIndexer.this.indexingTimer.scheduleAtFixedRate(r2, 0, 1000);
                    AppMethodBeat.o(17512);
                } catch (Exception e2) {
                    String unused = ViewIndexer.TAG;
                    AppMethodBeat.o(17512);
                }
            }
        });
        AppMethodBeat.o(17519);
    }

    public void unschedule() {
        AppMethodBeat.i(17520);
        if (this.activityReference.get() == null) {
            AppMethodBeat.o(17520);
            return;
        }
        if (this.indexingTimer != null) {
            try {
                this.indexingTimer.cancel();
                this.indexingTimer = null;
                AppMethodBeat.o(17520);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(17520);
    }

    public void sendToServerUnity(String str) {
        String str2;
        AppMethodBeat.i(17521);
        Activity activity = this.activityReference.get();
        if (activity != null) {
            str2 = activity.getClass().getSimpleName();
        } else {
            str2 = "";
        }
        sendToServer(str, str2);
        AppMethodBeat.o(17521);
    }

    private void sendToServer(final String str, String str2) {
        AppMethodBeat.i(17522);
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.codeless.ViewIndexer.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(17513);
                String applicationId = FacebookSdk.getApplicationId();
                String md5hash = Utility.md5hash(str);
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                if (md5hash == null || !md5hash.equals(ViewIndexer.this.previousDigest)) {
                    GraphRequest buildAppIndexingRequest = ViewIndexer.buildAppIndexingRequest(str, currentAccessToken, applicationId, Constants.APP_INDEXING);
                    if (buildAppIndexingRequest != null) {
                        GraphResponse executeAndWait = buildAppIndexingRequest.executeAndWait();
                        try {
                            JSONObject jSONObject = executeAndWait.getJSONObject();
                            if (jSONObject != null) {
                                if (jSONObject.has("success") && jSONObject.getString("success") == ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) {
                                    Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "Successfully send UI component tree to server");
                                    ViewIndexer.this.previousDigest = md5hash;
                                }
                                if (jSONObject.has(Constants.APP_INDEXING_ENABLED)) {
                                    ActivityLifecycleTracker.updateAppIndexing(Boolean.valueOf(jSONObject.getBoolean(Constants.APP_INDEXING_ENABLED)));
                                    AppMethodBeat.o(17513);
                                    return;
                                }
                            } else {
                                String unused = ViewIndexer.TAG;
                                new StringBuilder("Error sending UI component tree to Facebook: ").append(executeAndWait.getError());
                            }
                            AppMethodBeat.o(17513);
                            return;
                        } catch (JSONException e2) {
                            String unused2 = ViewIndexer.TAG;
                        }
                    }
                    AppMethodBeat.o(17513);
                    return;
                }
                AppMethodBeat.o(17513);
            }
        });
        AppMethodBeat.o(17522);
    }

    public static GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
        AppMethodBeat.i(17523);
        if (str == null) {
            AppMethodBeat.o(17523);
            return null;
        }
        GraphRequest newPostRequest = GraphRequest.newPostRequest(accessToken, String.format(Locale.US, "%s/app_indexing", str2), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString(TREE_PARAM, str);
        parameters.putString(APP_VERSION_PARAM, AppEventUtility.getAppVersion());
        parameters.putString("platform", "android");
        parameters.putString(REQUEST_TYPE, str3);
        if (str3.equals(Constants.APP_INDEXING)) {
            parameters.putString(Constants.DEVICE_SESSION_ID, ActivityLifecycleTracker.getCurrentDeviceSessionID());
        }
        newPostRequest.setParameters(parameters);
        newPostRequest.setCallback(new GraphRequest.Callback() {
            /* class com.facebook.appevents.codeless.ViewIndexer.AnonymousClass4 */

            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(17514);
                Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "App index sent to FB!");
                AppMethodBeat.o(17514);
            }
        });
        AppMethodBeat.o(17523);
        return newPostRequest;
    }

    static class ScreenshotTaker implements Callable<String> {
        private WeakReference<View> rootView;

        public ScreenshotTaker(View view) {
            AppMethodBeat.i(17515);
            this.rootView = new WeakReference<>(view);
            AppMethodBeat.o(17515);
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            AppMethodBeat.i(17516);
            View view = this.rootView.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                AppMethodBeat.o(17516);
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            AppMethodBeat.o(17516);
            return encodeToString;
        }
    }
}
