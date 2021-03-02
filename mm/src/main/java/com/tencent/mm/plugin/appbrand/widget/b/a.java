package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.u.b;

public interface a extends f, b, c, d {
    ad.b getKeyValueSet();

    View getView();

    void setKeyValueSet(ad.b bVar);
}
