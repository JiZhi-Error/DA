package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.liteav.k;
import com.tencent.liteav.renderer.TXCFocusIndicatorView;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCloudVideoView extends FrameLayout implements View.OnTouchListener {
    private static final int FOCUS_AREA_SIZE_DP = 70;
    private static final String TAG = "TXCloudVideoView";
    private float mBottom;
    private k mCapture;
    private int mCaptureHeight;
    private int mCaptureWidth;
    private int mCurrentScale;
    protected TXDashBoard mDashBoard;
    private boolean mFocus;
    private int mFocusAreaSize;
    protected TXCFocusIndicatorView mFocusIndicatorView;
    protected TXCGLSurfaceView mGLSurfaceView;
    private float mLeft;
    private float mRight;
    private ScaleGestureDetector mScaleGestureDetector;
    private ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
    protected SurfaceView mSurfaceView;
    private float mTop;
    private a mTouchFocusRunnable;
    private String mUserId;
    protected TextureView mVideoView;
    private boolean mZoom;

    public TXCloudVideoView(Context context) {
        this(context, null);
    }

    public TXCloudVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(14245);
        this.mCaptureWidth = 0;
        this.mCaptureHeight = 0;
        this.mLeft = 0.0f;
        this.mRight = 0.0f;
        this.mTop = 0.0f;
        this.mBottom = 0.0f;
        this.mFocusAreaSize = 0;
        this.mUserId = "";
        this.mFocus = false;
        this.mZoom = false;
        this.mCurrentScale = 1;
        this.mScaleGestureDetector = null;
        this.mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener() {
            /* class com.tencent.rtmp.ui.TXCloudVideoView.AnonymousClass2 */

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                int i2;
                float f2 = 1.1f;
                AppMethodBeat.i(14244);
                int e2 = TXCloudVideoView.this.mCapture != null ? TXCloudVideoView.this.mCapture.e() : 0;
                if (e2 > 0) {
                    float scaleFactor = scaleGestureDetector.getScaleFactor();
                    if (scaleFactor > 1.0f) {
                        float f3 = ((0.2f / ((float) e2)) * ((float) (e2 - TXCloudVideoView.this.mCurrentScale))) + 1.0f;
                        if (f3 > 1.1f) {
                            f2 = f3;
                        }
                    } else if (scaleFactor < 1.0f) {
                        f2 = 1.0f - ((0.2f / ((float) e2)) * ((float) TXCloudVideoView.this.mCurrentScale));
                        if (f2 >= 0.9f) {
                            f2 = 0.9f;
                        }
                    } else {
                        f2 = scaleFactor;
                    }
                    int round = Math.round(((float) TXCloudVideoView.this.mCurrentScale) * f2);
                    if (round == TXCloudVideoView.this.mCurrentScale) {
                        if (f2 > 1.0f) {
                            round++;
                        } else if (f2 < 1.0f) {
                            round--;
                        }
                    }
                    if (round >= e2) {
                        round = e2;
                    }
                    if (round <= 1) {
                        round = 1;
                    }
                    if (f2 > 1.0f) {
                        if (round < TXCloudVideoView.this.mCurrentScale) {
                            i2 = TXCloudVideoView.this.mCurrentScale;
                        }
                        i2 = round;
                    } else {
                        if (f2 < 1.0f && round > TXCloudVideoView.this.mCurrentScale) {
                            i2 = TXCloudVideoView.this.mCurrentScale;
                        }
                        i2 = round;
                    }
                    TXCloudVideoView.this.mCurrentScale = i2;
                    if (TXCloudVideoView.this.mCapture != null) {
                        TXCloudVideoView.this.mCapture.a(TXCloudVideoView.this.mCurrentScale);
                    }
                }
                AppMethodBeat.o(14244);
                return false;
            }

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        };
        this.mTouchFocusRunnable = new a();
        this.mDashBoard = new TXDashBoard(context);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this.mScaleGestureListener);
        AppMethodBeat.o(14245);
    }

    public TXCloudVideoView(SurfaceView surfaceView) {
        this(surfaceView.getContext(), null);
        AppMethodBeat.i(14246);
        this.mSurfaceView = surfaceView;
        AppMethodBeat.o(14246);
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void addVideoView(TXCGLSurfaceView tXCGLSurfaceView) {
        AppMethodBeat.i(14247);
        if (this.mGLSurfaceView != null) {
            removeView(this.mGLSurfaceView);
        }
        this.mGLSurfaceView = tXCGLSurfaceView;
        addView(this.mGLSurfaceView);
        resetLogView();
        AppMethodBeat.o(14247);
    }

    public void addVideoView(TextureView textureView) {
        AppMethodBeat.i(14248);
        if (this.mVideoView != null) {
            removeView(this.mVideoView);
        }
        this.mVideoView = textureView;
        addView(this.mVideoView);
        resetLogView();
        AppMethodBeat.o(14248);
    }

    public void removeVideoView() {
        AppMethodBeat.i(14249);
        if (this.mVideoView != null) {
            removeView(this.mVideoView);
            this.mVideoView = null;
        }
        if (this.mGLSurfaceView != null) {
            removeView(this.mGLSurfaceView);
            this.mGLSurfaceView = null;
        }
        this.mSurfaceView = null;
        AppMethodBeat.o(14249);
    }

    public void removeFocusIndicatorView() {
        AppMethodBeat.i(14250);
        if (this.mFocusIndicatorView != null) {
            removeView(this.mFocusIndicatorView);
            this.mFocusIndicatorView = null;
        }
        AppMethodBeat.o(14250);
    }

    public void onDestroy() {
    }

    public TextureView getVideoView() {
        return this.mVideoView;
    }

    public TXCGLSurfaceView getGLSurfaceView() {
        return this.mGLSurfaceView;
    }

    public SurfaceView getSurfaceView() {
        return this.mSurfaceView;
    }

    public void setRenderMode(int i2) {
    }

    public void setRenderRotation(int i2) {
    }

    public TextureView getHWVideoView() {
        return this.mVideoView;
    }

    public void clearLastFrame(boolean z) {
        AppMethodBeat.i(14251);
        if (z) {
            setVisibility(8);
        }
        AppMethodBeat.o(14251);
    }

    public void onTouchFocus(int i2, int i3) {
        AppMethodBeat.i(14252);
        if (this.mGLSurfaceView == null) {
            AppMethodBeat.o(14252);
        } else if (i2 < 0 || i3 < 0) {
            if (this.mFocusIndicatorView != null) {
                this.mFocusIndicatorView.setVisibility(8);
            }
            AppMethodBeat.o(14252);
        } else {
            if (this.mFocusIndicatorView == null) {
                this.mFocusIndicatorView = new TXCFocusIndicatorView(getContext());
                this.mFocusIndicatorView.setVisibility(0);
                addView(this.mFocusIndicatorView);
            } else if (indexOfChild(this.mFocusIndicatorView) != getChildCount() - 1) {
                removeView(this.mFocusIndicatorView);
                addView(this.mFocusIndicatorView);
            }
            Rect touchRect = getTouchRect(i2, i3, this.mGLSurfaceView.getWidth(), this.mGLSurfaceView.getHeight(), 1.0f);
            this.mFocusIndicatorView.show(touchRect.left, touchRect.top, touchRect.right - touchRect.left);
            AppMethodBeat.o(14252);
        }
    }

    private Rect getTouchRect(int i2, int i3, int i4, int i5, float f2) {
        AppMethodBeat.i(14253);
        if (this.mFocusAreaSize == 0 && this.mGLSurfaceView != null) {
            this.mFocusAreaSize = (int) ((70.0f * this.mGLSurfaceView.getResources().getDisplayMetrics().density) + 0.5f);
        }
        int intValue = Float.valueOf(((float) this.mFocusAreaSize) * f2).intValue();
        int clamp = clamp(i2 - (intValue / 2), 0, i4 - intValue);
        int clamp2 = clamp(i3 - (intValue / 2), 0, i5 - intValue);
        Rect rect = new Rect(clamp, clamp2, clamp + intValue, intValue + clamp2);
        AppMethodBeat.o(14253);
        return rect;
    }

    private int clamp(int i2, int i3, int i4) {
        if (i2 > i4) {
            return i4;
        }
        return i2 < i3 ? i3 : i2;
    }

    public void setMirror(boolean z) {
    }

    public void disableLog(boolean z) {
        AppMethodBeat.i(14254);
        if (this.mDashBoard != null) {
            this.mDashBoard.a(z);
        }
        AppMethodBeat.o(14254);
    }

    public void showLog(boolean z) {
        AppMethodBeat.i(14255);
        if (this.mDashBoard != null) {
            this.mDashBoard.setShowLevel(z ? 2 : 0);
        }
        AppMethodBeat.o(14255);
    }

    public void clearLog() {
        AppMethodBeat.i(14256);
        if (this.mDashBoard != null) {
            this.mDashBoard.a();
        }
        AppMethodBeat.o(14256);
    }

    public void setLogText(Bundle bundle, Bundle bundle2, int i2) {
        AppMethodBeat.i(14257);
        if (this.mDashBoard != null) {
            this.mDashBoard.a(bundle, bundle2, i2);
        }
        AppMethodBeat.o(14257);
    }

    /* access modifiers changed from: protected */
    public void resetLogView() {
        AppMethodBeat.i(14258);
        if (this.mDashBoard != null) {
            removeView(this.mDashBoard);
            addView(this.mDashBoard);
        }
        AppMethodBeat.o(14258);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(14259);
        super.onLayout(z, i2, i3, i4, i5);
        updateDbMargin();
        if (this.mDashBoard != null) {
            this.mDashBoard.setStatusTextSize((float) (((double) px2dip(getContext(), (float) getWidth())) / 30.0d));
            this.mDashBoard.setEventTextSize((float) (((double) px2dip(getContext(), (float) getWidth())) / 25.0d));
        }
        if (!(this.mCaptureWidth == 0 || this.mCaptureHeight == 0)) {
            updateVideoViewSize(this.mCaptureWidth, this.mCaptureHeight);
        }
        AppMethodBeat.o(14259);
    }

    public void updateVideoViewSize(int i2, int i3) {
        View view;
        int i4;
        int width;
        FrameLayout.LayoutParams layoutParams;
        AppMethodBeat.i(14260);
        if (this.mGLSurfaceView != null) {
            view = this.mGLSurfaceView;
        } else if (this.mVideoView != null) {
            view = this.mVideoView;
        } else {
            AppMethodBeat.o(14260);
            return;
        }
        int width2 = getWidth();
        int height = getHeight();
        if (i3 == 0 || height == 0) {
            AppMethodBeat.o(14260);
            return;
        }
        this.mCaptureWidth = i2;
        this.mCaptureHeight = i3;
        float f2 = (((float) i2) * 1.0f) / ((float) i3);
        if (f2 > (((float) width2) * 1.0f) / ((float) height)) {
            height = (int) (((float) width2) / f2);
            i4 = (getHeight() - height) / 2;
            width = 0;
        } else {
            width2 = (int) (f2 * ((float) height));
            i4 = 0;
            width = (getWidth() - width2) / 2;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
            if (layoutParams.width == width2 && layoutParams.height == height) {
                AppMethodBeat.o(14260);
                return;
            } else {
                layoutParams.width = width2;
                layoutParams.height = height;
            }
        } else {
            layoutParams = new FrameLayout.LayoutParams(width2, height);
        }
        layoutParams.leftMargin = width;
        layoutParams.topMargin = i4;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(14260);
    }

    public void setDashBoardStatusInfo(CharSequence charSequence) {
        AppMethodBeat.i(14261);
        if (this.mDashBoard != null) {
            this.mDashBoard.a(charSequence);
        }
        AppMethodBeat.o(14261);
    }

    public void appendEventInfo(String str) {
        AppMethodBeat.i(14262);
        if (this.mDashBoard != null) {
            this.mDashBoard.a(str);
        }
        AppMethodBeat.o(14262);
    }

    public void showVideoDebugLog(int i2) {
        AppMethodBeat.i(14263);
        if (this.mDashBoard != null) {
            this.mDashBoard.setShowLevel(i2);
        }
        AppMethodBeat.o(14263);
    }

    public void setLogMargin(float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(14264);
        this.mLeft = f2;
        this.mRight = f3;
        this.mTop = f4;
        this.mBottom = f5;
        if (this.mDashBoard != null) {
            this.mDashBoard.a((int) this.mLeft, (int) this.mTop, (int) this.mRight, (int) this.mBottom);
        }
        AppMethodBeat.o(14264);
    }

    public void setLogMarginRatio(final float f2, final float f3, final float f4, final float f5) {
        AppMethodBeat.i(14265);
        getWidth();
        getHeight();
        postDelayed(new Runnable() {
            /* class com.tencent.rtmp.ui.TXCloudVideoView.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(14243);
                TXCloudVideoView.this.mLeft = ((float) TXCloudVideoView.this.getWidth()) * f2;
                TXCloudVideoView.this.mRight = ((float) TXCloudVideoView.this.getWidth()) * f3;
                TXCloudVideoView.this.mTop = ((float) TXCloudVideoView.this.getHeight()) * f4;
                TXCloudVideoView.this.mBottom = ((float) TXCloudVideoView.this.getHeight()) * f5;
                if (TXCloudVideoView.this.mDashBoard != null) {
                    TXCloudVideoView.this.mDashBoard.a((int) TXCloudVideoView.this.mLeft, (int) TXCloudVideoView.this.mTop, (int) TXCloudVideoView.this.mRight, (int) TXCloudVideoView.this.mBottom);
                }
                AppMethodBeat.o(14243);
            }
        }, 100);
        AppMethodBeat.o(14265);
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public static int px2dip(Context context, float f2) {
        AppMethodBeat.i(14266);
        int i2 = (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
        AppMethodBeat.o(14266);
        return i2;
    }

    private void updateDbMargin() {
        AppMethodBeat.i(14267);
        if (this.mDashBoard != null) {
            this.mDashBoard.a((int) this.mLeft, (int) this.mTop, (int) this.mRight, (int) this.mBottom);
        }
        AppMethodBeat.o(14267);
    }

    public void start(boolean z, boolean z2, k kVar) {
        AppMethodBeat.i(222662);
        this.mFocus = z;
        this.mZoom = z2;
        if (this.mFocus || this.mZoom) {
            setOnTouchListener(this);
            this.mCapture = kVar;
        }
        if (this.mGLSurfaceView != null) {
            this.mGLSurfaceView.setVisibility(0);
        }
        AppMethodBeat.o(222662);
    }

    public void stop(boolean z) {
        AppMethodBeat.i(14269);
        if (this.mFocus || this.mZoom) {
            setOnTouchListener(null);
        }
        this.mCapture = null;
        if (z && this.mGLSurfaceView != null) {
            this.mGLSurfaceView.setVisibility(8);
        }
        AppMethodBeat.o(14269);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(14270);
        if (motionEvent.getPointerCount() == 1 && motionEvent.getAction() == 0) {
            this.mTouchFocusRunnable.a(view);
            this.mTouchFocusRunnable.a(motionEvent);
            postDelayed(this.mTouchFocusRunnable, 100);
        } else if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2) {
            removeCallbacks(this.mTouchFocusRunnable);
            onTouchFocus(-1, -1);
            if (this.mScaleGestureDetector != null && this.mZoom) {
                this.mScaleGestureDetector.onTouchEvent(motionEvent);
            }
        }
        if (this.mZoom && motionEvent.getAction() == 0) {
            performClick();
        }
        boolean z = this.mZoom;
        AppMethodBeat.o(14270);
        return z;
    }

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private View f1646b;

        /* renamed from: c  reason: collision with root package name */
        private MotionEvent f1647c;

        private a() {
        }

        public void a(View view) {
            this.f1646b = view;
        }

        public void a(MotionEvent motionEvent) {
            this.f1647c = motionEvent;
        }

        public void run() {
            AppMethodBeat.i(14284);
            if (TXCloudVideoView.this.mCapture != null && TXCloudVideoView.this.mFocus) {
                TXCloudVideoView.this.mCapture.a(this.f1647c.getX() / ((float) this.f1646b.getWidth()), this.f1647c.getY() / ((float) this.f1646b.getHeight()));
            }
            if (TXCloudVideoView.this.mFocus) {
                TXCloudVideoView.this.onTouchFocus((int) this.f1647c.getX(), (int) this.f1647c.getY());
            }
            AppMethodBeat.o(14284);
        }
    }
}
