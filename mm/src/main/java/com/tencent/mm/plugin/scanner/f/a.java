package com.tencent.mm.plugin.scanner.f;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.f.e;
import com.tencent.mm.plugin.scanner.model.d;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.scanlib.ui.ScanView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002-.B'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001a\u0010 \u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\"H\u0016J,\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010+\u001a\u00020\u00162\b\u0010,\u001a\u0004\u0018\u00010\u0011R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scanMode", "", "scanView", "Lcom/tencent/scanlib/ui/ScanView;", "uiCallback", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;", "scanCallback", "Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "(ILcom/tencent/scanlib/ui/ScanView;Lcom/tencent/mm/plugin/scanner/result/ResultHandler$ResultHandlerUICallback;Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;)V", "captureImageUploader", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "galleryImageUploader", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "scanResultCallback", "uploadCallback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "cancelResult", "", "session", "", "destroy", "finishResult", "success", "", "getSource", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "handleResult", "result", "Landroid/os/Bundle;", "notifyEvent", "eventId", "data", "onSceneEnd", "errType", "errCode", "errMsg", "", "setLocationInfo", FirebaseAnalytics.b.LOCATION, "AiScanResultCallback", "Companion", "plugin-scan_release"})
public final class a extends e implements i, e.a {
    public static final b CIP = new b((byte) 0);
    public mu CAV;
    private final AbstractC1671a CIL;
    private final d.a CIM = new d.a(this) {
        /* class com.tencent.mm.plugin.scanner.f.a.AnonymousClass1 */
        final /* synthetic */ a CIQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.CIQ = r1;
        }

        @Override // com.tencent.mm.plugin.scanner.model.d.a
        public final void a(z zVar) {
            AppMethodBeat.i(52240);
            p.h(zVar, "result");
            this.CIQ.CIL.b(zVar);
            AppMethodBeat.o(52240);
        }

        @Override // com.tencent.mm.plugin.scanner.model.d.a
        public final void a(int i2, long j2, int i3, String str) {
            AppMethodBeat.i(161977);
            this.CIQ.CIL.b(i2, j2, i3, str);
            AppMethodBeat.o(161977);
        }

        @Override // com.tencent.mm.plugin.scanner.model.d.a
        public final void ePM() {
            AppMethodBeat.i(52242);
            Log.e("MicroMsg.AiImageHandler", "alvinluo onUploadError errCode: %d", 2);
            this.CIQ.r(2, null);
            AppMethodBeat.o(52242);
        }

