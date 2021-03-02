package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static boolean V(boolean z, int i2) {
        if (!z) {
            return false;
        }
        if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 9 || i2 == 19) {
            return true;
        }
        return false;
    }

    public static void a(Activity activity, int i2, SnsInfo snsInfo, int i3) {
        AppMethodBeat.i(202200);
        k aH = aH(activity);
        SnsAdClick snsAdClick = new SnsAdClick(i2, i2 == 0 ? 1 : 2, snsInfo.field_snsId, i3, 45);
        com.tencent.mm.plugin.sns.data.k.a(snsAdClick, aH, snsInfo, i3);
        r.a(snsAdClick);
        AppMethodBeat.o(202200);
    }

    private static k aH(Activity activity) {
        AppMethodBeat.i(202201);
        k kVar = null;
        try {
            if (activity instanceof SnsTimeLineUI) {
                kVar = ((SnsTimeLineUI) activity).fjf();
            } else if (activity instanceof SnsCommentDetailUI) {
                kVar = ((SnsCommentDetailUI) activity).EBv;
            }
        } catch (Throwable th) {
            Log.e("AdTagClickableHelper", th.toString());
        }
        AppMethodBeat.o(202201);
        return kVar;
    }
}
