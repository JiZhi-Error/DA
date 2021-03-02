package com.tencent.tmediacodec.hook;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.g.b;

public class THookTextureView extends TextureView {
    private static a Smn;
    private TextureView.SurfaceTextureListener Smo;
    private TextureView.SurfaceTextureListener Smp;

    public interface a {
        boolean u(SurfaceTexture surfaceTexture);
    }

    public static void setHookCallback(a aVar) {
        Smn = aVar;
    }

    public THookTextureView(Context context) {
        this(context, null, 0);
    }

    public THookTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public THookTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(190143);
        this.Smp = new TextureView.SurfaceTextureListener() {
            /* class com.tencent.tmediacodec.hook.THookTextureView.AnonymousClass1 */

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(190139);
                if (THookTextureView.this.Smo != null) {
                    THookTextureView.this.Smo.onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
                }
                AppMethodBeat.o(190139);
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(190140);
                if (THookTextureView.this.Smo != null) {
                    THookTextureView.this.Smo.onSurfaceTextureUpdated(surfaceTexture);
                }
                AppMethodBeat.o(190140);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                boolean z = true;
                AppMethodBeat.i(190141);
                boolean z2 = THookTextureView.this.Smo == null || THookTextureView.this.Smo.onSurfaceTextureDestroyed(surfaceTexture);
                if (THookTextureView.Smn != null) {
                    if (!z2 || !THookTextureView.Smn.u(surfaceTexture)) {
                        z = false;
                    }
                    new StringBuilder().append(this).append("onSurfaceTextureDestroyed surfaceTexture:").append(surfaceTexture).append(" hookResult:").append(z).append("result:").append(z2);
                    b.bqQ("THookTextureView");
                    AppMethodBeat.o(190141);
                    return z;
                }
                new StringBuilder().append(this).append(", onSurfaceTextureDestroyed surfaceTexture:").append(surfaceTexture).append(" result:").append(z2);
                b.bqQ("THookTextureView");
                AppMethodBeat.o(190141);
                return z2;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(190142);
                if (THookTextureView.this.Smo != null) {
                    THookTextureView.this.Smo.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
                }
                AppMethodBeat.o(190142);
            }
        };
        setSurfaceTextureListener(null);
        AppMethodBeat.o(190143);
    }

    public final void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        AppMethodBeat.i(190144);
        this.Smo = surfaceTextureListener;
        super.setSurfaceTextureListener(this.Smp);
        AppMethodBeat.o(190144);
    }
}
