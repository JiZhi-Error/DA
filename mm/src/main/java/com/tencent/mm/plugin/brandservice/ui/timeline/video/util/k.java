package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoResolutionHelper;", "", "()V", "TAG", "", "getInitResolution", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "urlInfoList", "Ljava/util/LinkedList;", "getLastResolution", "", "setLastResolution", "", "type", "plugin-brandservice_release"})
public final class k {
    private static final String TAG = TAG;
    public static final k pLx = new k();

    static {
        AppMethodBeat.i(7310);
        AppMethodBeat.o(7310);
    }

    private k() {
    }

    public static final gh K(LinkedList<gh> linkedList) {
        int i2;
        AppMethodBeat.i(7308);
        p.h(linkedList, "urlInfoList");
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(7308);
            return null;
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(TAG);
        if (mmkv != null) {
            i2 = mmkv.decodeInt("LastResolutionType", -1);
        } else {
            i2 = -1;
        }
        Log.i(TAG, "getInitResolution ".concat(String.valueOf(i2)));
        gh ghVar = linkedList.get(0);
        p.g(ghVar, "urlInfoList[0]");
        gh ghVar2 = ghVar;
        if (i2 == -1) {
            AppMethodBeat.o(7308);
            return ghVar2;
        }
        Iterator<gh> it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                ghVar2 = ghVar2;
                break;
            }
            ghVar2 = it.next();
            if (ghVar2.KKg <= i2 && (ghVar2.KKg >= i2 || ghVar2.KKg < ghVar2.KKg)) {
                p.g(ghVar2, "info");
                if (ghVar2.KKg == i2) {
                    break;
                }
            } else {
                ghVar2 = ghVar2;
            }
        }
        AppMethodBeat.o(7308);
        return ghVar2;
    }

    public static final void DP(int i2) {
        AppMethodBeat.i(7309);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(TAG);
        if (mmkv != null) {
            mmkv.encode("LastResolutionType", i2);
        }
        if (mmkv != null) {
            mmkv.encode("LastResolutionTime", System.currentTimeMillis());
        }
        Log.i(TAG, "LastResolutionType ".concat(String.valueOf(i2)));
        AppMethodBeat.o(7309);
    }
}
