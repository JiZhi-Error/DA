package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aa;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R&\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\b`\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "addMember", "", "userName", FirebaseAnalytics.b.INDEX, "", "checkIsExists", "", "getItemCount", "getMarginWidth", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "plugin-multitalk_release"})
public final class s extends RecyclerView.a<t> {
    private Context context;
    public ArrayList<String> zVh = new ArrayList<>();

    public s(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(178991);
        this.context = context2;
        AppMethodBeat.o(178991);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ t a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(178988);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.bde, viewGroup, false);
        p.g(inflate, "LayoutInflater.from(cont…avatar_cell,parent,false)");
        t tVar = new t(inflate);
        AppMethodBeat.o(178988);
        return tVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(t tVar, int i2) {
        int size;
        int i3;
        AppMethodBeat.i(178990);
        t tVar2 = tVar;
        p.h(tVar2, "holder");
        if ((i2 + 1) * e.b.JSG < this.zVh.size()) {
            size = (i2 + 1) * e.b.JSG;
        } else {
            size = this.zVh.size();
        }
        LinearLayout linearLayout = new LinearLayout(this.context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        if (i2 != 0) {
            layoutParams.topMargin = f.zSg;
        }
        if (i2 == getItemCount() - 1) {
            int size2 = this.zVh.size() % e.b.JSG;
            if (size2 == 0) {
                i3 = 0;
            } else {
                i3 = ((e.b.JSG - size2) * (f.zSo + f.zSg)) / 2;
            }
            layoutParams.leftMargin = i3;
        }
        linearLayout.setLayoutParams(layoutParams);
        for (int i4 = e.b.JSG * i2; i4 < size; i4++) {
            ImageView imageView = new ImageView(this.context);
            int i5 = f.zSo;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i5, i5);
            if (i4 != e.b.JSG * i2) {
                layoutParams2.leftMargin = f.zSg;
            }
            imageView.setLayoutParams(layoutParams2);
            linearLayout.addView(imageView);
            imageView.setContentDescription(com.tencent.mm.pluginsdk.ui.span.l.c(this.context, aa.getDisplayName(this.zVh.get(i4))));
            a.b.c(imageView, this.zVh.get(i4));
        }
        RelativeLayout relativeLayout = tVar2.zVi;
        if (relativeLayout != null) {
            relativeLayout.addView(linearLayout);
            AppMethodBeat.o(178990);
            return;
        }
        AppMethodBeat.o(178990);
    }

    public final void eO(String str, int i2) {
        AppMethodBeat.i(178986);
        p.h(str, "userName");
        if (this.zVh.size() <= i2) {
            this.zVh.add(str);
            AppMethodBeat.o(178986);
            return;
        }
        this.zVh.set(i2, str);
        AppMethodBeat.o(178986);
    }

    public final boolean aGC(String str) {
        T t;
        AppMethodBeat.i(178987);
        p.h(str, "userName");
        Iterator<T> it = this.zVh.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (p.j(t, str)) {
                break;
            }
        }
        if (t != null) {
            AppMethodBeat.o(178987);
            return true;
        }
        AppMethodBeat.o(178987);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(178989);
        int ceil = (int) Math.ceil(((double) this.zVh.size()) / ((double) e.b.JSG));
        AppMethodBeat.o(178989);
        return ceil;
    }
}
