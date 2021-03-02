package com.pay.http;

import android.text.TextUtils;
import com.pay.network.model.APDataReportAns;
import com.pay.network.model.APDataReportReq;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APPluginDataInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class APNetworkManager {
    public static final String HTTP_KEY_DATAREPORT = "datareport";
    public static final String HTTP_KEY_INITREPORT = "initreport";
    private static APNetworkManager gInstance = null;
    private HashMap<String, APBaseHttpReq> httpReqMap = new HashMap<>();

    public APNetworkManager() {
        AppMethodBeat.i(193260);
        AppMethodBeat.o(193260);
    }

    static class APNetworkManagerHolder {
        private static final APNetworkManager INSTANCE = new APNetworkManager();

        private APNetworkManagerHolder() {
        }

        static {
            AppMethodBeat.i(193265);
            AppMethodBeat.o(193265);
        }
    }

    public static APNetworkManager getInstance() {
        AppMethodBeat.i(193261);
        if (gInstance == null) {
            gInstance = APNetworkManagerHolder.INSTANCE;
        }
        APNetworkManager aPNetworkManager = gInstance;
        AppMethodBeat.o(193261);
        return aPNetworkManager;
    }

    public static void release() {
        gInstance = null;
    }

    public static void cancelRequest(String str) {
        AppMethodBeat.i(193262);
        APBaseHttpReq aPBaseHttpReq = gInstance.httpReqMap.get(str);
        if (aPBaseHttpReq != null) {
            aPBaseHttpReq.stopRequest();
            gInstance.httpReqMap.remove(str);
        }
        AppMethodBeat.o(193262);
    }

    public void cancelPreRequest() {
        AppMethodBeat.i(193263);
        if (gInstance.httpReqMap != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, APBaseHttpReq> entry : gInstance.httpReqMap.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue());
                }
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                APBaseHttpReq aPBaseHttpReq = (APBaseHttpReq) arrayList.get(i2);
                if (aPBaseHttpReq != null) {
                    aPBaseHttpReq.stopRequest();
                }
            }
            gInstance.httpReqMap.clear();
        }
        AppMethodBeat.o(193263);
    }

    public void dataReport(String str, IAPHttpAnsObserver iAPHttpAnsObserver) {
        AppMethodBeat.i(193264);
        if (TextUtils.isEmpty(APPluginDataInterface.singleton().getOfferId())) {
            AppMethodBeat.o(193264);
            return;
        }
        APDataReportReq aPDataReportReq = new APDataReportReq();
        aPDataReportReq.setHttpAns(new APDataReportAns(APHttpHandle.getIntanceHandel(), iAPHttpAnsObserver, this.httpReqMap, HTTP_KEY_DATAREPORT));
        aPDataReportReq.startService(str);
        AppMethodBeat.o(193264);
    }
}
