package com.tencent.mm.plugin.textstatus.b.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
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
import com.tencent.mm.plugin.textstatus.f.f.d;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/like/LikeItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class b extends e<com.tencent.mm.plugin.textstatus.f.c.b> {
    public static final a FXR = new a((byte) 0);

    static {
        AppMethodBeat.i(216109);
        AppMethodBeat.o(216109);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.textstatus.f.c.b bVar, int i2, int i3, boolean z, List list) {
        boolean z2;
        String str;
        AppMethodBeat.i(216108);
        com.tencent.mm.plugin.textstatus.f.c.b bVar2 = bVar;
        p.h(hVar, "holder");
        p.h(bVar2, "item");
        f fVar = f.FXJ;
        as aTn = f.fvO().aTn(bVar2.FZy.field_HashUserName);
        if (aTn == null || !aTn.arv()) {
            View Mn = hVar.Mn(R.id.iy6);
            p.g(Mn, "holder.getView<TextView>(R.id.tv_nickname)");
            ((TextView) Mn).setText(bVar2.FZy.field_DisplayName);
            q.bcV().loadImage(bVar2.FZy.field_HeadImgUrl, (ImageView) hVar.Mn(R.id.e47));
            hVar.aus.setOnClickListener(null);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(com.tencent.mm.pluginsdk.ui.span.l.e(hVar.getContext(), (CharSequence) aTn.arJ(), com.tencent.mm.cb.a.aG(hVar.getContext(), R.dimen.is)));
            ImageSpan textStatusSpanSync = ((c) g.ah(c.class)).getTextStatusSpanSync(aTn.getUsername(), a.b.CONVERSATION_LIST, (float) com.tencent.mm.cb.a.aG(hVar.getContext(), R.dimen.is));
            if (textStatusSpanSync != null) {
                spannableStringBuilder.append((CharSequence) " ");
                spannableStringBuilder.setSpan(textStatusSpanSync, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
            }
            View Mn2 = hVar.Mn(R.id.iy6);
            p.g(Mn2, "holder.getView<TextView>(R.id.tv_nickname)");
            ((TextView) Mn2).setText(spannableStringBuilder);
            a.b.c((ImageView) hVar.Mn(R.id.e47), aTn.getUsername());
            hVar.aus.setOnClickListener(new View$OnClickListenerC1811b(aTn, hVar));
        }
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Drawable drawable = context.getResources().getDrawable(R.raw.icon_filled_awesome);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        ((ImageView) hVar.Mn(R.id.dxf)).setImageDrawable(ar.e(drawable, context2.getResources().getColor(R.color.Red_90)));
        View Mn3 = hVar.Mn(R.id.iyv);
        p.g(Mn3, "holder.getView<TextView>(R.id.tv_time)");
        ((TextView) Mn3).setText(com.tencent.mm.pluginsdk.i.f.c(hVar.getContext(), ((long) bVar2.FZy.field_CreateTime) * 1000, true));
        TextView textView = (TextView) hVar.Mn(R.id.fn8);
        String str2 = bVar2.FZy.field_Description;
        if (str2 == null || str2.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            str = bVar2.FZy.field_Description;
            p.g(str, "item.likeInfo.field_Description");
        } else {
            f fVar2 = f.FXJ;
            d fvM = f.fvM();
            String str3 = bVar2.FZy.field_TextStatusId;
            p.g(str3, "item.likeInfo.field_TextStatusId");
            com.tencent.mm.plugin.textstatus.f.f.a aTm = fvM.aTm(str3);
            if (aTm != null) {
                String str4 = aTm.field_Description;
                if (!(str4 == null || str4.length() == 0)) {
                    str = aTm.field_Description;
                    p.g(str, "field_Description");
                } else {
                    com.tencent.mm.plugin.textstatus.j.b bVar3 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
                    String str5 = aTm.field_IconID;
                    p.g(str5, "field_IconID");
                    str = com.tencent.mm.plugin.textstatus.j.b.aTp(str5);
                }
            } else {
                str = "";
            }
        }
        p.g(textView, "view");
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(hVar.getContext(), str, textView.getTextSize()));
        AppMethodBeat.o(216108);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.c2j;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(216107);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(216107);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.textstatus.b.b.b$b  reason: collision with other inner class name */
    static final class View$OnClickListenerC1811b implements View.OnClickListener {
        final /* synthetic */ as Byz;
        final /* synthetic */ h qhp;

        View$OnClickListenerC1811b(as asVar, h hVar) {
            this.Byz = asVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216106);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("Contact_User", this.Byz.getUsername());
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 2);
            com.tencent.mm.br.c.b(this.qhp.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent, 213);
            ((c) g.ah(c.class)).report22210(this.Byz.getUsername(), 3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/convert/like/LikeItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216106);
        }
    }
}
