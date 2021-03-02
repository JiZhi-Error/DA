package com.google.android.exoplayer2.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class e extends a {
    public ByteBuffer aKP;
    public final b bhp = new b();
    public final int bhq;
    public long timeUs;

    public e(int i2) {
        AppMethodBeat.i(91850);
        this.bhq = i2;
        AppMethodBeat.o(91850);
    }

    public final void dM(int i2) {
        AppMethodBeat.i(91851);
        if (this.aKP == null) {
            this.aKP = dN(i2);
            AppMethodBeat.o(91851);
            return;
        }
        int capacity = this.aKP.capacity();
        int position = this.aKP.position();
        int i3 = position + i2;
        if (capacity >= i3) {
            AppMethodBeat.o(91851);
            return;
        }
        ByteBuffer dN = dN(i3);
        if (position > 0) {
            this.aKP.position(0);
            this.aKP.limit(position);
            dN.put(this.aKP);
        }
        this.aKP = dN;
        AppMethodBeat.o(91851);
    }

    public final boolean uh() {
        AppMethodBeat.i(91852);
        boolean dL = dL(1073741824);
        AppMethodBeat.o(91852);
        return dL;
    }

    public final void ui() {
        AppMethodBeat.i(91853);
        this.aKP.flip();
        AppMethodBeat.o(91853);
    }

    @Override // com.google.android.exoplayer2.b.a
    public final void clear() {
        AppMethodBeat.i(91854);
        super.clear();
        if (this.aKP != null) {
            this.aKP.clear();
        }
        AppMethodBeat.o(91854);
    }

    private ByteBuffer dN(int i2) {
        AppMethodBeat.i(91855);
        if (this.bhq == 1) {
            ByteBuffer allocate = ByteBuffer.allocate(i2);
            AppMethodBeat.o(91855);
            return allocate;
        } else if (this.bhq == 2) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
            AppMethodBeat.o(91855);
            return allocateDirect;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Buffer too small (" + (this.aKP == null ? 0 : this.aKP.capacity()) + " < " + i2 + ")");
            AppMethodBeat.o(91855);
            throw illegalStateException;
        }
    }
}
