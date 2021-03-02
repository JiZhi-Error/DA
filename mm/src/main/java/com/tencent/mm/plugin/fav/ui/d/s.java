package com.tencent.mm.plugin.fav.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;

public final class s extends b {
    final int tlc;

    public static class a extends b.C1049b {
        TextView tlW;
        ImageView tlo;
    }

    public s(o oVar) {
        super(oVar);
        AppMethodBeat.i(107497);
        this.tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.eb);
        AppMethodBeat.o(107497);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        AppMethodBeat.i(107498);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.a7l, null), aVar, gVar);
            aVar.tlo = (ImageView) view.findViewById(R.id.cc_);
            aVar.tlW = (TextView) view.findViewById(R.id.cdv);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.tlW.setVisibility(0);
        LinkedList<aml> linkedList = gVar.field_favProto.ppH;
        if (linkedList.size() <= 0 || linkedList.getFirst().duration <= 0) {
            aVar.tlW.setText("");
        } else {
            aVar.tlW.setText(m.J(context, linkedList.getFirst().duration));
        }
        a(aVar, gVar);
        this.tdg.a(aVar.tlo, com.tencent.mm.plugin.fav.a.b.c(gVar), gVar, R.raw.app_attach_file_icon_video, this.tlc, this.tlc);
        AppMethodBeat.o(107498);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107499);
        a aVar = (a) view.getTag();
        Context context = view.getContext();
        aml c2 = com.tencent.mm.plugin.fav.a.b.c(aVar.tbr);
        View findViewById = view.findViewById(R.id.cc_);
        if (!(c2 == null || c2.Lwh == null || c2.Lwh.Lxi == null)) {
            int[] iArr = new int[2];
            if (findViewById != null) {
                int width = findViewById.getWidth();
                int height = findViewById.getHeight();
                findViewById.getLocationInWindow(iArr);
                amt amt = c2.Lwh.Lxi;
                amt.LxS = new amu();
                amt.LxS.left = iArr[0];
                amt.LxS.top = iArr[1];
                amt.LxS.width = width;
                amt.LxS.height = height;
            }
        }
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(context, aVar.tbr, and);
        AppMethodBeat.o(107499);
    }

    public static boolean a(Context context, amt amt, aml aml, boolean z) {
        AppMethodBeat.i(235384);
        Log.i("MicroMsg.FavVideoListItem", "handleMpVideoItem %s/%s", amt.dHc, amt.vid);
        com.tencent.mm.ag.y yVar = new com.tencent.mm.ag.y();
        yVar.dHc = amt.dHc;
        yVar.iAg = amt.iAg;
        yVar.KOe = amt.KOe;
        yVar.videoUrl = amt.videoUrl;
        yVar.KOf = amt.vid;
        yVar.title = aml.title;
        yVar.iAo = amt.iAo;
        yVar.width = amt.videoWidth;
        yVar.height = amt.videoHeight;
        yVar.videoDuration = amt.duration;
        yVar.url = aml.Lvu;
        Log.i("MicroMsg.FavVideoListItem", "[ImageGalleryUI] showImgGallery");
        Intent intent = new Intent();
        intent.putExtra("show_search_chat_content_result", false);
        intent.putExtra("img_gallery_msg_id", 0);
        intent.putExtra("img_gallery_talker", amt.dHc);
        intent.putExtra("img_gallery_chatroom_name", false);
        if (amt.LxS != null) {
            intent.putExtra("img_gallery_width", amt.LxS.width).putExtra("img_gallery_height", amt.LxS.height).putExtra("img_gallery_left", amt.LxS.left).putExtra("img_gallery_top", amt.LxS.top);
        }
        intent.putExtra("img_gallery_is_mp_video_without_msg", true);
        intent.putExtra("img_gallery_mp_video_click_from", 0);
        intent.putExtra("img_gallery_path", aml.dLl);
        intent.putExtra("show_enter_grid", false);
        intent.putExtra("KOpenArticleSceneFromScene", 24);
        intent.putExtra("img_preview_only", z);
        try {
            intent.putExtra("img_gallery_mp_share_video_info", yVar.toByteArray());
        } catch (IOException e2) {
            Log.e("MicroMsg.FavVideoListItem", "handleMpVideoItem toByteArray ex %s", e2.getMessage());
        }
        c.f(context, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
        ((Activity) context).overridePendingTransition(0, 0);
        AppMethodBeat.o(235384);
        return true;
    }
}
