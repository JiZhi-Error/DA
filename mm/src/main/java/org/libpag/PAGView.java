package org.libpag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.opengl.EGLContext;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.TextureView;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.extra.tools.ScreenBroadcastReceiver;
import org.extra.tools.a;

public class PAGView extends TextureView implements TextureView.SurfaceTextureListener, ScreenBroadcastReceiver.a {
    private static final int ANDROID_SDK_VERSION_O = 26;
    private static final int MSG_FLUSH = 0;
    private static final int MSG_HANDLER_THREAD_QUITE = 2;
    private static final int MSG_SURFACE_DESTROY = 1;
    private static String TAG = "PAGView";
    private static final Object g_HandlerLock = new Object();
    private static volatile int g_HandlerThreadCount = 0;
    private static PAGRendererHandler g_PAGRendererHandler = null;
    private static HandlerThread g_PAGRendererThread = null;
    private boolean _isPlaying = false;
    private ValueAnimator animator;
    private volatile float animatorProgress;
    private String filePath = "";
    private SparseArray<PAGImage> imageReplacementMap = new SparseArray<>();
    private boolean isAttachedToWindow = false;
    private Runnable mAnimatorCancelRunnable = new Runnable() {
        /* class org.libpag.PAGView.AnonymousClass5 */

        public void run() {
            AppMethodBeat.i(236944);
            PAGView.this.animator.cancel();
            AppMethodBeat.o(236944);
        }
    };
    private AnimatorListenerAdapter mAnimatorListenerAdapter = new AnimatorListenerAdapter() {
        /* class org.libpag.PAGView.AnonymousClass2 */

        public void onAnimationStart(Animator animator) {
            AppMethodBeat.i(236938);
            super.onAnimationStart(animator);
            synchronized (PAGView.this) {
                try {
                    Iterator it = PAGView.this.mViewListeners.iterator();
                    while (it.hasNext()) {
                        ((PAGViewListener) it.next()).onAnimationStart(PAGView.this);
                    }
                } finally {
                    AppMethodBeat.o(236938);
                }
            }
        }

        public void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(236939);
            super.onAnimationEnd(animator);
            synchronized (PAGView.this) {
                try {
                    Iterator it = PAGView.this.mViewListeners.iterator();
                    while (it.hasNext()) {
                        ((PAGViewListener) it.next()).onAnimationEnd(PAGView.this);
                    }
                } finally {
                    AppMethodBeat.o(236939);
                }
            }
        }

