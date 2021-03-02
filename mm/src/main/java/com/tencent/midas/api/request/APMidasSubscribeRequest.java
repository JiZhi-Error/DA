package com.tencent.midas.api.request;

public class APMidasSubscribeRequest extends APMidasMonthRequest {
    private static final long serialVersionUID = 6111439524338439638L;
    public int gameLogo = 0;
    public String productId = "";

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    @Override // com.tencent.midas.api.request.APMidasMonthRequest
    public int getGameLogo() {
        return this.gameLogo;
    }

    @Override // com.tencent.midas.api.request.APMidasMonthRequest
    public void setGameLogo(int i2) {
        this.gameLogo = i2;
    }
}
