package com.tencent.midas.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.midas.api.request.APMidasMonthRequest;
import com.tencent.midas.api.request.APMidasSubscribeRequest;
import com.tencent.midas.comm.APLog;

public class APMidasAnalyzeParams {

    /* access modifiers changed from: package-private */
    public static class SingletonHolder {
        private static APMidasAnalyzeParams instance = new APMidasAnalyzeParams();

        private SingletonHolder() {
        }

        static {
            AppMethodBeat.i(192996);
            AppMethodBeat.o(192996);
        }
    }

    public static APMidasAnalyzeParams getInstance() {
        AppMethodBeat.i(193020);
        APMidasAnalyzeParams aPMidasAnalyzeParams = SingletonHolder.instance;
        AppMethodBeat.o(193020);
        return aPMidasAnalyzeParams;
    }

    public void AnalyzeParams(APMidasBaseRequest aPMidasBaseRequest) {
        AppMethodBeat.i(193021);
        if (aPMidasBaseRequest != null) {
            AnalyzeCommParams(aPMidasBaseRequest);
            setSaveType(aPMidasBaseRequest);
        }
        AppMethodBeat.o(193021);
    }

    public void setSaveType(APMidasBaseRequest aPMidasBaseRequest) {
        AppMethodBeat.i(193022);
        APPluginDataInterface singleton = APPluginDataInterface.singleton();
        try {
            if (aPMidasBaseRequest instanceof APMidasGameRequest) {
                if (aPMidasBaseRequest.acctType.equals("qb")) {
                    singleton.setSaveType(3);
                    AppMethodBeat.o(193022);
                    return;
                }
                singleton.setSaveType(0);
                AppMethodBeat.o(193022);
            } else if (aPMidasBaseRequest instanceof APMidasGoodsRequest) {
                singleton.setSaveType(1);
                AppMethodBeat.o(193022);
            } else if (aPMidasBaseRequest instanceof APMidasMonthRequest) {
                singleton.setSaveType(4);
                AppMethodBeat.o(193022);
            } else {
                if (aPMidasBaseRequest instanceof APMidasSubscribeRequest) {
                    singleton.setSaveType(5);
                }
                AppMethodBeat.o(193022);
            }
        } catch (Exception e2) {
            APLog.i("setSaveType", e2.toString());
            AppMethodBeat.o(193022);
        }
    }

    private void AnalyzeCommParams(APMidasBaseRequest aPMidasBaseRequest) {
        AppMethodBeat.i(193023);
        try {
            APPluginDataInterface singleton = APPluginDataInterface.singleton();
            singleton.setOfferId(aPMidasBaseRequest.offerId);
            singleton.setOpenId(aPMidasBaseRequest.openId);
            singleton.setOpenKey(aPMidasBaseRequest.openKey);
            singleton.setSessionId(aPMidasBaseRequest.sessionId);
            singleton.setSessionType(aPMidasBaseRequest.sessionType);
            singleton.setPf(aPMidasBaseRequest.pf);
            singleton.setPfKey(aPMidasBaseRequest.pfKey);
            singleton.setZoneId(aPMidasBaseRequest.zoneId);
            singleton.setDiscountUrl(aPMidasBaseRequest.mpInfo.discountUrl);
            singleton.setReserv(aPMidasBaseRequest.reserv);
            AppMethodBeat.o(193023);
        } catch (Exception e2) {
            APLog.i("AnalyzeCommParams", e2.toString());
            AppMethodBeat.o(193023);
        }
    }
}
