package com.pay.network.model;

import com.pay.http.APBaseHttpAns;
import com.pay.http.APBaseHttpReq;
import com.pay.http.APHttpHandle;
import com.pay.http.IAPHttpAnsObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

public class APDataReportAns extends APBaseHttpAns {
    public APDataReportAns(APHttpHandle aPHttpHandle, IAPHttpAnsObserver iAPHttpAnsObserver, HashMap<String, APBaseHttpReq> hashMap, String str) {
        super(aPHttpHandle, iAPHttpAnsObserver, hashMap, str);
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStartAns(APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onReceiveAns(byte[] bArr, int i2, long j2, APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onFinishAns(byte[] bArr, APBaseHttpReq aPBaseHttpReq) {
        AppMethodBeat.i(193301);
        progressJson(bArr, aPBaseHttpReq);
        AppMethodBeat.o(193301);
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onErrorAns(APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStopAns(APBaseHttpReq aPBaseHttpReq) {
    }

    private void progressJson(byte[] bArr, APBaseHttpReq aPBaseHttpReq) {
        AppMethodBeat.i(193302);
        APLog.i("MidasPlugin.jar APDataReportAns", "report ok");
        AppMethodBeat.o(193302);
    }
}
