package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.page.bu;

public interface h extends f, i {

    public interface a {
        ad.b L(int i2, boolean z);

        boolean a(int i2, bu buVar, int i3);

        boolean a(int i2, float[] fArr, int i3, Boolean bool, Boolean bool2);

        boolean a(View view, int i2, int i3, float[] fArr, int i4, boolean z, boolean z2, boolean z3);

        ViewGroup bEh();

        View getRootView();

        View getViewById(int i2);

        ad.b wC(int i2);

        boolean wD(int i2);

        int wE(int i2);

        boolean wF(int i2);

        boolean wG(int i2);

        boolean wH(int i2);

        boolean wI(int i2);

        int wJ(int i2);
    }

    boolean btO();

    a gA(boolean z);

    View getContentView();

    a getCustomViewContainer();
}
