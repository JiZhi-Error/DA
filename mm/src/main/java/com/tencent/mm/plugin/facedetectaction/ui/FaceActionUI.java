package com.tencent.mm.plugin.facedetectaction.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.a;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.a;
import com.tencent.tavkit.component.TAVExporter;

@a(3)
public class FaceActionUI extends MMActivity {
    int dGe;
    private long endTime;
    private int mStatus = 0;
    RelativeLayout sXY;
    RelativeLayout sXZ;
    private int sXk;
    private String sXl;
    private a.AbstractC1040a sXn;
    RelativeLayout sYa;
    RelativeLayout sYb;
    private PreviewFrameLayout sYc;
    private FaceActionMask sYd;
    private MMTextureView sYe;
    ImageView sYf;
    private TextView sYg;
    private TextView sYh;
    ImageView sYi;
    private ImageView sYj;
    ImageView sYk;
    ImageView sYl;
    private Button sYm;
    private Button sYn;
    private TextView sYo;
    public boolean sYp = false;
    com.tencent.mm.plugin.facedetectlight.ui.a sYq;
    private int sYr;
    private int sYs;
    private String sYt;
    private int sYu;
    private String sYv = "";
    private int scene;
    private long startTime;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(FaceActionUI faceActionUI) {
        AppMethodBeat.i(104266);
        faceActionUI.cUb();
        AppMethodBeat.o(104266);
    }

