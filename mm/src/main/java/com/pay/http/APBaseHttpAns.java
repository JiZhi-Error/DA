package com.pay.http;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class APBaseHttpAns implements IAPHttpAns {
    private final int REQUESTMAX = 1;
    public String errorMsg = "";
    private APBaseHttpReq httpClient;
    private APHttpHandle httpHandler;
    public String httpReqKey = "";
    private HashMap<String, APBaseHttpReq> httpReqMap;
    private IAPHttpAnsObserver observer;
    private int requestAgainCount = 0;
    public int resultCode = -1;
    public String resultMsg = "";

    public APBaseHttpAns(APHttpHandle aPHttpHandle, IAPHttpAnsObserver iAPHttpAnsObserver, HashMap<String, APBaseHttpReq> hashMap, String str) {
        AppMethodBeat.i(193284);
        this.httpHandler = aPHttpHandle;
        this.httpReqMap = hashMap;
        this.httpReqKey = str;
        this.observer = iAPHttpAnsObserver;
        this.httpHandler.register(this.httpReqKey, iAPHttpAnsObserver);
        AppMethodBeat.o(193284);
    }

    public void onStartAns(APBaseHttpReq aPBaseHttpReq) {
    }

    public void onReceiveAns(byte[] bArr, int i2, long j2, APBaseHttpReq aPBaseHttpReq) {
    }

    public void onFinishAns(byte[] bArr, APBaseHttpReq aPBaseHttpReq) {
    }

    public void onErrorAns(APBaseHttpReq aPBaseHttpReq) {
    }

    public void onStopAns(APBaseHttpReq aPBaseHttpReq) {
    }

    public void reRegister() {
        AppMethodBeat.i(193285);
        this.httpHandler.register(this.httpReqKey, this.observer);
        AppMethodBeat.o(193285);
    }

    @Override // com.pay.http.IAPHttpAns
    public void onStart(APBaseHttpReq aPBaseHttpReq) {
        AppMethodBeat.i(193286);
        register(aPBaseHttpReq);
        onStartAns(aPBaseHttpReq);
        AppMethodBeat.o(193286);
    }

    @Override // com.pay.http.IAPHttpAns
    public void onReceive(byte[] bArr, int i2, long j2, APBaseHttpReq aPBaseHttpReq) {
        AppMethodBeat.i(193287);
        onReceiveAns(bArr, i2, j2, aPBaseHttpReq);
        AppMethodBeat.o(193287);
    }

    @Override // com.pay.http.IAPHttpAns
    public void onStop(APBaseHttpReq aPBaseHttpReq) {
        AppMethodBeat.i(193288);
        unRegister();
        onStopAns(aPBaseHttpReq);
        sendStopMessage();
        AppMethodBeat.o(193288);
    }

    @Override // com.pay.http.IAPHttpAns
    public void onFinish(APBaseHttpReq aPBaseHttpReq) {
        AppMethodBeat.i(193289);
        unRegister();
        if (aPBaseHttpReq.getContent() == null) {
            this.resultCode = -1;
            this.resultMsg = "";
            sendErrorMessage();
            AppMethodBeat.o(193289);
            return;
        }
        this.httpClient = aPBaseHttpReq;
        onFinishAns(aPBaseHttpReq.getContent(), aPBaseHttpReq);
        sendFinishMessage(aPBaseHttpReq.getContent());
        AppMethodBeat.o(193289);
    }

    @Override // com.pay.http.IAPHttpAns
    public void onError(APBaseHttpReq aPBaseHttpReq, int i2, String str) {
        AppMethodBeat.i(193290);
        this.errorMsg = str;
        this.resultMsg = str;
        this.resultCode = i2;
        unRegister();
        onErrorAns(aPBaseHttpReq);
        sendErrorMessage();
        AppMethodBeat.o(193290);
    }

    private void sendFinishMessage(byte[] bArr) {
        AppMethodBeat.i(193291);
        Message message = new Message();
        message.what = 3;
        message.obj = this;
        this.httpHandler.sendMessage(message);
        AppMethodBeat.o(193291);
    }

    private void sendErrorMessage() {
        AppMethodBeat.i(193292);
        Message message = new Message();
        message.what = 4;
        message.obj = this;
        this.httpHandler.sendMessage(message);
        AppMethodBeat.o(193292);
    }

    private void sendStopMessage() {
        AppMethodBeat.i(193293);
        Message message = new Message();
        message.what = 5;
        message.obj = this;
        this.httpHandler.sendMessage(message);
        AppMethodBeat.o(193293);
    }

    public String getHttpReqKey() {
        return this.httpReqKey;
    }

    private void register(APBaseHttpReq aPBaseHttpReq) {
        AppMethodBeat.i(193294);
        this.httpReqMap.put(this.httpReqKey, aPBaseHttpReq);
        AppMethodBeat.o(193294);
    }

    private void unRegister() {
        AppMethodBeat.i(193295);
        this.httpReqMap.remove(this.httpReqKey);
        AppMethodBeat.o(193295);
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultMessage() {
        return this.resultMsg;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public void requestAgain() {
        AppMethodBeat.i(193296);
        if (this.httpClient == null || this.requestAgainCount > 1) {
            reRegister();
            onError(this.httpClient, -1, "");
            AppMethodBeat.o(193296);
            return;
        }
        this.requestAgainCount++;
        reRegister();
        new Thread(new Runnable() {
            /* class com.pay.http.APBaseHttpAns.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(193258);
                APBaseHttpAns.this.httpClient.requestAgain();
                AppMethodBeat.o(193258);
            }
        }).start();
        AppMethodBeat.o(193296);
    }
}
