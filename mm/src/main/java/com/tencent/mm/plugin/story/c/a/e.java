package com.tencent.mm.plugin.story.c.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryNewFeatureElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryNewFeatureElementConfig$StoryNewFeatureConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryNewFeatureConfig;", "()V", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "visitorEnable", "", "StoryNewFeatureConfig", "plugin-story_release"})
public final class e extends b<a> implements j {
    public static final e Fln = new e();

    static {
        AppMethodBeat.i(118610);
        AppMethodBeat.o(118610);
    }

    private e() {
    }

    @Override // com.tencent.mm.media.b.c
    public final void aLS() {
        AppMethodBeat.i(118608);
        if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            ((a) aLQ()).Flo = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_visitor_enable, false);
            AppMethodBeat.o(118608);
            return;
        }
        ((a) aLQ()).Flo = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_visitor_enable, false);
        AppMethodBeat.o(118608);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryNewFeatureElementConfig$StoryNewFeatureConfig;", "", "visitorEnable", "", "(Z)V", "getVisitorEnable", "()Z", "setVisitorEnable", "component1", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-story_release"})
    public static final class a {
        boolean Flo;

        public final boolean equals(Object obj) {
            return this == obj || ((obj instanceof a) && this.Flo == ((a) obj).Flo);
        }

        public final int hashCode() {
            boolean z = this.Flo;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            AppMethodBeat.i(118606);
            String str = "StoryNewFeatureConfig(visitorEnable=" + this.Flo + ")";
            AppMethodBeat.o(118606);
            return str;
        }

        private a() {
            this.Flo = false;
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.story.api.j
    public final boolean fng() {
        AppMethodBeat.i(118609);
        boolean z = ((a) aLT()).Flo;
        AppMethodBeat.o(118609);
        return z;
    }

    @Override // com.tencent.mm.media.b.c
    public final /* synthetic */ Object aLR() {
        AppMethodBeat.i(118607);
        a aVar = new a((byte) 0);
        AppMethodBeat.o(118607);
        return aVar;
    }
}
