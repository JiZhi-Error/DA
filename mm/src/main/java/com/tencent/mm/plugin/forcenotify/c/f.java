package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0015R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr;", "", "()V", "historyIdSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "itemQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "add", "", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "item", "hasNext", "", "next", "setExpired", "forcePushId", "size", "", "Companion", "plugin-force-notify_release"})
public final class f {
    public static final a UVX = new a((byte) 0);
    private static final kotlin.f iax = g.ah(b.UVY);
    public final ConcurrentLinkedQueue<e> UVV;
    public final HashSet<String> UVW;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<h, x> {
        final /* synthetic */ f UVZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(f fVar) {
            super(1);
            this.UVZ = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(h hVar) {
            AppMethodBeat.i(261752);
            h hVar2 = hVar;
            p.h(hVar2, LocaleUtil.ITALIAN);
            this.UVZ.UVV.offer(hVar2);
            this.UVZ.UVW.add(hVar2.wMn);
            x xVar = x.SXb;
            AppMethodBeat.o(261752);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr;", "getInstance", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr;", "instance$delegate", "Lkotlin/Lazy;", "plugin-force-notify_release"})
    public static final class a {
        public static f hVE() {
            AppMethodBeat.i(261751);
            kotlin.f fVar = f.iax;
            a aVar = f.UVX;
            f fVar2 = (f) fVar.getValue();
            AppMethodBeat.o(261751);
            return fVar2;
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private f() {
        AppMethodBeat.i(261756);
        this.UVV = new ConcurrentLinkedQueue<>();
        this.UVW = new HashSet<>();
        AppMethodBeat.o(261756);
    }

    public /* synthetic */ f(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(261757);
        AppMethodBeat.o(261757);
    }

    public final void byh(String str) {
        AppMethodBeat.i(261753);
        p.h(str, "forcePushId");
        this.UVW.remove(str);
        AppMethodBeat.o(261753);
    }

    public final boolean hasNext() {
        AppMethodBeat.i(261754);
        if (!this.UVV.isEmpty()) {
            AppMethodBeat.o(261754);
            return true;
        }
        AppMethodBeat.o(261754);
        return false;
    }

    public final e hVD() {
        AppMethodBeat.i(261755);
        e poll = this.UVV.poll();
        AppMethodBeat.o(261755);
        return poll;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItemMgr;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<f> {
        public static final b UVY = new b();

        static {
            AppMethodBeat.i(261750);
            AppMethodBeat.o(261750);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ f invoke() {
            AppMethodBeat.i(261749);
            f fVar = new f((byte) 0);
            AppMethodBeat.o(261749);
            return fVar;
        }
    }
}
