package com.tencent.mm.plugin.eggspring.ui;

import com.tencent.mm.t.a.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0007"}, hxF = {"isCoupon", "", "Lcom/tencent/mm/eggspring/model/Material;", "isGoods", "isGreeting", "isMoney", "isRedPackage", "plugin-eggspring_release"})
public final class a {
    public static final boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        return jVar.gTr == 2 || jVar.gTr == 1;
    }

    public static final boolean b(j jVar) {
        if (jVar != null && jVar.gTr == 6) {
            return true;
        }
        return false;
    }

    public static final boolean c(j jVar) {
        if (jVar != null && jVar.gTr == 4) {
            return true;
        }
        return false;
    }

    public static final boolean d(j jVar) {
        if (jVar != null && jVar.gTr == 3) {
            return true;
        }
        return false;
    }
}
