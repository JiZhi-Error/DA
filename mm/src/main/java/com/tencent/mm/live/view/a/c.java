package com.tencent.mm.live.view.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.live.b.o;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J \u0010\u001e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0018H\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0018H\u0016J\u000e\u0010%\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0006J\u0014\u0010&\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060'R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006*"}, hxF = {"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "()V", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "onItemCLickListener", "Lkotlin/Function1;", "", "", "getOnItemCLickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemCLickListener", "(Lkotlin/jvm/functions/Function1;)V", "sysSpan", "com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1;", "appendComment", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "getItemCount", "", "onBindSysMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindTextMsg", "onBindViewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "updateComments", "", "LiveCommentItemHolder", "LiveHeightSpan", "plugin-logic_release"})
public final class c extends RecyclerView.a<a> {
    kotlin.g.a.b<? super String, x> hXA;
    public final ArrayList<a> hXy = new ArrayList<>();
    private final C0396c hXz = new C0396c();

    public c() {
        AppMethodBeat.i(208669);
        AppMethodBeat.o(208669);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(208666);
        p.h(viewGroup, "viewGroup");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.b0n, null);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.bottomMargin = at.fromDPToPix(viewGroup.getContext(), 12);
        p.g(inflate, "itemView");
        inflate.setLayoutParams(marginLayoutParams);
        a aVar = new a(inflate);
        AppMethodBeat.o(208666);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(208668);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        Context context = MMApplicationContext.getContext();
        int i3 = this.hXy.get(i2).msgType;
        o.d dVar = o.d.hGL;
        if (i3 == o.d.aFy()) {
            p.g(context, "context");
            a aVar3 = this.hXy.get(i2);
            p.g(aVar3, "commentList[position]");
            a aVar4 = aVar3;
            if (p.j(aVar4.hXp, z.aUa())) {
                a.b.c(aVar2.hXu, z.aTY());
            } else if (Util.isNullOrNil(aVar4.hXq)) {
                a.b.c(aVar2.hXu, aVar4.hXp);
            } else {
                q.bcV().loadImage(aVar4.hXq, aVar2.hXu);
            }
            aVar2.hXB.setVisibility(0);
            String str = aVar4.hXp;
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            String string = context.getString(R.string.efi, com.tencent.mm.live.b.x.GV(str));
            p.g(string, "context.getString(R.stri…ontent_tmpl, displayName)");
            m mVar = new m(com.tencent.mm.pluginsdk.ui.span.l.c(context, string + aVar4.hXr));
            mVar.a(this.hXz, string, 0);
            aVar2.hXC.setText(mVar);
        } else {
            o.d dVar2 = o.d.hGL;
            if (i3 == o.d.aFz()) {
                p.g(context, "context");
                a aVar5 = this.hXy.get(i2);
                p.g(aVar5, "commentList[position]");
                a aVar6 = aVar5;
                aVar2.hXB.setVisibility(8);
                String string2 = context.getString(R.string.efi, aVar6.hXp);
                p.g(string2, "context.getString(R.stri…, commentData.identityId)");
                m mVar2 = new m(com.tencent.mm.pluginsdk.ui.span.l.c(context, string2 + aVar6.hXr));
                mVar2.a(this.hXz, string2, 0);
                aVar2.hXC.setText(mVar2);
            }
        }
        aVar2.aus.setOnClickListener(new b(this, i2));
        AppMethodBeat.o(208668);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-logic_release"})
    /* renamed from: com.tencent.mm.live.view.a.c$c  reason: collision with other inner class name */
    public static final class C0396c extends CharacterStyle {
        C0396c() {
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(208663);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            int color = context.getResources().getColor(R.color.ua);
            if (textPaint != null) {
                textPaint.setColor(color);
            }
            if (textPaint != null) {
                textPaint.setUnderlineText(false);
                AppMethodBeat.o(208663);
                return;
            }
            AppMethodBeat.o(208663);
        }
    }

    public final void aj(List<a> list) {
        AppMethodBeat.i(208664);
        p.h(list, "commentList");
        this.hXy.clear();
        this.hXy.addAll(list);
        AppMethodBeat.o(208664);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(208665);
        p.h(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        int size = this.hXy.size();
        this.hXy.add(aVar);
        cj(size);
        AppMethodBeat.o(208665);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(208667);
        int size = this.hXy.size();
        AppMethodBeat.o(208667);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ c hXD;

        b(c cVar, int i2) {
            this.hXD = cVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208662);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/adapter/LiveCommentAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b<? super String, x> bVar2 = this.hXD.hXA;
            if (bVar2 != null) {
                bVar2.invoke(this.hXD.hXy.get(this.gUj).hXp);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/adapter/LiveCommentAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208662);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/live/view/adapter/LiveCommentAdapter$LiveCommentItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarGroup", "Landroid/view/ViewGroup;", "getAvatarGroup", "()Landroid/view/ViewGroup;", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
    public static final class a extends RecyclerView.v {
        final ViewGroup hXB;
        final TextView hXC;
        final ImageView hXu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(208661);
            View findViewById = view.findViewById(R.id.eg_);
            p.g(findViewById, "itemView.findViewById(R.…omment_item_avatar_group)");
            this.hXB = (ViewGroup) findViewById;
            View findViewById2 = view.findViewById(R.id.ega);
            p.g(findViewById2, "itemView.findViewById(R.…comment_item_avatar_icon)");
            this.hXu = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.egb);
            p.g(findViewById3, "itemView.findViewById(R.…_comment_item_content_tv)");
            this.hXC = (TextView) findViewById3;
            AppMethodBeat.o(208661);
        }
    }
}
