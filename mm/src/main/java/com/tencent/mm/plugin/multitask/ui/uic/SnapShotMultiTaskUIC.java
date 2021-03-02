package com.tencent.mm.plugin.multitask.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.animation.c.a.d;
import com.tencent.mm.plugin.multitask.c.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.c.a.b;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\f\u0018\u0000 k2\u00020\u0001:\u0001kB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J,\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u0018H\u0016J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u0018J\b\u0010\"\u001a\u00020\tH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0006\u0010&\u001a\u00020\tJ\u0006\u0010'\u001a\u00020\tJ\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020\u0018H\u0016J\"\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u0018H\u0016J\u0012\u00102\u001a\u00020)2\b\u00103\u001a\u0004\u0018\u000100H\u0016J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u000206H\u0016J\u0012\u00107\u001a\u00020)2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010:\u001a\u00020)2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010;\u001a\u00020)2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010<\u001a\u00020)H\u0016J\u0018\u0010=\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020@H\u0016J\u0018\u0010A\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020@H\u0016J\u0012\u0010B\u001a\u00020)2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J,\u0010E\u001a\u00020)2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010DH\u0016J\b\u0010J\u001a\u00020)H\u0016J\b\u0010K\u001a\u00020)H\u0016J\b\u0010L\u001a\u00020)H\u0016J\u0018\u0010M\u001a\u00020)2\b\u0010N\u001a\u0004\u0018\u00010 2\u0006\u0010O\u001a\u00020PJ\b\u0010Q\u001a\u00020)H\u0016J-\u0010R\u001a\u00020)2\u0006\u0010-\u001a\u00020\t2\u000e\u0010S\u001a\n\u0012\u0006\b\u0001\u0012\u00020U0T2\u0006\u0010V\u001a\u00020WH\u0016¢\u0006\u0002\u0010XJ\u0012\u0010Y\u001a\u00020)2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010Z\u001a\u00020)H\u0016J\u0012\u0010[\u001a\u00020)2\b\u0010\\\u001a\u0004\u0018\u000109H\u0016J\b\u0010]\u001a\u00020)H\u0016J$\u0010^\u001a\u00020)2\b\u0010_\u001a\u0004\u0018\u0001002\u0006\u0010-\u001a\u00020\t2\b\u0010`\u001a\u0004\u0018\u000109H\u0016J\b\u0010a\u001a\u00020)H\u0016J\b\u0010b\u001a\u00020)H\u0016J\b\u0010c\u001a\u00020)H\u0016J\b\u0010d\u001a\u00020)H\u0016J\u0012\u0010d\u001a\u00020)2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010e\u001a\u00020)H\u0016J0\u0010f\u001a\u00020)2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010g\u001a\u0004\u0018\u00010hH\u0002J\u0010\u0010i\u001a\u00020\u00182\u0006\u0010j\u001a\u00020\tH\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006l"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "HIDE_DURATION", "", "HIDE_LOADING", "LoadingHandler", "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1;", "SHOW_DURATION", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;)V", "checkShowSnapshotIfNeed", "", "size", "forceHide", "taskInfo", "forceShow", "getDefaultBitmap", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "onlyBg", "getLayoutId", "getMultiTaskInfo", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getViewHeight", "getViewWidth", "hideSnapshotUIC", "", "hideloading", "isShow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "info", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPanelSlide", "panel", "slideOffset", "", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "showSnapshotUIC", "showloading", "startEnterAnim", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "supportMultiTaskType", "multiTaskType", "Companion", "ui-multitask_release"})
public final class SnapShotMultiTaskUIC extends MultiTaskUIComponent {
    public static final a Agz = new a((byte) 0);
    com.tencent.mm.plugin.multitask.animation.a.a Agt;
    MultiTaskInfo Agu;
    private final int Agv;
    private final int Agw = 10000;
    private final int Agx = 1000;
    private final b Agy = new b(this, Looper.getMainLooper());

