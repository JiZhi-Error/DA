package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class p extends m implements a {
    private static final String TAG = "MicroMsg.NetSceneTenpayRetriableBase";
    private boolean can_pay_retry2;
    private int errCode = 0;
    private String errMsg = "";
    private boolean hasCGiRetried = false;
    private boolean hasRetried = false;
    public boolean isPaySuccess = false;
    private ITenpaySave.RetryPayInfo retryPayInfo;
    private boolean shouldRetr = false;

    public boolean checkPaySuccess() {
        return this.isPaySuccess;
    }

    public void setPaySuccess(boolean z) {
        this.isPaySuccess = z;
    }

    @Override // com.tencent.mm.wallet_core.c.s, com.tencent.mm.wallet_core.tenpay.model.m
    public void configRequest(boolean z, boolean z2) {
        super.configRequest(z, z2);
    }

    public void setRetry() {
        reset();
        HashMap hashMap = new HashMap();
        hashMap.put("is_retry_pay", "1");
        addRequestData(hashMap);
        this.hasCGiRetried = true;
        this.isFake = false;
    }

    public boolean ishasCGiRetried() {
        return this.hasCGiRetried;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        this.errCode = i2;
        this.errMsg = str;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public boolean canRetry() {
        return false;
    }

    public boolean isShouldRetr() {
        return this.shouldRetr;
    }

    public void setShouldRetr(boolean z) {
        this.shouldRetr = z;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int i2) {
        this.errCode = i2;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setHasRetried(boolean z) {
        this.hasRetried = z;
    }

    public boolean getHasRetried() {
        return this.hasRetried;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public boolean shouldResolveJsonWhenError() {
        return !getHasRetried();
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd2(e eVar, JSONObject jSONObject) {
        boolean z = true;
        super.onGYNetEnd2(eVar, jSONObject);
        if (jSONObject == null || jSONObject.optInt("can_pay_retry") != 1) {
            z = false;
        }
        this.can_pay_retry2 = z;
        this.retryPayInfo = new ITenpaySave.RetryPayInfo();
        this.retryPayInfo.bK(jSONObject);
    }

    public void updateConfig(int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("retry_count", String.valueOf(i2));
        hashMap.put("is_last_retry", String.valueOf(i3));
        addRequestData(hashMap);
    }

    public boolean canPayRetry() {
        return this.can_pay_retry2;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.a
    public ITenpaySave.RetryPayInfo getRetryPayInfo() {
        return this.retryPayInfo;
    }

    public void resetForRetry() {
        reset();
        this.hasCGiRetried = true;
        this.isFake = false;
    }
}
