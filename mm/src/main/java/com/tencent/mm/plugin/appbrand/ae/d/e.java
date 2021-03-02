package com.tencent.mm.plugin.appbrand.ae.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.d.d;
import com.tencent.mm.plugin.appbrand.ae.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e implements c {
    protected static byte[] ojp = new byte[0];
    protected boolean ojq;
    protected d.a ojr;
    private ByteBuffer ojs;
    protected boolean ojt;

    public e() {
    }

    public e(d.a aVar) {
        AppMethodBeat.i(156660);
        this.ojr = aVar;
        this.ojs = ByteBuffer.wrap(ojp);
        AppMethodBeat.o(156660);
    }

    public e(d dVar) {
        AppMethodBeat.i(156661);
        this.ojq = dVar.bZI();
        this.ojr = dVar.bZK();
        this.ojs = dVar.bZH();
        this.ojt = dVar.bZJ();
        AppMethodBeat.o(156661);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.d
    public final boolean bZI() {
        return this.ojq;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.d
    public final d.a bZK() {
        return this.ojr;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.d
    public final boolean bZJ() {
        return this.ojt;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.d
    public ByteBuffer bZH() {
        return this.ojs;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.c
    public final void iX(boolean z) {
        this.ojq = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.c
    public final void a(d.a aVar) {
        this.ojr = aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.c
    public void A(ByteBuffer byteBuffer) {
        this.ojs = byteBuffer;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.c
    public final void iY(boolean z) {
        this.ojt = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.d
    public final void e(d dVar) {
        AppMethodBeat.i(156662);
        ByteBuffer bZH = dVar.bZH();
        if (this.ojs == null) {
            this.ojs = ByteBuffer.allocate(bZH.remaining());
            bZH.mark();
            this.ojs.put(bZH);
            bZH.reset();
        } else {
            bZH.mark();
            this.ojs.position(this.ojs.limit());
            this.ojs.limit(this.ojs.capacity());
            if (bZH.remaining() > this.ojs.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(bZH.remaining() + this.ojs.capacity());
                this.ojs.flip();
                allocate.put(this.ojs);
                allocate.put(bZH);
                this.ojs = allocate;
            } else {
                this.ojs.put(bZH);
            }
            this.ojs.rewind();
            bZH.reset();
        }
        this.ojq = dVar.bZI();
        AppMethodBeat.o(156662);
    }

    public String toString() {
        AppMethodBeat.i(156663);
        String str = "Framedata{ optcode:" + this.ojr + ", fin:" + this.ojq + ", payloadlength:[pos:" + this.ojs.position() + ", len:" + this.ojs.remaining() + "], payload:" + Arrays.toString(b.afS(new String(this.ojs.array()))) + "}";
        AppMethodBeat.o(156663);
        return str;
    }
}
