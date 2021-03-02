package com.tencent.mm.plugin.finder.megavideo.bullet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.danmaku.b.e;
import com.tencent.mm.danmaku.render.h;
import com.tencent.mm.protocal.protobuf.cni;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmakuRender;", "Lcom/tencent/mm/danmaku/render/ViewDanmakuRender;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getItemViewType", "", "danmakuData", "", "onBindViewHolder", "", "itemViewType", "viewHolder", "Lcom/tencent/mm/danmaku/render/ViewDanmakuRender$ViewHolder;", "danmaku", "Lcom/tencent/mm/danmaku/data/ViewDanmaku;", "onCreateViewHolder", "TextViewHolder", "plugin-finder_release"})
public final class d extends h {
    private final Context context;

    public d(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(248281);
        this.context = context2;
        AppMethodBeat.o(248281);
    }

    @Override // com.tencent.mm.danmaku.render.h
    public final h.a atg() {
        AppMethodBeat.i(248279);
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.b6y, (ViewGroup) null);
        p.g(inflate, "LayoutInflater.from(cont…mega_bullet_layout, null)");
        a aVar = new a(this, inflate);
        AppMethodBeat.o(248279);
        return aVar;
    }

    @Override // com.tencent.mm.danmaku.render.h
    public final void a(h.a aVar, e eVar) {
        String str;
        AppMethodBeat.i(248280);
        p.h(aVar, "viewHolder");
        p.h(eVar, "danmaku");
        Object data = eVar.getData();
        if (data == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoBulletCommentInfo");
            AppMethodBeat.o(248280);
            throw tVar;
        }
        cni cni = (cni) data;
        TextView textView = ((a) aVar).uKi;
        String str2 = cni.content;
        Context context2 = textView.getContext();
        p.g(context2, "context");
        int color = context2.getResources().getColor(R.color.BW_100_Alpha_0_8);
        if ((cni.extFlag & 1) != 0) {
            StringBuilder sb = new StringBuilder();
            Context context3 = textView.getContext();
            p.g(context3, "context");
            str = sb.append(context3.getResources().getString(R.string.ezf)).append(cni.content).toString();
            Context context4 = textView.getContext();
            p.g(context4, "context");
            color = context4.getResources().getColor(R.color.a05);
        } else if ((cni.extFlag & 2) != 0) {
            StringBuilder sb2 = new StringBuilder();
            Context context5 = textView.getContext();
            p.g(context5, "context");
            str = sb2.append(context5.getResources().getString(R.string.ezb)).append(cni.content).toString();
            Context context6 = textView.getContext();
            p.g(context6, "context");
            color = context6.getResources().getColor(R.color.pm);
        } else {
            str = str2;
        }
        textView.setText(str);
        textView.setTextColor(color);
        AppMethodBeat.o(248280);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmakuRender$TextViewHolder;", "Lcom/tencent/mm/danmaku/render/ViewDanmakuRender$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmakuRender;Landroid/view/View;)V", "bulletTv", "Landroid/widget/TextView;", "getBulletTv", "()Landroid/widget/TextView;", "getItemView", "()Landroid/view/View;", "plugin-finder_release"})
    public final class a extends h.a {
        private final View aus;
        final TextView uKi;
        final /* synthetic */ d uKj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.uKj = dVar;
            AppMethodBeat.i(248278);
            this.aus = view;
            View findViewById = this.aus.findViewById(R.id.afl);
            p.g(findViewById, "itemView.findViewById(R.id.bullet_tv)");
            this.uKi = (TextView) findViewById;
            AppMethodBeat.o(248278);
        }
    }
}
