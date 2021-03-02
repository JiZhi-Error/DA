package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0002J$\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0014\u0010!\u001a\u00020\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0#R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemLongClickListener", "getOnItemLongClickListener", "setOnItemLongClickListener", "getCount", "getItem", "position", "getItemId", "", "getShowBefore", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "contacts", "", "ContactViewHolder", "plugin-finder_release"})
public final class a extends BaseAdapter {
    private String TAG = "Finder.FansListAdapter";
    private Activity dKq;
    private ArrayList<aqr> kgc;
    m<? super View, ? super Integer, x> uAi;
    m<? super View, ? super Integer, x> uAj;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(167126);
        aqr IR = IR(i2);
        AppMethodBeat.o(167126);
        return IR;
    }

    public a(Activity activity) {
        p.h(activity, "context");
        AppMethodBeat.i(167129);
        this.dKq = activity;
        this.kgc = new ArrayList<>();
        AppMethodBeat.o(167129);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        String str;
        String str2;
        int i3;
        boolean z;
        AppMethodBeat.i(167124);
        if (view == null) {
            view = View.inflate(this.dKq, R.layout.a_m, null);
            C1293a aVar = new C1293a();
            p.g(view, "itemView");
            view.setTag(aVar);
        }
        Object tag = view.getTag();
        if (tag == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FansListAdapter.ContactViewHolder");
            AppMethodBeat.o(167124);
            throw tVar;
        }
        C1293a aVar2 = (C1293a) tag;
        View findViewById = view.findViewById(R.id.x1);
        p.g(findViewById, "itemView.findViewById(R.id.avatar_iv)");
        ImageView imageView = (ImageView) findViewById;
        p.h(imageView, "<set-?>");
        aVar2.gyr = imageView;
        View findViewById2 = view.findViewById(R.id.fzg);
        p.g(findViewById2, "itemView.findViewById(R.id.nickname_tv)");
        TextView textView = (TextView) findViewById2;
        p.h(textView, "<set-?>");
        aVar2.pIN = textView;
        View findViewById3 = view.findViewById(R.id.a2r);
        p.g(findViewById3, "itemView.findViewById(R.id.before_split_tv)");
        TextView textView2 = (TextView) findViewById3;
        p.h(textView2, "<set-?>");
        aVar2.vGX = textView2;
        aqr IR = IR(i2);
        FinderContact finderContact = IR.contact;
        if (finderContact == null || (str = finderContact.headUrl) == null) {
            str = "";
        }
        String nullAsNil = Util.nullAsNil(str);
        if (IR.displayFlag == 0) {
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<o> dkb = com.tencent.mm.plugin.finder.loader.m.dkb();
            com.tencent.mm.plugin.finder.loader.a aVar3 = new com.tencent.mm.plugin.finder.loader.a(nullAsNil);
            ImageView avatarIv = aVar2.getAvatarIv();
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dkb.a(aVar3, avatarIv, com.tencent.mm.plugin.finder.loader.m.a(m.a.WX_AVATAR));
        } else {
            com.tencent.mm.plugin.finder.loader.m mVar3 = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar4 = new com.tencent.mm.plugin.finder.loader.a(nullAsNil);
            ImageView avatarIv2 = aVar2.getAvatarIv();
            com.tencent.mm.plugin.finder.loader.m mVar4 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dka.a(aVar4, avatarIv2, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
        }
        TextView textView3 = aVar2.pIN;
        if (textView3 == null) {
            p.btv("nicknameTv");
        }
        Activity activity = this.dKq;
        y yVar = y.vXH;
        String str3 = IR.username;
        FinderContact finderContact2 = IR.contact;
        if (finderContact2 != null) {
            str2 = finderContact2.nickname;
        } else {
            str2 = null;
        }
        textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(activity, y.hf(str3, str2)));
        ArrayList<aqr> arrayList = this.kgc;
        ListIterator<aqr> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i3 = -1;
                break;
            }
            if (listIterator.previous().cSx == 1) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                i3 = listIterator.nextIndex();
                break;
            }
        }
        if (i3 != i2 || i2 == getCount() - 1) {
            aVar2.dyQ().setVisibility(8);
        } else {
            aVar2.dyQ().setVisibility(0);
        }
        View findViewById4 = view.findViewById(R.id.cb0);
        if (IR(i2).dJM) {
            findViewById4.setOnLongClickListener(null);
            findViewById4.setOnClickListener(new b(this, findViewById4, i2));
        } else {
            findViewById4.setOnLongClickListener(new c(this, findViewById4, i2));
            findViewById4.setOnClickListener(new d(this, findViewById4, i2));
        }
        AppMethodBeat.o(167124);
        return view;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ a vGY;
        final /* synthetic */ View vGZ;

        b(a aVar, View view, int i2) {
            this.vGY = aVar;
            this.vGZ = view;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261401);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.m<? super View, ? super Integer, x> mVar = this.vGY.uAj;
            if (mVar != null) {
                View view2 = this.vGZ;
                p.g(view2, "clickArea");
                mVar.invoke(view2, Integer.valueOf(this.gUj));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261401);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class c implements View.OnLongClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ a vGY;
        final /* synthetic */ View vGZ;

        c(a aVar, View view, int i2) {
            this.vGY = aVar;
            this.vGZ = view;
            this.gUj = i2;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(261402);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            kotlin.g.a.m<? super View, ? super Integer, x> mVar = this.vGY.uAi;
            if (mVar != null) {
                View view2 = this.vGZ;
                p.g(view2, "clickArea");
                mVar.invoke(view2, Integer.valueOf(this.gUj));
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(261402);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ a vGY;
        final /* synthetic */ View vGZ;

        d(a aVar, View view, int i2) {
            this.vGY = aVar;
            this.vGZ = view;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261403);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.m<? super View, ? super Integer, x> mVar = this.vGY.uAj;
            if (mVar != null) {
                View view2 = this.vGZ;
                p.g(view2, "clickArea");
                mVar.invoke(view2, Integer.valueOf(this.gUj));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FansListAdapter$getView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261403);
        }
    }

    public final aqr IR(int i2) {
        AppMethodBeat.i(167125);
        aqr aqr = this.kgc.get(i2);
        p.g(aqr, "dataList[position]");
        aqr aqr2 = aqr;
        AppMethodBeat.o(167125);
        return aqr2;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getCount() {
        AppMethodBeat.i(167127);
        int size = this.kgc.size();
        AppMethodBeat.o(167127);
        return size;
    }

    public final void ev(List<? extends aqr> list) {
        AppMethodBeat.i(167128);
        p.h(list, "contacts");
        this.kgc.clear();
        this.kgc.addAll(list);
        AppMethodBeat.o(167128);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FansListAdapter$ContactViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "beforeTip", "Landroid/widget/TextView;", "getBeforeTip", "()Landroid/widget/TextView;", "setBeforeTip", "(Landroid/widget/TextView;)V", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.ui.a$a  reason: collision with other inner class name */
    static final class C1293a {
        public ImageView gyr;
        public TextView pIN;
        public TextView vGX;

        public final ImageView getAvatarIv() {
            AppMethodBeat.i(178428);
            ImageView imageView = this.gyr;
            if (imageView == null) {
                p.btv("avatarIv");
            }
            AppMethodBeat.o(178428);
            return imageView;
        }

        public final TextView dyQ() {
            AppMethodBeat.i(167122);
            TextView textView = this.vGX;
            if (textView == null) {
                p.btv("beforeTip");
            }
            AppMethodBeat.o(167122);
            return textView;
        }
    }
}
