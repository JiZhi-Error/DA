package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    anr Cqx = null;
    rc Cqy;

    public final void eNC() {
        AppMethodBeat.i(67922);
        Log.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
        this.Cqy = null;
        this.Cqx = null;
        AppMethodBeat.o(67922);
    }

    public final List<ans> eND() {
        AppMethodBeat.i(67923);
        if (this.Cqy != null) {
            LinkedList<ans> linkedList = this.Cqy.KXX;
            AppMethodBeat.o(67923);
            return linkedList;
        }
        LinkedList linkedList2 = new LinkedList();
        AppMethodBeat.o(67923);
        return linkedList2;
    }

    public final String eNE() {
        if (this.Cqy == null) {
            return "";
        }
        return this.Cqy.KYb;
    }

    public final boolean eNF() {
        if (this.Cqy != null) {
            return true;
        }
        return false;
    }

    public final boolean eNG() {
        AppMethodBeat.i(67924);
        if (this.Cqy == null || this.Cqy.KXX == null || this.Cqy.KXX.size() <= 0) {
            AppMethodBeat.o(67924);
            return false;
        }
        AppMethodBeat.o(67924);
        return true;
    }

    public final void aMi(String str) {
        AppMethodBeat.i(67925);
        this.Cqx = null;
        if (str == null) {
            this.Cqx = null;
            AppMethodBeat.o(67925);
        } else if (this.Cqy == null) {
            Log.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
            this.Cqx = null;
            AppMethodBeat.o(67925);
        } else {
            Iterator<anr> it = this.Cqy.KXY.iterator();
            while (it.hasNext()) {
                anr next = it.next();
                if (str.equals(next.LyJ)) {
                    this.Cqx = next;
                    AppMethodBeat.o(67925);
                    return;
                }
            }
            AppMethodBeat.o(67925);
        }
    }

    public final boolean a(List<ans> list, ans ans) {
        AppMethodBeat.i(67926);
        if (this.Cqy == null) {
            Log.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
            AppMethodBeat.o(67926);
            return false;
        }
        String bigInteger = ans != null ? new BigInteger(Long.toBinaryString(ans.LyS), 2).toString() : null;
        LinkedList<anr> linkedList = new LinkedList();
        Iterator<anr> it = this.Cqy.KXY.iterator();
        while (it.hasNext()) {
            anr next = it.next();
            if (ans == null || (!Util.isNullOrNil(bigInteger) && next.LyJ.contains(bigInteger))) {
                linkedList.add(next);
            }
        }
        LinkedList linkedList2 = new LinkedList();
        for (anr anr : linkedList) {
            if (a(list, anr)) {
                linkedList2.add(anr);
            }
        }
        if (linkedList2.size() > 0) {
            Collections.sort(linkedList2, new a());
            this.Cqx = (anr) linkedList2.get(0);
            AppMethodBeat.o(67926);
            return true;
        }
        this.Cqx = null;
        AppMethodBeat.o(67926);
        return false;
    }

    private static boolean a(List<ans> list, anr anr) {
        AppMethodBeat.i(67927);
        if (anr.KXX.size() == 0) {
            AppMethodBeat.o(67927);
            return false;
        }
        HashSet hashSet = new HashSet();
        for (ans ans : list) {
            hashSet.add(Long.valueOf(ans.LyS));
        }
        Iterator<ans> it = anr.KXX.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(Long.valueOf(it.next().LyS))) {
                AppMethodBeat.o(67927);
                return false;
            }
        }
        AppMethodBeat.o(67927);
        return true;
    }

    /* access modifiers changed from: package-private */
    public class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((anr) obj).LyN - ((anr) obj2).LyN > 0 ? -1 : 1;
        }
    }
}
