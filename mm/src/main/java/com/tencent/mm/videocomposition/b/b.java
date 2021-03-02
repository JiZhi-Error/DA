package com.tencent.mm.videocomposition.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "filter", "Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "(Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;)V", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectId", "", "getFilter", "renderContext", "Landroid/opengl/EGLContext;", "updateRenderSize", "", "width", "", "height", "Companion", "video_composition_release"})
public final class b implements TAVVideoMixEffect {
    public static final a RhX = new a((byte) 0);
    private final a RhW;

    static {
        AppMethodBeat.i(216845);
        AppMethodBeat.o(216845);
    }

    public b(a aVar) {
        p.h(aVar, "filter");
        AppMethodBeat.i(216844);
        this.RhW = aVar;
        AppMethodBeat.o(216844);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect$Companion;", "", "()V", "TAG", "", "video_composition_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    public final String effectId() {
        AppMethodBeat.i(216843);
        String str = "CompositionMixEffect_" + hashCode();
        AppMethodBeat.o(216843);
        return str;
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    public final TAVVideoMixEffect.Filter createFilter() {
        return this.RhW;
    }
}
