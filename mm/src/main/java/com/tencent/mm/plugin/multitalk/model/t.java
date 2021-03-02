package com.tencent.mm.plugin.multitalk.model;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.common.b.a.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\bH\u0016J\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0010J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0004J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0016\u0010 \u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0006\u0010%\u001a\u00020\bJ\u0010\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u000e\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\fX\u0004¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkScreenCastManager;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastEventHandler;", "()V", "canReceiveScreenCast", "", "dispatchToPauseEvent", "Lkotlin/Function1;", "", "", "dispatchToStartEvent", "dispatchToStopEvent", "dispatcher", "", "", "mCurrenScreenCastList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMCurrenScreenCastList", "()Ljava/util/ArrayList;", "setMCurrenScreenCastList", "(Ljava/util/ArrayList;)V", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "close", "getCurrenScreenCastList", "getUserState", "wxUserName", "isCanReceiveScreenCast", "onSwitchVideoScreenSharingRsp", "rsp", "onVideoGroupMemberChange", "memberList", "", "Lcom/tencent/pb/common/network/protocol/nano/ProtocolContacts$VideoGroupMember;", "pauseScreenCast", "refreshScreenList", "registerUiCallback", "callback", "restartScreenCast", "resumeScreenCast", "startScreenCast", "stopScreenCast", "switchScreenCastState", "state", "Companion", "plugin-multitalk_release"})
public final class t implements h {
    public static final a zNJ = new a((byte) 0);
    private final ArrayMap<String, Integer> zKT = new ArrayMap<>();
    private i zNC;
    public final boolean zND;
    public ArrayList<String> zNE;
    private final kotlin.g.a.b<String, x> zNF;
    private final kotlin.g.a.b<String, x> zNG;
    private final kotlin.g.a.b<String, x> zNH;
    private final Map<Integer, kotlin.g.a.b<String, x>> zNI;

    static {
        AppMethodBeat.i(239633);
        AppMethodBeat.o(239633);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "wxUserName", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ t zNK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(t tVar) {
            super(1);
            this.zNK = tVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            boolean z;
            AppMethodBeat.i(239622);
            String str2 = str;
            p.h(str2, "wxUserName");
            if (((Integer) this.zNK.zKT.get(str2)) != null) {
                Integer num = (Integer) this.zNK.zKT.get(str2);
                if (num != null && num.intValue() == 103) {
                    Log.e("MicroMsg.MultiTalkScreenCastManager", "error state change from stop to pause");
                    z = false;
                } else if (num != null && num.intValue() == 102) {
                    Log.i("MicroMsg.MultiTalkScreenCastManager", "state change from pause to pause");
                    z = true;
                } else {
                    t.d(this.zNK, str2);
                    z = true;
                }
            } else {
                t.d(this.zNK, str2);
                z = true;
            }
            if (z) {
                this.zNK.zKT.put(str2, 102);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239622);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "wxUserName", "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ t zNK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(t tVar) {
            super(1);
            this.zNK = tVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(239623);
            String str2 = str;
            p.h(str2, "wxUserName");
            Integer num = (Integer) this.zNK.zKT.get(str2);
            if (num == null) {
                t.a(this.zNK, str2);
            } else if (num != null && num.intValue() == 100) {
                t.a(this.zNK, str2);
            } else if (num != null && num.intValue() == 101) {
                Log.i("MicroMsg.MultiTalkScreenCastManager", "state change from start to start");
            } else if (num != null && num.intValue() == 102) {
                t.b(this.zNK, str2);
            } else if (num != null && num.intValue() == 103) {
                t.c(this.zNK, str2);
            }
            this.zNK.zKT.put(str2, 101);
            x xVar = x.SXb;
            AppMethodBeat.o(239623);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "wxUserName", "", "invoke"})
    static final class d extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ t zNK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(t tVar) {
            super(1);
            this.zNK = tVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(239624);
            String str2 = str;
            p.h(str2, "wxUserName");
            Integer num = (Integer) this.zNK.zKT.get(str2);
            if (num == null) {
                t.e(this.zNK, str2);
            } else if (num != null && num.intValue() == 103) {
                Log.i("MicroMsg.MultiTalkScreenCastManager", "state change from stop to stop");
            } else {
                t.e(this.zNK, str2);
            }
            this.zNK.zKT.put(str2, 103);
            if (ac.eom().yon) {
                q eom = ac.eom();
                p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                eom.enA().eL(str2, 0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239624);
            return xVar;
        }
    }

