package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class e implements bd {
    private a AAX = new a();

    public e() {
        AppMethodBeat.i(163198);
        AppMethodBeat.o(163198);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(26559);
        Log.i("MicroMsg.SubCoreNearLife", "onAccountPostReset SubCoreNearLife");
        g.b(com.tencent.mm.plugin.story.api.a.class, new com.tencent.mm.plugin.story.api.a() {
            /* class com.tencent.mm.plugin.nearlife.b.e.AnonymousClass1 */
        });
        g.b(a.class, this.AAX);
        AppMethodBeat.o(26559);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
    }
}
