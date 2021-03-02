package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016J(\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModBlockPosterService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModBlockPoster;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modBlockPoster", "finderUserName", "block", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "plugin-finder_release"})
public final class b extends k<ayu> implements r {
    private final String TAG = "Finder.FinderModBloclPosterSetting";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ com.tencent.mm.bw.b di(ayu ayu) {
        AppMethodBeat.i(242640);
        ayu ayu2 = ayu;
        p.h(ayu2, "cmdBufItem");
        com.tencent.mm.bw.b cD = com.tencent.mm.bw.b.cD(ayu2.toByteArray());
        p.g(cD, "ByteString.copyFrom(cmdBufItem.toByteArray())");
        AppMethodBeat.o(242640);
        return cD;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ void n(ayu ayu, int i2) {
        AppMethodBeat.i(242642);
        ayu ayu2 = ayu;
        p.h(ayu2, "cmdBufItem");
        Log.i(this.TAG, "opType=" + ayu2.opType + " retcode:" + i2);
        AppMethodBeat.o(242642);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final int getCmdId() {
        AppMethodBeat.i(242641);
        bx.a aVar = bx.tvW;
        int i2 = bx.tvU;
        AppMethodBeat.o(242641);
        return i2;
    }

    @Override // com.tencent.mm.plugin.i.a.r
    public final void a(String str, boolean z, ai<ayu> aiVar) {
        int i2;
        AppMethodBeat.i(242643);
        p.h(str, "finderUserName");
        ayu ayu = new ayu();
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ayu.opType = i2;
        ayu.finderUsername = str;
        a((Object) ayu, (ai) aiVar, false);
        AppMethodBeat.o(242643);
    }
}
