package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class a implements OnlineVideoView.a {
    private SnsInfo DqO;
    private Reference<OnlineVideoView> DzR;
    private Reference<k> DzS;
    private int qbU;

    private static String XR(int i2) {
        switch (i2) {
            case 1:
                return "normal time line item";
            case 2:
            default:
                return "";
            case 3:
                return "base card time line item";
        }
    }

    public a(SnsInfo snsInfo, OnlineVideoView onlineVideoView, k kVar, int i2) {
        AppMethodBeat.i(202317);
        this.DqO = snsInfo;
        this.DzR = new WeakReference(onlineVideoView);
        this.DzS = new WeakReference(kVar);
        this.qbU = i2;
        AppMethodBeat.o(202317);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OnlineVideoView.a
    public final void onStart(int i2) {
        AppMethodBeat.i(202318);
        Log.d("SnsAd.OnlineAdVideoCallback", "online player onStart is called, durationSecond=" + i2 + ", the item is " + XR(this.qbU));
        AppMethodBeat.o(202318);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OnlineVideoView.a
    public final void onCompletion() {
        AppMethodBeat.i(202319);
        Log.d("SnsAd.OnlineAdVideoCallback", "online player onCompletion is called , the item is " + XR(this.qbU));
        SnsInfo snsInfo = this.DqO;
        k kVar = this.DzS.get();
        OnlineVideoView onlineVideoView = this.DzR.get();
        if (!(snsInfo == null || kVar == null)) {
            long j2 = snsInfo.field_snsId;
            Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerCompletion is called, snsId=" + r.Jb(j2));
            if (!snsInfo.isAd()) {
                Log.e("SnsAd.OnlineAdVideoCallback", "online player completion, !isAd,  snsId=" + r.Jb(j2));
            } else {
                kVar.I(j2, false);
            }
        }
        if (onlineVideoView != null) {
            onlineVideoView.aT(0, true);
        }
        AppMethodBeat.o(202319);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OnlineVideoView.a
    public final void xv(int i2) {
        AppMethodBeat.i(202320);
        SnsInfo snsInfo = this.DqO;
        k kVar = this.DzS.get();
        OnlineVideoView onlineVideoView = this.DzR.get();
        if (!(onlineVideoView == null || snsInfo == null || kVar == null)) {
            long j2 = (long) (i2 * 1000);
            long duration = (long) onlineVideoView.getDuration();
            Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying is called , the second  is " + j2 + " the duration is " + duration);
            if (snsInfo == null || kVar == null) {
                Log.e("SnsAd.OnlineAdVideoCallback", "doOnNewPlayerPlaying is called , the holder or sns info is null");
                AppMethodBeat.o(202320);
                return;
            }
            long j3 = snsInfo.field_snsId;
            if (!snsInfo.isAd()) {
                Log.w("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, the info is not Ad, snsId=" + r.Jb(j3));
                AppMethodBeat.o(202320);
                return;
            }
            kVar.IT(snsInfo.field_snsId);
            kVar.ao(snsInfo.field_snsId, j2);
            if (!kVar.IQ(j3)) {
                kVar.c(j3, Util.currentTicks(), false);
                kVar.e(j3, (int) (duration / 1000), false);
                kVar.an(j3, j3);
                Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, addPlay3s, snsId=" + r.Jb(j3));
            }
        }
        AppMethodBeat.o(202320);
    }
}
