package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.i.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModMessageSetting;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderMessageMuteSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModMsgMuteSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyMessageMuteSetting", "ifOpen", "", "plugin-finder_release"})
public final class d extends k<azc> implements p {
    private final String TAG = "Finder.FinderModMessageSetting";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ b di(azc azc) {
        AppMethodBeat.i(242648);
        azc azc2 = azc;
        kotlin.g.b.p.h(azc2, "cmdBufItem");
        b cD = b.cD(azc2.toByteArray());
        kotlin.g.b.p.g(cD, "ByteString.copyFrom(cmdBufItem.toByteArray())");
        AppMethodBeat.o(242648);
        return cD;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ void n(azc azc, int i2) {
        AppMethodBeat.i(242650);
        azc azc2 = azc;
        kotlin.g.b.p.h(azc2, "cmdBufItem");
        Log.i(this.TAG, "opType=" + azc2.opType + " retcode:" + i2);
        if (i2 != 0) {
            h.INSTANCE.n(1473, 10, 1);
        }
        AppMethodBeat.o(242650);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final int getCmdId() {
        AppMethodBeat.i(242649);
        bx.a aVar = bx.tvW;
        int i2 = bx.tvQ;
        AppMethodBeat.o(242649);
        return i2;
    }

    @Override // com.tencent.mm.plugin.i.a.p
    public final void mQ(boolean z) {
        int i2;
        AppMethodBeat.i(242651);
        azc azc = new azc();
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        azc.opType = i2;
        a(azc, null, false);
        AppMethodBeat.o(242651);
    }
}
