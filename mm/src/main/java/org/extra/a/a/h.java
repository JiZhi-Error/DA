package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.extra.a.a.c;

public final class h extends c.AbstractC2385c {
    public h(f fVar, c.b bVar, long j2) {
        AppMethodBeat.i(236811);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(bVar.UhJ ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = bVar.UhK + (((long) bVar.UhM) * j2);
        this.dDw = fVar.e(allocate, j3);
        this.offset = fVar.d(allocate, 8 + j3);
        this.UhR = fVar.d(allocate, 16 + j3);
        this.UhS = fVar.d(allocate, j3 + 40);
        AppMethodBeat.o(236811);
    }
}
