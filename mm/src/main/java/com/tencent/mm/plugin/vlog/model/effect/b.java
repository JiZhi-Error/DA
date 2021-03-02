package com.tencent.mm.plugin.vlog.model.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.ad;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "info", "Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "start", "", "end", "order", "", "(Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;Lcom/tencent/mm/xeffect/effect/VLogEffect;JJI)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getEnd", "()J", "setEnd", "(J)V", "getInfo", "()Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "getOrder", "()I", "setOrder", "(I)V", "getStart", "setStart", "plugin-vlog_release"})
public final class b extends e {
    public final a GAm;
    public ad GAn;
    public long boX;
    public int order;
    public long start;

    public /* synthetic */ b(a aVar, ad adVar, long j2, long j3, byte b2) {
        this(aVar, adVar, j2, j3);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private b(a aVar, ad adVar, long j2, long j3) {
        super(2);
        p.h(aVar, "info");
        AppMethodBeat.i(190728);
        this.GAm = aVar;
        this.GAn = adVar;
        this.start = j2;
        this.boX = j3;
        this.order = 0;
        AppMethodBeat.o(190728);
    }
}
