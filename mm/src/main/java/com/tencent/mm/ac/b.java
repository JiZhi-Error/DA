package com.tencent.mm.ac;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import junit.framework.AssertionFailedError;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001'B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJB\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dH\u0016J6\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dH\u0016J8\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dH\u0016JB\u0010!\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dH\u0016J8\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dH\u0016JB\u0010#\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dH\u0016J6\u0010$\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dH\u0016J0\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, hxF = {"Lcom/tencent/mm/kt/AssertCat;", "Lcom/tencent/mm/kt/IAssert;", "idkeyArray", "", "", "kv", "", "name", "", "generator", "Lcom/tencent/mm/kt/AssertCat$IdsGenerator;", "([Ljava/lang/Long;ILjava/lang/String;Lcom/tencent/mm/kt/AssertCat$IdsGenerator;)V", "getGenerator", "()Lcom/tencent/mm/kt/AssertCat$IdsGenerator;", "[Ljava/lang/Long;", "getKv", "()I", "getName", "()Ljava/lang/String;", "assertEquals", "", "key", "expected", "", "actual", "isReport", "", "isThrow", "message", "Lkotlin/Function0;", "assertFalse", "condition", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertTrue", "fail", FirebaseAnalytics.b.METHOD, "IdsGenerator", "libktcomm_release"})
public final class b implements f {
    private final Long[] hve;
    private final int hvf = 20889;
    private final a hvg;
    private final String name;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/kt/AssertCat$IdsGenerator;", "", "getId", "", "key", "", "getVersion", "libktcomm_release"})
    public interface a {
        int getId(String str);
    }

    public b(Long[] lArr, String str, a aVar) {
        p.h(lArr, "idkeyArray");
        p.h(str, "name");
        p.h(aVar, "generator");
        AppMethodBeat.i(204374);
        this.hve = lArr;
        this.name = str;
        this.hvg = aVar;
        AppMethodBeat.o(204374);
    }

    @Override // com.tencent.mm.ac.f
    public final void a(String str, boolean z, boolean z2, boolean z3, kotlin.g.a.a<String> aVar) {
        AppMethodBeat.i(204371);
        p.h(str, "key");
        p.h(aVar, "message");
        if (!z) {
            a("assertTrue", str, aVar.invoke(), z2, z3);
        }
        AppMethodBeat.o(204371);
    }

    @Override // com.tencent.mm.ac.f
    public final void b(String str, boolean z, boolean z2, boolean z3, kotlin.g.a.a<String> aVar) {
        AppMethodBeat.i(204372);
        p.h(str, "key");
        p.h(aVar, "message");
        if (z) {
            a("assertFalse", str, aVar.invoke(), z2, z3);
        }
        AppMethodBeat.o(204372);
    }

    private final void a(String str, String str2, String str3, boolean z, boolean z2) {
        AppMethodBeat.i(204373);
        int id = this.hvg.getId(str2);
        int i2 = id / 255;
        if (this.hve.length <= i2) {
            AppMethodBeat.o(204373);
            return;
        }
        long longValue = this.hve[i2].longValue();
        Log.e(this.name, str + ": key=[" + str2 + ':' + id + "] idKey=" + longValue + " message=" + str3);
        if (z) {
            long id2 = (long) this.hvg.getId(str2);
            com.tencent.mm.compatible.d.a aVar = com.tencent.mm.compatible.d.a.INSTANCE;
            com.tencent.mm.compatible.d.a.v(longValue, id2);
            com.tencent.mm.compatible.d.a aVar2 = com.tencent.mm.compatible.d.a.INSTANCE;
            com.tencent.mm.compatible.d.a.b(this.hvf, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, String.valueOf(id2), str3);
        }
        if (z2) {
            Throwable assertionFailedError = new AssertionFailedError(str3);
            AppMethodBeat.o(204373);
            throw assertionFailedError;
        }
        AppMethodBeat.o(204373);
    }
}
