package com.tencent.midas.api.request;

import java.io.Serializable;

public abstract class APMidasBaseRequest implements Serializable {
    public static final int MALL_TYPE_DEFAULT = 0;
    public static final int MALL_TYPE_GROUPBUY = 1;
    public static final int MALL_TYPE_VMALL = 2;
    private static final long serialVersionUID = -9123623786877679280L;
    public String acctType;
    public APMidasExtendInfo extendInfo;
    public String h5Url;
    public boolean isCanChange;
    public int mallType;
    public APMidasMPInfo mpInfo;
    public String offerId;
    public String openId;
    public String openKey;
    public String pf;
    public String pfKey;
    public String remark;
    public byte[] resData;
    public int resId;
    public String reserv;
    public String saveValue;
    public String sessionId;
    public String sessionType;
    public String zoneId;

    public APMidasBaseRequest() {
        this.mallType = 0;
        this.h5Url = "";
        this.offerId = "";
        this.openId = "";
        this.openKey = "";
        this.sessionId = "";
        this.sessionType = "";
        this.zoneId = "";
        this.pf = "";
        this.pfKey = "";
        this.resId = 0;
        this.acctType = "common";
        this.saveValue = "";
        this.isCanChange = true;
        this.mallType = 0;
        this.h5Url = "";
        this.remark = "";
        this.mpInfo = new APMidasMPInfo();
        this.extendInfo = new APMidasExtendInfo();
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

    public boolean getIsCanChange() {
        return this.isCanChange;
    }

    public void setIsCanChange(boolean z) {
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

    public String getAcctType() {
        return this.acctType;
    }

    public void setAcctType(String str) {
        this.acctType = str;
    }

    public String getReserv() {
        return this.reserv;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setReserv(String str) {
        this.reserv = str;
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

    public String getPayChannel() {
        return this.mpInfo.payChannel;
    }

    public void setPayChannel(String str) {
        this.mpInfo.payChannel = str;
    }

    public String getDiscountType() {
        return this.mpInfo.discountType;
    }

    public void setDiscountType(String str) {
        this.mpInfo.discountType = str;
    }

    public String getDiscountUrl() {
        return this.mpInfo.discountUrl;
    }

    public void setDiscountUrl(String str) {
        this.mpInfo.discountUrl = str;
    }

    public String getDrmInfo() {
        return this.mpInfo.drmInfo;
    }

    public void setDrmInfo(String str) {
        this.mpInfo.drmInfo = str;
    }

    public String getDiscoutId() {
        return this.mpInfo.discoutId;
    }

    public void setDiscoutId(String str) {
        this.mpInfo.discoutId = str;
    }

    public String getExtras() {
        return this.mpInfo.extras;
    }

    public void setExtras(String str) {
        this.mpInfo.extras = str;
    }

    public String getUnit() {
        return this.extendInfo.unit;
    }

    public void setUnit(String str) {
        this.extendInfo.unit = str;
    }

    public boolean getShowNum() {
        return this.extendInfo.isShowNum;
    }

    public void setShowNum(boolean z) {
        this.extendInfo.isShowNum = z;
    }

    public boolean getShowListOtherNum() {
        return this.extendInfo.isShowListOtherNum;
    }

    public void setShowListOtherNum(boolean z) {
        this.extendInfo.isShowListOtherNum = z;
    }

    public class APMidasExtendInfo implements Serializable {
        private static final long serialVersionUID = -5387967973327966068L;
        public boolean isShowListOtherNum = true;
        public boolean isShowNum = true;
        public String unit = "";

        public APMidasExtendInfo() {
        }
    }

    public class APMidasMPInfo implements Serializable {
        private static final long serialVersionUID = 631101753621041424L;
        public String discountType;
        public String discountUrl;
        public String discoutId;
        public String drmInfo;
        public String extras;
        public String payChannel;

        public APMidasMPInfo() {
            this.drmInfo = "";
            this.discoutId = "";
            this.extras = "";
            this.payChannel = "";
            this.discountType = "";
            this.discountUrl = "";
            this.drmInfo = "";
            this.discoutId = "";
            this.extras = "";
        }
    }
}
