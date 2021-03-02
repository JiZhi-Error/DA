package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/logic/FinderObjectWordingConfig;", "", "()V", "SRV_Placeholder", "", "configMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "Lkotlin/collections/HashMap;", "getExtInfo", "type", "preLoadIcon", "", "info", "resetConfig", "infoList", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfoList;", "plugin-finder_release"})
public final class g {
    private static final HashMap<Integer, azu> hDh = new HashMap<>();
    public static final g vGW = new g();

    static {
        AppMethodBeat.i(252099);
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_OBJECT_WORDING_CONFIG_STRING_SYNC, "");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(252099);
            throw tVar;
        }
        byte[] decodeHexString = Util.decodeHexString((String) obj);
        azv azv = new azv();
        azv.parseFrom(decodeHexString);
        a(azv);
        AppMethodBeat.o(252099);
    }

    private g() {
    }

    public static azu Lj(int i2) {
        AppMethodBeat.i(252097);
        c cVar = c.vCb;
        if (c.duG().value().intValue() == 1) {
            i2 = 1;
        }
        azu azu = hDh.get(Integer.valueOf(i2));
        AppMethodBeat.o(252097);
        return azu;
    }

    public static void a(azv azv) {
        AppMethodBeat.i(252098);
        p.h(azv, "infoList");
        hDh.clear();
        LinkedList<azu> linkedList = azv.LJM;
        if (linkedList != null) {
            for (T t : linkedList) {
                Integer valueOf = Integer.valueOf(t.objectType);
                p.g(t, LocaleUtil.ITALIAN);
                hDh.put(valueOf, t);
                m mVar = m.uJa;
                d<o> djY = m.djY();
                com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(t.LJE, x.FULL_IMAGE);
                m mVar2 = m.uJa;
                djY.a(pVar, m.a(m.a.TIMELINE));
                m mVar3 = m.uJa;
                d<o> djY2 = m.djY();
                com.tencent.mm.plugin.finder.loader.p pVar2 = new com.tencent.mm.plugin.finder.loader.p(t.LJF, x.FULL_IMAGE);
                m mVar4 = m.uJa;
                djY2.a(pVar2, m.a(m.a.TIMELINE));
                m mVar5 = m.uJa;
                d<o> djY3 = m.djY();
                com.tencent.mm.plugin.finder.loader.p pVar3 = new com.tencent.mm.plugin.finder.loader.p(t.LJG, x.FULL_IMAGE);
                m mVar6 = m.uJa;
                djY3.a(pVar3, m.a(m.a.TIMELINE));
                m mVar7 = m.uJa;
                d<o> djY4 = m.djY();
                com.tencent.mm.plugin.finder.loader.p pVar4 = new com.tencent.mm.plugin.finder.loader.p(t.LJH, x.FULL_IMAGE);
                m mVar8 = m.uJa;
                djY4.a(pVar4, m.a(m.a.TIMELINE));
            }
        }
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_OBJECT_WORDING_CONFIG_STRING_SYNC, Util.encodeHexString(azv.toByteArray()));
        AppMethodBeat.o(252098);
    }
}
