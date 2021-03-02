package com.tencent.mm.plugin.eggspring;

import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.eggspring.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cs;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.f;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/SpringLuckyEggHelper;", "", "()V", "interval", "", "lastCheckJob", "Lkotlinx/coroutines/Job;", "lastCheckTime", "", "playCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "", "getPlayCallback", "()Lkotlin/jvm/functions/Function1;", "setPlayCallback", "(Lkotlin/jvm/functions/Function1;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "checkCanShowEgg", "appId", "", "keyword", "dispose", "Companion", "plugin-eggspring_release"})
public final class d {
    public static final a qUU = new a((byte) 0);
    private int gTn;
    private long lastCheckTime;
    private ai qUR = aj.hMI();
    public bu qUS;
    public kotlin.g.a.b<? super c, x> qUT;

    static {
        AppMethodBeat.i(194563);
        AppMethodBeat.o(194563);
    }

    public d() {
        AppMethodBeat.i(194562);
        AppMethodBeat.o(194562);
    }

    public final void fM(String str, String str2) {
        AppMethodBeat.i(194561);
        p.h(str2, "keyword");
        Log.i("MicroMsg.SpringLuckyEggHelper", "start check egg: appId=" + str + ", keyword=" + str2);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.lastCheckTime > 0 && this.gTn > 0) {
            long j2 = elapsedRealtime - this.lastCheckTime;
            if (j2 < ((long) (this.gTn * 1000))) {
                Log.w("MicroMsg.SpringLuckyEggHelper", "The check is too frequent, interval=" + this.gTn + ", delta=" + j2);
                AppMethodBeat.o(194561);
                return;
            }
        }
        this.lastCheckTime = elapsedRealtime;
        bu buVar = this.qUS;
        if (buVar != null) {
            buVar.a((CancellationException) null);
        }
        this.qUS = f.b(this.qUR, (kotlin.d.f) null, new b(this, str2, str, null), 3);
        AppMethodBeat.o(194561);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/SpringLuckyEggHelper$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.eggspring.SpringLuckyEggHelper$checkCanShowEgg$1", f = "SpringLuckyEggHelper.kt", hxM = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR}, m = "invokeSuspend")
    public static final class b extends j implements m<ai, kotlin.d.d<? super x>, Object> {
        Object L$0;
        final /* synthetic */ String kPQ;
        int label;
        private ai p$;
        final /* synthetic */ d qUV;
        final /* synthetic */ String qUW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, String str, String str2, kotlin.d.d dVar2) {
            super(2, dVar2);
            this.qUV = dVar;
            this.qUW = str;
            this.kPQ = str2;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(194559);
            p.h(dVar, "completion");
            b bVar = new b(this.qUV, this.qUW, this.kPQ, dVar);
            bVar.p$ = (ai) obj;
            AppMethodBeat.o(194559);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(194560);
            Object invokeSuspend = ((b) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(194560);
            return invokeSuspend;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetInteractionADResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
        @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.eggspring.SpringLuckyEggHelper$checkCanShowEgg$1$resp$1", f = "SpringLuckyEggHelper.kt", hxM = {42}, m = "invokeSuspend")
        public static final class a extends j implements m<ai, kotlin.d.d<? super com.tencent.mm.t.a.d>, Object> {
            Object L$0;
            int label;
            private ai p$;
            final /* synthetic */ b qUX;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, kotlin.d.d dVar) {
                super(2, dVar);
                this.qUX = bVar;
            }

            @Override // kotlin.d.b.a.a
            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                AppMethodBeat.i(194556);
                p.h(dVar, "completion");
                a aVar = new a(this.qUX, dVar);
                aVar.p$ = (ai) obj;
                AppMethodBeat.o(194556);
                return aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final Object invoke(ai aiVar, kotlin.d.d<? super com.tencent.mm.t.a.d> dVar) {
                AppMethodBeat.i(194557);
                Object invokeSuspend = ((a) create(aiVar, dVar)).invokeSuspend(x.SXb);
                AppMethodBeat.o(194557);
                return invokeSuspend;
            }

            @Override // kotlin.d.b.a.a
            public final Object invokeSuspend(Object obj) {
                AppMethodBeat.i(194555);
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = this.p$;
                        this.label = 1;
                        obj = b.a(new com.tencent.mm.plugin.eggspring.b.b(this.qUX.qUW, ""), this);
                        if (obj == aVar) {
                            AppMethodBeat.o(194555);
                            return aVar;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        AppMethodBeat.o(194555);
                        throw illegalStateException;
                }
                AppMethodBeat.o(194555);
                return obj;
            }
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            kotlin.g.a.b<? super c, x> bVar;
            AppMethodBeat.i(194558);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    try {
                        this.L$0 = this.p$;
                        this.label = 1;
                        obj2 = cu.a(10000, new a(this, null), this);
                        if (obj2 == aVar) {
                            AppMethodBeat.o(194558);
                            return aVar;
                        }
                    } catch (a e2) {
                        Log.w("MicroMsg.SpringLuckyEggHelper", "Unable to check if we can show lucky egg: " + e2.getMessage());
                        x xVar = x.SXb;
                        this.qUV.qUT = null;
                        AppMethodBeat.o(194558);
                        return xVar;
                    } catch (cs e3) {
                        Log.w("MicroMsg.SpringLuckyEggHelper", "Timeout to check can show luck egg");
                        x xVar2 = x.SXb;
                        this.qUV.qUT = null;
                        AppMethodBeat.o(194558);
                        return xVar2;
                    } catch (Throwable th) {
                        this.qUV.qUT = null;
                        AppMethodBeat.o(194558);
                        throw th;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(194558);
                    throw illegalStateException;
            }
            com.tencent.mm.t.a.d dVar = (com.tencent.mm.t.a.d) obj2;
            this.qUV.gTn = dVar.gTn;
            Log.i("MicroMsg.SpringLuckyEggHelper", "should play lucky egg:" + dVar.gTm + " interval=" + this.qUV.gTn + ", traceId=" + dVar.gTl);
            if (dVar.gTm == 1 && (bVar = this.qUV.qUT) != null) {
                bVar.invoke(new c(this.qUW, dVar.gTl, this.kPQ, true, dVar.gTn, 32));
            }
            this.qUV.qUT = null;
            x xVar3 = x.SXb;
            AppMethodBeat.o(194558);
            return xVar3;
        }
    }
}
