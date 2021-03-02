package com.tencent.thumbplayer.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.g;

public final class d implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener {
    ITPPlayerListener.IOnPreparedListener Sbc;
    ITPPlayerListener.IOnCompletionListener Sbd;
    ITPPlayerListener.IOnInfoListener Sbe;
    ITPPlayerListener.IOnErrorListener Sbf;
    ITPPlayerListener.IOnSeekCompleteListener Sbg;
    ITPPlayerListener.IOnVideoSizeChangedListener Sbh;
    ITPPlayerListener.IOnSubtitleDataListener Sbi;
    ITPPlayerListener.IOnSubtitleFrameOutListener Sbj;
    ITPPlayerListener.IOnVideoFrameOutListener Sbk;
    ITPPlayerListener.IOnAudioFrameOutputListener Sbl;
    ITPPlayerListener.IOnVideoProcessFrameOutputListener Sbm;
    ITPPlayerListener.IOnAudioProcessFrameOutputListener Sbn;
    ITPPlayerListener.IOnStateChangeListener Sbo;
    ITPPlayerListener.IOnStopAsyncCompleteListener Sbp;
    a Sbq;
    private String mTag = "TPPlayerListenerS";

    d(String str) {
        AppMethodBeat.i(189499);
        bqx(str);
        this.Sbq = new a(this.mTag);
        this.Sbc = this.Sbq;
        this.Sbd = this.Sbq;
        this.Sbe = this.Sbq;
        this.Sbf = this.Sbq;
        this.Sbg = this.Sbq;
        this.Sbh = this.Sbq;
        this.Sbi = this.Sbq;
        this.Sbj = this.Sbq;
        this.Sbk = this.Sbq;
        this.Sbl = this.Sbq;
        this.Sbm = this.Sbq;
        this.Sbn = this.Sbq;
        this.Sbo = this.Sbq;
        this.Sbp = this.Sbq;
        AppMethodBeat.o(189499);
    }

