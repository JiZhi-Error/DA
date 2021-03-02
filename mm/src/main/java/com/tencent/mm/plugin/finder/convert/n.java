package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0017\u001a\u00020\rH\u0002J\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fJ\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0016\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\fJ\u0016\u0010!\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\fJ@\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0016J \u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001eH\u0016J\u000e\u0010/\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u001aJ\u000e\u00100\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u001aJ\u0018\u00101\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u001a2\b\b\u0002\u00102\u001a\u00020(J\u000e\u00103\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u001aJ \u00104\u001a\u00020\r2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u001eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "feedId", "", "(J)V", "TAG", "", "getFeedId", "()J", "onBlackClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "unlikeToast", "Landroid/widget/Toast;", "cancelToast", "clickLike", "vh", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "likeInfo", "clickUnLike", "getLayoutId", "", "initLikeView", "contact", "initUnLikeView", "onBindViewHolder", "holder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setLikeGray", "setLikeRed", "setUnLikeBlack", "needToast", "setUnLikeGray", "showCenterToast", "context", "Landroid/content/Context;", "text", "resource", "plugin-finder_release"})
public final class n extends e<v> {
    final String TAG = "Finder.FinderFeedFriendLikeConvert";
    final long feedId;
    public kotlin.g.a.b<? super aul, x> tBx;
    public kotlin.g.a.b<? super aul, x> tBy;
    private Toast tBz;

    public n(long j2) {
        this.feedId = j2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, v vVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(242876);
        v vVar2 = vVar;
        p.h(hVar, "holder");
        p.h(vVar2, "item");
        ImageView imageView = (ImageView) hVar.Mn(R.id.cmm);
        TextView textView = (TextView) hVar.Mn(R.id.cmq);
        hVar.Mn(R.id.d40);
        View Mn = hVar.Mn(R.id.d41);
        z.f fVar = new z.f();
        fVar.SYG = (T) hVar.Mn(R.id.eb9);
        aul aul = vVar2.uOk;
        if (p.j(aul.dMW, com.tencent.mm.model.z.aTY())) {
            p.g(Mn, "unLikeLayout");
            Mn.setVisibility(8);
        } else {
            p.g(Mn, "unLikeLayout");
            Mn.setVisibility(0);
            Mn.setOnClickListener(new a(this, hVar, aul));
        }
        m mVar = m.uJa;
        d<o> dkb = m.dkb();
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(aul.iAR);
        p.g(imageView, "avatarIv");
        m mVar2 = m.uJa;
        dkb.a(aVar, imageView, m.a(m.a.WX_AVATAR));
        p.g(textView, "nicknameTv");
        Context context = hVar.getContext();
        y yVar = y.vXH;
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, y.hf(aul.dMW, aul.nickName)));
        p.h(hVar, "vh");
        p.h(aul, "contact");
        if (aul.likeFlag == 1) {
            p.h(hVar, "holder");
            ((WeImageView) hVar.Mn(R.id.cmo)).setImageResource(R.raw.icons_filled_like);
            Context context2 = hVar.getContext();
            p.g(context2, "holder.context");
            ((WeImageView) hVar.Mn(R.id.cmo)).setIconColor(context2.getResources().getColor(R.color.Red));
        } else {
            p.h(hVar, "holder");
            ((WeImageView) hVar.Mn(R.id.cmo)).setImageResource(R.raw.icons_outlined_like);
            Context context3 = hVar.getContext();
            p.g(context3, "holder.context");
            ((WeImageView) hVar.Mn(R.id.cmo)).setIconColor(context3.getResources().getColor(R.color.FG_2));
        }
        p.h(hVar, "vh");
        p.h(aul, "contact");
        if (aul.LFn == 1) {
            b(hVar, false);
        } else {
            e(hVar);
        }
        hVar.aus.setOnClickListener(new b(this, aul, hVar, vVar2));
        T t = fVar.SYG;
        p.g(t, "maskView");
        t.setVisibility(8);
        if (vVar2.uOb && !vVar2.uOc) {
            Log.i(this.TAG, "begin blink animation ".concat(String.valueOf(i2)));
            vVar2.uOc = true;
            T t2 = fVar.SYG;
            p.g(t2, "maskView");
            t2.setVisibility(0);
            T t3 = fVar.SYG;
            p.g(t3, "maskView");
            t3.setAlpha(1.0f);
            fVar.SYG.animate().alpha(0.0f).setDuration(1000).setListener(new c(this, fVar, i2)).start();
        }
        AppMethodBeat.o(242876);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.aco;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(242875);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(242875);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ n tBA;
        final /* synthetic */ aul tBB;

        a(n nVar, h hVar, aul aul) {
            this.tBA = nVar;
            this.qhp = hVar;
            this.tBB = aul;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242872);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            n nVar = this.tBA;
            h hVar = this.qhp;
            aul aul = this.tBB;
            p.h(hVar, "vh");
            p.h(aul, "likeInfo");
            if (aul.LFn == 1) {
                nVar.e(hVar);
            } else {
                nVar.b(hVar, true);
            }
            aul.LFn = (aul.LFn + 1) % 2;
            kotlin.g.a.b<? super aul, x> bVar2 = nVar.tBy;
            if (bVar2 != null) {
                bVar2.invoke(aul);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242872);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ n tBA;
        final /* synthetic */ aul tBB;
        final /* synthetic */ v tBC;

        b(n nVar, aul aul, h hVar, v vVar) {
            this.tBA = nVar;
            this.tBB = aul;
            this.qhp = hVar;
            this.tBC = vVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0039, code lost:
            if (com.tencent.mm.plugin.finder.utils.y.awn(r9.tBB.dMW) != false) goto L_0x003b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r10) {
            /*
            // Method dump skipped, instructions count: 178
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.n.b.onClick(android.view.View):void");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ n tBA;
        final /* synthetic */ z.f tBD;

        c(n nVar, z.f fVar, int i2) {
            this.tBA = nVar;
            this.tBD = fVar;
            this.gUj = i2;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(242874);
            T t = this.tBD.SYG;
            p.g(t, "maskView");
            t.setVisibility(8);
            Log.i(this.tBA.TAG, "maskView gone " + this.gUj);
            AppMethodBeat.o(242874);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public final void b(h hVar, boolean z) {
        AppMethodBeat.i(242877);
        p.h(hVar, "holder");
        ((WeImageView) hVar.Mn(R.id.d40)).setImageResource(R.raw.icons_outlined_eyes_off);
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        ((WeImageView) hVar.Mn(R.id.d40)).setIconColor(context.getResources().getColor(R.color.Red_100));
        if (z) {
            Context context2 = hVar.getContext();
            p.g(context2, "holder.context");
            String string = hVar.getContext().getString(R.string.dav);
            p.g(string, "holder.context.getString…finder_unlike_toast_text)");
            aA(context2, string);
        }
        AppMethodBeat.o(242877);
    }

    public final void e(h hVar) {
        AppMethodBeat.i(242878);
        p.h(hVar, "holder");
        ((WeImageView) hVar.Mn(R.id.d40)).setImageResource(R.raw.icons_outlined_eyes_on);
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        ((WeImageView) hVar.Mn(R.id.d40)).setIconColor(context.getResources().getColor(R.color.FG_1));
        cZB();
        AppMethodBeat.o(242878);
    }

    private final void aA(Context context, String str) {
        AppMethodBeat.i(242879);
        cZB();
        Toast makeText = Toast.makeText(context, "", 0);
        View inflate = View.inflate(context, R.layout.pd, null);
        WeImageView weImageView = (WeImageView) inflate.findViewById(R.id.irc);
        weImageView.setImageResource(R.raw.icons_filled_eyes_off);
        p.g(weImageView, LocaleUtil.ITALIAN);
        ViewGroup.LayoutParams layoutParams = weImageView.getLayoutParams();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.cl);
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        weImageView.setLayoutParams(layoutParams);
        weImageView.setIconColor(context.getResources().getColor(R.color.BW_100_Alpha_0_9));
        TextView textView = (TextView) inflate.findViewById(R.id.ird);
        p.g(textView, LocaleUtil.ITALIAN);
        textView.setText(str);
        textView.setTextSize(0, context.getResources().getDimension(R.dimen.bd));
        textView.setTextColor(context.getResources().getColor(R.color.BW_100_Alpha_0_9));
        makeText.setGravity(17, 0, 0);
        p.g(makeText, "toast");
        makeText.setView(inflate);
        makeText.show();
        this.tBz = makeText;
        AppMethodBeat.o(242879);
    }

    private final void cZB() {
        AppMethodBeat.i(242880);
        Toast toast = this.tBz;
        if (toast != null) {
            toast.cancel();
        }
        this.tBz = null;
        AppMethodBeat.o(242880);
    }
}
