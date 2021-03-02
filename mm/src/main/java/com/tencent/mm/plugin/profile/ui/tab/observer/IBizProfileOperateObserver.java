package com.tencent.mm.plugin.profile.ui.tab.observer;

import android.arch.lifecycle.LifecycleObserver;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.f;

public interface IBizProfileOperateObserver extends LifecycleObserver {
    boolean a(f fVar, as asVar);
}
