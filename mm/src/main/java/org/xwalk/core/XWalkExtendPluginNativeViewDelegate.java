package org.xwalk.core;

import android.content.Context;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

public abstract class XWalkExtendPluginNativeViewDelegate {
    private WeakReference<XWalkExtendPluginNativeViewClient> mClient;

    public abstract Context getContext();

    public abstract void onCreate(int i2, int i3);

    public abstract void onDestroy();

    public abstract void onSizeChanged(int i2, int i3);

    public void setClient(XWalkExtendPluginNativeViewClient xWalkExtendPluginNativeViewClient) {
        this.mClient = new WeakReference<>(xWalkExtendPluginNativeViewClient);
    }

    public FrameLayout getRootView() {
        if (this.mClient.get() != null) {
            return this.mClient.get().getRootView();
        }
        return null;
    }
}
