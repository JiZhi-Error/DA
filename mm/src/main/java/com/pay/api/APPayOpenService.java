package com.pay.api;

import com.pay.AndroidPay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasMonthRequest;
import com.tencent.midas.api.request.APMidasSubscribeRequest;
import com.tencent.midas.comm.APBeanUtil;
import com.tencent.midas.comm.APLog;

public class APPayOpenService {
    private static IAPMidasPayCallBack midasCallBack = new IAPMidasPayCallBack() {
        /* class com.pay.api.APPayOpenService.AnonymousClass1 */

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public final void MidasPayNeedLogin() {
            AppMethodBeat.i(193342);
            if (APPayOpenService.serviceDelegate != null) {
                APPayOpenService.serviceDelegate.PayOpenServiceNeedLogin();
            }
            AppMethodBeat.o(193342);
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public final void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            AppMethodBeat.i(193343);
            if (APPayOpenService.serviceDelegate != null) {
                APPayResponseInfo aPPayResponseInfo = new APPayResponseInfo();
                try {
                    APBeanUtil.copyProperties(aPMidasResponse, aPPayResponseInfo);
                } catch (Exception e2) {
                    APLog.i("APPayOpenService", "midasCallBack copyProperties error:" + e2.toString());
                }
                APPayOpenService.serviceDelegate.PayOpenServiceCallBack(aPPayResponseInfo);
            }
            AppMethodBeat.o(193343);
        }
    };
    private static IAPPayOpenServiceCallBack serviceDelegate = null;

    static {
        AppMethodBeat.i(193354);
        AppMethodBeat.o(193354);
    }

    public static void LaunchOpenServiceView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, String str10, boolean z, String str11) {
        AppMethodBeat.i(193349);
        APMidasMonthRequest aPMidasMonthRequest = new APMidasMonthRequest();
        setCommParams(aPMidasMonthRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasMonthRequest.serviceCode = str8;
        aPMidasMonthRequest.serviceName = str9;
        aPMidasMonthRequest.resId = i2;
        aPMidasMonthRequest.saveValue = str10;
        aPMidasMonthRequest.isCanChange = z;
        aPMidasMonthRequest.remark = str11;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasMonthRequest, midasCallBack);
        AppMethodBeat.o(193349);
    }

    public static void LaunchOpenServiceView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, String str10) {
        AppMethodBeat.i(193350);
        APMidasMonthRequest aPMidasMonthRequest = new APMidasMonthRequest();
        setCommParams(aPMidasMonthRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasMonthRequest.serviceCode = str8;
        aPMidasMonthRequest.serviceName = str9;
        aPMidasMonthRequest.resId = i2;
        aPMidasMonthRequest.remark = str10;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasMonthRequest, midasCallBack);
        AppMethodBeat.o(193350);
    }

    public static void LaunchOpenServiceView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, String str10, String str11, boolean z, String str12) {
        AppMethodBeat.i(193351);
        APMidasSubscribeRequest aPMidasSubscribeRequest = new APMidasSubscribeRequest();
        setCommParams(aPMidasSubscribeRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasSubscribeRequest.serviceCode = str8;
        aPMidasSubscribeRequest.serviceName = str9;
        aPMidasSubscribeRequest.resId = i2;
        aPMidasSubscribeRequest.saveValue = str10;
        aPMidasSubscribeRequest.productId = str11;
        aPMidasSubscribeRequest.isCanChange = z;
        aPMidasSubscribeRequest.remark = str12;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasSubscribeRequest, midasCallBack);
        AppMethodBeat.o(193351);
    }

    public static void LaunchOpenServiceView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, String str10, boolean z, String str11, boolean z2) {
        AppMethodBeat.i(193352);
        APMidasMonthRequest aPMidasMonthRequest = new APMidasMonthRequest();
        setCommParams(aPMidasMonthRequest, str, str2, str3, str4, str5, str6, str7);
        aPMidasMonthRequest.serviceCode = str8;
        aPMidasMonthRequest.serviceName = str9;
        aPMidasMonthRequest.resId = i2;
        aPMidasMonthRequest.remark = str11;
        aPMidasMonthRequest.autoPay = z2;
        APMidasPayAPI.launchPay(AndroidPay.singleton().fromActivity, aPMidasMonthRequest, midasCallBack);
        AppMethodBeat.o(193352);
    }

    @Deprecated
    public static void SetNeedReloginInSDK(boolean z) {
    }

    public static void SetDelegate(IAPPayOpenServiceCallBack iAPPayOpenServiceCallBack) {
        serviceDelegate = iAPPayOpenServiceCallBack;
    }

    public static IAPPayOpenServiceCallBack GetDelegate() {
        return serviceDelegate;
    }

    public static void release() {
        serviceDelegate = null;
    }

    private static void setCommParams(APMidasBaseRequest aPMidasBaseRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(193353);
        aPMidasBaseRequest.offerId = AndroidPay.singleton().offerId;
        aPMidasBaseRequest.openId = str;
        aPMidasBaseRequest.openKey = str2;
        aPMidasBaseRequest.sessionId = str3;
        aPMidasBaseRequest.sessionType = str4;
        aPMidasBaseRequest.zoneId = str5;
        aPMidasBaseRequest.pf = str6;
        aPMidasBaseRequest.pfKey = str7;
        AppMethodBeat.o(193353);
    }
}
