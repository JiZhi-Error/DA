package com.tencent.mm.plugin.finder.cgi;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.data.r;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 22\u00020\u0001:\u00012B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"J\b\u0010$\u001a\u0004\u0018\u00010\u0006J\b\u0010%\u001a\u00020\bH\u0016J\u0006\u0010&\u001a\u00020'J>\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u00032\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderMVUserPage;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderUserName", "", "finderSelfUserName", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderUserName", "()Ljava/lang/String;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFinderItems", "getFinderObjects", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLastBuffer", "getType", "hasMore", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bv extends ax {
    public static final a tvI = new a((byte) 0);
    private i callback;
    public d iUB;
    public int pullType;
    public final String sBN;
    private final String tvH;
    private List<? extends FinderItem> tvo;

    static {
        AppMethodBeat.i(242476);
        AppMethodBeat.o(242476);
    }

    public bv(String str, String str2, b bVar, int i2, bbn bbn) {
        super(bbn);
        AppMethodBeat.i(242475);
        this.sBN = str;
        this.tvH = str2;
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/findermvuserpage");
        aya aya = new aya();
        aya.finderUsername = this.tvH;
        aya.userName = this.sBN;
        aya.lastBuffer = bVar;
        this.pullType = i2;
        am amVar = am.tuw;
        aya.LBM = am.a(bbn);
        am amVar2 = am.tuw;
        aya.LAv = am.cXZ();
        aVar.c(aya);
        aVar.d(new ayb());
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.iUB = aXF;
        Log.i("Finder.NetSceneFinderMVUserPage", "NetSceneFinderMVUserPage init finderUserName " + this.sBN + " finderSelfUserName: " + this.tvH);
        AppMethodBeat.o(242475);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderMVUserPage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242473);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(242473);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6628;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242474);
        Log.i("Finder.NetSceneFinderMVUserPage", "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            if (this.iUB.aYK() == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
                AppMethodBeat.o(242474);
                throw tVar;
            }
            c.a aVar = c.vGN;
            com.tencent.mm.bw.a aYK = this.iUB.aYK();
            if (aYK == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMVUserPageResponse");
                AppMethodBeat.o(242474);
                throw tVar2;
            }
            LinkedList<FinderObject> linkedList = ((ayb) aYK).object;
            p.g(linkedList, "(commReqResp.responsePro…serPageResponse).`object`");
            this.tvo = c.a.a(linkedList, 33280, this.ttO);
            if (this.pullType != 2) {
                String str2 = this.sBN;
                if (str2 == null) {
                    str2 = z.aUg();
                }
                List<? extends FinderItem> list = this.tvo;
                if (list != null) {
                    LinkedList linkedList2 = new LinkedList();
                    for (T t : list) {
                        linkedList2.add(new r(0, t.getFinderObject().id, t.getFinderObject(), 33280));
                    }
                    if (linkedList2.size() > 0) {
                        l.a aVar2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                        if (TextUtils.isEmpty(str2)) {
                            str2 = z.aUg();
                        } else if (str2 == null) {
                            p.hyc();
                        }
                        p.g(str2, "if (TextUtils.isEmpty(us…sername() else userName!!");
                        l.a.a(17, str2, linkedList2);
                    }
                }
            }
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242474);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.tencent.mm.plugin.finder.storage.FinderItem>, java.util.List<com.tencent.mm.plugin.finder.storage.FinderItem> */
    public final List<FinderItem> cYL() {
        List list = this.tvo;
        if (list == null) {
            return v.SXr;
        }
        return list;
    }
}
