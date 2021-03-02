package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public final class j {

    public static class a {
        public List<i> SDP;
        public String dZc;

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final boolean I(double d2) {
            AppMethodBeat.i(219073);
            if (this.SDP == null) {
                AppMethodBeat.o(219073);
                return false;
            }
            for (i iVar : this.SDP) {
                if (iVar.SDM <= d2 && iVar.SDN >= d2) {
                    if (((double) XWalkEnvironment.getTodayGrayValue()) < 10000.0d * iVar.H(d2)) {
                        AppMethodBeat.o(219073);
                        return true;
                    }
                    AppMethodBeat.o(219073);
                    return false;
                }
            }
            AppMethodBeat.o(219073);
            return false;
        }
    }
}
