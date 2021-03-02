package com.tencent.mm.plugin.vlog.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.ccw;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u0001:\u0001@B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\u0002J\u000e\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0004J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0%J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\nJ\u0006\u0010-\u001a\u00020\nJA\u0010.\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u00042%\u00100\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012J,\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\b2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0006\u00107\u001a\u00020\u0017J\u0016\u00108\u001a\b\u0012\u0004\u0012\u0002090%2\u0006\u0010:\u001a\u00020\u001cH\u0002J\u0016\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004J\u0014\u0010>\u001a\u00020\u00172\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001f0%R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R-\u0010\u0011\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "currentIndex", "", "id2path", "", "", "", "isAllImageMaterial", "", "materials", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "netScriptCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "", "previewHeight", "previewWidth", "scripts", "", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "sid", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "vLogConf", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "generateVlog", "", "getIndexScript", FirebaseAnalytics.b.INDEX, "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getPreviewSize", "Landroid/util/Size;", "hasPrepared", "isAllImageMaterials", "loadPlayScript", "fid", "callback", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "renderScript", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "setPreviewSize", "width", "height", "setSource", "sourceTrackList", "Companion", "plugin-vlog_release"})
public final class ae implements i {
    public static final a GzI = new a((byte) 0);
    public int DYl;
    public final LinkedList<ad> Gyw = new LinkedList<>();
    private LinkedList<cmt> GzC = new LinkedList<>();
    public aar GzD;
    private Map<Long, String> GzE = new LinkedHashMap();
    public kotlin.g.a.b<? super bha, x> GzF;
    public List<erh> GzG = new ArrayList();
    public boolean GzH;
    public final MultiProcessMMKV cQe = MultiProcessMMKV.getSingleMMKV("MicroMsg.VLogDataManager");
    public int currentIndex;
    int previewHeight;
    int previewWidth;

    static {
        AppMethodBeat.i(190719);
        AppMethodBeat.o(190719);
    }

    public ae() {
        AppMethodBeat.i(190718);
        g.azz().a(1469, this);
        g.azz().a(2972, this);
        AppMethodBeat.o(190718);
    }

    public final List<clp> eua() {
        AppMethodBeat.i(190714);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (T t : this.GzG) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            clp clp = new clp();
            String str = t2.NoU.MqU;
            if (str == null) {
                str = "";
            }
            clp.MqU = str;
            clp.MqO = (int) t2.NoU.LQL;
            clp.MqX = t2.NoU.MqX;
            String str2 = t2.NoU.MqW;
            if (str2 == null) {
                str2 = "";
            }
            clp.MqW = str2;
            clp.MqY = t2.NoU.MqY;
            arrayList.add(clp);
            i2 = i3;
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(190714);
        return arrayList2;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(190715);
        if (!(qVar instanceof com.tencent.mm.plugin.vlog.model.cgi.b)) {
            if (qVar instanceof com.tencent.mm.plugin.vlog.model.cgi.a) {
                if (i2 == 0 && i3 == 0) {
                    bgz bgz = ((com.tencent.mm.plugin.vlog.model.cgi.a) qVar).GAe;
                    if (bgz == null) {
                        p.btv("response");
                    }
                    bha bha = bgz.LQN;
                    long j2 = bha.KPp;
                    LinkedList<erh> linkedList = bha.LQO;
                    Log.i("MicroMsg.VLogDataManager", "generate vlog response, ret = " + j2 + ", scripts = " + linkedList);
                    this.currentIndex = 0;
                    List<erh> list = this.GzG;
                    p.g(linkedList, "scripts");
                    list.addAll(0, linkedList);
                    if (!linkedList.isEmpty()) {
                        kotlin.g.a.b<? super bha, x> bVar = this.GzF;
                        if (bVar != null) {
                            bVar.invoke(bha);
                        }
                    } else {
                        kotlin.g.a.b<? super bha, x> bVar2 = this.GzF;
                        if (bVar2 != null) {
                            bVar2.invoke(null);
                        }
                    }
                    this.GzF = null;
                } else {
                    Log.w("MicroMsg.VLogDataManager", "generate vlog from server error, errType = " + i2 + ", errCode = " + i3);
                    AppMethodBeat.o(190715);
                    return;
                }
            }
            AppMethodBeat.o(190715);
        } else if (i2 == 0 && i3 == 0) {
            blj blj = ((com.tencent.mm.plugin.vlog.model.cgi.b) qVar).GAh;
            if (blj == null) {
                p.btv("response");
            }
            this.GzD = blj.LUp;
            MultiProcessMMKV multiProcessMMKV = this.cQe;
            aar aar = this.GzD;
            if (aar == null) {
                p.hyc();
            }
            multiProcessMMKV.encode("VLOG_CONF", aar.toByteArray());
            hN(this.Gyw);
            AppMethodBeat.o(190715);
        } else {
            Log.w("MicroMsg.VLogDataManager", "get client from server error, errType = " + i2 + ", errCode = " + i3);
            AppMethodBeat.o(190715);
        }
    }

    public final void hN(List<ad> list) {
        AppMethodBeat.i(190716);
        d.b("generateVLog", new b(this, list));
        AppMethodBeat.o(190716);
    }

