package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.Map;

public final class b extends a {
    public String dHx = null;
    public String jfM;
    public LinkedList<String> jfN = new LinkedList<>();
    public String jfO = null;
    public String text = null;

    public b(Map<String, String> map, ca caVar) {
        super(map, caVar);
        AppMethodBeat.i(101782);
        AppMethodBeat.o(101782);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: java.util.LinkedList<java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.az.a
    public final boolean aTA() {
        AppMethodBeat.i(101783);
        if (this.values == null) {
            Log.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(101783);
            return false;
        }
        Log.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (Util.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            Log.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", Util.nullAsNil(this.TYPE));
            AppMethodBeat.o(101783);
            return false;
        }
        this.jfM = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName");
        if (this.values.containsKey(jfE)) {
            this.text = Util.nullAsNil((String) this.values.get(jfE));
        }
        if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text")) {
            this.jfO = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text"));
        }
        if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket")) {
            this.dHx = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket"));
        }
        this.jfG = this.text;
        if (!this.dTX.gDO()) {
            this.jfI.add(this.jfO);
            this.jfJ.add(Integer.valueOf(this.jfG.length()));
            this.jfG += this.jfO;
            this.jfK.add(Integer.valueOf(this.jfG.length()));
        } else {
            this.jfG += " " + MMApplicationContext.getContext().getString(R.string.dzp);
        }
        for (String str : this.values.keySet()) {
            if (str.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
                this.jfN.add(this.values.get(str));
            }
        }
        AppMethodBeat.o(101783);
        return true;
    }
}
