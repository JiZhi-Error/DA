package com.tencent.mm.plugin.multitask.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitask.f.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0011\u0018\u0000 H2\u00020\u0001:\u0001HB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J,\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010/\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010&H\u0016J\b\u00100\u001a\u00020\rH\u0016J\b\u00101\u001a\u00020\rH\u0016J\b\u00102\u001a\u00020\rH\u0016J-\u00103\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u000e\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u000206052\u0006\u00107\u001a\u000208H\u0016¢\u0006\u0002\u00109J\u0012\u0010:\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010;\u001a\u00020\rH\u0016J\u0012\u0010<\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010>\u001a\u00020\rH\u0016J$\u0010?\u001a\u00020\r2\b\u0010@\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\t2\b\u0010A\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010B\u001a\u00020\rH\u0016J\u0010\u0010C\u001a\u00020\r2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010D\u001a\u00020\rH\u0016J\b\u0010E\u001a\u00020\rH\u0016J\u0010\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\tH\u0016¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/uic/WebMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onTaskBarItemExposed", "onUserVisibleFocused", "onUserVisibleUnFocused", "supportMultiTaskType", "multiTaskType", "Companion", "ui-multitask_release"})
public final class WebMultiTaskUIC extends MultiTaskUIComponent {
    public static final a AgH = new a((byte) 0);

    static {
        AppMethodBeat.i(236738);
        AppMethodBeat.o(236738);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/uic/WebMultiTaskUIC$Companion;", "", "()V", "TAG", "", "ui-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebMultiTaskUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(236736);
        AppMethodBeat.o(236736);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebMultiTaskUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(236737);
        AppMethodBeat.o(236737);
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
        AppMethodBeat.i(236728);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        AppMethodBeat.o(236728);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(236729);
        p.h(configuration, "newConfig");
        AppMethodBeat.o(236729);
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
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(236730);
        p.h(keyEvent, "event");
        AppMethodBeat.o(236730);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(236731);
        p.h(keyEvent, "event");
        AppMethodBeat.o(236731);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        AppMethodBeat.i(236732);
        int layoutId = super.getLayoutId();
        AppMethodBeat.o(236732);
        return layoutId;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final boolean Js(int i2) {
        return i2 == 2;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void dk(Object obj) {
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a, com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void a(View view, MultiTaskInfo multiTaskInfo, crq crq, Object obj) {
        String str;
        AppMethodBeat.i(236733);
        p.h(multiTaskInfo, "info");
        p.h(crq, "animateData");
        fah fah = new fah();
        try {
            fah.parseFrom(multiTaskInfo.field_data);
        } catch (Exception e2) {
        }
        Intent intent = new Intent();
        b.a(intent, fah);
        int i2 = fah.Nwt;
        ach ach = new ach();
        ach.LmQ = crq;
        if (view != null) {
            SecDataUIC.a aVar = SecDataUIC.CWq;
            Context context = view.getContext();
            p.g(context, "view.context");
            if (SecDataUIC.a.gU(context) != null) {
                SecDataUIC.a aVar2 = SecDataUIC.CWq;
                Context context2 = view.getContext();
                p.g(context2, "view.context");
                SecDataUIC gU = SecDataUIC.a.gU(context2);
                crt crt = gU != null ? (crt) gU.Xh(5) : null;
                if (crt != null) {
                    str = crt.sGQ;
                } else {
                    str = null;
                }
                ach.sGQ = str;
            }
        }
        intent.putExtra("rawUrl", fah.edo);
        intent.putExtra("convertActivityFromTranslucent", false);
        intent.putExtra("key_multi_task_common_info", ach.toByteArray());
        intent.putExtra("float_ball_key", multiTaskInfo.field_id);
        intent.putExtra("key_enable_teen_mode_check", true);
        intent.putExtra("nextAnimIn", R.anim.br);
        intent.putExtra("currentAnimOut", 0);
        intent.putExtra("minimize_secene", 0);
        intent.putExtra("webpageTitle", fah.title);
        if (i2 >= 0) {
            int i3 = fah.Nwo;
            int i4 = fah.Nwp;
            if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(i3) && ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(MMApplicationContext.getContext(), fah.edo, i2, i3, i4, intent)) {
                Log.i("MicroMsg.WebMultiTaskUIC", "openWebPage, use fast Load");
                AppMethodBeat.o(236733);
                return;
            }
        }
        c.b(getActivity(), "webview", ".ui.tools.WebViewUI", intent);
        d dVar = d.JmQ;
        d.s(multiTaskInfo);
        AppMethodBeat.o(236733);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public final a.b dks() {
        return a.b.MODE_SHOW_MULTI_SCENE;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void dF(Object obj) {
        AppMethodBeat.i(236734);
        if (obj instanceof MultiTaskInfo) {
            Log.d("MicroMsg.WebMultiTaskUIC", "onMultiTaskItemDelete, name:%s", ((MultiTaskInfo) obj).field_showData.title);
            d dVar = d.JmQ;
            d.q((MultiTaskInfo) obj);
        }
        AppMethodBeat.o(236734);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void a(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(236735);
        p.h(multiTaskInfo, "info");
        Log.d("MicroMsg.WebMultiTaskUIC", "onTaskBarItemExposed, name:%s", multiTaskInfo.field_showData.title);
        fah fah = new fah();
        try {
            fah.parseFrom(multiTaskInfo.field_data);
            int i2 = fah.Nwt;
            String str = fah.edo;
            if (i2 >= 0 && !Util.isNullOrNil(str)) {
                int i3 = fah.Nwo;
                Log.d("MicroMsg.WebMultiTaskUIC", "addToPreload, name:%s", multiTaskInfo.field_showData.title);
                ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(str, i2, i3, new Object[0]);
            }
            d dVar = d.JmQ;
            d.r(multiTaskInfo);
            AppMethodBeat.o(236735);
        } catch (Throwable th) {
            Log.e("MicroMsg.WebMultiTaskUIC", "WebMultiTaskData parse fail", th);
            AppMethodBeat.o(236735);
        }
    }
}
