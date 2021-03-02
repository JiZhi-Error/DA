package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.i.a.u;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModFeedReproduce;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedReproduce;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedReproduction;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyFeedReproduce", "ifOpen", "", "plugin-finder_release"})
public final class c extends k<ayx> implements u {
    private final String TAG = "Finder.FinderModFeedReproduce";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ b di(ayx ayx) {
        AppMethodBeat.i(242644);
        ayx ayx2 = ayx;
        p.h(ayx2, "cmdBufItem");
        b cD = b.cD(ayx2.toByteArray());
        p.g(cD, "ByteString.copyFrom(cmdBufItem.toByteArray())");
        AppMethodBeat.o(242644);
        return cD;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ void n(ayx ayx, int i2) {
        AppMethodBeat.i(242646);
        p.h(ayx, "cmdBufItem");
        Log.d(this.TAG, "retcode:".concat(String.valueOf(i2)));
        AppMethodBeat.o(242646);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final int getCmdId() {
        AppMethodBeat.i(242645);
        bx.a aVar = bx.tvW;
        int i2 = bx.tvR;
        AppMethodBeat.o(242645);
        return i2;
    }

    @Override // com.tencent.mm.plugin.i.a.u
    public final void mP(boolean z) {
        int i2;
        AppMethodBeat.i(242647);
        ayx ayx = new ayx();
        if (z) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ayx.LIU = i2;
        a(ayx, null, false);
        AppMethodBeat.o(242647);
    }
}
