package com.tencent.mm.plugin.sns.ad.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.c;
import com.tencent.mm.plugin.sns.ad.timeline.b.e;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.sdk.platformtools.Log;

public final class k {
    public static void a(Context context, ADXml.b bVar, String str) {
        AppMethodBeat.i(201940);
        if (bVar == null) {
            Log.e("ScanJumpHelper", "jumpScanUI, jumpInfo==null");
            AppMethodBeat.o(201940);
            return;
        }
        Log.i("ScanJumpHelper", "jumpScanUI, desc=" + bVar.desc + ", gestureId=" + bVar.DWl + ", uxinfo=" + str);
        e.a(bVar, "");
        ScanGoodsRequest eOU = ScanGoodsRequest.eOU();
        eOU.CAQ = bVar.desc;
        eOU.CAN = e.aNR(bVar.DWj);
        eOU.CAP = e.aNR(bVar.pSE);
        eOU.CAO = e.aNR(bVar.DWk);
        eOU.putExtra("key_sns_ad_ux_info", str);
        eOU.putExtra("key_gesture_id", String.valueOf(bVar.DWl));
        ((c) g.af(c.class)).a(context, eOU);
        AppMethodBeat.o(201940);
    }
}
