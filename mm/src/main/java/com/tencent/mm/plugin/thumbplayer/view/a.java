package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.e.b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000bR\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/view/MMCdnTPPlayerRecycler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "busyPlayerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "", "getBusyPlayerMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getContext", "()Landroid/content/Context;", "idlePlayers", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getIdlePlayers", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "destroy", "", "getOrCreatePlayer", "recyclePlayer", "player", "plugin-thumbplayer_release"})
public final class a {
    public final ConcurrentLinkedDeque<b> Gia = new ConcurrentLinkedDeque<>();
    public final ConcurrentHashMap<b, Long> Gib = new ConcurrentHashMap<>();
    private final String TAG = "MicroMsg.TP.MMCdnTPPlayerRecycler";
    private final Context context;

    public a(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(238750);
        this.context = context2;
        AppMethodBeat.o(238750);
    }
}
