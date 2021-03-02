package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.o;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.u;
import com.tencent.mm.plugin.i.a.ac;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J(\u0010\u0012\u001a\u00020\n2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderSwitchApi;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSwitchApi;", "()V", "TAG", "", "getFinderActivityShareBusinessType", "", "getUserInfoFinderSetting", "", "hasFinderSetting", "", "type", "setUserInfoFinderSetting", "", "finderSetting", "showFinderAtWxProfile", "showFinderEntryAtWxMe", "showFinderEntrySetting", "showFinderRecentLike", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "showFriendFinderEntry", "plugin-finder_release"})
public final class v implements ac {
    private static final String TAG = TAG;
    public static final v vXn = new v();

    static {
        AppMethodBeat.i(253547);
        AppMethodBeat.o(253547);
    }

    private v() {
    }

    @Override // com.tencent.mm.plugin.i.a.ac
    public final void Gf(long j2) {
        AppMethodBeat.i(253538);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_USER_INFO_FINDER_SETTING_LONG_SYNC, Long.valueOf(j2));
        AppMethodBeat.o(253538);
    }

    @Override // com.tencent.mm.plugin.i.a.ac
    public final long dCq() {
        AppMethodBeat.i(253539);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long a2 = aAh.azQ().a(ar.a.USERINFO_USER_INFO_FINDER_SETTING_LONG_SYNC, 0);
        AppMethodBeat.o(253539);
        return a2;
    }

    @Override // com.tencent.mm.plugin.i.a.ac
    public final boolean dCr() {
        AppMethodBeat.i(253540);
        if ((dCq() & 1) != 0) {
            AppMethodBeat.o(253540);
            return true;
        }
        AppMethodBeat.o(253540);
        return false;
    }

    @Override // com.tencent.mm.plugin.i.a.ac
    public final boolean dCs() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        AppMethodBeat.i(253541);
        y yVar = y.vXH;
        int dCL = y.dCL();
        com.tencent.mm.kernel.c.a af = g.af(b.class);
        p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        boolean Vt = ((b) af).Vt();
        c cVar = c.vCb;
        switch (c.dsI().value().intValue()) {
            case 1:
                z = true;
                break;
            case 2:
                z = Vt;
                dCL = 1;
                break;
            case 3:
                dCL = 4;
                z = Vt;
                break;
            default:
                z = Vt;
                break;
        }
        Log.i(TAG, "showFinderEntryAtWxMe teenMode:" + z + ", state:" + dCL);
        if (z) {
            AppMethodBeat.o(253541);
            return false;
        }
        switch (dCL) {
            case 1:
            case 4:
            case 5:
                AppMethodBeat.o(253541);
                return false;
            case 2:
            case 3:
            default:
                c cVar2 = c.vCb;
                if (c.dsJ().value().intValue() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c cVar3 = c.vCb;
                if (c.dsK().value().intValue() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                c cVar4 = c.vCb;
                if (c.dsL().value().intValue() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                y yVar2 = y.vXH;
                boolean dCG = y.dCG();
                Log.i(TAG, "showFinderEntryAtWxMe switchA:" + z2 + ", switchB:" + z3 + ", switchC:" + z4 + ", showFinderAtWxProfile:" + dCG);
                if (z2) {
                    AppMethodBeat.o(253541);
                    return true;
                } else if (!z3) {
                    AppMethodBeat.o(253541);
                    return false;
                } else if (!z4) {
                    AppMethodBeat.o(253541);
                    return false;
                } else if (dCG) {
                    AppMethodBeat.o(253541);
                    return true;
                } else {
                    AppMethodBeat.o(253541);
                    return false;
                }
        }
    }

    public static boolean dCt() {
        boolean z;
        AppMethodBeat.i(253542);
        y yVar = y.vXH;
        boolean dCB = y.dCB();
        c cVar = c.vCb;
        if (c.dsL().value().intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        Log.i(TAG, "showFinderEntrySetting hasFinderAccount" + dCB + ", switch:" + z);
        if (!dCB || !z) {
            AppMethodBeat.o(253542);
            return false;
        }
        AppMethodBeat.o(253542);
        return true;
    }

    @Override // com.tencent.mm.plugin.i.a.ac
    public final boolean dCu() {
        AppMethodBeat.i(253543);
        c cVar = c.vCb;
        if (c.dsL().value().intValue() == 1) {
            AppMethodBeat.o(253543);
            return true;
        }
        AppMethodBeat.o(253543);
        return false;
    }

    @Override // com.tencent.mm.plugin.i.a.ac
    public final boolean dCv() {
        AppMethodBeat.i(261477);
        y yVar = y.vXH;
        boolean dCG = y.dCG();
        AppMethodBeat.o(261477);
        return dCG;
    }

    @Override // com.tencent.mm.plugin.i.a.ac
    public final int dCw() {
        AppMethodBeat.i(253545);
        c cVar = c.vCb;
        int intValue = c.dwH().value().intValue();
        AppMethodBeat.o(253545);
        return intValue;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/utils/FinderSwitchApi$showFinderRecentLike$1", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "onCallback", "", "ret", "(Ljava/lang/Integer;)V", "plugin-finder_release"})
    public static final class a implements af.a<Integer> {
        final /* synthetic */ af.a tpa;

        a(af.a aVar) {
            this.tpa = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.i.a.af.a
        public final /* synthetic */ void bn(Integer num) {
            boolean z = true;
            AppMethodBeat.i(253537);
            Integer num2 = num;
            af.a aVar = this.tpa;
            if (aVar != null) {
                if (num2 == null || num2.intValue() != 1) {
                    z = false;
                }
                aVar.bn(Boolean.valueOf(z));
                AppMethodBeat.o(253537);
                return;
            }
            AppMethodBeat.o(253537);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.ac
    public final boolean a(af.a<Boolean> aVar) {
        AppMethodBeat.i(253546);
        u uVar = u.vXk;
        a aVar2 = new a(aVar);
        Integer num = u.vXj.get(1);
        if (num == null) {
            num = 0;
        }
        p.g(num, "requestTimeMap[exptId] ?: 0");
        if (cl.aWB() - num.intValue() > u.ufh) {
            new o(j.listOf((Object) 1)).aYI().g(new u.a(aVar2));
        }
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (aAh.azQ().getInt(ar.a.USERINFO_SHOW_FINDER_RECENT_LIKE_INT_SYNC, 0) == 1) {
            AppMethodBeat.o(253546);
            return true;
        }
        AppMethodBeat.o(253546);
        return false;
    }
}
