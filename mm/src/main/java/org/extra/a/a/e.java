package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.extra.a.a.c;

public final class e extends c.b {
    private final f UhU;

    public e(boolean z, f fVar) {
        AppMethodBeat.i(236796);
        this.UhJ = z;
        this.UhU = fVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.type = fVar.f(allocate, 16);
        this.UhK = fVar.d(allocate, 32);
        this.UhL = fVar.d(allocate, 40);
        this.UhM = fVar.f(allocate, 54);
        this.UhN = fVar.f(allocate, 56);
        this.UhO = fVar.f(allocate, 58);
        this.UhP = fVar.f(allocate, 60);
        this.UhQ = fVar.f(allocate, 62);
        AppMethodBeat.o(236796);
    }

    @Override // org.extra.a.a.c.b
    public final c.d hPS() {
        AppMethodBeat.i(236797);
        j jVar = new j(this.UhU, this);
        AppMethodBeat.o(236797);
        return jVar;
    }

    @Override // org.extra.a.a.c.b
    public final c.AbstractC2385c Pv(long j2) {
        AppMethodBeat.i(236798);
        h hVar = new h(this.UhU, this, j2);
        AppMethodBeat.o(236798);
        return hVar;
    }

    @Override // org.extra.a.a.c.b
    public final c.a aw(long j2, int i2) {
        AppMethodBeat.i(236799);
        b bVar = new b(this.UhU, this, j2, i2);
        AppMethodBeat.o(236799);
        return bVar;
    }
}
