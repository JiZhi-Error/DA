package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.finder.extension.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bde;
import com.tencent.mm.protocal.protobuf.bdf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002-.B5\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017J\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010 \u001a\u00020\bJ\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J>\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", ch.COL_USERNAME, "", "keyBuf", "", "selector", "", "scene", "args", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;", "(Ljava/lang/String;[BIILcom/tencent/mm/plugin/finder/extension/FinderSyncExtension$SyncArgs;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "enableReportVal", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "getContactsList", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getContinueFlag", "getInterval", "getRequestKeyBuf", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "getResponseKeyBuf", "getSelector", "getType", "isEnableReport", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "transformToServerScene", "localScene", "Companion", "FinderSyncScene", "plugin-finder_release"})
public final class ci extends ax implements m {
    public static final a two = new a((byte) 0);
    private i callback;
    public d rr;
    private b ttH = b.Disable;

    static {
        AppMethodBeat.i(165277);
        AppMethodBeat.o(165277);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSync$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public ci(String str, byte[] bArr, int i2, int i3, a.b bVar) {
        String str2;
        LinkedList<bbi> linkedList;
        String str3;
        int i4 = 3;
        LinkedList<bbi> linkedList2 = null;
        AppMethodBeat.i(242513);
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/findersync");
        bde bde = new bde();
        bde.dML = i2;
        bde.finderUsername = str;
        bde.LMX = z.aC(bArr);
        am amVar = am.tuw;
        bde.uli = am.cXY();
        aov aov = bde.uli;
        if (aov != null) {
            if (i3 != 3) {
                if (i3 == 7) {
                    i4 = 1;
                } else if (i3 == 2 || i3 == 4) {
                    i4 = 2;
                } else if (i3 == 5 || i3 == 6) {
                    i4 = 4;
                } else if (i3 == 1) {
                    i4 = 5;
                } else if (i3 == 8) {
                    i4 = 6;
                } else if (i3 >= 10000) {
                    i4 = i3;
                } else {
                    RuntimeException runtimeException = new RuntimeException("unknown this localScene(" + i3 + ')');
                    AppMethodBeat.o(242513);
                    throw runtimeException;
                }
            }
            aov.scene = i4;
        }
        if (bVar != null) {
            str2 = bVar.tIX;
        } else {
            str2 = null;
        }
        bde.LMZ = str2;
        if (bVar != null) {
            linkedList = bVar.tIY;
        } else {
            linkedList = null;
        }
        bde.LMY = linkedList;
        if (bVar != null) {
            str3 = bVar.tIZ;
        } else {
            str3 = null;
        }
        bde.LNb = str3;
        bde.LNa = bVar != null ? bVar.tJa : linkedList2;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        bde.VjH = ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).UVM;
        bdf bdf = new bdf();
        bdf.setBaseResponse(new BaseResponse());
        aVar.c(bde);
        aVar.d(bdf);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        StringBuilder append = new StringBuilder("NetSceneFinderSync init selector=").append(i2).append(" scene=").append(i3).append(" ctrlInfo type=");
        LinkedList<bbi> linkedList3 = bde.LMY;
        p.g(linkedList3, "request.ctrlInfoList");
        LinkedList<bbi> linkedList4 = linkedList3;
        ArrayList arrayList = new ArrayList(j.a(linkedList4, 10));
        Iterator<T> it = linkedList4.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().LKM);
        }
        Log.i("Finder.NetSceneFinderSync", append.append(arrayList).append(' ').append("entranceTipsId=").append(bde.LMZ).append(" stay_display_tab_type=").append(bde.VjH).toString());
        AppMethodBeat.o(242513);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3565;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165271);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165271);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242512);
        Log.i("Finder.NetSceneFinderSync", "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (sVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
            AppMethodBeat.o(242512);
            throw tVar;
        }
        com.tencent.mm.bw.a aYK = ((d) sVar).aYK();
        if (aYK == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
            AppMethodBeat.o(242512);
            throw tVar2;
        }
        bdf bdf = (bdf) aYK;
        if (i3 >= 4) {
            this.ttH = b.Default;
        }
        if (i3 == 0 && i4 == 0) {
            e.INSTANCE.idkeyStat(1279, 11, 1, false);
            apb apb = bdf.LNe;
            if (apb != null) {
                StringBuilder sb = new StringBuilder("[onGYNetEnd] check_expire_info=");
                p.g(apb, LocaleUtil.ITALIAN);
                Log.i("Finder.NetSceneFinderSync", sb.append(cj.a(apb)).toString());
                if (apb.LBb == 1) {
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    aAh.azQ().set(ar.a.USERINFO_FINDER_RED_DOT_EXPIRED_INFO_STRING_SYNC, Util.encodeHexString(apb.toByteArray()));
                }
            }
        } else {
            e.INSTANCE.idkeyStat(1279, 12, 1, false);
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242512);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final b cXS() {
        return this.ttH;
    }

    public final int cYA() {
        AppMethodBeat.i(165273);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
            AppMethodBeat.o(165273);
            throw tVar;
        }
        int i2 = ((bdf) aYK).continueFlag;
        AppMethodBeat.o(165273);
        return i2;
    }

    public final int getInterval() {
        AppMethodBeat.i(165274);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
            AppMethodBeat.o(165274);
            throw tVar;
        }
        int i2 = ((bdf) aYK).LNd;
        AppMethodBeat.o(165274);
        return i2;
    }

    public final List<apf> cZf() {
        AppMethodBeat.i(165275);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSyncResponse");
            AppMethodBeat.o(165275);
            throw tVar;
        }
        LinkedList<apf> linkedList = ((bdf) aYK).sKS;
        p.g(linkedList, "(rr.responseProtoBuf as …nderSyncResponse).cmdList");
        LinkedList<apf> linkedList2 = linkedList;
        AppMethodBeat.o(165275);
        return linkedList2;
    }
}
