package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a implements com.google.android.exoplayer2.metadata.a {
    @Override // com.google.android.exoplayer2.metadata.a
    public final Metadata a(d dVar) {
        AppMethodBeat.i(92395);
        ByteBuffer byteBuffer = dVar.aKP;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        m mVar = new m(array, limit);
        String xn = mVar.xn();
        String xn2 = mVar.xn();
        long dE = mVar.dE();
        mVar.eZ(4);
        Metadata metadata = new Metadata(new EventMessage(xn, xn2, (mVar.dE() * 1000) / dE, mVar.dE(), Arrays.copyOfRange(array, mVar.position, limit)));
        AppMethodBeat.o(92395);
        return metadata;
    }
}
