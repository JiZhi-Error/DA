package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.extra.a.a.c;

public final class a extends c.a {
    public a(f fVar, c.b bVar, long j2, int i2) {
        AppMethodBeat.i(236790);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(bVar.UhJ ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = ((long) (i2 * 8)) + j2;
        this.UhH = fVar.e(allocate, j3);
        this.UhI = fVar.e(allocate, j3 + 4);
        AppMethodBeat.o(236790);
    }
}
