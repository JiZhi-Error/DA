package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.z;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0004J(\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderStatLogic;", "", "()V", "LIMIT_PER_COUNT", "", "RETRY_COUNT", "TAG", "", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "feedId", "", "mediaType", "sessionBuffer", "commentScene", "sendStatsLimit", "", "list", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hasTryTime", "plugin-finder_release"})
public final class s {
    public static final s vhF = new s();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ bbn $contextObj;
        final /* synthetic */ LinkedList vhG;
        final /* synthetic */ LinkedList vhH;
        final /* synthetic */ int vhI;

        a(LinkedList linkedList, LinkedList linkedList2, bbn bbn, int i2) {
            this.vhG = linkedList;
            this.vhH = linkedList2;
            this.$contextObj = bbn;
            this.vhI = i2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(250794);
            c.a aVar = (c.a) obj;
            if (aVar.errCode == 0 && aVar.errType == 0) {
                Log.i("Finder.StatLogicReporter", "successfully! size=" + this.vhG.size());
                s sVar = s.vhF;
                s.a(this.vhH, this.$contextObj, 0);
            } else if (this.vhI <= 2) {
                this.vhH.addAll(0, this.vhG);
                Log.i("Finder.StatLogicReporter", "failure! try next time, size=" + this.vhG.size());
                s sVar2 = s.vhF;
                s.a(this.vhH, this.$contextObj, this.vhI + 1);
            } else {
                StringBuilder append = new StringBuilder("tryCount=").append(this.vhI).append(", throw this sendList=");
                LinkedList<ecq> linkedList = this.vhG;
                ArrayList arrayList = new ArrayList(j.a(linkedList, 10));
                for (ecq ecq : linkedList) {
                    arrayList.add(d.zs(ecq.hFK));
                }
                Log.e("Finder.StatLogicReporter", append.append(arrayList).toString());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250794);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(250797);
        AppMethodBeat.o(250797);
    }

    private s() {
    }

    public static void a(List<? extends ecq> list, bbn bbn, int i2) {
        AppMethodBeat.i(250795);
        p.h(list, "list");
        if (i2 > 2 || list.isEmpty()) {
            AppMethodBeat.o(250795);
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        if (list.size() > 20) {
            linkedList2.addAll(list.subList(0, 20));
            linkedList.addAll(list.subList(20, list.size()));
        } else {
            linkedList2.addAll(list);
        }
        Log.i("Finder.StatLogicReporter", "[sendStatsLimit] list=" + list.size() + " tryCount=" + i2);
        new z(linkedList2, bbn).aYH().aYI().j(new a(linkedList2, linkedList, bbn, i2));
        AppMethodBeat.o(250795);
    }

    public static ecq a(long j2, String str, int i2) {
        AppMethodBeat.i(250796);
        ecq ecq = new ecq();
        ecq.NcN = new epf();
        ecq.NcM = new mp();
        ecq.NcO = new cxr();
        ecq.hFK = j2;
        ecq.tCE = i2;
        ecq.sessionBuffer = str;
        ecq.finderUsername = com.tencent.mm.model.z.aUg();
        ecq.NcP = cl.aWA();
        ecq.mediaType = 2004;
        AppMethodBeat.o(250796);
        return ecq;
    }
}
