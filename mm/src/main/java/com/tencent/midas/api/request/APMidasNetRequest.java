package com.tencent.midas.api.request;

import com.tencent.mm.sdk.platformtools.WeChatBrands;

public class APMidasNetRequest extends APMidasBaseRequest {
    public static String NET_REQ_MP = WeChatBrands.Business.GROUP_MP;
    private static final long serialVersionUID = 5582061948778338484L;
    public String reqType = "";

    public String getReqType() {
        return this.reqType;
    }

    public void setReqType(String str) {
        this.reqType = str;
    }
}
