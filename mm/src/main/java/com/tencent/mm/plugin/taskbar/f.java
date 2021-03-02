package com.tencent.mm.plugin.taskbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/TaskBarLogic;", "", "()V", "generateTaskBarImageCacheKey", "", "path", "imageLoaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getCoverImgPath", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "id", "plugin-taskbar_release"})
public final class f {
    public static final f FSa = new f();

    static {
        AppMethodBeat.i(238422);
        AppMethodBeat.o(238422);
    }

    private f() {
    }

    public static String f(String str, c cVar) {
        AppMethodBeat.i(263575);
        p.h(str, "path");
        p.h(cVar, "imageLoaderOptions");
        if (cVar.bdl()) {
            str = str + "round" + cVar.bdm();
        }
        if (!Util.isNullOrNil(cVar.bdn())) {
            str = str + cVar.bdn();
        }
        String str2 = str + "size" + cVar.bdj() + cVar.bdk();
        AppMethodBeat.o(263575);
        return str2;
    }

    public static String aGJ(String str) {
        AppMethodBeat.i(238421);
        p.h(str, "id");
        StringBuilder sb = new StringBuilder();
        g gVar = g.FSd;
        String sb2 = sb.append(g.fut()).append(str).toString();
        AppMethodBeat.o(238421);
        return sb2;
    }
}
