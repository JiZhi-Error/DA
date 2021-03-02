package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.d.a.a(gRF = at.class)
public class be extends a implements at {
    private static HashMap<Long, String> PuI = new HashMap<>();
    private static HashMap<Long, ChattingItemTranslate.c> PuJ = new HashMap<>();
    private static LinkedHashMap<Long, Pair<ca, Integer>> PuK = new LinkedHashMap<>();
    private static HashMap<Long, Boolean> PuL = new HashMap<>();
    private static ArrayList<Long> PuM = new ArrayList<>();
    private static HashMap<Long, a> PuN = new HashMap<>();
    private IListener<qo> PuO = new IListener<qo>() {
        /* class com.tencent.mm.ui.chatting.d.be.AnonymousClass1 */

        {
            AppMethodBeat.i(233195);
            this.__eventId = qo.class.getName().hashCode();
            AppMethodBeat.o(233195);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qo qoVar) {
            AppMethodBeat.i(233196);
            qo qoVar2 = qoVar;
            a aVar = (a) be.PuN.get(Long.valueOf(qoVar2.dXb.msgId));
            if (aVar != null) {
                Log.i("MicroMsg.TransformComponent", "RecallVoiceTransTextActEvent %s %s", Long.valueOf(qoVar2.dXb.msgId), Integer.valueOf(aVar.pos));
                be.a(be.this, aVar.dTX, aVar.pos);
            }
            AppMethodBeat.o(233196);
            return false;
        }
    };
    private boolean PuP = false;
    private boolean PuQ = false;
    private List<Long> PuR = new ArrayList();
    boolean PuS = false;
    long PuT;
    long PuU = 0;
    boolean PuV = false;
    private int PuW = -1;
    private boolean ooc = false;

    public be() {
        AppMethodBeat.i(35689);
        AppMethodBeat.o(35689);
    }

    static /* synthetic */ Context a(be beVar) {
        AppMethodBeat.i(233204);
        Context context = beVar.getContext();
        AppMethodBeat.o(233204);
        return context;
    }

    static /* synthetic */ void a(be beVar, int i2) {
        AppMethodBeat.i(233210);
        beVar.amH(i2);
        AppMethodBeat.o(233210);
    }

    static /* synthetic */ void a(be beVar, long j2) {
        AppMethodBeat.i(233206);
        beVar.NA(j2);
        AppMethodBeat.o(233206);
    }

    static /* synthetic */ void a(be beVar, ca caVar, int i2) {
        AppMethodBeat.i(233203);
        beVar.g(caVar, i2);
        AppMethodBeat.o(233203);
    }

    static /* synthetic */ void a(be beVar, String str) {
        AppMethodBeat.i(233205);
        beVar.bmR(str);
        AppMethodBeat.o(233205);
    }

    static /* synthetic */ void b(be beVar) {
        AppMethodBeat.i(233208);
        beVar.notifyDataSetChanged();
        AppMethodBeat.o(233208);
    }

    static /* synthetic */ void b(be beVar, int i2) {
        AppMethodBeat.i(233211);
        beVar.amI(i2);
        AppMethodBeat.o(233211);
    }

    static /* synthetic */ void b(be beVar, long j2) {
        AppMethodBeat.i(233207);
        beVar.NE(j2);
        AppMethodBeat.o(233207);
    }

    static /* synthetic */ ca c(be beVar, long j2) {
        AppMethodBeat.i(233209);
        ca ND = beVar.ND(j2);
        AppMethodBeat.o(233209);
        return ND;
    }

    static {
        AppMethodBeat.i(35726);
        AppMethodBeat.o(35726);
    }

    public final synchronized void a(long j2, String str, ChattingItemTranslate.c cVar) {
        AppMethodBeat.i(35690);
        PuI.put(Long.valueOf(j2), str);
        PuJ.put(Long.valueOf(j2), cVar);
        if (cVar == ChattingItemTranslate.c.Transformed) {
            PuL.put(Long.valueOf(j2), Boolean.TRUE);
        }
        AppMethodBeat.o(35690);
    }

