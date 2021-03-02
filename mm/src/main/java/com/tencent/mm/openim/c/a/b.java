package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.Map;

public final class b extends a {
    public String dHx;
    public LinkedList<String> jHr = new LinkedList<>();
    public LinkedList<String> jHs = new LinkedList<>();
    public String jHt = null;
    public String jHu = null;
    public String jfM;
    public LinkedList<String> jfN = new LinkedList<>();
    public int jfP;
    public LinkedList<String> jfQ = new LinkedList<>();
    public LinkedList<String> jfR = new LinkedList<>();
    public String jfS = null;
    public String jfT = null;
    public String jfU = null;
    public String text = null;

    public b(Map<String, String> map, ca caVar) {
        super(map, caVar);
        AppMethodBeat.i(151262);
        AppMethodBeat.o(151262);
    }

    @Override // com.tencent.mm.az.a
    public final boolean aTA() {
        AppMethodBeat.i(151263);
        if (this.values == null) {
            Log.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(151263);
            return false;
        }
        Log.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (Util.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplication")) {
            Log.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type err :%s", Util.nullAsNil(this.TYPE));
            AppMethodBeat.o(151263);
            return false;
        }
        this.jfM = (String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.RoomName");
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text")) {
            this.jfU = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text"));
        }
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username")) {
            this.jfS = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username"));
        }
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid")) {
            this.jHt = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid"));
        }
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid")) {
            this.jHu = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid"));
        }
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason")) {
            this.jfT = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason"));
        }
        if (this.values.containsKey(jfE)) {
            this.text = Util.nullAsNil((String) this.values.get(jfE));
        }
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket")) {
            this.dHx = (String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket");
        }
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize")) {
            this.jfP = Util.getInt((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize"), 0);
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
                this.jfN.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.username")));
                this.jfQ.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.nickname")));
                this.jHr.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.descid")));
                this.jHs.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.appid")));
                this.jfR.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.headimgurl")));
            } else {
                this.jfN.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i2 + ".username")));
                this.jfQ.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i2 + ".nickname")));
                this.jHs.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i2 + ".appid")));
                this.jHr.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i2 + ".descid")));
                this.jfR.add(Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i2 + ".headimgurl")));
            }
        }
        AppMethodBeat.o(151263);
        return true;
    }
}
