package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Queue;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.au;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
@f(c = "com.tencent.mm.sdk.platformtools.MMBatchRunKt$batchRun$2", f = "MMBatchRun.kt", hxM = {28}, m = "invokeSuspend")
public final class MMBatchRunKt$batchRun$2 extends j implements m<ai, d<? super x>, Object> {
    final /* synthetic */ long $delay;
    final /* synthetic */ String $key;
    final /* synthetic */ b $run;
    Object L$0;
    int label;
    private ai p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMBatchRunKt$batchRun$2(long j2, String str, b bVar, d dVar) {
        super(2, dVar);
        this.$delay = j2;
        this.$key = str;
        this.$run = bVar;
    }

    @Override // kotlin.d.b.a.a
    public final d<x> create(Object obj, d<?> dVar) {
        AppMethodBeat.i(215477);
        p.h(dVar, "completion");
        MMBatchRunKt$batchRun$2 mMBatchRunKt$batchRun$2 = new MMBatchRunKt$batchRun$2(this.$delay, this.$key, this.$run, dVar);
        mMBatchRunKt$batchRun$2.p$ = (ai) obj;
        AppMethodBeat.o(215477);
        return mMBatchRunKt$batchRun$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.g.a.m
    public final Object invoke(ai aiVar, d<? super x> dVar) {
        AppMethodBeat.i(215478);
        Object invokeSuspend = ((MMBatchRunKt$batchRun$2) create(aiVar, dVar)).invokeSuspend(x.SXb);
        AppMethodBeat.o(215478);
        return invokeSuspend;
    }

    @Override // kotlin.d.b.a.a
    public final Object invokeSuspend(Object obj) {
        ai aiVar;
        ArrayList arrayList;
        AppMethodBeat.i(215476);
        a aVar = a.COROUTINE_SUSPENDED;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                aiVar = this.p$;
                long j2 = this.$delay;
                this.L$0 = aiVar;
                this.label = 1;
                if (au.a(j2, this) == aVar) {
                    AppMethodBeat.o(215476);
                    return aVar;
                }
                break;
            case 1:
                aiVar = (ai) this.L$0;
                ResultKt.throwOnFailure(obj);
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(215476);
                throw illegalStateException;
        }
        if (!aj.a(aiVar)) {
            x xVar = x.SXb;
            AppMethodBeat.o(215476);
            return xVar;
        }
        synchronized (__BATCH_RUN_OBJ.INSTANCE) {
            try {
                Queue<?> queue = __BATCH_RUN_OBJ.INSTANCE.getBatchData().get(this.$key);
                if (!(queue instanceof Queue)) {
                    queue = null;
                }
                Queue<?> queue2 = queue;
                if (queue2 != null) {
                    __BATCH_RUN_OBJ.INSTANCE.getBatchData().remove(this.$key);
                    arrayList = new ArrayList(queue2);
                } else {
                    arrayList = null;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(215476);
                throw th;
            }
        }
        if (arrayList != null) {
            this.$run.invoke(arrayList);
        }
        __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
        x xVar2 = x.SXb;
        AppMethodBeat.o(215476);
        return xVar2;
    }
}
