package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b3\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001eB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001a\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00104\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0016J\u0010\u00105\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0002J\u0012\u00106\u001a\u0002002\b\u00107\u001a\u0004\u0018\u00010\rH\u0016J\b\u00108\u001a\u000200H\u0002J\b\u00109\u001a\u000200H\u0002J\b\u0010:\u001a\u000200H\u0002J\b\u0010;\u001a\u00020\u0018H\u0016J\b\u0010<\u001a\u00020\u001aH\u0016J\b\u0010=\u001a\u00020%H\u0016J\b\u0010>\u001a\u00020%H\u0016J\u0010\u0010?\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010@\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0016J\u0010\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020\nH\u0016J\u0010\u0010C\u001a\u0002002\u0006\u0010D\u001a\u00020\u0014H\u0016J\b\u0010E\u001a\u000200H\u0016J\u0010\u0010F\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0016J\u0010\u0010G\u001a\u0002002\u0006\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010H\u001a\u000200H\u0002J\b\u0010I\u001a\u000200H\u0016J\u0010\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020\u0014H\u0016J\u000e\u0010L\u001a\u0002002\u0006\u0010M\u001a\u00020\nJ\u0010\u0010N\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0016J\u0010\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020 H\u0016J\u0010\u0010Q\u001a\u0002002\u0006\u0010P\u001a\u00020 H\u0016J\u0012\u0010R\u001a\u0002002\b\u0010S\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010T\u001a\u0002002\b\u0010U\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010V\u001a\u0002002\b\u0010W\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010X\u001a\u0002002\b\u0010Y\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010Z\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0016J\u0010\u0010[\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0016J\u0010\u0010\\\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0002J\u0010\u0010]\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0002J\u0010\u0010^\u001a\u0002002\u0006\u0010_\u001a\u00020\u0014H\u0002J\b\u0010`\u001a\u000200H\u0002J\b\u0010a\u001a\u000200H\u0002J\b\u0010b\u001a\u000200H\u0002J\u0010\u0010c\u001a\u0002002\u0006\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010d\u001a\u000200H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScanSharedMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundView", "Landroid/view/TextureView;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurMaskView", "Landroid/widget/ImageView;", "contentLayout", "currentNetworkAvailable", "", "currentTab", "darkCornerMask", "flashSwitcher", "Lcom/tencent/mm/plugin/scanner/ui/ScannerFlashSwitcher;", "galleryButton", "Landroid/view/View;", "isFlashShow", "isTitleShowing", "mBottomExtraHeight", "needAnimateBackgroundView", "onFlashSwitcherClickListener", "Landroid/view/View$OnClickListener;", "onGalleryClickListener", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "scanTips", "Landroid/widget/TextView;", "scanTipsWording", "", "scanTitle", "scanToast", "showTitle", "showToast", "titleShowAnimationTask", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask;", "toastShowAnimationTask", "animateBackgroundView", "", "show", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "animateShow", "animateShowScanTips", "attachBackgroundView", "textureView", "cancelTitleAnimationTask", "cancelToastAnimationTask", "checkNetwork", "getFlashSwitcherView", "getGalleryButton", "getScanTipsView", "getScanTitleView", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onFlashStatusChanged", "onNetworkChange", "state", "onPreviewReady", "isSwitchTab", "onScanSuccess", "onShowInfoView", "onViewReady", "recycleBlurBitmap", "release", "setAnimateBackgroundView", "needAnimate", "setBottomExtraHeight", "bottomHeight", "setFlashStatus", "setOnFlashSwitcherClickListener", "onClickListener", "setOnGalleryClickListener", "setScanRequest", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "setScanTips", "tips", "setScanTitle", "title", "setScanToast", "toast", "setShowTitle", "setShowToast", "showGalleryButton", "showScanTips", "startTitleAnimationTask", "withShowAnimation", "startToastAnimationTask", "updateBackgroundBlurView", "updateTitleAndTips", "updateViewByNetwork", "updateViewLayoutParams", "Companion", "plugin-scan_release"})
public final class ScanSharedMaskView extends RelativeLayout {
    public static final a CSS = new a((byte) 0);
    private Bitmap BQT;
    private String CAQ;
    private BaseScanRequest CJD;
    public ScannerFlashSwitcher CJh;
    private boolean CJv;
    public TextView CSA;
    public TextView CSB;
    public TextView CSC;
    private ImageView CSD;
    public View CSE;
    private ImageView CSF;
    public int CSG;
    public TextureView CSH;
    private boolean CSI;
    private View.OnClickListener CSJ;
    private View.OnClickListener CSK;
    public com.tencent.mm.plugin.scanner.util.l CSL;
    private com.tencent.mm.plugin.scanner.util.l CSM;
    public boolean CSN;
    public boolean CSO;
    public int CSP;
    public boolean CSQ;
    private boolean CSR;
    public RelativeLayout contentLayout;

    static {
        AppMethodBeat.i(52465);
        AppMethodBeat.o(52465);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$Companion;", "", "()V", "TAG", "", "TITLE_ALPHA_DURATION", "", "TITLE_SHOW_DURATION", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void b(ScanSharedMaskView scanSharedMaskView, boolean z) {
        AppMethodBeat.i(240700);
        scanSharedMaskView.uf(z);
        AppMethodBeat.o(240700);
    }

    public static final /* synthetic */ void c(ScanSharedMaskView scanSharedMaskView) {
        AppMethodBeat.i(240697);
        scanSharedMaskView.eRr();
        AppMethodBeat.o(240697);
    }

    public static final /* synthetic */ ImageView d(ScanSharedMaskView scanSharedMaskView) {
        AppMethodBeat.i(240698);
        ImageView imageView = scanSharedMaskView.CSF;
        if (imageView == null) {
            p.btv("blurMaskView");
        }
        AppMethodBeat.o(240698);
        return imageView;
    }

    public static final /* synthetic */ TextView e(ScanSharedMaskView scanSharedMaskView) {
        AppMethodBeat.i(170089);
        TextView textView = scanSharedMaskView.CSA;
        if (textView == null) {
            p.btv("scanTitle");
        }
        AppMethodBeat.o(170089);
        return textView;
    }

    public static final /* synthetic */ void j(ScanSharedMaskView scanSharedMaskView) {
        AppMethodBeat.i(170091);
        scanSharedMaskView.uj(true);
        AppMethodBeat.o(170091);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanSharedMaskView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(52462);
        AppMethodBeat.o(52462);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanSharedMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(52463);
        AppMethodBeat.o(52463);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanSharedMaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(52464);
        this.CJv = true;
        this.CSQ = true;
        this.CAQ = "";
        View inflate = LayoutInflater.from(context).inflate(R.layout.aza, this);
        View findViewById = inflate.findViewById(R.id.bex);
        p.g(findViewById, "view.findViewById(R.id.content_layout)");
        this.contentLayout = (RelativeLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.har);
        p.g(findViewById2, "view.findViewById(R.id.scan_title)");
        this.CSA = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.haq);
        p.g(findViewById3, "view.findViewById(R.id.scan_tip_tv)");
        this.CSB = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.hax);
        p.g(findViewById4, "view.findViewById(R.id.scan_toast_tv)");
        this.CSC = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.bkc);
        p.g(findViewById5, "view.findViewById(R.id.dark_corner_mask)");
        this.CSD = (ImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.hb5);
        p.g(findViewById6, "view.findViewById(R.id.scanner_flash_switcher)");
        this.CJh = (ScannerFlashSwitcher) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.hhv);
        p.g(findViewById7, "view.findViewById(R.id.select_from_gallery)");
        this.CSE = findViewById7;
        View findViewById8 = inflate.findViewById(R.id.y3);
        p.g(findViewById8, "view.findViewById(R.id.background_blur_mask_view)");
        this.CSF = (ImageView) findViewById8;
        View view = this.CSE;
        if (view == null) {
            p.btv("galleryButton");
        }
        view.setOnClickListener(new d(this));
        ScannerFlashSwitcher scannerFlashSwitcher = this.CJh;
        if (scannerFlashSwitcher == null) {
            p.btv("flashSwitcher");
        }
        scannerFlashSwitcher.setOnClickListener(new e(this));
        TextView textView = this.CSA;
        if (textView == null) {
            p.btv("scanTitle");
        }
        ao.a(textView.getPaint(), 0.8f);
        AppMethodBeat.o(52464);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ ScanSharedMaskView CST;

        d(ScanSharedMaskView scanSharedMaskView) {
            this.CST = scanSharedMaskView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(52449);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View.OnClickListener onClickListener = this.CST.CSJ;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(52449);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ ScanSharedMaskView CST;

        e(ScanSharedMaskView scanSharedMaskView) {
            this.CST = scanSharedMaskView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(52450);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View.OnClickListener onClickListener = this.CST.CSK;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(52450);
        }
    }

    public final void setScanTitle(String str) {
        AppMethodBeat.i(52451);
        TextView textView = this.CSA;
        if (textView == null) {
            p.btv("scanTitle");
        }
        textView.setText(str);
        AppMethodBeat.o(52451);
    }

    public final void setShowTitle(boolean z) {
        this.CSQ = z;
    }

    public final TextView getScanTitleView() {
        AppMethodBeat.i(52452);
        TextView textView = this.CSA;
        if (textView == null) {
            p.btv("scanTitle");
        }
        AppMethodBeat.o(52452);
        return textView;
    }

    public final void setScanTips(String str) {
        String str2;
        AppMethodBeat.i(52453);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        this.CAQ = str2;
        TextView textView = this.CSB;
        if (textView == null) {
            p.btv("scanTips");
        }
        textView.setText(str);
        AppMethodBeat.o(52453);
    }

    public final TextView getScanTipsView() {
        AppMethodBeat.i(52454);
        TextView textView = this.CSB;
        if (textView == null) {
            p.btv("scanTips");
        }
        AppMethodBeat.o(52454);
        return textView;
    }

    public final void setScanToast(String str) {
        AppMethodBeat.i(240686);
        TextView textView = this.CSC;
        if (textView == null) {
            p.btv("scanToast");
        }
        textView.setText(str);
        AppMethodBeat.o(240686);
    }

    public final void setShowToast(boolean z) {
        this.CSR = z;
    }

    public final ScannerFlashSwitcher getFlashSwitcherView() {
        AppMethodBeat.i(52455);
        ScannerFlashSwitcher scannerFlashSwitcher = this.CJh;
        if (scannerFlashSwitcher == null) {
            p.btv("flashSwitcher");
        }
        AppMethodBeat.o(52455);
        return scannerFlashSwitcher;
    }

    public final void setOnGalleryClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(52456);
        p.h(onClickListener, "onClickListener");
        this.CSJ = onClickListener;
        View view = this.CSE;
        if (view == null) {
            p.btv("galleryButton");
        }
        view.setOnClickListener(this.CSJ);
        AppMethodBeat.o(52456);
    }

    public final void setOnFlashSwitcherClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(52457);
        p.h(onClickListener, "onClickListener");
        this.CSK = onClickListener;
        AppMethodBeat.o(52457);
    }

    public final View getGalleryButton() {
        AppMethodBeat.i(52458);
        View view = this.CSE;
        if (view == null) {
            p.btv("galleryButton");
        }
        AppMethodBeat.o(52458);
        return view;
    }

    public final void setBottomExtraHeight(int i2) {
        this.CSP = i2;
    }

    public final void setAnimateBackgroundView(boolean z) {
        AppMethodBeat.i(240687);
        this.CSI = z;
        if (!this.CSI || this.CSH == null) {
            Log.e("MicroMsg.ScanSharedMaskView", "updateBackgroundBlurView not need show blurMaskView");
            ImageView imageView = this.CSF;
            if (imageView == null) {
                p.btv("blurMaskView");
            }
            imageView.setVisibility(8);
            eRr();
            AppMethodBeat.o(240687);
            return;
        }
        com.tencent.f.h.RTc.aX(new h(this));
        AppMethodBeat.o(240687);
    }

    public final void f(boolean z, AnimatorListenerAdapter animatorListenerAdapter) {
        float f2 = 1.0f;
        AppMethodBeat.i(240688);
        if (this.BQT != null) {
            Bitmap bitmap = this.BQT;
            if (bitmap == null) {
                p.hyc();
            }
            if (!bitmap.isRecycled()) {
                ImageView imageView = this.CSF;
                if (imageView == null) {
                    p.btv("blurMaskView");
                }
                imageView.setVisibility(0);
                float f3 = z ? 0.0f : 1.0f;
                if (!z) {
                    f2 = 0.0f;
                }
                ImageView imageView2 = this.CSF;
                if (imageView2 == null) {
                    p.btv("blurMaskView");
                }
                imageView2.setAlpha(f3);
                ImageView imageView3 = this.CSF;
                if (imageView3 == null) {
                    p.btv("blurMaskView");
                }
                m.a(imageView3, f3, f2, 150, new b(this, z, animatorListenerAdapter));
                AppMethodBeat.o(240688);
                return;
            }
        }
        ImageView imageView4 = this.CSF;
        if (imageView4 == null) {
            p.btv("blurMaskView");
        }
        imageView4.setVisibility(8);
        AppMethodBeat.o(240688);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$animateBackgroundView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-scan_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ ScanSharedMaskView CST;
        final /* synthetic */ AnimatorListenerAdapter CSh;
        final /* synthetic */ boolean rti;

        b(ScanSharedMaskView scanSharedMaskView, boolean z, AnimatorListenerAdapter animatorListenerAdapter) {
            this.CST = scanSharedMaskView;
            this.rti = z;
            this.CSh = animatorListenerAdapter;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(240674);
            if (!this.rti) {
                ScanSharedMaskView.c(this.CST);
                ScanSharedMaskView.d(this.CST).setVisibility(8);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
                AppMethodBeat.o(240674);
                return;
            }
            AppMethodBeat.o(240674);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(240675);
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(animator);
                AppMethodBeat.o(240675);
                return;
            }
            AppMethodBeat.o(240675);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(240676);
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationRepeat(animator);
                AppMethodBeat.o(240676);
                return;
            }
            AppMethodBeat.o(240676);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(240677);
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationStart(animator);
                AppMethodBeat.o(240677);
                return;
            }
            AppMethodBeat.o(240677);
        }

        public final void onAnimationPause(Animator animator) {
            AppMethodBeat.i(240678);
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationPause(animator);
                AppMethodBeat.o(240678);
                return;
            }
            AppMethodBeat.o(240678);
        }

        public final void onAnimationResume(Animator animator) {
            AppMethodBeat.i(240679);
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationResume(animator);
                AppMethodBeat.o(240679);
                return;
            }
            AppMethodBeat.o(240679);
        }
    }

    public final void eQC() {
        boolean z;
        AppMethodBeat.i(240689);
        t azz = com.tencent.mm.kernel.g.azz();
        p.g(azz, "MMKernel.getNetSceneQueue()");
        if (azz.aYS() != 6) {
            t azz2 = com.tencent.mm.kernel.g.azz();
            p.g(azz2, "MMKernel.getNetSceneQueue()");
            if (azz2.aYS() != 4) {
                z = false;
                this.CJv = z;
                AppMethodBeat.o(240689);
            }
        }
        z = true;
        this.CJv = z;
        AppMethodBeat.o(240689);
    }

    public final void WY(int i2) {
        AppMethodBeat.i(240690);
        if (this.CJv) {
            ug(true);
            TextView textView = this.CSB;
            if (textView == null) {
                p.btv("scanTips");
            }
            textView.setText(this.CAQ);
            AppMethodBeat.o(240690);
        } else if (r.Xe(i2) || r.Xf(i2)) {
            TextView textView2 = this.CSB;
            if (textView2 == null) {
                p.btv("scanTips");
            }
            textView2.setText(R.string.gd2);
            ug(false);
            AppMethodBeat.o(240690);
        } else {
            ug(true);
            AppMethodBeat.o(240690);
        }
    }

    public final void uf(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(240691);
        if (!z || this.CJD == null) {
            TextView textView = this.CSB;
            if (textView == null) {
                p.btv("scanTips");
            }
            if (!z) {
                i2 = 8;
            }
            textView.setVisibility(i2);
            AppMethodBeat.o(240691);
            return;
        }
        TextView textView2 = this.CSB;
        if (textView2 == null) {
            p.btv("scanTips");
        }
        BaseScanRequest baseScanRequest = this.CJD;
        if (baseScanRequest == null) {
            p.hyc();
        }
        if (baseScanRequest.CAF || !z) {
            i2 = 8;
        }
        textView2.setVisibility(i2);
        AppMethodBeat.o(240691);
    }

    private final void ug(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(240692);
        if (!z || this.CJD == null) {
            View view = this.CSE;
            if (view == null) {
                p.btv("galleryButton");
            }
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
            AppMethodBeat.o(240692);
            return;
        }
        View view2 = this.CSE;
        if (view2 == null) {
            p.btv("galleryButton");
        }
        BaseScanRequest baseScanRequest = this.CJD;
        if (baseScanRequest == null) {
            p.hyc();
        }
        if (baseScanRequest.CAH || !z) {
            i2 = 8;
        }
        view2.setVisibility(i2);
        AppMethodBeat.o(240692);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$startTitleAnimationTask$1", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "onShowAnimationEnd", "", "show", "", "onShowAnimationStart", "onShowTaskEnd", "onShowTaskStart", "withShowAnimation", "plugin-scan_release"})
    public static final class f implements l.b {
        final /* synthetic */ ScanSharedMaskView CST;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public f(ScanSharedMaskView scanSharedMaskView) {
            this.CST = scanSharedMaskView;
        }

        @Override // com.tencent.mm.plugin.scanner.util.l.b
        public final void eRI() {
            AppMethodBeat.i(240680);
            ScanSharedMaskView.e(this.CST).setShadowLayer(10.0f, 0.0f, 0.0f, this.CST.getResources().getColor(R.color.BW_0_Alpha_0_2));
            AppMethodBeat.o(240680);
        }

        @Override // com.tencent.mm.plugin.scanner.util.l.b
        public final void eRJ() {
            AppMethodBeat.i(240681);
            this.CST.CSN = true;
            AppMethodBeat.o(240681);
        }

        @Override // com.tencent.mm.plugin.scanner.util.l.b
        public final void eRK() {
            AppMethodBeat.i(240682);
            this.CST.CSN = false;
            Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onShowTaskEnd isFlashShow: %b, showToast: %b", Boolean.valueOf(this.CST.CSO), Boolean.valueOf(this.CST.CSR));
            if (this.CST.CSO) {
                AppMethodBeat.o(240682);
            } else if (this.CST.CSR) {
                this.CST.CSR = false;
                ScanSharedMaskView.i(this.CST);
                AppMethodBeat.o(240682);
            } else {
                ScanSharedMaskView.j(this.CST);
                AppMethodBeat.o(240682);
            }
        }
    }

    public final void eRF() {
        AppMethodBeat.i(240693);
        com.tencent.mm.plugin.scanner.util.l lVar = this.CSL;
        if (lVar != null) {
            lVar.cancel();
            AppMethodBeat.o(240693);
            return;
        }
        AppMethodBeat.o(240693);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$startToastAnimationTask$1", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "onShowAnimationEnd", "", "show", "", "onShowAnimationStart", "onShowTaskEnd", "onShowTaskStart", "withShowAnimation", "plugin-scan_release"})
    public static final class g implements l.b {
        final /* synthetic */ ScanSharedMaskView CST;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(ScanSharedMaskView scanSharedMaskView) {
            this.CST = scanSharedMaskView;
        }

        @Override // com.tencent.mm.plugin.scanner.util.l.b
        public final void eRI() {
        }

        @Override // com.tencent.mm.plugin.scanner.util.l.b
        public final void eRJ() {
        }

        @Override // com.tencent.mm.plugin.scanner.util.l.b
        public final void eRK() {
            AppMethodBeat.i(240683);
            if (this.CST.CSO) {
                AppMethodBeat.o(240683);
                return;
            }
            ScanSharedMaskView.j(this.CST);
            AppMethodBeat.o(240683);
        }
    }

    public final void eRG() {
        AppMethodBeat.i(240694);
        com.tencent.mm.plugin.scanner.util.l lVar = this.CSM;
        if (lVar != null) {
            lVar.cancel();
            AppMethodBeat.o(240694);
            return;
        }
        AppMethodBeat.o(240694);
    }

    public final void tY(boolean z) {
        AppMethodBeat.i(52459);
        Log.v("MicroMsg.ScanSharedMaskView", "alvinluo onPreviewReady isSwitchTab: %b", Boolean.valueOf(z));
        if (!z) {
            View view = this.CSE;
            if (view == null) {
                p.btv("galleryButton");
            }
            if (view.getVisibility() == 0) {
                View view2 = this.CSE;
                if (view2 == null) {
                    p.btv("galleryButton");
                }
                m.a(view2, 0.0f, 1.0f, 200, (Animator.AnimatorListener) null);
            }
        }
        AppMethodBeat.o(52459);
    }

    public final void eRH() {
        AppMethodBeat.i(240695);
        Log.v("MicroMsg.ScanSharedMaskView", "alvinluo onScanSuccess");
        View view = this.CSE;
        if (view == null) {
            p.btv("galleryButton");
        }
        m.a(view, 1.0f, 0.0f, 200, (Animator.AnimatorListener) null);
        eRG();
        eRF();
        TextView textView = this.CSA;
        if (textView == null) {
            p.btv("scanTitle");
        }
        textView.setVisibility(8);
        TextView textView2 = this.CSC;
        if (textView2 == null) {
            p.btv("scanToast");
        }
        textView2.setVisibility(8);
        this.CSN = false;
        this.CSO = false;
        ScannerFlashSwitcher scannerFlashSwitcher = this.CJh;
        if (scannerFlashSwitcher == null) {
            p.btv("flashSwitcher");
        }
        scannerFlashSwitcher.setVisibility(8);
        AppMethodBeat.o(240695);
    }

    public final void setFlashStatus(boolean z) {
        AppMethodBeat.i(170085);
        Log.d("MicroMsg.ScanSharedMaskView", "alvinluo setFlashStatus show: %b", Boolean.valueOf(z));
        this.CSO = z;
        AppMethodBeat.o(170085);
    }

    public final void uh(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(170086);
        Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onFlashStatusChanged show: %b, isTitleShowing: %b", Boolean.valueOf(z), Boolean.valueOf(this.CSN));
        if (this.CSO != z) {
            this.CSO = z;
            if (!this.CSN) {
                if (z) {
                    z2 = false;
                }
                uj(z2);
            }
        }
        AppMethodBeat.o(170086);
    }

    public final void ui(boolean z) {
        AppMethodBeat.i(52460);
        Log.v("MicroMsg.ScanSharedMaskView", "alvinluo animateShow show: %b, alpha: %f", Boolean.valueOf(z), Float.valueOf(getAlpha()));
        if (!z || getAlpha() != 0.0f) {
            if (!z && getAlpha() == 1.0f) {
                m.a(this, 1.0f, 0.0f, 200, (Animator.AnimatorListener) null);
            }
            AppMethodBeat.o(52460);
            return;
        }
        m.a(this, 0.0f, 1.0f, 200, (Animator.AnimatorListener) null);
        AppMethodBeat.o(52460);
    }

    public final void setScanRequest(BaseScanRequest baseScanRequest) {
        this.CJD = baseScanRequest;
    }

    private final void uj(boolean z) {
        boolean z2 = false;
        float f2 = 1.0f;
        AppMethodBeat.i(170087);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        TextView textView = this.CSB;
        if (textView == null) {
            p.btv("scanTips");
        }
        if (textView.getVisibility() == 0) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        Log.d("MicroMsg.ScanSharedMaskView", "alvinluo animateScanTips show: %b, visible: %b", objArr);
        if (z && this.CJD != null) {
            BaseScanRequest baseScanRequest = this.CJD;
            if (baseScanRequest == null) {
                p.hyc();
            }
            if (baseScanRequest.CAF) {
                AppMethodBeat.o(170087);
                return;
            }
        }
        TextView textView2 = this.CSB;
        if (textView2 == null) {
            p.btv("scanTips");
        }
        if (textView2.getVisibility() == 0) {
            TextView textView3 = this.CSB;
            if (textView3 == null) {
                p.btv("scanTips");
            }
            if (textView3.getAlpha() == 1.0f && z) {
                AppMethodBeat.o(170087);
                return;
            }
        }
        TextView textView4 = this.CSB;
        if (textView4 == null) {
            p.btv("scanTips");
        }
        if (textView4.getVisibility() == 0 || z) {
            uf(true);
            TextView textView5 = this.CSB;
            if (textView5 == null) {
                p.btv("scanTips");
            }
            TextView textView6 = textView5;
            float f3 = z ? 0.0f : 1.0f;
            if (!z) {
                f2 = 0.0f;
            }
            m.a(textView6, f3, f2, 200, new c(this, z));
            AppMethodBeat.o(170087);
            return;
        }
        AppMethodBeat.o(170087);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$animateShowScanTips$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-scan_release"})
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ ScanSharedMaskView CST;
        final /* synthetic */ boolean rti;

        c(ScanSharedMaskView scanSharedMaskView, boolean z) {
            this.CST = scanSharedMaskView;
            this.rti = z;
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(170076);
            super.onAnimationCancel(animator);
            ScanSharedMaskView.b(this.CST, this.rti);
            AppMethodBeat.o(170076);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(170075);
            super.onAnimationEnd(animator);
            ScanSharedMaskView.b(this.CST, this.rti);
            AppMethodBeat.o(170075);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ ScanSharedMaskView CST;

        h(ScanSharedMaskView scanSharedMaskView) {
            this.CST = scanSharedMaskView;
        }

        public final void run() {
            AppMethodBeat.i(240685);
            ScanSharedMaskView.c(this.CST);
            TextureView textureView = this.CST.CSH;
            Bitmap bitmap = textureView != null ? textureView.getBitmap() : null;
            if (bitmap == null) {
                Log.e("MicroMsg.ScanSharedMaskView", "alvinluo updateBackgroundBlurView get bitmap failed");
                AppMethodBeat.o(240685);
                return;
            }
            m.a(bitmap, new kotlin.g.a.b<Bitmap, x>(this) {
                /* class com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.h.AnonymousClass1 */
                final /* synthetic */ h CSU;

                {
                    this.CSU = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Bitmap bitmap) {
                    AppMethodBeat.i(240684);
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        this.CSU.CST.BQT = bitmap2;
                        ScanSharedMaskView.d(this.CSU.CST).setImageBitmap(bitmap2);
                        ScanSharedMaskView.d(this.CSU.CST).setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(240684);
                    return xVar;
                }
            });
            AppMethodBeat.o(240685);
        }
    }

    private final void eRr() {
        AppMethodBeat.i(240696);
        if (this.BQT != null) {
            Bitmap bitmap = this.BQT;
            if (bitmap == null) {
                p.hyc();
            }
            if (!bitmap.isRecycled()) {
                Bitmap bitmap2 = this.BQT;
                if (bitmap2 == null) {
                    p.hyc();
                }
                bitmap2.recycle();
                this.BQT = null;
            }
        }
        AppMethodBeat.o(240696);
    }

    public static final /* synthetic */ void i(ScanSharedMaskView scanSharedMaskView) {
        AppMethodBeat.i(240699);
        if (scanSharedMaskView.CSM == null) {
            com.tencent.mm.plugin.scanner.util.l lVar = new com.tencent.mm.plugin.scanner.util.l();
            TextView textView = scanSharedMaskView.CSC;
            if (textView == null) {
                p.btv("scanToast");
            }
            com.tencent.mm.plugin.scanner.util.l eRZ = lVar.eV(textView).eRY().eRZ();
            eRZ.CUp = new g(scanSharedMaskView);
            scanSharedMaskView.CSM = eRZ;
        }
        com.tencent.mm.plugin.scanner.util.l lVar2 = scanSharedMaskView.CSM;
        if (lVar2 != null) {
            com.tencent.mm.plugin.scanner.util.l.a(lVar2);
            AppMethodBeat.o(240699);
            return;
        }
        AppMethodBeat.o(240699);
    }
}
