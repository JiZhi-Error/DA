package com.tencent.mm.ui.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u0012J\"\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0012H\u0016J\u0012\u0010'\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010.\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010/\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\nH\u0016J\b\u00100\u001a\u00020!H\u0016J\b\u00101\u001a\u00020!H\u0016J\u0018\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H\u0016J\u0012\u00107\u001a\u00020!2\b\u00108\u001a\u0004\u0018\u00010%H\u0016J\b\u00109\u001a\u00020!H\u0016J-\u0010:\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001e2\u000e\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020=0<2\u0006\u0010>\u001a\u00020?H\u0016¢\u0006\u0002\u0010@J\u0012\u0010A\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010B\u001a\u00020!H\u0016J\u0012\u0010C\u001a\u00020!2\b\u0010D\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010E\u001a\u00020!H\u0016J$\u0010F\u001a\u00020!2\b\u00108\u001a\u0004\u0018\u00010%2\u0006\u0010\"\u001a\u00020\u001e2\b\u0010G\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010H\u001a\u00020!H\u0016J\b\u0010I\u001a\u00020!H\u0016J\b\u0010J\u001a\u00020!H\u0016J\u0010\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020\u0012H\u0016J\u0012\u0010M\u001a\u00020!2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006N"}, hxF = {"Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/SimpleUIComponent;", "Lcom/tencent/mm/ui/component/IUIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "arguments", "Landroid/os/Bundle;", "context", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "context$delegate", "Lkotlin/Lazy;", "isUserVisibleFocused", "", "()Z", "setUserVisibleFocused", "(Z)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "getArguments", "getLayoutId", "", "isBelongFragment", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateAfter", "onCreateBefore", "onDestroy", "onFinished", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "onWindowFocusChanged", "hasFocus", "setArguments", "libmmui_release"})
public abstract class UIComponent extends SimpleUIComponent {
    private boolean PRP;
    private Bundle PRQ;
    public View lJI;
    private final f tMy = g.ah(new a(this));

    public final Activity getContext() {
        return (Activity) this.tMy.getValue();
    }

    public final View getRootView() {
        View view = this.lJI;
        if (view == null) {
            p.btv("rootView");
        }
        return view;
    }

    public final void setRootView(View view) {
        p.h(view, "<set-?>");
        this.lJI = view;
    }

    public final boolean isUserVisibleFocused() {
        return this.PRP;
    }

    public final void setUserVisibleFocused(boolean z) {
        this.PRP = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UIComponent(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UIComponent(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
    }

    public final boolean isBelongFragment() {
        return getFragment() != null;
    }

    public void onCreate(Bundle bundle) {
    }

    public void setArguments(Bundle bundle) {
        this.PRQ = bundle;
    }

    public Bundle getArguments() {
        return this.PRQ;
    }

    public void onCreateBefore(Bundle bundle) {
    }

    public void onCreateAfter(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public int getLayoutId() {
        return 0;
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onUserVisibleFocused() {
        this.PRP = true;
    }

    public void onUserVisibleUnFocused() {
        this.PRP = false;
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
    }

    public void onConfigurationChanged(Configuration configuration) {
        p.h(configuration, "newConfig");
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onNewIntent(Intent intent) {
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        p.h(keyEvent, "event");
        return false;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        p.h(keyEvent, "event");
        return false;
    }

    public void onStartActivityForResult(Intent intent, int i2, Bundle bundle) {
    }

    public void onWindowFocusChanged(boolean z) {
    }

    public void onBeforeFinish(Intent intent) {
    }

    public void onFinished() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/app/AppCompatActivity;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<AppCompatActivity> {
        final /* synthetic */ UIComponent PRR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(UIComponent uIComponent) {
            super(0);
            this.PRR = uIComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AppCompatActivity invoke() {
            AppMethodBeat.i(204835);
            AppCompatActivity activity = this.PRR.getActivity();
            AppMethodBeat.o(204835);
            return activity;
        }
    }
}
