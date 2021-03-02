package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalLiveBottomButtonsSmallScreenConfig;", "", "()V", "SMALL_WIDTH_DP", "", "isSmallScreen", "", "context", "Landroid/content/Context;", "plugin-festival_release"})
public final class bm {
    public static final bm Uwt = new bm();

    static {
        AppMethodBeat.i(262815);
        AppMethodBeat.o(262815);
    }

    private bm() {
    }

    public static boolean hz(Context context) {
        AppMethodBeat.i(262814);
        p.h(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        Resources resources2 = context.getResources();
        p.g(resources2, "context.resources");
        if (((float) resources.getDisplayMetrics().widthPixels) / resources2.getDisplayMetrics().density < 368.0f) {
            AppMethodBeat.o(262814);
            return true;
        }
        AppMethodBeat.o(262814);
        return false;
    }
}
