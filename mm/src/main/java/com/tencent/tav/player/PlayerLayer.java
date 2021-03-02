package com.tencent.tav.player;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PlayerLayer {
    private boolean needReleaseSurface = false;
    private Player player;
    private boolean readyForDisplay;
    private PlayerLayerReadyListener readyListener = null;
    Surface surface;
    int surfaceHeight;
    int surfaceWidth;
    private int videoGravity;
    private Rect videoRect;

    public interface PlayerLayerReadyListener {
        void finish(PlayerLayer playerLayer);
    }

    public PlayerLayer(Surface surface2, int i2, int i3) {
        this.surface = surface2;
        this.surfaceWidth = i2;
        this.surfaceHeight = i3;
    }

    public PlayerLayer(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(218618);
        this.surface = new Surface(surfaceTexture);
        this.needReleaseSurface = true;
        this.surfaceWidth = i2;
        this.surfaceHeight = i3;
        AppMethodBeat.o(218618);
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player2) {
        AppMethodBeat.i(218619);
        this.player = player2;
        if (player2 != null) {
            player2.bindLayer(this);
        }
        AppMethodBeat.o(218619);
    }

    public boolean isReadyForDisplay() {
        return this.readyForDisplay;
    }

    public Rect getVideoRect() {
        return this.videoRect;
    }

    public int getVideoGravity() {
        return this.videoGravity;
    }

    public void setVideoGravity(int i2) {
        this.videoGravity = i2;
    }

    public int getSurfaceWidth() {
        return this.surfaceWidth;
    }

    public int getSurfaceHeight() {
        return this.surfaceHeight;
    }

    public Surface getSurface() {
        return this.surface;
    }

    public void setReadyForDisplay(PlayerLayerReadyListener playerLayerReadyListener) {
        this.readyListener = playerLayerReadyListener;
    }

    /* access modifiers changed from: package-private */
    public void release() {
        AppMethodBeat.i(218620);
        if (this.needReleaseSurface) {
            this.surface.release();
        }
        AppMethodBeat.o(218620);
    }
}
