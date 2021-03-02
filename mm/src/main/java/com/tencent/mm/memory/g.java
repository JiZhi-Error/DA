package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class g extends a<byte[]> {
    public static final g ity = new g();

    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ void bU(Object obj) {
        AppMethodBeat.i(156419);
        k((byte[]) obj);
        AppMethodBeat.o(156419);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* bridge */ /* synthetic */ long bV(Object obj) {
        return (long) ((byte[]) obj).length;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Integer bW(Object obj) {
        AppMethodBeat.i(156420);
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(156420);
            return 0;
        }
        Integer valueOf = Integer.valueOf(bArr.length);
        AppMethodBeat.o(156420);
        return valueOf;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* bridge */ /* synthetic */ Integer c(Integer num) {
        return num;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ d d(Integer num) {
        AppMethodBeat.i(156421);
        f fVar = new f(num.intValue());
        AppMethodBeat.o(156421);
        return fVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final /* synthetic */ Object e(Integer num) {
        AppMethodBeat.i(156422);
        byte[] bArr = new byte[num.intValue()];
        AppMethodBeat.o(156422);
        return bArr;
    }

    static {
        AppMethodBeat.i(156423);
        AppMethodBeat.o(156423);
    }

    private g() {
    }

    public final synchronized void k(byte[] bArr) {
        AppMethodBeat.i(156418);
        Arrays.fill(bArr, (byte) 0);
        super.bU(bArr);
        AppMethodBeat.o(156418);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final long aRP() {
        return 5242880;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.e
    public final long aRQ() {
        return 1048576;
    }
}
