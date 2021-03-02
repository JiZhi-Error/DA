package com.tencent.mm.plugin.finder.upload.action;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.upload.action.k;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "needRetry", "", "getNeedRetry", "()Z", "setNeedRetry", "(Z)V", "call", "", "uniqueId", "", "Companion", "plugin-finder_release"})
public final class d extends c {
    public static final a vUf = new a((byte) 0);
    boolean vUd;
    final e vUe;

    static {
        AppMethodBeat.i(253195);
        AppMethodBeat.o(253195);
    }

    public d(e eVar) {
        p.h(eVar, NativeProtocol.WEB_DIALOG_ACTION);
        AppMethodBeat.i(253194);
        this.vUe = eVar;
        AppMethodBeat.o(253194);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/action/FavActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/upload/action/FavActionTask$call$1", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "onTaskResult", "", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isNeedRetry", "", "plugin-finder_release"})
    public static final class b implements k.b {
        final /* synthetic */ d vUg;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(d dVar) {
            this.vUg = dVar;
        }

        @Override // com.tencent.mm.plugin.finder.upload.action.k.b
        public final void a(j jVar, boolean z) {
            AppMethodBeat.i(253191);
            p.h(jVar, "status");
            this.vUg.vUd = z;
            this.vUg.a(jVar);
            AppMethodBeat.o(253191);
        }
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        AppMethodBeat.i(253192);
        this.vUe.a(new b(this));
        AppMethodBeat.o(253192);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(253193);
        String auK = this.vUe.auK();
        AppMethodBeat.o(253193);
        return auK;
    }
}
