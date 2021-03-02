package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardCdnImageView;", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "plugin-card_release"})
public final class CardCdnImageView extends CdnImageView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardCdnImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(112402);
        init();
        AppMethodBeat.o(112402);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardCdnImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(112403);
        init();
        AppMethodBeat.o(112403);
    }

    private final void init() {
        AppMethodBeat.i(112401);
        setImgSavedPath(m.pTN + FilePathGenerator.ANDROID_DIR_SEP);
        AppMethodBeat.o(112401);
    }
}
