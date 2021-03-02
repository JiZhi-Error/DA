package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;

public final class e {
    public static String gkQ() {
        AppMethodBeat.i(200168);
        String str = b.dTg() + "wepkg/";
        AppMethodBeat.o(200168);
        return str;
    }

    public static String bcx(String str) {
        AppMethodBeat.i(110675);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110675);
            return "";
        }
        String str2 = gkQ() + str + FilePathGenerator.ANDROID_DIR_SEP;
        AppMethodBeat.o(110675);
        return str2;
    }

    public static String ms(String str, String str2) {
        AppMethodBeat.i(110676);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(110676);
            return "";
        }
        String str3 = bcx(str) + str2;
        AppMethodBeat.o(110676);
        return str3;
    }

    public static String bcy(String str) {
        AppMethodBeat.i(200169);
        if (str == null) {
            AppMethodBeat.o(200169);
            return "";
        }
        try {
            String[] split = str.split("/wepkg/");
            if (split.length <= 1) {
                AppMethodBeat.o(200169);
                return "";
            }
            String str2 = split[1];
            if (str2 == null) {
                AppMethodBeat.o(200169);
                return "";
            }
            String[] split2 = str2.split(FilePathGenerator.ANDROID_DIR_SEP);
            if (split2.length > 0) {
                String str3 = split2[0];
                AppMethodBeat.o(200169);
                return str3;
            }
            AppMethodBeat.o(200169);
            return "";
        } catch (Exception e2) {
        }
    }

    public static String bcz(String str) {
        AppMethodBeat.i(200170);
        if (str == null) {
            AppMethodBeat.o(200170);
            return "";
        }
        try {
            String[] split = str.split("/wepkg/");
            if (split.length <= 1) {
                AppMethodBeat.o(200170);
                return "";
            }
            String str2 = split[1];
            if (str2 == null) {
                AppMethodBeat.o(200170);
                return "";
            }
            String[] split2 = str2.split(FilePathGenerator.ANDROID_DIR_SEP);
            if (split2.length > 1) {
                String str3 = split2[1];
                AppMethodBeat.o(200170);
                return str3;
            }
            AppMethodBeat.o(200170);
            return "";
        } catch (Exception e2) {
        }
    }
}
