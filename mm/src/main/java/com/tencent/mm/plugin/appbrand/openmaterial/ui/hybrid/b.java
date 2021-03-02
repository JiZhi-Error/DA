package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.a;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentView", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView;", "getContentView", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "getListener", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;)V", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setAllowScroll2Hide", "allowScroll2Hide", "", "plugin-appbrand-integration_release"})
public final class b extends e {
    public a.AbstractC0763a nme;
    final HybridOpenMaterialView nml;

    public static final /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(229222);
        super.dismiss();
        AppMethodBeat.o(229222);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R.style.rn);
        p.h(context, "context");
        AppMethodBeat.i(229221);
        this.nml = new HybridOpenMaterialView(context);
        gR();
        AppMethodBeat.o(229221);
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        Window window;
        AppMethodBeat.i(229219);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
            window.addFlags(67108864);
        }
        ViewGroup.LayoutParams bQm = this.nml.bQm();
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(bQm.width, bQm.height);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setWindowAnimations(R.style.ro);
        }
        this.nml.setListener(new a(this));
        setContentView(this.nml, new ViewGroup.LayoutParams(-1, -1));
        setOnShowListener(new DialogInterface$OnShowListenerC0765b(this));
        setCancelable(true);
        AppMethodBeat.o(229219);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog$onCreate$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$ListenerAdapter;", "contentVisibleHeight", "", "Ljava/lang/Integer;", "onContentVisibleHeightChange", "", "height", "onHidden", "plugin-appbrand-integration_release"})
    public static final class a extends HybridOpenMaterialView.b {
        private Integer nmm;
        final /* synthetic */ b nmn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(b bVar) {
            this.nmn = bVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.a, com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.b
        public final void bQd() {
            AppMethodBeat.i(229216);
            super.bQd();
            try {
                b.a(this.nmn);
                AppMethodBeat.o(229216);
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.HybridOpenMaterialDialog", "super#dismiss, fail since ".concat(String.valueOf(e2)));
                AppMethodBeat.o(229216);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.a, com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.b
        public final void yH(int i2) {
            AppMethodBeat.i(229217);
            super.yH(i2);
            Integer num = this.nmm;
            if (num == null || i2 != num.intValue()) {
                a.AbstractC0763a aVar = this.nmn.nme;
                if (aVar != null) {
                    aVar.yH(i2);
                }
                this.nmm = Integer.valueOf(i2);
            }
            AppMethodBeat.o(229217);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"})
    /* renamed from: com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.b$b  reason: collision with other inner class name */
    static final class DialogInterface$OnShowListenerC0765b implements DialogInterface.OnShowListener {
        final /* synthetic */ b nmn;

        DialogInterface$OnShowListenerC0765b(b bVar) {
            this.nmn = bVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            AppMethodBeat.i(229218);
            this.nmn.nml.show();
            AppMethodBeat.o(229218);
        }
    }

    public final void dismiss() {
        AppMethodBeat.i(229220);
        this.nml.hide();
        AppMethodBeat.o(229220);
    }
}
