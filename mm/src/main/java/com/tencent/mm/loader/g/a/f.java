package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eB5\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016R\u000e\u0010\u0010\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "lightWork", "Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;", "parallelTask", "", "name", "", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "retrySg", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "heavyWork", "ioWork", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "TAG", "createHeavyExecutor", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "createIoExecutor", "createLightExecutor", "retryStrategy", "libimageloader_release"})
public final class f implements d {
    private final String TAG;
    private final c ibN;
    private final g ibO;
    private final g ibP;
    private final g ibQ;
    private final int ibR;
    private final String name;

    public f(c cVar, g gVar, g gVar2, g gVar3, int i2, String str) {
        p.h(cVar, "retrySg");
        p.h(gVar, "lightWork");
        p.h(gVar2, "heavyWork");
        p.h(gVar3, "ioWork");
        p.h(str, "name");
        this.ibN = cVar;
        this.ibO = gVar;
        this.ibP = gVar2;
        this.ibQ = gVar3;
        this.ibR = i2;
        this.name = str;
        this.TAG = "MicroMsg.Loader.TaskLoaderConfiguration";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public f(c cVar, g gVar, int i2, String str) {
        this(cVar, gVar, gVar, gVar, i2, str);
        p.h(cVar, "retrySg");
        p.h(gVar, "lightWork");
        p.h(str, "name");
    }

    @Override // com.tencent.mm.loader.g.a.d
    public final a aKe() {
        Log.i(this.TAG, "pool heavy poolSize " + this.ibP.ibS + " priority " + this.ibP.ibS + " name: " + this.name);
        return new b(this.name, this.ibP.ibS, this.ibP.ibS, new com.tencent.mm.loader.i.a());
    }

    @Override // com.tencent.mm.loader.g.a.d
    public final a aKd() {
        Log.i(this.TAG, "pool light poolSize " + this.ibO.ibS + " priority " + this.ibO.ibS + " name: " + this.name);
        return new b(this.name, this.ibO.ibS, this.ibO.ibS, new com.tencent.mm.loader.i.a());
    }

    @Override // com.tencent.mm.loader.g.a.d
    public final int aKf() {
        return this.ibR;
    }

    @Override // com.tencent.mm.loader.g.a.d
    public final String name() {
        return this.name;
    }

    @Override // com.tencent.mm.loader.g.a.d
    public final c aKg() {
        return this.ibN;
    }
}
