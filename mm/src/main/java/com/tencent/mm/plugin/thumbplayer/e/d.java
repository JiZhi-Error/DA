package com.tencent.mm.plugin.thumbplayer.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayerFactory;", "", "()V", "Companion", "plugin-thumbplayer_release"})
public final class d {
    public static final a GhZ = new a((byte) 0);

    static {
        AppMethodBeat.i(238749);
        AppMethodBeat.o(238749);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/player/MMTPPlayerFactory$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "context", "Landroid/content/Context;", "threadLooper", "Landroid/os/Looper;", "callbackLoop", "createCdnPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "plugin-thumbplayer_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static a ht(Context context) {
            AppMethodBeat.i(238747);
            p.h(context, "context");
            c cVar = new c(context);
            AppMethodBeat.o(238747);
            return cVar;
        }

        public static b hu(Context context) {
            AppMethodBeat.i(238748);
            p.h(context, "context");
            b bVar = new b(context);
            AppMethodBeat.o(238748);
            return bVar;
        }
    }
}
