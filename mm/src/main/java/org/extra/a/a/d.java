package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.extra.a.a.c;

public final class d extends c.b {
    private final f UhU;

    public d(boolean z, f fVar) {
        AppMethodBeat.i(236792);
        this.UhJ = z;
        this.UhU = fVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.type = fVar.f(allocate, 16);
        this.UhK = fVar.e(allocate, 28);
        this.UhL = fVar.e(allocate, 32);
        this.UhM = fVar.f(allocate, 42);
        this.UhN = fVar.f(allocate, 44);
        this.UhO = fVar.f(allocate, 46);
        this.UhP = fVar.f(allocate, 48);
        this.UhQ = fVar.f(allocate, 50);
        AppMethodBeat.o(236792);
    }

    @Override // org.extra.a.a.c.b
    public final c.d hPS() {
        AppMethodBeat.i(236793);
        i iVar = new i(this.UhU, this);
        AppMethodBeat.o(236793);
        return iVar;
    }

    @Override // org.extra.a.a.c.b
    public final c.AbstractC2385c Pv(long j2) {
        AppMethodBeat.i(236794);
        g gVar = new g(this.UhU, this, j2);
        AppMethodBeat.o(236794);
        return gVar;
    }

    @Override // org.extra.a.a.c.b
    public final c.a aw(long j2, int i2) {
        AppMethodBeat.i(236795);
        a aVar = new a(this.UhU, this, j2, i2);
        AppMethodBeat.o(236795);
        return aVar;
    }
}
