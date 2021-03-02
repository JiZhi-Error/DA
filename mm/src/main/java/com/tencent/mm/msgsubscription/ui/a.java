package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003%&'B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018H\u0016J\u001e\u0010#\u001a\u00020\u00142\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgItemOpListener;", "(Landroid/content/Context;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgItemOpListener;)V", "value", "", "exampleTitle", "getExampleTitle", "()Ljava/lang/String;", "setExampleTitle", "(Ljava/lang/String;)V", "mList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "fillInfoIcon", "", "holder", "item", "position", "", "fillSubscribeCheckBox", "filling", "getItem", "getItemCount", "getList", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setList", "list", "Companion", "SubscribeMsgItemOpListener", "SubscribeMsgListItemViewHolder", "plugin-comm_release"})
public final class a extends RecyclerView.a<c> {
    public static final C0474a jBG = new C0474a((byte) 0);
    private final Context context;
    String jAi = "";
    ArrayList<SubscribeMsgTmpItem> jBE = new ArrayList<>();
    private final b jBF;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgItemOpListener;", "", "getCheckBoxState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onCheckBoxStatusChanged", "", "check", "onItemInfoClick", "view", "Landroid/view/View;", "plugin-comm_release"})
    public interface b {
        boolean a(SubscribeMsgTmpItem subscribeMsgTmpItem);

        void b(SubscribeMsgTmpItem subscribeMsgTmpItem, boolean z);
    }

    static {
        AppMethodBeat.i(149734);
        AppMethodBeat.o(149734);
    }

    public a(Context context2, b bVar) {
        p.h(context2, "context");
        p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AppMethodBeat.i(223417);
        this.context = context2;
        this.jBF = bVar;
        AppMethodBeat.o(223417);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ c a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(149730);
        p.h(viewGroup, "parent");
        View inflate = aa.jQ(this.context).inflate(R.layout.c14, viewGroup, false);
        p.g(inflate, "view");
        c cVar = new c(inflate);
        AppMethodBeat.o(149730);
        return cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(c cVar, int i2) {
        SubscribeMsgTmpItem subscribeMsgTmpItem;
        int i3;
        AppMethodBeat.i(149731);
        c cVar2 = cVar;
        p.h(cVar2, "holder");
        if (i2 < 0 || i2 >= this.jBE.size()) {
            subscribeMsgTmpItem = null;
        } else {
            subscribeMsgTmpItem = this.jBE.get(i2);
        }
        if (subscribeMsgTmpItem == null) {
            AppMethodBeat.o(149731);
            return;
        }
        Log.i("Mp.SubscribeMsgListAdapter", "alvinluo onBindViewHolder item: %s", subscribeMsgTmpItem.toString());
        View view = cVar2.jBI;
        p.g(view, "holder.topLine");
        if (i2 == 0) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        TextView textView = cVar2.hbb;
        p.g(textView, "holder.title");
        textView.setText(subscribeMsgTmpItem.title);
        CheckBox checkBox = cVar2.checkBox;
        p.g(checkBox, "holder.checkBox");
        checkBox.setChecked(this.jBF.a(subscribeMsgTmpItem));
        cVar2.aus.setOnClickListener(new e(this, cVar2, subscribeMsgTmpItem));
        cVar2.jBH.setOnClickListener(new d(this, subscribeMsgTmpItem));
        AppMethodBeat.o(149731);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    /* renamed from: com.tencent.mm.msgsubscription.ui.a$a  reason: collision with other inner class name */
    public static final class C0474a {
        private C0474a() {
        }

        public /* synthetic */ C0474a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ a jBJ;
        final /* synthetic */ SubscribeMsgTmpItem jBK;
        final /* synthetic */ c jBM;

        e(a aVar, c cVar, SubscribeMsgTmpItem subscribeMsgTmpItem) {
            this.jBJ = aVar;
            this.jBM = cVar;
            this.jBK = subscribeMsgTmpItem;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(149729);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillSubscribeCheckBox$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            CheckBox checkBox = this.jBM.checkBox;
            p.g(checkBox, "holder.checkBox");
            CheckBox checkBox2 = this.jBM.checkBox;
            p.g(checkBox2, "holder.checkBox");
            checkBox.setChecked(!checkBox2.isChecked());
            b bVar2 = this.jBJ.jBF;
            SubscribeMsgTmpItem subscribeMsgTmpItem = this.jBK;
            CheckBox checkBox3 = this.jBM.checkBox;
            p.g(checkBox3, "holder.checkBox");
            bVar2.b(subscribeMsgTmpItem, checkBox3.isChecked());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillSubscribeCheckBox$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(149729);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ a jBJ;
        final /* synthetic */ SubscribeMsgTmpItem jBK;

        d(a aVar, SubscribeMsgTmpItem subscribeMsgTmpItem) {
            this.jBJ = aVar;
            this.jBK = subscribeMsgTmpItem;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(149728);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillInfoIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.msgsubscription.util.b bVar2 = com.tencent.mm.msgsubscription.util.b.jDg;
            com.tencent.mm.ui.widget.a.d a2 = h.a(this.jBJ.context, this.jBJ.jAi, this.jBJ.context.getString(R.string.w1), com.tencent.mm.msgsubscription.util.b.a(this.jBJ.context, this.jBK.jyA, this.jBJ.context.getResources().getDimensionPixelSize(R.dimen.k5)), DialogInterface$OnClickListenerC0475a.jBL);
            a2.ajL(Color.parseColor("#07C160"));
            a2.setCancelable(false);
            a2.setCanceledOnTouchOutside(false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillInfoIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(149728);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.msgsubscription.ui.a$d$a  reason: collision with other inner class name */
        static final class DialogInterface$OnClickListenerC0475a implements DialogInterface.OnClickListener {
            public static final DialogInterface$OnClickListenerC0475a jBL = new DialogInterface$OnClickListenerC0475a();

            static {
                AppMethodBeat.i(149727);
                AppMethodBeat.o(149727);
            }

            DialogInterface$OnClickListenerC0475a() {
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(149726);
                dialogInterface.dismiss();
                AppMethodBeat.o(149726);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(149732);
        int size = this.jBE.size();
        AppMethodBeat.o(149732);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00130\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0004¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "infoIcon", "Landroid/widget/ImageView;", "getInfoIcon", "()Landroid/widget/ImageView;", "setInfoIcon", "(Landroid/widget/ImageView;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "topLine", "getTopLine", "()Landroid/view/View;", "setTopLine", "plugin-comm_release"})
    public static final class c extends RecyclerView.v {
        CheckBox checkBox;
        TextView hbb;
        ImageView jBH;
        View jBI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            p.h(view, "view");
            AppMethodBeat.i(149725);
            this.checkBox = (CheckBox) view.findViewById(R.id.b0m);
            this.hbb = (TextView) view.findViewById(R.id.ido);
            this.jBH = (ImageView) view.findViewById(R.id.idl);
            this.jBI = view.findViewById(R.id.it2);
            AppMethodBeat.o(149725);
        }
    }
}
