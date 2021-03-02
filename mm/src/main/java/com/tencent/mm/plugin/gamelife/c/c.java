package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.gamelife.b.h;
import com.tencent.mm.plugin.gamelife.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ6\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0011H\u0014¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionIdResponse;", "fromUserName", "", "toUserName", "scene", "", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class c extends com.tencent.mm.ak.c<i> {
    private static final String TAG = TAG;
    public static final a ybw = new a((byte) 0);

    public c(String str, String str2, int i2, b bVar) {
        p.h(str2, "toUserName");
        AppMethodBeat.i(241278);
        d.a aVar = new d.a();
        h hVar = new h();
        hVar.pPy = str;
        hVar.pPz = str2;
        hVar.scene = i2;
        hVar.ybi = bVar;
        aVar.c(hVar);
        aVar.d(new i());
        Log.i(TAG, "fromUserName[" + hVar.pPy + "], toUserName[" + hVar.pPz + "], scene[" + hVar.scene + "], extInfo[" + hVar.ybi + ']');
        aVar.MB("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessionid");
        aVar.sG(1103);
        c(aVar.aXF());
        AppMethodBeat.o(241278);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, i iVar, q qVar) {
        AppMethodBeat.i(241277);
        super.a(i2, i3, str, iVar, qVar);
        Log.i(TAG, "onCgiBack, errType = " + i2 + ", errMsg = " + str);
        AppMethodBeat.o(241277);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionId$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241279);
        AppMethodBeat.o(241279);
    }
}
