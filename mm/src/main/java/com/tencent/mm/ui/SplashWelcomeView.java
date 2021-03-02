package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.chatting.ar;
import com.tencent.mm.ui.e;
import com.tencent.mm.vfs.s;

public class SplashWelcomeView extends FrameLayout implements ar {
    private volatile boolean OLm;
    private volatile boolean OLn;
    private ImageView OLo;
    private int OLp;
    private Bitmap bitmap;
    private boolean hasDrawed;

    static /* synthetic */ void c(SplashWelcomeView splashWelcomeView) {
        AppMethodBeat.i(33776);
        splashWelcomeView.gJF();
        AppMethodBeat.o(33776);
    }

    public SplashWelcomeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33769);
        jT(context);
        AppMethodBeat.o(33769);
    }

    public SplashWelcomeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(33770);
        jT(context);
        AppMethodBeat.o(33770);
    }

    private boolean e(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(33771);
        this.OLp = sharedPreferences.getInt("launch_fail_times", 0);
        int i2 = sharedPreferences.getInt("launch_last_status", 0);
        if (i2 == 1) {
            Log.i("SplashWelcomeView", "last launch status is 'start'.");
            this.OLp++;
            sharedPreferences.edit().putInt("launch_fail_times", this.OLp).commit();
        } else if (i2 == 2) {
            Log.i("SplashWelcomeView", "last launch status is 'end'.");
        }
        sharedPreferences.edit().putInt("launch_last_status", 1).apply();
        if (this.OLp >= 3) {
            Log.i("SplashWelcomeView", "launch exceed max failed times, %d", Integer.valueOf(this.OLp));
            AppMethodBeat.o(33771);
            return false;
        }
        AppMethodBeat.o(33771);
        return true;
    }

    private void gJE() {
        AppMethodBeat.i(33772);
        if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(33772);
        } else if (Build.VERSION.SDK_INT < 23 || g.isMIUIV8()) {
            ((Activity) getContext()).getWindow().setStatusBarColor(ar.v(Color.parseColor("#33000000"), -1));
            AppMethodBeat.o(33772);
        } else {
            ((Activity) getContext()).getWindow().setStatusBarColor(-1);
            AppMethodBeat.o(33772);
        }
    }

    private void jT(Context context) {
        AppMethodBeat.i(33773);
        this.OLo = new SplashImageView(context);
        ((SplashImageView) this.OLo).setOnDrawListener(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (MMApplicationContext.isMMProcess()) {
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0);
            try {
                boolean z = sharedPreferences.getBoolean("transit_to_switch_account", false);
                Log.i("SplashWelcomeView", "transit to switch account %s", Boolean.valueOf(z));
                if (z) {
                    byte[] aW = s.aW(e.g.Ozb, 0, (int) s.boW(e.g.Ozb));
                    s.deleteFile(e.g.Ozb);
                    sharedPreferences.edit().putBoolean("transit_to_switch_account", false).commit();
                    if (aW != null && aW.length > 0) {
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(aW, 0, aW.length);
                        if (decodeByteArray != null) {
                            this.OLo.setImageBitmap(decodeByteArray);
                            gJE();
                        } else {
                            Log.e("SplashWelcomeView", "get switch account bg null!");
                        }
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("SplashWelcomeView", e2, "show switch account view with exception!", new Object[0]);
            }
        }
        addView(this.OLo, layoutParams);
        try {
            if (!MMApplicationContext.isMMProcess()) {
                Log.i("SplashWelcomeView", "not main process, only load default splash bitmap.");
                AppMethodBeat.o(33773);
                return;
            }
            SharedPreferences sharedPreferences2 = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
            long j2 = sharedPreferences2.getLong("new_launch_image_begin_time", 0);
            long j3 = sharedPreferences2.getLong("new_launch_image_end_time", 0);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Log.i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(currentTimeMillis));
            final String str = b.aKB() + "splashWelcomeImg";
            if (currentTimeMillis <= j2 || currentTimeMillis >= j3) {
                Log.i("SplashWelcomeView", "change launch image activity is finished!");
                s.deleteFile(str);
                AppMethodBeat.o(33773);
            } else if (!e(sharedPreferences2)) {
                AppMethodBeat.o(33773);
            } else {
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.ui.SplashWelcomeView.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(33766);
                        if (s.YS(str)) {
                            try {
                                byte[] aW = s.aW(str, 0, (int) s.boW(str));
                                if (aW != null && aW.length > 0) {
                                    SplashWelcomeView.this.bitmap = BitmapFactory.decodeByteArray(aW, 0, aW.length);
                                    Log.i("SplashWelcomeView", "ready to play animation, hasDrawed %s", Boolean.valueOf(SplashWelcomeView.this.hasDrawed));
                                    SplashWelcomeView.this.OLn = true;
                                }
                                if (SplashWelcomeView.this.hasDrawed) {
                                    SplashWelcomeView.c(SplashWelcomeView.this);
                                    AppMethodBeat.o(33766);
                                    return;
                                }
                            } catch (Exception e2) {
                                Log.printErrStackTrace("SplashWelcomeView", e2, "decode new welcome image error: %s", e2.getMessage());
                                if (SplashWelcomeView.this.hasDrawed) {
                                    SplashWelcomeView.c(SplashWelcomeView.this);
                                    AppMethodBeat.o(33766);
                                    return;
                                }
                            } catch (Throwable th) {
                                if (SplashWelcomeView.this.hasDrawed) {
                                    SplashWelcomeView.c(SplashWelcomeView.this);
                                }
                                AppMethodBeat.o(33766);
                                throw th;
                            }
                            AppMethodBeat.o(33766);
                            return;
                        }
                        Log.i("SplashWelcomeView", "cannot find %s", str);
                        AppMethodBeat.o(33766);
                    }
                }, "readWelcomeBg");
                AppMethodBeat.o(33773);
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("SplashWelcomeView", e3, "%s", e3.getMessage());
            AppMethodBeat.o(33773);
        }
    }

    private synchronized void gJF() {
        AppMethodBeat.i(33774);
        if (!this.OLm) {
            this.OLm = true;
            if (this.bitmap != null) {
                try {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.SplashWelcomeView.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(33768);
                            Log.d("SplashWelcomeView", "set top imageView");
                            final ImageView imageView = new ImageView(SplashWelcomeView.this.getContext());
                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            imageView.setImageBitmap(SplashWelcomeView.this.bitmap);
                            imageView.setAlpha(0.0f);
                            SplashWelcomeView.this.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
                            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(1000L);
                            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                /* class com.tencent.mm.ui.SplashWelcomeView.AnonymousClass2.AnonymousClass1 */

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    AppMethodBeat.i(33767);
                                    imageView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                    AppMethodBeat.o(33767);
                                }
                            });
                            duration.start();
                            Log.i("SplashWelcomeView", "start play animation");
                            AppMethodBeat.o(33768);
                        }
                    });
                    AppMethodBeat.o(33774);
                } catch (Exception e2) {
                    Log.printErrStackTrace("SplashWelcomeView", e2, "%s", e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(33774);
    }

    @Override // com.tencent.mm.ui.chatting.ar
    public final void dSa() {
        AppMethodBeat.i(33775);
        Log.i("SplashWelcomeView", "hasDrawed:%s", Boolean.valueOf(this.hasDrawed));
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.OLn && !this.OLm) {
                gJF();
            }
        }
        AppMethodBeat.o(33775);
    }
}
