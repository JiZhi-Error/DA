package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.Platform;

public class UIPagePlatformDelegateImpl implements IUIPagePlatformDelegate {
    private Context context;

    public UIPagePlatformDelegateImpl(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformDelegate
    public Platform currentPlatform() {
        return Platform.ANDROID;
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public Context getContext() {
        return this.context;
    }
}
