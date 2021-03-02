package com.tencent.mm.live.b.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\u0001?B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u0004\u0018\u00010\u0016J\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00160#j\b\u0012\u0004\u0012\u00020\u0016`$J\b\u0010'\u001a\u00020\u0013H\u0002J\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u0005J+\u0010+\u001a\u00020\u00052#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007J)\u0010-\u001a\u00020\u00052!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00050\u0007Jh\u0010.\u001a\u00020\u00052`\u0010,\u001a\\\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00050\rJ\u0016\u0010/\u001a\u00020\u00052\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J)\u00100\u001a\u00020\u00052!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00050\u0007J\u0016\u00101\u001a\u00020\u00052\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J+\u00102\u001a\u00020\u00052#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007J\u000e\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0016J\u000e\u00105\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u00106\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J6\u00107\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000eJ\u001e\u0010;\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u000eJ\u0010\u0010<\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000Rj\u0010\f\u001a^\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00160#j\b\u0012\u0004\u0012\u00020\u0016`$X\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, hxF = {"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "", "()V", "anchorAcceptSelfMicObserver", "Lkotlin/Function0;", "", "anchorCloseLiveObserver", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "liveId", "anchorMicUerSuccessObserver", "Lkotlin/Function4;", "", "uid", "headImg", "nickName", "anchorSetMicEnableObserver", "", "enable", "callingUser", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "micCloseObserver", "self", "sbLinkMicSuccessObserver", "sdkMicUserId", "selfWaitingMicID", "getSelfWaitingMicID", "()Ljava/lang/String;", "setSelfWaitingMicID", "(Ljava/lang/String;)V", "userApplyMicObserver", "show", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCallingUser", "getUserList", "imCallingMic", "reset", "resetMicCallingUser", "resetMicStatus", "setAnchorCloseLiveObserver", "observer", "setLiveMicEnableObserver", "setLiveMicSuccessObserver", "setMicChangeObserver", "setMicCloseObserver", "setSbLinkMicSuccessObserver", "setUserChangeObserver", "updateAnchorAcceptSelfMic", "user", "updateCloseObserver", "updateLiveMicEnable", "updateLiveMicSuccess", "micId", "audience", "sdkUid", "updateMicCloseObserver", "updateSdkMicUid", "updateUser", "liveMicUser", "LiveMicUser", "plugin-logic_release"})
public final class a {
    public kotlin.g.a.b<? super Boolean, x> hKM;
    public kotlin.g.a.a<x> hKN;
    public kotlin.g.a.b<? super Long, x> hKO;
    public kotlin.g.a.b<? super Boolean, x> hKP;
    public r<? super Long, ? super String, ? super String, ? super String, x> hKQ;
    public kotlin.g.a.a<x> hKR;
    public kotlin.g.a.b<? super Boolean, x> hKS;
    public final ArrayList<C0371a> hKT = new ArrayList<>();
    public C0371a hKU;
    public String hKV = "";
    public String hKW = "";

