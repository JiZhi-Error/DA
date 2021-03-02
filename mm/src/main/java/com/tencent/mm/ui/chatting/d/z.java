package com.tencent.mm.ui.chatting.d;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.w;
import com.tencent.mm.ui.chatting.gallery.g;

@com.tencent.mm.ui.chatting.d.a.a(gRF = w.class)
public class z extends a implements e.a, u.a, w {
    private MTimerHandler Pqi = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.chatting.d.z.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            boolean baX;
            AppMethodBeat.i(35350);
            if (z.this.dom == null) {
                AppMethodBeat.o(35350);
            } else {
                boolean eCR = com.tencent.mm.plugin.priority.a.a.a.a.eCR();
                int firstVisiblePosition = z.this.dom.getFirstVisiblePosition() - z.this.dom.getHeaderViewsCount();
                int lastVisiblePosition = z.this.dom.getLastVisiblePosition() - z.this.dom.getHeaderViewsCount();
                k kVar = (k) z.this.dom.bh(k.class);
                int max = Math.max(firstVisiblePosition, 0);
                int max2 = Math.max(Math.min(lastVisiblePosition, kVar.getCount()), 0);
                Log.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + max + " last: " + max2);
                if (max2 < max) {
                    Log.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
                    z.this.Pqi.startTimer(1000);
                    AppMethodBeat.o(35350);
                } else {
                    q.bcS().iXf = true;
                    for (int i2 = max; i2 <= max2; i2++) {
                        ca amt = kVar.amt(i2);
                        if (amt != null && amt.field_isSend == 0 && amt.gAz()) {
                            g G = q.bcR().G(amt.field_talker, amt.field_msgSvrId);
                            if (!G.bcu() && amt.fRb != 2) {
                                if (amt.fRb != 1) {
                                    if (eCR) {
                                        d.baW();
                                        if (amt == null) {
                                            Log.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
                                            baX = false;
                                        } else if (!amt.gAz()) {
                                            Log.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
                                            baX = false;
                                        } else if (!d.T(amt)) {
                                            Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
                                            baX = false;
                                        } else {
                                            baX = d.baX();
                                        }
                                        if (!baX) {
                                        }
                                    }
                                }
                                ((b) com.tencent.mm.kernel.g.af(b.class)).a(amt, new a(amt, G, i2));
                            }
                        }
                    }
                    q.bcS().bco();
                    AppMethodBeat.o(35350);
                }
            }
            return false;
        }
    }, false);
    private com.tencent.mm.ui.chatting.gallery.g Pqj = g.a.Pyr;
    private IListener qoC = new IListener<bf>() {
        /* class com.tencent.mm.ui.chatting.d.z.AnonymousClass1 */

        {
            AppMethodBeat.i(161530);
            this.__eventId = bf.class.getName().hashCode();
            AppMethodBeat.o(161530);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bf bfVar) {
            AppMethodBeat.i(35349);
            bf bfVar2 = bfVar;
            if (bfVar2 instanceof bf) {
                z.a(z.this, bfVar2.dEo.dCM, bfVar2);
            }
            AppMethodBeat.o(35349);
            return false;
        }
    };

    public z() {
        AppMethodBeat.i(35353);
        AppMethodBeat.o(35353);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.w
    public final void startTimer() {
        AppMethodBeat.i(35354);
        this.Pqi.stopTimer();
        this.Pqi.startTimer(1000);
        AppMethodBeat.o(35354);
    }

    private void stopTimer() {
        AppMethodBeat.i(35355);
        if (bg.aAc()) {
            q.bcS().a(this);
        }
        this.Pqi.stopTimer();
        AppMethodBeat.o(35355);
    }

    private void gpe() {
        AppMethodBeat.i(35356);
        stopTimer();
        EventCenter.instance.removeListener(this.qoC);
        com.tencent.mm.ui.chatting.gallery.g gVar = this.Pqj;
        gVar.xql.clear();
        gVar.dSj();
        AppMethodBeat.o(35356);
    }

    class a implements Runnable {
        private com.tencent.mm.av.g Bwy;
        private ca dTX;

        /* renamed from: i  reason: collision with root package name */
        private int f1551i;

        a(ca caVar, com.tencent.mm.av.g gVar, int i2) {
            this.dTX = caVar;
            this.Bwy = gVar;
            this.f1551i = i2;
        }

        public final void run() {
            AppMethodBeat.i(35352);
            f.baQ().iRE.add("image_" + this.dTX.field_msgId);
            q.bcS().a(this.Bwy.localId, this.dTX.field_msgId, 0, Integer.valueOf(this.f1551i), R.drawable.c3h, z.this, -1, true);
            AppMethodBeat.o(35352);
        }
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, com.tencent.mm.ak.q qVar) {
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(35357);
        if (!com.tencent.mm.plugin.priority.a.a.a.a.eCR()) {
            q.bcS().a(this);
        }
        boolean z = i4 == 0 && i5 == 0;
        ((b) com.tencent.mm.kernel.g.af(b.class)).b(j3, z, false);
        ((com.tencent.mm.plugin.priority.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.priority.a.a.class)).getC2CImgAutoDownloader().b(j2, j3, z);
        bg.aVF();
        ((k) this.dom.bh(k.class)).a(j3, c.aSQ().Hb(j3), z);
        AppMethodBeat.o(35357);
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj) {
        AppMethodBeat.i(35358);
        ((b) com.tencent.mm.kernel.g.af(b.class)).b(j3, false, true);
        AppMethodBeat.o(35358);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, Bitmap bitmap) {
        AppMethodBeat.i(35359);
        if (Util.isNullOrNil(str) || bitmap == null || this.dom == null) {
            AppMethodBeat.o(35359);
            return;
        }
        com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.z.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(35351);
                if (z.this.dom != null) {
                    z.this.dom.cmy();
                }
                AppMethodBeat.o(35351);
            }
        });
        AppMethodBeat.o(35359);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(35360);
        super.onScrollStateChanged(absListView, i2);
        q.bcV().onScrollStateChanged(i2);
        if (i2 == 0) {
            startTimer();
            AppMethodBeat.o(35360);
            return;
        }
        if (i2 == 2) {
            stopTimer();
        }
        AppMethodBeat.o(35360);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35361);
        super.gOK();
        gpe();
        AppMethodBeat.o(35361);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35365);
        gpe();
        AppMethodBeat.o(35365);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35362);
        EventCenter.instance.addListener(this.qoC);
        AppMethodBeat.o(35362);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(35363);
        pg pgVar = new pg();
        pgVar.dVo.pause = true;
        pgVar.dVo.talker = this.dom.GUe.field_username;
        EventCenter.instance.asyncPublish(pgVar, Looper.getMainLooper());
        u.b(this);
        AppMethodBeat.o(35363);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35364);
        pg pgVar = new pg();
        pgVar.dVo.pause = false;
        pgVar.dVo.talker = this.dom.GUe.field_username;
        EventCenter.instance.asyncPublish(pgVar, Looper.getMainLooper());
        u.c(this);
        stopTimer();
        AppMethodBeat.o(35364);
    }

    static /* synthetic */ void a(z zVar, ca caVar, bf bfVar) {
        AppMethodBeat.i(35366);
        int firstVisiblePosition = zVar.dom.getListView().getFirstVisiblePosition();
        int lastVisiblePosition = zVar.dom.getListView().getLastVisiblePosition();
        int max = Math.max(firstVisiblePosition, 0);
        int max2 = Math.max(lastVisiblePosition, 0);
        if (max < 0 || max2 >= zVar.dom.getListView().getAdapter().getCount()) {
            Log.i("MicroMsg.ChattingUI.GetImageComponent", "invalid position %d-%d, cnt:%d", Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(zVar.dom.getListView().getAdapter().getCount()));
            AppMethodBeat.o(35366);
            return;
        }
        for (int i2 = max; i2 <= max2; i2++) {
            ca caVar2 = (ca) zVar.dom.getListView().getAdapter().getItem(i2);
            if (!(caVar == null || caVar2 == null || caVar2.field_msgId != caVar.field_msgId)) {
                View childAt = zVar.dom.getChildAt(i2 - max);
                if (childAt == null) {
                    Log.e("MicroMsg.ChattingUI.GetImageComponent", "[getPhotoInfo] getChildAt(%d)", Integer.valueOf((i2 - max) + zVar.dom.getHeaderViewsCount()));
                } else {
                    View view = null;
                    if (caVar.gAz() || caVar.cWJ() || caVar.cWL() || caVar.cWK()) {
                        view = childAt.findViewById(R.id.aul);
                    } else if (caVar.gDr()) {
                        view = childAt.findViewById(R.id.att);
                    }
                    if (view != null) {
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        bfVar.dEp.dEq = iArr[0];
                        bfVar.dEp.dEr = iArr[1];
                        bfVar.dEp.dEs = view.getWidth();
                        bfVar.dEp.dEt = view.getHeight();
                    }
                }
            }
        }
        AppMethodBeat.o(35366);
    }
}
