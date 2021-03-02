package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

public final class b {
    public int gCF = 0;
    public int gCG = 0;
    public byte[] gCH = null;
    public int gCI = 0;
    public int gCJ = 0;
    public boolean gCK = false;
    public Lock gCL = null;

    public final int anD() {
        AppMethodBeat.i(155548);
        if (this.gCK) {
            this.gCL.lock();
        }
        if (this.gCI == this.gCJ) {
            AppMethodBeat.o(155548);
            return 0;
        }
        if (this.gCI < this.gCJ) {
            this.gCG = this.gCJ - this.gCI;
        } else if (this.gCI > this.gCJ) {
            this.gCG = (this.gCJ + this.gCF) - this.gCI;
        }
        if (this.gCK) {
            this.gCL.unlock();
        }
        int i2 = this.gCG;
        AppMethodBeat.o(155548);
        return i2;
    }
}