    static /* synthetic */ int d(FaceActionUI faceActionUI) {
        int i2 = faceActionUI.sYu;
        faceActionUI.sYu = i2 + 1;
        return i2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a5m;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104250);
        Log.d("MicroMsg.FaceActionUI", "start VerifyActivity");
        super.onCreate(bundle);
        b.dLj().eqQ = 1;
        b.axn("enter");
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(2097280);
        this.scene = getIntent().getIntExtra("scene", 0);
        this.sYu = 0;
        this.startTime = Util.currentTicks();
        this.dGe = 4;
        if (Build.VERSION.SDK_INT >= 16) {
            getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        }
        setActionbarColor(getContext().getResources().getColor(R.color.afz));
        Log.d("MicroMsg.FaceActionUI", "initLayout");
        this.sYf = (ImageView) findViewById(R.id.y7);
        cUa();
        this.sXZ = (RelativeLayout) findViewById(R.id.ca5);
        this.sYa = (RelativeLayout) findViewById(R.id.ca6);
        this.sYb = (RelativeLayout) findViewById(R.id.ca4);
        this.sXZ.setVisibility(4);
        this.sYa.setVisibility(4);
        this.sYb.setVisibility(4);
        this.sYi = (ImageView) findViewById(R.id.c97);
        this.sYk = (ImageView) findViewById(R.id.c94);
        this.sYl = (ImageView) findViewById(R.id.c9d);
        this.sYo = (TextView) findViewById(R.id.c9b);
        this.sYm = (Button) findViewById(R.id.c9_);
        this.sYn = (Button) findViewById(R.id.c9a);
        if (!Util.isNullOrNil(d.sXz.dYL)) {
            this.sYn.setText(d.sXz.dYL);
            this.sYn.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(104245);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.FaceActionUI", "click mUploadFailedConfig");
                    FaceActionUI.this.sYp = true;
                    FaceActionUI.this.g("fail", FaceActionUI.this.sYs, "", FaceActionUI.this.sYv);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(104245);
                }
            });
        } else {
            this.sYn.setVisibility(8);
        }
        if (p.aj(this)) {
            Log.i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
            cTZ();
            AppMethodBeat.o(104250);
            return;
        }
        Log.i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
        AppMethodBeat.o(104250);
    }

    private void cTZ() {
        AppMethodBeat.i(104251);
        this.sXn = new a.AbstractC1040a() {
            /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass1 */
        };
        d.sXz.sXE = new d.a() {
            /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.facedetectaction.b.d.a
            public final void aX(final int i2, final String str) {
                AppMethodBeat.i(104238);
                Log.i("MicroMsg.FaceActionUI", "onInitFaceCheckFinish: %s", Integer.valueOf(i2));
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(104232);
                        FaceActionUI.this.sXk = i2;
                        FaceActionUI.this.sXl = str;
                        FaceActionUI.b(FaceActionUI.this);
                        FaceActionUI.c(FaceActionUI.this);
                        FaceActionUI.d(FaceActionUI.this);
                        AppMethodBeat.o(104232);
                    }
                });
                AppMethodBeat.o(104238);
            }

            @Override // com.tencent.mm.plugin.facedetectaction.b.d.a
            public final void cTY() {
                AppMethodBeat.i(104239);
                Log.i("MicroMsg.FaceActionUI", "onStartUpload");
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass3.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(104233);
                        FaceActionUI faceActionUI = FaceActionUI.this;
                        if (faceActionUI.sYq != null) {
                            com.tencent.mm.plugin.facedetectlight.ui.a aVar = faceActionUI.sYq;
                            Log.i("MicroMsg.FaceReflectCam", "stopPreview ,isPreview %s camera:%s", Boolean.valueOf(aVar.sZd), aVar.sZb);
                            if (aVar.sZb != null) {
                                aVar.sZd = false;
                                aVar.sZb.stopPreview();
                                aVar.sZb.setPreviewCallback(null);
                                aVar.sZm.removeCallbacksAndMessages(null);
                                c.sQB.aRR();
                            }
                        }
                        faceActionUI.sXY.setVisibility(8);
                        faceActionUI.sXZ.setVisibility(0);
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) faceActionUI.sYi.getHeight());
                        translateAnimation.setDuration(2000);
                        translateAnimation.setRepeatMode(2);
                        translateAnimation.setRepeatCount(-1);
                        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                        scaleAnimation.setDuration(1000);
                        scaleAnimation.setRepeatMode(2);
                        scaleAnimation.setRepeatCount(-1);
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(scaleAnimation);
                        animationSet.setAnimationListener(new Animation.AnimationListener() {
                            /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass8 */

                            public final void onAnimationEnd(Animation animation) {
                                AppMethodBeat.i(104246);
                                Log.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationEnd");
                                Log.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationEnd");
                                AppMethodBeat.o(104246);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationStart(Animation animation) {
                                AppMethodBeat.i(104247);
                                Log.d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationStart");
                                AppMethodBeat.o(104247);
                            }
                        });
                        animationSet.setRepeatCount(-1);
                        faceActionUI.sYk.startAnimation(animationSet);
                        AppMethodBeat.o(104233);
                    }
                });
                AppMethodBeat.o(104239);
            }

            @Override // com.tencent.mm.plugin.facedetectaction.b.d.a
            public final void a(final bnh bnh) {
                AppMethodBeat.i(186394);
                Log.i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", bnh.LpC);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass3.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(104234);
                        FaceActionUI.this.sYk.clearAnimation();
                        FaceActionUI faceActionUI = FaceActionUI.this;
                        faceActionUI.sXY.setVisibility(8);
                        faceActionUI.sYk.clearAnimation();
                        faceActionUI.sXZ.setVisibility(8);
                        faceActionUI.sYf.setVisibility(0);
                        faceActionUI.sYa.setVisibility(0);
                        faceActionUI.sYl.setScaleX(0.0f);
                        faceActionUI.sYl.setScaleY(0.0f);
                        faceActionUI.sYl.animate().scaleX(1.0f).scaleY(1.0f).setDuration(800);
                        FaceActionUI.this.sYv = bnh.LVU;
                        FaceActionUI faceActionUI2 = FaceActionUI.this;
                        String str = bnh.LpC;
                        String str2 = bnh.LVU;
                        Log.i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
                        Bundle bundle = new Bundle();
                        bundle.putString("token", str);
                        bundle.putString("serial_id", str2);
                        faceActionUI2.dGe = 0;
                        faceActionUI2.a("ok", 0, bundle, Boolean.valueOf(faceActionUI2.sYp));
                        AppMethodBeat.o(104234);
                    }
                });
                AppMethodBeat.o(186394);
            }

            @Override // com.tencent.mm.plugin.facedetectaction.b.d.a
            public final void a(int i2, final int i3, final String str, final String str2, final int i4) {
                AppMethodBeat.i(186395);
                Log.i("MicroMsg.FaceActionUI", "onError, err: %s, cgiErrCode: %s, cgiErrMsg: %s,retry: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4));
                FaceActionUI.this.sYr = i2;
                FaceActionUI.this.sYs = i3;
                FaceActionUI.this.sYt = str;
                FaceActionUI.this.sYv = str2;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass3.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(104237);
                        if (!Util.isNullOrNil(str)) {
                            FaceActionUI.this.sYo.setText(str);
                            FaceActionUI.this.dGe = 2;
                        } else {
                            FaceActionUI.this.sYo.setText(R.string.c44);
                        }
                        if (i4 == 1) {
                            FaceActionUI.this.sYm.setText(R.string.c6p);
                            FaceActionUI.this.sYm.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass3.AnonymousClass4.AnonymousClass1 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(104235);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.FaceActionUI", "click retry");
                                    FaceActionUI.i(FaceActionUI.this);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(104235);
                                }
                            });
                        } else {
                            FaceActionUI.this.sYm.setText(R.string.c6o);
                            FaceActionUI.this.sYm.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass3.AnonymousClass4.AnonymousClass2 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(104236);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.FaceActionUI", "click finish");
                                    FaceActionUI.this.g("fail", i3, "", str2);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(104236);
                                }
                            });
                        }
                        FaceActionUI.this.sYk.clearAnimation();
                        FaceActionUI faceActionUI = FaceActionUI.this;
                        faceActionUI.sXY.setVisibility(8);
                        faceActionUI.sYb.setVisibility(0);
                        faceActionUI.sYk.clearAnimation();
                        faceActionUI.sYf.setVisibility(0);
                        faceActionUI.sXZ.setVisibility(8);
                        d.sXz.mStatus = 3;
                        FaceActionUI.this.mStatus = 3;
                        AppMethodBeat.o(104237);
                    }
                });
                AppMethodBeat.o(186395);
            }
        };
        d.sXz.gte = this;
        d.sXz.a(this);
        AppMethodBeat.o(104251);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(104252);
        Log.d("MicroMsg.FaceActionUI", "onStart");
        super.onStart();
        if (this.sYq != null) {
            this.sYq.a(this.sYe);
            this.sYq.cUd();
        }
        AppMethodBeat.o(104252);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(104253);
        super.onResume();
        Log.d("MicroMsg.FaceActionUI", "onResume");
        cUb();
        AppMethodBeat.o(104253);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(104254);
        Log.d("MicroMsg.FaceActionUI", "onPause");
        super.onPause();
        AppMethodBeat.o(104254);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(104255);
        Log.i("MicroMsg.FaceActionUI", "onStop");
        super.onStop();
        if (this.sYq != null) {
            this.sYq.sTE = false;
        }
        AppMethodBeat.o(104255);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(104256);
        super.onDestroy();
        Log.i("MicroMsg.FaceActionUI", "onDestroy");
        d.sXz.release(true);
        AppMethodBeat.o(104256);
    }

    private void cUa() {
        AppMethodBeat.i(104257);
        this.sXY = (RelativeLayout) findViewById(R.id.c_7);
        this.sYc = (PreviewFrameLayout) findViewById(R.id.c9w);
        this.sYe = (MMTextureView) findViewById(R.id.c9v);
        this.sYe.setVisibility(4);
        this.sYd = (FaceActionMask) findViewById(R.id.c9x);
        this.sYj = (ImageView) findViewById(R.id.c8g);
        this.sYj.post(new Runnable() {
            /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(104242);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) FaceActionUI.this.sYj.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((double) FaceActionUI.this.sYd.getHeight()) * 0.4d);
                FaceActionUI.this.sYj.setLayoutParams(marginLayoutParams);
                FaceActionUI.this.sYj.setVisibility(0);
                AppMethodBeat.o(104242);
            }
        });
        this.sYg = (TextView) findViewById(R.id.c9y);
        this.sYg.post(new Runnable() {
            /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(104243);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) FaceActionUI.this.sYg.getLayoutParams();
                int height = ((int) (((double) FaceActionUI.this.sYd.getHeight()) * 0.4d)) + ((int) (((double) FaceActionUI.this.sYd.getWidth()) * 0.35d)) + at.fromDPToPix(FaceActionUI.this, 30);
                marginLayoutParams.topMargin = height;
                Log.i("MicroMsg.FaceActionUI", "topMargin：%d", Integer.valueOf(height));
                FaceActionUI.this.sYg.setLayoutParams(marginLayoutParams);
                FaceActionUI.this.sYg.setVisibility(0);
                AppMethodBeat.o(104243);
            }
        });
        this.sYh = (TextView) findViewById(R.id.c8f);
        this.sYh.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(104244);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (FaceActionUI.this.mStatus == 3) {
                    FaceActionUI.this.g("fail", FaceActionUI.this.sYs, "", FaceActionUI.this.sYv);
                } else {
                    d.sXz.onBackPressed();
                }
                FaceActionUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(104244);
            }
        });
        this.mStatus = 0;
        AppMethodBeat.o(104257);
    }

    public final void g(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(186396);
        Log.i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
        Bundle bundle = new Bundle();
        bundle.putString("token", str2);
        bundle.putString("serial_id", str3);
        a(str, i2, bundle, Boolean.valueOf(this.sYp));
        AppMethodBeat.o(186396);
    }

    public final void a(String str, final int i2, Bundle bundle, Boolean bool) {
        String str2;
        AppMethodBeat.i(104259);
        Log.i("MicroMsg.FaceActionUI", "finishWithResult errMsg: %s, errCode: %d", str, Integer.valueOf(i2));
        if (bool.booleanValue()) {
            str2 = "yes";
        } else {
            str2 = "no";
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("click_other_verify_btn", str2);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Log.i("MicroMsg.FaceActionUI", "seriaId:%s", this.sYv);
        bundle2.putString("serial_id", this.sYv);
        c(str, i2, bundle2);
        if (i2 == 0) {
            Log.i("MicroMsg.FaceActionUI", "errCode == ConstantsFace.UploadErrCode.OK");
            h.RTc.n(new Runnable() {
                /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(104249);
                    b.MX(i2);
                    FaceActionUI.this.finish();
                    AppMethodBeat.o(104249);
                }
            }, 1500);
            AppMethodBeat.o(104259);
            return;
        }
        b.MX(i2);
        finish();
        AppMethodBeat.o(104259);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void c(String str, int i2, Bundle bundle) {
        char c2;
        AppMethodBeat.i(104260);
        Intent d2 = d(str, i2, bundle);
        switch (str.hashCode()) {
            case -1367724422:
                if (str.equals("cancel")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3548:
                if (str.equals("ok")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3135262:
                if (str.equals("fail")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                setResult(-1, d2);
                AppMethodBeat.o(104260);
                return;
            case 1:
                setResult(1, d2);
                AppMethodBeat.o(104260);
                return;
            case 2:
                b.axn("usrCancel");
                setResult(0, d2);
                AppMethodBeat.o(104260);
                return;
            default:
                setResult(-1, d2);
                AppMethodBeat.o(104260);
                return;
        }
    }

    private Intent d(String str, int i2, Bundle bundle) {
        AppMethodBeat.i(104261);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_code", i2);
        bundle2.putString("err_msg", str);
        bundle2.putInt("scene", this.scene);
        bundle2.putInt("countFace", this.sYu);
        bundle2.putInt("err_type", this.dGe);
        this.endTime = Util.currentTicks();
        Log.i("MicroMsg.FaceActionUI", "endTime：" + this.endTime);
        Log.i("MicroMsg.FaceActionUI", "startTime：" + this.startTime);
        bundle2.putLong("totalTime", this.endTime - this.startTime);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        AppMethodBeat.o(104261);
        return intent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(104262);
        if (this.mStatus == 3) {
            g("fail", this.sYs, "", this.sYv);
        } else {
            d.sXz.onBackPressed();
        }
        finish();
        AppMethodBeat.o(104262);
    }

    private void cUb() {
        AppMethodBeat.i(104263);
        Log.i("MicroMsg.FaceActionUI", "preview");
        if (this.sYq != null) {
            this.sYq.sZd = true;
            Log.i("MicroMsg.FaceActionUI", "mCamera ！= null");
        }
        this.sYg.setText(R.string.c6h);
        AppMethodBeat.o(104263);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean z;
        AppMethodBeat.i(104264);
        Log.i("MicroMsg.FaceActionUI", "carson onRequestPermissionsResult");
        if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.o(104264);
            return;
        }
        switch (i2) {
            case 23:
                String str = "";
                String str2 = "";
                if (iArr.length != 1) {
                    if (iArr.length == 2) {
                        if (iArr[0] == 0 && iArr[1] == 0) {
                            z = true;
                        } else {
                            if (iArr[0] != 0) {
                                str = "camera permission not granted";
                                str2 = getString(R.string.fl0);
                            }
                            if (iArr[1] != 0) {
                                str = "audio permission not granted";
                                str2 = getString(R.string.flb);
                            }
                            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                                str = "both camera and audio permission not granted";
                                str2 = getString(R.string.fl0);
                            }
                        }
                    }
                    Log.i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(str)));
                    Log.i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(str2)));
                    Log.i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
                    this.sYo.setText(str2);
                    this.sYm.setText(R.string.c6o);
                    this.sYm.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass9 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(104248);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.FaceActionUI", "click finish");
                            FaceActionUI.this.g("fail", 90010, "", "");
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(104248);
                        }
                    });
                    this.sXY.setVisibility(8);
                    this.sYb.setVisibility(0);
                    this.sYk.clearAnimation();
                    this.sYf.setVisibility(0);
                    this.sXZ.setVisibility(8);
                    z = false;
                } else if (iArr[0] == 0) {
                    z = true;
                } else {
                    if (strArr[0].equals("android.permission.CAMERA")) {
                        str = "camera permission not granted";
                        str2 = getString(R.string.fl0);
                    } else if (strArr[0].equals("android.permission.RECORD_AUDIO")) {
                        str = "audio permission not granted";
                        str2 = getString(R.string.flb);
                    }
                    Log.i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(str)));
                    Log.i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(str2)));
                    Log.i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
                    this.sYo.setText(str2);
                    this.sYm.setText(R.string.c6o);
                    this.sYm.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.AnonymousClass9 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(104248);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.FaceActionUI", "click finish");
                            FaceActionUI.this.g("fail", 90010, "", "");
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(104248);
                        }
                    });
                    this.sXY.setVisibility(8);
                    this.sYb.setVisibility(0);
                    this.sYk.clearAnimation();
                    this.sYf.setVisibility(0);
                    this.sXZ.setVisibility(8);
                    z = false;
                }
                if (z) {
                    cTZ();
                    break;
                }
                break;
        }
        AppMethodBeat.o(104264);
    }

    static /* synthetic */ void b(FaceActionUI faceActionUI) {
        AppMethodBeat.i(104265);
        Log.d("MicroMsg.FaceActionUI", "initCamera");
        faceActionUI.sYq = new com.tencent.mm.plugin.facedetectlight.ui.a(faceActionUI, faceActionUI.sXn);
        faceActionUI.sYq.sZe = faceActionUI.sYg;
        faceActionUI.sYq.sYd = faceActionUI.sYd;
        faceActionUI.sYq.sZg = faceActionUI.sYc;
        faceActionUI.sYq.sXk = faceActionUI.sXk;
        faceActionUI.sYq.sXl = faceActionUI.sXl;
        faceActionUI.sYq.sZi = faceActionUI.sYj;
        faceActionUI.sYq.pcg = faceActionUI.sYf;
        faceActionUI.sYq.a(faceActionUI.sYe);
        faceActionUI.sYq.cUd();
        AppMethodBeat.o(104265);
    }

    static /* synthetic */ void i(FaceActionUI faceActionUI) {
        AppMethodBeat.i(186397);
        d.sXz.release(false);
        if (faceActionUI.sYq != null) {
            faceActionUI.sYq.aPK();
        }
        faceActionUI.sXZ.setVisibility(8);
        faceActionUI.sYb.setVisibility(8);
        faceActionUI.sXY.setVisibility(0);
        faceActionUI.cUa();
        d.sXz.a(faceActionUI);
        AppMethodBeat.o(186397);
    }
}
