package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r implements i {
    private Map<Class<? extends j>, j> cEr = new ConcurrentHashMap();

    public r() {
        AppMethodBeat.i(215555);
        AppMethodBeat.o(215555);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.i
    public final String getName() {
        return "VideoPlayer#Stub";
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.i
    public final <AddOn extends j> void a(Class<AddOn> cls, AddOn addon) {
        AppMethodBeat.i(215556);
        if (addon == null) {
            this.cEr.remove(cls);
            AppMethodBeat.o(215556);
            return;
        }
        this.cEr.put(cls, addon);
        AppMethodBeat.o(215556);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.i
    public final <AddOn extends j> AddOn X(Class<AddOn> cls) {
        AppMethodBeat.i(215557);
        AddOn addon = (AddOn) this.cEr.get(cls);
        if (addon == null || !cls.isInstance(addon)) {
            AppMethodBeat.o(215557);
            return null;
        }
        AppMethodBeat.o(215557);
        return addon;
    }
}
