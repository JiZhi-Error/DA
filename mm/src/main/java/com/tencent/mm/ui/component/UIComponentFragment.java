package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 N2\u00020\u0001:\u0001NB\u0005¢\u0006\u0002\u0010\u0002J#\u0010 \u001a\u0002H!\"\b\b\u0000\u0010!*\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\u0018\u0010(\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0$\u0018\u00010)H&J \u0010*\u001a\u00020+2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001cj\b\u0012\u0004\u0012\u00020\u000b`\u001dH\u0014J\u0006\u0010,\u001a\u00020\u0006J?\u0010-\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010\u00112\u0006\u0010/\u001a\u00020\u00112#\b\u0002\u00100\u001a\u001d\u0012\u0013\u0012\u001102¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u000601H\u0003J\u0012\u00106\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u00109\u001a\u00020+2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0010\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020>H\u0016J&\u0010?\u001a\u0004\u0018\u00010\u00162\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010D\u001a\u00020+H\u0016J\b\u0010E\u001a\u00020+H\u0016J\b\u0010F\u001a\u00020+H\u0016J\u0010\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u000208H\u0016J\b\u0010I\u001a\u00020+H\u0016J\b\u0010J\u001a\u00020+H\u0016J\b\u0010K\u001a\u00020+H\u0016J\b\u0010L\u001a\u00020+H\u0016J\u0012\u0010M\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u000108H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR!\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001cj\b\u0012\u0004\u0012\u00020\u000b`\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006O"}, hxF = {"Lcom/tencent/mm/ui/component/UIComponentFragment;", "Landroid/support/v4/app/Fragment;", "()V", "focusState", "", "isShouldCreated", "", "()Z", "setShouldCreated", "(Z)V", "layoutUIC", "Lcom/tencent/mm/ui/component/UIComponent;", "getLayoutUIC", "()Lcom/tencent/mm/ui/component/UIComponent;", "setLayoutUIC", "(Lcom/tencent/mm/ui/component/UIComponent;)V", "modelStore", "Landroid/arch/lifecycle/ViewModelStore;", "pendingResumeAction", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "component", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "getLayoutId", "getViewModelStore", "importUIComponents", "", "initializeUIC", "", "isUserVisibleFocused", "mapStoreTo", "src", "dest", "isStore", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "any", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "onViewStateRestored", "Companion", "libmmui_release"})
public abstract class UIComponentFragment extends Fragment {
    public static final a PRZ = new a((byte) 0);
    private int PRW;
    protected boolean PRX;
    private final LinkedList<Runnable> PRY = new LinkedList<>();
    private HashMap _$_findViewCache;
    protected View lJI;
    private UIComponent layoutUIC;
    private ViewModelStore modelStore;
    public final HashSet<UIComponent> uiComponents = new HashSet<>();

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public abstract Set<Class<? extends UIComponent>> importUIComponents();

    @Override // android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Object, Boolean> {
        public static final b PSa = new b();

