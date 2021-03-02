package com.tencent.mm.ui.component;

import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0007\b\u0012¢\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010\u001d\u001a\u00020\u001cJ\n\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020#2\b\b\u0001\u0010\u001d\u001a\u00020\u001cJ\b\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020#H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, hxF = {"Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Lcom/tencent/mm/ui/component/SimpleUIComponentJava;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "()V", "getActivity", "()Landroid/support/v7/app/AppCompatActivity;", "setActivity", "getFragment", "()Landroid/support/v4/app/Fragment;", "setFragment", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "lifecycle", "Landroid/arch/lifecycle/Lifecycle;", "getLifecycle", "()Landroid/arch/lifecycle/Lifecycle;", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "getColor", "", "id", "getDimension", "", "getFindIdDelegateView", "Landroid/view/View;", "getString", "", "onCleared", "", "toString", "Companion", "libmmui_release"})
public class SimpleUIComponent extends SimpleUIComponentJava {
    public static final a PRM = new a((byte) 0);
    private Fragment fragment;
    public AppCompatActivity tUQ;

    static {
        AppMethodBeat.i(204826);
        AppMethodBeat.o(204826);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/component/SimpleUIComponent$Companion;", "", "()V", "TAG", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final AppCompatActivity getActivity() {
        AppMethodBeat.i(204813);
        AppCompatActivity appCompatActivity = this.tUQ;
        if (appCompatActivity == null) {
            p.btv(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        AppMethodBeat.o(204813);
        return appCompatActivity;
    }

    public final void setActivity(AppCompatActivity appCompatActivity) {
        AppMethodBeat.i(204814);
        p.h(appCompatActivity, "<set-?>");
        this.tUQ = appCompatActivity;
        AppMethodBeat.o(204814);
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final void setFragment(Fragment fragment2) {
        this.fragment = fragment2;
    }

    public final Lifecycle getLifecycle() {
        Lifecycle lifecycle;
        AppMethodBeat.i(204815);
        Fragment fragment2 = this.fragment;
        if (fragment2 == null || (lifecycle = fragment2.getLifecycle()) == null) {
            AppCompatActivity appCompatActivity = this.tUQ;
            if (appCompatActivity == null) {
                p.btv(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            }
            lifecycle = appCompatActivity.getLifecycle();
            p.g(lifecycle, "activity.lifecycle");
        }
        AppMethodBeat.o(204815);
        return lifecycle;
    }

    public final Intent getIntent() {
        AppMethodBeat.i(204816);
        AppCompatActivity appCompatActivity = this.tUQ;
        if (appCompatActivity == null) {
            p.btv(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        Intent intent = appCompatActivity.getIntent();
        p.g(intent, "activity.intent");
        AppMethodBeat.o(204816);
        return intent;
    }

    public final Resources getResources() {
        AppMethodBeat.i(204817);
        AppCompatActivity appCompatActivity = this.tUQ;
        if (appCompatActivity == null) {
            p.btv(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        Resources resources = appCompatActivity.getResources();
        p.g(resources, "activity.resources");
        AppMethodBeat.o(204817);
        return resources;
    }

    public SimpleUIComponent(AppCompatActivity appCompatActivity) {
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(204824);
        this.tUQ = appCompatActivity;
        AppMethodBeat.o(204824);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SimpleUIComponent(android.support.v4.app.Fragment r4) {
        /*
            r3 = this;
            r2 = 204825(0x32019, float:2.87021E-40)
            java.lang.String r0 = "fragment"
            kotlin.g.b.p.h(r4, r0)
            android.support.v4.app.FragmentActivity r0 = r4.getActivity()
            if (r0 != 0) goto L_0x001b
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type android.support.v7.app.AppCompatActivity"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x001b:
            android.support.v7.app.AppCompatActivity r0 = (android.support.v7.app.AppCompatActivity) r0
            r3.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            r3.fragment = r4
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.component.SimpleUIComponent.<init>(android.support.v4.app.Fragment):void");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.component.SimpleUIComponentJava
    public View getFindIdDelegateView() {
        AppMethodBeat.i(204818);
        if (this.fragment != null) {
            Fragment fragment2 = this.fragment;
            if (fragment2 != null) {
                View view = fragment2.getView();
                AppMethodBeat.o(204818);
                return view;
            }
            AppMethodBeat.o(204818);
            return null;
        }
        AppCompatActivity appCompatActivity = this.tUQ;
        if (appCompatActivity == null) {
            p.btv(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        Window window = appCompatActivity.getWindow();
        p.g(window, "activity.window");
        View decorView = window.getDecorView();
        AppMethodBeat.o(204818);
        return decorView;
    }

    private SimpleUIComponent() {
    }

    public final String getString(int i2) {
        AppMethodBeat.i(204819);
        String string = getResources().getString(i2);
        p.g(string, "resources.getString(id)");
        AppMethodBeat.o(204819);
        return string;
    }

    public final int getColor(@android.support.annotation.a int i2) {
        AppMethodBeat.i(204820);
        int color = getResources().getColor(i2);
        AppMethodBeat.o(204820);
        return color;
    }

    public final float getDimension(int i2) {
        AppMethodBeat.i(204821);
        float dimension = getResources().getDimension(i2);
        AppMethodBeat.o(204821);
        return dimension;
    }

    public String toString() {
        AppMethodBeat.i(204822);
        String str = getClass().getName() + '@' + hashCode();
        AppMethodBeat.o(204822);
        return str;
    }

    @Override // android.arch.lifecycle.ViewModel
    public void onCleared() {
        Class<?> cls;
        AppMethodBeat.i(204823);
        super.onCleared();
        StringBuilder sb = new StringBuilder("[onCleared] fragment=");
        Fragment fragment2 = this.fragment;
        StringBuilder append = sb.append((fragment2 == null || (cls = fragment2.getClass()) == null) ? null : cls.getName()).append(" activity=");
        AppCompatActivity appCompatActivity = this.tUQ;
        if (appCompatActivity == null) {
            p.btv(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        Log.i("SimpleUIComponent", append.append(appCompatActivity.getClass().getName()).toString());
        AppMethodBeat.o(204823);
    }
}
