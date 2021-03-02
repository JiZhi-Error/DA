package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class c {
    public static final a sHX = new a((byte) 0);

    static {
        AppMethodBeat.i(122576);
        AppMethodBeat.o(122576);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchConfig$Companion;", "", "()V", "TAG", "", "getConfig", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "Lkotlin/collections/ArrayList;", "sid", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ArrayList<dvk> aqe(String str) {
            AppMethodBeat.i(122575);
            p.h(str, "sid");
            p.g(d.cQe(), "HellSessionPageCloudConfig.getInstance()");
            dvh cQf = d.cQf();
            if (cQf == null) {
                AppMethodBeat.o(122575);
                return null;
            }
            ArrayList<dvk> arrayList = new ArrayList<>();
            Iterator<dvk> it = cQf.MWn.iterator();
            while (it.hasNext()) {
                dvk next = it.next();
                if (next != null && next.type == 1) {
                    if ((!(!p.j(next.sGF, str)) || !(!p.j(next.sGF, "-1"))) && !next.MWr.isEmpty()) {
                        arrayList.add(next);
                    }
                }
            }
            Log.i("HABBYGE-MALI.FuzzyMatchConfig", "FuzzyMatchConfig, getConfig: " + arrayList.size());
            AppMethodBeat.o(122575);
            return arrayList;
        }
    }
}
