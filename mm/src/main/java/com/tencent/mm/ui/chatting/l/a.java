package com.tencent.mm.ui.chatting.l;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/ui/chatting/report/ChatTagSearchSpanClickReportFlow;", "", "()V", "Companion", "app_release"})
public final class a {
    public static final C2099a PEV = new C2099a((byte) 0);
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/ui/chatting/report/ChatTagSearchSpanClickReportFlow$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bindDataToWidget", "", "widget", "Landroid/view/View;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "isGroupChat", "", "userName", "app_release"})
    /* renamed from: com.tencent.mm.ui.chatting.l.a$a  reason: collision with other inner class name */
    public static final class C2099a {
        private C2099a() {
        }

        public /* synthetic */ C2099a(byte b2) {
            this();
        }

        public static void a(View view, ca caVar, boolean z, String str) {
            AppMethodBeat.i(231347);
            p.h(caVar, "msg");
            Log.i(a.TAG, "bindDataToWidget widget:".concat(String.valueOf(view)));
            if (view != null) {
                egl egl = new egl();
                egl.KMf = caVar.ajM();
                egl.Ngu = z ? 2 : 1;
                if (z) {
                    str = caVar.ajO();
                }
                egl.Ngv = str;
                egl.KMc = caVar.getCreateTime();
                egl.Ngw = 0;
                SecDataUIC.a aVar = SecDataUIC.CWq;
                SecDataUIC.a.a(view, egl);
                AppMethodBeat.o(231347);
                return;
            }
            AppMethodBeat.o(231347);
        }
    }

    static {
        AppMethodBeat.i(231348);
        AppMethodBeat.o(231348);
    }
}
