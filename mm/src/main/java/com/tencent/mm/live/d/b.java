package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.ah;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/live/report/LiveKvStatReportHelper;", "", "()V", "Companion", "plugin-logic_release"})
public final class b {
    public static final a hTK = new a((byte) 0);

    static {
        AppMethodBeat.i(208305);
        AppMethodBeat.o(208305);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0017H\u0007J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0007J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/live/report/LiveKvStatReportHelper$Companion;", "", "()V", "GROUP_CHATTING_ROLE_MANAGER", "", "GROUP_CHATTING_ROLE_NORMAL", "GROUP_CHATTING_ROLE_OWNER", "LIVE_COMPLAINT_SENCE_LIVE", "LIVE_COMPLAINT_SENCE_OTHER", "LIVE_ENTRANCE_SCENE_OTHER", "LIVE_ENTRANCE_SCENE_TOOLBAR", "LIVE_NOTIFICATION_SCENE_APPMSG", "LIVE_NOTIFICATION_SCENE_NAV_TIP", "LIVE_NOTIFICATION_SCENE_OTHER", "LIVE_ROLE_ANCHOR", "LIVE_ROLE_VISITOR", "REPORT_CAMERA_STATUS_BACK", "REPORT_CAMERA_STATUS_FRONT", "REPORT_CAMERA_STATUS_OTHER", "REPORT_SCREEN_ORIENTATION_LANDSCAPE", "REPORT_SCREEN_ORIENTATION_OTHER", "REPORT_SCREEN_ORIENTATION_PORTRAIT", "TAG", "", "getGroupChattingMemberCount", "roomId", "getGroupChattingRole", "userName", "getLiveRole", "anchorName", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int ax(String str, String str2) {
            AppMethodBeat.i(208302);
            p.h(str, "userName");
            p.h(str2, "roomId");
            com.tencent.mm.kernel.c.a af = g.af(c.class);
            p.g(af, "MMKernel.service(IChatroomService::class.java)");
            ah Kd = ((c) af).aSX().Kd(str2);
            if (Kd != null && Kd.bjf(str)) {
                AppMethodBeat.o(208302);
                return 2;
            } else if (Kd == null || !Kd.JO(str)) {
                AppMethodBeat.o(208302);
                return 3;
            } else {
                AppMethodBeat.o(208302);
                return 1;
            }
        }

        public static int ay(String str, String str2) {
            AppMethodBeat.i(208303);
            p.h(str, "userName");
            p.h(str2, "anchorName");
            if (p.j(str, str2)) {
                AppMethodBeat.o(208303);
                return 1;
            }
            AppMethodBeat.o(208303);
            return 2;
        }

        public static int Hd(String str) {
            List<String> bax;
            AppMethodBeat.i(208304);
            p.h(str, "roomId");
            com.tencent.mm.kernel.c.a af = g.af(c.class);
            p.g(af, "MMKernel.service(IChatroomService::class.java)");
            ah Kd = ((c) af).aSX().Kd(str);
            if (Kd == null || (bax = Kd.bax()) == null) {
                AppMethodBeat.o(208304);
                return 0;
            }
            int size = bax.size();
            AppMethodBeat.o(208304);
            return size;
        }
    }
}
