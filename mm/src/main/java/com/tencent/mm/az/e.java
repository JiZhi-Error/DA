package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.Map;

public final class e extends a {
    public String dTx;
    public LinkedList<String> jfV = new LinkedList<>();
    public String url;

    public e(Map<String, String> map, ca caVar) {
        super(map, caVar);
        AppMethodBeat.i(101787);
        AppMethodBeat.o(101787);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: java.util.LinkedList<java.lang.String> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: java.util.LinkedList<java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.az.a
    public final boolean aTA() {
        int i2;
        AppMethodBeat.i(101788);
        if (this.values == null) {
            Log.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(101788);
            return false;
        }
        Log.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (Util.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("delchatroommember")) {
            Log.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", Util.nullAsNil(this.TYPE));
            AppMethodBeat.o(101788);
            return false;
        }
        this.url = Util.nullAsNil((String) this.values.get(".sysmsg.delchatroommember.url"));
        this.dTx = Util.nullAsNil((String) this.values.get(".sysmsg.delchatroommember.link.qrcode"));
        this.jfV.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
        for (String str : this.values.keySet()) {
            if (str.startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
                this.jfV.add(this.values.get(str));
            }
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        for (String str2 : this.values.keySet()) {
            if (!str2.startsWith(jfE)) {
                if (str2.startsWith(".sysmsg.delchatroommember.link.text")) {
                    sb.append((String) this.values.get(str2));
                    this.jfI.add(this.values.get(str2));
                    i2 = ((String) this.values.get(str2)).length();
                } else {
                    i2 = i3;
                }
                i3 = i2;
            } else if (sb.length() > 0) {
                sb.insert(0, (String) this.values.get(str2));
            } else {
                sb.append((String) this.values.get(str2));
            }
        }
        this.jfJ.addFirst(Integer.valueOf(sb.length() - i3));
        this.jfK.add(Integer.valueOf(sb.length()));
        this.jfG = sb.toString();
        Log.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", this.url, this.dTx, Integer.valueOf(this.jfV.size()));
        AppMethodBeat.o(101788);
        return true;
    }
}