        static {
            AppMethodBeat.i(204842);
            AppMethodBeat.o(204842);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Object obj) {
            AppMethodBeat.i(204841);
            p.h(obj, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(204841);
            return bool;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "model", "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<Object, Boolean> {
        public static final c PSb = new c();

        static {
            AppMethodBeat.i(204844);
            AppMethodBeat.o(204844);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Object obj) {
            boolean z;
            AppMethodBeat.i(204843);
            p.h(obj, "model");
            if (!(obj instanceof SimpleUIComponent)) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(204843);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/ui/component/UIComponentFragment$Companion;", "", "()V", "STATE_DEFAULT", "", "STATE_FOCUSED", "STATE_UN_FOCUSED", "TAG", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final <T extends ViewModel> T component(Class<T> cls) {
        p.h(cls, "modelClass");
        a aVar = a.PRN;
        T t = (T) a.of(this).get(cls);
        p.g(t, "UICProvider.of(this).get(modelClass)");
        return t;
    }

    @Override // android.support.v4.app.Fragment, android.arch.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        ViewModelStore viewModelStore = this.modelStore;
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        mapStoreTo(super.getViewModelStore(), viewModelStore2, b.PSa);
        this.modelStore = viewModelStore2;
        return viewModelStore2;
    }

    public int getLayoutId() {
        UIComponent uIComponent = this.layoutUIC;
        if (uIComponent != null) {
            return uIComponent.getLayoutId();
        }
        return 0;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        boolean z;
        super.onAttach(context);
        HashSet<UIComponent> hashSet = this.uiComponents;
        p.h(hashSet, "uiComponents");
        Set<Class<? extends UIComponent>> importUIComponents = importUIComponents();
        if (importUIComponents != null) {
            Iterator<T> it = importUIComponents.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                a aVar = a.PRN;
                UIComponent uIComponent = (UIComponent) a.of(this).get(it.next());
                hashSet.add(uIComponent);
                if (uIComponent.getLayoutId() != 0) {
                    this.layoutUIC = uIComponent;
                    if (z2) {
                        throw new RuntimeException("already layout uic[" + this.layoutUIC + "], no more than one layout uic.");
                    }
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
        }
        Iterator<T> it2 = this.uiComponents.iterator();
        while (it2.hasNext()) {
            it2.next().setArguments(getArguments());
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        p.h(layoutInflater, "inflater");
        if (this.lJI == null) {
            View inflate = aa.jQ(getContext()).inflate(getLayoutId(), viewGroup, false);
            Log.i("MicroMsg.UIComponentFragment", "[onCreateView] " + getClass().getSimpleName() + '@' + hashCode() + " uiComponents=" + this.uiComponents);
            Iterator<T> it = this.uiComponents.iterator();
            while (it.hasNext()) {
                p.g(inflate, "view");
                it.next().setRootView(inflate);
            }
            this.lJI = inflate;
            Iterator<T> it2 = this.uiComponents.iterator();
            while (it2.hasNext()) {
                it2.next().onCreateBefore(bundle);
            }
            this.PRX = true;
        }
        return this.lJI;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.PRX) {
            Log.i("MicroMsg.UIComponentFragment", "[onActivityCreated] " + getClass().getSimpleName() + '@' + hashCode());
            Iterator<T> it = this.uiComponents.iterator();
            while (it.hasNext()) {
                it.next().onCreate(bundle);
            }
            Iterator<T> it2 = this.uiComponents.iterator();
            while (it2.hasNext()) {
                it2.next().onCreateAfter(bundle);
            }
            this.PRX = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        Log.i("MicroMsg.UIComponentFragment", "[onStart] " + getClass().getSimpleName() + '@' + hashCode());
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Log.i("MicroMsg.UIComponentFragment", "[onResume] " + getClass().getSimpleName() + '@' + hashCode());
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
        Iterator<T> it2 = this.PRY.iterator();
        while (it2.hasNext()) {
            it2.next().run();
        }
        this.PRY.clear();
    }

    @Override // android.support.v4.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    public void onUserVisibleFocused() {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        if (!p.j(currentThread, mainLooper.getThread())) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (this.PRW != 1) {
            d dVar = new d(this);
            if (!isResumed()) {
                Log.w("MicroMsg.UIComponentFragment", "[onUserVisibleFocused] wait to fragment resume.");
                this.PRY.add(dVar);
            } else {
                dVar.run();
            }
            this.PRW = 1;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ UIComponentFragment PSc;

        d(UIComponentFragment uIComponentFragment) {
            this.PSc = uIComponentFragment;
        }

        public final void run() {
            AppMethodBeat.i(204845);
            Log.i("MicroMsg.UIComponentFragment", "[onViewFocused] " + this.PSc.getClass().getSimpleName() + '@' + this.PSc.hashCode() + " focusState=" + this.PSc.PRW);
            Iterator<T> it = this.PSc.uiComponents.iterator();
            while (it.hasNext()) {
                it.next().onUserVisibleFocused();
            }
            AppMethodBeat.o(204845);
        }
    }

    public void onUserVisibleUnFocused() {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        if (!p.j(currentThread, mainLooper.getThread())) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (this.PRW != 2) {
            Log.i("MicroMsg.UIComponentFragment", "[onViewUnFocused] " + getClass().getSimpleName() + '@' + hashCode());
            Iterator<T> it = this.uiComponents.iterator();
            while (it.hasNext()) {
                it.next().onUserVisibleUnFocused();
            }
            this.PRW = 2;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        Log.i("MicroMsg.UIComponentFragment", "[onPause] " + getClass().getSimpleName() + '@' + hashCode());
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        Log.i("MicroMsg.UIComponentFragment", "[onStop] " + getClass().getSimpleName() + '@' + hashCode());
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        ViewModelStore viewModelStore = this.modelStore;
        ViewModelStore viewModelStore2 = super.getViewModelStore();
        p.g(viewModelStore2, "super.getViewModelStore()");
        mapStoreTo(viewModelStore, viewModelStore2, c.PSb);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onRestoreInstanceState(bundle);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        p.h(bundle, "outState");
        super.onSaveInstanceState(bundle);
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onSaveInstanceState(bundle);
        }
    }

    private static void mapStoreTo(ViewModelStore viewModelStore, ViewModelStore viewModelStore2, kotlin.g.a.b<Object, Boolean> bVar) {
        if (viewModelStore != null) {
            Field declaredField = ViewModelStore.class.getDeclaredField("mMap");
            p.g(declaredField, "ViewModelStore::class.ja….getDeclaredField(\"mMap\")");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(viewModelStore);
            if (obj == null) {
                throw new t("null cannot be cast to non-null type java.util.HashMap<kotlin.Any, kotlin.Any>");
            }
            HashMap hashMap = (HashMap) obj;
            Object obj2 = declaredField.get(viewModelStore2);
            if (obj2 == null) {
                throw new t("null cannot be cast to non-null type java.util.HashMap<kotlin.Any, kotlin.Any>");
            }
            HashMap hashMap2 = (HashMap) obj2;
            for (Map.Entry entry : hashMap.entrySet()) {
                if (bVar.invoke(entry.getValue()).booleanValue()) {
                    hashMap2.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
