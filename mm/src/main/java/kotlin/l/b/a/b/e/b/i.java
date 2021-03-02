package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a;

public final class i {
    private static final i TBJ = new i(v.SXr);
    public static final a TBK = new a((byte) 0);
    final List<a.u> iHg;

    private i(List<a.u> list) {
        this.iHg = list;
    }

    public /* synthetic */ i(List list, byte b2) {
        this(list);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static i g(a.v vVar) {
            AppMethodBeat.i(59085);
            p.h(vVar, SharePluginInfo.ISSUE_KEY_TABLE);
            if (vVar.TAr.size() == 0) {
                i iVar = i.TBJ;
                AppMethodBeat.o(59085);
                return iVar;
            }
            List<a.u> list = vVar.TAr;
            p.g(list, "table.requirementList");
            i iVar2 = new i(list, (byte) 0);
            AppMethodBeat.o(59085);
            return iVar2;
        }
    }

    static {
        AppMethodBeat.i(59086);
        AppMethodBeat.o(59086);
    }
}
