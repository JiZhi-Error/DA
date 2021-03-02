package com.tencent.mm.plugin.finder.shell;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/shell/FinderShell;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "createShell", "", "cmd", "shell", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ParameterName;", "name", "intent", "exec", "plugin-finder_release"})
public final class a {
    final String TAG = "Finder.Shell";

    public a() {
        AppMethodBeat.i(251492);
        m("execSql", new b<Intent, x>(this) {
            /* class com.tencent.mm.plugin.finder.shell.a.AnonymousClass1 */
            final /* synthetic */ a vwf;

            {
                this.vwf = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x00af  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x00b2 A[SYNTHETIC, Splitter:B:24:0x00b2] */
            /* JADX WARNING: Removed duplicated region for block: B:4:0x0023  */
            /* JADX WARNING: Removed duplicated region for block: B:6:0x0029  */
            @Override // kotlin.g.a.b
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ kotlin.x invoke(android.content.Intent r15) {
                /*
                // Method dump skipped, instructions count: 440
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.shell.a.AnonymousClass1.invoke(java.lang.Object):java.lang.Object");
            }
        });
        m("sendGifts", AnonymousClass2.vwg);
        AppMethodBeat.o(251492);
    }

    private static void m(String str, b<? super Intent, x> bVar) {
        AppMethodBeat.i(251491);
        b bVar2 = b.vwj;
        b.m(str, bVar);
        AppMethodBeat.o(251491);
    }
}
