package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0002J.\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000eJ\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J&\u0010\u001e\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0017\u001a\u00020\u0010J\u0018\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000eH\u0016J&\u0010%\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0017\u001a\u00020\u0010R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarAdapterInContactUI;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "headerCount", "", "smallAvatarClickListener", "Landroid/view/View$OnClickListener;", "checkIsExists", "", "userName", "decreaseContact", "", "userNameList", "onClickListener", FirebaseAnalytics.b.INDEX, "getItemCount", "getItemViewType", "position", "getMarginStart", "getMarginStartFrom", "increaseContact", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateContactList", "Companion", "plugin-multitalk_release"})
public final class q extends RecyclerView.a<r> {
    public static final a zVg = new a((byte) 0);
    private Context context;
    public final ArrayList<String> uae = new ArrayList<>();
    public final int wqJ = 1;
    public View.OnClickListener zVf;

    static {
        AppMethodBeat.i(178984);
        AppMethodBeat.o(178984);
    }

    public q(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(178983);
        this.context = context2;
        AppMethodBeat.o(178983);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ r a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(178980);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.btc, viewGroup, false);
        p.g(inflate, "LayoutInflater.from(cont…atar_list, parent, false)");
        r rVar = new r(inflate);
        AppMethodBeat.o(178980);
        return rVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(r rVar, int i2) {
        int i3 = 0;
        AppMethodBeat.i(178981);
        r rVar2 = rVar;
        p.h(rVar2, "holder");
        if (getItemViewType(i2) == 1) {
            String str = this.uae.get(i2 - 1);
            p.g(str, "contactList[position - 1]");
            String str2 = str;
            rVar2.zRg.setVisibility(8);
            int i4 = f.zSs;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i4);
            layoutParams.addRule(1);
            layoutParams.topMargin = f.zSm;
            if (i2 - 1 != 0) {
                i3 = f.zSk;
            } else if (epe() >= 0) {
                i3 = epe();
            }
            layoutParams.setMarginStart(i3);
            View view = rVar2.aus;
            p.g(view, "holder.itemView");
            view.setLayoutParams(layoutParams);
            a.b.c(rVar2.gyr, str2);
            rVar2.gyr.setContentDescription(((b) g.af(b.class)).getDisplayName(str2));
            rVar2.gyr.setTag(str2);
            rVar2.gyr.setOnClickListener(this.zVf);
            AppMethodBeat.o(178981);
            return;
        }
        if (getItemViewType(i2) == 2 && this.uae.size() >= 5) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(f.zSs / 2, f.zSs);
            layoutParams2.topMargin = f.zSm;
            layoutParams2.setMarginStart(0);
            View view2 = rVar2.aus;
            p.g(view2, "holder.itemView");
            view2.setLayoutParams(layoutParams2);
            rVar2.gyr.setVisibility(8);
            rVar2.zRg.setVisibility(0);
        }
        AppMethodBeat.o(178981);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarAdapterInContactUI$Companion;", "", "()V", "VIEW_TYPE_FOOTER", "", "VIEW_TYPE_HEADER", "VIEW_TYPE_ITEM", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        switch (i2) {
            case 0:
                return 2;
            default:
                return 1;
        }
    }

    public final void b(ArrayList<String> arrayList, View.OnClickListener onClickListener) {
        AppMethodBeat.i(178977);
        p.h(arrayList, "userNameList");
        p.h(onClickListener, "onClickListener");
        this.uae.clear();
        this.uae.add(z.aTY());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = arrayList.get(i2);
            p.g(str, "userNameList[i]");
            if (!aGC(str) && (!p.j(arrayList.get(i2), z.aTY()))) {
                this.uae.add(arrayList.get(i2));
            }
        }
        this.zVf = onClickListener;
        notifyDataSetChanged();
        AppMethodBeat.o(178977);
    }

    public final boolean aGC(String str) {
        T t;
        AppMethodBeat.i(178978);
        Iterator<T> it = this.uae.iterator();
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
            AppMethodBeat.o(178978);
            return true;
        }
        AppMethodBeat.o(178978);
        return false;
    }

    private final int epe() {
        AppMethodBeat.i(178979);
        int size = ((ao.az(this.context).x - ((f.zSs * this.uae.size()) + (f.zSk * (this.uae.size() - 1)))) / 2) - f.zSs;
        AppMethodBeat.o(178979);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(178982);
        int size = this.uae.size() + this.wqJ;
        AppMethodBeat.o(178982);
        return size;
    }
}
