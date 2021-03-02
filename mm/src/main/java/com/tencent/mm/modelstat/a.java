package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class a {

    /* renamed from: com.tencent.mm.modelstat.a$a  reason: collision with other inner class name */
    public enum EnumC0456a {
        Expose(1),
        Click(2);
        
        public int value = 0;

        public static EnumC0456a valueOf(String str) {
            AppMethodBeat.i(20654);
            EnumC0456a aVar = (EnumC0456a) Enum.valueOf(EnumC0456a.class, str);
            AppMethodBeat.o(20654);
            return aVar;
        }

        static {
            AppMethodBeat.i(20655);
            AppMethodBeat.o(20655);
        }

        private EnumC0456a(int i2) {
            this.value = i2;
        }
    }

    public static void a(ca caVar, EnumC0456a aVar) {
        int i2;
        int Kp;
        AppMethodBeat.i(20656);
        if (Util.isNullOrNil(caVar.fRa)) {
            AppMethodBeat.o(20656);
            return;
        }
        m mVar = new m();
        mVar.n("20ExpIdStr", caVar.fRa + ",");
        mVar.n("21OpType", aVar.value + ",");
        mVar.n("22msgId", caVar.field_msgSvrId + ",");
        mVar.n("23MessageType", caVar.getType() + ",");
        if (caVar.dOQ()) {
            k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
            if (aD == null) {
                i2 = 0;
            } else {
                i2 = aD.type;
            }
        } else {
            i2 = 0;
        }
        String str = caVar.field_talker;
        mVar.n("24AppMsgInnerType", i2 + ",");
        mVar.n("25curUsername", str + ",");
        String str2 = "";
        if (caVar.field_isSend == 1) {
            str2 = z.aTY();
        } else if (str == null || !ab.Eq(str)) {
            str2 = str;
        } else if (!(caVar.field_content == null || (Kp = bp.Kp(caVar.field_content)) == -1)) {
            str2 = caVar.field_content.substring(0, Kp).trim();
        }
        mVar.n("26msgPostUserName", str2 + ",");
        mVar.n("27MediaState", caVar.fRb + ",");
        Log.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + mVar.abW());
        h.INSTANCE.a(13564, mVar);
        AppMethodBeat.o(20656);
    }
}
