package com.tencent.mm.plugin.game.luggage.e.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.bb;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.snackbar.a;
import org.json.JSONObject;

public final class g extends a {
    private a.b xxK = new a.b() {
        /* class com.tencent.mm.plugin.game.luggage.e.a.g.AnonymousClass2 */

        @Override // com.tencent.mm.ui.widget.snackbar.a.b
        public final void bDZ() {
            AppMethodBeat.i(83110);
            FavUrlTask favUrlTask = new FavUrlTask();
            favUrlTask.actionType = 2;
            AppBrandMainProcessService.a(favUrlTask);
            AppMethodBeat.o(83110);
        }
    };

    public g() {
        super(4);
        AppMethodBeat.i(83111);
        AppMethodBeat.o(83111);
    }

    @Override // com.tencent.mm.plugin.game.luggage.e.a.a
    public final void a(Context context, com.tencent.mm.plugin.webview.luggage.g gVar, coq coq) {
        AppMethodBeat.i(83112);
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", gVar.mParams.getLong("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", gVar.mParams.getString("sns_local_id"));
        bundle.putInt("news_svr_id", gVar.mParams.getInt("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", gVar.mParams.getString("news_svr_tweetid"));
        bundle.putInt("message_index", gVar.mParams.getInt("message_index", 0));
        String url = gVar.getUrl();
        String coX = gVar.coX();
        bundle.putString("rawUrl", coX);
        if (!Util.isNullOrNil(coX) && coX.endsWith("#rd")) {
            String substring = coX.substring(0, coX.length() - 3);
            if (!Util.isNullOrNil(url) && !url.startsWith(substring)) {
                bundle.putString("rawUrl", url);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!Util.isNullOrNil(url) && !url.startsWith(coX)) {
            bundle.putString("rawUrl", url);
            bundle.putLong("msg_id", Long.MIN_VALUE);
            bundle.putString("sns_local_id", "");
        }
        bundle.putString("preChatName", gVar.mParams.getString("preChatName"));
        bundle.putInt("preMsgIndex", gVar.mParams.getInt("preMsgIndex", 0));
        bundle.putString("prePublishId", gVar.mParams.getString("prePublishId"));
        bundle.putString("preUsername", gVar.mParams.getString("preUsername"));
        FavUrlTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 1;
        favUrlTask.dQL = bundle;
        AppBrandMainProcessService.b(favUrlTask);
        if (favUrlTask.ISL) {
            bb.afY(1);
            gVar.ctS.a(new d() {
                /* class com.tencent.mm.plugin.game.luggage.e.a.g.AnonymousClass1 */

                @Override // com.tencent.luggage.d.d
                public final String name() {
                    return "menu:share:appmessage";
                }

                @Override // com.tencent.luggage.d.d
                public final JSONObject Ld() {
                    return null;
                }
            });
            AppMethodBeat.o(83112);
            return;
        }
        e.a(favUrlTask.ret, (Activity) context, this.xxK);
        AppMethodBeat.o(83112);
    }
}
