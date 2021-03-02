package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcherFactory;", "", "()V", "getFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "", "plugin-story_release"})
public final class e {
    public static final e Fqp = new e();

    static {
        AppMethodBeat.i(119080);
        AppMethodBeat.o(119080);
    }

    private e() {
    }

    public static com.tencent.mm.plugin.story.api.l aSj(String str) {
        AppMethodBeat.i(119079);
        String str2 = str;
        if (!(str2 == null || n.aL(str2))) {
            MMHandlerThread aAk = g.aAk();
            p.g(aAk, "MMKernel.getPizzaWorkerThread()");
            if (aAk.getLooper() != null) {
                if (ab.Ix(str)) {
                    d dVar = new d(str);
                    AppMethodBeat.o(119079);
                    return dVar;
                }
                b bVar = new b(str);
                AppMethodBeat.o(119079);
                return bVar;
            }
        }
        AppMethodBeat.o(119079);
        return null;
    }
}
