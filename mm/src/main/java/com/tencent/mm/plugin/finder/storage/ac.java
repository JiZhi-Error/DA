package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.h;
import com.tencent.mm.g.b.a.ol;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aq;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004J(\u0010\u0019\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J&\u0010\u0019\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0004J(\u0010\u001b\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u001c\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderMvLogic;", "", "()V", "TAG", "", "playingPos", "", "getPlayingPos", "()I", "setPlayingPos", "(I)V", "createMusicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "musicSongInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicId", "musicType", "directPlayMusic", "", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "isPlayingPosValid", "", "isTheSameIdPlaying", "playId", "playMusic", "musicCoverUrl", "playOrPauseMusic", "resetPlayingPos", "plugin-finder_release"})
public final class ac {
    private static int vEQ = -1;
    public static final ac vER = new ac();

    static {
        AppMethodBeat.i(251829);
        AppMethodBeat.o(251829);
    }

    private ac() {
    }

    public static void KZ(int i2) {
        vEQ = i2;
    }

    public static void dxV() {
        vEQ = -1;
    }

    public static void a(axy axy, String str, css css) {
        AppMethodBeat.i(261388);
        p.h(axy, "musicSongInfo");
        p.h(str, "musicId");
        if (!avv(str)) {
            Log.i("FinderMvLogic", "playMusic");
            f a2 = a(axy, str, 0);
            ((a) g.af(a.class)).b(a2, h.a(str, css));
            com.tencent.mm.ay.a.c(a2);
            AppMethodBeat.o(261388);
            return;
        }
        Log.i("FinderMvLogic", "same music");
        AppMethodBeat.o(261388);
    }

    public static void a(axy axy, String str, int i2, String str2) {
        AppMethodBeat.i(261389);
        p.h(axy, "musicSongInfo");
        p.h(str, "musicId");
        p.h(str2, "musicCoverUrl");
        if (!avv(str)) {
            Log.i("FinderMvLogic", "playMusic");
            f a2 = a(axy, str, i2);
            ((a) g.af(a.class)).b(a2, h.bv(str, str2));
            com.tencent.mm.ay.a.c(a2);
            AppMethodBeat.o(261389);
            return;
        }
        Log.i("FinderMvLogic", "same music");
        AppMethodBeat.o(261389);
    }

    public static void b(axy axy, String str, css css) {
        AppMethodBeat.i(261390);
        f a2 = a(axy, str, 0);
        ((a) g.af(a.class)).b(a2, h.a(str, css));
        com.tencent.mm.ay.a.c(a2);
        ol olVar = new ol();
        olVar.PP(1);
        olVar.PQ(8);
        aq.a(olVar);
        AppMethodBeat.o(261390);
    }

    public static boolean avv(String str) {
        AppMethodBeat.i(251827);
        p.h(str, "playId");
        f bef = com.tencent.mm.ay.a.bef();
        if ((bef != null ? bef.jeV : null) != null && bef.jeT == 0 && com.tencent.mm.ay.a.bec()) {
            try {
                if (Util.isEqual(bef.jeV, str)) {
                    AppMethodBeat.o(251827);
                    return true;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(251827);
                return false;
            }
        }
        AppMethodBeat.o(251827);
        return false;
    }

    private static f a(axy axy, String str, int i2) {
        AppMethodBeat.i(261391);
        f fVar = new f();
        fVar.jeT = i2;
        fVar.jeV = str;
        fVar.jfi = axy.LIf;
        fVar.jeZ = axy.albumName;
        fVar.jeX = axy.BPc;
        fVar.jeY = axy.lDR;
        fVar.jfa = axy.Djf;
        fVar.jfm = axy.Djf;
        fVar.jfd = axy.LIg;
        fVar.jfb = axy.musicDataUrl;
        fVar.jfx = true;
        AppMethodBeat.o(261391);
        return fVar;
    }
}
