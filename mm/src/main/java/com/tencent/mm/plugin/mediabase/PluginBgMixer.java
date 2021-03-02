package com.tencent.mm.plugin.mediabase;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.recordvideo.background.c.b;
import com.tencent.mm.plugin.recordvideo.background.c.d;
import com.tencent.mm.plugin.recordvideo.background.c.e;
import com.tencent.mm.plugin.vlog.remux.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u00012\u00020\u0002:\u0001\bB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/mediabase/PluginBgMixer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IPluginBgMixer;", "()V", "execute", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "Companion", "plugin-base_release"})
public final class PluginBgMixer extends f implements b {
    public static final a zoD = new a((byte) 0);

    static {
        AppMethodBeat.i(62523);
        AppMethodBeat.o(62523);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mediabase/PluginBgMixer$Companion;", "", "()V", "TAG", "", "plugin-base_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(62522);
        Log.i("MicroMsg.PluginBgMixer", "PluginBgMixer execute!");
        d dVar = d.BMq;
        d.a(0, new e());
        d dVar2 = d.BMq;
        d.a(1, new c());
        AppMethodBeat.o(62522);
    }
}
