package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebDialog extends Dialog {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int BACKGROUND_GRAY = -872415232;
    private static final int DEFAULT_THEME = R.style.a5c;
    static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
    private static final String DISPLAY_TOUCH = "touch";
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
    private static final int MAX_PADDING_SCREEN_WIDTH = 800;
    private static final double MIN_SCALE_FACTOR = 0.5d;
    private static final int NO_PADDING_SCREEN_HEIGHT = 800;
    private static final int NO_PADDING_SCREEN_WIDTH = 480;
    private static volatile int webDialogTheme;
    private FrameLayout contentFrameLayout;
    private ImageView crossImageView;
    private String expectedRedirectUrl;
    private boolean isDetached;
    private boolean isPageFinished;
    private boolean listenerCalled;
    private OnCompleteListener onCompleteListener;
    private ProgressDialog spinner;
    private UploadStagingResourcesTask uploadTask;
    private String url;
    private WebView webView;
    private WindowManager.LayoutParams windowParams;

    public interface OnCompleteListener {
        void onComplete(Bundle bundle, FacebookException facebookException);
    }

    static /* synthetic */ void access$1000(WebDialog webDialog, int i2) {
        AppMethodBeat.i(7718);
        webDialog.setUpWebView(i2);
        AppMethodBeat.o(7718);
    }

    protected static void initDefaultTheme(Context context) {
        AppMethodBeat.i(7697);
        if (context == null) {
            AppMethodBeat.o(7697);
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                AppMethodBeat.o(7697);
                return;
            }
            if (webDialogTheme == 0) {
                setWebDialogTheme(applicationInfo.metaData.getInt(FacebookSdk.WEB_DIALOG_THEME));
            }
            AppMethodBeat.o(7697);
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(7697);
        }
    }

    public static WebDialog newInstance(Context context, String str, Bundle bundle, int i2, OnCompleteListener onCompleteListener2) {
        AppMethodBeat.i(7698);
        initDefaultTheme(context);
        WebDialog webDialog = new WebDialog(context, str, bundle, i2, onCompleteListener2);
        AppMethodBeat.o(7698);
        return webDialog;
    }

    public static int getWebDialogTheme() {
        AppMethodBeat.i(7699);
        Validate.sdkInitialized();
        int i2 = webDialogTheme;
        AppMethodBeat.o(7699);
        return i2;
    }

    public static void setWebDialogTheme(int i2) {
        if (i2 == 0) {
            i2 = DEFAULT_THEME;
        }
        webDialogTheme = i2;
    }

    protected WebDialog(Context context, String str) {
        this(context, str, getWebDialogTheme());
        AppMethodBeat.i(7700);
        AppMethodBeat.o(7700);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private WebDialog(Context context, String str, int i2) {
        super(context, i2 == 0 ? getWebDialogTheme() : i2);
        AppMethodBeat.i(7701);
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        this.listenerCalled = false;
        this.isDetached = false;
        this.isPageFinished = false;
        this.url = str;
        AppMethodBeat.o(7701);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private WebDialog(Context context, String str, Bundle bundle, int i2, OnCompleteListener onCompleteListener2) {
        super(context, i2 == 0 ? getWebDialogTheme() : i2);
        AppMethodBeat.i(7702);
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        this.listenerCalled = false;
        this.isDetached = false;
        this.isPageFinished = false;
        bundle = bundle == null ? new Bundle() : bundle;
        this.expectedRedirectUrl = Utility.isChromeOS(context) ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : ServerProtocol.DIALOG_REDIRECT_URI;
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.expectedRedirectUrl);
        bundle.putString(ServerProtocol.DIALOG_PARAM_DISPLAY, "touch");
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        bundle.putString(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.format(Locale.ROOT, "android-%s", FacebookSdk.getSdkVersion()));
        this.onCompleteListener = onCompleteListener2;
        if (!str.equals("share") || !bundle.containsKey("media")) {
            this.url = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + str, bundle).toString();
            AppMethodBeat.o(7702);
            return;
        }
        this.uploadTask = new UploadStagingResourcesTask(str, bundle);
        AppMethodBeat.o(7702);
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener2) {
        this.onCompleteListener = onCompleteListener2;
    }

    public OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(7703);
        if (i2 == 4) {
            cancel();
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(7703);
        return onKeyDown;
    }

    public void dismiss() {
        AppMethodBeat.i(7704);
        if (this.webView != null) {
            this.webView.stopLoading();
        }
        if (!this.isDetached && this.spinner != null && this.spinner.isShowing()) {
            this.spinner.dismiss();
        }
        super.dismiss();
        AppMethodBeat.o(7704);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        AppMethodBeat.i(7705);
        super.onStart();
        if (this.uploadTask == null || this.uploadTask.getStatus() != AsyncTask.Status.PENDING) {
            resize();
            AppMethodBeat.o(7705);
            return;
        }
        this.uploadTask.execute(new Void[0]);
        this.spinner.show();
        AppMethodBeat.o(7705);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        AppMethodBeat.i(7706);
        if (this.uploadTask != null) {
            this.uploadTask.cancel(true);
            this.spinner.dismiss();
        }
        super.onStop();
        AppMethodBeat.o(7706);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(7707);
        this.isDetached = true;
        super.onDetachedFromWindow();
        AppMethodBeat.o(7707);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(7708);
        this.isDetached = false;
        if (Utility.mustFixWindowParamsForAutofill(getContext()) && this.windowParams != null && this.windowParams.token == null) {
            this.windowParams.token = getOwnerActivity().getWindow().getAttributes().token;
            Utility.logd(LOG_TAG, "Set token on onAttachedToWindow(): " + this.windowParams.token);
        }
        super.onAttachedToWindow();
        AppMethodBeat.o(7708);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        AppMethodBeat.i(7709);
        if (layoutParams.token == null) {
            this.windowParams = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
        AppMethodBeat.o(7709);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7710);
        super.onCreate(bundle);
        this.spinner = new ProgressDialog(getContext());
        this.spinner.requestWindowFeature(1);
        this.spinner.setMessage(getContext().getString(R.string.b84));
        this.spinner.setCanceledOnTouchOutside(false);
        this.spinner.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.facebook.internal.WebDialog.AnonymousClass1 */

            public void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(7679);
                WebDialog.this.cancel();
                AppMethodBeat.o(7679);
            }
        });
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        resize();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        createCrossImage();
        if (this.url != null) {
            setUpWebView((this.crossImageView.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        this.contentFrameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.contentFrameLayout);
        AppMethodBeat.o(7710);
    }

    /* access modifiers changed from: protected */
    public void setExpectedRedirectUrl(String str) {
        this.expectedRedirectUrl = str;
    }

    /* access modifiers changed from: protected */
    public Bundle parseResponseUri(String str) {
        AppMethodBeat.i(7711);
        Uri parse = Uri.parse(str);
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
        parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
        AppMethodBeat.o(7711);
        return parseUrlQueryString;
    }

    /* access modifiers changed from: protected */
    public boolean isListenerCalled() {
        return this.listenerCalled;
    }

    /* access modifiers changed from: protected */
    public boolean isPageFinished() {
        return this.isPageFinished;
    }

    /* access modifiers changed from: protected */
    public WebView getWebView() {
        return this.webView;
    }

    public void resize() {
        AppMethodBeat.i(7712);
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        getWindow().setLayout(Math.min(getScaledSize(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(getScaledSize(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
        AppMethodBeat.o(7712);
    }

    private int getScaledSize(int i2, float f2, int i3, int i4) {
        double d2 = MIN_SCALE_FACTOR;
        int i5 = (int) (((float) i2) / f2);
        if (i5 <= i3) {
            d2 = 1.0d;
        } else if (i5 < i4) {
            d2 = MIN_SCALE_FACTOR + ((((double) (i4 - i5)) / ((double) (i4 - i3))) * MIN_SCALE_FACTOR);
        }
        return (int) (d2 * ((double) i2));
    }

    /* access modifiers changed from: protected */
    public void sendSuccessToListener(Bundle bundle) {
        AppMethodBeat.i(7713);
        if (this.onCompleteListener != null && !this.listenerCalled) {
            this.listenerCalled = true;
            this.onCompleteListener.onComplete(bundle, null);
            dismiss();
        }
        AppMethodBeat.o(7713);
    }

    /* access modifiers changed from: protected */
    public void sendErrorToListener(Throwable th) {
        FacebookException facebookException;
        AppMethodBeat.i(7714);
        if (this.onCompleteListener != null && !this.listenerCalled) {
            this.listenerCalled = true;
            if (th instanceof FacebookException) {
                facebookException = (FacebookException) th;
            } else {
                facebookException = new FacebookException(th);
            }
            this.onCompleteListener.onComplete(null, facebookException);
            dismiss();
        }
        AppMethodBeat.o(7714);
    }

    public void cancel() {
        AppMethodBeat.i(7715);
        if (this.onCompleteListener != null && !this.listenerCalled) {
            sendErrorToListener(new FacebookOperationCanceledException());
        }
        AppMethodBeat.o(7715);
    }

    private void createCrossImage() {
        AppMethodBeat.i(7716);
        this.crossImageView = new ImageView(getContext());
        this.crossImageView.setOnClickListener(new View.OnClickListener() {
            /* class com.facebook.internal.WebDialog.AnonymousClass2 */

            public void onClick(View view) {
                AppMethodBeat.i(7680);
                WebDialog.this.cancel();
                AppMethodBeat.o(7680);
            }
        });
        this.crossImageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.b8k));
        this.crossImageView.setVisibility(4);
        AppMethodBeat.o(7716);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void setUpWebView(int i2) {
        AppMethodBeat.i(7717);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.webView = new WebView(getContext()) {
            /* class com.facebook.internal.WebDialog.AnonymousClass3 */

            public void onWindowFocusChanged(boolean z) {
                AppMethodBeat.i(7681);
                try {
                    super.onWindowFocusChanged(z);
                    AppMethodBeat.o(7681);
                } catch (NullPointerException e2) {
                    AppMethodBeat.o(7681);
                }
            }
        };
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setWebViewClient(new DialogWebViewClient());
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.loadUrl(this.url);
        this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.webView.setVisibility(4);
        this.webView.getSettings().setSavePassword(false);
        this.webView.getSettings().setSaveFormData(false);
        this.webView.setFocusable(true);
        this.webView.setFocusableInTouchMode(true);
        this.webView.setOnTouchListener(new View.OnTouchListener() {
            /* class com.facebook.internal.WebDialog.AnonymousClass4 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(7682);
                if (!view.hasFocus()) {
                    view.requestFocus();
                }
                AppMethodBeat.o(7682);
                return false;
            }
        });
        linearLayout.setPadding(i2, i2, i2, i2);
        linearLayout.addView(this.webView);
        linearLayout.setBackgroundColor(BACKGROUND_GRAY);
        this.contentFrameLayout.addView(linearLayout);
        AppMethodBeat.o(7717);
    }

    /* access modifiers changed from: package-private */
    public class DialogWebViewClient extends WebViewClient {
        private byte _hellAccFlag_;

        private DialogWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int i2;
            AppMethodBeat.i(7687);
            Utility.logd(WebDialog.LOG_TAG, "Redirect URL: ".concat(String.valueOf(str)));
            if (str.startsWith(WebDialog.this.expectedRedirectUrl)) {
                Bundle parseResponseUri = WebDialog.this.parseResponseUri(str);
                String string = parseResponseUri.getString("error");
                if (string == null) {
                    string = parseResponseUri.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
                }
                String string2 = parseResponseUri.getString("error_msg");
                if (string2 == null) {
                    string2 = parseResponseUri.getString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE);
                }
                if (string2 == null) {
                    string2 = parseResponseUri.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                }
                String string3 = parseResponseUri.getString("error_code");
                if (!Utility.isNullOrEmpty(string3)) {
                    try {
                        i2 = Integer.parseInt(string3);
                    } catch (NumberFormatException e2) {
                        i2 = -1;
                    }
                } else {
                    i2 = -1;
                }
                if (Utility.isNullOrEmpty(string) && Utility.isNullOrEmpty(string2) && i2 == -1) {
                    WebDialog.this.sendSuccessToListener(parseResponseUri);
                } else if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                    WebDialog.this.cancel();
                } else if (i2 == WebDialog.API_EC_DIALOG_CANCEL) {
                    WebDialog.this.cancel();
                } else {
                    WebDialog.this.sendErrorToListener(new FacebookServiceException(new FacebookRequestError(i2, string, string2), string2));
                }
                AppMethodBeat.o(7687);
                return true;
            } else if (str.startsWith(ServerProtocol.DIALOG_CANCEL_URI)) {
                WebDialog.this.cancel();
                AppMethodBeat.o(7687);
                return true;
            } else if (str.contains("touch")) {
                AppMethodBeat.o(7687);
                return false;
            } else {
                try {
                    Context context = WebDialog.this.getContext();
                    a bl = new a().bl(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/facebook/internal/WebDialog$DialogWebViewClient", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/facebook/internal/WebDialog$DialogWebViewClient", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(7687);
                    return true;
                } catch (ActivityNotFoundException e3) {
                    AppMethodBeat.o(7687);
                    return false;
                }
            }
        }

        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            AppMethodBeat.i(7688);
            super.onReceivedError(webView, i2, str, str2);
            WebDialog.this.sendErrorToListener(new FacebookDialogException(str, i2, str2));
            AppMethodBeat.o(7688);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AppMethodBeat.i(7689);
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            WebDialog.this.sendErrorToListener(new FacebookDialogException(null, -11, null));
            AppMethodBeat.o(7689);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(7690);
            Utility.logd(WebDialog.LOG_TAG, "Webview loading URL: ".concat(String.valueOf(str)));
            super.onPageStarted(webView, str, bitmap);
            if (!WebDialog.this.isDetached) {
                WebDialog.this.spinner.show();
            }
            AppMethodBeat.o(7690);
        }

        public void onPageFinished(WebView webView, String str) {
            AppMethodBeat.i(7691);
            super.onPageFinished(webView, str);
            if (!WebDialog.this.isDetached) {
                WebDialog.this.spinner.dismiss();
            }
            WebDialog.this.contentFrameLayout.setBackgroundColor(0);
            WebDialog.this.webView.setVisibility(0);
            WebDialog.this.crossImageView.setVisibility(0);
            WebDialog.this.isPageFinished = true;
            AppMethodBeat.o(7691);
        }
    }

    public static class Builder {
        private AccessToken accessToken;
        private String action;
        private String applicationId;
        private Context context;
        private OnCompleteListener listener;
        private Bundle parameters;
        private int theme;

        public Builder(Context context2, String str, Bundle bundle) {
            AppMethodBeat.i(7683);
            this.accessToken = AccessToken.getCurrentAccessToken();
            if (!AccessToken.isCurrentAccessTokenActive()) {
                String metadataApplicationId = Utility.getMetadataApplicationId(context2);
                if (metadataApplicationId != null) {
                    this.applicationId = metadataApplicationId;
                } else {
                    FacebookException facebookException = new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                    AppMethodBeat.o(7683);
                    throw facebookException;
                }
            }
            finishInit(context2, str, bundle);
            AppMethodBeat.o(7683);
        }

        public Builder(Context context2, String str, String str2, Bundle bundle) {
            AppMethodBeat.i(7684);
            str = str == null ? Utility.getMetadataApplicationId(context2) : str;
            Validate.notNullOrEmpty(str, "applicationId");
            this.applicationId = str;
            finishInit(context2, str2, bundle);
            AppMethodBeat.o(7684);
        }

        public Builder setTheme(int i2) {
            this.theme = i2;
            return this;
        }

        public Builder setOnCompleteListener(OnCompleteListener onCompleteListener) {
            this.listener = onCompleteListener;
            return this;
        }

        public WebDialog build() {
            AppMethodBeat.i(7685);
            if (this.accessToken != null) {
                this.parameters.putString("app_id", this.accessToken.getApplicationId());
                this.parameters.putString("access_token", this.accessToken.getToken());
            } else {
                this.parameters.putString("app_id", this.applicationId);
            }
            WebDialog newInstance = WebDialog.newInstance(this.context, this.action, this.parameters, this.theme, this.listener);
            AppMethodBeat.o(7685);
            return newInstance;
        }

        public String getApplicationId() {
            return this.applicationId;
        }

        public Context getContext() {
            return this.context;
        }

        public int getTheme() {
            return this.theme;
        }

        public Bundle getParameters() {
            return this.parameters;
        }

        public OnCompleteListener getListener() {
            return this.listener;
        }

        private void finishInit(Context context2, String str, Bundle bundle) {
            AppMethodBeat.i(7686);
            this.context = context2;
            this.action = str;
            if (bundle != null) {
                this.parameters = bundle;
                AppMethodBeat.o(7686);
                return;
            }
            this.parameters = new Bundle();
            AppMethodBeat.o(7686);
        }
    }

    class UploadStagingResourcesTask extends AsyncTask<Void, Void, String[]> {
        private String action;
        private Exception[] exceptions;
        private Bundle parameters;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ String[] doInBackground(Void[] voidArr) {
            AppMethodBeat.i(7696);
            String[] doInBackground = doInBackground(voidArr);
            AppMethodBeat.o(7696);
            return doInBackground;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(String[] strArr) {
            AppMethodBeat.i(7695);
            onPostExecute(strArr);
            AppMethodBeat.o(7695);
        }

        UploadStagingResourcesTask(String str, Bundle bundle) {
            this.action = str;
            this.parameters = bundle;
        }

        /* access modifiers changed from: protected */
        public String[] doInBackground(Void... voidArr) {
            AppMethodBeat.i(7693);
            String[] stringArray = this.parameters.getStringArray("media");
            final String[] strArr = new String[stringArray.length];
            this.exceptions = new Exception[stringArray.length];
            final CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            for (final int i2 = 0; i2 < stringArray.length; i2++) {
                try {
                    if (isCancelled()) {
                        Iterator it = concurrentLinkedQueue.iterator();
                        while (it.hasNext()) {
                            ((AsyncTask) it.next()).cancel(true);
                        }
                        AppMethodBeat.o(7693);
                        return null;
                    }
                    Uri parse = Uri.parse(stringArray[i2]);
                    if (Utility.isWebUri(parse)) {
                        strArr[i2] = parse.toString();
                        countDownLatch.countDown();
                    } else {
                        concurrentLinkedQueue.add(ShareInternalUtility.newUploadStagingResourceWithImageRequest(currentAccessToken, parse, new GraphRequest.Callback() {
                            /* class com.facebook.internal.WebDialog.UploadStagingResourcesTask.AnonymousClass1 */

                            @Override // com.facebook.GraphRequest.Callback
                            public void onCompleted(GraphResponse graphResponse) {
                                AppMethodBeat.i(7692);
                                try {
                                    FacebookRequestError error = graphResponse.getError();
                                    if (error != null) {
                                        String errorMessage = error.getErrorMessage();
                                        if (errorMessage == null) {
                                            errorMessage = "Error staging photo.";
                                        }
                                        FacebookGraphResponseException facebookGraphResponseException = new FacebookGraphResponseException(graphResponse, errorMessage);
                                        AppMethodBeat.o(7692);
                                        throw facebookGraphResponseException;
                                    }
                                    JSONObject jSONObject = graphResponse.getJSONObject();
                                    if (jSONObject == null) {
                                        FacebookException facebookException = new FacebookException("Error staging photo.");
                                        AppMethodBeat.o(7692);
                                        throw facebookException;
                                    }
                                    String optString = jSONObject.optString(ShareConstants.MEDIA_URI);
                                    if (optString == null) {
                                        FacebookException facebookException2 = new FacebookException("Error staging photo.");
                                        AppMethodBeat.o(7692);
                                        throw facebookException2;
                                    }
                                    strArr[i2] = optString;
                                    countDownLatch.countDown();
                                    AppMethodBeat.o(7692);
                                } catch (Exception e2) {
                                    UploadStagingResourcesTask.this.exceptions[i2] = e2;
                                }
                            }
                        }).executeAsync());
                    }
                } catch (Exception e2) {
                    Iterator it2 = concurrentLinkedQueue.iterator();
                    while (it2.hasNext()) {
                        ((AsyncTask) it2.next()).cancel(true);
                    }
                    AppMethodBeat.o(7693);
                    return null;
                }
            }
            countDownLatch.await();
            AppMethodBeat.o(7693);
            return strArr;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String[] strArr) {
            AppMethodBeat.i(7694);
            WebDialog.this.spinner.dismiss();
            Exception[] excArr = this.exceptions;
            for (Exception exc : excArr) {
                if (exc != null) {
                    WebDialog.this.sendErrorToListener(exc);
                    AppMethodBeat.o(7694);
                    return;
                }
            }
            if (strArr == null) {
                WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                AppMethodBeat.o(7694);
                return;
            }
            List asList = Arrays.asList(strArr);
            if (asList.contains(null)) {
                WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                AppMethodBeat.o(7694);
                return;
            }
            Utility.putJSONValueInBundle(this.parameters, "media", new JSONArray((Collection) asList));
            WebDialog.this.url = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + this.action, this.parameters).toString();
            WebDialog.access$1000(WebDialog.this, (WebDialog.this.crossImageView.getDrawable().getIntrinsicWidth() / 2) + 1);
            AppMethodBeat.o(7694);
        }
    }
}
