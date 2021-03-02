package com.tencent.mm.plugin.gamelife.c;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.gamelife.b.f;
import com.tencent.mm.plugin.gamelife.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J6\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataResponse;", "sessionIdList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "getRequest", "()Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class b extends c<g> {
    public static final a ybv = new a((byte) 0);
    private final f ybu = new f();

    static {
        AppMethodBeat.i(241276);
        AppMethodBeat.o(241276);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(LinkedList<String> linkedList) {
        p.h(linkedList, "sessionIdList");
        AppMethodBeat.i(241275);
        d.a aVar = new d.a();
        this.ybu.ybg = linkedList;
        aVar.c(this.ybu);
        aVar.d(new g());
        aVar.MB("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessiondata");
        aVar.sG(1910);
        c(aVar.aXF());
        AppMethodBeat.o(241275);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, g gVar, q qVar) {
        AppMethodBeat.i(241274);
        super.a(i2, i3, str, gVar, qVar);
        Log.i("MicroMsg.CgiGetChatSessionData", "onCgiBack, errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.o(241274);
    }
}
