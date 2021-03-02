package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    ValueAnimator animator;
    float progress = 0.0f;
    float zEA = 0.0f;
    float zEB = 0.0f;
    float zEC = 0.0f;
    Path zED;
    private Paint zEE = null;
    a zEp;
    a zEq;
    boolean zEr = false;
    public a zEs;
    PointF zEt;
    PointF zEu;
    PointF zEv;
    PointF zEw;
    PointF zEx;
    PointF zEy;
    float zEz = 0.0f;

    public interface a {
        void a(a aVar);

        void elf();
    }

    public b(a aVar, a aVar2, a aVar3) {
        AppMethodBeat.i(94797);
        this.zEp = aVar;
        this.zEq = aVar2;
        this.zEs = aVar3;
        this.zEA = ((float) MMSightProgressBar.rLp) * 2.0f;
        this.zEB = ((float) (-MMSightProgressBar.rLp)) * 0.5f;
        this.zED = new Path();
        this.zEE = new Paint();
        this.zEE.setAntiAlias(true);
        this.zEE.setStyle(Paint.Style.FILL);
        AppMethodBeat.o(94797);
    }
}
