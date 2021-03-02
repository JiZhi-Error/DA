package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.emoji.panel.a.h;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.emoji.panel.a.r;
import com.tencent.mm.emoji.panel.a.s;
import com.tencent.mm.emoji.panel.a.t;
import com.tencent.mm.emoji.panel.a.u;
import com.tencent.mm.emoji.panel.a.v;
import com.tencent.mm.emoji.panel.a.z;
import com.tencent.tav.core.AssetExtension;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u001c\u0010\u0014\u001a\u00020\u00102\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u001c\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0006\u0010\u001b\u001a\u00020\u0010J\u0014\u0010\u001c\u001a\u00020\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0006\u0010 \u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\u0010J\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u0010J\u0006\u0010%\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "talkName", "", "(Ljava/lang/String;)V", "gifAutoPlay", "", "maxBindViewPosition", "", "getMaxBindViewPosition", "()I", "setMaxBindViewPosition", "(I)V", "getTalkName", "()Ljava/lang/String;", "addEmojiStoreEntry", "", "getGifAutoPlay", "getItemViewType", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBottomData", "setData", "list", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "setEmptyData", "setErrorNetwork", "setGifAutoPlay", AssetExtension.SCENE_PLAY, "setLoadData", "setResultHead", "Companion", "plugin-emojisdk_release"})
public final class a extends h {
    public static final C0961a rgE = new C0961a((byte) 0);
    public boolean hbx = true;
    private int rgC;
    private final String rgD;

    static {
        AppMethodBeat.i(200043);
        AppMethodBeat.o(200043);
    }

    public a(String str) {
        this.rgD = str;
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // com.tencent.mm.emoji.panel.a.h, android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ q<?> a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(200039);
        q<?> f2 = f(viewGroup, i2);
        AppMethodBeat.o(200039);
        return f2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // com.tencent.mm.emoji.panel.a.h, android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(q<?> qVar, int i2) {
        AppMethodBeat.i(200041);
        a(qVar, i2);
        AppMethodBeat.o(200041);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchAdapter$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.plugin.emoji.ui.a$a  reason: collision with other inner class name */
    public static final class C0961a {
        private C0961a() {
        }

        public /* synthetic */ C0961a(byte b2) {
            this();
        }
    }

    public final void cHr() {
        AppMethodBeat.i(200037);
        a(0, new ah(200));
        AppMethodBeat.o(200037);
    }

    @Override // com.tencent.mm.emoji.panel.a.h
    public final q<?> f(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(200038);
        p.h(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i2) {
            case 200:
                View inflate = from.inflate(R.layout.a27, viewGroup, false);
                p.g(inflate, "itemView");
                s sVar = new s(inflate, this.haK);
                AppMethodBeat.o(200038);
                return sVar;
            case 201:
                View inflate2 = from.inflate(R.layout.bt6, viewGroup, false);
                p.g(inflate2, "itemView");
                r rVar = new r(inflate2, this.haK);
                AppMethodBeat.o(200038);
                return rVar;
            case 202:
            default:
                View inflate3 = from.inflate(R.layout.bt7, viewGroup, false);
                p.g(inflate3, "itemView");
                z zVar = new z(inflate3, this.hbx, this.haK);
                AppMethodBeat.o(200038);
                return zVar;
            case 203:
                View inflate4 = from.inflate(R.layout.a2_, viewGroup, false);
                p.g(inflate4, "itemView");
                v vVar = new v(inflate4, this.haK, R.string.btf, true);
                AppMethodBeat.o(200038);
                return vVar;
            case 204:
                View inflate5 = from.inflate(R.layout.a29, viewGroup, false);
                p.g(inflate5, "itemView");
                u uVar = new u(inflate5);
                AppMethodBeat.o(200038);
                return uVar;
            case 205:
                View inflate6 = from.inflate(R.layout.a28, viewGroup, false);
                p.g(inflate6, "itemView");
                t tVar = new t(inflate6);
                AppMethodBeat.o(200038);
                return tVar;
            case 206:
                View inflate7 = from.inflate(R.layout.a2_, viewGroup, false);
                p.g(inflate7, "itemView");
                v vVar2 = new v(inflate7, null, R.string.bth, false);
                AppMethodBeat.o(200038);
                return vVar2;
        }
    }

    @Override // com.tencent.mm.emoji.panel.a.h
    public final void a(q<?> qVar, int i2) {
        AppMethodBeat.i(200040);
        p.h(qVar, "holder");
        if (getItemViewType(i2) == 202) {
            ((z) qVar).hbx = this.hbx;
        }
        if (i2 > this.rgC) {
            this.rgC = i2;
        }
        super.a(qVar, i2);
        AppMethodBeat.o(200040);
    }

    @Override // com.tencent.mm.emoji.panel.a.h, android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(200042);
        if (pm(i2) == null) {
            AppMethodBeat.o(200042);
            return 200;
        } else if (pm(i2) instanceof com.tencent.mm.emoji.b.b.h) {
            ac pm = pm(i2);
            if (pm == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
                AppMethodBeat.o(200042);
                throw tVar;
            }
            int i3 = ((com.tencent.mm.emoji.b.b.h) pm).gYc;
            AppMethodBeat.o(200042);
            return i3;
        } else {
            ac pm2 = pm(i2);
            if (pm2 == null) {
                p.hyc();
            }
            int i4 = pm2.type;
            AppMethodBeat.o(200042);
            return i4;
        }
    }
}
