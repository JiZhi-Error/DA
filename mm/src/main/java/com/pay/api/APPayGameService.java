package com.pay.api;

import com.pay.AndroidPay;
import com.pay.http.APHttpHandle;
import com.pay.http.IAPHttpAnsObserver;
import com.pay.network.model.APMpAns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasNetCallBack;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.midas.api.request.APMidasNetRequest;
import com.tencent.midas.comm.APBeanUtil;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

public class APPayGameService {
    public static final String ACCOUNT_TYPE_COMMON = "common";
    public static final String ACCOUNT_TYPE_SECURITY = "secrety";
    public static final int LOGINPLATFORM_MOBILEQQ = 2;
    public static final int LOGINPLATFORM_WECHAT = 1;
    public static final String PAY_CHANNEL_BANK = "bank";
    public static final String PAY_CHANNEL_WECHAT = "wechat";
    private static IAPMidasPayCallBack midasCallBack = new IAPMidasPayCallBack() {
        /* class com.pay.api.APPayGameService.AnonymousClass1 */

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public final void MidasPayNeedLogin() {
            AppMethodBeat.i(193347);
            if (APPayGameService.serviceDelegate != null) {
                APLog.i("midasCallBack", "MidasPayNeedLogin");
                APPayGameService.serviceDelegate.PayGameNeedLogin();
            }
            AppMethodBeat.o(193347);
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public final void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            AppMethodBeat.i(193348);
            if (APPayGameService.serviceDelegate != null) {
                APPayResponseInfo aPPayResponseInfo = new APPayResponseInfo();
                try {
                    APBeanUtil.copyProperties(aPMidasResponse, aPPayResponseInfo);
                } catch (Exception e2) {
                    APLog.i("APPayGameService", "midas callBack copyProperties error:" + e2.toString());
                }
                APLog.i("midasCallBack", "MidasPayCallBack");
                APPayGameService.serviceDelegate.PayGameServiceCallBack(aPPayResponseInfo);
            }
            AppMethodBeat.o(193348);
        }
    };
    private static IAPPayGameServiceCallBack serviceDelegate = null;

    static {
        AppMethodBeat.i(193369);
        AppMethodBeat.o(193369);
    }

