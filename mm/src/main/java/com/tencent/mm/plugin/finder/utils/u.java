package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J.\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderSvrExptManager;", "", "()V", "TAG", "", "requestInterval", "", "requestTimeMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getHitCache", "exptId", "getSvrExptHitValue", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "setHitCache", "", "value", "plugin-finder_release"})
public final class u {
    private static final String TAG = TAG;
    static int ufh = 300;
    static final HashMap<Integer, Integer> vXj = new HashMap<>();
    public static final u vXk = new u();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetSvrExptConfigResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ af.a tpa;
        final /* synthetic */ int vXl = 1;
        final /* synthetic */ af.a vXm;

        a(af.a aVar) {
            this.tpa = aVar;
            this.vXm = null;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            LinkedList<bdc> linkedList;
            T t;
            boolean z;
            AppMethodBeat.i(253534);
            c.a aVar = (c.a) obj;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                u uVar = u.vXk;
                atr atr = (atr) aVar.iLC;
                u.ufh = atr != null ? atr.LED : 300;
                atr atr2 = (atr) aVar.iLC;
                if (!(atr2 == null || (linkedList = atr2.LEC) == null)) {
                    Iterator<T> it = linkedList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        T next = it.next();
                        if (next.LMV == this.vXl) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            t = next;
                            break;
                        }
                    }
                    T t2 = t;
                    if (t2 != null) {
                        u uVar2 = u.vXk;
                        u.gn(this.vXl, t2.LMU);
                        af.a aVar2 = this.tpa;
                        if (aVar2 != null) {
                            aVar2.bn(Integer.valueOf(t2.LMU));
                        }
                    }
                }
            } else {
                af.a aVar3 = this.vXm;
                if (aVar3 != null) {
                    aVar3.bn(Integer.valueOf(aVar.errCode));
                }
            }
            if ((aVar.errType == 0 && aVar.errCode == 0) || aVar.errType == 4) {
                u uVar3 = u.vXk;
                u.vXj.put(Integer.valueOf(this.vXl), Integer.valueOf(cl.aWB()));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253534);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(253536);
        AppMethodBeat.o(253536);
    }

    private u() {
    }

    public static void gn(int i2, int i3) {
        AppMethodBeat.i(253535);
        Log.i(TAG, "setHitCache, exptId:" + i2 + ", value:" + i3);
        switch (i2) {
            case 1:
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_SHOW_FINDER_RECENT_LIKE_INT_SYNC, Integer.valueOf(i3));
                break;
        }
        AppMethodBeat.o(253535);
    }
}
