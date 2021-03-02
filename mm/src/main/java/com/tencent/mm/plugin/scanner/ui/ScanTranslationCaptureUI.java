package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.protobuf.ekt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class ScanTranslationCaptureUI extends MMActivity implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, i, k.b {
    private View CMA;
    private View CMB;
    private View CMC;
    private ImageView CMD;
    private View CME;
    private View CMF;
    private View CMG;
    private TextView CMH;
    private Bitmap CMI;
    private Bitmap CMJ;
    private String CMK;
    private a CML;
    private MMGestureGallery CMM;
    private ValueAnimator CMN;
    private int CMO;
    private String CMP;
    private boolean CMQ;
    private int CMR = 0;
    private go CMS = new go();
    private long[] CMT = new long[2];
    private IListener<pn> CMU = new IListener<pn>() {
        /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161738);
            this.__eventId = pn.class.getName().hashCode();
            AppMethodBeat.o(161738);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pn pnVar) {
            Bitmap decodeFile;
            AppMethodBeat.i(120863);
            if (pnVar.dVF.action == 2) {
                Log.i("MicroMsg.ScanTranslationCaptureUI", "receive play open translate anim event");
                String stringExtra = ScanTranslationCaptureUI.this.getIntent().getStringExtra("key_first_background");
                if (!Util.isNullOrNil(stringExtra) && (decodeFile = BitmapUtil.decodeFile(stringExtra, new BitmapFactory.Options())) != null) {
                    ScanTranslationCaptureUI.this.CMM.setVisibility(0);
                    ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, decodeFile);
                    s.deleteFile(stringExtra);
                }
                ScanTranslationCaptureUI.this.jWj.setAlpha(1.0f);
                ScanTranslationCaptureUI.this.CMN.start();
                ScanTranslationCaptureUI.this.CMw.setVisibility(0);
                ScanTranslationCaptureUI.this.CMQ = true;
                AppMethodBeat.o(120863);
                return true;
            }
            AppMethodBeat.o(120863);
            return false;
        }
    };
    private MMTextureView CMw;
    private com.tencent.mm.plugin.scanner.a.a CMx;
    private View CMy;
    private View CMz;
    private int iOu;
    private int ijt = 0;
    private View jWj;
    private String jrK;
    private boolean kgv = true;
    private int mEY;
    private int source = 0;
    private SurfaceTexture surfaceTexture;
    private ImageView tgP;
    private ValueAnimator tgS;
    private p tgU = new p.a() {
        /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass12 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(120878);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass12.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(120877);
                    if (!(g.azz().aYS() == 6 || g.azz().aYS() == 4 || ScanTranslationCaptureUI.this.iOu != 1)) {
                        h.c(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(R.string.gd1), "", true);
                        ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
                    }
                    AppMethodBeat.o(120877);
                }
            });
            AppMethodBeat.o(120878);
        }
    };
    private String xCU;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ScanTranslationCaptureUI() {
        AppMethodBeat.i(120893);
        AppMethodBeat.o(120893);
    }

    static /* synthetic */ void A(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.i(120928);
        scanTranslationCaptureUI.eQQ();
        AppMethodBeat.o(120928);
    }

    static /* synthetic */ void a(ScanTranslationCaptureUI scanTranslationCaptureUI, Bitmap bitmap) {
        AppMethodBeat.i(120923);
        scanTranslationCaptureUI.an(bitmap);
        AppMethodBeat.o(120923);
    }

    static /* synthetic */ void f(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.i(120924);
        scanTranslationCaptureUI.eQU();
        AppMethodBeat.o(120924);
    }

    static /* synthetic */ void g(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.i(120925);
        scanTranslationCaptureUI.goBack();
        AppMethodBeat.o(120925);
    }

    static /* synthetic */ void v(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.i(120926);
        scanTranslationCaptureUI.eQV();
        AppMethodBeat.o(120926);
    }

    static /* synthetic */ void z(ScanTranslationCaptureUI scanTranslationCaptureUI) {
        AppMethodBeat.i(120927);
        scanTranslationCaptureUI.aPK();
        AppMethodBeat.o(120927);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(120894);
        customfixStatusbar(true);
        super.onCreate(bundle);
        this.CMx = new com.tencent.mm.plugin.scanner.a.a();
        initView();
        EventCenter.instance.addListener(this.CMU);
        this.CMS.eDV = 3;
        AppMethodBeat.o(120894);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(120895);
        this.jWj = findViewById(R.id.h8y);
        this.jWj.setAlpha(0.0f);
        this.CMw = (MMTextureView) findViewById(R.id.iv8);
        this.CMw.setOpaque(false);
        this.CMw.setSurfaceTextureListener(this);
        this.CMM = (MMGestureGallery) findViewById(R.id.iv_);
        this.CML = new a(this, (byte) 0);
        this.CMM.setAdapter((SpinnerAdapter) this.CML);
        this.CMB = findViewById(R.id.aj7);
        this.CMy = findViewById(R.id.haz);
        this.CMy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass18 */

            public final void onClick(View view) {
                AppMethodBeat.i(120884);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ScanTranslationCaptureUI.g(ScanTranslationCaptureUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120884);
            }
        });
        this.CMz = findViewById(R.id.h_z);
        this.CMz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass19 */

            public final void onClick(View view) {
                AppMethodBeat.i(120885);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ScanTranslationCaptureUI.this.CMx.a(ScanTranslationCaptureUI.this);
                ScanTranslationCaptureUI.this.CMS.eJT = (long) ((int) (System.currentTimeMillis() - ScanTranslationCaptureUI.this.CMT[0]));
                ScanTranslationCaptureUI.this.CMS.eDV = 1;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120885);
            }
        });
        this.CMz.setEnabled(false);
        this.CMH = (TextView) findViewById(R.id.ha0);
        this.CMA = findViewById(R.id.hb0);
        this.CMA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass20 */

            public final void onClick(View view) {
                AppMethodBeat.i(120886);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.pluginsdk.ui.tools.s.a(ScanTranslationCaptureUI.this, 561, 1, 0, 1, (Intent) null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120886);
            }
        });
        this.CMC = findViewById(R.id.h_h);
        this.CMD = (ImageView) this.CMC.findViewById(R.id.ive);
        this.CMD.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass21 */

            public final void onClick(View view) {
                AppMethodBeat.i(120887);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ScanTranslationCaptureUI.this.iOu == 3) {
                    if (ScanTranslationCaptureUI.this.CMI != null) {
                        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.CMI);
                    }
                    if (ScanTranslationCaptureUI.this.CMP.equalsIgnoreCase(LocaleUtil.CHINA)) {
                        ScanTranslationCaptureUI.this.CMD.setImageResource(R.raw.translation_result_chinese_highlighted);
                    } else {
                        ScanTranslationCaptureUI.this.CMD.setImageResource(R.raw.translation_result_english_highlighted);
                    }
                    ScanTranslationCaptureUI.this.iOu = 2;
                    ScanTranslationCaptureUI.this.CMS.eJX++;
                } else if (ScanTranslationCaptureUI.this.iOu == 2) {
                    if (ScanTranslationCaptureUI.this.CMJ != null) {
                        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.CMJ);
                    }
                    if (ScanTranslationCaptureUI.this.CMP.equalsIgnoreCase(LocaleUtil.CHINA)) {
                        ScanTranslationCaptureUI.this.CMD.setImageResource(R.drawable.b0s);
                    } else {
                        ScanTranslationCaptureUI.this.CMD.setImageResource(R.drawable.b0u);
                    }
                    ScanTranslationCaptureUI.this.iOu = 3;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120887);
            }
        });
        this.CMF = findViewById(R.id.ivd);
        this.CMG = findViewById(R.id.iv7);
        hideTitleView();
        setMMTitle(R.string.gbs);
        setActionbarColor(getResources().getColor(R.color.ac_));
        this.tgP = (ImageView) findViewById(R.id.ha7);
        this.CME = this.CMC.findViewById(R.id.iv9);
        this.CME.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass22 */

            public final void onClick(View view) {
                AppMethodBeat.i(120888);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ScanTranslationCaptureUI.this.iOu == 2) {
                    try {
                        ScanTranslationCaptureUI.this.CMS.eJZ = 1;
                        com.tencent.mm.platformtools.p.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.jrK, new p.a() {
                            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass22.AnonymousClass1 */

                            @Override // com.tencent.mm.platformtools.p.a
                            public final void bP(String str, String str2) {
                                AppMethodBeat.i(200112);
                                com.tencent.mm.ui.widget.snackbar.b.r(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(R.string.ge7));
                                AppMethodBeat.o(200112);
                            }

                            @Override // com.tencent.mm.platformtools.p.a
                            public final void bQ(String str, String str2) {
                            }
                        });
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e2, "copy to gallery error", new Object[0]);
                    }
                } else if (ScanTranslationCaptureUI.this.iOu == 3) {
                    try {
                        ScanTranslationCaptureUI.this.CMS.eJY = 1;
                        if (ScanTranslationCaptureUI.this.source == 0) {
                            try {
                                ScanTranslationCaptureUI.this.CMK = ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
                                BitmapUtil.saveBitmapToImage(ScanTranslationCaptureUI.this.CMJ, 80, Bitmap.CompressFormat.JPEG, ScanTranslationCaptureUI.this.CMK, false);
                            } catch (IOException e3) {
                                Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e3, "save translate result file error", new Object[0]);
                            }
                        }
                        com.tencent.mm.platformtools.p.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.CMK, new p.a() {
                            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass22.AnonymousClass2 */

                            @Override // com.tencent.mm.platformtools.p.a
                            public final void bP(String str, String str2) {
                                AppMethodBeat.i(200113);
                                com.tencent.mm.ui.widget.snackbar.b.r(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(R.string.ge7));
                                AppMethodBeat.o(200113);
                            }

                            @Override // com.tencent.mm.platformtools.p.a
                            public final void bQ(String str, String str2) {
                            }
                        });
                    } catch (Exception e4) {
                        Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e4, "save to gallery error", new Object[0]);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120888);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass23 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(120889);
                ScanTranslationCaptureUI.g(ScanTranslationCaptureUI.this);
                AppMethodBeat.o(120889);
                return true;
            }
        });
        this.mEY = getWindowManager().getDefaultDisplay().getHeight();
        this.tgS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.tgS.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass24 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(120890);
                ScanTranslationCaptureUI.this.tgP.setAlpha(0.0f);
                AppMethodBeat.o(120890);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(120891);
                ScanTranslationCaptureUI.this.tgP.setAlpha(0.0f);
                AppMethodBeat.o(120891);
            }
        });
        this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(120864);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue <= 0.1f) {
                    ScanTranslationCaptureUI.this.tgP.setAlpha(floatValue * 10.0f);
                } else if (floatValue >= 0.9f) {
                    ScanTranslationCaptureUI.this.tgP.setAlpha((1.0f - floatValue) * 10.0f);
                }
                ScanTranslationCaptureUI.this.tgP.setTranslationY(floatValue * ((float) (ScanTranslationCaptureUI.this.mEY - ScanTranslationCaptureUI.this.tgP.getHeight())));
                AppMethodBeat.o(120864);
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.CMC.getLayoutParams();
        layoutParams.bottomMargin += ao.aD(this);
        this.CMC.setLayoutParams(layoutParams);
        this.tgS.setDuration(5000L);
        com.tencent.mm.ui.base.b.a(this, null);
        this.jWj.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(120866);
                if (ScanTranslationCaptureUI.this.iOu == 0 && view == ScanTranslationCaptureUI.this.jWj) {
                    if (motionEvent.getAction() == 0) {
                        Log.i("MicroMsg.ScanTranslationCaptureUI", "event down, (%f, %f)", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                        ScanTranslationCaptureUI.this.CMx.a(motionEvent.getX() / ((float) ScanTranslationCaptureUI.this.jWj.getWidth()), motionEvent.getY() / ((float) ScanTranslationCaptureUI.this.jWj.getHeight()), new Camera.AutoFocusCallback() {
                            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass3.AnonymousClass1 */

                            public final void onAutoFocus(boolean z, Camera camera) {
                                AppMethodBeat.i(120865);
                                Log.i("MicroMsg.ScanTranslationCaptureUI", "camera auto focus call back");
                                ScanTranslationCaptureUI.this.CMx.cancelAutoFocus();
                                ScanTranslationCaptureUI.this.CMx.ePB();
                                AppMethodBeat.o(120865);
                            }
                        });
                    }
                    AppMethodBeat.o(120866);
                    return true;
                }
                AppMethodBeat.o(120866);
                return false;
            }
        });
        eQP();
        this.CMN = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.CMN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass4 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(120867);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int height = ((RelativeLayout.LayoutParams) ScanTranslationCaptureUI.this.CMB.getLayoutParams()).bottomMargin + ScanTranslationCaptureUI.this.CMB.getHeight();
                ScanTranslationCaptureUI.this.CMB.setTranslationY(((float) height) * floatValue);
                ScanTranslationCaptureUI.this.CMH.setTranslationY(((float) (((RelativeLayout.LayoutParams) ScanTranslationCaptureUI.this.CMH.getLayoutParams()).bottomMargin + ScanTranslationCaptureUI.this.CMH.getHeight() + height)) * floatValue);
                AppMethodBeat.o(120867);
            }
        });
        this.CMN.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass5 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(120868);
                ScanTranslationCaptureUI.this.CMQ = false;
                ScanTranslationCaptureUI.this.CMM.setVisibility(8);
                AppMethodBeat.o(120868);
            }
        });
        this.CMN.setDuration(300L);
        pn pnVar = new pn();
        pnVar.dVF.action = 1;
        EventCenter.instance.publish(pnVar);
        AppMethodBeat.o(120895);
    }

    private void eQP() {
        AppMethodBeat.i(120896);
        LocaleUtil.getApplicationLanguage().equalsIgnoreCase(LocaleUtil.CHINA);
        this.CMP = LocaleUtil.getCurrentLanguage(this);
        Log.i("MicroMsg.ScanTranslationCaptureUI", "targetLang %s", this.CMP);
        AppMethodBeat.o(120896);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(120897);
        super.onResume();
        f.e(true, true, true);
        KD();
        g.azz().a(294, this);
        g.aAg().a(this.tgU);
        if (this.kgv) {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, (String) null, (String) null);
            Log.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(a2));
            if (!a2) {
                AppMethodBeat.o(120897);
                return;
            }
            eHs();
            AppMethodBeat.o(120897);
            return;
        }
        eQS();
        AppMethodBeat.o(120897);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(120898);
        super.onPause();
        f.e(false, true, true);
        AppMethodBeat.o(120898);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(120899);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(120899);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(120899);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(120900);
        super.onStop();
        aPK();
        g.azz().b(294, this);
        EventCenter.instance.removeListener(this.CMU);
        g.aAg().b(this.tgU);
        AppMethodBeat.o(120900);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(120901);
        super.onDestroy();
        this.CMN.removeAllUpdateListeners();
        this.tgS.removeAllUpdateListeners();
        AppMethodBeat.o(120901);
    }

    private void goBack() {
        AppMethodBeat.i(120902);
        ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).getTranslationRender().eRW();
        if (this.iOu != 0) {
            if (this.iOu == 1 || this.iOu == 2 || this.iOu == 3) {
                if (this.iOu == 1) {
                    this.CMS.eJW = (long) ((int) (System.currentTimeMillis() - this.CMT[1]));
                }
                if (this.CMS.eEt != 0) {
                    this.CMS.bfK();
                }
                eQU();
            }
            AppMethodBeat.o(120902);
        } else if (this.CMQ) {
            Log.i("MicroMsg.ScanTranslationCaptureUI", "is playing animation");
            AppMethodBeat.o(120902);
        } else {
            this.CMN.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass8 */

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(120874);
                    pn pnVar = new pn();
                    pnVar.dVF.action = 3;
                    EventCenter.instance.publish(pnVar);
                    ScanTranslationCaptureUI.this.CMQ = false;
                    ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
                    ScanTranslationCaptureUI.this.finish();
                    AppMethodBeat.o(120874);
                }
            });
            this.CMN.reverse();
            this.CMQ = true;
            AppMethodBeat.o(120902);
        }
    }

    private void eHs() {
        AppMethodBeat.i(120903);
        if (!com.tencent.mm.compatible.e.b.apj()) {
            h.a((Context) this, getString(R.string.z6), getString(R.string.x0), getString(R.string.x1), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(120875);
                    com.tencent.mm.compatible.e.b.cw(ScanTranslationCaptureUI.this);
                    ScanTranslationCaptureUI.this.finish();
                    AppMethodBeat.o(120875);
                }
            });
            AppMethodBeat.o(120903);
            return;
        }
        eQS();
        AppMethodBeat.o(120903);
    }

    private void eQQ() {
        AppMethodBeat.i(120904);
        try {
            if (!this.CMx.isOpen()) {
                long currentTimeMillis = System.currentTimeMillis();
                this.CMx.aqD(getWindowManager().getDefaultDisplay().getRotation());
                this.CMx.a(new Camera.PreviewCallback() {
                    /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass10 */

                    public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    }
                });
                Log.i("MicroMsg.ScanTranslationCaptureUI", "open camera cost %s, failed count %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.CMR));
                this.CMx.ePB();
                Rect rect = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.CMx.p(new Point(rect.width(), rect.height()));
                if (this.iOu == 0) {
                    eQU();
                }
                this.CMR = 0;
            }
            AppMethodBeat.o(120904);
        } catch (Exception e2) {
            Log.e("MicroMsg.ScanTranslationCaptureUI", e2.getMessage());
            this.CMR++;
            if (this.CMR >= 5) {
                eQR();
                AppMethodBeat.o(120904);
                return;
            }
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass11 */

                public final void run() {
                    AppMethodBeat.i(120876);
                    ScanTranslationCaptureUI.A(ScanTranslationCaptureUI.this);
                    AppMethodBeat.o(120876);
                }
            }, 30);
            AppMethodBeat.o(120904);
        }
    }

    private void aPK() {
        AppMethodBeat.i(120905);
        try {
            stopPreview();
            this.CMx.close();
            AppMethodBeat.o(120905);
        } catch (Exception e2) {
            Log.e("MicroMsg.ScanTranslationCaptureUI", e2.getMessage());
            AppMethodBeat.o(120905);
        }
    }

    private void stopPreview() {
        AppMethodBeat.i(120906);
        try {
            if (this.CMx.dEO()) {
                this.CMx.stopPreview();
            }
            AppMethodBeat.o(120906);
        } catch (Exception e2) {
            Log.e("MicroMsg.ScanTranslationCaptureUI", e2.getMessage());
            AppMethodBeat.o(120906);
        }
    }

    private void startPreview() {
        AppMethodBeat.i(120907);
        try {
            if (this.surfaceTexture == null || !this.CMx.isOpen() || this.CMx.dEO()) {
                Log.i("MicroMsg.ScanTranslationCaptureUI", "can not start preview");
                AppMethodBeat.o(120907);
                return;
            }
            Log.i("MicroMsg.ScanTranslationCaptureUI", "start preview");
            this.CMx.r(this.surfaceTexture);
            this.CMz.setEnabled(true);
            AppMethodBeat.o(120907);
        } catch (Exception e2) {
            Log.e("MicroMsg.ScanTranslationCaptureUI", e2.getMessage());
            eQR();
            AppMethodBeat.o(120907);
        }
    }

    private void eQR() {
        AppMethodBeat.i(120908);
        h.a((Context) this, getString(R.string.gdb), getString(R.string.zb), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass13 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(120879);
                ScanTranslationCaptureUI.z(ScanTranslationCaptureUI.this);
                ScanTranslationCaptureUI.this.finish();
                ScanTranslationCaptureUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(120879);
            }
        });
        AppMethodBeat.o(120908);
    }

    private void eQS() {
        AppMethodBeat.i(120909);
        Log.i("MicroMsg.ScanTranslationCaptureUI", "curState %d", Integer.valueOf(this.iOu));
        if (!this.CMx.isOpen()) {
            eQQ();
        }
        if (this.iOu == 0 && this.CMx.isOpen()) {
            eQU();
        }
        AppMethodBeat.o(120909);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(120910);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(120910);
            return;
        }
        Log.i("MicroMsg.ScanTranslationCaptureUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 16:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    this.kgv = false;
                    h.a((Context) this, getString(R.string.fl0), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass14 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(120880);
                            ScanTranslationCaptureUI scanTranslationCaptureUI = ScanTranslationCaptureUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(scanTranslationCaptureUI, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$21", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            scanTranslationCaptureUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(scanTranslationCaptureUI, "com/tencent/mm/plugin/scanner/ui/ScanTranslationCaptureUI$21", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            ScanTranslationCaptureUI.this.kgv = true;
                            ScanTranslationCaptureUI.this.finish();
                            AppMethodBeat.o(120880);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass15 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(120881);
                            ScanTranslationCaptureUI.this.kgv = true;
                            ScanTranslationCaptureUI.this.finish();
                            AppMethodBeat.o(120881);
                        }
                    });
                    break;
                } else {
                    eHs();
                    AppMethodBeat.o(120910);
                    return;
                }
                break;
        }
        AppMethodBeat.o(120910);
    }

    private void KD() {
        AppMethodBeat.i(120911);
        getWindow().addFlags(2097280);
        int i2 = 1798;
        if (Build.VERSION.SDK_INT >= 19) {
            i2 = 5894;
        }
        getWindow().getDecorView().setSystemUiVisibility(i2);
        AppMethodBeat.o(120911);
    }

    private void eQT() {
        AppMethodBeat.i(120912);
        getController().setNavigationbarColor(getResources().getColor(R.color.ac_));
        getWindow().getDecorView().setSystemUiVisibility(1796);
        AppMethodBeat.o(120912);
    }

    private void cWg() {
        AppMethodBeat.i(120913);
        stopPreview();
        if (g.azz().aYS() == 6 || g.azz().aYS() == 4) {
            this.CMS.eEt = 2;
            this.CMO = (int) ((((long) z.aTY().hashCode()) + System.currentTimeMillis()) & -1);
            this.iOu = 1;
            showTitleView();
            eQT();
            eQP();
            if (this.CMP.equalsIgnoreCase(LocaleUtil.CHINA)) {
                this.CMD.setImageResource(R.raw.translation_result_chinese);
            } else {
                this.CMD.setImageResource(R.raw.translation_result_english);
            }
            this.CMF.setVisibility(0);
            this.CMG.setVisibility(0);
            this.CMC.setVisibility(8);
            this.tgP.setVisibility(0);
            this.CMB.setVisibility(8);
            this.CMM.setVisibility(0);
            this.CMH.setVisibility(8);
            this.tgS.setRepeatMode(1);
            this.tgS.setRepeatCount(-1);
            this.tgS.start();
            try {
                if (!Util.isNullOrNil(this.jrK) && this.CMI != null) {
                    this.xCU = com.tencent.mm.plugin.scanner.util.p.aMv(this.jrK);
                    final String str = this.jrK;
                    if (this.source == 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        BitmapUtil.saveBitmapToImage(this.CMI, 80, Bitmap.CompressFormat.JPEG, this.jrK, false);
                        Log.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                        Log.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", Long.valueOf(s.boW(this.jrK)));
                    } else if (this.source == 1) {
                        fx aMG = ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).getTranslationResultStorage().aMG(MD5Util.getMD5String(this.jrK + s.boX(this.jrK)));
                        if (aMG != null) {
                            Log.i("MicroMsg.ScanTranslationCaptureUI", "already has translation result");
                            this.CMK = aMG.field_resultFile;
                            this.CMJ = BitmapUtil.decodeFile(this.CMK, new BitmapFactory.Options());
                            if (this.CMJ != null) {
                                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                    /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass6 */

                                    public final void run() {
                                        AppMethodBeat.i(120869);
                                        ScanTranslationCaptureUI.v(ScanTranslationCaptureUI.this);
                                        ScanTranslationCaptureUI.a(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.CMJ);
                                        AppMethodBeat.o(120869);
                                    }
                                }, 500);
                            } else {
                                Log.w("MicroMsg.ScanTranslationCaptureUI", "can not find old translation result!");
                            }
                        }
                        if (this.ijt != 0) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            String genScanTmpImgPath = ((com.tencent.mm.plugin.scanner.f) g.ah(com.tencent.mm.plugin.scanner.f.class)).genScanTmpImgPath("jpg");
                            BitmapUtil.saveBitmapToImage(this.CMI, 80, Bitmap.CompressFormat.JPEG, genScanTmpImgPath, false);
                            Log.i("MicroMsg.ScanTranslationCaptureUI", "save img cost %d", Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis2)));
                            Log.i("MicroMsg.ScanTranslationCaptureUI", "fileSize %d", Long.valueOf(s.boW(genScanTmpImgPath)));
                            str = genScanTmpImgPath;
                        }
                    }
                    this.CMT[1] = System.currentTimeMillis();
                    ((com.tencent.mm.plugin.scanner.f) g.ah(com.tencent.mm.plugin.scanner.f.class)).getScanCdnService().a(this.xCU, str, com.tencent.mm.i.a.MediaType_IMAGE, new p.a() {
                        /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass7 */

                        @Override // com.tencent.mm.plugin.scanner.util.p.a
                        public final void a(String str, p.b bVar) {
                            AppMethodBeat.i(120873);
                            if (!Util.isNullOrNil(str) && str.equals(ScanTranslationCaptureUI.this.xCU)) {
                                ScanTranslationCaptureUI.this.CMS.eJU = (long) ((int) (System.currentTimeMillis() - ScanTranslationCaptureUI.this.CMT[1]));
                                Log.i("MicroMsg.ScanTranslationCaptureUI", "upload img cost %d", Long.valueOf(ScanTranslationCaptureUI.this.CMS.eJU));
                                ScanTranslationCaptureUI.this.CMS.uq(bVar.fileId);
                                ScanTranslationCaptureUI.this.CMS.ur(bVar.aeskey);
                                switch (bVar.errCode) {
                                    case -21009:
                                    case -21000:
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass7.AnonymousClass2 */

                                            public final void run() {
                                                AppMethodBeat.i(120872);
                                                h.d(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(R.string.cdr), ScanTranslationCaptureUI.this.getString(R.string.zb), new DialogInterface.OnClickListener() {
                                                    /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass7.AnonymousClass2.AnonymousClass1 */

                                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                                        AppMethodBeat.i(120871);
                                                        ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
                                                        AppMethodBeat.o(120871);
                                                    }
                                                });
                                                AppMethodBeat.o(120872);
                                            }
                                        });
                                        ScanTranslationCaptureUI.this.CMS.eEt = 3;
                                        break;
                                    case 0:
                                        if (Util.isNullOrNil(bVar.fileId, bVar.aeskey)) {
                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass7.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(120870);
                                                    ScanTranslationCaptureUI.this.CMS.eEt = 3;
                                                    h.cD(ScanTranslationCaptureUI.this, ScanTranslationCaptureUI.this.getString(R.string.ge4));
                                                    AppMethodBeat.o(120870);
                                                }
                                            });
                                            break;
                                        } else {
                                            Log.i("MicroMsg.ScanTranslationCaptureUI", "fileId %s", bVar.fileId);
                                            g.azz().a(new m(ScanTranslationCaptureUI.this.CMO, (int) s.boW(str), bVar.fileId, bVar.aeskey), 0);
                                            break;
                                        }
                                }
                                if (ScanTranslationCaptureUI.this.iOu == 1 && ScanTranslationCaptureUI.this.ijt != 0) {
                                    Log.i("delete tmp path %s", str);
                                    s.deleteFile(str);
                                }
                            }
                            AppMethodBeat.o(120873);
                        }
                    });
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e2, "", new Object[0]);
            }
            g.azz().a(294, this);
            AppMethodBeat.o(120913);
            return;
        }
        h.c(this, getString(R.string.gd1), "", true);
        eQU();
        AppMethodBeat.o(120913);
    }

    private void eQU() {
        AppMethodBeat.i(120914);
        KD();
        startPreview();
        hideTitleView();
        this.CMT[0] = System.currentTimeMillis();
        if (this.source == 0 && !Util.isNullOrNil(this.jrK)) {
            s.deleteFile(this.jrK);
        }
        this.iOu = 0;
        this.source = 0;
        this.jrK = null;
        this.CMK = null;
        this.CMI = null;
        this.CMJ = null;
        this.ijt = 0;
        this.CMF.setVisibility(8);
        this.CMG.setVisibility(8);
        this.CMB.setVisibility(0);
        this.CMC.setVisibility(8);
        this.CMM.setVisibility(8);
        this.CMw.setVisibility(0);
        this.CMH.setVisibility(0);
        this.tgP.setVisibility(8);
        cWj();
        g.azz().b(294, this);
        AppMethodBeat.o(120914);
    }

    private void eQV() {
        AppMethodBeat.i(120915);
        eQT();
        this.iOu = 3;
        this.CMC.setVisibility(0);
        if (this.CMP.equalsIgnoreCase(LocaleUtil.CHINA)) {
            this.CMD.setImageResource(R.drawable.b0s);
        } else {
            this.CMD.setImageResource(R.drawable.b0u);
        }
        this.tgP.setVisibility(8);
        cWj();
        if (this.source == 1 && Util.isNullOrNil(this.CMK)) {
            this.CMK = ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
            try {
                BitmapUtil.saveBitmapToImage(this.CMJ, 80, Bitmap.CompressFormat.JPEG, this.CMK, false);
                aj ajVar = new aj();
                ajVar.field_originMD5 = MD5Util.getMD5String(this.jrK + s.boX(this.jrK));
                ajVar.field_resultFile = this.CMK;
                Log.i("MicroMsg.ScanTranslationCaptureUI", "insert translate result %s", this.CMK);
                ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).getTranslationResultStorage().a(ajVar);
                AppMethodBeat.o(120915);
                return;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e2, "save translate result file error", new Object[0]);
            }
        }
        AppMethodBeat.o(120915);
    }

    private void cWj() {
        AppMethodBeat.i(120916);
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(0);
        this.tgS.end();
        AppMethodBeat.o(120916);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bo9;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture2, int i2, int i3) {
        AppMethodBeat.i(120917);
        Log.i("MicroMsg.ScanTranslationCaptureUI", "surface texture available");
        this.CMw.gLi();
        this.surfaceTexture = surfaceTexture2;
        if (this.kgv) {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, (String) null, (String) null);
            Log.i("MicroMsg.ScanTranslationCaptureUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(a2));
            if (!a2) {
                AppMethodBeat.o(120917);
                return;
            }
            eHs();
            AppMethodBeat.o(120917);
        } else if (!this.CMx.isOpen()) {
            eQQ();
            AppMethodBeat.o(120917);
        } else {
            eQU();
            AppMethodBeat.o(120917);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture2, int i2, int i3) {
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture2) {
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture2) {
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        AppMethodBeat.i(120918);
        Log.i("MicroMsg.ScanTranslationCaptureUI", "get preview frame success, length %d", Integer.valueOf(bArr.length));
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    this.CMI = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    Point hkU = this.CMx.hkU();
                    YuvImage yuvImage = new YuvImage(bArr, 17, hkU.x, hkU.y, null);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, hkU.x, hkU.y), 100, byteArrayOutputStream);
                    Bitmap decodeByteArray = BitmapUtil.decodeByteArray(byteArrayOutputStream.toByteArray());
                    int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    if (decodeByteArray != null) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        this.CMI = BitmapUtil.rotate(decodeByteArray, (float) this.CMx.getCameraRotation());
                        Log.i("MicroMsg.ScanTranslationCaptureUI", "decode cost %d, rotate cost %d", Integer.valueOf(currentTimeMillis2), Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis3)));
                        if (this.CMI != null) {
                            this.jrK = ((com.tencent.mm.plugin.scanner.f) g.ah(com.tencent.mm.plugin.scanner.f.class)).genScanCaptureImgPath("jpg");
                            cWg();
                            an(this.CMI);
                        }
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", e2, "", new Object[0]);
                AppMethodBeat.o(120918);
                return;
            }
        }
        AppMethodBeat.o(120918);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(120919);
        Log.i("MicroMsg.ScanTranslationCaptureUI", "errType %s, errCode %s, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            List<ekt> list = ((m) qVar).CFD;
            if (list != null && ((m) qVar).dEb == this.CMO) {
                this.CMS.eJV = (long) ((int) (System.currentTimeMillis() - ((m) qVar).CFE));
                Log.i("MicroMsg.ScanTranslationCaptureUI", "angle %f, translationInfos length %d", Float.valueOf(((m) qVar).angle), Integer.valueOf(list.size()));
                if (list.size() > 0) {
                    this.CMS.eEt = 1;
                    ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).getTranslationRender().a(this.CMO, list, ((m) qVar).angle, this.CMI, this);
                    if (!Util.isNullOrNil(((m) qVar).ePR())) {
                        this.CMP = ((m) qVar).ePR();
                        AppMethodBeat.o(120919);
                        return;
                    }
                } else {
                    this.CMS.eJW = (long) ((int) (System.currentTimeMillis() - this.CMT[1]));
                    h.a((Context) this, getString(R.string.ge4), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass16 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(120882);
                            ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
                            AppMethodBeat.o(120882);
                        }
                    });
                }
            }
            AppMethodBeat.o(120919);
            return;
        }
        this.CMS.eEt = 5;
        this.CMS.eJW = (long) ((int) (System.currentTimeMillis() - this.CMT[1]));
        String string = getString(R.string.ge4);
        if (Util.isNullOrNil(str)) {
            str = string;
        }
        h.a((Context) this, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.AnonymousClass17 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(120883);
                ScanTranslationCaptureUI.f(ScanTranslationCaptureUI.this);
                AppMethodBeat.o(120883);
            }
        });
        AppMethodBeat.o(120919);
    }

    private void an(Bitmap bitmap) {
        AppMethodBeat.i(120920);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(120920);
            return;
        }
        this.CML.bitmap = bitmap;
        this.CML.notifyDataSetChanged();
        AppMethodBeat.o(120920);
    }

    @Override // com.tencent.mm.plugin.scanner.util.k.b
    public final void d(int i2, Bitmap bitmap) {
        AppMethodBeat.i(120921);
        if (bitmap != null && i2 == this.CMO) {
            this.CMS.eJW = (long) ((int) (System.currentTimeMillis() - this.CMT[1]));
            this.CMJ = bitmap;
            eQV();
            an(this.CMJ);
        }
        AppMethodBeat.o(120921);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(120922);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 561 && i3 == -1) {
            String i4 = com.tencent.mm.ui.tools.a.i(this, intent, d.aSY());
            Log.i("MicroMsg.ScanTranslationCaptureUI", "select: [%s]", i4);
            if (!Util.isNullOrNil(i4)) {
                this.jrK = i4;
                this.source = 1;
                this.CMS.eDV = 2;
                this.ijt = Exif.fromFile(i4).getOrientationInDegree();
                Log.i("MicroMsg.ScanTranslationCaptureUI", "degree %s", Integer.valueOf(this.ijt));
                Bitmap decodeFileWithSample = BitmapUtil.decodeFileWithSample(i4);
                if (decodeFileWithSample != null) {
                    this.CMI = BitmapUtil.rotate(decodeFileWithSample, (float) this.ijt);
                    cWg();
                    an(this.CMI);
                }
            }
        }
        AppMethodBeat.o(120922);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        Bitmap bitmap;

        private a() {
        }

        /* synthetic */ a(ScanTranslationCaptureUI scanTranslationCaptureUI, byte b2) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i2) {
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            MultiTouchImageView multiTouchImageView;
            AppMethodBeat.i(120892);
            if (view == null) {
                multiTouchImageView = new MultiTouchImageView(ScanTranslationCaptureUI.this, 0, 0, (byte) 0);
                multiTouchImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            } else {
                multiTouchImageView = (MultiTouchImageView) view;
            }
            if (this.bitmap != null) {
                multiTouchImageView.setImageBitmap(this.bitmap);
                multiTouchImageView.cN(this.bitmap.getWidth(), this.bitmap.getHeight());
                multiTouchImageView.gKy();
            }
            AppMethodBeat.o(120892);
            return multiTouchImageView;
        }
    }
}
