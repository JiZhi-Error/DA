package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/emoji/report/ChatEmojiBtnClickReport;", "", "()V", "TAG", "", "btnClicked", "", "lastShow", "panelOpenTime", "", "recordBtnClick", "", "recordClose", "recordOpen", "plugin-emojisdk_release"})
public final class b {
    private static final String TAG = TAG;
    private static long hca;
    private static boolean hcb;
    private static boolean hcc;
    public static final b hcd = new b();

    static {
        AppMethodBeat.i(105725);
        AppMethodBeat.o(105725);
    }

    private b() {
    }

    public static void avZ() {
        hcb = true;
    }

    public static void awa() {
        int i2 = 3;
        AppMethodBeat.i(105723);
        hca = System.currentTimeMillis();
        Log.i(TAG, "recordOpen: " + hca + ", " + hcc);
        if (!hcc) {
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[3];
            if (hcb) {
                i2 = 1;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = 0;
            objArr[2] = Long.valueOf(hca);
            hVar.a(17302, objArr);
            c.awc().zj(hca);
            h.awf().zj(hca);
            g gVar = g.hcn;
            g.zj(hca);
        }
        hcc = true;
        hcb = false;
        AppMethodBeat.o(105723);
    }

    public static void awb() {
        int i2 = 2;
        AppMethodBeat.i(105724);
        long currentTimeMillis = System.currentTimeMillis() - hca;
        Log.i(TAG, "recordClose: " + currentTimeMillis + ", " + hca + ", " + hcc);
        if (hcc) {
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[2];
            if (!hcb) {
                i2 = 4;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Long.valueOf(currentTimeMillis);
            hVar.a(17302, objArr);
        }
        hcc = false;
        AppMethodBeat.o(105724);
    }
}
