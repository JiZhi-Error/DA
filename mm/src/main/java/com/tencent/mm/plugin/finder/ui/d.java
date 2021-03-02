package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001:B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000bJ\u0016\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000bJ\b\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0006H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010%\u001a\u00020\u0006H\u0016J$\u0010(\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u00162\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0016\u0010,\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010-\u001a\u00020\u000bJ\u0016\u0010.\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010-\u001a\u00020\u000bJ\u000e\u0010/\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 J\u000e\u00100\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 J\u0014\u00101\u001a\u00020\u000f2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b03J\u000e\u00104\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 J\u000e\u00105\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 J\u000e\u00106\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000bJ\u000e\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u000209R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "MENU_ID_NOLONGER_SEE", "", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "onBlackClickListener", "Lkotlin/Function1;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "clickLike", "vh", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "likeInfo", "clickUnLike", "getCount", "getItem", "position", "getItemId", "", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "initLikeView", "contact", "initUnLikeView", "setLikeGray", "setLikeRed", "setLikedContactList", "contacts", "", "setUnLikeBlack", "setUnLikeGray", "showMoreSheet", "uninterest", "likeEvent", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "LikedViewHolder", "plugin-finder_release"})
public final class d extends BaseAdapter {
    private String TAG = "Finder.FinderLikedAdapter";
    private Activity dKq;
    public ArrayList<aul> kgc;
    public kotlin.g.a.b<? super aul, x> tBx;
    public kotlin.g.a.b<? super aul, x> tBy;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(252394);
        aul Lo = Lo(i2);
        AppMethodBeat.o(252394);
        return Lo;
    }

    public d(Activity activity) {
        p.h(activity, "context");
        AppMethodBeat.i(252396);
        this.dKq = activity;
        this.kgc = new ArrayList<>();
        AppMethodBeat.o(252396);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(252388);
        if (view == null) {
            view = aa.jQ(this.dKq).inflate(R.layout.aco, viewGroup, false);
            a aVar = new a();
            p.g(view, "itemView");
            view.setTag(aVar);
        }
        Object tag = view.getTag();
        if (tag == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendRecommendAdapter.LikedViewHolder");
            AppMethodBeat.o(252388);
            throw tVar;
        }
        a aVar2 = (a) tag;
        View findViewById = view.findViewById(R.id.cmm);
        p.g(findViewById, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
        ImageView imageView = (ImageView) findViewById;
        p.h(imageView, "<set-?>");
        aVar2.gyr = imageView;
        View findViewById2 = view.findViewById(R.id.cmq);
        p.g(findViewById2, "itemView.findViewById(R.…finder_liked_username_tv)");
        TextView textView = (TextView) findViewById2;
        p.h(textView, "<set-?>");
        aVar2.pIN = textView;
        View findViewById3 = view.findViewById(R.id.cmo);
        p.g(findViewById3, "itemView.findViewById(R.id.finder_liked_iv)");
        WeImageView weImageView = (WeImageView) findViewById3;
        p.h(weImageView, "<set-?>");
        aVar2.tFv = weImageView;
        View findViewById4 = view.findViewById(R.id.cmn);
        p.g(findViewById4, "itemView.findViewById(R.…inder_liked_click_layout)");
        p.h(findViewById4, "<set-?>");
        aVar2.vKh = findViewById4;
        View findViewById5 = view.findViewById(R.id.d40);
        p.g(findViewById5, "itemView.findViewById(R.id.finder_unliked_iv)");
        WeImageView weImageView2 = (WeImageView) findViewById5;
        p.h(weImageView2, "<set-?>");
        aVar2.vKi = weImageView2;
        View findViewById6 = view.findViewById(R.id.d41);
        p.g(findViewById6, "itemView.findViewById(R.id.finder_unliked_layout)");
        p.h(findViewById6, "<set-?>");
        aVar2.vKj = findViewById6;
        aul Lo = Lo(i2);
        if (p.j(Lo.dMW, z.aTY())) {
            aVar2.dzx().setVisibility(8);
            aVar2.dzy().setVisibility(8);
        } else {
            aVar2.dzx().setVisibility(0);
            aVar2.dzx().setOnClickListener(new b(this, aVar2, Lo));
            View view2 = aVar2.vKj;
            if (view2 == null) {
                p.btv("unLikeLayout");
            }
            view2.setOnClickListener(new c(this, aVar2, Lo));
        }
        m mVar = m.uJa;
        com.tencent.mm.loader.d<o> dkb = m.dkb();
        com.tencent.mm.plugin.finder.loader.a aVar3 = new com.tencent.mm.plugin.finder.loader.a(Lo.iAR);
        ImageView avatarIv = aVar2.getAvatarIv();
        m mVar2 = m.uJa;
        dkb.a(aVar3, avatarIv, m.a(m.a.WX_AVATAR));
        TextView textView2 = aVar2.pIN;
        if (textView2 == null) {
            p.btv("nicknameTv");
        }
        textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.dKq, Lo.nickName));
        p.h(aVar2, "vh");
        p.h(Lo, "contact");
        if (Lo.likeFlag == 1) {
            a(aVar2);
        } else {
            b(aVar2);
        }
        p.h(aVar2, "vh");
        p.h(Lo, "contact");
        if (Lo.LFn == 1) {
            c(aVar2);
        } else {
            d(aVar2);
        }
        aVar2.getAvatarIv().setOnClickListener(new View$OnClickListenerC1295d(this, Lo));
        AppMethodBeat.o(252388);
        return view;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ aul tBB;
        final /* synthetic */ d vKk;
        final /* synthetic */ a vKl;

        b(d dVar, a aVar, aul aul) {
            this.vKk = dVar;
            this.vKl = aVar;
            this.tBB = aul;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252385);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            d dVar = this.vKk;
            a aVar = this.vKl;
            aul aul = this.tBB;
            p.h(aVar, "vh");
            p.h(aul, "likeInfo");
            if (aul.likeFlag == 1) {
                dVar.b(aVar);
            } else {
                dVar.a(aVar);
            }
            aul.likeFlag = (aul.likeFlag + 1) % 2;
            kotlin.g.a.b<? super aul, x> bVar2 = dVar.tBx;
            if (bVar2 != null) {
                bVar2.invoke(aul);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252385);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ aul tBB;
        final /* synthetic */ d vKk;
        final /* synthetic */ a vKl;

        c(d dVar, a aVar, aul aul) {
            this.vKk = dVar;
            this.vKl = aVar;
            this.tBB = aul;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252386);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            d dVar = this.vKk;
            a aVar = this.vKl;
            aul aul = this.tBB;
            p.h(aVar, "vh");
            p.h(aul, "likeInfo");
            if (aul.LFn == 1) {
                dVar.d(aVar);
            } else {
                dVar.c(aVar);
            }
            aul.LFn = (aul.LFn + 1) % 2;
            kotlin.g.a.b<? super aul, x> bVar2 = dVar.tBy;
            if (bVar2 != null) {
                bVar2.invoke(aul);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252386);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.finder.ui.d$d  reason: collision with other inner class name */
    static final class View$OnClickListenerC1295d implements View.OnClickListener {
        final /* synthetic */ aul tBB;
        final /* synthetic */ d vKk;

        View$OnClickListenerC1295d(d dVar, aul aul) {
            this.vKk = dVar;
            this.tBB = aul;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252387);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.d(this.tBB.dMW, this.vKk.dKq);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252387);
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(252389);
        p.h(aVar, "vh");
        aVar.dzw().setImageResource(R.raw.icons_filled_like);
        aVar.dzw().setIconColor(this.dKq.getResources().getColor(R.color.Red));
        AppMethodBeat.o(252389);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(252390);
        p.h(aVar, "vh");
        aVar.dzw().setImageResource(R.raw.icons_outlined_like);
        aVar.dzw().setIconColor(this.dKq.getResources().getColor(R.color.FG_2));
        AppMethodBeat.o(252390);
    }

    public final void c(a aVar) {
        AppMethodBeat.i(252391);
        p.h(aVar, "vh");
        aVar.dzy().setImageResource(R.raw.icons_filled_eyes_off);
        aVar.dzy().setIconColor(this.dKq.getResources().getColor(R.color.FG_0));
        AppMethodBeat.o(252391);
    }

    public final void d(a aVar) {
        AppMethodBeat.i(252392);
        p.h(aVar, "vh");
        aVar.dzy().setImageResource(R.raw.icons_outlined_eyes_on);
        aVar.dzy().setIconColor(this.dKq.getResources().getColor(R.color.FG_2));
        AppMethodBeat.o(252392);
    }

    private aul Lo(int i2) {
        AppMethodBeat.i(252393);
        aul aul = this.kgc.get(i2);
        p.g(aul, "dataList[position]");
        aul aul2 = aul;
        AppMethodBeat.o(252393);
        return aul2;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getCount() {
        AppMethodBeat.i(252395);
        int size = this.kgc.size();
        AppMethodBeat.o(252395);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "likeLayout", "Landroid/view/View;", "getLikeLayout", "()Landroid/view/View;", "setLikeLayout", "(Landroid/view/View;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "unLike", "getUnLike", "setUnLike", "unLikeLayout", "getUnLikeLayout", "setUnLikeLayout", "plugin-finder_release"})
    public static final class a {
        public ImageView gyr;
        public TextView pIN;
        public WeImageView tFv;
        public View vKh;
        public WeImageView vKi;
        public View vKj;

        public final ImageView getAvatarIv() {
            AppMethodBeat.i(252381);
            ImageView imageView = this.gyr;
            if (imageView == null) {
                p.btv("avatarIv");
            }
            AppMethodBeat.o(252381);
            return imageView;
        }

        public final WeImageView dzw() {
            AppMethodBeat.i(252382);
            WeImageView weImageView = this.tFv;
            if (weImageView == null) {
                p.btv("likeIv");
            }
            AppMethodBeat.o(252382);
            return weImageView;
        }

        public final View dzx() {
            AppMethodBeat.i(252383);
            View view = this.vKh;
            if (view == null) {
                p.btv("likeLayout");
            }
            AppMethodBeat.o(252383);
            return view;
        }

        public final WeImageView dzy() {
            AppMethodBeat.i(252384);
            WeImageView weImageView = this.vKi;
            if (weImageView == null) {
                p.btv("unLike");
            }
            AppMethodBeat.o(252384);
            return weImageView;
        }
    }
}
