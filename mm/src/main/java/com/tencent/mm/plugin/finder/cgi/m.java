package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cBÀ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012{\u0010\u0006\u001aw\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ4\u0010\u001b\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0001\u0010\u0006\u001aw\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "pullType", "", "tabType", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "scene", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IILkotlin/jvm/functions/Function5;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "Companion", "plugin-finder_release"})
public final class m extends an<ask> {
    public static final a ttf = new a((byte) 0);
    private final int dLS;
    private final b lastBuffer;
    private final int pullType;
    private final s<Integer, Integer, String, ask, q, x> ttc;
    private final ab.c ttd = null;
    private final boolean tte;

    static {
        AppMethodBeat.i(165165);
        AppMethodBeat.o(165165);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, ask ask, q qVar) {
        String str2 = null;
        byte[] bArr = null;
        AppMethodBeat.i(242225);
        ask ask2 = ask;
        p.h(ask2, "resp");
        ab.c cVar = this.ttd;
        if (cVar == null || !cVar.b(ask2)) {
            LinkedList<FinderObject> linkedList = ask2.object;
            if (linkedList == null) {
                p.hyc();
            }
            Log.i("Finder.CgiFinderGetHistory", "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " pullType=" + this.pullType + " list=" + linkedList.size() + " last_buffer=" + ask2.LDs);
            if (i2 == 0 && i3 == 0 && this.tte) {
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                ao azQ = aAh.azQ();
                y yVar = y.vXH;
                ar.a LK = y.LK(this.dLS);
                if (ask2.LDs != null) {
                    b bVar = ask2.LDs;
                    if (bVar != null) {
                        bArr = bVar.toByteArray();
                    }
                    str2 = Util.encodeHexString(bArr);
                }
                azQ.set(LK, str2);
            }
            al alVar = al.tuv;
            Log.i("Finder.CgiFinderGetHistory", al.dQ(linkedList));
            this.ttc.a(Integer.valueOf(i2), Integer.valueOf(i3), str, ask2, qVar);
            AppMethodBeat.o(242225);
            return;
        }
        Log.w("Finder.CgiFinderGetHistory", "has consume.");
        AppMethodBeat.o(242225);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.g.a.s<? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.String, ? super com.tencent.mm.protocal.protobuf.ask, ? super com.tencent.mm.ak.q, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(int i2, int i3, s<? super Integer, ? super Integer, ? super String, ? super ask, ? super q, x> sVar, ab.c cVar, b bVar, bbn bbn) {
        super(bbn);
        p.h(sVar, "callback");
        AppMethodBeat.i(242226);
        this.pullType = i2;
        this.dLS = i3;
        this.ttc = sVar;
        this.lastBuffer = bVar;
        this.tte = false;
        d.a aVar = new d.a();
        asj asj = new asj();
        asj.LAt = z.aUg();
        asj.dLS = this.dLS;
        if (this.tte) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            ao azQ = aAh.azQ();
            y yVar = y.vXH;
            Object obj = azQ.get(y.LK(this.dLS), "");
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(242226);
                throw tVar;
            }
            asj.LDs = b.cD(Util.decodeHexString((String) obj));
        } else {
            asj.LDs = this.lastBuffer;
        }
        Log.i("Finder.CgiFinderGetHistory", "[request] tabType=" + this.dLS + " pullType=" + this.pullType + " useGlobalLastBuffer=" + this.tte);
        am amVar = am.tuw;
        asj.uli = am.a(bbn);
        aVar.c(asj);
        ask ask = new ask();
        ask.setBaseResponse(new BaseResponse());
        ask.getBaseResponse().ErrMsg = new dqi();
        aVar.d(ask);
        aVar.MB("/cgi-bin/micromsg-bin/findergethistory");
        aVar.sG(3814);
        c(aVar.aXF());
        AppMethodBeat.o(242226);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
