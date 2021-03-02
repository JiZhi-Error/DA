package com.tencent.mm.plugin.appbrand.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/storage/StorageUtils;", "", "()V", "runInTransaction", "T", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "block", "Lkotlin/Function0;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "plugin-appbrand-integration_release"})
public final class d {
    public static final d nOm = new d();

    static {
        AppMethodBeat.i(229365);
        AppMethodBeat.o(229365);
    }

    private d() {
    }

    public static /* synthetic */ <T> T a(ISQLiteDatabase iSQLiteDatabase, a<? extends T> aVar) {
        AppMethodBeat.i(229364);
        p.h(iSQLiteDatabase, "$this$runInTransaction");
        p.h(aVar, "block");
        if (iSQLiteDatabase instanceof ISQLiteDatabaseEx) {
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            long beginTransaction = ((ISQLiteDatabaseEx) iSQLiteDatabase).beginTransaction(currentThread.getId());
            T t = (T) aVar.invoke();
            ((ISQLiteDatabaseEx) iSQLiteDatabase).endTransaction(beginTransaction);
            AppMethodBeat.o(229364);
            return t;
        }
        T t2 = (T) aVar.invoke();
        AppMethodBeat.o(229364);
        return t2;
    }
}
