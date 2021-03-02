package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bw;
import com.tencent.mm.plugin.appbrand.page.capsulebar.c;
import com.tencent.mm.plugin.appbrand.page.capsulebar.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import com.tencent.mm.plugin.appbrand.ui.k;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011J/\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0005H\u0002¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0005J/\u0010\u001b\u001a\u0004\u0018\u0001H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00052\u0006\u0010\u001c\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u001dJ/\u0010\u001e\u001a\u0004\u0018\u0001H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0005H\u0016¢\u0006\u0002\u0010\u0018J\u0006\u0010\u001f\u001a\u00020 J \u0010!\u001a\u00020 \"\b\b\u0000\u0010\u0013*\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0005H\u0007R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/page/PageDecorWidgetFactory$DefaultFactory;", "()V", "mKeepPersistentViews", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "[Ljava/lang/Class;", "mPreloadedWidgets", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "mScreenAdaptiveViews", "Landroid/view/ViewGroup;", "contains", "", "array", "objectToFind", "", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "createWidgetImpl", "WIDGET", "Landroid/view/View;", "context", "Landroid/content/Context;", "clazz", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "getFactoryContextForWidget", "originalContext", "getPreloadedWidget", "ctx", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "onCreateWidget", "onDestroy", "", "preloadWidget", "Companion", "PreloadWidgetPool", "plugin-appbrand-integration_release"})
public final class e extends bw.a {
    public static final a nnG = new a((byte) 0);
    private final Class<? extends ViewGroup>[] nnD = {d.class, com.tencent.mm.plugin.appbrand.widget.actionbar.b.class, com.tencent.mm.plugin.appbrand.widget.tabbar.a.class};
    private final Class<? extends com.tencent.mm.ui.statusbar.b>[] nnE = {c.class, com.tencent.mm.plugin.appbrand.widget.actionbar.d.class, AppBrandUILoadingSplash.class};
    public final b nnF = new b();

    static {
        AppMethodBeat.i(50908);
        AppMethodBeat.o(50908);
    }

