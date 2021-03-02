package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public class FilePathGenerator {
    public static final String ANDROID_DIR_SEP = "/";
    public static final int HASH_TYPE_ALL_MD5 = 2;
    public static final int HASH_TYPE_HEAD_2_BYTE = 1;
    public static final String NO_MEDIA_FILENAME = ".nomedia";
    private static final String TAG = "MicroMsg.FilePathGenerator";

    public enum DIR_HASH_TYPE {
        HEAD_2_BYTE,
        ALL_MD5;

        public static DIR_HASH_TYPE valueOf(String str) {
            AppMethodBeat.i(230289);
            DIR_HASH_TYPE dir_hash_type = (DIR_HASH_TYPE) Enum.valueOf(DIR_HASH_TYPE.class, str);
            AppMethodBeat.o(230289);
            return dir_hash_type;
        }

        static {
            AppMethodBeat.i(230290);
            AppMethodBeat.o(230290);
        }
    }

    private static String genByHead2Byte(String str) {
        AppMethodBeat.i(157531);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(157531);
            return null;
        } else if (str.length() <= 4) {
            AppMethodBeat.o(157531);
            return null;
        } else {
            String str2 = str.substring(0, 2) + ANDROID_DIR_SEP + str.substring(2, 4) + ANDROID_DIR_SEP;
            AppMethodBeat.o(157531);
            return str2;
        }
    }

    private static String genByAllMd5(String str) {
        AppMethodBeat.i(230291);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(230291);
            return null;
        }
        String genByHead2Byte = genByHead2Byte(g.getMessageDigest(str.getBytes()));
        AppMethodBeat.o(230291);
        return genByHead2Byte;
    }

    public static boolean checkMkdir(String str) {
        AppMethodBeat.i(157532);
        s.boN(str);
        AppMethodBeat.o(157532);
        return true;
    }

    public static String genPath(String str, String str2, String str3, String str4, int i2, boolean z) {
        AppMethodBeat.i(157533);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(157533);
            return null;
        } else if (!str.endsWith(ANDROID_DIR_SEP)) {
            AppMethodBeat.o(157533);
            return null;
        } else {
            String str5 = "";
            if (i2 == 1) {
                str5 = genByHead2Byte(str3);
            } else if (i2 == 2) {
                str5 = genByAllMd5(str3);
            }
            if (Util.isNullOrNil(str5)) {
                AppMethodBeat.o(157533);
                return null;
            }
            String str6 = str + str5;
            if (!z || checkMkdir(str6)) {
                String str7 = str6 + Util.nullAsNil(str2) + str3 + Util.nullAsNil(str4);
                AppMethodBeat.o(157533);
                return str7;
            }
            AppMethodBeat.o(157533);
            return null;
        }
    }

    public static String genPath(String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.i(157534);
        String genPath = genPath(str, str2, str3, str4, i2, true);
        AppMethodBeat.o(157534);
        return genPath;
    }

    public static String defGenPathWithOld(String str, String str2, String str3, String str4, String str5, int i2, boolean z) {
        AppMethodBeat.i(230292);
        String str6 = str + str3 + str4 + str5;
        String genPath = genPath(str2, str3, str4, str5, i2, z);
        if (Util.isNullOrNil(str6) || Util.isNullOrNil(genPath)) {
            AppMethodBeat.o(230292);
            return null;
        }
        o oVar = new o(genPath);
        o oVar2 = new o(str6);
        if (oVar.exists()) {
            AppMethodBeat.o(230292);
            return genPath;
        }
        if (oVar2.exists()) {
            FilesCopy.copy(str6, genPath, false);
        }
        AppMethodBeat.o(230292);
        return genPath;
    }

    public static String defGenPathWithOld(String str, String str2, String str3, String str4, String str5, int i2) {
        AppMethodBeat.i(230293);
        String defGenPathWithOld = defGenPathWithOld(str, str2, str3, str4, str5, i2, true);
        AppMethodBeat.o(230293);
        return defGenPathWithOld;
    }
}
