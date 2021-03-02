package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import java.util.HashSet;

public final class l implements e.a {
    private static l PBl;
    HashSet<Long> PBm = new HashSet<>();
    e.a PBn;

    private l() {
        AppMethodBeat.i(36338);
        AppMethodBeat.o(36338);
    }

    public static l gTf() {
        AppMethodBeat.i(36339);
        if (PBl == null) {
            PBl = new l();
        }
        l lVar = PBl;
        AppMethodBeat.o(36339);
        return lVar;
    }

    public final boolean NS(long j2) {
        AppMethodBeat.i(36340);
        boolean contains = this.PBm.contains(Long.valueOf(j2));
        AppMethodBeat.o(36340);
        return contains;
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, q qVar) {
        AppMethodBeat.i(36341);
        if (this.PBn != null) {
            this.PBn.a(j2, j3, i2, i3, obj, i4, i5, qVar);
        }
        AppMethodBeat.o(36341);
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, q qVar) {
        AppMethodBeat.i(36342);
        if (this.PBn != null) {
            this.PBn.a(j2, j3, i2, i3, obj, i4, i5, str, qVar);
        } else {
            bg.aVF();
            ca Hb = c.aSQ().Hb(j3);
            Log.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", Long.valueOf(Hb.field_msgId));
            b.d(MMApplicationContext.getContext(), Hb, false);
        }
        this.PBm.remove(Long.valueOf(j3));
        AppMethodBeat.o(36342);
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj) {
        AppMethodBeat.i(36343);
        if (this.PBn != null) {
            this.PBn.a(j2, j3, i2, i3, obj);
        }
        this.PBm.remove(Long.valueOf(j3));
        AppMethodBeat.o(36343);
    }
}
