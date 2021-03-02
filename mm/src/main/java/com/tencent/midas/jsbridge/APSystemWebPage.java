package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pay.tool.APMidasCommMethod;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APProgressDialog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;

public class APSystemWebPage implements IAPWebPage {
    private static final int HEADER_BACK = 1;
    private static final int HEADER_CLOSE = 2;
    private static final int HEADER_REFRESH = 4;
    private static final String TAG = "APSystemWebPage";
    private Activity activity;
    private APProgressDialog waitDialog;
    private APWebView webView;
    private IAPWebViewCallback webviewCallback = new IAPWebViewCallback() {
        /* class com.tencent.midas.jsbridge.APSystemWebPage.AnonymousClass1 */

        @Override // com.tencent.midas.jsbridge.IAPWebViewCallback
        public boolean WebChromeClientJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.i(192865);
            APLog.d(APSystemWebPage.TAG, "WebChromeClientJsAlert message=".concat(String.valueOf(str2)));
            APWebProtocol.AnalyzeWebEntry(APSystemWebPage.this.activity, APSystemWebPage.this.webView.getWebView(), APSystemWebPage.this, str2);
            AppMethodBeat.o(192865);
            return true;
        }

        @Override // com.tencent.midas.jsbridge.IAPWebViewCallback
        public boolean WebChromeClientJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return true;
        }

        @Override // com.tencent.midas.jsbridge.IAPWebViewCallback
        public void WebViewClientPageFinished(WebView webView, String str) {
            AppMethodBeat.i(192866);
            if (!APSystemWebPage.this.activity.isFinishing() && APSystemWebPage.this.waitDialog != null && APSystemWebPage.this.waitDialog.isShowing()) {
                APSystemWebPage.this.waitDialog.dismiss();
            }
            AppMethodBeat.o(192866);
        }

        @Override // com.tencent.midas.jsbridge.IAPWebViewCallback
        public void WebViewClientPageStarted(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(192867);
            APSystemWebPage.this.waitDialog.show();
            AppMethodBeat.o(192867);
        }

        @Override // com.tencent.midas.jsbridge.IAPWebViewCallback
        public void WebViewClientReceivedError(WebView webView, int i2, String str, String str2) {
            AppMethodBeat.i(192868);
            if (!APSystemWebPage.this.activity.isFinishing() && APSystemWebPage.this.waitDialog != null && APSystemWebPage.this.waitDialog.isShowing()) {
                APSystemWebPage.this.waitDialog.dismiss();
            }
            AppMethodBeat.o(192868);
        }
    };

    public APSystemWebPage() {
        AppMethodBeat.i(192858);
        AppMethodBeat.o(192858);
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void initUI(Activity activity2) {
        AppMethodBeat.i(192859);
        this.activity = activity2;
        activity2.setContentView(APMidasCommMethod.getLayoutId(activity2, "unipay_layout_activity_web"));
        this.webView = new APWebView(activity2, (WebView) activity2.findViewById(APMidasCommMethod.getId(activity2, "unipay_id_WebView")), this.webviewCallback);
        this.waitDialog = createDialog();
        this.waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.midas.jsbridge.APSystemWebPage.AnonymousClass2 */

            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(192859);
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void toPureH5Pay(Activity activity2, APMidasBaseRequest aPMidasBaseRequest) {
        AppMethodBeat.i(192860);
        this.activity = activity2;
        activity2.setContentView(APMidasCommMethod.getLayoutId(activity2, "unipay_layout_activity_web"));
        WebView webView2 = (WebView) activity2.findViewById(APMidasCommMethod.getId(activity2, "unipay_id_WebView"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity2.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) webView2.getLayoutParams();
        layoutParams.width = (int) (((float) displayMetrics.widthPixels) * 0.85f);
        layoutParams.height = (int) (((float) displayMetrics.heightPixels) * 0.85f);
        webView2.setLayoutParams(layoutParams);
        this.webView = new APWebView(activity2, webView2, this.webviewCallback);
        this.waitDialog = createDialog();
        this.waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.midas.jsbridge.APSystemWebPage.AnonymousClass3 */

            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(192860);
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void loadUrl(String str) {
        AppMethodBeat.i(192861);
        this.webView.loadUrl(str);
        AppMethodBeat.o(192861);
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void initHead(final Activity activity2, String str, String str2) {
        int i2;
        AppMethodBeat.i(192862);
        try {
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_HEAD_INIT, "", "headControl=" + str + "&headTitle=" + str2);
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (Exception e2) {
                i2 = 0;
            }
            if (!TextUtils.isEmpty(str2)) {
                str2 = APMidasTools.urlDecode(str2, 1);
            }
            LinearLayout linearLayout = (LinearLayout) activity2.findViewById(APMidasCommMethod.getId(activity2, "midas_header_layout"));
            if (i2 > 0 || !TextUtils.isEmpty(str2)) {
                linearLayout.setVisibility(0);
                TextView textView = (TextView) activity2.findViewById(APMidasCommMethod.getId(activity2, "midas_header_title"));
                if (!TextUtils.isEmpty(str2)) {
                    textView.setVisibility(0);
                    textView.setText(str2);
                } else {
                    textView.setVisibility(8);
                }
                ImageButton imageButton = (ImageButton) activity2.findViewById(APMidasCommMethod.getId(activity2, "midas_header_back"));
                if ((i2 & 1) == 1) {
                    imageButton.setVisibility(0);
                    imageButton.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.midas.jsbridge.APSystemWebPage.AnonymousClass4 */

                        public void onClick(View view) {
                            AppMethodBeat.i(192834);
                            APLog.d(APSystemWebPage.TAG, "backBtn() clicked");
                            boolean z = (APSystemWebPage.this.webView == null || APSystemWebPage.this.webView.getWebView() == null) ? false : true;
                            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_BACK, "", "webviewNotNull=".concat(String.valueOf(z)));
                            if (z && APSystemWebPage.this.webView.getWebView().canGoBack()) {
                                APSystemWebPage.this.webView.getWebView().goBack();
                            }
                            AppMethodBeat.o(192834);
                        }
                    });
                } else {
                    imageButton.setVisibility(8);
                }
                ImageButton imageButton2 = (ImageButton) activity2.findViewById(APMidasCommMethod.getId(activity2, "midas_header_close"));
                if ((i2 & 2) == 2) {
                    imageButton2.setVisibility(0);
                    imageButton2.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.midas.jsbridge.APSystemWebPage.AnonymousClass5 */

                        public void onClick(View view) {
                            AppMethodBeat.i(192815);
                            APLog.d(APSystemWebPage.TAG, "closeBtn() clicked");
                            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_CLOSE, "", "");
                            APMidasResponse aPMidasResponse = new APMidasResponse();
                            aPMidasResponse.resultCode = 100;
                            aPMidasResponse.resultMsg = "关闭";
                            APMidasPayHelper.midasCallBack(aPMidasResponse);
                            activity2.finish();
                            AppMethodBeat.o(192815);
                        }
                    });
                } else {
                    imageButton2.setVisibility(8);
                }
                ImageButton imageButton3 = (ImageButton) activity2.findViewById(APMidasCommMethod.getId(activity2, "midas_header_refresh"));
                if ((i2 & 4) == 4) {
                    imageButton3.setVisibility(0);
                    imageButton3.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.midas.jsbridge.APSystemWebPage.AnonymousClass6 */

                        public void onClick(View view) {
                            AppMethodBeat.i(192821);
                            APLog.d(APSystemWebPage.TAG, "refreshBtn() clicked");
                            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_REFRESH, "", "");
                            if (!(APSystemWebPage.this.webView == null || APSystemWebPage.this.webView.getWebView() == null)) {
                                APSystemWebPage.this.webView.getWebView().reload();
                            }
                            AppMethodBeat.o(192821);
                        }
                    });
                    AppMethodBeat.o(192862);
                    return;
                }
                imageButton3.setVisibility(8);
                AppMethodBeat.o(192862);
                return;
            }
            linearLayout.setVisibility(8);
            AppMethodBeat.o(192862);
        } catch (Throwable th) {
            AppMethodBeat.o(192862);
        }
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void updateWebViewSize(String str) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(192863);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.webView.getWebView().getLayoutParams();
        APLog.i("webviewclient == ", "updateWebViewSize ");
        String urlParamsValue = APMidasTools.getUrlParamsValue(str, "mpwidth");
        if (!TextUtils.isEmpty(urlParamsValue)) {
            i2 = Integer.valueOf(urlParamsValue).intValue();
        } else {
            i2 = 0;
        }
        String urlParamsValue2 = APMidasTools.getUrlParamsValue(str, "mpheight");
        if (!TextUtils.isEmpty(urlParamsValue2)) {
            i3 = Integer.valueOf(urlParamsValue2).intValue();
        }
        if (!(i3 == 0 || i2 == 0)) {
            layoutParams.width = APMidasCommMethod.dip2px(this.activity, (float) i2);
            layoutParams.height = APMidasCommMethod.dip2px(this.activity, (float) i3);
            this.webView.getWebView().setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(192863);
    }

    /* access modifiers changed from: protected */
    public APProgressDialog createDialog() {
        AppMethodBeat.i(192864);
        APProgressDialog aPProgressDialog = new APProgressDialog(this.activity);
        aPProgressDialog.setMessage("请稍候...");
        AppMethodBeat.o(192864);
        return aPProgressDialog;
    }
}
