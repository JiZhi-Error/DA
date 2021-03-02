package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.f;

public final class ah {
    public static int DKc = 30;
    public static boolean DKd = false;
    public static boolean DKe = false;
    public static boolean DKf = false;
    public static int DKg = 50;
    public static boolean VaL = true;

    public static void far() {
        AppMethodBeat.i(202732);
        DKc = ((b) g.af(b.class)).a(b.a.clicfg_sns_link_collapse_enable, 30);
        DKd = ((e) g.ah(e.class)).getStoryBasicConfig().a(f.a.TimeLine_Comment);
        DKe = ((e) g.ah(e.class)).getStoryBasicConfig().a(f.a.TimeLine_Des);
        DKf = ((e) g.ah(e.class)).getStoryBasicConfig().a(f.a.TimeLine_Like);
        DKg = ((b) g.af(b.class)).a(b.a.clicfg_sns_ws_fold_range_size, 50);
        VaL = ((b) g.af(b.class)).a(b.a.clicfg_sns_sync_settext, 1) > 0;
        AppMethodBeat.o(202732);
    }

    public static void fas() {
        AppMethodBeat.i(202733);
        DKc = ((b) g.af(b.class)).a(b.a.clicfg_sns_link_collapse_enable, 30);
        DKd = ((e) g.ah(e.class)).getStoryBasicConfig().a(f.a.TimeLine_Comment);
        DKe = ((e) g.ah(e.class)).getStoryBasicConfig().a(f.a.TimeLine_Des);
        DKf = ((e) g.ah(e.class)).getStoryBasicConfig().a(f.a.TimeLine_Like);
        VaL = ((b) g.af(b.class)).a(b.a.clicfg_sns_sync_settext, 1) > 0;
        AppMethodBeat.o(202733);
    }
}
