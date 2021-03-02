package com.tencent.mm.plugin.scanner.view;

import android.animation.Animator;
import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.model.ah;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u001c\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\u0012\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020\u0018H\u0002R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/scanner/view/ScanTranslationMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "Landroid/hardware/Camera$PreviewCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "captureBtn", "Landroid/view/View;", "captureTime", "", "isDestroyed", "", "startTimeArray", "", "translateHandler", "Lcom/tencent/mm/plugin/scanner/model/ScanTranslateHandler;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "initView", "rootView", "onNetworkChange", "state", "onPreviewFrame", "bytes", "", "camera", "Landroid/hardware/Camera;", "onPreviewReady", "isSwitchTab", "onResume", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "processFrame", "setBottomExtraHeight", "bottomHeight", "updateViewByNetwork", "Companion", "scan-translation_release"})
public final class ScanTranslationMaskView extends BaseScanMaskView<BaseScanRequest> implements Camera.PreviewCallback {
    public static final a CVv = new a((byte) 0);
    private final long[] CMT;
    private View CMz;
    private ah CVu;
    private boolean aMn;
    private long captureTime;

    static {
        AppMethodBeat.i(121028);
        AppMethodBeat.o(121028);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/scanner/view/ScanTranslationMaskView$Companion;", "", "()V", "REQUEST_CODE_SELECT_PICTURE", "", "TAG", "", "scan-translation_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanTranslationMaskView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(121025);
        AppMethodBeat.o(121025);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanTranslationMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(121026);
        AppMethodBeat.o(121026);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanTranslationMaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(121027);
        this.CMT = new long[2];
        View inflate = LayoutInflater.from(context).inflate(R.layout.az6, this);
        p.g(inflate, "view");
        View findViewById = inflate.findViewById(R.id.h_z);
        p.g(findViewById, "rootView.findViewById(R.id.scan_capture_btn)");
        this.CMz = findViewById;
        View view = this.CMz;
        if (view == null) {
            p.btv("captureBtn");
        }
        view.setEnabled(false);
        View view2 = this.CMz;
        if (view2 == null) {
            p.btv("captureBtn");
        }
        view2.setOnClickListener(new b(this));
        this.CVu = new ah(context);
        AppMethodBeat.o(121027);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ ScanTranslationMaskView CVw;

        b(ScanTranslationMaskView scanTranslationMaskView) {
            this.CVw = scanTranslationMaskView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(121010);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.d("MicroMsg.ScanTranslationMaskView", "alvinluo onCaptureBtn click");
            com.tencent.mm.plugin.scanner.a.a scanCamera = this.CVw.getScanCamera();
            if (scanCamera != null) {
                scanCamera.a(this.CVw);
            }
            this.CVw.captureTime = (long) ((int) (System.currentTimeMillis() - this.CVw.CMT[0]));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(121010);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void setBottomExtraHeight(int i2) {
        AppMethodBeat.i(121016);
        super.setBottomExtraHeight(i2);
        View view = this.CMz;
        if (view == null) {
            p.btv("captureBtn");
        }
        View view2 = this.CMz;
        if (view2 == null) {
            p.btv("captureBtn");
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24) + getMBottomExtraHeight();
        }
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(121016);
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        boolean z;
        AppMethodBeat.i(121017);
        Object[] objArr = new Object[1];
        objArr[0] = bArr != null ? Integer.valueOf(bArr.length) : null;
        Log.i("MicroMsg.ScanTranslationMaskView", "alvinluo onPreviewFrame data size: %d", objArr);
        if (bArr == null) {
            AppMethodBeat.o(121017);
            return;
        }
        if (!(bArr.length == 0)) {
            z = true;
        } else {
            z = false;
        }
        if (z && getScanCamera() != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray("key_translate_yuv_byte_array", bArr);
            com.tencent.mm.plugin.scanner.a.a scanCamera = getScanCamera();
            if (scanCamera == null) {
                p.hyc();
            }
            bundle.putParcelable("key_translate_camera_resolution", scanCamera.hkU());
            com.tencent.mm.plugin.scanner.a.a scanCamera2 = getScanCamera();
            if (scanCamera2 == null) {
                p.hyc();
            }
            bundle.putInt("key_translate_camera_rotation", scanCamera2.getCameraRotation());
            bundle.putLong("key_translate_capture_time", this.captureTime);
            ah ahVar = this.CVu;
            if (ahVar != null) {
                ahVar.c(System.currentTimeMillis(), bundle);
                AppMethodBeat.o(121017);
                return;
            }
        }
        AppMethodBeat.o(121017);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void eRq() {
        AppMethodBeat.i(121019);
        super.eRq();
        synchronized (Boolean.valueOf(this.aMn)) {
            try {
                this.aMn = false;
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(121019);
                throw th;
            }
        }
        eSk();
        AppMethodBeat.o(121019);
    }

    @Override // com.tencent.mm.plugin.scanner.view.b, com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void a(Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(121020);
        synchronized (Boolean.valueOf(this.aMn)) {
            try {
                this.aMn = true;
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(121020);
                throw th;
            }
        }
        m.a(this, 1.0f, 0.0f, 200, animatorListener);
        AppMethodBeat.o(121020);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void tY(boolean z) {
        AppMethodBeat.i(121021);
        super.tY(z);
        View view = this.CMz;
        if (view == null) {
            p.btv("captureBtn");
        }
        view.setEnabled(true);
        this.CMT[0] = System.currentTimeMillis();
        setVisibility(0);
        if (getCurrentNetworkAvailable()) {
            m.a(this, 0.0f, 1.0f, 200, (Animator.AnimatorListener) null);
        }
        AppMethodBeat.o(121021);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void onResume() {
        AppMethodBeat.i(121022);
        super.onResume();
        Log.i("MicroMsg.ScanTranslationMaskView", "alvinluo onResume");
        this.CMT[0] = System.currentTimeMillis();
        AppMethodBeat.o(121022);
    }

    @Override // com.tencent.mm.plugin.scanner.view.BaseScanMaskView
    public final void onNetworkChange(int i2) {
        AppMethodBeat.i(121023);
        super.onNetworkChange(i2);
        Log.i("MicroMsg.ScanTranslationMaskView", "alvinluo onNetworkChange state: %d, currentNetworkAvailable: %b", Integer.valueOf(i2), Boolean.valueOf(getCurrentNetworkAvailable()));
        eSk();
        AppMethodBeat.o(121023);
    }

    private final void eSk() {
        AppMethodBeat.i(121024);
        if (getCurrentNetworkAvailable()) {
            View view = this.CMz;
            if (view == null) {
                p.btv("captureBtn");
            }
            view.setVisibility(0);
            AppMethodBeat.o(121024);
            return;
        }
        View view2 = this.CMz;
        if (view2 == null) {
            p.btv("captureBtn");
        }
        view2.setVisibility(8);
        AppMethodBeat.o(121024);
    }
}
