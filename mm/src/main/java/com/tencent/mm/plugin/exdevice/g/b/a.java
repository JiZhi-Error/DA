package com.tencent.mm.plugin.exdevice.g.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public final class a {
    SparseArray<WeakReference<e>> rCW;

    public final void a(e eVar) {
        AppMethodBeat.i(23543);
        Assert.assertTrue(true);
        if (this.rCW == null) {
            this.rCW = new SparseArray<>();
        }
        this.rCW.put(eVar.hashCode(), new WeakReference<>(eVar));
        AppMethodBeat.o(23543);
    }

    public final void b(e eVar) {
        AppMethodBeat.i(23544);
        Assert.assertTrue(true);
        if (this.rCW == null) {
            Log.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort ");
            AppMethodBeat.o(23544);
            return;
        }
        this.rCW.remove(eVar.hashCode());
        AppMethodBeat.o(23544);
    }

    public final void a(String str, d dVar) {
        AppMethodBeat.i(23545);
        Assert.assertTrue(true);
        if (this.rCW == null) {
            Log.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort");
            AppMethodBeat.o(23545);
            return;
        }
        for (int i2 = 0; i2 < this.rCW.size(); i2++) {
            e eVar = this.rCW.get(this.rCW.keyAt(i2)).get();
            if (eVar != null) {
                eVar.b(str, dVar);
            }
        }
        Log.d("MicroMsg.ExdeviceRankCallbackManager", "hy: publish end");
        AppMethodBeat.o(23545);
    }
}
