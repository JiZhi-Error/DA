package com.tencent.mm.msgsubscription.d;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u00015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0002JH\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\tH\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u001a\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0017J4\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0002J\u001e\u0010%\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0002J\u0016\u0010&\u001a\u00020\u000e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0(H\u0002J.\u0010)\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u001e\u0010*\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0002J\u001e\u0010+\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0003JX\u0010+\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u001428\u0010'\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\f¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u000e0,H\u0003J8\u00101\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\u0006\u00102\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0017J\u001e\u00103\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0016J\u0018\u00104\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\tH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f`\nX\u0004¢\u0006\u0002\n\u0000¨\u00066"}, hxF = {"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageManager;", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "()V", "MMKV_FILE_KEY_POSTFIX", "", "SubscribeMsgSaveExecutorTag", "TAG", "mTotalSwitchOpenMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "subscribeMsgTmpCacheMap", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", com.tencent.mm.plugin.appbrand.jsapi.storage.a.NAME, "", "doSaveSubscribeMsgList", "scene", "", "bizUsername", "subscribeMsgList", "", "subscribeSwitchOpened", "doSaveSubscribeStatus", "toSaveList", "switchOpen", "needUpdateSettingStatus", "needUpdateSwitchOpen", "needUpdateTimestamp", "getCacheKey", "templateId", "getMMKVKey", "getSubscribeMsgListWrapper", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "getSubscribeSwitchOpened", "getSubscribeTmpByTemplateId", "mergeSubscribeMsgList", "savedList", "processSubscribeMsgList", "runInMainUI", "task", "Lkotlin/Function0;", "saveSubscribeMsgList", "updateCache", "updateCacheList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cachedItem", "toUpdateItem", "updateSubscribeStatus", "switchOpened", "updateSubscribeStatusTimestamp", "updateSwitchOpen", "ParcelUtil", "plugin-comm_release"})
public final class c implements a {
    private static final HashMap<String, SubscribeMsgTmpItem> jAD = new HashMap<>();
    private static HashMap<String, Boolean> jAE = new HashMap<>();
    public static final c jAF = new c();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ List jAH;
        final /* synthetic */ boolean jAI;
        final /* synthetic */ boolean jAJ;
        final /* synthetic */ boolean jAK;
        final /* synthetic */ boolean jAL;
        final /* synthetic */ String jzO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(List list, String str, boolean z, boolean z2, boolean z3, boolean z4) {
            super(0);
            this.jAH = list;
            this.jzO = str;
            this.jAI = z;
            this.jAJ = z2;
            this.jAK = z3;
            this.jAL = z4;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "cachedItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "toUpdateItem", "invoke", "com/tencent/mm/msgsubscription/storage/SubscribeMsgStorageManager$doSaveSubscribeStatus$2$1$1"})
        static final class a extends q implements m<SubscribeMsgTmpItem, SubscribeMsgTmpItem, x> {
            final /* synthetic */ b jAM;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(2);
                this.jAM = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(SubscribeMsgTmpItem subscribeMsgTmpItem, SubscribeMsgTmpItem subscribeMsgTmpItem2) {
                AppMethodBeat.i(223345);
                SubscribeMsgTmpItem subscribeMsgTmpItem3 = subscribeMsgTmpItem;
                SubscribeMsgTmpItem subscribeMsgTmpItem4 = subscribeMsgTmpItem2;
                p.h(subscribeMsgTmpItem4, "toUpdateItem");
                Log.v("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgUiStatus updateCache templateId: %s settingStatus: %ss", subscribeMsgTmpItem4.ixM, Integer.valueOf(subscribeMsgTmpItem4.jyB));
                if (subscribeMsgTmpItem3 != null) {
                    if (this.jAM.jAI) {
                        subscribeMsgTmpItem3.jyB = subscribeMsgTmpItem4.jyB;
                    }
                    if (this.jAM.jAJ) {
                        subscribeMsgTmpItem3.jyC = subscribeMsgTmpItem4.jyC;
                    }
                    if (this.jAM.jAK) {
                        subscribeMsgTmpItem3.VC = subscribeMsgTmpItem4.VC;
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(223345);
                return xVar;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(223346);
            List list = this.jAH;
            if (list != null) {
                c cVar = c.jAF;
                c.a(this.jzO, list, new a(this));
            }
            if (this.jAK) {
                c cVar2 = c.jAF;
                c.ab(this.jzO, this.jAL);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(223346);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(223365);
        AppMethodBeat.o(223365);
    }

    private c() {
    }

    public static final /* synthetic */ void ab(String str, boolean z) {
        AppMethodBeat.i(223368);
        aa(str, z);
        AppMethodBeat.o(223368);
    }

    public static final /* synthetic */ void g(String str, List list) {
        AppMethodBeat.i(223369);
        f(str, list);
        AppMethodBeat.o(223369);
    }

    private static String biZ() {
        AppMethodBeat.i(223350);
        StringBuilder sb = new StringBuilder();
        p.g(g.aAf(), "MMKernel.account()");
        String sb2 = sb.append(com.tencent.mm.kernel.a.ayV()).append("_subscribe_msg_storage").toString();
        AppMethodBeat.o(223350);
        return sb2;
    }

    private static String bJ(String str, String str2) {
        AppMethodBeat.i(223351);
        String str3 = str + str2;
        AppMethodBeat.o(223351);
        return str3;
    }

    @Override // com.tencent.mm.msgsubscription.d.a
    public final void biY() {
        AppMethodBeat.i(223352);
        Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo SubscribeMsg clearStorage");
        MultiProcessMMKV.getMMKV(biZ()).clear();
        AppMethodBeat.o(223352);
    }

    @Override // com.tencent.mm.msgsubscription.d.a
    public final SubscribeMsgTmpItem bI(String str, String str2) {
        AppMethodBeat.i(223353);
        p.h(str, "bizUsername");
        p.h(str2, "templateId");
        SubscribeMsgTmpItem subscribeMsgTmpItem = jAD.get(bJ(str, str2));
        AppMethodBeat.o(223353);
        return subscribeMsgTmpItem;
    }

    @Override // com.tencent.mm.msgsubscription.d.a
    public final boolean Rz(String str) {
        AppMethodBeat.i(223354);
        p.h(str, "bizUsername");
        Boolean bool = jAE.get(str);
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(223354);
            return booleanValue;
        }
        AppMethodBeat.o(223354);
        return false;
    }

    @Override // com.tencent.mm.msgsubscription.d.a
    public final ISubscribeMsgService.Companion.SubscribeMsgListWrapper RA(String str) {
        AppMethodBeat.i(223355);
        p.h(str, "bizUsername");
        Log.v("MicroMsg.BrandSubscribeStorageManager", "alvinluo getSubscribeMsgListWrapper bizUsername: %s, hashCode: %s", str, Integer.valueOf(hashCode()));
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(biZ());
        try {
            String string = mmkv.getString(str, null);
            if (string == null) {
                AppMethodBeat.o(223355);
                return null;
            }
            a aVar = a.jAG;
            ISubscribeMsgService.Companion.SubscribeMsgListWrapper.a aVar2 = ISubscribeMsgService.Companion.SubscribeMsgListWrapper.CREATOR;
            p.h(string, "data");
            p.h(aVar2, "creator");
            Parcel RB = a.RB(string);
            Object createFromParcel = aVar2.createFromParcel(RB);
            RB.recycle();
            ISubscribeMsgService.Companion.SubscribeMsgListWrapper subscribeMsgListWrapper = (ISubscribeMsgService.Companion.SubscribeMsgListWrapper) createFromParcel;
            e(str, j.v((Collection) subscribeMsgListWrapper.jyV));
            aa(str, subscribeMsgListWrapper.jyW);
            AppMethodBeat.o(223355);
            return subscribeMsgListWrapper;
        } catch (Exception e2) {
            mmkv.putString(str, null);
            AppMethodBeat.o(223355);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ int $scene = 1;
        final /* synthetic */ List jAO;
        final /* synthetic */ boolean jAP;
        final /* synthetic */ String jzO;

        d(String str, List list, boolean z) {
            this.jzO = str;
            this.jAO = list;
            this.jAP = z;
        }

        public final void run() {
            AppMethodBeat.i(223348);
            c.a(c.jAF, this.$scene, this.jzO, this.jAO, this.jAP);
            AppMethodBeat.o(223348);
        }
    }

    @Override // com.tencent.mm.msgsubscription.d.a
    public final void a(String str, List<SubscribeMsgTmpItem> list, boolean z) {
        AppMethodBeat.i(223356);
        p.h(str, "bizUsername");
        p.h(list, "subscribeMsgList");
        h.RTc.b(new d(str, list, z), "SubscribeMsgSaveTag");
        AppMethodBeat.o(223356);
    }

    @Override // com.tencent.mm.msgsubscription.d.a
    public final void b(String str, List<SubscribeMsgTmpItem> list, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(223357);
        p.h(str, "bizUsername");
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = list != null ? Integer.valueOf(list.size()) : null;
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Boolean.valueOf(z2);
        objArr[4] = Boolean.valueOf(z3);
        Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgSubscribeStatus bizUsername: %s, size: %s, switchOpened: %b, needUpdateSwitchOpen: %b, needUpdateTimestamp: %b", objArr);
        a(str, list, z, true, z2, z3);
        AppMethodBeat.o(223357);
    }

    @Override // com.tencent.mm.msgsubscription.d.a
    public final void d(String str, List<SubscribeMsgTmpItem> list) {
        AppMethodBeat.i(223358);
        p.h(str, "bizUsername");
        p.h(list, "subscribeMsgList");
        Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo updateSubscribeMsgUiStatusTimestamp bizUsername: %s, size: %s", str, Integer.valueOf(list.size()));
        a(str, list, false, false, false, true);
        AppMethodBeat.o(223358);
    }

    private final void a(String str, List<SubscribeMsgTmpItem> list, boolean z, boolean z2, boolean z3, boolean z4) {
        List<SubscribeMsgTmpItem> list2;
        boolean z5;
        boolean z6;
        AppMethodBeat.i(223359);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(biZ());
        ISubscribeMsgService.Companion.SubscribeMsgListWrapper RA = RA(str);
        if (RA != null) {
            list2 = RA.jyV;
        } else {
            list2 = null;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (T t : list) {
                boolean z7 = false;
                if (list2 != null) {
                    for (T t2 : list2) {
                        if (t2.ixM.equals(t.ixM)) {
                            if (z2) {
                                t2.jyB = t.jyB;
                            }
                            if (z4) {
                                Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo doSaveSubscribeStatus timestamp: %s", Long.valueOf(t.jyC));
                                t2.jyC = t.jyC;
                            }
                            z6 = true;
                        } else {
                            z6 = z7;
                        }
                        z7 = z6;
                    }
                }
                if (!z7) {
                    arrayList.add(t);
                }
            }
        }
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgUiStatus finalList: %d, switchOpen: %b, needUpateSwitchOpen: %b", Integer.valueOf(arrayList.size()), Boolean.valueOf(z), Boolean.valueOf(z3));
        if (z3) {
            z5 = z;
        } else {
            z5 = RA != null ? RA.jyW : false;
        }
        ISubscribeMsgService.Companion.SubscribeMsgListWrapper subscribeMsgListWrapper = new ISubscribeMsgService.Companion.SubscribeMsgListWrapper(arrayList, z5);
        a aVar = a.jAG;
        mmkv.putString(str, a.e(subscribeMsgListWrapper));
        q(new b(list, str, z2, z4, z3, z));
        AppMethodBeat.o(223359);
    }

    private static void q(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(223360);
        if (MMHandlerThread.isMainThread()) {
            aVar.invoke();
            AppMethodBeat.o(223360);
            return;
        }
        h.RTc.aV(new RunnableC0470c(aVar));
        AppMethodBeat.o(223360);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.msgsubscription.d.c$c  reason: collision with other inner class name */
    public static final class RunnableC0470c implements Runnable {
        final /* synthetic */ kotlin.g.a.a jAN;

        RunnableC0470c(kotlin.g.a.a aVar) {
            this.jAN = aVar;
        }

        public final void run() {
            AppMethodBeat.i(223347);
            this.jAN.invoke();
            AppMethodBeat.o(223347);
        }
    }

    private static void e(String str, List<SubscribeMsgTmpItem> list) {
        AppMethodBeat.i(223361);
        if (MMHandlerThread.isMainThread()) {
            f(str, list);
            AppMethodBeat.o(223361);
            return;
        }
        MMHandlerThread.postToMainThread(new e(str, list));
        AppMethodBeat.o(223361);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ List jAO;
        final /* synthetic */ String jzO;

        e(String str, List list) {
            this.jzO = str;
            this.jAO = list;
        }

        public final void run() {
            AppMethodBeat.i(223349);
            c cVar = c.jAF;
            c.g(this.jzO, this.jAO);
            AppMethodBeat.o(223349);
        }
    }

    private static void f(String str, List<SubscribeMsgTmpItem> list) {
        AppMethodBeat.i(223362);
        for (T t : list) {
            jAD.put(bJ(str, t.ixM), t);
        }
        AppMethodBeat.o(223362);
    }

    private static void aa(String str, boolean z) {
        AppMethodBeat.i(223363);
        Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo updateSwitchOpen: %b", Boolean.valueOf(z));
        jAE.put(str, Boolean.valueOf(z));
        AppMethodBeat.o(223363);
    }

    private static List<SubscribeMsgTmpItem> a(int i2, List<SubscribeMsgTmpItem> list, List<SubscribeMsgTmpItem> list2) {
        AppMethodBeat.i(223364);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (T t : list) {
                boolean z = false;
                for (T t2 : list2) {
                    t2.jyD = i2 == 1;
                    z = t.ixM.equals(t2.ixM) ? true : z;
                }
                if (!z && !t.jyD) {
                    arrayList.add(t);
                }
            }
        }
        arrayList.addAll(list2);
        AppMethodBeat.o(223364);
        return arrayList;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J'\u0010\u0007\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\t\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgStorageManager$ParcelUtil;", "", "()V", "marshall", "", "parcelable", "Landroid/os/Parcelable;", "unmarshall", "Landroid/os/Parcel;", "data", "T", "creator", "Landroid/os/Parcelable$Creator;", "(Ljava/lang/String;Landroid/os/Parcelable$Creator;)Ljava/lang/Object;", "plugin-comm_release"})
    public static final class a {
        public static final a jAG = new a();

        static {
            AppMethodBeat.i(223344);
            AppMethodBeat.o(223344);
        }

        private a() {
        }

        public static String e(Parcelable parcelable) {
            AppMethodBeat.i(223342);
            p.h(parcelable, "parcelable");
            Parcel obtain = Parcel.obtain();
            p.g(obtain, "Parcel.obtain()");
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            String encodeToString = Base64.encodeToString(marshall, 0);
            p.g(encodeToString, "Base64.encodeToString(bytes, Base64.DEFAULT)");
            AppMethodBeat.o(223342);
            return encodeToString;
        }

        public static Parcel RB(String str) {
            AppMethodBeat.i(223343);
            p.h(str, "data");
            byte[] decode = Base64.decode(str, 0);
            Parcel obtain = Parcel.obtain();
            p.g(obtain, "Parcel.obtain()");
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            AppMethodBeat.o(223343);
            return obtain;
        }
    }

    public static final /* synthetic */ void a(c cVar, int i2, String str, List list, boolean z) {
        List<SubscribeMsgTmpItem> list2;
        AppMethodBeat.i(223366);
        Log.i("MicroMsg.BrandSubscribeStorageManager", "alvinluo saveSubscribeMsgList bizUsername: %s, scene: %d, size: %d, isOpened: %b", str, Integer.valueOf(i2), Integer.valueOf(list.size()), Boolean.valueOf(z));
        if (i2 == 1) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((SubscribeMsgTmpItem) it.next()).jyD = true;
            }
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(biZ());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        ISubscribeMsgService.Companion.SubscribeMsgListWrapper RA = cVar.RA(str);
        if (RA != null) {
            list2 = RA.jyV;
        } else {
            list2 = null;
        }
        List<SubscribeMsgTmpItem> a2 = a(i2, list2, arrayList);
        ISubscribeMsgService.Companion.SubscribeMsgListWrapper subscribeMsgListWrapper = new ISubscribeMsgService.Companion.SubscribeMsgListWrapper(a2, z);
        a aVar = a.jAG;
        mmkv.putString(str, a.e(subscribeMsgListWrapper));
        e(str, a2);
        aa(str, z);
        AppMethodBeat.o(223366);
    }

    public static final /* synthetic */ void a(String str, List list, m mVar) {
        AppMethodBeat.i(223367);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SubscribeMsgTmpItem subscribeMsgTmpItem = (SubscribeMsgTmpItem) it.next();
            if (jAD.containsKey(bJ(str, subscribeMsgTmpItem.ixM))) {
                mVar.invoke(jAD.get(bJ(str, subscribeMsgTmpItem.ixM)), subscribeMsgTmpItem);
            } else {
                jAD.put(bJ(str, subscribeMsgTmpItem.ixM), subscribeMsgTmpItem);
                mVar.invoke(jAD.get(bJ(str, subscribeMsgTmpItem.ixM)), subscribeMsgTmpItem);
            }
        }
        AppMethodBeat.o(223367);
    }
}
