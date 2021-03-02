package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/multitask/MultiTaskLogic;", "", "()V", "CoverImageLoadOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getCoverImageLoadOptions", "()Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getCoverImgPath", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "id", "getHomeUIImagePath", "plugin-multitask_release"})
public final class h {
    private static final c zZm;
    public static final h zZn = new h();

    static {
        AppMethodBeat.i(200304);
        c bdv = new c.a().bdo().bdr().bdv();
        p.g(bdv, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
        zZm = bdv;
        AppMethodBeat.o(200304);
    }

    private h() {
    }

    public static c eqz() {
        return zZm;
    }

    public static String g(MultiTaskInfo multiTaskInfo) {
        String str;
        AppMethodBeat.i(200301);
        if (multiTaskInfo == null || (str = multiTaskInfo.field_id) == null) {
            str = "";
        }
        String aGJ = aGJ(str);
        AppMethodBeat.o(200301);
        return aGJ;
    }

    public static String eqA() {
        AppMethodBeat.i(200302);
        g gVar = g.zZj;
        String aGJ = aGJ(g.eqy());
        AppMethodBeat.o(200302);
        return aGJ;
    }

    public static String aGJ(String str) {
        AppMethodBeat.i(200303);
        p.h(str, "id");
        StringBuilder sb = new StringBuilder();
        i iVar = i.zZq;
        String sb2 = sb.append(i.eqC()).append(str).toString();
        AppMethodBeat.o(200303);
        return sb2;
    }
}
