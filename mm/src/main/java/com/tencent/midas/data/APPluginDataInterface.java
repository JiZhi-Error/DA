package com.tencent.midas.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class APPluginDataInterface {
    public static final String LAUNCHPAY_INTERVAL_TIME = "launchpayintervaltime";
    public static final String LAUNCHPAY_TIME = "launchpaytime";
    public static final String LAUNCHPAY_UUID = "launchpayuuid";
    public static final String SHARE_PREFERENCE_NAME = "TencentUnipay";
    private static volatile APPluginDataInterface gInstance = new APPluginDataInterface();
    private String acctType = "";
    private boolean autoPay = true;
    private String discountType = "";
    private String discountUrl = "";
    private String discoutId = "";
    private String drmInfo = "";
    private String extras = "";
    private String goodsTokenUrl = "";
    private String h5Message = "";
    private String h5Url = "";
    private boolean isCanChange = true;
    private boolean isNumVisible = true;
    private boolean isShowListOtherNum = true;
    private boolean isShowNum = true;
    private String launchInterface = APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY;
    private boolean logEnable = true;
    private int mallType = 0;
    private String offerId = "";
    private String openId = "";
    private String openKey = "";
    private String payChannel = "";
    private String pf = "";
    private String pfKey = "";
    private APMultiProcessData processData = null;
    private String prodcutId = "";
    private String propUnit = "";
    private String remark = "";
    private String reqType = "";
    private byte[] resData = null;
    private int resId = 0;
    private String resUrl = "";
    private String reserv = "";
    private int saveType = 0;
    private String saveValue = "";
    private String serviceCode = "";
    private String serviceName = "";
    private int serviceType = 0;
    private String sessionId = "";
    private String sessionType = "";
    private int tokenType = 0;
    private String unit = "";
    private String zoneId = "";

    static {
        AppMethodBeat.i(192999);
        AppMethodBeat.o(192999);
    }

    private APPluginDataInterface() {
    }

    public static void init() {
        AppMethodBeat.i(192997);
        gInstance = new APPluginDataInterface();
        AppMethodBeat.o(192997);
    }

    public static APPluginDataInterface singleton() {
        AppMethodBeat.i(192998);
        if (gInstance == null) {
            synchronized (APPluginDataInterface.class) {
                try {
                    if (gInstance == null) {
                        gInstance = new APPluginDataInterface();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(192998);
                    throw th;
                }
            }
        }
        APPluginDataInterface aPPluginDataInterface = gInstance;
        AppMethodBeat.o(192998);
        return aPPluginDataInterface;
    }

    public String getH5Message() {
        return this.h5Message;
    }

    public void setH5Message(String str) {
        gInstance.h5Message = str;
    }

    public String getOfferId() {
        return this.offerId;
    }

    public void setOfferId(String str) {
        this.offerId = str;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public String getOpenKey() {
        return this.openKey;
    }

    public void setOpenKey(String str) {
        this.openKey = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getSessionType() {
        return this.sessionType;
    }

    public void setSessionType(String str) {
        this.sessionType = str;
    }

    public String getZoneId() {
        return this.zoneId;
    }

    public void setZoneId(String str) {
        this.zoneId = str;
    }

    public String getPf() {
        return this.pf;
    }

    public void setPf(String str) {
        this.pf = str;
    }

    public String getPfKey() {
        return this.pfKey;
    }

    public void setPfKey(String str) {
        this.pfKey = str;
    }

    public String getSaveValue() {
        return this.saveValue;
    }

    public void setSaveValue(String str) {
        this.saveValue = str;
    }

    public boolean isCanChange() {
        return this.isCanChange;
    }

    public void setCanChange(boolean z) {
        this.isCanChange = z;
    }

    public int getResId() {
        return this.resId;
    }

    public void setResId(int i2) {
        this.resId = i2;
    }

    public byte[] getResData() {
        return this.resData;
    }

    public void setResData(byte[] bArr) {
        this.resData = bArr;
    }

    public String getResUrl() {
        return this.resUrl;
    }

    public void setResUrl(String str) {
        this.resUrl = str;
    }

    public String getReserv() {
        return this.reserv;
    }

    public void setReserv(String str) {
        this.reserv = str;
    }

    public String getAcctType() {
        return this.acctType;
    }

    public void setAcctType(String str) {
        this.acctType = str;
    }

    public int getMallType() {
        return this.mallType;
    }

    public void setMallType(int i2) {
        this.mallType = i2;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public void setH5Url(String str) {
        this.h5Url = str;
    }

    public boolean isNumVisible() {
        return this.isNumVisible;
    }

    public void setNumVisible(boolean z) {
        this.isNumVisible = z;
    }

    public boolean isLogEnable() {
        return this.logEnable;
    }

    public void setLogEnable(boolean z) {
        this.logEnable = z;
    }

    public String getPropUnit() {
        return this.propUnit;
    }

    public void setPropUnit(String str) {
        this.propUnit = str;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public boolean isShowNum() {
        return this.isShowNum;
    }

    public void setShowNum(boolean z) {
        this.isShowNum = z;
    }

    public boolean isShowListOtherNum() {
        return this.isShowListOtherNum;
    }

    public void setShowListOtherNum(boolean z) {
        this.isShowListOtherNum = z;
    }

    public String getPayChannel() {
        return this.payChannel;
    }

    public void setPayChannel(String str) {
        this.payChannel = str;
    }

    public String getDiscountType() {
        return this.discountType;
    }

    public void setDiscountType(String str) {
        this.discountType = str;
    }

    public String getDiscountUrl() {
        return this.discountUrl;
    }

    public void setDiscountUrl(String str) {
        this.discountUrl = str;
    }

    public String getDrmInfo() {
        return this.drmInfo;
    }

    public void setDrmInfo(String str) {
        this.drmInfo = str;
    }

    public String getDiscoutId() {
        return this.discoutId;
    }

    public void setDiscoutId(String str) {
        this.discoutId = str;
    }

    public String getExtras() {
        return this.extras;
    }

    public void setExtras(String str) {
        this.extras = str;
    }

    public String getGoodsTokenUrl() {
        return this.goodsTokenUrl;
    }

    public void setGoodsTokenUrl(String str) {
        this.goodsTokenUrl = str;
    }

    public int getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(int i2) {
        this.tokenType = i2;
    }

    public String getProdcutId() {
        return this.prodcutId;
    }

    public void setProdcutId(String str) {
        this.prodcutId = str;
    }

    public boolean isAutoPay() {
        return this.autoPay;
    }

    public void setAutoPay(boolean z) {
        this.autoPay = z;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

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

    public int getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(int i2) {
        this.serviceType = i2;
    }

    public String getReqType() {
        return this.reqType;
    }

    public void setReqType(String str) {
        this.reqType = str;
    }

    public int getSaveType() {
        return this.saveType;
    }

    public void setSaveType(int i2) {
        this.saveType = i2;
    }

    public APMultiProcessData getProcessData() {
        return this.processData;
    }

    public String getLaunchInterface() {
        return this.launchInterface;
    }

    public void setLaunchInterface(String str) {
        this.launchInterface = str;
    }

    public void setProcessData(APMultiProcessData aPMultiProcessData) {
        this.processData = aPMultiProcessData;
    }
}
