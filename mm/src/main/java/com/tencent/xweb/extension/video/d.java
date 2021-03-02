package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.Base64;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.xweb.WebView;
import com.tencent.xweb.u;
import com.tencent.xweb.util.h;
import com.tencent.xweb.v;
import java.util.Timer;
import java.util.TimerTask;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;

public final class d implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, b, u {
    WebView IJw;
    private int JvV = -3;
    GestureDetector PO;
    ScaleGestureDetector Rkr;
    private long SBA;
    private double SBB;
    private double SBC;
    private final int SBD = 0;
    private final int SBE = 1;
    private final int SBF = 2;
    private final int SBG = 3;
    private boolean SBH = false;
    private v SBI;
    private int SBJ = 0;
    private double SBK = 0.0d;
    private float SBL = 0.0f;
    private float SBM = 0.0f;
    private a SBN;
    String SBO;
    private Timer SBP;
    private boolean SBQ;
    private int SBR = 0;
    private double SBS;
    private int SBT = 200;
    private Drawable SBU;
    private boolean SBV;
    private boolean SBW;
    private boolean SBX = false;
    private int SBY;
    private ViewGroup SBk;
    SurfaceView SBl;
    private View SBm;
    ViewGroup SBn;
    VideoStatusLayout SBo;
    ProgressBar SBp;
    TextView SBq;
    TextView SBr;
    ClickableFrameLayout SBs;
    LinearLayout SBt;
    ImageView SBu;
    ImageView SBv;
    ImageView SBw;
    c SBx;
    private WebChromeClient.CustomViewCallback SBy;
    private boolean SBz;
    private Window WZ;
    private WindowManager.LayoutParams azI;
    Activity mActivity;
    private AudioManager mAudioManager;
    private float mBrightness = 1.0f;
    private int mCurrentOrientation;
    private double mLe;
    private int mMode = 0;
    FrameLayout mRootView;

