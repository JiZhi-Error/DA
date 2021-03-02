package com.tencent.mm.msgsubscription.presenter;

import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H&J\u001a\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0003H&¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter;", "", "getCheckBoxState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "loadData", "", "bizUsername", "", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "onActivityCreated", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivityStarted", "onActivityStopped", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeMsgItemInfoClick", "view", "Landroid/view/View;", "onSubscribeSwitchChanged", "on", "LoadDataListener", "plugin-comm_release"})
public interface b {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "", "onError", "", "onSuccess", "data", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "plugin-comm_release"})
    public interface a {
        void a(SubscribeMsgSettingData subscribeMsgSettingData);

        void onError();
    }

    void a(SubscribeMsgTmpItem subscribeMsgTmpItem, boolean z);

    void a(String str, a aVar);

    boolean a(SubscribeMsgTmpItem subscribeMsgTmpItem);

    void fC(boolean z);
}
