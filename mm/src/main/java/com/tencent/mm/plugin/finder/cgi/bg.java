package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0006\u0010\u0019\u001a\u00020\u001aJ>\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFansList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "liveId", "", "scene", "", "(Lcom/tencent/mm/protobuf/ByteString;JI)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFansList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bg extends ax implements m {
    private final String TAG;
    private i callback;
    private d rr;

    public /* synthetic */ bg(b bVar) {
        this(bVar, 0, 0);
        AppMethodBeat.i(165220);
        AppMethodBeat.o(165220);
    }

    public bg(b bVar, long j2, int i2) {
        AppMethodBeat.i(242393);
        this.TAG = "Finder.NetSceneFinderGetFansList";
        d.a aVar = new d.a();
        aVar.sG(getType());
        arx arx = new arx();
        arx.finderUsername = z.aUg();
        arx.tVM = bVar;
        am amVar = am.tuw;
        arx.uli = am.cXY();
        arx.LDo = j2;
        arx.scene = i2;
        aVar.c(arx);
        aVar.d(new ary());
        aVar.MB("/cgi-bin/micromsg-bin/findergetfanslist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderGetFansList,liveId:" + j2 + ",scene:" + i2);
        AppMethodBeat.o(242393);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3531;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165217);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165217);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242389);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            e.INSTANCE.idkeyStat(1279, 9, 1, false);
        } else {
            e.INSTANCE.idkeyStat(1279, 10, 1, false);
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242389);
    }

    public final b cYn() {
        AppMethodBeat.i(242390);
        a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListRequest");
            AppMethodBeat.o(242390);
            throw tVar;
        }
        b bVar = ((arx) aYJ).tVM;
        AppMethodBeat.o(242390);
        return bVar;
    }

    public final b cYm() {
        AppMethodBeat.i(242391);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
            AppMethodBeat.o(242391);
            throw tVar;
        }
        b bVar = ((ary) aYK).tVM;
        AppMethodBeat.o(242391);
        return bVar;
    }

    public final LinkedList<aqr> cYo() {
        AppMethodBeat.i(165219);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
            AppMethodBeat.o(165219);
            throw tVar;
        }
        LinkedList<aqr> linkedList = ((ary) aYK).LDp;
        AppMethodBeat.o(165219);
        return linkedList;
    }

    public final boolean cYp() {
        AppMethodBeat.i(242392);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
            AppMethodBeat.o(242392);
            throw tVar;
        } else if (((ary) aYK).continueFlag != 0) {
            AppMethodBeat.o(242392);
            return true;
        } else {
            AppMethodBeat.o(242392);
            return false;
        }
    }
}
