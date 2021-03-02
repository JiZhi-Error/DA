package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a;
import kotlin.r;

public final class d implements c {
    private final a.o TBH;
    private final a.n TBI;

    public d(a.o oVar, a.n nVar) {
        p.h(oVar, "strings");
        p.h(nVar, "qualifiedNames");
        AppMethodBeat.i(59068);
        this.TBH = oVar;
        this.TBI = nVar;
        AppMethodBeat.o(59068);
    }

    @Override // kotlin.l.b.a.b.e.b.c
    public final String getString(int i2) {
        AppMethodBeat.i(59064);
        String string = this.TBH.getString(i2);
        p.g(string, "strings.getString(index)");
        AppMethodBeat.o(59064);
        return string;
    }

    @Override // kotlin.l.b.a.b.e.b.c
    public final String avl(int i2) {
        AppMethodBeat.i(59065);
        r<List<String>, List<String>, Boolean> avn = avn(i2);
        A a2 = avn.first;
        String a3 = j.a(avn.second, ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62);
        if (a2.isEmpty()) {
            AppMethodBeat.o(59065);
            return a3;
        }
        String str = j.a(a2, FilePathGenerator.ANDROID_DIR_SEP, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62) + '/' + a3;
        AppMethodBeat.o(59065);
        return str;
    }

    @Override // kotlin.l.b.a.b.e.b.c
    public final boolean avm(int i2) {
        AppMethodBeat.i(59066);
        boolean booleanValue = avn(i2).SWY.booleanValue();
        AppMethodBeat.o(59066);
        return booleanValue;
    }

    private final r<List<String>, List<String>, Boolean> avn(int i2) {
        AppMethodBeat.i(59067);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i2 != -1) {
            a.n.b auC = this.TBI.auC(i2);
            a.o oVar = this.TBH;
            p.g(auC, "proto");
            String string = oVar.getString(auC.Tzb);
            a.n.b.EnumC2318b bVar = auC.Tzc;
            if (bVar == null) {
                p.hyc();
            }
            switch (e.$EnumSwitchMapping$0[bVar.ordinal()]) {
                case 1:
                    linkedList2.addFirst(string);
                    break;
                case 2:
                    linkedList.addFirst(string);
                    break;
                case 3:
                    linkedList2.addFirst(string);
                    z = true;
                    break;
            }
            i2 = auC.Tza;
        }
        r<List<String>, List<String>, Boolean> rVar = new r<>(linkedList, linkedList2, Boolean.valueOf(z));
        AppMethodBeat.o(59067);
        return rVar;
    }
}
