package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.q;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class ac extends q<LocalUsageInfo> {
    public ac(List<LocalUsageInfo> list, List<LocalUsageInfo> list2) {
        super(bl(list), bl(list2));
        AppMethodBeat.i(44643);
        AppMethodBeat.o(44643);
    }

    private static <T> ArrayList<T> bl(List<T> list) {
        AppMethodBeat.i(44644);
        if (list instanceof ArrayList) {
            ArrayList<T> arrayList = (ArrayList) list;
            AppMethodBeat.o(44644);
            return arrayList;
        } else if (Util.isNullOrNil(list)) {
            ArrayList<T> arrayList2 = new ArrayList<>(0);
            AppMethodBeat.o(44644);
            return arrayList2;
        } else {
            ArrayList<T> arrayList3 = new ArrayList<>(list.size());
            arrayList3.addAll(list);
            AppMethodBeat.o(44644);
            return arrayList3;
        }
    }

    @Override // android.support.v7.h.c.a
    public final boolean i(int i2, int i3) {
        AppMethodBeat.i(44645);
        LocalUsageInfo localUsageInfo = (LocalUsageInfo) this.oew.get(i2);
        LocalUsageInfo localUsageInfo2 = (LocalUsageInfo) this.oex.get(i3);
        if (!Util.nullAsNil(localUsageInfo.username).equals(localUsageInfo2.username) || localUsageInfo.iOo != localUsageInfo2.iOo) {
            AppMethodBeat.o(44645);
            return false;
        }
        AppMethodBeat.o(44645);
        return true;
    }

    @Override // android.support.v7.h.c.a
    public final boolean j(int i2, int i3) {
        AppMethodBeat.i(44646);
        boolean equals = Util.nullAsNil(((LocalUsageInfo) this.oew.get(i2)).kVZ).equals(((LocalUsageInfo) this.oex.get(i3)).kVZ);
        AppMethodBeat.o(44646);
        return equals;
    }

    @Override // android.support.v7.h.c.a
    public final Object h(int i2, int i3) {
        AppMethodBeat.i(44647);
        if (i2 >= this.oew.size()) {
            AppMethodBeat.o(44647);
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            LocalUsageInfo localUsageInfo = (LocalUsageInfo) this.oew.get(i2);
            LocalUsageInfo localUsageInfo2 = (LocalUsageInfo) this.oex.get(i3);
            if (!Util.nullAsNil(localUsageInfo.kVZ).equals(localUsageInfo2.kVZ)) {
                bundle.putString("icon", localUsageInfo2.kVZ);
            }
            if (!Util.nullAsNil(localUsageInfo.nickname).equals(localUsageInfo2.nickname)) {
                bundle.putString("nick_name", localUsageInfo2.nickname);
            }
        } catch (Exception e2) {
            bundle.clear();
        }
        if (bundle.size() <= 0) {
            AppMethodBeat.o(44647);
            return null;
        }
        AppMethodBeat.o(44647);
        return bundle;
    }
}
