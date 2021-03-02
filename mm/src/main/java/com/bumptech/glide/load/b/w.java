package com.bumptech.glide.load.b;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.f;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

/* access modifiers changed from: package-private */
public final class w implements d.a<Object>, f {
    private final g<?> aFL;
    private final f.a aFM;
    private int aFN;
    private g aFO;
    private List<n<File, ?>> aFP;
    private int aFQ;
    private volatile n.a<?> aFR;
    private File aFS;
    private int aHZ = -1;
    private x aIa;

    w(g<?> gVar, f.a aVar) {
        this.aFL = gVar;
        this.aFM = aVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 140
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    @Override // com.bumptech.glide.load.b.f
    public final boolean ow() {
        /*
        // Method dump skipped, instructions count: 331
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.w.ow():boolean");
    }

    private boolean ox() {
        AppMethodBeat.i(77047);
        if (this.aFQ < this.aFP.size()) {
            AppMethodBeat.o(77047);
            return true;
        }
        AppMethodBeat.o(77047);
        return false;
    }

    @Override // com.bumptech.glide.load.b.f
    public final void cancel() {
        AppMethodBeat.i(77048);
        n.a<?> aVar = this.aFR;
        if (aVar != null) {
            aVar.aKh.cancel();
        }
        AppMethodBeat.o(77048);
    }

    @Override // com.bumptech.glide.load.a.d.a
    public final void S(Object obj) {
        AppMethodBeat.i(77049);
        this.aFM.a(this.aFO, obj, this.aFR.aKh, a.RESOURCE_DISK_CACHE, this.aIa);
        AppMethodBeat.o(77049);
    }

    @Override // com.bumptech.glide.load.a.d.a
    public final void e(Exception exc) {
        AppMethodBeat.i(77050);
        this.aFM.a(this.aIa, exc, this.aFR.aKh, a.RESOURCE_DISK_CACHE);
        AppMethodBeat.o(77050);
    }
}
