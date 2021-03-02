package com.tencent.mm.plugin.appbrand.m;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0006\u0010\u000b\u001a\u00020\n¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheDirectoryTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class ac extends as {
    @Deprecated
    public static final a mOd = new a((byte) 0);

    static {
        AppMethodBeat.i(50726);
        AppMethodBeat.o(50726);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheDirectoryTransfer$Companion;", "", "()V", "PREF_KEY_TRANSFER_FINISHED", "", "TAG", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.model.as
    @SuppressLint({"ApplySharedPref"})
    public final void transfer(int i2) {
        AppMethodBeat.i(50724);
        s.deleteDir(ad.bMM());
        String bML = ad.bML();
        if (bML != null) {
            String bMK = ad.bMK();
            if (s.YS(bML) && !s.YS(bMK) && !com.tencent.mm.plugin.appbrand.appstorage.l.cE(bML, bMK)) {
                s.boN(bMK);
                s.ny(bML, bMK);
            }
            s.deleteDir(bML);
        }
        PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer_transfer_finished", true).commit();
        AppMethodBeat.o(50724);
    }

    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        AppMethodBeat.i(50725);
        if (!PluginAppBrand.getProcessSharedPrefs().getBoolean("MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer_transfer_finished", false)) {
            AppMethodBeat.o(50725);
            return true;
        }
        AppMethodBeat.o(50725);
        return false;
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer";
    }
}
