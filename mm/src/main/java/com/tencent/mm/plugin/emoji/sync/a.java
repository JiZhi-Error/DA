package com.tencent.mm.plugin.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.sync.b;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class a<T extends c> {
    public BKGLoaderManager rds;

    public a() {
        AppMethodBeat.i(108744);
        b.a aVar = new b.a();
        aVar.rdt = 1;
        aVar.rdu = 10;
        aVar.rdv = new b.C0960b(aVar.rdt, aVar.rdt, new com.tencent.mm.av.a.e.a());
        a(new b(aVar));
        AppMethodBeat.o(108744);
    }

    private synchronized void a(b bVar) {
        AppMethodBeat.i(108745);
        if (this.rds == null) {
            this.rds = new BKGLoaderManager(bVar);
            AppMethodBeat.o(108745);
        } else {
            Log.i("MicroMsg.BKGLoader.BKGLoader", "[cpan] BKGLoader had init.");
            AppMethodBeat.o(108745);
        }
    }

    public final void X(ArrayList<c> arrayList) {
        AppMethodBeat.i(108746);
        this.rds.di(arrayList);
        AppMethodBeat.o(108746);
    }
}
