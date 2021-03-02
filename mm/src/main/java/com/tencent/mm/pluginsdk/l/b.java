package com.tencent.mm.pluginsdk.l;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;

public final class b {
    public a Dqi;
    public g KaF;
    public int KaG = 0;
    private final int KaH = 5;
    private a KaI = new a(Looper.getMainLooper());
    public Context context;
    public int fileSize;
    public String filename;
    public int jqs;
    private boolean ztI = false;
    public MediaRecorder zwf;

    public b() {
        AppMethodBeat.i(31167);
        AppMethodBeat.o(31167);
    }

    static class a extends Handler {
        int lCq = 0;
        boolean ztI = false;

        public a(Looper looper) {
            super(looper);
        }

        @TargetApi(8)
        public final void handleMessage(Message message) {
            AppMethodBeat.i(31166);
            Camera camera = (Camera) message.obj;
            Camera.Parameters parameters = camera.getParameters();
            int zoom = parameters.getZoom() + this.lCq;
            if (this.ztI) {
                if (zoom >= parameters.getMaxZoom() / 2) {
                    zoom = parameters.getMaxZoom() / 2;
                } else {
                    sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
                }
            } else if (zoom <= 0) {
                zoom = 0;
            } else {
                sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
            AppMethodBeat.o(31166);
        }
    }

    @TargetApi(9)
    public void setOrientationHint(final int i2) {
        AppMethodBeat.i(31168);
        com.tencent.mm.compatible.a.a.a(9, new a.AbstractC0298a() {
            /* class com.tencent.mm.pluginsdk.l.b.AnonymousClass1 */

            @Override // com.tencent.mm.compatible.a.a.AbstractC0298a
            public final void run() {
                AppMethodBeat.i(31165);
                if (b.this.zwf != null) {
                    b.this.zwf.setOrientationHint(i2);
                }
                AppMethodBeat.o(31165);
            }
        });
        AppMethodBeat.o(31168);
    }

    public final int d(Activity activity, boolean z) {
        AppMethodBeat.i(31169);
        this.context = activity;
        int a2 = this.KaF.a(activity, this.Dqi, z);
        if (a2 != 0) {
            AppMethodBeat.o(31169);
            return a2;
        }
        AppMethodBeat.o(31169);
        return 0;
    }

    public final int goi() {
        AppMethodBeat.i(31170);
        this.KaF.ejx();
        AppMethodBeat.o(31170);
        return 0;
    }

    public final int b(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(31171);
        int b2 = this.KaF.b(surfaceHolder);
        AppMethodBeat.o(31171);
        return b2;
    }

    public final int getPreviewWidth() {
        AppMethodBeat.i(31172);
        if (this.KaF.gGr.gII == null) {
            AppMethodBeat.o(31172);
            return 0;
        }
        int i2 = this.KaF.gGr.gII.getParameters().getPreviewSize().width;
        AppMethodBeat.o(31172);
        return i2;
    }

    public final int getPreviewHeight() {
        AppMethodBeat.i(31173);
        if (this.KaF.gGr.gII == null) {
            AppMethodBeat.o(31173);
            return 0;
        }
        int i2 = this.KaF.gGr.gII.getParameters().getPreviewSize().height;
        AppMethodBeat.o(31173);
        return i2;
    }
}
