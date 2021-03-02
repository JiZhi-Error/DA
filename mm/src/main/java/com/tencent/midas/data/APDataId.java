package com.tencent.midas.data;

public class APDataId {
    private static APDataId gInstance = null;
    private static int paydataCount = 0;
    private final String DATA_DISCOUNT_INIT = "initdataCount";
    private final String DATA_DISCOUNT_PAY = "dataCount";
    private final String TENCENTUNIPAY_DATAID_FLAG = APPluginDataInterface.SHARE_PREFERENCE_NAME;

    private APDataId() {
    }

    public static void initDataId() {
        paydataCount = 0;
    }

    public static int getDataId() {
        int i2 = paydataCount;
        paydataCount = i2 + 1;
        return i2;
    }
}
