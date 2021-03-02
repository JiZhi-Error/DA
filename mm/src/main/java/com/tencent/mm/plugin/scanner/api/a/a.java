package com.tencent.mm.plugin.scanner.api.a;

import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.scanner.api.d;
import com.tencent.mm.plugin.scanner.api.e;

public interface a {
    boolean It(long j2);

    long a(e eVar, d dVar, c cVar);

    void eN(View view);

    void eO(View view);

    boolean eOV();

    void onConfigurationChanged(Configuration configuration);

    boolean onDoubleTap(MotionEvent motionEvent);

    void release();
}