        public void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(236940);
            super.onAnimationCancel(animator);
            synchronized (PAGView.this) {
                try {
                    Iterator it = PAGView.this.mViewListeners.iterator();
                    while (it.hasNext()) {
                        ((PAGViewListener) it.next()).onAnimationCancel(PAGView.this);
                    }
                } finally {
                    AppMethodBeat.o(236940);
                }
            }
        }

        public void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(236941);
            super.onAnimationRepeat(animator);
            synchronized (PAGView.this) {
                try {
                    Iterator it = PAGView.this.mViewListeners.iterator();
                    while (it.hasNext()) {
                        ((PAGViewListener) it.next()).onAnimationRepeat(PAGView.this);
                    }
                } finally {
                    AppMethodBeat.o(236941);
                }
            }
        }
    };
    private Runnable mAnimatorStartRunnable = new Runnable() {
        /* class org.libpag.PAGView.AnonymousClass4 */

        public void run() {
            AppMethodBeat.i(236943);
            if (PAGView.this.isAttachedToWindow) {
                PAGView.this.animator.start();
                AppMethodBeat.o(236943);
                return;
            }
            String unused = PAGView.TAG;
            AppMethodBeat.o(236943);
        }
    };
    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        /* class org.libpag.PAGView.AnonymousClass1 */

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(236937);
            PAGView.this.animatorProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            PAGView.access$300(PAGView.this);
            AppMethodBeat.o(236937);
        }
    };
    private TextureView.SurfaceTextureListener mListener;
    private ArrayList<PAGFlushListener> mPAGFlushListeners = new ArrayList<>();
    private boolean mSaveVisibleState;
    private ArrayList<PAGViewListener> mViewListeners = new ArrayList<>();
    private PAGFile pagFile;
    private PAGPlayer pagPlayer;
    private PAGSurface pagSurface;
    private EGLContext sharedContext = null;
    private SparseArray<PAGText> textReplacementMap = new SparseArray<>();

    public interface PAGFlushListener {
        void onFlush();
    }

    public interface PAGViewListener {
        void onAnimationCancel(PAGView pAGView);

        void onAnimationEnd(PAGView pAGView);

        void onAnimationRepeat(PAGView pAGView);

        void onAnimationStart(PAGView pAGView);
    }

    static /* synthetic */ void access$000(PAGView pAGView) {
        AppMethodBeat.i(237011);
        pAGView.updateView();
        AppMethodBeat.o(237011);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(237012);
        HandlerThreadQuit();
        AppMethodBeat.o(237012);
    }

    static /* synthetic */ void access$300(PAGView pAGView) {
        AppMethodBeat.i(237013);
        NeedsUpdateView(pAGView);
        AppMethodBeat.o(237013);
    }

    static {
        AppMethodBeat.i(237014);
        a hPU = a.hPU();
        if (hPU.UhY == null) {
            hPU.UhY = new ScreenBroadcastReceiver(hPU);
            ScreenBroadcastReceiver screenBroadcastReceiver = hPU.UhY;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            try {
                Context applicationContext = ScreenBroadcastReceiver.getApplicationContext();
                if (applicationContext != null) {
                    applicationContext.registerReceiver(screenBroadcastReceiver, intentFilter);
                }
                AppMethodBeat.o(237014);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(237014);
    }

    private static synchronized void StartHandlerThread() {
        synchronized (PAGView.class) {
            AppMethodBeat.i(236949);
            g_HandlerThreadCount++;
            if (g_PAGRendererThread == null) {
                HandlerThread handlerThread = new HandlerThread("pag-renderer");
                g_PAGRendererThread = handlerThread;
                handlerThread.start();
            }
            if (g_PAGRendererHandler == null) {
                g_PAGRendererHandler = new PAGRendererHandler(g_PAGRendererThread.getLooper());
            }
            AppMethodBeat.o(236949);
        }
    }

    private static synchronized void DestroyHandlerThread() {
        synchronized (PAGView.class) {
            AppMethodBeat.i(236950);
            int i2 = g_HandlerThreadCount - 1;
            g_HandlerThreadCount = i2;
            if (i2 != 0) {
                AppMethodBeat.o(236950);
            } else if (g_PAGRendererHandler == null || g_PAGRendererThread == null) {
                AppMethodBeat.o(236950);
            } else if (!g_PAGRendererThread.isAlive()) {
                AppMethodBeat.o(236950);
            } else {
                SendMessage(2, null);
                AppMethodBeat.o(236950);
            }
        }
    }

    private static void SendMessage(int i2, Object obj) {
        AppMethodBeat.i(236951);
        if (g_PAGRendererHandler == null) {
            AppMethodBeat.o(236951);
            return;
        }
        Message obtainMessage = g_PAGRendererHandler.obtainMessage();
        obtainMessage.arg1 = i2;
        if (obj != null) {
            obtainMessage.obj = obj;
        }
        g_PAGRendererHandler.sendMessage(obtainMessage);
        AppMethodBeat.o(236951);
    }

    private static void NeedsUpdateView(PAGView pAGView) {
        AppMethodBeat.i(236952);
        if (g_PAGRendererHandler == null) {
            AppMethodBeat.o(236952);
            return;
        }
        g_PAGRendererHandler.needsUpdateView(pAGView);
        AppMethodBeat.o(236952);
    }

    private static void HandlerThreadQuit() {
        AppMethodBeat.i(236953);
        if (g_HandlerThreadCount != 0) {
            AppMethodBeat.o(236953);
        } else if (g_PAGRendererHandler == null || g_PAGRendererThread == null) {
            AppMethodBeat.o(236953);
        } else if (!g_PAGRendererThread.isAlive()) {
            AppMethodBeat.o(236953);
        } else {
            g_PAGRendererHandler.removeCallbacksAndMessages(null);
            if (Build.VERSION.SDK_INT > 18) {
                g_PAGRendererThread.quitSafely();
            } else {
                g_PAGRendererThread.quit();
            }
            g_PAGRendererThread = null;
            g_PAGRendererHandler = null;
            AppMethodBeat.o(236953);
        }
    }

    /* access modifiers changed from: package-private */
    public static class PAGRendererHandler extends Handler {
        private final Object lock = new Object();
        private List<PAGView> needsUpdateViews = new ArrayList();

        PAGRendererHandler(Looper looper) {
            super(looper);
            AppMethodBeat.i(236946);
            AppMethodBeat.o(236946);
        }

        /* access modifiers changed from: package-private */
        public void needsUpdateView(PAGView pAGView) {
            AppMethodBeat.i(236947);
            synchronized (this.lock) {
                try {
                    if (this.needsUpdateViews.isEmpty()) {
                        Message obtainMessage = obtainMessage();
                        obtainMessage.arg1 = 0;
                        sendMessage(obtainMessage);
                    }
                    this.needsUpdateViews.add(pAGView);
                } finally {
                    AppMethodBeat.o(236947);
                }
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public void handleMessage(Message message) {
            ArrayList arrayList;
            AppMethodBeat.i(236948);
            super.handleMessage(message);
            switch (message.arg1) {
                case 0:
                    synchronized (this.lock) {
                        try {
                            arrayList = new ArrayList(this.needsUpdateViews);
                            this.needsUpdateViews.clear();
                        } finally {
                            AppMethodBeat.o(236948);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : arrayList) {
                        if (obj instanceof PAGView) {
                            PAGView pAGView = (PAGView) obj;
                            if (!arrayList2.contains(pAGView)) {
                                PAGView.access$000(pAGView);
                                arrayList2.add(pAGView);
                            }
                        }
                    }
                    return;
                case 1:
                    if (!(message.obj instanceof SurfaceTexture)) {
                        AppMethodBeat.o(236948);
                        return;
                    }
                    ((SurfaceTexture) message.obj).release();
                    AppMethodBeat.o(236948);
                    return;
                case 2:
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class org.libpag.PAGView.PAGRendererHandler.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(236945);
                            PAGView.access$100();
                            AppMethodBeat.o(236945);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(236948);
        }
    }

    public PAGView(Context context) {
        super(context);
        AppMethodBeat.i(236954);
        setupSurfaceTexture();
        AppMethodBeat.o(236954);
    }

    public PAGView(Context context, EGLContext eGLContext) {
        super(context);
        AppMethodBeat.i(236955);
        this.sharedContext = eGLContext;
        setupSurfaceTexture();
        AppMethodBeat.o(236955);
    }

    public PAGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(236956);
        setupSurfaceTexture();
        AppMethodBeat.o(236956);
    }

    public PAGView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(236957);
        setupSurfaceTexture();
        AppMethodBeat.o(236957);
    }

    private void setupSurfaceTexture() {
        AppMethodBeat.i(236958);
        setOpaque(false);
        this.pagPlayer = new PAGPlayer();
        setSurfaceTextureListener(this);
        this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.animator.setRepeatCount(0);
        this.animator.setInterpolator(new LinearInterpolator());
        AppMethodBeat.o(236958);
    }

    private void updateView() {
        AppMethodBeat.i(236959);
        if (!this.isAttachedToWindow) {
            AppMethodBeat.o(236959);
            return;
        }
        setProgress((double) this.animatorProgress);
        flush();
        if (!this.mPAGFlushListeners.isEmpty()) {
            post(new Runnable() {
                /* class org.libpag.PAGView.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(236942);
                    Iterator it = PAGView.this.mPAGFlushListeners.iterator();
                    while (it.hasNext()) {
                        ((PAGFlushListener) it.next()).onFlush();
                    }
                    AppMethodBeat.o(236942);
                }
            });
        }
        AppMethodBeat.o(236959);
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        AppMethodBeat.i(236960);
        if (surfaceTextureListener == this) {
            super.setSurfaceTextureListener(surfaceTextureListener);
            AppMethodBeat.o(236960);
            return;
        }
        this.mListener = surfaceTextureListener;
        AppMethodBeat.o(236960);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(236961);
        if (this.pagSurface != null) {
            this.pagSurface.release();
            this.pagSurface = null;
        }
        this.pagSurface = PAGSurface.FromSurfaceTexture(surfaceTexture, this.sharedContext);
        this.pagPlayer.setSurface(this.pagSurface);
        if (this.pagSurface == null) {
            AppMethodBeat.o(236961);
            return;
        }
        this.animator.addUpdateListener(this.mAnimatorUpdateListener);
        if (!this.mPAGFlushListeners.isEmpty()) {
            this.pagSurface.clearAll();
            NeedsUpdateView(this);
        } else {
            flush();
        }
        if (this.mListener != null) {
            this.mListener.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
        }
        AppMethodBeat.o(236961);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(236962);
        if (this.pagSurface != null) {
            this.pagSurface.updateSize();
            if (!this.mPAGFlushListeners.isEmpty()) {
                this.pagSurface.clearAll();
                NeedsUpdateView(this);
            } else {
                flush();
            }
        }
        if (this.mListener != null) {
            this.mListener.onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
        AppMethodBeat.o(236962);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z = true;
        AppMethodBeat.i(236963);
        this.pagPlayer.setSurface(null);
        if (this.mListener != null) {
            this.mListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        if (this.pagSurface != null) {
            this.pagSurface.freeCache();
        }
        this.animator.removeUpdateListener(this.mAnimatorUpdateListener);
        if (!(g_PAGRendererHandler == null || surfaceTexture == null)) {
            SendMessage(1, surfaceTexture);
            z = false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            synchronized (g_HandlerLock) {
                try {
                    DestroyHandlerThread();
                } finally {
                    AppMethodBeat.o(236963);
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(236964);
        this.isAttachedToWindow = true;
        super.onAttachedToWindow();
        this.animator.addListener(this.mAnimatorListenerAdapter);
        a hPU = a.hPU();
        if (hPU.UhY != null) {
            hPU.hPV();
            synchronized (hPU.UhX) {
                try {
                    Iterator<WeakReference<ScreenBroadcastReceiver.a>> it = a.opg.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (this == it.next().get()) {
                                break;
                            }
                        } else {
                            a.opg.add(new WeakReference<>(this));
                            break;
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(236964);
                    throw th;
                }
            }
        }
        synchronized (g_HandlerLock) {
            try {
                StartHandlerThread();
            } finally {
                AppMethodBeat.o(236964);
            }
        }
        if (this._isPlaying) {
            doPlay();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(236965);
        this.isAttachedToWindow = false;
        super.onDetachedFromWindow();
        a hPU = a.hPU();
        if (hPU.UhY != null) {
            hPU.hPV();
            synchronized (hPU.UhX) {
                try {
                    WeakReference<ScreenBroadcastReceiver.a> weakReference = null;
                    for (WeakReference<ScreenBroadcastReceiver.a> weakReference2 : a.opg) {
                        if (this != weakReference2.get()) {
                            weakReference2 = weakReference;
                        }
                        weakReference = weakReference2;
                    }
                    if (weakReference != null) {
                        a.opg.remove(weakReference);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(236965);
                    throw th;
                }
            }
        }
        if (this.pagSurface != null) {
            this.pagSurface.release();
            this.pagSurface = null;
        }
        this._isPlaying = this._isPlaying && this.animator.isRunning();
        cancelAnimator();
        if (Build.VERSION.SDK_INT < 26) {
            synchronized (g_HandlerLock) {
                try {
                    DestroyHandlerThread();
                } catch (Throwable th2) {
                    AppMethodBeat.o(236965);
                    throw th2;
                }
            }
        }
        this.animator.removeListener(this.mAnimatorListenerAdapter);
        AppMethodBeat.o(236965);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(236966);
        if (this.mListener != null) {
            this.mListener.onSurfaceTextureUpdated(surfaceTexture);
        }
        AppMethodBeat.o(236966);
    }

    public boolean isPlaying() {
        AppMethodBeat.i(236967);
        if (this.animator != null) {
            boolean isRunning = this.animator.isRunning();
            AppMethodBeat.o(236967);
            return isRunning;
        }
        AppMethodBeat.o(236967);
        return false;
    }

    public void play() {
        AppMethodBeat.i(236968);
        this._isPlaying = true;
        doPlay();
        AppMethodBeat.o(236968);
    }

    private void doPlay() {
        AppMethodBeat.i(236969);
        if (!this.isAttachedToWindow) {
            AppMethodBeat.o(236969);
            return;
        }
        this.animator.setCurrentPlayTime((long) (this.pagPlayer.getProgress() * ((double) this.animator.getDuration())));
        startAnimator();
        AppMethodBeat.o(236969);
    }

    public void stop() {
        AppMethodBeat.i(236970);
        this._isPlaying = false;
        cancelAnimator();
        AppMethodBeat.o(236970);
    }

    private boolean isMainThread() {
        AppMethodBeat.i(236971);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            AppMethodBeat.o(236971);
            return true;
        }
        AppMethodBeat.o(236971);
        return false;
    }

    private void startAnimator() {
        AppMethodBeat.i(236972);
        if (isMainThread()) {
            this.animator.start();
            AppMethodBeat.o(236972);
            return;
        }
        removeCallbacks(this.mAnimatorCancelRunnable);
        post(this.mAnimatorStartRunnable);
        AppMethodBeat.o(236972);
    }

    private void cancelAnimator() {
        AppMethodBeat.i(236973);
        if (isMainThread()) {
            this.animator.cancel();
            AppMethodBeat.o(236973);
            return;
        }
        removeCallbacks(this.mAnimatorStartRunnable);
        post(this.mAnimatorCancelRunnable);
        AppMethodBeat.o(236973);
    }

    public void setRepeatCount(int i2) {
        AppMethodBeat.i(236974);
        if (i2 < 0) {
            i2 = 0;
        }
        this.animator.setRepeatCount(i2 - 1);
        AppMethodBeat.o(236974);
    }

    public void addListener(PAGViewListener pAGViewListener) {
        AppMethodBeat.i(236975);
        synchronized (this) {
            try {
                this.mViewListeners.add(pAGViewListener);
            } finally {
                AppMethodBeat.o(236975);
            }
        }
    }

    public void removeListener(PAGViewListener pAGViewListener) {
        AppMethodBeat.i(236976);
        synchronized (this) {
            try {
                this.mViewListeners.remove(pAGViewListener);
            } finally {
                AppMethodBeat.o(236976);
            }
        }
    }

    public void addPAGFlushListener(PAGFlushListener pAGFlushListener) {
        AppMethodBeat.i(236977);
        synchronized (this) {
            try {
                this.mPAGFlushListeners.add(pAGFlushListener);
            } finally {
                AppMethodBeat.o(236977);
            }
        }
    }

    public void removePAGFlushListener(PAGFlushListener pAGFlushListener) {
        AppMethodBeat.i(236978);
        synchronized (this) {
            try {
                this.mPAGFlushListeners.remove(pAGFlushListener);
            } finally {
                AppMethodBeat.o(236978);
            }
        }
    }

    @Deprecated
    public void addListener(Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(236979);
        this.animator.addListener(animatorListener);
        AppMethodBeat.o(236979);
    }

    @Deprecated
    public void removeListener(Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(236980);
        this.animator.removeListener(animatorListener);
        AppMethodBeat.o(236980);
    }

    public String getPath() {
        return this.filePath;
    }

    public boolean setPath(String str) {
        PAGFile Load;
        AppMethodBeat.i(236981);
        if (str == null || !str.startsWith("assets://")) {
            Load = PAGFile.Load(str);
        } else {
            Load = PAGFile.Load(getContext().getAssets(), str.substring(9));
        }
        setComposition(Load);
        this.filePath = str;
        if (Load != null) {
            AppMethodBeat.o(236981);
            return true;
        }
        AppMethodBeat.o(236981);
        return false;
    }

    public PAGComposition getComposition() {
        AppMethodBeat.i(236982);
        PAGComposition composition = this.pagPlayer.getComposition();
        AppMethodBeat.o(236982);
        return composition;
    }

    public void setComposition(PAGComposition pAGComposition) {
        AppMethodBeat.i(236983);
        this.filePath = null;
        this.pagFile = null;
        this.pagPlayer.setComposition(pAGComposition);
        this.animator.setDuration(this.pagPlayer.duration() / 1000);
        AppMethodBeat.o(236983);
    }

    public boolean videoEnabled() {
        AppMethodBeat.i(236984);
        boolean videoEnabled = this.pagPlayer.videoEnabled();
        AppMethodBeat.o(236984);
        return videoEnabled;
    }

    public void setVideoEnabled(boolean z) {
        AppMethodBeat.i(236985);
        this.pagPlayer.setVideoEnabled(z);
        AppMethodBeat.o(236985);
    }

    public boolean cacheEnabled() {
        AppMethodBeat.i(236986);
        boolean cacheEnabled = this.pagPlayer.cacheEnabled();
        AppMethodBeat.o(236986);
        return cacheEnabled;
    }

    public void setCacheEnabled(boolean z) {
        AppMethodBeat.i(236987);
        this.pagPlayer.setCacheEnabled(z);
        AppMethodBeat.o(236987);
    }

    public float cacheScale() {
        AppMethodBeat.i(236988);
        float cacheScale = this.pagPlayer.cacheScale();
        AppMethodBeat.o(236988);
        return cacheScale;
    }

    public void setCacheScale(float f2) {
        AppMethodBeat.i(236989);
        this.pagPlayer.setCacheScale(f2);
        AppMethodBeat.o(236989);
    }

    public float maxFrameRate() {
        AppMethodBeat.i(236990);
        float maxFrameRate = this.pagPlayer.maxFrameRate();
        AppMethodBeat.o(236990);
        return maxFrameRate;
    }

    public void setMaxFrameRate(float f2) {
        AppMethodBeat.i(236991);
        this.pagPlayer.setMaxFrameRate(f2);
        AppMethodBeat.o(236991);
    }

    public int scaleMode() {
        AppMethodBeat.i(236992);
        int scaleMode = this.pagPlayer.scaleMode();
        AppMethodBeat.o(236992);
        return scaleMode;
    }

    public void setScaleMode(int i2) {
        AppMethodBeat.i(236993);
        this.pagPlayer.setScaleMode(i2);
        AppMethodBeat.o(236993);
    }

    public Matrix matrix() {
        AppMethodBeat.i(236994);
        Matrix matrix = this.pagPlayer.matrix();
        AppMethodBeat.o(236994);
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        AppMethodBeat.i(236995);
        this.pagPlayer.setMatrix(matrix);
        AppMethodBeat.o(236995);
    }

    public long duration() {
        AppMethodBeat.i(236996);
        long duration = this.pagPlayer.duration();
        AppMethodBeat.o(236996);
        return duration;
    }

    public double getProgress() {
        AppMethodBeat.i(236997);
        double progress = this.pagPlayer.getProgress();
        AppMethodBeat.o(236997);
        return progress;
    }

    public void setProgress(double d2) {
        AppMethodBeat.i(236998);
        if (this.animatorProgress != ((float) d2)) {
            this.animatorProgress = (float) d2;
            if (Build.VERSION.SDK_INT >= 22) {
                this.animator.setCurrentFraction(this.animatorProgress);
            }
        }
        this.pagPlayer.setProgress(d2);
        AppMethodBeat.o(236998);
    }

    public boolean flush() {
        AppMethodBeat.i(236999);
        boolean flush = this.pagPlayer.flush();
        AppMethodBeat.o(236999);
        return flush;
    }

    public PAGLayer[] getLayersUnderPoint(float f2, float f3) {
        AppMethodBeat.i(237000);
        PAGLayer[] layersUnderPoint = this.pagPlayer.getLayersUnderPoint(f2, f3);
        AppMethodBeat.o(237000);
        return layersUnderPoint;
    }

    public void freeCache() {
        AppMethodBeat.i(237001);
        if (this.pagSurface != null) {
            this.pagSurface.freeCache();
        }
        AppMethodBeat.o(237001);
    }

    @Deprecated
    public PAGFile getFile() {
        return this.pagFile;
    }

    @Deprecated
    public void setFile(PAGFile pAGFile) {
        AppMethodBeat.i(237002);
        setComposition(pAGFile != null ? pAGFile.copyOriginal() : null);
        this.pagFile = pAGFile;
        if (this.pagFile != null) {
            applyReplacements();
        }
        AppMethodBeat.o(237002);
    }

    @Deprecated
    public PAGComposition getRootComposition() {
        AppMethodBeat.i(237003);
        PAGComposition composition = this.pagPlayer.getComposition();
        AppMethodBeat.o(237003);
        return composition;
    }

    @Deprecated
    public boolean flush(boolean z) {
        AppMethodBeat.i(237004);
        boolean flush = flush();
        AppMethodBeat.o(237004);
        return flush;
    }

    @Deprecated
    public void setTextData(int i2, PAGText pAGText) {
        AppMethodBeat.i(237005);
        PAGComposition composition = this.pagPlayer.getComposition();
        if (composition != null && this.pagFile == null) {
            AppMethodBeat.o(237005);
        } else if (composition != null) {
            ((PAGFile) composition).replaceText(i2, pAGText);
            AppMethodBeat.o(237005);
        } else {
            this.textReplacementMap.put(i2, pAGText);
            AppMethodBeat.o(237005);
        }
    }

    @Deprecated
    public void replaceImage(int i2, PAGImage pAGImage) {
        AppMethodBeat.i(237006);
        PAGComposition composition = this.pagPlayer.getComposition();
        if (composition != null && this.pagFile == null) {
            AppMethodBeat.o(237006);
        } else if (composition != null) {
            ((PAGFile) composition).replaceImage(i2, pAGImage);
            AppMethodBeat.o(237006);
        } else {
            this.imageReplacementMap.put(i2, pAGImage);
            AppMethodBeat.o(237006);
        }
    }

    private void applyReplacements() {
        AppMethodBeat.i(237007);
        PAGFile pAGFile = (PAGFile) this.pagPlayer.getComposition();
        if (pAGFile == null) {
            AppMethodBeat.o(237007);
            return;
        }
        for (int i2 = 0; i2 < this.textReplacementMap.size(); i2++) {
            pAGFile.replaceText(this.textReplacementMap.keyAt(i2), this.textReplacementMap.valueAt(i2));
        }
        this.textReplacementMap.clear();
        for (int i3 = 0; i3 < this.imageReplacementMap.size(); i3++) {
            pAGFile.replaceImage(this.imageReplacementMap.keyAt(i3), this.imageReplacementMap.valueAt(i3));
        }
        this.imageReplacementMap.clear();
        AppMethodBeat.o(237007);
    }

    @Override // org.extra.tools.ScreenBroadcastReceiver.a
    public void onScreenOff() {
        AppMethodBeat.i(237008);
        if (getVisibility() == 0) {
            this.mSaveVisibleState = true;
            setVisibility(4);
        }
        AppMethodBeat.o(237008);
    }

    @Override // org.extra.tools.ScreenBroadcastReceiver.a
    public void onScreenOn() {
        AppMethodBeat.i(237009);
        if (this.mSaveVisibleState) {
            setVisibility(0);
        }
        this.mSaveVisibleState = false;
        AppMethodBeat.o(237009);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        AppMethodBeat.i(237010);
        if (Build.VERSION.SDK_INT < 24 && drawable != null) {
            super.setBackgroundDrawable(drawable);
        }
        AppMethodBeat.o(237010);
    }
}
