package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.model.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.conversation.a.j;
import com.tencent.mm.ui.conversation.a.r;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class a implements e.a, bc, MStorageEx.IOnStorageChange {
    p FPE;
    List<b> QaV = new LinkedList();
    List<b> QaW = new LinkedList();
    List<b> QaX = new LinkedList();
    List<b> QaY = new LinkedList();
    List<b> QaZ = new LinkedList();
    List<b> Qba = new LinkedList();
    IListener Qbb;
    IListener Qbc;
    ListView Qbd;
    private View Qbe;
    boolean Qbf = false;
    Context context;

    public a() {
        AppMethodBeat.i(38152);
        AppMethodBeat.o(38152);
    }

    public final void a(Context context2, ListView listView, View view) {
        AppMethodBeat.i(38153);
        this.context = context2;
        this.Qbd = listView;
        this.Qbe = view;
        this.Qbc = new IListener<al>() {
            /* class com.tencent.mm.ui.conversation.a.AnonymousClass1 */

            {
                AppMethodBeat.i(161554);
                this.__eventId = al.class.getName().hashCode();
                AppMethodBeat.o(161554);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(al alVar) {
                AppMethodBeat.i(38146);
                al alVar2 = alVar;
                b bVar = alVar2.dDm.dDn;
                if (bVar != null && bVar.getView() != null) {
                    Log.i("MicroMsg.BannerHelper", "now add banner:%s, hc:%d", bVar, Integer.valueOf(a.this.hashCode()));
                    if (!alVar2.dDm.independent) {
                        switch (alVar2.dDm.level) {
                            case 1:
                                a.this.QaW.add(bVar);
                                break;
                            case 2:
                                a.this.QaX.add(bVar);
                                break;
                            default:
                                a.this.QaY.add(bVar);
                                break;
                        }
                    } else {
                        a.this.QaV.add(bVar);
                    }
                } else {
                    Log.w("MicroMsg.BannerHelper", "banner is null, event:%s", alVar2);
                }
                AppMethodBeat.o(38146);
                return false;
            }
        };
        EventCenter.instance.addListener(this.Qbc);
        ak akVar = new ak();
        akVar.dDl.activity = (Activity) context2;
        EventCenter.instance.publish(akVar);
        al alVar = new al();
        alVar.dDm.dDn = (b) com.tencent.mm.ui.conversation.a.e.a(this.context, e.a.MAIN_FRAME_AND_ABTEST_BANNER, null);
        EventCenter.instance.publish(alVar);
        al alVar2 = new al();
        alVar2.dDm.dDn = (b) com.tencent.mm.ui.conversation.a.e.a(this.context, e.a.NET_WARN_BANNER, null);
        alVar2.dDm.level = 1;
        EventCenter.instance.publish(alVar2);
        al alVar3 = new al();
        alVar3.dDm.dDn = (b) com.tencent.mm.ui.conversation.a.e.a(this.context, e.a.STORAGE_PERMISSION_BANNER, null);
        alVar3.dDm.level = 1;
        EventCenter.instance.publish(alVar3);
        al alVar4 = new al();
        alVar4.dDm.dDn = (b) com.tencent.mm.ui.conversation.a.e.a(this.context, e.a.OTHER_ONLINE_BANNER, null);
        alVar4.dDm.independent = false;
        alVar4.dDm.level = 1;
        EventCenter.instance.publish(alVar4);
        al alVar5 = new al();
        alVar5.dDm.dDn = (r) com.tencent.mm.ui.conversation.a.e.a(this.context, e.a.TRY_NEW_INIT_BANNER, null);
        alVar5.dDm.independent = false;
        alVar5.dDm.level = 2;
        EventCenter.instance.publish(alVar5);
        al alVar6 = new al();
        alVar6.dDm.dDn = (com.tencent.mm.ui.conversation.a.a) com.tencent.mm.ui.conversation.a.e.a(this.context, e.a.AD_BANNER, null);
        alVar6.dDm.independent = false;
        alVar6.dDm.level = 3;
        EventCenter.instance.publish(alVar6);
        Context context3 = this.context;
        e.a aVar = e.a.CHATTING_MONITORED_HINT;
        Object[] objArr = {b.EnumC0443b.Main};
        al alVar7 = new al();
        alVar7.dDm.dDn = (com.tencent.mm.ui.d.a) com.tencent.mm.ui.conversation.a.e.a(context3, aVar, objArr);
        alVar7.dDm.independent = true;
        EventCenter.instance.publish(alVar7);
        EventCenter.instance.removeListener(this.Qbc);
        this.Qba.addAll(this.QaV);
        this.Qba.addAll(this.QaW);
        this.Qba.addAll(this.QaX);
        this.Qba.addAll(this.QaY);
        Collections.sort(this.Qba, new Comparator<com.tencent.mm.pluginsdk.ui.b.b>() {
            /* class com.tencent.mm.ui.conversation.a.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(com.tencent.mm.pluginsdk.ui.b.b bVar, com.tencent.mm.pluginsdk.ui.b.b bVar2) {
                AppMethodBeat.i(38147);
                int order = bVar2.getOrder() - bVar.getOrder();
                AppMethodBeat.o(38147);
                return order;
            }
        });
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : this.Qba) {
            this.Qbd.addHeaderView(bVar.getView());
        }
        new LinkedList();
        com.tencent.mm.pluginsdk.ui.b.b bVar2 = (com.tencent.mm.pluginsdk.ui.b.b) com.tencent.mm.ui.conversation.a.e.a(context2, e.a.FACEBOOK_BANNER, null);
        if (!(bVar2 == null || bVar2.getView() == null)) {
            listView.addFooterView(bVar2.getView());
        }
        this.QaZ.add(bVar2);
        listView.addFooterView(new j(context2).getView(), null, true);
        this.QaZ.add(bVar2);
        this.FPE = new p.a() {
            /* class com.tencent.mm.ui.conversation.a.AnonymousClass3 */
            private final MTimerHandler Qbh = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.ui.conversation.a.AnonymousClass3.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(38148);
                    a.this.gVm();
                    AppMethodBeat.o(38148);
                    return false;
                }
            }, false);

            {
                AppMethodBeat.i(38149);
                AppMethodBeat.o(38149);
            }

            @Override // com.tencent.mm.network.p
            public final void onNetworkChange(int i2) {
                AppMethodBeat.i(38150);
                if (this.Qbh != null) {
                    this.Qbh.startTimer(10);
                }
                AppMethodBeat.o(38150);
            }
        };
        bg.a(this.FPE);
        this.Qbb = new IListener<mg>() {
            /* class com.tencent.mm.ui.conversation.a.AnonymousClass4 */

            {
                AppMethodBeat.i(161555);
                this.__eventId = mg.class.getName().hashCode();
                AppMethodBeat.o(161555);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(mg mgVar) {
                AppMethodBeat.i(38151);
                if (a.this.Qbd.getVisibility() != 0) {
                    a.this.Qbd.setVisibility(0);
                    a.this.Qbe.setVisibility(8);
                }
                AppMethodBeat.o(38151);
                return false;
            }
        };
        EventCenter.instance.addListener(this.Qbb);
        bg.aVF();
        c.a(this);
        gVm();
        AppMethodBeat.o(38153);
    }

    public final void gGx() {
        AppMethodBeat.i(38154);
        Log.i("MicroMsg.BannerHelper", "releaseBanner");
        if (!this.Qbf) {
            AppMethodBeat.o(38154);
            return;
        }
        this.Qbf = false;
        jT(this.QaV);
        jT(this.QaW);
        jT(this.QaX);
        jT(this.QaY);
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : this.QaZ) {
            if (bVar != null) {
                bVar.release();
            }
        }
        if (bg.aAc()) {
            com.tencent.mm.aj.p.aYn().e(this);
        }
        if (bg.aAc()) {
            bg.aVF();
            c.azQ().remove(this);
        }
        AppMethodBeat.o(38154);
    }

    public final void gVm() {
        View childAt;
        AppMethodBeat.i(38155);
        if (this.context == null || !bg.aAc()) {
            AppMethodBeat.o(38155);
            return;
        }
        Log.i("MicroMsg.BannerHelper", "updateBanner, :%d", Integer.valueOf(hashCode()));
        boolean A = A(this.QaV, true);
        boolean A2 = A(this.QaW, true);
        boolean A3 = A(this.QaX, true);
        boolean z = A || A2 || A3 || A(this.QaY, true);
        if (A2) {
            jS(this.QaX);
            jS(this.QaY);
        } else if (A3) {
            jS(this.QaY);
        }
        LinkedList<com.tencent.mm.pluginsdk.ui.b.b> linkedList = new LinkedList();
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : this.Qba) {
            if (!(bVar == null || (childAt = ((ViewGroup) bVar.getView()).getChildAt(0)) == null || childAt.getVisibility() != 0)) {
                bVar.isFirst = false;
                bVar.ifo = false;
                linkedList.add(bVar);
            }
        }
        if (linkedList.size() > 0) {
            ((com.tencent.mm.pluginsdk.ui.b.b) linkedList.getFirst()).isFirst = true;
            ((com.tencent.mm.pluginsdk.ui.b.b) linkedList.getLast()).ifo = true;
            for (com.tencent.mm.pluginsdk.ui.b.b bVar2 : linkedList) {
                bVar2.bYa();
            }
        }
        if (z && this.Qbd.getVisibility() != 0) {
            this.Qbd.setVisibility(0);
            this.Qbe.setVisibility(8);
        }
        for (com.tencent.mm.pluginsdk.ui.b.b bVar3 : this.QaZ) {
            if (bVar3 != null) {
                bVar3.bYa();
            }
        }
        AppMethodBeat.o(38155);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(38156);
        if (bg.aAc() && !bg.azj() && Util.nullAsNil(str).length() > 0 && str.equals(z.aTY())) {
            gVm();
        }
        AppMethodBeat.o(38156);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(38157);
        if (bg.aAc()) {
            bg.aVF();
            if (mStorageEx == c.azQ()) {
                int nullAsInt = Util.nullAsInt(obj, 0);
                if (8193 == nullAsInt) {
                    gVm();
                }
                if (42 == nullAsInt) {
                    gVm();
                }
            }
        }
        AppMethodBeat.o(38157);
    }

    @Override // com.tencent.mm.model.bc
    public final void aVw() {
        AppMethodBeat.i(38158);
        gVm();
        AppMethodBeat.o(38158);
    }

    /* access modifiers changed from: package-private */
    public final void jR(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        AppMethodBeat.i(38159);
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            if (bVar.getView() != null) {
                this.Qbd.removeHeaderView(bVar.getView());
            }
        }
        AppMethodBeat.o(38159);
    }

    /* access modifiers changed from: package-private */
    public final boolean A(List<com.tencent.mm.pluginsdk.ui.b.b> list, boolean z) {
        boolean z2;
        AppMethodBeat.i(38160);
        boolean z3 = false;
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            View childAt = ((ViewGroup) bVar.getView()).getChildAt(0);
            if (bVar.bYa()) {
                Object[] objArr = new Object[4];
                objArr[0] = bVar;
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = Boolean.valueOf(childAt != null && childAt.getVisibility() == 0);
                objArr[3] = Integer.valueOf(hashCode());
                Log.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d", objArr);
                if (!z) {
                    AppMethodBeat.o(38160);
                    return true;
                }
                z2 = true;
            } else {
                if (childAt != null && childAt.getVisibility() == 0) {
                    Log.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", bVar, Boolean.valueOf(z), Integer.valueOf(hashCode()));
                }
                z2 = z3;
            }
            z3 = z2;
        }
        AppMethodBeat.o(38160);
        return z3;
    }

    private static void jS(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        AppMethodBeat.i(38161);
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            bVar.setVisibility(8);
        }
        AppMethodBeat.o(38161);
    }

    private static void jT(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        AppMethodBeat.i(38162);
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            bVar.release();
        }
        AppMethodBeat.o(38162);
    }

    static void jU(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        AppMethodBeat.i(38163);
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            bVar.destroy();
        }
        list.clear();
        AppMethodBeat.o(38163);
    }
}
