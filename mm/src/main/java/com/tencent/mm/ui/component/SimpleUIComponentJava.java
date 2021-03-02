package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.view.View;

public abstract class SimpleUIComponentJava extends ViewModel {
    /* access modifiers changed from: protected */
    public abstract View getFindIdDelegateView();

    public <T extends View> T findViewById(int i2) {
        View findIdDelegateView = getFindIdDelegateView();
        if (findIdDelegateView == null) {
            return null;
        }
        return (T) findIdDelegateView.findViewById(i2);
    }
}
