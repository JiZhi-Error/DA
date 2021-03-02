package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "appId", "", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;)V", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetPhoneItems", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class q extends RecyclerView.a<a> {
    private final String appId;
    final Context context;
    public ArrayList<PhoneItem> lJn;

    public q(String str, Context context2, ArrayList<PhoneItem> arrayList) {
        p.h(str, "appId");
        p.h(context2, "context");
        p.h(arrayList, "phoneItems");
        AppMethodBeat.i(148068);
        this.appId = str;
        this.context = context2;
        this.lJn = arrayList;
        AppMethodBeat.o(148068);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(148067);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ej, viewGroup, false);
        p.g(inflate, "v");
        a aVar = new a(this, inflate);
        AppMethodBeat.o(148067);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        int i3;
        AppMethodBeat.i(148065);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        PhoneItem phoneItem = this.lJn.get(i2);
        p.g(phoneItem, "phoneItems[position]");
        PhoneItem phoneItem2 = phoneItem;
        if (phoneItem2 != null) {
            p.h(phoneItem2, "phoneItem");
            aVar2.nzh.setText(phoneItem2.nzt);
            if (phoneItem2.nzy) {
                aVar2.nzi.setText(aVar2.nzr.context.getString(R.string.a34));
            } else {
                aVar2.nzi.setText("");
            }
            ImageView imageView = aVar2.nzq;
            if (phoneItem2.nzz) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
        aVar2.aus.setOnClickListener(new b(this, phoneItem2));
        AppMethodBeat.o(148065);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ PhoneItem nzl;
        final /* synthetic */ q nzs;

        b(q qVar, PhoneItem phoneItem) {
            this.nzs = qVar;
            this.nzl = phoneItem;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(148064);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            q.a(this.nzs);
            this.nzl.nzz = true;
            this.nzs.notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(148064);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(148066);
        int size = this.lJn.size();
        AppMethodBeat.o(148066);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "checkIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"})
    public static final class a extends RecyclerView.v {
        final TextView nzh;
        final TextView nzi;
        final ImageView nzq;
        final q nzr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(q qVar, View view) {
            super(view);
            p.h(qVar, "adapter");
            p.h(view, "view");
            AppMethodBeat.i(148063);
            this.nzr = qVar;
            View findViewById = view.findViewById(R.id.gas);
            p.g(findViewById, "view.findViewById(R.id.p…anager_dialog_item_phone)");
            this.nzh = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.gat);
            p.g(findViewById2, "view.findViewById(R.id.p…nager_dialog_item_remark)");
            this.nzi = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.gaq);
            p.g(findViewById3, "view.findViewById(R.id.p…anager_dialog_item_check)");
            this.nzq = (ImageView) findViewById3;
            AppMethodBeat.o(148063);
        }
    }

    public static final /* synthetic */ void a(q qVar) {
        AppMethodBeat.i(168683);
        Iterator<PhoneItem> it = qVar.lJn.iterator();
        while (it.hasNext()) {
            it.next().nzz = false;
        }
        AppMethodBeat.o(168683);
    }
}
