package com.tencent.mm.plugin.aa.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.tavkit.component.TAVExporter;

public class AAImagPreviewUI extends MMActivity {
    private View gvQ;
    private String imagePath;
    private String imageUrl;
    private int jUA;
    private int jUB;
    private Dialog jUC = null;
    private AnimationLayout jUD;
    private boolean jUE = false;
    private ViewAnimHelper.ViewInfo jUF;
    private ImageView jUG;
    private int jUH;
    private final int jUw = 1;
    private final int jUx = 2;
    private MMGestureGallery jUy;
    private a jUz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        AppMethodBeat.i(63491);
        a(multiTouchImageView, bitmap);
        AppMethodBeat.o(63491);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(63486);
        customfixStatusbar(true);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.f9, R.anim.f_);
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        this.jUA = getIntent().getIntExtra("use_scene", 1);
        this.jUB = getIntent().getIntExtra("scene", 1);
        this.imagePath = getIntent().getStringExtra("path");
        this.imageUrl = getIntent().getStringExtra("url");
        this.jUF = (ViewAnimHelper.ViewInfo) getIntent().getParcelableExtra("view_info");
        this.jUH = getIntent().getIntExtra("aa_type", 2);
        initView();
        setResult(0);
        AppMethodBeat.o(63486);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a7;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(63487);
        hideTitleView();
        fullScreenNoTitleBar(true);
        if (d.oD(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        this.jUD = (AnimationLayout) findViewById(R.id.n0);
        this.gvQ = findViewById(R.id.h8y);
        this.jUG = (ImageView) findViewById(R.id.dcj);
        if (this.jUF == null) {
            this.jUF = ViewAnimHelper.q(this.jUG, getContext().getWindow().getDecorView());
        }
        this.jUy = (MMGestureGallery) findViewById(R.id.dci);
        this.jUy.setVerticalFadingEdgeEnabled(false);
        this.jUy.setHorizontalFadingEdgeEnabled(false);
        this.jUy.setSingleClickOverListener(new MMGestureGallery.f() {
            /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.f
            public final void bmt() {
                AppMethodBeat.i(63477);
                AAImagPreviewUI.this.finish();
                AppMethodBeat.o(63477);
            }
        });
        this.jUy.setLongClickOverListener(new MMGestureGallery.c() {
            /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.c
            public final void bmu() {
                AppMethodBeat.i(63480);
                e eVar = new e((Context) AAImagPreviewUI.this, 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(63478);
                        mVar.kV(1, R.string.edc);
                        if (AAImagPreviewUI.this.jUA == 1) {
                            mVar.a(2, AAImagPreviewUI.this.getContext().getResources().getColor(R.color.Red), AAImagPreviewUI.this.getString(R.string.ecz));
                        }
                        AppMethodBeat.o(63478);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass4.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(63479);
                        Log.i("MicroMsg.PreviewHdHeadImg", "onMMMenuItemSelected %s", Integer.valueOf(menuItem.getItemId()));
                        switch (menuItem.getItemId()) {
                            case 1:
                                AAImagPreviewUI.b(AAImagPreviewUI.this);
                                AppMethodBeat.o(63479);
                                return;
                            case 2:
                                AAImagPreviewUI.this.setResult(-1);
                                AAImagPreviewUI.this.finish();
                                break;
                        }
                        AppMethodBeat.o(63479);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(63480);
            }
        });
        this.jUz = new a(this, (byte) 0);
        this.jUy.setAdapter((SpinnerAdapter) this.jUz);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(63481);
                AAImagPreviewUI.this.finish();
                AppMethodBeat.o(63481);
                return true;
            }
        });
        if (!this.jUE) {
            this.jUE = true;
            Log.i("MicroMsg.PreviewHdHeadImg", "runEnterAnimation");
            this.jUD.b(this.jUG, this.gvQ, this.jUF, new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass11 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(212957);
                    AAImagPreviewUI.this.jUG.setVisibility(0);
                    AppMethodBeat.o(212957);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(212958);
                    AAImagPreviewUI.this.jUE = false;
                    AppMethodBeat.o(212958);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }, null);
        }
        AppMethodBeat.o(63487);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(63488);
        super.finish();
        bms();
        overridePendingTransition(R.anim.f9, R.anim.f_);
        AppMethodBeat.o(63488);
    }

    private static void a(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        AppMethodBeat.i(63489);
        ForceGpuUtil.decideLayerType(multiTouchImageView, bitmap.getWidth(), bitmap.getHeight());
        int width = multiTouchImageView.getWidth();
        int height = multiTouchImageView.getHeight();
        Matrix matrix = new Matrix();
        matrix.reset();
        float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
        float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
        Log.v("MicroMsg.PreviewHdHeadImg", "whDiv is " + width2 + " hwDiv is " + height2);
        if (height2 >= 2.0f && bitmap.getHeight() >= 480) {
            float width3 = ((float) bitmap.getWidth()) / ((float) width);
            float width4 = ((float) width) / ((float) bitmap.getWidth());
            if (((double) width3) > 1.0d) {
                matrix.postScale(width4, width4);
                bitmap.getHeight();
                matrix.postTranslate((((float) width) - (width4 * ((float) bitmap.getWidth()))) / 2.0f, 0.0f);
            } else {
                matrix.postScale(1.0f, 1.0f);
                matrix.postTranslate((float) ((width - bitmap.getWidth()) / 2), 0.0f);
            }
        } else if (width2 < 2.0f || bitmap.getWidth() < 480) {
            float width5 = ((float) width) / ((float) bitmap.getWidth());
            float height3 = ((float) height) / ((float) bitmap.getHeight());
            if (width5 >= height3) {
                width5 = height3;
            }
            float width6 = ((float) bitmap.getWidth()) / ((float) width);
            float height4 = ((float) bitmap.getHeight()) / ((float) height);
            if (width6 <= height4) {
                width6 = height4;
            }
            if (((double) width6) > 1.0d) {
                matrix.postScale(width5, width5);
            } else {
                width5 = 1.0f;
            }
            matrix.postTranslate((((float) width) - (((float) bitmap.getWidth()) * width5)) / 2.0f, (((float) height) - (width5 * ((float) bitmap.getHeight()))) / 2.0f);
        } else {
            float height5 = ((float) bitmap.getHeight()) / 480.0f;
            float height6 = 480.0f / ((float) bitmap.getHeight());
            if (((double) height5) > 1.0d) {
                matrix.postScale(height5, height6);
                matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
            } else {
                matrix.postScale(1.0f, 1.0f);
                float height7 = (float) ((height - bitmap.getHeight()) / 2);
                Log.d("MicroMsg.PreviewHdHeadImg", " offsety ".concat(String.valueOf(height7)));
                matrix.postTranslate(0.0f, height7);
            }
        }
        multiTouchImageView.setImageMatrix(matrix);
        multiTouchImageView.cN(bitmap.getWidth(), bitmap.getHeight());
        multiTouchImageView.setMaxZoomDoubleTab(true);
        multiTouchImageView.setImageBitmap(bitmap);
        AppMethodBeat.o(63489);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(AAImagPreviewUI aAImagPreviewUI, byte b2) {
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
            AppMethodBeat.i(63485);
            View inflate = View.inflate(AAImagPreviewUI.this.getContext(), R.layout.a8, null);
            inflate.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            AAImagPreviewUI.a(AAImagPreviewUI.this, (MultiTouchImageView) inflate.findViewById(R.id.dup));
            AppMethodBeat.o(63485);
            return inflate;
        }
    }

    private void bms() {
        AppMethodBeat.i(212959);
        if (this.jUE) {
            AppMethodBeat.o(212959);
            return;
        }
        this.jUE = true;
        Log.i("MicroMsg.PreviewHdHeadImg", "runExitAnimation");
        this.jUD.a(this.jUG, this.gvQ, this.jUF, new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(212952);
                AAImagPreviewUI.this.finish();
                AAImagPreviewUI.this.overridePendingTransition(R.anim.f9, R.anim.f_);
                AppMethodBeat.o(212952);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }, new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass3 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(212953);
                ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AppMethodBeat.o(212953);
            }
        });
        AppMethodBeat.o(212959);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(212960);
        super.onBackPressed();
        bms();
        AppMethodBeat.o(212960);
    }

    static /* synthetic */ void b(AAImagPreviewUI aAImagPreviewUI) {
        AppMethodBeat.i(63490);
        p.a(aAImagPreviewUI, new Runnable() {
            /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(212955);
                if (s.YS(AAImagPreviewUI.this.imagePath)) {
                    String str = AndroidMediaUtil.getSysCameraDirPath() + "img_" + g.getMD5(AAImagPreviewUI.this.imagePath) + System.currentTimeMillis() + ".jpg";
                    s.deleteFile(str);
                    s.nw(AAImagPreviewUI.this.imagePath, str);
                    AndroidMediaUtil.refreshMediaScanner(str, AAImagPreviewUI.this.getContext());
                    Toast.makeText(AAImagPreviewUI.this.getContext(), AAImagPreviewUI.this.getContext().getString(R.string.dv7, new Object[]{AndroidMediaUtil.getSysCameraDirPath()}), 1).show();
                    if (AAImagPreviewUI.this.jUA == 2) {
                        h.INSTANCE.a(13721, 4, 13, Integer.valueOf(AAImagPreviewUI.this.jUH));
                    }
                } else {
                    Toast.makeText(AAImagPreviewUI.this.getContext(), AAImagPreviewUI.this.getContext().getString(R.string.ed7), 1).show();
                }
                i.uZ(15);
                AppMethodBeat.o(212955);
            }
        }, new Runnable() {
            /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(212956);
                Toast.makeText(AAImagPreviewUI.this.getContext(), AAImagPreviewUI.this.getContext().getString(R.string.ed8), 1).show();
                i.uZ(15);
                AppMethodBeat.o(212956);
            }
        });
        AppMethodBeat.o(63490);
    }

    static /* synthetic */ void a(AAImagPreviewUI aAImagPreviewUI, final MultiTouchImageView multiTouchImageView) {
        AppMethodBeat.i(212961);
        if (aAImagPreviewUI.jUB == 1) {
            q.bcQ();
            Bitmap EP = com.tencent.mm.av.d.EP(aAImagPreviewUI.imageUrl);
            if (EP != null) {
                a(multiTouchImageView, EP);
                AppMethodBeat.o(212961);
                return;
            }
            aAImagPreviewUI.jUC = com.tencent.mm.ui.base.h.a((Context) aAImagPreviewUI, 3, (int) R.style.lj, aAImagPreviewUI.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass6 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(63482);
                    if (AAImagPreviewUI.this.jUC != null && AAImagPreviewUI.this.jUC.isShowing()) {
                        AAImagPreviewUI.this.jUC.dismiss();
                    }
                    AppMethodBeat.o(63482);
                }
            });
            q.bcU().a(aAImagPreviewUI.imageUrl, new r.a() {
                /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass7 */

                @Override // com.tencent.mm.av.r.a
                public final void a(String str, final Bitmap bitmap, String str2) {
                    AppMethodBeat.i(63484);
                    Log.i("MicroMsg.PreviewHdHeadImg", "onLoadImageEnd() url:%s path:%s", str, str2);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(63483);
                            if (AAImagPreviewUI.this.jUC != null && AAImagPreviewUI.this.jUC.isShowing()) {
                                AAImagPreviewUI.this.jUC.dismiss();
                            }
                            if (bitmap == null) {
                                Log.e("MicroMsg.PreviewHdHeadImg", "showAAImag onLoadImageEnd bm == null");
                                AAImagPreviewUI.this.finish();
                                AppMethodBeat.o(63483);
                                return;
                            }
                            AAImagPreviewUI.b(multiTouchImageView, bitmap);
                            AppMethodBeat.o(63483);
                        }
                    });
                    AppMethodBeat.o(63484);
                }
            });
            AppMethodBeat.o(212961);
        } else if (aAImagPreviewUI.jUB == 2) {
            multiTouchImageView.post(new Runnable() {
                /* class com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(212954);
                    Bitmap decodeFileWithSample = BitmapUtil.decodeFileWithSample(AAImagPreviewUI.this.imagePath, multiTouchImageView.getWidth(), multiTouchImageView.getHeight());
                    int orientationInDegree = Exif.fromFile(AAImagPreviewUI.this.imagePath).getOrientationInDegree();
                    Bitmap rotate = BitmapUtil.rotate(decodeFileWithSample, (float) orientationInDegree);
                    Log.i("MicroMsg.PreviewHdHeadImg", "exifPath : %s degree : %d", AAImagPreviewUI.this.imagePath, Integer.valueOf(orientationInDegree));
                    AAImagPreviewUI.b(multiTouchImageView, rotate);
                    AppMethodBeat.o(212954);
                }
            });
            AppMethodBeat.o(212961);
        } else {
            Log.e("MicroMsg.PreviewHdHeadImg", "scene(%s) invalid", Integer.valueOf(aAImagPreviewUI.jUB));
            aAImagPreviewUI.finish();
            AppMethodBeat.o(212961);
        }
    }
}
