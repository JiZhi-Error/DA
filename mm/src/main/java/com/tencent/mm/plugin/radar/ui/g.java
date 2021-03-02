package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.djb;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarUtils;", "", "()V", "getEncodeUsername", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getUsername", "lowerThanXHDPI", "", "context", "Landroid/content/Context;", "plugin-radar_release"})
public final class g {
    public static final g BAY = new g();

    static {
        AppMethodBeat.i(138730);
        AppMethodBeat.o(138730);
    }

    private g() {
    }

    public static String b(djb djb) {
        AppMethodBeat.i(138728);
        p.h(djb, "member");
        String str = djb.UserName;
        if (str == null && (str = djb.LuX) == null) {
            str = "";
        }
        AppMethodBeat.o(138728);
        return str;
    }

    public static String a(diy diy) {
        if (diy != null) {
            String str = diy.LuX;
            if (str == null && (str = diy.UserName) == null) {
                str = "";
            }
            return str == null ? "" : str;
        }
    }

    public static String c(djb djb) {
        if (djb != null) {
            String str = djb.LuX;
            if (str == null && (str = djb.UserName) == null) {
                str = "";
            }
            return str == null ? "" : str;
        }
    }

    public static boolean gM(Context context) {
        AppMethodBeat.i(138729);
        p.h(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        if (resources.getDisplayMetrics().densityDpi <= 240) {
            AppMethodBeat.o(138729);
            return true;
        }
        AppMethodBeat.o(138729);
        return false;
    }
}
