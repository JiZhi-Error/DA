package com.tencent.mm.plugin.sns.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class b {
    private static volatile b FcV;
    public Set<a> FcW = new HashSet();

    private b() {
        AppMethodBeat.i(176434);
        AppMethodBeat.o(176434);
    }

    public static b fkM() {
        AppMethodBeat.i(176435);
        if (FcV == null) {
            synchronized (b.class) {
                try {
                    if (FcV == null) {
                        FcV = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(176435);
                    throw th;
                }
            }
        }
        b bVar = FcV;
        AppMethodBeat.o(176435);
        return bVar;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(176436);
        this.FcW.add(aVar);
        for (a aVar2 : this.FcW) {
            if (aVar2 != aVar) {
                aVar2.pause();
            }
        }
        AppMethodBeat.o(176436);
    }

    public final void pause() {
        AppMethodBeat.i(176437);
        for (a aVar : this.FcW) {
            aVar.pause();
        }
        AppMethodBeat.o(176437);
    }
}
