package com.tencent.mm.plugin.scanner.view;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 w*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001wB\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0015H\u0016J\u0012\u0010P\u001a\u00020N2\b\u0010Q\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010R\u001a\u00020N2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010S\u001a\u00020N2\u0006\u0010T\u001a\u00020HH\u0017J\b\u0010U\u001a\u00020NH\u0002J\n\u0010V\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010W\u001a\u00020NH\u0002J\u0010\u0010X\u001a\u00020N2\u0006\u0010Y\u001a\u00020\fH\u0017J\b\u0010Z\u001a\u00020NH\u0016J\u0010\u0010[\u001a\u00020N2\u0006\u0010\\\u001a\u00020\u0015H\u0017J\b\u0010]\u001a\u00020NH\u0016J\u001a\u0010^\u001a\u00020N2\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0010\u0010c\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0015H\u0016J\u0010\u0010d\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0015H\u0016J\u0012\u0010e\u001a\u00020N2\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\b\u0010h\u001a\u00020NH\u0017J\b\u0010i\u001a\u00020NH\u0017J\u0010\u0010j\u001a\u00020N2\u0006\u0010k\u001a\u00020\fH\u0016J\u0012\u0010l\u001a\u00020N2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010m\u001a\u00020N2\b\u0010n\u001a\u0004\u0018\u000101J\u0010\u0010o\u001a\u00020N2\b\u0010n\u001a\u0004\u0018\u000101J\u0017\u0010p\u001a\u00020N2\b\u0010<\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010@J\u0010\u0010q\u001a\u00020N2\u0006\u0010r\u001a\u00020\fH\u0016J\u001a\u0010s\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00152\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\u0010\u0010v\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0015H\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\u001a\u0010(\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001a\u00109\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R\u001c\u0010<\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006x"}, hxF = {"Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "T", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/view/IScanMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "currentNetworkAvailable", "", "getCurrentNetworkAvailable", "()Z", "setCurrentNetworkAvailable", "(Z)V", "flashSwitcher", "Landroid/view/View;", "getFlashSwitcher", "()Landroid/view/View;", "setFlashSwitcher", "(Landroid/view/View;)V", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getFrameData", "()Lcom/tencent/qbar/ScanDecodeFrameData;", "setFrameData", "(Lcom/tencent/qbar/ScanDecodeFrameData;)V", "isViewDestroy", "setViewDestroy", "mBottomExtraHeight", "getMBottomExtraHeight", "()I", "setMBottomExtraHeight", "(I)V", "mGalleryButton", "getMGalleryButton", "setMGalleryButton", "mPreviewRect", "Landroid/graphics/Rect;", "getMPreviewRect", "()Landroid/graphics/Rect;", "setMPreviewRect", "(Landroid/graphics/Rect;)V", "mScanRect", "getMScanRect", "setMScanRect", "mScanSource", "getMScanSource", "setMScanSource", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "getRequest", "()Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "setRequest", "(Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;)V", "scanCamera", "Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "getScanCamera", "()Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "setScanCamera", "(Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;)V", "scanTips", "Landroid/widget/TextView;", "getScanTips", "()Landroid/widget/TextView;", "setScanTips", "(Landroid/widget/TextView;)V", "animateShow", "", "show", "attachBackgroundView", "backgroundView", "attachScanCamera", "attachScanTipsView", "tipsView", "checkNetwork", "getTargetSuccessMarkView", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onNetworkChange", "state", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "onShowInfoView", "onShowNetworkLoading", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "release", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setPreviewRect", "rect", "setScanRect", "setScanRequest", "setScanSource", "scanSource", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showScanTips", "Companion", "scan-sdk_release"})
public abstract class BaseScanMaskView<T extends BaseScanRequest> extends RelativeLayout implements b<T> {
    public static final a CUQ = new a((byte) 0);
    private boolean CJv;
    public com.tencent.mm.plugin.scanner.a.a CMx;
    public TextView CSB;
    private int CSP;
    private View CUI;
    private View CUJ;
    private Rect CUK;
    private Rect CUL;
    private int CUM;
    public boolean CUN;
    private ScanDecodeFrameData CUO;
    private BaseScanRequest CUP;
    private Activity activity;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView$Companion;", "", "()V", "ALPHA_ANIMATION_DURATION", "", "SUCCESS_MARK_VIEW_ANIMATION_DURATION", "TAG", "", "scan-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Activity getActivity() {
        return this.activity;
    }

    /* access modifiers changed from: protected */
    public final void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    public final TextView getScanTips() {
        return this.CSB;
    }

    /* access modifiers changed from: protected */
    public final void setScanTips(TextView textView) {
        this.CSB = textView;
    }

    /* access modifiers changed from: protected */
    public final View getFlashSwitcher() {
        return this.CUI;
    }

    /* access modifiers changed from: protected */
    public final void setFlashSwitcher(View view) {
        this.CUI = view;
    }

    /* access modifiers changed from: protected */
    public final View getMGalleryButton() {
        return this.CUJ;
    }

    /* access modifiers changed from: protected */
    public final void setMGalleryButton(View view) {
        this.CUJ = view;
    }

    /* access modifiers changed from: protected */
    public final Rect getMPreviewRect() {
        return this.CUK;
    }

    /* access modifiers changed from: protected */
    public final void setMPreviewRect(Rect rect) {
        this.CUK = rect;
    }

    /* access modifiers changed from: protected */
    public final Rect getMScanRect() {
        return this.CUL;
    }

    /* access modifiers changed from: protected */
    public final void setMScanRect(Rect rect) {
        this.CUL = rect;
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.scanner.a.a getScanCamera() {
        return this.CMx;
    }

    /* access modifiers changed from: protected */
    public final void setScanCamera(com.tencent.mm.plugin.scanner.a.a aVar) {
        this.CMx = aVar;
    }

    public final int getMScanSource() {
        return this.CUM;
    }

    /* access modifiers changed from: protected */
    public final void setMScanSource(int i2) {
        this.CUM = i2;
    }

    /* access modifiers changed from: protected */
    public final boolean getCurrentNetworkAvailable() {
        return this.CJv;
    }

    /* access modifiers changed from: protected */
    public final void setCurrentNetworkAvailable(boolean z) {
        this.CJv = z;
    }

    /* access modifiers changed from: protected */
    public final int getMBottomExtraHeight() {
        return this.CSP;
    }

    /* access modifiers changed from: protected */
    public final void setMBottomExtraHeight(int i2) {
        this.CSP = i2;
    }

    /* access modifiers changed from: protected */
    public final void setViewDestroy(boolean z) {
        this.CUN = z;
    }

    /* access modifiers changed from: protected */
    public final ScanDecodeFrameData getFrameData() {
        return this.CUO;
    }

    /* access modifiers changed from: protected */
    public final void setFrameData(ScanDecodeFrameData scanDecodeFrameData) {
        this.CUO = scanDecodeFrameData;
    }

    public final BaseScanRequest getRequest() {
        return this.CUP;
    }

    /* access modifiers changed from: protected */
    public final void setRequest(BaseScanRequest baseScanRequest) {
        this.CUP = baseScanRequest;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseScanMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseScanMaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        eQC();
        Log.i("MicroMsg.BaseScanMaskView", "alvinluo init networkAvailable: %b", Boolean.valueOf(this.CJv));
    }

    private final void eQC() {
        boolean z;
        t azz = g.azz();
        p.g(azz, "MMKernel.getNetSceneQueue()");
        if (azz.aYS() != 6) {
            t azz2 = g.azz();
            p.g(azz2, "MMKernel.getNetSceneQueue()");
            if (azz2.aYS() != 4) {
                z = false;
                this.CJv = z;
            }
        }
        z = true;
        this.CJv = z;
    }

    public final void uf(boolean z) {
        int i2 = 0;
        if (!z || this.CUP == null) {
            TextView textView = this.CSB;
            if (textView != null) {
                if (!z) {
                    i2 = 8;
                }
                textView.setVisibility(i2);
                return;
            }
            return;
        }
        TextView textView2 = this.CSB;
        if (textView2 != null) {
            BaseScanRequest baseScanRequest = this.CUP;
            if (baseScanRequest == null) {
                p.hyc();
            }
            if (baseScanRequest.CAF || !z) {
                i2 = 8;
            }
            textView2.setVisibility(i2);
        }
    }

    public void eU(View view) {
    }

    public final void setPreviewRect(Rect rect) {
        this.CUK = rect;
        postInvalidate();
    }

    public final void setScanRect(Rect rect) {
        this.CUL = rect;
    }

    public void setDecodeSuccessFrameData(ScanDecodeFrameData scanDecodeFrameData) {
        this.CUO = scanDecodeFrameData;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    @Override // com.tencent.mm.plugin.scanner.view.b
    public void release() {
    }

    public void onNetworkChange(int i2) {
        Log.i("MicroMsg.BaseScanMaskView", "alvinluo onNetworkChange state: %d", Integer.valueOf(i2));
        eQC();
    }

    @Override // com.tencent.mm.plugin.scanner.view.b
    public void a(Animator.AnimatorListener animatorListener) {
        Log.d("MicroMsg.BaseScanMaskView", "alvinluo onViewDestroy hashCode: %d", Integer.valueOf(hashCode()));
        this.CUN = true;
    }

    public void eRq() {
        Log.i("MicroMsg.BaseScanMaskView", "alvinluo onViewReady hashCode: %d", Integer.valueOf(hashCode()));
        this.CUN = false;
    }

    public void tY(boolean z) {
        Log.i("MicroMsg.BaseScanMaskView", "alvinluo onPreviewReady hashCode: %d, isSwitchTab: %b", Integer.valueOf(hashCode()), Boolean.valueOf(z));
    }

    public void b(Object obj, d dVar) {
        p.h(obj, "data");
    }

    public void setScanSource(int i2) {
        this.CUM = i2;
    }

    public void b(boolean z, DialogInterface.OnCancelListener onCancelListener) {
    }

    public void setBottomExtraHeight(int i2) {
        this.CSP = i2;
    }

    public final void ui(boolean z) {
        if (z && getAlpha() == 0.0f) {
            m.a(this, 0.0f, 1.0f, 200, (Animator.AnimatorListener) null);
        } else if (!z && getAlpha() == 1.0f) {
            m.a(this, 1.0f, 0.0f, 200, (Animator.AnimatorListener) null);
        }
    }

    public View getTargetSuccessMarkView() {
        return null;
    }

    public void uc(boolean z) {
    }

    public void eRz() {
    }

    public void setScanRequest(T t) {
        this.CUP = t;
    }
}
