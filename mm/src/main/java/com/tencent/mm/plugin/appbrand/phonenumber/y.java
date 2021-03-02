package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\bN\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006¢\u0006\u0002\u0010 J\u0006\u0010T\u001a\u00020UJ\b\u0010V\u001a\u00020\u0003H\u0016R\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001a\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001a\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001a\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\"\"\u0004\b2\u0010$R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\"\"\u0004\b:\u0010$R\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\"\"\u0004\b<\u0010$R\u001a\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\"\"\u0004\b>\u0010$R\u001a\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\"\"\u0004\b@\u0010$R\u001a\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\"\"\u0004\bB\u0010$R\u001a\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\"\"\u0004\bD\u0010$R\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\"\"\u0004\bF\u0010$R\u001a\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\"\"\u0004\bH\u0010$R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\"\"\u0004\bJ\u0010$R\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\"\"\u0004\bL\u0010$R\u001a\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\"\"\u0004\bN\u0010$R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\"\"\u0004\bO\u0010$R\u001a\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\"\"\u0004\bQ\u0010$R\u001a\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\"\"\u0004\bR\u0010$R\u001a\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\"\"\u0004\bS\u0010$¨\u0006W"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "", "jsonStr", "", "(Ljava/lang/String;)V", "isBindPhone", "", "bindSuccess", "getPhoneNumberCount", "clickConfirmCount", "clickDenyCount", "clickCancelCount", "confirmBindedPhoneCount", "confirmUnBindPhoneCount", "clickInfoCount", "clickUseOtherPhoneCount", "clickManagePhoneCount", "clickGetVerifyCodeCount", "getVerifyCodeSuccessCount", "getVerifyCodeFailedCount", "clickAddPhoneDoneCount", "addPhoneSuccessCount", "addPhoneFailedCount", "addPhoneAndSaveCount", "addPhoneNotSaveCount", "clickAddPhoneOnManagePageCount", "deletePhoneCount", "deletePhoneSuccessCount", "deletePhoneFailedCount", "verifyCodeCount", "verifyCodeSuccessCount", "verifyCodeFailedCount", "(JJJJJJJJJJJJJJJJJJJJJJJJJJ)V", "getAddPhoneAndSaveCount", "()J", "setAddPhoneAndSaveCount", "(J)V", "getAddPhoneFailedCount", "setAddPhoneFailedCount", "getAddPhoneNotSaveCount", "setAddPhoneNotSaveCount", "getAddPhoneSuccessCount", "setAddPhoneSuccessCount", "getBindSuccess", "setBindSuccess", "getClickAddPhoneDoneCount", "setClickAddPhoneDoneCount", "getClickAddPhoneOnManagePageCount", "setClickAddPhoneOnManagePageCount", "getClickCancelCount", "setClickCancelCount", "getClickConfirmCount", "setClickConfirmCount", "getClickDenyCount", "setClickDenyCount", "getClickGetVerifyCodeCount", "setClickGetVerifyCodeCount", "getClickInfoCount", "setClickInfoCount", "getClickManagePhoneCount", "setClickManagePhoneCount", "getClickUseOtherPhoneCount", "setClickUseOtherPhoneCount", "getConfirmBindedPhoneCount", "setConfirmBindedPhoneCount", "getConfirmUnBindPhoneCount", "setConfirmUnBindPhoneCount", "getDeletePhoneCount", "setDeletePhoneCount", "getDeletePhoneFailedCount", "setDeletePhoneFailedCount", "getDeletePhoneSuccessCount", "setDeletePhoneSuccessCount", "getGetPhoneNumberCount", "setGetPhoneNumberCount", "getGetVerifyCodeFailedCount", "setGetVerifyCodeFailedCount", "getGetVerifyCodeSuccessCount", "setGetVerifyCodeSuccessCount", "setBindPhone", "getVerifyCodeCount", "setVerifyCodeCount", "setVerifyCodeFailedCount", "setVerifyCodeSuccessCount", "report", "", "toString", "luggage-wechat-full-sdk_release"})
public final class y {
    public long nAE;
    public long nAF;
    public long nAG;
    public long nAH;
    public long nAI;
    public long nAJ;
    public long nAK;
    public long nAL;
    public long nAM;
    public long nAN;
    public long nAO;
    public long nAP;
    long nAQ;
    public long nAR;
    public long nAS;
    public long nAT;
    public long nAU;
    public long nAV;
    public long nAW;
    public long nAX;
    public long nAY;
    public long nAZ;
    public long nBa;
    public long nBb;
    public long nBc;
    public long nBd;

    private y() {
        this.nAE = 0;
        this.nAF = 0;
        this.nAG = 0;
        this.nAH = 0;
        this.nAI = 0;
        this.nAJ = 0;
        this.nAK = 0;
        this.nAL = 0;
        this.nAM = 0;
        this.nAN = 0;
        this.nAO = 0;
        this.nAP = 0;
        this.nAQ = 0;
        this.nAR = 0;
        this.nAS = 0;
        this.nAT = 0;
        this.nAU = 0;
        this.nAV = 0;
        this.nAW = 0;
        this.nAX = 0;
        this.nAY = 0;
        this.nAZ = 0;
        this.nBa = 0;
        this.nBb = 0;
        this.nBc = 0;
        this.nBd = 0;
    }

