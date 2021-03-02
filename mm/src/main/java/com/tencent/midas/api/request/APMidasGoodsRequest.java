package com.tencent.midas.api.request;

public class APMidasGoodsRequest extends APMidasBaseRequest {
    public static final int GETTOKENTYPE_CLIENT = 3;
    public static final int GETTOKENTYPE_SDK = 2;
    public static final int GETTOKENTYPE_SERVER = 1;
    private static final long serialVersionUID = -4326761659903564582L;
    public String developerPayload = "";
    public int gameLogo = 0;
    public String goodsTokenUrl = "";
    public boolean mIsReceiptMode = false;
    public String prodcutId = "";
    public int tokenType = -1;

    public int getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(int i2) {
        this.tokenType = i2;
    }

    public String getGoodsTokenUrl() {
        return this.goodsTokenUrl;
    }

    public void setGoodsTokenUrl(String str) {
        this.goodsTokenUrl = str;
    }

    public String getProdcutId() {
        return this.prodcutId;
    }

    public void setProdcutId(String str) {
        this.prodcutId = str;
    }

    public int getGameLogo() {
        return this.gameLogo;
    }

    public void setGameLogo(int i2) {
        this.gameLogo = i2;
    }

    public String getDeveloperPayload() {
        return this.developerPayload;
    }

    public void setDeveloperPayload(String str) {
        this.developerPayload = str;
    }

    public boolean getIsReceiptMode() {
        return this.mIsReceiptMode;
    }

    public void setIsReceiptMode(boolean z) {
        this.mIsReceiptMode = z;
    }
}
