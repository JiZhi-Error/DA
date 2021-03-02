package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.view.View;

public interface c<T> {
    T currentValue();

    View getView();

    void onAttach(com.tencent.mm.plugin.appbrand.widget.picker.c cVar);

    void onDetach(com.tencent.mm.plugin.appbrand.widget.picker.c cVar);

    void onHide(com.tencent.mm.plugin.appbrand.widget.picker.c cVar);

    void onShow(com.tencent.mm.plugin.appbrand.widget.picker.c cVar);
}
