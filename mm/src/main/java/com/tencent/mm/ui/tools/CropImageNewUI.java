package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.ImageDownloadUI;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.CropImageView;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.lang.reflect.Array;
import junit.framework.Assert;

@Deprecated
public class CropImageNewUI extends MMActivity {
    private boolean PCD = false;
    private int QpA = 0;
    private FilterImageView QpB;
    private LinearLayout QpC;
    private CropImageView QpD;
    private ImageView QpE;
    private View QpF;
    private boolean QpG = false;
    private boolean QpH = false;
    private final int Qpx = 1;
    private final int Qpy = 0;
    private int Qpz;
    private String filePath;
    private int gwE = 0;
    private int xlQ = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ boolean a(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(39044);
        boolean gXz = cropImageNewUI.gXz();
        AppMethodBeat.o(39044);
        return gXz;
    }

    static /* synthetic */ boolean a(CropImageNewUI cropImageNewUI, Bitmap bitmap, String str) {
        AppMethodBeat.i(39054);
        boolean a2 = cropImageNewUI.a(bitmap, str, false);
        AppMethodBeat.o(39054);
        return a2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ys;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39030);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(39030);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(39031);
        super.onNewIntent(intent);
        setIntent(intent);
        initView();
        AppMethodBeat.o(39031);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void activateBroadcast(boolean z) {
        AppMethodBeat.i(39032);
        if (z) {
            aa.d(z, new Intent().putExtra("classname", getClass().getName()).putExtra("main_process", false));
            AppMethodBeat.o(39032);
            return;
        }
        super.activateBroadcast(z);
        AppMethodBeat.o(39032);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(39033);
        super.onResume();
        setRequestedOrientation(1);
        AppMethodBeat.o(39033);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(39034);
        if (this.QpD != null) {
            CropImageView cropImageView = this.QpD;
            if (cropImageView.xqp != null && !cropImageView.xqp.isRecycled()) {
                Log.i("MicroMsg.CropImageView", "recycle bitmap:%s", cropImageView.xqp.toString());
                cropImageView.xqp.recycle();
            }
            if (cropImageView.Qqh != null) {
                cropImageView.Qqh.cancel();
                cropImageView.Qqh = null;
            }
            cropImageView.Qqi.removeCallbacksAndMessages(null);
            cropImageView.Qqk.removeCallbacksAndMessages(null);
        }
        if (this.QpB != null) {
            FilterImageView filterImageView = this.QpB;
            filterImageView.Qqw = null;
            if (filterImageView.QqA != null && !filterImageView.QqA.isRecycled()) {
                Log.i("MicroMsg.FilterView", "recycle bitmap:%s", filterImageView.QqA.toString());
                filterImageView.QqA.recycle();
            }
            filterImageView.QqA = null;
        }
        super.onDestroy();
        AppMethodBeat.o(39034);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(39035);
        setMMTitle("");
        this.QpC = (LinearLayout) findViewById(R.id.bj0);
        this.QpE = (ImageView) findViewById(R.id.biy);
        this.QpF = findViewById(R.id.bit);
        this.Qpz = getIntent().getIntExtra("CropImageMode", 0);
        Assert.assertTrue("the image mode must be set", this.Qpz != 0);
        this.gwE = getIntent().getIntExtra("CropImage_from_scene", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("CropImage_Filter", false);
        final boolean booleanExtra2 = getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false);
        if (booleanExtra) {
            b(new Runnable() {
                /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass22 */

                public final void run() {
                    boolean z = false;
                    AppMethodBeat.i(39028);
                    if (CropImageNewUI.this.QpB == null) {
                        AppMethodBeat.o(39028);
                        return;
                    }
                    if (CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                        SharedPreferences.Editor edit = CropImageNewUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
                        if (CropImageNewUI.this.QpB.findViewById(R.id.bim).getVisibility() == 0) {
                            z = true;
                        }
                        edit.putBoolean("CropImage_Filter_Show", z);
                        edit.commit();
                    }
                    String stringExtra = CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath");
                    if (stringExtra == null) {
                        stringExtra = b.aKV() + g.getMessageDigest((CropImageNewUI.this.filePath + System.currentTimeMillis()).getBytes()) + "_fiter.jpg";
                    }
                    Intent intent = new Intent();
                    intent.putExtra("CropImage_Compress_Img", true);
                    if (CropImageNewUI.this.QpB != null) {
                        intent.putExtra("CropImage_filterId", CropImageNewUI.this.QpB.getFilterId());
                    }
                    if (CropImageNewUI.this.QpB.getFilterId() == 0) {
                        intent.putExtra("CropImage_OutputPath", CropImageNewUI.this.filePath);
                        CropImageNewUI.this.setResult(-1, intent);
                    } else if (CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.QpB.getFilterBmp(), stringExtra)) {
                        intent.putExtra("CropImage_OutputPath", stringExtra);
                        CropImageNewUI.this.setResult(-1, intent);
                    } else {
                        CropImageNewUI.this.setResult(-1);
                    }
                    CropImageNewUI.this.finish();
                    AppMethodBeat.o(39028);
                }
            }, new Runnable() {
                /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass23 */

                public final void run() {
                    AppMethodBeat.i(39029);
                    if (CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                        CropImageNewUI.this.finish();
                        AppMethodBeat.o(39029);
                        return;
                    }
                    CropImageNewUI.this.QpB.setVisibility(8);
                    CropImageNewUI.this.QpC.setVisibility(0);
                    CropImageNewUI.this.QpE.setVisibility(((Integer) CropImageNewUI.this.QpE.getTag()).intValue());
                    CropImageNewUI.this.QpD.setVisibility(0);
                    AppMethodBeat.o(39029);
                }
            });
        }
        this.QpH = false;
        this.QpD = (CropImageView) findViewById(R.id.bj1);
        this.QpD.post(new Runnable() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(39006);
                if (!CropImageNewUI.a(CropImageNewUI.this)) {
                    AppMethodBeat.o(39006);
                } else if (CropImageNewUI.this.QpG || CropImageNewUI.this.PCD || !CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                    if (1 == CropImageNewUI.this.Qpz) {
                        CropImageNewUI.g(CropImageNewUI.this);
                    }
                    AppMethodBeat.o(39006);
                } else {
                    CropImageNewUI.d(CropImageNewUI.this);
                    if (!CropImageNewUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("CropImage_Filter_Show", true)) {
                        CropImageNewUI.this.QpB.findViewById(R.id.bim).setVisibility(4);
                    }
                    AppMethodBeat.o(39006);
                }
            }
        });
        this.QpD.setOnShortClick(new CropImageView.a() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.tools.CropImageView.a
            public final void gXA() {
                AppMethodBeat.i(39017);
                CropImageNewUI.h(CropImageNewUI.this);
                AppMethodBeat.o(39017);
            }
        });
        ((Button) findViewById(R.id.bj2)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(39009);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/ui/tools/CropImageNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CropImageView cropImageView = CropImageNewUI.this.QpD;
                if (cropImageView.xqp == null) {
                    Log.w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
                } else {
                    float[] fArr = {(float) (cropImageView.xqp.getWidth() / 2), (float) (cropImageView.xqp.getHeight() / 2)};
                    cropImageView.getImageMatrix().mapPoints(fArr);
                    cropImageView.getImageMatrix().postRotate(90.0f, fArr[0], fArr[1]);
                    cropImageView.setImageBitmap(cropImageView.xqp);
                    cropImageView.invalidate();
                    cropImageView.dQd++;
                }
                a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(39009);
            }
        });
        Button button = (Button) findViewById(R.id.bj3);
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(39010);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/ui/tools/CropImageNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CropImageNewUI.this.QpD.zoomIn();
                a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(39010);
            }
        });
        Button button2 = (Button) findViewById(R.id.bj4);
        button2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(39011);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/ui/tools/CropImageNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CropImageNewUI.this.QpD.zoomOut();
                a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(39011);
            }
        });
        final MTimerHandler mTimerHandler = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass7 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(39012);
                CropImageNewUI.this.QpD.zoomIn();
                AppMethodBeat.o(39012);
                return true;
            }
        }, true);
        final MTimerHandler mTimerHandler2 = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass8 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(39013);
                CropImageNewUI.this.QpD.zoomOut();
                AppMethodBeat.o(39013);
                return true;
            }
        }, true);
        button.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass9 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(39014);
                switch (motionEvent.getAction()) {
                    case 0:
                        mTimerHandler.startTimer(200);
                        break;
                    case 1:
                        mTimerHandler.stopTimer();
                        break;
                }
                AppMethodBeat.o(39014);
                return false;
            }
        });
        button2.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass10 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(39015);
                switch (motionEvent.getAction()) {
                    case 0:
                        mTimerHandler2.startTimer(200);
                        break;
                    case 1:
                        mTimerHandler2.stopTimer();
                        break;
                }
                AppMethodBeat.o(39015);
                return false;
            }
        });
        switch (this.Qpz) {
            case 1:
                b(new Runnable() {
                    /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(39007);
                        CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.QpB.getCropImageIV(), CropImageNewUI.this.QpB.getCropAreaView());
                        CropImageNewUI.this.finish();
                        AppMethodBeat.o(39007);
                    }
                }, new Runnable() {
                    /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(39008);
                        CropImageNewUI.this.finish();
                        AppMethodBeat.o(39008);
                    }
                });
                this.QpB.setLimitZoomIn(false);
                FilterImageView filterImageView = this.QpB;
                if (filterImageView.Qqz != null) {
                    filterImageView.Qqz.setScaleType(ImageView.ScaleType.MATRIX);
                    filterImageView.Qqz.gXB();
                }
                this.QpB.setCropMaskVisible(0);
                if (this.gwE == 1) {
                    this.QpB.setCropMaskBackground(R.drawable.bjg);
                    break;
                }
                break;
            case 2:
                this.QpD.setEnableOprate(false);
                findViewById(R.id.bil).setVisibility(8);
                findViewById(R.id.biu).setVisibility(8);
                break;
            case 3:
                this.QpC.setVisibility(8);
                break;
            case 5:
                int intExtra = getIntent().getIntExtra("CropImage_CompressType", 1);
                boolean booleanExtra3 = getIntent().getBooleanExtra("CropImage_BHasHD", false);
                if (intExtra != 1 && booleanExtra3) {
                    findViewById(R.id.biu).setVisibility(0);
                    Button button3 = (Button) findViewById(R.id.biv);
                    button3.setBackgroundResource(R.drawable.ki);
                    button3.setPadding(25, 8, 25, 8);
                    button3.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass11 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(39016);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/tools/CropImageNewUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            CropImageNewUI.r(CropImageNewUI.this);
                            a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(39016);
                        }
                    });
                    break;
                } else {
                    findViewById(R.id.biu).setVisibility(8);
                    break;
                }
        }
        Log.d("MicroMsg.CropImageUI", "mode is  " + this.Qpz);
        AnonymousClass17 r3 = new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass17 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39021);
                if (!booleanExtra || !booleanExtra2) {
                    switch (CropImageNewUI.this.Qpz) {
                        case 1:
                            if (CropImageNewUI.this.QpB == null) {
                                CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.QpD, CropImageNewUI.this.QpF);
                                break;
                            } else {
                                CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.QpB.getCropImageIV(), CropImageNewUI.this.QpF);
                                break;
                            }
                        case 2:
                            CropImageNewUI.k(CropImageNewUI.this);
                            break;
                        case 3:
                            CropImageNewUI.l(CropImageNewUI.this);
                            break;
                        case 4:
                            CropImageNewUI.m(CropImageNewUI.this);
                            break;
                        case 5:
                            CropImageNewUI.n(CropImageNewUI.this);
                            break;
                    }
                    AppMethodBeat.o(39021);
                } else {
                    CropImageNewUI.a(CropImageNewUI.this, true);
                    AppMethodBeat.o(39021);
                }
                return true;
            }
        };
        if (this.Qpz == 5) {
            addIconOptionMenu(0, R.raw.icons_outlined_more, r3);
        } else if (this.Qpz == 4) {
            addIconOptionMenu(0, R.raw.icons_outlined_more, r3);
            findViewById(R.id.biu).setVisibility(0);
            Button button4 = (Button) findViewById(R.id.biv);
            button4.setText(R.string.bjp);
            button4.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass18 */

                public final void onClick(View view) {
                    AppMethodBeat.i(39022);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/tools/CropImageNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    CropImageNewUI.a(CropImageNewUI.this, true);
                    a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(39022);
                }
            });
        } else {
            addTextOptionMenu(0, getString(R.string.bjt), r3, null, t.b.GREEN);
        }
        if (booleanExtra && booleanExtra2) {
            addTextOptionMenu(0, getString(R.string.bjp), r3, null, t.b.GREEN);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass19 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39023);
                CropImageNewUI.this.finish();
                AppMethodBeat.o(39023);
                return true;
            }
        });
        if (this.Qpz == 6) {
            findViewById(R.id.biu).setVisibility(8);
            addTextOptionMenu(0, getString(R.string.bjt), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass20 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(39026);
                    e eVar = new e((Context) CropImageNewUI.this, 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass20.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(39024);
                            mVar.kV(0, R.string.bjy);
                            mVar.kV(1, R.string.bk2);
                            AppMethodBeat.o(39024);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass20.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(39025);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Intent intent = new Intent();
                                    intent.putExtra("CropImage_OutputPath", CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath"));
                                    intent.putExtra("OP_CODE", 1);
                                    CropImageNewUI.this.setResult(-1, intent);
                                    CropImageNewUI.this.finish();
                                    AppMethodBeat.o(39025);
                                    return;
                                case 1:
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("CropImage_OutputPath", CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath"));
                                    intent2.putExtra("OP_CODE", 2);
                                    CropImageNewUI.this.setResult(-1, intent2);
                                    CropImageNewUI.this.finish();
                                    break;
                            }
                            AppMethodBeat.o(39025);
                        }
                    };
                    eVar.dGm();
                    AppMethodBeat.o(39026);
                    return true;
                }
            }, null, t.b.GREEN);
        }
        AppMethodBeat.o(39035);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(39036);
        Log.d("MicroMsg.CropImageUI", "onConfigurationChanged, config.orientation = " + configuration.orientation);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            Log.v("MicroMsg.CropImageUI", "onConfigurationChanged");
            this.QpD.post(new Runnable() {
                /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass21 */

                public final void run() {
                    AppMethodBeat.i(39027);
                    CropImageNewUI.a(CropImageNewUI.this);
                    AppMethodBeat.o(39027);
                }
            });
        }
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(39036);
    }

    private boolean gXz() {
        View findViewById;
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(39037);
        if (1 != this.Qpz) {
            findViewById = findViewById(R.id.bis);
        } else if (this.QpB != null) {
            findViewById = this.QpB.getCropAreaView();
        } else {
            findViewById = findViewById(R.id.bit);
        }
        if (findViewById == null) {
            AppMethodBeat.o(39037);
            return false;
        }
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        Log.v("MicroMsg.CropImageUI", "scrWidth:" + width + " scrHeight:" + height);
        this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
        if (!s.YS(this.filePath)) {
            finish();
            AppMethodBeat.o(39037);
            return false;
        }
        int i7 = 960;
        int i8 = 960;
        if (this.Qpz == 2) {
            z = true;
            i2 = height;
            i3 = width;
        } else if (this.Qpz == 3) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = MMBitmapFactory.decodeFile(this.filePath, options);
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            int i9 = options.outWidth;
            int i10 = options.outHeight;
            float f2 = 1.0f;
            if (i9 <= 640 && i10 <= 640) {
                i4 = i10;
                i3 = i9;
            } else if (i9 > i10) {
                f2 = ((float) i10) / ((float) i9);
                i3 = 640;
                i4 = (int) (((float) i10) * f2);
            } else {
                f2 = ((float) i9) / ((float) i10);
                i4 = 640;
                i3 = (int) (960.0f * f2);
            }
            Log.d("MicroMsg.CropImageUI", "w:%d h:%d width:%d height:%d scale:%f", Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2));
            Button button = (Button) findViewById(R.id.biv);
            if (button != null) {
                button.setVisibility(8);
            }
            z = false;
            i2 = i4;
        } else if (this.Qpz == 1) {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            Bitmap decodeFile2 = MMBitmapFactory.decodeFile(this.filePath, options2);
            if (decodeFile2 != null) {
                Log.i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile2.toString());
                decodeFile2.recycle();
            }
            if (options2.outWidth > options2.outHeight) {
                i7 = (int) ((((double) (options2.outWidth * 960)) * 1.0d) / ((double) options2.outHeight));
                if (i7 > 1920) {
                    i7 = 1920;
                }
            } else {
                i8 = (int) ((((double) (options2.outHeight * 960)) * 1.0d) / ((double) options2.outWidth));
                if (i8 > 1920) {
                    i8 = 1920;
                }
            }
            z = false;
            i2 = i8;
            i3 = i7;
        } else {
            BitmapFactory.Options options3 = new BitmapFactory.Options();
            options3.inJustDecodeBounds = true;
            BitmapUtil.bindlowMemeryOption(options3);
            Bitmap decodeFile3 = MMBitmapFactory.decodeFile(this.filePath, options3);
            if (decodeFile3 != null) {
                Log.i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile3.toString());
                decodeFile3.recycle();
            }
            this.QpG = af.isLongHorizontal(options3.outWidth, options3.outHeight) && options3.outWidth > 480;
            this.PCD = af.isLongVertical(options3.outWidth, options3.outHeight) && options3.outHeight > 480;
            if (this.QpG || this.PCD) {
                i8 = options3.outHeight;
                i7 = options3.outWidth;
            }
            Log.e("MicroMsg.CropImageUI", "width is " + i7 + " height is " + i8);
            z = false;
            i2 = i8;
            i3 = i7;
        }
        this.xlQ = BackwardSupportUtil.ExifHelper.getExifOrientation(this.filePath);
        if (this.xlQ == 90 || this.xlQ == 270) {
            i6 = i3;
            i5 = i2;
        } else {
            i6 = i2;
            i5 = i3;
        }
        Bitmap extractThumbNail = BitmapUtil.extractThumbNail(this.filePath, i6, i5, z);
        byte[] aW = s.aW(this.filePath, 0, 10);
        if (ImgUtil.isGif(aW)) {
            this.QpA = 1;
        } else {
            this.QpA = 0;
        }
        if (extractThumbNail == null) {
            finish();
            AppMethodBeat.o(39037);
            return false;
        }
        Log.d("temBmp crop", "h:" + extractThumbNail.getHeight() + "w: " + extractThumbNail.getWidth());
        Bitmap rotate = BitmapUtil.rotate(extractThumbNail, (float) this.xlQ);
        Matrix matrix = new Matrix();
        matrix.reset();
        float f3 = 1.0f;
        if (z) {
            float width2 = ((float) rotate.getWidth()) / ((float) width);
            float height2 = ((float) rotate.getHeight()) / ((float) height);
            float f4 = width2 < height2 ? width2 : height2;
            float f5 = width > height ? (float) height : (float) width;
            float width3 = f5 / ((float) rotate.getWidth());
            float height3 = f5 / ((float) rotate.getHeight());
            if (width3 > height3) {
                height3 = width3;
            }
            if (((double) f4) < 1.0d) {
                matrix.postScale(height3, height3);
            }
        } else {
            float width4 = ((float) rotate.getWidth()) / ((float) rotate.getHeight());
            float height4 = ((float) rotate.getHeight()) / ((float) rotate.getWidth());
            Log.v("MicroMsg.CropImageUI", "whDiv is " + width4 + " hwDiv is " + height4);
            if (height4 >= 2.0f && rotate.getHeight() >= 480) {
                float width5 = ((float) rotate.getWidth()) / ((float) width);
                float width6 = ((float) width) / ((float) rotate.getWidth());
                if (1 == this.Qpz) {
                    float height5 = ((float) height) / ((float) rotate.getHeight());
                    if (width6 <= height5) {
                        width6 = height5;
                    }
                    matrix.postScale(width6, width6);
                    matrix.postTranslate(((((float) width) - (width6 * ((float) rotate.getWidth()))) / 2.0f) + ((float) findViewById.getLeft()), (float) findViewById.getTop());
                } else if (((double) width5) > 1.0d) {
                    matrix.postScale(width6, width6);
                    rotate.getHeight();
                    matrix.postTranslate((((float) width) - (width6 * ((float) rotate.getWidth()))) / 2.0f, 0.0f);
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    if (3 == this.Qpz) {
                        matrix.postTranslate((float) ((width - rotate.getWidth()) / 2), (float) ((height - rotate.getHeight()) / 2));
                    } else {
                        matrix.postTranslate((float) ((width - rotate.getWidth()) / 2), 0.0f);
                    }
                }
            } else if (width4 < 2.0f || rotate.getWidth() < 480) {
                float width7 = ((float) width) / ((float) rotate.getWidth());
                float height6 = ((float) height) / ((float) rotate.getHeight());
                float f6 = width7 < height6 ? width7 : height6;
                if (width7 <= height6) {
                    width7 = height6;
                }
                if (1 == this.Qpz) {
                    matrix.postScale(width7, width7);
                    matrix.postTranslate(((((float) width) - (((float) rotate.getWidth()) * width7)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (width7 * ((float) rotate.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                } else if (this.QpA == 1) {
                    this.QpD.setGifPath(this.filePath);
                    this.QpD.getGifWidth();
                    this.QpD.getGifHeight();
                    float gifWidth = ((float) this.QpD.getGifWidth()) / ((float) width);
                    float gifHeight = ((float) this.QpD.getGifHeight()) / ((float) height);
                    if (gifWidth <= gifHeight) {
                        gifWidth = gifHeight;
                    }
                    if (((double) gifWidth) > 1.0d) {
                        matrix.postScale(gifWidth, gifWidth);
                    } else {
                        gifWidth = 1.0f;
                    }
                    matrix.postTranslate((((float) width) - (((float) this.QpD.getGifWidth()) * gifWidth)) / 2.0f, (((float) height) - (gifWidth * ((float) this.QpD.getGifHeight()))) / 2.0f);
                } else {
                    float width8 = ((float) rotate.getWidth()) / ((float) width);
                    float height7 = ((float) rotate.getHeight()) / ((float) height);
                    if (width8 <= height7) {
                        width8 = height7;
                    }
                    if (((double) width8) > 1.0d) {
                        matrix.postScale(f6, f6);
                        f3 = f6;
                    }
                    matrix.postTranslate((((float) width) - (((float) rotate.getWidth()) * f3)) / 2.0f, (((float) height) - (((float) rotate.getHeight()) * f3)) / 2.0f);
                }
            } else {
                float height8 = ((float) rotate.getHeight()) / 480.0f;
                float height9 = 480.0f / ((float) rotate.getHeight());
                if (1 == this.Qpz) {
                    float width9 = ((float) width) / ((float) rotate.getWidth());
                    float height10 = ((float) height) / ((float) rotate.getHeight());
                    if (width9 <= height10) {
                        width9 = height10;
                    }
                    matrix.postScale(width9, width9);
                    matrix.postTranslate(((((float) width) - (((float) rotate.getWidth()) * width9)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (width9 * ((float) rotate.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                } else if (((double) height8) > 1.0d) {
                    matrix.postScale(height8, height9);
                    matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    float height11 = (float) ((height - rotate.getHeight()) / 2);
                    Log.d("MicroMsg.CropImageUI", " offsety ".concat(String.valueOf(height11)));
                    matrix.postTranslate(0.0f, height11);
                }
            }
        }
        if (1 == this.Qpz) {
            if (this.QpB != null) {
                this.QpB.setMatrix(matrix);
                this.QpB.setImage(rotate);
            }
        } else if (this.QpA != 1) {
            this.QpD.setImageMatrix(matrix);
            this.QpD.setImageBitmap(rotate);
        }
        if (this.Qpz == 3) {
            if (ImgUtil.isGif(aW)) {
                this.QpA = 1;
                try {
                    com.tencent.mm.plugin.gif.b hT = c.dXx().hT(this.filePath, this.filePath);
                    this.QpD.setImageDrawable(hT);
                    hT.start();
                    matrix.reset();
                    int intrinsicWidth = hT.getIntrinsicWidth();
                    int intrinsicHeight = hT.getIntrinsicHeight();
                    float f7 = ((float) width) / ((float) intrinsicWidth);
                    float f8 = ((float) height) / ((float) intrinsicHeight);
                    float f9 = f7 < f8 ? f7 : f8;
                    float f10 = ((float) intrinsicWidth) / ((float) width);
                    float f11 = ((float) intrinsicHeight) / ((float) height);
                    if (f10 <= f11) {
                        f10 = f11;
                    }
                    if (((double) f10) > 1.0d) {
                        matrix.postScale(f9, f9);
                        matrix.postTranslate((((float) width) - (((float) intrinsicWidth) * f9)) / 2.0f, (((float) height) - (f9 * ((float) intrinsicHeight))) / 2.0f);
                    } else {
                        matrix.postTranslate((float) ((width - intrinsicWidth) / 2), (float) ((height - intrinsicHeight) / 2));
                    }
                    this.QpD.setImageMatrix(matrix);
                } catch (Exception e2) {
                    Log.e("MicroMsg.CropImageUI", Util.stackTraceToString(e2));
                }
            } else {
                this.QpA = 0;
            }
            AppMethodBeat.o(39037);
            return true;
        }
        if (this.QpG || this.PCD) {
            findViewById(R.id.bj2).setVisibility(8);
        }
        if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
            findViewById(R.id.biu).setVisibility(8);
        }
        AppMethodBeat.o(39037);
        return true;
    }

    private void b(Runnable runnable, Runnable runnable2) {
        AppMethodBeat.i(39038);
        this.QpB = (FilterImageView) findViewById(R.id.biq);
        this.QpB.setOnConfirmImp(runnable);
        this.QpB.setOnExitImp(runnable2);
        AppMethodBeat.o(39038);
    }

    private Bitmap lr(int i2, int i3) {
        AppMethodBeat.i(39040);
        Bitmap extractThumbNail = BitmapUtil.extractThumbNail(this.filePath, i3, i2, true);
        if (this.xlQ != 0) {
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate((float) this.xlQ, (float) (extractThumbNail.getWidth() / 2), (float) (extractThumbNail.getHeight() / 2));
            Bitmap createBitmap = Bitmap.createBitmap(extractThumbNail, 0, 0, extractThumbNail.getWidth(), extractThumbNail.getHeight(), matrix, true);
            if (extractThumbNail != createBitmap) {
                Log.i("MicroMsg.CropImageUI", "recycle bitmap:%s", extractThumbNail.toString());
                extractThumbNail.recycle();
            }
            extractThumbNail = createBitmap;
        }
        Log.d("MicroMsg.CropImageUI", "getcrop degree:" + this.xlQ);
        AppMethodBeat.o(39040);
        return extractThumbNail;
    }

    private static Bitmap a(float[][] fArr, float f2, float f3, float f4, float f5, CropImageView cropImageView) {
        AppMethodBeat.i(39041);
        if (cropImageView == null) {
            AppMethodBeat.o(39041);
            return null;
        }
        float[] a2 = n.a(fArr, new float[]{f2, f3, 1.0f});
        float[] a3 = n.a(fArr, new float[]{f4, f5, 1.0f});
        int min = (int) Math.min(a2[0], a3[0]);
        int min2 = (int) Math.min(a2[1], a3[1]);
        if (min < 0) {
            min = 0;
        }
        if (min2 < 0) {
            min2 = 0;
        }
        int abs = (int) Math.abs(a2[0] - a3[0]);
        int abs2 = (int) Math.abs(a2[1] - a3[1]);
        Matrix matrix = new Matrix();
        switch (cropImageView.getRotateCount() % 4) {
            case 0:
                matrix.setRotate(0.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 1:
                matrix.setRotate(90.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 2:
                matrix.setRotate(180.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 3:
                matrix.setRotate(270.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
        }
        Bitmap bmp = cropImageView.getBmp();
        if (min + abs > bmp.getWidth()) {
            abs = bmp.getWidth() - min;
        }
        if (min2 + abs2 > bmp.getHeight()) {
            abs2 = bmp.getHeight() - min2;
        }
        Log.i("MicroMsg.CropImageUI", "rawWidth:%d, rawHeigth:%d, originalLX:%d, originalTY:%d, realWidth:%d, realHeight:%d", Integer.valueOf(bmp.getWidth()), Integer.valueOf(bmp.getHeight()), Integer.valueOf(min), Integer.valueOf(min2), Integer.valueOf(abs), Integer.valueOf(abs2));
        Bitmap createBitmap = Bitmap.createBitmap(bmp, min, min2, abs, abs2, matrix, true);
        AppMethodBeat.o(39041);
        return createBitmap;
    }

    private boolean a(Bitmap bitmap, String str, boolean z) {
        AppMethodBeat.i(39042);
        if (str != null && !str.equals("")) {
            try {
                if (this.gwE == 1) {
                    BitmapUtil.saveBitmapToImage(bitmap, 30, Bitmap.CompressFormat.JPEG, str, z);
                } else if (this.gwE == 2) {
                    BitmapUtil.saveBitmapToImage(bitmap, 80, Bitmap.CompressFormat.JPEG, str, z);
                } else {
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.JPEG, str, z);
                }
                AppMethodBeat.o(39042);
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CropImageUI", e2, "", new Object[0]);
                Log.e("MicroMsg.CropImageUI", "saveBitmapToImage failed:" + e2.toString());
            }
        }
        AppMethodBeat.o(39042);
        return false;
    }

    private static float[][] j(Matrix matrix) {
        AppMethodBeat.i(39043);
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, 3, 3);
        float[] fArr2 = new float[9];
        matrix.getValues(fArr2);
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                fArr[i2][i3] = fArr2[(i2 * 3) + i3];
            }
        }
        AppMethodBeat.o(39043);
        return fArr;
    }

    static /* synthetic */ void d(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(39045);
        if (cropImageNewUI.QpB.getFilterBmp() == null) {
            cropImageNewUI.QpB.hl(cropImageNewUI.filePath, cropImageNewUI.xlQ);
        }
        cropImageNewUI.QpC.setVisibility(8);
        cropImageNewUI.QpB.setVisibility(0);
        cropImageNewUI.QpE.setTag(Integer.valueOf(cropImageNewUI.QpE.getVisibility()));
        cropImageNewUI.QpE.setVisibility(8);
        cropImageNewUI.QpD.setVisibility(8);
        AppMethodBeat.o(39045);
    }

    static /* synthetic */ void g(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(39046);
        cropImageNewUI.QpB.hl(cropImageNewUI.filePath, cropImageNewUI.xlQ);
        cropImageNewUI.QpC.setVisibility(8);
        cropImageNewUI.QpB.setVisibility(0);
        cropImageNewUI.QpE.setTag(Integer.valueOf(cropImageNewUI.QpE.getVisibility()));
        cropImageNewUI.QpE.setVisibility(8);
        cropImageNewUI.QpD.setVisibility(8);
        cropImageNewUI.QpB.findViewById(R.id.bim).setVisibility(4);
        AppMethodBeat.o(39046);
    }

    static /* synthetic */ void h(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(39047);
        Log.d("MicroMsg.CropImageUI", "doShowOrNot");
        if (cropImageNewUI.QpC.getVisibility() == 0) {
            cropImageNewUI.QpC.setVisibility(4);
            AppMethodBeat.o(39047);
            return;
        }
        if (cropImageNewUI.QpC.getVisibility() == 4) {
            cropImageNewUI.QpC.setVisibility(0);
        }
        AppMethodBeat.o(39047);
    }

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, boolean z) {
        AppMethodBeat.i(39048);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        if (!af.isNullOrNil(stringExtra)) {
            byte[] aW = s.aW(cropImageNewUI.filePath, 0, -1);
            s.f(stringExtra, aW, aW.length);
        } else {
            stringExtra = cropImageNewUI.filePath;
        }
        Intent intent = new Intent();
        intent.putExtra("CropImage_Compress_Img", z);
        intent.putExtra("CropImage_OutputPath", stringExtra);
        intent.putExtra("CropImage_rotateCount", cropImageNewUI.QpD.getRotateCount() % 4);
        if (cropImageNewUI.QpB != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.QpB.getFilterId());
        }
        intent.putExtra("from_source", cropImageNewUI.getIntent().getIntExtra("from_source", 0));
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
        AppMethodBeat.o(39048);
    }

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, CropImageView cropImageView, View view) {
        float f2;
        Bitmap bitmap;
        int width;
        int height;
        AppMethodBeat.i(39049);
        Log.d("MicroMsg.CropImageUI", "doCropImage" + cropImageNewUI.QpH);
        if (cropImageView == null || view == null) {
            AppMethodBeat.o(39049);
        } else if (cropImageNewUI.QpH) {
            Log.d("MicroMsg.CropImageUI", "isCroping");
            AppMethodBeat.o(39049);
        } else {
            cropImageNewUI.QpH = true;
            Bitmap createBitmap = BitmapUtil.createBitmap(cropImageView.getBmp().getWidth(), cropImageView.getBmp().getHeight(), Bitmap.Config.RGB_565);
            if (createBitmap == null) {
                cropImageNewUI.setResult(-1);
                cropImageNewUI.finish();
                AppMethodBeat.o(39049);
                return;
            }
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate((float) cropImageView.getScrollX(), (float) cropImageView.getScrollY());
            cropImageView.draw(canvas);
            float[] fArr = new float[9];
            cropImageView.getImageMatrix().getValues(fArr);
            int left = view.getLeft();
            int top = view.getTop();
            int width2 = view.getWidth();
            if (fArr[0] != 0.0f) {
                f2 = fArr[0];
            } else {
                f2 = fArr[1];
            }
            Math.abs(f2);
            float[][] c2 = n.c(j(cropImageView.getImageMatrix()));
            try {
                if (cropImageNewUI.gwE == 1) {
                    bitmap = a(c2, (float) left, (float) (((int) (((double) width2) * 0.125d)) + top), (float) (left + width2), (float) ((top + width2) - ((int) (((double) width2) * 0.125d))), cropImageView);
                } else {
                    bitmap = a(c2, (float) left, (float) top, (float) (left + width2), (float) (top + width2), cropImageView);
                }
            } catch (Throwable th) {
                bitmap = null;
            }
            if (bitmap == null) {
                Log.e("MicroMsg.CropImageUI", "doCropImage: error");
            } else {
                Log.d("MicroMsg.CropImageUI", "bm w: " + bitmap.getWidth() + " " + bitmap.getHeight());
                if (!(cropImageNewUI.gwE == 1 || (width = bitmap.getWidth()) == (height = bitmap.getHeight()))) {
                    if (width > height) {
                        bitmap = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
                    } else {
                        bitmap = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
                    }
                }
                String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
                if (stringExtra == null) {
                    stringExtra = b.aKV() + g.getMessageDigest((cropImageNewUI.filePath + System.currentTimeMillis()).getBytes()) + "_crop.jpg";
                }
                if (cropImageNewUI.a(bitmap, stringExtra, true)) {
                    Intent intent = new Intent();
                    intent.putExtra("CropImage_OutputPath", stringExtra);
                    if (cropImageNewUI.QpB != null) {
                        intent.putExtra("CropImage_filterId", cropImageNewUI.QpB.getFilterId());
                    }
                    cropImageNewUI.setResult(-1, intent);
                    cropImageNewUI.finish();
                    AppMethodBeat.o(39049);
                }
            }
            cropImageNewUI.setResult(-1);
            cropImageNewUI.finish();
            AppMethodBeat.o(39049);
        }
    }

    static /* synthetic */ void k(CropImageNewUI cropImageNewUI) {
        int i2;
        int i3;
        Bitmap bitmap;
        Bitmap bitmap2;
        AppMethodBeat.i(39050);
        Rect rect = new Rect();
        cropImageNewUI.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i4 = rect.top;
        Log.e("MicroMsg.CropImageUI", "window TitleBar.h:".concat(String.valueOf(i4)));
        if (i4 == 0) {
            i2 = n.D(cropImageNewUI.getContext(), 0);
        } else {
            i2 = i4;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) cropImageNewUI.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i5 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
        int min = Math.min(cropImageNewUI.QpF.getWidth(), cropImageNewUI.QpF.getHeight());
        int max = Math.max(cropImageNewUI.QpF.getWidth(), cropImageNewUI.QpF.getHeight());
        int i6 = max - (i5 * 2);
        int i7 = max + i2 + i5;
        int i8 = (min - (i5 * 2)) - i2;
        if (cropImageNewUI.xlQ == 0) {
            min += i2 + (i5 * 2);
            i3 = i8 + i5;
        } else {
            i3 = i8;
        }
        int[] iArr = {min, i6, i3, i7};
        Bitmap lr = cropImageNewUI.lr(iArr[2], iArr[3]);
        Bitmap lr2 = cropImageNewUI.lr(iArr[0], iArr[1]);
        if (cropImageNewUI.xlQ == 0) {
            bitmap = lr2;
            bitmap2 = lr;
        } else {
            bitmap = lr;
            bitmap2 = lr2;
        }
        Log.d("MicroMsg.CropImageUI", "docrop degree:" + cropImageNewUI.xlQ);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_vertical");
        String stringExtra2 = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_horizontal");
        if (!cropImageNewUI.a(bitmap2, stringExtra, true) || !cropImageNewUI.a(bitmap, stringExtra2, true)) {
            cropImageNewUI.setResult(-1);
        } else {
            Intent intent = new Intent();
            intent.putExtra("CropImage_bg_vertical", stringExtra);
            intent.putExtra("CropImage_bg_horizontal", stringExtra2);
            if (cropImageNewUI.QpB != null) {
                intent.putExtra("CropImage_filterId", cropImageNewUI.QpB.getFilterId());
            }
            cropImageNewUI.setResult(-1, intent);
        }
        cropImageNewUI.finish();
        AppMethodBeat.o(39050);
    }

    static /* synthetic */ void l(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(39051);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        String str = null;
        Intent intent = new Intent();
        if (cropImageNewUI.QpA == 0) {
            try {
                String messageDigest = g.getMessageDigest(new StringBuilder().append(System.currentTimeMillis()).toString().getBytes());
                BitmapUtil.saveBitmapToImage(cropImageNewUI.QpD.getBmp(), 100, Bitmap.CompressFormat.PNG, stringExtra + messageDigest, false);
                str = g.getMessageDigest(s.aW(stringExtra + messageDigest, 0, (int) s.boW(stringExtra + messageDigest)));
                if (!s.YS(stringExtra + str)) {
                    s.bo(stringExtra, messageDigest, str);
                } else {
                    Log.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
                    s.deleteFile(stringExtra + messageDigest);
                }
                intent.putExtra("emoji_type", 0);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.CropImageUI", e2, "", new Object[0]);
                cropImageNewUI.setResult(-2);
            }
        } else if (cropImageNewUI.QpA == 1) {
            byte[] aW = s.aW(cropImageNewUI.filePath, 0, -1);
            str = g.getMessageDigest(aW);
            if (!s.YS(stringExtra + str)) {
                s.f(stringExtra + str, aW, aW.length);
            } else {
                Log.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
            }
            intent.putExtra("emoji_type", 1);
        }
        intent.putExtra("CropImage_OutputPath", stringExtra + str);
        if (cropImageNewUI.QpB != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.QpB.getFilterId());
        }
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
        AppMethodBeat.o(39051);
    }

    static /* synthetic */ void m(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(39052);
        h.b(cropImageNewUI, "", (cropImageNewUI.QpG || cropImageNewUI.PCD) ? new String[]{cropImageNewUI.getString(R.string.bjs)} : new String[]{cropImageNewUI.getString(R.string.bjs)}, "", new h.d() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass14 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(39019);
                switch (i2) {
                    case 0:
                        CropImageNewUI.u(CropImageNewUI.this);
                        break;
                }
                AppMethodBeat.o(39019);
            }
        });
        AppMethodBeat.o(39052);
    }

    static /* synthetic */ void n(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(39053);
        h.b(cropImageNewUI, "", new String[]{cropImageNewUI.getString(R.string.g5j), cropImageNewUI.getString(R.string.gau)}, "", new h.d() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass13 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(39018);
                switch (i2) {
                    case 0:
                        CropImageNewUI.s(CropImageNewUI.this);
                        AppMethodBeat.o(39018);
                        return;
                    case 1:
                        CropImageNewUI.t(CropImageNewUI.this);
                        break;
                }
                AppMethodBeat.o(39018);
            }
        });
        AppMethodBeat.o(39053);
    }

    static /* synthetic */ void r(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(39055);
        long longExtra = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Id", 0);
        long longExtra2 = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Svr_Id", 0);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_Username");
        Intent intent = new Intent(cropImageNewUI, ImageDownloadUI.class);
        intent.putExtra("img_msg_id", longExtra);
        intent.putExtra("img_server_id", longExtra2);
        intent.putExtra("img_download_compress_type", 1);
        intent.putExtra("img_download_username", stringExtra);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(cropImageNewUI, bl.axQ(), "com/tencent/mm/ui/tools/CropImageNewUI", "viewHdImg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        cropImageNewUI.startActivity((Intent) bl.pG(0));
        a.a(cropImageNewUI, "com/tencent/mm/ui/tools/CropImageNewUI", "viewHdImg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(39055);
    }

    static /* synthetic */ void s(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(39056);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_ImgPath");
        int intExtra = cropImageNewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = cropImageNewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent(cropImageNewUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("Retr_Compress_Type", intExtra);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(cropImageNewUI, bl.axQ(), "com/tencent/mm/ui/tools/CropImageNewUI", "doRestransmitMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        cropImageNewUI.startActivity((Intent) bl.pG(0));
        a.a(cropImageNewUI, "com/tencent/mm/ui/tools/CropImageNewUI", "doRestransmitMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(39056);
    }

    static /* synthetic */ void t(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(39057);
        com.tencent.mm.pluginsdk.ui.tools.s.l(cropImageNewUI.getIntent().getStringExtra("CropImage_ImgPath"), cropImageNewUI);
        AppMethodBeat.o(39057);
    }

    static /* synthetic */ void u(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(39058);
        h.a(cropImageNewUI, cropImageNewUI.getString(R.string.bjq, new Object[]{Long.toString(s.boW(cropImageNewUI.filePath) / 1024)}), cropImageNewUI.getString(R.string.zb), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass15 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(39020);
                CropImageNewUI.a(CropImageNewUI.this, false);
                AppMethodBeat.o(39020);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.tools.CropImageNewUI.AnonymousClass16 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(39058);
    }
}
