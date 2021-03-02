package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.videocomposition.b.e;
import com.tencent.mm.xeffect.effect.n;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VideoCompositionExportFrameRenderCallback;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "labelMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;Ljava/util/HashMap;Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;)V", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getEffect", "()Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "getLabelMap", "()Ljava/util/HashMap;", "onFrameStart", "", "pts", "", "onRelease", "plugin-vlog_release"})
public final class ai implements e {
    private final ac GxA;
    private final HashMap<String, Integer> GzU;
    private final n GzV;

    public ai(ac acVar, HashMap<String, Integer> hashMap, n nVar) {
        p.h(acVar, "composition");
        p.h(hashMap, "labelMap");
        AppMethodBeat.i(190725);
        this.GxA = acVar;
        this.GzU = hashMap;
        this.GzV = nVar;
        AppMethodBeat.o(190725);
    }

    @Override // com.tencent.mm.videocomposition.b.e
    public final void KM(long j2) {
        String str;
        n nVar;
        AppMethodBeat.i(190724);
        ad a2 = i.a(this.GxA, j2);
        HashMap<String, Integer> hashMap = this.GzU;
        if (a2 != null) {
            str = a2.path;
        } else {
            str = null;
        }
        Integer num = hashMap.get(str);
        int intValue = num != null ? num.intValue() : -1;
        a aVar = a.GAD;
        if (!a.fBU().contains(Integer.valueOf(intValue)) || (nVar = this.GzV) == null) {
            AppMethodBeat.o(190724);
            return;
        }
        nVar.setScene(intValue);
        AppMethodBeat.o(190724);
    }

    @Override // com.tencent.mm.videocomposition.b.e
    public final void onRelease() {
    }
}
