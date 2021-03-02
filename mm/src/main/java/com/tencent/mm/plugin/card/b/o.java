package com.tencent.mm.plugin.card.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.up;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.card.compat.a.a;
import com.tencent.mm.plugin.card.d.g;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends IListener<up> {
    public o() {
        AppMethodBeat.i(161194);
        this.__eventId = up.class.getName().hashCode();
        AppMethodBeat.o(161194);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(up upVar) {
        AppMethodBeat.i(112713);
        up upVar2 = upVar;
        if (upVar2 instanceof up) {
            String str = upVar2.eaS.dPu;
            long j2 = upVar2.eaS.dFm;
            String str2 = upVar2.eaS.dPv;
            d ajZ = g.ajZ(str);
            if (ajZ == null) {
                Log.e("ShareCardEventListener", "item == null");
            } else if (TextUtils.isEmpty(str)) {
                Log.e("ShareCardEventListener", "cardAppMsg is empty");
            } else {
                k.b HD = k.b.HD(((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j2).field_content);
                if (HD != null) {
                    HD.ixT = g.a(ajZ);
                    HD.dPu = str;
                    HD.ixU = ajZ.gTG;
                    HD.ixV = ajZ.eaQ;
                    HD.ixW = ajZ.nHh;
                    byte[] bArr = null;
                    Bitmap a2 = u.a(new m(HD.thumburl));
                    if (a2 != null) {
                        bArr = BitmapUtil.Bitmap2Bytes(a2);
                    }
                    ((a) com.tencent.mm.kernel.g.af(a.class)).a(HD, HD.appId, ajZ.gTG, str2, bArr);
                    AppMethodBeat.o(112713);
                    return true;
                }
            }
        }
        AppMethodBeat.o(112713);
        return false;
    }
}
