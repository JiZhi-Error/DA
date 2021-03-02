package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiJumpDownloaderWidgetForNative;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.loader.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0013\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0016H\u0014J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "frame", "Landroid/view/View;", "frameBg", "frameLoadingBg", "lensId", "", "loading", "loadingCallback", "com/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1;", "bindLensId", "", "notifyLoadingResult", "result", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onDetachedFromWindow", "setSelected", "selected", "", "plugin-emojicapture_release"})
public final class StickerSelectFrame extends FrameLayout {
    private String rnS;
    final int rtS;
    final int rtT;
    final View rtU;
    final View rtV;
    private final a rtW;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StickerSelectFrame(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(674);
        this.rtS = R.drawable.emoji_sticker_select_frame_loading;
        this.rtT = R.drawable.emoji_sticker_select_frame;
        this.rtW = new a(this);
        View.inflate(context, R.layout.a2k, this);
        View findViewById = findViewById(R.id.c1r);
        p.g(findViewById, "findViewById(R.id.emoji_sticker_select_frame)");
        this.rtU = findViewById;
        View findViewById2 = findViewById(R.id.c1s);
        p.g(findViewById2, "findViewById(R.id.emoji_sticker_select_loading)");
        this.rtV = findViewById2;
        AppMethodBeat.o(674);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StickerSelectFrame(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(675);
        AppMethodBeat.o(675);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
    public static final class a implements f<g> {
        final /* synthetic */ StickerSelectFrame rtX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(StickerSelectFrame stickerSelectFrame) {
            this.rtX = stickerSelectFrame;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(g gVar, j jVar) {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.appdownload.f.CTRL_INDEX);
            g gVar2 = gVar;
            p.h(gVar2, "task");
            p.h(jVar, "status");
            if (p.j(gVar2.NNU.rnS, this.rtX.rnS)) {
                StickerSelectFrame stickerSelectFrame = this.rtX;
                p.h(jVar, "result");
                if (jVar == j.OK) {
                    stickerSelectFrame.rtU.setBackgroundResource(stickerSelectFrame.rtT);
                    stickerSelectFrame.rtV.setVisibility(8);
                    AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.appdownload.f.CTRL_INDEX);
                    return;
                }
                stickerSelectFrame.rtU.setBackgroundResource(stickerSelectFrame.rtS);
                stickerSelectFrame.rtV.setVisibility(0);
            }
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.appdownload.f.CTRL_INDEX);
        }
    }

    public final void anq(String str) {
        AppMethodBeat.i(JsApiJumpDownloaderWidgetForNative.CTRL_INDEX);
        this.rnS = str;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            this.rtU.setBackgroundResource(this.rtT);
            this.rtV.setVisibility(8);
            AppMethodBeat.o(JsApiJumpDownloaderWidgetForNative.CTRL_INDEX);
            return;
        }
        e eVar = e.NNN;
        if (e.bix(str)) {
            this.rtU.setBackgroundResource(this.rtT);
            this.rtV.setVisibility(8);
            AppMethodBeat.o(JsApiJumpDownloaderWidgetForNative.CTRL_INDEX);
            return;
        }
        this.rtU.setBackgroundResource(this.rtS);
        this.rtV.setVisibility(0);
        AppMethodBeat.o(JsApiJumpDownloaderWidgetForNative.CTRL_INDEX);
    }

    public final void setSelected(boolean z) {
        AppMethodBeat.i(672);
        super.setSelected(z);
        if (!z) {
            e eVar = e.NNN;
            e.b(this.rtW);
            setVisibility(8);
            AppMethodBeat.o(672);
            return;
        }
        e eVar2 = e.NNN;
        e.a(this.rtW);
        setVisibility(0);
        AppMethodBeat.o(672);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(673);
        super.onDetachedFromWindow();
        e eVar = e.NNN;
        e.b(this.rtW);
        AppMethodBeat.o(673);
    }
}
