package com.tencent.midas.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.Toast;
import com.pay.tool.APMidasCommMethod;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.ability.MidasBaseAbility;
import com.tencent.midas.api.request.APIabResult;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.midas.api.request.APMidasNetRequest;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.api.request.APQueryInventoryFinishedListener;
import com.tencent.midas.api.request.OnAPConsumeFinishedListener;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogUtil;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.plugin.APPluginLoader;
import com.tencent.midas.plugin.APPluginStatic;
import com.tencent.midas.plugin.APPluginUtils;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class APMidasPayAPI {
    public static final String ACCOUNT_TYPE_COMMON = "common";
    public static final String ACCOUNT_TYPE_SECURITY = "secrety";
    public static final String ENV_DEV = "dev";
    public static final String ENV_RELEASE = "release";
    public static final String ENV_TEST = "test";
    public static final String ENV_TESTING = "testing";
    public static final int LANDSCAPE = 0;
    public static final String PAY_CHANNEL_BANK = "bank";
    public static final String PAY_CHANNEL_QQWALLET = "qqwallet";
    public static final String PAY_CHANNEL_WECHAT = "wechat";
    public static final int PORTRAINT = 1;
    private static final String TAG = "APMidasPayAPI";
    public static final String WX_COUPONS = "wechatAddCardToWXCardPackage";
    private static String dataPath = "";
    public static String env = "release";
    public static Context fromContext = null;
    private static boolean logEnable = true;
    private static int screenType = -1;

    public static void setParentClassloader(DexClassLoader dexClassLoader) {
        AppMethodBeat.i(192892);
        APLog.i(TAG, "setParentClassloader enter classLoader:".concat(String.valueOf(dexClassLoader)));
        APPluginLoader.setParentClassLoader(dexClassLoader);
        AppMethodBeat.o(192892);
    }

    public static void init(Context context, APMidasBaseRequest aPMidasBaseRequest) {
        AppMethodBeat.i(192893);
        APPluginReportManager.initDataRelease();
        APPluginReportManager.getInstance().initInterfaceInit(APMidasPluginInfo.LAUNCH_INTERFACE_INIT, aPMidasBaseRequest);
        APLogUtil.initAPLogInPlugin(context.getApplicationContext(), logEnable);
        APLog.i(TAG, "init new enter");
        APPluginReportManager.getInstance().insertTimeData(APMidasPluginInfo.LAUNCH_INTERFACE_INIT, APPluginReportManager.MIDASPLUGIN_TIMENAME_INIT);
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        if (checkInitCommParam(context, aPMidasBaseRequest)) {
            APMidasPayHelper.init(context, aPMidasBaseRequest);
            AppMethodBeat.o(192893);
            return;
        }
        APMidasPayHelper.isNewProcess = APMidasPayHelper.isNewProcess(context);
        AppMethodBeat.o(192893);
    }

    public static void release(Activity activity) {
        AppMethodBeat.i(192894);
        APLog.i(TAG, "release() enter");
        new APMidasPayHelper().call(activity, APMidasPayHelper.MED_DISTRIBUTE_RELEASE, new Object[0]);
        AppMethodBeat.o(192894);
    }

    private static boolean checkParams(Context context) {
        AppMethodBeat.i(192895);
        if (context == null) {
            APLog.e(TAG, "checkParams() context/activity == Null");
            new Throwable("APMidasPayAPI().checkParams() context/activity == Null");
            AppMethodBeat.o(192895);
            return false;
        }
        AppMethodBeat.o(192895);
        return true;
    }

    public static void h5PayInitUnifier(Activity activity, IAPWebView iAPWebView) {
        AppMethodBeat.i(192896);
        APLog.i(TAG, "h5PayInitUnifier enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192896);
            return;
        }
        APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_OUT_WEBVIEW;
        APMidasPayHelper.h5InitUnifier(activity, iAPWebView);
        AppMethodBeat.o(192896);
    }

    public static void h5PayInit(Activity activity, WebView webView) {
        AppMethodBeat.i(192897);
        APLog.i(TAG, "h5PayInit enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192897);
            return;
        }
        APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_OUT_WEBVIEW;
        APMidasPayHelper.h5Init(activity, webView, null);
        AppMethodBeat.o(192897);
    }

    public static void InnerH5PayInit(Activity activity, WebView webView) {
        AppMethodBeat.i(192898);
        APLog.i(TAG, "InnerH5PayInit enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192898);
            return;
        }
        APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_INNER_WEBVIEW;
        APMidasPayHelper.h5Init(activity, webView, null);
        AppMethodBeat.o(192898);
    }

    public static void h5PayInitX5(Activity activity, com.tencent.smtt.sdk.WebView webView) {
        AppMethodBeat.i(192899);
        APLog.i(TAG, "h5PayInitX5 enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192899);
            return;
        }
        APMidasPayHelper.h5Init(activity, null, webView);
        AppMethodBeat.o(192899);
    }

    public static void InnerH5PayInitX5(Activity activity, com.tencent.smtt.sdk.WebView webView) {
        AppMethodBeat.i(192900);
        APLog.i(TAG, "InnerH5PayInit enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192900);
            return;
        }
        APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_INNER_WEBVIEW;
        APMidasPayHelper.h5Init(activity, null, webView);
        AppMethodBeat.o(192900);
    }

    public static String getJSContent(Context context) {
        AppMethodBeat.i(192901);
        APLog.i(TAG, "getJSContent enter");
        if (!checkParams(context)) {
            AppMethodBeat.o(192901);
            return "";
        }
        String jSContent = APMidasPayHelper.getJSContent(context);
        AppMethodBeat.o(192901);
        return jSContent;
    }

    public static int h5PayHook(Activity activity, WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(192902);
        APLog.i(TAG, "h5PayHook enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192902);
            return -33;
        }
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        aPMidasPayHelper.setScreenType(screenType);
        int h5Pay = aPMidasPayHelper.h5Pay(activity, webView, null, str, str2);
        AppMethodBeat.o(192902);
        return h5Pay;
    }

    public static int h5PayHookX5(Activity activity, com.tencent.smtt.sdk.WebView webView, String str, String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        AppMethodBeat.i(192903);
        APLog.i(TAG, "h5PayHookX5 enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192903);
            return -33;
        }
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        aPMidasPayHelper.setScreenType(screenType);
        int h5Pay = aPMidasPayHelper.h5Pay(activity, null, webView, str, str2);
        AppMethodBeat.o(192903);
        return h5Pay;
    }

    public static void setEnv(String str) {
        Method method;
        Object obj;
        Method method2 = null;
        AppMethodBeat.i(192904);
        env = str;
        try {
            Class<?> cls = Class.forName("com.pay.tool.APAppDataInterface");
            if (cls != null) {
                try {
                    method = cls.getDeclaredMethod("singleton", new Class[0]);
                } catch (NoSuchMethodException e2) {
                    APLog.d(TAG, "com.pay.tool.APAppDataInterface ClassNotFound");
                    method = null;
                }
                try {
                    obj = method.invoke(null, new Object[0]);
                } catch (Exception e3) {
                    APLog.d(TAG, "com.pay.tool.APAppDataInterface invoke error");
                    obj = null;
                }
                try {
                    method2 = cls.getMethod("setEnv", String.class);
                } catch (NoSuchMethodException e4) {
                    APLog.d(TAG, "setEnv no such method");
                }
                try {
                    method2.invoke(obj, str);
                } catch (Exception e5) {
                    APLog.d(TAG, "setEnv invoke error " + e5.toString());
                }
            }
        } catch (Exception e6) {
            APLog.d(TAG, "setEnv exception e:" + e6.toString());
        }
        APLog.d("MidasPluginSDK", "env= " + env);
        AppMethodBeat.o(192904);
    }

    public static void setLogEnable(boolean z) {
        logEnable = z;
    }

    public static String getMidasPluginVersion() {
        String str;
        AppMethodBeat.i(192905);
        APLog.d(TAG, "getMidasPluginVersion enter " + Thread.currentThread().getStackTrace()[3].toString());
        if (APMidasCommMethod.getApplicationPackageName().equals("com.tencent.unipay")) {
            str = APMidasCommMethod.getApplicationVersion();
        } else {
            str = "1.7.1f";
        }
        AppMethodBeat.o(192905);
        return str;
    }

    public static String getMidasCoreVersion(Activity activity) {
        AppMethodBeat.i(192906);
        APLog.i(TAG, "getMidasCoreVersion enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192906);
            return "";
        }
        String midasCoreVersionName = APPluginUtils.getMidasCoreVersionName(activity);
        AppMethodBeat.o(192906);
        return midasCoreVersionName;
    }

    public static String getMidasSDKVersion(Activity activity) {
        AppMethodBeat.i(192907);
        APLog.i(TAG, "getMidasSDKVersion enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192907);
            return "";
        }
        String str = (String) new APMidasPayHelper().call(activity, Thread.currentThread().getStackTrace()[2].getMethodName(), new Object[0]);
        AppMethodBeat.o(192907);
        return str;
    }

    public static void setScreenType(Activity activity, int i2) {
        screenType = i2;
    }

    public static String getPath() {
        return dataPath;
    }

    public static void setPath(String str) {
        AppMethodBeat.i(192908);
        APLog.i(TAG, "setPath enter path:".concat(String.valueOf(str)));
        dataPath = str;
        AppMethodBeat.o(192908);
    }

    public static void launchPay(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        AppMethodBeat.i(192909);
        APLog.i(TAG, "launchPay enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192909);
            return;
        }
        try {
            fromContext = activity.getApplicationContext();
        } catch (Exception e2) {
            APLog.i("fromContext", e2.toString());
        }
        if (APMidasTools.isFastClick()) {
            APLog.i("launchPay", "isfast");
            APLog.w(TAG, "launchPay enter fast:".concat(String.valueOf(iAPMidasPayCallBack)));
            APMidasResponse aPMidasResponse = new APMidasResponse();
            aPMidasResponse.resultCode = -1;
            aPMidasResponse.payChannel = -1;
            aPMidasResponse.payState = 2;
            aPMidasResponse.provideState = -1;
            aPMidasResponse.resultMsg = "fast click";
            iAPMidasPayCallBack.MidasPayCallBack(aPMidasResponse);
            AppMethodBeat.o(192909);
            return;
        }
        APPluginReportManager.payDataRelease();
        APPluginReportManager.getInstance().payInterfaceInit(aPMidasBaseRequest, APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
        APPluginReportManager.getInstance().insertTimeData(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY);
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        aPMidasPayHelper.setScreenType(screenType);
        aPMidasPayHelper.pay(activity, aPMidasBaseRequest, iAPMidasPayCallBack);
        AppMethodBeat.o(192909);
    }

    public static void launchWeb(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        AppMethodBeat.i(192910);
        APLog.i(TAG, "launchWeb enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192910);
            return;
        }
        try {
            fromContext = activity.getApplicationContext();
        } catch (Exception e2) {
            APLog.i("fromContext", e2.toString());
        }
        APPluginReportManager.payDataRelease();
        APPluginReportManager.getInstance().payInterfaceInit(aPMidasBaseRequest, APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHWEB);
        APPluginReportManager.getInstance().insertTimeData(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHWEB, APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHWEB);
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        aPMidasPayHelper.setScreenType(screenType);
        aPMidasPayHelper.web(activity, aPMidasBaseRequest, iAPMidasPayCallBack);
        AppMethodBeat.o(192910);
    }

    public static void launchNet(Activity activity, APMidasNetRequest aPMidasNetRequest, IAPMidasNetCallBack iAPMidasNetCallBack) {
        AppMethodBeat.i(192911);
        APLog.i(TAG, "launchNet enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192911);
            return;
        }
        try {
            fromContext = activity.getApplicationContext();
        } catch (Exception e2) {
            APLog.i("fromContext", e2.toString());
        }
        APPluginReportManager.payDataRelease();
        APPluginReportManager.getInstance().payInterfaceInit(aPMidasNetRequest, APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHNET);
        APPluginReportManager.getInstance().insertTimeData(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHNET, APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHNET);
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        aPMidasPayHelper.net(activity, aPMidasNetRequest, iAPMidasNetCallBack);
        AppMethodBeat.o(192911);
    }

    public static void getInfo(Activity activity, String str, APMidasBaseRequest aPMidasBaseRequest, IAPMidasNetCallBack iAPMidasNetCallBack) {
        AppMethodBeat.i(192912);
        APLog.i(TAG, "getInfo enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192912);
            return;
        }
        try {
            fromContext = activity.getApplicationContext();
        } catch (Exception e2) {
            APLog.i("fromContext", e2.toString());
        }
        APPluginReportManager.payDataRelease();
        APPluginReportManager.getInstance().payInterfaceInit(aPMidasBaseRequest, APMidasPluginInfo.LAUNCH_INTERFACE_GETINFO);
        APPluginReportManager.getInstance().insertTimeData(APMidasPluginInfo.LAUNCH_INTERFACE_GETINFO, APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHINFO);
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        aPMidasPayHelper.getInfo(activity, str, aPMidasBaseRequest, iAPMidasNetCallBack);
        AppMethodBeat.o(192912);
    }

    public static void hfCouponsRollBack(Activity activity, String str) {
        AppMethodBeat.i(192913);
        APLog.i(TAG, "hfCouponsRollBack enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192913);
            return;
        }
        new APMidasPayHelper().call(activity, APMidasPayHelper.MED_DISTRIBUTE_HF_COUPONS_ROLLBACK, new Object[]{str});
        AppMethodBeat.o(192913);
    }

    public static void launchAbility(Context context, MidasBaseAbility midasBaseAbility, final ResultReceiver resultReceiver) {
        AppMethodBeat.i(192914);
        APLog.i(TAG, "launchAbility enter : " + midasBaseAbility.toString());
        if (APMidasTools.isFastClick()) {
            APLog.i("launchAbility", "isfast");
            if (resultReceiver != null) {
                Bundle bundle = new Bundle();
                bundle.putString("midas_callback_ability_" + "postBack", midasBaseAbility.postBack);
                bundle.putInt("midas_callback_ability_" + TMQQDownloaderOpenSDKConst.UINTYPE_CODE, -999);
                bundle.putString("midas_callback_ability_" + "msg", "fast click");
                bundle.putBundle("midas_callback_ability_" + "data", new Bundle());
                resultReceiver.send(-1, bundle);
            }
            AppMethodBeat.o(192914);
        } else if (!checkParams(context)) {
            AppMethodBeat.o(192914);
        } else {
            APPluginReportManager.payDataRelease();
            APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
            aPMidasGameRequest.offerId = midasBaseAbility.offerId;
            aPMidasGameRequest.openId = midasBaseAbility.openId;
            aPMidasGameRequest.openKey = midasBaseAbility.openKey;
            aPMidasGameRequest.sessionId = midasBaseAbility.sessionId;
            aPMidasGameRequest.sessionType = midasBaseAbility.sessionType;
            aPMidasGameRequest.pf = midasBaseAbility.pf;
            aPMidasGameRequest.pfKey = midasBaseAbility.pfKey;
            APPluginReportManager.getInstance().payInterfaceInit(aPMidasGameRequest, APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHFEATURE);
            APPluginReportManager.getInstance().insertTimeData(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHFEATURE, APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHABILITY);
            APPluginReportManager.getInstance().insertData(APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHABILITY, APPluginReportManager.MIDASPLUGIN_ENTER_ABILITY, "MidasPlugin", midasBaseAbility.toString());
            new APMidasPayHelper().sendMidas(context, midasBaseAbility.toBundle(), new ResultReceiver(new Handler()) {
                /* class com.tencent.midas.api.APMidasPayAPI.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public final void onReceiveResult(int i2, Bundle bundle) {
                    AppMethodBeat.i(192891);
                    APLog.i(APMidasPayAPI.TAG, "launchAbility.onReceiveResult() resultCode=" + i2 + ", resultData=" + bundle);
                    if (resultReceiver != null) {
                        resultReceiver.send(i2, bundle);
                        APPluginReportManager.getInstance().dataReport("launchAbility");
                        APPluginUtils.release();
                        APLog.closeLog();
                    }
                    AppMethodBeat.o(192891);
                }
            });
            AppMethodBeat.o(192914);
        }
    }

    public static void launchWXMiniProgram(Context context, Bundle bundle, ResultReceiver resultReceiver) {
        AppMethodBeat.i(192915);
        APLog.i(TAG, "launchWXMiniProgram enter");
        if (!checkParams(context)) {
            AppMethodBeat.o(192915);
            return;
        }
        new APMidasPayHelper().launchWXMiniProgram(context, bundle, resultReceiver);
        AppMethodBeat.o(192915);
    }

    public static void launchWXMiniProgram_OnResponse(Context context, int i2, Bundle bundle) {
        AppMethodBeat.i(192916);
        APLog.i(TAG, "launchWXMiniProgram_OnResponse enter");
        APLog.i(TAG, "launchWXMiniProgram_OnResponse enter: bundle = ".concat(String.valueOf(bundle)));
        if (!checkParams(context)) {
            AppMethodBeat.o(192916);
            return;
        }
        new APMidasPayHelper().launchWXMiniProgram_OnResponse(context, i2, bundle);
        AppMethodBeat.o(192916);
    }

    public static void closeAll() {
        AppMethodBeat.i(192917);
        APPluginStatic.removeAll();
        AppMethodBeat.o(192917);
    }

    private static boolean checkInitCommParam(Context context, APMidasBaseRequest aPMidasBaseRequest) {
        AppMethodBeat.i(192918);
        if (!env.equals("release")) {
            try {
                if (APMidasCommMethod.getApplicationPackageName().equals("com.tencent.unipay")) {
                    AppMethodBeat.o(192918);
                    return true;
                } else if (aPMidasBaseRequest == null) {
                    Toast.makeText(context, "初始化request不能为空", 1).show();
                    AppMethodBeat.o(192918);
                    return false;
                } else if (TextUtils.isEmpty(aPMidasBaseRequest.offerId)) {
                    Toast.makeText(context, "初始化offerid不能为空", 1).show();
                    AppMethodBeat.o(192918);
                    return false;
                } else if (TextUtils.isEmpty(aPMidasBaseRequest.openId)) {
                    Toast.makeText(context, "初始化openId不能为空", 1).show();
                    AppMethodBeat.o(192918);
                    return false;
                } else if (TextUtils.isEmpty(aPMidasBaseRequest.openKey)) {
                    Toast.makeText(context, "初始化openKey不能为空", 1).show();
                    AppMethodBeat.o(192918);
                    return false;
                } else if (TextUtils.isEmpty(aPMidasBaseRequest.sessionId)) {
                    Toast.makeText(context, "初始化sessionId不能为空", 1).show();
                    AppMethodBeat.o(192918);
                    return false;
                } else if (TextUtils.isEmpty(aPMidasBaseRequest.sessionType)) {
                    Toast.makeText(context, "初始化sessionType不能为空", 1).show();
                    AppMethodBeat.o(192918);
                    return false;
                } else if (TextUtils.isEmpty(aPMidasBaseRequest.pf)) {
                    Toast.makeText(context, "初始化pf不能为空", 1).show();
                    AppMethodBeat.o(192918);
                    return false;
                } else if (TextUtils.isEmpty(aPMidasBaseRequest.pfKey)) {
                    Toast.makeText(context, "初始化pfKey不能为空", 1).show();
                    AppMethodBeat.o(192918);
                    return false;
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(192918);
        return true;
    }

    public static void launchPurchaseFlow(Activity activity, APMidasBaseRequest aPMidasBaseRequest, final APOnIabPurchaseFinished aPOnIabPurchaseFinished) {
        AppMethodBeat.i(192919);
        APLog.i(TAG, "launchPurchaseFlow enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192919);
            return;
        }
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        if (aPMidasBaseRequest == null || !(aPMidasBaseRequest instanceof APMidasGoodsRequest)) {
            aPOnIabPurchaseFinished.onIabPurchaseFinished(new APIabResult(3, ""), null);
            APLog.e("launchPurchaseFlow", "parameter is error");
            AppMethodBeat.o(192919);
            return;
        }
        if (aPMidasBaseRequest instanceof APMidasGoodsRequest) {
            ((APMidasGoodsRequest) aPMidasBaseRequest).mIsReceiptMode = true;
        }
        ((APMidasGoodsRequest) aPMidasBaseRequest).isCanChange = false;
        ((APMidasGoodsRequest) aPMidasBaseRequest).saveValue = "1";
        ((APMidasGoodsRequest) aPMidasBaseRequest).tokenType = 2;
        launchPay(activity, aPMidasBaseRequest, new IAPMidasPayCallBack() {
            /* class com.tencent.midas.api.APMidasPayAPI.AnonymousClass2 */

            @Override // com.tencent.midas.api.IAPMidasPayCallBack
            public final void MidasPayNeedLogin() {
                AppMethodBeat.i(192935);
                aPOnIabPurchaseFinished.onIabyNeedLogin();
                AppMethodBeat.o(192935);
            }

            @Override // com.tencent.midas.api.IAPMidasPayCallBack
            public final void MidasPayCallBack(APMidasResponse aPMidasResponse) {
                AppMethodBeat.i(192936);
                int resultCode = aPMidasResponse.getResultCode();
                if (aPMidasResponse.resultCode == 100) {
                    resultCode = 101;
                }
                aPOnIabPurchaseFinished.onIabPurchaseFinished(new APIabResult(resultCode, aPMidasResponse.getResultMsg()), aPMidasResponse.getReceipt());
                AppMethodBeat.o(192936);
            }
        });
        AppMethodBeat.o(192919);
    }

    public static void queryInventoryAsync(Activity activity, boolean z, List<?> list, APQueryInventoryFinishedListener aPQueryInventoryFinishedListener) {
        Class<?> cls;
        Class<?> cls2;
        AppMethodBeat.i(192920);
        APLog.i(TAG, "queryInventoryAsync enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192920);
            return;
        }
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        try {
            cls = Class.forName(List.class.getName());
        } catch (ClassNotFoundException e2) {
            APLog.d(TAG, "queryInventoryAsync setEnv e:" + e2.toString());
            cls = null;
        }
        try {
            cls2 = Class.forName("com.tencent.midas.api.request.APQueryInventoryFinishedListener");
        } catch (ClassNotFoundException e3) {
            APLog.d(TAG, "queryInventoryAsync APQueryInventoryFinishedListener e:" + e3.toString());
            cls2 = null;
        }
        Object call = aPMidasPayHelper.call(activity, APMidasPayHelper.MED_DISTRIBUTE_XGAME_QUERY, new Object[]{Boolean.valueOf(z), list, aPQueryInventoryFinishedListener}, new Class[]{Boolean.class, cls, cls2});
        APLog.i(TAG, "queryInventoryAsync ret ".concat(String.valueOf(call)));
        if (call == null) {
            aPQueryInventoryFinishedListener.onQueryInventoryFinished(new APIabResult(-1, ""), null);
        }
        AppMethodBeat.o(192920);
    }

    public static void consumeAsync(Activity activity, List<APPurchase> list, OnAPConsumeFinishedListener onAPConsumeFinishedListener) {
        Class<?> cls;
        Class<?> cls2 = null;
        AppMethodBeat.i(192921);
        APLog.i(TAG, "consumeAsync enter");
        if (!checkParams(activity)) {
            AppMethodBeat.o(192921);
            return;
        }
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        try {
            cls = Class.forName(List.class.getName());
        } catch (ClassNotFoundException e2) {
            APLog.d(TAG, "consumeAsync setEnv e:" + e2.toString());
            cls = null;
        }
        try {
            cls2 = Class.forName("com.tencent.midas.api.request.OnAPConsumeFinishedListener");
        } catch (ClassNotFoundException e3) {
            APLog.d(TAG, "consumeAsync OnAPConsumeFinishedListener e:" + e3.toString());
        }
        Object call = aPMidasPayHelper.call(activity, APMidasPayHelper.MED_DISTRIBUTE_XGAME_CONSUME, new Object[]{list, onAPConsumeFinishedListener}, new Class[]{cls, cls2});
        APLog.i(TAG, "consumeAsync ret ".concat(String.valueOf(call)));
        if (call == null) {
            onAPConsumeFinishedListener.onConsumeFinished(new ArrayList());
        }
        AppMethodBeat.o(192921);
    }

    public static void H5Release() {
        if (APMidasPayHelper.x5Webview != null) {
            APMidasPayHelper.x5Webview = null;
        }
        if (APMidasPayHelper.webview != null) {
            APMidasPayHelper.webview = null;
        }
        if (APMidasPayHelper.sIWebView != null) {
            APMidasPayHelper.sIWebView = null;
        }
    }
}
