package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.box.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "opListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel$OpListener;", "viewHeight", "zoomButton", "Landroid/widget/ImageView;", "getVieHeight", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "onZoomStateChanged", "zoomState", "release", "setOpListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "plugin-scan_release"})
public final class ScanOCRDialogBackgroundOpView extends RelativeLayout implements b {
    public static final a CDw = new a((byte) 0);
    private b.a CDu;
    private ImageView CDv;
    private int gRE;

    static {
        AppMethodBeat.i(240334);
        AppMethodBeat.o(240334);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanOCRDialogBackgroundOpView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(240331);
        AppMethodBeat.o(240331);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanOCRDialogBackgroundOpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(240332);
        AppMethodBeat.o(240332);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanOCRDialogBackgroundOpView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(240333);
        this.CDv = (ImageView) LayoutInflater.from(context).inflate(R.layout.az4, (ViewGroup) this, true).findViewById(R.id.jso);
        ImageView imageView = this.CDv;
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
        this.gRE = com.tencent.mm.cb.a.fromDPToPix(context, 28);
        AppMethodBeat.o(240333);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ ScanOCRDialogBackgroundOpView CDx;

        b(ScanOCRDialogBackgroundOpView scanOCRDialogBackgroundOpView) {
            this.CDx = scanOCRDialogBackgroundOpView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(240329);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b.a aVar = this.CDx.CDu;
            if (aVar != null) {
                aVar.bmr();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240329);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.box.b
    public final int getVieHeight() {
        return this.gRE;
    }

    @Override // com.tencent.mm.plugin.scanner.box.b
    public final void setOpListener(b.a aVar) {
        this.CDu = aVar;
    }

    @Override // com.tencent.mm.plugin.scanner.box.b
    public final void Ws(int i2) {
        AppMethodBeat.i(240330);
        if (i2 == 1) {
            ImageView imageView = this.CDv;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.c_y);
                AppMethodBeat.o(240330);
                return;
            }
            AppMethodBeat.o(240330);
            return;
        }
        ImageView imageView2 = this.CDv;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.c_z);
            AppMethodBeat.o(240330);
            return;
        }
        AppMethodBeat.o(240330);
    }

    @Override // com.tencent.mm.plugin.scanner.box.b
    public final void release() {
        this.CDu = null;
    }
}
