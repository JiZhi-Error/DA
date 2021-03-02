package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.a;
import com.tencent.mm.bb.v;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.ah;
import com.tencent.mm.ui.chatting.viewitems.ba;
import com.tencent.mm.ui.chatting.viewitems.c;

/* access modifiers changed from: package-private */
public final class ay implements ba.a {
    ay() {
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.ba.a
    public final void b(c.a aVar, final int i2, com.tencent.mm.ui.chatting.e.a aVar2, final ca caVar) {
        int i3;
        Spannable spannable;
        AppMethodBeat.i(37366);
        final ba.b bVar = (ba.b) aVar;
        final a.b bVar2 = (a.b) aVar2.bh(ah.class);
        int color = bVar.POM.getContext().getResources().getColor(R.color.x0);
        int color2 = bVar.POM.getContext().getResources().getColor(R.color.x2);
        final com.tencent.mm.az.a gDX = caVar.gDX();
        if (gDX == null) {
            bVar.convertView.setVisibility(8);
        } else {
            bVar.convertView.setVisibility(0);
            bVar.POM.a(l.b(bVar.POM.getContext(), Util.nullAsNil(gDX.jfG), bVar.POM.getTextSize()), TextView.BufferType.SPANNABLE);
            if (gDX.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication") || gDX.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
                color = bVar.POM.getContext().getResources().getColor(R.color.g7);
                color2 = bVar.POM.getContext().getResources().getColor(R.color.g9);
                if (!caVar.gDO()) {
                    Spannable newSpannable = Spannable.Factory.getInstance().newSpannable("    " + ((Object) bVar.POM.hiT()));
                    Drawable drawable = bVar.POM.getContext().getResources().getDrawable(R.raw.invite_sysmsg_icon);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    com.tencent.mm.ui.widget.a aVar3 = new com.tencent.mm.ui.widget.a(drawable, 1);
                    aVar3.QBM = (int) (((((float) drawable.getIntrinsicHeight()) - bVar.POM.getTextSize()) + ((float) com.tencent.mm.cb.a.fromDPToPix(bVar.POM.getContext(), 2))) / 2.0f);
                    newSpannable.setSpan(aVar3, 0, 3, 33);
                    spannable = newSpannable;
                    i3 = 4;
                } else {
                    color = bVar.POM.getContext().getResources().getColor(R.color.g7);
                    color2 = bVar.POM.getContext().getResources().getColor(R.color.g9);
                    spannable = Spannable.Factory.getInstance().newSpannable(bVar.POM.hiT());
                    i3 = 0;
                }
            } else {
                spannable = Spannable.Factory.getInstance().newSpannable(bVar.POM.hiT());
                i3 = 0;
            }
            for (final int i4 = 0; i4 < gDX.jfI.size(); i4++) {
                a aVar4 = new a();
                aVar4.POt = new p(color, color2) {
                    /* class com.tencent.mm.ui.chatting.viewitems.ay.AnonymousClass1 */

                    @Override // com.tencent.mm.pluginsdk.ui.span.p
                    public final void onClick(View view) {
                        AppMethodBeat.i(37364);
                        Log.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", gDX);
                        bVar2.a(bVar.convertView, caVar, gDX, i4);
                        AppMethodBeat.o(37364);
                    }
                };
                aVar4.start = gDX.jfJ.get(i4).intValue();
                aVar4.end = gDX.jfK.get(i4).intValue();
                spannable.setSpan(aVar4.POt, aVar4.start + i3, aVar4.end + i3, 18);
            }
            bVar.POM.a(spannable, TextView.BufferType.SPANNABLE);
            bVar.POM.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.viewitems.ay.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(37365);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemNewXmlSysImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.d("MicroMsg.ChattingItemNewXmlSysImpl", "clicked");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemNewXmlSysImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37365);
                }
            });
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
        AppMethodBeat.o(37366);
    }

    static class a {
        public ClickableSpan POt;
        public int end;
        public int start;

        a() {
        }
    }
}
