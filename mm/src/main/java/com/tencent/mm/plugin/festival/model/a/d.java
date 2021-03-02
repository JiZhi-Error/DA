package com.tencent.mm.plugin.festival.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.oh;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/report/FestivalPicShareReporter;", "", "()V", "report", "", "scene", "Lcom/tencent/mm/plugin/festival/model/report/FestivalPicShareReporter$Scene;", "Scene", "plugin-festival_release"})
public final class d {
    public static final d UAc = new d();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/report/FestivalPicShareReporter$Scene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SnsTimeline", "Chat", "SaveToLocal", "plugin-festival_release"})
    public enum a {
        SnsTimeline(1),
        Chat(2),
        SaveToLocal(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(263173);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(263173);
            return aVar;
        }

        private a(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(263171);
            AppMethodBeat.o(263171);
        }
    }

    static {
        AppMethodBeat.i(263175);
        AppMethodBeat.o(263175);
    }

    private d() {
    }

    public static void a(a aVar) {
        AppMethodBeat.i(263174);
        p.h(aVar, "scene");
        oh ohVar = new oh();
        ohVar.PH(MMSlotKt.now());
        b bVar = b.UzX;
        ohVar.agP(b.hRV());
        ohVar.abH(2);
        ohVar.abJ(aVar.value);
        ohVar.bfK();
        AppMethodBeat.o(263174);
    }
}
