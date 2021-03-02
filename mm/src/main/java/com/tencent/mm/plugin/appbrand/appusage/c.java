package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.support.v7.h.c;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.aa;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.protocal.protobuf.ech;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.kernel.b.e(com.tencent.mm.plugin.appbrand.api.c.class)
@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0002#$B\u0005¢\u0006\u0002\u0010\u0003J=\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0015H\u0002J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010!\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue;", "Lcom/tencent/mm/kernel/service/IService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "memoryQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "timeoutOpTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "applyDiff", "", "diff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "newList", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "applyDiff$plugin_appbrand_integration_release", "deserializeFromDisk", "", "modelClient2Server", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "clientUse", "onRegister", "onUnregister", "push", "op", "reason", "Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "serializeToDisk", "triggerRequest", "writeBackQueue", "queue", "Companion", "OnModifiedCallback", "plugin-appbrand-integration_release"})
public final class c implements com.tencent.mm.kernel.c.a, com.tencent.mm.kernel.c.b {
    public static final a kUa = new a((byte) 0);
    private final LinkedList<ech> kTY = new LinkedList<>();
    private final MTimerHandler kTZ = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new d(this), false);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "plugin-appbrand-integration_release"})
    public interface b {
        void b(LocalUsageInfo localUsageInfo);

        void c(LocalUsageInfo localUsageInfo);

        void d(LocalUsageInfo localUsageInfo);
    }

    static {
        AppMethodBeat.i(50237);
        AppMethodBeat.o(50237);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class f<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ c kUb;
        final /* synthetic */ aa.b kUi;
        final /* synthetic */ LinkedList kUj;

        f(c cVar, aa.b bVar, LinkedList linkedList) {
            this.kUb = cVar;
            this.kUi = bVar;
            this.kUj = linkedList;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(50229);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "updateWxaStarRecord, onResponse reason=[" + this.kUi.intValue + "], cgi=[" + com.tencent.mm.plugin.appbrand.r.a.e(aVar) + ']');
            if (com.tencent.mm.plugin.appbrand.r.a.d(aVar)) {
                if (((emr) aVar.iLC).Ljo != null) {
                    Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "updateWxaStarRecord, onResponse reason=[" + this.kUi.intValue + "], ErrCode=" + ((emr) aVar.iLC).Ljo.rBL);
                    switch (((emr) aVar.iLC).Ljo.rBL) {
                        case 0:
                            break;
                        case 10001:
                            c.a(this.kUb, this.kUj);
                            break;
                        default:
                            af.a aVar2 = af.kVR;
                            af.a.a(0, 0, null, 7);
                            break;
                    }
                } else {
                    Log.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "updateWxaStarRecord, onResponse reason=[" + this.kUi.intValue + "] NULL wxa_resp");
                }
            } else {
                c.a(this.kUb, this.kUj);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(50229);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$Companion;", "", "()V", "MODIFY_TIMEOUT_INTERVAL", "", "SERIALIZE_KEY", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public c() {
        AppMethodBeat.i(50236);
        AppMethodBeat.o(50236);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class d implements MTimerHandler.CallBack {
        final /* synthetic */ c kUb;

        d(c cVar) {
            this.kUb = cVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(50225);
            this.kUb.a(aa.b.Timeout);
            AppMethodBeat.o(50225);
            return false;
        }
    }

    public final boolean a(c.b bVar, List<? extends LocalUsageInfo> list, List<? extends LocalUsageInfo> list2, b bVar2) {
        AppMethodBeat.i(50232);
        p.h(bVar, "diff");
        p.h(list, "oldList");
        p.h(list2, "newList");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        PInt pInt = new PInt(0);
        synchronized (this.kTY) {
            try {
                bVar.a(new C0557c(this, bVar, pInt, list, list2, bVar2, arrayList));
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(50232);
                throw th;
            }
        }
        if (pInt.value > 0) {
            AppMethodBeat.o(50232);
            return true;
        }
        AppMethodBeat.o(50232);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$applyDiff$1$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.c$c  reason: collision with other inner class name */
    public static final class C0557c implements android.support.v7.h.d {
        final /* synthetic */ c kUb;
        final /* synthetic */ c.b kUc;
        final /* synthetic */ PInt kUd;
        final /* synthetic */ List kUe;
        final /* synthetic */ List kUf;
        final /* synthetic */ b kUg;
        final /* synthetic */ ArrayList kUh;

        C0557c(c cVar, c.b bVar, PInt pInt, List list, List list2, b bVar2, ArrayList arrayList) {
            this.kUb = cVar;
            this.kUc = bVar;
            this.kUd = pInt;
            this.kUe = list;
            this.kUf = list2;
            this.kUg = bVar2;
            this.kUh = arrayList;
        }

        @Override // android.support.v7.h.d
        public final void f(int i2, int i3) {
            LocalUsageInfo localUsageInfo;
            AppMethodBeat.i(50222);
            this.kUd.value += i3;
            Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onInserted position=" + i2 + " count=" + i3 + "  oldList.size=" + this.kUe.size() + "  newList.size=" + this.kUf.size());
            if (i2 + i3 == this.kUf.size()) {
                localUsageInfo = null;
            } else {
                try {
                    localUsageInfo = (LocalUsageInfo) this.kUf.get(i2 + i3);
                } catch (IndexOutOfBoundsException e2) {
                    Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "print old list:" + this.kUe.size());
                    for (LocalUsageInfo localUsageInfo2 : this.kUe) {
                        Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", localUsageInfo2.nickname + ':' + localUsageInfo2.iOo);
                    }
                    Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "print new list:" + this.kUf.size());
                    for (LocalUsageInfo localUsageInfo3 : this.kUf) {
                        Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", localUsageInfo3.nickname + ':' + localUsageInfo3.iOo);
                    }
                    IndexOutOfBoundsException indexOutOfBoundsException = e2;
                    AppMethodBeat.o(50222);
                    throw indexOutOfBoundsException;
                }
            }
            int i4 = (i2 + i3) - 1;
            if (i2 <= i4) {
                while (true) {
                    LocalUsageInfo localUsageInfo4 = (LocalUsageInfo) this.kUf.get(i2);
                    LocalUsageInfo localUsageInfo5 = i2 == 0 ? null : (LocalUsageInfo) this.kUf.get(i2 - 1);
                    b bVar = this.kUg;
                    if (bVar != null) {
                        bVar.b(localUsageInfo4);
                    }
                    c cVar = this.kUb;
                    aa.a aVar = aa.kVI;
                    ecg a2 = c.a(localUsageInfo4);
                    if (a2 == null) {
                        p.hyc();
                    }
                    c.a(cVar, aa.a.a(a2, c.a(localUsageInfo5), c.a(localUsageInfo)));
                    if (i2 == i4) {
                        break;
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(50222);
        }

        @Override // android.support.v7.h.d
        public final void k(int i2, int i3) {
            AppMethodBeat.i(50223);
            this.kUd.value += i3;
            Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onRemoved position=" + i2 + " count=" + i3);
            int i4 = (i2 + i3) - 1;
            if (i2 <= i4) {
                int i5 = i2;
                while (true) {
                    LocalUsageInfo localUsageInfo = (LocalUsageInfo) this.kUh.remove(i2);
                    b bVar = this.kUg;
                    if (bVar != null) {
                        p.g(localUsageInfo, "info");
                        bVar.d(localUsageInfo);
                    }
                    c cVar = this.kUb;
                    aa.a aVar = aa.kVI;
                    ecg a2 = c.a(localUsageInfo);
                    if (a2 == null) {
                        p.hyc();
                    }
                    c.a(cVar, aa.a.a(a2));
                    if (i5 == i4) {
                        break;
                    }
                    i5++;
                }
            }
            AppMethodBeat.o(50223);
        }

        @Override // android.support.v7.h.d
        public final void l(int i2, int i3) {
            LocalUsageInfo localUsageInfo;
            boolean z;
            LocalUsageInfo localUsageInfo2 = null;
            AppMethodBeat.i(50224);
            this.kUd.value++;
            Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onMoved from " + i2 + " to " + i3);
            this.kUh.add(i3, (LocalUsageInfo) this.kUh.remove(i2));
            Object obj = this.kUh.get(i3);
            p.g(obj, "tempList[toPosition]");
            LocalUsageInfo localUsageInfo3 = (LocalUsageInfo) obj;
            if (i3 == 0) {
                localUsageInfo = null;
            } else {
                localUsageInfo = (LocalUsageInfo) this.kUh.get(i3 - 1);
            }
            if (i3 + 1 != this.kUh.size()) {
                localUsageInfo2 = (LocalUsageInfo) this.kUh.get(i3 + 1);
            }
            b bVar = this.kUg;
            if (bVar != null) {
                bVar.c(localUsageInfo3);
            }
            c cVar = this.kUb;
            aa.a aVar = aa.kVI;
            ecg a2 = c.a(localUsageInfo3);
            if (a2 == null) {
                p.hyc();
            }
            ecg a3 = c.a(localUsageInfo);
            ecg a4 = c.a(localUsageInfo2);
            p.h(a2, "self");
            if (aa.a.byt()) {
                if (a3 == null && a4 == null) {
                    z = false;
                } else {
                    z = true;
                }
                if (kotlin.aa.SXc && !z) {
                    AssertionError assertionError = new AssertionError("Assertion failed");
                    AppMethodBeat.o(50224);
                    throw assertionError;
                }
            }
            ech ech = new ech();
            ech.Ncw = a2;
            ech.Ncz = 3;
            ech.Ncx = a3;
            ech.Ncy = a4;
            c.a(cVar, ech);
            AppMethodBeat.o(50224);
        }

        @Override // android.support.v7.h.d
        public final void c(int i2, int i3, Object obj) {
        }
    }

    public static /* synthetic */ void a(c cVar, ech ech) {
        AppMethodBeat.i(50234);
        cVar.a(ech, aa.b.None);
        AppMethodBeat.o(50234);
    }

    public final void a(ech ech, aa.b bVar) {
        AppMethodBeat.i(50233);
        p.h(ech, "op");
        p.h(bVar, "reason");
        synchronized (this.kTY) {
            try {
                this.kTY.addLast(ech);
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(50233);
                throw th;
            }
        }
        switch (d.$EnumSwitchMapping$0[bVar.ordinal()]) {
            case 1:
                this.kTZ.startTimer(30000);
                AppMethodBeat.o(50233);
                return;
            default:
                a(bVar);
                AppMethodBeat.o(50233);
                return;
        }
    }

    public final void a(aa.b bVar) {
        AppMethodBeat.i(50235);
        p.h(bVar, "reason");
        Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason = " + bVar.name());
        this.kTZ.stopTimer();
        LinkedList linkedList = new LinkedList();
        synchronized (this.kTY) {
            try {
                linkedList.addAll(this.kTY);
                this.kTY.clear();
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(50235);
            }
        }
        if (linkedList.isEmpty()) {
            Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason=[" + bVar.intValue + "], queue empty");
            if (bVar == aa.b.ClosePullDown) {
                af.a aVar = af.kVR;
                af.a.a(2, 0, new e(), 2);
                AppMethodBeat.o(50235);
                return;
            }
            if (bVar == aa.b.CloseCollectionList) {
                af.a aVar2 = af.kVR;
                af.a.a(2, 0, null, 6);
            }
            return;
        }
        Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "run cgi reason=[" + bVar.intValue + "], queue_size=" + linkedList.size());
        new aa(linkedList, bVar.intValue).aYI().j(new f(this, bVar, linkedList));
        AppMethodBeat.o(50235);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$triggerRequest$1", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "doNotifyManually", "", "onCgiBack", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"})
    public static final class e implements af.b {
        e() {
        }

        @Override // com.tencent.mm.plugin.appbrand.appusage.af.b
        public final void bxE() {
            AppMethodBeat.i(50226);
            bxF();
            AppMethodBeat.o(50226);
        }

        @Override // com.tencent.mm.plugin.appbrand.appusage.af.b
        public final void b(c.a<bzl> aVar) {
            AppMethodBeat.i(180435);
            if (!com.tencent.mm.plugin.appbrand.r.a.d(aVar)) {
                bxF();
            }
            AppMethodBeat.o(180435);
        }

        private static void bxF() {
            AppMethodBeat.i(50228);
            u uVar = (u) n.W(u.class);
            if (uVar != null) {
                uVar.doNotify(MStorageEventData.EventType.BATCH, 3, null);
                AppMethodBeat.o(50228);
                return;
            }
            AppMethodBeat.o(50228);
        }
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
        AppMethodBeat.i(50230);
        byte[] bArr = n.buP().get("AppBrandCollectionModifyQueue");
        if (bArr != null) {
            if (!(bArr.length == 0)) {
                n.buP().clear("AppBrandCollectionModifyQueue");
                try {
                    eo eoVar = new eo();
                    eoVar.parseFrom(bArr);
                    synchronized (this.kTY) {
                        try {
                            this.kTY.addAll(eoVar.gCs);
                        } finally {
                            AppMethodBeat.o(50230);
                        }
                    }
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "deserializeFromDisk, read kv failed, e = ".concat(String.valueOf(e2)));
                }
            }
            AppMethodBeat.o(50230);
            return;
        }
        AppMethodBeat.o(50230);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBd() {
        AppMethodBeat.i(50231);
        eo eoVar = new eo();
        synchronized (this.kTY) {
            try {
                eoVar.gCs.addAll(this.kTY);
            } finally {
                AppMethodBeat.o(50231);
            }
        }
        if (!eoVar.gCs.isEmpty()) {
            try {
                n.buP().l("AppBrandCollectionModifyQueue", eoVar.toByteArray());
                AppMethodBeat.o(50231);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "serializeToDisk, write kv failed, e = ".concat(String.valueOf(e2)));
            }
        }
    }

    public static final /* synthetic */ ecg a(LocalUsageInfo localUsageInfo) {
        AppMethodBeat.i(50238);
        if (localUsageInfo != null) {
            ecg ecg = new ecg();
            ecg.username = localUsageInfo.username;
            ecg.KXC = localUsageInfo.iOo;
            AppMethodBeat.o(50238);
            return ecg;
        }
        AppMethodBeat.o(50238);
        return null;
    }

    public static final /* synthetic */ void a(c cVar, List list) {
        AppMethodBeat.i(50239);
        if (!list.isEmpty()) {
            synchronized (cVar.kTY) {
                try {
                    cVar.kTY.addAll(0, list);
                } finally {
                    AppMethodBeat.o(50239);
                }
            }
            return;
        }
        AppMethodBeat.o(50239);
    }
}
