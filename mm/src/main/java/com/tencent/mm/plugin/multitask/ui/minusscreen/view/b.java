package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.ui.minusscreen.d.a;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.xwalk.core.Log;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016J@\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0016J \u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/FileMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"})
public final class b extends d {
    private final String TAG = "MicroMsg.FileMinusScreenRoundCornerConvert";

    public b(a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(236516);
        a(hVar, aVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(236516);
    }

    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(236514);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        AppMethodBeat.o(236514);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(h hVar, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, int i2, int i3, boolean z, List<Object> list) {
        AppMethodBeat.i(236515);
        p.h(hVar, "holder");
        p.h(aVar, "item");
        Log.d(this.TAG, "onBindViewHolder");
        super.a(hVar, aVar, i2, i3, z, list);
        ImageView imageView = (ImageView) hVar.aus.findViewById(R.id.fno);
        imageView.setImageDrawable(null);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) hVar.aus.findViewById(R.id.bld);
        p.g(imageView, "avatarImgView");
        imageView.setVisibility(8);
        p.g(roundCornerImageView, "defaultImage");
        roundCornerImageView.setVisibility(0);
        com.tencent.mm.plugin.multitask.ui.minusscreen.e.a aVar2 = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Aep;
        roundCornerImageView.setImageResource(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.aGN(aVar.Aen.erh().gCr));
        AppMethodBeat.o(236515);
    }

    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        AppMethodBeat.i(236517);
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        super.a(recyclerView, wxRecyclerAdapter);
        AppMethodBeat.o(236517);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final String a(Context context, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar) {
        String str;
        AppMethodBeat.i(236518);
        p.h(context, "context");
        p.h(aVar, "item");
        String str2 = aVar.Aen.erh().gCr;
        if (str2 == null) {
            str = null;
        } else if (str2 == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(236518);
            throw tVar;
        } else {
            str = str2.toUpperCase();
            p.g(str, "(this as java.lang.String).toUpperCase()");
        }
        String I = p.I(str, context.getResources().getString(R.string.f0j));
        AppMethodBeat.o(236518);
        return I;
    }
}
