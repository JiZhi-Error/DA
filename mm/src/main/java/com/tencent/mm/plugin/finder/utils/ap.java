package com.tencent.mm.plugin.finder.utils;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.abj;
import com.tencent.mm.sdk.event.EventCenter;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0004¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderReportUtil;", "", "()V", "onCommentAction", "", NativeProtocol.WEB_DIALOG_ACTION, "", "commentId", "", "onLikeComment", "isLike", "", "onPostComment", "plugin-finder_release"})
public final class ap {
    public static final ap UVg = new ap();

    static {
        AppMethodBeat.i(261476);
        AppMethodBeat.o(261476);
    }

    private ap() {
    }

    public static void m(boolean z, long j2) {
        AppMethodBeat.i(261473);
        abj abj = new abj();
        abj.opV.action = z ? 2 : 3;
        abj.opV.commentId = j2;
        EventCenter.instance.publish(abj);
        AppMethodBeat.o(261473);
    }

    public static void hVt() {
        AppMethodBeat.i(261474);
        abj abj = new abj();
        abj.opV.action = 1;
        abj.opV.commentId = 0;
        EventCenter.instance.publish(abj);
        AppMethodBeat.o(261474);
    }

    public static void bc(int i2, long j2) {
        AppMethodBeat.i(261475);
        abj abj = new abj();
        abj.opV.action = i2;
        abj.opV.commentId = j2;
        EventCenter.instance.publish(abj);
        AppMethodBeat.o(261475);
    }
}