    public a() {
        AppMethodBeat.i(207842);
        AppMethodBeat.o(207842);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ a hKY;

        public g(a aVar) {
            this.hKY = aVar;
        }

        public final void run() {
            AppMethodBeat.i(207836);
            kotlin.g.a.b<? super Boolean, x> bVar = this.hKY.hKM;
            if (bVar != null) {
                bVar.invoke(Boolean.TRUE);
                AppMethodBeat.o(207836);
                return;
            }
            AppMethodBeat.o(207836);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ a hKY;
        final /* synthetic */ boolean hLa;

        public d(a aVar, boolean z) {
            this.hKY = aVar;
            this.hLa = z;
        }

        public final void run() {
            AppMethodBeat.i(207833);
            kotlin.g.a.b<? super Boolean, x> bVar = this.hKY.hKP;
            if (bVar != null) {
                bVar.invoke(Boolean.valueOf(this.hLa));
                AppMethodBeat.o(207833);
                return;
            }
            AppMethodBeat.o(207833);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ a hKY;
        final /* synthetic */ long hvK;

        public c(a aVar, long j2) {
            this.hKY = aVar;
            this.hvK = j2;
        }

        public final void run() {
            AppMethodBeat.i(207832);
            kotlin.g.a.b<? super Long, x> bVar = this.hKY.hKO;
            if (bVar != null) {
                bVar.invoke(Long.valueOf(this.hvK));
                AppMethodBeat.o(207832);
                return;
            }
            AppMethodBeat.o(207832);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ a hKY;
        final /* synthetic */ C0371a hKZ;

        b(a aVar, C0371a aVar2) {
            this.hKY = aVar;
            this.hKZ = aVar2;
        }

        public final void run() {
            AppMethodBeat.i(207831);
            this.hKY.hKU = this.hKZ;
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sysmsg]anchor accept mic " + this.hKZ);
            kotlin.g.a.a<x> aVar2 = this.hKY.hKN;
            if (aVar2 != null) {
                aVar2.invoke();
                AppMethodBeat.o(207831);
                return;
            }
            AppMethodBeat.o(207831);
        }
    }

    public final void a(C0371a aVar) {
        AppMethodBeat.i(207837);
        p.h(aVar, "user");
        MMHandlerThread.postToMainThread(new b(this, aVar));
        AppMethodBeat.o(207837);
    }

    public final void aHk() {
        this.hKU = null;
        this.hKV = "";
    }

    public final void h(kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(207838);
        p.h(bVar, "micCloseObserver");
        this.hKS = bVar;
        AppMethodBeat.o(207838);
    }

    public final void a(long j2, String str, String str2) {
        String str3;
        String str4 = null;
        AppMethodBeat.i(207839);
        p.h(str, "audience");
        p.h(str2, "micId");
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        StringBuilder append = new StringBuilder("[sysmsg]broadcast close mic.liveId:").append(j2).append(" audience:").append(str).append(" micId:").append(str2).append(" isSelf:");
        C0371a aVar2 = this.hKU;
        if (aVar2 != null) {
            str3 = aVar2.hFz;
        } else {
            str3 = null;
        }
        com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", append.append(p.j(str3, str2)).toString());
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        if (j2 != com.tencent.mm.live.b.x.aGr().hyH) {
            AppMethodBeat.o(207839);
            return;
        }
        Iterator<C0371a> it = this.hKT.iterator();
        p.g(it, "userList.iterator()");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0371a next = it.next();
            p.g(next, "mIterator.next()");
            if (p.j(next.hFz, str2)) {
                it.remove();
                break;
            }
        }
        MMHandlerThread.postToMainThread(new e(this));
        C0371a aVar3 = this.hKU;
        if (aVar3 != null) {
            str4 = aVar3.hFz;
        }
        if (p.j(str2, str4)) {
            MMHandlerThread.postToMainThread(new f(this));
        }
        AppMethodBeat.o(207839);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ a hKY;

        e(a aVar) {
            this.hKY = aVar;
        }

        public final void run() {
            AppMethodBeat.i(207834);
            kotlin.g.a.b<? super Boolean, x> bVar = this.hKY.hKM;
            if (bVar != null) {
                bVar.invoke(Boolean.FALSE);
                AppMethodBeat.o(207834);
                return;
            }
            AppMethodBeat.o(207834);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ a hKY;

        f(a aVar) {
            this.hKY = aVar;
        }

        public final void run() {
            AppMethodBeat.i(207835);
            kotlin.g.a.b<? super Boolean, x> bVar = this.hKY.hKS;
            if (bVar != null) {
                bVar.invoke(Boolean.valueOf(this.hKY.aHl()));
                AppMethodBeat.o(207835);
                return;
            }
            AppMethodBeat.o(207835);
        }
    }

    public final void a(long j2, String str, String str2, String str3, String str4, String str5) {
        kotlin.g.a.a<x> aVar;
        AppMethodBeat.i(207840);
        p.h(str, "micId");
        p.h(str2, "audience");
        p.h(str3, "headImg");
        p.h(str4, "nickName");
        p.h(str5, "sdkUid");
        com.tencent.mm.live.core.debug.a aVar2 = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sysmsg]broadcast mic success.micId:" + str + " audience:" + str2 + " nick:" + str4 + " liveId:" + j2 + " sdkUid:" + str5);
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        if (j2 == com.tencent.mm.live.b.x.aGr().hyH) {
            this.hKU = new C0371a(j2, str, str2, "", str5);
            r<? super Long, ? super String, ? super String, ? super String, x> rVar = this.hKQ;
            if (rVar != null) {
                rVar.invoke(Long.valueOf(j2), str2, str3, str4);
            }
            if (!aHl() && (aVar = this.hKR) != null) {
                aVar.invoke();
                AppMethodBeat.o(207840);
                return;
            }
        }
        AppMethodBeat.o(207840);
    }

    public final boolean aHl() {
        String str;
        AppMethodBeat.i(207841);
        C0371a aVar = this.hKU;
        if (aVar != null) {
            str = aVar.hFG;
        } else {
            str = null;
        }
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        boolean j2 = p.j(str, com.tencent.mm.live.b.x.aGr().MnL);
        AppMethodBeat.o(207841);
        return j2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0002J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, hxF = {"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "", "liveId", "", "micId", "", "audience", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "setAudience", "(Ljava/lang/String;)V", "getLiveId", "()J", "setLiveId", "(J)V", "getMicId", "setMicId", "getRoomId", "setRoomId", "getSdkUid", "setSdkUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "Companion", "plugin-logic_release"})
    /* renamed from: com.tencent.mm.live.b.b.a$a  reason: collision with other inner class name */
    public static final class C0371a {
        public static final C0372a hKX = new C0372a((byte) 0);
        public String hFG;
        public String hFJ;
        public String hFz;
        public long liveId;
        public String roomId;

        static {
            AppMethodBeat.i(207828);
            AppMethodBeat.o(207828);
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(207830);
            long j2 = this.liveId;
            int i3 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            String str = this.hFz;
            int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
            String str2 = this.hFJ;
            int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
            String str3 = this.roomId;
            int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
            String str4 = this.hFG;
            if (str4 != null) {
                i2 = str4.hashCode();
            }
            int i4 = hashCode3 + i2;
            AppMethodBeat.o(207830);
            return i4;
        }

        public final String toString() {
            AppMethodBeat.i(207829);
            String str = "LiveMicUser(liveId=" + this.liveId + ", micId=" + this.hFz + ", audience=" + this.hFJ + ", roomId=" + this.roomId + ", sdkUid=" + this.hFG + ")";
            AppMethodBeat.o(207829);
            return str;
        }

        public C0371a(long j2, String str, String str2, String str3, String str4) {
            p.h(str, "micId");
            p.h(str2, "audience");
            p.h(str3, "roomId");
            p.h(str4, "sdkUid");
            AppMethodBeat.i(207827);
            this.liveId = j2;
            this.hFz = str;
            this.hFJ = str2;
            this.roomId = str3;
            this.hFG = str4;
            AppMethodBeat.o(207827);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(207826);
            if (!(obj instanceof C0371a)) {
                AppMethodBeat.o(207826);
                return false;
            } else if (p.j(((C0371a) obj).hFJ, this.hFJ)) {
                AppMethodBeat.o(207826);
                return true;
            } else {
                AppMethodBeat.o(207826);
                return false;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser$Companion;", "", "()V", "getTitleModel", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "plugin-logic_release"})
        /* renamed from: com.tencent.mm.live.b.b.a$a$a  reason: collision with other inner class name */
        public static final class C0372a {
            private C0372a() {
            }

            public /* synthetic */ C0372a(byte b2) {
                this();
            }
        }
    }
}
