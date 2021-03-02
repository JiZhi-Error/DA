package com.tencent.mm.ag;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class x extends s {
    public x() {
        AppMethodBeat.i(116419);
        this.iAi = new v();
        AppMethodBeat.o(116419);
    }

    public final void t(Intent intent) {
        AppMethodBeat.i(116420);
        try {
            if (g.aAe().azG().aBb() && ((this.iAi.type == 5 || this.iAi.type == 8) && this.iAj.size() == 0)) {
                this.iAj.add(aSA());
            }
            intent.putExtra("biz_mp_msg_info", toByteArray());
            intent.putExtra("rawUrl", this.iAi.url);
            AppMethodBeat.o(116420);
        } catch (IOException e2) {
            Log.e("MicroMsg.MPMsgInfo", "writeToIntent %s", e2.getMessage());
            AppMethodBeat.o(116420);
        }
    }

    public final void z(Bundle bundle) {
        AppMethodBeat.i(116421);
        try {
            if (g.aAe().azG().aBb() && ((this.iAi.type == 5 || this.iAi.type == 8) && this.iAj.size() == 0)) {
                this.iAj.add(aSA());
            }
            bundle.putByteArray("biz_mp_msg_info", toByteArray());
            bundle.putString("rawUrl", this.iAi.url);
            AppMethodBeat.o(116421);
        } catch (IOException e2) {
            Log.e("MicroMsg.MPMsgInfo", "writeToIntent %s", e2.getMessage());
            AppMethodBeat.o(116421);
        }
    }

    private String aSA() {
        AppMethodBeat.i(116422);
        String bdu = s.bdu(b.u(this.iAi.iAo, 4));
        AppMethodBeat.o(116422);
        return bdu;
    }

    public final void u(Intent intent) {
        AppMethodBeat.i(116423);
        try {
            parseFrom(intent.getByteArrayExtra("biz_mp_msg_info"));
            AppMethodBeat.o(116423);
        } catch (IOException e2) {
            Log.e("MicroMsg.MPMsgInfo", "parseFromIntent %s", e2.getMessage());
            AppMethodBeat.o(116423);
        } catch (Exception e3) {
            Log.e("MicroMsg.MPMsgInfo", "parseFromIntent %s", e3.getMessage());
            AppMethodBeat.o(116423);
        }
    }

    public final void A(Bundle bundle) {
        AppMethodBeat.i(116424);
        try {
            parseFrom(bundle.getByteArray("biz_mp_msg_info"));
            AppMethodBeat.o(116424);
        } catch (IOException e2) {
            Log.e("MicroMsg.MPMsgInfo", "parseFromBundle %s", e2.getMessage());
            AppMethodBeat.o(116424);
        } catch (Exception e3) {
            Log.e("MicroMsg.MPMsgInfo", "parseFromBundle %s", e3.getMessage());
            AppMethodBeat.o(116424);
        }
    }

    public static boolean rK(int i2) {
        return (i2 & 1) != 0;
    }

    public final String ajO() {
        boolean z;
        if (this.type == 285212721) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return this.userName;
        }
        return this.dHc;
    }
}
