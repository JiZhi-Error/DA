package com.tencent.tmassistantsdk.protocol.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class JceCmd implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!JceCmd.class.desiredAssertionStatus());
    public static final JceCmd Empty = new JceCmd(0, 0, "Empty");
    public static final JceCmd GetAppSimpleDetail = new JceCmd(5, 5, "GetAppSimpleDetail");
    public static final JceCmd GetAppUpdate = new JceCmd(3, 3, "GetAppUpdate");
    public static final JceCmd GetSettings = new JceCmd(2, 2, "GetSettings");
    public static final JceCmd ReportApkFileInfo = new JceCmd(4, 4, "ReportApkFileInfo");
    public static final JceCmd ReportLog = new JceCmd(1, 1, "ReportLog");
    public static final int _Empty = 0;
    public static final int _GetAppSimpleDetail = 5;
    public static final int _GetAppUpdate = 3;
    public static final int _GetSettings = 2;
    public static final int _ReportApkFileInfo = 4;
    public static final int _ReportLog = 1;
    private static JceCmd[] __values = new JceCmd[6];
    private String __T = new String();
    private int __value;

    static {
        AppMethodBeat.i(102311);
        AppMethodBeat.o(102311);
    }

    public static JceCmd convert(int i2) {
        AppMethodBeat.i(102308);
        for (int i3 = 0; i3 < __values.length; i3++) {
            if (__values[i3].value() == i2) {
                JceCmd jceCmd = __values[i3];
                AppMethodBeat.o(102308);
                return jceCmd;
            }
        }
        if (!$assertionsDisabled) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(102308);
            throw assertionError;
        }
        AppMethodBeat.o(102308);
        return null;
    }

    public static JceCmd convert(String str) {
        AppMethodBeat.i(102309);
        for (int i2 = 0; i2 < __values.length; i2++) {
            if (__values[i2].toString().equals(str)) {
                JceCmd jceCmd = __values[i2];
                AppMethodBeat.o(102309);
                return jceCmd;
            }
        }
        if (!$assertionsDisabled) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(102309);
            throw assertionError;
        }
        AppMethodBeat.o(102309);
        return null;
    }

    public final int value() {
        return this.__value;
    }

    public final String toString() {
        return this.__T;
    }

    private JceCmd(int i2, int i3, String str) {
        AppMethodBeat.i(102310);
        this.__T = str;
        this.__value = i3;
        __values[i2] = this;
        AppMethodBeat.o(102310);
    }
}
