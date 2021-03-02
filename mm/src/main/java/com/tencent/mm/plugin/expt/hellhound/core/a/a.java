package com.tencent.mm.plugin.expt.hellhound.core.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/component/HellMultiProcessSeqGenerator;", "", "()V", "Companion", "plugin-expt_release"})
public final class a {
    public static final C1024a szg = new C1024a((byte) 0);

    static {
        AppMethodBeat.i(122555);
        AppMethodBeat.o(122555);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/component/HellMultiProcessSeqGenerator$Companion;", "", "()V", "MMKV_KEY_HELL_MULTIPROCESEQ", "", "SESSION_FLOW_TYPE", "", "SESSION_FRONTTIME_TYPE", "TAG", "getSeqAfterIncrement", "", "type", "resetAllSeq", "", "writeback", "seq", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.core.a.a$a  reason: collision with other inner class name */
    public static final class C1024a {
        private C1024a() {
        }

        public /* synthetic */ C1024a(byte b2) {
            this();
        }

        static void GO(int i2) {
            AppMethodBeat.i(122554);
            try {
                b.apa("hell_mlprocseq_".concat(String.valueOf(i2)));
                AppMethodBeat.o(122554);
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.HellMultiProcessSeqGenerator", e2, "HellMultiProcessSeqGenerator.writeback", new Object[0]);
                AppMethodBeat.o(122554);
            }
        }
    }

    public static final void cNF() {
        AppMethodBeat.i(122556);
        if (b.isMMProcess()) {
            C1024a.GO(0);
            C1024a.GO(1);
        }
        AppMethodBeat.o(122556);
    }
}
