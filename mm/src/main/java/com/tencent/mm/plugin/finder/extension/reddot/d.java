package com.tencent.mm.plugin.finder.extension.reddot;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotDuplicateChecker;", "", "()V", "RED_DOT_DB_LIMIT", "", "TAG", "", "check", "", "redDotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "reportRedDotExceedLimit", "", "count", "plugin-finder_release"})
public final class d {
    public static final d tJq = new d();

    static {
        AppMethodBeat.i(243510);
        AppMethodBeat.o(243510);
    }

    private d() {
    }

    public static boolean a(LinkedList<k> linkedList, c cVar) {
        AppMethodBeat.i(243509);
        p.h(linkedList, "redDotList");
        p.h(cVar, "storage");
        int size = linkedList.size();
        if (size > 100) {
            br brVar = new br();
            brVar.jX("1");
            brVar.ew(10001);
            brVar.jY(String.valueOf(size));
            brVar.bfK();
        }
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_REDDOT_DELETE_DUP_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(243509);
            throw tVar;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        Log.i("Finder.RedDotDuplicateChecker", "[check] isDbDuplicateDeleted=" + booleanValue + ' ');
        if (!booleanValue) {
            long currentTimeMillis = System.currentTimeMillis();
            SparseArray sparseArray = new SparseArray();
            for (T t : linkedList) {
                int i2 = ((k) t).field_ctrInfo.type;
                k kVar = (k) sparseArray.get(i2);
                if (kVar == null) {
                    sparseArray.put(i2, t);
                } else if (((k) t).field_time > kVar.field_time && !t.dbz()) {
                    sparseArray.put(i2, t);
                }
            }
            linkedList.clear();
            cVar.db.execSQL("FinderRedDotInfo", "delete from FinderRedDotInfo");
            int size2 = sparseArray.size();
            for (int i3 = 0; i3 < size2; i3++) {
                int keyAt = sparseArray.keyAt(i3);
                k kVar2 = (k) sparseArray.get(keyAt);
                Log.i("Finder.RedDotDuplicateChecker", " key " + keyAt + ", " + kVar2);
                if (kVar2 != null) {
                    k.a(kVar2, cVar);
                    linkedList.add(kVar2);
                }
            }
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_REDDOT_DELETE_DUP_BOOLEAN_SYNC, Boolean.TRUE);
            Log.i("Finder.RedDotDuplicateChecker", "[check] COST=" + (System.currentTimeMillis() - currentTimeMillis) + LocaleUtil.MALAY);
            AppMethodBeat.o(243509);
            return true;
        }
        AppMethodBeat.o(243509);
        return false;
    }
}
