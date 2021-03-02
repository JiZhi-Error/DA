package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class r implements IPxxLogic.ICallBack {
    private static long jDZ = 0;
    private static int jEa = 0;
    private final String TAG = "IPxxCallback";

    @Override // com.tencent.mars.magicbox.IPxxLogic.ICallBack
    public final String getUploadLogExtrasInfo(String str) {
        AppMethodBeat.i(132749);
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Device:").append(d.KyJ).append(" ").append(d.KyK).append("\n");
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(132749);
            return stringBuffer2;
        } catch (Exception e2) {
            AppMethodBeat.o(132749);
            return null;
        }
    }

    @Override // com.tencent.mars.magicbox.IPxxLogic.ICallBack
    public final void setNewDnsDebugHostInfo(String str, int i2) {
        AppMethodBeat.i(132750);
        MMLogic.setNewDnsDebugHost(str, String.valueOf(i2));
        AppMethodBeat.o(132750);
    }

    @Override // com.tencent.mars.magicbox.IPxxLogic.ICallBack
    public final String getCrashFilePath(int i2) {
        AppMethodBeat.i(132751);
        Date date = new Date(System.currentTimeMillis() - (((long) i2) * Util.MILLSECONDS_OF_DAY));
        String str = b.aKL() + "crash_" + new SimpleDateFormat("yyyyMMdd").format(date) + ".txt";
        if (s.YS(str)) {
            AppMethodBeat.o(132751);
            return str;
        }
        AppMethodBeat.o(132751);
        return null;
    }

    @Override // com.tencent.mars.magicbox.IPxxLogic.ICallBack
    public final void recoverLinkAddrs() {
        AppMethodBeat.i(132752);
        MMLogic.recoverLinkAddrs();
        AppMethodBeat.o(132752);
    }

    @Override // com.tencent.mars.magicbox.IPxxLogic.ICallBack
    public final void uploadLogResponse(long j2, long j3) {
        AppMethodBeat.i(132753);
        Log.i("IPxxCallback", "ipxx progress totalSize:%d uploadSize:%d lastPercent:%d ", Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(jEa));
        long nowSecond = Util.nowSecond();
        if (nowSecond - 1 < jDZ) {
            AppMethodBeat.o(132753);
            return;
        }
        jDZ = nowSecond;
        int i2 = 0;
        if (j3 >= 0 && j2 > 0 && j3 < j2) {
            i2 = (int) ((100 * j3) / j2);
        }
        if (i2 > 100) {
            i2 = 100;
        }
        if (jEa > i2) {
            i2 = jEa;
        }
        jEa = i2;
        uv(i2);
        AppMethodBeat.o(132753);
    }

    @Override // com.tencent.mars.magicbox.IPxxLogic.ICallBack
    public final void uploadLogFail() {
        AppMethodBeat.i(132754);
        jEa = 0;
        uv(-1);
        AppMethodBeat.o(132754);
    }

    @Override // com.tencent.mars.magicbox.IPxxLogic.ICallBack
    public final void uploadLogSuccess() {
        AppMethodBeat.i(132755);
        jEa = 0;
        uv(100);
        AppMethodBeat.o(132755);
    }

    private static void uv(int i2) {
        AppMethodBeat.i(132756);
        try {
            af.bkl().uw(i2);
            AppMethodBeat.o(132756);
        } catch (Exception e2) {
            Log.e("IPxxCallback", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132756);
        }
    }
}
