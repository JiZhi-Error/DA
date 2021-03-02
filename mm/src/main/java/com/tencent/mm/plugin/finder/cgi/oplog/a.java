package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0012H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderDelFansService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderDelFansService;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderRemoveFansSetting;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "delFans", "", "fansId", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "getCmdId", "", "handleUpdateResult", "retCode", "plugin-finder_release"})
public final class a extends k<bbm> implements o {
    private final String TAG = "Finder.FinderDelFansService";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ b di(bbm bbm) {
        AppMethodBeat.i(242636);
        bbm bbm2 = bbm;
        p.h(bbm2, "cmdBufItem");
        b cD = b.cD(bbm2.toByteArray());
        p.g(cD, "ByteString.copyFrom(cmdBufItem.toByteArray())");
        AppMethodBeat.o(242636);
        return cD;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ void n(bbm bbm, int i2) {
        AppMethodBeat.i(242638);
        p.h(bbm, "cmdBufItem");
        Log.d(this.TAG, "retcode:".concat(String.valueOf(i2)));
        AppMethodBeat.o(242638);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final int getCmdId() {
        AppMethodBeat.i(242637);
        bx.a aVar = bx.tvW;
        int i2 = bx.tvV;
        AppMethodBeat.o(242637);
        return i2;
    }

    @Override // com.tencent.mm.plugin.i.a.o
    public final void a(String str, ai<bbm> aiVar) {
        AppMethodBeat.i(242639);
        p.h(str, "fansId");
        bbm bbm = new bbm();
        bbm.LKT = str;
        a(bbm, aiVar, false);
        AppMethodBeat.o(242639);
    }
}
