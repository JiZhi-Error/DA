package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.q;
import com.tencent.mm.al.a.e;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.bb.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.c;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.av;
import com.tencent.mm.ui.chatting.viewitems.be;
import com.tencent.mm.ui.chatting.viewitems.br;
import com.tencent.mm.ui.chatting.viewitems.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a extends BaseAdapter implements k {
    protected i.a AHZ = new i.a() {
        /* class com.tencent.mm.ui.chatting.a.a.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
        public final void a(i iVar, i.c cVar) {
            AppMethodBeat.i(34986);
            if (iVar == null || cVar == null) {
                AppMethodBeat.o(34986);
            } else if (cVar.talker == null || a.this.OIz.getTalkerUserName() == null) {
                AppMethodBeat.o(34986);
            } else {
                if (cVar.talker.equals(a.this.OIz.getTalkerUserName())) {
                    a.this.gOw();
                }
                AppMethodBeat.o(34986);
            }
        }
    };
    private boolean CXr = false;
    public com.tencent.mm.ui.chatting.e.a OIz;
    private c PlA;
    private View.OnClickListener PlB = null;
    private final int PlC;
    private final int PlD;
    public SparseArray<ca> PlE = new SparseArray<>();
    private HashSet<Long> PlF = new HashSet<>();
    public SparseIntArray PlG = new SparseIntArray();
    public long PlH = -1;
    public long PlI = -1;
    private CopyOnWriteArraySet<Long> PlJ = new CopyOnWriteArraySet<>();
    private Map<Long, Integer> PlK = new HashMap();
    private Map<Long, WeakReference<View>> PlL = new HashMap();
    private boolean PlM = false;
    private boolean PlN = false;
    private boolean PlO = false;
    private final MTimerHandler PlP = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.chatting.a.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(34984);
            if (a.this.OIz != null && a.this.OIz.cQp) {
                Log.i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
                a.this.gOw();
            }
            AppMethodBeat.o(34984);
            return true;
        }
    }, true);
    public com.tencent.mm.ui.chatting.n.a.a PlQ;
    private boolean PlR = false;
    private int PlS = 0;
    private t.a PlT = new t.a() {
        /* class com.tencent.mm.ui.chatting.a.a.AnonymousClass4 */

        @Override // com.tencent.mm.modelvideo.t.a
        public final void a(t.a.C0460a aVar) {
            AppMethodBeat.i(34988);
            boolean z = false;
            if (!(aVar == null || aVar.jsu == 3 || (aVar.jsu != 2 && aVar.jsu != -1 && aVar.jsu != 1))) {
                z = be.d.b(aVar);
            }
            if (!z) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.a.a.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(34987);
                        a.this.gOw();
                        AppMethodBeat.o(34987);
                    }
                });
            }
            AppMethodBeat.o(34988);
        }
    };
    private long PlU = -1;
    public t.g Plr;
    private t.g Pls;
    public t.f Plt;
    private t.f Plu;
    public l Plv;
    private l Plw;
    public ac Plx;
    private ac Ply;
    public c Plz;
    private int cSs = -1;
    private boolean dlW;
    public com.tencent.mm.av.a.a.c gzE = null;
    private LayoutInflater kgB;
    private ListView mListView;
    private com.tencent.mm.pluginsdk.ui.span.i ptq;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(35021);
        ca amt = amt(i2);
        AppMethodBeat.o(35021);
        return amt;
    }

    public a(com.tencent.mm.ui.chatting.e.a aVar, ListView listView) {
        AppMethodBeat.i(34989);
        aVar.a(k.class, this);
        this.mListView = listView;
        this.OIz = aVar;
        this.kgB = aa.jQ(aVar.Pwc.getContext());
        this.PlC = aVar.Pwc.getMMResources().getDimensionPixelSize(R.dimen.kb);
        this.PlD = aVar.Pwc.getMMResources().getDimensionPixelSize(R.dimen.i2);
        t.g gVar = new t.g();
        this.Pls = gVar;
        this.Plr = gVar;
        t.f fVar = new t.f(aVar);
        this.Plu = fVar;
        this.Plt = fVar;
        l lVar = new l(aVar.Pwc.getContext());
        this.Plw = lVar;
        this.Plv = lVar;
        ac acVar = new ac(aVar);
        this.Ply = acVar;
        this.Plx = acVar;
        c cVar = new c(aVar);
        this.PlA = cVar;
        this.Plz = cVar;
        this.ptq = new ag(aVar);
        gpB();
        AppMethodBeat.o(34989);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final int getCount() {
        AppMethodBeat.i(34990);
        int size = this.PlE.size();
        AppMethodBeat.o(34990);
        return size;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(34991);
        int cS = br.cS(amt(i2));
        AppMethodBeat.o(34991);
        return cS;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(34992);
        int gUk = br.gUk();
        AppMethodBeat.o(34992);
        return gUk;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final SparseArray<ca> gOq() {
        return this.PlE;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        boolean z;
        boolean z2;
        c.a aVar;
        AppMethodBeat.i(34993);
        ca amt = amt(i2);
        Log.i("MicroMsg.ChattingDataAdapter", "[getView] position:" + i2 + " msgId:" + amt.field_msgId + " svrId:" + amt.field_msgSvrId + " type:" + amt.getType() + " send:" + amt.field_isSend + " talker:" + amt.field_talker + " msgSep:" + amt.field_msgSeq + " time:" + amt.field_createTime);
        if (i2 == 0) {
            com.tencent.mm.ui.chatting.e.a aVar2 = this.OIz;
            Log.i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
            aVar2.Pwd.gOe();
        }
        if (i2 != 0 && this.PlG.get(i2) == 0) {
            long j2 = amt(i2 - 1).field_createTime;
            long j3 = amt.field_createTime;
            boolean z3 = j3 - j2 < Util.MILLSECONDS_OF_MINUTE;
            boolean z4 = (j3 - j2) / 180000 < 1;
            if (z3 || z4) {
                this.PlG.put(i2, 2);
            } else {
                this.PlG.put(i2, 1);
            }
        }
        if ((this.PlG.get(i2) == 1 || i2 == 0 || this.PlF.contains(Long.valueOf(amt.field_msgId))) && amt.field_createTime > 1000) {
            z = true;
        } else {
            z = false;
        }
        if (amt.field_msgId == this.PlH) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (v.bew().Pp(this.OIz.getTalkerUserName()) == null) {
            bg.aVF();
            ((Integer) com.tencent.mm.model.c.azQ().get(12311, (Object) -2)).intValue();
        }
        if (view == null) {
            com.tencent.mm.ui.chatting.viewitems.c cR = br.cR(amt);
            view = cR.a(this.kgB, view);
            c.a aVar3 = (c.a) view.getTag();
            aVar3.setChattingItem(cR);
            aVar = aVar3;
        } else {
            aVar = (c.a) view.getTag();
        }
        Log.d("MicroMsg.ChattingDataAdapter", "dealItemView() ChattingItem:%s", aVar.chattingItem);
        if (z) {
            aVar.timeTV.setVisibility(0);
            aVar.timeTV.setText(f.c(this.OIz.Pwc.getContext(), amt.field_createTime, false));
            if (aVar.timeTV.getTextSize() > ((float) com.tencent.mm.cb.a.fromDPToPix((Context) this.OIz.Pwc.getContext(), 25))) {
                Log.e("MicroMsg.ChattingDataAdapter", "WDF!!! TextSize:%s", Float.valueOf(aVar.timeTV.getTextSize()));
            }
        } else {
            aVar.timeTV.setVisibility(8);
        }
        if (aVar.historyMsgTip != null) {
            if (z2) {
                aVar.historyMsgTip.setVisibility(0);
            } else {
                aVar.historyMsgTip.setVisibility(8);
            }
        }
        if (this.PlI == -1) {
            ca aEy = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEy(this.OIz.getTalkerUserName());
            if (aEy != null) {
                this.PlI = aEy.field_msgId;
            } else {
                this.PlI = 0;
            }
        }
        if (aVar.noMoreMsgTip != null) {
            if (!this.PlN || amt.field_msgId != this.PlI) {
                aVar.noMoreMsgTip.setVisibility(8);
            } else {
                aVar.noMoreMsgTip.setVisibility(0);
            }
        }
        com.tencent.mm.ui.chatting.viewitems.c cVar = aVar.chattingItem;
        aVar.playingMsgId = null;
        com.tencent.mm.ay.f bef = com.tencent.mm.ay.a.bef();
        if (bef != null && bef.jeV != null && bef.jeT == 0 && com.tencent.mm.ay.a.bec()) {
            aVar.playingMsgId = bef.jeV;
        }
        cVar.a(aVar, i2, this.OIz, amt);
        com.tencent.mm.pluginsdk.ui.f gPr = ((com.tencent.mm.ui.chatting.d.b.c) this.OIz.bh(com.tencent.mm.ui.chatting.d.b.c.class)).gPr();
        if (aVar.timeTV.getVisibility() == 0 && gPr != null) {
            aVar.timeTV.setTextColor(gPr.Kbq);
            if (gPr.Kbr) {
                aVar.timeTV.setShadowLayer(2.0f, 1.2f, 1.2f, gPr.Kbs);
            } else {
                aVar.timeTV.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if (gPr.Kbt) {
                if (gPr.Kbu) {
                    aVar.timeTV.setBackgroundResource(R.drawable.ms);
                } else {
                    aVar.timeTV.setBackgroundResource(R.drawable.mr);
                }
                aVar.timeTV.setPadding(this.PlD, this.PlC, this.PlD, this.PlC);
            } else {
                aVar.timeTV.setBackgroundColor(0);
            }
        }
        if (!(aVar.userTV == null || aVar.userTV.getVisibility() != 0 || gPr == null || this.OIz.getTalkerUserName().equals("qqmail") || amt.getType() == 318767153)) {
            if (gPr.Kbu) {
                aVar.userTV.setTextColor(-1);
                aVar.userTV.setShadowLayer((float) com.tencent.mm.cb.a.fromDPToPix(aVar.userTV.getContext(), 2), 0.0f, (float) com.tencent.mm.cb.a.fromDPToPix(aVar.userTV.getContext(), 1), this.OIz.Pwc.getMMResources().getColor(R.color.BW_0_Alpha_0_5));
            } else {
                aVar.userTV.setTextColor(gPr.Kbq);
                aVar.userTV.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
        if (aVar.maskView != null) {
            aVar.maskView.setTag(Long.valueOf(amt.field_msgId));
        }
        if ((!this.PlM || !bS(amt)) && !this.PlO) {
            aVar.showEditView(false);
        } else {
            if (aVar.checkBox != null) {
                aVar.checkBox.setChecked(this.PlJ.contains(Long.valueOf(amt.field_msgId)));
            }
            if (aVar.maskView != null) {
                aVar.maskView.setOnClickListener(this.PlB);
            }
            aVar.showEditView(true);
        }
        if (!this.PlM || !this.CXr || this.PlJ.contains(Long.valueOf(amt.field_msgId))) {
            view.setAlpha(1.0f);
        } else {
            view.setAlpha(0.5f);
        }
        Iterator<Map.Entry<Long, WeakReference<View>>> it = this.PlL.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Long, WeakReference<View>> next = it.next();
            if (next.getValue() != null && next.getValue().get() == view) {
                this.PlL.remove(next.getKey());
                this.PlK.remove(next.getKey());
                break;
            }
        }
        this.PlL.put(Long.valueOf(amt.field_msgId), new WeakReference<>(view));
        if (amt.gAz()) {
            this.PlK.put(Long.valueOf(amt.field_msgId), Integer.valueOf(amt.field_isSend));
        }
        AppMethodBeat.o(34993);
        return view;
    }

    private static boolean bS(ca caVar) {
        AppMethodBeat.i(232954);
        if (caVar.gDm() || caVar.gDp() || caVar.gDw()) {
            AppMethodBeat.o(232954);
            return false;
        }
        AppMethodBeat.o(232954);
        return true;
    }

    private void gOr() {
        AppMethodBeat.i(34994);
        Log.d("MicroMsg.ChattingDataAdapter", "disable clickListener");
        this.Plr = null;
        this.Plt = null;
        this.Plv = null;
        this.Plx = null;
        this.Plz = null;
        AppMethodBeat.o(34994);
    }

    public final void resume() {
        AppMethodBeat.i(34995);
        this.dlW = true;
        Log.i("MicroMsg.ChattingDataAdapter", "adapter resume");
        bg.aVF();
        com.tencent.mm.model.c.aSQ().a(this.AHZ, Looper.getMainLooper());
        com.tencent.mm.pluginsdk.ui.span.l.a(this.ptq);
        this.PlP.startTimer(300000);
        if (this.PlQ != null) {
            this.PlQ.a(d.a.ACTION_UPDATE, false, (Bundle) null);
        }
        AppMethodBeat.o(34995);
    }

    public final void pause() {
        AppMethodBeat.i(34996);
        this.dlW = false;
        bg.aVF();
        com.tencent.mm.model.c.aSQ().a(this.AHZ);
        com.tencent.mm.pluginsdk.ui.span.l.b(this.ptq);
        Log.i("MicroMsg.ChattingDataAdapter", "adapter pause");
        this.PlP.stopTimer();
        AppMethodBeat.o(34996);
    }

    @Override // com.tencent.mm.pluginsdk.model.app.k.a
    public final void gmY() {
        AppMethodBeat.i(34997);
        com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable() {
            /* class com.tencent.mm.ui.chatting.a.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(34985);
                a.this.notifyDataSetChanged();
                AppMethodBeat.o(34985);
            }
        });
        AppMethodBeat.o(34997);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final int cZm() {
        AppMethodBeat.i(34998);
        if (-1 == this.cSs) {
            bg.aVF();
            this.cSs = com.tencent.mm.model.c.aSQ().aEM(this.OIz.getTalkerUserName());
        }
        int i2 = this.cSs;
        AppMethodBeat.o(34998);
        return i2;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final ca amt(int i2) {
        AppMethodBeat.i(34999);
        ca caVar = this.PlE.get(i2);
        AppMethodBeat.o(34999);
        return caVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011b  */
    @Override // com.tencent.mm.ui.chatting.d.b.k
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean Nu(long r12) {
        /*
        // Method dump skipped, instructions count: 290
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.a.a.Nu(long):boolean");
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final boolean bT(ca caVar) {
        AppMethodBeat.i(232955);
        if (caVar == null || !bS(caVar)) {
            AppMethodBeat.o(232955);
            return false;
        }
        AppMethodBeat.o(232955);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final int eGR() {
        AppMethodBeat.i(35001);
        int size = this.PlJ.size();
        AppMethodBeat.o(35001);
        return size;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final Set<Long> gOs() {
        return this.PlJ;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void gOt() {
        AppMethodBeat.i(35002);
        if (this.PlJ != null) {
            this.PlJ.clear();
        }
        AppMethodBeat.o(35002);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void cVM() {
        AppMethodBeat.i(35003);
        this.PlM = false;
        notifyDataSetChanged();
        Log.d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
        this.Plr = this.Pls;
        this.Plt = this.Plu;
        this.Plv = this.Plw;
        this.Plx = this.Ply;
        this.Plz = this.PlA;
        AppMethodBeat.o(35003);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void gOu() {
        AppMethodBeat.i(35004);
        this.PlM = true;
        notifyDataSetChanged();
        gOr();
        AppMethodBeat.o(35004);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void gOv() {
        this.PlN = true;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void uo(boolean z) {
        AppMethodBeat.i(232956);
        if (this.CXr != z) {
            this.CXr = z;
            notifyDataSetChanged();
        }
        AppMethodBeat.o(232956);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final boolean isInEditMode() {
        return this.PlM;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void i(View.OnClickListener onClickListener) {
        this.PlB = onClickListener;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(35005);
        super.notifyDataSetChanged();
        this.PlG.clear();
        AppMethodBeat.o(35005);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void gOw() {
        AppMethodBeat.i(35006);
        if (this.PlR) {
            this.PlS++;
            Log.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.PlS);
            AppMethodBeat.o(35006);
        } else if (!this.dlW) {
            Log.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
            AppMethodBeat.o(35006);
        } else {
            this.PlQ.a(d.a.ACTION_UPDATE, false, (Bundle) null);
            AppMethodBeat.o(35006);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final View zh(long j2) {
        View view;
        AppMethodBeat.i(232957);
        if (!this.PlL.containsKey(Long.valueOf(j2))) {
            Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(j2)));
            AppMethodBeat.o(232957);
            return null;
        }
        WeakReference<View> weakReference = this.PlL.get(Long.valueOf(j2));
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            AppMethodBeat.o(232957);
            return view;
        }
        AppMethodBeat.o(232957);
        return null;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void amu(int i2) {
        boolean z = false;
        AppMethodBeat.i(35007);
        ca amt = amt(i2);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        if (amt == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.i("MicroMsg.ChattingDataAdapter", "[setShowHistoryMsgTipId] pos:%s msg is null? %s", objArr);
        if (!(amt == null || amt.field_msgId == 0)) {
            this.PlH = amt.field_msgId;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(35007);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void a(long j2, boolean z, d.a aVar) {
        AppMethodBeat.i(35008);
        Log.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] messageId:%s loadAllBottomMsg:%s mode:%s", Long.valueOf(j2), Boolean.valueOf(z), aVar);
        Bundle bundle = new Bundle();
        bundle.putLong("MSG_ID", j2);
        bundle.putInt("SCENE", 1);
        bundle.putBoolean("IS_LOAD_ALL", z);
        this.PlQ.a(aVar, true, bundle);
        AppMethodBeat.o(35008);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void a(int i2, d.a aVar) {
        AppMethodBeat.i(35009);
        Log.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", Integer.valueOf(i2), aVar);
        Bundle bundle = new Bundle();
        bundle.putInt("MSG_POSITION", i2);
        bundle.putInt("SCENE", 2);
        this.PlQ.a(aVar, false, bundle);
        AppMethodBeat.o(35009);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void gOx() {
        AppMethodBeat.i(35010);
        Log.i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", Boolean.valueOf(this.PlR), Integer.valueOf(this.PlS));
        if (this.PlR) {
            AppMethodBeat.o(35010);
            return;
        }
        this.PlR = true;
        this.PlS = 0;
        AppMethodBeat.o(35010);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void gOy() {
        AppMethodBeat.i(35011);
        Log.i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", Boolean.valueOf(this.PlR), Integer.valueOf(this.PlS));
        if (!this.PlR) {
            AppMethodBeat.o(35011);
            return;
        }
        this.PlR = false;
        if (this.PlS > 0) {
            this.PlQ.a(d.a.ACTION_UPDATE, false, (Bundle) null);
        }
        this.PlS = 0;
        AppMethodBeat.o(35011);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void s(long j2, int i2, int i3) {
        AppMethodBeat.i(35012);
        if (!this.PlL.containsKey(Long.valueOf(j2)) || !this.PlK.containsKey(Long.valueOf(j2))) {
            Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(j2)));
            AppMethodBeat.o(35012);
            return;
        }
        WeakReference<View> weakReference = this.PlL.get(Long.valueOf(j2));
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            av.b.a((c.a) view.getTag(), i2, i3);
        }
        AppMethodBeat.o(35012);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void Q(long j2, boolean z) {
        AppMethodBeat.i(35013);
        if (!this.PlL.containsKey(Long.valueOf(j2)) || !this.PlK.containsKey(Long.valueOf(j2))) {
            Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(j2)));
            AppMethodBeat.o(35013);
            return;
        }
        WeakReference<View> weakReference = this.PlL.get(Long.valueOf(j2));
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            av.b.c((c.a) view.getTag(), z);
        }
        AppMethodBeat.o(35013);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void a(long j2, ca caVar, boolean z) {
        AppMethodBeat.i(35014);
        if (!this.PlL.containsKey(Long.valueOf(j2)) || !this.PlK.containsKey(Long.valueOf(j2))) {
            Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(j2)));
            AppMethodBeat.o(35014);
            return;
        }
        WeakReference<View> weakReference = this.PlL.get(Long.valueOf(j2));
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            av.a.a(this.OIz.Pwc.getContext(), (c.a) view.getTag(), caVar, z);
        }
        AppMethodBeat.o(35014);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void amv(int i2) {
        AppMethodBeat.i(35015);
        ca amt = amt(i2);
        if (!(amt == null || amt.field_msgId == 0)) {
            this.PlF.add(Long.valueOf(amt.field_msgId));
        }
        AppMethodBeat.o(35015);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final void gOz() {
        AppMethodBeat.i(35016);
        this.PlO = true;
        gOr();
        AppMethodBeat.o(35016);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final t.a gOA() {
        return this.PlT;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final t.f gOB() {
        return this.Plt;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final t.g gOC() {
        return this.Plr;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final ac gOD() {
        return this.Plx;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final l gOE() {
        return this.Plv;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final com.tencent.mm.ui.chatting.c gOF() {
        return this.Plz;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final long gOG() {
        AppMethodBeat.i(35017);
        if (this.PlU != -1) {
            long j2 = this.PlU;
            AppMethodBeat.o(35017);
            return j2;
        }
        this.PlU = 0;
        int count = getCount() - 1;
        while (true) {
            if (count < 0) {
                break;
            }
            ca amt = amt(count);
            if (amt.field_isSend == 1 && (amt.fqJ & 4) != 4) {
                this.PlU = amt.field_msgId;
                break;
            }
            count--;
        }
        long j3 = this.PlU;
        AppMethodBeat.o(35017);
        return j3;
    }

    private void gpB() {
        AppMethodBeat.i(35018);
        if (this.gzE == null) {
            c.a aVar = new c.a();
            aVar.prefixPath = e.NN(this.OIz.getTalkerUserName());
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.jbq = R.raw.default_avatar;
            try {
                this.gzE = aVar.bdv();
                AppMethodBeat.o(35018);
                return;
            } catch (NullPointerException e2) {
                Log.printErrStackTrace("MicroMsg.ChattingDataAdapter", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(35018);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.k
    public final com.tencent.mm.av.a.a.c gOH() {
        AppMethodBeat.i(35019);
        if (this.gzE == null) {
            gpB();
        }
        com.tencent.mm.av.a.a.c cVar = this.gzE;
        AppMethodBeat.o(35019);
        return cVar;
    }

    public final ca amw(int i2) {
        AppMethodBeat.i(161523);
        int i3 = i2 - 1;
        if (this.PlE == null || i3 < 0 || i3 >= this.PlE.size()) {
            AppMethodBeat.o(161523);
            return null;
        }
        ca caVar = this.PlE.get(i3);
        AppMethodBeat.o(161523);
        return caVar;
    }

    public final void fc(int i2, int i3) {
        String str;
        k.b aD;
        com.tencent.mm.ui.chatting.viewitems.c cR;
        String a2;
        String str2;
        int i4;
        AppMethodBeat.i(35020);
        if (this.OIz == null) {
            AppMethodBeat.o(35020);
            return;
        }
        as asVar = this.OIz.GUe;
        if (asVar == null) {
            AppMethodBeat.o(35020);
            return;
        }
        LinkedList linkedList = new LinkedList();
        boolean cle = ((b) g.af(b.class)).cle();
        if (asVar.gBM()) {
            ArrayList arrayList = new ArrayList();
            while (i2 <= i3) {
                ca amw = amw(i2);
                if (amw != null && amw.getType() == 285212721) {
                    Log.v("MicroMsg.ChattingDataAdapter", "terry checkpreload:" + amw.field_msgId);
                    arrayList.add(new String[]{String.valueOf(amw.field_msgId), amw.field_content, "-1"});
                    q qVar = new q();
                    qVar.msgId = amw.field_msgId;
                    qVar.iAc = amw.field_content;
                    if (cle) {
                        linkedList.add(qVar);
                    }
                }
                i2++;
            }
            if (arrayList.size() > 0) {
                ((b) g.af(b.class)).k(arrayList, 0);
                if (cle) {
                    ((b) g.af(b.class)).l(linkedList, 0);
                }
            }
            AppMethodBeat.o(35020);
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        while (i2 <= i3) {
            ca amw2 = amw(i2);
            if (!(amw2 == null || (amw2.getType() & 49) == 0 || (str = amw2.field_content) == null || (aD = k.b.aD(str, amw2.field_reserved)) == null || TextUtils.isEmpty(aD.url) || !aD.url.contains(WeChatHosts.domainString(R.string.e20)) || (cR = br.cR(amw2)) == null || (a2 = cR.a(this.OIz, amw2)) == null || (str2 = asVar.field_username) == null)) {
                int aJ = com.tencent.mm.model.ac.aJ(a2, this.OIz.getTalkerUserName());
                com.tencent.mm.ag.e eVar = (com.tencent.mm.ag.e) aD.as(com.tencent.mm.ag.e.class);
                if (eVar != null) {
                    i4 = eVar.iwc;
                } else {
                    i4 = -1;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(aD.url);
                arrayList2.add(String.valueOf(i4));
                arrayList2.add(String.valueOf(amw2.field_msgSvrId));
                arrayList2.add(str2);
                arrayList2.add(String.valueOf(aJ));
                arrayList2.add(a2);
                arrayList2.add(String.valueOf(amw2.field_createTime));
                arrayList2.add(String.valueOf(((b) g.af(b.class)).ahy(str2)));
                linkedList2.add(arrayList2);
            }
            i2++;
        }
        if (linkedList2.size() > 0) {
            ((b) g.af(b.class)).j(linkedList2, 1);
        }
        AppMethodBeat.o(35020);
    }
}
