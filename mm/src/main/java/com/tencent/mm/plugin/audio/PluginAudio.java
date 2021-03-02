package com.tencent.mm.plugin.audio;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/audio/PluginAudio;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/audio/api/IPluginAudio;", "()V", "configure", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "name", "", "Companion", "plugin-audio_release"})
public final class PluginAudio extends f implements com.tencent.mm.plugin.audio.a.a {
    public static final a oHB = new a((byte) 0);

    static {
        AppMethodBeat.i(223933);
        AppMethodBeat.o(223933);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/audio/PluginAudio$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(g gVar) {
        AppMethodBeat.i(223932);
        if (gVar != null && gVar.aBb()) {
            Log.i("MicroMsg.PluginAudio", "PluginAudio configure");
            pin(new y(com.tencent.mm.plugin.audio.c.a.class));
        }
        AppMethodBeat.o(223932);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public final String name() {
        return "plugin-audio";
    }
}
