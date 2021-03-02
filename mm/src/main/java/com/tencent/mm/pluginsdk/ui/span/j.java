package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.pluginsdk.ui.span.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

public class j {
    private int HQW = 500;
    private long HQX = 0;
    Context mContext;
    String mSessionId;

    public void a(View view, u uVar) {
        i iVar;
        String userName;
        String str;
        String str2;
        String str3;
        int i2;
        ca caVar;
        ca caVar2;
        ca caVar3;
        ca caVar4;
        ca caVar5;
        ca caVar6;
        int i3 = 0;
        AppMethodBeat.i(152273);
        if (System.currentTimeMillis() - this.HQX <= ((long) this.HQW)) {
            Log.e("MicroMsg.MMSpanClickListener", "process pass");
            AppMethodBeat.o(152273);
            return;
        }
        this.HQX = System.currentTimeMillis();
        if (uVar == null) {
            Log.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
            AppMethodBeat.o(152273);
            return;
        }
        Log.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", Integer.valueOf(uVar.type));
        if (this.mContext == null) {
            Log.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
            AppMethodBeat.o(152273);
            return;
        }
        if (l.Krd == null || l.Krd.size() <= 0) {
            iVar = null;
        } else {
            Log.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", Integer.valueOf(l.Krd.size()));
            iVar = l.Krd.getLast();
        }
        if (view == null || !(view.getTag() instanceof c) || (caVar6 = ((c) view.getTag()).dTX) == null) {
            userName = (view == null || !(view.getTag() instanceof a)) ? null : ((a) view.getTag()).getUserName();
        } else {
            userName = caVar6.field_talker;
            if (ab.Iw(userName)) {
                userName = bp.Ks(caVar6.field_content);
            }
        }
        uVar.username = userName;
        if (view == null || !(view.getTag() instanceof c) || (caVar5 = ((c) view.getTag()).dTX) == null || caVar5.field_isSend != 1) {
            str = null;
        } else {
            str = z.aTY();
        }
        uVar.tOw = str;
        if (view == null || !(view.getTag() instanceof c) || (caVar4 = ((c) view.getTag()).dTX) == null) {
            str2 = null;
        } else {
            str2 = caVar4.field_content;
        }
        uVar.tXF = str2;
        if (view == null || !(view.getTag() instanceof c) || (caVar3 = ((c) view.getTag()).dTX) == null) {
            str3 = null;
        } else {
            str3 = caVar3.field_talker;
        }
        uVar.chatroomName = str3;
        if (view == null || !(view.getTag() instanceof c) || (caVar2 = ((c) view.getTag()).dTX) == null || caVar2.getType() != 10000) {
            i2 = 0;
        } else {
            i2 = caVar2.fRg;
        }
        uVar.fRg = i2;
        if (view == null || !(view.getTag() instanceof c)) {
            caVar = null;
        } else {
            caVar = ((c) view.getTag()).dTX;
        }
        uVar.dTX = caVar;
        if (view != null && (view.getTag() instanceof c)) {
            i3 = 1;
        }
        if (i3 != 0) {
            uVar.fromScene = i3;
        }
        if (!TextUtils.isEmpty(this.mSessionId)) {
            uVar.mSessionId = this.mSessionId;
        }
        d.a.KqD.a(this.mContext, view, uVar, iVar);
        if (view != null && (view.getTag() instanceof c)) {
            ((b) g.af(b.class)).akR(uVar.username);
        }
        uVar.mSessionId = null;
        AppMethodBeat.o(152273);
    }
}