        @Override // com.tencent.mm.plugin.scanner.model.d.a
        public final void aD(int i2, long j2) {
            AppMethodBeat.i(240558);
            this.CIQ.CIL.a(i2, j2, 1);
            AppMethodBeat.o(240558);
        }
    };
    public d CIN;
    public d CIO;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J*\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$AiScanResultCallback;", "", "notifyScanEvent", "", "source", "", "session", "", "event", "onScanResultFailed", "errCode", "errMsg", "", "onScanResultSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
    /* renamed from: com.tencent.mm.plugin.scanner.f.a$a  reason: collision with other inner class name */
    public interface AbstractC1671a {
        void a(int i2, long j2, int i3);

        void b(int i2, long j2, int i3, String str);

        void b(z zVar);
    }

    static {
        AppMethodBeat.i(52249);
        AppMethodBeat.o(52249);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/scanner/result/AiImageHandler$Companion;", "", "()V", "BUTTON_SELECT_IMAGE", "", "TAG", "", "plugin-scan_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public a(int i2, ScanView scanView, e.b bVar, AbstractC1671a aVar) {
        p.h(scanView, "scanView");
        p.h(bVar, "uiCallback");
        p.h(aVar, "scanCallback");
        AppMethodBeat.i(52248);
        this.mode = i2;
        this.CIW = scanView;
        this.CIX = bVar;
        this.context = scanView.getContext();
        this.CIL = aVar;
        g.azz().a(2580, this);
        AppMethodBeat.o(52248);
    }

    @Override // com.tencent.mm.plugin.scanner.f.e
    public final void c(long j2, Bundle bundle) {
        AppMethodBeat.i(52243);
        if (bundle == null) {
            AppMethodBeat.o(52243);
            return;
        }
        int i2 = bundle.getInt("scan_source", 0);
        if (i2 == 1) {
            if (this.CIO == null) {
                this.CIO = new d(i2, this.CIM);
            }
            d dVar = this.CIO;
            if (dVar != null) {
                dVar.CAV = this.CAV;
            }
            d dVar2 = this.CIO;
            if (dVar2 != null) {
                dVar2.c(j2, bundle);
                AppMethodBeat.o(52243);
                return;
            }
            AppMethodBeat.o(52243);
            return;
        }
        if (i2 == 2) {
            if (this.CIN == null) {
                this.CIN = new d(i2, this.CIM);
            }
            d dVar3 = this.CIO;
            if (dVar3 != null) {
                dVar3.CAV = null;
            }
            d dVar4 = this.CIN;
            if (dVar4 != null) {
                dVar4.c(j2, bundle);
                AppMethodBeat.o(52243);
                return;
            }
        }
        AppMethodBeat.o(52243);
    }

    @Override // com.tencent.mm.plugin.scanner.f.e
    public final void F(long j2, boolean z) {
        AppMethodBeat.i(161978);
        this.CAV = null;
        d dVar = this.CIO;
        if (dVar != null) {
            dVar.F(j2, z);
        }
        d dVar2 = this.CIN;
        if (dVar2 != null) {
            dVar2.F(j2, z);
            AppMethodBeat.o(161978);
            return;
        }
        AppMethodBeat.o(161978);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        d dVar;
        AppMethodBeat.i(52245);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = str;
        objArr[3] = qVar != null ? Integer.valueOf(qVar.getType()) : null;
        Log.i("MicroMsg.AiImageHandler", "alvinluo AiScanImage onSceneEnd errType %d, errCode %d, errMsg %s, scene type: %s", objArr);
        if (qVar != null) {
            if (qVar.getType() == 2580) {
                if (qVar instanceof com.tencent.mm.plugin.scanner.model.g) {
                    i4 = ((com.tencent.mm.plugin.scanner.model.g) qVar).source;
                } else {
                    i4 = -1;
                }
                if (i4 == 1) {
                    d dVar2 = this.CIO;
                    if (dVar2 != null) {
                        dVar2.onSceneEnd(i2, i3, str, qVar);
                        AppMethodBeat.o(52245);
                        return;
                    }
                    AppMethodBeat.o(52245);
                    return;
                } else if (i4 == 2 && (dVar = this.CIN) != null) {
                    dVar.onSceneEnd(i2, i3, str, qVar);
                    AppMethodBeat.o(52245);
                    return;
                }
            }
            AppMethodBeat.o(52245);
            return;
        }
        AppMethodBeat.o(52245);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.scanner.f.e.a
    public final void r(int i2, Bundle bundle) {
        AppMethodBeat.i(52246);
        Log.i("MicroMsg.AiImageHandler", "notify Event: %d", Integer.valueOf(i2));
        switch (i2) {
            case 0:
                AppMethodBeat.o(52246);
                return;
            case 1:
            case 2:
                this.CIW.onResume();
                AppMethodBeat.o(52246);
                return;
            case 3:
                this.CIX.cvn();
                AppMethodBeat.o(52246);
                return;
            case 5:
                this.CIW.onPause();
                break;
        }
        AppMethodBeat.o(52246);
    }

    @Override // com.tencent.mm.plugin.scanner.f.e
    public final void destroy() {
        AppMethodBeat.i(52247);
        g.azz().b(2580, this);
        if (this.CIN != null) {
            d.release();
        }
        if (this.CIO != null) {
            d.release();
        }
        AppMethodBeat.o(52247);
    }
}
