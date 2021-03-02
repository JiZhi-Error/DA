package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ6\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedLikedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "likeBuffer", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ag extends c<asc> {
    private final FinderItem feedObject;
    private final b lastBuffer;
    private final b likeBuffer;
    private final int scene;

    public ag(FinderItem finderItem, int i2, b bVar, b bVar2) {
        p.h(finderItem, "feedObject");
        AppMethodBeat.i(242303);
        this.feedObject = finderItem;
        this.scene = i2;
        this.lastBuffer = bVar;
        this.likeBuffer = bVar2;
        d.a aVar = new d.a();
        asb asb = new asb();
        asb.finderUsername = this.feedObject.field_username;
        asb.scene = this.scene;
        asb.lastBuffer = this.lastBuffer;
        asb.hFK = this.feedObject.field_id;
        asb.objectNonceId = this.feedObject.getObjectNonceId();
        asb.likeBuffer = this.likeBuffer;
        am amVar = am.tuw;
        asb.LAI = am.cXY();
        aVar.c(asb);
        asc asc = new asc();
        asc.setBaseResponse(new BaseResponse());
        asc.getBaseResponse().ErrMsg = new dqi();
        aVar.d(asc);
        aVar.MB("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
        aVar.sG(3593);
        c(aVar.aXF());
        Log.i("Finder.CgiGetFinderFeedLikedList", "CgiGetFinderFeedLikedList init finderUsername=" + this.feedObject.field_username + " scene=" + this.scene + " lastBuffer=" + (this.lastBuffer != null));
        AppMethodBeat.o(242303);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, asc asc, q qVar) {
        AppMethodBeat.i(242302);
        asc asc2 = asc;
        super.a(i2, i3, str, asc2, qVar);
        Log.i("Finder.CgiGetFinderFeedLikedList", "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " resp=" + asc2 + " thread=" + Thread.currentThread());
        AppMethodBeat.o(242302);
    }
}
