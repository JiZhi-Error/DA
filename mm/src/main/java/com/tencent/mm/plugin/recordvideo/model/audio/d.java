package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.clo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, hxF = {"dump", "", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "plugin-recordvideo_release"})
public final class d {
    public static final String a(clo clo) {
        AppMethodBeat.i(169931);
        p.h(clo, "$this$dump");
        String sb = new StringBuilder().append(clo.MqO).append(' ').append(clo.MqP).append(' ').append(clo.MqQ).append(' ').append(clo.MqR).toString();
        AppMethodBeat.o(169931);
        return sb;
    }
}
