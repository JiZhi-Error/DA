package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\tJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0014J\u0018\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotHelper;", "", "()V", "TAG", "", "dotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "checkDotValid", "", "lastDotInfo", "dotInfo", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "checkWebViewId", "getDotList", "getNextDotInfo", "currentTime", "", "parseDotPosInfo", "", "posInfo", "reset", "setDotScriptData", "bundle", "Landroid/os/Bundle;", "shouldDestroyDotNow", "dot", "shouldShowDotNow", "plugin-brandservice_release"})
public final class b {
    public final String TAG = "MicroMsg.BizVideoDotHelper";
    public LinkedList<c> pKl = new LinkedList<>();

    public b() {
        AppMethodBeat.i(7283);
        AppMethodBeat.o(7283);
    }

    public final void reset() {
        AppMethodBeat.i(7279);
        synchronized (this) {
            try {
                this.pKl.clear();
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(7279);
            }
        }
    }

    public final c bb(float f2) {
        AppMethodBeat.i(7280);
        synchronized (this) {
            try {
                if (Util.isNullOrNil(this.pKl)) {
                    return null;
                }
                Iterator<c> it = this.pKl.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (((double) f2) <= next.pKm) {
                        if (f2 >= 2.0f && ((double) f2) >= next.pKt - 10.0d) {
                            AppMethodBeat.o(7280);
                            return next;
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(7280);
                return null;
            } finally {
                AppMethodBeat.o(7280);
            }
        }
    }

    public static boolean a(float f2, c cVar) {
        if (cVar != null && !cVar.pKq && cVar.pKt <= ((double) f2) && ((double) f2) <= cVar.pKm) {
            return true;
        }
        return false;
    }

    public final boolean b(float f2, c cVar) {
        c bb;
        AppMethodBeat.i(7281);
        if (cVar == null) {
            AppMethodBeat.o(7281);
            return false;
        } else if (cVar.pKq && (((double) f2) < cVar.pKt || ((double) f2) > cVar.pKu)) {
            AppMethodBeat.o(7281);
            return true;
        } else if (((double) f2) > cVar.pKu) {
            AppMethodBeat.o(7281);
            return true;
        } else if (((double) f2) >= cVar.pKt || (bb = bb(f2)) == null || bb.id == cVar.id) {
            AppMethodBeat.o(7281);
            return false;
        } else {
            AppMethodBeat.o(7281);
            return true;
        }
    }

    public static boolean cqW() {
        AppMethodBeat.i(7282);
        if (!BuildInfo.DEBUG && !BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(7282);
            return true;
        } else if (MultiProcessMMKV.getMMKV("MicroMsg.BizVideoDetailUI").decodeInt("CheckWebviewId", 1) == 0) {
            AppMethodBeat.o(7282);
            return false;
        } else {
            AppMethodBeat.o(7282);
            return true;
        }
    }
}
