package com.tencent.mm.plugin.textstatus.b.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/like/LikeHistoryItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/like/LikeHistoryItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class a extends e<com.tencent.mm.plugin.textstatus.f.c.a> {
    public static final C1810a FXQ = new C1810a((byte) 0);

    static {
        AppMethodBeat.i(216105);
        AppMethodBeat.o(216105);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.textstatus.f.c.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(216104);
        com.tencent.mm.plugin.textstatus.f.c.a aVar2 = aVar;
        p.h(hVar, "holder");
        p.h(aVar2, "item");
        f fVar = f.FXJ;
        as aTn = f.fvO().aTn(aVar2.FZx.GaS);
        if (aTn == null || !aTn.arv()) {
            View Mn = hVar.Mn(R.id.iy6);
            p.g(Mn, "holder.getView<TextView>(R.id.tv_nickname)");
            ((TextView) Mn).setText(aVar2.FZx.nickname);
            q.bcV().loadImage(aVar2.FZx.qFV, (ImageView) hVar.Mn(R.id.e47));
            hVar.aus.setOnClickListener(null);
        } else {
            SpannableString e2 = com.tencent.mm.pluginsdk.ui.span.l.e(hVar.getContext(), (CharSequence) aTn.arJ(), com.tencent.mm.cb.a.aG(hVar.getContext(), R.dimen.is));
            p.g(e2, "MMSpanManager.spanForSmi… R.dimen.NormalTextSize))");
            CharSequence attachTextStatusSpanSync = ((c) g.ah(c.class)).attachTextStatusSpanSync(aTn.getUsername(), e2, a.b.CONVERSATION_LIST, (float) com.tencent.mm.cb.a.aG(hVar.getContext(), R.dimen.is));
            p.g(attachTextStatusSpanSync, "MMKernel.plugin(IPluginT…ormalTextSize).toFloat())");
            View Mn2 = hVar.Mn(R.id.iy6);
            p.g(Mn2, "holder.getView<TextView>(R.id.tv_nickname)");
            ((TextView) Mn2).setText(attachTextStatusSpanSync);
            a.b.c((ImageView) hVar.Mn(R.id.e47), aTn.getUsername());
            hVar.aus.setOnClickListener(new b(aTn, hVar));
        }
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Drawable drawable = context.getResources().getDrawable(R.raw.icon_filled_awesome);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        ((ImageView) hVar.Mn(R.id.dxf)).setImageDrawable(ar.e(drawable, context2.getResources().getColor(R.color.Red_90)));
        View Mn3 = hVar.Mn(R.id.iyv);
        p.g(Mn3, "holder.getView<TextView>(R.id.tv_time)");
        ((TextView) Mn3).setText(com.tencent.mm.pluginsdk.i.f.c(hVar.getContext(), ((long) aVar2.FZx.Gaz) * 1000, true));
        View Mn4 = hVar.Mn(R.id.fn8);
        p.g(Mn4, "holder.getView<TextView>(R.id.msg_tv)");
        ((TextView) Mn4).setVisibility(4);
        AppMethodBeat.o(216104);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/like/LikeHistoryItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    /* renamed from: com.tencent.mm.plugin.textstatus.b.b.a$a  reason: collision with other inner class name */
    public static final class C1810a {
        private C1810a() {
        }

        public /* synthetic */ C1810a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.c2j;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(216103);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(216103);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ as Byz;
        final /* synthetic */ h qhp;

        b(as asVar, h hVar) {
            this.Byz = asVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216102);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/convert/like/LikeHistoryItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("Contact_User", this.Byz.getUsername());
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 2);
            com.tencent.mm.br.c.b(this.qhp.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent, 213);
            ((c) g.ah(c.class)).report22210(this.Byz.getUsername(), 4);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/convert/like/LikeHistoryItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216102);
        }
    }
}
