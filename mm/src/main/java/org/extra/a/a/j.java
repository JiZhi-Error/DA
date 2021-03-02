package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.extra.a.a.c;

public final class j extends c.d {
    public j(f fVar, c.b bVar) {
        AppMethodBeat.i(236813);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(bVar.UhJ ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.UhT = fVar.e(allocate, bVar.UhL + ((long) (bVar.UhO * 0)) + 44);
        AppMethodBeat.o(236813);
    }
}
