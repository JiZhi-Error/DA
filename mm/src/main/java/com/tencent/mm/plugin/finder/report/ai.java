package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.g.b.a.bh;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\tH\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\tH\u0002J,\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010!\u001a\u00020\tH\u0002J\u0006\u0010$\u001a\u00020\u0004J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010!\u001a\u00020\tH\u0002J\u0018\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\tH\u0002J\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020\u001cJ\u0016\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014J\u0010\u0010-\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010/J\u000e\u00100\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0004J\u0014\u00100\u001a\u00020\u001c2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011J\u0014\u00102\u001a\u00020\u001c2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eJ,\u00102\u001a\u00020\u001c2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e2\u0006\u0010!\u001a\u00020\tH\u0002J\u0012\u00104\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\b\u00105\u001a\u00020\u001cH\u0002J\u0010\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u000208H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "chatExposeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "chatListRecord", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "getChatListRecord", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "clickChatExposeMap", "clickChatExposeSet", "", "currentChatExposeSet", "delClickCountL", "", "dotClickCountL", "isOnProcess", "", "()Z", "setOnProcess", "(Z)V", "copySet", "", "src", "", "dst", "getExposePv", "type", "getExposeUV", "getMapContainer", "getSessionId", "getSetContainer", "incChatExpose", "key", "incDelClickCount", "incDotClickCount", "onEnterChatList", "accountType", "isGreetSession", "onExitChatList", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "recordChatClickExpose", "curRecordSet", "recordChatExpose", "exposeSet", "report20688", "resetChatListRecord", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-finder_release"})
public final class ai {
    private final String TAG = "RecordFinderChatList";
    public boolean viM;
    public final d.a viN = new d.a();
    private final Set<String> viO = new HashSet();
    private final HashMap<String, Integer> viP = new HashMap<>();
    private final Set<String> viQ = new HashSet();
    private final HashMap<String, Integer> viR = new HashMap<>();
    public long viS;
    private long viT;

    public ai() {
        AppMethodBeat.i(250880);
        AppMethodBeat.o(250880);
    }

    public final void R(long j2, long j3) {
        AppMethodBeat.i(250868);
        doX();
        d.a aVar = this.viN;
        aVar.vdq = j2;
        aVar.vds = j3;
        aVar.sTp = cl.aWA();
        aVar.auC(String.valueOf(aVar.sTp));
        this.viM = true;
        AppMethodBeat.o(250868);
    }

    public final void f(bbn bbn) {
        AppMethodBeat.i(250869);
        g(bbn);
        this.viM = false;
        AppMethodBeat.o(250869);
    }

    public final void auB(String str) {
        AppMethodBeat.i(250871);
        p.h(str, "key");
        if (!this.viM) {
            AppMethodBeat.o(250871);
            return;
        }
        dC(str, 2);
        AppMethodBeat.o(250871);
    }

    private final void b(Set<String> set, Set<String> set2) {
        AppMethodBeat.i(250872);
        if (!this.viM) {
            AppMethodBeat.o(250872);
            return;
        }
        Set<String> a2 = ak.a(set2, set);
        Log.i(this.TAG, "latestExposeRecords" + a2 + "，size:" + a2.size());
        if (!a2.isEmpty()) {
            for (String str : a2) {
                dC(str, 1);
            }
        }
        c(set2, this.viO);
        Log.i(this.TAG, "pvCount:" + KE(1) + ": uvCount:" + KF(1));
        AppMethodBeat.o(250872);
    }

    private final HashMap<String, Integer> KD(int i2) {
        return i2 == 1 ? this.viP : this.viR;
    }

    private static void c(Set<String> set, Set<String> set2) {
        AppMethodBeat.i(250873);
        set2.clear();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            set2.add(it.next());
        }
        AppMethodBeat.o(250873);
    }

    private final long KE(int i2) {
        AppMethodBeat.i(250874);
        long j2 = 0;
        Collection<Integer> values = KD(i2).values();
        p.g(values, "getMapContainer(type).values");
        for (T t : values) {
            p.g(t, LocaleUtil.ITALIAN);
            j2 = ((long) t.intValue()) + j2;
        }
        AppMethodBeat.o(250874);
        return j2;
    }

    private final long KF(int i2) {
        AppMethodBeat.i(250875);
        long size = (long) KD(i2).size();
        AppMethodBeat.o(250875);
        return size;
    }

    private final void dC(String str, int i2) {
        AppMethodBeat.i(250876);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(250876);
            return;
        }
        HashMap<String, Integer> KD = KD(i2);
        if (KD.containsKey(str)) {
            Integer num = KD.get(str);
            if (num != null) {
                KD.put(str, Integer.valueOf(num.intValue() + 1));
                AppMethodBeat.o(250876);
                return;
            }
            AppMethodBeat.o(250876);
            return;
        }
        KD.put(str, 1);
        AppMethodBeat.o(250876);
    }

    private final void g(bbn bbn) {
        AppMethodBeat.i(250877);
        bh bhVar = new bh();
        bhVar.dy(this.viN.vdq);
        bhVar.dz(this.viN.vds);
        bhVar.jg(this.viN.vdr);
        bhVar.dB(KF(1));
        bhVar.dC(KE(1));
        bhVar.dD(KE(2));
        bhVar.dE(KF(2));
        bhVar.dF(this.viS);
        bhVar.dH(this.viT);
        bhVar.dG(System.currentTimeMillis() - this.viN.sTp);
        if (bbn != null) {
            bhVar.dA((long) bbn.tyh);
        }
        bhVar.bfK();
        a(bhVar);
        AppMethodBeat.o(250877);
    }

    private static void a(a aVar) {
        AppMethodBeat.i(250878);
        d dVar = d.vdp;
        String tag = d.getTAG();
        StringBuilder append = new StringBuilder("report").append(aVar.getId()).append(' ');
        String abW = aVar.abW();
        p.g(abW, "struct.toShowString()");
        Log.i(tag, append.append(n.j(abW, APLogFileUtil.SEPARATOR_LINE, " ", false)).toString());
        AppMethodBeat.o(250878);
    }

    private final void doX() {
        AppMethodBeat.i(250879);
        d.a aVar = this.viN;
        aVar.vdq = 0;
        aVar.auC("");
        aVar.sTp = 0;
        aVar.vds = 0;
        this.viM = false;
        this.viS = 0;
        this.viT = 0;
        this.viO.clear();
        this.viQ.clear();
        this.viP.clear();
        this.viR.clear();
        AppMethodBeat.o(250879);
    }

    public final void n(Set<String> set) {
        AppMethodBeat.i(250870);
        p.h(set, "curRecordSet");
        b(this.viO, set);
        AppMethodBeat.o(250870);
    }
}
