package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashSet;
import java.util.Set;

public final class i extends b {
    private final int tlc;
    private Set<ImageView> tlr;
    private View.OnClickListener tls = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.d.i.AnonymousClass1 */

        public final void onClick(View view) {
            String z;
            String str;
            AppMethodBeat.i(107464);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!e.apn()) {
                u.g(i.this.tdg.context, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107464);
                return;
            }
            if (view.getTag() instanceof g) {
                g gVar = (g) view.getTag();
                anh anh = gVar.field_favProto.Lya;
                aml c2 = com.tencent.mm.plugin.fav.a.b.c(gVar);
                if (c2 == null) {
                    Log.w("MicroMsg.FavBaseListItem", "data item is null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107464);
                    return;
                } else if (com.tencent.mm.plugin.fav.a.b.f(c2)) {
                    Log.i("MicroMsg.FavBaseListItem", "same song, do release");
                    com.tencent.mm.ay.a.bea();
                    i.a(i.this, (ImageView) null);
                } else if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107464);
                    return;
                } else {
                    o oVar = new o(com.tencent.mm.plugin.fav.a.b.a(c2));
                    if (oVar.exists()) {
                        z = aa.z(oVar.her());
                    } else if (c2.dFN == null) {
                        z = "";
                    } else {
                        o oVar2 = new o(com.tencent.mm.plugin.fav.a.b.cUf() + com.tencent.mm.b.g.getMessageDigest(c2.dFN.getBytes()));
                        if (oVar2.exists()) {
                            str = aa.z(oVar2.her());
                        } else {
                            str = "";
                        }
                        z = str;
                    }
                    f a2 = com.tencent.mm.ay.i.a(6, null, c2.title, c2.desc, c2.Lvu, c2.Lvy, c2.Lvw, c2.dLl, com.tencent.mm.plugin.fav.a.b.cUl(), z, "", anh.appId);
                    a2.jfm = c2.songAlbumUrl;
                    a2.jfe = c2.songLyric;
                    a2.jfw = c2.dLl;
                    com.tencent.mm.ay.a.c(a2);
                    i.a(i.this, (ImageView) view);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107464);
        }
    };

    public static class a extends b.C1049b {
        TextView jBR;
        TextView jVO;
        ImageView nnL;
        TextView tln;
        ImageView tlu;
    }

    public i(com.tencent.mm.plugin.fav.ui.o oVar) {
        super(oVar);
        AppMethodBeat.i(107465);
        this.tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.ea);
        this.tlr = new HashSet();
        AppMethodBeat.o(107465);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        AppMethodBeat.i(107466);
        Context context = viewGroup.getContext();
        if (view == null) {
            a aVar2 = new a();
            view = a(View.inflate(context, R.layout.a7c, null), aVar2, gVar);
            aVar2.nnL = (ImageView) view.findViewById(R.id.cc2);
            aVar2.jVO = (TextView) view.findViewById(R.id.cdm);
            aVar2.jBR = (TextView) view.findViewById(R.id.cbl);
            aVar2.tlu = (ImageView) view.findViewById(R.id.cc7);
            aVar2.tln = (TextView) view.findViewById(R.id.cd0);
            aVar2.tln.setVisibility(8);
            aVar2.tlu.setOnClickListener(this.tls);
            aVar2.tlu.setVisibility(0);
            this.tlr.add(aVar2.tlu);
            aVar = aVar2;
        } else {
            try {
                aVar = (a) view.getTag();
            } catch (Exception e2) {
                Log.e("MicroMsg.FavBaseListItem", "invalid type, message:" + e2.getMessage());
                AppMethodBeat.o(107466);
            }
        }
        a(aVar, gVar);
        aml c2 = com.tencent.mm.plugin.fav.a.b.c(gVar);
        aVar.jVO.setText(c2.title);
        aVar.jBR.setText(c2.desc);
        aVar.jBR.setVisibility(0);
        this.tdg.a(aVar.nnL, c2, gVar, R.raw.app_attach_file_icon_music, this.tlc, this.tlc);
        aVar.tlu.setTag(gVar);
        if (com.tencent.mm.plugin.fav.a.b.f(c2)) {
            aVar.tlu.setImageResource(R.drawable.alq);
        } else {
            aVar.tlu.setImageResource(R.drawable.am5);
        }
        AppMethodBeat.o(107466);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107467);
        if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(view.getContext())) {
            AppMethodBeat.o(107467);
            return;
        }
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107467);
    }

    static /* synthetic */ void a(i iVar, ImageView imageView) {
        AppMethodBeat.i(107468);
        Log.i("MicroMsg.FavBaseListItem", "mask iv set size is %d", Integer.valueOf(iVar.tlr.size()));
        for (ImageView imageView2 : iVar.tlr) {
            if (imageView2 == imageView) {
                imageView2.setImageResource(R.drawable.alq);
            } else {
                imageView2.setImageResource(R.drawable.am5);
            }
        }
        AppMethodBeat.o(107468);
    }
}
