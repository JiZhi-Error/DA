package com.tencent.mm.ui.chatting.d;

import android.graphics.Rect;
import android.os.Vibrator;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.viewitems.ad;
import com.tencent.mm.ui.chatting.viewitems.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@a(gRF = ah.class)
public class n extends a implements ah {
    private Set<Long> Pol = new HashSet();
    private Map<Long, czg> Pom = new HashMap();
    private Animation Pon = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.x);
    private Vibrator paT = ((Vibrator) MMApplicationContext.getContext().getSystemService("vibrator"));

    public n() {
        AppMethodBeat.i(233077);
        AppMethodBeat.o(233077);
    }

    static /* synthetic */ czg b(czg czg, czg czg2) {
        AppMethodBeat.i(233086);
        czg a2 = a(czg, czg2);
        AppMethodBeat.o(233086);
        return a2;
    }

    @Override // com.tencent.mm.ui.chatting.d.ah
    public final boolean Nv(long j2) {
        AppMethodBeat.i(233078);
        boolean contains = this.Pol.contains(Long.valueOf(j2));
        AppMethodBeat.o(233078);
        return contains;
    }

    @Override // com.tencent.mm.ui.chatting.d.ah
    public final void Nw(long j2) {
        AppMethodBeat.i(233079);
        this.Pol.add(Long.valueOf(j2));
        AppMethodBeat.o(233079);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void a(com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(233080);
        super.a(aVar);
        AppMethodBeat.o(233080);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(233081);
        super.gOK();
        AppMethodBeat.o(233081);
    }

    @Override // com.tencent.mm.ui.l
    public final void onFinish() {
        AppMethodBeat.i(233082);
        super.onFinish();
        Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "onFinish");
        this.Pol.clear();
        ((PluginPatMsg) g.ah(PluginPatMsg.class)).clearTemplate();
        if (!this.Pom.isEmpty()) {
            Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "updatedPatMsg id: %s", this.Pom.keySet());
            final HashMap hashMap = new HashMap(this.Pom);
            this.Pom.clear();
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.n.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(233076);
                    for (Long l : hashMap.keySet()) {
                        long longValue = l.longValue();
                        ca Hb = ((l) g.af(l.class)).eiy().Hb(longValue);
                        if (Hb.field_msgId == longValue) {
                            Hb.setContent(((b) g.af(b.class)).a(n.b((czg) hashMap.get(Long.valueOf(longValue)), ((b) g.af(b.class)).aJJ(Hb.field_content))));
                            Hb.setType(922746929);
                            ((l) g.af(l.class)).eiy().a(longValue, Hb);
                        }
                    }
                    hashMap.clear();
                    AppMethodBeat.o(233076);
                }
            }, "updatePatMsgWhenExitChatting");
        }
        AppMethodBeat.o(233082);
    }

    private static czg a(czg czg, czg czg2) {
        AppMethodBeat.i(233083);
        czg czg3 = new czg();
        int min = Math.min(czg2.yVw.size(), czg.yVw.size());
        czg3.gnh = czg.gnh;
        for (int i2 = 0; i2 < min; i2++) {
            czg3.yVw.add(czg2.yVw.get(i2));
            czg3.yVw.get(i2).MEB = czg.yVw.get(i2).MEB;
        }
        if (czg2.yVw.size() >= czg.yVw.size()) {
            for (int i3 = min; i3 < czg2.yVw.size(); i3++) {
                czg3.yVw.add(czg2.yVw.get(i3));
            }
        } else {
            Log.w("MicroMsg.ChattingPatMsgUpdateComponent", "db record list %d, updated record list %d", Integer.valueOf(czg2.yVw.size()), Integer.valueOf(czg.yVw.size()));
        }
        AppMethodBeat.o(233083);
        return czg3;
    }

    private static Pair<Integer, Integer> O(ViewGroup viewGroup) {
        AppMethodBeat.i(233084);
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            Rect rect = new Rect();
            childAt.getLocalVisibleRect(rect);
            if (rect.height() > 0) {
                if (i4 < i2) {
                    i2 = i4;
                }
                if (i4 > i3) {
                    i3 = i4;
                }
            }
        }
        Pair<Integer, Integer> create = Pair.create(Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(233084);
        return create;
    }

    @Override // com.tencent.mm.ui.l
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        czg czg;
        czg czg2;
        AppMethodBeat.i(233085);
        Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "onScroll, headerCount:%d, firstVisible:%d, lastVisible:%d", Integer.valueOf(this.dom.getHeaderViewsCount()), Integer.valueOf(i2), Integer.valueOf((i2 + i3) - 1));
        long currentTicks = Util.currentTicks();
        try {
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            String aTY = z.aTY();
            ca aEx = ((l) g.af(l.class)).eiy().aEx(this.dom.getTalkerUserName());
            for (int i5 = 0; i5 < i3; i5++) {
                View childAt = this.dom.getChildAt(i5);
                if (!(childAt == null || childAt.getTag() == null)) {
                    if (childAt.getTag() instanceof ad.a) {
                        long currentTicks2 = Util.currentTicks();
                        ad.a aVar = (ad.a) childAt.getTag();
                        long longValue = ((Long) aVar.PLB.getTag()).longValue();
                        Pair<Integer, Integer> O = O(aVar.xUE);
                        Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d, line %d-%d", Long.valueOf(longValue), O.first, O.second);
                        ca Hb = ((l) g.af(l.class)).eiy().Hb(longValue);
                        Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item1 %d ms", Long.valueOf(longValue), Long.valueOf(Util.ticksToNow(currentTicks2)));
                        long currentTicks3 = Util.currentTicks();
                        czg czg3 = this.Pom.get(Long.valueOf(longValue));
                        if (czg3 == null) {
                            czg = ((b) g.af(b.class)).aJJ(Hb.field_content);
                        } else {
                            czg = czg3;
                        }
                        if (longValue == aEx.field_msgId) {
                            Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "merge last pat msg %d", Long.valueOf(longValue));
                            czg2 = a(czg, ((b) g.af(b.class)).aJJ(aEx.field_content));
                        } else if (((b) g.af(b.class)).HD(longValue)) {
                            Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", Long.valueOf(longValue), Long.valueOf(Util.ticksToNow(currentTicks3)));
                        } else {
                            czg2 = czg;
                        }
                        Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item2 %d ms", Long.valueOf(longValue), Long.valueOf(Util.ticksToNow(currentTicks3)));
                        long currentTicks4 = Util.currentTicks();
                        if (((Integer) O.first).intValue() <= ((Integer) O.second).intValue()) {
                            for (int intValue = ((Integer) O.first).intValue(); intValue <= ((Integer) O.second).intValue(); intValue++) {
                                Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d mark record %d read", Long.valueOf(Hb.field_msgId), Integer.valueOf(intValue));
                                if (intValue >= 0 && intValue < czg2.yVw.size()) {
                                    if (!aTY.equals(czg2.yVw.get(intValue).dRL) && aTY.equals(czg2.yVw.get(intValue).MEA) && czg2.yVw.get(intValue).MEB == 0 && !hashMap.containsKey(Integer.valueOf(i5))) {
                                        hashMap.put(Integer.valueOf(i5), -1);
                                    }
                                    czg2.yVw.get(intValue).MEB = 1;
                                }
                            }
                        }
                        Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "msg %d handle scroll cost item3 %d ms", Long.valueOf(longValue), Long.valueOf(Util.ticksToNow(currentTicks4)));
                        this.Pom.put(Long.valueOf(Hb.field_msgId), czg2);
                    } else if ((childAt.getTag() instanceof c.a) && ((c.a) childAt.getTag()).chattingItem.gTT()) {
                        hashSet.add(Integer.valueOf(i5));
                    }
                }
            }
            Log.d("MicroMsg.ChattingPatMsgUpdateComponent", "handle scroll cost %d ms", Long.valueOf(Util.ticksToNow(currentTicks)));
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                for (Integer num : hashMap.keySet()) {
                    int intValue3 = num.intValue();
                    int intValue4 = ((Integer) hashMap.get(Integer.valueOf(intValue3))).intValue();
                    if (intValue4 == -1) {
                        hashMap.put(Integer.valueOf(intValue3), Integer.valueOf(intValue2));
                    } else if (Math.abs(intValue3 - intValue2) < Math.abs(intValue3 - intValue4)) {
                        hashMap.put(Integer.valueOf(intValue3), Integer.valueOf(intValue2));
                    }
                }
            }
            HashSet hashSet2 = new HashSet(hashMap.values());
            Log.i("MicroMsg.ChattingPatMsgUpdateComponent", "%s are going to shake", hashSet2);
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                int intValue5 = ((Integer) it2.next()).intValue();
                if (intValue5 >= 0) {
                    c.a aVar2 = (c.a) this.dom.getChildAt(intValue5).getTag();
                    if (aVar2.avatarIV.getAnimation() == null || aVar2.avatarIV.getAnimation().hasEnded()) {
                        aVar2.avatarIV.startAnimation(this.Pon);
                        if (!com.tencent.mm.n.g.Er(this.dom.getTalkerUserName())) {
                            this.paT.vibrate(10);
                        }
                    }
                }
            }
            hashMap.clear();
            AppMethodBeat.o(233085);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ChattingPatMsgUpdateComponent", e2, "", new Object[0]);
            AppMethodBeat.o(233085);
        }
    }
}
