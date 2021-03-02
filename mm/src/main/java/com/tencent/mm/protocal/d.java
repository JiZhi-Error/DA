package com.tencent.mm.protocal;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.smtt.sdk.TbsDownloader;
import junit.framework.Assert;

public final class d extends e {
    public static final String DEVICE_NAME = (Build.MANUFACTURER + "-" + Build.MODEL);
    public static int KyH = 2;
    public static final String KyI = Build.BRAND;
    public static final String KyJ = (Build.MODEL + Build.CPU_ABI);
    public static String KyK = ("android-" + Build.VERSION.SDK_INT);
    public static final String KyL = ("android-" + Build.MANUFACTURER);
    public static String KyM = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
    public static long KyN = 0;
    public static int KyO;
    public static boolean KyP = gty();
    public static boolean KyQ = gtx();
    public static boolean KyR = gtv();
    public static boolean KyS = gtw();
    public static int KyT = 5;
    public static final byte[] KyU = null;
    public static final byte[] KyV = null;
    public static final byte[] KyW = null;
    public static final String KyX = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e20) + "/mp/lifedetail?bid=%s&action=list#wechat_redirect");
    public static final String KyY = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e20) + "/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect");
    public static String ics = ("android-" + Build.VERSION.SDK_INT);

    public static void aiV(int i2) {
        AppMethodBeat.i(133038);
        KyO = i2;
        KyR = gtv();
        KyP = gty();
        KyQ = gtx();
        KyS = gtw();
        AppMethodBeat.o(133038);
    }

    static {
        AppMethodBeat.i(133039);
        KyO = Integer.decode(BuildInfo.CLIENT_VERSION).intValue();
        Assert.assertNotNull(BuildInfo.CLIENT_VERSION);
        try {
            int i2 = MMApplicationContext.getContext().getPackageManager().getApplicationInfo(MMApplicationContext.getPackageName(), 128).metaData.getInt(TbsDownloader.TBS_METADATA);
            if (i2 > KyO && i2 - KyO < 255 && (i2 & 255) >= 48) {
                KyO = i2;
            }
        } catch (Exception e2) {
            Log.printDebugStack("MicroMsg.ConstantsProtocal", "", e2);
        }
        AppMethodBeat.o(133039);
    }

    private static boolean gtv() {
        return (KyO & 255) >= 16 && (KyO & 255) <= 47;
    }

    private static boolean gtw() {
        return (KyO & 255) >= 0 && (KyO & 255) <= 15;
    }

    private static boolean gtx() {
        return (KyO & 255) >= 96 && (KyO & 255) <= 255;
    }

    private static boolean gty() {
        return (KyO & 255) >= 48 && (KyO & 255) <= 95;
    }
}
