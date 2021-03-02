package com.tencent.mm.plugin.emojicapture.ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c;
import com.tencent.mm.plugin.appbrand.jsapi.aa.d;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e;
import com.tencent.mm.plugin.appbrand.jsapi.aa.f;
import com.tencent.mm.plugin.appbrand.jsapi.aa.g;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR7\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onModeSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mode", "", "getOnModeSelected", "()Lkotlin/jvm/functions/Function1;", "setOnModeSelected", "(Lkotlin/jvm/functions/Function1;)V", "plugin-emojicapture_release"})
public final class StickerPreviewChangeMode extends FrameLayout {
    private b<? super Integer, x> rwV;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StickerPreviewChangeMode(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(f.CTRL_INDEX);
        View.inflate(context, R.layout.bys, this);
        findViewById(R.id.i6g).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewChangeMode.AnonymousClass1 */
            final /* synthetic */ StickerPreviewChangeMode rwW;

            {
                this.rwW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(c.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b<Integer, x> onModeSelected = this.rwW.getOnModeSelected();
                if (onModeSelected != null) {
                    onModeSelected.invoke(0);
                }
                a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(c.CTRL_INDEX);
            }
        });
        findViewById(R.id.i6i).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewChangeMode.AnonymousClass2 */
            final /* synthetic */ StickerPreviewChangeMode rwW;

            {
                this.rwW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(e.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b<Integer, x> onModeSelected = this.rwW.getOnModeSelected();
                if (onModeSelected != null) {
                    onModeSelected.invoke(1);
                }
                a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(e.CTRL_INDEX);
            }
        });
        findViewById(R.id.i6h).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewChangeMode.AnonymousClass3 */
            final /* synthetic */ StickerPreviewChangeMode rwW;

            {
                this.rwW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(d.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b<Integer, x> onModeSelected = this.rwW.getOnModeSelected();
                if (onModeSelected != null) {
                    onModeSelected.invoke(2);
                }
                a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(d.CTRL_INDEX);
            }
        });
        AppMethodBeat.o(f.CTRL_INDEX);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StickerPreviewChangeMode(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(g.CTRL_INDEX);
        AppMethodBeat.o(g.CTRL_INDEX);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StickerPreviewChangeMode(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
        AppMethodBeat.o(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final b<Integer, x> getOnModeSelected() {
        return this.rwV;
    }

    public final void setOnModeSelected(b<? super Integer, x> bVar) {
        this.rwV = bVar;
    }
}
