package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bb.v;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.ba;
import com.tencent.mm.ui.chatting.viewitems.c;
import java.util.regex.Matcher;

/* access modifiers changed from: package-private */
public final class bb implements ba.a {
    bb() {
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.ba.a
    public final void b(c.a aVar, int i2, a aVar2, ca caVar) {
        AppMethodBeat.i(37379);
        ba.b bVar = (ba.b) aVar;
        bVar.POM.aw(caVar.field_content);
        bVar.POM.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
        Bundle bundle = new Bundle();
        bundle.putString("chatroom_name", aVar2.getTalkerUserName());
        bundle.putLong("msg_id", caVar.field_msgId);
        if ((caVar.field_flag & 8) != 0) {
            bVar.POM.a(l.a((Context) aVar2.Pwc.getContext(), (CharSequence) caVar.field_content, (int) bVar.POM.getTextSize(), false, (Object) bundle), TextView.BufferType.SPANNABLE);
            bVar.POM.setClickable(true);
        } else {
            bVar.POM.a(l.a((Context) aVar2.Pwc.getContext(), (CharSequence) caVar.field_content, (int) bVar.POM.getTextSize(), true, (Object) bundle), TextView.BufferType.SPANNABLE);
        }
        if (caVar.field_content.contains("weixin://wxpay/transfer/remindrcvmsg")) {
            Matcher matcher = k.a.KqM.matcher(caVar.field_content);
            if (matcher.find()) {
                Uri parse = Uri.parse(matcher.group(1));
                String queryParameter = parse.getQueryParameter("transferid");
                String queryParameter2 = parse.getQueryParameter("transfer_msg_type");
                h.INSTANCE.a(20467, "transfer_to_change", "read message", "", "", "", "", 4, queryParameter, queryParameter2);
            }
        }
        com.tencent.mm.bb.a Pp = v.bew().Pp(aVar2.getTalkerUserName());
        bg.aVF();
        int intValue = ((Integer) com.tencent.mm.model.c.azQ().get(12311, (Object) -2)).intValue();
        if ((Pp == null || Pp.jgE == -2) && (Pp != null || intValue == -2)) {
            bVar.POM.setTextColor(aVar2.Pwc.getContext().getResources().getColor(R.color.FG_2));
            bVar.POM.setBackground(aVar2.Pwc.getContext().getResources().getDrawable(R.drawable.mr));
        } else {
            bVar.POM.setTextColor(aVar2.Pwc.getContext().getResources().getColor(R.color.jg));
            bVar.POM.setBackground(aVar2.Pwc.getContext().getResources().getDrawable(R.drawable.ms));
        }
        bVar.POM.invalidate();
        AppMethodBeat.o(37379);
    }
}