    public final void bqx(String str) {
        AppMethodBeat.i(189500);
        if (TextUtils.isEmpty(str)) {
            this.mTag = "TPPlayerListenerS";
        } else {
            this.mTag = str;
        }
        if (this.Sbq != null) {
            this.Sbq.mTag = str;
        }
        AppMethodBeat.o(189500);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener
    public final void onPrepared(ITPPlayer iTPPlayer) {
        AppMethodBeat.i(189501);
        this.Sbc.onPrepared(iTPPlayer);
        AppMethodBeat.o(189501);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener
    public final void onCompletion(ITPPlayer iTPPlayer) {
        AppMethodBeat.i(189502);
        this.Sbd.onCompletion(iTPPlayer);
        AppMethodBeat.o(189502);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener
    public final void onInfo(ITPPlayer iTPPlayer, int i2, long j2, long j3, Object obj) {
        AppMethodBeat.i(189503);
        this.Sbe.onInfo(iTPPlayer, i2, j2, j3, obj);
        AppMethodBeat.o(189503);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener
    public final void onError(ITPPlayer iTPPlayer, int i2, int i3, long j2, long j3) {
        AppMethodBeat.i(189504);
        this.Sbf.onError(iTPPlayer, i2, i3, j2, j3);
        AppMethodBeat.o(189504);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener
    public final void onSeekComplete(ITPPlayer iTPPlayer) {
        AppMethodBeat.i(189505);
        this.Sbg.onSeekComplete(iTPPlayer);
        AppMethodBeat.o(189505);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener
    public final void onVideoSizeChanged(ITPPlayer iTPPlayer, long j2, long j3) {
        AppMethodBeat.i(189506);
        this.Sbh.onVideoSizeChanged(iTPPlayer, j2, j3);
        AppMethodBeat.o(189506);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener
    public final void onSubtitleData(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
        AppMethodBeat.i(189507);
        this.Sbi.onSubtitleData(iTPPlayer, tPSubtitleData);
        AppMethodBeat.o(189507);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener
    public final void onSubtitleFrameOut(ITPPlayer iTPPlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
        AppMethodBeat.i(189508);
        this.Sbj.onSubtitleFrameOut(iTPPlayer, tPSubtitleFrameBuffer);
        AppMethodBeat.o(189508);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener
    public final void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
        AppMethodBeat.i(189509);
        this.Sbk.onVideoFrameOut(iTPPlayer, tPVideoFrameBuffer);
        AppMethodBeat.o(189509);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener
    public final void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
        AppMethodBeat.i(189510);
        this.Sbl.onAudioFrameOut(iTPPlayer, tPAudioFrameBuffer);
        AppMethodBeat.o(189510);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoProcessFrameOutputListener
    public final TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        AppMethodBeat.i(189511);
        TPPostProcessFrameBuffer onVideoProcessFrameOut = this.Sbm.onVideoProcessFrameOut(iTPPlayer, tPPostProcessFrameBuffer);
        AppMethodBeat.o(189511);
        return onVideoProcessFrameOut;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioProcessFrameOutputListener
    public final TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        AppMethodBeat.i(189512);
        TPPostProcessFrameBuffer onAudioProcessFrameOut = this.Sbn.onAudioProcessFrameOut(iTPPlayer, tPPostProcessFrameBuffer);
        AppMethodBeat.o(189512);
        return onAudioProcessFrameOut;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener
    public final void onStateChange(int i2, int i3) {
        AppMethodBeat.i(189513);
        this.Sbo.onStateChange(i2, i3);
        AppMethodBeat.o(189513);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener
    public final void onStopAsyncComplete(ITPPlayer iTPPlayer) {
        AppMethodBeat.i(189514);
        this.Sbp.onStopAsyncComplete(iTPPlayer);
        AppMethodBeat.o(189514);
    }

    /* access modifiers changed from: package-private */
    public static class a implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener {
        String mTag;

        public a(String str) {
            this.mTag = str;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener
        public final void onPrepared(ITPPlayer iTPPlayer) {
            AppMethodBeat.i(189485);
            g.i(this.mTag, " empty player listener , notify , onPrepared");
            AppMethodBeat.o(189485);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener
        public final void onCompletion(ITPPlayer iTPPlayer) {
            AppMethodBeat.i(189486);
            g.i(this.mTag, " empty player listener , notify , onCompletion");
            AppMethodBeat.o(189486);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener
        public final void onInfo(ITPPlayer iTPPlayer, int i2, long j2, long j3, Object obj) {
            AppMethodBeat.i(189487);
            g.i(this.mTag, " empty player listener , notify , onInfo");
            AppMethodBeat.o(189487);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener
        public final void onError(ITPPlayer iTPPlayer, int i2, int i3, long j2, long j3) {
            AppMethodBeat.i(189488);
            g.i(this.mTag, " empty player listener , notify , onError");
            AppMethodBeat.o(189488);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener
        public final void onSeekComplete(ITPPlayer iTPPlayer) {
            AppMethodBeat.i(189489);
            g.i(this.mTag, " empty player listener , notify , onSeekComplete");
            AppMethodBeat.o(189489);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener
        public final void onVideoSizeChanged(ITPPlayer iTPPlayer, long j2, long j3) {
            AppMethodBeat.i(189490);
            g.i(this.mTag, " empty player listener , notify , onVideoSizeChanged");
            AppMethodBeat.o(189490);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener
        public final void onSubtitleData(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
            AppMethodBeat.i(189491);
            g.i(this.mTag, " empty player listener , notify , onSubtitleData");
            AppMethodBeat.o(189491);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener
        public final void onSubtitleFrameOut(ITPPlayer iTPPlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            AppMethodBeat.i(189492);
            g.i(this.mTag, " empty player listener , notify , onSubtitleFrameOut");
            AppMethodBeat.o(189492);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener
        public final void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
            AppMethodBeat.i(189493);
            g.i(this.mTag, " empty player listener , notify , onVideoFrameOut");
            AppMethodBeat.o(189493);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener
        public final void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
            AppMethodBeat.i(189494);
            g.i(this.mTag, " empty player listener , notify , onAudioFrameOut");
            AppMethodBeat.o(189494);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoProcessFrameOutputListener
        public final TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            AppMethodBeat.i(189495);
            g.i(this.mTag, " empty player listener , notify , onPostProcessFrameOut");
            AppMethodBeat.o(189495);
            return null;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioProcessFrameOutputListener
        public final TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            AppMethodBeat.i(189496);
            g.i(this.mTag, " empty player listener , notify , onPostProcessFrameOut");
            AppMethodBeat.o(189496);
            return null;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener
        public final void onStateChange(int i2, int i3) {
            AppMethodBeat.i(189497);
            g.i(this.mTag, " empty player listener , notify , onStateChange");
            AppMethodBeat.o(189497);
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener
        public final void onStopAsyncComplete(ITPPlayer iTPPlayer) {
            AppMethodBeat.i(189498);
            g.i(this.mTag, " empty player listener , notify , onStopAsyncComplete");
            AppMethodBeat.o(189498);
        }
    }
}
