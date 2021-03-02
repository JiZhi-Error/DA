package com.google.android.exoplayer2.f.b;

import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.b.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a extends b {
    private final b bBF;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        AppMethodBeat.i(92790);
        m mVar = new m(list.get(0));
        this.bBF = new b(mVar.readUnsignedShort(), mVar.readUnsignedShort());
        AppMethodBeat.o(92790);
    }

    @Override // com.google.android.exoplayer2.f.b
    public final /* synthetic */ d b(byte[] bArr, int i2, boolean z) {
        AppMethodBeat.i(92791);
        if (z) {
            b.h hVar = this.bBF.bBN;
            hVar.bBZ.clear();
            hVar.bCr.clear();
            hVar.bCs.clear();
            hVar.bCt.clear();
            hVar.bCu.clear();
            hVar.bCv = null;
            hVar.bCw = null;
        }
        c cVar = new c(this.bBF.g(bArr, i2));
        AppMethodBeat.o(92791);
        return cVar;
    }
}
