package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.timeline.c.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.video.online.e;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;

public final class f implements CardLayoutManager.c {
    public SnsInfo DqO;
    final e DyU;
    a DyZ;
    boolean DzK;
    boolean DzL;

    public f(e eVar, a aVar) {
        this.DyU = eVar;
        this.DyZ = aVar;
    }

    public final void eYb() {
        AppMethodBeat.i(202297);
        this.DzL = false;
        Log.d("SnsAd.TopicCardVideoPlayHelper", "the time line is paused, ready to play is false");
        e eVar = this.DyU;
        if (eVar != null) {
            try {
                eVar.cXa();
            } catch (Throwable th) {
                AppMethodBeat.o(202297);
                return;
            }
        }
        AppMethodBeat.o(202297);
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.c
    public final void a(CardLayoutManager cardLayoutManager, int i2) {
        AppMethodBeat.i(202298);
        if (i2 == 1) {
            try {
                this.DzK = true;
                cardLayoutManager.eYC();
                AppMethodBeat.o(202298);
            } catch (Throwable th) {
                AppMethodBeat.o(202298);
            }
        } else {
            this.DzK = false;
            AppMethodBeat.o(202298);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.c
    public final void a(CardLayoutManager cardLayoutManager, int i2, int i3) {
        AppMethodBeat.i(202299);
        Log.d("SnsAd.TopicCardVideoPlayHelper", "the onVisibleItemChanged is called , current position is " + i2 + ", the last position " + i3);
        try {
            if (this.DyZ != null) {
                a aVar = this.DyZ;
                if (i2 != aVar.currentIndex) {
                    aVar.currentIndex = i2;
                    a.C1709a XP = aVar.XP(i2);
                    if (XP != null) {
                        XP.Dzo++;
                    }
                }
            }
            a(cardLayoutManager, i2, false);
            AppMethodBeat.o(202299);
        } catch (Throwable th) {
            Log.d("SnsAd.TopicCardVideoPlayHelper", "onVisibleItemChanged has something wrong");
            AppMethodBeat.o(202299);
        }
    }

    public final void b(CardLayoutManager cardLayoutManager) {
        AppMethodBeat.i(202300);
        Log.i("SnsAd.TopicCardVideoPlayHelper", "resumePlayByTimeline is called!");
        this.DzL = true;
        if (cardLayoutManager != null) {
            try {
                int eYD = cardLayoutManager.eYD();
                if (eYD >= 0) {
                    a(cardLayoutManager, eYD, true);
                }
            } catch (Throwable th) {
                Log.d("SnsAd.TopicCardVideoPlayHelper", "resumePlayByTimeline has something wrong");
                AppMethodBeat.o(202300);
                return;
            }
        }
        AppMethodBeat.o(202300);
    }

    private void a(CardLayoutManager cardLayoutManager, int i2, boolean z) {
        AppMethodBeat.i(202301);
        Log.d("SnsAd.TopicCardVideoPlayHelper", "playInner:: currentPosition is " + i2 + ", the ready to play is " + this.DzL);
        if (cardLayoutManager == null) {
            AppMethodBeat.o(202301);
            return;
        }
        SnsInfo snsInfo = this.DqO;
        com.tencent.mm.plugin.sns.ad.a.e b2 = b(cardLayoutManager, i2);
        e c2 = c(cardLayoutManager, i2);
        if (snsInfo == null || b2 == null || c2 == null || c2.DzD == null) {
            Log.w("SnsAd.TopicCardVideoPlayHelper", "playInner::the resInfo or view holder is null");
            AppMethodBeat.o(202301);
            return;
        }
        cardLayoutManager.eYC();
        if (!this.DzL) {
            Log.i("SnsAd.TopicCardVideoPlayHelper", "playInner::the topic item is not able to play video");
        } else if (b2.eWB()) {
            Log.i("SnsAd.TopicCardVideoPlayHelper", "playInner:: currentPosition is " + i2 + ", the res info is sight");
            a(cardLayoutManager, c2.DzD, snsInfo, b2.ebR, z);
            AppMethodBeat.o(202301);
            return;
        } else {
            cardLayoutManager.eYB();
            if (this.DyU != null) {
                this.DyU.cXa();
                AppMethodBeat.o(202301);
                return;
            }
        }
        AppMethodBeat.o(202301);
    }

    private static com.tencent.mm.plugin.sns.ad.a.e b(CardLayoutManager cardLayoutManager, int i2) {
        AppMethodBeat.i(202302);
        if (cardLayoutManager == null) {
            AppMethodBeat.o(202302);
            return null;
        }
        try {
            RecyclerView.a cWP = cardLayoutManager.cWP();
            if (cWP instanceof d) {
                com.tencent.mm.plugin.sns.ad.a.e XQ = ((d) cWP).XQ(i2);
                AppMethodBeat.o(202302);
                return XQ;
            }
        } catch (Throwable th) {
            Log.d("SnsAd.TopicCardVideoPlayHelper", "get topic resource information failed!");
        }
        AppMethodBeat.o(202302);
        return null;
    }

    private static e c(CardLayoutManager cardLayoutManager, int i2) {
        AppMethodBeat.i(202303);
        if (cardLayoutManager == null) {
            AppMethodBeat.o(202303);
            return null;
        }
        try {
            RecyclerView.v XZ = cardLayoutManager.XZ(i2);
            if (XZ instanceof e) {
                e eVar = (e) XZ;
                AppMethodBeat.o(202303);
                return eVar;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202303);
        return null;
    }

    private void a(CardLayoutManager cardLayoutManager, ViewGroup viewGroup, SnsInfo snsInfo, cnb cnb, boolean z) {
        AppMethodBeat.i(202304);
        e eVar = this.DyU;
        if (eVar == null || cardLayoutManager == null || viewGroup == null || snsInfo == null || cnb == null) {
            Log.e("SnsAd.TopicCardVideoPlayHelper", "the input params are invalid!!!!");
            AppMethodBeat.o(202304);
            return;
        }
        c cVar = new c();
        cVar.ebR = cnb;
        cVar.dHp = snsInfo.getLocalid();
        cVar.dRS = r.Jb(snsInfo.field_snsId);
        cVar.iXu = snsInfo.getCreateTime();
        OnlineVideoView bx = eVar.bx(viewGroup.getContext(), cnb.Id);
        OnlineVideoView E = E(viewGroup);
        if (E == null) {
            Log.d("SnsAd.TopicCardVideoPlayHelper", "the videoViewInContainer need new view");
            a(bx, cardLayoutManager, viewGroup, cVar);
            AppMethodBeat.o(202304);
        } else if (E == bx) {
            Log.d("SnsAd.TopicCardVideoPlayHelper", "the videoViewInContainer and media id view is same, is time line reason ".concat(String.valueOf(z)));
            if (z) {
                eVar.a(E, cnb.Id);
                AppMethodBeat.o(202304);
                return;
            }
            eVar.b(E, cnb.Id);
            AppMethodBeat.o(202304);
        } else {
            m.F(viewGroup);
            a(bx, cardLayoutManager, viewGroup, cVar);
            AppMethodBeat.o(202304);
        }
    }

    private static OnlineVideoView E(ViewGroup viewGroup) {
        AppMethodBeat.i(202305);
        if (m.G(viewGroup)) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof OnlineVideoView) {
                OnlineVideoView onlineVideoView = (OnlineVideoView) childAt;
                AppMethodBeat.o(202305);
                return onlineVideoView;
            }
        }
        AppMethodBeat.o(202305);
        return null;
    }

    private void a(OnlineVideoView onlineVideoView, CardLayoutManager cardLayoutManager, ViewGroup viewGroup, c cVar) {
        AppMethodBeat.i(202306);
        e eVar = this.DyU;
        if (!(onlineVideoView == null || eVar == null)) {
            m.fc(onlineVideoView);
            m.u(onlineVideoView, -1, -1);
            m.a(viewGroup, onlineVideoView, 0);
            m.u(onlineVideoView, true);
            onlineVideoView.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
            onlineVideoView.setVideoScaleType(i.e.COVER);
            onlineVideoView.setVideoCallback(new a(cardLayoutManager, onlineVideoView));
            eVar.a(onlineVideoView, cVar, cVar.dRS, cVar.ebR.Id);
        }
        AppMethodBeat.o(202306);
    }

    /* access modifiers changed from: package-private */
    public class a implements OnlineVideoView.a {
        final CardLayoutManager DyT;
        final OnlineVideoView DzM;
        boolean DzN = false;

        public a(CardLayoutManager cardLayoutManager, OnlineVideoView onlineVideoView) {
            this.DzM = onlineVideoView;
            this.DyT = cardLayoutManager;
        }

        @Override // com.tencent.mm.plugin.sns.ui.OnlineVideoView.a
        public final void onStart(int i2) {
            AppMethodBeat.i(202294);
            try {
                Log.d("SnsAd.TopicCardVideoPlayHelper", "the video is start");
                if (this.DyT != null) {
                    int eYD = this.DyT.eYD();
                    if (!(f.this.DyZ == null || this.DzM == null)) {
                        f.this.DyZ.io(eYD, this.DzM.getDuration());
                    }
                }
                AppMethodBeat.o(202294);
            } catch (Throwable th) {
                AppMethodBeat.o(202294);
            }
        }

        @Override // com.tencent.mm.plugin.sns.ui.OnlineVideoView.a
        public final void onCompletion() {
            AppMethodBeat.i(202295);
            try {
                Log.d("SnsAd.TopicCardVideoPlayHelper", "the video is onCompletion");
                this.DzN = false;
                if (this.DyT != null) {
                    int eYD = this.DyT.eYD();
                    if (!(f.this.DyZ == null || this.DzM == null)) {
                        a.C1709a XP = f.this.DyZ.XP(eYD);
                        if (XP != null) {
                            XP.Dzp++;
                            XP.Dzq += XP.Dzs;
                            XP.Dzt = 0;
                        }
                        f.this.DyZ.io(eYD, this.DzM.getDuration());
                    }
                }
                f fVar = f.this;
                CardLayoutManager cardLayoutManager = this.DyT;
                OnlineVideoView onlineVideoView = this.DzM;
                if (fVar.DzK) {
                    if (onlineVideoView != null) {
                        onlineVideoView.aT(0, true);
                        AppMethodBeat.o(202295);
                        return;
                    }
                } else if (cardLayoutManager != null) {
                    try {
                        if (cardLayoutManager.DBo != null) {
                            CardLayoutManager.a aVar = cardLayoutManager.DBo;
                            if (aVar.sCt != null) {
                                aVar.cancel();
                                aVar.sCt.sendEmptyMessage(0);
                            }
                        }
                        AppMethodBeat.o(202295);
                        return;
                    } catch (Throwable th) {
                    }
                }
                AppMethodBeat.o(202295);
            } catch (Throwable th2) {
                AppMethodBeat.o(202295);
            }
        }

        @Override // com.tencent.mm.plugin.sns.ui.OnlineVideoView.a
        public final void xv(int i2) {
            AppMethodBeat.i(202296);
            try {
                if (this.DyT != null) {
                    int eYD = this.DyT.eYD();
                    if (!(f.this.DyZ == null || this.DzM == null)) {
                        Object tag = this.DzM.getTag(R.id.huv);
                        if ((tag instanceof Integer) && ((Integer) tag).intValue() == 1) {
                            Log.d("SnsAd.TopicCardVideoPlayHelper", "the video view has bean seek to 0");
                            this.DzM.setTag(R.id.huv, 0);
                            this.DzN = false;
                            a.C1709a XP = f.this.DyZ.XP(eYD);
                            if (XP != null) {
                                XP.Dzq += XP.Dzt;
                                XP.Dzt = 0;
                            }
                        }
                        int i3 = i2 * 1000;
                        a.C1709a XP2 = f.this.DyZ.XP(eYD);
                        if (XP2 != null) {
                            XP2.Dzt = i3;
                            if (XP2.Dzr < i3) {
                                XP2.Dzr = i3;
                            }
                        }
                        if (!this.DzN && i2 > 0) {
                            this.DzN = true;
                            a.C1709a XP3 = f.this.DyZ.XP(eYD);
                            if (XP3 != null) {
                                XP3.Aiv++;
                            }
                        }
                    }
                }
                AppMethodBeat.o(202296);
            } catch (Throwable th) {
                AppMethodBeat.o(202296);
            }
        }
    }
}
