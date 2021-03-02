package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\nH\u0002J\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\nJ\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "backEnable", "", "frontEnable", "icon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "iconCheck", "Landroid/widget/ImageView;", "isBack", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "enableBeauty", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "enable", "setIsUseBackCamera", "isBackCamera", "setVisibility", "visibility", "", "plugin-finder_release"})
public final class b implements t {
    boolean krh = true;
    private final WeImageView uGm = ((WeImageView) this.wgR.findViewById(R.id.a2n));
    private boolean wgN;
    boolean wgO;
    boolean wgP = true;
    private final ImageView wgQ = ((ImageView) this.wgR.findViewById(R.id.a2o));
    ViewGroup wgR;
    final e wgS;
    private d wgr;

    public b(ViewGroup viewGroup, d dVar, e eVar) {
        p.h(viewGroup, "view");
        p.h(dVar, "status");
        AppMethodBeat.i(254465);
        this.wgR = viewGroup;
        this.wgr = dVar;
        this.wgS = eVar;
        this.uGm.setIconColor(a.n(this.wgR.getContext(), R.color.act));
        this.wgQ.setImageDrawable(a.l(this.wgR.getContext(), R.raw.popvideo_post_selected_origin));
        this.wgR.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.video.plugin.b.AnonymousClass1 */
            final /* synthetic */ b wgT;

            {
                this.wgT = r1;
            }

            public final void onClick(View view) {
                boolean z;
                boolean z2 = true;
                AppMethodBeat.i(254458);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.wgT.krh) {
                    b bVar2 = this.wgT;
                    if (!this.wgT.wgO) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar2.wgO = z;
                    this.wgT.setEnable(this.wgT.wgO);
                } else {
                    b bVar3 = this.wgT;
                    if (this.wgT.wgP) {
                        z2 = false;
                    }
                    bVar3.wgP = z2;
                    this.wgT.setEnable(this.wgT.wgP);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254458);
            }
        });
        if (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_PURPLE) {
            this.wgR.setOnLongClickListener(new View.OnLongClickListener(this) {
                /* class com.tencent.mm.plugin.finder.video.plugin.b.AnonymousClass2 */
                final /* synthetic */ b wgT;

                {
                    this.wgT = r1;
                }

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(254459);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    android.support.design.widget.a aVar = new android.support.design.widget.a(this.wgT.wgR.getContext());
                    Window window = aVar.getWindow();
                    if (window != null) {
                        window.clearFlags(2);
                    }
                    Context context = this.wgT.wgR.getContext();
                    p.g(context, "view.context");
                    XLabEffectSettingView xLabEffectSettingView = new XLabEffectSettingView(context);
                    xLabEffectSettingView.setCameraView(this.wgT.wgS);
                    aVar.setContentView(xLabEffectSettingView);
                    aVar.show();
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(254459);
                    return true;
                }
            });
        }
        AppMethodBeat.o(254465);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(254466);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(254466);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(254460);
        if (this.wgN) {
            this.wgR.setVisibility(i2);
        }
        AppMethodBeat.o(254460);
    }

    public final void oS(boolean z) {
        AppMethodBeat.i(254461);
        this.krh = z;
        if (this.wgN) {
            setEnable(this.krh ? this.wgO : this.wgP);
        }
        AppMethodBeat.o(254461);
    }

    public final void a(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(254462);
        p.h(recordConfigProvider, "config");
        this.wgN = recordConfigProvider.BOJ.BOM;
        if (this.wgN) {
            this.wgR.setVisibility(0);
            setEnable(this.krh ? this.wgO : this.wgP);
            AppMethodBeat.o(254462);
            return;
        }
        this.wgR.setVisibility(8);
        AppMethodBeat.o(254462);
    }

    /* access modifiers changed from: package-private */
    public final void setEnable(boolean z) {
        AppMethodBeat.i(254463);
        ImageView imageView = this.wgQ;
        p.g(imageView, "iconCheck");
        imageView.setVisibility(z ? 0 : 4);
        c cVar = c.BXI;
        c.x("KEY_RECORD_IS_BEAUTIFY", Boolean.valueOf(z));
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_BEAUTIFY_ENABLE", z);
        this.wgr.a(d.c.BUF, bundle);
        AppMethodBeat.o(254463);
    }

    public final boolean dFS() {
        AppMethodBeat.i(254464);
        ImageView imageView = this.wgQ;
        p.g(imageView, "iconCheck");
        if (imageView.getVisibility() == 0) {
            AppMethodBeat.o(254464);
            return true;
        }
        AppMethodBeat.o(254464);
        return false;
    }
}
