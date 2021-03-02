package com.tencent.mm.plugin.expt.d.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class b {
    public r.a syB;

    public final boolean a(List<List<com.tencent.mm.plugin.expt.d.e.b>> list, com.tencent.mm.plugin.expt.d.e.a.b bVar) {
        AppMethodBeat.i(220377);
        if (this.syB == null || list == null || list.size() <= 0 || bVar == null) {
            AppMethodBeat.o(220377);
            return false;
        }
        Log.d("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult, configID : %s", bVar.syg);
        a aVar = new a(this.syB, bVar.syg, bVar.sym);
        if (!aVar.cNc()) {
            Log.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult create table for isnot exist!");
            if (!aVar.cNd()) {
                Log.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult createTable fail!");
                AppMethodBeat.o(220377);
                return false;
            } else if (!aVar.cNe()) {
                Log.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult createIndex fail!");
            }
        } else {
            aVar.cNf();
        }
        boolean dp = aVar.dp(list);
        AppMethodBeat.o(220377);
        return dp;
    }
}