    static {
        AppMethodBeat.i(236727);
        AppMethodBeat.o(236727);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$Companion;", "", "()V", "TAG", "", "ui-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$LoadingHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "ui-multitask_release"})
    public static final class b extends MMHandler {
        final /* synthetic */ SnapShotMultiTaskUIC AgA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(SnapShotMultiTaskUIC snapShotMultiTaskUIC, Looper looper) {
            super(looper);
            this.AgA = snapShotMultiTaskUIC;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(236696);
            p.h(message, "msg");
            int i2 = message.what;
            if (i2 == this.AgA.Agx) {
                ProgressBar progressBar = (ProgressBar) this.AgA.getRootView().findViewById(R.id.fnl);
                p.g(progressBar, "loadingView");
                progressBar.setVisibility(0);
                AppMethodBeat.o(236696);
                return;
            }
            if (i2 == this.AgA.Agv) {
                this.AgA.esA();
                this.AgA.esB();
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                Context context = this.AgA.getRootView().getContext();
                p.g(context, "rootView.context");
                ((MultiTaskUIC) com.tencent.mm.ui.component.a.ko(context).get(MultiTaskUIC.class)).hx(true);
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_MULTITASK_LAST_SHOW_ID_AND_TIME_STRING_SYNC, "");
            }
            AppMethodBeat.o(236696);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapShotMultiTaskUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(236725);
        AppMethodBeat.o(236725);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapShotMultiTaskUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(236726);
        AppMethodBeat.o(236726);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateBefore(Bundle bundle) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onRestoreInstanceState(Bundle bundle) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStart() {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleUnFocused() {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStop() {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(236708);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        AppMethodBeat.o(236708);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(236709);
        p.h(configuration, "newConfig");
        AppMethodBeat.o(236709);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStartActivityForResult(Intent intent, int i2, Bundle bundle) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onBeforeFinish(Intent intent) {
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void dkr() {
        AppMethodBeat.i(236710);
        esB();
        esA();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        Context context = getRootView().getContext();
        p.g(context, "rootView.context");
        ((MultiTaskUIC) com.tencent.mm.ui.component.a.ko(context).get(MultiTaskUIC.class)).hx(true);
        AppMethodBeat.o(236710);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(236711);
        p.h(keyEvent, "event");
        AppMethodBeat.o(236711);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(236712);
        p.h(keyEvent, "event");
        AppMethodBeat.o(236712);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.b78;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final boolean Js(int i2) {
        return i2 == 1048576;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        public static final c AgB = new c();

        static {
            AppMethodBeat.i(236698);
            AppMethodBeat.o(236698);
        }

        c() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(236697);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$onMultiTaskInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.d("MicroMsg.SnapShotMultiTaskUIC", "snapshotview onClick!");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$onMultiTaskInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(236697);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void dk(Object obj) {
        AppMethodBeat.i(236713);
        getRootView().setOnClickListener(c.AgB);
        AppMethodBeat.o(236713);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$onMultiTaskItemClick$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "ui-multitask_release"})
    public static final class d implements com.tencent.mm.plugin.multitask.c.c {
        final /* synthetic */ SnapShotMultiTaskUIC AgA;
        final /* synthetic */ Object AgC;

        d(SnapShotMultiTaskUIC snapShotMultiTaskUIC, Object obj) {
            this.AgA = snapShotMultiTaskUIC;
            this.AgC = obj;
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void RL(int i2) {
            AppMethodBeat.i(236699);
            if (this.AgC instanceof com.tencent.mm.plugin.multitask.c.c) {
                ((com.tencent.mm.plugin.multitask.c.c) this.AgC).RL(0);
            }
            this.AgA.esA();
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = this.AgA.getRootView().getContext();
            p.g(context, "rootView.context");
            ((MultiTaskUIC) com.tencent.mm.ui.component.a.ko(context).get(MultiTaskUIC.class)).hx(true);
            AppMethodBeat.o(236699);
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void a(Bitmap bitmap, boolean z, int i2) {
            AppMethodBeat.i(236700);
            if (this.AgC instanceof com.tencent.mm.plugin.multitask.c.c) {
                c.a.a((com.tencent.mm.plugin.multitask.c.c) this.AgC, bitmap, false, 6);
            }
            this.AgA.esA();
            this.AgA.getRootView().setTranslationX(0.0f);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = this.AgA.getRootView().getContext();
            p.g(context, "rootView.context");
            ((MultiTaskUIC) com.tencent.mm.ui.component.a.ko(context).get(MultiTaskUIC.class)).hx(false);
            AppMethodBeat.o(236700);
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void g(Bitmap bitmap, int i2) {
            AppMethodBeat.i(236701);
            this.AgA.esz();
            if (this.AgC instanceof com.tencent.mm.plugin.multitask.c.c) {
                c.a.a((com.tencent.mm.plugin.multitask.c.c) this.AgC, bitmap);
            }
            AppMethodBeat.o(236701);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a, com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void a(View view, MultiTaskInfo multiTaskInfo, crq crq, Object obj) {
        AppMethodBeat.i(236714);
        p.h(multiTaskInfo, "info");
        p.h(crq, "animateData");
        this.Agu = multiTaskInfo;
        a(view, multiTaskInfo, crq, (com.tencent.mm.plugin.multitask.c.c) new d(this, obj));
        AppMethodBeat.o(236714);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public final a.b dks() {
        return a.b.MODE_SHOW_SNAPSHOT_SCENE;
    }

    public final void esz() {
        AppMethodBeat.i(236715);
        this.Agy.removeMessages(this.Agx);
        this.Agy.sendEmptyMessageDelayed(this.Agx, (long) this.Agx);
        this.Agy.removeMessages(this.Agv);
        this.Agy.sendEmptyMessageDelayed(this.Agv, (long) this.Agw);
        AppMethodBeat.o(236715);
    }

    public final void esA() {
        AppMethodBeat.i(236716);
        ProgressBar progressBar = (ProgressBar) getRootView().findViewById(R.id.fnl);
        p.g(progressBar, "loadingView");
        progressBar.setVisibility(8);
        this.Agy.removeMessages(this.Agx);
        this.Agy.removeMessages(this.Agv);
        AppMethodBeat.o(236716);
    }

    public final void erV() {
        AppMethodBeat.i(236717);
        m(this.Agu);
        AppMethodBeat.o(236717);
    }

    public final void m(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(236718);
        boolean z = getRootView().getVisibility() == 0;
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "showSnapshotUIC, isVisible:%b", Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(236718);
            return;
        }
        esA();
        getRootView().setVisibility(0);
        View rootView = getRootView();
        MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
        int i2 = MultiTaskUIC.Agi;
        com.tencent.mm.plugin.multitask.f.a aVar2 = com.tencent.mm.plugin.multitask.f.a.AgJ;
        rootView.setTranslationX(0.0f - ((float) (i2 + com.tencent.mm.plugin.multitask.f.a.esC())));
        com.tencent.f.h.RTc.aZ(new e(this, multiTaskInfo));
        AppMethodBeat.o(236718);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ SnapShotMultiTaskUIC AgA;
        final /* synthetic */ MultiTaskInfo AgD;

        e(SnapShotMultiTaskUIC snapShotMultiTaskUIC, MultiTaskInfo multiTaskInfo) {
            this.AgA = snapShotMultiTaskUIC;
            this.AgD = multiTaskInfo;
        }

        public final void run() {
            Integer num;
            Integer num2;
            x xVar;
            String str;
            cru erh;
            String str2 = null;
            AppMethodBeat.i(236704);
            com.tencent.mm.plugin.multitask.h hVar = com.tencent.mm.plugin.multitask.h.zZn;
            String g2 = com.tencent.mm.plugin.multitask.h.g(this.AgD);
            com.tencent.mm.plugin.multitask.f.a aVar = com.tencent.mm.plugin.multitask.f.a.AgJ;
            Bitmap aGR = com.tencent.mm.plugin.multitask.f.a.aGR(g2);
            if (aGR != null) {
                num = Integer.valueOf(aGR.getWidth());
            } else {
                num = null;
            }
            if (aGR != null) {
                num2 = Integer.valueOf(aGR.getHeight());
            } else {
                num2 = null;
            }
            if (num == null || num2 == null) {
                xVar = null;
            } else {
                com.tencent.mm.ac.d.h(new b(num.intValue(), num2.intValue(), this, aGR));
                xVar = x.SXb;
            }
            if (xVar == null) {
                StringBuilder sb = new StringBuilder("showSnapshotUIC, error! id:");
                MultiTaskInfo multiTaskInfo = this.AgD;
                if (multiTaskInfo != null) {
                    str = multiTaskInfo.field_id;
                } else {
                    str = null;
                }
                StringBuilder append = sb.append(str).append(", title:");
                MultiTaskInfo multiTaskInfo2 = this.AgD;
                if (!(multiTaskInfo2 == null || (erh = multiTaskInfo2.erh()) == null)) {
                    str2 = erh.title;
                }
                Log.i("MicroMsg.SnapShotMultiTaskUIC", append.append(str2).toString());
                com.tencent.mm.ac.d.h(new a(this));
                x xVar2 = x.SXb;
            }
            AppMethodBeat.o(236704);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$showSnapshotUIC$1$1$1"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ e AgE;
            final /* synthetic */ int UZa;
            final /* synthetic */ int UZb;
            final /* synthetic */ Bitmap UZc;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(int i2, int i3, e eVar, Bitmap bitmap) {
                super(0);
                this.UZa = i2;
                this.UZb = i3;
                this.AgE = eVar;
                this.UZc = bitmap;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                float height;
                cru erh;
                Integer num = null;
                AppMethodBeat.i(259985);
                ViewParent parent = this.AgE.AgA.getRootView().getParent();
                if (!(parent instanceof ViewGroup)) {
                    parent = null;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup != null) {
                    float width = ((float) viewGroup.getWidth()) / ((float) this.UZa);
                    MultiTaskInfo multiTaskInfo = this.AgE.AgD;
                    if (!(multiTaskInfo == null || (erh = multiTaskInfo.erh()) == null)) {
                        num = Integer.valueOf(erh.xlQ);
                    }
                    if (num == null) {
                        height = width;
                    } else {
                        height = num.intValue() == 90 ? ((float) viewGroup.getHeight()) / ((float) this.UZb) : width;
                    }
                    Matrix matrix = new Matrix();
                    matrix.setScale(height, height);
                    View findViewById = this.AgE.AgA.getRootView().findViewById(R.id.fnk);
                    p.g(findViewById, "(rootView.findViewById<I…R.id.multi_task_content))");
                    ((ImageView) findViewById).setImageMatrix(matrix);
                    ((ImageView) this.AgE.AgA.getRootView().findViewById(R.id.fnk)).setImageBitmap(this.UZc);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(259985);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$showSnapshotUIC$1$2$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ e AgE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(e eVar) {
                super(0);
                this.AgE = eVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(236702);
                this.AgE.AgA.esB();
                x xVar = x.SXb;
                AppMethodBeat.o(236702);
                return xVar;
            }
        }
    }

    public final void esB() {
        ViewParent viewParent;
        ViewParent viewParent2;
        AppMethodBeat.i(236719);
        boolean z = getRootView().getVisibility() == 8;
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "hideSnapshotUIC, isInVisible:%b", Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(236719);
            return;
        }
        getRootView().setVisibility(8);
        View rootView = getRootView();
        com.tencent.mm.plugin.multitask.f.a aVar = com.tencent.mm.plugin.multitask.f.a.AgJ;
        rootView.setTranslationX(0.0f - ((float) com.tencent.mm.plugin.multitask.f.a.esC()));
        ((ImageView) getRootView().findViewById(R.id.fnk)).setImageBitmap(null);
        if (this.Agt != null) {
            com.tencent.mm.plugin.multitask.animation.a.a aVar2 = this.Agt;
            if (aVar2 != null) {
                viewParent = aVar2.getParent();
            } else {
                viewParent = null;
            }
            if (p.j(viewParent, getRootView())) {
                com.tencent.mm.plugin.multitask.animation.a.a aVar3 = this.Agt;
                if (aVar3 != null) {
                    viewParent2 = aVar3.getParent();
                } else {
                    viewParent2 = null;
                }
                if (viewParent2 == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(236719);
                    throw tVar;
                }
                ((ViewGroup) viewParent2).removeView(this.Agt);
                this.Agt = null;
            }
        }
        AppMethodBeat.o(236719);
    }

    public final boolean bJw() {
        AppMethodBeat.i(236720);
        if (getRootView().getVisibility() == 0) {
            AppMethodBeat.o(236720);
            return true;
        }
        AppMethodBeat.o(236720);
        return false;
    }

    private final void a(View view, MultiTaskInfo multiTaskInfo, crq crq, com.tencent.mm.plugin.multitask.c.c cVar) {
        String str;
        String[] strArr;
        List<String> q;
        AppMethodBeat.i(236721);
        if (view == null || multiTaskInfo == null) {
            cVar.RL(0);
            AppMethodBeat.o(236721);
            return;
        }
        z.f fVar = new z.f();
        if (multiTaskInfo.erh().MwT) {
            fVar.SYG = (T) ex(view.findViewById(R.id.fnq));
        } else {
            com.tencent.mm.plugin.multitask.h hVar = com.tencent.mm.plugin.multitask.h.zZn;
            String g2 = com.tencent.mm.plugin.multitask.h.g(multiTaskInfo);
            com.tencent.mm.plugin.multitask.f.a aVar = com.tencent.mm.plugin.multitask.f.a.AgJ;
            fVar.SYG = (T) com.tencent.mm.plugin.multitask.f.a.aGR(g2);
        }
        if (fVar.SYG == null || fVar.SYG.isRecycled() || fVar.SYG.getWidth() == 0 || fVar.SYG.getHeight() == 0) {
            Log.w("MicroMsg.SnapShotMultiTaskUIC", "startEnterAnim, page get bitmap is null");
            cVar.RL(0);
            AppMethodBeat.o(236721);
            return;
        }
        ((ImageView) getRootView().findViewById(R.id.fnk)).setImageBitmap(null);
        if (this.Agt != null) {
            com.tencent.mm.plugin.multitask.animation.a.a aVar2 = this.Agt;
            if (p.j(aVar2 != null ? aVar2.getParent() : null, getRootView())) {
                View rootView = getRootView();
                if (rootView == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
                    AppMethodBeat.o(236721);
                    throw tVar;
                }
                ((FrameLayout) rootView).removeView(this.Agt);
            }
        }
        int viewWidth = getViewWidth();
        int viewHeight = getViewHeight();
        if (multiTaskInfo.erh().MwT) {
            Bitmap hn = com.tencent.mm.ui.n.a.hn(view.findViewById(R.id.fnu));
            this.Agt = new com.tencent.mm.plugin.multitask.animation.a.b(view.getContext(), fVar.SYG, hn);
            if (hn != null) {
                int width = (viewWidth - hn.getWidth()) / 2;
                int height = (viewHeight - hn.getHeight()) / 2;
                com.tencent.mm.plugin.multitask.animation.a.a aVar3 = this.Agt;
                if (aVar3 != null) {
                    aVar3.setDefaultDstRect(new Rect(width, height, hn.getWidth() + width, hn.getHeight() + height));
                }
            }
        } else {
            this.Agt = new com.tencent.mm.plugin.multitask.animation.a.c(view.getContext(), fVar.SYG);
        }
        com.tencent.mm.plugin.multitask.animation.a.a aVar4 = this.Agt;
        if (aVar4 != null) {
            aVar4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        View rootView2 = getRootView();
        if (rootView2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(236721);
            throw tVar2;
        }
        ((FrameLayout) rootView2).addView(this.Agt, 0);
        if (crq != null) {
            try {
                str = crq.lcm;
            } catch (Exception e2) {
                cVar.RL(0);
                Log.e("MicroMsg.SnapShotMultiTaskUIC", "get pos value failed, %s", e2.getMessage());
                AppMethodBeat.o(236721);
                return;
            }
        } else {
            str = null;
        }
        if (!Util.isNullOrNil(str)) {
            if (!(str == null || (q = new k(",").q(str, 0)) == null)) {
                Object[] array = q.toArray(new String[0]);
                if (array == null) {
                    t tVar3 = new t("null cannot be cast to non-null type kotlin.Array<T>");
                    AppMethodBeat.o(236721);
                    throw tVar3;
                }
                String[] strArr2 = (String[]) array;
                if (strArr2 != null) {
                    strArr = strArr2;
                    if (strArr == null && strArr.length == 4) {
                        getRootView().setVisibility(0);
                        Rect rect = new Rect(0, 0, viewWidth, viewHeight);
                        Integer valueOf = Integer.valueOf(strArr[0]);
                        p.g(valueOf, "Integer.valueOf(posVec.get(0))");
                        int intValue = valueOf.intValue();
                        Integer valueOf2 = Integer.valueOf(strArr[1]);
                        p.g(valueOf2, "Integer.valueOf(posVec.get(1))");
                        int intValue2 = valueOf2.intValue();
                        Integer valueOf3 = Integer.valueOf(strArr[2]);
                        p.g(valueOf3, "Integer.valueOf(posVec.get(2))");
                        int intValue3 = valueOf3.intValue();
                        Integer valueOf4 = Integer.valueOf(strArr[3]);
                        p.g(valueOf4, "Integer.valueOf(posVec.get(3))");
                        Rect rect2 = new Rect(intValue, intValue2, intValue3, valueOf4.intValue());
                        int width2 = rect2.left + (rect2.width() / 2);
                        int height2 = rect2.top + (rect2.height() / 2);
                        float width3 = (float) ((rect.left + (rect.width() / 2)) - width2);
                        float height3 = (float) (((rect.height() / 2) + rect.top) - height2);
                        float width4 = ((float) rect2.width()) / ((float) viewWidth);
                        com.tencent.mm.plugin.multitask.animation.a.a aVar5 = this.Agt;
                        if (aVar5 != null) {
                            aVar5.setTranslationX(-width3);
                        }
                        com.tencent.mm.plugin.multitask.animation.a.a aVar6 = this.Agt;
                        if (aVar6 != null) {
                            aVar6.setTranslationY(-height3);
                        }
                        com.tencent.mm.plugin.multitask.animation.a.a aVar7 = this.Agt;
                        if (aVar7 != null) {
                            aVar7.setScaleX(width4);
                        }
                        com.tencent.mm.plugin.multitask.animation.a.a aVar8 = this.Agt;
                        if (aVar8 != null) {
                            aVar8.setScaleY(width4);
                        }
                        com.tencent.mm.plugin.multitask.animation.a.a aVar9 = this.Agt;
                        if (aVar9 != null) {
                            aVar9.setDstRect(new Rect(0, 0, viewWidth, viewHeight));
                        }
                        com.tencent.mm.plugin.multitask.animation.a.a aVar10 = this.Agt;
                        if (aVar10 != null) {
                            aVar10.hk(viewWidth, viewHeight);
                        }
                        float height4 = (((((float) viewHeight) * width4) - ((float) rect2.height())) / 2.0f) * (1.0f / width4);
                        com.tencent.mm.plugin.multitask.animation.a.a aVar11 = this.Agt;
                        if (aVar11 != null) {
                            aVar11.m(height4, (float) viewWidth, ((float) viewHeight) - height4);
                        }
                        com.tencent.mm.plugin.multitask.animation.a.a aVar12 = this.Agt;
                        if (aVar12 != null) {
                            d.a aVar13 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
                            d.a aVar14 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
                            d.a aVar15 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
                            d.a aVar16 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
                            aVar12.m(((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) / width4, ((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) / width4, ((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) / width4, ((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) / width4);
                        }
                        com.tencent.mm.ui.c.a.a.gu(this.Agt).cn(0.0f).co(0.0f).cp(1.0f).cq(1.0f).a(new f(this, viewWidth, viewHeight, width4, rect2)).c(new DecelerateInterpolator()).aK(new g(cVar, fVar)).aJ(new h(cVar)).gKg().start();
                        AppMethodBeat.o(236721);
                        return;
                    }
                    cVar.RL(0);
                    AppMethodBeat.o(236721);
                    return;
                }
            }
            strArr = null;
            if (strArr == null) {
            }
            cVar.RL(0);
            AppMethodBeat.o(236721);
            return;
        }
        cVar.RL(0);
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "startEnterAnim, snapPos is null or empty");
        AppMethodBeat.o(236721);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "value", "", "onUpdate"})
    public static final class f implements b.a {
        final /* synthetic */ Rect AaU;
        final /* synthetic */ SnapShotMultiTaskUIC AgA;
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ float wrG;

        f(SnapShotMultiTaskUIC snapShotMultiTaskUIC, int i2, int i3, float f2, Rect rect) {
            this.AgA = snapShotMultiTaskUIC;
            this.cKE = i2;
            this.cKF = i3;
            this.wrG = f2;
            this.AaU = rect;
        }

        @Override // com.tencent.mm.ui.c.a.b.a
        public final void by(float f2) {
            AppMethodBeat.i(236705);
            float f3 = (float) this.cKE;
            float height = (((((float) this.cKF) * this.wrG) - ((float) this.AaU.height())) / 2.0f) * (1.0f - f2) * (1.0f / this.wrG);
            float f4 = ((float) this.cKF) - height;
            com.tencent.mm.plugin.multitask.animation.a.a aVar = this.AgA.Agt;
            if (aVar != null) {
                aVar.setMaskAlpha((int) (255.0f * (1.0f - f2)));
            }
            com.tencent.mm.plugin.multitask.animation.a.a aVar2 = this.AgA.Agt;
            if (aVar2 != null) {
                aVar2.m(height, f3, f4);
            }
            com.tencent.mm.plugin.multitask.animation.a.a aVar3 = this.AgA.Agt;
            if (aVar3 != null) {
                d.a aVar4 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
                float f5 = (((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) * (1.0f - f2)) / this.wrG;
                d.a aVar5 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
                float f6 = (((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) * (1.0f - f2)) / this.wrG;
                d.a aVar6 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
                float f7 = (((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) * (1.0f - f2)) / this.wrG;
                d.a aVar7 = com.tencent.mm.plugin.multitask.animation.c.a.d.AaD;
                aVar3.m(f5, f6, f7, (((float) com.tencent.mm.plugin.multitask.animation.c.a.d.zZS) * (1.0f - f2)) / this.wrG);
            }
            com.tencent.mm.plugin.multitask.animation.a.a aVar8 = this.AgA.Agt;
            if (aVar8 != null) {
                aVar8.postInvalidate();
                AppMethodBeat.o(236705);
                return;
            }
            AppMethodBeat.o(236705);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ z.f AgG;
        final /* synthetic */ com.tencent.mm.plugin.multitask.c.c zZX;

        g(com.tencent.mm.plugin.multitask.c.c cVar, z.f fVar) {
            this.zZX = cVar;
            this.AgG = fVar;
        }

        public final void run() {
            AppMethodBeat.i(236706);
            com.tencent.mm.plugin.multitask.c.c cVar = this.zZX;
            if (cVar != null) {
                c.a.a(cVar, this.AgG.SYG, false, 6);
                AppMethodBeat.o(236706);
                return;
            }
            AppMethodBeat.o(236706);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.multitask.c.c zZX;

        h(com.tencent.mm.plugin.multitask.c.c cVar) {
            this.zZX = cVar;
        }

        public final void run() {
            AppMethodBeat.i(236707);
            com.tencent.mm.plugin.multitask.c.c cVar = this.zZX;
            if (cVar != null) {
                c.a.a(cVar, null);
                AppMethodBeat.o(236707);
                return;
            }
            AppMethodBeat.o(236707);
        }
    }

    private static Bitmap ex(View view) {
        AppMethodBeat.i(236722);
        if (view != null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                Drawable background = view.getBackground();
                if (background != null) {
                    background.draw(canvas);
                }
                AppMethodBeat.o(236722);
                return createBitmap;
            } catch (Exception e2) {
                Log.e("MicroMsg.SnapShotMultiTaskUIC", "%s", Util.stackTraceToString(e2));
            }
        }
        AppMethodBeat.o(236722);
        return null;
    }

    private int getViewWidth() {
        View bodyView;
        AppMethodBeat.i(236723);
        AppCompatActivity activity = getActivity();
        if (!(activity instanceof MMActivity)) {
            activity = null;
        }
        MMActivity mMActivity = (MMActivity) activity;
        if (mMActivity == null || (bodyView = mMActivity.getBodyView()) == null) {
            Window window = getActivity().getWindow();
            p.g(window, "activity.window");
            View decorView = window.getDecorView();
            p.g(decorView, "activity.window.decorView");
            int width = decorView.getWidth();
            AppMethodBeat.o(236723);
            return width;
        }
        int width2 = bodyView.getWidth();
        AppMethodBeat.o(236723);
        return width2;
    }

    private int getViewHeight() {
        View bodyView;
        AppMethodBeat.i(236724);
        AppCompatActivity activity = getActivity();
        if (!(activity instanceof MMActivity)) {
            activity = null;
        }
        MMActivity mMActivity = (MMActivity) activity;
        if (mMActivity == null || (bodyView = mMActivity.getBodyView()) == null) {
            Window window = getActivity().getWindow();
            p.g(window, "activity.window");
            View decorView = window.getDecorView();
            p.g(decorView, "activity.window.decorView");
            int height = decorView.getHeight();
            AppMethodBeat.o(236724);
            return height;
        }
        int height2 = bodyView.getHeight();
        AppMethodBeat.o(236724);
        return height2;
    }
}
