package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.extra.a.a.c;

public final class b extends c.a {
    public b(f fVar, c.b bVar, long j2, int i2) {
        AppMethodBeat.i(236791);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(bVar.UhJ ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = ((long) (i2 * 16)) + j2;
        this.UhH = fVar.d(allocate, j3);
        this.UhI = fVar.d(allocate, j3 + 8);
        AppMethodBeat.o(236791);
    }
}