    private synchronized void NA(long j2) {
        AppMethodBeat.i(35691);
        PuI.remove(Long.valueOf(j2));
        PuJ.remove(Long.valueOf(j2));
        AppMethodBeat.o(35691);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.at
    public final synchronized String S(long j2, String str) {
        String str2;
        cu bkZ;
        AppMethodBeat.i(35692);
        str2 = PuI.get(Long.valueOf(j2));
        if (Util.isNullOrNil(str2) && (bkZ = o.bic().bkZ(str)) != null && !Util.isNullOrNil(bkZ.field_content)) {
            str2 = bkZ.field_content;
        }
        AppMethodBeat.o(35692);
        return str2;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.at
    public final synchronized ChattingItemTranslate.c NB(long j2) {
        ChattingItemTranslate.c cVar;
        AppMethodBeat.i(35693);
        cVar = PuJ.get(Long.valueOf(j2));
        if (cVar == null) {
            cVar = ChattingItemTranslate.c.NoTransform;
        }
        AppMethodBeat.o(35693);
        return cVar;
    }

    private synchronized void a(long j2, ca caVar, int i2) {
        AppMethodBeat.i(35694);
        PuK.put(Long.valueOf(j2), new Pair<>(caVar, Integer.valueOf(i2)));
        AppMethodBeat.o(35694);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.at
    public final synchronized boolean NC(long j2) {
        boolean z;
        AppMethodBeat.i(35695);
        if (PuK.containsKey(Long.valueOf(j2))) {
            z = true;
            AppMethodBeat.o(35695);
        } else {
            z = false;
            AppMethodBeat.o(35695);
        }
        return z;
    }

    private synchronized ca ND(long j2) {
        ca caVar;
        AppMethodBeat.i(35696);
        Pair<ca, Integer> pair = PuK.get(Long.valueOf(j2));
        if (pair == null) {
            caVar = null;
            AppMethodBeat.o(35696);
        } else {
            caVar = (ca) pair.first;
            AppMethodBeat.o(35696);
        }
        return caVar;
    }

    public final synchronized Pair<ca, Integer> gRq() {
        Pair<ca, Integer> pair;
        AppMethodBeat.i(35697);
        Iterator<Map.Entry<Long, Pair<ca, Integer>>> it = PuK.entrySet().iterator();
        if (it.hasNext()) {
            pair = it.next().getValue();
            AppMethodBeat.o(35697);
        } else {
            pair = null;
            AppMethodBeat.o(35697);
        }
        return pair;
    }

    private synchronized void NE(long j2) {
        AppMethodBeat.i(35698);
        if (PuK.containsKey(Long.valueOf(j2))) {
            PuK.remove(Long.valueOf(j2));
        }
        AppMethodBeat.o(35698);
    }

    private synchronized void gRr() {
        AppMethodBeat.i(35699);
        PuK.clear();
        AppMethodBeat.o(35699);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.at
    public final boolean gRs() {
        AppMethodBeat.i(35700);
        bg.aVF();
        if (!((Boolean) c.azQ().get(75, Boolean.FALSE)).booleanValue()) {
            AppMethodBeat.o(35700);
            return true;
        }
        AppMethodBeat.o(35700);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.at
    public final void gRt() {
        AppMethodBeat.i(35701);
        bg.aVF();
        c.azQ().set(75, Boolean.TRUE);
        AppMethodBeat.o(35701);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.at
    public final void amG(int i2) {
        AppMethodBeat.i(35702);
        if (i2 == 2) {
            this.PuQ = true;
            AppMethodBeat.o(35702);
            return;
        }
        if (this.PuS) {
            a(ND(this.PuT), true, -1, i2);
        }
        AppMethodBeat.o(35702);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.at
    public final boolean ch(ca caVar) {
        AppMethodBeat.i(233198);
        if (caVar == null) {
            AppMethodBeat.o(233198);
            return false;
        } else if (!Util.isNullOrNil(S(caVar.field_msgId, caVar.field_imgPath))) {
            AppMethodBeat.o(233198);
            return true;
        } else {
            AppMethodBeat.o(233198);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.at
    public final boolean NF(long j2) {
        AppMethodBeat.i(233199);
        boolean contains = PuM.contains(Long.valueOf(j2));
        AppMethodBeat.o(233199);
        return contains;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.at
    public final void NG(long j2) {
        AppMethodBeat.i(233200);
        PuM.remove(Long.valueOf(j2));
        AppMethodBeat.o(233200);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.at
    public final void a(final ca caVar, boolean z, final int i2, int i3) {
        AppMethodBeat.i(35703);
        if (caVar == null) {
            Log.d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
            AppMethodBeat.o(35703);
        } else if (NH(caVar.field_msgId)) {
            Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", Long.valueOf(caVar.field_msgId), Boolean.valueOf(this.PuS));
            caVar.gDT();
            NI(caVar.field_msgId);
            notifyDataSetChanged();
            AppMethodBeat.o(35703);
        } else {
            if (!NC(caVar.field_msgId) || !z) {
                Log.d("MicroMsg.TransformComponent", "voice to text, pos:%s", Integer.valueOf(i2));
                cu bkZ = o.bic().bkZ(caVar.field_imgPath);
                if (bkZ == null || Util.isNullOrNil(bkZ.field_content)) {
                    int aYS = bg.azz().aYS();
                    if (aYS == 4 || aYS == 6) {
                        if (this.PuS) {
                            Log.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
                            a(caVar.field_msgId, caVar, i2);
                            a(caVar.field_msgId, "", ChattingItemTranslate.c.PreTransform);
                            notifyDataSetChanged();
                        } else {
                            gf gfVar = new gf();
                            gfVar.dJV.dJY = 1;
                            EventCenter.instance.publish(gfVar);
                            ((aw) this.dom.bh(aw.class)).NM(caVar.field_msgId);
                            final gf gfVar2 = new gf();
                            gfVar2.dJV.dJX = String.valueOf(caVar.field_msgId);
                            gfVar2.dJV.fileName = caVar.field_imgPath;
                            gfVar2.dJV.from = 1;
                            gfVar2.dJV.dJY = 0;
                            gfVar2.dJV.scene = gRu();
                            gfVar2.dJV.dJZ = new Runnable() {
                                /* class com.tencent.mm.ui.chatting.d.be.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(35687);
                                    if (!be.this.NC(Long.valueOf(gfVar2.dJV.dJX).longValue())) {
                                        AppMethodBeat.o(35687);
                                    } else if (gfVar2.dJW.brW) {
                                        if (Util.isNullOrNil(gfVar2.dJW.content)) {
                                            if (gfVar2.dJW.state == 2) {
                                                Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", gfVar2.dJV.dJX);
                                                be.a(be.this, be.a(be.this).getString(R.string.b2w));
                                            }
                                            be.a(be.this, Long.valueOf(gfVar2.dJV.dJX).longValue());
                                            be.b(be.this, Long.valueOf(gfVar2.dJV.dJX).longValue());
                                            be.this.PuS = false;
                                            be.b(be.this);
                                        } else {
                                            Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", gfVar2.dJV.dJX);
                                            ca c2 = be.c(be.this, Long.valueOf(gfVar2.dJV.dJX).longValue());
                                            if (c2 != null) {
                                                be.this.a(Long.valueOf(gfVar2.dJV.dJX).longValue(), gfVar2.dJW.content, ChattingItemTranslate.c.Transformed);
                                                c2.gDU();
                                                bg.aVF();
                                                c.aSQ().a(c2.field_msgId, c2);
                                                be.b(be.this, Long.valueOf(gfVar2.dJV.dJX).longValue());
                                                be.b(be.this);
                                                be.a(be.this, i2);
                                            }
                                            be.this.PuS = false;
                                        }
                                        if (34 == caVar.getType()) {
                                            be.PuN.put(Long.valueOf(caVar.field_msgId), new a(caVar, i2));
                                            AppMethodBeat.o(35687);
                                            return;
                                        }
                                        be.a(be.this, caVar, i2);
                                        AppMethodBeat.o(35687);
                                    } else {
                                        if (!Util.isNullOrNil(gfVar2.dJW.content)) {
                                            be.this.a(Long.valueOf(gfVar2.dJV.dJX).longValue(), gfVar2.dJW.content, ChattingItemTranslate.c.Transforming);
                                            Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", gfVar2.dJV.dJX);
                                        }
                                        be.b(be.this);
                                        be.a(be.this, i2);
                                        AppMethodBeat.o(35687);
                                    }
                                }
                            };
                            if (34 == caVar.getType()) {
                                PuM.add(Long.valueOf(caVar.field_msgId));
                            }
                            a(Long.valueOf(gfVar2.dJV.dJX).longValue(), "", ChattingItemTranslate.c.Transforming);
                            a(caVar.field_msgId, caVar, i2);
                            this.PuS = true;
                            this.PuT = caVar.field_msgId;
                            notifyDataSetChanged();
                            amH(i2);
                            if (EventCenter.instance.publish(gfVar2)) {
                                Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
                            } else {
                                Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
                                bmR(getContext().getString(R.string.b2w));
                                NA(Long.valueOf(gfVar2.dJV.dJX).longValue());
                                NE(Long.valueOf(gfVar2.dJV.dJX).longValue());
                                this.PuS = false;
                                g(caVar, i2);
                            }
                        }
                        if (z) {
                            this.ooc = true;
                        }
                    } else {
                        h.n(getContext(), R.string.b2x, R.string.zb);
                        c(2, caVar);
                        this.PuP = false;
                        AppMethodBeat.o(35703);
                        return;
                    }
                } else {
                    Log.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", Long.valueOf(caVar.field_msgId), caVar.field_imgPath);
                    caVar.gDU();
                    a(caVar.field_msgId, bkZ.field_content, ChattingItemTranslate.c.Transformed);
                    bg.aVF();
                    c.aSQ().a(caVar.field_msgId, caVar);
                    this.PuP = false;
                    amH(i2);
                    AppMethodBeat.o(35703);
                    return;
                }
            } else {
                if (NB(caVar.field_msgId) == ChattingItemTranslate.c.PreTransform) {
                    Log.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
                    NE(caVar.field_msgId);
                    NA(caVar.field_msgId);
                    c(5, caVar);
                } else if (this.PuS) {
                    gf gfVar3 = new gf();
                    gfVar3.dJV.dJY = 3;
                    EventCenter.instance.publish(gfVar3);
                    NE(caVar.field_msgId);
                    NA(caVar.field_msgId);
                    caVar.gDT();
                    bg.aVF();
                    c.aSQ().a(caVar.field_msgId, caVar);
                    this.PuS = false;
                    g(caVar, -1);
                }
                notifyDataSetChanged();
                if (z) {
                    amI(i3);
                    AppMethodBeat.o(35703);
                    return;
                }
            }
            AppMethodBeat.o(35703);
        }
    }

    private void amH(int i2) {
        AppMethodBeat.i(35704);
        if (this.ooc && i2 != -1) {
            com.tencent.mm.ui.chatting.e.a aVar = this.dom;
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(aVar, a2.axQ(), "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
            aVar.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/component/TransformComponent", "scrollTo", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        }
        AppMethodBeat.o(35704);
    }

    private void amI(int i2) {
        int i3 = 1;
        AppMethodBeat.i(35705);
        if (this.PuP && this.PuR.size() > 0) {
            String l = this.PuR.get(0).toString();
            for (int i4 = 1; i4 < this.PuR.size(); i4++) {
                l = l + ":" + this.PuR.get(i4);
            }
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(this.PuR.size());
            if (this.ooc) {
                i3 = 0;
            }
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = 0;
            objArr[4] = l;
            hVar.a(16128, objArr);
            this.PuP = false;
            this.PuR.clear();
        }
        AppMethodBeat.o(35705);
    }

    private static void c(int i2, ca caVar) {
        AppMethodBeat.i(35706);
        if (caVar == null) {
            AppMethodBeat.o(35706);
            return;
        }
        gj gjVar = new gj();
        gjVar.dKg.dKi = 0;
        gjVar.dKg.dKj = 0;
        gjVar.dKg.dKk = 0;
        gjVar.dKg.dKh = 0;
        gjVar.dKg.fileName = caVar.field_imgPath;
        gjVar.dKg.result = i2;
        EventCenter.instance.publish(gjVar);
        AppMethodBeat.o(35706);
    }

    private void notifyDataSetChanged() {
        AppMethodBeat.i(35708);
        if (this.dom != null) {
            this.dom.cmy();
        }
        AppMethodBeat.o(35708);
    }

    private Context getContext() {
        AppMethodBeat.i(35709);
        if (this.dom != null) {
            Activity context = this.dom.Pwc.getContext();
            AppMethodBeat.o(35709);
            return context;
        }
        Context context2 = MMApplicationContext.getContext();
        AppMethodBeat.o(35709);
        return context2;
    }

    private void bmR(String str) {
        AppMethodBeat.i(35710);
        if (!(this.dom == null || this.dom.Pwc.getContext() == null)) {
            Toast makeText = Toast.makeText(this.dom.Pwc.getContext(), str, 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
        AppMethodBeat.o(35710);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.at
    public final synchronized boolean NH(long j2) {
        boolean z;
        AppMethodBeat.i(35711);
        Boolean bool = PuL.get(Long.valueOf(j2));
        if (bool != null) {
            z = bool.booleanValue();
            AppMethodBeat.o(35711);
        } else {
            z = false;
            AppMethodBeat.o(35711);
        }
        return z;
    }

    private synchronized void NI(long j2) {
        AppMethodBeat.i(35712);
        PuL.put(Long.valueOf(j2), Boolean.FALSE);
        AppMethodBeat.o(35712);
    }

    private int gRu() {
        int i2;
        AppMethodBeat.i(35713);
        if (ab.IT(this.dom.getTalkerUserName())) {
            boolean gOQ = ((d) this.dom.bh(d.class)).gOQ();
            if (((d) this.dom.bh(d.class)).gOP()) {
                if (gOQ) {
                    i2 = 5;
                } else {
                    i2 = 4;
                }
            } else if (g.Nf(this.dom.getTalkerUserName())) {
                i2 = 3;
            } else if (g.Ng(this.dom.getTalkerUserName())) {
                i2 = 0;
            } else if (g.Nb(this.dom.getTalkerUserName())) {
                i2 = 6;
            } else {
                i2 = 7;
            }
        } else if (this.dom.gRL()) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        AppMethodBeat.o(35713);
        return i2;
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(233201);
        super.gIl();
        this.PuO.alive();
        AppMethodBeat.o(233201);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35714);
        Log.i("MicroMsg.TransformComponent", "[onChattingPause]");
        amG(3);
        AppMethodBeat.o(35714);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(233202);
        super.gIn();
        this.PuO.dead();
        AppMethodBeat.o(233202);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AppMethodBeat.i(35716);
        super.onScroll(absListView, i2, i3, i4);
        if (i2 < this.PuW) {
            this.ooc = false;
        }
        this.PuW = i2;
        AppMethodBeat.o(35716);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        ca dTX;
        int pos;

        public a(ca caVar, int i2) {
            this.dTX = caVar;
            this.pos = i2;
        }
    }

    private synchronized void g(final ca caVar, final int i2) {
        MMHandler mMHandler;
        AppMethodBeat.i(35707);
        if (this.dom != null) {
            mMHandler = com.tencent.mm.ui.chatting.e.a.gRP();
        } else {
            mMHandler = null;
        }
        if (mMHandler != null) {
            mMHandler.post(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.be.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(35688);
                    Pair<ca, Integer> gRq = be.this.gRq();
                    if (gRq != null) {
                        if (be.this.PuP) {
                            be.b(be.this, 4);
                        }
                        be.this.a((ca) gRq.first, false, ((Integer) gRq.second).intValue(), 0);
                        AppMethodBeat.o(35688);
                        return;
                    }
                    if (i2 != -1) {
                        ca amt = ((k) be.this.dom.bh(k.class)).amt(i2 + 1);
                        if (amt != null && amt.gAy() && amt.field_isSend == 0 && be.this.PuQ) {
                            be.this.PuQ = false;
                            be.b(be.this, 2);
                            EventCenter.instance.asyncPublish(new zc(), Looper.getMainLooper());
                            AppMethodBeat.o(35688);
                            return;
                        } else if (amt == null || !amt.gAy() || amt.field_isSend != 0 || s.ai(amt)) {
                            be.b(be.this, 0);
                        } else {
                            if (!be.this.PuP) {
                                be.this.PuR.add(Long.valueOf(caVar.field_msgId));
                            }
                            be.this.PuP = true;
                            be.this.PuR.add(Long.valueOf(amt.field_msgId));
                            s.ak(amt);
                            be.this.a(amt, false, i2 + 1, 0);
                            AppMethodBeat.o(35688);
                            return;
                        }
                    }
                    EventCenter.instance.asyncPublish(new zc(), Looper.getMainLooper());
                    AppMethodBeat.o(35688);
                }
            });
        }
        AppMethodBeat.o(35707);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIo() {
        AppMethodBeat.i(35715);
        Log.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
        gRr();
        PuJ.clear();
        PuK.clear();
        PuL.clear();
        if (this.PuS) {
            gf gfVar = new gf();
            gfVar.dJV.dJY = 3;
            EventCenter.instance.publish(gfVar);
            this.PuS = false;
        }
        Log.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.be.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(233197);
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (be.this) {
                    try {
                        be.PuL.clear();
                        be.PuK.clear();
                    } catch (Throwable th) {
                        AppMethodBeat.o(233197);
                        throw th;
                    }
                }
                Log.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(233197);
            }
        }, "UnsetTransformFlag");
        AppMethodBeat.o(35715);
    }
}
