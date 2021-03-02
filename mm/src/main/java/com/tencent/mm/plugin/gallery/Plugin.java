package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(111228);
        AnonymousClass1 r0 = new n() {
            /* class com.tencent.mm.plugin.gallery.Plugin.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.n
            public final void a(m mVar) {
            }

            @Override // com.tencent.mm.pluginsdk.n
            public final void a(l lVar) {
            }
        };
        AppMethodBeat.o(111228);
        return r0;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(111229);
        AnonymousClass2 r0 = new bd() {
            /* class com.tencent.mm.plugin.gallery.Plugin.AnonymousClass2 */

            @Override // com.tencent.mm.model.bd
            public final HashMap<Integer, h.b> getBaseDBFactories() {
                return null;
            }

            @Override // com.tencent.mm.model.bd
            public final void clearPluginData(int i2) {
            }

            @Override // com.tencent.mm.model.bd
            public final void onAccountPostReset(boolean z) {
            }

            @Override // com.tencent.mm.model.bd
            public final void onSdcardMount(boolean z) {
            }

            @Override // com.tencent.mm.model.bd
            public final void onAccountRelease() {
            }
        };
        AppMethodBeat.o(111229);
        return r0;
    }
}
