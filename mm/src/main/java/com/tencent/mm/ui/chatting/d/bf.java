package com.tencent.mm.ui.chatting.d;

import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.yc;
import com.tencent.mm.g.a.yd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate;
import java.util.HashMap;
import java.util.regex.Pattern;

@a(gRF = au.class)
public class bf extends a implements au {
    private IListener BIE = new IListener<yd>() {
        /* class com.tencent.mm.ui.chatting.d.bf.AnonymousClass2 */

        {
            AppMethodBeat.i(161534);
            this.__eventId = yd.class.getName().hashCode();
            AppMethodBeat.o(161534);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yd ydVar) {
            AppMethodBeat.i(35729);
            yd ydVar2 = ydVar;
            if (ydVar2 instanceof yd) {
                final String str = ydVar2.eey.id;
                final int i2 = ydVar2.eey.ret;
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.bf.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(35728);
                        if (i2 == 0) {
                            bf.b(bf.this);
                            bf.this.a(Util.safeParseLong(str), ChattingItemTranslate.c.Transformed);
                            bf.a(bf.this, Util.safeParseLong(str));
                            AppMethodBeat.o(35728);
                            return;
                        }
                        if (i2 == 3) {
                            h.cD(bf.this.dom.Pwc.getContext(), bf.this.dom.Pwc.getMMResources().getString(R.string.b35));
                        } else if (i2 != 5) {
                            h.cD(bf.this.dom.Pwc.getContext(), bf.this.dom.Pwc.getMMResources().getString(R.string.b30));
                        }
                        bf.this.a(Util.safeParseLong(str), ChattingItemTranslate.c.NoTransform);
                        bf.this.dom.cmy();
                        AppMethodBeat.o(35728);
                    }
                }, (long) (i2 == 5 ? 2000 : 0));
            }
            AppMethodBeat.o(35729);
            return false;
        }
    };
    private Pattern BIF = Pattern.compile("[a-zA-z]");
    private Pattern BIG = Pattern.compile("[一-龥]");
    private int PuW = -1;
    private QueueWorkerThread PuZ = new QueueWorkerThread(5, "msg-translate-update-worker");
    private HashMap<Long, ChattingItemTranslate.c> Pva = new HashMap<>();
    private int Pvb = -1;
    private boolean Pvc;
    private int Pvd;
    private boolean ooc = false;

    static /* synthetic */ void a(bf bfVar, ca caVar, int i2, boolean z) {
        AppMethodBeat.i(233221);
        bfVar.a(caVar, i2, z);
        AppMethodBeat.o(233221);
    }

    static /* synthetic */ int b(bf bfVar) {
        int i2 = bfVar.Pvd;
        bfVar.Pvd = i2 + 1;
        return i2;
    }

    public bf() {
        AppMethodBeat.i(35731);
        AppMethodBeat.o(35731);
    }

    private void gOL() {
        AppMethodBeat.i(35732);
        EventCenter.instance.removeListener(this.BIE);
        AppMethodBeat.o(35732);
    }

    private int amJ(int i2) {
        AppMethodBeat.i(233213);
        k kVar = (k) this.dom.bh(k.class);
        int i3 = 0;
        while (i3 <= 20 && ci(kVar.amt(i2 + i3 + 1))) {
            i3++;
        }
        AppMethodBeat.o(233213);
        return i3;
    }

    private static void F(int i2, int i3, int i4) {
        AppMethodBeat.i(233214);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(19168, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i2 + i4));
        AppMethodBeat.o(233214);
    }

    private boolean ci(ca caVar) {
        AppMethodBeat.i(233215);
        if (caVar == null || ((!caVar.isText() && !caVar.gDy()) || caVar.gDz() || caVar.field_isSend != 0)) {
            AppMethodBeat.o(233215);
            return false;
        }
        String str = caVar.field_content;
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            str = str.substring(indexOf + 1);
        }
        if (LocaleUtil.isChineseAppLang()) {
            boolean find = this.BIF.matcher(str).find();
            AppMethodBeat.o(233215);
            return find;
        }
        boolean find2 = this.BIG.matcher(str).find();
        AppMethodBeat.o(233215);
        return find2;
    }

    public final void a(long j2, ChattingItemTranslate.c cVar) {
        AppMethodBeat.i(35733);
        this.Pva.put(Long.valueOf(j2), cVar);
        AppMethodBeat.o(35733);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.au
    public final ChattingItemTranslate.c cj(ca caVar) {
        AppMethodBeat.i(35734);
        ChattingItemTranslate.c cVar = this.Pva.get(Long.valueOf(caVar.field_msgId));
        if (cVar == null) {
            if (!caVar.gDz()) {
                yc ycVar = new yc();
                ycVar.eev.id = new StringBuilder().append(caVar.field_msgId).toString();
                EventCenter.instance.publish(ycVar);
                if (ycVar.eew.eex) {
                    cVar = ChattingItemTranslate.c.Transforming;
                    a(caVar.field_msgId, cVar);
                } else {
                    cVar = ChattingItemTranslate.c.NoTransform;
                }
            } else if (caVar.gDI()) {
                cVar = ChattingItemTranslate.c.Transformed;
            } else {
                cVar = ChattingItemTranslate.c.NoTransform;
            }
        }
        AppMethodBeat.o(35734);
        return cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0103  */
    @Override // com.tencent.mm.ui.chatting.d.b.au
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(final android.view.MenuItem r11, final com.tencent.mm.storage.ca r12) {
        /*
        // Method dump skipped, instructions count: 290
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.bf.b(android.view.MenuItem, com.tencent.mm.storage.ca):boolean");
    }

    @Override // com.tencent.mm.ui.chatting.d.b.au
    public final String g(ca caVar, boolean z) {
        AppMethodBeat.i(179930);
        if (z) {
            String hd = hd(caVar.field_transContent, caVar.field_isSend);
            AppMethodBeat.o(179930);
            return hd;
        }
        String hd2 = hd(caVar.field_content, caVar.field_isSend);
        AppMethodBeat.o(179930);
        return hd2;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.au
    public final void gRw() {
        this.Pvc = true;
    }

    private String hd(String str, int i2) {
        AppMethodBeat.i(179931);
        if (this.dom.gRL() && str != null && i2 == 0) {
            str = bp.Kt(str);
        }
        AppMethodBeat.o(179931);
        return str;
    }

    private void a(ca caVar, int i2, boolean z) {
        boolean z2;
        int indexOf;
        AppMethodBeat.i(233216);
        if (caVar.gDz() && !z) {
            if (caVar.gDI()) {
                caVar.gDK();
                a(caVar.field_msgId, ChattingItemTranslate.c.NoTransform);
                b.jmd.a(caVar, false);
            } else {
                caVar.gDJ();
                a(caVar.field_msgId, ChattingItemTranslate.c.Transformed);
                b.jmd.a(caVar, true);
            }
            bg.aVF();
            c.aSQ().a(caVar.field_msgId, caVar);
            this.Pvb = -1;
        } else if (cj(caVar) == ChattingItemTranslate.c.Transforming) {
            AppMethodBeat.o(233216);
            return;
        } else {
            ya yaVar = new ya();
            yaVar.eep.eer = false;
            yaVar.eep.id = new StringBuilder().append(caVar.field_msgId).toString();
            if (caVar.dOQ()) {
                String str = caVar.field_content;
                if (this.dom.gRM() && (indexOf = caVar.field_content.indexOf(58)) != -1) {
                    str = caVar.field_content.substring(indexOf + 1);
                }
                if (str != null) {
                    yaVar.eep.eeq = k.b.aD(str, caVar.field_reserved).title;
                }
                z2 = true;
            } else {
                yaVar.eep.eeq = caVar.field_content;
                z2 = false;
            }
            yaVar.eep.ees = caVar.fRc;
            if (!this.dom.gRM() || caVar.field_isSend == 1) {
                yaVar.eep.type = 0;
            } else if (z2) {
                yaVar.eep.type = 0;
            } else {
                yaVar.eep.type = 1;
            }
            yaVar.eep.source = this.dom.getTalkerUserName();
            EventCenter.instance.publish(yaVar);
            a(caVar.field_msgId, ChattingItemTranslate.c.Transforming);
            this.Pvb = i2;
        }
        this.dom.cmy();
        AppMethodBeat.o(233216);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35739);
        gOL();
        AppMethodBeat.o(35739);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35740);
        super.gOK();
        gOL();
        AppMethodBeat.o(35740);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(233217);
        super.cFy();
        this.Pvc = true;
        if (this.Pvb >= 0) {
            F(this.Pvd, 1, amJ(this.Pvb));
        }
        AppMethodBeat.o(233217);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AppMethodBeat.i(233218);
        super.onScroll(absListView, i2, i3, i4);
        if (i2 < this.PuW) {
            this.ooc = false;
        }
        this.PuW = i2;
        AppMethodBeat.o(233218);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35738);
        this.Pva.clear();
        EventCenter.instance.addListener(this.BIE);
        AppMethodBeat.o(35738);
    }

    static /* synthetic */ void a(bf bfVar) {
        AppMethodBeat.i(233219);
        ChatFooter gPO = ((u) bfVar.dom.bh(u.class)).gPO();
        if (bfVar.Pvc || gPO.gqJ()) {
            F(bfVar.Pvd, 1, bfVar.amJ(bfVar.Pvb));
            AppMethodBeat.o(233219);
        } else if (bfVar.Pvb < 0) {
            F(bfVar.Pvd, 0, 0);
            AppMethodBeat.o(233219);
        } else {
            ca amt = ((com.tencent.mm.ui.chatting.d.b.k) bfVar.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).amt(bfVar.Pvb + 1);
            if (bfVar.ci(amt)) {
                bfVar.a(amt, bfVar.Pvb + 1, false);
                int i2 = bfVar.Pvb;
                if (bfVar.ooc && i2 != -1) {
                    com.tencent.mm.ui.chatting.e.a aVar = bfVar.dom;
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, a2.axQ(), "com/tencent/mm/ui/chatting/component/TranslateComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                    aVar.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/component/TranslateComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                }
                AppMethodBeat.o(233219);
                return;
            }
            bfVar.Pvb = -1;
            F(bfVar.Pvd, 0, 0);
            AppMethodBeat.o(233219);
        }
    }

    static /* synthetic */ void a(bf bfVar, final long j2) {
        AppMethodBeat.i(233220);
        bfVar.PuZ.add(new QueueWorkerThread.ThreadObject() {
            /* class com.tencent.mm.ui.chatting.d.bf.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
            public final boolean onPostExecute() {
                return false;
            }

            @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
            public final boolean doInBackground() {
                AppMethodBeat.i(35727);
                bg.aVF();
                ca Hb = c.aSQ().Hb(j2);
                Hb.gDJ();
                b.jmd.a(Hb, true);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.bf.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(233212);
                        bf.a(bf.this);
                        AppMethodBeat.o(233212);
                    }
                });
                bg.aVF();
                c.aSQ().a(j2, Hb);
                AppMethodBeat.o(35727);
                return false;
            }
        });
        AppMethodBeat.o(233220);
    }
}
