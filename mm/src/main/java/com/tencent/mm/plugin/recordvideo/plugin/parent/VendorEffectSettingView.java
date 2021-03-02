package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.media.widget.b.a.a.b;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJS\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00140\u001bH\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/VendorEffectSettingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getCameraView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "setCameraView", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "setSeekBarItem", "", "seekBarId", "textViewId", "strId", "value", "max", "onChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "progress", "plugin-recordvideo_release"})
public final class VendorEffectSettingView extends FrameLayout {
    private final String TAG;
    private e wgS;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorEffectSettingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(75824);
        this.TAG = "MicroMsg.VendorEffectSettingView";
        View.inflate(context, R.layout.ly, this);
        com.tencent.mm.media.widget.b.a.a aVar = com.tencent.mm.media.widget.b.a.a.ioi;
        a(R.id.j2n, R.id.j2o, R.string.acx, com.tencent.mm.media.widget.b.a.a.aPN(), 5, new b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.parent.VendorEffectSettingView.AnonymousClass1 */
            final /* synthetic */ VendorEffectSettingView BXi;

            {
                this.BXi = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(75815);
                final int intValue = num.intValue();
                e cameraView = this.BXi.getCameraView();
                if (cameraView != null) {
                    cameraView.j(new kotlin.g.a.a<x>() {
                        /* class com.tencent.mm.plugin.recordvideo.plugin.parent.VendorEffectSettingView.AnonymousClass1.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(75814);
                            com.tencent.mm.media.widget.b.a.a aVar = com.tencent.mm.media.widget.b.a.a.ioi;
                            b.a aVar2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
                            com.tencent.mm.media.widget.b.a.a.ae(com.tencent.mm.media.widget.b.a.a.b.ioT, intValue);
                            x xVar = x.SXb;
                            AppMethodBeat.o(75814);
                            return xVar;
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(75815);
                return xVar;
            }
        });
        com.tencent.mm.media.widget.b.a.a aVar2 = com.tencent.mm.media.widget.b.a.a.ioi;
        a(R.id.j2p, R.id.j2q, R.string.ad2, com.tencent.mm.media.widget.b.a.a.aPO(), 100, new kotlin.g.a.b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.parent.VendorEffectSettingView.AnonymousClass2 */
            final /* synthetic */ VendorEffectSettingView BXi;

            {
                this.BXi = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(75817);
                final int intValue = num.intValue();
                e cameraView = this.BXi.getCameraView();
                if (cameraView != null) {
                    cameraView.j(new kotlin.g.a.a<x>() {
                        /* class com.tencent.mm.plugin.recordvideo.plugin.parent.VendorEffectSettingView.AnonymousClass2.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(75816);
                            com.tencent.mm.media.widget.b.a.a aVar = com.tencent.mm.media.widget.b.a.a.ioi;
                            b.a aVar2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
                            com.tencent.mm.media.widget.b.a.a.ae(com.tencent.mm.media.widget.b.a.a.b.ioV, intValue);
                            x xVar = x.SXb;
                            AppMethodBeat.o(75816);
                            return xVar;
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(75817);
                return xVar;
            }
        });
        com.tencent.mm.media.widget.b.a.a aVar3 = com.tencent.mm.media.widget.b.a.a.ioi;
        a(R.id.j2r, R.id.j2s, R.string.ad3, com.tencent.mm.media.widget.b.a.a.aPP(), 100, new kotlin.g.a.b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.parent.VendorEffectSettingView.AnonymousClass3 */
            final /* synthetic */ VendorEffectSettingView BXi;

            {
                this.BXi = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(75819);
                final int intValue = num.intValue();
                e cameraView = this.BXi.getCameraView();
                if (cameraView != null) {
                    cameraView.j(new kotlin.g.a.a<x>() {
                        /* class com.tencent.mm.plugin.recordvideo.plugin.parent.VendorEffectSettingView.AnonymousClass3.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(75818);
                            com.tencent.mm.media.widget.b.a.a aVar = com.tencent.mm.media.widget.b.a.a.ioi;
                            b.a aVar2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
                            com.tencent.mm.media.widget.b.a.a.ae(com.tencent.mm.media.widget.b.a.a.b.ioU, intValue);
                            x xVar = x.SXb;
                            AppMethodBeat.o(75818);
                            return xVar;
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(75819);
                return xVar;
            }
        });
        AppMethodBeat.o(75824);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VendorEffectSettingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(75825);
        AppMethodBeat.o(75825);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VendorEffectSettingView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(75826);
        AppMethodBeat.o(75826);
    }

    public final e getCameraView() {
        return this.wgS;
    }

    public final void setCameraView(e eVar) {
        this.wgS = eVar;
    }

    private final void a(int i2, int i3, int i4, int i5, int i6, kotlin.g.a.b<? super Integer, x> bVar) {
        AppMethodBeat.i(75823);
        View findViewById = findViewById(i2);
        p.g(findViewById, "findViewById(seekBarId)");
        SeekBar seekBar = (SeekBar) findViewById;
        View findViewById2 = findViewById(i3);
        p.g(findViewById2, "findViewById(textViewId)");
        TextView textView = (TextView) findViewById2;
        textView.setText(getResources().getString(i4, Integer.valueOf(i5)));
        seekBar.setProgress(i5);
        seekBar.setMax(i6);
        seekBar.setOnSeekBarChangeListener(new a(this, textView, i4, bVar));
        AppMethodBeat.o(75823);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/parent/VendorEffectSettingView$setSeekBarItem$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-recordvideo_release"})
    public static final class a implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ VendorEffectSettingView BXi;
        final /* synthetic */ int BXj;
        final /* synthetic */ kotlin.g.a.b BXk;
        final /* synthetic */ TextView hUM;

        a(VendorEffectSettingView vendorEffectSettingView, TextView textView, int i2, kotlin.g.a.b bVar) {
            this.BXi = vendorEffectSettingView;
            this.hUM = textView;
            this.BXj = i2;
            this.BXk = bVar;
        }

        public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            AppMethodBeat.i(75820);
            p.h(seekBar, "seekBar");
            this.hUM.setText(this.BXi.getResources().getString(this.BXj, Integer.valueOf(i2)));
            this.BXk.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(75820);
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
            AppMethodBeat.i(75821);
            p.h(seekBar, "seekBar");
            AppMethodBeat.o(75821);
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            AppMethodBeat.i(75822);
            p.h(seekBar, "seekBar");
            AppMethodBeat.o(75822);
        }
    }
}
