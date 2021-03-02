package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.gamelife.b.q;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/SetBlackListResponse;", "userName", "", "switch", "", "associateWxGameAccount", "(Ljava/lang/String;ZZ)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class e extends c<q> {
    private static final String TAG = TAG;
    public static final a yby = new a((byte) 0);

    public e(String str, boolean z, boolean z2) {
        p.h(str, "userName");
        AppMethodBeat.i(241284);
        d.a aVar = new d.a();
        com.tencent.mm.plugin.gamelife.b.p pVar = new com.tencent.mm.plugin.gamelife.b.p();
        com.tencent.mm.plugin.gamelife.b.a aVar2 = new com.tencent.mm.plugin.gamelife.b.a();
        aVar2.username = str;
        aVar2.yaY = z;
        pVar.ybe = aVar2;
        pVar.ybr = z2;
        aVar.c(pVar);
        aVar.d(new q());
        aVar.MB("/cgi-bin/mmgame-bin/gamegamelifeappsvr/setblacklist");
        aVar.sG(1102);
        c(aVar.aXF());
        AppMethodBeat.o(241284);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, q qVar, com.tencent.mm.ak.q qVar2) {
        AppMethodBeat.i(241283);
        super.a(i2, i3, str, qVar, qVar2);
        Log.i(TAG, "onCgiBack, errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.o(241283);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/cgi/CgiSetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241285);
        AppMethodBeat.o(241285);
    }
}
