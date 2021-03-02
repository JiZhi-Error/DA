package com.tencent.mm.plugin.festival.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.b.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u0013\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalMusicListProvider;", "", "()V", "interval", "", "getInterval", "()J", "setInterval", "(J)V", "musicList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishMusic;", "Lkotlin/collections/ArrayList;", "getMusicList", "()Ljava/util/ArrayList;", "notifyMusicList", "", "list", "", "pollInterval", "plugin-festival_release"})
public final class q {
    private static final ArrayList<i> UyA = new ArrayList<>();
    public static final q UyB = new q();
    private static long interval = 5000;

    static {
        AppMethodBeat.i(263022);
        AppMethodBeat.o(263022);
    }

    private q() {
    }

    public static ArrayList<i> hdY() {
        return UyA;
    }

    public static long getInterval() {
        return interval;
    }

    public static void k(List<? extends i> list, long j2) {
        AppMethodBeat.i(263021);
        p.h(list, "list");
        if (!UyA.isEmpty()) {
            AppMethodBeat.o(263021);
            return;
        }
        UyA.clear();
        UyA.addAll(list);
        interval = j2;
        AppMethodBeat.o(263021);
    }
}
