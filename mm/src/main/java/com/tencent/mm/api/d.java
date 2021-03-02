package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.e;

public final class d {
    public static void a(Intent intent, drt drt, int i2) {
        AppMethodBeat.i(123930);
        ((n) g.af(n.class)).a(intent, drt, i2);
        AppMethodBeat.o(123930);
    }

    public static void a(Intent intent, drr drr) {
        AppMethodBeat.i(123931);
        ((n) g.af(n.class)).a(intent, drr, 15);
        AppMethodBeat.o(123931);
    }

    public static void a(Intent intent, dsk dsk, int i2) {
        AppMethodBeat.i(123932);
        intent.putExtra("Contact_User", dsk.UserName);
        intent.putExtra("Contact_Nick", dsk.oUJ);
        intent.putExtra("Contact_PyInitial", dsk.LoE);
        intent.putExtra("Contact_QuanPin", dsk.LoF);
        intent.putExtra("Contact_Sex", dsk.kdY);
        intent.putExtra("Contact_Scene", i2);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra(e.d.OyT, dsk.LRO);
        intent.putExtra("key_add_contact_openim_appid", dsk.jfi);
        intent.putExtra("key_add_contact_match_type", dsk.MUk);
        intent.putExtra("key_add_contact_custom_detail_visible", dsk.MUN.MBw);
        intent.putExtra("key_add_contact_custom_detail", dsk.MUN.xKd);
        Log.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", dsk.LRO);
        AppMethodBeat.o(123932);
    }
}
