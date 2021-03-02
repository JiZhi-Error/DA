package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemSizeResolver;", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "minSpaceSize", "getMinSpaceSize", "plugin-emojisdk_release"})
public final class j extends o {
    private final float haX;
    private final float haY;
    private final float haZ;
    private final float hba;

    public j() {
        AppMethodBeat.i(199968);
        Context context = MMApplicationContext.getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        this.haX = resources.getDimension(R.dimen.a2w);
        this.haY = resources.getDimension(R.dimen.cb);
        this.haZ = resources.getDimension(R.dimen.c5) - 1.0f;
        this.hba = resources.getDimension(R.dimen.bt);
        this.att = 5;
        updateSize();
        AppMethodBeat.o(199968);
    }

    @Override // com.tencent.mm.emoji.panel.a.o
    public final float avS() {
        return this.haX;
    }

    @Override // com.tencent.mm.emoji.panel.a.o
    public final float avT() {
        return this.haY;
    }

    @Override // com.tencent.mm.emoji.panel.a.o
    public final float avU() {
        return this.haZ;
    }
}
