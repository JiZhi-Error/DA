package com.tencent.pb.common.c;

import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.f;

public final class b {
    private static int RGP = 2;
    private static boolean RGQ = false;
    public static int level = 0;

    public static void hjo() {
        RGP = 0;
        RGQ = true;
    }

    public static void d(String str, Object... objArr) {
        if (RGQ && RGP <= 1 && str != null) {
            aa(1, str, " ".concat(String.valueOf(O(objArr))));
        }
    }

    public static void i(String str, Object... objArr) {
        if (RGQ && RGP <= 2) {
            aa(2, str, " ".concat(String.valueOf(O(objArr))));
        }
    }

    public static void w(String str, Object... objArr) {
        if (RGQ && RGP <= 3 && str != null) {
            aa(3, str, " ".concat(String.valueOf(O(objArr))));
        }
    }

    public static void e(String str, Object... objArr) {
        if (RGQ && RGP <= 4) {
            aa(4, str, " ".concat(String.valueOf(O(objArr))));
        }
    }

    private static String O(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(250);
        for (Object obj : objArr) {
            if (obj != null) {
                stringBuffer.append("|");
                if (obj instanceof Throwable) {
                    stringBuffer.append(((Throwable) obj).getMessage());
                } else {
                    stringBuffer.append(obj.toString());
                }
            }
        }
        return stringBuffer.toString();
    }

    private static void aa(int i2, String str, String str2) {
        e hrt = f.hrt();
        if (hrt != null) {
            hrt.H(i2, "MTSDK".concat(String.valueOf(str)), str2);
        }
    }
}
