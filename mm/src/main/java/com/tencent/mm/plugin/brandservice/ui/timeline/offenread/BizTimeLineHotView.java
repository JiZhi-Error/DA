package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.an;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ehp;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.aa;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BizTimeLineHotView extends LinearLayout implements i, j, MStorageEx.IOnStorageChange {
    private TextView jUu;
    private int omS = 0;
    private float paddingLeft = -1.0f;
    public g pyZ = new g();
    private MessageQueue.IdleHandler pzA = new MessageQueue.IdleHandler() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.AnonymousClass10 */

        public final boolean queueIdle() {
            AppMethodBeat.i(195003);
            Looper.myQueue().removeIdleHandler(BizTimeLineHotView.this.pzA);
            if (BizTimeLineHotView.this.pzq.get() == null || BizTimeLineHotView.this.pzq.get().isFinishing()) {
                AppMethodBeat.o(195003);
            } else {
                BizTimeLineHotView.this.pzr.c(BizTimeLineHotView.this.pzu, true);
                AppMethodBeat.o(195003);
            }
            return false;
        }
    };
    WeakReference<Activity> pzq;
    public BizTimeLineHotListView pzr;
    private TextView pzs;
    private boolean pzt = false;
    private List<c> pzu = new CopyOnWriteArrayList();
    private d pzv;
    private int pzw = 0;
    public IListener pzx = new IListener<an>() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.AnonymousClass4 */

        {
            AppMethodBeat.i(194999);
            this.__eventId = an.class.getName().hashCode();
            AppMethodBeat.o(194999);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(an anVar) {
            AppMethodBeat.i(195000);
            final an anVar2 = anVar;
            if (!(anVar2 == null || anVar2.dDr == null || Util.isNullOrNil(anVar2.dDr.userName) || BizTimeLineHotView.this.pzu == null)) {
                b.a("BrandServiceWorkerThread", new Runnable() {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        c cVar;
                        AppMethodBeat.i(194998);
                        Iterator it = BizTimeLineHotView.this.pzu.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                cVar = null;
                                break;
                            }
                            cVar = (c) it.next();
                            if (anVar2.dDr.userName.equals(cVar.KJV)) {
                                break;
                            }
                        }
                        if (cVar != null) {
                            BizTimeLineHotView.this.pzu.remove(cVar);
                        }
                        BizTimeLineHotView.b(BizTimeLineHotView.this);
                        AppMethodBeat.o(194998);
                    }
                }, 0);
            }
            AppMethodBeat.o(195000);
            return false;
        }
    };
    private float pzy = -1.0f;
    private boolean pzz = true;

    static /* synthetic */ boolean cnq() {
        AppMethodBeat.i(195011);
        boolean cno = cno();
        AppMethodBeat.o(195011);
        return cno;
    }

    public BizTimeLineHotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(6105);
        init(context);
        AppMethodBeat.o(6105);
    }

    public BizTimeLineHotView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(6106);
        init(context);
        AppMethodBeat.o(6106);
    }

    public final void o(z zVar) {
        AppMethodBeat.i(195004);
        p(zVar);
        AppMethodBeat.o(195004);
    }

    public final void p(final z zVar) {
        AppMethodBeat.i(6107);
        if (zVar != null) {
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(6097);
                    z MP = ag.ban().MP((long) zVar.field_talkerId);
                    if (MP != null && MP.field_msgId == zVar.field_msgId) {
                        ((l) g.af(l.class)).aST().bka(zVar.field_talker);
                        BizTimeLineHotView.this.ahQ(zVar.field_talker);
                    }
                    AppMethodBeat.o(6097);
                }
            }, "MicroMsg.BizTimeLineHotList");
        }
        AppMethodBeat.o(6107);
    }

    public final void ahQ(final String str) {
        AppMethodBeat.i(6108);
        b.a("BrandServiceWorkerThread", new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(194997);
                if (BizTimeLineHotView.this.pzu == null) {
                    AppMethodBeat.o(194997);
                } else if (str == null || ab.Js(str)) {
                    AppMethodBeat.o(194997);
                } else {
                    try {
                        Iterator it = BizTimeLineHotView.this.pzu.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            c cVar = (c) it.next();
                            if (str.equals(cVar.KJV)) {
                                if (BizTimeLineHotView.b(cVar)) {
                                    BizTimeLineHotView.a(BizTimeLineHotView.this, cVar);
                                    AppMethodBeat.o(194997);
                                    return;
                                }
                            }
                        }
                        AppMethodBeat.o(194997);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.BizTimeLineHotList", "updateGreenDot ex:%s", e2.getMessage());
                        AppMethodBeat.o(194997);
                    }
                }
            }
        }, 0);
        AppMethodBeat.o(6108);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(6109);
        if (obj == null || !(obj instanceof String)) {
            Log.e("MicroMsg.BizTimeLineHotList", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(6109);
        } else if (this.pzq.get() == null || this.pzq.get().isFinishing()) {
            AppMethodBeat.o(6109);
        } else {
            ahQ((String) obj);
            AppMethodBeat.o(6109);
        }
    }

    public int getItemPadding() {
        AppMethodBeat.i(6110);
        int ew = a.ew(getContext());
        AppMethodBeat.o(6110);
        return ew;
    }

    private void init(Context context) {
        AppMethodBeat.i(6111);
        g.azz().a(2768, this);
        this.pzq = new WeakReference<>((Activity) context);
        a.init(context);
        this.omS = getItemPadding();
        View inflate = aa.jQ(context).inflate(R.layout.jv, this);
        this.pzr = (BizTimeLineHotListView) inflate.findViewById(R.id.a7u);
        this.jUu = (TextView) inflate.findViewById(R.id.a87);
        this.pzs = (TextView) inflate.findViewById(R.id.a88);
        this.pzv = new d(this.omS, context);
        this.pzr.a(this.pzv);
        this.pzr.a(context, this.pzu, this.pyZ, this);
        getLocalOftenReadData();
        getOftenRead();
        ((l) g.af(l.class)).aST().add(this);
        EventCenter.instance.addListener(this.pzx);
        AppMethodBeat.o(6111);
    }

    public void onConfigurationChanged(final Configuration configuration) {
        AppMethodBeat.i(6112);
        super.onConfigurationChanged(configuration);
        if (this.pzq.get() == null) {
            AppMethodBeat.o(6112);
            return;
        }
        final View decorView = this.pzq.get().getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.AnonymousClass5 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(195001);
                decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int itemPadding = BizTimeLineHotView.this.getItemPadding();
                if (!(BizTimeLineHotView.this.pzw == configuration.orientation && BizTimeLineHotView.this.omS == itemPadding)) {
                    if (BizTimeLineHotView.this.pzv != null) {
                        BizTimeLineHotView.this.omS = itemPadding;
                        BizTimeLineHotView.this.pzv.padding = BizTimeLineHotView.this.omS;
                    }
                    BizTimeLineHotView.this.pzw = configuration.orientation;
                    BizTimeLineHotListView bizTimeLineHotListView = BizTimeLineHotView.this.pzr;
                    if (bizTimeLineHotListView.pyW != null) {
                        h hVar = bizTimeLineHotListView.pyW;
                        RecyclerView.LayoutManager layoutManager = hVar.pzW.getLayoutManager();
                        a a2 = c.a(0, new a());
                        com.tencent.mm.hellhoundlib.a.a.a(layoutManager, a2.axQ(), "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
                        layoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(layoutManager, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
                        hVar.mOffsetX = 0;
                        hVar.oDP = 0;
                        hVar.oDQ = 0;
                        hVar.owW = 0;
                    }
                    BizTimeLineHotView.this.pzr.c(BizTimeLineHotView.this.pzu, true);
                }
                AppMethodBeat.o(195001);
            }
        });
        AppMethodBeat.o(6112);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.offenread.j
    public void setOftenReadTitlePaddingLeft(float f2) {
        AppMethodBeat.i(195005);
        if (this.jUu != null) {
            if (this.paddingLeft == f2) {
                AppMethodBeat.o(195005);
                return;
            } else {
                this.paddingLeft = f2;
                this.jUu.setPadding((int) f2, this.jUu.getPaddingTop(), this.jUu.getPaddingRight(), this.jUu.getPaddingBottom());
            }
        }
        AppMethodBeat.o(195005);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.offenread.j
    public void setVideoTitlePaddingLeft(float f2) {
        AppMethodBeat.i(195006);
        if (this.pzs != null) {
            if (this.pzy == f2) {
                AppMethodBeat.o(195006);
                return;
            }
            this.pzy = f2;
            if (this.pzs.getVisibility() != 0) {
                this.pzs.setVisibility(0);
            }
            this.pzs.setPadding((int) f2, this.pzs.getPaddingTop(), this.pzs.getPaddingRight(), this.pzs.getPaddingBottom());
        }
        AppMethodBeat.o(195006);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.offenread.j
    public final void cnn() {
        AppMethodBeat.i(195007);
        if (this.pzs != null && this.pzs.getVisibility() == 0) {
            this.pzs.setVisibility(8);
        }
        AppMethodBeat.o(195007);
    }

    private void getLocalOftenReadData() {
        AppMethodBeat.i(6114);
        if (!Util.isNullOrNil(this.pzu)) {
            AppMethodBeat.o(6114);
            return;
        }
        a(f.cnr());
        AppMethodBeat.o(6114);
    }

    private void getOftenRead() {
        AppMethodBeat.i(6115);
        b.a("BrandServiceWorkerThread", new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(195002);
                BizTimeLineHotView.g(BizTimeLineHotView.this);
                AppMethodBeat.o(195002);
            }
        }, 0);
        AppMethodBeat.o(6115);
    }

    private static boolean cno() {
        AppMethodBeat.i(195008);
        if (!com.tencent.mm.plugin.brandservice.b.c.clu() || com.tencent.mm.plugin.brandservice.b.c.clw() == null) {
            AppMethodBeat.o(195008);
            return false;
        }
        AppMethodBeat.o(195008);
        return true;
    }

    private void a(final ehp ehp) {
        AppMethodBeat.i(6116);
        if (ehp != null) {
            com.tencent.mm.plugin.brandservice.ui.b.a.BR((long) (ehp.Nhg * 1000));
            com.tencent.mm.plugin.brandservice.ui.b.a.BS((long) ehp.Nhe);
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(ehp.Nhd != null ? ehp.Nhd.size() : 0);
            objArr[1] = Integer.valueOf(ehp.Nhf);
            objArr[2] = Integer.valueOf(ehp.Nhe);
            Log.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", objArr);
            if (com.tencent.mm.plugin.brandservice.ui.b.a.DV(4)) {
                setVisibility(8);
                AppMethodBeat.o(6116);
                return;
            }
            if (com.tencent.mm.plugin.biz.b.c.ckt()) {
                ehp.Nhd.clear();
                this.pzu.clear();
            }
            if (!Util.isNullOrNil(ehp.Nhd) || !Util.isNullOrNil(this.pzu) || cno()) {
                h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.AnonymousClass7 */

                    public final void run() {
                        boolean z = false;
                        AppMethodBeat.i(6102);
                        if (!Util.isNullOrNil(ehp.Nhd)) {
                            BizTimeLineHotView.this.pzu = new ArrayList();
                            Iterator<ehs> it = ehp.Nhd.iterator();
                            int i2 = 0;
                            while (it.hasNext()) {
                                ehs next = it.next();
                                i2++;
                                if (i2 > 12) {
                                    break;
                                }
                                c cVar = new c();
                                if (ab.IS(next.KJV)) {
                                    cVar.KJV = next.KJV;
                                    BizTimeLineHotView.this.pzu.add(cVar);
                                }
                            }
                            BizTimeLineHotView.this.cnp();
                            BizTimeLineHotView bizTimeLineHotView = BizTimeLineHotView.this;
                            if (ehp.Nhf == 1) {
                                z = true;
                            }
                            BizTimeLineHotView.a(bizTimeLineHotView, z);
                        }
                        BizTimeLineHotView.b(BizTimeLineHotView.this);
                        AppMethodBeat.o(6102);
                    }
                }, "MicroMsg.BizTimeLineHotList");
                AppMethodBeat.o(6116);
                return;
            }
            setVisibility(8);
            Log.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
            AppMethodBeat.o(6116);
            return;
        }
        AppMethodBeat.o(6116);
    }

    public final void cnp() {
        AppMethodBeat.i(6117);
        if (Util.isNullOrNil(this.pzu)) {
            AppMethodBeat.o(6117);
            return;
        }
        for (c cVar : this.pzu) {
            b(cVar);
        }
        AppMethodBeat.o(6117);
    }

    public static boolean b(c cVar) {
        AppMethodBeat.i(6118);
        long bjM = ((l) g.af(l.class)).aSN().bjM(cVar.KJV);
        z MP = ag.ban().MP(bjM);
        if (MP == null) {
            AppMethodBeat.o(6118);
            return false;
        }
        cVar.oJs = MP.field_createTime;
        az bjY = ((l) g.af(l.class)).aST().bjY(cVar.KJV);
        boolean z = cVar.pzL;
        cVar.pzL = false;
        if (bjY != null && bjY.field_unReadCount > 0 && System.currentTimeMillis() - cVar.oJs < com.tencent.mm.plugin.brandservice.ui.b.a.crd() && bjY.field_unReadCount > ag.bap().Ne(bjM)) {
            cVar.pzL = true;
        }
        if (z != cVar.pzL) {
            AppMethodBeat.o(6118);
            return true;
        }
        AppMethodBeat.o(6118);
        return false;
    }

    public final void cnm() {
        AppMethodBeat.i(6119);
        if (getVisibility() != 0 || (Util.isNullOrNil(this.pzu) && !this.pzr.pyY)) {
            AppMethodBeat.o(6119);
            return;
        }
        this.pzr.cnm();
        AppMethodBeat.o(6119);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(6120);
        Log.i("MicroMsg.BizTimeLineHotList", "onSceneEnd, type %d, errType = %d, errCode = %d", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof k) {
                ehp ehp = (ehp) ((k) qVar).rr.iLL.iLR;
                if (this.pzq.get() != null && this.pzq.get().isFinishing()) {
                    AppMethodBeat.o(6120);
                    return;
                } else if (com.tencent.mm.plugin.brandservice.ui.b.c.b(ehp, f.cnr())) {
                    Log.d("MicroMsg.BizTimeLineHotList", "onSceneEnd nothing change");
                    AppMethodBeat.o(6120);
                    return;
                } else {
                    f.pzR = ehp;
                    try {
                        g.aAh().azQ().set(ar.a.USERINFO_BIZ_TIME_LINE_OFTEN_READ_STRING_SYNC, Base64.encodeToString(ehp.toByteArray(), 0));
                    } catch (IOException e2) {
                        Log.e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", e2.getMessage());
                        g.aAh().azQ().set(ar.a.USERINFO_BIZ_TIME_LINE_OFTEN_READ_STRING_SYNC, "");
                    }
                    a(ehp);
                }
            }
            AppMethodBeat.o(6120);
            return;
        }
        AppMethodBeat.o(6120);
    }

    static /* synthetic */ void a(BizTimeLineHotView bizTimeLineHotView, final c cVar) {
        AppMethodBeat.i(6121);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(194996);
                BizTimeLineHotView.this.pzr.a(cVar);
                AppMethodBeat.o(194996);
            }
        });
        AppMethodBeat.o(6121);
    }

    static /* synthetic */ void b(BizTimeLineHotView bizTimeLineHotView) {
        AppMethodBeat.i(6122);
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(6104);
                if (BizTimeLineHotView.this.pzq.get() != null && BizTimeLineHotView.this.pzq.get().isFinishing()) {
                    AppMethodBeat.o(6104);
                } else if (!Util.isNullOrNil(BizTimeLineHotView.this.pzu) || BizTimeLineHotView.cnq()) {
                    if (Util.isNullOrNil(BizTimeLineHotView.this.pzu)) {
                        BizTimeLineHotView.this.jUu.setVisibility(8);
                    } else {
                        BizTimeLineHotView.this.jUu.setVisibility(0);
                    }
                    if (BizTimeLineHotView.cnq()) {
                        BizTimeLineHotView.this.pzs.setVisibility(0);
                    } else {
                        BizTimeLineHotView.this.pzs.setVisibility(8);
                    }
                    if (BizTimeLineHotView.this.getVisibility() != 0) {
                        BizTimeLineHotView.this.setVisibility(0);
                    }
                    if (BizTimeLineHotView.this.pzz) {
                        BizTimeLineHotView.this.pzz = false;
                        BizTimeLineHotView.this.pzr.c(BizTimeLineHotView.this.pzu, false);
                        AppMethodBeat.o(6104);
                        return;
                    }
                    Looper.myQueue().removeIdleHandler(BizTimeLineHotView.this.pzA);
                    Looper.myQueue().addIdleHandler(BizTimeLineHotView.this.pzA);
                    AppMethodBeat.o(6104);
                } else {
                    BizTimeLineHotView.this.setVisibility(8);
                    AppMethodBeat.o(6104);
                }
            }
        });
        AppMethodBeat.o(6122);
    }

    static /* synthetic */ void g(BizTimeLineHotView bizTimeLineHotView) {
        AppMethodBeat.i(195009);
        if (!bizTimeLineHotView.pzt) {
            bizTimeLineHotView.pzt = true;
            g.azz().a(new k(), 0);
        }
        AppMethodBeat.o(195009);
    }

    static /* synthetic */ void a(BizTimeLineHotView bizTimeLineHotView, final boolean z) {
        AppMethodBeat.i(195010);
        if (!Util.isNullOrNil(bizTimeLineHotView.pzu)) {
            Collections.sort(bizTimeLineHotView.pzu, new Comparator<c>() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.AnonymousClass8 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(c cVar, c cVar2) {
                    c cVar3 = cVar;
                    c cVar4 = cVar2;
                    if (z) {
                        if (cVar3.pzL && cVar4.pzL) {
                            return cVar3.weight <= cVar4.weight ? 1 : -1;
                        }
                        if (!cVar3.pzL) {
                            return (cVar4.pzL || cVar3.weight <= cVar4.weight) ? 1 : -1;
                        }
                    } else if (cVar3.pzL && cVar4.pzL) {
                        return cVar3.oJs > cVar4.oJs ? -1 : 1;
                    } else {
                        if (!cVar3.pzL && (cVar4.pzL || cVar3.oJs <= cVar4.oJs)) {
                            return 1;
                        }
                    }
                    return -1;
                }
            });
        }
        AppMethodBeat.o(195010);
    }
}
