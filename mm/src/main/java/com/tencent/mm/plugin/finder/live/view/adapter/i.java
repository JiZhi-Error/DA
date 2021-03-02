package com.tencent.mm.plugin.finder.live.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004$%&'B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0012\u001a\u00020\r2\n\u0010\u0013\u001a\u00060\u0014R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\r2\n\u0010\u0013\u001a\u00060\u0018R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016H\u0016J\u0016\u0010\"\u001a\u00020\r2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "onItemClikListener", "Lkotlin/Function0;", "", "getOnItemClikListener", "()Lkotlin/jvm/functions/Function0;", "setOnItemClikListener", "(Lkotlin/jvm/functions/Function0;)V", "bindBottomViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$BottomViewHolder;", "position", "", "bindWhiteListViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$WhiteListViewHolder;", "getItemCount", "getItemData", "pos", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateWhiteList", "list", "BottomViewHolder", "Companion", "FinderLiveAudienceListFileWrapper", "WhiteListViewHolder", "plugin-finder_release"})
public final class i extends RecyclerView.a<RecyclerView.v> {
    public static final b uCc = new b((byte) 0);
    public LinkedList<c> ppH = new LinkedList<>();
    public kotlin.g.a.a<x> uCb;

    static {
        AppMethodBeat.i(247867);
        AppMethodBeat.o(247867);
    }

    public i() {
        AppMethodBeat.i(247866);
        AppMethodBeat.o(247866);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$Companion;", "", "()V", "TAG", "", "TYPE_BOTTOM", "", "TYPE_NORMAL", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(247861);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 2:
                View inflate = View.inflate(viewGroup.getContext(), R.layout.ag4, null);
                p.g(inflate, "itemView");
                a aVar = new a(this, inflate);
                AppMethodBeat.o(247861);
                return aVar;
            default:
                View inflate2 = View.inflate(viewGroup.getContext(), R.layout.ag5, null);
                p.g(inflate2, "itemView");
                d dVar = new d(this, inflate2);
                AppMethodBeat.o(247861);
                return dVar;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(247862);
        int size = this.ppH.size();
        AppMethodBeat.o(247862);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(247863);
        int i3 = this.ppH.get(i2).type;
        AppMethodBeat.o(247863);
        return i3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$BottomViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public final class a extends RecyclerView.v {
        final /* synthetic */ i uCd;
        private TextView vr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(i iVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.uCd = iVar;
            AppMethodBeat.i(247857);
            this.vr = (TextView) view.findViewById(R.id.jnk);
            AppMethodBeat.o(247857);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$WhiteListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;Landroid/view/View;)V", "check", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheck", "()Landroid/widget/CheckBox;", "setCheck", "(Landroid/widget/CheckBox;)V", "detail", "Landroid/widget/TextView;", "getDetail", "()Landroid/widget/TextView;", "setDetail", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public final class d extends RecyclerView.v {
        final /* synthetic */ i uCd;
        CheckBox uCg;
        TextView uCh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(i iVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.uCd = iVar;
            AppMethodBeat.i(247859);
            this.uCg = (CheckBox) view.findViewById(R.id.jni);
            this.uCh = (TextView) view.findViewById(R.id.jnn);
            CheckBox checkBox = this.uCg;
            p.g(checkBox, "check");
            checkBox.setClickable(false);
            AppMethodBeat.o(247859);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        c cVar;
        String str;
        avh avh;
        avh avh2;
        String str2 = null;
        AppMethodBeat.i(247865);
        p.h(vVar, "holder");
        if (vVar instanceof d) {
            d dVar = (d) vVar;
            int size = this.ppH.size();
            if (i2 >= 0 && size > i2) {
                cVar = this.ppH.get(i2);
            } else {
                cVar = null;
            }
            CheckBox checkBox = dVar.uCg;
            p.g(checkBox, "holder.check");
            checkBox.setChecked(cVar != null && cVar.uCe);
            dVar.aus.setOnClickListener(new e(this, cVar, dVar));
            TextView textView = dVar.uCh;
            p.g(textView, "holder.detail");
            if (cVar == null || (avh2 = cVar.uCf) == null) {
                str = null;
            } else {
                str = avh2.title;
            }
            textView.setText(str);
            TextView textView2 = dVar.uCh;
            p.g(textView2, "holder.detail");
            if (!(cVar == null || (avh = cVar.uCf) == null)) {
                str2 = avh.KRd;
            }
            textView2.setTag(str2);
        }
        AppMethodBeat.o(247865);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ i uCd;
        final /* synthetic */ c uCi;
        final /* synthetic */ d uCj;

        e(i iVar, c cVar, d dVar) {
            this.uCd = iVar;
            this.uCi = cVar;
            this.uCj = dVar;
        }

        public final void onClick(View view) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(247860);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$bindWhiteListViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            c cVar = this.uCi;
            if (cVar != null) {
                c cVar2 = this.uCi;
                if (cVar2 == null || cVar2.uCe) {
                    z = false;
                } else {
                    z = true;
                }
                cVar.uCe = z;
            }
            CheckBox checkBox = this.uCj.uCg;
            p.g(checkBox, "holder.check");
            c cVar3 = this.uCi;
            if (cVar3 == null || !cVar3.uCe) {
                z2 = false;
            }
            checkBox.setChecked(z2);
            kotlin.g.a.a<x> aVar = this.uCd.uCb;
            if (aVar != null) {
                aVar.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$bindWhiteListViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(247860);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "", "choose", "", "audienceFile", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "type", "", "(ZLcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;I)V", "getAudienceFile", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getChoose", "()Z", "setChoose", "(Z)V", "getType", "()I", "setType", "(I)V", "plugin-finder_release"})
    public static final class c {
        int type;
        public boolean uCe;
        public final avh uCf;

        public /* synthetic */ c(boolean z, avh avh) {
            this(z, avh, 1);
        }

        public c(boolean z, avh avh, int i2) {
            p.h(avh, "audienceFile");
            AppMethodBeat.i(247858);
            this.uCe = z;
            this.uCf = avh;
            this.type = i2;
            AppMethodBeat.o(247858);
        }
    }
}
