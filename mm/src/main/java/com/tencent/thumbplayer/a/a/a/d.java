package com.tencent.thumbplayer.a.a.a;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.b;
import com.tencent.thumbplayer.a.a.c;
import com.tencent.thumbplayer.a.c;
import com.tencent.thumbplayer.a.e;
import com.tencent.thumbplayer.a.g;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerState;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements b {
    private com.tencent.thumbplayer.f.b RVM;
    com.tencent.thumbplayer.f.a RVN;
    b RVO;
    TPPlayerState RVP;
    e RVR;
    c RVT;
    g RVU;
    com.tencent.thumbplayer.a.b RVW;
    private a RWI;
    List<ITPMediaTrackClip> RWJ;
    int RWK = 0;
    boolean RWL;
    boolean RWM;
    LinkedList<Long> RWN;
    private Context mContext;

    public d(Context context, com.tencent.thumbplayer.f.b bVar) {
        AppMethodBeat.i(188790);
        this.RVM = new com.tencent.thumbplayer.f.b(bVar, "TPSystemClipPlayer");
        this.RVN = new com.tencent.thumbplayer.f.a(this.RVM);
        this.mContext = context;
        this.RVP = new TPPlayerState();
        this.RVT = new c();
        this.RWI = new a(this, (byte) 0);
        this.RVR = new e(this.RVN.RVM.tag);
        this.RVU = new g(this.RVP);
        this.RWJ = new ArrayList();
        AppMethodBeat.o(188790);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void updateLoggerContext(com.tencent.thumbplayer.f.b bVar) {
        AppMethodBeat.i(188791);
        this.RVN.a(new com.tencent.thumbplayer.f.b(bVar, "TPSystemClipPlayer"));
        if (!(this.RVR == null || bVar == null)) {
            this.RVR.bqx(this.RVN.RVM.tag);
        }
        AppMethodBeat.o(188791);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setPlayerOptionalParam(TPOptionalParam tPOptionalParam) {
        AppMethodBeat.i(188792);
        if (!this.RVU.aqS(3)) {
            IllegalStateException illegalStateException = new IllegalStateException("setPlayerOptionalParam , state invalid");
            AppMethodBeat.o(188792);
            throw illegalStateException;
        }
        if (tPOptionalParam.getKey() == 100) {
            int i2 = (int) tPOptionalParam.getParamLong().value;
            this.RVN.debug("start position:".concat(String.valueOf(i2)));
            for (int i3 = 0; i3 < this.RWJ.size(); i3++) {
                if (this.RWJ.get(i3).getStartPositionMs() <= ((long) i2) && ((long) i2) <= this.RWJ.get(i3).getStartPositionMs() + this.RWJ.get(i3).getOriginalDurationMs()) {
                    this.RWK = i3;
                    this.RVT.setDataSource(this.RWJ.get(i3).getFilePath());
                    tPOptionalParam.getParamLong().value = ((long) i2) - this.RWJ.get(i3).getStartPositionMs();
                }
            }
        }
        if (this.RVO != null) {
            this.RVO.setPlayerOptionalParam(tPOptionalParam);
        }
        this.RVT.a(tPOptionalParam);
        AppMethodBeat.o(188792);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setSurface(Surface surface) {
        AppMethodBeat.i(188793);
        if (!this.RVU.aqS(4)) {
            IllegalStateException illegalStateException = new IllegalStateException("setSurface , state invalid");
            AppMethodBeat.o(188793);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.setSurface(surface);
        }
        this.RVT.RVt = surface;
        AppMethodBeat.o(188793);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(188794);
        if (!this.RVU.aqS(4)) {
            IllegalStateException illegalStateException = new IllegalStateException("setSurfaceHolder , state invalid");
            AppMethodBeat.o(188794);
            throw illegalStateException;
        }
        if (this.RVO != null) {
            this.RVO.setSurfaceHolder(surfaceHolder);
        }
        this.RVT.RVt = surfaceHolder;
        AppMethodBeat.o(188794);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(String str, Map<String, String> map) {
        AppMethodBeat.i(188795);
        this.RVT.setDataSource(str, map);
        this.RVP.changeState(2);
        AppMethodBeat.o(188795);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(ParcelFileDescriptor parcelFileDescriptor) {
        AppMethodBeat.i(188796);
        this.RVT.setDataSource(parcelFileDescriptor);
        this.RVP.changeState(2);
        AppMethodBeat.o(188796);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setDataSource(ITPMediaAsset iTPMediaAsset) {
        AppMethodBeat.i(188797);
        try {
            this.RWJ = a(iTPMediaAsset);
            this.RVT.setDataSource(this.RWJ.get(this.RWK).getFilePath());
            this.RVP.changeState(2);
            AppMethodBeat.o(188797);
        } catch (Exception e2) {
            this.RVN.r(e2);
            IllegalStateException illegalStateException = new IllegalStateException("exception when system clip player set data source!");
            AppMethodBeat.o(188797);
            throw illegalStateException;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void addSubtitleSource(String str, String str2, String str3) {
        AppMethodBeat.i(188798);
        this.RVN.error("addSubtitleSource not supported.");
        AppMethodBeat.o(188798);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void g(String str, String str2, List<TPOptionalParam> list) {
        AppMethodBeat.i(188799);
        this.RVN.error("addAudioTrackSource not supported.");
        AppMethodBeat.o(188799);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void selectTrack(int i2, long j2) {
        AppMethodBeat.i(188800);
        this.RVN.error("selectTrack not supported.");
        AppMethodBeat.o(188800);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void deselectTrack(int i2, long j2) {
        AppMethodBeat.i(188801);
        this.RVN.error("deselectTrack not supported.");
        AppMethodBeat.o(188801);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void prepare() {
        AppMethodBeat.i(188802);
        if (!this.RVU.aqS(1)) {
            AppMethodBeat.o(188802);
        } else if (!this.RVT.hmL()) {
            IOException iOException = new IOException("error , prepare , data source invalid");
            AppMethodBeat.o(188802);
            throw iOException;
        } else {
            this.RVO = hmS();
            if (this.RVO == null) {
                RuntimeException runtimeException = new RuntimeException("error , create player failed");
                AppMethodBeat.o(188802);
                throw runtimeException;
            }
            this.RVP.changeState(3);
            this.RVO.prepare();
            AppMethodBeat.o(188802);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void prepareAsync() {
        AppMethodBeat.i(188803);
        if (!this.RVU.aqS(1)) {
            AppMethodBeat.o(188803);
        } else if (!this.RVT.hmL()) {
            IllegalStateException illegalStateException = new IllegalStateException("error , prepare , state invalid , data source invalid");
            AppMethodBeat.o(188803);
            throw illegalStateException;
        } else {
            this.RVO = hmS();
            if (this.RVO == null) {
                RuntimeException runtimeException = new RuntimeException("error , create player failed");
                AppMethodBeat.o(188803);
                throw runtimeException;
            }
            this.RVP.changeState(3);
            this.RVO.prepareAsync();
            AppMethodBeat.o(188803);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void start() {
        AppMethodBeat.i(188804);
        if (!this.RVU.aqS(5)) {
            AppMethodBeat.o(188804);
        } else if (this.RVO == null) {
            IllegalStateException illegalStateException = new IllegalStateException("error , start , player is null");
            AppMethodBeat.o(188804);
            throw illegalStateException;
        } else {
            try {
                this.RVO.start();
                this.RVP.changeState(5);
                AppMethodBeat.o(188804);
            } catch (IllegalStateException e2) {
                IllegalStateException illegalStateException2 = new IllegalStateException("error , start ,state invalid");
                AppMethodBeat.o(188804);
                throw illegalStateException2;
            }
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void pause() {
        AppMethodBeat.i(188805);
        if (!this.RVU.aqS(6)) {
            AppMethodBeat.o(188805);
        } else if (this.RVO == null) {
            IllegalStateException illegalStateException = new IllegalStateException("error , pause , player is null");
            AppMethodBeat.o(188805);
            throw illegalStateException;
        } else {
            try {
                this.RVO.pause();
                this.RVP.changeState(6);
                AppMethodBeat.o(188805);
            } catch (IllegalStateException e2) {
                IllegalStateException illegalStateException2 = new IllegalStateException("error , pause ,state invalid");
                AppMethodBeat.o(188805);
                throw illegalStateException2;
            }
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void stop() {
        AppMethodBeat.i(188806);
        if (!this.RVU.aqS(7)) {
            AppMethodBeat.o(188806);
        } else if (this.RVO == null) {
            IllegalStateException illegalStateException = new IllegalStateException("error , stop , player is null");
            AppMethodBeat.o(188806);
            throw illegalStateException;
        } else {
            try {
                this.RVP.changeState(8);
                this.RVO.stop();
                this.RVP.changeState(9);
                AppMethodBeat.o(188806);
            } catch (IllegalStateException e2) {
                IllegalStateException illegalStateException2 = new IllegalStateException("error , pause ,state invalid");
                AppMethodBeat.o(188806);
                throw illegalStateException2;
            } catch (Throwable th) {
                this.RVP.changeState(9);
                AppMethodBeat.o(188806);
                throw th;
            }
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void reset() {
        AppMethodBeat.i(188807);
        this.RVN.info("reset, current state:" + this.RVP);
        if (this.RVO != null) {
            this.RVO.reset();
        }
        this.RVT.reset();
        this.RVR.clear();
        this.RVP.changeState(1);
        AppMethodBeat.o(188807);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void release() {
        AppMethodBeat.i(188808);
        this.RVN.info("release, current state:" + this.RVP);
        if (this.RVO != null) {
            this.RVO.release();
            this.RVO = null;
        }
        this.RVT.reset();
        this.RVR.clear();
        this.RVP.changeState(11);
        AppMethodBeat.o(188808);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void seekTo(int i2) {
        AppMethodBeat.i(188809);
        if (!this.RVU.aqS(9)) {
            AppMethodBeat.o(188809);
            return;
        }
        if (((long) i2) < hmR().getStartPositionMs() || ((long) i2) > hmR().getStartPositionMs() + hmR().getOriginalDurationMs()) {
            aqU(i2);
        } else if (this.RVO != null) {
            this.RVN.debug("seek to:".concat(String.valueOf(i2)));
            this.RVO.seekTo((int) (((long) i2) - hmR().getStartPositionMs()));
            AppMethodBeat.o(188809);
            return;
        }
        AppMethodBeat.o(188809);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void seekTo(int i2, @TPCommonEnum.TPSeekMode int i3) {
        AppMethodBeat.i(188810);
        if (!this.RVU.aqS(9)) {
            AppMethodBeat.o(188810);
            return;
        }
        if (((long) i2) < hmR().getStartPositionMs() || ((long) i2) > hmR().getStartPositionMs() + hmR().getOriginalDurationMs()) {
            aqU(i2);
        } else if (this.RVO != null) {
            this.RVN.debug("seek to:" + i2 + "/mode=" + i3);
            this.RVO.seekTo((int) (((long) i2) - hmR().getStartPositionMs()), i3);
            AppMethodBeat.o(188810);
            return;
        }
        AppMethodBeat.o(188810);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void L(String str, @TPCommonEnum.TPSwitchDefMode int i2, long j2) {
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i2, long j2) {
        AppMethodBeat.i(188811);
        List<ITPMediaTrackClip> a2 = a(iTPMediaAsset);
        if (com.tencent.thumbplayer.utils.b.isEmpty(a2)) {
            IllegalStateException illegalStateException = new IllegalStateException("exception when switch Definition with clip mediaAsset empty source!");
            AppMethodBeat.o(188811);
            throw illegalStateException;
        }
        long currentPositionMs = getCurrentPositionMs();
        try {
            this.RWJ = a2;
            this.RWM = true;
            if (com.tencent.thumbplayer.utils.b.isEmpty(this.RWN)) {
                this.RWN = new LinkedList<>();
            }
            this.RWN.offer(Long.valueOf(j2));
            this.RVN.info("try to switch definition with system clip player, current clipNo:" + this.RWK);
            aqU((int) currentPositionMs);
            AppMethodBeat.o(188811);
        } catch (Exception e2) {
            this.RVN.r(e2);
            IllegalStateException illegalStateException2 = new IllegalStateException("exception when system clip player switch definition!");
            AppMethodBeat.o(188811);
            throw illegalStateException2;
        }
    }

    private static List<ITPMediaTrackClip> a(ITPMediaAsset iTPMediaAsset) {
        ArrayList arrayList;
        AppMethodBeat.i(188812);
        if ((iTPMediaAsset instanceof com.tencent.thumbplayer.c.b) || (iTPMediaAsset instanceof com.tencent.thumbplayer.c.d) || (iTPMediaAsset instanceof com.tencent.thumbplayer.c.e)) {
            ArrayList arrayList2 = new ArrayList();
            if (iTPMediaAsset instanceof com.tencent.thumbplayer.c.b) {
                List<ITPMediaTrack> allAVTracks = ((com.tencent.thumbplayer.c.b) iTPMediaAsset).getAllAVTracks();
                if (com.tencent.thumbplayer.utils.b.isEmpty(allAVTracks) || allAVTracks.get(0) == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("empty av tracks when set data source!");
                    AppMethodBeat.o(188812);
                    throw illegalStateException;
                }
                arrayList = allAVTracks.get(0).getAllTrackClips();
            } else if (iTPMediaAsset instanceof com.tencent.thumbplayer.c.d) {
                arrayList = ((com.tencent.thumbplayer.c.d) iTPMediaAsset).getAllTrackClips();
            } else {
                arrayList2.add((ITPMediaTrackClip) iTPMediaAsset);
                arrayList = arrayList2;
            }
            long j2 = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((ITPMediaTrackClip) arrayList.get(i2)).setStartPositionMs(j2);
                j2 += ((ITPMediaTrackClip) arrayList.get(i2)).getOriginalDurationMs();
            }
            AppMethodBeat.o(188812);
            return arrayList;
        }
        IllegalStateException illegalStateException2 = new IllegalStateException("system mediaPlayer : media asset is illegal source!");
        AppMethodBeat.o(188812);
        throw illegalStateException2;
    }

    private void aqU(int i2) {
        AppMethodBeat.i(188813);
        for (int i3 = 0; i3 < this.RWJ.size(); i3++) {
            if (this.RWJ.get(i3).getStartPositionMs() <= ((long) i2) && ((long) i2) <= this.RWJ.get(i3).getStartPositionMs() + this.RWJ.get(i3).getOriginalDurationMs()) {
                try {
                    aX(i3, ((long) i2) - this.RWJ.get(i3).getStartPositionMs());
                } catch (IOException e2) {
                    this.RVN.info("selectClipPlayer:" + e2.toString());
                }
            }
        }
        AppMethodBeat.o(188813);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setOutputMute(boolean z) {
        AppMethodBeat.i(188814);
        if (!this.RVU.aqS(3)) {
            AppMethodBeat.o(188814);
            return;
        }
        if (this.RVO != null) {
            this.RVO.setOutputMute(z);
        }
        this.RVT.RVA = z;
        AppMethodBeat.o(188814);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setAudioGainRatio(float f2) {
        AppMethodBeat.i(188815);
        if (!this.RVU.aqS(3)) {
            AppMethodBeat.o(188815);
            return;
        }
        if (this.RVO != null) {
            this.RVO.setAudioGainRatio(f2);
        }
        this.RVT.RVB = f2;
        AppMethodBeat.o(188815);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setAudioNormalizeVolumeParams(String str) {
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setPlaySpeedRatio(float f2) {
        AppMethodBeat.i(188816);
        if (!this.RVU.aqS(3)) {
            AppMethodBeat.o(188816);
            return;
        }
        if (this.RVO != null) {
            this.RVO.setPlaySpeedRatio(f2);
        }
        this.RVT.RVD = f2;
        AppMethodBeat.o(188816);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setLoopback(boolean z) {
        AppMethodBeat.i(188817);
        if (!this.RVU.aqS(3)) {
            AppMethodBeat.o(188817);
            return;
        }
        if (this.RVO != null) {
            this.RVO.setLoopback(z);
        }
        this.RVT.setLoopback(z);
        AppMethodBeat.o(188817);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void setLoopback(boolean z, long j2, long j3) {
        AppMethodBeat.i(188818);
        if (!this.RVU.aqS(3)) {
            AppMethodBeat.o(188818);
            return;
        }
        if (this.RVO != null) {
            this.RVO.setLoopback(z, j2, j3);
        }
        this.RVT.setLoopback(z, j2, j3);
        AppMethodBeat.o(188818);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getPropertyLong(int i2) {
        AppMethodBeat.i(188819);
        if (this.RVO != null) {
            long propertyLong = this.RVO.getPropertyLong(i2);
            AppMethodBeat.o(188819);
            return propertyLong;
        }
        AppMethodBeat.o(188819);
        return -1;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final String getPropertyString(int i2) {
        AppMethodBeat.i(188820);
        if (this.RVO != null) {
            String propertyString = this.RVO.getPropertyString(i2);
            AppMethodBeat.o(188820);
            return propertyString;
        }
        AppMethodBeat.o(188820);
        return "";
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getDurationMs() {
        AppMethodBeat.i(188821);
        long j2 = 0;
        for (ITPMediaTrackClip iTPMediaTrackClip : this.RWJ) {
            j2 = iTPMediaTrackClip.getOriginalDurationMs() + j2;
        }
        AppMethodBeat.o(188821);
        return j2;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getCurrentPositionMs() {
        AppMethodBeat.i(188822);
        long j2 = 0;
        int i2 = 0;
        while (i2 < this.RWJ.size() && i2 < this.RWK) {
            j2 += this.RWJ.get(i2).getOriginalDurationMs();
            i2++;
        }
        if (!this.RVU.aqS(12)) {
            AppMethodBeat.o(188822);
            return j2;
        }
        long currentPositionMs = j2 + this.RVO.getCurrentPositionMs();
        AppMethodBeat.o(188822);
        return currentPositionMs;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final long getPlayableDurationMs() {
        AppMethodBeat.i(188823);
        if (this.RVU.aqS(15)) {
            long playableDurationMs = this.RVO.getPlayableDurationMs();
            AppMethodBeat.o(188823);
            return playableDurationMs;
        } else if (this.RVW != null) {
            long j2 = this.RVW.RVr;
            AppMethodBeat.o(188823);
            return j2;
        } else {
            AppMethodBeat.o(188823);
            return 0;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final int getVideoWidth() {
        AppMethodBeat.i(188824);
        if (this.RVW == null) {
            AppMethodBeat.o(188824);
            return 0;
        } else if (this.RVW.width > 0) {
            int i2 = (int) this.RVW.width;
            AppMethodBeat.o(188824);
            return i2;
        } else if (!this.RVU.aqS(13)) {
            AppMethodBeat.o(188824);
            return 0;
        } else {
            this.RVW.width = (long) this.RVO.getVideoWidth();
            int i3 = (int) this.RVW.width;
            AppMethodBeat.o(188824);
            return i3;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final int getVideoHeight() {
        AppMethodBeat.i(188825);
        if (this.RVW == null) {
            AppMethodBeat.o(188825);
            return 0;
        } else if (this.RVW.height > 0) {
            int i2 = (int) this.RVW.height;
            AppMethodBeat.o(188825);
            return i2;
        } else if (!this.RVU.aqS(13)) {
            AppMethodBeat.o(188825);
            return 0;
        } else {
            this.RVW.height = (long) this.RVO.getVideoHeight();
            int i3 = (int) this.RVW.height;
            AppMethodBeat.o(188825);
            return i3;
        }
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final TPTrackInfo[] getTrackInfo() {
        AppMethodBeat.i(188826);
        this.RVN.error("getTrackInfo not supported.");
        TPTrackInfo[] tPTrackInfoArr = new TPTrackInfo[0];
        AppMethodBeat.o(188826);
        return tPTrackInfoArr;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void selectProgram(int i2, long j2) {
        AppMethodBeat.i(188827);
        this.RVN.error("selectProgram not supported.");
        AppMethodBeat.o(188827);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final TPProgramInfo[] getProgramInfo() {
        AppMethodBeat.i(188828);
        this.RVN.error("getProgramInfo not supported.");
        TPProgramInfo[] tPProgramInfoArr = new TPProgramInfo[0];
        AppMethodBeat.o(188828);
        return tPProgramInfoArr;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void captureVideo(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        AppMethodBeat.i(188829);
        if (this.RVO != null) {
            this.RVO.captureVideo(tPCaptureParams, tPCaptureCallBack);
        }
        AppMethodBeat.o(188829);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.f fVar) {
        AppMethodBeat.i(188830);
        this.RVR.a(fVar);
        AppMethodBeat.o(188830);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.AbstractC2201c cVar) {
        AppMethodBeat.i(188831);
        this.RVR.a(cVar);
        AppMethodBeat.o(188831);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.e eVar) {
        AppMethodBeat.i(188832);
        this.RVR.a(eVar);
        AppMethodBeat.o(188832);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.d dVar) {
        AppMethodBeat.i(188833);
        this.RVR.a(dVar);
        AppMethodBeat.o(188833);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.g gVar) {
        AppMethodBeat.i(188834);
        this.RVR.a(gVar);
        AppMethodBeat.o(188834);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.m mVar) {
        AppMethodBeat.i(188835);
        this.RVR.a(mVar);
        AppMethodBeat.o(188835);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.i iVar) {
        AppMethodBeat.i(188836);
        this.RVR.a(iVar);
        AppMethodBeat.o(188836);
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.j jVar) {
        AppMethodBeat.i(188837);
        IllegalStateException illegalStateException = new IllegalStateException("system Mediaplayer now not support subtitle frame out");
        AppMethodBeat.o(188837);
        throw illegalStateException;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.k kVar) {
        AppMethodBeat.i(188838);
        IllegalStateException illegalStateException = new IllegalStateException("system Mediaplayer cannot support video frame out");
        AppMethodBeat.o(188838);
        throw illegalStateException;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.a aVar) {
        AppMethodBeat.i(188839);
        IllegalStateException illegalStateException = new IllegalStateException("system Mediaplayer cannot support audio frame out");
        AppMethodBeat.o(188839);
        throw illegalStateException;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.l lVar) {
        AppMethodBeat.i(188840);
        IllegalStateException illegalStateException = new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
        AppMethodBeat.o(188840);
        throw illegalStateException;
    }

    @Override // com.tencent.thumbplayer.a.a.b
    public final void a(c.b bVar) {
        AppMethodBeat.i(188841);
        IllegalStateException illegalStateException = new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
        AppMethodBeat.o(188841);
        throw illegalStateException;
    }

    /* access modifiers changed from: package-private */
    public final void aX(int i2, long j2) {
        AppMethodBeat.i(188842);
        this.RVN.debug("switchPlayer: clipNo:" + i2 + "   startPostion:" + j2);
        if (this.RVO != null) {
            this.RVO.release();
        }
        this.RWL = true;
        this.RWK = i2;
        this.RVT.setDataSource(this.RWJ.get(this.RWK).getFilePath());
        this.RVO = hmS();
        if (this.RVO == null) {
            RuntimeException runtimeException = new RuntimeException("error , create player failed");
            AppMethodBeat.o(188842);
            throw runtimeException;
        }
        this.RVO.setPlayerOptionalParam(new TPOptionalParam().buildLong(100, j2));
        this.RVO.prepare();
        AppMethodBeat.o(188842);
    }

    private ITPMediaTrackClip hmR() {
        AppMethodBeat.i(188843);
        ITPMediaTrackClip iTPMediaTrackClip = this.RWJ.get(this.RWK);
        AppMethodBeat.o(188843);
        return iTPMediaTrackClip;
    }

    private b hmS() {
        AppMethodBeat.i(188844);
        e eVar = new e(this.mContext, this.RVM);
        if (this.RVW == null) {
            this.RVW = new com.tencent.thumbplayer.a.b();
        }
        a(eVar);
        AppMethodBeat.o(188844);
        return eVar;
    }

    private void a(b bVar) {
        AppMethodBeat.i(188845);
        if (1 == this.RVT.RVy.mType) {
            bVar.setDataSource(this.RVT.RVy.RWn);
        }
        if (this.RVT.RVy.mType == 0) {
            bVar.setDataSource(this.RVT.RVy.mUrl, this.RVT.RVy.RWo);
        }
        for (TPOptionalParam tPOptionalParam : this.RVT.hmO()) {
            bVar.setPlayerOptionalParam(tPOptionalParam);
        }
        for (c.d dVar : this.RVT.hmM()) {
            bVar.addSubtitleSource(dVar.url, dVar.mimeType, dVar.name);
        }
        for (c.a aVar : this.RVT.hmN()) {
            bVar.g(aVar.url, aVar.name, aVar.RVH);
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
        if (this.RVT.RVt instanceof SurfaceHolder) {
            bVar.setSurfaceHolder((SurfaceHolder) this.RVT.RVt);
        } else if (this.RVT.RVt instanceof Surface) {
            bVar.setSurface((Surface) this.RVT.RVt);
        }
        bVar.a((c.e) this.RWI);
        bVar.a((c.f) this.RWI);
        bVar.a((c.AbstractC2201c) this.RWI);
        bVar.a((c.d) this.RWI);
        bVar.a((c.g) this.RWI);
        bVar.a((c.m) this.RWI);
        bVar.a((c.i) this.RWI);
        AppMethodBeat.o(188845);
    }

    /* access modifiers changed from: package-private */
    public class a implements c.a, c.b, c.AbstractC2201c, c.d, c.e, c.f, c.g, c.i, c.k, c.l, c.m {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        @Override // com.tencent.thumbplayer.a.a.c.f
        public final void tf() {
            AppMethodBeat.i(188779);
            d dVar = d.this;
            if (dVar.RVR != null) {
                dVar.RVR.a(152, (long) dVar.RWK, 0, (Object) null);
            }
            if (dVar.RWL) {
                dVar.start();
                if (dVar.RWM && dVar.RVR != null && !com.tencent.thumbplayer.utils.b.isEmpty(dVar.RWN)) {
                    Long poll = dVar.RWN.poll();
                    if (poll != null) {
                        dVar.RVR.a(3, poll.longValue(), 0, (Object) null);
                    }
                    dVar.RWM = false;
                }
                AppMethodBeat.o(188779);
                return;
            }
            if (dVar.RVU.aqT(1)) {
                dVar.RVP.changeState(4);
                if (dVar.RVR != null) {
                    dVar.RVR.tf();
                }
                b bVar = dVar.RVO;
                TPTrackInfo[] trackInfo = dVar.getTrackInfo();
                if (trackInfo != null) {
                    for (int i2 = 0; i2 < trackInfo.length; i2++) {
                        if (trackInfo[i2].equals(dVar.RVT.RVE.get(Integer.valueOf(trackInfo[i2].getTrackType())))) {
                            bVar.selectTrack(i2, -1);
                        }
                    }
                }
            }
            AppMethodBeat.o(188779);
        }

        @Override // com.tencent.thumbplayer.a.a.c.AbstractC2201c
        public final void onCompletion() {
            AppMethodBeat.i(188780);
            d dVar = d.this;
            if (dVar.RVU.aqT(2)) {
                if (dVar.RWK >= dVar.RWJ.size() - 1) {
                    dVar.RVP.changeState(7);
                    dVar.RVR.onCompletion();
                    AppMethodBeat.o(188780);
                    return;
                }
                try {
                    dVar.aX(dVar.RWK + 1, 0);
                    AppMethodBeat.o(188780);
                    return;
                } catch (IOException e2) {
                    dVar.RVN.info("handleOnComplete:" + e2.toString());
                }
            }
            AppMethodBeat.o(188780);
        }

        @Override // com.tencent.thumbplayer.a.a.c.e
        public final void a(int i2, long j2, long j3, Object obj) {
            AppMethodBeat.i(188781);
            d dVar = d.this;
            if (dVar.RVU.aqT(3)) {
                dVar.RVR.a(i2, j2, j3, obj);
            }
            AppMethodBeat.o(188781);
        }

        @Override // com.tencent.thumbplayer.a.a.c.d
        public final void a(int i2, int i3, long j2, long j3) {
            AppMethodBeat.i(188782);
            d dVar = d.this;
            if (dVar.RVU.aqT(4)) {
                dVar.RVR.a(i2, i3, j2, j3);
            }
            AppMethodBeat.o(188782);
        }

        @Override // com.tencent.thumbplayer.a.a.c.g
        public final void cJH() {
            AppMethodBeat.i(188783);
            d dVar = d.this;
            if (dVar.RVU.aqT(5)) {
                dVar.RVR.cJH();
            }
            AppMethodBeat.o(188783);
        }

        @Override // com.tencent.thumbplayer.a.a.c.m
        public final void aI(long j2, long j3) {
            AppMethodBeat.i(188784);
            d dVar = d.this;
            if (dVar.RVU.aqT(6)) {
                dVar.RVW.height = j3;
                dVar.RVW.width = j2;
                dVar.RVR.aI(j2, j3);
            }
            AppMethodBeat.o(188784);
        }

        @Override // com.tencent.thumbplayer.a.a.c.i
        public final void a(TPSubtitleData tPSubtitleData) {
            AppMethodBeat.i(188785);
            d dVar = d.this;
            if (dVar.RVU.aqT(7)) {
                dVar.RVR.a(tPSubtitleData);
            }
            AppMethodBeat.o(188785);
        }

        @Override // com.tencent.thumbplayer.a.a.c.k
        public final void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            AppMethodBeat.i(188786);
            d dVar = d.this;
            if (dVar.RVU.aqT(7)) {
                dVar.RVR.a(tPVideoFrameBuffer);
            }
            AppMethodBeat.o(188786);
        }

        @Override // com.tencent.thumbplayer.a.a.c.a
        public final void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
            AppMethodBeat.i(188787);
            d dVar = d.this;
            if (dVar.RVU.aqT(7)) {
                dVar.RVR.a(tPAudioFrameBuffer);
            }
            AppMethodBeat.o(188787);
        }

        @Override // com.tencent.thumbplayer.a.a.c.l
        public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            AppMethodBeat.i(188788);
            d dVar = d.this;
            if (!dVar.RVU.aqT(7)) {
                AppMethodBeat.o(188788);
                return null;
            }
            TPPostProcessFrameBuffer a2 = dVar.RVR.a(tPPostProcessFrameBuffer);
            AppMethodBeat.o(188788);
            return a2;
        }

        @Override // com.tencent.thumbplayer.a.a.c.b
        public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            AppMethodBeat.i(188789);
            d dVar = d.this;
            if (!dVar.RVU.aqT(7)) {
                AppMethodBeat.o(188789);
                return null;
            }
            TPPostProcessFrameBuffer b2 = dVar.RVR.b(tPPostProcessFrameBuffer);
            AppMethodBeat.o(188789);
            return b2;
        }
    }
}
