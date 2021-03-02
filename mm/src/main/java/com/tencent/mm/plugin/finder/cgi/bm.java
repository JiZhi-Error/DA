package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001BK\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001c\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020\u0007J\u0006\u0010-\u001a\u00020\u0003J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0014J\u0006\u00100\u001a\u00020\u0003J\u0006\u00101\u001a\u00020\u0007J\b\u00102\u001a\u0004\u0018\u00010\u0005J\b\u00103\u001a\u00020\u0007H\u0016J\b\u00104\u001a\u00020\u000eH\u0016J>\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016R\u000e\u0010\u0010\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastPlayId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "saveCache", "", "(JLcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IZ)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSaveCache", "()Z", "setSaveCache", "(Z)V", "getTargetUsername", "()Ljava/lang/String;", "setTargetUsername", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getCount", "getLastDisplayId", "getLikedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMaxId", "getMegaVideoCount", "getRespLastBuffer", "getType", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bm extends ax {
    private final String TAG;
    private i callback;
    private int dLS;
    public int pullType;
    private d rr;
    public List<? extends FinderItem> tvo;
    private String tvp;
    private boolean tvq;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ bm(long r12, com.tencent.mm.bw.b r14, int r15, java.lang.String r16, com.tencent.mm.protocal.protobuf.bbn r17, int r18, boolean r19, int r20) {
        /*
            r11 = this;
            r0 = r20 & 4
            if (r0 == 0) goto L_0x0034
            r5 = 0
        L_0x0005:
            r0 = r20 & 8
            if (r0 == 0) goto L_0x0031
            java.lang.String r6 = ""
        L_0x000c:
            r0 = r20 & 32
            if (r0 == 0) goto L_0x002e
            r8 = 0
        L_0x0011:
            r0 = r20 & 64
            if (r0 == 0) goto L_0x002b
            r9 = 1
        L_0x0016:
            r1 = r11
            r2 = r12
            r4 = r14
            r7 = r17
            r1.<init>(r2, r4, r5, r6, r7, r8, r9)
            r0 = 242433(0x3b301, float:3.39721E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r0)
            r0 = 242433(0x3b301, float:3.39721E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0)
            return
        L_0x002b:
            r9 = r19
            goto L_0x0016
        L_0x002e:
            r8 = r18
            goto L_0x0011
        L_0x0031:
            r6 = r16
            goto L_0x000c
        L_0x0034:
            r5 = r15
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.bm.<init>(long, com.tencent.mm.bw.b, int, java.lang.String, com.tencent.mm.protocal.protobuf.bbn, int, boolean, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bm(long j2, b bVar, int i2, String str, bbn bbn, int i3, boolean z) {
        super(bbn);
        p.h(str, "targetUsername");
        AppMethodBeat.i(242432);
        this.TAG = "Finder.NetSceneFinderGetLikedList";
        this.tvp = "";
        this.tvq = true;
        d.a aVar = new d.a();
        aVar.sG(getType());
        this.pullType = i2;
        this.tvp = str;
        this.tvq = z;
        asn asn = new asn();
        asn.LDu = j2;
        asn.lastBuffer = bVar;
        asn.LAt = z.aUg();
        if (!p.j(str, z.aTY())) {
            asn.tvp = str;
        }
        asn.dLS = i3;
        am amVar = am.tuw;
        asn.LAv = am.cXZ();
        this.dLS = i3;
        am amVar2 = am.tuw;
        asn.uli = am.a(bbn);
        aVar.c(asn);
        aVar.sG(getType());
        aVar.d(new aso());
        aVar.MB("/cgi-bin/micromsg-bin/findergetlikedlist");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "NetSceneFinderGetLikedList init: " + j2 + ' ' + asn.LAt + "， targetUsername：" + str);
        AppMethodBeat.o(242432);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3965;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165226);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165226);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        List<? extends FinderItem> list;
        boolean z = false;
        AppMethodBeat.i(242427);
        Log.i(this.TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
                AppMethodBeat.o(242427);
                throw tVar;
            }
            p.g(((aso) aYK).LDv, "(rr.responseProtoBuf as …dListResponse).liked_list");
            a aYK2 = this.rr.aYK();
            if (aYK2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
                AppMethodBeat.o(242427);
                throw tVar2;
            }
            aso aso = (aso) aYK2;
            com.tencent.mm.plugin.finder.preload.a aVar = com.tencent.mm.plugin.finder.preload.a.uTO;
            baw baw = aso.LAF;
            LinkedList<FinderObject> linkedList = aso.LDv;
            p.g(linkedList, "resp.liked_list");
            com.tencent.mm.plugin.finder.preload.a.a(baw, linkedList, 3965);
            LinkedList<FinderObject> linkedList2 = aso.LDv;
            p.g(linkedList2, "resp.liked_list");
            if (linkedList2.size() > 0) {
                FinderObject finderObject = linkedList2.get(0);
                p.g(finderObject, "list[0]");
                Log.i(this.TAG, "onGYNetEnd list:" + linkedList2.size() + " firstItem:" + com.tencent.mm.ac.g.bN(finderObject));
            }
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("onGYNetEnd list:").append(linkedList2.size()).append(", continueFlag:").append(aso.continueFlag).append(", maxId:");
            FinderObject finderObject2 = (FinderObject) j.kv(linkedList2);
            Log.i(str2, append.append(finderObject2 != null ? Long.valueOf(finderObject2.displayId) : null).append(' ').toString());
            if (this.pullType != 2 && Util.isNullOrNil(this.tvp)) {
                z = true;
            }
            ArrayList arrayList = new ArrayList();
            for (T t : linkedList2) {
                y yVar = y.vXH;
                if (y.r((FinderObject) t)) {
                    arrayList.add(t);
                }
            }
            c.a aVar2 = c.vGN;
            this.tvo = c.a.a(arrayList, 4, this.ttO);
            if (z && this.dLS != 1 && this.tvq && (list = this.tvo) != null) {
                c.a aVar3 = c.vGN;
                List<? extends FinderItem> list2 = list;
                ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    c.a aVar4 = c.vGN;
                    arrayList2.add(c.a.s(it.next()));
                }
                c.a.b(arrayList2, 4, z);
            }
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242427);
    }

    public final int getCount() {
        AppMethodBeat.i(242428);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("total count = ");
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
            AppMethodBeat.o(242428);
            throw tVar;
        }
        Log.i(str, sb.append(((aso) aYK).gAZ).toString());
        a aYK2 = this.rr.aYK();
        if (aYK2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
            AppMethodBeat.o(242428);
            throw tVar2;
        }
        int i2 = ((aso) aYK2).gAZ;
        AppMethodBeat.o(242428);
        return i2;
    }

    public final int cYy() {
        AppMethodBeat.i(242429);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
            AppMethodBeat.o(242429);
            throw tVar;
        }
        int i2 = ((aso) aYK).uKM;
        AppMethodBeat.o(242429);
        return i2;
    }

    public final b cYz() {
        AppMethodBeat.i(242430);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
            AppMethodBeat.o(242430);
            throw tVar;
        }
        b bVar = ((aso) aYK).lastBuffer;
        AppMethodBeat.o(242430);
        return bVar;
    }

    public final int cYA() {
        AppMethodBeat.i(242431);
        a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
            AppMethodBeat.o(242431);
            throw tVar;
        }
        int i2 = ((aso) aYK).continueFlag;
        AppMethodBeat.o(242431);
        return i2;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final boolean cXQ() {
        return true;
    }
}
