package com.tencent.mm.pluginsdk.wallet;

public final class h {
    private static int mPayChannel = -1;
    private static int mPayScene = -1;

    public static void setPayChannel(int i2) {
        mPayChannel = i2;
    }

    public static int getPayChannel() {
        return mPayChannel;
    }
}
