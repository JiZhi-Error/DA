package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import kotlin.g.b.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0014J$\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\b¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\n \u0014*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0005H\u0014J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0005H\u0014J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0005H\u0014R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "slotRecorder", "slotSeconds", "", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;J)V", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "", "decodeProtoBuffer", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getSlotByKey", "kotlin.jvm.PlatformType", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"})
public class MMKVSlotManager extends BaseSlotManager<MultiProcessMMKV> {
    private final MultiProcessMMKV slotRecorder;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MMKVSlotManager(MultiProcessMMKV multiProcessMMKV, long j2, int i2, j jVar) {
        this(multiProcessMMKV, (i2 & 2) != 0 ? 900 : j2);
        AppMethodBeat.i(215494);
        AppMethodBeat.o(215494);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public /* bridge */ /* synthetic */ void clearSlot(long j2, MultiProcessMMKV multiProcessMMKV) {
        AppMethodBeat.i(156391);
        clearSlot(j2, multiProcessMMKV);
        AppMethodBeat.o(156391);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.String] */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public /* bridge */ /* synthetic */ boolean containsKey(MultiProcessMMKV multiProcessMMKV, String str) {
        AppMethodBeat.i(156395);
        boolean containsKey = containsKey(multiProcessMMKV, str);
        AppMethodBeat.o(156395);
        return containsKey;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMKVSlotManager(MultiProcessMMKV multiProcessMMKV, long j2) {
        super(j2, 0, 2, null);
        p.h(multiProcessMMKV, "slotRecorder");
        AppMethodBeat.i(156396);
        this.slotRecorder = multiProcessMMKV;
        AppMethodBeat.o(156396);
    }

    /* access modifiers changed from: protected */
    public void clearSlot(long j2, MultiProcessMMKV multiProcessMMKV) {
        AppMethodBeat.i(215490);
        p.h(multiProcessMMKV, "slot");
        if (multiProcessMMKV.count() > 0) {
            multiProcessMMKV.clear();
        }
        AppMethodBeat.o(215490);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public void remarkSlot(String str, long j2) {
        AppMethodBeat.i(156392);
        p.h(str, "slotKey");
        this.slotRecorder.putLong(str, j2);
        AppMethodBeat.o(156392);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public boolean verifySlot(String str, long j2) {
        AppMethodBeat.i(156393);
        p.h(str, "slotKey");
        if (this.slotRecorder.getLong(str, 0) == j2) {
            AppMethodBeat.o(156393);
            return true;
        }
        AppMethodBeat.o(156393);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdk.platformtools.BaseSlotManager
    public MultiProcessMMKV getSlotByKey(String str, long j2) {
        AppMethodBeat.i(215491);
        p.h(str, "slotKey");
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(str, 2);
        AppMethodBeat.o(215491);
        return mmkv;
    }

    /* access modifiers changed from: protected */
    public boolean containsKey(MultiProcessMMKV multiProcessMMKV, String str) {
        AppMethodBeat.i(215492);
        p.h(multiProcessMMKV, "slot");
        p.h(str, "key");
        boolean containsKey = multiProcessMMKV.containsKey(str);
        AppMethodBeat.o(215492);
        return containsKey;
    }

    public final /* synthetic */ <T extends a> T decodeProtoBuffer(String str) {
        byte[] decodeBytes;
        AppMethodBeat.i(215493);
        p.h(str, "key");
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) findSlot(str);
        if (multiProcessMMKV != null) {
            if (multiProcessMMKV.containsKey(str) && (decodeBytes = multiProcessMMKV.decodeBytes(str)) != null) {
                if (!(decodeBytes.length == 0)) {
                    try {
                        p.hyd();
                        Object newInstance = a.class.newInstance();
                        ((a) newInstance).parseFrom(decodeBytes);
                        T t = (T) ((a) newInstance);
                        AppMethodBeat.o(215493);
                        return t;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                    }
                }
            }
            AppMethodBeat.o(215493);
            return null;
        }
        AppMethodBeat.o(215493);
        return null;
    }
}
