package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\b\u0010\"\u001a\u00020 H\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0012\u0010\u0011\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u0012\u0010\u0016\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\nR\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\n¨\u0006#"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "", "()V", "TAG", "", "contentPadding", "", "getContentPadding", "()I", "setContentPadding", "(I)V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "itemSpace", "getItemSpace", "setItemSpace", "minSpaceSize", "getMinSpaceSize", "parentWidth", "spanCount", "getSpanCount", "setSpanCount", "titlePadding", "getTitlePadding", "setTitlePadding", "setParentWidth", "", "width", "updateSize", "plugin-emojisdk_release"})
public abstract class o {
    private final String TAG = "MicroMsg.PanelSizeResolver";
    public int att;
    private int hbc;
    private int hbd;
    public int hbe;
    int hbf;

    public abstract float avS();

    public abstract float avT();

    public abstract float avU();

    public o() {
        Context context = MMApplicationContext.getContext();
        p.g(context, "context");
        context.getResources();
        this.hbc = a.fromDPToPix(context, 400);
    }

    public final void pn(int i2) {
        Log.i(this.TAG, "setParentWidth: ".concat(String.valueOf(i2)));
        if (i2 > 0) {
            this.hbc = i2;
            updateSize();
        }
    }

    /* access modifiers changed from: protected */
    public final void updateSize() {
        float avT = ((float) this.hbc) - (avT() * 2.0f);
        if (avT < avS() * 2.0f) {
            this.att = 1;
            return;
        }
        int avS = ((int) ((avT - avS()) / (avS() + avU()))) + 1;
        this.hbd = (int) ((avT - (avS() * ((float) avS))) / ((float) (avS - 1)));
        this.hbe = (int) (((((float) this.hbc) - (avS() * ((float) avS))) - ((float) (this.hbd * avS))) / 2.0f);
        this.hbf = this.hbd / 2;
        Log.i(this.TAG, "updateSize: " + avS() + ", " + avT() + ", " + avU() + ", " + this.att + ", " + this.hbd + ", " + this.hbe + ", " + this.hbf);
        this.att = avS;
    }
}
