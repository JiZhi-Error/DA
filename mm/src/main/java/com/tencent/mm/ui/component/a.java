package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.InvocationTargetException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/ui/component/UICProvider;", "", "()V", "of", "Landroid/arch/lifecycle/ViewModelProvider;", "context", "Landroid/content/Context;", "fragment", "Landroid/support/v4/app/Fragment;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "P", "Lcom/tencent/mm/kernel/plugin/Plugin;", "ownerClazz", "Ljava/lang/Class;", "libmmui_release"})
public final class a {
    public static final a PRN = new a();

    static {
        AppMethodBeat.i(204834);
        AppMethodBeat.o(204834);
    }

    private a() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0002H\u0003\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, hxF = {"com/tencent/mm/ui/component/UICProvider$of$1", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
    /* renamed from: com.tencent.mm.ui.component.a$a  reason: collision with other inner class name */
    public static final class C2108a extends ViewModelProvider.NewInstanceFactory {
        final /* synthetic */ Fragment uRC;

        C2108a(Fragment fragment) {
            this.uRC = fragment;
        }

        @Override // android.arch.lifecycle.ViewModelProvider.Factory, android.arch.lifecycle.ViewModelProvider.NewInstanceFactory
        public final <T extends ViewModel> T create(Class<T> cls) {
            AppMethodBeat.i(204827);
            p.h(cls, "modelClass");
            if (SimpleUIComponent.class.isAssignableFrom(cls)) {
                try {
                    T newInstance = cls.getConstructor(Fragment.class).newInstance(this.uRC);
                    AppMethodBeat.o(204827);
                    return newInstance;
                } catch (NoSuchMethodException e2) {
                    RuntimeException runtimeException = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
                    AppMethodBeat.o(204827);
                    throw runtimeException;
                } catch (IllegalAccessException e3) {
                    RuntimeException runtimeException2 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e3);
                    AppMethodBeat.o(204827);
                    throw runtimeException2;
                } catch (InstantiationException e4) {
                    RuntimeException runtimeException3 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e4);
                    AppMethodBeat.o(204827);
                    throw runtimeException3;
                } catch (InvocationTargetException e5) {
                    RuntimeException runtimeException4 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e5);
                    AppMethodBeat.o(204827);
                    throw runtimeException4;
                }
            } else {
                T t = (T) super.create(cls);
                AppMethodBeat.o(204827);
                return t;
            }
        }
    }

    public static ViewModelProvider of(Fragment fragment) {
        AppMethodBeat.i(204830);
        p.h(fragment, "fragment");
        ViewModelProvider of = ViewModelProviders.of(fragment, new C2108a(fragment));
        p.g(of, "ViewModelProviders.of(fr…\n            }\n        })");
        AppMethodBeat.o(204830);
        return of;
    }

    public static ViewModelProvider ko(Context context) {
        AppMethodBeat.i(204831);
        p.h(context, "context");
        if (!(context instanceof AppCompatActivity)) {
            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(204831);
            throw illegalStateException;
        }
        ViewModelProvider b2 = b((AppCompatActivity) context);
        AppMethodBeat.o(204831);
        return b2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0002H\u0003\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, hxF = {"com/tencent/mm/ui/component/UICProvider$of$2", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
    public static final class b extends ViewModelProvider.NewInstanceFactory {
        final /* synthetic */ AppCompatActivity uQi;

        b(AppCompatActivity appCompatActivity) {
            this.uQi = appCompatActivity;
        }

        @Override // android.arch.lifecycle.ViewModelProvider.Factory, android.arch.lifecycle.ViewModelProvider.NewInstanceFactory
        public final <T extends ViewModel> T create(Class<T> cls) {
            AppMethodBeat.i(204828);
            p.h(cls, "modelClass");
            if (SimpleUIComponent.class.isAssignableFrom(cls)) {
                try {
                    T newInstance = cls.getConstructor(AppCompatActivity.class).newInstance(this.uQi);
                    AppMethodBeat.o(204828);
                    return newInstance;
                } catch (NoSuchMethodException e2) {
                    RuntimeException runtimeException = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
                    AppMethodBeat.o(204828);
                    throw runtimeException;
                } catch (IllegalAccessException e3) {
                    RuntimeException runtimeException2 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e3);
                    AppMethodBeat.o(204828);
                    throw runtimeException2;
                } catch (InstantiationException e4) {
                    RuntimeException runtimeException3 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e4);
                    AppMethodBeat.o(204828);
                    throw runtimeException3;
                } catch (InvocationTargetException e5) {
                    RuntimeException runtimeException4 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e5);
                    AppMethodBeat.o(204828);
                    throw runtimeException4;
                }
            } else {
                T t = (T) super.create(cls);
                AppMethodBeat.o(204828);
                return t;
            }
        }
    }

    public static ViewModelProvider b(AppCompatActivity appCompatActivity) {
        AppMethodBeat.i(204832);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        ViewModelProvider of = ViewModelProviders.of(appCompatActivity, new b(appCompatActivity));
        p.g(of, "ViewModelProviders.of(ac…\n            }\n        })");
        AppMethodBeat.o(204832);
        return of;
    }

    public static <P extends f> ViewModelProvider bi(Class<P> cls) {
        AppMethodBeat.i(204833);
        p.h(cls, "ownerClazz");
        com.tencent.mm.kernel.b.a ah = g.ah(cls);
        if (ah == null) {
            p.hyc();
        }
        f fVar = (f) ah;
        if (!(fVar instanceof ViewModelStoreOwner)) {
            RuntimeException runtimeException = new RuntimeException(fVar + " cannot create ViewModelProvider failed.");
            AppMethodBeat.o(204833);
            throw runtimeException;
        }
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStoreOwner) fVar, new c(fVar));
        AppMethodBeat.o(204833);
        return viewModelProvider;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0002H\u0003\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, hxF = {"com/tencent/mm/ui/component/UICProvider$of$3", "Landroid/arch/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "libmmui_release"})
    public static final class c extends ViewModelProvider.NewInstanceFactory {
        final /* synthetic */ f PRO;

        c(f fVar) {
            this.PRO = fVar;
        }

        @Override // android.arch.lifecycle.ViewModelProvider.Factory, android.arch.lifecycle.ViewModelProvider.NewInstanceFactory
        public final <T extends ViewModel> T create(Class<T> cls) {
            AppMethodBeat.i(204829);
            p.h(cls, "modelClass");
            if (UIComponentPlugin.class.isAssignableFrom(cls)) {
                try {
                    T newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                    T t = newInstance;
                    if (t == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.component.UIComponentPlugin<P>");
                        AppMethodBeat.o(204829);
                        throw tVar;
                    }
                    P p = (P) this.PRO;
                    p.h(p, "<set-?>");
                    ((UIComponentPlugin) t).PSd = p;
                    T t2 = newInstance;
                    AppMethodBeat.o(204829);
                    return t2;
                } catch (NoSuchMethodException e2) {
                    RuntimeException runtimeException = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
                    AppMethodBeat.o(204829);
                    throw runtimeException;
                } catch (IllegalAccessException e3) {
                    RuntimeException runtimeException2 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e3);
                    AppMethodBeat.o(204829);
                    throw runtimeException2;
                } catch (InstantiationException e4) {
                    RuntimeException runtimeException3 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e4);
                    AppMethodBeat.o(204829);
                    throw runtimeException3;
                } catch (InvocationTargetException e5) {
                    RuntimeException runtimeException4 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e5);
                    AppMethodBeat.o(204829);
                    throw runtimeException4;
                }
            } else {
                T t3 = (T) super.create(cls);
                AppMethodBeat.o(204829);
                return t3;
            }
        }
    }
}
