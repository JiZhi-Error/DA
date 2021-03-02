package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.h;
import com.tencent.mm.ay.i;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.a.ol;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.i.a.aq;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashSet;
import java.util.Set;

public final class j extends b {
    private final int tlc;
    private Set<ImageView> tlr;
    private View.OnClickListener tls = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.d.j.AnonymousClass1 */

        public final void onClick(View view) {
            String z;
            css css;
            String str;
            AppMethodBeat.i(235379);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!e.apn()) {
                u.g(j.this.tdg.context, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235379);
                return;
            }
            if (view.getTag() instanceof g) {
                g gVar = (g) view.getTag();
                anh anh = gVar.field_favProto.Lya;
                aml c2 = com.tencent.mm.plugin.fav.a.b.c(gVar);
                if (c2 == null) {
                    Log.w("MicroMsg.FavBaseListItem", "data item is null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(235379);
                    return;
                } else if (com.tencent.mm.plugin.fav.a.b.f(c2)) {
                    Log.i("MicroMsg.FavBaseListItem", "same song, do release");
                    ol olVar = new ol();
                    olVar.enl = 2;
                    olVar.erW = 9;
                    aq.a(olVar);
                    com.tencent.mm.ay.a.bea();
                    j.a(j.this, (ImageView) null);
                } else if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(235379);
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
                    if (c2.Lwh != null) {
                        css = c2.Lwh.Lxs;
                    } else {
                        css = null;
                    }
                    f a2 = i.a(6, null, c2.title, c2.desc, c2.Lvu, c2.Lvy, c2.Lvw, c2.dLl, com.tencent.mm.plugin.fav.a.b.cUl(), z, "", anh.appId, h.a(c2.dLl, css));
                    a2.jfm = c2.songAlbumUrl;
                    a2.jfe = c2.songLyric;
                    a2.jfw = c2.dLl;
                    com.tencent.mm.ay.a.c(a2);
                    j.a(j.this, (ImageView) view);
                    ol olVar2 = new ol();
                    olVar2.enl = 1;
                    olVar2.erW = 9;
                    aq.a(olVar2);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235379);
        }
    };

    public static class a extends b.C1049b {
        TextView jBR;
        TextView jVO;
        ImageView nnL;
        TextView tln;
        ImageView tlu;
    }

    public j(com.tencent.mm.plugin.fav.ui.o oVar) {
        super(oVar);
        AppMethodBeat.i(235380);
        this.tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.ea);
        this.tlr = new HashSet();
        AppMethodBeat.o(235380);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        css css = null;
        AppMethodBeat.i(235381);
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
                AppMethodBeat.o(235381);
            }
        }
        a(aVar, gVar);
        aml c2 = com.tencent.mm.plugin.fav.a.b.c(gVar);
        if (c2 == null) {
            Log.w("MicroMsg.FavBaseListItem", "getView, data item is null");
            AppMethodBeat.o(235381);
        } else {
            String str = c2.title;
            String str2 = c2.desc;
            String str3 = "";
            if (c2.Lwh != null) {
                css = c2.Lwh.Lxs;
            }
            if (css != null) {
                if (!Util.isNullOrNil(css.Ktq)) {
                    str2 = css.Ktq + context.getString(R.string.f8v);
                    str = str + String.format("·%s", c2.desc);
                } else if (!Util.isNullOrNil(css.singerName)) {
                    str2 = css.singerName;
                }
                str3 = css.Ktp;
            }
            aVar.jVO.setText(str);
            if (!Util.isNullOrNil(str2)) {
                aVar.jBR.setText(str2);
                aVar.jBR.setVisibility(0);
            }
            if (c2.Lwh == null) {
                c2.a(new amm());
            }
            if (c2.Lwh.Lxs == null) {
                c2.Lwh.e(new css());
            }
            if (!Util.isNullOrNil(str3)) {
                c.a aVar3 = new c.a();
                String aIf = com.tencent.mm.plugin.music.h.b.aIf(str3);
                aVar3.fullPath = aIf;
                aVar3.jbf = true;
                aVar3.iaT = true;
                aVar3.jbd = true;
                aVar3.hZF = true;
                aVar3.jbx = (float) com.tencent.mm.cb.a.fromDPToPix(context, 2);
                q.bcV().a(str3, aVar.nnL, aVar3.bdv());
                c2.Lwh.Lxs.jfz = aIf;
            } else {
                this.tdg.a(aVar.nnL, c2, gVar, R.raw.app_attach_file_icon_music, this.tlc, this.tlc);
            }
            aVar.tlu.setTag(gVar);
            if (com.tencent.mm.plugin.fav.a.b.f(c2)) {
                aVar.tlu.setImageResource(R.drawable.alq);
            } else {
                aVar.tlu.setImageResource(R.drawable.am5);
            }
            AppMethodBeat.o(235381);
        }
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(235382);
        if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(view.getContext())) {
            AppMethodBeat.o(235382);
            return;
        }
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(235382);
    }

    static /* synthetic */ void a(j jVar, ImageView imageView) {
        AppMethodBeat.i(235383);
        Log.i("MicroMsg.FavBaseListItem", "mask iv set size is %d", Integer.valueOf(jVar.tlr.size()));
        for (ImageView imageView2 : jVar.tlr) {
            if (imageView2 == imageView) {
                imageView2.setImageResource(R.drawable.alq);
            } else {
                imageView2.setImageResource(R.drawable.am5);
            }
        }
        AppMethodBeat.o(235383);
    }
}
