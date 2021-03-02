package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.Map;

public final class d extends a {
    public String dHx;
    public String jfM;
    public LinkedList<String> jfN = new LinkedList<>();
    public int jfP;
    public LinkedList<String> jfQ = new LinkedList<>();
    public LinkedList<String> jfR = new LinkedList<>();
    public String jfS = null;
    public String jfT = null;
    public String jfU = null;
    public String text = null;

    public d(Map<String, String> map, ca caVar) {
        super(map, caVar);
        AppMethodBeat.i(101785);
        AppMethodBeat.o(101785);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.az.a
    public final boolean aTA() {
        AppMethodBeat.i(101786);
        if (this.values == null) {
            Log.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(101786);
            return false;
        }
        Log.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (Util.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            Log.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", Util.nullAsNil(this.TYPE));
            AppMethodBeat.o(101786);
            return false;
        }
        this.jfM = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName");
        if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text")) {
            this.jfU = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text"));
        }
        if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername")) {
            this.jfS = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername"));
        }
        if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason")) {
            this.jfT = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason"));
        }
        if (this.values.containsKey(jfE)) {
            this.text = Util.nullAsNil((String) this.values.get(jfE));
        }
        if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket")) {
            this.dHx = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket");
        }
        if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize")) {
            this.jfP = Util.getInt((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize"), 0);
        }
        if (!this.dTX.gDO()) {
            this.jfJ.add(Integer.valueOf(this.text.length()));
            this.jfI.add(this.jfU);
            this.jfG = this.text + this.jfU;
            this.jfK.add(Integer.valueOf(this.jfG.length()));
        } else {
            this.jfI.clear();
            this.jfJ.clear();
            this.jfK.clear();
            this.jfG = this.text + " ";
            this.jfJ.add(Integer.valueOf(this.jfG.length()));
            this.jfI.add(MMApplicationContext.getContext().getString(R.string.dzk));
            this.jfG += MMApplicationContext.getContext().getString(R.string.dzk);
            this.jfK.add(Integer.valueOf(this.jfG.length()));
        }
        for (int i2 = 0; i2 < this.jfP; i2++) {
            if (i2 == 0) {
                this.jfN.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
                this.jfQ.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
                this.jfR.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
            } else {
                this.jfN.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i2 + ".username")));
                this.jfQ.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i2 + ".nickname")));
                this.jfR.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i2 + ".headimgurl")));
            }
        }
        AppMethodBeat.o(101786);
        return true;
    }
}
