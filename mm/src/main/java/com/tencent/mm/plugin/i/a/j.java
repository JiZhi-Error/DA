package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u000e\u0010\u0007\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/CgiFinderGetUser;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetUserResponse;", "nicknameList", "", "", "(Ljava/util/List;)V", "TAG", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "finder-sdk_release"})
public final class j extends c<atx> {
    private final String TAG = "Finder.CgiFinderGetUser";

    public j(List<String> list) {
        p.h(list, "nicknameList");
        AppMethodBeat.i(208789);
        atw atw = new atw();
        atw.LEK.addAll(list);
        d.a aVar = new d.a();
        aVar.c(atw);
        atx atx = new atx();
        atx.setBaseResponse(new BaseResponse());
        atx.getBaseResponse().ErrMsg = new dqi();
        aVar.d(atx);
        aVar.MB("/cgi-bin/micromsg-bin/findergetuser");
        aVar.sG(3512);
        c(aVar.aXF());
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("init nickname:");
        String str2 = (String) kotlin.a.j.kt(list);
        Log.i(str, sb.append(str2 == null ? "" : str2).toString());
        AppMethodBeat.o(208789);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, atx atx, q qVar) {
        AppMethodBeat.i(208788);
        atx atx2 = atx;
        p.h(atx2, "resp");
        super.a(i2, i3, str, atx2, qVar);
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread() + ' ');
        AppMethodBeat.o(208788);
    }
}
