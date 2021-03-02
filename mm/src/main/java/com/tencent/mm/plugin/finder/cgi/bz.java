package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020\u000bH\u0016J>\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000f¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginalUserFeeds;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", ch.COL_USERNAME, "", "refObjectId", "", "refObjectNonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "TAG", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "getRefObjectId", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderOriginalUserFeedsResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bz extends q implements m {
    private final String TAG = "Finder.NetSceneFinderOriginalUserFeeds";
    private i callback;
    private final b lastBuffer;
    public final int pullType;
    public final long refObjectId;
    private d rr;
    public List<? extends FinderItem> tvo;
    private final String username;

    public bz(String str, long j2, String str2, b bVar, int i2) {
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "refObjectNonceId");
        AppMethodBeat.i(165253);
        this.username = str;
        this.refObjectId = j2;
        this.lastBuffer = bVar;
        this.pullType = i2;
        d.a aVar = new d.a();
        aVar.sG(getType());
        bad bad = new bad();
        bad.username = this.username;
        bad.refObjectId = this.refObjectId;
        bad.refObjectNonceId = str2;
        bad.finderUsername = z.aUg();
        bad.lastBuffer = this.lastBuffer;
        am amVar = am.tuw;
        bad.uli = am.cXY();
        aVar.c(bad);
        aVar.sG(getType());
        aVar.d(new bae());
        aVar.MB("/cgi-bin/micromsg-bin/finderoriginaluserfeeds");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderOriginalUserFeeds " + this.refObjectId);
        AppMethodBeat.o(165253);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3581;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165250);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165250);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        List<? extends FinderItem> list;
        AppMethodBeat.i(165251);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOriginalUserFeedsResponse");
                AppMethodBeat.o(165251);
                throw tVar;
            }
            LinkedList<FinderObject> linkedList = ((bae) aYK).object;
            if (linkedList == null) {
                p.hyc();
            }
            Log.i(this.TAG, "onGYNetEnd list:" + linkedList.size());
            boolean z = this.pullType != 2;
            c.a aVar = c.vGN;
            ArrayList arrayList = new ArrayList();
            for (T t : linkedList) {
                y yVar = y.vXH;
                if (y.r((FinderObject) t)) {
                    arrayList.add(t);
                }
            }
            this.tvo = c.a.s(arrayList, 2);
            if (z && (list = this.tvo) != null) {
                c.a aVar2 = c.vGN;
                List<? extends FinderItem> list2 = list;
                ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    c.a aVar3 = c.vGN;
                    arrayList2.add(c.a.s(it.next()));
                }
                c.a.a(arrayList2, 2, this.username, z);
            }
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(165251);
    }

    public final bae cYZ() {
        AppMethodBeat.i(165252);
        d dVar = this.rr;
        a aYK = dVar != null ? dVar.aYK() : null;
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOriginalUserFeedsResponse");
            AppMethodBeat.o(165252);
            throw tVar;
        }
        bae bae = (bae) aYK;
        AppMethodBeat.o(165252);
        return bae;
    }
}