    public static void LauchVmallView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(193355);
        APMidasGoodsRequest aPMidasGoodsRequest = new APMidasGoodsRequest();
        setCommParams(aPMidasGoodsRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGoodsRequest.mallType = 2;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasGoodsRequest, midasCallBack);
        AppMethodBeat.o(193355);
    }

    public static void LaunchGroupBuyView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(193356);
        APMidasGoodsRequest aPMidasGoodsRequest = new APMidasGoodsRequest();
        setCommParams(aPMidasGoodsRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGoodsRequest.mallType = 1;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasGoodsRequest, midasCallBack);
        AppMethodBeat.o(193356);
    }

    public static void LaunchSaveCurrencyView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, int i2) {
        AppMethodBeat.i(193357);
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        setCommParams(aPMidasGameRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGameRequest.acctType = str8;
        aPMidasGameRequest.saveValue = str9;
        aPMidasGameRequest.isCanChange = z;
        aPMidasGameRequest.resId = i2;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasGameRequest, midasCallBack);
        AppMethodBeat.o(193357);
    }

    public static void LaunchSaveCurrencyView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, int i2, String str10, String str11) {
        AppMethodBeat.i(193358);
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        setCommParams(aPMidasGameRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGameRequest.acctType = str8;
        aPMidasGameRequest.saveValue = str9;
        aPMidasGameRequest.isCanChange = z;
        aPMidasGameRequest.resId = i2;
        aPMidasGameRequest.mpInfo.drmInfo = str10;
        aPMidasGameRequest.mpInfo.discoutId = str11;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasGameRequest, midasCallBack);
        AppMethodBeat.o(193358);
    }

    public static void LaunchSaveCurrencyView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        AppMethodBeat.i(193359);
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        setCommParams(aPMidasGameRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGameRequest.acctType = str8;
        aPMidasGameRequest.saveValue = "";
        aPMidasGameRequest.isCanChange = true;
        aPMidasGameRequest.resId = i2;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasGameRequest, midasCallBack);
        AppMethodBeat.o(193359);
    }

    public static void LaunchSaveCurrencyView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10) {
        AppMethodBeat.i(193360);
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        setCommParams(aPMidasGameRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGameRequest.acctType = str8;
        aPMidasGameRequest.saveValue = "";
        aPMidasGameRequest.isCanChange = true;
        aPMidasGameRequest.resId = i2;
        aPMidasGameRequest.mpInfo.drmInfo = str9;
        aPMidasGameRequest.mpInfo.discoutId = str10;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasGameRequest, midasCallBack);
        AppMethodBeat.o(193360);
    }

    public static void LaunchMPSaveCurrencyView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, String str10, String str11, String str12, String str13) {
        AppMethodBeat.i(193361);
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        setCommParams(aPMidasGameRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGameRequest.acctType = str8;
        aPMidasGameRequest.saveValue = str9;
        aPMidasGameRequest.resId = i2;
        aPMidasGameRequest.mpInfo.payChannel = str10;
        aPMidasGameRequest.mpInfo.discountType = str11;
        aPMidasGameRequest.mpInfo.discountUrl = str12;
        aPMidasGameRequest.mpInfo.extras = str13;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasGameRequest, midasCallBack);
        AppMethodBeat.o(193361);
    }

    public static void LaunchSaveGoodsView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        AppMethodBeat.i(193362);
        APMidasGoodsRequest aPMidasGoodsRequest = new APMidasGoodsRequest();
        aPMidasGoodsRequest.tokenType = 1;
        setCommParams(aPMidasGoodsRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGoodsRequest.goodsTokenUrl = str8;
        aPMidasGoodsRequest.resId = i2;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasGoodsRequest, midasCallBack);
        AppMethodBeat.o(193362);
    }

    public static void LaunchMPSaveGoodsView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, String str11, String str12) {
        AppMethodBeat.i(193363);
        APMidasGoodsRequest aPMidasGoodsRequest = new APMidasGoodsRequest();
        aPMidasGoodsRequest.tokenType = 1;
        setCommParams(aPMidasGoodsRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGoodsRequest.goodsTokenUrl = str8;
        aPMidasGoodsRequest.resId = i2;
        aPMidasGoodsRequest.mpInfo.payChannel = str9;
        aPMidasGoodsRequest.mpInfo.discountType = str10;
        aPMidasGoodsRequest.mpInfo.discountUrl = str11;
        aPMidasGoodsRequest.mpInfo.extras = str12;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasGoodsRequest, midasCallBack);
        AppMethodBeat.o(193363);
    }

    public static void LaunchSaveGoodsViewWithoutToken(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10) {
        AppMethodBeat.i(193364);
        APMidasGoodsRequest aPMidasGoodsRequest = new APMidasGoodsRequest();
        aPMidasGoodsRequest.tokenType = 2;
        setCommParams(aPMidasGoodsRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasGoodsRequest.prodcutId = str8;
        aPMidasGoodsRequest.saveValue = str9;
        aPMidasGoodsRequest.isCanChange = z;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasGoodsRequest, midasCallBack);
        AppMethodBeat.o(193364);
    }

    public static void LaunchMp(String str, String str2, String str3, String str4, String str5, String str6, String str7, IAPHttpAnsObserver iAPHttpAnsObserver) {
        AppMethodBeat.i(193365);
        startMpNetWork(str, str2, str3, str4, str5, str6, str7, "", iAPHttpAnsObserver);
        AppMethodBeat.o(193365);
    }

    public static void LaunchMp(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, IAPHttpAnsObserver iAPHttpAnsObserver) {
        AppMethodBeat.i(193366);
        startMpNetWork(str, str2, str3, str4, str5, str6, str7, str8, iAPHttpAnsObserver);
        AppMethodBeat.o(193366);
    }

    private static void startMpNetWork(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, final IAPHttpAnsObserver iAPHttpAnsObserver) {
        AppMethodBeat.i(193367);
        APMidasNetRequest aPMidasNetRequest = new APMidasNetRequest();
        setCommParams(aPMidasNetRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasNetRequest.reqType = APMidasNetRequest.NET_REQ_MP;
        if (str8 != null || "".equals(str8)) {
            aPMidasNetRequest.mpInfo.drmInfo = str8;
        }
        final APMpAns aPMpAns = new APMpAns(APHttpHandle.getIntanceHandel(), iAPHttpAnsObserver, new HashMap(), APMidasNetRequest.NET_REQ_MP);
        APMidasPayAPI.launchNet(AndroidPay.singleton().fromActivity, aPMidasNetRequest, new IAPMidasNetCallBack() {
            /* class com.pay.api.APPayGameService.AnonymousClass2 */

            @Override // com.tencent.midas.api.IAPMidasNetCallBack
            public final void MidasNetStop(String str) {
                AppMethodBeat.i(193344);
                iAPHttpAnsObserver.onStop(aPMpAns);
                AppMethodBeat.o(193344);
            }

            @Override // com.tencent.midas.api.IAPMidasNetCallBack
            public final void MidasNetFinish(String str, String str2) {
                AppMethodBeat.i(193345);
                aPMpAns.onFinishAns(str2.getBytes(), null);
                iAPHttpAnsObserver.onFinish(aPMpAns);
                AppMethodBeat.o(193345);
            }

            @Override // com.tencent.midas.api.IAPMidasNetCallBack
            public final void MidasNetError(String str, int i2, String str2) {
                AppMethodBeat.i(193346);
                aPMpAns.resultCode = i2;
                aPMpAns.resultMsg = str2;
                iAPHttpAnsObserver.onError(aPMpAns);
                AppMethodBeat.o(193346);
            }
        });
        AppMethodBeat.o(193367);
    }

    @Deprecated
    public static void reportCrashApLog(Throwable th) {
    }

    @Deprecated
    public static void SetNeedReloginInSDK(boolean z) {
    }

    public static void SetDelegate(IAPPayGameServiceCallBack iAPPayGameServiceCallBack) {
        serviceDelegate = iAPPayGameServiceCallBack;
    }

    public static IAPPayGameServiceCallBack GetDelegate() {
        return serviceDelegate;
    }

    public static void release() {
        serviceDelegate = null;
    }

    private static void setCommParams(APMidasBaseRequest aPMidasBaseRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(193368);
        aPMidasBaseRequest.offerId = AndroidPay.singleton().offerId;
        aPMidasBaseRequest.openId = str;
        aPMidasBaseRequest.openKey = str2;
        aPMidasBaseRequest.sessionId = str3;
        aPMidasBaseRequest.sessionType = str4;
        aPMidasBaseRequest.zoneId = str5;
        aPMidasBaseRequest.pf = str6;
        aPMidasBaseRequest.pfKey = str7;
        aPMidasBaseRequest.extendInfo.unit = AndroidPay.singleton().unit;
        aPMidasBaseRequest.extendInfo.isShowNum = AndroidPay.singleton().isShowNum;
        aPMidasBaseRequest.resData = AndroidPay.singleton().resdata;
        aPMidasBaseRequest.extendInfo.isShowListOtherNum = AndroidPay.singleton().isShowListOtherNum;
        AppMethodBeat.o(193368);
    }
}
