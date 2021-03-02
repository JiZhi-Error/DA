package org.xwalk.core;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.ColorDrawable;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.widget.FrameLayout;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkExtendPluginNativeViewClient {
    private static final String TAG = "XWalkExtendPluginNativeViewClient";
    private Context mContext;
    private XWalkExtendPluginNativeViewDelegate mDelegate;
    private int mHeight;
    private NativeViewPresentation mNativeViewPresentation;
    private FrameLayout mRootView;
    private Surface mSurface = new Surface(this.mSurfaceTexture);
    private SurfaceTexture mSurfaceTexture;
    private VirtualDisplay mVirtualDisplay;
    private int mWidth;

    public XWalkExtendPluginNativeViewClient(Context context, SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(183758);
        this.mContext = context;
        this.mSurfaceTexture = surfaceTexture;
        this.mWidth = i2;
        this.mHeight = i3;
        AppMethodBeat.o(183758);
    }

    public void setDelegate(XWalkExtendPluginNativeViewDelegate xWalkExtendPluginNativeViewDelegate) {
        AppMethodBeat.i(183759);
        this.mDelegate = xWalkExtendPluginNativeViewDelegate;
        if (xWalkExtendPluginNativeViewDelegate != null) {
            this.mRootView = new FrameLayout(xWalkExtendPluginNativeViewDelegate.getContext());
            refresh(false);
        }
        AppMethodBeat.o(183759);
    }

    public Context getContext() {
        AppMethodBeat.i(183760);
        if (this.mDelegate != null) {
            Context context = this.mDelegate.getContext();
            AppMethodBeat.o(183760);
            return context;
        }
        Log.e(TAG, "no context");
        AppMethodBeat.o(183760);
        return null;
    }

    public void onSizeChanged(int i2, int i3) {
        AppMethodBeat.i(183761);
        if (this.mDelegate != null) {
            this.mDelegate.onSizeChanged(i2, i3);
        }
        if (!(this.mWidth == i2 && this.mHeight == i3)) {
            this.mWidth = i2;
            this.mHeight = i3;
            refresh(false);
        }
        AppMethodBeat.o(183761);
    }

    public void dispose() {
        AppMethodBeat.i(183762);
        if (this.mDelegate != null) {
            this.mDelegate.onDestroy();
        }
        if (this.mNativeViewPresentation != null) {
            this.mNativeViewPresentation.cancel();
            this.mNativeViewPresentation.detach();
        }
        if (this.mVirtualDisplay != null) {
            this.mVirtualDisplay.release();
        }
        AppMethodBeat.o(183762);
    }

    public FrameLayout getRootView() {
        return this.mRootView;
    }

    private void refresh(boolean z) {
        AppMethodBeat.i(183763);
        if (this.mNativeViewPresentation != null) {
            this.mNativeViewPresentation.detach();
        }
        if (this.mVirtualDisplay != null) {
            this.mVirtualDisplay.setSurface(null);
            this.mVirtualDisplay.release();
        }
        this.mSurfaceTexture.setDefaultBufferSize(this.mWidth, this.mHeight);
        this.mVirtualDisplay = ((DisplayManager) getContext().getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY)).createVirtualDisplay("xweb-vd" + hashCode(), this.mWidth, this.mHeight, getContext().getResources().getDisplayMetrics().densityDpi, this.mSurface, 0);
        this.mNativeViewPresentation = new NativeViewPresentation(getContext(), this.mVirtualDisplay.getDisplay(), false, this);
        this.mNativeViewPresentation.show();
        AppMethodBeat.o(183763);
    }

    /* access modifiers changed from: package-private */
    @Keep
    @TargetApi(17)
    public class NativeViewPresentation extends Presentation {
        private XWalkExtendPluginNativeViewClient mClient;
        private FrameLayout mContentView;
        private boolean mStartFocused = false;

        public NativeViewPresentation(Context context, Display display, boolean z, XWalkExtendPluginNativeViewClient xWalkExtendPluginNativeViewClient) {
            super(context, display);
            AppMethodBeat.i(183755);
            getWindow().setFlags(8, 8);
            this.mStartFocused = z;
            this.mClient = xWalkExtendPluginNativeViewClient;
            AppMethodBeat.o(183755);
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle bundle) {
            AppMethodBeat.i(183756);
            super.onCreate(bundle);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            XWalkExtendPluginNativeViewClient.this.mRootView = new FrameLayout(getContext());
            if (this.mContentView != null) {
                if (this.mStartFocused) {
                    this.mContentView.requestFocus();
                }
                XWalkExtendPluginNativeViewClient.this.mRootView.addView(this.mContentView);
            }
            setContentView(XWalkExtendPluginNativeViewClient.this.mRootView);
            if (XWalkExtendPluginNativeViewClient.this.mDelegate != null) {
                XWalkExtendPluginNativeViewClient.this.mDelegate.onCreate(this.mClient.mWidth, this.mClient.mHeight);
            }
            AppMethodBeat.o(183756);
        }

        public void detach() {
            AppMethodBeat.i(183757);
            if (XWalkExtendPluginNativeViewClient.this.mRootView != null) {
                XWalkExtendPluginNativeViewClient.this.mRootView.removeAllViews();
            }
            AppMethodBeat.o(183757);
        }
    }

    public void onNativeViewReady(int i2) {
    }

    public void onNativeViewSizeChanged(int i2, int i3, int i4) {
    }

    public void onNativeViewTouch(int i2, MotionEvent motionEvent) {
    }

    public void onNativeViewDestroy(int i2) {
    }
}
