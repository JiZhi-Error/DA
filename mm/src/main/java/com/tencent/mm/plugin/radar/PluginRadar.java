package com.tencent.mm.plugin.radar;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/radar/PluginRadar;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/radar/api/IPluginRadar;", "()V", "configure", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "Companion", "plugin-radar_release"})
public final class PluginRadar extends f implements com.tencent.mm.plugin.radar.a.a {
    public static final a BxY = new a((byte) 0);
    private static final String TAG = TAG;

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(g gVar) {
        AppMethodBeat.i(138490);
        p.h(gVar, Scopes.PROFILE);
        if (gVar.aBb()) {
            Log.i(TAG, "PluginRadar configure");
            pin(new y(b.class));
        }
        AppMethodBeat.o(138490);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(138491);
        p.h(gVar, Scopes.PROFILE);
        b.bfQ("radar");
        AppMethodBeat.o(138491);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/radar/PluginRadar$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138492);
        AppMethodBeat.o(138492);
    }
}
