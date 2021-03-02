package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.i.a.ag;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderWxMsgSessionMuteSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderWxMessageSessionMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgSessionMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyWxMsgSessionMuteSetting", "ifOpen", "", "session", "plugin-finder_release"})
public final class l extends k<azd> implements ag {
    private final String TAG = "Finder.FinderWxMsgSessionMuteSetting";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ b di(azd azd) {
        AppMethodBeat.i(242674);
        azd azd2 = azd;
        p.h(azd2, "cmdBufItem");
        b cD = b.cD(azd2.toByteArray());
        p.g(cD, "ByteString.copyFrom(cmdBufItem.toByteArray())");
        AppMethodBeat.o(242674);
        return cD;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ void n(azd azd, int i2) {
        AppMethodBeat.i(242672);
        azd azd2 = azd;
        p.h(azd2, "cmdBufItem");
        Log.i(this.TAG, "sessionId=" + azd2.sessionId + " retcode:" + i2);
        if (i2 == 0) {
            com.tencent.mm.plugin.finder.storage.ag sessionInfoStorage = ((PluginFinder) g.ah(PluginFinder.class)).getSessionInfoStorage();
            String str = azd2.sessionId;
            if (str == null) {
                str = "";
            }
            sessionInfoStorage.dD(str, azd2.opType);
            AppMethodBeat.o(242672);
            return;
        }
        h.INSTANCE.n(1473, 9, 1);
        AppMethodBeat.o(242672);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final int getCmdId() {
        AppMethodBeat.i(242671);
        bx.a aVar = bx.tvW;
        int i2 = bx.tvS;
        AppMethodBeat.o(242671);
        return i2;
    }

    @Override // com.tencent.mm.plugin.i.a.ag
    public final void w(boolean z, String str) {
        AppMethodBeat.i(242673);
        p.h(str, "session");
        azd azd = new azd();
        azd.opType = z ? 1 : 0;
        azd.sessionId = str;
        a(azd, null, false);
        AppMethodBeat.o(242673);
    }
}
