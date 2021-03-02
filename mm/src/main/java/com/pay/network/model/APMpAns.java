package com.pay.network.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.pay.http.APBaseHttpAns;
import com.pay.http.APBaseHttpReq;
import com.pay.http.APHttpHandle;
import com.pay.http.IAPHttpAnsObserver;
import com.pay.tool.APProductItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class APMpAns extends APBaseHttpAns {
    private String beginTime = "";
    private String endTime = "";
    private String firstsave_present_count = "";
    private List<APProductItem> mGoodsList = new ArrayList();
    private String mpJson = "";
    private List<String> mpList = new ArrayList();
    private List<String> mpPresentList = new ArrayList();
    private List<String> mpValueList = new ArrayList();
    private String rate = "";

    public APMpAns(APHttpHandle aPHttpHandle, IAPHttpAnsObserver iAPHttpAnsObserver, HashMap<String, APBaseHttpReq> hashMap, String str) {
        super(aPHttpHandle, iAPHttpAnsObserver, hashMap, str);
        AppMethodBeat.i(193297);
        AppMethodBeat.o(193297);
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStartAns(APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onReceiveAns(byte[] bArr, int i2, long j2, APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onFinishAns(byte[] bArr, APBaseHttpReq aPBaseHttpReq) {
        AppMethodBeat.i(193298);
        super.onFinishAns(bArr, aPBaseHttpReq);
        String str = new String(bArr);
        this.mpJson = str;
        APLog.i("APMpAns", "resultData=".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.resultCode = Integer.parseInt(jSONObject.getString("ret").toString());
            if (this.resultCode == 0) {
                if (jSONObject.has("product_list")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("product_list");
                    this.mGoodsList.clear();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        APProductItem aPProductItem = new APProductItem();
                        try {
                            aPProductItem.name = jSONObject2.getString("name");
                            aPProductItem.productId = jSONObject2.getString("productid");
                            aPProductItem.price = jSONObject2.getString(FirebaseAnalytics.b.PRICE);
                            aPProductItem.num = jSONObject2.getString("num");
                            this.mGoodsList.add(aPProductItem);
                        } catch (Exception e2) {
                        }
                    }
                }
                this.rate = jSONObject.getString("rate");
                APCommMethod.transformStrToList(jSONObject.getString("list"), this.mpList);
                this.firstsave_present_count = jSONObject.getString("firstsave_present_count");
                APCommMethod.transformStrToMpInfoList(jSONObject.getString("present_level"), this.mpValueList, this.mpPresentList);
                this.beginTime = jSONObject.getString("begin_time");
                this.endTime = jSONObject.getString("end_time");
                AppMethodBeat.o(193298);
                return;
            }
            this.resultMsg = jSONObject.getString("msg");
            String str2 = jSONObject.getString("err_code").toString();
            if (!str2.equals("")) {
                this.resultMsg = "系统繁忙,请稍后再试\n(" + str2 + ")";
            }
            AppMethodBeat.o(193298);
        } catch (Exception e3) {
            AppMethodBeat.o(193298);
        }
    }

    public List<String> getMpList() {
        return this.mpList;
    }

    public void setMpList(List<String> list) {
        this.mpList = list;
    }

    public String getRate() {
        return this.rate;
    }

    public void setRate(String str) {
        this.rate = str;
    }

    public String getFirstsave_present_count() {
        return this.firstsave_present_count;
    }

    public void setFirstsave_present_count(String str) {
        this.firstsave_present_count = str;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onErrorAns(APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStopAns(APBaseHttpReq aPBaseHttpReq) {
    }

    public List<String> getMpValueList() {
        return this.mpValueList;
    }

    public void setMpValueList(List<String> list) {
        this.mpValueList = list;
    }

    public List<String> getMpPresentList() {
        return this.mpPresentList;
    }

    public void setMpPresentList(List<String> list) {
        this.mpPresentList = list;
    }

    public List<APProductItem> getProductList() {
        return this.mGoodsList;
    }

    public String getMpJson() {
        return this.mpJson;
    }
}
