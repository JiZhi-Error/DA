package com.tencent.tmassistantsdk.protocol.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class ResponseHeadErrorCode implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!ResponseHeadErrorCode.class.desiredAssertionStatus());
    public static final ResponseHeadErrorCode EC_BUSINESS_ERROR = new ResponseHeadErrorCode(1, -11, "EC_BUSINESS_ERROR");
    public static final ResponseHeadErrorCode EC_SERVER_INTERNAL_ERROR = new ResponseHeadErrorCode(0, -10, "EC_SERVER_INTERNAL_ERROR");
    public static final int _EC_BUSINESS_ERROR = -11;
    public static final int _EC_SERVER_INTERNAL_ERROR = -10;
    private static ResponseHeadErrorCode[] __values = new ResponseHeadErrorCode[2];
    private String __T = new String();
    private int __value;

    static {
        AppMethodBeat.i(102363);
        AppMethodBeat.o(102363);
    }

    public static ResponseHeadErrorCode convert(int i2) {
        AppMethodBeat.i(102360);
        for (int i3 = 0; i3 < __values.length; i3++) {
            if (__values[i3].value() == i2) {
                ResponseHeadErrorCode responseHeadErrorCode = __values[i3];
                AppMethodBeat.o(102360);
                return responseHeadErrorCode;
            }
        }
        if (!$assertionsDisabled) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(102360);
            throw assertionError;
        }
        AppMethodBeat.o(102360);
        return null;
    }

    public static ResponseHeadErrorCode convert(String str) {
        AppMethodBeat.i(102361);
        for (int i2 = 0; i2 < __values.length; i2++) {
            if (__values[i2].toString().equals(str)) {
                ResponseHeadErrorCode responseHeadErrorCode = __values[i2];
                AppMethodBeat.o(102361);
                return responseHeadErrorCode;
            }
        }
        if (!$assertionsDisabled) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(102361);
            throw assertionError;
        }
        AppMethodBeat.o(102361);
        return null;
    }

    public final int value() {
        return this.__value;
    }

    public final String toString() {
        return this.__T;
    }

    private ResponseHeadErrorCode(int i2, int i3, String str) {
        AppMethodBeat.i(102362);
        this.__T = str;
        this.__value = i3;
        __values[i2] = this;
        AppMethodBeat.o(102362);
    }
}
