package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.extra.a.a.c;

public final class i extends c.d {
    public i(f fVar, c.b bVar) {
        AppMethodBeat.i(236812);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(bVar.UhJ ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.UhT = fVar.e(allocate, bVar.UhL + ((long) (bVar.UhO * 0)) + 28);
        AppMethodBeat.o(236812);
    }
}
