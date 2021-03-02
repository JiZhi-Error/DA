package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.f.a;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.protocal.protobuf.eys;
import com.tencent.mm.sdk.platformtools.Util;

public final class c implements o.c.a {
    @Override // com.tencent.mm.pluginsdk.o.c.a
    public final String fVT() {
        AppMethodBeat.i(29977);
        eys eys = a.fVM().IxH.Iyu;
        if (eys != null) {
            String str = eys.Nvs + "\n" + eys.Nvt + "\n" + eys.Nvu;
            AppMethodBeat.o(29977);
            return str;
        }
        AppMethodBeat.o(29977);
        return "Not Connect";
    }

    @Override // com.tencent.mm.pluginsdk.o.c.a
    public final void fVU() {
        AppMethodBeat.i(29978);
        a.fVN().a(new a());
        AppMethodBeat.o(29978);
    }

    @Override // com.tencent.mm.pluginsdk.o.c.a
    public final boolean fVV() {
        String str = null;
        AppMethodBeat.i(29979);
        eys eys = a.fVM().IxH.Iyu;
        if (!Util.isNullOrNil((String) null) || !Util.isNullOrNil((String) null)) {
            if (Util.isNullOrNil((String) null)) {
                if (eys == null || !str.equals("gh_43f2581f6fd6")) {
                    AppMethodBeat.o(29979);
                    return false;
                }
                AppMethodBeat.o(29979);
                return true;
            } else if (Util.isNullOrNil((String) null)) {
                if (eys == null || !str.equals(eys.Nvp)) {
                    AppMethodBeat.o(29979);
                    return false;
                }
                AppMethodBeat.o(29979);
                return true;
            } else if (eys == null || !str.equals("gh_43f2581f6fd6") || !str.equals(eys.Nvp)) {
                AppMethodBeat.o(29979);
                return false;
            } else {
                AppMethodBeat.o(29979);
                return true;
            }
        } else if (eys != null) {
            AppMethodBeat.o(29979);
            return true;
        } else {
            AppMethodBeat.o(29979);
            return false;
        }
    }
}
