package com.tencent.mm.modelsns;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Map;

public final class h implements j {
    public jo jli = new jo();

    public h() {
        AppMethodBeat.i(192730);
        AppMethodBeat.o(192730);
    }

    @Override // com.tencent.mm.modelsns.j
    public final String bfF() {
        AppMethodBeat.i(192731);
        String b2 = b(this.jli);
        AppMethodBeat.o(192731);
        return b2;
    }

    public static String b(jo joVar) {
        AppMethodBeat.i(192732);
        StringBuilder sb = new StringBuilder();
        if (joVar != null) {
            try {
                sb.append("<mmbrandmpvideo>");
                sb.append("<mpUrl>").append(Util.escapeStringForXml(joVar.KOe)).append("</mpUrl>");
                sb.append("<thumbUrl>").append(Util.escapeStringForXml(joVar.iAo)).append("</thumbUrl>");
                sb.append("<videoVid>").append(joVar.KOf).append("</videoVid>");
                sb.append("<bizUsrName>").append(joVar.dHc).append("</bizUsrName>");
                sb.append("<bizNickName>").append(joVar.iAg).append("</bizNickName>");
                sb.append("<videoUrl>").append(Util.escapeStringForXml(joVar.videoUrl)).append("</videoUrl>");
                sb.append("<url>").append(Util.escapeStringForXml(joVar.url)).append("</url>");
                sb.append("<title>").append(Util.escapeStringForXml(joVar.title)).append("</title>");
                sb.append("<videoDuration>").append(joVar.videoDuration).append("</videoDuration>");
                sb.append("<thumbWidth>").append(joVar.width).append("</thumbWidth>");
                sb.append("<thumbHeight>").append(joVar.height).append("</thumbHeight>");
                sb.append("</mmbrandmpvideo>");
            } catch (Exception e2) {
                Log.e("MicroMsg.SnsMpVideoShareObject", "make content error %s", e2.getMessage());
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(192732);
        return sb2;
    }

    public static jo k(String str, Map<String, String> map) {
        AppMethodBeat.i(192733);
        jo joVar = new jo();
        try {
            String str2 = str + ".mmbrandmpvideo";
            if (!map.isEmpty() && map.containsKey(str2 + ".videoUrl")) {
                joVar.KOe = Util.nullAsNil(map.get(str2 + ".mpUrl"));
                joVar.videoUrl = Util.nullAsNil(map.get(str2 + ".videoUrl"));
                joVar.url = Util.nullAsNil(map.get(str2 + ".url"));
                joVar.title = Util.nullAsNil(map.get(str2 + ".title"));
                joVar.KOf = Util.nullAsNil(map.get(str2 + ".videoVid"));
                joVar.iAo = Util.nullAsNil(map.get(str2 + ".thumbUrl"));
                joVar.dHc = Util.nullAsNil(map.get(str2 + ".bizUsrName"));
                joVar.iAg = Util.nullAsNil(map.get(str2 + ".bizNickName"));
                joVar.videoDuration = (int) Util.safeParseFloat(map.get(str2 + ".videoDuration"));
                joVar.width = (int) Util.safeParseFloat(map.get(str2 + ".thumbWidth"));
                joVar.height = (int) Util.safeParseFloat(map.get(str2 + ".thumbHeight"));
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsMpVideoShareObject", "parse error %s", e2.getMessage());
        }
        AppMethodBeat.o(192733);
        return joVar;
    }

    public static boolean a(Context context, jo joVar, Rect rect) {
        AppMethodBeat.i(192734);
        Log.i("MicroMsg.SnsMpVideoShareObject", "onClick %s/%s", joVar.dHc, joVar.KOf);
        Intent intent = new Intent();
        intent.putExtra("show_search_chat_content_result", false);
        intent.putExtra("img_gallery_msg_id", 0);
        intent.putExtra("img_gallery_talker", joVar.dHc);
        intent.putExtra("img_gallery_chatroom_name", false);
        intent.putExtra("img_gallery_width", rect.right - rect.left).putExtra("img_gallery_height", rect.bottom - rect.top).putExtra("img_gallery_left", rect.left).putExtra("img_gallery_top", rect.top);
        intent.putExtra("img_gallery_is_mp_video_without_msg", true);
        intent.putExtra("img_gallery_mp_video_click_from", 1);
        intent.putExtra("img_gallery_path", MD5Util.getMD5String(joVar.videoUrl));
        intent.putExtra("show_enter_grid", false);
        intent.putExtra("KOpenArticleSceneFromScene", 2);
        try {
            intent.putExtra("img_gallery_mp_share_video_info", joVar.toByteArray());
        } catch (IOException e2) {
            Log.e("MicroMsg.SnsMpVideoShareObject", "onClick toByteArray ex %s", e2.getMessage());
        }
        c.f(context, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
        ((Activity) context).overridePendingTransition(0, 0);
        AppMethodBeat.o(192734);
        return true;
    }
}
