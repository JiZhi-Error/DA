package com.tencent.mm.plugin.webview.luggage.webview_impl;

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
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;

public final class LuggageWebMultiTaskUIC extends MultiTaskUIComponent {
    private static final LinkedList<b> IXj = new LinkedList<>();
    public static final a IXk = new a((byte) 0);

    public interface b {
        void p(MultiTaskInfo multiTaskInfo);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(210345);
        AppMethodBeat.o(210345);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LuggageWebMultiTaskUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(210343);
        AppMethodBeat.o(210343);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LuggageWebMultiTaskUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(210344);
        AppMethodBeat.o(210344);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(210335);
        getRootView().findViewById(getLayoutId());
        AppMethodBeat.o(210335);
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
        AppMethodBeat.i(210336);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        AppMethodBeat.o(210336);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(210337);
        p.h(configuration, "newConfig");
        AppMethodBeat.o(210337);
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
        AppMethodBeat.i(210338);
        p.h(keyEvent, "event");
        AppMethodBeat.o(210338);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(210339);
        p.h(keyEvent, "event");
        AppMethodBeat.o(210339);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        AppMethodBeat.i(210340);
        int layoutId = super.getLayoutId();
        AppMethodBeat.o(210340);
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
        AppMethodBeat.i(210341);
        p.h(multiTaskInfo, "info");
        p.h(crq, "animateData");
        fah fah = new fah();
        try {
            fah.parseFrom(multiTaskInfo.field_data);
        } catch (Exception e2) {
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", fah.edo);
        intent.putExtra("title", fah.title);
        intent.putExtra("KMutilTaskInfo", multiTaskInfo);
        intent.putExtra("webview_bg_color_rsID", 17170445);
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
        intent.putExtra("key_multi_task_common_info", ach.toByteArray());
        intent.putExtra("float_ball_key", multiTaskInfo.field_id);
        Log.i("MicroMsg.LuggageWebMultiTaskUIC", "onMultiTaskItemClick, id = " + multiTaskInfo.field_id);
        c.b(getActivity(), "webview", ".ui.tools.WebViewUI", intent);
        com.tencent.mm.ui.base.b.ke(getActivity());
        AppMethodBeat.o(210341);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void dF(Object obj) {
        AppMethodBeat.i(210342);
        if (obj instanceof MultiTaskInfo) {
            MultiTaskInfo multiTaskInfo = (MultiTaskInfo) obj;
            p.h(multiTaskInfo, "info");
            Iterator<T> it = IXj.iterator();
            while (it.hasNext()) {
                it.next().p(multiTaskInfo);
            }
        }
        AppMethodBeat.o(210342);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public final a.b dks() {
        return a.b.MODE_SHOW_MULTI_SCENE;
    }
}
