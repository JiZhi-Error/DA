package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.multitask.ui.minusscreen.d.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.xwalk.core.Log;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016J@\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0016J \u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/WebMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"})
public final class h extends d {
    private final String TAG = "MicroMsg.WebMinusScreenRoundCornerConvert";

    public h(a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(236549);
        a(hVar, aVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(236549);
    }

    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(236547);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        AppMethodBeat.o(236547);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(com.tencent.mm.view.recyclerview.h hVar, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, int i2, int i3, boolean z, List<Object> list) {
        AppMethodBeat.i(236548);
        p.h(hVar, "holder");
        p.h(aVar, "item");
        Log.d(this.TAG, "onBindViewHolder");
        super.a(hVar, aVar, i2, i3, z, list);
        ImageView imageView = (ImageView) hVar.aus.findViewById(R.id.bld);
        ImageView imageView2 = (ImageView) hVar.aus.findViewById(R.id.fno);
        imageView2.setImageDrawable(null);
        p.g(imageView, "defaultImage");
        imageView.setVisibility(8);
        String str = aVar.Aen.field_showData.MwR;
        if (str != null) {
            if (!Util.isNullOrNil(str)) {
                e eVar = e.hXU;
                com.tencent.mm.loader.a aJs = e.aJs();
                p.g(imageView2, "avatarImgView");
                aJs.a(str, imageView2, this.Aer);
            }
            AppMethodBeat.o(236548);
            return;
        }
        imageView.setPadding(at.fromDPToPix(hVar.getContext(), 3), at.fromDPToPix(hVar.getContext(), 3), at.fromDPToPix(hVar.getContext(), 3), at.fromDPToPix(hVar.getContext(), 3));
        imageView.setImageDrawable(ar.m(hVar.getContext(), R.raw.icons_filled_link, ar.fj(-1, 50)));
        imageView.setVisibility(0);
        AppMethodBeat.o(236548);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final String a(Context context, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar) {
        AppMethodBeat.i(236550);
        p.h(context, "context");
        p.h(aVar, "item");
        String a2 = super.a(context, aVar);
        if (a2 != null) {
            if (a2.length() > 0) {
                AppMethodBeat.o(236550);
                return a2;
            }
        }
        String string = context.getResources().getString(R.string.f0r);
        AppMethodBeat.o(236550);
        return string;
    }

    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        AppMethodBeat.i(236551);
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        super.a(recyclerView, wxRecyclerAdapter);
        AppMethodBeat.o(236551);
    }
}
