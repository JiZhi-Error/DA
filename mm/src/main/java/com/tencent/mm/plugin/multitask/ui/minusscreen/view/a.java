package com.tencent.mm.plugin.multitask.ui.minusscreen.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.e;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.xwalk.core.Log;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016J@\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J \u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/AppBrandMinusScreenRoundCornerConvert;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/view/MinusScreenRoundCornerConvert;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "MAX_APPBRAND_NAME_COUNT", "", "getMAX_APPBRAND_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNickName", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "ui-multitask_release"})
public final class a extends d {
    private final int Aeq = 4;
    private final String TAG = "MicroMsg.AppBrandMinusScreenRoundCornerConvert";

    public a(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(236511);
        a(hVar, aVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(236511);
    }

    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(236509);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        AppMethodBeat.o(236509);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(h hVar, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar, int i2, int i3, boolean z, List<Object> list) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(236510);
        p.h(hVar, "holder");
        p.h(aVar, "item");
        Log.d(this.TAG, "onBindViewHolder");
        super.a(hVar, aVar, i2, i3, z, list);
        ImageView imageView = (ImageView) hVar.aus.findViewById(R.id.fno);
        TextView textView = (TextView) hVar.aus.findViewById(R.id.fnw);
        cru erh = aVar.Aen.erh();
        if (!Util.isNullOrNil(aVar.Aen.erh().tag)) {
            p.g(textView, "nickname");
            com.tencent.mm.plugin.multitask.ui.minusscreen.e.a aVar2 = com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.Aep;
            if (erh != null && (str3 = erh.nickname) != null) {
                str2 = str3;
            }
            textView.setText(com.tencent.mm.plugin.multitask.ui.minusscreen.e.a.a(textView, str2, this.Aeq));
        }
        imageView.setImageDrawable(null);
        cru erh2 = aVar.Aen.erh();
        if (erh2 == null || (str = erh2.MwR) == null) {
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) hVar.aus.findViewById(R.id.bld);
            p.g(roundCornerImageView, "defaultImage");
            roundCornerImageView.setVisibility(0);
            roundCornerImageView.setImageResource(R.raw.spannable_app_brand_link_logo);
            AppMethodBeat.o(236510);
            return;
        }
        e eVar = e.hXU;
        com.tencent.mm.loader.a aJs = e.aJs();
        p.g(imageView, "avatarImgView");
        aJs.a(str, imageView, this.Aer);
        AppMethodBeat.o(236510);
    }

    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        AppMethodBeat.i(236512);
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        super.a(recyclerView, wxRecyclerAdapter);
        AppMethodBeat.o(236512);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.view.d
    public final String a(Context context, com.tencent.mm.plugin.multitask.ui.minusscreen.b.a aVar) {
        AppMethodBeat.i(236513);
        p.h(context, "context");
        p.h(aVar, "item");
        String a2 = super.a(context, aVar);
        if (a2 != null) {
            if (a2.length() > 0) {
                AppMethodBeat.o(236513);
                return a2;
            }
        }
        String string = context.getResources().getString(R.string.f0i);
        AppMethodBeat.o(236513);
        return string;
    }
}
