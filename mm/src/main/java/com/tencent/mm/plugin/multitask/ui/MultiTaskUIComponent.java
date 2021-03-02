package com.tencent.mm.plugin.multitask.ui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J,\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getMultiTaskRootView", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "setMultiTaskRootView", "(Lcom/tencent/mm/ui/base/CustomViewPager;)V", "onMultiTaskInit", "", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onTaskBarItemExposed", "plugin-multitask_release"})
public abstract class MultiTaskUIComponent extends UIComponent implements a {
    public CustomViewPager zZC;

    public boolean Js(int i2) {
        return false;
    }

    public void a(MStorageEventData mStorageEventData) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskUIComponent(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskUIComponent(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
    }

    public void dkr() {
    }

    public void dk(Object obj) {
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public void a(View view, MultiTaskInfo multiTaskInfo, crq crq, Object obj) {
        p.h(multiTaskInfo, "info");
        p.h(crq, "animateData");
    }

    public void a(MultiTaskInfo multiTaskInfo) {
        p.h(multiTaskInfo, "info");
    }

    public void dF(Object obj) {
    }
}
