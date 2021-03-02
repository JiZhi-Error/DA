package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class av implements aa, MMActivity.a {
    public final int requestCode = (av.class.hashCode() & 65535);

    public void onReady() {
    }

    public void bNL() {
    }

    protected av() {
        AppMethodBeat.i(47308);
        AppMethodBeat.o(47308);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.aa
    public final boolean bNh() {
        return true;
    }

    public void bNM() {
        AppMethodBeat.i(47309);
        if (d.oD(17)) {
            onReady();
        }
        AppMethodBeat.o(47309);
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public final void d(int i2, int i3, Intent intent) {
        AppMethodBeat.i(47310);
        if (this.requestCode != i2) {
            AppMethodBeat.o(47310);
        } else if (i3 == -1) {
            Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download ok");
            h.bWb().zn(0);
            onReady();
            AppMethodBeat.o(47310);
        } else if (i3 == 2) {
            Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs cancel loading, download in background");
            bNL();
            AppMethodBeat.o(47310);
        } else {
            Log.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", Integer.valueOf(i3), Integer.valueOf(Build.VERSION.SDK_INT));
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(366, 8, 1, false);
            bNM();
            AppMethodBeat.o(47310);
        }
    }
}
