package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.fav.PluginFav;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;

public class g implements a {
    @Override // com.tencent.mm.modelstat.a.a
    public final void callback(Bundle bundle) {
        int i2;
        AppMethodBeat.i(30939);
        int i3 = bundle.getInt("mm_rpt_fav_id", 0);
        int i4 = bundle.getInt("key_detail_fav_scene", 0);
        int i5 = bundle.getInt("key_detail_fav_sub_scene", 0);
        int i6 = bundle.getInt("key_detail_fav_index", 0);
        long j2 = bundle.getLong("key_activity_browse_time", -1);
        int i7 = bundle.getBoolean("mm_scroll_bottom") ? 1 : 0;
        int i8 = bundle.getInt("mm_send_friend_count", 0);
        int i9 = bundle.getInt("mm_share_sns_count", 0);
        if (bundle.getBoolean("mm_del_fav", false)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i10 = bundle.getInt("mm_edit_fav_count", 0);
        String string = bundle.getString("key_detail_fav_query", "");
        String string2 = bundle.getString("key_detail_fav_sessionid", "");
        String string3 = bundle.getString("key_detail_fav_tags", "");
        Log.d("MicroMsg.FavWebRptCallback", "FavWebRptCallback uiBrowseTime[%d] isScrollBottom[%b] sendToFriendCount[%d] shareSnsCount[%d]  isDelFav[%b] clickEditFavTagCount[%d] favId[%s]", Long.valueOf(j2), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i2), Integer.valueOf(i10), Integer.valueOf(i3));
        com.tencent.mm.plugin.fav.a.g DZ = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) i3);
        if (DZ == null) {
            Log.w("MicroMsg.FavWebRptCallback", "fav web rpt but favitem info is null favid[%d]", Integer.valueOf(i3));
            AppMethodBeat.o(30939);
            return;
        }
        long j3 = DZ.field_sourceCreateTime != 0 ? DZ.field_sourceCreateTime / 1000 : DZ.field_updateTime / 1000;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i4).append(",");
        stringBuffer.append(i6).append(",");
        stringBuffer.append(i3).append(",");
        stringBuffer.append(DZ.field_type).append(",");
        stringBuffer.append("0,");
        stringBuffer.append(DZ.field_sourceType).append(",");
        stringBuffer.append(j3).append(",");
        stringBuffer.append(j2).append(",");
        stringBuffer.append("0,");
        stringBuffer.append("0,");
        stringBuffer.append("0,");
        stringBuffer.append(i8).append(",");
        stringBuffer.append(i9).append(",");
        stringBuffer.append("0,");
        stringBuffer.append(i10).append(",");
        stringBuffer.append(i2).append(",");
        stringBuffer.append(i7).append(",");
        stringBuffer.append(i5).append(",");
        stringBuffer.append(string2).append(",");
        int HX = ((PluginFav) com.tencent.mm.kernel.g.ah(PluginFav.class)).getFavItemInfoStorage().HX(i3) + 1;
        stringBuffer.append(HX).append(",");
        stringBuffer.append(string).append(",");
        stringBuffer.append(string3);
        Log.d("MicroMsg.FavWebRptCallback", String.format("lxl, 15098, sid:%s, sourcepos:%s, query:%s, tag:%s", string2, Integer.valueOf(HX), string, string3));
        Log.v("MicroMsg.FavWebRptCallback", "FavWebRptCallback rpt id[%d] [%s]", 15098, stringBuffer.toString());
        e.INSTANCE.kvStat(15098, stringBuffer.toString());
        AppMethodBeat.o(30939);
    }
}
