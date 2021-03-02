package com.tencent.kinda.framework.app;

import com.tencent.kinda.framework.jsapi.KindaJSInvokeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class SubCoreKinda implements bd {
    public static final String TAG = "MicroMsg.SubCoreKinda";
    private static HashMap<Integer, h.b> baseDBFactories;
    private KindaCacheStg cacheStg;
    private KindaConfigCacheStg configCacheStg;
    private KindaJSInvokeListener jsInvokeListener = new KindaJSInvokeListener();

    public SubCoreKinda() {
        AppMethodBeat.i(214431);
        AppMethodBeat.o(214431);
    }

    public static SubCoreKinda getCore() {
        AppMethodBeat.i(18563);
        SubCoreKinda subCoreKinda = (SubCoreKinda) y.at(SubCoreKinda.class);
        AppMethodBeat.o(18563);
        return subCoreKinda;
    }

    public KindaConfigCacheStg getConfigCacheStg() {
        AppMethodBeat.i(18564);
        if (!g.aAc()) {
            b bVar = new b();
            AppMethodBeat.o(18564);
            throw bVar;
        }
        if (getCore().configCacheStg == null) {
            getCore().configCacheStg = new KindaConfigCacheStg(g.aAh().hqK);
        }
        KindaConfigCacheStg kindaConfigCacheStg = getCore().configCacheStg;
        AppMethodBeat.o(18564);
        return kindaConfigCacheStg;
    }

    public KindaCacheStg getCacheStg() {
        AppMethodBeat.i(18565);
        if (!g.aAc()) {
            b bVar = new b();
            AppMethodBeat.o(18565);
            throw bVar;
        }
        if (getCore().cacheStg == null) {
            getCore().cacheStg = new KindaCacheStg(g.aAh().hqK);
        }
        KindaCacheStg kindaCacheStg = getCore().cacheStg;
        AppMethodBeat.o(18565);
        return kindaCacheStg;
    }

    static {
        AppMethodBeat.i(18566);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("KindaCacheTable".hashCode()), new h.b() {
            /* class com.tencent.kinda.framework.app.SubCoreKinda.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return KindaCacheStg.SQL_CREATE;
            }
        });
        AppMethodBeat.o(18566);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(214432);
        this.jsInvokeListener.alive();
        AppMethodBeat.o(214432);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
        AppMethodBeat.i(214433);
        this.jsInvokeListener.dead();
        AppMethodBeat.o(214433);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
    }
}
