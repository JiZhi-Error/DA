package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.gamelife.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J6\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetBlackListResponse;", "userName", "", "(Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class a extends c<e> {
    private static final String TAG = TAG;
    public static final C1412a ybt = new C1412a((byte) 0);

    public a(String str) {
        p.h(str, "userName");
        AppMethodBeat.i(241272);
        d.a aVar = new d.a();
        com.tencent.mm.plugin.gamelife.b.d dVar = new com.tencent.mm.plugin.gamelife.b.d();
        dVar.username = str;
        aVar.c(dVar);
        aVar.d(new e());
        aVar.MB("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getblacklist");
        aVar.sG(2982);
        c(aVar.aXF());
        AppMethodBeat.o(241272);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, e eVar, q qVar) {
        AppMethodBeat.i(241271);
        super.a(i2, i3, str, eVar, qVar);
        Log.i(TAG, "onCgiBack, errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.o(241271);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
    /* renamed from: com.tencent.mm.plugin.gamelife.c.a$a  reason: collision with other inner class name */
    public static final class C1412a {
        private C1412a() {
        }

        public /* synthetic */ C1412a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241273);
        AppMethodBeat.o(241273);
    }
}
