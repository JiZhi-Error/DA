package com.tencent.map.tools.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.File;
import javax.crypto.spec.IvParameterSpec;
import org.xwalk.core.XWalkEnvironment;

public final class t {
    public static final String A = ("SP_pro_" + a.f1309a + "_load_info");
    public static final String B = ("SP_" + a.f1309a + "__update_compinfo");
    public static final String C = ("SP_" + a.f1309a + "_MODULE_SHELL_SDK_VERSION");
    public static final String D = (a.f1309a + "/conf");
    public static final String E = ("https://tmapsdk-70114.njc.vod.tencent-cloud.com/" + a.f1310b + FilePathGenerator.ANDROID_DIR_SEP);
    public static final String[] F = {"", "", XWalkEnvironment.RUNTIME_ABI_ARM64_STR, XWalkEnvironment.RUNTIME_ABI_ARM32_STR, "armeabi", "x86", "x86_64", "mips64"};
    public static final IvParameterSpec G = new IvParameterSpec(H);
    private static final byte[] H = {84, 101, 110, 99, 101, 110, 116, 76, 111, 99, 97, 116, 105, 111, 110, 49};

    /* renamed from: a  reason: collision with root package name */
    public static final String f1400a = (a.f1309a + "_desc");

    /* renamed from: b  reason: collision with root package name */
    public static final String f1401b = ("tencentmap" + File.separator + a.f1309a + "_ps" + File.separator + a.f1309a + "_module");

    /* renamed from: c  reason: collision with root package name */
    public static final String f1402c = ("tencentmap" + File.separator + a.f1309a + "_ps" + File.separator + a.f1309a + "_lib");

    /* renamed from: d  reason: collision with root package name */
    public static final String f1403d = (a.f1309a + "_ps" + File.separator + a.f1309a + "_load");

    /* renamed from: e  reason: collision with root package name */
    public static final String f1404e = (f1403d + File.separator + a.f1309a + "_module");

    /* renamed from: f  reason: collision with root package name */
    public static final String f1405f = (f1403d + File.separator + a.f1309a + "_odex");

    /* renamed from: g  reason: collision with root package name */
    public static final String f1406g = (f1403d + File.separator + a.f1309a + "_lib");

    /* renamed from: h  reason: collision with root package name */
    public static final String f1407h = (a.f1309a + "_ps" + File.separator + a.f1309a + "_update");

    /* renamed from: i  reason: collision with root package name */
    public static final String f1408i = (f1407h + File.separator + a.f1309a + "_module");

    /* renamed from: j  reason: collision with root package name */
    public static final String f1409j = (f1407h + File.separator + a.f1309a + "_lib");
    public static String k = (a.f1310b + "." + a.f1311c + "." + a.f1312d);
    public static String l = a.f1313e;
    public static String m = a.f1314f;
    public static final String n = (a.f1309a + "_lock");
    public static final String o = (f1401b + File.separator + f1400a);
    public static final String p = f1402c;
    public static final String q = ("SP_" + a.f1309a + "_MODULE_INFO");
    public static final String r = ("SP_LAST_" + a.f1309a + "_MODULE_INFO");
    public static final String s = ("SP_UPDATE_" + a.f1309a + "_MODULE_INFO");
    public static final String t = ("SP_LAST_" + a.f1309a + "_MODULE_SDK_VER");
    public static final String u = ("SP_UPDATE_" + a.f1309a + "_MODULE_SDK_VER");
    public static final String v = ("SP_bad_" + a.f1309a + "_info");
    public static String w = (a.f1309a + "_loading");
    public static final String x = ("SP_last_check_" + a.f1309a + "_update_time");
    public static final String y = ("SP_" + a.f1309a + "_run_duration");
    public static final String z = ("SP_" + a.f1309a + "__exp_times");

    static {
        AppMethodBeat.i(193542);
        AppMethodBeat.o(193542);
    }
}
