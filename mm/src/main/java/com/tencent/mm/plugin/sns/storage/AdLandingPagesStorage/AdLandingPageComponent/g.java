package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;

public final class g extends q {
    public String DXZ;
    public long DYa;
    public String dOD;

    public final String toString() {
        AppMethodBeat.i(96314);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[disableWording:").append(this.DXZ).append(", hbCoverId:").append(this.dOD).append(", disableTime:").append(this.DYa).append("]");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(96314);
        return stringBuffer2;
    }

    public final boolean isExpired() {
        AppMethodBeat.i(96315);
        try {
            long aWB = (long) (cl.aWB() * 1000);
            if (this.DYa <= 0 || this.DYa >= aWB) {
                AppMethodBeat.o(96315);
                return false;
            }
            AppMethodBeat.o(96315);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(96315);
            return false;
        }
    }
}
