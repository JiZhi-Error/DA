package com.tencent.mm.plugin.flash.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;

public final class d implements a {
    @Override // com.tencent.mm.plugin.flash.e.a
    public final String getResultKey() {
        return "faceverify_ticket";
    }

    @Override // com.tencent.mm.plugin.flash.e.a
    public final void a(long j2, String str, String str2, String str3, String str4, int i2, float f2, int i3, i iVar) {
        AppMethodBeat.i(186703);
        Bundle bundle = new Bundle();
        bundle.putString("err_msg", "ok");
        bundle.putString("key_pic_cdn_id", str);
        bundle.putString("key_cdn_aes_key", str2);
        bundle.putString("k_bio_id", String.valueOf(j2));
        bundle.putInt("check_alive_type", i2);
        bundle.putBoolean("selfHandle", true);
        a aVar = new a();
        aVar.result = bundle;
        iVar.onSceneEnd(0, 0, "ok", aVar);
        AppMethodBeat.o(186703);
    }

    @Override // com.tencent.mm.plugin.flash.e.a
    public final int getType() {
        return 0;
    }

    public static class a extends q {
        public Bundle result;

        @Override // com.tencent.mm.ak.q
        public final int getType() {
            return 0;
        }

        @Override // com.tencent.mm.ak.q
        public final int doScene(g gVar, i iVar) {
            return 0;
        }
    }
}
