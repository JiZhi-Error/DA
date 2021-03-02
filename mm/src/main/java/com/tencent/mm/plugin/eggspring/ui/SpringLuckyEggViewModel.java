package com.tencent.mm.plugin.eggspring.ui;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.t.a.j;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aj;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 82\u00020\u0001:\u00018B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0016\u0010$\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020%J\u0018\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0003H\u0002J\b\u0010+\u001a\u00020,H\u0003J\u0011\u0010-\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020%H\u0014J\u001a\u00100\u001a\u0004\u0018\u00010\u000f2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020%2\u0006\u00106\u001a\u000207H\u0002R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\rR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "Landroid/arch/lifecycle/ViewModel;", "eggName", "", "keyword", "appId", "traceId", "defaultBackgroundColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "acceptEvent", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/eggspring/model/AcceptEvent;", "getAcceptEvent", "()Landroid/arch/lifecycle/MutableLiveData;", "acceptLink", "", "getAcceptLink", "accepted", "", "getAccepted", "backgroundColor", "getBackgroundColor", "bag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getBag", "bottomLink", "getBottomLink", "loading", "getLoading", "material", "Lcom/tencent/mm/eggspring/model/Material;", "getMaterial", "scope", "Lkotlinx/coroutines/CoroutineScope;", "startMills", "", "acceptCoupon", "", "stockId", "acceptEventHandled", "acceptMoney", "materialId", "amount", "loadEgg", "Lkotlinx/coroutines/Job;", "loadMaterial", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "parseLink", "type", "", "info", "Lcom/tencent/mm/eggspring/model/MaterialPageInfo;", "sendAcceptError", "error", "Lcom/tencent/mm/plugin/eggspring/CgiException;", "Companion", "plugin-eggspring_release"})
public final class SpringLuckyEggViewModel extends ViewModel {
    public static final a qWg = new a((byte) 0);
    private String appId;
    private final String dDv;
    String kZe;
    final ai qUR = aj.hMI();
    final MutableLiveData<Boolean> qVW = new MutableLiveData<>();
    final MutableLiveData<com.tencent.mm.plugin.eggspring.c.a> qVX = new MutableLiveData<>();
    final MutableLiveData<String> qVY = new MutableLiveData<>();
    final MutableLiveData<Object> qVZ = new MutableLiveData<>();
    final MutableLiveData<Object> qWa = new MutableLiveData<>();
    final MutableLiveData<j> qWb = new MutableLiveData<>();
    final MutableLiveData<k> qWc = new MutableLiveData<>();
    final MutableLiveData<Boolean> qWd = new MutableLiveData<>();
    private final long qWe = Util.nowMilliSecond();
    private final String qWf;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, hxF = {"loadMaterial", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel", f = "SpringLuckyEggViewModel.kt", hxM = {PlayerException.EXCEPTION_IN_SEEK}, m = "loadMaterial")
    public static final class e extends kotlin.d.b.a.d {
        Object L$0;
        int label;
        final /* synthetic */ SpringLuckyEggViewModel qWh;
        /* synthetic */ Object result;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(SpringLuckyEggViewModel springLuckyEggViewModel, kotlin.d.d dVar) {
            super(dVar);
            this.qWh = springLuckyEggViewModel;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(194637);
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object a2 = this.qWh.a(this);
            AppMethodBeat.o(194637);
            return a2;
        }
    }

    static {
        AppMethodBeat.i(194644);
        AppMethodBeat.o(194644);
    }

    public SpringLuckyEggViewModel(String str, String str2, String str3, String str4, String str5) {
        p.h(str, "eggName");
        p.h(str2, "keyword");
        AppMethodBeat.i(194643);
        this.qWf = str;
        this.dDv = str2;
        this.appId = str3;
        this.kZe = str4;
        this.qVY.setValue(str5);
        this.qVW.setValue(Boolean.TRUE);
        kotlinx.coroutines.f.b(this.qUR, (kotlin.d.f) null, new d(this, null), 3);
        AppMethodBeat.o(194643);
    }

    private static Object a(int i2, com.tencent.mm.t.a.l lVar) {
        switch (i2) {
            case 1:
                return lVar.gTO;
            case 2:
                return lVar.gTP;
            case 3:
                return lVar.gTQ;
            case 4:
            case 5:
                return lVar.gTR;
            default:
                return null;
        }
    }

    @Override // android.arch.lifecycle.ViewModel
    public final void onCleared() {
        AppMethodBeat.i(194641);
        super.onCleared();
        Log.i("MicroMsg.SpringLuckyEggViewModel", "onCleared()");
        aj.b(this.qUR);
        AppMethodBeat.o(194641);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel$Companion;", "", "()V", "LOAD_MATERIAL_TIMEOUT", "", "TAG", "", "plugin-eggspring_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel$loadEgg$1", f = "SpringLuckyEggViewModel.kt", hxM = {TPCodecParamers.TP_PROFILE_H264_MAIN, 90}, m = "invokeSuspend")
    public static final class d extends kotlin.d.b.a.j implements m<ai, kotlin.d.d<? super x>, Object> {
        Object L$0;
        int label;
        private ai p$;
        Object pED;
        final /* synthetic */ SpringLuckyEggViewModel qWh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(SpringLuckyEggViewModel springLuckyEggViewModel, kotlin.d.d dVar) {
            super(2, dVar);
            this.qWh = springLuckyEggViewModel;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(194635);
            p.h(dVar, "completion");
            d dVar2 = new d(this.qWh, dVar);
            dVar2.p$ = (ai) obj;
            AppMethodBeat.o(194635);
            return dVar2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(194636);
            Object invokeSuspend = ((d) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(194636);
            return invokeSuspend;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/modelpackage/EggInfo;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
        @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel$loadEgg$1$egg$1", f = "SpringLuckyEggViewModel.kt", hxM = {}, m = "invokeSuspend")
        public static final class a extends kotlin.d.b.a.j implements m<ai, kotlin.d.d<? super com.tencent.mm.bb.e>, Object> {
            int label;
            private ai p$;
            final /* synthetic */ d qWm;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, kotlin.d.d dVar2) {
                super(2, dVar2);
                this.qWm = dVar;
            }

            @Override // kotlin.d.b.a.a
            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                AppMethodBeat.i(194632);
                p.h(dVar, "completion");
                a aVar = new a(this.qWm, dVar);
                aVar.p$ = (ai) obj;
                AppMethodBeat.o(194632);
                return aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final Object invoke(ai aiVar, kotlin.d.d<? super com.tencent.mm.bb.e> dVar) {
                AppMethodBeat.i(194633);
                Object invokeSuspend = ((a) create(aiVar, dVar)).invokeSuspend(x.SXb);
                AppMethodBeat.o(194633);
                return invokeSuspend;
            }

            /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab A[SYNTHETIC] */
            @Override // kotlin.d.b.a.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                // Method dump skipped, instructions count: 190
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel.d.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0071  */
        @Override // kotlin.d.b.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
            // Method dump skipped, instructions count: 182
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel$acceptCoupon$1", f = "SpringLuckyEggViewModel.kt", hxM = {160}, m = "invokeSuspend")
    public static final class b extends kotlin.d.b.a.j implements m<ai, kotlin.d.d<? super x>, Object> {
        Object L$0;
        final /* synthetic */ String kPQ;
        int label;
        private ai p$;
        final /* synthetic */ SpringLuckyEggViewModel qWh;
        final /* synthetic */ String qWi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(SpringLuckyEggViewModel springLuckyEggViewModel, String str, String str2, kotlin.d.d dVar) {
            super(2, dVar);
            this.qWh = springLuckyEggViewModel;
            this.kPQ = str;
            this.qWi = str2;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(194626);
            p.h(dVar, "completion");
            b bVar = new b(this.qWh, this.kPQ, this.qWi, dVar);
            bVar.p$ = (ai) obj;
            AppMethodBeat.o(194626);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(194627);
            Object invokeSuspend = ((b) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(194627);
            return invokeSuspend;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x008e  */
        @Override // kotlin.d.b.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
            // Method dump skipped, instructions count: 196
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel$acceptMoney$1", f = "SpringLuckyEggViewModel.kt", hxM = {TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE, com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX}, m = "invokeSuspend")
    public static final class c extends kotlin.d.b.a.j implements m<ai, kotlin.d.d<? super x>, Object> {
        Object L$0;
        int label;
        private ai p$;
        final /* synthetic */ SpringLuckyEggViewModel qWh;
        long qWj;
        final /* synthetic */ long qWk;
        final /* synthetic */ String qWl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(SpringLuckyEggViewModel springLuckyEggViewModel, long j2, String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.qWh = springLuckyEggViewModel;
            this.qWk = j2;
            this.qWl = str;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(194629);
            p.h(dVar, "completion");
            c cVar = new c(this.qWh, this.qWk, this.qWl, dVar);
            cVar.p$ = (ai) obj;
            AppMethodBeat.o(194629);
            return cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(194630);
            Object invokeSuspend = ((c) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(194630);
            return invokeSuspend;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x00aa  */
        @Override // kotlin.d.b.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
            // Method dump skipped, instructions count: 312
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetInteractionMaterialResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel$loadMaterial$resp$1", f = "SpringLuckyEggViewModel.kt", hxM = {PlayerException.EXCEPTION_IN_SETAUDIOEFFECT}, m = "invokeSuspend")
    public static final class f extends kotlin.d.b.a.j implements m<ai, kotlin.d.d<? super com.tencent.mm.t.a.f>, Object> {
        Object L$0;
        int label;
        private ai p$;
        final /* synthetic */ SpringLuckyEggViewModel qWh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(SpringLuckyEggViewModel springLuckyEggViewModel, kotlin.d.d dVar) {
            super(2, dVar);
            this.qWh = springLuckyEggViewModel;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(194639);
            p.h(dVar, "completion");
            f fVar = new f(this.qWh, dVar);
            fVar.p$ = (ai) obj;
            AppMethodBeat.o(194639);
            return fVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super com.tencent.mm.t.a.f> dVar) {
            AppMethodBeat.i(194640);
            Object invokeSuspend = ((f) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(194640);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(194638);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = this.p$;
                    this.label = 1;
                    obj = com.tencent.mm.plugin.eggspring.b.a(new com.tencent.mm.plugin.eggspring.b.c(this.qWh.dDv, "", ""), this);
                    if (obj == aVar) {
                        AppMethodBeat.o(194638);
                        return aVar;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(194638);
                    throw illegalStateException;
            }
            AppMethodBeat.o(194638);
            return obj;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object a(kotlin.d.d<? super kotlin.x> r12) {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel.a(kotlin.d.d):java.lang.Object");
    }

    public static final /* synthetic */ void a(SpringLuckyEggViewModel springLuckyEggViewModel, com.tencent.mm.plugin.eggspring.a aVar) {
        AppMethodBeat.i(194645);
        if (aVar.errorCode > 0) {
            springLuckyEggViewModel.qVX.postValue(com.tencent.mm.plugin.eggspring.c.a.Denied);
            AppMethodBeat.o(194645);
            return;
        }
        springLuckyEggViewModel.qVX.postValue(com.tencent.mm.plugin.eggspring.c.a.qUZ);
        AppMethodBeat.o(194645);
    }
}
