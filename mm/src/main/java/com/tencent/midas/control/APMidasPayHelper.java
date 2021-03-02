package com.tencent.midas.control;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasNetCallBack;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.IAPWebView;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasNetRequest;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APCallBackResultReceiver;
import com.tencent.midas.data.APDataId;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.midas.data.APMultiProcessData;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.jsbridge.APWebJSBridgeActivity;
import com.tencent.midas.plugin.APPluginChecker;
import com.tencent.midas.plugin.APPluginInstallerAndUpdater;
import com.tencent.midas.plugin.APPluginInterfaceManager;
import com.tencent.midas.plugin.APPluginLoader;
import com.tencent.midas.plugin.APPluginUtils;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import org.json.JSONException;

public class APMidasPayHelper implements APCallBackResultReceiver.Receiver {
    public static String MED_DISTRIBUTE_CALL = "openMidasCall";
    public static String MED_DISTRIBUTE_CALL2 = "openMidasCall2";
    public static final String MED_DISTRIBUTE_CALLBACK_FROM_MIDAS_PAY = "callbackFromMidasPay";
    public static String MED_DISTRIBUTE_H5PAY = "openMidasH5Pay";
    public static String MED_DISTRIBUTE_HANDLE_QQ_WALLET_INTENT = "handleQQWalletIntent";
    public static String MED_DISTRIBUTE_HANDLE_WX_INTENT = "handleWXIntent";
    public static final String MED_DISTRIBUTE_HF_COUPONS_ROLLBACK = "hfCouponsRollBack";
    public static String MED_DISTRIBUTE_INFO = "openMidasInfo";
    public static String MED_DISTRIBUTE_INIT = "golbalInit";
    public static String MED_DISTRIBUTE_NET = "openMidasNet";
    public static String MED_DISTRIBUTE_PAY = "openMidasPay";
    public static String MED_DISTRIBUTE_RECEIVE = "receiveMidas";
    public static String MED_DISTRIBUTE_RELEASE = "release";
    public static String MED_DISTRIBUTE_WEB = "openMidasWeb";
    public static final String MED_DISTRIBUTE_WX_MINIPROGRAM = "launchWXMiniProgram";
    public static final String MED_DISTRIBUTE_WX_MINIPROGRAM_ONRESPONSE = "launchWXMiniProgram_OnResponse";
    public static final String MED_DISTRIBUTE_XGAME_CONSUME = "consumeAsync";
    public static final String MED_DISTRIBUTE_XGAME_QUERY = "queryInventoryAsync";
    public static int MIDAS_INNER_WEBVIEW = 0;
    public static int MIDAS_OUT_WEBVIEW = 1;
    public static String MIDAS_PLUGIN_NAME = "MidasPay";
    public static final String MIDAS_PLUGIN_VERSION = "1.7.1f";
    public static int MIDAS_WEBVIEW = 0;
    public static String PKG_DISTRIBUTE = "com.tencent.midas.pay.APMidasDistribute";
    public static final int PLUGIN_INITFAIL = 2;
    private static final int PLUGIN_INITIDLE = -1;
    public static final int PLUGIN_INITING = 0;
    public static final int PLUGIN_INITSUCC = 1;
    private static final int RET_CHANGE_H5 = -100011;
    private static final String RET_MSG_CHANGE_H5 = "needChangeH5";
    private static final String TAG = "APMidasPayHelper";
    private static Object dexloadObject = new Object();
    private static String env = "release";
    private static int initCount = 0;
    private static Object initObject = new Object();
    private static APMidasBaseRequest initRequest = null;
    public static int initState = -1;
    private static boolean isInitSucc = false;
    private static boolean isNeedLocalUpdate = false;
    public static boolean isNewProcess = false;
    private static Object loadingObject = new Object();
    private static boolean logEnable;
    public static IAPMidasPayCallBack midasCallBack = null;
    public static IAPMidasNetCallBack netCallBack = null;
    private static String netCallBack_ReqType = "";
    private static APCallBackResultReceiver remotRecevier = null;
    public static APMidasBaseRequest requestObject = null;
    public static IAPWebView sIWebView;
    public static Activity staticActivityContext = null;
    public static WebView webview;
    public static com.tencent.smtt.sdk.WebView x5Webview;
    private byte _hellAccFlag_;
    Object retobj = null;
    public int saveType = 0;
    public int screenType = 0;

    static /* synthetic */ void access$1000(APMidasPayHelper aPMidasPayHelper, Activity activity, Intent intent, String str) {
        AppMethodBeat.i(192991);
        aPMidasPayHelper.openPlugin(activity, intent, str);
        AppMethodBeat.o(192991);
    }

    static /* synthetic */ int access$1100(APMidasPayHelper aPMidasPayHelper, Activity activity, String str, String str2, String str3) {
        AppMethodBeat.i(192992);
        int h5MidasPay = aPMidasPayHelper.toH5MidasPay(activity, str, str2, str3);
        AppMethodBeat.o(192992);
        return h5MidasPay;
    }

    static /* synthetic */ void access$1200(Context context, String str, IAPInitCallBack iAPInitCallBack) {
        AppMethodBeat.i(192993);
        preLoadMidasPay(context, str, iAPInitCallBack);
        AppMethodBeat.o(192993);
    }

