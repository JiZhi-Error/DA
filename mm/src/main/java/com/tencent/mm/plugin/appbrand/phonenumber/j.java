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
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+BH\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0002\u0010\u000fJ\b\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020!H\u0016J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020!H\u0016J\u001c\u0010)\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070*R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R5\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "onPhoneItemRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "phoneItem", "", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "getOnPhoneItemRemove", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemRemove", "(Lkotlin/jvm/functions/Function1;)V", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showDelete", "", "getShowDelete", "()Z", "setShowDelete", "(Z)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updatePhoneItems", "", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class j extends RecyclerView.a<a> {
    final Context context;
    ArrayList<PhoneItem> lJn;
    boolean nze;
    b<? super PhoneItem, x> nzf;

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(148058);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ej, viewGroup, false);
        p.g(inflate, "v");
        a aVar = new a(this, inflate);
        AppMethodBeat.o(148058);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(148056);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        PhoneItem phoneItem = this.lJn.get(i2);
        p.g(phoneItem, "phoneItems[position]");
        PhoneItem phoneItem2 = phoneItem;
        if (phoneItem2 != null) {
            p.h(phoneItem2, "phoneItem");
            aVar2.nzh.setText(phoneItem2.nzt);
            if (phoneItem2.nzy) {
                aVar2.nzi.setText(aVar2.nzj.context.getString(R.string.a34));
            } else {
                aVar2.nzi.setText("");
            }
            if (!aVar2.nzj.nze || phoneItem2.nzy) {
                aVar2.nzg.setVisibility(8);
            } else {
                aVar2.nzg.setVisibility(0);
                aVar2.nzg.setOnClickListener(new a.View$OnClickListenerC0784a(aVar2, phoneItem2));
                AppMethodBeat.o(148056);
                return;
            }
        }
        AppMethodBeat.o(148056);
    }

    public j(Context context2, ArrayList<PhoneItem> arrayList, b<? super PhoneItem, x> bVar) {
        p.h(context2, "context");
        p.h(arrayList, "phoneItems");
        p.h(bVar, "onPhoneItemRemove");
        AppMethodBeat.i(148059);
        this.context = context2;
        this.lJn = arrayList;
        this.nzf = bVar;
        AppMethodBeat.o(148059);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(148057);
        int size = this.lJn.size();
        AppMethodBeat.o(148057);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "deleteIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"})
    public static final class a extends RecyclerView.v {
        final ImageView nzg;
        final TextView nzh;
        final TextView nzi;
        final j nzj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j jVar, View view) {
            super(view);
            p.h(jVar, "adapter");
            p.h(view, "view");
            AppMethodBeat.i(148055);
            this.nzj = jVar;
            View findViewById = view.findViewById(R.id.gar);
            p.g(findViewById, "view.findViewById(R.id.p…nager_dialog_item_delete)");
            this.nzg = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.gas);
            p.g(findViewById2, "view.findViewById(R.id.p…anager_dialog_item_phone)");
            this.nzh = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.gat);
            p.g(findViewById3, "view.findViewById(R.id.p…nager_dialog_item_remark)");
            this.nzi = (TextView) findViewById3;
            AppMethodBeat.o(148055);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.j$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC0784a implements View.OnClickListener {
            final /* synthetic */ a nzk;
            final /* synthetic */ PhoneItem nzl;

            View$OnClickListenerC0784a(a aVar, PhoneItem phoneItem) {
                this.nzk = aVar;
                this.nzl = phoneItem;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(148054);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder$fillItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.nzk.nzj.nzf.invoke(this.nzl);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder$fillItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(148054);
            }
        }
    }
}
