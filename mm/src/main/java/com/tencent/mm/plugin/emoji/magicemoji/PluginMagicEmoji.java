package com.tencent.mm.plugin.emoji.magicemoji;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.v;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.emoji.magicemoji.a.a;
import com.tencent.mm.sdk.platformtools.Log;

@Keep
public class PluginMagicEmoji extends f implements b, c, com.tencent.mm.plugin.emoji.magicemoji.a.b {
    private static final String TAG = "MicroMsg.PluginMagicEmoji";

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-magic-emoji";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(199704);
        alias(com.tencent.mm.plugin.emoji.magicemoji.a.b.class);
        AppMethodBeat.o(199704);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(199705);
        dependsOn(com.tencent.mm.plugin.appbrand.api.c.class);
        AppMethodBeat.o(199705);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(199706);
        Log.i(TAG, "hy: on account initialized");
        ((v) com.tencent.mm.kernel.g.af(v.class)).zX(0);
        com.tencent.mm.kernel.g.b(a.class, new com.tencent.mm.plugin.emoji.magicemoji.b.c());
        ((v) com.tencent.mm.kernel.g.af(v.class)).Vw();
        AppMethodBeat.o(199706);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
        AppMethodBeat.i(199707);
        com.tencent.mm.kernel.a.b.a.a(this, c.class).bI(com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.appbrand.api.c.class));
        AppMethodBeat.o(199707);
    }
}