    static /* synthetic */ int access$508() {
        int i2 = initCount;
        initCount = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$700(APMidasPayHelper aPMidasPayHelper, Activity activity, APMidasBaseRequest aPMidasBaseRequest, String str, String str2) {
        AppMethodBeat.i(192990);
        int midasPay = aPMidasPayHelper.toMidasPay(activity, aPMidasBaseRequest, str, str2);
        AppMethodBeat.o(192990);
        return midasPay;
    }

    static {
        AppMethodBeat.i(192994);
        AppMethodBeat.o(192994);
    }

    @Override // com.tencent.midas.control.APCallBackResultReceiver.Receiver
    public void onReceiveResult(int i2, Bundle bundle) {
        AppMethodBeat.i(192952);
        APLog.i(TAG, "remotRecevier payHelper resultCode:".concat(String.valueOf(i2)));
        if (i2 == 0) {
            progressRemoteInfo(bundle);
        }
        AppMethodBeat.o(192952);
    }

    public void progressRemoteInfo(Bundle bundle) {
        APPurchase aPPurchase;
        AppMethodBeat.i(192953);
        String string = bundle.getString("type");
        APLog.i(TAG, "progressRemoteInfo type:".concat(String.valueOf(string)));
        if ("callback".equals(string)) {
            APMidasResponse aPMidasResponse = new APMidasResponse();
            aPMidasResponse.resultCode = bundle.getInt("resultCode", -1);
            aPMidasResponse.resultInerCode = bundle.getInt("resultInerCode");
            aPMidasResponse.realSaveNum = bundle.getInt("realSaveNum");
            aPMidasResponse.payChannel = bundle.getInt("payChannel");
            aPMidasResponse.payState = bundle.getInt("payState");
            aPMidasResponse.provideState = bundle.getInt("provideState");
            aPMidasResponse.resultMsg = bundle.getString("resultMsg");
            aPMidasResponse.extendInfo = bundle.getString("extendInfo");
            aPMidasResponse.payReserve1 = bundle.getString("payReserve1");
            aPMidasResponse.payReserve2 = bundle.getString("payReserve2");
            aPMidasResponse.payReserve3 = bundle.getString("payReserve3");
            try {
                aPPurchase = new APPurchase(bundle.getString("purchaseJson"), bundle.getString("purchaseSign"));
            } catch (JSONException e2) {
                aPPurchase = new APPurchase();
                APLog.w("progressRemoteInfo", "purchase creat fail1 " + e2.toString());
            } catch (Exception e3) {
                aPPurchase = new APPurchase();
                APLog.w("progressRemoteInfo", "purchase creat fail2 " + e3.toString());
            }
            aPMidasResponse.mAPPurchase = aPPurchase;
            midasCallBack(aPMidasResponse);
            AppMethodBeat.o(192953);
        } else if ("h5callback".equals(string)) {
            midasH5CallBack(bundle.getString("callbackinfo"));
            AppMethodBeat.o(192953);
        } else {
            if ("needlogin".equals(string)) {
                midasLoginExpire();
            }
            AppMethodBeat.o(192953);
        }
    }

    public static synchronized void init(final Context context, APMidasBaseRequest aPMidasBaseRequest) {
        synchronized (APMidasPayHelper.class) {
            AppMethodBeat.i(192954);
            APLog.i(TAG, "init initCount:" + initCount);
            isNewProcess = isNewProcess(context);
            initRequest = aPMidasBaseRequest;
            if (initCount <= 0 && !isInitSucc) {
                APPluginUtils.release();
                preLoadPlugin(context, APMidasPluginInfo.LAUNCH_INTERFACE_INIT, new IAPInitCallBack() {
                    /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass1 */

                    @Override // com.tencent.midas.control.IAPInitCallBack
                    public final void result(int i2, String str, String str2, Bundle bundle) {
                        AppMethodBeat.i(192940);
                        APLog.i(APMidasPayHelper.TAG, "initcallback ret:" + i2 + " msg:" + str);
                        synchronized (APMidasPayHelper.dexloadObject) {
                            try {
                                boolean unused = APMidasPayHelper.isInitSucc = true;
                                APMidasPayHelper.dexloadObject.notifyAll();
                            } catch (Throwable th) {
                                AppMethodBeat.o(192940);
                                throw th;
                            }
                        }
                        APPluginReportManager.getInstance().dataReport(APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
                        AppMethodBeat.o(192940);
                    }
                });
            } else if (isInitSucc) {
                ((Activity) context).runOnUiThread(new Runnable() {
                    /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(192951);
                        APLog.i(APMidasPayHelper.TAG, "initcallback isInitSucc direct call init function");
                        Intent intent = new Intent();
                        intent.putExtra("version", "1.7.1f");
                        intent.putExtra("req", APMidasPayHelper.initRequest);
                        intent.putExtra("env", APMidasPayHelper.env);
                        intent.putExtra("logEnable", APMidasPayHelper.logEnable);
                        intent.putExtra("launchInterfaceName", Thread.currentThread().getName());
                        try {
                            APPluginInterfaceManager.initPluginInterface(context, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_INIT, new Object[]{context, intent});
                            AppMethodBeat.o(192951);
                        } catch (Exception e2) {
                            APLog.i(APMidasPayHelper.TAG, "initcallback isInitSucc direct call init function e:" + e2.toString());
                            AppMethodBeat.o(192951);
                        }
                    }
                });
            }
            APPluginReportManager.getInstance().dataReport(APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
            initCount++;
            AppMethodBeat.o(192954);
        }
    }

    @SuppressLint({"NewApi"})
    public static synchronized void h5InitUnifier(final Activity activity, IAPWebView iAPWebView) {
        synchronized (APMidasPayHelper.class) {
            AppMethodBeat.i(192955);
            APLog.i(TAG, "h5InitUnifier");
            sIWebView = iAPWebView;
            isNewProcess = isNewProcess(activity);
            if (initCount <= 0) {
                APPluginUtils.release();
                preLoadPlugin(activity, APMidasPluginInfo.LAUNCH_INTERFACE_INIT, new IAPInitCallBack() {
                    /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass3 */

                    @Override // com.tencent.midas.control.IAPInitCallBack
                    public final void result(int i2, String str, String str2, Bundle bundle) {
                        AppMethodBeat.i(192944);
                        APLog.i(APMidasPayHelper.TAG, "h5InitUnifier ret:" + i2 + " msg:" + str);
                        APPluginReportManager.getInstance().dataReport(APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
                        if (i2 == 0) {
                            String str3 = (String) new APMidasPayHelper().call(activity, "getH5JS", new Object[]{activity});
                            if (!TextUtils.isEmpty(str3)) {
                                try {
                                    if (APMidasPayHelper.sIWebView != null) {
                                        APMidasPayHelper.sIWebView.loadUrl("javascript:".concat(String.valueOf(str3)));
                                    }
                                } catch (Exception e2) {
                                    APLog.w(APMidasPayHelper.TAG, "h5InitUnifier loadJS error:" + e2.toString());
                                }
                            }
                            APMidasPayHelper.access$508();
                        }
                        AppMethodBeat.o(192944);
                    }
                });
                AppMethodBeat.o(192955);
            } else {
                String str = (String) new APMidasPayHelper().call(activity, "getH5JS", new Object[]{activity});
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (sIWebView != null) {
                            sIWebView.loadUrl("javascript:".concat(String.valueOf(str)));
                        }
                        AppMethodBeat.o(192955);
                    } catch (Exception e2) {
                        APLog.w(TAG, "h5InitUnifier loadJS error:" + e2.toString());
                    }
                }
                AppMethodBeat.o(192955);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static synchronized void h5Init(final Activity activity, WebView webView, com.tencent.smtt.sdk.WebView webView2) {
        synchronized (APMidasPayHelper.class) {
            AppMethodBeat.i(192956);
            APLog.i(TAG, "h5Init");
            x5Webview = webView2;
            webview = webView;
            isNewProcess = isNewProcess(activity);
            if (initCount <= 0) {
                APPluginUtils.release();
                preLoadPlugin(activity, APMidasPluginInfo.LAUNCH_INTERFACE_INIT, new IAPInitCallBack() {
                    /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass4 */

                    @Override // com.tencent.midas.control.IAPInitCallBack
                    public final void result(int i2, String str, String str2, Bundle bundle) {
                        AppMethodBeat.i(192950);
                        APLog.i(APMidasPayHelper.TAG, "init ret:" + i2 + " msg:" + str);
                        APPluginReportManager.getInstance().dataReport(APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
                        if (i2 == 0) {
                            String str3 = (String) new APMidasPayHelper().call(activity, "getH5JS", new Object[]{activity});
                            if (!TextUtils.isEmpty(str3)) {
                                try {
                                    if (APMidasPayHelper.webview != null) {
                                        APMidasPayHelper.webview.loadUrl("javascript:".concat(String.valueOf(str3)));
                                    }
                                    if (APMidasPayHelper.x5Webview != null) {
                                        APMidasPayHelper.x5Webview.loadUrl("javascript:".concat(String.valueOf(str3)));
                                    }
                                } catch (Exception e2) {
                                    APLog.w(APMidasPayHelper.TAG, "h5Init loadJS error:" + e2.toString());
                                }
                            }
                            APMidasPayHelper.access$508();
                        }
                        AppMethodBeat.o(192950);
                    }
                });
                AppMethodBeat.o(192956);
            } else {
                String str = (String) new APMidasPayHelper().call(activity, "getH5JS", new Object[]{activity});
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (webview != null) {
                            webView.loadUrl("javascript:".concat(String.valueOf(str)));
                        }
                        if (x5Webview != null) {
                            x5Webview.loadUrl("javascript:".concat(String.valueOf(str)));
                        }
                        AppMethodBeat.o(192956);
                    } catch (Exception e2) {
                        APLog.w(TAG, "h5Init loadJS error:" + e2.toString());
                    }
                }
                AppMethodBeat.o(192956);
            }
        }
    }

    public static synchronized String getJSContent(Context context) {
        String str;
        synchronized (APMidasPayHelper.class) {
            AppMethodBeat.i(192957);
            APLog.i(TAG, "getJSContent");
            init(context, null);
            str = (String) new APMidasPayHelper().callWithContext(context, "getH5JS", new Object[]{context});
            AppMethodBeat.o(192957);
        }
        return str;
    }

    public static void setEnv(String str) {
        AppMethodBeat.i(192958);
        if (!"release".equals(str) && !APMidasPayAPI.ENV_TEST.equals(str) && !APMidasPayAPI.ENV_DEV.equals(str) && !"debug".equals(str) && !APMidasPayAPI.ENV_TESTING.equals(str)) {
            str = "release";
        }
        env = str;
        AppMethodBeat.o(192958);
    }

    public static void setLogEnable(boolean z) {
        logEnable = z;
    }

    public static boolean isLogEnable() {
        return logEnable;
    }

    public void setScreenType(int i2) {
        this.screenType = i2;
    }

    public int pay(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        AppMethodBeat.i(192959);
        APLog.d(TAG, "Calling into pay, caller = " + Thread.currentThread().getStackTrace()[3].toString());
        if (APMidasPayAPI.ENV_TEST.equals(env) && initCount <= 0) {
            Toast.makeText(activity, "腾讯支付尚未初始化，请先调用初始化接口!", 1).show();
        }
        midasCallBack = iAPMidasPayCallBack;
        if (isNewProcess) {
            SharedPreferences.Editor edit = activity.getApplicationContext().getSharedPreferences(APPluginDataInterface.SHARE_PREFERENCE_NAME, 4).edit();
            edit.putString("launchpaycalling", "1");
            edit.commit();
        }
        int midas = toMidas(activity, aPMidasBaseRequest, MED_DISTRIBUTE_PAY, WeChatBrands.Business.GROUP_PAY);
        AppMethodBeat.o(192959);
        return midas;
    }

    public void web(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        AppMethodBeat.i(192960);
        midasCallBack = iAPMidasPayCallBack;
        launchWeb(activity, aPMidasBaseRequest, iAPMidasPayCallBack);
        AppMethodBeat.o(192960);
    }

    public void launchWeb(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        AppMethodBeat.i(192961);
        Intent intent = new Intent();
        intent.setClass(activity, APWebJSBridgeActivity.class);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/midas/control/APMidasPayHelper", "launchWeb", "(Landroid/app/Activity;Lcom/tencent/midas/api/request/APMidasBaseRequest;Lcom/tencent/midas/api/IAPMidasPayCallBack;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/midas/control/APMidasPayHelper", "launchWeb", "(Landroid/app/Activity;Lcom/tencent/midas/api/request/APMidasBaseRequest;Lcom/tencent/midas/api/IAPMidasPayCallBack;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(192961);
    }

    public int h5Pay(Activity activity, WebView webView, com.tencent.smtt.sdk.WebView webView2, String str, String str2) {
        AppMethodBeat.i(192962);
        webview = webView;
        x5Webview = webView2;
        APLog.i(TAG, "h5Pay webview:" + webview + " x5Webview:" + x5Webview + " msg:" + str2);
        if (TextUtils.isEmpty(str2) || !str2.startsWith("midas_js_bridge_")) {
            AppMethodBeat.o(192962);
            return -2;
        }
        int h5Midas = toH5Midas(activity, webView, str, str2, MED_DISTRIBUTE_H5PAY, "h5Pay");
        AppMethodBeat.o(192962);
        return h5Midas;
    }

    public int net(Activity activity, APMidasNetRequest aPMidasNetRequest, IAPMidasNetCallBack iAPMidasNetCallBack) {
        AppMethodBeat.i(192963);
        netCallBack = iAPMidasNetCallBack;
        netCallBack_ReqType = aPMidasNetRequest.reqType;
        int midas = toMidas(activity, aPMidasNetRequest, MED_DISTRIBUTE_NET, "net");
        AppMethodBeat.o(192963);
        return midas;
    }

    public int getInfo(Activity activity, String str, APMidasBaseRequest aPMidasBaseRequest, IAPMidasNetCallBack iAPMidasNetCallBack) {
        AppMethodBeat.i(192964);
        netCallBack = iAPMidasNetCallBack;
        netCallBack_ReqType = str;
        int midas = toMidas(activity, aPMidasBaseRequest, MED_DISTRIBUTE_INFO, "getInfo");
        AppMethodBeat.o(192964);
        return midas;
    }

    public void launchWXMiniProgram(Context context, Bundle bundle, ResultReceiver resultReceiver) {
        AppMethodBeat.i(192965);
        call(context, MED_DISTRIBUTE_WX_MINIPROGRAM, new Class[]{Context.class, Bundle.class, ResultReceiver.class}, new Object[]{context, bundle, resultReceiver});
        AppMethodBeat.o(192965);
    }

    public void launchWXMiniProgram_OnResponse(Context context, int i2, Bundle bundle) {
        AppMethodBeat.i(192966);
        call(context, MED_DISTRIBUTE_WX_MINIPROGRAM_ONRESPONSE, new Class[]{Integer.TYPE, Bundle.class}, new Object[]{Integer.valueOf(i2), bundle});
        AppMethodBeat.o(192966);
    }

    public void sendMidas(final Context context, final Bundle bundle, final ResultReceiver resultReceiver) {
        AppMethodBeat.i(192967);
        waitingPluginReady(context, new ResultReceiver(new Handler(Looper.getMainLooper())) {
            /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i2, Bundle bundle) {
                AppMethodBeat.i(192949);
                if (i2 == 0) {
                    try {
                        APMidasPayHelper.this.retobj = APPluginInterfaceManager.initPluginInterface(context, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_RECEIVE, new Object[]{context, bundle, resultReceiver}, new Class[]{Context.class, Bundle.class, ResultReceiver.class});
                        AppMethodBeat.o(192949);
                    } catch (Exception e2) {
                        APLog.e(APMidasPayHelper.TAG, "sendMidas() e = " + e2.toString());
                        AppMethodBeat.o(192949);
                    }
                } else {
                    if (resultReceiver != null) {
                        String string = bundle.getString("__midas_ability_baseReq__postBack");
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("midas_callback_ability_postBack", string);
                        bundle2.putInt("midas_callback_ability_code", -1999);
                        bundle2.putString("midas_callback_ability_msg", "MidasPlugin load failure");
                        bundle2.putBundle("midas_callback_ability_data", bundle);
                        resultReceiver.send(-1, bundle2);
                    }
                    AppMethodBeat.o(192949);
                }
            }
        });
        AppMethodBeat.o(192967);
    }

    public Object call(Activity activity, String str, Object[] objArr) {
        AppMethodBeat.i(192968);
        Object callWithContext = callWithContext(activity, str, objArr);
        AppMethodBeat.o(192968);
        return callWithContext;
    }

    public Object call(Activity activity, String str, Object[] objArr, Class<?>[] clsArr) {
        AppMethodBeat.i(192969);
        Object callWithContext = callWithContext(activity, str, objArr, clsArr);
        AppMethodBeat.o(192969);
        return callWithContext;
    }

    public Object call(Context context, String str, Class<?>[] clsArr, Object[] objArr) {
        AppMethodBeat.i(192970);
        Object callWithContext = callWithContext(context, str, objArr, clsArr);
        AppMethodBeat.o(192970);
        return callWithContext;
    }

    private void waitingPluginReady(Context context, final ResultReceiver resultReceiver) {
        AppMethodBeat.i(192971);
        if (APMidasPayAPI.ENV_TEST.equals(env) && initCount <= 0) {
            Toast.makeText(context, "腾讯支付尚未初始化，请先调用初始化接口!", 1).show();
        }
        if (isNewProcess) {
            SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(APPluginDataInterface.SHARE_PREFERENCE_NAME, 4).edit();
            edit.putString("launchpaycalling", "1");
            edit.commit();
        }
        APLog.i(TAG, "ToMidas initState = " + initState);
        synchronized (initObject) {
            try {
                final ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setIndeterminate(false);
                progressDialog.setProgressStyle(0);
                progressDialog.setTitle("温馨提示");
                progressDialog.setMessage("腾讯支付服务初始化中");
                final long currentTimeMillis = System.currentTimeMillis();
                boolean isNeedUpdateFromLocal = APPluginInstallerAndUpdater.isNeedUpdateFromLocal(context);
                isNeedLocalUpdate = isNeedUpdateFromLocal;
                if (isNeedUpdateFromLocal) {
                    synchronized (initObject) {
                        try {
                            initState = -1;
                        } catch (Throwable th) {
                            AppMethodBeat.o(192971);
                            throw th;
                        }
                    }
                }
                if ((initState == -1 || initState == 0) && !MED_DISTRIBUTE_NET.equals("launchFunction") && !MED_DISTRIBUTE_INFO.equals("launchFunction")) {
                    try {
                        progressDialog.show();
                    } catch (Throwable th2) {
                    }
                }
                if (initState == -1) {
                    if (isNeedLocalUpdate) {
                        release(context);
                    }
                    preLoadPlugin(context, "launchFunction", null);
                }
                if (initState == 0) {
                    new Thread(new Runnable() {
                        /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass6 */

                        public void run() {
                            AppMethodBeat.i(192942);
                            try {
                                synchronized (APMidasPayHelper.loadingObject) {
                                    try {
                                        APMidasPayHelper.loadingObject.wait();
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(192942);
                                        throw th;
                                    }
                                }
                            } catch (InterruptedException e2) {
                                APLog.w(APMidasPayHelper.TAG, e2.toString());
                            }
                            try {
                                if (progressDialog.isShowing()) {
                                    progressDialog.dismiss();
                                }
                            } catch (Throwable th2) {
                            }
                            APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY_WAIT_INIT, currentTimeMillis);
                            resultReceiver.send(0, new Bundle());
                            AppMethodBeat.o(192942);
                        }
                    }).start();
                } else {
                    resultReceiver.send(0, new Bundle());
                }
            } finally {
                AppMethodBeat.o(192971);
            }
        }
    }

    public Object callWithContext(Context context, String str, Object[] objArr) {
        AppMethodBeat.i(192972);
        Object obj = null;
        try {
            obj = APPluginInterfaceManager.initPluginInterface(context, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, MED_DISTRIBUTE_CALL, new Object[]{str, objArr});
        } catch (Exception e2) {
            APLog.i(TAG, "callWithContext error:" + e2.toString());
        }
        AppMethodBeat.o(192972);
        return obj;
    }

    public Object callWithContext(final Context context, final String str, final Object[] objArr, final Class<?>[] clsArr) {
        AppMethodBeat.i(192973);
        synchronized (initObject) {
            try {
                APLog.i("callWithContext ", "initState:" + initState);
                if (initState == 0) {
                    new Thread(new Runnable() {
                        /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass7 */

                        public void run() {
                            AppMethodBeat.i(192937);
                            try {
                                APLog.d("callWithContext ", "PLUGIN_INITING wait");
                                synchronized (APMidasPayHelper.dexloadObject) {
                                    try {
                                        APMidasPayHelper.dexloadObject.wait();
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(192937);
                                        throw th;
                                    }
                                }
                                APLog.d("callWithContext ", "PLUGIN_INITING go");
                                ((Activity) context).runOnUiThread(new Runnable() {
                                    /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass7.AnonymousClass1 */

                                    public void run() {
                                        AppMethodBeat.i(192938);
                                        try {
                                            APMidasPayHelper.this.retobj = APPluginInterfaceManager.initPluginInterface2(context, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_CALL2, new Object[]{str, objArr, clsArr});
                                            AppMethodBeat.o(192938);
                                        } catch (Exception e2) {
                                            APLog.e("callWithContext", "error1 " + e2.toString());
                                            AppMethodBeat.o(192938);
                                        }
                                    }
                                });
                                AppMethodBeat.o(192937);
                            } catch (InterruptedException e2) {
                                APLog.e("callWithContext", "error2 " + e2.toString());
                                AppMethodBeat.o(192937);
                            } catch (Throwable th2) {
                                APLog.e("callWithContext", "error3 " + th2.toString());
                                AppMethodBeat.o(192937);
                            }
                        }
                    }).start();
                } else {
                    try {
                        this.retobj = APPluginInterfaceManager.initPluginInterface2(context, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, MED_DISTRIBUTE_CALL2, new Object[]{str, objArr, clsArr});
                    } catch (Exception e2) {
                        APLog.e("callWithContext", "error3 " + e2.toString());
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(192973);
                throw th;
            }
        }
        Object obj = this.retobj;
        AppMethodBeat.o(192973);
        return obj;
    }

    private int toMidas(final Activity activity, final APMidasBaseRequest aPMidasBaseRequest, final String str, final String str2) {
        AppMethodBeat.i(192974);
        if (aPMidasBaseRequest == null) {
            APLog.w(TAG, "toMidas pay request is null");
            AppMethodBeat.o(192974);
            return -1;
        }
        requestObject = aPMidasBaseRequest;
        staticActivityContext = activity;
        APLog.i(TAG, "ToMidas initState = " + initState);
        synchronized (initObject) {
            try {
                final ProgressDialog progressDialog = new ProgressDialog(activity);
                progressDialog.setIndeterminate(false);
                progressDialog.setProgressStyle(0);
                progressDialog.setTitle("温馨提示");
                progressDialog.setMessage("腾讯支付服务初始化中");
                final long currentTimeMillis = System.currentTimeMillis();
                boolean isNeedUpdateFromLocal = APPluginInstallerAndUpdater.isNeedUpdateFromLocal(activity);
                isNeedLocalUpdate = isNeedUpdateFromLocal;
                if (isNeedUpdateFromLocal) {
                    synchronized (initObject) {
                        try {
                            initState = -1;
                        } catch (Throwable th) {
                            AppMethodBeat.o(192974);
                            throw th;
                        }
                    }
                }
                if ((initState == -1 || initState == 0) && !MED_DISTRIBUTE_NET.equals(str) && !MED_DISTRIBUTE_INFO.equals(str)) {
                    try {
                        progressDialog.show();
                    } catch (Throwable th2) {
                    }
                }
                if (initState == -1) {
                    if (isNeedLocalUpdate) {
                        release(activity);
                    }
                    preLoadPlugin(activity, str2, null);
                }
                if (initState == 0) {
                    new Thread(new Runnable() {
                        /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass8 */

                        public void run() {
                            AppMethodBeat.i(192995);
                            try {
                                synchronized (APMidasPayHelper.loadingObject) {
                                    try {
                                        APMidasPayHelper.loadingObject.wait();
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(192995);
                                        throw th;
                                    }
                                }
                            } catch (InterruptedException e2) {
                                APLog.w(APMidasPayHelper.TAG, e2.toString());
                            }
                            try {
                                if (progressDialog.isShowing()) {
                                    progressDialog.dismiss();
                                }
                            } catch (Throwable th2) {
                            }
                            APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY_WAIT_INIT, currentTimeMillis);
                            APMidasPayHelper.access$700(APMidasPayHelper.this, activity, aPMidasBaseRequest, str, str2);
                            AppMethodBeat.o(192995);
                        }
                    }).start();
                    AppMethodBeat.o(192974);
                    return 0;
                }
                return toMidasPay(activity, aPMidasBaseRequest, str, str2);
            } finally {
                AppMethodBeat.o(192974);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r6.runOnUiThread(new com.tencent.midas.control.APMidasPayHelper.AnonymousClass9(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        com.tencent.midas.control.APMidasPayHelper.requestObject = r7;
        com.tencent.midas.control.APMidasPayHelper.staticActivityContext = r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int toMidasPay(final android.app.Activity r6, final com.tencent.midas.api.request.APMidasBaseRequest r7, final java.lang.String r8, java.lang.String r9) {
        /*
            r5 = this;
            r0 = -1
            r4 = 192975(0x2f1cf, float:2.70416E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.lang.Object r1 = com.tencent.midas.control.APMidasPayHelper.initObject
            monitor-enter(r1)
            int r2 = com.tencent.midas.control.APMidasPayHelper.initState     // Catch:{ all -> 0x0035 }
            r3 = 2
            if (r2 != r3) goto L_0x0023
            java.lang.String r2 = "APMidasPayHelper"
            java.lang.String r3 = "toMidasPay plugin init error"
            com.tencent.midas.comm.APLog.i(r2, r3)     // Catch:{ all -> 0x0035 }
            r5.pluginInitErrCallBack(r6)     // Catch:{ all -> 0x0035 }
            r2 = -1
            com.tencent.midas.control.APMidasPayHelper.initState = r2     // Catch:{ all -> 0x0035 }
            monitor-exit(r1)     // Catch:{ all -> 0x0035 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0022:
            return r0
        L_0x0023:
            monitor-exit(r1)
            com.tencent.midas.control.APMidasPayHelper.requestObject = r7
            com.tencent.midas.control.APMidasPayHelper.staticActivityContext = r6
            com.tencent.midas.control.APMidasPayHelper$9 r0 = new com.tencent.midas.control.APMidasPayHelper$9     // Catch:{ Exception -> 0x003b }
            r0.<init>(r7, r8, r6)     // Catch:{ Exception -> 0x003b }
            r6.runOnUiThread(r0)     // Catch:{ Exception -> 0x003b }
        L_0x0030:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0022
        L_0x0035:
            r0 = move-exception
            monitor-exit(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x003b:
            r0 = move-exception
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.control.APMidasPayHelper.toMidasPay(android.app.Activity, com.tencent.midas.api.request.APMidasBaseRequest, java.lang.String, java.lang.String):int");
    }

    private int toH5Midas(final Activity activity, WebView webView, final String str, final String str2, final String str3, String str4) {
        AppMethodBeat.i(192976);
        APLog.i(TAG, "toH5Midas initState: " + initState);
        synchronized (initObject) {
            try {
                final ProgressDialog progressDialog = new ProgressDialog(activity);
                progressDialog.setIndeterminate(false);
                progressDialog.setProgressStyle(0);
                progressDialog.setTitle("温馨提示");
                progressDialog.setMessage("腾讯支付服务初始化中");
                if (initState == -1 || initState == 0) {
                    try {
                        progressDialog.show();
                    } catch (Throwable th) {
                    }
                }
                if (initState == -1) {
                    preLoadPlugin(activity, str4, null);
                }
                if (initState == 0) {
                    new Thread(new Runnable() {
                        /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass10 */

                        public void run() {
                            AppMethodBeat.i(192947);
                            try {
                                synchronized (APMidasPayHelper.loadingObject) {
                                    try {
                                        APMidasPayHelper.loadingObject.wait();
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(192947);
                                        throw th;
                                    }
                                }
                            } catch (InterruptedException e2) {
                                APLog.w(APMidasPayHelper.TAG, "toH5Midas e:" + e2.toString());
                            }
                            try {
                                if (progressDialog.isShowing()) {
                                    progressDialog.dismiss();
                                }
                            } catch (Throwable th2) {
                            }
                            APMidasPayHelper.access$1100(APMidasPayHelper.this, activity, str, str2, str3);
                            AppMethodBeat.o(192947);
                        }
                    }).start();
                    AppMethodBeat.o(192976);
                    return 0;
                }
                return toH5MidasPay(activity, str, str2, str3);
            } finally {
                AppMethodBeat.o(192976);
            }
        }
    }

    private int toH5MidasPay(final Activity activity, final String str, final String str2, final String str3) {
        AppMethodBeat.i(192977);
        synchronized (initObject) {
            try {
                if (initState == 2) {
                    APLog.i(TAG, "toH5MidasPay plugin init error");
                    pluginInitErrCallBack(activity);
                    initState = -1;
                    return -1;
                }
                activity.runOnUiThread(new Runnable() {
                    /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass11 */

                    public void run() {
                        AppMethodBeat.i(192946);
                        Intent intent = new Intent();
                        intent.putExtra("version", APMidasPayAPI.getMidasPluginVersion());
                        intent.putExtra("env", APMidasPayHelper.env);
                        intent.putExtra("screenType", APMidasPayHelper.this.screenType);
                        intent.putExtra("logEnable", APMidasPayHelper.logEnable);
                        intent.putExtra("req", "H5Pay");
                        intent.putExtra("url", str);
                        intent.putExtra("message", str2);
                        intent.putExtra("reqType", APMidasPayHelper.netCallBack_ReqType);
                        try {
                            APMultiProcessData processData = APPluginDataInterface.singleton().getProcessData();
                            if (processData != null) {
                                intent.putExtra("launchPayGUID", processData.getGuid());
                                intent.putExtra("launchPayTime", processData.getPayInterfaceTime());
                                intent.putExtra("launchPayDataid", APDataId.getDataId());
                                intent.putExtra("launchIntervalTime", processData.getIntervalTime());
                            }
                        } catch (Exception e2) {
                        }
                        if (APMidasPayHelper.isNewProcess) {
                            APCallBackResultReceiver unused = APMidasPayHelper.remotRecevier = new APCallBackResultReceiver(new Handler());
                            APMidasPayHelper.remotRecevier.setReceiver(APMidasPayHelper.this);
                            intent.putExtra("remoteReceiver", APMidasPayHelper.remotRecevier);
                        }
                        APMidasPayHelper.access$1000(APMidasPayHelper.this, activity, intent, str3);
                        AppMethodBeat.o(192946);
                    }
                });
                AppMethodBeat.o(192977);
                return 0;
            } finally {
                AppMethodBeat.o(192977);
            }
        }
    }

    private void openPlugin(Activity activity, Intent intent, String str) {
        Object obj;
        AppMethodBeat.i(192978);
        APLog.d(TAG, "Calling into openPlugin, method = " + str + " caller = " + Thread.currentThread().getStackTrace()[3].toString());
        try {
            obj = APPluginInterfaceManager.initPluginInterface(activity, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, str, new Object[]{activity, intent});
        } catch (Exception e2) {
            obj = null;
        }
        try {
            APPluginReportManager.getInstance().dataReport(APPluginDataInterface.singleton().getLaunchInterface());
        } catch (Exception e3) {
            APLog.i(TAG, "openPlugin dataReport:" + e3.toString());
        }
        APLog.i(TAG, "openPlugin obj:".concat(String.valueOf(obj)));
        AppMethodBeat.o(192978);
    }

    private static void preLoadPlugin(final Context context, final String str, final IAPInitCallBack iAPInitCallBack) {
        AppMethodBeat.i(192979);
        synchronized (initObject) {
            try {
                initState = 0;
            } catch (Throwable th) {
                AppMethodBeat.o(192979);
                throw th;
            }
        }
        Thread thread = new Thread(new Runnable() {
            /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(192941);
                APMidasPayHelper.access$1200(context, str, iAPInitCallBack);
                AppMethodBeat.o(192941);
            }
        });
        thread.setName(APPluginDataInterface.singleton().getLaunchInterface());
        thread.start();
        AppMethodBeat.o(192979);
    }

    private static void preLoadMidasPay(final Context context, final String str, final IAPInitCallBack iAPInitCallBack) {
        int i2 = 0;
        AppMethodBeat.i(192980);
        APLog.d(TAG, "Calling into preLoadMidasPay " + Thread.currentThread().getStackTrace()[3].toString());
        System.currentTimeMillis();
        if (isNeedLocalUpdate) {
            APLog.d(TAG, "Calling into preLoadMidasPay isNeedLocalUpdate == true");
            APPluginInstallerAndUpdater.installFromLocal(context);
            APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_INSTALL_FROM_LOCAL, System.currentTimeMillis());
            isNeedLocalUpdate = false;
        } else {
            APLog.d(TAG, "Calling into preLoadMidasPay isNeedLocalUpdate == false");
        }
        long currentTimeMillis = System.currentTimeMillis();
        int isNeedUpdateFromAssets = APPluginInstallerAndUpdater.isNeedUpdateFromAssets(context);
        APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_IS_NEED_ASSETS_UPDATE, currentTimeMillis);
        APLog.d(TAG, "preLoadMidasPay isNeedUpdateFromAssets = ".concat(String.valueOf(isNeedUpdateFromAssets)));
        if (isNeedUpdateFromAssets > 0) {
            long currentTimeMillis2 = System.currentTimeMillis();
            i2 = APPluginInstallerAndUpdater.installPlugin(context, isNeedUpdateFromAssets);
            APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_INSTALL_FROM_ASSETS, currentTimeMillis2);
        }
        APLog.i(TAG, "preLoadMidasPay installPlugin ret:" + i2 + " initRequest:" + initRequest);
        synchronized (initObject) {
            if (i2 != 0) {
                try {
                    initCount = 0;
                    initState = 2;
                    if (iAPInitCallBack != null) {
                        iAPInitCallBack.result(-1, APPluginUtils.getInitErrorMsg(), str, null);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(192980);
                    throw th;
                }
            } else {
                long currentTimeMillis3 = System.currentTimeMillis();
                boolean isPluginValid = APPluginChecker.isPluginValid(context);
                APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_PLUGIN_VALID, currentTimeMillis3);
                if (!isPluginValid) {
                    APLog.i(TAG, "preLoadMidasPay isPluginValid false");
                    APPluginInstallerAndUpdater.unInstallPlugin(context);
                    initState = -1;
                    if (iAPInitCallBack != null) {
                        initCount = 0;
                        iAPInitCallBack.result(-1, "支付插件校验失败", str, null);
                    }
                    synchronized (loadingObject) {
                        try {
                            loadingObject.notifyAll();
                        } catch (Throwable th2) {
                            AppMethodBeat.o(192980);
                            throw th2;
                        }
                    }
                } else {
                    try {
                        long currentTimeMillis4 = System.currentTimeMillis();
                        APPluginLoader.preCreateClassLoaderByPath(context);
                        APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_LOAD_DEX, currentTimeMillis4);
                    } catch (Exception e2) {
                        APLog.e(TAG, "preLoadMidasPay preCreateClassLoaderByPath e: " + e2.toString());
                    }
                    final String name = Thread.currentThread().getName();
                    if (context instanceof Activity) {
                        ((Activity) context).runOnUiThread(new Runnable() {
                            /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass13 */

                            /* JADX WARNING: Removed duplicated region for block: B:18:0x00b2  */
                            /* JADX WARNING: Removed duplicated region for block: B:9:0x00a0 A[SYNTHETIC, Splitter:B:9:0x00a0] */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void run() {
                                /*
                                // Method dump skipped, instructions count: 199
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.control.APMidasPayHelper.AnonymousClass13.run():void");
                            }
                        });
                    } else {
                        initState = 1;
                        synchronized (loadingObject) {
                            try {
                                loadingObject.notifyAll();
                            } catch (Throwable th3) {
                                AppMethodBeat.o(192980);
                                throw th3;
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(192980);
    }

    public static void midasCallBack(APMidasResponse aPMidasResponse) {
        AppMethodBeat.i(192981);
        if (aPMidasResponse == null || aPMidasResponse.resultCode != -100011 || !RET_MSG_CHANGE_H5.equals(aPMidasResponse.resultMsg) || !APWebJSBridgeActivity.startPureH5Pay(staticActivityContext, "", "change_h5_from_cgi")) {
            APLog.i(TAG, "midasCallBack resultCode :" + aPMidasResponse.resultCode + " midasCallBack:" + midasCallBack);
            if (midasCallBack != null) {
                midasCallBack.MidasPayCallBack(aPMidasResponse);
                midasCallBack = null;
            }
            if (remotRecevier != null) {
                remotRecevier.setReceiver(null);
                remotRecevier = null;
            }
            APPluginReportManager.getInstance().dataReport(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
            requestObject = null;
            APPluginUtils.release();
            APLog.closeLog();
            staticActivityContext = null;
            AppMethodBeat.o(192981);
            return;
        }
        staticActivityContext = null;
        AppMethodBeat.o(192981);
    }

    public static void midasLoginExpire() {
        AppMethodBeat.i(192982);
        if (midasCallBack != null) {
            midasCallBack.MidasPayNeedLogin();
            midasCallBack = null;
        }
        if (remotRecevier != null) {
            remotRecevier.setReceiver(null);
            remotRecevier = null;
        }
        APPluginReportManager.getInstance().dataReport(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
        APPluginUtils.release();
        APLog.closeLog();
        staticActivityContext = null;
        requestObject = null;
        AppMethodBeat.o(192982);
    }

    public static void midasH5CallBack(String str) {
        AppMethodBeat.i(192983);
        APLog.i(TAG, "midasH5CallBack params:" + str + " webview:" + webview + " x5Webview:" + x5Webview);
        if (webview != null) {
            try {
                webview.loadUrl(str);
            } catch (Exception e2) {
                APLog.w(TAG, "midasH5CallBack error:" + e2.toString());
            }
        }
        if (x5Webview != null) {
            try {
                x5Webview.loadUrl(str);
            } catch (Exception e3) {
                APLog.w(TAG, "midasH5CallBack error:" + e3.toString());
            }
        }
        if (remotRecevier != null) {
            remotRecevier.setReceiver(null);
            remotRecevier = null;
        }
        APPluginReportManager.getInstance().dataReport(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
        APPluginUtils.release();
        APLog.closeLog();
        staticActivityContext = null;
        requestObject = null;
        AppMethodBeat.o(192983);
    }

    public static void onNetError(String str, Integer num, String str2) {
        AppMethodBeat.i(192984);
        if (netCallBack != null) {
            netCallBack.MidasNetError(str, num.intValue(), str2);
            netCallBack = null;
            netCallBack_ReqType = "";
        }
        staticActivityContext = null;
        AppMethodBeat.o(192984);
    }

    public static void onNetStop(String str) {
        AppMethodBeat.i(192985);
        if (netCallBack != null) {
            netCallBack.MidasNetStop(str);
            netCallBack = null;
            netCallBack_ReqType = "";
        }
        staticActivityContext = null;
        AppMethodBeat.o(192985);
    }

    public static void onNetFinish(String str, String str2) {
        AppMethodBeat.i(192986);
        if (netCallBack != null) {
            netCallBack.MidasNetFinish(str, str2);
            netCallBack = null;
            netCallBack_ReqType = "";
        }
        staticActivityContext = null;
        AppMethodBeat.o(192986);
    }

    private void pluginInitErrCallBack(final Activity activity) {
        AppMethodBeat.i(192987);
        APLog.i(TAG, "pluginInitErrCallBack" + midasCallBack);
        if (APWebJSBridgeActivity.startPureH5Pay(activity, APPluginUtils.getInitErrorMsg(), "pluginInitErrCallBack")) {
            AppMethodBeat.o(192987);
            return;
        }
        activity.runOnUiThread(new Runnable() {
            /* class com.tencent.midas.control.APMidasPayHelper.AnonymousClass14 */

            public void run() {
                AppMethodBeat.i(192943);
                APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_ERROR, "", APPluginUtils.getInitErrorMsg());
                Toast.makeText(activity, "腾讯支付服务加载失败，请退出重试", 1).show();
                APMidasResponse aPMidasResponse = new APMidasResponse();
                aPMidasResponse.resultCode = -100;
                if (APMidasPayHelper.midasCallBack != null) {
                    APMidasPayHelper.midasCallBack.MidasPayCallBack(aPMidasResponse);
                    APMidasPayHelper.midasCallBack = null;
                    APMidasPayHelper.requestObject = null;
                    APMidasPayHelper.staticActivityContext = null;
                }
                if (APMidasPayHelper.netCallBack != null) {
                    APMidasPayHelper.netCallBack.MidasNetError(APMidasPayHelper.netCallBack_ReqType, -100, "腾讯支付服务加载失败，请退出重试");
                    APMidasPayHelper.netCallBack = null;
                    String unused = APMidasPayHelper.netCallBack_ReqType = "";
                    APMidasPayHelper.requestObject = null;
                    APMidasPayHelper.staticActivityContext = null;
                }
                APPluginReportManager.getInstance().dataReport(APPluginDataInterface.singleton().getLaunchInterface());
                AppMethodBeat.o(192943);
            }
        });
        AppMethodBeat.o(192987);
    }

    public static void release(Context context) {
        AppMethodBeat.i(192988);
        APLog.d(TAG, "release");
        APPluginInstallerAndUpdater.unInstallPlugin(context);
        synchronized (initObject) {
            try {
                initState = -1;
            } finally {
                AppMethodBeat.o(192988);
            }
        }
    }

    public static boolean isNewProcess(Context context) {
        AppMethodBeat.i(192989);
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageManager.getPackageInfo(context.getApplicationContext().getPackageName(), 0).packageName, 1).activities;
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (activityInfo.name.equals("com.tencent.midas.proxyactivity.APMidasPayProxyActivity")) {
                    String str = activityInfo.processName;
                    if (!TextUtils.isEmpty(str) && str.contains("midasPay")) {
                        AppMethodBeat.o(192989);
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(192989);
        return false;
    }
}
