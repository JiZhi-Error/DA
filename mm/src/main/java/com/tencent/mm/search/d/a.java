package com.tencent.mm.search.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.emoji.panel.a.aa;
import com.tencent.mm.emoji.panel.a.h;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.emoji.panel.a.w;
import com.tencent.mm.emoji.panel.a.x;
import com.tencent.mm.emoji.panel.a.y;
import com.tencent.mm.emoji.panel.a.z;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.tav.core.AssetExtension;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001c\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020\u0010J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004J\u0010\u0010%\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "()V", "gifAutoPlay", "", "maxBindViewPosition", "", "getMaxBindViewPosition", "()I", "setMaxBindViewPosition", "(I)V", "showHeadTip", "getGifAutoPlay", "getItemViewType", "position", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBottomData", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setData", "list", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "setEmptyData", "setGifAutoPlay", AssetExtension.SCENE_PLAY, "setHeaderData", "setLoadData", "setShowHeadTip", "show", "setWebSearchHeaderData", "Companion", "plugin-emojisdk_release"})
public final class a extends h {
    public static final C2057a NJC = new C2057a((byte) 0);
    public boolean NJB;
    public boolean hbx = true;
    public int rgC;

    static {
        AppMethodBeat.i(105869);
        AppMethodBeat.o(105869);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // com.tencent.mm.emoji.panel.a.h, android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ q<?> a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(105865);
        q<?> f2 = f(viewGroup, i2);
        AppMethodBeat.o(105865);
        return f2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // com.tencent.mm.emoji.panel.a.h, android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(q<?> qVar, int i2) {
        AppMethodBeat.i(105867);
        a(qVar, i2);
        AppMethodBeat.o(105867);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/search/ui/SimilarEmojiAdapter$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.search.d.a$a  reason: collision with other inner class name */
    public static final class C2057a {
        private C2057a() {
        }

        public /* synthetic */ C2057a(byte b2) {
            this();
        }
    }

    public final void setData(List<? extends dkt> list) {
        AppMethodBeat.i(105859);
        p.h(list, "list");
        List<? extends dkt> list2 = list;
        ArrayList arrayList = new ArrayList(j.a(list2, 10));
        for (T t : list2) {
            EmojiInfo emojiInfo = new EmojiInfo();
            b.a(t.MOJ, emojiInfo, t.MOK);
            if ((t.type & 1) == 0) {
                emojiInfo.Vlo = 1;
            }
            if ((t.type & 1) == 0 && (t.type & 16) == 0) {
                emojiInfo.Vln = 1;
            }
            emojiInfo.field_catalog = EmojiInfo.VkQ;
            emojiInfo.field_groupId = t.MOJ.ProductID;
            arrayList.add(new com.tencent.mm.emoji.b.b.h(emojiInfo, 102));
        }
        ad(arrayList);
        AppMethodBeat.o(105859);
    }

    public final void F(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105860);
        p.h(emojiInfo, "emojiInfo");
        a(0, new com.tencent.mm.emoji.b.b.h(emojiInfo, 100));
        AppMethodBeat.o(105860);
    }

    public static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(200090);
        aVar.G(new EmojiInfo());
        AppMethodBeat.o(200090);
    }

    public final void G(EmojiInfo emojiInfo) {
        AppMethodBeat.i(200089);
        p.h(emojiInfo, "emojiInfo");
        a(0, new com.tencent.mm.emoji.b.b.h(emojiInfo, 107));
        AppMethodBeat.o(200089);
    }

    public final void H(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105861);
        p.h(emojiInfo, "emojiInfo");
        a(getItemCount(), new ah(101));
        AppMethodBeat.o(105861);
    }

    public final void gxB() {
        AppMethodBeat.i(105862);
        a(getItemCount(), new ah(105));
        AppMethodBeat.o(105862);
    }

    public final void gxC() {
        AppMethodBeat.i(105863);
        a(getItemCount(), new ah(106));
        AppMethodBeat.o(105863);
    }

    @Override // com.tencent.mm.emoji.panel.a.h
    public final q<?> f(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(105864);
        p.h(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i2) {
            case 100:
                View inflate = from.inflate(R.layout.bt9, viewGroup, false);
                p.g(inflate, "itemView");
                y yVar = new y(inflate, this.NJB, this.haK);
                AppMethodBeat.o(105864);
                return yVar;
            case 101:
                View inflate2 = from.inflate(R.layout.bt6, viewGroup, false);
                p.g(inflate2, "itemView");
                w wVar = new w(inflate2, this.haK);
                AppMethodBeat.o(105864);
                return wVar;
            case 102:
            default:
                View inflate3 = from.inflate(R.layout.bt7, viewGroup, false);
                p.g(inflate3, "itemView");
                z zVar = new z(inflate3, this.hbx, this.haK);
                AppMethodBeat.o(105864);
                return zVar;
            case 103:
                View inflate4 = from.inflate(R.layout.bt8, viewGroup, false);
                p.g(inflate4, "itemView");
                z zVar2 = new z(inflate4, this.hbx, this.haK);
                AppMethodBeat.o(105864);
                return zVar2;
            case 104:
                View inflate5 = from.inflate(R.layout.bt4, viewGroup, false);
                p.g(inflate5, "itemView");
                w wVar2 = new w(inflate5, null);
                AppMethodBeat.o(105864);
                return wVar2;
            case 105:
                View inflate6 = from.inflate(R.layout.bt5, viewGroup, false);
                p.g(inflate6, "itemView");
                x xVar = new x(inflate6, R.id.ep4);
                AppMethodBeat.o(105864);
                return xVar;
            case 106:
                View inflate7 = from.inflate(R.layout.bt5, viewGroup, false);
                p.g(inflate7, "itemView");
                x xVar2 = new x(inflate7, R.id.h5p);
                AppMethodBeat.o(105864);
                return xVar2;
            case 107:
                View inflate8 = from.inflate(R.layout.bt_, viewGroup, false);
                p.g(inflate8, "itemView");
                aa aaVar = new aa(inflate8);
                AppMethodBeat.o(105864);
                return aaVar;
        }
    }

    @Override // com.tencent.mm.emoji.panel.a.h
    public final void a(q<?> qVar, int i2) {
        AppMethodBeat.i(105866);
        p.h(qVar, "holder");
        if (getItemViewType(i2) == 100) {
            ((y) qVar).hbt = this.NJB;
        }
        if (getItemViewType(i2) == 103) {
            ((z) qVar).hbx = this.hbx;
        }
        if (getItemViewType(i2) == 102) {
            ((z) qVar).hbx = this.hbx;
        }
        if (i2 > this.rgC) {
            this.rgC = i2;
        }
        super.a(qVar, i2);
        AppMethodBeat.o(105866);
    }

    @Override // com.tencent.mm.emoji.panel.a.h, android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(105868);
        if (pm(i2) == null) {
            AppMethodBeat.o(105868);
            return 100;
        } else if (pm(i2) instanceof com.tencent.mm.emoji.b.b.h) {
            ac pm = pm(i2);
            if (pm == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
                AppMethodBeat.o(105868);
                throw tVar;
            }
            int i3 = ((com.tencent.mm.emoji.b.b.h) pm).gYc;
            AppMethodBeat.o(105868);
            return i3;
        } else {
            ac pm2 = pm(i2);
            if (pm2 == null) {
                p.hyc();
            }
            int i4 = pm2.type;
            AppMethodBeat.o(105868);
            return i4;
        }
    }
}
