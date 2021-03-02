package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Size;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class MMSightRecordView extends FrameLayout {
    public static b zsY;
    public e zsX;

    public interface a {
        void C(byte[] bArr, int i2, int i3);
    }

    public interface b {
        e bqH();
    }

    public interface c {
        void bFX();
    }

    public interface d {
        void bFW();
    }

    public static abstract class e {
        public abstract void a(Context context, ViewGroup viewGroup, SurfaceTexture surfaceTexture, int i2, int i3);

        public abstract void a(g gVar, boolean z);

        public abstract void a(h hVar);

        public abstract void a(ByteBuffer byteBuffer, f fVar);

        public abstract boolean aD(float f2);

        public abstract boolean aai();

        public abstract void b(Context context, ViewGroup viewGroup);

        public abstract void bqI();

        public abstract void bqN();

        public abstract void bqO();

        public abstract int getCameraRotation();

        public abstract Bitmap getCurrentFramePicture();

        public abstract Point getDrawSizePoint();

        public abstract int getFlashMode();

        public abstract Point getPictureSize();

        public abstract Point getPreviewSize();

        public abstract float[] getSupportZoomMultiple();

        public abstract String getVideoFilePath();

        public abstract Point getVideoSize();

        public abstract void o(MotionEvent motionEvent);

        public abstract void release();

        public abstract void setClipPictureSize(boolean z);

        public abstract void setClipVideoSize(boolean z);

        public abstract void setDisplayRatio(float f2);

        public abstract void setDisplayScreenSize(Size size);

        public abstract void setEnableDragZoom(boolean z);

        public abstract void setEnableTouchFocus(boolean z);

        public abstract void setFlashMode(int i2);

        public abstract void setFrameDataCallback(a aVar);

        public abstract void setInitDoneCallback(c cVar);

        public abstract void setInitErrorCallback(d dVar);

        public abstract void setPreviewMode(int i2);

        public abstract void setPreviewSizeLimit(int i2);

        public abstract void setRGBSizeLimit(int i2);

        public abstract void setUseBackCamera(boolean z);

        public abstract void setVideoFilePath(String str);

        public abstract void setVideoPara$2e715812(int i2);

        public abstract void startPreview();

        public abstract void switchCamera();
    }

    public interface f {
        void bGa();
    }

    public interface g {
        void R(Bitmap bitmap);

        void bFZ();
    }

    public interface h {
        void hs(boolean z);
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(148788);
        init(context);
        AppMethodBeat.o(148788);
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(148789);
        init(context);
        AppMethodBeat.o(148789);
    }

    public MMSightRecordView(Context context) {
        super(context);
        AppMethodBeat.i(148790);
        init(context);
        AppMethodBeat.o(148790);
    }

    public MMSightRecordView(Context context, SurfaceTexture surfaceTexture, int i2, int i3) {
        super(context);
        AppMethodBeat.i(148791);
        this.zsX = zsY.bqH();
        this.zsX.a(context, this, surfaceTexture, i2, i3);
        AppMethodBeat.o(148791);
    }

    private void init(Context context) {
        AppMethodBeat.i(148792);
        this.zsX = zsY.bqH();
        this.zsX.b(context, this);
        AppMethodBeat.o(148792);
    }

    public void setInitErrorCallback(d dVar) {
        AppMethodBeat.i(148793);
        this.zsX.setInitErrorCallback(dVar);
        AppMethodBeat.o(148793);
    }

    public void setInitDoneCallback(c cVar) {
        AppMethodBeat.i(148794);
        this.zsX.setInitDoneCallback(cVar);
        AppMethodBeat.o(148794);
    }

    public void setDisplayRatio(float f2) {
        AppMethodBeat.i(148795);
        this.zsX.setDisplayRatio(f2);
        AppMethodBeat.o(148795);
    }

    public void setPreviewSizeLimit(int i2) {
        AppMethodBeat.i(148796);
        this.zsX.setPreviewSizeLimit(i2);
        AppMethodBeat.o(148796);
    }

    public void setPreviewMode(int i2) {
        AppMethodBeat.i(148797);
        this.zsX.setPreviewMode(i2);
        AppMethodBeat.o(148797);
    }

    public final void setVideoPara$2e715812(int i2) {
        AppMethodBeat.i(148798);
        this.zsX.setVideoPara$2e715812(i2);
        AppMethodBeat.o(148798);
    }

    public void setVideoFilePath(String str) {
        AppMethodBeat.i(148799);
        this.zsX.setVideoFilePath(str);
        AppMethodBeat.o(148799);
    }

    public String getVideoFilePath() {
        AppMethodBeat.i(148800);
        String videoFilePath = this.zsX.getVideoFilePath();
        AppMethodBeat.o(148800);
        return videoFilePath;
    }

    public final void a(h hVar) {
        AppMethodBeat.i(148801);
        this.zsX.a(hVar);
        AppMethodBeat.o(148801);
    }

    public final void a(g gVar, boolean z) {
        AppMethodBeat.i(148802);
        this.zsX.a(gVar, z);
        AppMethodBeat.o(148802);
    }

    public void setUseBackCamera(boolean z) {
        AppMethodBeat.i(148803);
        this.zsX.setUseBackCamera(z);
        AppMethodBeat.o(148803);
    }

    public Point getPictureSize() {
        AppMethodBeat.i(148804);
        Point pictureSize = this.zsX.getPictureSize();
        AppMethodBeat.o(148804);
        return pictureSize;
    }

    public Point getVideoSize() {
        AppMethodBeat.i(148805);
        Point videoSize = this.zsX.getVideoSize();
        AppMethodBeat.o(148805);
        return videoSize;
    }

    public Point getPreviewSize() {
        AppMethodBeat.i(148806);
        Point previewSize = this.zsX.getPreviewSize();
        AppMethodBeat.o(148806);
        return previewSize;
    }

    public Point getDrawSizePoint() {
        AppMethodBeat.i(148807);
        Point drawSizePoint = this.zsX.getDrawSizePoint();
        AppMethodBeat.o(148807);
        return drawSizePoint;
    }

    public void setFrameDataCallback(a aVar) {
        AppMethodBeat.i(148808);
        this.zsX.setFrameDataCallback(aVar);
        AppMethodBeat.o(148808);
    }

    public int getCameraRotation() {
        AppMethodBeat.i(148809);
        int cameraRotation = this.zsX.getCameraRotation();
        AppMethodBeat.o(148809);
        return cameraRotation;
    }

    public void setClipVideoSize(boolean z) {
        AppMethodBeat.i(148810);
        this.zsX.setClipVideoSize(z);
        AppMethodBeat.o(148810);
    }

    public void setClipPictureSize(boolean z) {
        AppMethodBeat.i(148811);
        this.zsX.setClipPictureSize(z);
        AppMethodBeat.o(148811);
    }

    public void setFlashMode(int i2) {
        AppMethodBeat.i(148812);
        this.zsX.setFlashMode(i2);
        AppMethodBeat.o(148812);
    }

    public int getFlashMode() {
        AppMethodBeat.i(148813);
        int flashMode = this.zsX.getFlashMode();
        AppMethodBeat.o(148813);
        return flashMode;
    }

    public void setEnableDragZoom(boolean z) {
        AppMethodBeat.i(148814);
        this.zsX.setEnableDragZoom(z);
        AppMethodBeat.o(148814);
    }

    public float[] getSupportZoomMultiple() {
        AppMethodBeat.i(148815);
        float[] supportZoomMultiple = this.zsX.getSupportZoomMultiple();
        AppMethodBeat.o(148815);
        return supportZoomMultiple;
    }

    public void setEnableTouchFocus(boolean z) {
        AppMethodBeat.i(148816);
        this.zsX.setEnableTouchFocus(z);
        AppMethodBeat.o(148816);
    }

    public void setRGBSizeLimit(int i2) {
        AppMethodBeat.i(148817);
        this.zsX.setRGBSizeLimit(i2);
        AppMethodBeat.o(148817);
    }

    public void setDisplayScreenSize(Size size) {
        AppMethodBeat.i(240832);
        this.zsX.setDisplayScreenSize(size);
        AppMethodBeat.o(240832);
    }

    public Bitmap getCurrentFramePicture() {
        AppMethodBeat.i(148818);
        Bitmap currentFramePicture = this.zsX.getCurrentFramePicture();
        AppMethodBeat.o(148818);
        return currentFramePicture;
    }

    public final void a(ByteBuffer byteBuffer, f fVar) {
        AppMethodBeat.i(148819);
        this.zsX.a(byteBuffer, fVar);
        AppMethodBeat.o(148819);
    }
}
