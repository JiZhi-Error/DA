package com.tencent.mm.plugin.appbrand.ae.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.c.c;
import com.tencent.mm.plugin.appbrand.ae.d.d;
import java.nio.ByteBuffer;

public final class b extends e implements a {
    static final ByteBuffer ojh = ByteBuffer.allocate(0);
    private String cXS;
    private int code;

    static {
        AppMethodBeat.i(156656);
        AppMethodBeat.o(156656);
    }

    public b() {
        super(d.a.CLOSING);
        AppMethodBeat.i(156649);
        iX(true);
        AppMethodBeat.o(156649);
    }

    public b(int i2, String str) {
        super(d.a.CLOSING);
        String str2;
        AppMethodBeat.i(156650);
        iX(true);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (i2 == 1015) {
            str2 = "";
            i2 = 1005;
        }
        if (i2 != 1005) {
            byte[] afS = com.tencent.mm.plugin.appbrand.ae.f.b.afS(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i2);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(afS.length + 2);
            allocate2.put(allocate);
            allocate2.put(afS);
            allocate2.rewind();
            A(allocate2);
            AppMethodBeat.o(156650);
        } else if (str2.length() > 0) {
            com.tencent.mm.plugin.appbrand.ae.c.b bVar = new com.tencent.mm.plugin.appbrand.ae.c.b("A close frame must have a closecode if it has a reason");
            AppMethodBeat.o(156650);
            throw bVar;
        } else {
            AppMethodBeat.o(156650);
        }
    }

    private void bZF() {
        AppMethodBeat.i(156651);
        this.code = 1005;
        ByteBuffer bZH = super.bZH();
        bZH.mark();
        if (bZH.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(bZH.getShort());
            allocate.position(0);
            this.code = allocate.getInt();
            if (this.code == 1006 || this.code == 1015 || this.code == 1005 || this.code > 4999 || this.code < 1000 || this.code == 1004) {
                c cVar = new c("closecode must not be sent over the wire: " + this.code);
                AppMethodBeat.o(156651);
                throw cVar;
            }
        }
        bZH.reset();
        AppMethodBeat.o(156651);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.a
    public final int bZE() {
        return this.code;
    }

    private void bZG() {
        AppMethodBeat.i(156652);
        if (this.code == 1005) {
            this.cXS = com.tencent.mm.plugin.appbrand.ae.f.b.B(super.bZH());
            AppMethodBeat.o(156652);
            return;
        }
        ByteBuffer bZH = super.bZH();
        int position = bZH.position();
        try {
            bZH.position(bZH.position() + 2);
            this.cXS = com.tencent.mm.plugin.appbrand.ae.f.b.B(bZH);
            bZH.position(position);
            AppMethodBeat.o(156652);
        } catch (IllegalArgumentException e2) {
            c cVar = new c(e2);
            AppMethodBeat.o(156652);
            throw cVar;
        } catch (Throwable th) {
            bZH.position(position);
            AppMethodBeat.o(156652);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.a
    public final String getMessage() {
        return this.cXS;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.e
    public final String toString() {
        AppMethodBeat.i(156653);
        String str = super.toString() + "code: " + this.code;
        AppMethodBeat.o(156653);
        return str;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.e, com.tencent.mm.plugin.appbrand.ae.d.c
    public final void A(ByteBuffer byteBuffer) {
        AppMethodBeat.i(156654);
        super.A(byteBuffer);
        bZF();
        bZG();
        AppMethodBeat.o(156654);
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.d.e, com.tencent.mm.plugin.appbrand.ae.d.d
    public final ByteBuffer bZH() {
        AppMethodBeat.i(156655);
        if (this.code == 1005) {
            ByteBuffer byteBuffer = ojh;
            AppMethodBeat.o(156655);
            return byteBuffer;
        }
        ByteBuffer bZH = super.bZH();
        AppMethodBeat.o(156655);
        return bZH;
    }
}
