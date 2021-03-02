package com.tencent.mm.plugin.teenmode.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

public final class c implements b {
    /* synthetic */ c(byte b2) {
        this();
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final boolean Vt() {
        AppMethodBeat.i(187373);
        Log.w("MicroMsg.TeenModeServiceProxy", "isTeenMode not implemented in non-MM process");
        AppMethodBeat.o(187373);
        return false;
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final int dxW() {
        AppMethodBeat.i(187374);
        Log.w("MicroMsg.TeenModeServiceProxy", "getFinderOption not implemented in non-MM process");
        AppMethodBeat.o(187374);
        return 0;
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final int fvo() {
        AppMethodBeat.i(187375);
        Log.w("MicroMsg.TeenModeServiceProxy", "getBizAcctOption not implemented in non-MM process");
        AppMethodBeat.o(187375);
        return 0;
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final int fvp() {
        AppMethodBeat.i(187376);
        Log.w("MicroMsg.TeenModeServiceProxy", "getMiniProgramOption not implemented in non-MM process");
        AppMethodBeat.o(187376);
        return 0;
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final void hr(Context context) {
        AppMethodBeat.i(187377);
        u.u(context, context.getString(R.string.hme), R.raw.teen_mode);
        AppMethodBeat.o(187377);
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final void pl(int i2) {
        AppMethodBeat.i(187378);
        Log.w("MicroMsg.TeenModeServiceProxy", "report not implemented in non-MM process");
        AppMethodBeat.o(187378);
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final boolean fvr() {
        AppMethodBeat.i(187379);
        Log.w("MicroMsg.TeenModeServiceProxy", "isHideTeenModeEntrance not implemented in non-MM process");
        AppMethodBeat.o(187379);
        return false;
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final void a(com.tencent.mm.plugin.teenmode.a.c cVar) {
        AppMethodBeat.i(187380);
        Log.w("MicroMsg.TeenModeServiceProxy", "registerTeenModeDataChangedListener not implemented in non-MM process");
        AppMethodBeat.o(187380);
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final void b(com.tencent.mm.plugin.teenmode.a.c cVar) {
        AppMethodBeat.i(187381);
        Log.w("MicroMsg.TeenModeServiceProxy", "unregisterTeenModeDataChangedListener not implemented in non-MM process");
        AppMethodBeat.o(187381);
    }

    @Override // com.tencent.mm.plugin.teenmode.a.b
    public final void fvq() {
        AppMethodBeat.i(187382);
        Log.w("MicroMsg.TeenModeServiceProxy", "notifyTeenModeDataChanged not implemented in non-MM process");
        AppMethodBeat.o(187382);
    }

    static class a {
        public static c FWl = new c((byte) 0);

        static {
            AppMethodBeat.i(187372);
            AppMethodBeat.o(187372);
        }
    }

    public static c fvt() {
        return a.FWl;
    }

    private c() {
    }
}
