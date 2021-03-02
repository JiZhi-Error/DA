package com.tencent.mm.sdk.platformtools;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import kotlin.ResultKt;
import kotlin.d.a.a;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2", "com/tencent/mm/sdk/platformtools/MMFileSlotManager$$special$$inlined$batchRun$1"})
public final class MMFileSlotManager$clearSlot$$inlined$also$lambda$1 extends j implements m<ai, d<? super x>, Object> {
    final /* synthetic */ long $delay;
    final /* synthetic */ String $key;
    Object L$0;
    int label;
    private ai p$;
    final /* synthetic */ MMFileSlotManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMFileSlotManager$clearSlot$$inlined$also$lambda$1(long j2, String str, d dVar, MMFileSlotManager mMFileSlotManager) {
        super(2, dVar);
        this.$delay = j2;
        this.$key = str;
        this.this$0 = mMFileSlotManager;
    }

    @Override // kotlin.d.b.a.a
    public final d<x> create(Object obj, d<?> dVar) {
        AppMethodBeat.i(175892);
        p.h(dVar, "completion");
        MMFileSlotManager$clearSlot$$inlined$also$lambda$1 mMFileSlotManager$clearSlot$$inlined$also$lambda$1 = new MMFileSlotManager$clearSlot$$inlined$also$lambda$1(this.$delay, this.$key, dVar, this.this$0);
        mMFileSlotManager$clearSlot$$inlined$also$lambda$1.p$ = (ai) obj;
        AppMethodBeat.o(175892);
        return mMFileSlotManager$clearSlot$$inlined$also$lambda$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.g.a.m
    public final Object invoke(ai aiVar, d<? super x> dVar) {
        AppMethodBeat.i(175893);
        Object invokeSuspend = ((MMFileSlotManager$clearSlot$$inlined$also$lambda$1) create(aiVar, dVar)).invokeSuspend(x.SXb);
        AppMethodBeat.o(175893);
        return invokeSuspend;
    }

    @Override // kotlin.d.b.a.a
    public final Object invokeSuspend(Object obj) {
        ai aiVar;
        ArrayList<List> arrayList;
        AppMethodBeat.i(175891);
        a aVar = a.COROUTINE_SUSPENDED;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                aiVar = this.p$;
                long j2 = this.$delay;
                this.L$0 = aiVar;
                this.label = 1;
                if (au.a(j2, this) == aVar) {
                    AppMethodBeat.o(175891);
                    return aVar;
                }
                break;
            case 1:
                aiVar = (ai) this.L$0;
                ResultKt.throwOnFailure(obj);
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(175891);
                throw illegalStateException;
        }
        if (!aj.a(aiVar)) {
            x xVar = x.SXb;
            AppMethodBeat.o(175891);
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
                AppMethodBeat.o(175891);
                throw th;
            }
        }
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            for (List list : arrayList) {
                if (list == null) {
                    p.hyc();
                }
                kotlin.a.j.a((Collection) arrayList2, (Iterable) list);
            }
            final ArrayList arrayList3 = arrayList2;
            if (!arrayList3.isEmpty()) {
                Log.i(this.this$0.TAG, "clear file slots:\n" + kotlin.a.j.a(arrayList3, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62));
                h.RTc.aY(new Runnable() {
                    /* class com.tencent.mm.sdk.platformtools.MMFileSlotManager$clearSlot$$inlined$also$lambda$1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(175890);
                        for (String str : arrayList3) {
                            s.deleteDir(str);
                        }
                        AppMethodBeat.o(175890);
                    }
                });
            }
        }
        __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
        x xVar2 = x.SXb;
        AppMethodBeat.o(175891);
        return xVar2;
    }
}
