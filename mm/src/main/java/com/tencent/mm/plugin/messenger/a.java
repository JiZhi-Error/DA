package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.as;

public final class a implements b {
    @Override // com.tencent.mm.plugin.messenger.a.b
    public final String getDisplayName(String str, String str2) {
        AppMethodBeat.i(90700);
        String displayName = aa.getDisplayName(str, str2);
        AppMethodBeat.o(90700);
        return displayName;
    }

    @Override // com.tencent.mm.plugin.messenger.a.b
    public final String getDisplayName(String str) {
        AppMethodBeat.i(90701);
        String displayName = aa.getDisplayName(str);
        AppMethodBeat.o(90701);
        return displayName;
    }

    @Override // com.tencent.mm.plugin.messenger.a.b
    public final String b(as asVar, String str) {
        AppMethodBeat.i(90702);
        String b2 = aa.b(asVar, str);
        AppMethodBeat.o(90702);
        return b2;
    }

    @Override // com.tencent.mm.plugin.messenger.a.b
    public final String Ir(String str) {
        AppMethodBeat.i(90703);
        String Ir = aa.Ir(str);
        AppMethodBeat.o(90703);
        return Ir;
    }

    @Override // com.tencent.mm.plugin.messenger.a.b
    public final String b(as asVar) {
        AppMethodBeat.i(90704);
        String b2 = aa.b(asVar);
        AppMethodBeat.o(90704);
        return b2;
    }

    @Override // com.tencent.mm.plugin.messenger.a.b
    public final String It(String str) {
        AppMethodBeat.i(168685);
        String It = aa.It(str);
        AppMethodBeat.o(168685);
        return It;
    }
}
