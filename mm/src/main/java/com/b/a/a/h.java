package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;

public final class h {
    static final int chO = 5;
    static final int chP = 7;
    static final byte[] chQ;
    static final int chR = 4;
    static final int chS = 6;
    static final byte[] chT;
    static final byte[] chU = {-75, -5, -12, 112, -40, -44, -7, -71};
    static final String chV = (FilePathGenerator.ANDROID_DIR_SEP + y.PROTOCOL + "/c.php");
    static final String chW = (FilePathGenerator.ANDROID_DIR_SEP + y.PROTOCOL + "/d.php");
    static final String chX = ("_" + y.MODE + "_list.sensewhere-sdk.com");

    static {
        byte[] bytes;
        byte[] bytes2;
        AppMethodBeat.i(87998);
        try {
            bytes = "$UEC,".getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            bytes = "$UEC,".getBytes();
        }
        chQ = bytes;
        try {
            bytes2 = "$UP,".getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e3) {
            bytes2 = "$UP,".getBytes();
        }
        chT = bytes2;
        AppMethodBeat.o(87998);
    }
}
