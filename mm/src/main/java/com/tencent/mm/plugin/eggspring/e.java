package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.t.a.r;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.j.c;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cs;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.f;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\fJ\u0006\u0010\u001a\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000RL\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/EggRedEnvelopeHelper;", "", "()V", "TAG", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "showEgg", "url", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "interval", "", "lastCheckJob", "Lkotlinx/coroutines/Job;", "lastCheckTime", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "checkShowEgg", "dispose", "plugin-eggspring_release"})
public final class e {
    public final String TAG = "MicroMsg.EggRedEnvelopeHelper";
    int gTn;
    public m<? super Boolean, ? super String, x> gWp;
    private long lastCheckTime;
    private ai qUR = aj.hMI();
    public bu qUS;

    public e() {
        AppMethodBeat.i(259481);
        AppMethodBeat.o(259481);
    }

    public final void dhS() {
        AppMethodBeat.i(259480);
        Log.i(this.TAG, "checkShowEgg: ");
        long currentTicks = Util.currentTicks();
        if (Util.ticksToNow(this.lastCheckTime) <= ((long) this.gTn)) {
            Log.w(this.TAG, "checkShowEgg: " + this.lastCheckTime + ", " + this.gTn + ", " + currentTicks);
            AppMethodBeat.o(259480);
            return;
        }
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_egg_red_envelope_percent, 100);
        c.b bVar = c.SYP;
        int nextInt = c.SYN.nextInt(100);
        Log.i(this.TAG, "checkShowEgg: percent " + a2 + ", " + nextInt);
        if (nextInt >= a2) {
            AppMethodBeat.o(259480);
            return;
        }
        this.lastCheckTime = currentTicks;
        bu buVar = this.qUS;
        if (buVar != null) {
            buVar.a((CancellationException) null);
        }
        this.qUS = f.b(this.qUR, (kotlin.d.f) null, new a(this, null), 3);
        AppMethodBeat.o(259480);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.eggspring.EggRedEnvelopeHelper$checkShowEgg$1", f = "EggRedEnvelopeHelper.kt", hxM = {49}, m = "invokeSuspend")
    static final class a extends j implements m<ai, d<? super x>, Object> {
        final /* synthetic */ e JRT;
        Object L$0;
        int label;
        private ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar, d dVar) {
            super(2, dVar);
            this.JRT = eVar;
        }

        @Override // kotlin.d.b.a.a
        public final d<x> create(Object obj, d<?> dVar) {
            AppMethodBeat.i(259478);
            p.h(dVar, "completion");
            a aVar = new a(this.JRT, dVar);
            aVar.p$ = (ai) obj;
            AppMethodBeat.o(259478);
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, d<? super x> dVar) {
            AppMethodBeat.i(259479);
            Object invokeSuspend = ((a) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(259479);
            return invokeSuspend;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetRedpacketCoverRecvEntranceResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
        @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.eggspring.EggRedEnvelopeHelper$checkShowEgg$1$resp$1", f = "EggRedEnvelopeHelper.kt", hxM = {50}, m = "invokeSuspend")
        /* renamed from: com.tencent.mm.plugin.eggspring.e$a$a  reason: collision with other inner class name */
        public static final class C0954a extends j implements m<ai, d<? super r>, Object> {
            Object L$0;
            int label;
            private ai p$;

            C0954a(d dVar) {
                super(2, dVar);
            }

            @Override // kotlin.d.b.a.a
            public final d<x> create(Object obj, d<?> dVar) {
                AppMethodBeat.i(259475);
                p.h(dVar, "completion");
                C0954a aVar = new C0954a(dVar);
                aVar.p$ = (ai) obj;
                AppMethodBeat.o(259475);
                return aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final Object invoke(ai aiVar, d<? super r> dVar) {
                AppMethodBeat.i(259476);
                Object invokeSuspend = ((C0954a) create(aiVar, dVar)).invokeSuspend(x.SXb);
                AppMethodBeat.o(259476);
                return invokeSuspend;
            }

            @Override // kotlin.d.b.a.a
            public final Object invokeSuspend(Object obj) {
                AppMethodBeat.i(259474);
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = this.p$;
                        this.label = 1;
                        obj = b.a(new com.tencent.mm.plugin.eggspring.b.e(), this);
                        if (obj == aVar) {
                            AppMethodBeat.o(259474);
                            return aVar;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        AppMethodBeat.o(259474);
                        throw illegalStateException;
                }
                AppMethodBeat.o(259474);
                return obj;
            }
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            r rVar;
            m<? super Boolean, ? super String, x> mVar;
            AppMethodBeat.i(259477);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    try {
                        this.L$0 = this.p$;
                        this.label = 1;
                        obj2 = cu.a(10000, new C0954a(null), this);
                        if (obj2 == aVar) {
                            AppMethodBeat.o(259477);
                            return aVar;
                        }
                        rVar = (r) obj2;
                        this.JRT.gTn = rVar.uAE * 1000;
                        Log.i(this.JRT.TAG, "checkShowEgg: " + rVar.uAC + ", " + rVar.uAD + ", " + rVar.uAE);
                        if (!(!rVar.uAC || rVar.uAD == null || (mVar = this.JRT.gWp) == null)) {
                            Boolean bool = Boolean.TRUE;
                            String str = rVar.uAD;
                            p.g(str, "resp.entrance_url");
                            mVar.invoke(bool, str);
                            break;
                        }
                    } catch (a e2) {
                        Log.w(this.JRT.TAG, "Cgi error: " + e2.getMessage());
                        break;
                    } catch (cs e3) {
                        Log.w(this.JRT.TAG, "Cgi Timeout: ");
                        break;
                    }
                case 1:
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    rVar = (r) obj2;
                    this.JRT.gTn = rVar.uAE * 1000;
                    Log.i(this.JRT.TAG, "checkShowEgg: " + rVar.uAC + ", " + rVar.uAD + ", " + rVar.uAE);
                    Boolean bool2 = Boolean.TRUE;
                    String str2 = rVar.uAD;
                    p.g(str2, "resp.entrance_url");
                    mVar.invoke(bool2, str2);
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(259477);
                    throw illegalStateException;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(259477);
            return xVar;
        }
    }
}
