package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.tools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002KLB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006J\u001a\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020\u0006H\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0018H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u000e\u0010-\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0018H\u0016J\u0010\u00100\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0018H\u0016J\u0018\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0018H\u0016J\u0018\u00104\u001a\u00020$2\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0018H\u0016J\u0010\u00105\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0018H\u0016J\u0018\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0018H\u0016J\u0018\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0018H\u0016J\u0016\u0010<\u001a\u00020$2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010>J\u000e\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020\rJ\u000e\u0010A\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006J\u000e\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020\u0014J\u000e\u0010D\u001a\u00020$2\u0006\u0010C\u001a\u00020\u0016J\u000e\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020GJ\u0016\u0010H\u001a\u00020$2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010>J\u000e\u0010J\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR6\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001c¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/conv/ConversationHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "dataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDataMap", "()Ljava/util/HashMap;", "setDataMap", "(Ljava/util/HashMap;)V", "onClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "onLongClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "pageType", "", "getPageType", "()I", "setPageType", "(I)V", "scene", "getScene", "setScene", "topPlaceCount", "getTopPlaceCount", "setTopPlaceCount", "delConv", "", "conv", "formatTime", "", "context", "Landroid/content/Context;", "getItem", "position", "getItemCount", "insertOrUpdateConv", "notifyConvItemChanged", FirebaseAnalytics.b.INDEX, "notifyConvItemInserted", "notifyConvItemRangeInserted", "positionStart", "itemCount", "notifyConvItemRangeRemoved", "notifyConvItemRemoved", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshList", "data", "", "removeConversation", "sessionId", "setConvRead", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnItemLongClickListener", "setOrCancelTopPlace", "dataSource", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "submitList", "datas", "updateConv", "OnItemClickListener", "OnItemLongClickListener", "plugin-finder_release"})
public class d extends RecyclerView.a<a> {
    public int pageType = 1;
    public LinkedList<c> ppH = new LinkedList<>();
    public int scene = 2;
    public HashMap<String, c> tyt = new HashMap<>();
    private a tyu;
    private b tyv;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
    public interface a {
        void a(View view, c cVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
    public interface b {
        void a(View view, int i2, c cVar);
    }

    public d() {
        AppMethodBeat.i(242722);
        AppMethodBeat.o(242722);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(242708);
        p.h(viewGroup, "parent");
        View inflate = aa.jQ(viewGroup.getContext()).inflate(R.layout.a_7, viewGroup, false);
        p.g(inflate, "MMLayoutInflater.getInfl…tion_item, parent, false)");
        a aVar = new a(inflate);
        View view = aVar.aus;
        p.g(view, "holder.itemView");
        view.setOnLongClickListener(new c(this, aVar, view));
        view.setOnClickListener(new View$OnClickListenerC1098d(this, aVar, view));
        a aVar2 = aVar;
        AppMethodBeat.o(242708);
        return aVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public /* bridge */ /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(242710);
        a(aVar, i2);
        AppMethodBeat.o(242710);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class c implements View.OnLongClickListener {
        final /* synthetic */ View rsM;
        final /* synthetic */ d tyw;
        final /* synthetic */ a tyx;

        c(d dVar, a aVar, View view) {
            this.tyw = dVar;
            this.tyx = aVar;
            this.rsM = view;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(242704);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            c cVar = (c) this.tyx.hgv();
            b bVar2 = this.tyw.tyv;
            if (bVar2 != null) {
                View view2 = this.rsM;
                int lR = this.tyx.lR();
                p.g(cVar, "item");
                bVar2.a(view2, lR, cVar);
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(242704);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.finder.conv.d$d  reason: collision with other inner class name */
    static final class View$OnClickListenerC1098d implements View.OnClickListener {
        final /* synthetic */ View rsM;
        final /* synthetic */ d tyw;
        final /* synthetic */ a tyx;

        View$OnClickListenerC1098d(d dVar, a aVar, View view) {
            this.tyw = dVar;
            this.tyx = aVar;
            this.rsM = view;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242705);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            c cVar = (c) this.tyx.hgv();
            a aVar = this.tyw.tyu;
            if (aVar != null) {
                View view2 = this.rsM;
                this.tyx.lR();
                p.g(cVar, "item");
                aVar.a(view2, cVar);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242705);
        }
    }

    public void a(a aVar, int i2) {
        SpannableStringBuilder spannableStringBuilder;
        String c2;
        AppMethodBeat.i(242709);
        p.h(aVar, "holder");
        View view = aVar.aus;
        p.g(view, "holder.itemView");
        c Io = Io(i2);
        if (Io == null) {
            AppMethodBeat.o(242709);
            return;
        }
        aVar.et(Io);
        com.tencent.mm.ui.g.a.a.c((ImageView) view.findViewById(R.id.wo), Io.field_sessionId);
        TextView textView = (TextView) view.findViewById(R.id.bfx);
        p.g(textView, "itemView.conversationName");
        textView.setText(Io.tyr);
        TextView textView2 = (TextView) view.findViewById(R.id.bmt);
        p.g(textView2, "itemView.descTv");
        Context context = MMApplicationContext.getContext();
        String str = Io.field_editingMsg;
        if (str == null || n.aL(str)) {
            SpannableString c3 = com.tencent.mm.pluginsdk.ui.span.l.c(context, Io.field_digest);
            p.g(c3, "MMSpanManager.spanForSmiley(context, field_digest)");
            spannableStringBuilder = c3;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(context.getString(R.string.d13));
            p.g(context, "context");
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.a5e)), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder2.append((CharSequence) " ").append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.c(context, Io.field_editingMsg));
            spannableStringBuilder = spannableStringBuilder2;
        }
        textView2.setText(spannableStringBuilder);
        if (Io.cZw()) {
            view.setBackgroundResource(R.drawable.a_9);
        } else {
            view.setBackgroundResource(R.drawable.qa);
        }
        TextView textView3 = (TextView) view.findViewById(R.id.ims);
        p.g(textView3, "itemView.timeTv");
        Context context2 = view.getContext();
        p.g(context2, "itemView.context");
        if (Io.field_status == 1) {
            c2 = context2.getString(R.string.d8z);
        } else {
            c2 = com.tencent.mm.pluginsdk.i.f.c(context2, Io.field_updateTime, true);
        }
        textView3.setText(String.valueOf(c2));
        if (p.j(Io.field_sessionId, "findersayhisessionholder")) {
            TextView textView4 = (TextView) view.findViewById(R.id.io8);
            p.g(textView4, "itemView.tipNomalTv");
            textView4.setVisibility((Io.field_unReadCount <= 0 || Io.field_readStatus != 0) ? 8 : 0);
            TextView textView5 = (TextView) view.findViewById(R.id.io7);
            p.g(textView5, "itemView.tipCountTv");
            textView5.setVisibility(8);
            ((TextView) view.findViewById(R.id.io8)).setBackgroundResource(v.kH(view.getContext()));
            ((TextView) view.findViewById(R.id.io8)).setTextSize(0, ((float) com.tencent.mm.cb.a.aH(view.getContext(), R.dimen.ane)) * com.tencent.mm.cb.a.ji(view.getContext()));
            AppMethodBeat.o(242709);
            return;
        }
        TextView textView6 = (TextView) view.findViewById(R.id.io7);
        p.g(textView6, "itemView.tipCountTv");
        textView6.setVisibility((Io.field_unReadCount <= 0 || Io.field_readStatus != 0) ? 8 : 0);
        TextView textView7 = (TextView) view.findViewById(R.id.io7);
        p.g(textView7, "itemView.tipCountTv");
        textView7.setText(String.valueOf(Io.field_unReadCount));
        ((TextView) view.findViewById(R.id.io7)).setBackgroundResource(v.aQ(view.getContext(), Io.field_unReadCount));
        ((TextView) view.findViewById(R.id.io7)).setTextSize(0, ((float) com.tencent.mm.cb.a.aH(view.getContext(), R.dimen.ane)) * com.tencent.mm.cb.a.ji(view.getContext()));
        TextView textView8 = (TextView) view.findViewById(R.id.io8);
        p.g(textView8, "itemView.tipNomalTv");
        textView8.setVisibility(8);
        AppMethodBeat.o(242709);
    }

    public final void dR(List<c> list) {
        AppMethodBeat.i(242711);
        if (list != null) {
            com.tencent.mm.ac.d.h(new f(list, this));
            AppMethodBeat.o(242711);
            return;
        }
        AppMethodBeat.o(242711);
    }

    public void Il(int i2) {
        AppMethodBeat.i(242712);
        ci(i2);
        AppMethodBeat.o(242712);
    }

    public void Im(int i2) {
        AppMethodBeat.i(242713);
        cj(i2);
        AppMethodBeat.o(242713);
    }

    public void fY(int i2, int i3) {
        AppMethodBeat.i(242714);
        as(i2, i3);
        AppMethodBeat.o(242714);
    }

    public void In(int i2) {
        AppMethodBeat.i(242715);
        ck(i2);
        AppMethodBeat.o(242715);
    }

    public void fZ(int i2, int i3) {
        AppMethodBeat.i(242716);
        at(i2, i3);
        AppMethodBeat.o(242716);
    }

    public final void a(c cVar) {
        int i2;
        int i3;
        AppMethodBeat.i(242717);
        p.h(cVar, "conv");
        if (cVar.field_type == 1 && this.pageType == 1 && this.scene == 2) {
            c cVar2 = this.tyt.get("findersayhisessionholder");
            if (cVar2 == null) {
                c cVar3 = new c();
                cVar3.field_sessionId = "findersayhisessionholder";
                cVar3.field_talker = "findersayhisessionholder";
                cVar3.field_placedFlag = 1000;
                cVar3.field_type = 100;
                cVar3.field_scene = 2;
                cVar3.prepare();
                this.tyt.put("findersayhisessionholder", cVar3);
                cVar2 = cVar3;
            }
            p.g(cVar2, "dataMap[ContactStorageLo… = this\n                }");
            cVar2.field_unReadCount += cVar.field_unReadCount;
            cVar2.field_digest = cVar.field_digest;
            cVar2.field_updateTime = cVar.field_updateTime;
            cVar2.field_readStatus = cVar.field_readStatus;
            int indexOf = this.ppH.indexOf(cVar2);
            if (indexOf >= 0) {
                Il(indexOf);
                AppMethodBeat.o(242717);
                return;
            }
            this.ppH.add(0, cVar2);
            Im(indexOf);
            AppMethodBeat.o(242717);
            return;
        }
        int a2 = j.a((List) this.ppH, (Object) this.tyt.get(cVar.field_sessionId));
        if (a2 >= 0) {
            this.ppH.remove(a2);
            In(a2);
        }
        cVar.prepare();
        LinkedList<c> linkedList = this.ppH;
        ListIterator<c> listIterator = linkedList.listIterator(linkedList.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous().cZv()) {
                    i2 = listIterator.nextIndex();
                    break;
                }
            } else {
                i2 = -1;
                break;
            }
        }
        if (i2 < 0) {
            i3 = 0;
        } else {
            i3 = i2 + 1;
        }
        this.ppH.add(i3, cVar);
        Im(i3);
        this.tyt.remove(cVar.field_sessionId);
        String str = cVar.field_sessionId;
        p.g(str, "conv.field_sessionId");
        this.tyt.put(str, cVar);
        AppMethodBeat.o(242717);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(242718);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.tyu = aVar;
        AppMethodBeat.o(242718);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(242719);
        p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.tyv = bVar;
        AppMethodBeat.o(242719);
    }

