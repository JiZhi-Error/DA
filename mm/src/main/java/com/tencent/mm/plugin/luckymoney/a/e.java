package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.c.bj;

public final class e {
    public static void a(StringBuilder sb, bj bjVar, int i2) {
        AppMethodBeat.i(130931);
        if (bjVar == null) {
            AppMethodBeat.o(130931);
            return;
        }
        sb.append("<emoji>");
        sb.append("<localreceivestatus>").append(i2).append("</localreceivestatus>");
        sb.append("<md5>").append(k.b.HE(bjVar.field_md5)).append("</md5>");
        sb.append("<type>").append(bjVar.field_type).append("</type>");
        sb.append("<width>").append(bjVar.field_width).append("</width>");
        sb.append("<height>").append(bjVar.field_height).append("</height>");
        sb.append("<len>").append(bjVar.field_size).append("</len>");
        sb.append("<aeskey>").append(k.b.HE(bjVar.field_aeskey)).append("</aeskey>");
        sb.append("<cdnurl>").append(k.b.HE(bjVar.field_cdnUrl)).append("</cdnurl>");
        sb.append("<encrypturl>").append(k.b.HE(bjVar.field_encrypturl)).append("</encrypturl>");
        sb.append("<externurl>").append(k.b.HE(bjVar.field_externUrl)).append("</externurl>");
        sb.append("<externmd5>").append(k.b.HE(bjVar.field_externMd5)).append("</externmd5>");
        sb.append("<productid>").append(k.b.HE(bjVar.field_groupId)).append("</productid>");
        sb.append("<designerid>").append(k.b.HE(bjVar.field_designerID)).append("</designerid>");
        sb.append("<attachedtext>").append(k.b.HE(bjVar.field_attachedText)).append("</attachedtext>");
        sb.append("</emoji>");
        AppMethodBeat.o(130931);
    }
}
