package com.tencent.mm.ui.chatting.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class a extends com.tencent.mm.az.a {
    public String PEb;
    public long PEc = 0;
    public String PEd;
    public int mType;

    public a(Map<String, String> map, ca caVar) {
        super(map, caVar);
    }

    @Override // com.tencent.mm.az.a
    public final boolean aTA() {
        AppMethodBeat.i(36444);
        if (this.values == null) {
            Log.e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(36444);
            return false;
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.preContent")) {
            this.PEb = (String) this.values.get(".sysmsg.invokeMessage.preContent");
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.msgSource")) {
            this.PEd = (String) this.values.get(".sysmsg.invokeMessage.msgSource");
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
            this.PEc = Util.safeParseLong((String) this.values.get(".sysmsg.invokeMessage.timestamp"));
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.type")) {
            this.mType = Util.safeParseInt((String) this.values.get(".sysmsg.invokeMessage.type"));
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String str : this.values.keySet()) {
            if (!str.startsWith(".sysmsg.invokeMessage.text")) {
                if (str.startsWith(".sysmsg.invokeMessage.link.text") && !Util.isNullOrNil((String) this.values.get(str))) {
                    String str2 = (String) this.values.get(str);
                    sb.append(str2);
                    this.jfI.add(str2);
                    i2 = str2.length();
                }
                i2 = i2;
            } else if (sb.length() > 0) {
                sb.insert(0, (String) this.values.get(str));
            } else {
                sb.append((String) this.values.get(str));
            }
        }
        this.jfJ.addFirst(Integer.valueOf(sb.length() - i2));
        this.jfK.add(Integer.valueOf(sb.length()));
        this.jfG = sb.toString();
        if (cl.aWz() - this.PEc >= 300000 && !Util.isNullOrNil(this.PEb)) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.ui.chatting.j.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(36443);
                    a.this.dTX.setType(10002);
                    w.a(MMApplicationContext.getContext().getString(R.string.b24), "", a.this.dTX, "");
                    bg.aVF();
                    c.aSQ().a(a.this.dTX.field_msgId, a.this.dTX);
                    Log.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", Long.valueOf(a.this.dTX.field_msgId));
                    AppMethodBeat.o(36443);
                }
            }, "[checkExpired]");
        }
        AppMethodBeat.o(36444);
        return true;
    }
}
