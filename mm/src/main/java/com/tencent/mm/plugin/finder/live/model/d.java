package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveComboRewardMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "selfMsgInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "getSelfMsgInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "setSelfMsgInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;)V", "selfSend", "", "getSelfSend", "()Z", "setSelfSend", "(Z)V", "getPayLoadContent", "", "plugin-finder_release"})
public final class d extends c {
    private final String TAG = "FinderLiveComboRewardMsg";
    public auy uiq;
    public boolean uir;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(aut aut) {
        super(aut);
        p.h(aut, "msg");
        AppMethodBeat.i(246075);
        AppMethodBeat.o(246075);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final Object dft() {
        byte[] bArr = null;
        AppMethodBeat.i(246074);
        switch (this.uio.ybm) {
            case 20013:
                if (this.uir) {
                    String str = this.TAG;
                    StringBuilder sb = new StringBuilder("FinderLiveComboRewardMsg is selfSend getPayLoadContent:");
                    Object obj = this.uiq;
                    if (obj == null) {
                        obj = "";
                    }
                    Log.i(str, sb.append(g.bN(obj)).toString());
                    auy auy = this.uiq;
                    AppMethodBeat.o(246074);
                    return auy;
                }
                auy auy2 = new auy();
                b bVar = this.uio.LFB;
                if (bVar != null) {
                    bArr = bVar.toByteArray();
                }
                auy2.parseFrom(bArr);
                AppMethodBeat.o(246074);
                return auy2;
            default:
                AppMethodBeat.o(246074);
                return null;
        }
    }
}
