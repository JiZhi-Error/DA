package com.tencent.midas.api.request;

public class APMidasMonthRequest extends APMidasBaseRequest {
    public static final int SERVICETYPE_NORMAL = 1;
    public static final int SERVICETYPE_RENEW = 2;
    public static final int SERVICETYPE_UPGRADE = 3;
    private static final long serialVersionUID = -557287896140460926L;
    public boolean autoPay = false;
    public int gameLogo = 0;
    public String serviceCode = "";
    public String serviceName = "";
    public int serviceType = 1;

    public String getServiceCode() {
        return this.serviceCode;
    }

    public void setServiceCode(String str) {
        this.serviceCode = str;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public boolean getAutoPay() {
        return this.autoPay;
    }

    public void setAutoPay(boolean z) {
        this.autoPay = z;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(int i2) {
        this.serviceType = i2;
    }

    public int getGameLogo() {
        return this.gameLogo;
    }

    public void setGameLogo(int i2) {
        this.gameLogo = i2;
    }
}