    public t() {
        AppMethodBeat.i(239632);
        e eVar = e.zZc;
        this.zND = e.eqd();
        this.zNF = new c(this);
        this.zNG = new b(this);
        this.zNH = new d(this);
        this.zNI = ae.e(s.U(101, this.zNF), s.U(102, this.zNG), s.U(103, this.zNH));
        AppMethodBeat.o(239632);
    }

    public static final /* synthetic */ void c(t tVar, String str) {
        AppMethodBeat.i(239636);
        tVar.aGk(str);
        AppMethodBeat.o(239636);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkScreenCastManager$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static void Rk(int i2) {
        AppMethodBeat.i(239625);
        if (ac.eom() != null) {
            q.Rj(i2);
        }
        AppMethodBeat.o(239625);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.h
    public final void Rd(int i2) {
        AppMethodBeat.i(239626);
        Log.i("MicroMsg.MultiTalkScreenCastManager", String.valueOf(i2));
        AppMethodBeat.o(239626);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.h
    public final void fz(List<a.as> list) {
        AppMethodBeat.i(239627);
        p.h(list, "memberList");
        if (!this.zND) {
            AppMethodBeat.o(239627);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Log.i("MicroMsg.MultiTalkScreenCastManager", "memberList is ".concat(String.valueOf(list)));
        ArrayList<a.as> arrayList2 = new ArrayList();
        for (T t : list) {
            if (!p.j(t.dLN, z.aTY())) {
                arrayList2.add(t);
            }
        }
        for (a.as asVar : arrayList2) {
            kotlin.g.a.b<String, x> bVar = this.zNI.get(Integer.valueOf(asVar.RFm));
            if (bVar != null) {
                String str = asVar.dLN;
                p.g(str, "it.wxUserName");
                bVar.invoke(str);
            }
            if (asVar.RFm == 101 || asVar.RFm == 102) {
                arrayList.add(asVar.dLN);
            }
        }
        this.zNE = arrayList;
        AppMethodBeat.o(239627);
    }

    public final void a(i iVar) {
        if (this.zND) {
            this.zNC = iVar;
        }
    }

    public final ArrayList<String> enV() {
        AppMethodBeat.i(239628);
        if (this.zNE != null) {
            ArrayList<String> arrayList = this.zNE;
            AppMethodBeat.o(239628);
            return arrayList;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        AppMethodBeat.o(239628);
        return arrayList2;
    }

    public final int aGj(String str) {
        AppMethodBeat.i(239629);
        p.h(str, "wxUserName");
        Integer num = this.zKT.get(str);
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(239629);
            return intValue;
        }
        AppMethodBeat.o(239629);
        return 100;
    }

    public final void aGk(String str) {
        AppMethodBeat.i(239630);
        i iVar = this.zNC;
        if (iVar != null) {
            iVar.aFD(str);
            AppMethodBeat.o(239630);
            return;
        }
        AppMethodBeat.o(239630);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.h
    public final void close() {
        AppMethodBeat.i(239631);
        this.zKT.clear();
        this.zNC = null;
        ArrayList<String> arrayList = this.zNE;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.zNE = null;
        AppMethodBeat.o(239631);
    }

    public static final /* synthetic */ void a(t tVar, String str) {
        AppMethodBeat.i(239634);
        i iVar = tVar.zNC;
        if (iVar != null) {
            iVar.afd(str);
            AppMethodBeat.o(239634);
            return;
        }
        AppMethodBeat.o(239634);
    }

    public static final /* synthetic */ void b(t tVar, String str) {
        AppMethodBeat.i(239635);
        i iVar = tVar.zNC;
        if (iVar != null) {
            iVar.aFE(str);
            AppMethodBeat.o(239635);
            return;
        }
        AppMethodBeat.o(239635);
    }

    public static final /* synthetic */ void d(t tVar, String str) {
        AppMethodBeat.i(239637);
        i iVar = tVar.zNC;
        if (iVar != null) {
            iVar.aFC(str);
            AppMethodBeat.o(239637);
            return;
        }
        AppMethodBeat.o(239637);
    }

    public static final /* synthetic */ void e(t tVar, String str) {
        AppMethodBeat.i(239638);
        i iVar = tVar.zNC;
        if (iVar != null) {
            iVar.aFF(str);
            AppMethodBeat.o(239638);
            return;
        }
        AppMethodBeat.o(239638);
    }
}
