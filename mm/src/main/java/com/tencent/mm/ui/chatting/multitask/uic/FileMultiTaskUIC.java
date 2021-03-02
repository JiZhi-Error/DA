package com.tencent.mm.ui.chatting.multitask.uic;

import android.app.Activity;
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitask.d;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\u0018\u0000 F2\u00020\u0001:\u0001FB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J,\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010&H\u0016J\b\u0010/\u001a\u00020\rH\u0016J\b\u00100\u001a\u00020\rH\u0016J\b\u00101\u001a\u00020\rH\u0016J-\u00102\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u000e\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u000205042\u0006\u00106\u001a\u000207H\u0016¢\u0006\u0002\u00108J\u0012\u00109\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010:\u001a\u00020\rH\u0016J\u0012\u0010;\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010=\u001a\u00020\rH\u0016J$\u0010>\u001a\u00020\r2\b\u0010?\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010A\u001a\u00020\rH\u0016J\b\u0010B\u001a\u00020\rH\u0016J\b\u0010C\u001a\u00020\rH\u0016J\u0010\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020\tH\u0016¨\u0006G"}, hxF = {"Lcom/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "supportMultiTaskType", "multiTaskType", "Companion", "app_release"})
public final class FileMultiTaskUIC extends MultiTaskUIComponent {
    public static final a PEa = new a((byte) 0);

    static {
        AppMethodBeat.i(231346);
        AppMethodBeat.o(231346);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileMultiTaskUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(231344);
        AppMethodBeat.o(231344);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileMultiTaskUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(231345);
        AppMethodBeat.o(231345);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(231337);
        getRootView().findViewById(getLayoutId());
        AppMethodBeat.o(231337);
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
        AppMethodBeat.i(231338);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        AppMethodBeat.o(231338);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(231339);
        p.h(configuration, "newConfig");
        AppMethodBeat.o(231339);
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
        AppMethodBeat.i(231340);
        p.h(keyEvent, "event");
        AppMethodBeat.o(231340);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(231341);
        p.h(keyEvent, "event");
        AppMethodBeat.o(231341);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        AppMethodBeat.i(231342);
        int layoutId = super.getLayoutId();
        AppMethodBeat.o(231342);
        return layoutId;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final boolean Js(int i2) {
        return i2 == 4;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void dk(Object obj) {
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a, com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void a(View view, MultiTaskInfo multiTaskInfo, crq crq, Object obj) {
        crt crt;
        AppMethodBeat.i(231343);
        p.h(multiTaskInfo, "info");
        p.h(crq, "animateData");
        if (multiTaskInfo.field_data != null) {
            Log.i("MicroMsg.FileMultiTaskUIC", "handleBallInfoClicked, openFile t:%s", multiTaskInfo);
            AppCompatActivity activity = getActivity();
            if (!com.tencent.mm.ui.chatting.multitask.b.gSk()) {
                u.g(activity, null);
                AppMethodBeat.o(231343);
                return;
            }
            aoe aoe = new aoe();
            try {
                aoe.parseFrom(multiTaskInfo.field_data);
            } catch (Throwable th) {
                Log.e("MicroMsg.FileMultiTaskUIC", "handleMultiTaskInfoClicked", th);
            }
            String str = aoe.filePath;
            if (!s.YS(str)) {
                Log.i("MicroMsg.FileMultiTaskUIC", "handleBallInfoClicked() %s not exist", str);
                f.a aVar = new f.a(activity);
                aVar.aC("");
                aVar.bow(activity.getString(R.string.cej)).Dq(true).hbu().b(new b()).show();
                ((d) g.ah(d.class)).removeTaskInfoAndCoverImg(multiTaskInfo.field_id);
                AppMethodBeat.o(231343);
                return;
            }
            ach ach = new ach();
            ach.LmQ = crq;
            if (view != null) {
                SecDataUIC.a aVar2 = SecDataUIC.CWq;
                Context context = view.getContext();
                p.g(context, "it.context");
                SecDataUIC gU = SecDataUIC.a.gU(context);
                ach.sGQ = (gU == null || (crt = (crt) gU.Xh(5)) == null) ? null : crt.sGQ;
            }
            if (aoe.LzL) {
                Intent intent = new Intent();
                intent.setClassName(activity, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                com.tencent.mm.plugin.multitask.f.b.a(intent, aoe);
                intent.putExtra("key_multi_task_common_info", ach.toByteArray());
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    extras.putInt("scene", 9);
                }
                intent.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC", "onMultiTaskItemClick", "(Landroid/view/View;Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC", "onMultiTaskItemClick", "(Landroid/view/View;Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(231343);
                return;
            }
            String str2 = aoe.gCr;
            String str3 = aoe.appId;
            String str4 = aoe.processName;
            boolean z = aoe.lwF;
            if (!Util.isNullOrNil(str4)) {
                ((com.tencent.mm.plugin.appbrand.service.f) g.af(com.tencent.mm.plugin.appbrand.service.f.class)).a(activity, str, str2, str3, z, str4);
            } else if (com.tencent.mm.pluginsdk.ui.tools.a.a(str, str2, "", 9, ach)) {
                com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) getActivity(), str, str2, "", 9, ach);
                AppMethodBeat.o(231343);
                return;
            }
        }
        AppMethodBeat.o(231343);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC$onMultiTaskItemClick$1$1", "Lcom/tencent/mm/ui/widget/dialog/MMConfirmDialog$IOnDialogClick;", "onDialogClick", "", "bOk", "", "text", "", "app_release"})
    public static final class b implements f.c {
        b() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(231336);
            if (z) {
                com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
                ((d) g.ah(d.class)).sendMultiTaskEvent(0, com.tencent.mm.plugin.multitask.g.eqx(), 1048576);
            }
            AppMethodBeat.o(231336);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public final a.b dks() {
        return a.b.MODE_SHOW_MULTI_SCENE;
    }
}
