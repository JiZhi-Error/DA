package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.multitask.ui.minusscreen.d.a;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.xwalk.core.Log;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016J@\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0016J \u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u001bH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/VideoMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "useBottomGradient", "ui-multitask_release"})
public final class g extends d {
    private final String TAG = "MicroMsg.VideoMinusScreenRoundCornerConvert";

    public g(a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(236544);
        a(hVar, aVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(236544);
    }

    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(236542);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        AppMethodBeat.o(236542);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(h hVar, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, int i2, int i3, boolean z, List<Object> list) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(236543);
        p.h(hVar, "holder");
        p.h(aVar, "item");
        Log.d(this.TAG, "onBindViewHolder");
        super.a(hVar, aVar, i2, i3, z, list);
        cru erh = aVar.Aen.erh();
        TextView textView = (TextView) hVar.aus.findViewById(R.id.fnw);
        ImageView imageView = (ImageView) hVar.aus.findViewById(R.id.fno);
        ImageView imageView2 = (ImageView) hVar.aus.findViewById(R.id.fnp);
        m mVar = m.uJa;
        d<o> dka = m.dka();
        if (erh == null || (str = erh.MwR) == null) {
            str = "";
        }
        com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(str);
        p.g(imageView, "avatarImgView");
        m mVar2 = m.uJa;
        dka.a(aVar2, imageView, m.a(m.a.AVATAR));
        p.g(textView, "nickname");
        com.tencent.mm.plugin.multitask.ui.minusscreen.e.a aVar3 = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Aep;
        if (erh != null && (str3 = erh.nickname) != null) {
            str2 = str3;
        }
        textView.setText(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.a(textView, str2, this.tDx));
        if (erh != null) {
            com.tencent.mm.plugin.multitask.ui.minusscreen.e.a aVar4 = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Aep;
            p.g(imageView2, "avatarIconView");
            com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.a(imageView2, erh.MwS, erh.MwQ);
        }
        WeImageView weImageView = (WeImageView) hVar.Mn(R.id.fnr);
        weImageView.setImageResource(R.raw.icons_outlined_playbtn);
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        weImageView.setIconColor(context.getResources().getColor(R.color.am));
        if (!erh.MwT) {
            p.g(weImageView, "playIconImg");
            weImageView.setVisibility(0);
        } else {
            p.g(weImageView, "playIconImg");
            weImageView.setVisibility(8);
        }
        TextView textView2 = (TextView) hVar.Mn(R.id.fnv);
        int i4 = aVar.Aen.erh().Eso;
        textView2.setText(d.xt(i4 / 60) + ":" + d.xt(i4 % 60));
        p.g(textView2, "durationTv");
        textView2.setVisibility(0);
        AppMethodBeat.o(236543);
    }

    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        AppMethodBeat.i(236545);
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        super.a(recyclerView, wxRecyclerAdapter);
        AppMethodBeat.o(236545);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final boolean erF() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final String a(Context context, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar) {
        AppMethodBeat.i(236546);
        p.h(context, "context");
        p.h(aVar, "item");
        if (Util.isNullOrNil(aVar.Aen.erh().nickname)) {
            String string = context.getResources().getString(R.string.f0q);
            AppMethodBeat.o(236546);
            return string;
        }
        String str = aVar.Aen.erh().nickname;
        AppMethodBeat.o(236546);
        return str;
    }
}
