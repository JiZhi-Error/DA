package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.scanner.PluginScanTranslation;
import com.tencent.mm.plugin.scanner.model.ai;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.protobuf.ekt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;
import java.io.IOException;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002STB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\u001a\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\b\u00102\u001a\u00020)H\u0002J\b\u00103\u001a\u00020\fH\u0014J\b\u00104\u001a\u00020)H\u0002J\b\u00105\u001a\u00020)H\u0002J\b\u00106\u001a\u00020)H\u0002J\"\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010;H\u0014J\u0012\u0010<\u001a\u00020)2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020)H\u0014J\u0018\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020)H\u0014J\b\u0010F\u001a\u00020)H\u0014J,\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\b\u0010J\u001a\u0004\u0018\u00010\n2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020)H\u0014J\b\u0010N\u001a\u00020)H\u0002J\u0012\u0010O\u001a\u00020)2\b\u0010P\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010Q\u001a\u00020)H\u0002J\b\u0010R\u001a\u00020)H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0018\u00010%R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000¨\u0006U"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/scanner/util/ScanTranslationRender$TranslationRenderCallback;", "()V", "bottomBgLayer", "Landroid/view/View;", "closeButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "curMediaId", "", "curSessionId", "", "curState", "gestureGallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "originalBitmap", "Landroid/graphics/Bitmap;", "originalPath", "reportData", "Lcom/tencent/mm/autogen/mmdata/rpt/OCRTranslateReportStruct;", "rootContainer", "rotateDegree", "saveContainer", "saveImgBtn", "scanLine", "Landroid/widget/ImageView;", "scanLineAnimator", "Landroid/animation/ValueAnimator;", "screenHeight", "source", "startTimeArray", "", "targetLang", "topBgLayer", "translateBitmap", "translateImageAdapter", "Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$TranslateImageAdapter;", "translationPath", "viewSourceBtn", "configNavigationBar", "", "doTranslation", "drawTranslationResult", "session", "newBitmap", "enterFullScreen", "enterPreviewStatus", "enterTranslateFinishStatus", "enterTranslateStatus", "finishActivity", "getLayoutId", "goBack", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "resetTargetLang", "setPreviewBitmap", "bitmap", "startScanLineAnimation", "stopScanLineAnimation", "Companion", "TranslateImageAdapter", "scan-translation_release"})
public final class ScanTranslationResultUI extends MMActivity implements com.tencent.mm.ak.i, k.b {
    public static final a CNc = new a((byte) 0);
    private WeImageView AmD;
    private View CMC;
    private ImageView CMD;
    private View CME;
    private View CMF;
    private View CMG;
    private Bitmap CMI;
    private Bitmap CMJ;
    private String CMK;
    private MMGestureGallery CMM;
    private int CMO;
    private String CMP;
    private final go CMS = new go();
    private final long[] CMT = new long[2];
    private b CNb;
    private int iOu = -1;
    private int ijt;
    private View jWj;
    private String jrK;
    private int mEY;
    private int source;
    private ImageView tgP;
    private ValueAnimator tgS = new ValueAnimator();
    private String xCU;

