package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

public final class MMThumbPlayerTextureView extends MMTextureView {
    private static final int GiA = 2;
    private static final int GiB = 3;
    public static final a GiC = new a((byte) 0);
    private static final int Giy;
    private static final int Giz = 1;
    private int Git;
    public float Giu;
    public float Giv;
    private TextureView.SurfaceTextureListener Giw;
    private final b Gix = new b(this);
    private Rect iiw = new Rect();
    private int scaleType = Giy;
    private int videoHeight;
    private int videoWidth;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(238818);
        AppMethodBeat.o(238818);
    }

    public MMThumbPlayerTextureView(Context context) {
        super(context);
        AppMethodBeat.i(238815);
        initView();
        AppMethodBeat.o(238815);
    }

    public MMThumbPlayerTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(238816);
        initView();
        AppMethodBeat.o(238816);
    }

    public MMThumbPlayerTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(238817);
        initView();
        AppMethodBeat.o(238817);
    }

    private final void initView() {
        AppMethodBeat.i(238807);
        setOpaque(false);
        setAlpha(0.0f);
        setScaleX(1.0001f);
        setScaleY(1.0001f);
        setSurfaceTextureListener(this.Gix);
        AppMethodBeat.o(238807);
    }

    public static final class b implements TextureView.SurfaceTextureListener {
        final /* synthetic */ MMThumbPlayerTextureView GiD;

        b(MMThumbPlayerTextureView mMThumbPlayerTextureView) {
            this.GiD = mMThumbPlayerTextureView;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(238803);
            p.h(surfaceTexture, "surface");
            TextureView.SurfaceTextureListener surfaceTextureListener = this.GiD.Giw;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
                AppMethodBeat.o(238803);
                return;
            }
            AppMethodBeat.o(238803);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(238804);
            p.h(surfaceTexture, "surface");
            TextureView.SurfaceTextureListener surfaceTextureListener = this.GiD.Giw;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
            }
            AppMethodBeat.o(238804);
            return false;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(238805);
            p.h(surfaceTexture, "surface");
            TextureView.SurfaceTextureListener surfaceTextureListener = this.GiD.Giw;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
                AppMethodBeat.o(238805);
                return;
            }
            AppMethodBeat.o(238805);
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(238806);
            p.h(surfaceTexture, "surface");
            TextureView.SurfaceTextureListener surfaceTextureListener = this.GiD.Giw;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
                AppMethodBeat.o(238806);
                return;
            }
            AppMethodBeat.o(238806);
        }
    }

    public final void setCropRect(Rect rect) {
        AppMethodBeat.i(238808);
        p.h(rect, "cropRect");
        this.iiw = rect;
        Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "setCropRect, cropRect:".concat(String.valueOf(rect)));
        AppMethodBeat.o(238808);
    }

    public final void reset() {
        AppMethodBeat.i(260013);
        Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "reset cropRect=" + this.iiw);
        this.iiw = new Rect();
        AppMethodBeat.o(260013);
    }

    public final void setScaleType(int i2) {
        AppMethodBeat.i(238809);
        Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "setScaleType, scaleType:".concat(String.valueOf(i2)));
        this.scaleType = i2;
        AppMethodBeat.o(238809);
    }

    public final int getScaleType() {
        return this.scaleType;
    }

    public final void jk(int i2, int i3) {
        AppMethodBeat.i(238810);
        Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "setVideoWidthAndHeight videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight + ", width:" + i2 + ", height:" + i3 + " scaleType:" + this.scaleType);
        if (this.videoWidth == i2 && this.videoHeight == i3) {
            this.videoWidth = i2;
            this.videoHeight = i3;
            AppMethodBeat.o(238810);
            return;
        }
        this.videoWidth = i2;
        this.videoHeight = i3;
        requestLayout();
        AppMethodBeat.o(238810);
    }

    public final void setOpaqueInfo(boolean z) {
        AppMethodBeat.i(238811);
        if (z) {
            setOpaque(true);
            setAlpha(1.0f);
            AppMethodBeat.o(238811);
            return;
        }
        setOpaque(false);
        setAlpha(0.0f);
        AppMethodBeat.o(238811);
    }

    public final void setTextureListenerCallback(TextureView.SurfaceTextureListener surfaceTextureListener) {
        AppMethodBeat.i(238812);
        p.h(surfaceTextureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.Giw = surfaceTextureListener;
        AppMethodBeat.o(238812);
    }

    private final void jl(int i2, int i3) {
        AppMethodBeat.i(238814);
        Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "centerCrop, container:[" + i2 + ", " + i3 + ']');
        float f2 = ((float) i2) / ((float) this.videoWidth);
        float f3 = ((float) i3) / ((float) this.videoHeight);
        float max = Math.max(f2, f3);
        float f4 = max / f2;
        float f5 = max / f3;
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f5, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
        Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "centerCrop matrix:".concat(String.valueOf(matrix)));
        setTransform(matrix);
        AppMethodBeat.o(238814);
    }

    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(238813);
        if (this.videoWidth == 0 || this.videoHeight == 0) {
            setMeasuredDimension(1, 1);
            AppMethodBeat.o(238813);
            return;
        }
        int defaultSize = MMTextureView.getDefaultSize(1, i2);
        int defaultSize2 = MMTextureView.getDefaultSize(1, i3);
        int i4 = this.scaleType;
        if (i4 == Giy) {
            jl(defaultSize, defaultSize2);
        } else if (i4 == Giz) {
            float f2 = ((float) defaultSize) / ((float) this.videoWidth);
            float f3 = ((float) defaultSize2) / ((float) this.videoHeight);
            float min = Math.min(f2, f3);
            float f4 = min / f2;
            float f5 = min / f3;
            Matrix matrix = new Matrix();
            matrix.setScale(f4, f5, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
            setTransform(matrix);
        } else if (i4 != GiB) {
            setTransform(new Matrix());
        } else if (!this.iiw.isEmpty()) {
            Rect rect = this.iiw;
            if (!(this.Giu == 0.0f || this.Giv == 0.0f || rect.isEmpty())) {
                float width = ((float) defaultSize) / ((float) rect.width());
                float height = ((float) defaultSize2) / ((float) rect.height());
                float f6 = ((float) defaultSize) / this.Giu;
                float f7 = ((float) defaultSize2) / this.Giv;
                float max = Math.max(f6, f7);
                float centerX = width * ((this.Giu / 2.0f) - ((float) rect.centerX()));
                float centerY = ((this.Giv / 2.0f) - ((float) rect.centerY())) * height;
                Matrix matrix2 = new Matrix();
                matrix2.setScale(max / f6, max / f7, ((float) defaultSize) / 2.0f, ((float) defaultSize2) / 2.0f);
                matrix2.postTranslate(centerX, centerY);
                Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "cropRect(), containerWidth:" + defaultSize + " containerHeight:" + defaultSize2 + ' ' + matrix2);
                setTransform(matrix2);
            }
        } else {
            jl(defaultSize, defaultSize2);
        }
        if (this.Git == 90 || this.Git == 270) {
            Matrix matrix3 = new Matrix();
            matrix3.set(getMatrix());
            float f8 = ((float) defaultSize) / 2.0f;
            float f9 = ((float) defaultSize2) / 2.0f;
            float f10 = ((float) defaultSize2) / ((float) defaultSize);
            if (!(getScaleX() == 1.0f && getScaleY() == 1.0f)) {
                matrix3.setScale(getScaleX(), getScaleY(), f8, f9);
            }
            matrix3.postRotate((float) this.Git, f8, f9);
            matrix3.postScale(1.0f / f10, f10, f8, f9);
            setTransform(matrix3);
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "onMeasure#handleOnMeasureLikeMM video size[" + this.videoWidth + ' ' + this.videoHeight + "] spec[" + MMTextureView.getDefaultSize(1, i2) + ", " + MMTextureView.getDefaultSize(1, i3) + "] result=" + defaultSize + ',' + defaultSize2);
        AppMethodBeat.o(238813);
    }
}
