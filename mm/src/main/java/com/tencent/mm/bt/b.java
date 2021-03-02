package com.tencent.mm.bt;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.h;
import com.tencent.mm.api.j;
import com.tencent.mm.api.r;
import com.tencent.mm.api.u;
import com.tencent.mm.api.z;
import com.tencent.mm.cache.f;
import com.tencent.mm.e.a;

public interface b {
    boolean R(MotionEvent motionEvent);

    boolean Ul();

    f a(a aVar);

    void a(Editable editable, int i2, int i3);

    void a(ab.a aVar);

    void a(u uVar, boolean z);

    void a(com.tencent.mm.view.a aVar);

    void ate();

    <T extends com.tencent.mm.e.b> T c(h hVar);

    void c(r rVar);

    void cW(float f2);

    ab.a getConfig();

    float getCurScale();

    h[] getFeatures();

    float getInitScale();

    z getSelectedFeatureListener();

    boolean gte();

    void gtf();

    void gtg();

    com.tencent.mm.view.a gth();

    <T extends com.tencent.mm.e.b> T gti();

    float gtk();

    void gtl();

    Bitmap gtm();

    boolean gtn();

    void onAttachedToWindow();

    void onDestroy();

    void onDraw(Canvas canvas);

    void onExit();

    void onFinish();

    void setActionBarCallback(j jVar);

    void setAutoShowFooterAndBar(boolean z);

    void setInitScale(float f2);

    void setOutputSize(int i2, int i3);
}
