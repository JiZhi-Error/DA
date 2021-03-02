package com.tencent.mm.loader.g;

import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/loader/loader/SingleTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "task", "Lkotlin/Function1;", "", "id", "", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTask", "()Lkotlin/jvm/functions/Function1;", "token", "", "getToken", "()I", "setToken", "(I)V", "call", "toString", "uniqueId", "libimageloader_release"})
public final class h extends c {
    private final b<h, x> ibm;
    private final String id;
    public int token;

    public /* synthetic */ h(b bVar) {
        this(bVar, new StringBuilder().append(System.nanoTime()).append('}').toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.g.a.b<? super com.tencent.mm.loader.g.h, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    private h(b<? super h, x> bVar, String str) {
        p.h(bVar, "task");
        p.h(str, "id");
        this.ibm = bVar;
        this.id = str;
        this.token = -1;
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        this.ibm.invoke(this);
    }

    public final String toString() {
        return "{token=" + this.token + " id=" + this.id + '}';
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        return this.id;
    }
}
