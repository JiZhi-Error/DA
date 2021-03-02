package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
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
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebView;

public class APX5WebPage implements IAPWebPage {
    private static final int HEADER_BACK = 1;
    private static final int HEADER_CLOSE = 2;
    private static final int HEADER_REFRESH = 4;
    private static final String TAG = "APX5WebPage";
    private Activity activity;
    protected ProgressDialog waitDialog;
    protected APX5WebView webView = null;
    private IAPX5WebViewCallback webviewCallback = new IAPX5WebViewCallback() {
        /* class com.tencent.midas.jsbridge.APX5WebPage.AnonymousClass1 */

        @Override // com.tencent.midas.jsbridge.IAPX5WebViewCallback
        public boolean WebChromeClientJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.i(192801);
            APLog.d(APX5WebPage.TAG, "WebChromeClientJsAlert message=".concat(String.valueOf(str2)));
            APWebProtocol.AnalyzeWebEntry(APX5WebPage.this.activity, APX5WebPage.this.webView.getWebView(), APX5WebPage.this, str2);
            AppMethodBeat.o(192801);
            return true;
        }

        @Override // com.tencent.midas.jsbridge.IAPX5WebViewCallback
        public boolean WebChromeClientJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return true;
        }

        @Override // com.tencent.midas.jsbridge.IAPX5WebViewCallback
        public void WebViewClientPageFinished(WebView webView, String str) {
            AppMethodBeat.i(192802);
            if (!APX5WebPage.this.activity.isFinishing() && APX5WebPage.this.waitDialog != null && APX5WebPage.this.waitDialog.isShowing()) {
                APX5WebPage.this.waitDialog.dismiss();
            }
            AppMethodBeat.o(192802);
        }

        @Override // com.tencent.midas.jsbridge.IAPX5WebViewCallback
        public void WebViewClientPageStarted(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(192803);
            APX5WebPage.this.waitDialog.show();
            AppMethodBeat.o(192803);
        }

        @Override // com.tencent.midas.jsbridge.IAPX5WebViewCallback
        public void WebViewClientReceivedError(WebView webView, int i2, String str, String str2) {
            AppMethodBeat.i(192804);
            if (!APX5WebPage.this.activity.isFinishing() && APX5WebPage.this.waitDialog != null && APX5WebPage.this.waitDialog.isShowing()) {
                APX5WebPage.this.waitDialog.dismiss();
            }
            AppMethodBeat.o(192804);
        }
    };

    public APX5WebPage() {
        AppMethodBeat.i(192835);
        AppMethodBeat.o(192835);
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void toPureH5Pay(Activity activity2, APMidasBaseRequest aPMidasBaseRequest) {
        AppMethodBeat.i(192836);
        this.activity = activity2;
        activity2.setContentView(APMidasCommMethod.getLayoutId(activity2, "unipay_layout_activity_web_x5"));
        WebView webView2 = (WebView) activity2.findViewById(APMidasCommMethod.getId(activity2, "unipay_id_WebView"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity2.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) webView2.getLayoutParams();
        layoutParams.width = (int) (((float) displayMetrics.widthPixels) * 0.85f);
        layoutParams.height = (int) (((float) displayMetrics.heightPixels) * 0.85f);
        webView2.setLayoutParams(layoutParams);
        this.webView = new APX5WebView(activity2, webView2, this.webviewCallback);
        this.waitDialog = createDialog();
        this.waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.midas.jsbridge.APX5WebPage.AnonymousClass2 */

            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(192836);
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void loadUrl(String str) {
        AppMethodBeat.i(192837);
        this.webView.loadUrl(str);
        AppMethodBeat.o(192837);
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void initUI(Activity activity2) {
        AppMethodBeat.i(192838);
        this.activity = activity2;
        activity2.setContentView(APMidasCommMethod.getLayoutId(activity2, "unipay_layout_activity_web_x5"));
        this.webView = new APX5WebView(activity2, (WebView) activity2.findViewById(APMidasCommMethod.getId(activity2, "unipay_id_WebView")), this.webviewCallback);
        this.waitDialog = createDialog();
        this.waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.midas.jsbridge.APX5WebPage.AnonymousClass3 */

            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(192838);
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void initHead(final Activity activity2, String str, String str2) {
        int i2;
        AppMethodBeat.i(192839);
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
                        /* class com.tencent.midas.jsbridge.APX5WebPage.AnonymousClass4 */

                        public void onClick(View view) {
                            AppMethodBeat.i(192816);
                            APLog.d(APX5WebPage.TAG, "backBtn() clicked");
                            boolean z = (APX5WebPage.this.webView == null || APX5WebPage.this.webView.getWebView() == null) ? false : true;
                            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_X5_BACK, "", "webviewNotNull=".concat(String.valueOf(z)));
                            if (z && APX5WebPage.this.webView.getWebView().canGoBack()) {
                                APX5WebPage.this.webView.getWebView().goBack();
                            }
                            AppMethodBeat.o(192816);
                        }
                    });
                } else {
                    imageButton.setVisibility(8);
                }
                ImageButton imageButton2 = (ImageButton) activity2.findViewById(APMidasCommMethod.getId(activity2, "midas_header_close"));
                if ((i2 & 2) == 2) {
                    imageButton2.setVisibility(0);
                    imageButton2.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.midas.jsbridge.APX5WebPage.AnonymousClass5 */

                        public void onClick(View view) {
                            AppMethodBeat.i(192873);
                            APLog.d(APX5WebPage.TAG, "closeBtn() clicked");
                            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_X5_CLOSE, "", "");
                            APMidasResponse aPMidasResponse = new APMidasResponse();
                            aPMidasResponse.resultCode = 100;
                            aPMidasResponse.resultMsg = "关闭";
                            APMidasPayHelper.midasCallBack(aPMidasResponse);
                            activity2.finish();
                            AppMethodBeat.o(192873);
                        }
                    });
                } else {
                    imageButton2.setVisibility(8);
                }
                ImageButton imageButton3 = (ImageButton) activity2.findViewById(APMidasCommMethod.getId(activity2, "midas_header_refresh"));
                if ((i2 & 4) == 4) {
                    imageButton3.setVisibility(0);
                    imageButton3.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.midas.jsbridge.APX5WebPage.AnonymousClass6 */

                        public void onClick(View view) {
                            AppMethodBeat.i(192814);
                            APLog.d(APX5WebPage.TAG, "refreshBtn() clicked");
                            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_X5_REFRESH, "", "");
                            if (!(APX5WebPage.this.webView == null || APX5WebPage.this.webView.getWebView() == null)) {
                                APX5WebPage.this.webView.getWebView().reload();
                            }
                            AppMethodBeat.o(192814);
                        }
                    });
                    AppMethodBeat.o(192839);
                    return;
                }
                imageButton3.setVisibility(8);
                AppMethodBeat.o(192839);
                return;
            }
            linearLayout.setVisibility(8);
            AppMethodBeat.o(192839);
        } catch (Throwable th) {
            AppMethodBeat.o(192839);
        }
    }

    @Override // com.tencent.midas.jsbridge.IAPWebPage
    public void updateWebViewSize(String str) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(192840);
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
        AppMethodBeat.o(192840);
    }

    /* access modifiers changed from: protected */
    public APProgressDialog createDialog() {
        AppMethodBeat.i(192841);
        APProgressDialog aPProgressDialog = new APProgressDialog(this.activity);
        aPProgressDialog.setMessage("请稍候...");
        AppMethodBeat.o(192841);
        return aPProgressDialog;
    }
}
