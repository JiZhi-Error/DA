package com.pay.network.model;

import android.text.TextUtils;
import com.pay.http.APHttpReqPost;
import com.pay.http.APPluginUrlConf;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APPluginDataInterface;

public class APDataReportReq extends APHttpReqPost {
    public APDataReportReq() {
        AppMethodBeat.i(193299);
        String offerId = APPluginDataInterface.singleton().getOfferId();
        if (TextUtils.isEmpty(offerId)) {
            AppMethodBeat.o(193299);
            return;
        }
        setReportUrl(String.format(APPluginUrlConf.AP_LOGREPORT_FCG, offerId), String.format(APPluginUrlConf.AP_LOGREPORT_FCG, offerId), String.format(APPluginUrlConf.AP_LOGREPORT_FCG, offerId));
        AppMethodBeat.o(193299);
    }

    public void startService(String str) {
        AppMethodBeat.i(193300);
        if (str.equals("")) {
            AppMethodBeat.o(193300);
        } else if (TextUtils.isEmpty(APPluginDataInterface.singleton().getOfferId())) {
            AppMethodBeat.o(193300);
        } else {
            this.httpParam.reqParam.clear();
            this.httpParam.reqParam.put(str, "");
            startRequest();
            AppMethodBeat.o(193300);
        }
    }
}
