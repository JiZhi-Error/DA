package com.tencent.magicbrush.ui;

import android.support.annotation.Keep;
import com.facebook.appevents.UserDataStore;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@Keep
@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000fJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0014J\r\u0010\u0015\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0004J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0004J\u001a\u0010\u001a\u001a\u00020\r2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\u001cJ\u0015\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0000¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0007J\b\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/magicbrush/ui/MBViewManager;", "", "()V", "idGenerator", "", "listeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "viewContainer", "Ljava/util/HashMap;", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "Lkotlin/collections/HashMap;", "add", "", "view", "add$lib_magicbrush_nano_release", "fromId", "addListener", "l", "addSurfaceListenerForAllViews", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "clear", "clear$lib_magicbrush_nano_release", "find", "virtualElementId", "findOrNull", "forEach", UserDataStore.FIRST_NAME, "Lkotlin/Function1;", "remove", "remove$lib_magicbrush_nano_release", "removeListener", "toString", "", "Listener", "lib-magicbrush-nano_release"})
public final class MBViewManager {
    private int idGenerator;
    private final com.tencent.magicbrush.utils.c<a> listeners = new com.tencent.magicbrush.utils.c<>();
    private final HashMap<Integer, MagicBrushView> viewContainer = new HashMap<>();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "", "onViewAdd", "", "v", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "onViewRemove", "lib-magicbrush-nano_release"})
    public interface a {
        void a(MagicBrushView magicBrushView);

        void b(MagicBrushView magicBrushView);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<a, x> {
        final /* synthetic */ MagicBrushView cKD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MagicBrushView magicBrushView) {
            super(1);
            this.cKD = magicBrushView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(a aVar) {
            AppMethodBeat.i(140236);
            a aVar2 = aVar;
            p.h(aVar2, LocaleUtil.ITALIAN);
            aVar2.b(this.cKD);
            x xVar = x.SXb;
            AppMethodBeat.o(140236);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "invoke"})
    static final class d extends q implements kotlin.g.a.b<a, x> {
        final /* synthetic */ MagicBrushView cKD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MagicBrushView magicBrushView) {
            super(1);
            this.cKD = magicBrushView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(a aVar) {
            AppMethodBeat.i(140237);
            a aVar2 = aVar;
            p.h(aVar2, LocaleUtil.ITALIAN);
            aVar2.a(this.cKD);
            x xVar = x.SXb;
            AppMethodBeat.o(140237);
            return xVar;
        }
    }

    public MBViewManager() {
        AppMethodBeat.i(140247);
        AppMethodBeat.o(140247);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/magicbrush/ui/MBViewManager$addSurfaceListenerForAllViews$1", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "onViewAdd", "", "v", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "lib-magicbrush-nano_release"})
    public static final class c implements a {
        final /* synthetic */ MagicBrushView.c cOQ;

        c(MagicBrushView.c cVar) {
            this.cOQ = cVar;
        }

        @Override // com.tencent.magicbrush.ui.MBViewManager.a
        public final void a(MagicBrushView magicBrushView) {
            AppMethodBeat.i(162120);
            p.h(magicBrushView, "v");
            p.h(magicBrushView, "v");
            AppMethodBeat.o(162120);
        }

        @Override // com.tencent.magicbrush.ui.MBViewManager.a
        public final void b(MagicBrushView magicBrushView) {
            AppMethodBeat.i(162119);
            p.h(magicBrushView, "v");
            magicBrushView.a(this.cOQ);
            AppMethodBeat.o(162119);
        }
    }

    public final void addSurfaceListenerForAllViews(MagicBrushView.c cVar) {
        AppMethodBeat.i(162121);
        p.h(cVar, "l");
        this.listeners.add(new c(cVar));
        AppMethodBeat.o(162121);
    }

    public final void addListener(a aVar) {
        AppMethodBeat.i(140238);
        p.h(aVar, "l");
        this.listeners.add(aVar);
        AppMethodBeat.o(140238);
    }

    public final void removeListener(a aVar) {
        AppMethodBeat.i(140239);
        p.h(aVar, "l");
        this.listeners.remove(aVar);
        AppMethodBeat.o(140239);
    }

    public final synchronized MagicBrushView findOrNull(int i2) {
        MagicBrushView magicBrushView;
        AppMethodBeat.i(140240);
        magicBrushView = this.viewContainer.get(Integer.valueOf(i2));
        AppMethodBeat.o(140240);
        return magicBrushView;
    }

    public final synchronized MagicBrushView find(int i2) {
        MagicBrushView magicBrushView;
        AppMethodBeat.i(140241);
        MagicBrushView magicBrushView2 = this.viewContainer.get(Integer.valueOf(i2));
        if (magicBrushView2 == null) {
            p.hyc();
        }
        magicBrushView = magicBrushView2;
        AppMethodBeat.o(140241);
        return magicBrushView;
    }

    public final void add$lib_magicbrush_nano_release(MagicBrushView magicBrushView) {
        AppMethodBeat.i(140242);
        p.h(magicBrushView, "view");
        add$lib_magicbrush_nano_release(magicBrushView, -1);
        AppMethodBeat.o(140242);
    }

    public final void add$lib_magicbrush_nano_release(MagicBrushView magicBrushView, int i2) {
        AppMethodBeat.i(206875);
        p.h(magicBrushView, "view");
        z.d dVar = new z.d();
        synchronized (this) {
            if (i2 < 0) {
                try {
                    i2 = this.idGenerator;
                    this.idGenerator = i2 + 1;
                } catch (Throwable th) {
                    AppMethodBeat.o(206875);
                    throw th;
                }
            }
            dVar.SYE = i2;
            this.viewContainer.put(Integer.valueOf(dVar.SYE), magicBrushView);
            x xVar = x.SXb;
        }
        magicBrushView.setVirtualElementId$lib_magicbrush_nano_release(dVar.SYE);
        this.listeners.b(new b(magicBrushView));
        AppMethodBeat.o(206875);
    }

    public final void remove$lib_magicbrush_nano_release(MagicBrushView magicBrushView) {
        AppMethodBeat.i(140243);
        p.h(magicBrushView, "view");
        synchronized (this) {
            try {
                int virtualElementId = magicBrushView.getVirtualElementId();
                if (!this.viewContainer.containsKey(Integer.valueOf(virtualElementId))) {
                    String format = String.format("VirtualElementId error. current [%s] request [%d]", Arrays.copyOf(new Object[]{toString(), Integer.valueOf(virtualElementId)}, 2));
                    p.g(format, "java.lang.String.format(this, *args)");
                    IllegalStateException illegalStateException = new IllegalStateException(format.toString());
                    AppMethodBeat.o(140243);
                    throw illegalStateException;
                }
                this.viewContainer.remove(Integer.valueOf(virtualElementId));
            } catch (Throwable th) {
                AppMethodBeat.o(140243);
                throw th;
            }
        }
        this.listeners.b(new d(magicBrushView));
        AppMethodBeat.o(140243);
    }

    public final synchronized void clear$lib_magicbrush_nano_release() {
        AppMethodBeat.i(140244);
        this.viewContainer.clear();
        this.listeners.clear();
        AppMethodBeat.o(140244);
    }

    public final void forEach(kotlin.g.a.b<? super MagicBrushView, x> bVar) {
        AppMethodBeat.i(182582);
        p.h(bVar, UserDataStore.FIRST_NAME);
        ArrayList<? super MagicBrushView> arrayList = new ArrayList();
        synchronized (this) {
            try {
                for (MagicBrushView magicBrushView : this.viewContainer.values()) {
                    p.g(magicBrushView, "v");
                    arrayList.add(magicBrushView);
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(182582);
            }
        }
        for (Object obj : arrayList) {
            bVar.invoke(obj);
        }
    }

    public final String toString() {
        AppMethodBeat.i(140246);
        StringBuilder sb = new StringBuilder();
        sb.append("ViewManager(").append(hashCode()).append(")");
        synchronized (this) {
            try {
                Set<Integer> keySet = this.viewContainer.keySet();
                p.g(keySet, "viewContainer.keys");
                sb.append(j.u((Collection<Integer>) keySet));
            } catch (Throwable th) {
                AppMethodBeat.o(140246);
                throw th;
            }
        }
        String sb2 = sb.toString();
        p.g(sb2, "result.toString()");
        AppMethodBeat.o(140246);
        return sb2;
    }
}