    public /* synthetic */ y(byte b2) {
        this();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public y(String str) {
        this((byte) 0);
        p.h(str, "jsonStr");
        AppMethodBeat.i(169647);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.nAE = jSONObject.optLong("isBindPhone", 0);
            this.nAF = jSONObject.optLong("bindSuccess", 0);
            this.nAG = jSONObject.optLong("getPhoneNumberCount", 0);
            this.nAH = jSONObject.optLong("clickConfirmCount", 0);
            this.nAI = jSONObject.optLong("clickDenyCount", 0);
            this.nAJ = jSONObject.optLong("clickCancelCount", 0);
            this.nAK = jSONObject.optLong("confirmBindedPhoneCount", 0);
            this.nAL = jSONObject.optLong("confirmUnBindPhoneCount", 0);
            this.nAM = jSONObject.optLong("clickInfoCount", 0);
            this.nAN = jSONObject.optLong("clickUseOtherPhoneCount", 0);
            this.nAO = jSONObject.optLong("clickManagePhoneCount", 0);
            this.nAP = jSONObject.optLong("clickGetVerifyCodeCount", 0);
            this.nAQ = jSONObject.optLong("getVerifyCodeSuccessCount", 0);
            this.nAR = jSONObject.optLong("getVerifyCodeFailedCount", 0);
            this.nAS = jSONObject.optLong("clickAddPhoneDoneCount", 0);
            this.nAT = jSONObject.optLong("addPhoneSuccessCount", 0);
            this.nAU = jSONObject.optLong("addPhoneFailedCount", 0);
            this.nAV = jSONObject.optLong("addPhoneAndSaveCount", 0);
            this.nAW = jSONObject.optLong("addPhoneNotSaveCount", 0);
            this.nAX = jSONObject.optLong("clickAddPhoneOnManagePageCount", 0);
            this.nAY = jSONObject.optLong("deletePhoneCount", 0);
            this.nAZ = jSONObject.optLong("deletePhoneSuccessCount", 0);
            this.nBa = jSONObject.optLong("deletePhoneFailedCount", 0);
            this.nBb = jSONObject.optLong("verifyCodeCount", 0);
            this.nBc = jSONObject.optLong("verifyCodeSuccessCount", 0);
            this.nBd = jSONObject.optLong("verifyCodeFailedCount", 0);
            AppMethodBeat.o(169647);
        } catch (Exception e2) {
            AppMethodBeat.o(169647);
        }
    }

    public final String toString() {
        AppMethodBeat.i(169645);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isBindPhone", this.nAE);
        jSONObject.put("bindSuccess", this.nAF);
        jSONObject.put("getPhoneNumberCount", this.nAG);
        jSONObject.put("clickConfirmCount", this.nAH);
        jSONObject.put("clickDenyCount", this.nAI);
        jSONObject.put("clickCancelCount", this.nAJ);
        jSONObject.put("confirmBindedPhoneCount", this.nAK);
        jSONObject.put("confirmUnBindPhoneCount", this.nAL);
        jSONObject.put("clickInfoCount", this.nAM);
        jSONObject.put("clickUseOtherPhoneCount", this.nAN);
        jSONObject.put("clickManagePhoneCount", this.nAO);
        jSONObject.put("clickGetVerifyCodeCount", this.nAP);
        jSONObject.put("getVerifyCodeSuccessCount", this.nAQ);
        jSONObject.put("getVerifyCodeFailedCount", this.nAR);
        jSONObject.put("clickAddPhoneDoneCount", this.nAS);
        jSONObject.put("addPhoneSuccessCount", this.nAT);
        jSONObject.put("addPhoneFailedCount", this.nAU);
        jSONObject.put("addPhoneAndSaveCount", this.nAV);
        jSONObject.put("addPhoneNotSaveCount", this.nAW);
        jSONObject.put("clickAddPhoneOnManagePageCount", this.nAX);
        jSONObject.put("deletePhoneCount", this.nAY);
        jSONObject.put("deletePhoneSuccessCount", this.nAZ);
        jSONObject.put("deletePhoneFailedCount", this.nBa);
        jSONObject.put("verifyCodeCount", this.nBb);
        jSONObject.put("verifyCodeSuccessCount", this.nBc);
        jSONObject.put("verifyCodeFailedCount", this.nBd);
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "jsonObject.toString()");
        AppMethodBeat.o(169645);
        return jSONObject2;
    }

    public final void report() {
        AppMethodBeat.i(169646);
        u uVar = u.nAe;
        u.bTz().a(this);
        AppMethodBeat.o(169646);
    }
}
