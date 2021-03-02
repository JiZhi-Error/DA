package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import junit.framework.Assert;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/storage/BizMsgResortTest;", "", "()V", "TAG", "", "resortTestOpen", "", "getResortTestOpen", "()I", "setResortTestOpen", "(I)V", "checkReqData", "", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "beginTime", "", "checkReqLimit", "reqLimit", "itemSize", "checkRespData", "isResortTestOpen", "", "onCheckFail", "errMsg", "plugin-biz_release"})
public final class w {
    private static int NPJ = -1;
    public static final w NPK = new w();

    static {
        AppMethodBeat.i(212571);
        AppMethodBeat.o(212571);
    }

    private w() {
    }

    public static void ajS(int i2) {
        NPJ = i2;
    }

    static boolean gAk() {
        AppMethodBeat.i(212569);
        if (NPJ != -1) {
            if (NPJ == 1) {
                AppMethodBeat.o(212569);
                return true;
            }
            AppMethodBeat.o(212569);
            return false;
        } else if ((BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) && Log.getLogLevel() < 2) {
            AppMethodBeat.o(212569);
            return true;
        } else {
            AppMethodBeat.o(212569);
            return false;
        }
    }

    static void biV(String str) {
        AppMethodBeat.i(212570);
        Log.e("MicroMsg.BizMsgResortTest", "onCheckFail ".concat(String.valueOf(str)));
        if (BuildInfo.DEBUG || Log.getLogLevel() <= 1) {
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - singleMMKV.decodeLong("lastResortCrashTime", -1)) > Util.MILLSECONDS_OF_DAY) {
                singleMMKV.encode("lastResortCrashTime", currentTimeMillis);
                Assert.assertTrue("onCheckFail ".concat(String.valueOf(str)), false);
            }
        }
        AppMethodBeat.o(212570);
    }
}
