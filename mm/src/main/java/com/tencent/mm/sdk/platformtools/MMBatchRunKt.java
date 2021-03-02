package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CancellationException;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.f;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001aL\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001a\b\u0004\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\b¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"batchRun", "", "T", "data", "delay", "", "key", "", "run", "Lkotlin/Function1;", "", "(Ljava/lang/Object;JLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "libcompatible_release"})
public final class MMBatchRunKt {
    public static /* synthetic */ void batchRun$default(Object obj, long j2, String str, b bVar, int i2, Object obj2) {
        AppMethodBeat.i(215480);
        if ((i2 & 4) != 0) {
            str = MStorageEventData.EventType.BATCH;
        }
        p.h(str, "key");
        p.h(bVar, "run");
        StringBuilder sb = new StringBuilder();
        p.hyd();
        String sb2 = sb.append(Object.class.getCanonicalName()).append('_').append(str).toString();
        synchronized (__BATCH_RUN_OBJ.INSTANCE) {
            try {
                bu buVar = __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(sb2);
                if (buVar != null) {
                    buVar.a((CancellationException) null);
                }
                HashMap<String, Queue<?>> batchData = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
                if (!batchData.containsKey(sb2)) {
                    batchData.put(sb2, new LinkedList());
                }
                Queue<?> queue = batchData.get(sb2);
                if (queue == null) {
                    t tVar = new t("null cannot be cast to non-null type java.util.LinkedList<T>");
                    AppMethodBeat.o(215480);
                    throw tVar;
                }
                ((LinkedList) queue).add(obj);
            } catch (Throwable th) {
                AppMethodBeat.o(215480);
                throw th;
            }
        }
        __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().put(sb2, f.b(bn.TUK, ba.hMW(), new MMBatchRunKt$batchRun$2(j2, sb2, bVar, null), 2));
        AppMethodBeat.o(215480);
    }

    public static final /* synthetic */ <T> void batchRun(T t, long j2, String str, b<? super List<? extends T>, x> bVar) {
        AppMethodBeat.i(215479);
        p.h(str, "key");
        p.h(bVar, "run");
        StringBuilder sb = new StringBuilder();
        p.hyd();
        String sb2 = sb.append(Object.class.getCanonicalName()).append('_').append(str).toString();
        synchronized (__BATCH_RUN_OBJ.INSTANCE) {
            try {
                bu buVar = __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(sb2);
                if (buVar != null) {
                    buVar.a((CancellationException) null);
                }
                HashMap<String, Queue<?>> batchData = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
                if (!batchData.containsKey(sb2)) {
                    batchData.put(sb2, new LinkedList());
                }
                Queue<?> queue = batchData.get(sb2);
                if (queue == null) {
                    t tVar = new t("null cannot be cast to non-null type java.util.LinkedList<T>");
                    AppMethodBeat.o(215479);
                    throw tVar;
                }
                ((LinkedList) queue).add(t);
            } catch (Throwable th) {
                AppMethodBeat.o(215479);
                throw th;
            }
        }
        __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().put(sb2, f.b(bn.TUK, ba.hMW(), new MMBatchRunKt$batchRun$2(j2, sb2, bVar, null), 2));
        AppMethodBeat.o(215479);
    }
}
