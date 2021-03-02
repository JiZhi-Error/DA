package com.tencent.mm.protocal.protobuf;

import com.tencent.mm.bw.a;

public abstract class dpc extends a {
    public BaseResponse BaseResponse;

    public BaseResponse getBaseResponse() {
        return this.BaseResponse;
    }

    public dpc setBaseResponse(BaseResponse baseResponse) {
        this.BaseResponse = baseResponse;
        return this;
    }
}
