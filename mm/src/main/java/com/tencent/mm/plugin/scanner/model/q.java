package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/OfflineScanReporter;", "", "()V", "ACTION_TYPE_CLICK_BY_NOTIFY_MESSAGE", "", "ACTION_TYPE_NORMAL", "NETWORK_TYPE_BAD_WITHOUT_DIALOG", "NETWORK_TYPE_BAD_WITH_DIALOG", "NETWORK_TYPE_CONNECTED", "NETWORK_TYPE_UNAVAILABLE", "OFFLINE_SCAN_SCENE_SCAN", "OFFLINE_SCAN_SCENE_SELECT_FROM_ALBUM", "TAG", "", "report", "", "result", "resultType", "scene", "networkType", "actionType", "plugin-scan_release"})
public final class q {
    public static final q CFL = new q();

    static {
        AppMethodBeat.i(52181);
        AppMethodBeat.o(52181);
    }

    private q() {
    }

    public static void b(String str, String str2, int i2, int i3, int i4) {
        AppMethodBeat.i(240411);
        p.h(str2, "resultType");
        Log.i("MicroMsg.OfflineScanReporter", "alvinluo OfflineScan report resultType: %s, scene: %d, networkType: %d, actionType: %d, result: %s", str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[5];
        objArr[0] = str2;
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(i4);
        if (str == null) {
            str = "";
        }
        objArr[4] = str;
        hVar.a(17386, objArr);
        AppMethodBeat.o(240411);
    }
}
