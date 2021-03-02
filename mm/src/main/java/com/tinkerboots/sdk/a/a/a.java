package com.tinkerboots.sdk.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.b.c;
import com.tinkerboots.sdk.b.d;
import java.util.Map;

public class a implements b {
    @Override // com.tinkerboots.sdk.a.a.b
    public boolean dZo() {
        AppMethodBeat.i(3437);
        Context context = c.getContext();
        com.tencent.tinker.lib.e.a lk = com.tencent.tinker.lib.e.a.lk(context);
        if (!com.tinkerboots.sdk.b.a.isConnected(context)) {
            ShareTinkerLog.v("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, not connect to internet", new Object[0]);
            AppMethodBeat.o(3437);
            return false;
        } else if (b.lm(context)) {
            ShareTinkerLog.v("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, tinker service is running", new Object[0]);
            AppMethodBeat.o(3437);
            return false;
        } else if (!lk.FgY) {
            ShareTinkerLog.v("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, only request on the main process", new Object[0]);
            AppMethodBeat.o(3437);
            return false;
        } else if (d.hwc()) {
            ShareTinkerLog.v("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, is in ignore channel, current channel:%s", d.hwb());
            AppMethodBeat.o(3437);
            return false;
        } else {
            AppMethodBeat.o(3437);
            return true;
        }
    }

    @Override // com.tinkerboots.sdk.a.a.b
    public void ao(Map<String, String> map) {
    }

    @Override // com.tinkerboots.sdk.a.a.b
    public void dZp() {
    }
}
