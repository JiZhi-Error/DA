package com.tencent.mm.plugin.vlog.ui.manager;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.player.g;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ-\u0010\u001f\u001a\u00020\u001e2%\u0010 \u001a!\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001e\u0018\u00010!JJ\u0010&\u001a\u00020\u001e2\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010(j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`)2\u001a\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010(j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`)2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,J\u0016\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/manager/VLogPreloadManager;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "vLogComposition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getVLogComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVLogComposition", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "getVLogDataManager", "()Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "getVLogDirector", "()Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "setVLogDirector", "(Lcom/tencent/mm/plugin/vlog/player/VLogDirector;)V", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "getVLogSurface", "()Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "setVLogSurface", "(Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;)V", "clear", "", "loadPlayScript", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "setMaterial", "videoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "imageList", FirebaseAnalytics.b.INDEX, "", "setPreviewSize", "width", "", "height", "plugin-vlog_release"})
public final class c {
    private static com.tencent.mm.plugin.vlog.player.c GCP = null;
    private static g GCQ = null;
    private static final ae GFL = new ae();
    public static final c GGi = new c();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(111160);
        AppMethodBeat.o(111160);
    }

    private c() {
    }

    public static ae fCM() {
        return GFL;
    }

    public static g fCN() {
        return GCQ;
    }

    public static com.tencent.mm.plugin.vlog.player.c fCO() {
        return GCP;
    }
}
