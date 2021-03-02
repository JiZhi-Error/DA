package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper;

@com.tencent.mm.ui.base.a(35)
public class TranslationResultUI extends MMActivity {
    private Bitmap CMJ;
    private MMGestureGallery CMM;
    private String COH;
    private fx COI;
    private a COJ;
    private View COK;
    private TextView COL;
    private Rect COM;
    private String aesKey;
    private String fileId;
    private View gvQ;
    private AnimationLayout jUD;
    private boolean jUE;
    private ImageView jUG;
    private MultiTouchImageView lTJ;
    private long msgId;
    private float scaleX;
    private float scaleY;
    private int source;
    private float translationX;
    private float translationY;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(TranslationResultUI translationResultUI) {
        AppMethodBeat.i(120945);
        translationResultUI.goBack();
        AppMethodBeat.o(120945);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(120938);
        requestWindowFeature(1);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(120938);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(120939);
        this.gvQ = findViewById(R.id.h8y);
        this.COK = findViewById(R.id.h_g);
        this.jUG = (ImageView) findViewById(R.id.dcj);
        this.jUD = (AnimationLayout) findViewById(R.id.n0);
        this.COL = (TextView) findViewById(R.id.ivb);
        this.COH = getIntent().getStringExtra("original_file_path");
        this.msgId = getIntent().getLongExtra("msg_id", -1);
        this.source = getIntent().getIntExtra("translate_source", 0);
        this.COM = (Rect) getIntent().getParcelableExtra("thumb_location");
        this.fileId = getIntent().getStringExtra("fileid");
        this.aesKey = getIntent().getStringExtra("aeskey");
        Log.i("MicroMsg.TranslationResultUI", "file path %s", this.COH);
        if (!s.YS(this.COH)) {
            Log.e("MicroMsg.TranslationResultUI", "translation original file not exist!");
        }
        View findViewById = findViewById(R.id.h_a);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.bottomMargin += ao.aD(this);
        findViewById.setLayoutParams(layoutParams);
        getSupportActionBar().hide();
        getController().p(this, getResources().getColor(R.color.ac_));
        getController().setNavigationbarColor(getResources().getColor(R.color.ac_));
        this.CMM = (MMGestureGallery) findViewById(R.id.ivf);
        this.COJ = new a(this, (byte) 0);
        this.CMM.setAdapter((SpinnerAdapter) this.COJ);
        this.CMM.setSingleClickOverListener(new MMGestureGallery.f() {
            /* class com.tencent.mm.plugin.scanner.ui.TranslationResultUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.f
            public final void bmt() {
                AppMethodBeat.i(120929);
                TranslationResultUI.a(TranslationResultUI.this);
                AppMethodBeat.o(120929);
            }
        });
        this.COI = ((e) g.ah(e.class)).getTranslationResult(this.COH);
        if (this.COI != null) {
            if (this.CMJ == null) {
                ThreadPool.postAtFront(new Runnable() {
                    /* class com.tencent.mm.plugin.scanner.ui.TranslationResultUI.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(120931);
                        TranslationResultUI.this.CMJ = BitmapUtil.decodeFile(TranslationResultUI.this.COI.field_resultFile, null);
                        if (TranslationResultUI.this.CMJ != null) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.scanner.ui.TranslationResultUI.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(120930);
                                    TranslationResultUI.this.COJ.bitmap = TranslationResultUI.this.CMJ;
                                    TranslationResultUI.this.COJ.notifyDataSetChanged();
                                    AppMethodBeat.o(120930);
                                }
                            });
                        }
                        AppMethodBeat.o(120931);
                    }
                }, "decode_translate_result_img");
            } else {
                this.COJ.bitmap = this.CMJ;
                this.COJ.notifyDataSetChanged();
            }
            if (!Util.isNullOrNil(this.COI.field_brand)) {
                this.COL.setText(this.COI.field_brand);
                this.COL.setVisibility(0);
            }
            this.COK.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.scanner.ui.TranslationResultUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(120932);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/TranslationResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ep epVar = new ep();
                    epVar.ejA = 7;
                    epVar.eDV = (long) TranslationResultUI.this.source;
                    epVar.rK(TranslationResultUI.this.fileId);
                    epVar.rL(TranslationResultUI.this.aesKey);
                    epVar.bfK();
                    TranslationResultUI.a(TranslationResultUI.this, TranslationResultUI.this.COI.field_resultFile);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/TranslationResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(120932);
                }
            });
            this.COK.setVisibility(0);
            this.CMM.setGalleryScaleListener(new MMGestureGallery.b() {
                /* class com.tencent.mm.plugin.scanner.ui.TranslationResultUI.AnonymousClass4 */

                @Override // com.tencent.mm.ui.tools.MMGestureGallery.b
                public final void S(float f2, float f3) {
                    float f4 = 1.0f;
                    AppMethodBeat.i(120933);
                    float height = 1.0f - (f3 / ((float) TranslationResultUI.this.CMM.getHeight()));
                    if (height <= 1.0f) {
                        f4 = height;
                    }
                    Log.d("MicroMsg.TranslationResultUI", "onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                    if (TranslationResultUI.this.lTJ != null) {
                        if (f2 == 0.0f && f3 == 0.0f) {
                            TranslationResultUI.this.COK.setVisibility(0);
                        } else {
                            TranslationResultUI.this.COK.setVisibility(8);
                        }
                        TranslationResultUI.this.lTJ.setPivotX((float) (TranslationResultUI.this.CMM.getWidth() / 2));
                        TranslationResultUI.this.lTJ.setPivotY((float) (TranslationResultUI.this.CMM.getHeight() / 2));
                        TranslationResultUI.this.lTJ.setScaleX(f4);
                        TranslationResultUI.this.lTJ.setScaleY(f4);
                        TranslationResultUI.this.lTJ.setTranslationX(f2);
                        TranslationResultUI.this.lTJ.setTranslationY(f3);
                        TranslationResultUI.this.gvQ.setAlpha(f4);
                        AppMethodBeat.o(120933);
                        return;
                    }
                    Log.d("MicroMsg.TranslationResultUI", "runDragAnimation contentView is null !!");
                    AppMethodBeat.o(120933);
                }

                @Override // com.tencent.mm.ui.tools.MMGestureGallery.b
                public final void T(float f2, float f3) {
                }
            });
            ca Hb = ((l) g.af(l.class)).eiy().Hb(this.msgId);
            if (this.msgId != -1) {
                bf bfVar = new bf();
                bfVar.dEo.dCM = Hb;
                EventCenter.instance.publish(bfVar);
                this.COM = new Rect();
                this.COM.left = bfVar.dEp.dEq;
                this.COM.top = bfVar.dEp.dEr;
                this.COM.right = bfVar.dEp.dEs + this.COM.left;
                this.COM.bottom = bfVar.dEp.dEt + this.COM.top;
            }
            AppMethodBeat.o(120939);
            return;
        }
        Log.e("MicroMsg.TranslationResultUI", "translation result not found!");
        goBack();
        AppMethodBeat.o(120939);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(120940);
        super.onResume();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);
        View decorView = getWindow().getDecorView();
        int i2 = 1796;
        if (Build.VERSION.SDK_INT >= 19) {
            i2 = 5892;
        }
        decorView.setSystemUiVisibility(i2);
        AppMethodBeat.o(120940);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean convertActivityFromTranslucent() {
        return false;
    }

    private void goBack() {
        AppMethodBeat.i(120941);
        if (this.COM != null) {
            bms();
            AppMethodBeat.o(120941);
            return;
        }
        finish();
        overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(120941);
    }

    private void bms() {
        AppMethodBeat.i(120942);
        if (this.jUE) {
            AppMethodBeat.o(120942);
            return;
        }
        this.jUE = true;
        Log.i("MicroMsg.TranslationResultUI", "runExitAnimation, thumbRect %s", this.COM);
        this.jUD.a(this.jUG, this.gvQ, new ViewAnimHelper.ViewInfo(this.COM), new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.scanner.ui.TranslationResultUI.AnonymousClass5 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(120934);
                if (TranslationResultUI.this.lTJ != null) {
                    if (TranslationResultUI.this.lTJ.getScale() > 1.0f) {
                        TranslationResultUI.this.lTJ.gKy();
                    }
                    TranslationResultUI.this.translationX = TranslationResultUI.this.lTJ.getTranslationX();
                    TranslationResultUI.this.translationY = TranslationResultUI.this.lTJ.getTranslationY();
                    TranslationResultUI.this.scaleX = TranslationResultUI.this.lTJ.getScaleX();
                    TranslationResultUI.this.scaleY = TranslationResultUI.this.lTJ.getScaleY();
                }
                AppMethodBeat.o(120934);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(120935);
                TranslationResultUI.this.finish();
                TranslationResultUI.this.overridePendingTransition(R.anim.s, R.anim.s);
                AppMethodBeat.o(120935);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }, new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.scanner.ui.TranslationResultUI.AnonymousClass6 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(120936);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (TranslationResultUI.this.lTJ != null) {
                    TranslationResultUI.this.lTJ.setTranslationX(TranslationResultUI.this.translationX * (1.0f - floatValue));
                    TranslationResultUI.this.lTJ.setTranslationY(TranslationResultUI.this.translationY * (1.0f - floatValue));
                    TranslationResultUI.this.lTJ.setScaleX(((1.0f - floatValue) * TranslationResultUI.this.scaleX) + floatValue);
                    TranslationResultUI.this.lTJ.setScaleY(floatValue + ((1.0f - floatValue) * TranslationResultUI.this.scaleY));
                }
                AppMethodBeat.o(120936);
            }
        });
        AppMethodBeat.o(120942);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(120943);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(120943);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(120943);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(120944);
        super.onDestroy();
        this.CMJ = null;
        AppMethodBeat.o(120944);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.avw;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        Bitmap bitmap;

        private a() {
        }

        /* synthetic */ a(TranslationResultUI translationResultUI, byte b2) {
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
            AppMethodBeat.i(120937);
            if (TranslationResultUI.this.lTJ == null) {
                TranslationResultUI.this.lTJ = new MultiTouchImageView(TranslationResultUI.this, 0, 0, (byte) 0);
                TranslationResultUI.this.lTJ.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                TranslationResultUI.this.lTJ.gKy();
            }
            if (this.bitmap != null) {
                TranslationResultUI.this.lTJ.setImageBitmap(this.bitmap);
                TranslationResultUI.this.lTJ.cN(this.bitmap.getWidth(), this.bitmap.getHeight());
            }
            MultiTouchImageView multiTouchImageView = TranslationResultUI.this.lTJ;
            AppMethodBeat.o(120937);
            return multiTouchImageView;
        }
    }

    static /* synthetic */ void a(TranslationResultUI translationResultUI, String str) {
        AppMethodBeat.i(200116);
        p.a(translationResultUI, str, new p.a() {
            /* class com.tencent.mm.plugin.scanner.ui.TranslationResultUI.AnonymousClass7 */

            @Override // com.tencent.mm.platformtools.p.a
            public final void bP(String str, String str2) {
                AppMethodBeat.i(200114);
                Toast.makeText(TranslationResultUI.this, TranslationResultUI.this.getString(R.string.e2z, new Object[]{str2}), 1).show();
                AppMethodBeat.o(200114);
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bQ(String str, String str2) {
                AppMethodBeat.i(200115);
                Toast.makeText(TranslationResultUI.this, TranslationResultUI.this.getString(R.string.gao), 1).show();
                AppMethodBeat.o(200115);
            }
        });
        AppMethodBeat.o(200116);
    }
}