    public e() {
        AppMethodBeat.i(50907);
        AppMethodBeat.o(50907);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final Context c(Context context, Class<? extends View> cls) {
        n nVar;
        AppMethodBeat.i(50902);
        p.h(context, "originalContext");
        p.h(cls, "clazz");
        if (k.bXf()) {
            if (contains(this.nnD, cls)) {
                nVar = f.eh(context);
            } else {
                nVar = context;
            }
            if (p.j(cls, AppBrandUILoadingSplash.class)) {
                nVar = f.eh(nVar);
            }
        } else {
            nVar = context;
        }
        if (contains(this.nnE, cls)) {
            nVar = f.ei(nVar);
        }
        Resources resources = nVar.getResources();
        p.g(resources, "context.resources");
        Resources resources2 = context.getResources();
        p.g(resources2, "originalContext.resources");
        Log.i("MicroMsg.AppBrandDecorWidgetFactoryWC", "getFactoryContextForWidget: clazz [%s] adapted density [%f] original density [%f]", cls.getCanonicalName(), Float.valueOf(resources.getDisplayMetrics().density), Float.valueOf(resources2.getDisplayMetrics().density));
        AppMethodBeat.o(50902);
        return nVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bw.a, com.tencent.mm.plugin.appbrand.page.bw
    public final <WIDGET extends View> WIDGET d(Context context, Class<WIDGET> cls) {
        AppMethodBeat.i(50903);
        p.h(context, "context");
        p.h(cls, "clazz");
        long nowMilliSecond = Util.nowMilliSecond();
        View b2 = this.nnF.b(cls, c(context, cls));
        WIDGET widget = b2 == null ? (WIDGET) e(context, cls) : (WIDGET) b2;
        Log.d("MicroMsg.AppBrandDecorWidgetFactoryWC", "onCreateWidget class[" + cls.getName() + "] cost[" + (Util.nowMilliSecond() - nowMilliSecond) + "ms] preloaded[" + (b2 != null) + ']');
        AppMethodBeat.o(50903);
        return widget;
    }

    private final <WIDGET extends View> WIDGET e(Context context, Class<WIDGET> cls) {
        AppMethodBeat.i(50904);
        WIDGET widget = (WIDGET) super.d(c(context, cls), cls);
        AppMethodBeat.o(50904);
        return widget;
    }

    public final <WIDGET extends View> void aD(Class<WIDGET> cls) {
        AppMethodBeat.i(50905);
        p.h(cls, "clazz");
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        View e2 = e(context, cls);
        if (e2 == null) {
            AppMethodBeat.o(50905);
            return;
        }
        this.nnF.a(cls, e2);
        AppMethodBeat.o(50905);
    }

    public final <WIDGET extends View> WIDGET a(Class<WIDGET> cls, Context context) {
        AppMethodBeat.i(229234);
        p.h(cls, "clazz");
        p.h(context, "ctx");
        WIDGET widget = (WIDGET) this.nnF.b(cls, c(context, cls));
        AppMethodBeat.o(229234);
        return widget;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\n2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\u0006J/\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000f0\u00052\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012RF\u0010\u0003\u001a:\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0004j\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "", "()V", "mMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Landroid/view/View;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "clear", "", "offer", "clazz", "widget", "poll", "WIDGET", "ctx", "Landroid/content/Context;", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "plugin-appbrand-integration_release"})
    public static final class b {
        final HashMap<Class<? extends View>, LinkedList<View>> mMap = new HashMap<>();

        public b() {
            AppMethodBeat.i(50901);
            AppMethodBeat.o(50901);
        }

        public final void a(Class<? extends View> cls, View view) {
            AppMethodBeat.i(50898);
            p.h(cls, "clazz");
            p.h(view, "widget");
            if (this.mMap.get(cls) == null) {
                new a(this, cls).invoke();
            }
            LinkedList<View> linkedList = this.mMap.get(cls);
            if (linkedList == null) {
                p.hyc();
            }
            linkedList.addLast(view);
            AppMethodBeat.o(50898);
        }

        public final <WIDGET extends View> WIDGET b(Class<? extends WIDGET> cls, Context context) {
            AppMethodBeat.i(229233);
            p.h(cls, "clazz");
            p.h(context, "ctx");
            LinkedList<View> linkedList = this.mMap.get(cls);
            WIDGET widget = linkedList != null ? (WIDGET) linkedList.pollFirst() : null;
            if (!(widget instanceof View)) {
                widget = null;
            }
            if (widget != null) {
                Resources resources = context.getResources();
                p.g(resources, "ctx.resources");
                float f2 = resources.getDisplayMetrics().density;
                Context context2 = widget.getContext();
                p.g(context2, "widget.context");
                Resources resources2 = context2.getResources();
                p.g(resources2, "widget.context.resources");
                float f3 = resources2.getDisplayMetrics().density;
                if (f2 != f3) {
                    Log.i("MicroMsg.AppBrandDecorWidgetFactoryWC", "getPreloadedWidget: [%s]([%f]) preloaded but outer density([%f]) has changed, ret null", cls.getCanonicalName(), Float.valueOf(f3), Float.valueOf(f2));
                    AppMethodBeat.o(229233);
                    return null;
                }
            }
            AppMethodBeat.o(229233);
            return widget;
        }

        public final void clear() {
            AppMethodBeat.i(50900);
            Collection<LinkedList<View>> values = this.mMap.values();
            p.g(values, "mMap.values");
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            this.mMap.clear();
            AppMethodBeat.o(50900);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Landroid/view/View;", "invoke"})
        public static final class a extends q implements kotlin.g.a.a<LinkedList<View>> {
            final /* synthetic */ b nnH;
            final /* synthetic */ Class nnI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, Class cls) {
                super(0);
                this.nnH = bVar;
                this.nnI = cls;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ LinkedList<View> invoke() {
                AppMethodBeat.i(50897);
                LinkedList<View> linkedList = new LinkedList<>();
                this.nnH.mMap.put(this.nnI, linkedList);
                AppMethodBeat.o(50897);
                return linkedList;
            }
        }
    }

    private static boolean contains(Object[] objArr, Object obj) {
        AppMethodBeat.i(50906);
        for (Object obj2 : objArr) {
            if (p.j(obj2, obj)) {
                AppMethodBeat.o(50906);
                return true;
            }
        }
        AppMethodBeat.o(50906);
        return false;
    }
}
