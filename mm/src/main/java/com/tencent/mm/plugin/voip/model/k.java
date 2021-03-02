package com.tencent.mm.plugin.voip.model;

import android.os.Debug;
import com.tencent.matrix.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/voip/model/VoipBeautyPerfStat;", "", "()V", "Kv_VoipBeautyRenderPerfStat", "", "STAT_ID", "", "TAG", "", "roomId", "doPerfStat", "", "v2protocal", "Lcom/tencent/mm/plugin/voip/model/v2protocal;", "beautyCmd", "setRoomId", "plugin-voip_release"})
public final class k {
    public static final k GVq = new k();
    private static int roomId;

    static {
        AppMethodBeat.i(184118);
        AppMethodBeat.o(184118);
    }

    private k() {
    }

    public static void setRoomId(int i2) {
        AppMethodBeat.i(184116);
        Log.i("MicroMsg.VoipBeautyPerfStat", "setRoomId:".concat(String.valueOf(i2)));
        roomId = i2;
        AppMethodBeat.o(184116);
    }

    public static void a(v2protocal v2protocal, int i2) {
        AppMethodBeat.i(184117);
        p.h(v2protocal, "v2protocal");
        Debug.MemoryInfo bo = a.bo(MMApplicationContext.getContext());
        long fIP = (long) v2protocal.fIP();
        long j2 = (long) bo.nativePss;
        long j3 = (long) bo.dalvikPss;
        Log.i("MicroMsg.VoipBeautyPerfStat", "doPerfIdKeyStat, beautyCmd:" + i2 + ", captureFps:" + fIP + ", nativePss:" + j2 + ", dalvikPss:" + j3 + ", roomId:" + roomId);
        if (fIP > 0 && roomId > 0 && j2 > 0 && j3 > 0) {
            if (i2 != 0) {
                switch (i2) {
                    case 1:
                        h.INSTANCE.n(1336, 36, fIP);
                        h.INSTANCE.n(1336, 37, 1);
                        h.INSTANCE.n(1336, 40, j3);
                        h.INSTANCE.n(1336, 41, 1);
                        h.INSTANCE.n(1336, 44, j2);
                        h.INSTANCE.n(1336, 45, 1);
                        break;
                    case 3:
                        h.INSTANCE.n(1336, 48, fIP);
                        h.INSTANCE.n(1336, 49, 1);
                        h.INSTANCE.n(1336, 52, j3);
                        h.INSTANCE.n(1336, 53, 1);
                        h.INSTANCE.n(1336, 56, j2);
                        h.INSTANCE.n(1336, 57, 1);
                        break;
                    case 5:
                        h.INSTANCE.n(1336, 60, fIP);
                        h.INSTANCE.n(1336, 61, 1);
                        h.INSTANCE.n(1336, 64, j3);
                        h.INSTANCE.n(1336, 65, 1);
                        h.INSTANCE.n(1336, 68, j2);
                        h.INSTANCE.n(1336, 69, 1);
                        break;
                    case 7:
                        h.INSTANCE.n(1336, 72, fIP);
                        h.INSTANCE.n(1336, 73, 1);
                        h.INSTANCE.n(1336, 76, j3);
                        h.INSTANCE.n(1336, 77, 1);
                        h.INSTANCE.n(1336, 80, j2);
                        h.INSTANCE.n(1336, 81, 1);
                        break;
                }
            } else {
                h.INSTANCE.n(1336, 0, fIP);
                h.INSTANCE.n(1336, 1, 1);
                h.INSTANCE.n(1336, 5, j3);
                h.INSTANCE.n(1336, 6, 1);
                h.INSTANCE.n(1336, 10, j2);
                h.INSTANCE.n(1336, 11, 1);
            }
            switch (i2) {
                case 0:
                    h.INSTANCE.n(1336, 30, 1);
                    break;
                case 1:
                    h.INSTANCE.n(1336, 31, 1);
                    break;
                case 3:
                    h.INSTANCE.n(1336, 32, 1);
                    break;
                case 5:
                    h.INSTANCE.n(1336, 33, 1);
                    break;
                case 7:
                    h.INSTANCE.n(1336, 34, 1);
                    break;
            }
            h.INSTANCE.a(19454, Integer.valueOf(roomId), Integer.valueOf(i2), Long.valueOf(fIP), Long.valueOf(j2), Long.valueOf(j3));
        }
        roomId = 0;
        AppMethodBeat.o(184117);
    }
}
