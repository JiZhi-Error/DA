package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CancellationException;
import kotlin.g.b.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.f;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0016\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0006H\u0002R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/vfs/VFSFile;", "name", "", "slotSeconds", "", "(Ljava/lang/String;J)V", "CLEAR_DELAY", "TAG", "prefix", "getPrefix", "()Ljava/lang/String;", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "getSlotPath", "libcompatible_release"})
public final class MMFileSlotManager extends BaseSlotManager<o> {
    private final long CLEAR_DELAY;
    private final String TAG;
    private final String prefix;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMFileSlotManager(String str, long j2) {
        super(j2, 0, 2, null);
        p.h(str, "name");
        AppMethodBeat.i(156390);
        this.TAG = "MMFileSlotManager";
        this.CLEAR_DELAY = 1000;
        this.prefix = str + '/' + j2 + '/';
        AppMethodBeat.o(156390);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MMFileSlotManager(String str, long j2, int i2, j jVar) {
        this(str, (i2 & 2) != 0 ? 900 : j2);
        AppMethodBeat.i(215489);
        AppMethodBeat.o(215489);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public final /* bridge */ /* synthetic */ void clearSlot(long j2, o oVar) {
        AppMethodBeat.i(156385);
        clearSlot(j2, oVar);
        AppMethodBeat.o(156385);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.String] */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public final /* bridge */ /* synthetic */ boolean containsKey(o oVar, String str) {
        AppMethodBeat.i(156389);
        boolean containsKey = containsKey(oVar, str);
        AppMethodBeat.o(156389);
        return containsKey;
    }

    static /* synthetic */ String getSlotPath$default(MMFileSlotManager mMFileSlotManager, String str, long j2, int i2, Object obj) {
        AppMethodBeat.i(215485);
        if ((i2 & 1) != 0) {
            j2 = -1;
        }
        String slotPath = mMFileSlotManager.getSlotPath(str, j2);
        AppMethodBeat.o(215485);
        return slotPath;
    }

    private final String getSlotPath(String str, long j2) {
        AppMethodBeat.i(156384);
        String str2 = b.aKB() + "mmslot/" + str + '/' + (j2 > 0 ? new StringBuilder().append(j2).append('/').toString() : "");
        AppMethodBeat.o(156384);
        return str2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public final String getPrefix() {
        return this.prefix;
    }

    /* access modifiers changed from: protected */
    public final void clearSlot(long j2, o oVar) {
        ArrayList arrayList;
        AppMethodBeat.i(215486);
        p.h(oVar, "slot");
        Log.v(this.TAG, "clearSlot");
        String[] a2 = oVar.a(new MMFileSlotManager$clearSlot$1(j2));
        if (a2 != null) {
            ArrayList arrayList2 = new ArrayList(a2.length);
            int length = a2.length;
            for (int i2 = 0; i2 < length; i2++) {
                arrayList2.add(oVar.getPath() + '/' + a2[i2]);
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        long j3 = this.CLEAR_DELAY;
        String str = List.class.getCanonicalName() + '_' + MStorageEventData.EventType.BATCH;
        synchronized (__BATCH_RUN_OBJ.INSTANCE) {
            try {
                bu buVar = __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(str);
                if (buVar != null) {
                    buVar.a((CancellationException) null);
                }
                HashMap<String, Queue<?>> batchData = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
                if (!batchData.containsKey(str)) {
                    batchData.put(str, new LinkedList());
                }
                Queue<?> queue = batchData.get(str);
                if (queue == null) {
                    t tVar = new t("null cannot be cast to non-null type java.util.LinkedList<T>");
                    AppMethodBeat.o(215486);
                    throw tVar;
                }
                ((LinkedList) queue).add(arrayList);
            } catch (Throwable th) {
                AppMethodBeat.o(215486);
                throw th;
            }
        }
        __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().put(str, f.b(bn.TUK, ba.hMW(), new MMFileSlotManager$clearSlot$$inlined$also$lambda$1(j3, str, null, this), 2));
        AppMethodBeat.o(215486);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public final o getSlotByKey(String str, long j2) {
        AppMethodBeat.i(215487);
        p.h(str, "slotKey");
        o oVar = new o(getSlotPath(str, j2));
        Log.v(this.TAG, "getSlotByKey path = " + oVar.getPath());
        if (!oVar.exists()) {
            oVar.mkdirs();
            Log.v(this.TAG, "getSlotByKey mkdirs = ".concat(String.valueOf(oVar)));
        }
        AppMethodBeat.o(215487);
        return oVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public final void remarkSlot(String str, long j2) {
        AppMethodBeat.i(156387);
        p.h(str, "slotKey");
        AppMethodBeat.o(156387);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public final boolean verifySlot(String str, long j2) {
        AppMethodBeat.i(156388);
        p.h(str, "slotKey");
        o oVar = new o(getSlotPath(str, j2));
        if (!oVar.exists() || oVar.length() <= 0) {
            AppMethodBeat.o(156388);
            return false;
        }
        AppMethodBeat.o(156388);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean containsKey(o oVar, String str) {
        AppMethodBeat.i(215488);
        p.h(oVar, "slot");
        p.h(str, "key");
        o oVar2 = new o(oVar.getPath() + '/' + str);
        if (!oVar2.exists() || oVar2.length() <= 0) {
            AppMethodBeat.o(215488);
            return false;
        }
        AppMethodBeat.o(215488);
        return true;
    }
}
