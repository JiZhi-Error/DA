package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Queue;
import kotlin.l;
import kotlinx.coroutines.bu;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R5\u0010\u0003\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004j\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, hxF = {"Lcom/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ;", "", "()V", "batchData", "Ljava/util/HashMap;", "", "Ljava/util/Queue;", "Lkotlin/collections/HashMap;", "getBatchData", "()Ljava/util/HashMap;", "batchJobs", "Lkotlinx/coroutines/Job;", "getBatchJobs", "libcompatible_release"})
public final class __BATCH_RUN_OBJ {
    public static final __BATCH_RUN_OBJ INSTANCE = new __BATCH_RUN_OBJ();
    private static final HashMap<String, Queue<?>> batchData = new HashMap<>();
    private static final HashMap<String, bu> batchJobs = new HashMap<>();

    static {
        AppMethodBeat.i(156399);
        AppMethodBeat.o(156399);
    }

    private __BATCH_RUN_OBJ() {
    }

    public final HashMap<String, bu> getBatchJobs() {
        return batchJobs;
    }

    public final HashMap<String, Queue<?>> getBatchData() {
        return batchData;
    }
}