    public c Io(int i2) {
        AppMethodBeat.i(242720);
        c cVar = this.ppH.get(i2);
        p.g(cVar, "dataList[position]");
        c cVar2 = cVar;
        AppMethodBeat.o(242720);
        return cVar2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public int getItemCount() {
        AppMethodBeat.i(242721);
        int size = this.ppH.size();
        AppMethodBeat.o(242721);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$refreshList$1$1"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d tyw;
        final /* synthetic */ List tyy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d dVar, List list) {
            super(0);
            this.tyw = dVar;
            this.tyy = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(242706);
            int size = this.tyw.ppH.size();
            this.tyw.ppH.clear();
            this.tyw.tyt.clear();
            this.tyw.fZ(0, size);
            this.tyw.dR(this.tyy);
            x xVar = x.SXb;
            AppMethodBeat.o(242706);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$submitList$1$1"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ List oaN;
        final /* synthetic */ d tyw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(List list, d dVar) {
            super(0);
            this.oaN = list;
            this.tyw = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(242707);
            int itemCount = this.tyw.getItemCount();
            for (c cVar : this.oaN) {
                String str = cVar.field_sessionId;
                p.g(str, "data.field_sessionId");
                this.tyw.tyt.put(str, cVar);
            }
            this.tyw.ppH.addAll(this.oaN);
            this.tyw.fY(itemCount, this.oaN.size());
            x xVar = x.SXb;
            AppMethodBeat.o(242707);
            return xVar;
        }
    }
}
