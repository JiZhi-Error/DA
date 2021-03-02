package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private Map<Integer, FloatCompHelperWithLifecycle> DtX = new ConcurrentHashMap();
    private b DtY;

    public a() {
        AppMethodBeat.i(202003);
        AppMethodBeat.o(202003);
    }

    public final FloatJumpCompHelper a(d dVar, ViewGroup viewGroup) {
        AppMethodBeat.i(202004);
        if (dVar == null || viewGroup == null) {
            AppMethodBeat.o(202004);
            return null;
        }
        try {
            FloatJumpCompHelper floatJumpCompHelper = new FloatJumpCompHelper(dVar, viewGroup);
            this.DtX.put(Integer.valueOf(dVar.type), floatJumpCompHelper);
            AppMethodBeat.o(202004);
            return floatJumpCompHelper;
        } catch (Throwable th) {
            AppMethodBeat.o(202004);
            return null;
        }
    }

    public final b a(i.a aVar) {
        b bVar = null;
        AppMethodBeat.i(202005);
        if (aVar == null) {
            AppMethodBeat.o(202005);
        } else {
            try {
                this.DtY = new b(aVar);
                bVar = this.DtY;
                AppMethodBeat.o(202005);
            } catch (Throwable th) {
                AppMethodBeat.o(202005);
            }
        }
        return bVar;
    }

    public final List<m> eXi() {
        AppMethodBeat.i(202006);
        try {
            ArrayList arrayList = new ArrayList();
            for (FloatCompHelperWithLifecycle floatCompHelperWithLifecycle : this.DtX.values()) {
                m eXj = floatCompHelperWithLifecycle.eXj();
                if (eXj != null) {
                    arrayList.add(eXj);
                }
            }
            if (this.DtY != null) {
                List<m> allComp = this.DtY.getAllComp();
                if (c.o(allComp)) {
                    arrayList.addAll(allComp);
                }
            }
            AppMethodBeat.o(202006);
            return arrayList;
        } catch (Throwable th) {
            AppMethodBeat.o(202006);
            return null;
        }
    }
}
