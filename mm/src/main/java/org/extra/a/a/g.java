package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.extra.a.a.c;

public final class g extends c.AbstractC2385c {
    public g(f fVar, c.b bVar, long j2) {
        AppMethodBeat.i(236810);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(bVar.UhJ ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = bVar.UhK + (((long) bVar.UhM) * j2);
        this.dDw = fVar.e(allocate, j3);
        this.offset = fVar.e(allocate, 4 + j3);
        this.UhR = fVar.e(allocate, 8 + j3);
        this.UhS = fVar.e(allocate, j3 + 20);
        AppMethodBeat.o(236810);
    }
}
