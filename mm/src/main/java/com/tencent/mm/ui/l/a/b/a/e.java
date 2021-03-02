package com.tencent.mm.ui.l.a.b.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.l.a.g;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private static final MMHandler mKp = new MMHandler(Looper.getMainLooper());
    public boolean ONW;
    public RectF Qmx;
    public String Qmy;
    public String content;
    public String dJw;
    public long msgId;
    public long timestamp;
    public int type;

    static {
        AppMethodBeat.i(234449);
        AppMethodBeat.o(234449);
    }

    private e() {
    }

    public static e a(final long j2, final g gVar, boolean z) {
        boolean z2;
        String aTY;
        AppMethodBeat.i(234446);
        Log.printDebugStack("MicroMsg.MagicEmojiMsgMeta", "hy: start create msg meta: %d, %b", Long.valueOf(j2), Boolean.valueOf(z));
        if (j2 < 0) {
            Log.e("MicroMsg.MagicEmojiMsgMeta", "hy: not valid msgId");
            AppMethodBeat.o(234446);
            return null;
        }
        ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j2);
        Log.d("MicroMsg.MagicEmojiMsgMeta", "hy: start get msg info with msg type: %d", Integer.valueOf(Hb.getType()));
        e eVar = new e();
        eVar.msgId = j2;
        eVar.content = f.r(Hb);
        eVar.Qmy = Util.nullAsNil(b.anj(eVar.content));
        if (Hb.field_isSend != 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        eVar.ONW = z2;
        eVar.timestamp = Hb.field_createTime;
        if (Hb.field_isSend == 1) {
            aTY = Hb.field_talker;
        } else if (ab.Eq(Hb.field_talker)) {
            aTY = Hb.field_talker;
        } else {
            aTY = z.aTY();
        }
        eVar.dJw = aTY;
        eVar.type = Hb.getType();
        if (z) {
            eVar.Qmx = (RectF) new SyncTask<RectF>() {
                /* class com.tencent.mm.ui.l.a.b.a.e.AnonymousClass1 */
                final /* synthetic */ boolean QmA = true;

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.sdk.platformtools.SyncTask
                public final /* synthetic */ RectF run() {
                    c.a aVar;
                    AppMethodBeat.i(234445);
                    com.tencent.mm.ui.l.a.e eVar = gVar.QlN;
                    if (eVar == null) {
                        Log.w("MicroMsg.MagicEmojiMsgMeta", "hy: runtime released");
                        AppMethodBeat.o(234445);
                        return null;
                    } else if (eVar.QlV == null) {
                        Log.w("MicroMsg.MagicEmojiMsgMeta", "hy: page released");
                        AppMethodBeat.o(234445);
                        return null;
                    } else {
                        a gWG = eVar.gWG();
                        if (gWG == null) {
                            Log.w("MicroMsg.MagicEmojiMsgMeta", "hy: chatting frame released");
                            AppMethodBeat.o(234445);
                            return null;
                        }
                        View zh = ((k) gWG.bh(k.class)).zh(j2);
                        if (zh != null) {
                            aVar = (c.a) zh.getTag();
                        } else {
                            aVar = null;
                        }
                        if (aVar == null) {
                            Log.w("MicroMsg.MagicEmojiMsgMeta", "hy: msg item not found!");
                            AppMethodBeat.o(234445);
                            return null;
                        }
                        View mainContainerView = aVar.getMainContainerView();
                        if (mainContainerView == null) {
                            Log.i("MicroMsg.MagicEmojiMsgMeta", "hy: not having main view");
                            AppMethodBeat.o(234445);
                            return null;
                        }
                        int[] hl = com.tencent.mm.ui.l.b.a.hl(eVar.QlV.QlP);
                        int[] hl2 = com.tencent.mm.ui.l.b.a.hl(mainContainerView);
                        if (this.QmA) {
                            Point gWE = eVar.QlV.gWE();
                            if (!new Rect(hl2[0], hl2[1], mainContainerView.getWidth() + hl2[0], mainContainerView.getHeight() + hl2[1]).intersect(new Rect(hl[0], hl[1], hl[0] + gWE.x, gWE.y + hl[1]))) {
                                Log.w("MicroMsg.MagicEmojiMsgMeta", "hy: main view not in the window location");
                                AppMethodBeat.o(234445);
                                return null;
                            }
                        }
                        float f2 = (float) (hl2[0] - hl[0]);
                        float f3 = (float) (hl2[1] - hl[1]);
                        RectF rectF = new RectF(f2, f3, ((float) mainContainerView.getWidth()) + f2, ((float) mainContainerView.getHeight()) + f3);
                        AppMethodBeat.o(234445);
                        return rectF;
                    }
                }
            }.exec(mKp);
        }
        if (!z || eVar.Qmx != null) {
            AppMethodBeat.o(234446);
            return eVar;
        }
        AppMethodBeat.o(234446);
        return null;
    }

    public final Map<String, Object> gWU() {
        AppMethodBeat.i(234447);
        HashMap hashMap = new HashMap(5);
        hashMap.put("msgId", Long.valueOf(this.msgId));
        hashMap.put("isFrom", Boolean.valueOf(this.ONW));
        hashMap.put("msgType", Integer.valueOf(this.type));
        hashMap.put("content", this.content);
        hashMap.put("emojiKey", this.Qmy);
        hashMap.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(this.timestamp));
        if (this.Qmx != null) {
            HashMap hashMap2 = new HashMap(4);
            hashMap2.put("x", Float.valueOf(com.tencent.mm.ui.l.b.a.cx(this.Qmx.left)));
            hashMap2.put("y", Float.valueOf(com.tencent.mm.ui.l.b.a.cx(this.Qmx.top)));
            hashMap2.put("w", Float.valueOf(com.tencent.mm.ui.l.b.a.cx(this.Qmx.width())));
            hashMap2.put("h", Float.valueOf(com.tencent.mm.ui.l.b.a.cx(this.Qmx.height())));
            hashMap.put("frame", hashMap2);
        }
        AppMethodBeat.o(234447);
        return hashMap;
    }

    public final String toString() {
        AppMethodBeat.i(234448);
        String str = "MagicEmojiMsgMeta{msgId=" + this.msgId + ", frame=" + this.Qmx + ", isFrom=" + this.ONW + ", content='" + this.content + '\'' + ", emojiKey='" + this.Qmy + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", toUserName='" + this.dJw + '\'' + '}';
        AppMethodBeat.o(234448);
        return str;
    }
}
