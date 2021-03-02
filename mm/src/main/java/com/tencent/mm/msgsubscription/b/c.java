package com.tencent.mm.msgsubscription.b;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0002J\u001e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\f\u001a\u00020\rH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager;", "", "service", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "(Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;)V", "subscribeMsgService", "updatingTaskIdSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "doUpdateSubscribeStatus", "", "updateTask", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$UpdateSubscribeStatusTask;", "isTemplateMsgSubscribed", "bizUsername", "templateId", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onUpdateSubscribeStatusSuccess", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "updateGetSubscribeStatusTimestamp", AppMeasurement.Param.TIMESTAMP, "", "updateSubscribeStatus", "updateSubscribeStatusIfNecessary", "subscribeMsgTmpItem", "Companion", "plugin-comm_release"})
public final class c {
    public static final a jzK = new a((byte) 0);
    private final HashSet<String> jzI = new HashSet<>();
    ISubscribeMsgService jzJ;

    static {
        AppMethodBeat.i(223284);
        AppMethodBeat.o(223284);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$Companion;", "", "()V", "DEFAULT_MAX_CACHE_AGE_FOR_TEST_IN_SEC", "", "DEFAULT_MAX_CACHE_AGE_IN_SEC", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public c(ISubscribeMsgService iSubscribeMsgService) {
        p.h(iSubscribeMsgService, "service");
        AppMethodBeat.i(223283);
        this.jzJ = iSubscribeMsgService;
        AppMethodBeat.o(223283);
    }

