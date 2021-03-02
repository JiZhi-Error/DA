package com.tencent.mm.plugin.fav.ui.detail;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class a {
    public static void a(MMActivity mMActivity, g gVar) {
        String Is;
        AppMethodBeat.i(107255);
        if (14 != gVar.field_type || Util.isNullOrNil(gVar.field_favProto.title)) {
            anh anh = gVar.field_favProto.Lya;
            if (anh == null || Util.isNullOrNil(anh.LxA)) {
                Is = b.Is(gVar.field_fromUser);
            } else {
                Is = b.arL(anh.LxA);
                if (z.aTY().equals(anh.dRL)) {
                    String Is2 = b.Is(anh.toUser);
                    if (!Util.nullAs(Is2, "").equals(anh.toUser)) {
                        Is = Is + " - " + Is2;
                    }
                } else {
                    String Is3 = b.Is(anh.dRL);
                    if (!Util.nullAs(Is3, "").equals(anh.dRL)) {
                        Is = Is + " - " + Is3;
                    }
                }
            }
        } else {
            Is = gVar.field_favProto.title;
        }
        mMActivity.setMMSubTitle(String.format(mMActivity.getString(R.string.c9a), Is, DateFormat.format("yyyy/M/d", gVar.field_updateTime)));
        AppMethodBeat.o(107255);
    }
}
