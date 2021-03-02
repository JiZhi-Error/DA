package com.tencent.mm.plugin.music.model;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\bJ\b\u0010\f\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/music/model/GlobalMusicMvFloatBallUtil;", "", "()V", "TAG", "", "hideAllFloatBall", "", "hideFloatBall", "", "markHideAllFloatBall", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "onPause", "resumeFloatBall", "onResume", "plugin-mv_release"})
public final class c {
    private static boolean Akb;
    public static final c Akc = new c();

    static {
        AppMethodBeat.i(256734);
        AppMethodBeat.o(256734);
    }

    private c() {
    }

    public static void onResume() {
        AppMethodBeat.i(256730);
        Log.printDebugStack("MicroMsg.GlobalMusicMvFloatBallUtil", "alvinluo Mv onResume", new Object[0]);
        cjj();
        sm(false);
        AppMethodBeat.o(256730);
    }

    public static void sm(boolean z) {
        AppMethodBeat.i(256732);
        Log.printDebugStack("MicroMsg.GlobalMusicMvFloatBallUtil", "alvinluo markHideAllFloatBall hide: %s", Boolean.valueOf(z));
        Akb = z;
        AppMethodBeat.o(256732);
    }

    public static void cjj() {
        AppMethodBeat.i(256733);
        ((b) g.af(b.class)).jS(true);
        f.cjk();
        AppMethodBeat.o(256733);
    }

    public static /* synthetic */ void hWr() {
        AppMethodBeat.i(259164);
        Log.printDebugStack("MicroMsg.GlobalMusicMvFloatBallUtil", "alvinluo Mv onPause hideAllFloatBall: %s, resumeFloatBall: %b", Boolean.valueOf(Akb), Boolean.TRUE);
        if (!Akb) {
            ((b) g.af(b.class)).jS(false);
            f.cji();
        }
        AppMethodBeat.o(259164);
    }
}
