package com.tencent.mm.plugin.recordvideo.background.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/mixer/VideoMixFactory;", "", "()V", "PHOTO2VIDEO_MIXER", "", "TAG", "", "VIDEO_MIXER", "VLOG_MIXER", "mixerManagerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "Lkotlin/collections/HashMap;", "getMixer", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "register", "", "key", "instanceManager", "plugin-recordvideo_release"})
public final class d {
    private static final HashMap<Integer, a> BMp = new HashMap<>();
    public static final d BMq = new d();

    static {
        AppMethodBeat.i(75324);
        AppMethodBeat.o(75324);
    }

    private d() {
    }

    public static void a(int i2, a aVar) {
        AppMethodBeat.i(75322);
        p.h(aVar, "instanceManager");
        BMp.put(Integer.valueOf(i2), aVar);
        AppMethodBeat.o(75322);
    }

    public static c b(c cVar, ald ald) {
        AppMethodBeat.i(75323);
        p.h(cVar, "editorData");
        p.h(ald, "extraConfig");
        a aVar = BMp.get(Integer.valueOf(ald.Luf));
        Log.i("MicroMsg.VideoMixFactory", "getMixer extraConfig.mixerType:" + ald.Luf + " mixInstanceManager:" + aVar);
        if (aVar != null) {
            c a2 = aVar.a(cVar, ald);
            AppMethodBeat.o(75323);
            return a2;
        }
        AppMethodBeat.o(75323);
        return null;
    }
}
