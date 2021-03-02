package com.tencent.thumbplayer.a;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c;
import com.tencent.thumbplayer.a.a.e;
import com.tencent.thumbplayer.a.c;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerState;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.f.b;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d implements a, c.h {
    b RVM;
    com.tencent.thumbplayer.f.a RVN = new com.tencent.thumbplayer.f.a(this.RVM);
    com.tencent.thumbplayer.a.a.b RVO;
    TPPlayerState RVP;
    boolean RVQ;
    e RVR;
    private a RVS;
    c RVT;
    g RVU;
    com.tencent.thumbplayer.a.b.a RVV;
    b RVW;
    int RVX;
    private Context mContext;

    public d(Context context, b bVar) {
        AppMethodBeat.i(188632);
        this.RVM = new b(bVar, "TPPlayerAdapter");
        this.mContext = context;
        this.RVP = new TPPlayerState();
        this.RVP.setOnPlayerStateChangeListener(this);
        this.RVT = new c();
        this.RVS = new a(this, (byte) 0);
        this.RVR = new e(this.RVM.tag);
        this.RVU = new g(this.RVP);
        this.RVW = new b();
        AppMethodBeat.o(188632);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void updateLoggerContext(b bVar) {
        AppMethodBeat.i(188633);
        this.RVM.a(bVar, "TPPlayerAdapter");
        this.RVN.a(this.RVM);
        this.RVR.bqx(this.RVM.tag);
        if (this.RVO != null) {
            this.RVO.updateLoggerContext(this.RVM);
        }
        AppMethodBeat.o(188633);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setPlayerOptionalParam(TPOptionalParam tPOptionalParam) {
        AppMethodBeat.i(188634);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("setPlayerOptionalParam , state invalid");
            AppMethodBeat.o(188634);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.setPlayerOptionalParam(tPOptionalParam);
        }
        this.RVT.a(tPOptionalParam);
        AppMethodBeat.o(188634);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setSurface(Surface surface) {
        AppMethodBeat.i(188635);
        if (!this.RVU.aqS(4)) {
            IllegalStateException illegalStateException = new IllegalStateException("setSurface , state invalid");
            AppMethodBeat.o(188635);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.setSurface(surface);
        }
        this.RVT.RVt = surface;
        AppMethodBeat.o(188635);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(188636);
        if (!this.RVU.aqS(4)) {
            IllegalStateException illegalStateException = new IllegalStateException("setSurfaceHolder , state invalid");
            AppMethodBeat.o(188636);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.setSurfaceHolder(surfaceHolder);
        }
        this.RVT.RVt = surfaceHolder;
        AppMethodBeat.o(188636);
    }

    @Override // com.tencent.thumbplayer.a.a
    public final void a(e eVar) {
        AppMethodBeat.i(188637);
        a(eVar, (Map<String, String>) null);
        AppMethodBeat.o(188637);
    }

    @Override // com.tencent.thumbplayer.a.a
    public final void a(e eVar, Map<String, String> map) {
        AppMethodBeat.i(188638);
        if (!this.RVU.aqS(2)) {
            IllegalStateException illegalStateException = new IllegalStateException("error : setDataSource , state invalid");
            AppMethodBeat.o(188638);
            throw illegalStateException;
        } else if (eVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("error : setDataSource , data source invalid");
            AppMethodBeat.o(188638);
            throw illegalArgumentException;
        } else {
            this.RVT.a(eVar, map);
            this.RVP.changeState(2);
            AppMethodBeat.o(188638);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(String str, Map<String, String> map) {
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(188639);
        if (!this.RVU.aqS(2)) {
            IllegalStateException illegalStateException = new IllegalStateException("error : setDataSource , state invalid");
            AppMethodBeat.o(188639);
            throw illegalStateException;
        } else if (parcelFileDescriptor == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("error : setDataSource , pfd invalid");
            AppMethodBeat.o(188639);
            throw illegalArgumentException;
        } else {
            this.RVT.setDataSource(parcelFileDescriptor);
            this.RVP.changeState(2);
            AppMethodBeat.o(188639);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(ITPMediaAsset iTPMediaAsset) {
        AppMethodBeat.i(188640);
        if (!this.RVU.aqS(2)) {
            IllegalStateException illegalStateException = new IllegalStateException("error : setDataSource , state invalid");
            AppMethodBeat.o(188640);
            throw illegalStateException;
        } else if (iTPMediaAsset == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
            AppMethodBeat.o(188640);
            throw illegalArgumentException;
        } else {
            this.RVT.setDataSource(iTPMediaAsset);
            this.RVP.changeState(2);
            AppMethodBeat.o(188640);
        }
    }

    @Override // com.tencent.thumbplayer.a.a
    public final void setVideoInfo(TPVideoInfo tPVideoInfo) {
        AppMethodBeat.i(188641);
        if (!this.RVU.aqS(2)) {
            this.RVN.error("setVideoInfo state invalid");
        }
        if (tPVideoInfo != null) {
            this.RVW.height = tPVideoInfo.getHeight();
            this.RVW.width = tPVideoInfo.getWidth();
            this.RVW.definition = tPVideoInfo.getDefinition();
            this.RVW.RVk = com.tencent.thumbplayer.utils.d.arD(tPVideoInfo.getVideoCodecId());
        }
        AppMethodBeat.o(188641);
    }

    @Override // com.tencent.thumbplayer.a.a
    public final void a(TPVideoInfo tPVideoInfo) {
        AppMethodBeat.i(188642);
        if (!this.RVU.aqS(3)) {
            this.RVN.error("updateVideoInfo state invalid");
        }
        if (tPVideoInfo != null) {
            this.RVW.height = tPVideoInfo.getHeight();
            this.RVW.width = tPVideoInfo.getWidth();
            this.RVW.definition = tPVideoInfo.getDefinition();
            this.RVW.RVk = com.tencent.thumbplayer.utils.d.arD(tPVideoInfo.getVideoCodecId());
        }
        AppMethodBeat.o(188642);
    }

    @Override // com.tencent.thumbplayer.a.a
    public final int getCurrentPlayClipNo() {
        if (this.RVW != null) {
            return this.RVW.RVs;
        }
        return 0;
    }

    @Override // com.tencent.thumbplayer.a.a
    public final int getCurrentState() {
        AppMethodBeat.i(188643);
        int state = this.RVP.state();
        AppMethodBeat.o(188643);
        return state;
    }

    @Override // com.tencent.thumbplayer.a.a
    public final boolean isPlaying() {
        AppMethodBeat.i(188644);
        if (this.RVP == null || this.RVP.state() != 5) {
            AppMethodBeat.o(188644);
            return false;
        }
        AppMethodBeat.o(188644);
        return true;
    }

    @Override // com.tencent.thumbplayer.a.a
    public final int getPlayerType() {
        return this.RVX;
    }

    @Override // com.tencent.thumbplayer.a.a
    public final b hmK() {
        return this.RVW;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void addSubtitleSource(String str, String str2, String str3) {
        AppMethodBeat.i(188645);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("error : addSubtitleSource , state invalid");
            AppMethodBeat.o(188645);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.addSubtitleSource(str, str2, str3);
        }
        c cVar = this.RVT;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            c.d dVar = new c.d();
            dVar.url = str;
            dVar.mimeType = str2;
            dVar.name = str3;
            cVar.RVu.put(str, dVar);
            cVar.trackId++;
            TPTrackInfo tPTrackInfo = new TPTrackInfo();
            tPTrackInfo.trackType = 3;
            tPTrackInfo.name = str3;
            tPTrackInfo.isSelected = false;
            tPTrackInfo.isExclusive = true;
            tPTrackInfo.isInternal = false;
            cVar.RVF.add(tPTrackInfo);
        }
        AppMethodBeat.o(188645);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void g(String str, String str2, List<TPOptionalParam> list) {
        AppMethodBeat.i(188646);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("error : addAudioTrackSource , state invalid");
            AppMethodBeat.o(188646);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.g(str, str2, list);
        }
        c cVar = this.RVT;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            c.a aVar = new c.a();
            aVar.url = str;
            aVar.name = str2;
            aVar.RVH = list;
            cVar.RVv.put(str, aVar);
            cVar.trackId++;
            TPTrackInfo tPTrackInfo = new TPTrackInfo();
            tPTrackInfo.trackType = 2;
            tPTrackInfo.name = str2;
            tPTrackInfo.isSelected = false;
            tPTrackInfo.isExclusive = true;
            tPTrackInfo.isInternal = false;
            cVar.RVF.add(tPTrackInfo);
        }
        AppMethodBeat.o(188646);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void selectTrack(int i2, long j2) {
        AppMethodBeat.i(188647);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("error : selectTrack , state invalid");
            AppMethodBeat.o(188647);
            throw illegalStateException;
        }
        TPTrackInfo[] trackInfo = getTrackInfo();
        if (trackInfo == null) {
            this.RVN.error("fatal err, tpTrackInfos is null");
            AppMethodBeat.o(188647);
        } else if (i2 < 0 || i2 > trackInfo.length - 1) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("error : track not found");
            AppMethodBeat.o(188647);
            throw illegalArgumentException;
        } else {
            if (this.RVO != null) {
                this.RVO.selectTrack(i2, j2);
            }
            this.RVT.a(i2, j2, trackInfo[i2]);
            AppMethodBeat.o(188647);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void deselectTrack(int i2, long j2) {
        AppMethodBeat.i(188648);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("error : deselectTrack , state invalid");
            AppMethodBeat.o(188648);
            throw illegalStateException;
        }
        TPTrackInfo[] trackInfo = getTrackInfo();
        if (trackInfo == null) {
            this.RVN.error("fatal err, tpTrackInfos is null");
            AppMethodBeat.o(188648);
        } else if (i2 < 0 || i2 > trackInfo.length - 1) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("error : track not found");
            AppMethodBeat.o(188648);
            throw illegalArgumentException;
        } else {
            if (this.RVO != null) {
                this.RVO.deselectTrack(i2, j2);
            }
            this.RVT.a(i2, trackInfo[i2]);
            AppMethodBeat.o(188648);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void prepare() {
        AppMethodBeat.i(188649);
        if (!this.RVU.aqS(1)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , prepare , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188649);
            throw illegalStateException;
        } else if (!this.RVT.hmL()) {
            IOException iOException = new IOException("error , prepare , data source invalid");
            AppMethodBeat.o(188649);
            throw iOException;
        } else {
            this.RVO = a(hmP(), this.RVM);
            if (this.RVO == null) {
                RuntimeException runtimeException = new RuntimeException("error , create player failed");
                AppMethodBeat.o(188649);
                throw runtimeException;
            }
            this.RVP.setInnerPlayStateState(3);
            this.RVP.changeState(3);
            this.RVO.prepare();
            AppMethodBeat.o(188649);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void prepareAsync() {
        AppMethodBeat.i(188650);
        if (!this.RVU.aqS(1)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , prepare , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188650);
            throw illegalStateException;
        } else if (!this.RVT.hmL()) {
            IllegalStateException illegalStateException2 = new IllegalStateException("error , prepare , state invalid , data source invalid");
            AppMethodBeat.o(188650);
            throw illegalStateException2;
        } else {
            this.RVO = a(hmP(), this.RVM);
            if (this.RVO == null) {
                RuntimeException runtimeException = new RuntimeException("error , create player failed");
                AppMethodBeat.o(188650);
                throw runtimeException;
            }
            this.RVP.setInnerPlayStateState(3);
            this.RVP.changeState(3);
            this.RVO.prepareAsync();
            AppMethodBeat.o(188650);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void start() {
        AppMethodBeat.i(188651);
        if (!this.RVU.aqS(5)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , start , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188651);
            throw illegalStateException;
        } else if (this.RVO == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException("error , start , player is null");
            AppMethodBeat.o(188651);
            throw illegalStateException2;
        } else {
            try {
                this.RVO.start();
                this.RVP.changeState(5);
                AppMethodBeat.o(188651);
            } catch (IllegalStateException e2) {
                IllegalStateException illegalStateException3 = new IllegalStateException("error , start ,state invalid");
                AppMethodBeat.o(188651);
                throw illegalStateException3;
            }
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void pause() {
        AppMethodBeat.i(188652);
        if (!this.RVU.aqS(6)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , pause , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188652);
            throw illegalStateException;
        } else if (this.RVO == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException("error , pause , player is null");
            AppMethodBeat.o(188652);
            throw illegalStateException2;
        } else if (this.RVQ) {
            this.RVP.changeState(6);
            AppMethodBeat.o(188652);
        } else {
            try {
                this.RVO.pause();
                this.RVP.changeState(6);
                AppMethodBeat.o(188652);
            } catch (IllegalStateException e2) {
                IllegalStateException illegalStateException3 = new IllegalStateException("error , pause ,state invalid");
                AppMethodBeat.o(188652);
                throw illegalStateException3;
            }
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void stop() {
        AppMethodBeat.i(188653);
        if (!this.RVU.aqS(7)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , stop , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188653);
            throw illegalStateException;
        } else if (this.RVO == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException("error , stop , player is null");
            AppMethodBeat.o(188653);
            throw illegalStateException2;
        } else {
            try {
                this.RVP.changeState(8);
                this.RVO.stop();
                this.RVP.changeState(9);
                AppMethodBeat.o(188653);
            } catch (IllegalStateException e2) {
                IllegalStateException illegalStateException3 = new IllegalStateException("error , stop ,state invalid");
                AppMethodBeat.o(188653);
                throw illegalStateException3;
            } catch (Throwable th) {
                this.RVP.changeState(9);
                AppMethodBeat.o(188653);
                throw th;
            }
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void reset() {
        AppMethodBeat.i(188654);
        this.RVN.info("reset, current state :" + this.RVP);
        if (this.RVO != null) {
            this.RVO.reset();
            this.RVO.release();
            this.RVO = null;
        }
        this.RVT.reset();
        b bVar = this.RVW;
        bVar.RVh = null;
        bVar.RVi = null;
        bVar.RVj = 0;
        bVar.RVk = 0;
        bVar.width = 0;
        bVar.height = 0;
        bVar.RVl = 0;
        bVar.RVm = null;
        bVar.RVn = 0;
        bVar.RVo = 0;
        bVar.channels = 0;
        bVar.sampleRate = 0;
        bVar.RVp = 0;
        bVar.RVq = 0;
        bVar.durationMs = 0;
        bVar.RVr = 0;
        bVar.RVs = 0;
        this.RVV = null;
        this.RVQ = false;
        this.RVP.changeState(1);
        this.RVP.setLastState(1);
        AppMethodBeat.o(188654);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void release() {
        AppMethodBeat.i(188655);
        this.RVN.info("release, current state :" + this.RVP);
        if (this.RVO != null) {
            this.RVO.release();
            this.RVO = null;
        }
        this.RVT.reset();
        this.RVR.clear();
        this.RVW = null;
        this.RVV = null;
        this.RVQ = false;
        this.RVP.changeState(11);
        AppMethodBeat.o(188655);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void seekTo(int i2) {
        AppMethodBeat.i(188656);
        if (!this.RVU.aqS(9)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188656);
            throw illegalStateException;
        } else if (this.RVO != null) {
            this.RVO.seekTo(i2);
            AppMethodBeat.o(188656);
        } else {
            this.RVN.warn("seekTo, mPlayerBase = null!");
            AppMethodBeat.o(188656);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void seekTo(int i2, @TPCommonEnum.TPSeekMode int i3) {
        AppMethodBeat.i(188657);
        if (!this.RVU.aqS(9)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188657);
            throw illegalStateException;
        } else if (this.RVO != null) {
            this.RVO.seekTo(i2, i3);
            AppMethodBeat.o(188657);
        } else {
            this.RVN.warn("seekTo, mPlayerBase = null!");
            AppMethodBeat.o(188657);
        }
    }

    @Override // com.tencent.thumbplayer.a.a
    public final void a(e eVar, int i2, long j2) {
        AppMethodBeat.i(188658);
        if (!this.RVU.aqS(17)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , switch definition , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188658);
            throw illegalStateException;
        }
        this.RVT.a(eVar, (Map<String, String>) null);
        if (this.RVO != null) {
            String str = "";
            if (this.RVX == 2) {
                str = eVar.RWt;
            } else if (this.RVX == 1) {
                str = eVar.RWs;
            }
            this.RVO.L(str, i2, j2);
            AppMethodBeat.o(188658);
            return;
        }
        this.RVN.warn("switchDefinition, mPlayerBase = null!");
        AppMethodBeat.o(188658);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void L(String str, @TPCommonEnum.TPSwitchDefMode int i2, long j2) {
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i2, long j2) {
        AppMethodBeat.i(188659);
        if (!this.RVU.aqS(17)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , switch definition , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188659);
            throw illegalStateException;
        }
        this.RVT.setDataSource(iTPMediaAsset);
        if (this.RVO != null) {
            this.RVO.a(iTPMediaAsset, i2, j2);
            AppMethodBeat.o(188659);
            return;
        }
        this.RVN.warn("switchDefinition, mPlayerBase = null!");
        AppMethodBeat.o(188659);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setOutputMute(boolean z) {
        AppMethodBeat.i(188660);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , setOutputMute , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188660);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.setOutputMute(z);
        } else {
            this.RVN.info("setOutputMute, mPlayerBase = null!");
        }
        this.RVT.RVA = z;
        AppMethodBeat.o(188660);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setAudioGainRatio(float f2) {
        AppMethodBeat.i(188661);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , setAudioGainRatio , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188661);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.setAudioGainRatio(f2);
        } else {
            this.RVN.info("setAudioGainRatio, mPlayerBase = null!");
        }
        this.RVT.RVB = f2;
        AppMethodBeat.o(188661);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setAudioNormalizeVolumeParams(String str) {
        AppMethodBeat.i(188662);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , setAudioNormalizeVolumeParams , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188662);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.setAudioNormalizeVolumeParams(str);
        } else {
            this.RVN.info("setAudioGainRatio, mPlayerBase = null!");
        }
        this.RVT.RVC = str;
        AppMethodBeat.o(188662);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setPlaySpeedRatio(float f2) {
        AppMethodBeat.i(188663);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , setPlaySpeedRatio , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188663);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.setPlaySpeedRatio(f2);
        } else {
            this.RVN.info("setPlaySpeedRatio, mPlayerBase = null!");
        }
        this.RVT.RVD = f2;
        AppMethodBeat.o(188663);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setLoopback(boolean z) {
        AppMethodBeat.i(188664);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188664);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.setLoopback(z);
        } else {
            this.RVN.info("setLoopback, mPlayerBase = null!");
        }
        this.RVT.setLoopback(z);
        AppMethodBeat.o(188664);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setLoopback(boolean z, long j2, long j3) {
        AppMethodBeat.i(188665);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.RVP);
            AppMethodBeat.o(188665);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.setLoopback(z, j2, j3);
        } else {
            this.RVN.info("setLoopback, mPlayerBase = null!");
        }
        this.RVT.setLoopback(z, j2, j3);
        AppMethodBeat.o(188665);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getPropertyLong(int i2) {
        AppMethodBeat.i(188666);
        if (this.RVO != null) {
            long propertyLong = this.RVO.getPropertyLong(i2);
            AppMethodBeat.o(188666);
            return propertyLong;
        }
        this.RVN.warn("getPropertyLong, mPlayerBase = null, return !");
        AppMethodBeat.o(188666);
        return -1;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final String getPropertyString(int i2) {
        AppMethodBeat.i(188667);
        if (this.RVO != null) {
            String propertyString = this.RVO.getPropertyString(i2);
            AppMethodBeat.o(188667);
            return propertyString;
        }
        this.RVN.warn("getPropertyString, mPlayerBase = null, return !");
        AppMethodBeat.o(188667);
        return "";
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getDurationMs() {
        AppMethodBeat.i(188668);
        if (this.RVW != null && this.RVW.durationMs > 0) {
            long j2 = this.RVW.durationMs;
            AppMethodBeat.o(188668);
            return j2;
        } else if (!this.RVU.aqS(11)) {
            AppMethodBeat.o(188668);
            return 0;
        } else if (this.RVO == null) {
            this.RVN.warn("getDurationMs, mPlayerBase = null, return 0!");
            AppMethodBeat.o(188668);
            return 0;
        } else {
            long durationMs = this.RVO.getDurationMs();
            if (this.RVW != null) {
                this.RVW.durationMs = durationMs;
            }
            AppMethodBeat.o(188668);
            return durationMs;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getCurrentPositionMs() {
        AppMethodBeat.i(188669);
        if (!this.RVU.aqS(12)) {
            if (this.RVW != null) {
                long j2 = this.RVW.RVq;
                AppMethodBeat.o(188669);
                return j2;
            }
            AppMethodBeat.o(188669);
            return 0;
        } else if (this.RVO == null) {
            this.RVN.warn("getCurrentPositionMs, mPlayerBase = null, return 0!");
            AppMethodBeat.o(188669);
            return 0;
        } else {
            long currentPositionMs = this.RVO.getCurrentPositionMs();
            if (this.RVW != null) {
                this.RVW.RVq = currentPositionMs;
            }
            AppMethodBeat.o(188669);
            return currentPositionMs;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getPlayableDurationMs() {
        long j2 = 0;
        AppMethodBeat.i(188670);
        if (!this.RVU.aqS(12)) {
            AppMethodBeat.o(188670);
        } else if (this.RVO == null) {
            this.RVN.warn("getBufferedDurationMs, mPlayerBase = null, return 0!");
            AppMethodBeat.o(188670);
        } else {
            j2 = this.RVO.getPlayableDurationMs();
            if (this.RVW != null) {
                this.RVW.RVr = j2;
            }
            AppMethodBeat.o(188670);
        }
        return j2;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final int getVideoWidth() {
        AppMethodBeat.i(188671);
        if (this.RVW != null && this.RVW.width > 0) {
            int i2 = (int) this.RVW.width;
            AppMethodBeat.o(188671);
            return i2;
        } else if (!this.RVU.aqS(13)) {
            this.RVN.warn("getVideoWidth, state error!");
            AppMethodBeat.o(188671);
            return 0;
        } else if (this.RVO == null) {
            this.RVN.warn("getVideoWidth, mPlayerBase = null, return 0!");
            AppMethodBeat.o(188671);
            return 0;
        } else {
            int videoWidth = this.RVO.getVideoWidth();
            if (this.RVW != null) {
                this.RVW.width = (long) videoWidth;
            }
            AppMethodBeat.o(188671);
            return videoWidth;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final int getVideoHeight() {
        AppMethodBeat.i(188672);
        if (this.RVW != null && this.RVW.height > 0) {
            int i2 = (int) this.RVW.height;
            AppMethodBeat.o(188672);
            return i2;
        } else if (!this.RVU.aqS(13)) {
            this.RVN.warn("getVideoHeight, state error!");
            AppMethodBeat.o(188672);
            return 0;
        } else if (this.RVO == null) {
            this.RVN.warn("getVideoHeight, mPlayerBase = null, return 0!");
            AppMethodBeat.o(188672);
            return 0;
        } else {
            int videoHeight = this.RVO.getVideoHeight();
            if (this.RVW != null) {
                this.RVW.height = (long) videoHeight;
            }
            AppMethodBeat.o(188672);
            return videoHeight;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final TPTrackInfo[] getTrackInfo() {
        AppMethodBeat.i(188673);
        if (this.RVO != null) {
            TPTrackInfo[] trackInfo = this.RVO.getTrackInfo();
            AppMethodBeat.o(188673);
            return trackInfo;
        }
        TPTrackInfo[] tPTrackInfoArr = (TPTrackInfo[]) this.RVT.RVF.toArray(new TPTrackInfo[0]);
        AppMethodBeat.o(188673);
        return tPTrackInfoArr;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void selectProgram(int i2, long j2) {
        AppMethodBeat.i(188674);
        if (!this.RVU.aqS(18)) {
            IllegalStateException illegalStateException = new IllegalStateException("error : selectProgram , state invalid");
            AppMethodBeat.o(188674);
            throw illegalStateException;
        }
        TPProgramInfo[] programInfo = getProgramInfo();
        if (programInfo == null) {
            programInfo = new TPProgramInfo[0];
        }
        if (i2 < 0 || i2 > programInfo.length - 1) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("error : program index not found");
            AppMethodBeat.o(188674);
            throw illegalArgumentException;
        }
        if (this.RVO != null) {
            this.RVO.selectProgram(i2, j2);
        }
        this.RVT.RVG = programInfo[i2];
        AppMethodBeat.o(188674);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final TPProgramInfo[] getProgramInfo() {
        AppMethodBeat.i(188675);
        if (this.RVO == null || this.RVO.getProgramInfo() == null) {
            TPProgramInfo[] tPProgramInfoArr = new TPProgramInfo[0];
            AppMethodBeat.o(188675);
            return tPProgramInfoArr;
        }
        TPProgramInfo[] programInfo = this.RVO.getProgramInfo();
        AppMethodBeat.o(188675);
        return programInfo;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void captureVideo(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        AppMethodBeat.i(188676);
        if (this.RVO != null) {
            this.RVO.captureVideo(tPCaptureParams, tPCaptureCallBack);
            AppMethodBeat.o(188676);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("error , no player for capture :" + this.RVP);
        AppMethodBeat.o(188676);
        throw illegalStateException;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.f fVar) {
        AppMethodBeat.i(188677);
        this.RVR.a(fVar);
        AppMethodBeat.o(188677);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.AbstractC2201c cVar) {
        AppMethodBeat.i(188678);
        this.RVR.a(cVar);
        AppMethodBeat.o(188678);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.e eVar) {
        AppMethodBeat.i(188679);
        this.RVR.a(eVar);
        AppMethodBeat.o(188679);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.d dVar) {
        AppMethodBeat.i(188680);
        this.RVR.a(dVar);
        AppMethodBeat.o(188680);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.g gVar) {
        AppMethodBeat.i(188681);
        this.RVR.a(gVar);
        AppMethodBeat.o(188681);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.m mVar) {
        AppMethodBeat.i(188682);
        this.RVR.a(mVar);
        AppMethodBeat.o(188682);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.i iVar) {
        AppMethodBeat.i(188683);
        this.RVR.a(iVar);
        AppMethodBeat.o(188683);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.j jVar) {
        AppMethodBeat.i(188684);
        this.RVR.a(jVar);
        AppMethodBeat.o(188684);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.k kVar) {
        AppMethodBeat.i(188685);
        this.RVR.a(kVar);
        AppMethodBeat.o(188685);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.a aVar) {
        AppMethodBeat.i(188686);
        this.RVR.b(aVar);
        AppMethodBeat.o(188686);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.l lVar) {
        AppMethodBeat.i(188687);
        this.RVR.b(lVar);
        AppMethodBeat.o(188687);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.b bVar) {
        AppMethodBeat.i(188688);
        this.RVR.b(bVar);
        AppMethodBeat.o(188688);
    }

    @Override // com.tencent.thumbplayer.a.a
    public final void setOnPlayerStateChangeListener(c.h hVar) {
        this.RVR.RWl = hVar;
    }

    private int hmP() {
        AppMethodBeat.i(188689);
        if (this.RVV == null) {
            this.RVV = a(this.RVT);
        }
        int a2 = this.RVV.a(this.RVW);
        AppMethodBeat.o(188689);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final com.tencent.thumbplayer.a.a.b a(int i2, b bVar) {
        com.tencent.thumbplayer.a.a.b bVar2;
        boolean z = true;
        AppMethodBeat.i(188690);
        if (i2 == 1) {
            try {
                this.RVN.info("to create androidPlayer");
                Context context = this.mContext;
                c cVar = this.RVT;
                if (cVar.RVy == null) {
                    z = false;
                } else if (cVar.RVy.mType != 2) {
                    z = false;
                }
                if (z) {
                    bVar2 = new com.tencent.thumbplayer.a.a.a.d(context, bVar);
                } else {
                    bVar2 = new com.tencent.thumbplayer.a.a.a.e(context, bVar);
                }
            } catch (Exception e2) {
                this.RVN.info("to create Player," + e2.toString());
                bVar2 = null;
            }
        } else if (i2 == 2) {
            this.RVN.info("to create thumbPlayer");
            bVar2 = com.tencent.thumbplayer.a.a.d.a(this.mContext, bVar);
        } else if (i2 == 3) {
            this.RVN.info("to create thumbPlayer software dec");
            bVar2 = com.tencent.thumbplayer.a.a.d.a(this.mContext, bVar);
        } else {
            this.RVN.info("to create no Player");
            bVar2 = null;
        }
        if (bVar2 == null) {
            this.RVN.info("play is null!");
            AppMethodBeat.o(188690);
            return null;
        }
        this.RVX = i2;
        a(bVar2);
        AppMethodBeat.o(188690);
        return bVar2;
    }

    private void a(com.tencent.thumbplayer.a.a.b bVar) {
        AppMethodBeat.i(188691);
        bVar.a((c.e) this.RVS);
        bVar.a((c.f) this.RVS);
        bVar.a((c.AbstractC2201c) this.RVS);
        bVar.a((c.d) this.RVS);
        bVar.a((c.g) this.RVS);
        bVar.a((c.m) this.RVS);
        bVar.a((c.i) this.RVS);
        if (hmQ()) {
            bVar.a((c.k) this.RVS);
            bVar.a((c.a) this.RVS);
            bVar.a((c.j) this.RVS);
            bVar.a((c.l) this.RVS);
            bVar.a((c.b) this.RVS);
        }
        if (1 == this.RVT.RVy.mType) {
            bVar.setDataSource(this.RVT.RVy.RWn);
        } else if (3 == this.RVT.RVy.mType) {
            if (this.RVX == 2) {
                bVar.setDataSource(this.RVT.RVy.RWq.RWt, this.RVT.RVy.RWo);
            } else if (this.RVX == 1) {
                bVar.setDataSource(this.RVT.RVy.RWq.RWs, this.RVT.RVy.RWo);
            }
        } else if (2 == this.RVT.RVy.mType) {
            bVar.setDataSource(this.RVT.RVy.RWp);
        }
        for (TPOptionalParam tPOptionalParam : this.RVT.hmO()) {
            if (com.tencent.thumbplayer.a.b.b.b.are(tPOptionalParam.getKey()) == null && com.tencent.thumbplayer.a.b.b.b.arf(tPOptionalParam.getKey()) == null) {
                this.RVN.warn("init param=[" + tPOptionalParam + "] is not valid native param");
            } else {
                bVar.setPlayerOptionalParam(tPOptionalParam);
            }
        }
        for (int i2 = 0; i2 < this.RVT.RVF.size(); i2++) {
            TPTrackInfo tPTrackInfo = this.RVT.RVF.get(i2);
            if (tPTrackInfo.trackType == 3) {
                Iterator<c.d> it = this.RVT.hmM().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c.d next = it.next();
                    if (!TextUtils.isEmpty(next.name) && next.name.equals(tPTrackInfo.name)) {
                        bVar.addSubtitleSource(next.url, next.mimeType, next.name);
                        break;
                    }
                }
            } else if (tPTrackInfo.trackType == 2) {
                Iterator<c.a> it2 = this.RVT.hmN().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    c.a next2 = it2.next();
                    if (!TextUtils.isEmpty(next2.name) && next2.name.equals(tPTrackInfo.name)) {
                        bVar.g(next2.url, next2.name, next2.RVH);
                        break;
                    }
                }
            }
        }
        Iterator<c.C2203c> it3 = this.RVT.RVw.iterator();
        while (it3.hasNext()) {
            c.C2203c next3 = it3.next();
            if (next3.RVL.isSelected) {
                TPTrackInfo[] trackInfo = bVar.getTrackInfo();
                if (trackInfo == null) {
                    this.RVN.error("playerTrackInfoList is null.");
                } else {
                    for (int i3 = 0; i3 < trackInfo.length; i3++) {
                        if (next3.RVL.name.equals(trackInfo[i3].name)) {
                            bVar.selectTrack(i3, next3.RVK);
                        }
                    }
                }
            }
        }
        if (this.RVT.RVz != null) {
            bVar.setLoopback(this.RVT.RVz.RVI, this.RVT.RVz.startPositionMs, this.RVT.RVz.RVJ);
        }
        bVar.setOutputMute(this.RVT.RVA);
        if (this.RVT.RVB != 0.0f) {
            bVar.setAudioGainRatio(this.RVT.RVB);
        }
        if (this.RVT.RVD != 0.0f) {
            bVar.setPlaySpeedRatio(this.RVT.RVD);
        }
        if (!"".equals(this.RVT.RVC)) {
            bVar.setAudioNormalizeVolumeParams(this.RVT.RVC);
        }
        if (this.RVT.RVt instanceof SurfaceHolder) {
            bVar.setSurfaceHolder((SurfaceHolder) this.RVT.RVt);
        } else if (this.RVT.RVt instanceof Surface) {
            bVar.setSurface((Surface) this.RVT.RVt);
        }
        bVar.setPlayerOptionalParam(new TPOptionalParam().buildQueueInt(204, this.RVV.hnd()));
        AppMethodBeat.o(188691);
    }

    /* access modifiers changed from: package-private */
    public final boolean hmQ() {
        return this.RVX == 2 || this.RVX == 3;
    }

    private static com.tencent.thumbplayer.a.b.a a(c cVar) {
        com.tencent.thumbplayer.a.b.a.a aVar;
        AppMethodBeat.i(188692);
        try {
            aVar = new com.tencent.thumbplayer.a.b.a.a(cVar);
        } catch (IllegalArgumentException e2) {
            aVar = new com.tencent.thumbplayer.a.b.a.a(null);
        }
        if (aVar.RYw) {
            com.tencent.thumbplayer.a.b.d dVar = new com.tencent.thumbplayer.a.b.d(aVar);
            AppMethodBeat.o(188692);
            return dVar;
        }
        com.tencent.thumbplayer.a.b.c cVar2 = new com.tencent.thumbplayer.a.b.c(aVar);
        AppMethodBeat.o(188692);
        return cVar2;
    }

    @Override // com.tencent.thumbplayer.a.a.c.h
    public final void onStateChange(int i2, int i3) {
        AppMethodBeat.i(188693);
        this.RVR.onStateChange(i2, i3);
        AppMethodBeat.o(188693);
    }

    /* access modifiers changed from: package-private */
    public class a implements c.a, c.b, c.AbstractC2201c, c.d, c.e, c.f, c.g, c.i, c.j, c.k, c.l, c.m {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        @Override // com.tencent.thumbplayer.a.a.c.f
        public final void tf() {
            TPProgramInfo tPProgramInfo;
            AppMethodBeat.i(188620);
            d dVar = d.this;
            dVar.RVR.a(1000, (long) dVar.RVX, 0, (Object) null);
            if (dVar.RVQ) {
                if (dVar.RVP.innerPlayState() != 3) {
                    dVar.RVN.warn("handleOnPrepared, invalid state, mIsRetrying.");
                    AppMethodBeat.o(188620);
                    return;
                }
            } else if (!dVar.RVU.aqT(1)) {
                dVar.RVN.info("handleOnPrepared, invalid state");
                AppMethodBeat.o(188620);
                return;
            }
            if (dVar.hmQ()) {
                dVar.RVW = b.bqw(dVar.getPropertyString(0));
                dVar.RVW.RVp = (int) dVar.RVO.getPropertyLong(204);
                dVar.RVW.RVj = (int) dVar.RVO.getPropertyLong(203);
                dVar.RVW.RVn = (int) dVar.RVO.getPropertyLong(102);
                dVar.RVW.RVk = (int) dVar.RVO.getPropertyLong(201);
            }
            if (dVar.RVW == null) {
                dVar.RVW = new b();
            }
            dVar.RVW.durationMs = dVar.RVO.getDurationMs();
            TPOptionalParam aqR = dVar.RVT.aqR(100);
            if (aqR != null) {
                dVar.RVW.RVq = aqR.getParamLong().value;
            }
            com.tencent.thumbplayer.a.a.b bVar = dVar.RVO;
            TPProgramInfo[] programInfo = dVar.getProgramInfo();
            if (programInfo != null && (tPProgramInfo = dVar.RVT.RVG) != null) {
                int i2 = 0;
                while (true) {
                    if (i2 < programInfo.length) {
                        if (!TextUtils.isEmpty(tPProgramInfo.name) && programInfo[i2] != null && tPProgramInfo.name.equals(programInfo[i2].name)) {
                            bVar.selectProgram(i2, -1);
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            if (dVar.RVQ) {
                dVar.RVQ = false;
                dVar.RVN.info("handleOnPrepared, mIsRetrying, recoverState, state:" + dVar.RVP.state());
                int state = dVar.RVP.state();
                dVar.RVP.changeState(4);
                if (dVar.RVP.lastState() == 3) {
                    dVar.RVR.tf();
                }
                dVar.RVR.a(1014, 0, 0, (Object) null);
                switch (state) {
                    case 5:
                        try {
                            dVar.RVO.start();
                            dVar.RVP.changeState(5);
                            AppMethodBeat.o(188620);
                            return;
                        } catch (IllegalStateException e2) {
                            dVar.RVN.r(e2);
                            break;
                        }
                }
                AppMethodBeat.o(188620);
                return;
            }
            dVar.RVP.setInnerPlayStateState(4);
            dVar.RVP.changeState(4);
            dVar.RVR.tf();
            AppMethodBeat.o(188620);
        }

        @Override // com.tencent.thumbplayer.a.a.c.AbstractC2201c
        public final void onCompletion() {
            AppMethodBeat.i(188621);
            d dVar = d.this;
            if (!dVar.RVU.aqT(2)) {
                dVar.RVN.info("handleOnComplete, invalid state");
                AppMethodBeat.o(188621);
                return;
            }
            dVar.RVP.changeState(7);
            dVar.RVR.onCompletion();
            AppMethodBeat.o(188621);
        }

        @Override // com.tencent.thumbplayer.a.a.c.e
        public final void a(int i2, long j2, long j3, Object obj) {
            AppMethodBeat.i(188622);
            d dVar = d.this;
            if (dVar.RVQ) {
                dVar.RVN.info("handleOnInfo, mIsRetrying");
                AppMethodBeat.o(188622);
                return;
            }
            if (i2 == 152 && dVar.RVW != null) {
                dVar.RVW.RVs = ((int) j2) + 1;
            }
            dVar.RVR.a(i2, j2, j3, obj);
            AppMethodBeat.o(188622);
        }

        @Override // com.tencent.thumbplayer.a.a.c.d
        public final void a(int i2, int i3, long j2, long j3) {
            AppMethodBeat.i(188623);
            d dVar = d.this;
            if (dVar.RVU.aqT(4)) {
                int a2 = dVar.RVV.a(dVar.RVW, new com.tencent.thumbplayer.a.b.a.b(dVar.RVX, i2, i3, dVar.RVW.definition));
                if (a2 == 0) {
                    dVar.RVR.a(i2, i3, j2, j3);
                    AppMethodBeat.o(188623);
                    return;
                }
                try {
                    dVar.RVR.a(1013, (long) a2, 0, (Object) null);
                    dVar.RVP.setLastState(dVar.RVP.state());
                    if (dVar.RVO != null) {
                        long currentPositionMs = dVar.RVO.getCurrentPositionMs();
                        dVar.RVN.info("switchPlayer, current position:".concat(String.valueOf(currentPositionMs)));
                        dVar.RVW.RVq = currentPositionMs;
                        dVar.RVW.RVr = dVar.RVO.getPlayableDurationMs();
                        dVar.RVO.reset();
                        dVar.RVO.release();
                    }
                    dVar.RVO = dVar.a(a2, dVar.RVM);
                    if (dVar.RVO == null) {
                        RuntimeException runtimeException = new RuntimeException("error , create player failed");
                        AppMethodBeat.o(188623);
                        throw runtimeException;
                    }
                    dVar.RVQ = true;
                    dVar.RVN.info("switch player to type:" + dVar.RVX);
                    if (dVar.RVW != null) {
                        dVar.RVO.setPlayerOptionalParam(new TPOptionalParam().buildLong(100, dVar.RVW.RVq));
                    }
                    dVar.RVP.setInnerPlayStateState(3);
                    dVar.RVO.prepareAsync();
                    AppMethodBeat.o(188623);
                    return;
                } catch (IOException e2) {
                    dVar.RVN.r(e2);
                    dVar.RVR.a(i2, i3, j2, j3);
                    AppMethodBeat.o(188623);
                    return;
                } catch (IllegalStateException e3) {
                    dVar.RVN.r(e3);
                    dVar.RVR.a(i2, i3, j2, j3);
                }
            }
            AppMethodBeat.o(188623);
        }

        @Override // com.tencent.thumbplayer.a.a.c.g
        public final void cJH() {
            AppMethodBeat.i(188624);
            d dVar = d.this;
            if (dVar.RVU.aqT(5)) {
                dVar.RVR.cJH();
            }
            AppMethodBeat.o(188624);
        }

        @Override // com.tencent.thumbplayer.a.a.c.m
        public final void aI(long j2, long j3) {
            AppMethodBeat.i(188625);
            d dVar = d.this;
            if (!dVar.RVU.aqT(6)) {
                dVar.RVN.info("handleOnVideoSizeChange, invalid state");
                AppMethodBeat.o(188625);
                return;
            }
            dVar.RVW.height = j3;
            dVar.RVW.width = j2;
            dVar.RVR.aI(j2, j3);
            AppMethodBeat.o(188625);
        }

        @Override // com.tencent.thumbplayer.a.a.c.i
        public final void a(TPSubtitleData tPSubtitleData) {
            AppMethodBeat.i(188626);
            d dVar = d.this;
            if (!dVar.RVU.aqT(7)) {
                dVar.RVN.info("handleOnSubtitleData, invalid state");
                AppMethodBeat.o(188626);
                return;
            }
            dVar.RVR.a(tPSubtitleData);
            AppMethodBeat.o(188626);
        }

        @Override // com.tencent.thumbplayer.a.a.c.j
        public final void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            AppMethodBeat.i(188627);
            d dVar = d.this;
            if (!dVar.RVU.aqT(7)) {
                dVar.RVN.info("handleOnSubtitleFrameOut, invalid state");
                AppMethodBeat.o(188627);
                return;
            }
            dVar.RVR.a(tPSubtitleFrameBuffer);
            AppMethodBeat.o(188627);
        }

        @Override // com.tencent.thumbplayer.a.a.c.k
        public final void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            AppMethodBeat.i(188628);
            d dVar = d.this;
            if (!dVar.RVU.aqT(7)) {
                dVar.RVN.info("handleOnVideoFrameOut, invalid state");
                AppMethodBeat.o(188628);
                return;
            }
            dVar.RVR.a(tPVideoFrameBuffer);
            AppMethodBeat.o(188628);
        }

        @Override // com.tencent.thumbplayer.a.a.c.a
        public final void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
            AppMethodBeat.i(188629);
            d dVar = d.this;
            if (dVar.RVU.aqT(7)) {
                dVar.RVR.a(tPAudioFrameBuffer);
            }
            AppMethodBeat.o(188629);
        }

        @Override // com.tencent.thumbplayer.a.a.c.l
        public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            AppMethodBeat.i(188630);
            d dVar = d.this;
            if (!dVar.RVU.aqT(7)) {
                AppMethodBeat.o(188630);
                return null;
            }
            TPPostProcessFrameBuffer a2 = dVar.RVR.a(tPPostProcessFrameBuffer);
            AppMethodBeat.o(188630);
            return a2;
        }

        @Override // com.tencent.thumbplayer.a.a.c.b
        public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            AppMethodBeat.i(188631);
            d dVar = d.this;
            if (!dVar.RVU.aqT(7)) {
                AppMethodBeat.o(188631);
                return null;
            }
            TPPostProcessFrameBuffer b2 = dVar.RVR.b(tPPostProcessFrameBuffer);
            AppMethodBeat.o(188631);
            return b2;
        }
    }
}