    public final List<s> a(erh erh) {
        q qVar;
        y yVar;
        q qVar2;
        ab abVar;
        q qVar3;
        AppMethodBeat.i(190717);
        LinkedList<cmu> linkedList = erh.GzC;
        p.g(linkedList, "script.materials");
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            String str = this.GzE.get(Long.valueOf(t.id));
            if (str == null) {
                str = "";
            }
            t.path = str;
            long j2 = t.dDw;
            if (j2 == 2) {
                String str2 = this.GzE.get(Long.valueOf(t.id));
                if (str2 == null) {
                    str2 = "";
                }
                qVar = new aj(str2, t.Mso, t.Msp, (float) t.Msq, t.begin_time, t.begin_time + t.duration);
            } else if (j2 == 1) {
                String str3 = this.GzE.get(Long.valueOf(t.id));
                if (str3 == null) {
                    str3 = "";
                }
                qVar = new q(str3, t.begin_time, t.begin_time + t.duration);
            } else {
                qVar = null;
            }
            if (qVar != null) {
                if (t.Msm == 3) {
                    yVar = y.VERTICAL_DISPLAY;
                } else {
                    yVar = y.CENTER_INSIDE;
                }
                qVar.a(yVar);
                if (t.Mst == null) {
                    qVar2 = qVar;
                } else if (t.Mst.Msk == 2) {
                    abVar = ab.FADE;
                    qVar3 = qVar;
                    qVar3.a(abVar);
                    qVar.Gyt = t.Msr;
                    qVar.Gyu = t.Mss;
                } else {
                    qVar2 = qVar;
                }
                abVar = ab.NONE;
                qVar3 = qVar2;
                qVar3.a(abVar);
                qVar.Gyt = t.Msr;
                qVar.Gyu = t.Mss;
            } else {
                qVar = null;
            }
            if (qVar != null) {
                arrayList.add(qVar);
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(190717);
        return arrayList2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager$Companion;", "", "()V", "KEY_VLOG_CONF", "", "TAG", "renderScript", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static List<s> a(erh erh) {
            q qVar;
            y yVar;
            q qVar2;
            ab abVar;
            q qVar3;
            AppMethodBeat.i(190712);
            p.h(erh, "script");
            LinkedList<cmu> linkedList = erh.GzC;
            p.g(linkedList, "script.materials");
            ArrayList arrayList = new ArrayList();
            for (T t : linkedList) {
                long j2 = t.dDw;
                if (j2 == 2) {
                    String str = t.path;
                    p.g(str, "materialResp.path");
                    qVar = new aj(str, t.Mso, t.Msp, (float) t.Msq, t.begin_time, t.begin_time + t.duration);
                } else if (j2 == 1) {
                    String str2 = t.path;
                    p.g(str2, "materialResp.path");
                    qVar = new q(str2, t.begin_time, t.begin_time + t.duration);
                } else {
                    qVar = null;
                }
                if (qVar != null) {
                    if (t.Msm == 3) {
                        yVar = y.VERTICAL_DISPLAY;
                    } else {
                        yVar = y.CENTER_INSIDE;
                    }
                    qVar.a(yVar);
                    if (t.Mst == null) {
                        qVar2 = qVar;
                    } else if (t.Mst.Msk == 2) {
                        abVar = ab.FADE;
                        qVar3 = qVar;
                        qVar3.a(abVar);
                        qVar.Gyt = t.Msr;
                        qVar.Gyu = t.Mss;
                    } else {
                        qVar2 = qVar;
                    }
                    abVar = ab.NONE;
                    qVar3 = qVar2;
                    qVar3.a(abVar);
                    qVar.Gyt = t.Msr;
                    qVar.Gyu = t.Mss;
                } else {
                    qVar = null;
                }
                if (qVar != null) {
                    arrayList.add(qVar);
                }
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(190712);
            return arrayList2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ae GzJ;
        final /* synthetic */ List GzK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ae aeVar, List list) {
            super(0);
            this.GzJ = aeVar;
            this.GzK = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(190713);
            long currentTimeMillis = System.currentTimeMillis();
            p.g(g.aAf(), "account()");
            String ayV = com.tencent.mm.kernel.a.ayV();
            p.g(ayV, "account().uinString");
            long parseLong = Long.parseLong(ayV);
            if (this.GzJ.DYl == 0) {
                al alVar = al.GAc;
                al.ax(currentTimeMillis, parseLong);
            }
            this.GzJ.GzC = new LinkedList();
            ag agVar = new ag();
            agVar.GzN = this.GzJ.GzD;
            for (ad adVar : this.GzK) {
                this.GzJ.GzE.put(Long.valueOf((long) adVar.id), adVar.path);
            }
            this.GzJ.GzC = agVar.hO(this.GzK);
            dus dus = new dus();
            ccw ccw = new ccw();
            ccw.width = (long) this.GzJ.previewWidth;
            ccw.height = (long) this.GzJ.previewHeight;
            dus.MVX = ccw;
            dus.MVY = 30;
            Log.d("MicroMsg.VLogDataManager", "generate vlog, materials = " + this.GzJ.GzC.size());
            g.azz().b(new com.tencent.mm.plugin.vlog.model.cgi.a(currentTimeMillis, parseLong, this.GzJ.GzC, dus, this.GzJ.DYl));
            x xVar = x.SXb;
            AppMethodBeat.o(190713);
            return xVar;
        }
    }
}