    static {
        AppMethodBeat.i(121001);
        AppMethodBeat.o(121001);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ScanTranslationResultUI() {
        AppMethodBeat.i(121000);
        AppMethodBeat.o(121000);
    }

    public static final /* synthetic */ void a(ScanTranslationResultUI scanTranslationResultUI, Bitmap bitmap) {
        AppMethodBeat.i(121002);
        scanTranslationResultUI.an(bitmap);
        AppMethodBeat.o(121002);
    }

    public static final /* synthetic */ ImageView d(ScanTranslationResultUI scanTranslationResultUI) {
        AppMethodBeat.i(121003);
        ImageView imageView = scanTranslationResultUI.CMD;
        if (imageView == null) {
            p.btv("viewSourceBtn");
        }
        AppMethodBeat.o(121003);
        return imageView;
    }

    public static final /* synthetic */ void j(ScanTranslationResultUI scanTranslationResultUI) {
        AppMethodBeat.i(121007);
        scanTranslationResultUI.eQX();
        AppMethodBeat.o(121007);
    }

    public static final /* synthetic */ ImageView k(ScanTranslationResultUI scanTranslationResultUI) {
        AppMethodBeat.i(121004);
        ImageView imageView = scanTranslationResultUI.tgP;
        if (imageView == null) {
            p.btv("scanLine");
        }
        AppMethodBeat.o(121004);
        return imageView;
    }

    public static final /* synthetic */ void m(ScanTranslationResultUI scanTranslationResultUI) {
        AppMethodBeat.i(121005);
        scanTranslationResultUI.eQV();
        AppMethodBeat.o(121005);
    }

    public static final /* synthetic */ void q(ScanTranslationResultUI scanTranslationResultUI) {
        AppMethodBeat.i(121006);
        scanTranslationResultUI.cWj();
        AppMethodBeat.o(121006);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$Companion;", "", "()V", "CUR_STATE_DEFAULT", "", "CUR_STATE_PREVIEW", "CUR_STATE_TRANSLATING", "CUR_STATE_VIEW_ORIGINAL", "CUR_STATE_VIEW_TRANSLATION", "REQUEST_CODE_SELECT_PICTURE", "SCAN_LINE_ANIMATION_DURATION", "", "SOURCE_CAPTURE", "SOURCE_GALLERY", "TAG", "", "scan-translation_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(120983);
        super.onCreate(bundle);
        getController().setNavigationbarColor(getResources().getColor(R.color.ae));
        View findViewById = findViewById(R.id.h8y);
        p.g(findViewById, "findViewById(R.id.root_container)");
        this.jWj = findViewById;
        View findViewById2 = findViewById(R.id.iv_);
        p.g(findViewById2, "findViewById(R.id.translate_gallery_view)");
        this.CMM = (MMGestureGallery) findViewById2;
        this.CNb = new b();
        MMGestureGallery mMGestureGallery = this.CMM;
        if (mMGestureGallery == null) {
            p.btv("gestureGallery");
        }
        mMGestureGallery.setAdapter((SpinnerAdapter) this.CNb);
        View findViewById3 = findViewById(R.id.h_h);
        p.g(findViewById3, "findViewById(R.id.save_translate_container)");
        this.CMC = findViewById3;
        View view = this.CMC;
        if (view == null) {
            p.btv("saveContainer");
        }
        View findViewById4 = view.findViewById(R.id.ive);
        p.g(findViewById4, "saveContainer.findViewBy…ranslate_view_source_btn)");
        this.CMD = (ImageView) findViewById4;
        ImageView imageView = this.CMD;
        if (imageView == null) {
            p.btv("viewSourceBtn");
        }
        imageView.setOnClickListener(new e(this));
        View findViewById5 = findViewById(R.id.ivd);
        p.g(findViewById5, "findViewById(R.id.translate_top_bg)");
        this.CMF = findViewById5;
        View findViewById6 = findViewById(R.id.iv7);
        p.g(findViewById6, "findViewById(R.id.translate_bottom_bg)");
        this.CMG = findViewById6;
        hideTitleView();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        View findViewById7 = findViewById(R.id.ha7);
        p.g(findViewById7, "findViewById(R.id.scan_line)");
        this.tgP = (ImageView) findViewById7;
        View view2 = this.CMC;
        if (view2 == null) {
            p.btv("saveContainer");
        }
        View findViewById8 = view2.findViewById(R.id.iv9);
        p.g(findViewById8, "saveContainer.findViewBy…d.translate_download_btn)");
        this.CME = findViewById8;
        View view3 = this.CME;
        if (view3 == null) {
            p.btv("saveImgBtn");
        }
        view3.setOnClickListener(new f(this));
        View findViewById9 = findViewById(R.id.b47);
        p.g(findViewById9, "findViewById(R.id.close_button)");
        this.AmD = (WeImageView) findViewById9;
        WeImageView weImageView = this.AmD;
        if (weImageView == null) {
            p.btv("closeButton");
        }
        weImageView.setOnClickListener(new g(this));
        this.mEY = com.tencent.mm.cb.a.jo(getContext());
        this.tgS.setFloatValues(0.0f, 1.0f);
        this.tgS.addListener(new h(this));
        this.tgS.addUpdateListener(new i(this));
        View view4 = this.CMC;
        if (view4 == null) {
            p.btv("saveContainer");
        }
        ViewGroup.LayoutParams layoutParams = view4.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(120983);
            throw tVar;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.bottomMargin = ao.aD(getContext()) + layoutParams2.bottomMargin;
        View view5 = this.CMC;
        if (view5 == null) {
            p.btv("saveContainer");
        }
        view5.setLayoutParams(layoutParams2);
        this.tgS.setDuration(5000L);
        com.tencent.mm.ui.base.b.a(this, null);
        eQP();
        String stringExtra = getIntent().getStringExtra("key_translation_origin_image_path");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.jrK = stringExtra;
        this.source = getIntent().getIntExtra("key_translation_source", 0);
        if (this.source == 0) {
            this.CMS.qy(getIntent().getLongExtra("key_translation_capture_time", 0));
            this.CMS.qx(1);
        } else if (this.source == 1) {
            this.CMS.qy(0);
            this.CMS.qx(2);
        }
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData originPath: %s, source: %d", this.jrK, Integer.valueOf(this.source));
        String str = this.jrK;
        if (str == null) {
            p.hyc();
        }
        this.CMI = ai.aMD(str);
        if (this.CMI != null) {
            Bitmap bitmap = this.CMI;
            if (bitmap == null) {
                p.hyc();
            }
            if (!bitmap.isRecycled()) {
                Object[] objArr = new Object[2];
                Bitmap bitmap2 = this.CMI;
                if (bitmap2 == null) {
                    p.hyc();
                }
                objArr[0] = Integer.valueOf(bitmap2.getWidth());
                Bitmap bitmap3 = this.CMI;
                if (bitmap3 == null) {
                    p.hyc();
                }
                objArr[1] = Integer.valueOf(bitmap3.getHeight());
                Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo initData bitmap width: %d, height: %d", objArr);
            }
        }
        an(this.CMI);
        AppMethodBeat.o(120983);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.az7;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ ScanTranslationResultUI CNd;

        e(ScanTranslationResultUI scanTranslationResultUI) {
            this.CNd = scanTranslationResultUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120976);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.CNd.iOu == 3) {
                if (this.CNd.CMI != null) {
                    ScanTranslationResultUI.a(this.CNd, this.CNd.CMI);
                }
                String str = this.CNd.CMP;
                if (str == null || !n.I(str, LocaleUtil.CHINA, false)) {
                    ScanTranslationResultUI.d(this.CNd).setImageResource(R.raw.translation_result_english_highlighted);
                } else {
                    ScanTranslationResultUI.d(this.CNd).setImageResource(R.raw.translation_result_chinese_highlighted);
                }
                this.CNd.iOu = 2;
                this.CNd.CMS.qD(this.CNd.CMS.agQ() + 1);
            } else if (this.CNd.iOu == 2) {
                if (this.CNd.CMJ != null) {
                    ScanTranslationResultUI.a(this.CNd, this.CNd.CMJ);
                }
                String str2 = this.CNd.CMP;
                if (str2 == null || !n.I(str2, LocaleUtil.CHINA, true)) {
                    ScanTranslationResultUI.d(this.CNd).setImageResource(R.drawable.b0u);
                } else {
                    ScanTranslationResultUI.d(this.CNd).setImageResource(R.drawable.b0s);
                }
                this.CNd.iOu = 3;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120976);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ ScanTranslationResultUI CNd;

        f(ScanTranslationResultUI scanTranslationResultUI) {
            this.CNd = scanTranslationResultUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120977);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.CNd.iOu == 2) {
                try {
                    this.CNd.CMS.agS();
                    String str = this.CNd.jrK;
                    if (str != null) {
                        com.tencent.mm.platformtools.p.a(this.CNd.getContext(), str, new a(this));
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ScanTranslationResultUI", e2, "copy to gallery error", new Object[0]);
                }
            } else if (this.CNd.iOu == 3) {
                try {
                    this.CNd.CMS.agR();
                    if (this.CNd.source == 0) {
                        try {
                            this.CNd.CMK = ((PluginScanTranslation) com.tencent.mm.kernel.g.ah(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
                            BitmapUtil.saveBitmapToImage(this.CNd.CMJ, 80, Bitmap.CompressFormat.JPEG, this.CNd.CMK, false);
                        } catch (IOException e3) {
                            Log.printErrStackTrace("MicroMsg.ScanTranslationResultUI", e3, "save translate result file error", new Object[0]);
                        }
                    }
                    String str2 = this.CNd.CMK;
                    if (str2 != null) {
                        com.tencent.mm.platformtools.p.a(this.CNd.getContext(), str2, new b(this));
                    }
                } catch (Exception e4) {
                    Log.printErrStackTrace("MicroMsg.ScanTranslationResultUI", e4, "save to gallery error", new Object[0]);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120977);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$1$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"})
        public static final class a implements p.a {
            final /* synthetic */ f CNi;

            a(f fVar) {
                this.CNi = fVar;
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bP(String str, String str2) {
                AppMethodBeat.i(200126);
                kotlin.g.b.p.h(str, "srcPath");
                kotlin.g.b.p.h(str2, "destPath");
                AppCompatActivity context = this.CNi.CNd.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(200126);
                    throw tVar;
                }
                com.tencent.mm.ui.widget.snackbar.b.r(context, this.CNi.CNd.getResources().getString(R.string.ge7));
                AppMethodBeat.o(200126);
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bQ(String str, String str2) {
                AppMethodBeat.i(200127);
                kotlin.g.b.p.h(str, "srcPath");
                kotlin.g.b.p.h(str2, "destPath");
                AppCompatActivity context = this.CNi.CNd.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(200127);
                    throw tVar;
                }
                com.tencent.mm.ui.widget.snackbar.b.r(context, this.CNi.CNd.getResources().getString(R.string.gao));
                AppMethodBeat.o(200127);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$2$2$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "scan-translation_release"})
        public static final class b implements p.a {
            final /* synthetic */ f CNi;

            b(f fVar) {
                this.CNi = fVar;
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bP(String str, String str2) {
                AppMethodBeat.i(200128);
                kotlin.g.b.p.h(str, "srcPath");
                kotlin.g.b.p.h(str2, "destPath");
                AppCompatActivity context = this.CNi.CNd.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(200128);
                    throw tVar;
                }
                com.tencent.mm.ui.widget.snackbar.b.r(context, this.CNi.CNd.getResources().getString(R.string.ge7));
                AppMethodBeat.o(200128);
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bQ(String str, String str2) {
                AppMethodBeat.i(200129);
                kotlin.g.b.p.h(str, "srcPath");
                kotlin.g.b.p.h(str2, "destPath");
                AppCompatActivity context = this.CNi.CNd.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(200129);
                    throw tVar;
                }
                com.tencent.mm.ui.widget.snackbar.b.r(context, this.CNi.CNd.getResources().getString(R.string.gao));
                AppMethodBeat.o(200129);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ ScanTranslationResultUI CNd;

        g(ScanTranslationResultUI scanTranslationResultUI) {
            this.CNd = scanTranslationResultUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(162354);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ScanTranslationResultUI.j(this.CNd);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(162354);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$init$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "scan-translation_release"})
    public static final class h extends AnimatorListenerAdapter {
        final /* synthetic */ ScanTranslationResultUI CNd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(ScanTranslationResultUI scanTranslationResultUI) {
            this.CNd = scanTranslationResultUI;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(162355);
            ScanTranslationResultUI.k(this.CNd).setAlpha(0.0f);
            AppMethodBeat.o(162355);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(162356);
            ScanTranslationResultUI.k(this.CNd).setAlpha(0.0f);
            AppMethodBeat.o(162356);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class i implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ScanTranslationResultUI CNd;

        i(ScanTranslationResultUI scanTranslationResultUI) {
            this.CNd = scanTranslationResultUI;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(162357);
            kotlin.g.b.p.g(valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(162357);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            if (floatValue <= 0.1f) {
                ScanTranslationResultUI.k(this.CNd).setAlpha(floatValue * 10.0f);
            } else if (floatValue >= 0.9f) {
                ScanTranslationResultUI.k(this.CNd).setAlpha((1.0f - floatValue) * 10.0f);
            }
            ScanTranslationResultUI.k(this.CNd).setTranslationY(floatValue * ((float) (this.CNd.mEY - ScanTranslationResultUI.k(this.CNd).getHeight())));
            AppMethodBeat.o(162357);
        }
    }

    private final void eQP() {
        AppMethodBeat.i(120984);
        n.I(LocaleUtil.getApplicationLanguage(), LocaleUtil.CHINA, true);
        this.CMP = LocaleUtil.getCurrentLanguage(getContext());
        Log.i("MicroMsg.ScanTranslationResultUI", "targetLang %s", this.CMP);
        AppMethodBeat.o(120984);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(120985);
        super.onResume();
        Window window = getWindow();
        if (window != null) {
            window.addFlags(2097280);
        }
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            getWindow().addFlags(67109888);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        Window window2 = getWindow();
        kotlin.g.b.p.g(window2, "window");
        View decorView = window2.getDecorView();
        kotlin.g.b.p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        com.tencent.mm.plugin.ball.f.f.cji();
        com.tencent.mm.kernel.g.azz().a(294, this);
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo onResume curState: %d", Integer.valueOf(this.iOu));
        if (this.iOu == -1) {
            cWg();
        }
        AppMethodBeat.o(120985);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(120986);
        super.onPause();
        com.tencent.mm.kernel.g.azz().b(294, this);
        AppMethodBeat.o(120986);
    }

    private final void eQW() {
        AppMethodBeat.i(120987);
        try {
            Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation");
            if (!Util.isNullOrNil(this.jrK) && this.CMI != null) {
                this.xCU = com.tencent.mm.plugin.scanner.util.p.aMv(this.jrK);
                String str = this.jrK;
                if (this.source == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    BitmapUtil.saveBitmapToImage(this.CMI, 80, Bitmap.CompressFormat.JPEG, this.jrK, false);
                    Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                    Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", Long.valueOf(s.boW(this.jrK)));
                } else if (this.source == 1) {
                    String mD5String = MD5Util.getMD5String(kotlin.g.b.p.I(this.jrK, Long.valueOf(s.boX(this.jrK))));
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginScanTranslation.class);
                    kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginScanTranslation::class.java)");
                    fx aMG = ((PluginScanTranslation) ah).getTranslationResultStorage().aMG(mD5String);
                    if (aMG != null) {
                        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation already has translation result");
                        this.CMK = aMG.field_resultFile;
                        this.CMJ = BitmapUtil.decodeFile(this.CMK, new BitmapFactory.Options());
                        if (this.CMJ != null) {
                            MMHandlerThread.postToMainThreadDelayed(new c(this), 500);
                            AppMethodBeat.o(120987);
                            return;
                        }
                        Log.w("MicroMsg.ScanTranslationResultUI", "can not find old translation result!");
                    }
                    if (this.ijt != 0) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String genScanTmpImgPath = ((com.tencent.mm.plugin.scanner.f) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.scanner.f.class)).genScanTmpImgPath("jpg");
                        BitmapUtil.saveBitmapToImage(this.CMI, 80, Bitmap.CompressFormat.JPEG, genScanTmpImgPath, false);
                        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation save img cost %d", Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis2)));
                        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo doTranslation fileSize %d", Long.valueOf(s.boW(genScanTmpImgPath)));
                        str = genScanTmpImgPath;
                    }
                }
                this.CMT[1] = System.currentTimeMillis();
                com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.scanner.f.class);
                kotlin.g.b.p.g(ah2, "MMKernel.plugin(IPluginScanner::class.java)");
                ((com.tencent.mm.plugin.scanner.f) ah2).getScanCdnService().a(this.xCU, str, com.tencent.mm.i.a.MediaType_IMAGE, new d(this, str));
                AppMethodBeat.o(120987);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanTranslationResultUI", e2, "", new Object[0]);
        }
        AppMethodBeat.o(120987);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ ScanTranslationResultUI CNd;

        c(ScanTranslationResultUI scanTranslationResultUI) {
            this.CNd = scanTranslationResultUI;
        }

        public final void run() {
            AppMethodBeat.i(120970);
            ScanTranslationResultUI.m(this.CNd);
            ScanTranslationResultUI.a(this.CNd, this.CNd.CMJ);
            AppMethodBeat.o(120970);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0005\u001a\u0012 \u0004*\b\u0018\u00010\u0006R\u00020\u00070\u0006R\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "mediaId", "", "kotlin.jvm.PlatformType", "result", "Lcom/tencent/mm/plugin/scanner/util/ScannerCdnService$ScannerUploadCallbackResult;", "Lcom/tencent/mm/plugin/scanner/util/ScannerCdnService;", "onFinish"})
    public static final class d implements p.a {
        final /* synthetic */ ScanTranslationResultUI CNd;
        final /* synthetic */ String CNe;

        d(ScanTranslationResultUI scanTranslationResultUI, String str) {
            this.CNd = scanTranslationResultUI;
            this.CNe = str;
        }

        @Override // com.tencent.mm.plugin.scanner.util.p.a
        public final void a(String str, p.b bVar) {
            AppMethodBeat.i(120975);
            if (!Util.isNullOrNil(str) && kotlin.g.b.p.j(str, this.CNd.xCU)) {
                this.CNd.CMS.qA((long) ((int) (System.currentTimeMillis() - this.CNd.CMT[1])));
                Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate upload img cost %d, errCode: %d", Long.valueOf(this.CNd.CMS.agP()), Integer.valueOf(bVar.errCode));
                this.CNd.CMS.uq(bVar.fileId);
                this.CNd.CMS.ur(bVar.aeskey);
                switch (bVar.errCode) {
                    case -21009:
                    case -21000:
                        MMHandlerThread.postToMainThread(new Runnable(this) {
                            /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI.d.AnonymousClass2 */
                            final /* synthetic */ d CNf;

                            {
                                this.CNf = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(120974);
                                ScanTranslationResultUI.q(this.CNf.CNd);
                                com.tencent.mm.ui.base.h.d(this.CNf.CNd.getContext(), this.CNf.CNd.getResources().getString(R.string.cdr), this.CNf.CNd.getResources().getString(R.string.zb), new DialogInterface.OnClickListener(this) {
                                    /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI.d.AnonymousClass2.AnonymousClass1 */
                                    final /* synthetic */ AnonymousClass2 CNh;

                                    {
                                        this.CNh = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(120973);
                                        ScanTranslationResultUI.j(this.CNh.CNf.CNd);
                                        AppMethodBeat.o(120973);
                                    }
                                });
                                AppMethodBeat.o(120974);
                            }
                        });
                        this.CNd.CMS.qz(3);
                        break;
                    case 0:
                        if (Util.isNullOrNil(bVar.fileId, bVar.aeskey)) {
                            MMHandlerThread.postToMainThread(new Runnable(this) {
                                /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI.d.AnonymousClass1 */
                                final /* synthetic */ d CNf;

                                {
                                    this.CNf = r1;
                                }

                                public final void run() {
                                    AppMethodBeat.i(120972);
                                    ScanTranslationResultUI.q(this.CNf.CNd);
                                    com.tencent.mm.ui.base.h.d(this.CNf.CNd.getContext(), this.CNf.CNd.getResources().getString(R.string.ge4), this.CNf.CNd.getResources().getString(R.string.zb), new DialogInterface.OnClickListener(this) {
                                        /* class com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI.d.AnonymousClass1.AnonymousClass1 */
                                        final /* synthetic */ AnonymousClass1 CNg;

                                        {
                                            this.CNg = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(120971);
                                            ScanTranslationResultUI.j(this.CNg.CNf.CNd);
                                            AppMethodBeat.o(120971);
                                        }
                                    });
                                    AppMethodBeat.o(120972);
                                }
                            });
                            this.CNd.CMS.qz(3);
                            break;
                        } else {
                            Log.i("MicroMsg.ScanTranslationResultUI", "fileId %s", bVar.fileId);
                            com.tencent.mm.kernel.g.azz().b(new m(this.CNd.CMO, (int) s.boW(this.CNe), bVar.fileId, bVar.aeskey));
                            break;
                        }
                }
                if (this.CNd.iOu == 1 && this.CNd.ijt != 0) {
                    Log.i("delete tmp path %s", this.CNe);
                    s.deleteFile(this.CNe);
                }
            }
            AppMethodBeat.o(120975);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(120988);
        kotlin.g.b.p.h(keyEvent, "event");
        if (i2 == 4) {
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginScanTranslation.class);
            if (ah == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
                AppMethodBeat.o(120988);
                throw tVar;
            }
            ((PluginScanTranslation) ah).getTranslationRender().eRW();
            if (this.iOu != 0) {
                if (this.iOu == 1 || this.iOu == 2 || this.iOu == 3) {
                    if (this.iOu == 1) {
                        this.CMS.qC((long) ((int) (System.currentTimeMillis() - this.CMT[1])));
                    }
                    if (this.CMS.agO() != 0) {
                        this.CMS.bfK();
                    }
                }
                AppMethodBeat.o(120988);
                return true;
            }
            eQX();
            AppMethodBeat.o(120988);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(120988);
        return onKeyDown;
    }

    private final void eQX() {
        AppMethodBeat.i(120989);
        finish();
        overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(120989);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(120990);
        super.onStop();
        com.tencent.mm.kernel.g.azz().b(294, this);
        AppMethodBeat.o(120990);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(120991);
        super.onDestroy();
        this.tgS.removeAllListeners();
        this.tgS.removeAllUpdateListeners();
        this.tgS.cancel();
        ai.clear();
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginScanTranslation.class);
        if (ah == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.PluginScanTranslation");
            AppMethodBeat.o(120991);
            throw tVar;
        }
        ((PluginScanTranslation) ah).getTranslationRender().eRW();
        AppMethodBeat.o(120991);
    }

    private final void cWg() {
        AppMethodBeat.i(120992);
        this.CMS.qz(2);
        this.CMO = (int) ((((long) z.aTY().hashCode()) + System.currentTimeMillis()) & -1);
        this.iOu = 1;
        eQP();
        if (n.I(this.CMP, LocaleUtil.CHINA, true)) {
            ImageView imageView = this.CMD;
            if (imageView == null) {
                kotlin.g.b.p.btv("viewSourceBtn");
            }
            imageView.setImageResource(R.raw.translation_result_chinese);
        } else {
            ImageView imageView2 = this.CMD;
            if (imageView2 == null) {
                kotlin.g.b.p.btv("viewSourceBtn");
            }
            imageView2.setImageResource(R.raw.translation_result_english);
        }
        View view = this.CMF;
        if (view == null) {
            kotlin.g.b.p.btv("topBgLayer");
        }
        view.setVisibility(0);
        View view2 = this.CMG;
        if (view2 == null) {
            kotlin.g.b.p.btv("bottomBgLayer");
        }
        view2.setVisibility(0);
        View view3 = this.CMC;
        if (view3 == null) {
            kotlin.g.b.p.btv("saveContainer");
        }
        view3.setVisibility(8);
        ImageView imageView3 = this.tgP;
        if (imageView3 == null) {
            kotlin.g.b.p.btv("scanLine");
        }
        imageView3.setVisibility(0);
        MMGestureGallery mMGestureGallery = this.CMM;
        if (mMGestureGallery == null) {
            kotlin.g.b.p.btv("gestureGallery");
        }
        mMGestureGallery.setVisibility(0);
        cWi();
        eQW();
        AppMethodBeat.o(120992);
    }

    private final void eQV() {
        AppMethodBeat.i(120993);
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo enterTranslateFinishStatus");
        this.iOu = 3;
        View view = this.CMC;
        if (view == null) {
            kotlin.g.b.p.btv("saveContainer");
        }
        view.setVisibility(0);
        if (n.I(this.CMP, LocaleUtil.CHINA, true)) {
            ImageView imageView = this.CMD;
            if (imageView == null) {
                kotlin.g.b.p.btv("viewSourceBtn");
            }
            imageView.setImageResource(R.drawable.b0s);
        } else {
            ImageView imageView2 = this.CMD;
            if (imageView2 == null) {
                kotlin.g.b.p.btv("viewSourceBtn");
            }
            imageView2.setImageResource(R.drawable.b0u);
        }
        ImageView imageView3 = this.tgP;
        if (imageView3 == null) {
            kotlin.g.b.p.btv("scanLine");
        }
        imageView3.setVisibility(8);
        cWj();
        if (this.source == 1 && Util.isNullOrNil(this.CMK)) {
            this.CMK = ((PluginScanTranslation) com.tencent.mm.kernel.g.ah(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
            try {
                BitmapUtil.saveBitmapToImage(this.CMJ, 80, Bitmap.CompressFormat.JPEG, this.CMK, false);
                aj ajVar = new aj();
                ajVar.field_originMD5 = MD5Util.getMD5String(kotlin.g.b.p.I(this.jrK, Long.valueOf(s.boX(this.jrK))));
                ajVar.field_resultFile = this.CMK;
                Log.i("MicroMsg.ScanTranslationResultUI", "insert translate result %s", this.CMK);
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginScanTranslation.class);
                kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginScanTranslation::class.java)");
                ((PluginScanTranslation) ah).getTranslationResultStorage().a(ajVar);
                AppMethodBeat.o(120993);
                return;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.ScanTranslationResultUI", e2, "save translate result file error", new Object[0]);
            }
        }
        AppMethodBeat.o(120993);
    }

    private final void cWi() {
        AppMethodBeat.i(120994);
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(-1);
        this.tgS.start();
        AppMethodBeat.o(120994);
    }

    private final void cWj() {
        AppMethodBeat.i(120995);
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(0);
        this.tgS.end();
        AppMethodBeat.o(120995);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        AppMethodBeat.i(120996);
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate onSceneEnd errType %s, errCode %s, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 != 0 || i3 != 0) {
            cWj();
            this.CMS.qz(5);
            this.CMS.qC((long) ((int) (System.currentTimeMillis() - this.CMT[1])));
            String string = getResources().getString(R.string.ge4);
            kotlin.g.b.p.g(string, "resources.getString(R.st…an_translating_no_result)");
            if (!Util.isNullOrNil(str)) {
                str2 = String.valueOf(str);
            } else {
                str2 = string;
            }
            com.tencent.mm.ui.base.h.a((Context) getContext(), str2, "", false, (DialogInterface.OnClickListener) new k(this));
        } else if (qVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneNewOCRTranslation");
            AppMethodBeat.o(120996);
            throw tVar;
        } else {
            List<ekt> ePQ = ((m) qVar).ePQ();
            if (ePQ != null && ((m) qVar).getSessionId() == this.CMO) {
                this.CMS.qB((long) ((int) (System.currentTimeMillis() - ((m) qVar).ePS())));
                Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo scanTranslate onSceneEnd angle %f, translationInfos length %d", Float.valueOf(((m) qVar).getAngle()), Integer.valueOf(ePQ.size()));
                if (ePQ.size() > 0) {
                    this.CMS.qz(1);
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginScanTranslation.class);
                    kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginScanTranslation::class.java)");
                    ((PluginScanTranslation) ah).getTranslationRender().a(this.CMO, ePQ, ((m) qVar).getAngle(), this.CMI, this);
                    if (!Util.isNullOrNil(((m) qVar).ePR())) {
                        this.CMP = ((m) qVar).ePR();
                        AppMethodBeat.o(120996);
                        return;
                    }
                } else {
                    this.CMS.qC((long) ((int) (System.currentTimeMillis() - this.CMT[1])));
                    String string2 = getResources().getString(R.string.ge4);
                    kotlin.g.b.p.g(string2, "resources.getString(R.st…an_translating_no_result)");
                    com.tencent.mm.ui.base.h.a((Context) getContext(), string2, "", false, (DialogInterface.OnClickListener) new j(this));
                    AppMethodBeat.o(120996);
                    return;
                }
            }
        }
        AppMethodBeat.o(120996);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    static final class j implements DialogInterface.OnClickListener {
        final /* synthetic */ ScanTranslationResultUI CNd;

        j(ScanTranslationResultUI scanTranslationResultUI) {
            this.CNd = scanTranslationResultUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(120981);
            ScanTranslationResultUI.j(this.CNd);
            AppMethodBeat.o(120981);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    static final class k implements DialogInterface.OnClickListener {
        final /* synthetic */ ScanTranslationResultUI CNd;

        k(ScanTranslationResultUI scanTranslationResultUI) {
            this.CNd = scanTranslationResultUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(120982);
            ScanTranslationResultUI.j(this.CNd);
            AppMethodBeat.o(120982);
        }
    }

    private final void an(Bitmap bitmap) {
        AppMethodBeat.i(120997);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(120997);
            return;
        }
        Log.i("MicroMsg.ScanTranslationResultUI", "alvinluo setImageBitmap size: %s, %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
        b bVar = this.CNb;
        if (bVar != null) {
            bVar.setImageBitmap(bitmap);
        }
        b bVar2 = this.CNb;
        if (bVar2 != null) {
            bVar2.notifyDataSetChanged();
            AppMethodBeat.o(120997);
            return;
        }
        AppMethodBeat.o(120997);
    }

    @Override // com.tencent.mm.plugin.scanner.util.k.b
    public final void d(int i2, Bitmap bitmap) {
        AppMethodBeat.i(120998);
        if (bitmap != null && i2 == this.CMO) {
            this.CMS.qC((long) ((int) (System.currentTimeMillis() - this.CMT[1])));
            this.CMJ = bitmap;
            eQV();
            an(this.CMJ);
        }
        AppMethodBeat.o(120998);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(120999);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 561 && i3 == -1) {
            String i4 = com.tencent.mm.ui.tools.a.i(getContext(), intent, com.tencent.mm.plugin.image.d.aSY());
            Log.i("MicroMsg.ScanTranslationResultUI", "select: [%s]", i4);
            if (!Util.isNullOrNil(i4)) {
                this.jrK = i4;
                this.source = 1;
                this.CMS.qx(2);
                Exif fromFile = Exif.fromFile(i4);
                kotlin.g.b.p.g(fromFile, "Exif.fromFile(filePath)");
                this.ijt = fromFile.getOrientationInDegree();
                Log.i("MicroMsg.ScanTranslationResultUI", "degree %s", Integer.valueOf(this.ijt));
                Bitmap decodeFileWithSample = BitmapUtil.decodeFileWithSample(i4);
                if (decodeFileWithSample != null) {
                    this.CMI = BitmapUtil.rotate(decodeFileWithSample, (float) this.ijt);
                    cWg();
                    an(this.CMI);
                }
            }
        }
        AppMethodBeat.o(120999);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI$TranslateImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/scanner/ui/ScanTranslationResultUI;)V", "bitmap", "Landroid/graphics/Bitmap;", "getCount", "", "getItem", "", "i", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImageBitmap", "", "scan-translation_release"})
    public final class b extends BaseAdapter {
        private Bitmap bitmap;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
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
            AppMethodBeat.i(120968);
            kotlin.g.b.p.h(viewGroup, "viewGroup");
            if (view == null) {
                MultiTouchImageView multiTouchImageView2 = new MultiTouchImageView(ScanTranslationResultUI.this.getContext(), 0, 0, (byte) 0);
                multiTouchImageView2.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                multiTouchImageView = multiTouchImageView2;
            } else {
                multiTouchImageView = (MultiTouchImageView) view;
            }
            if (this.bitmap != null) {
                multiTouchImageView.setImageBitmap(this.bitmap);
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 == null) {
                    kotlin.g.b.p.hyc();
                }
                int width = bitmap2.getWidth();
                Bitmap bitmap3 = this.bitmap;
                if (bitmap3 == null) {
                    kotlin.g.b.p.hyc();
                }
                multiTouchImageView.cN(width, bitmap3.getHeight());
                multiTouchImageView.gKy();
            }
            MultiTouchImageView multiTouchImageView3 = multiTouchImageView;
            AppMethodBeat.o(120968);
            return multiTouchImageView3;
        }

        public final void setImageBitmap(Bitmap bitmap2) {
            AppMethodBeat.i(120969);
            kotlin.g.b.p.h(bitmap2, "bitmap");
            this.bitmap = bitmap2;
            AppMethodBeat.o(120969);
        }
    }
}
