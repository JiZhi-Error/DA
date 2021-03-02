package com.tencent.mm.plugin.recordvideo.res;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/PluginVideoRes;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/plugin/IPlugin;", "()V", "CLASS", "", "getCLASS", "()Ljava/lang/String;", "setCLASS", "(Ljava/lang/String;)V", "configure", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "name", "Companion", "plugin-recordvideo_release"})
public final class PluginVideoRes extends f implements d {
    public static final a BYf = new a((byte) 0);
    private String CLASS = "com.tencent.mm.plugin.recordvideo.res.PluginVideoRes";

    static {
        AppMethodBeat.i(237480);
        AppMethodBeat.o(237480);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/PluginVideoRes$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final String getCLASS() {
        return this.CLASS;
    }

    public final void setCLASS(String str) {
        AppMethodBeat.i(237478);
        p.h(str, "<set-?>");
        this.CLASS = str;
        AppMethodBeat.o(237478);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(g gVar) {
        AppMethodBeat.i(237479);
        if (gVar != null && gVar.aBb()) {
            Log.i("MicroMsg.PluginVideoRes", "PluginVideoRes configure");
            pin(new y(c.class));
        }
        AppMethodBeat.o(237479);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public final String name() {
        return "plugin-videoRes";
    }
}
