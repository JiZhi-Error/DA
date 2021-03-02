package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\nJ\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "backEnable", "", "frontEnable", "isBack", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "enable", "setIsUseBackCamera", "isBackCamera", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class v implements t {
    public boolean krh = true;
    public boolean wgN;
    public boolean wgO;
    public boolean wgP = true;
    final e wgS;
    public WeImageView wgX;
    private d wgr;

    public v(WeImageView weImageView, d dVar, e eVar) {
        p.h(weImageView, "view");
        p.h(dVar, "status");
        AppMethodBeat.i(182849);
        this.wgX = weImageView;
        this.wgr = dVar;
        this.wgS = eVar;
        this.wgX.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.v.AnonymousClass1 */
            final /* synthetic */ v BRq;

            {
                this.BRq = r1;
            }

            public final void onClick(View view) {
                boolean z;
                boolean z2 = true;
                AppMethodBeat.i(182844);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.BRq.krh) {
                    v vVar = this.BRq;
                    if (!this.BRq.wgO) {
                        z = true;
                    } else {
                        z = false;
                    }
                    vVar.wgO = z;
                    this.BRq.setEnable(this.BRq.wgO);
                } else {
                    v vVar2 = this.BRq;
                    if (this.BRq.wgP) {
                        z2 = false;
                    }
                    vVar2.wgP = z2;
                    this.BRq.setEnable(this.BRq.wgP);
                }
                a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(182844);
            }
        });
        if (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_PURPLE) {
            this.wgX.setOnLongClickListener(new View.OnLongClickListener(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.v.AnonymousClass2 */
                final /* synthetic */ v BRq;

                {
                    this.BRq = r1;
                }

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(182845);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    android.support.design.widget.a aVar = new android.support.design.widget.a(this.BRq.wgX.getContext());
                    Window window = aVar.getWindow();
                    if (window != null) {
                        window.clearFlags(2);
                    }
                    Context context = this.BRq.wgX.getContext();
                    p.g(context, "view.context");
                    XLabEffectSettingView xLabEffectSettingView = new XLabEffectSettingView(context);
                    xLabEffectSettingView.setCameraView(this.BRq.wgS);
                    aVar.setContentView(xLabEffectSettingView);
                    aVar.show();
                    a.a(true, (Object) this, "com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(182845);
                    return true;
                }
            });
        }
        AppMethodBeat.o(182849);
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
        AppMethodBeat.i(237303);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237303);
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
        AppMethodBeat.i(182846);
        if (this.wgN) {
            this.wgX.setVisibility(i2);
        }
        AppMethodBeat.o(182846);
    }

    public final void oS(boolean z) {
        AppMethodBeat.i(182847);
        this.krh = z;
        if (this.wgN) {
            setEnable(this.krh ? this.wgO : this.wgP);
        }
        AppMethodBeat.o(182847);
    }

    public final void setEnable(boolean z) {
        int i2;
        AppMethodBeat.i(182848);
        c cVar = c.BXI;
        c.x("KEY_RECORD_IS_BEAUTIFY", Boolean.valueOf(z));
        WeImageView weImageView = this.wgX;
        if (z) {
            Context context = this.wgX.getContext();
            p.g(context, "view.context");
            i2 = context.getResources().getColor(R.color.a3b);
        } else {
            i2 = -1;
        }
        weImageView.setIconColor(i2);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_BEAUTIFY_ENABLE", z);
        this.wgr.a(d.c.BUF, bundle);
        AppMethodBeat.o(182848);
    }
}
