package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import org.xwalk.core.XWalkEnvironment;

public class BuildInfo {
    public static String BUILD_TAG;
    public static String CLIENT_VERSION;
    public static int CLIENT_VERSION_INT;
    public static String COMMAND;
    public static boolean DEBUG;
    public static boolean ENABLE_FPS_ANALYSE;
    public static boolean ENABLE_MATRIX;
    public static boolean ENABLE_MATRIX_TRACE;
    public static boolean ENABLE_PAYTEST;
    public static boolean EX_DEVICE_LOGIN;
    public static String HOSTNAME;
    public static boolean IS_ARM64;
    public static boolean IS_FLAVOR_BLUE;
    public static boolean IS_FLAVOR_PURPLE;
    public static boolean IS_FLAVOR_RED;
    public static boolean IS_UAT;
    public static String KINDA_DEFAULT;
    public static String MATRIX_VERSION;
    public static String OVERRIDE_VERSION_NAME;
    public static String OWNER;
    public static boolean PRE_RELEASE;
    public static boolean REDESIGN_ENTRANCE;
    public static String REV;
    public static String SVNPATH;
    public static String TIME;
    public static String TINKER_VERSION;
    public static final ImmutableBundle ext = new ImmutableBundle();

    public interface Developer {
        public static final int alexanderlu = 31;
        public static final int ashukang = 12;
        public static final int cpan = 99;
        public static final int dkyang = 20;
        public static final int edwardgu = 30;
        public static final int hakonzhao = 32;
        public static final int jiaminchen = 100;
        public static final int justinliu = 0;
        public static final int kirozhao = 1;
        public static final int klemlin = 11;
        public static final int pandyduan = 50;
        public static final int smoothieli = 10000;
        public static final int williamlin = 40;
        public static final int yihengliu = 10;
    }

    static {
        AppMethodBeat.i(125205);
        AppMethodBeat.o(125205);
    }

    public static String info() {
        AppMethodBeat.i(125204);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[b.ver] %s\n", StringUtil.diffStr(CLIENT_VERSION, a.CLIENT_VERSION)));
        sb.append(String.format("[tag  ] %s\n", StringUtil.diffStr(BUILD_TAG, a.BUILD_TAG)));
        sb.append(String.format("[by   ] %s\n", StringUtil.diffStr(OWNER, a.OWNER)));
        sb.append(String.format("[host ] %s\n", StringUtil.diffStr(HOSTNAME, a.HOSTNAME)));
        sb.append(String.format("[time ] %s\n", StringUtil.diffStr(TIME, a.TIME)));
        sb.append(String.format("[cmd  ] %s\n", StringUtil.diffStr(COMMAND, a.COMMAND)));
        sb.append(String.format("[path ] %s\n", StringUtil.diffStr(StringUtil.stringFrom(SVNPATH, "MicroMsg_proj"), StringUtil.stringFrom(a.SVNPATH, "MicroMsg_proj"))));
        sb.append(String.format("[rev  ] %s\n", StringUtil.diffStr(REV, a.REV)));
        Object[] objArr = new Object[1];
        objArr[0] = a.aKy() ? a.aKv() : "disabled";
        sb.append(String.format("[p.rev] %s\n", objArr));
        Object[] objArr2 = new Object[1];
        objArr2[0] = IS_ARM64 ? XWalkEnvironment.RUNTIME_ABI_ARM64_STR : XWalkEnvironment.RUNTIME_ABI_ARM32_STR;
        sb.append(String.format("[eabi ] %s\n", objArr2));
        sb.append(String.format("[feature_id] %s\n", ext.getString("FEATURE_ID")));
        String sb2 = sb.toString();
        AppMethodBeat.o(125204);
        return sb2;
    }

    /* access modifiers changed from: package-private */
    public static class StringUtil {
        private StringUtil() {
        }

        public static String stringFrom(String str, String str2) {
            AppMethodBeat.i(125202);
            if (str == null) {
                AppMethodBeat.o(125202);
                return null;
            }
            int indexOf = str.indexOf(str2);
            if (indexOf < 0) {
                AppMethodBeat.o(125202);
                return str;
            }
            String substring = str.substring(indexOf);
            AppMethodBeat.o(125202);
            return substring;
        }

        public static String diffStr(String str, String str2) {
            AppMethodBeat.i(125203);
            if (str == null) {
                AppMethodBeat.o(125203);
                return null;
            } else if (str.equals(str2)) {
                AppMethodBeat.o(125203);
                return str;
            } else {
                String format = String.format("%s(%s)", str, str2);
                AppMethodBeat.o(125203);
                return format;
            }
        }
    }
}
