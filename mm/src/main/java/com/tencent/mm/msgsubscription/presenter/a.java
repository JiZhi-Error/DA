package com.tencent.mm.msgsubscription.presenter;

import android.app.Activity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter;", "()V", "view", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "getView", "()Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "setView", "(Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;)V", "onActivityCreated", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivityStarted", "onActivityStopped", "onFinish", "plugin-comm_release"})
public abstract class a implements b {
    public c jAh;

    public void onActivityPaused(Activity activity) {
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
    }

    public void onActivityResumed(Activity activity) {
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
    }

    public void onActivityCreated(Activity activity) {
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
    }

    public void y(Activity activity) {
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
    }
}
