package com.tencent.mm.plugin.pwdgroup;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.b.f;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.pwdgroup.b;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class c implements bd {
    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(27618);
        b.a.Boe = new j.a() {
            /* class com.tencent.mm.plugin.pwdgroup.c.AnonymousClass1 */
            private f<String, WeakReference<Bitmap>> Bof;
            private Bitmap dku = null;

            {
                AppMethodBeat.i(27615);
                try {
                    this.dku = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.Facing.SubCorePwdGroup", e2, "", new Object[0]);
                }
                this.Bof = new com.tencent.mm.memory.a.b(15, getClass());
                AppMethodBeat.o(27615);
            }

            @Override // com.tencent.mm.pluginsdk.ui.j.a
            public final void a(j jVar) {
                AppMethodBeat.i(27616);
                if (jVar instanceof e.a) {
                    p.aYn().a((e.a) jVar);
                }
                AppMethodBeat.o(27616);
            }

            @Override // com.tencent.mm.pluginsdk.ui.j.a
            public final Bitmap fZ(String str) {
                AppMethodBeat.i(27617);
                WeakReference<Bitmap> weakReference = this.Bof.get(str);
                if (weakReference == null || weakReference.get() == null || weakReference.get().isRecycled() || weakReference.get() != Wg()) {
                    Bitmap a2 = com.tencent.mm.aj.c.a(str, false, -1, null);
                    if (a2 == null || a2.isRecycled()) {
                        a2 = this.dku;
                    } else {
                        this.Bof.x(str, new WeakReference<>(a2));
                    }
                    AppMethodBeat.o(27617);
                    return a2;
                }
                Bitmap bitmap = weakReference.get();
                AppMethodBeat.o(27617);
                return bitmap;
            }

            @Override // com.tencent.mm.pluginsdk.ui.j.a
            public final Bitmap Wg() {
                return this.dku;
            }

            @Override // com.tencent.mm.pluginsdk.ui.j.a
            public final Bitmap ga(String str) {
                return null;
            }

            @Override // com.tencent.mm.pluginsdk.ui.j.a
            public final Bitmap a(String str, int i2, int i3, int i4) {
                return null;
            }
        };
        AppMethodBeat.o(27618);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
    }
}