    public static final /* synthetic */ void a(c cVar, SubscribeMsgTmpItem subscribeMsgTmpItem, a.b bVar) {
        AppMethodBeat.i(223285);
        cVar.a(subscribeMsgTmpItem, bVar);
        AppMethodBeat.o(223285);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$isTemplateMsgSubscribed$2", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    /* renamed from: com.tencent.mm.msgsubscription.b.c$c  reason: collision with other inner class name */
    public static final class C0468c implements com.tencent.mm.msgsubscription.api.a {
        final /* synthetic */ String jzC;
        final /* synthetic */ ISubscribeMsgService.b jzG;
        final /* synthetic */ c jzL;
        final /* synthetic */ z.f jzN;

        C0468c(c cVar, String str, ISubscribeMsgService.b bVar, z.f fVar) {
            this.jzL = cVar;
            this.jzC = str;
            this.jzG = bVar;
            this.jzN = fVar;
        }

        @Override // com.tencent.mm.msgsubscription.api.a
        public final void i(int i2, int i3, String str) {
            AppMethodBeat.i(223276);
            p.h(str, "errMsg");
            Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo loadSubscribeMsgList onError templateId: " + this.jzC + ", errType: " + i2 + ", errCode: " + i3 + ", errMsg: " + str);
            ISubscribeMsgService.b bVar = this.jzG;
            if (bVar != null) {
                bVar.onError();
                AppMethodBeat.o(223276);
                return;
            }
            AppMethodBeat.o(223276);
        }

        @Override // com.tencent.mm.msgsubscription.api.a
        public final void a(String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            int i2;
            AppMethodBeat.i(223275);
            p.h(str, "bizUsername");
            p.h(subscribeMsgRequestResult, "result");
            ArrayList<SubscribeMsgTmpItem> arrayList = subscribeMsgRequestResult.jyk;
            if (!arrayList.isEmpty()) {
                for (T t : arrayList) {
                    if (this.jzC.equals(t.ixM)) {
                        ISubscribeMsgService.b bVar = this.jzG;
                        if (bVar != null) {
                            bVar.a(this.jzC, new ISubscribeMsgService.c(t.jyB == 1, t.VC));
                        }
                        this.jzN.SYG = t;
                    }
                }
            }
            c cVar = this.jzL;
            T t2 = this.jzN.SYG;
            String str2 = this.jzC;
            T t3 = this.jzN.SYG;
            if (t3 != null) {
                i2 = t3.jyB;
            } else {
                i2 = -1;
            }
            a.b bVar2 = new a.b(str, str2, i2);
            bVar2.jzA = this.jzG;
            c.a(cVar, (SubscribeMsgTmpItem) t2, bVar2);
            AppMethodBeat.o(223275);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$switchSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class d implements com.tencent.mm.msgsubscription.api.a {
        final /* synthetic */ SubscribeMsgTmpItem jzF;
        final /* synthetic */ ISubscribeMsgService.b jzG;
        final /* synthetic */ c jzL;
        final /* synthetic */ String jzO;

        d(c cVar, SubscribeMsgTmpItem subscribeMsgTmpItem, ISubscribeMsgService.b bVar, String str) {
            this.jzL = cVar;
            this.jzF = subscribeMsgTmpItem;
            this.jzG = bVar;
            this.jzO = str;
        }

        @Override // com.tencent.mm.msgsubscription.api.a
        public final void a(String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            ISubscribeMsgService.c cVar;
            AppMethodBeat.i(223277);
            p.h(str, "bizUsername");
            p.h(subscribeMsgRequestResult, "result");
            Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onSuccess bizUsername: %s, templateId: %s, settingStatus: %d", str, this.jzF.ixM, Integer.valueOf(this.jzF.jyB));
            boolean z = false;
            boolean z2 = false;
            for (T t : subscribeMsgRequestResult.jyk) {
                if (this.jzF.ixM.equals(t.ixM)) {
                    z = t.VC;
                    z2 = true;
                }
            }
            if (z2) {
                cVar = new ISubscribeMsgService.c(this.jzF.jyB == 1, z);
            } else {
                cVar = new ISubscribeMsgService.c(false, this.jzF.VC);
            }
            Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onSuccess hasResult: %b, isSubscribed: %b, switchOpen: %b", Boolean.valueOf(z2), Boolean.valueOf(cVar.jyX), Boolean.valueOf(cVar.jyY));
            this.jzG.a(this.jzF.ixM, cVar);
            ISubscribeMsgService iSubscribeMsgService = this.jzL.jzJ;
            if (iSubscribeMsgService != null) {
                ISubscribeMsgService.a.a(iSubscribeMsgService, str, subscribeMsgRequestResult.jyk);
                AppMethodBeat.o(223277);
                return;
            }
            AppMethodBeat.o(223277);
        }

        @Override // com.tencent.mm.msgsubscription.api.a
        public final void i(int i2, int i3, String str) {
            AppMethodBeat.i(223278);
            p.h(str, "errMsg");
            Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus onError templateId: " + this.jzF.ixM + ", errType: " + i2 + ", errCode: " + i3 + ", errMsg: " + str);
            if (this.jzF.jyB == 1) {
                this.jzF.jyB = 0;
            } else {
                this.jzF.jyB = 1;
            }
            this.jzG.onError();
            ISubscribeMsgService iSubscribeMsgService = this.jzL.jzJ;
            if (iSubscribeMsgService != null) {
                ISubscribeMsgService.a.a(iSubscribeMsgService, this.jzO, j.mutableListOf(this.jzF));
                AppMethodBeat.o(223278);
                return;
            }
            AppMethodBeat.o(223278);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(SubscribeMsgTmpItem subscribeMsgTmpItem, a.b bVar) {
        AppMethodBeat.i(223279);
        b bVar2 = b.jzH;
        if (b.b(subscribeMsgTmpItem)) {
            a(bVar);
            AppMethodBeat.o(223279);
            return;
        }
        Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo updateSubscribeStatusIfNecessary no need to update");
        AppMethodBeat.o(223279);
    }

    private final void a(a.b bVar) {
        AppMethodBeat.i(223280);
        if (this.jzI.contains(bVar.ixM)) {
            Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo updateSubscribeStatus templateId: %s is updating", bVar.ixM);
            AppMethodBeat.o(223280);
            return;
        }
        b(bVar);
        AppMethodBeat.o(223280);
    }

    private final void b(a.b bVar) {
        AppMethodBeat.i(223281);
        Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo doUpdateSubscribeStatus templateId: %s, bizUsername: %s", bVar.ixM, bVar.dVu);
        this.jzI.add(bVar.ixM);
        ISubscribeMsgService iSubscribeMsgService = this.jzJ;
        if (iSubscribeMsgService != null) {
            iSubscribeMsgService.a(bVar.dVu, j.mutableListOf(bVar.ixM), new b(this, bVar));
        }
        h(bVar.dVu, bVar.ixM, System.currentTimeMillis() + 30000);
        AppMethodBeat.o(223281);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager$doUpdateSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class b implements com.tencent.mm.msgsubscription.api.a {
        final /* synthetic */ c jzL;
        final /* synthetic */ a.b jzM;

        b(c cVar, a.b bVar) {
            this.jzL = cVar;
            this.jzM = bVar;
        }

        @Override // com.tencent.mm.msgsubscription.api.a
        public final void a(String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(223273);
            p.h(str, "bizUsername");
            p.h(subscribeMsgRequestResult, "result");
            this.jzL.jzI.remove(this.jzM.ixM);
            c.a(this.jzL, subscribeMsgRequestResult, this.jzM);
            AppMethodBeat.o(223273);
        }

        @Override // com.tencent.mm.msgsubscription.api.a
        public final void i(int i2, int i3, String str) {
            AppMethodBeat.i(223274);
            p.h(str, "errMsg");
            Log.e("MicroMsg.SubscribeStatusUpdateManager", "alvinluo getSubscribeStatus onError templateId: " + this.jzM.ixM + ", errType: " + i2 + ", errCode: " + i3 + ", errMsg: " + str);
            this.jzL.jzI.remove(this.jzM.ixM);
            ISubscribeMsgService.b bVar = this.jzM.jzA;
            if (bVar != null) {
                bVar.onError();
                AppMethodBeat.o(223274);
                return;
            }
            AppMethodBeat.o(223274);
        }
    }

    private final void h(String str, String str2, long j2) {
        AppMethodBeat.i(223282);
        ISubscribeMsgService iSubscribeMsgService = this.jzJ;
        if (iSubscribeMsgService != null) {
            iSubscribeMsgService.g(str, str2, j2);
            AppMethodBeat.o(223282);
            return;
        }
        AppMethodBeat.o(223282);
    }

    public static final /* synthetic */ void a(c cVar, SubscribeMsgRequestResult subscribeMsgRequestResult, a.b bVar) {
        AppMethodBeat.i(223286);
        Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo onUpdateSubscribeUIStatusSuccess onSuccess %d, templateId: %s", Integer.valueOf(subscribeMsgRequestResult.jyk.size()), bVar.ixM);
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        boolean z = false;
        for (T t : subscribeMsgRequestResult.jyk) {
            if (t.ixM.equals(bVar.ixM)) {
                Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo onUpdateSubscribeUIStatusSuccess templateId: %s, %d, cacheMax: %d, switchOpen: %b", t.ixM, Integer.valueOf(t.jyB), Integer.valueOf(subscribeMsgRequestResult.jyj), Boolean.valueOf(t.VC));
                i2 = t.jyB;
                z = t.VC;
                t.VC = subscribeMsgRequestResult.jyo;
                if (subscribeMsgRequestResult.jyj <= 0) {
                    t.jyC = System.currentTimeMillis() + 30000;
                } else {
                    t.jyC = System.currentTimeMillis() + (((long) subscribeMsgRequestResult.jyj) * 1000);
                }
                arrayList.add(t);
            }
        }
        ISubscribeMsgService.b bVar2 = bVar.jzA;
        if (bVar2 != null) {
            bVar2.a(bVar.ixM, new ISubscribeMsgService.c(i2 == 1, z));
        }
        ISubscribeMsgService iSubscribeMsgService = cVar.jzJ;
        if (iSubscribeMsgService != null) {
            iSubscribeMsgService.a(bVar.dVu, (List<SubscribeMsgTmpItem>) arrayList, z, true, true);
            AppMethodBeat.o(223286);
            return;
        }
        AppMethodBeat.o(223286);
    }
}
