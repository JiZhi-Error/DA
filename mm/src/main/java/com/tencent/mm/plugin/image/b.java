package com.tencent.mm.plugin.image;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.s;
import java.io.UnsupportedEncodingException;

public final class b {
    public String md5;
    public String ynE;
    public String ynF;
    public int ynG;
    public int ynH;
    public int ynI;
    public int ynJ;
    public int ynK;
    public int ynL;

    public static int aBO(String str) {
        AppMethodBeat.i(223697);
        int PP = PP(str);
        if (str.indexOf("png") >= 0) {
            PP = 1;
        } else if (str.indexOf("jpg") >= 0 || str.indexOf("jpeg") >= 0) {
            PP = 2;
        } else if (str.indexOf("mp4") >= 0) {
            PP = 3;
        } else if (str.indexOf("wxam") >= 0) {
            PP = 4;
        }
        AppMethodBeat.o(223697);
        return PP;
    }

    public static String akC(String str) {
        String str2;
        AppMethodBeat.i(151487);
        byte[] aW = s.aW(str, 0, 6);
        if (aW == null || aW.length != 6) {
            AppMethodBeat.o(151487);
            return "";
        }
        try {
            str2 = new String(aW, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.ImgExtInfoReport", "getFileExt UnsupportedEncodingException:".concat(String.valueOf(e2)));
            str2 = "";
        }
        AppMethodBeat.o(151487);
        return str2;
    }

    public static String aBP(String str) {
        AppMethodBeat.i(151488);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151488);
            return "";
        }
        String replace = str.replace(",", ";");
        AppMethodBeat.o(151488);
        return replace;
    }

    private static int PP(String str) {
        AppMethodBeat.i(151489);
        try {
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
            if (imageOptions == null) {
                AppMethodBeat.o(151489);
                return 0;
            }
            String str2 = imageOptions.outMimeType;
            if (str2 == null) {
                AppMethodBeat.o(151489);
                return 0;
            }
            String lowerCase = str2.toLowerCase();
            if (lowerCase.indexOf("png") >= 0) {
                AppMethodBeat.o(151489);
                return 1;
            } else if (lowerCase.indexOf("jpg") >= 0) {
                AppMethodBeat.o(151489);
                return 2;
            } else if (lowerCase.indexOf("jpeg") >= 0) {
                AppMethodBeat.o(151489);
                return 2;
            } else if (lowerCase.indexOf("wxam") >= 0) {
                AppMethodBeat.o(151489);
                return 4;
            } else {
                AppMethodBeat.o(151489);
                return 0;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(151489);
            return 0;
        }
    }
}
