package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.i;
import com.tencent.mm.plugin.appbrand.jsapi.audio.m;
import com.tencent.mm.plugin.appbrand.jsapi.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o.e;
import com.tencent.mm.plugin.appbrand.jsapi.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.y.c;
import java.util.Collection;
import java.util.HashSet;

public class n implements k {
    public static final n nxG = new n();
    protected Collection<Class<? extends e>> nxH = new HashSet();
    protected Collection<Class<? extends e>> nxI = new HashSet();

    static {
        AppMethodBeat.i(147665);
        AppMethodBeat.o(147665);
    }

    protected n() {
        AppMethodBeat.i(147662);
        this.nxH.add(b.a.class);
        this.nxH.add(c.a.class);
        this.nxH.add(e.a.class);
        this.nxI.add(f.class);
        this.nxI.add(com.tencent.mm.plugin.appbrand.jsapi.p.c.class);
        this.nxI.add(h.class);
        this.nxI.add(JsApiGetMusicPlayerState.class);
        this.nxI.add(JsApiGetBackgroundAudioState.class);
        this.nxI.add(com.tencent.mm.plugin.appbrand.jsapi.audio.e.class);
        this.nxI.add(com.tencent.mm.plugin.appbrand.jsapi.audio.f.class);
        this.nxI.add(h.class);
        this.nxI.add(m.class);
        this.nxI.add(i.class);
        AppMethodBeat.o(147662);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.appbrand.permission.n */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.appbrand.permission.k
    public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.e eVar) {
        AppMethodBeat.i(147663);
        if (eVar == null) {
            AppMethodBeat.o(147663);
            return false;
        }
        boolean aG = aG(eVar.getClass());
        AppMethodBeat.o(147663);
        return aG;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.k
    public final boolean aG(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e> cls) {
        AppMethodBeat.i(147664);
        if (cls == null) {
            AppMethodBeat.o(147664);
            return false;
        } else if (this.nxI.contains(cls) || this.nxH.contains(cls)) {
            AppMethodBeat.o(147664);
            return true;
        } else {
            AppMethodBeat.o(147664);
            return false;
        }
    }
}
