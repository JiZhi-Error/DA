package com.tencent.mm.plugin.appbrand.dynamic.k;

public final class b {
    public static int dV(int i2, int i3) {
        if (i2 == 0) {
            switch (i3) {
                case 1:
                    return 10000;
                case 2:
                    return 10001;
                default:
                    return 10002;
            }
        } else if (i2 != 1) {
            return Integer.MIN_VALUE;
        } else {
            switch (i3) {
                case 1:
                    return 10100;
                case 2:
                    return 10101;
                default:
                    return 10102;
            }
        }
    }

    public static int wq(int i2) {
        switch (i2) {
            case 10000:
            case 10100:
                return 1;
            case 10001:
            case 10101:
                return 2;
            default:
                return 0;
        }
    }
}
