package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.AssetExtension;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0004J\u001c\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/modelbase/AsyncMediaPlayerWrapper;", "", "()V", "TAG", "", "handlerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/modelbase/HandlerData;", "Lkotlin/collections/HashMap;", "createNewHandler", "tag", "dead", "", AssetExtension.SCENE_PLAY, "callback", "Lkotlin/Function0;", "plugin-audiologic_release"})
public final class a {
    public static final String TAG = TAG;
    public static final HashMap<String, e> iLv = new HashMap<>();
    public static final a iLw = new a();

    static {
        AppMethodBeat.i(187350);
        AppMethodBeat.o(187350);
    }

    private a() {
    }

    public static void MA(String str) {
        AppMethodBeat.i(187349);
        p.h(str, "tag");
        Log.i(TAG, "dead, tag:".concat(String.valueOf(str)));
        e eVar = iLv.get(str);
        if (eVar != null) {
            eVar.thread.quitSafely();
        }
        iLv.remove(str);
        AppMethodBeat.o(187349);
    }
}
