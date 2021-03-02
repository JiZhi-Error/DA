package com.tencent.mm.plugin.multitalk.b;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;
import java.util.Timer;

public final class v extends MMTextureView implements TextureView.SurfaceTextureListener, c {
    protected MMHandler kAn;
    private boolean ltv;
    private Timer mTimer;
    private int mViewId;
    private String qso;
    private int qsp;

    @Override // com.tencent.mm.plugin.multitalk.b.c
    public final void ES(int i2) {
        AppMethodBeat.i(239321);
        if (i2 == this.qsp) {
            AppMethodBeat.o(239321);
            return;
        }
        Log.i("MicroMsg.Multitalk.ILinkVideoView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:[" + this.qsp + "->" + i2 + "]");
        this.qsp = i2;
        AppMethodBeat.o(239321);
    }

    public final int getViewId() {
        return this.mViewId;
    }

    public final int getMemberId() {
        return this.qsp;
    }

    public final String getOpenId() {
        return this.qso;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(239322);
        Log.i("MicroMsg.Multitalk.ILinkVideoView", "onSurfaceTextureAvailable, surface:" + (surfaceTexture == null ? "isNull" : "nonNull") + ", viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp + ", width:" + i2 + ", height:" + i3);
        gLi();
        try {
            Canvas lockCanvas = lockCanvas();
            lockCanvas.drawColor(WebView.NIGHT_MODE_COLOR);
            unlockCanvasAndPost(lockCanvas);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Multitalk.ILinkVideoView", e2, "drawColor for background, unlockCanvasAndPost crash", new Object[0]);
        }
        synchronized (this) {
            try {
                this.ltv = true;
            } finally {
                AppMethodBeat.o(239322);
            }
        }
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(239323);
        Log.i("MicroMsg.Multitalk.ILinkVideoView", "onSurfaceTextureSizeChanged, viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp + ", width:" + i2 + ", height:" + i3);
        AppMethodBeat.o(239323);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(239324);
        Log.i("MicroMsg.Multitalk.ILinkVideoView", "onSurfaceTextureDestroyed, viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp);
        synchronized (this) {
            try {
                this.ltv = false;
            } finally {
                AppMethodBeat.o(239324);
            }
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        if (this.kAn != null) {
            this.kAn.removeCallbacksAndMessages(null);
        }
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private static int k(byte b2) {
        return (((b2 >> 4) & 15) * 16) + (b2 & 15);
    }

    public static int[] Z(byte[] bArr, int i2) {
        AppMethodBeat.i(239325);
        if (i2 == 0) {
            AppMethodBeat.o(239325);
            return null;
        }
        int i3 = i2 / 4;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int k = k(bArr[i4 * 4]);
            int k2 = k(bArr[(i4 * 4) + 1]);
            int i5 = k2 << 8;
            iArr[i4] = k | i5 | (k(bArr[(i4 * 4) + 2]) << 16) | (k(bArr[(i4 * 4) + 3]) << 24);
        }
        AppMethodBeat.o(239325);
        return iArr;
    }
}
