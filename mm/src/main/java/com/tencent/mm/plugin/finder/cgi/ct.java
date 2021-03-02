package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.b.g;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnw;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004J\b\u0010#\u001a\u0004\u0018\u00010\tJ\b\u0010$\u001a\u00020\u0012H\u0016J>\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetBullet;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "videoObjectId", "", "videoNonceId", "", "videoTimeStamps", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;JLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getVideoObjectId", "()J", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBulletList", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "getMaxTime", "getMinTime", "getRespLastBuffer", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ct extends cr implements m {
    public static final a twI = new a((byte) 0);
    private i callback;
    private final b lastBuffer;
    public int pullType;
    private d rr;
    public final long twG;

    static {
        AppMethodBeat.i(242556);
        AppMethodBeat.o(242556);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetBullet$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public ct(long j2, String str, long j3, b bVar, bbn bbn) {
        byte[] bArr;
        p.h(str, "videoNonceId");
        AppMethodBeat.i(242555);
        this.twG = j2;
        this.lastBuffer = bVar;
        cnw cnw = new cnw();
        ap apVar = ap.tuF;
        cnw.Mul = ap.b(bbn);
        cnw.twG = this.twG;
        cnw.lastBuffer = this.lastBuffer;
        cnw.LOd = str;
        cnw.MtO = j3;
        cnw.username = z.aUg();
        d.a aVar = new d.a();
        aVar.MB("/cgi-bin/micromsg-bin/megavideogetbulletcomment");
        aVar.sG(getType());
        aVar.c(cnw);
        aVar.d(new cnx());
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        StringBuilder append = new StringBuilder("NetSceneGetMegaVideoBullet videoObjectId ").append(this.twG).append(" lastBuffer ").append(this.lastBuffer).append(" md5:");
        b bVar2 = this.lastBuffer;
        if (bVar2 != null) {
            bArr = bVar2.zy;
        } else {
            bArr = null;
        }
        Log.i("Finder.NetSceneGetMegaVideoBullet", append.append(g.getMessageDigest(bArr)).toString());
        AppMethodBeat.o(242555);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6865;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(242549);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242549);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax, com.tencent.mm.plugin.finder.cgi.cr
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        byte[] bArr = null;
        AppMethodBeat.i(242550);
        if (i3 == 0 && i4 == 0) {
            StringBuilder append = new StringBuilder("count:").append(cZo().size()).append(" ,lastbuf ");
            b cYz = cYz();
            StringBuffer stringBuffer = new StringBuffer(append.append(g.getMessageDigest(cYz != null ? cYz.zy : null)).append(" min:").append(cZp()).append(" max: ==>").append(cZq()).toString());
            int i5 = 0;
            for (T t : cZo()) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    j.hxH();
                }
                T t2 = t;
                stringBuffer.append("# " + i5 + ':' + t2.content + ',' + t2.iXu + ", ");
                i5 = i6;
            }
            StringBuilder append2 = new StringBuilder("getBulletList videoObjectId ").append(this.twG).append(' ');
            b bVar = this.lastBuffer;
            if (bVar != null) {
                bArr = bVar.zy;
            }
            Log.i("Finder.NetSceneGetMegaVideoBullet", append2.append(g.getMessageDigest(bArr)).append(' ').append(stringBuffer).toString());
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242550);
            return;
        }
        AppMethodBeat.o(242550);
    }

    public final List<cni> cZo() {
        AppMethodBeat.i(242551);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoGetBulletCommentResponse");
            AppMethodBeat.o(242551);
            throw tVar;
        }
        LinkedList<cni> linkedList = ((cnx) aYK).commentList;
        p.g(linkedList, "(rr.responseProtoBuf as …mentResponse).commentList");
        LinkedList<cni> linkedList2 = linkedList;
        AppMethodBeat.o(242551);
        return linkedList2;
    }

    public final b cYz() {
        AppMethodBeat.i(242552);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoGetBulletCommentResponse");
            AppMethodBeat.o(242552);
            throw tVar;
        }
        b bVar = ((cnx) aYK).lastBuffer;
        AppMethodBeat.o(242552);
        return bVar;
    }

    public final long cZp() {
        AppMethodBeat.i(242553);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoGetBulletCommentResponse");
            AppMethodBeat.o(242553);
            throw tVar;
        }
        long j2 = ((cnx) aYK).Mum;
        AppMethodBeat.o(242553);
        return j2;
    }

    public final long cZq() {
        AppMethodBeat.i(242554);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoGetBulletCommentResponse");
            AppMethodBeat.o(242554);
            throw tVar;
        }
        long j2 = ((cnx) aYK).Mun;
        AppMethodBeat.o(242554);
        return j2;
    }
}
