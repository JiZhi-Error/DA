package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.Scopes;
import com.pay.tool.APMidasCommMethod;
import com.pay.tool.APMidasTools;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.midas.api.request.APMidasMonthRequest;
import com.tencent.midas.api.request.APMidasSubscribeRequest;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.plugin.APPluginUtils;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import java.util.Map;

public class APWebJSBridgeActivity extends HellActivity {
    private static final String KEY_REQUEST = "key_request";
    private static final String KEY_TYPE = "key_pure_h5_pay";
    private static final String TAG = "APWebJSBridgeActivity";
    private static final String VALUE_PURE_H5 = "value_pure_h5_pay";
    private static final String WEB_URL_POST = "/index.html";
    private static final String WEB_URL_PRE = "http://youxi.vip.qq.com/m/act/";
    private byte _hellAccFlag_;
    private IAPWebPage webPage = null;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(192846);
        super.onCreate(bundle);
        try {
            APMidasCommMethod.pushActivity(this);
            initWebPage();
            Intent intent = getIntent();
            if (intent == null || !VALUE_PURE_H5.equals(intent.getStringExtra(KEY_TYPE))) {
                initUI();
                AppMethodBeat.o(192846);
                return;
            }
            toPureH5Pay((APMidasBaseRequest) intent.getSerializableExtra(KEY_REQUEST));
            AppMethodBeat.o(192846);
        } catch (Exception e2) {
            String fullExceptionStacktrace = APPluginUtils.getFullExceptionStacktrace(e2);
            if (!TextUtils.isEmpty(fullExceptionStacktrace) && (fullExceptionStacktrace.contains("webview") || fullExceptionStacktrace.contains("Webview"))) {
                Toast.makeText(this, "系统组件缺失，请退出重试", 0).show();
            }
            APPluginUtils.callbackInMidasPluginWithoutCaringAboutNewProcess(this, 100, "返回");
            finish();
            AppMethodBeat.o(192846);
        }
    }

    private String getPureH5PayURLParameters(APMidasBaseRequest aPMidasBaseRequest) {
        AppMethodBeat.i(192847);
        HashMap hashMap = new HashMap();
        hashMap.put("m", "buy");
        hashMap.put("_version", "v3");
        hashMap.put("appid", aPMidasBaseRequest.offerId);
        hashMap.put("pf", aPMidasBaseRequest.pf);
        hashMap.put("n", aPMidasBaseRequest.saveValue);
        hashMap.put("sessionid", aPMidasBaseRequest.sessionId);
        hashMap.put("sessiontype", aPMidasBaseRequest.sessionType);
        hashMap.put(Scopes.OPEN_ID, aPMidasBaseRequest.openId);
        hashMap.put("openkey", aPMidasBaseRequest.openKey);
        hashMap.put("zoneid", aPMidasBaseRequest.zoneId);
        hashMap.put("sdktype", "android");
        String midasCoreVersionName = APPluginUtils.getMidasCoreVersionName(this);
        APLog.d(TAG, "app_version = ".concat(String.valueOf(midasCoreVersionName)));
        hashMap.put("appversion", midasCoreVersionName);
        hashMap.put("request_from", NetUtil.STR_UserAgent);
        hashMap.put("is_android_sdk_error_version", "1");
        hashMap.put("android_sdk_reserve", aPMidasBaseRequest.reserv);
        hashMap.put("android_sdk_mpinfo_discountType", aPMidasBaseRequest.mpInfo.discountType);
        hashMap.put("android_sdk_mpinfo_discountUrl", aPMidasBaseRequest.mpInfo.discountUrl);
        hashMap.put("android_sdk_mpinfo_discoutId", aPMidasBaseRequest.mpInfo.discoutId);
        hashMap.put("android_sdk_mpinfo_drmInfo", aPMidasBaseRequest.mpInfo.drmInfo);
        hashMap.put("android_sdk_mpinfo_extras", aPMidasBaseRequest.mpInfo.extras);
        hashMap.put("android_sdk_mpinfo_payChannel", aPMidasBaseRequest.mpInfo.payChannel);
        hashMap.put("android_sdk_extendInfo_unit", aPMidasBaseRequest.extendInfo.unit);
        hashMap.put("android_sdk_extendInfo_isShowListOtherNum", String.valueOf(aPMidasBaseRequest.extendInfo.isShowListOtherNum));
        hashMap.put("android_sdk_extendInfo_isShowNum", String.valueOf(aPMidasBaseRequest.extendInfo.isShowNum));
        if (aPMidasBaseRequest instanceof APMidasGameRequest) {
            if ("hy_gameid".equals(aPMidasBaseRequest.sessionId) && "wc_actoken".equals(aPMidasBaseRequest.sessionType)) {
                hashMap.put("c", "wechat_game");
            } else if ("itopid".equals(aPMidasBaseRequest.sessionId)) {
                hashMap.put("c", "itop_game");
            } else {
                hashMap.put("c", "game");
            }
            if (!TextUtils.isEmpty(aPMidasBaseRequest.saveValue)) {
                hashMap.put("as", "1");
            }
        } else if (aPMidasBaseRequest instanceof APMidasGoodsRequest) {
            APMidasGoodsRequest aPMidasGoodsRequest = (APMidasGoodsRequest) aPMidasBaseRequest;
            hashMap.put("c", "goods");
            if (aPMidasGoodsRequest.tokenType == 1) {
                hashMap.put(NativeProtocol.WEB_DIALOG_PARAMS, aPMidasGoodsRequest.goodsTokenUrl);
            } else {
                hashMap.put("productid", aPMidasGoodsRequest.prodcutId);
            }
        } else if (aPMidasBaseRequest instanceof APMidasSubscribeRequest) {
            APMidasSubscribeRequest aPMidasSubscribeRequest = (APMidasSubscribeRequest) aPMidasBaseRequest;
            if (OpenSDKTool4Assistant.EXTRA_UIN.equals(aPMidasBaseRequest.sessionId) || Scopes.OPEN_ID.equals(aPMidasBaseRequest.sessionId)) {
                hashMap.put("c", "qqsubscribe");
            } else {
                hashMap.put("c", "subscribe");
            }
            if (!TextUtils.isEmpty(aPMidasSubscribeRequest.productId)) {
                hashMap.put("as", "1");
                hashMap.put("productid", aPMidasSubscribeRequest.productId);
            }
            hashMap.put("service", aPMidasSubscribeRequest.serviceCode);
            hashMap.put("aid", aPMidasSubscribeRequest.remark);
            if (aPMidasSubscribeRequest.autoPay) {
                hashMap.put("ap", "1");
            }
        } else if (aPMidasBaseRequest instanceof APMidasMonthRequest) {
            APMidasMonthRequest aPMidasMonthRequest = (APMidasMonthRequest) aPMidasBaseRequest;
            hashMap.put("da", "1");
            hashMap.put("c", aPMidasMonthRequest.serviceCode.toLowerCase());
            hashMap.put("_newservice", "1");
            if (aPMidasMonthRequest.autoPay) {
                hashMap.put("ap", "1");
            }
            if (!TextUtils.isEmpty(aPMidasBaseRequest.saveValue)) {
                hashMap.put("as", "1");
            }
            hashMap.put("aid", aPMidasMonthRequest.remark);
        }
        String str = APMidasPayAPI.env;
        if (APMidasPayAPI.ENV_DEV.equals(str)) {
            hashMap.put("sandbox", "2");
        } else if (APMidasPayAPI.ENV_TEST.equals(str)) {
            hashMap.put("sandbox", "1");
        }
        String map2UrlParams = map2UrlParams(hashMap);
        AppMethodBeat.o(192847);
        return map2UrlParams;
    }

    public static String map2UrlParams(HashMap<String, String> hashMap) {
        AppMethodBeat.i(192848);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue());
                stringBuffer.append("&");
            }
            if (!TextUtils.isEmpty(stringBuffer)) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        } catch (Exception e2) {
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(192848);
        return stringBuffer2;
    }

    private void toPureH5Pay(APMidasBaseRequest aPMidasBaseRequest) {
        AppMethodBeat.i(192849);
        this.webPage.toPureH5Pay(this, aPMidasBaseRequest);
        String str = "https://pay.qq.com/h5/index.shtml?" + getPureH5PayURLParameters(aPMidasBaseRequest);
        APLog.d(TAG, "To pure h5 pay full url = ".concat(String.valueOf(str)));
        this.webPage.loadUrl(str);
        AppMethodBeat.o(192849);
    }

    public static boolean startPureH5Pay(Context context, String str, String str2) {
        AppMethodBeat.i(192850);
        APLog.d(TAG, " Calling into startPureH5Pay caller = " + Thread.currentThread().getStackTrace()[3].toString());
        APPluginReportManager.getInstance().reportImmediatelyOneRecord(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_LAUNCH_PURE_H5_ERROR_REASON, "scene=" + str2 + "&reason=" + str);
        if (context == null) {
            APLog.e(TAG, "Cannot start pure h5 pay with null context!");
            AppMethodBeat.o(192850);
            return false;
        }
        APMidasBaseRequest aPMidasBaseRequest = APMidasPayHelper.requestObject;
        if (aPMidasBaseRequest == null) {
            APLog.e(TAG, "Cannot start pure h5 pay with null request object!");
            AppMethodBeat.o(192850);
            return false;
        }
        Activity activity = APMidasPayHelper.staticActivityContext;
        if (activity == null) {
            APLog.e(TAG, "Cannot start pure h5 pay with null activity object!");
            AppMethodBeat.o(192850);
            return false;
        }
        APMidasPayHelper.staticActivityContext = null;
        boolean startPureH5Pay = startPureH5Pay(activity, aPMidasBaseRequest);
        AppMethodBeat.o(192850);
        return startPureH5Pay;
    }

    private static boolean startPureH5Pay(Context context, APMidasBaseRequest aPMidasBaseRequest) {
        AppMethodBeat.i(192851);
        if (context == null) {
            APLog.e(TAG, "Cannot start pure h5 pay with null context!");
            AppMethodBeat.o(192851);
            return false;
        }
        Intent intent = new Intent();
        intent.setClass(context, APWebJSBridgeActivity.class);
        intent.putExtra(KEY_TYPE, VALUE_PURE_H5);
        intent.putExtra(KEY_REQUEST, aPMidasBaseRequest);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/midas/jsbridge/APWebJSBridgeActivity", "startPureH5Pay", "(Landroid/content/Context;Lcom/tencent/midas/api/request/APMidasBaseRequest;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/midas/jsbridge/APWebJSBridgeActivity", "startPureH5Pay", "(Landroid/content/Context;Lcom/tencent/midas/api/request/APMidasBaseRequest;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(192851);
        return true;
    }

    private void initWebPage() {
        AppMethodBeat.i(192852);
        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_INIT, "", "");
        if (APX5.isX5Enabled(this)) {
            this.webPage = new APX5WebPage();
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_X5, "", "");
            AppMethodBeat.o(192852);
            return;
        }
        this.webPage = new APSystemWebPage();
        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_SYSTEM, "", "");
        AppMethodBeat.o(192852);
    }

    private void initUI() {
        AppMethodBeat.i(192853);
        this.webPage.initUI(this);
        this.webPage.loadUrl(constructUrl());
        AppMethodBeat.o(192853);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(192854);
        super.onResume();
        AppMethodBeat.o(192854);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        AppMethodBeat.i(192855);
        super.onStart();
        AppMethodBeat.o(192855);
    }

    private String constructUrl() {
        String discountUrl;
        AppMethodBeat.i(192856);
        if (TextUtils.isEmpty(APPluginDataInterface.singleton().getDiscountUrl())) {
            discountUrl = WEB_URL_PRE + APPluginDataInterface.singleton().getOfferId() + WEB_URL_POST;
            this.webPage.initHead(this, APMidasTools.getUrlParamsValue(discountUrl, APWebProtocol.URL_KEY_HEAD_CONTROL), APMidasTools.getUrlParamsValue(discountUrl, APWebProtocol.URL_KEY_HEAD_TITLE));
            this.webPage.updateWebViewSize(discountUrl);
        } else {
            discountUrl = APPluginDataInterface.singleton().getDiscountUrl();
            this.webPage.initHead(this, APMidasTools.getUrlParamsValue(discountUrl, APWebProtocol.URL_KEY_HEAD_CONTROL), APMidasTools.getUrlParamsValue(discountUrl, APWebProtocol.URL_KEY_HEAD_TITLE));
            this.webPage.updateWebViewSize(APPluginDataInterface.singleton().getDiscountUrl());
        }
        APLog.e("constructUrl", discountUrl);
        HashMap hashMap = new HashMap();
        hashMap.put("offerId", APPluginDataInterface.singleton().getOfferId());
        hashMap.put("openId", APPluginDataInterface.singleton().getOpenId());
        hashMap.put("openKey", APPluginDataInterface.singleton().getOpenKey());
        hashMap.put("sessionId", APPluginDataInterface.singleton().getSessionId());
        hashMap.put("sessionType", APPluginDataInterface.singleton().getSessionType());
        hashMap.put("pf", APPluginDataInterface.singleton().getPf());
        hashMap.put("pfKey", APPluginDataInterface.singleton().getPfKey());
        hashMap.put("zoneId", APPluginDataInterface.singleton().getZoneId());
        if (!discountUrl.contains("?")) {
            discountUrl = discountUrl + "?";
        } else if (!discountUrl.endsWith("?")) {
            discountUrl = discountUrl + "&";
        }
        String str = discountUrl + APMidasTools.map2UrlParams(hashMap);
        APLog.i("constructUrl", str);
        AppMethodBeat.o(192856);
        return str;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(192857);
        if (i2 == 4) {
            APLog.d(TAG, "onKey down = back!");
            APMidasResponse aPMidasResponse = new APMidasResponse();
            aPMidasResponse.resultCode = 100;
            aPMidasResponse.resultMsg = "返回";
            APMidasPayHelper.midasCallBack(aPMidasResponse);
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(192857);
        return onKeyDown;
    }
}