    private Activity htk() {
        Activity activity;
        AppMethodBeat.i(153593);
        if (this.mActivity != null) {
            Activity activity2 = this.mActivity;
            AppMethodBeat.o(153593);
            return activity2;
        }
        Context context = this.IJw.getContext();
        while (true) {
            if (!(context instanceof Activity)) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                Context baseContext = ((ContextWrapper) context).getBaseContext();
                if (baseContext == context) {
                    activity = null;
                    break;
                }
                context = baseContext;
            } else {
                activity = (Activity) context;
                break;
            }
        }
        if (activity != null) {
            this.mActivity = activity;
        } else {
            Log.e("XWebNativeInterface", "royle:tryGetActivity but no Activity");
        }
        AppMethodBeat.o(153593);
        return activity;
    }

    @Override // com.tencent.xweb.extension.video.b
    public final boolean eK(Object obj) {
        this.SBI = (v) obj;
        return true;
    }

    @Override // com.tencent.xweb.extension.video.b
    public final void eJ(Object obj) {
        AppMethodBeat.i(153594);
        new ReflectMethod(obj, "addJavascriptInterface", Object.class, String.class).invoke(this, "xwebToNative");
        AppMethodBeat.o(153594);
    }

    @Override // com.tencent.xweb.extension.video.b
    public final void bk(boolean z, boolean z2) {
        AppMethodBeat.i(153595);
        if (!(this.IJw == null || !z2 || this.SBO == null)) {
            Log.i("XWebNativeInterface", "evaluteJavascript:".concat(String.valueOf(z)));
            String str = this.SBO;
            if (z) {
                str = "window.addEventListener('DOMContentLoaded', function() {" + this.SBO + "});this.xwebReturn = function (){return \"1\";};this.xwebReturn()";
            }
            this.IJw.evaluateJavascript(str, new ValueCallback<String>() {
                /* class com.tencent.xweb.extension.video.d.AnonymousClass20 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(153589);
                    str.equals("1");
                    AppMethodBeat.o(153589);
                }
            });
        }
        AppMethodBeat.o(153595);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007a A[SYNTHETIC, Splitter:B:26:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007f A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0084 A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e5 A[SYNTHETIC, Splitter:B:55:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ea A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ef A[Catch:{ Exception -> 0x010b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String htl() {
        /*
        // Method dump skipped, instructions count: 290
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.extension.video.d.htl():java.lang.String");
    }

    private void reset() {
        Activity htk;
        AppMethodBeat.i(153597);
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.IJw.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        this.SBJ = this.mAudioManager.getStreamMaxVolume(3);
        this.SBK = (double) this.mAudioManager.getStreamVolume(3);
        if (this.SBN == null) {
            this.SBN = new a(this.IJw.getContext());
        }
        if (this.WZ == null && (htk = htk()) != null) {
            this.WZ = htk.getWindow();
        }
        if (this.WZ != null && this.azI == null) {
            this.azI = this.WZ.getAttributes();
        }
        if (this.azI != null) {
            this.mBrightness = this.azI.screenBrightness;
            if (this.mBrightness == -1.0f) {
                try {
                    this.mBrightness = (float) (((double) Settings.System.getInt(this.IJw.getContext().getContentResolver(), "screen_brightness")) / 256.0d);
                    AppMethodBeat.o(153597);
                    return;
                } catch (Settings.SettingNotFoundException e2) {
                    Log.e("XWebNativeInterface", "brightness get error:" + e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(153597);
    }

    @Override // com.tencent.xweb.extension.video.b
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        SurfaceView hQ;
        AppMethodBeat.i(153598);
        Log.i("XWebNativeInterface", "onShowCustomView");
        this.SBm = view;
        this.SBy = customViewCallback;
        if (this.SBm != null || this.IJw.isXWalkKernel()) {
            if (this.IJw.isXWalkKernel()) {
                h.hue();
            } else if (this.IJw.isSysKernel()) {
                h.hui();
            }
            Log.i("XWebNativeInterface", "attach");
            if (this.SBX) {
                Log.i("XWebNativeInterface", "attach has entered fullscreen");
            } else {
                Activity htk = htk();
                if (htk != null) {
                    reset();
                    Eo(true);
                    FrameLayout frameLayout = (FrameLayout) htk.getWindow().getDecorView();
                    if (this.IJw.isXWalkKernel() && this.mRootView.getParent() == frameLayout && this.SBm != null) {
                        this.mRootView.addView(this.SBm, 0, new FrameLayout.LayoutParams(-1, -1, 17));
                    } else if (this.mRootView.getParent() != frameLayout) {
                        frameLayout.addView(this.mRootView, new FrameLayout.LayoutParams(-1, -1, 17));
                        if (this.SBm != null) {
                            this.mRootView.addView(this.SBm, this.mRootView.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
                            if (this.IJw.isSysKernel()) {
                                this.SBm.setVisibility(4);
                            }
                        }
                        if (this.IJw.isSysKernel() && (hQ = hQ(this.SBm)) != null) {
                            hQ.setZOrderMediaOverlay(true);
                        }
                        if (this.IJw.isXWalkKernel()) {
                            this.SBk = (ViewGroup) this.IJw.getParent();
                            this.SBk.removeView(this.IJw);
                            this.mRootView.addView(this.IJw, this.mRootView.getChildCount());
                        }
                        this.mRootView.addView(this.SBn, this.mRootView.getChildCount(), new FrameLayout.LayoutParams(-1, -1, 17));
                        this.SBU = this.IJw.getView().getBackground();
                        if (this.SBU != null) {
                            this.SBU = this.SBU.getConstantState().newDrawable().mutate();
                        }
                        this.IJw.getView().setBackground(new ColorDrawable(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR));
                        if (this.IJw.isSysKernel()) {
                            this.mRootView.postDelayed(new Runnable() {
                                /* class com.tencent.xweb.extension.video.d.AnonymousClass16 */

                                public final void run() {
                                    AppMethodBeat.i(153585);
                                    if (d.this.SBm != null) {
                                        d.this.SBm.setVisibility(0);
                                    }
                                    AppMethodBeat.o(153585);
                                }
                            }, (long) this.SBT);
                        }
                    }
                }
            }
        }
        this.IJw.requestFocus();
        AppMethodBeat.o(153598);
    }

    @Override // com.tencent.xweb.extension.video.b
    public final void onHideCustomView() {
        AppMethodBeat.i(153599);
        if (this.SBy != null) {
            this.SBy.onCustomViewHidden();
        }
        Log.i("XWebNativeInterface", "detach");
        if (!this.SBX) {
            Log.i("XWebNativeInterface", "detach has exited fullscreen");
            AppMethodBeat.o(153599);
            return;
        }
        Activity htk = htk();
        if (htk != null) {
            if (this.SBU != null) {
                this.IJw.getView().setBackground(this.SBU);
                this.SBU = null;
            } else {
                this.IJw.getView().setBackground(new ColorDrawable(0));
            }
            if (this.mRootView.getParent() != ((ViewGroup) htk.getWindow().getDecorView())) {
                AppMethodBeat.o(153599);
                return;
            }
            if (this.IJw.isXWalkKernel()) {
                this.mRootView.removeView(this.IJw);
                this.SBk.addView(this.IJw, 0);
            }
            if (this.SBm != null) {
                this.mRootView.removeView(this.SBm);
            }
            this.mRootView.removeView(this.SBn);
            this.SBn.setVisibility(8);
            if (this.JvV != -3) {
                t(htk, this.JvV);
                this.JvV = -3;
            }
            Eo(false);
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
        }
        AppMethodBeat.o(153599);
    }

    @Override // com.tencent.xweb.extension.video.b
    public final void Em(boolean z) {
        AppMethodBeat.i(153600);
        Log.i("XWebNativeInterface", "disableJsCallback:".concat(String.valueOf(z)));
        this.SBH = z;
        AppMethodBeat.o(153600);
    }

    private void aC(Runnable runnable) {
        AppMethodBeat.i(153601);
        if (this.SBH) {
            AppMethodBeat.o(153601);
            return;
        }
        Activity htk = htk();
        if (htk != null) {
            htk.runOnUiThread(runnable);
            AppMethodBeat.o(153601);
            return;
        }
        this.IJw.getView().post(runnable);
        AppMethodBeat.o(153601);
    }

    public final void htm() {
        AppMethodBeat.i(153602);
        if (this.SBP != null) {
            this.SBP.cancel();
            this.SBP.purge();
            this.SBP = null;
        }
        this.SBP = new Timer();
        this.SBP.schedule(new TimerTask() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass21 */

            public final void run() {
                AppMethodBeat.i(153590);
                d.this.htp();
                AppMethodBeat.o(153590);
            }
        }, 4000);
        AppMethodBeat.o(153602);
    }

    public final void htn() {
        AppMethodBeat.i(153603);
        if (this.SBP != null) {
            this.SBP.cancel();
            this.SBP.purge();
            this.SBP = null;
        }
        AppMethodBeat.o(153603);
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.SBR = 0;
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(153604);
        b bVar = new b();
        bVar.bm(motionEvent);
        a.b("com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        htn();
        if (this.SBQ) {
            htp();
        } else {
            hto();
        }
        a.a(true, (Object) this, "com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(153604);
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float height;
        float width;
        AppMethodBeat.i(153605);
        if (motionEvent == null || motionEvent2 == null) {
            AppMethodBeat.o(153605);
        } else {
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent2.getY() - motionEvent.getY();
            if (this.SBn.getHeight() > this.SBn.getWidth()) {
                height = (float) this.SBn.getWidth();
                width = (float) this.SBn.getHeight();
            } else {
                height = (float) this.SBn.getHeight();
                width = (float) this.SBn.getWidth();
            }
            switch (this.SBR) {
                case 0:
                    if (Math.abs(x) - Math.abs(y) <= 1.0f) {
                        reset();
                        double ceil = Math.ceil((double) (25.0f * this.IJw.getContext().getResources().getDisplayMetrics().density));
                        if (((double) motionEvent.getY()) >= 2.0d * ceil && ((double) motionEvent.getY()) <= ((double) this.SBn.getHeight()) - (ceil * 2.0d)) {
                            if (motionEvent.getX() >= ((float) this.SBn.getWidth()) / 2.0f) {
                                this.SBR = 1;
                                break;
                            } else {
                                this.SBR = 2;
                                break;
                            }
                        } else {
                            this.SBR = 0;
                            break;
                        }
                    } else {
                        this.SBR = 3;
                        break;
                    }
                    break;
                case 1:
                    float f4 = y * -1.0f;
                    double d2 = (double) (((((float) this.SBJ) * f4) / height) * 1.2f);
                    int i2 = (int) d2;
                    if (i2 == 0 && Math.abs(d2) > 0.20000000298023224d) {
                        if (f4 > 0.0f) {
                            i2 = 1;
                        } else if (f4 < 0.0f) {
                            i2 = -1;
                        }
                    }
                    double d3 = ((double) i2) + this.SBK;
                    if (d3 > ((double) this.SBJ)) {
                        d3 = (double) this.SBJ;
                    } else if (d3 < 0.0d) {
                        d3 = 0.0d;
                    }
                    this.mAudioManager.setStreamVolume(3, (int) d3, 4);
                    this.SBo.setVolumnProgress((int) ((d3 / ((double) ((float) this.SBJ))) * 100.0d));
                    this.SBo.show();
                    break;
                case 2:
                    float f5 = (((-1.0f * y) / height) * 1.2f) + this.mBrightness;
                    if (f5 < 0.0f) {
                        f5 = 0.0f;
                    } else if (f5 > 1.0f) {
                        f5 = 1.0f;
                    }
                    this.azI.screenBrightness = f5;
                    this.WZ.setAttributes(this.azI);
                    this.SBo.setBrightProgress((int) (f5 * 100.0f));
                    this.SBo.show();
                    break;
                case 3:
                    float x2 = motionEvent2.getX() - motionEvent.getX();
                    this.SBM = this.SBx.mProgress;
                    if (x2 > 0.0f) {
                        this.SBL = (float) ((int) (((x2 / width) * 100.0f) + this.SBM));
                        if (this.SBL > 100.0f) {
                            this.SBL = 100.0f;
                        }
                    } else {
                        this.SBL = (float) ((int) (((x2 / width) * 100.0f) + this.SBM));
                        if (this.SBL < 0.0f) {
                            this.SBL = 0.0f;
                        }
                    }
                    double d4 = (this.mLe * ((double) this.SBL)) / 100.0d;
                    this.SBo.setVideoTimeProgress(q(d4, this.mLe) + FilePathGenerator.ANDROID_DIR_SEP + q(this.mLe, this.mLe));
                    this.SBo.show();
                    this.SBS = d4;
                    break;
            }
            AppMethodBeat.o(153605);
        }
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(207176);
        b bVar = new b();
        bVar.bm(motionEvent);
        a.b("com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        a.a(this, "com/tencent/xweb/extension/video/XWebNativeInterface", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(207176);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(153606);
        if (this.mMode != 1 || this.SBm == null) {
            AppMethodBeat.o(153606);
            return false;
        }
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        this.SBm.getLeft();
        this.SBm.getTop();
        this.SBm.getBottom();
        this.SBm.getRight();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        layoutParams.width = (int) (((float) this.SBm.getWidth()) * scaleFactor);
        layoutParams.height = (int) (scaleFactor * ((float) this.SBm.getHeight()));
        if (this.SBm != null) {
            this.SBm.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(153606);
        return true;
    }

    public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public final void hto() {
        AppMethodBeat.i(153607);
        aC(new Runnable() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass22 */

            public final void run() {
                AppMethodBeat.i(153591);
                d.this.SBQ = true;
                d.this.SBt.setVisibility(0);
                d.this.htm();
                AppMethodBeat.o(153591);
            }
        });
        AppMethodBeat.o(153607);
    }

    public final void htp() {
        AppMethodBeat.i(153608);
        aC(new Runnable() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass23 */

            public final void run() {
                AppMethodBeat.i(153592);
                d.this.SBQ = false;
                d.this.SBt.setVisibility(4);
                AppMethodBeat.o(153592);
            }
        });
        AppMethodBeat.o(153608);
    }

    private void En(final boolean z) {
        AppMethodBeat.i(153609);
        aC(new Runnable() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(153573);
                if (z) {
                    d.this.SBw.setImageResource(R.drawable.b6w);
                    AppMethodBeat.o(153573);
                    return;
                }
                d.this.SBw.setImageResource(R.drawable.b6y);
                AppMethodBeat.o(153573);
            }
        });
        AppMethodBeat.o(153609);
    }

    public final void e(final double d2, final boolean z) {
        AppMethodBeat.i(153610);
        aC(new Runnable() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(153574);
                if (z && d.this.mLe != 0.0d) {
                    d.this.SBx.e((float) ((int) (100.0d * (d2 / d.this.mLe))), false);
                }
                d.this.SBq.setText(d.a(d.this, d2));
                d.this.SBr.setText(d.n(d.this));
                AppMethodBeat.o(153574);
            }
        });
        AppMethodBeat.o(153610);
    }

    private static String q(double d2, double d3) {
        String format;
        AppMethodBeat.i(153611);
        String format2 = String.format("%02d", Integer.valueOf((int) (d2 / 3600.0d)));
        String format3 = String.format("%02d", Integer.valueOf(((int) (d2 % 3600.0d)) / 60));
        String format4 = String.format("%02d", Integer.valueOf(((int) (d2 % 3600.0d)) % 60));
        if (d3 > 3600.0d) {
            format = String.format("%s:%s:%s", format2, format3, format4);
        } else {
            format = String.format("%s:%s", format3, format4);
        }
        AppMethodBeat.o(153611);
        return format;
    }

    @Override // com.tencent.xweb.u
    public final void hsz() {
        AppMethodBeat.i(153612);
        this.IJw.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_NewPlay();", new Object[0]), new ValueCallback<String>() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
            }
        });
        AppMethodBeat.o(153612);
    }

    @Override // com.tencent.xweb.u
    public final void fDd() {
        AppMethodBeat.i(153613);
        this.IJw.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_NewPause();", new Object[0]), new ValueCallback<String>() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
            }
        });
        AppMethodBeat.o(153613);
    }

    @Override // com.tencent.xweb.u
    public final void F(double d2) {
        AppMethodBeat.i(153614);
        this.IJw.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", Double.valueOf(d2)), new ValueCallback<String>() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass7 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
            }
        });
        AppMethodBeat.o(153614);
    }

    @Override // com.tencent.xweb.u
    public final boolean hsA() {
        return true;
    }

    private void t(Activity activity, int i2) {
        AppMethodBeat.i(207177);
        if (this.SBI == null || !this.SBI.xJ(i2)) {
            if (activity != null) {
                activity.setRequestedOrientation(i2);
            }
            AppMethodBeat.o(207177);
            return;
        }
        Log.i("XWebNativeInterface", "setRequestedOrientation by wechat client");
        AppMethodBeat.o(207177);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoGetFrame(long j2, double d2, String str) {
        AppMethodBeat.i(153615);
        if (j2 == this.SBA && this.SBS == d2 && str != null && str.startsWith("data:image/png;base64,")) {
            byte[] decode = Base64.decode(str.substring(22), 0);
            this.SBu.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            this.SBu.setVisibility(0);
        }
        AppMethodBeat.o(153615);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPlaying() {
        AppMethodBeat.i(153616);
        Log.i("XWebNativeInterface", "onVideoPlaying");
        if (this.SBI != null) {
            this.SBI.onVideoPlaying();
        }
        aC(new Runnable() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(153576);
                d.this.SBp.setVisibility(8);
                AppMethodBeat.o(153576);
            }
        });
        AppMethodBeat.o(153616);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoWaiting() {
        AppMethodBeat.i(153617);
        Log.i("XWebNativeInterface", "onVideoWaiting");
        if (this.SBI != null) {
            this.SBI.onVideoWaiting();
        }
        aC(new Runnable() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(153577);
                d.this.SBp.setVisibility(0);
                AppMethodBeat.o(153577);
            }
        });
        AppMethodBeat.o(153617);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoSeeking() {
        AppMethodBeat.i(153618);
        Log.i("XWebNativeInterface", "onVideoSeeking");
        if (this.SBI != null) {
            this.SBI.onVideoSeeking();
        }
        aC(new Runnable() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(153580);
                d.this.SBp.setVisibility(0);
                AppMethodBeat.o(153580);
            }
        });
        AppMethodBeat.o(153618);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoSeeked() {
        AppMethodBeat.i(153619);
        Log.i("XWebNativeInterface", "onVideoSeeked");
        if (this.SBI != null) {
            this.SBI.onVideoSeeked();
        }
        aC(new Runnable() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(153581);
                d.this.SBp.setVisibility(8);
                AppMethodBeat.o(153581);
            }
        });
        AppMethodBeat.o(153619);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPlay() {
        AppMethodBeat.i(153620);
        Log.i("XWebNativeInterface", "onVideoPlay");
        if (this.SBI != null) {
            this.SBI.onVideoPlay();
        }
        En(false);
        AppMethodBeat.o(153620);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoPause() {
        AppMethodBeat.i(153621);
        Log.i("XWebNativeInterface", "onVideoPause");
        if (this.SBI != null) {
            this.SBI.onVideoPause();
        }
        En(true);
        AppMethodBeat.o(153621);
    }

    @JavascriptInterface
    public final void onVideoEnded() {
        AppMethodBeat.i(153622);
        Log.i("XWebNativeInterface", "onVideoEnded");
        if (this.SBI != null) {
            this.SBI.onVideoEnded();
        }
        AppMethodBeat.o(153622);
    }

    @JavascriptInterface
    public final boolean onVideoEmptied() {
        AppMethodBeat.i(153623);
        Log.i("XWebNativeInterface", "onVideoEmptied");
        if (this.SBI != null) {
            this.SBI.bLx();
            AppMethodBeat.o(153623);
            return true;
        }
        AppMethodBeat.o(153623);
        return false;
    }

    @JavascriptInterface
    public final void onVideoError(int i2, String str) {
        AppMethodBeat.i(153624);
        Log.i("XWebNativeInterface", "onVideoError");
        if (this.SBI != null) {
            this.SBI.onVideoError(i2, str);
        }
        AppMethodBeat.o(153624);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoEnterFullscreen(final boolean z, long j2, final double d2, final double d3, boolean z2, boolean z3, double d4, double d5, double[] dArr) {
        AppMethodBeat.i(153625);
        Log.i("XWebNativeInterface", "onVideoEnterFullscreen:isVideoTag:" + z + ",width:" + d2 + ",height:" + d3 + ",pause:" + z2 + ",seeking:" + z3 + ",currentTime:" + d4 + ",duration:" + d5);
        if (this.SBI != null) {
            this.SBI.onVideoEnterFullscreen(z, j2, d2, d3, z2, z3, d4, d5, dArr);
        }
        if (this.IJw.isXWalkKernel()) {
            h.huf();
        } else if (this.IJw.isSysKernel()) {
            h.huj();
        }
        if (z) {
            if (this.IJw.isXWalkKernel()) {
                h.hug();
            } else if (this.IJw.isSysKernel()) {
                h.huk();
            }
            this.SBz = true;
        }
        this.SBA = j2;
        this.mLe = d5;
        this.SBB = d2;
        this.SBC = d3;
        if (z3) {
            onVideoSeeking();
        } else {
            onVideoSeeked();
        }
        aC(new Runnable() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(153582);
                if (z) {
                    d.this.SBn.setVisibility(0);
                }
                d.this.eq((int) d2, (int) d3);
                AppMethodBeat.o(153582);
            }
        });
        onVideoTimeUpdate(d4, d5, dArr);
        En(z2);
        AppMethodBeat.o(153625);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoExitFullscreen() {
        AppMethodBeat.i(153626);
        Log.i("XWebNativeInterface", "onVideoExitFullscreen");
        if (this.SBI != null) {
            this.SBI.onVideoExitFullscreen();
        }
        this.SBz = false;
        aC(new Runnable() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(153583);
                d.this.SBn.setVisibility(8);
                AppMethodBeat.o(153583);
            }
        });
        AppMethodBeat.o(153626);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoTimeUpdate(double d2, final double d3, final double[] dArr) {
        AppMethodBeat.i(153627);
        if (this.SBI != null) {
            this.SBI.onVideoTimeUpdate(d2, d3, dArr);
        }
        this.mLe = d3;
        e(d2, true);
        aC(new Runnable() {
            /* class com.tencent.xweb.extension.video.d.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(153575);
                c cVar = d.this.SBx;
                double d2 = d3;
                double[] dArr = dArr;
                double d3 = 0.0d;
                for (int i2 = 0; i2 < dArr.length; i2 += 2) {
                    if (dArr.length > i2 + 1 && (dArr[i2] / d2) * 100.0d <= ((double) cVar.mProgress) && (dArr[i2 + 1] / d2) * 100.0d > ((double) cVar.mProgress)) {
                        d3 = (dArr[i2 + 1] / d2) * 100.0d;
                    }
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cVar.mDf.getLayoutParams();
                layoutParams.width = (int) ((d3 / 100.0d) * ((double) cVar.mCN.getWidth()));
                cVar.mDf.setLayoutParams(layoutParams);
                cVar.mDf.requestLayout();
                AppMethodBeat.o(153575);
            }
        });
        AppMethodBeat.o(153627);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onVideoSizeUpdate(final double d2, final double d3) {
        AppMethodBeat.i(153628);
        if (this.SBI != null) {
            this.SBI.onVideoSizeUpdate(d2, d3);
        }
        if (!(this.SBC == d3 && this.SBB == d2)) {
            this.SBB = d2;
            this.SBC = d3;
            Log.i("XWebNativeInterface", "onVideoSizeUpdate width:" + d2 + ", height:" + d3);
            aC(new Runnable() {
                /* class com.tencent.xweb.extension.video.d.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(153584);
                    d.this.eq((int) d2, (int) d3);
                    AppMethodBeat.o(153584);
                }
            });
        }
        AppMethodBeat.o(153628);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onSpecialVideoEnterFullscreen(int i2) {
        AppMethodBeat.i(153629);
        Log.i("XWebNativeInterface", "onSpecialVideoEnterFullscreen:".concat(String.valueOf(i2)));
        h.bY(i2, this.IJw.isXWalkKernel());
        AppMethodBeat.o(153629);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void onSpecialVideoHook(int i2) {
        AppMethodBeat.i(153630);
        Log.i("XWebNativeInterface", "onSpecialVideoHook:".concat(String.valueOf(i2)));
        h.bZ(i2, this.IJw.isXWalkKernel());
        AppMethodBeat.o(153630);
    }

    private SurfaceView hQ(View view) {
        AppMethodBeat.i(153631);
        if (view instanceof SurfaceView) {
            SurfaceView surfaceView = (SurfaceView) view;
            AppMethodBeat.o(153631);
            return surfaceView;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                SurfaceView hQ = hQ(viewGroup.getChildAt(i2));
                if (hQ != null) {
                    AppMethodBeat.o(153631);
                    return hQ;
                }
            }
        }
        AppMethodBeat.o(153631);
        return null;
    }

    private void Eo(boolean z) {
        AppMethodBeat.i(153632);
        Activity htk = htk();
        if (htk == null) {
            AppMethodBeat.o(153632);
            return;
        }
        if (z) {
            if ((htk.getWindow().getAttributes().flags & 2048) != 0) {
                this.SBW = true;
                htk.getWindow().clearFlags(2048);
            } else {
                this.SBW = false;
            }
            if (!this.SBX) {
                if ((htk.getWindow().getAttributes().flags & 1024) != 0) {
                    this.SBV = true;
                } else {
                    this.SBV = false;
                    htk.getWindow().addFlags(1024);
                }
                this.SBX = true;
                AppMethodBeat.o(153632);
                return;
            }
        } else {
            if (this.SBW) {
                htk.getWindow().addFlags(2048);
            }
            if (!this.SBV) {
                htk.getWindow().clearFlags(1024);
            }
            this.SBY = 0;
            this.SBX = false;
            this.SBz = false;
        }
        AppMethodBeat.o(153632);
    }

    public final void eq(int i2, int i3) {
        int i4;
        int max;
        int min;
        AppMethodBeat.i(153633);
        Activity htk = htk();
        if (htk == null) {
            AppMethodBeat.o(153633);
            return;
        }
        if (this.JvV == -3 && htk != null) {
            this.JvV = htk.getRequestedOrientation();
        }
        if (i2 <= i3) {
            t(htk, 1);
            i4 = 1;
        } else {
            t(htk, 0);
            i4 = 0;
        }
        this.mCurrentOrientation = i4;
        if (this.SBm != null) {
            View view = this.SBm;
            Display defaultDisplay = ((WindowManager) this.IJw.getContext().getSystemService("window")).getDefaultDisplay();
            Point point = new Point(0, 0);
            defaultDisplay.getSize(point);
            if (i4 == 0) {
                min = Math.max(point.x, point.y);
                max = Math.min(point.x, point.y);
            } else {
                max = Math.max(point.x, point.y);
                min = Math.min(point.x, point.y);
            }
            double d2 = (((double) i2) * 1.0d) / ((double) i3);
            if (d2 >= (((double) min) * 1.0d) / ((double) max)) {
                max = (int) ((1.0d / d2) * ((double) min));
            } else {
                min = (int) (d2 * ((double) max));
            }
            view.setLayoutParams(new FrameLayout.LayoutParams(min, max, 17));
        }
        AppMethodBeat.o(153633);
    }

    static /* synthetic */ String a(d dVar, double d2) {
        AppMethodBeat.i(153634);
        String q = q(d2, dVar.mLe);
        AppMethodBeat.o(153634);
        return q;
    }

    static /* synthetic */ String n(d dVar) {
        AppMethodBeat.i(153635);
        String q = q(dVar.mLe, dVar.mLe);
        AppMethodBeat.o(153635);
        return q;
    }
}
