package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;

/* access modifiers changed from: package-private */
public final class k {
    final boolean enable;

    k(boolean z) {
        this.enable = z;
    }

    /* access modifiers changed from: package-private */
    public final ArrayList<AppBrandRecentTaskInfo> L(ArrayList<AppBrandRecentTaskInfo> arrayList) {
        AppMethodBeat.i(49208);
        if (!this.enable || Util.isNullOrNil(arrayList)) {
            AppMethodBeat.o(49208);
            return arrayList;
        }
        ArrayList<AppBrandRecentTaskInfo> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<AppBrandRecentTaskInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            AppBrandRecentTaskInfo next = it.next();
            if (!next.kVp) {
                arrayList2.add(next);
            }
        }
        AppMethodBeat.o(49208);
        return arrayList2;
    }
}
