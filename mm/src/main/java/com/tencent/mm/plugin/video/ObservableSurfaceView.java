package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class ObservableSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private a GwQ = null;
    protected boolean GwR = false;
    protected boolean GwS = false;
    protected boolean GwT = false;
    protected SurfaceHolder laL;

    public ObservableSurfaceView(Context context) {
        super(context);
        AppMethodBeat.i(127126);
        init();
        AppMethodBeat.o(127126);
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(127127);
        init();
        AppMethodBeat.o(127127);
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(127128);
        init();
        AppMethodBeat.o(127128);
    }

    private void init() {
        AppMethodBeat.i(127129);
        this.laL = getHolder();
        this.laL.addCallback(this);
        AppMethodBeat.o(127129);
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.laL;
    }

    public void setNeedSetType(boolean z) {
        AppMethodBeat.i(127130);
        this.GwT = z;
        if (this.GwT) {
            this.laL.setType(3);
        }
        AppMethodBeat.o(127130);
    }

    public void setSurfaceChangeCallback(a aVar) {
        AppMethodBeat.i(127131);
        this.GwQ = aVar;
        if (this.GwT) {
            this.laL.setType(3);
        }
        AppMethodBeat.o(127131);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.GwR = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        AppMethodBeat.i(127132);
        Log.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
        this.GwS = true;
        try {
            this.laL.removeCallback(this);
        } catch (Exception e2) {
        }
        this.laL = surfaceHolder;
        this.laL.addCallback(this);
        if (this.GwQ != null) {
            this.GwQ.a(this.laL);
        }
        AppMethodBeat.o(127132);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.GwR = false;
        this.GwS = false;
    }

    public final boolean fAP() {
        return this.GwR;
    }
}
