package com.tencent.mm.live.core.core.trtc.a.b;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.h;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.live.core.core.trtc.a.b.b;
import com.tencent.mm.protocal.protobuf.fhl;
import com.tencent.mm.protocal.protobuf.fhm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    TRTCCloud hAY;
    private final a hBL;
    private boolean hBM;
    private ArrayList<b> hBN;
    private String hBO;
    private HashMap<String, h> hBP;
    private HashMap<Long, TXLivePlayer> hBQ;
    private int hBR = 1258344707;
    private int hBS = 58415;
    String uKt = "";
    private MTimerHandler uKu = new MTimerHandler("link_mic_sei_sender", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.live.core.core.trtc.a.b.c.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(261577);
            c.this.hAY.sendSEIMsg(c.this.uKt.getBytes(), 1);
            AppMethodBeat.o(261577);
            return true;
        }
    }, true);

    public interface a {
    }

    public c(TRTCCloud tRTCCloud, a aVar) {
        AppMethodBeat.i(196287);
        this.hAY = tRTCCloud;
        this.hBL = aVar;
        this.hBM = true;
        this.hBN = new ArrayList<>();
        this.hBP = new HashMap<>();
        this.hBQ = new HashMap<>();
        AppMethodBeat.o(196287);
    }

    public final void y(long j2, long j3) {
        AppMethodBeat.i(196288);
        if (j2 > 0) {
            this.hBR = (int) j2;
        }
        if (j3 > 0) {
            this.hBS = (int) j3;
        }
        TXLog.i("MicroMsg.LiveCoreVisitor", "setQCloudAccount:appid: " + j2 + ", bizid: " + j3 + ", mCloudAppid: " + this.hBR + ", mCloudBizid: " + this.hBS);
        AppMethodBeat.o(196288);
    }

    public final void Gs(String str) {
        this.hBO = str;
    }

    public final void muteRemoteAudio(String str, boolean z) {
        AppMethodBeat.i(196289);
        this.hAY.muteRemoteAudio(str, z);
        AppMethodBeat.o(196289);
    }

    private boolean Gt(String str) {
        AppMethodBeat.i(196290);
        Iterator<b> it = this.hBN.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.userId != null && next.userId.equals(str) && next.streamType == 0) {
                AppMethodBeat.o(196290);
                return true;
            }
        }
        AppMethodBeat.o(196290);
        return false;
    }

    private b Gu(String str) {
        AppMethodBeat.i(196291);
        Iterator<b> it = this.hBN.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.userId != null && next.userId.equals(str) && next.streamType == 0) {
                AppMethodBeat.o(196291);
                return next;
            }
        }
        AppMethodBeat.o(196291);
        return null;
    }

    public final void bxo() {
        AppMethodBeat.i(261581);
        this.hBN.clear();
        AppMethodBeat.o(261581);
    }

    public final void Gv(String str) {
        AppMethodBeat.i(196292);
        if (!this.hBM) {
            this.hAY.stopRemoteView(str);
        } else {
            Gz(str);
        }
        b.a.aDT().Gx(Util.nullAsNil(str));
        Iterator<b> it = this.hBN.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.userId != null && next.userId.equals(str) && next.streamType == 0) {
                it.remove();
                TXLog.i("MicroMsg.LiveCoreVisitor", "removeVideoStream " + str + ", stream 0, size " + this.hBN.size());
                AppMethodBeat.o(196292);
                return;
            }
        }
        AppMethodBeat.o(196292);
    }

    public final void a(String str, TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(196293);
        b bVar = new b((byte) 0);
        bVar.userId = str;
        bVar.streamType = 0;
        bVar.hBV = false;
        if (b.a.aDT().Gr(str) == null) {
            b.a.aDT().a(new a(str));
        }
        if (this.hBM) {
            final h Gy = Gy(str);
            if (Gy == null) {
                Gy = new h(str);
            }
            TextureView textureView = new TextureView(tXCloudVideoView.getContext());
            textureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            tXCloudVideoView.addVideoView(textureView);
            textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
                /* class com.tencent.mm.live.core.core.trtc.a.b.c.AnonymousClass2 */

                public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                    AppMethodBeat.i(261578);
                    Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", Integer.valueOf(i2), Integer.valueOf(i3));
                    Gy.bO(new Surface(surfaceTexture));
                    Gy.cX(i2, i3);
                    AppMethodBeat.o(261578);
                }

                public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                    AppMethodBeat.i(261579);
                    Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", Integer.valueOf(i2), Integer.valueOf(i3));
                    Gy.cX(i2, i3);
                    AppMethodBeat.o(261579);
                }

                public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    AppMethodBeat.i(261580);
                    Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
                    Gy.aEG();
                    AppMethodBeat.o(261580);
                    return false;
                }

                public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }
            });
            this.hAY.setRemoteVideoRenderListener(str, 1, 2, Gy);
            this.hBP.put(str, Gy);
            this.hAY.startRemoteView(str, null);
            textureView.invalidate();
        } else if (tXCloudVideoView != null) {
            this.hAY.setDebugViewMargin(str, new TRTCCloud.TRTCViewMargin(0.0f, 0.0f, 0.1f, 0.0f));
            this.hAY.setRemoteViewFillMode(str, 1);
            this.hAY.startRemoteView(str, tXCloudVideoView);
        }
        if (!Gt(str)) {
            this.hBN.add(bVar);
            TXLog.i("MicroMsg.LiveCoreVisitor", "remoteUserVideoAvailable " + bVar.userId + ", stream 0, size " + this.hBN.size());
        }
        AppMethodBeat.o(196293);
    }

    public static void Gw(String str) {
        AppMethodBeat.i(196294);
        b bVar = new b((byte) 0);
        bVar.userId = str;
        bVar.streamType = 0;
        if (b.a.aDT().Gr(str) == null) {
            b.a.aDT().a(new a(str));
        }
        AppMethodBeat.o(196294);
    }

    public final h Gy(String str) {
        AppMethodBeat.i(196296);
        if (this.hBP == null || Util.isNullOrNil(str) || !this.hBP.containsKey(str)) {
            AppMethodBeat.o(196296);
            return null;
        }
        h hVar = this.hBP.get(str);
        AppMethodBeat.o(196296);
        return hVar;
    }

    public final TXLivePlayer zv(long j2) {
        AppMethodBeat.i(196297);
        if (this.hBQ == null || !this.hBQ.containsKey(Long.valueOf(j2))) {
            AppMethodBeat.o(196297);
            return null;
        }
        TXLivePlayer tXLivePlayer = this.hBQ.get(Long.valueOf(j2));
        AppMethodBeat.o(196297);
        return tXLivePlayer;
    }

    public final void a(long j2, TXLivePlayer tXLivePlayer) {
        AppMethodBeat.i(196298);
        this.hBQ.put(Long.valueOf(j2), tXLivePlayer);
        AppMethodBeat.o(196298);
    }

    private void Gz(String str) {
        AppMethodBeat.i(196299);
        h remove = this.hBP.remove(str);
        if (remove != null) {
            remove.release();
        }
        this.hAY.stopRemoteSubStreamView(str);
        AppMethodBeat.o(196299);
    }

    public final void aDU() {
        int i2;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(196300);
        int i6 = TAVExporter.VIDEO_EXPORT_WIDTH;
        int i7 = TAVExporter.VIDEO_EXPORT_HEIGHT;
        if (!a.C0385a.hAV.aDD().hBw) {
            i6 = TAVExporter.VIDEO_EXPORT_HEIGHT;
            i7 = TAVExporter.VIDEO_EXPORT_WIDTH;
        }
        int i8 = TXLiveConstants.RENDER_ROTATION_180;
        int i9 = 320;
        if (!a.C0385a.hAV.aDD().hBG) {
            i8 = 320;
            i9 = TXLiveConstants.RENDER_ROTATION_180;
        }
        int i10 = 50;
        int i11 = 1500;
        switch (a.C0385a.hAV.aDD().hBu) {
            case 3:
                i5 = 160;
                i4 = 160;
                int i12 = 27;
                int i13 = 48;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i12 = 48;
                    i13 = 27;
                }
                i11 = 200;
                i10 = 20;
                i2 = i13;
                i3 = i12;
                break;
            case 7:
                i5 = 480;
                int i14 = 72;
                int i15 = 128;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i14 = 128;
                    i15 = 72;
                }
                i11 = 600;
                i2 = i15;
                i3 = i14;
                i4 = 480;
                break;
            case 56:
                int i16 = 240;
                int i17 = 320;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i16 = 320;
                    i17 = 240;
                }
                int i18 = 54;
                int i19 = 96;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i18 = 96;
                    i19 = 54;
                }
                i11 = 400;
                i2 = i19;
                i3 = i18;
                i4 = i17;
                i5 = i16;
                break;
            case 62:
                int i20 = 480;
                int i21 = 640;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i20 = 640;
                    i21 = 480;
                }
                int i22 = 90;
                int i23 = 160;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i22 = 160;
                    i23 = 90;
                }
                i11 = 800;
                i2 = i23;
                i3 = i22;
                i4 = i21;
                i5 = i20;
                break;
            case 104:
                int i24 = 192;
                int i25 = 336;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i24 = 336;
                    i25 = 192;
                }
                int i26 = 54;
                int i27 = 96;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i26 = 96;
                    i27 = 54;
                }
                i10 = 30;
                i11 = 400;
                i2 = i27;
                i3 = i26;
                i4 = i25;
                i5 = i24;
                break;
            case 108:
                int i28 = 368;
                int i29 = 640;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i28 = 640;
                    i29 = 368;
                }
                int i30 = 90;
                int i31 = 160;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i30 = 160;
                    i31 = 90;
                }
                i11 = 800;
                i2 = i31;
                i3 = i30;
                i4 = i29;
                i5 = i28;
                break;
            case 110:
                int i32 = 544;
                int i33 = 960;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i32 = 960;
                    i33 = 544;
                }
                int i34 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1;
                int i35 = 304;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i34 = 304;
                    i35 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1;
                }
                i11 = 1000;
                i2 = i35;
                i3 = i34;
                i4 = i33;
                i5 = i32;
                break;
            case 112:
                int i36 = TAVExporter.VIDEO_EXPORT_WIDTH;
                int i37 = TAVExporter.VIDEO_EXPORT_HEIGHT;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i36 = TAVExporter.VIDEO_EXPORT_HEIGHT;
                    i37 = TAVExporter.VIDEO_EXPORT_WIDTH;
                }
                int i38 = TXLiveConstants.RENDER_ROTATION_180;
                int i39 = 320;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i38 = 320;
                    i39 = TXLiveConstants.RENDER_ROTATION_180;
                }
                i11 = 1500;
                i2 = i39;
                i3 = i38;
                i4 = i37;
                i5 = i36;
                break;
            case 114:
                int i40 = 1088;
                int i41 = 1920;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i40 = 1920;
                    i41 = 1088;
                }
                int i42 = 272;
                int i43 = 480;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i42 = 480;
                    i43 = 272;
                }
                i11 = 1900;
                i2 = i43;
                i3 = i42;
                i4 = i41;
                i5 = i40;
                break;
            default:
                i2 = i9;
                i3 = i8;
                i4 = i7;
                i5 = i6;
                break;
        }
        int i44 = a.C0385a.hAV.aDD().mVideoBitrate;
        if (i44 > 0) {
            i11 = i44;
        }
        int i45 = a.C0385a.hAV.aDD().hBv;
        if (i45 <= 0) {
            i45 = 15;
        }
        Log.i("MicroMsg.LiveCoreVisitor", "videoWidth:%s, videoHeight:%s, bitrate:%s, fps:%s", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i11), Integer.valueOf(i45));
        TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
        tRTCTranscodingConfig.appId = this.hBR;
        tRTCTranscodingConfig.bizId = this.hBS;
        tRTCTranscodingConfig.videoWidth = i5;
        tRTCTranscodingConfig.videoHeight = i4;
        tRTCTranscodingConfig.videoGOP = 1;
        tRTCTranscodingConfig.videoFramerate = i45;
        tRTCTranscodingConfig.videoBitrate = i11;
        tRTCTranscodingConfig.audioSampleRate = 48000;
        tRTCTranscodingConfig.audioBitrate = 64;
        if (a.C0385a.hAV.aDE().hBo == 3) {
            tRTCTranscodingConfig.audioBitrate = 128;
        }
        tRTCTranscodingConfig.audioChannels = 2;
        TRTCCloudDef.TRTCMixUser tRTCMixUser = new TRTCCloudDef.TRTCMixUser();
        tRTCMixUser.userId = this.hBO;
        tRTCMixUser.zOrder = 0;
        tRTCMixUser.x = 0;
        tRTCMixUser.y = 0;
        tRTCMixUser.width = i5;
        tRTCMixUser.height = i4;
        tRTCTranscodingConfig.mixUsers = new ArrayList<>();
        tRTCTranscodingConfig.mixUsers.add(tRTCMixUser);
        if (a.C0385a.hAV.aDD().hBE) {
            int i46 = 0;
            TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.hBN.size());
            List<a> list = b.a.aDT().hBJ;
            if (list != null) {
                for (a aVar : list) {
                    TRTCCloudDef.TRTCMixUser tRTCMixUser2 = new TRTCCloudDef.TRTCMixUser();
                    com.tencent.mm.live.core.core.trtc.a.a.c aDF = a.C0385a.hAV.aDF();
                    if (aDF.hBs && aVar.goe.equalsIgnoreCase(aDF.hBr)) {
                        tRTCMixUser2.roomId = aDF.hBq;
                    }
                    tRTCMixUser2.userId = aVar.goe;
                    tRTCMixUser2.streamType = aVar.mStreamType;
                    tRTCMixUser2.zOrder = i46 + 1;
                    tRTCMixUser2.pureAudio = true;
                    b Gu = Gu(tRTCMixUser2.userId);
                    if (Gu != null) {
                        tRTCMixUser2.pureAudio = Gu.hBV;
                        if (i46 < 3) {
                            tRTCMixUser2.x = (i5 - 5) - i3;
                            tRTCMixUser2.y = (i46 * i2) + i10;
                            tRTCMixUser2.width = i3;
                            tRTCMixUser2.height = i2;
                        } else if (i46 < 6) {
                            tRTCMixUser2.x = 5;
                            tRTCMixUser2.y = ((i4 - i10) - ((i46 - 3) * i2)) - i2;
                            tRTCMixUser2.width = i3;
                            tRTCMixUser2.height = i2;
                        }
                    }
                    TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + tRTCMixUser2.userId + ", pureAudioMode: " + tRTCMixUser2.pureAudio);
                    tRTCTranscodingConfig.mixUsers.add(tRTCMixUser2);
                    i46++;
                }
            }
        }
        boolean z = a.C0385a.hAV.aDD().uKs;
        if (z || (tRTCTranscodingConfig.mixUsers != null && tRTCTranscodingConfig.mixUsers.size() > 1)) {
            this.hAY.setMixTranscodingConfig(tRTCTranscodingConfig);
            Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, config:%s, is265:%b", tRTCTranscodingConfig, Boolean.valueOf(z));
            AppMethodBeat.o(196300);
            return;
        }
        this.hAY.setMixTranscodingConfig(null);
        Log.i("MicroMsg.LiveCoreVisitor", "cancel cloudmixturing");
        AppMethodBeat.o(196300);
    }

    public final void B(float f2, float f3) {
        int i2;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(196301);
        int i6 = TAVExporter.VIDEO_EXPORT_WIDTH;
        int i7 = TAVExporter.VIDEO_EXPORT_HEIGHT;
        if (!a.C0385a.hAV.aDD().hBw) {
            i6 = TAVExporter.VIDEO_EXPORT_HEIGHT;
            i7 = TAVExporter.VIDEO_EXPORT_WIDTH;
        }
        int i8 = TXLiveConstants.RENDER_ROTATION_180;
        int i9 = 320;
        if (!a.C0385a.hAV.aDD().hBG) {
            i8 = 320;
            i9 = TXLiveConstants.RENDER_ROTATION_180;
        }
        int i10 = 50;
        int i11 = 1500;
        switch (a.C0385a.hAV.aDD().hBu) {
            case 3:
                i5 = 160;
                i4 = 160;
                int i12 = 27;
                int i13 = 48;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i12 = 48;
                    i13 = 27;
                }
                i11 = 200;
                i10 = 20;
                i2 = i13;
                i3 = i12;
                break;
            case 7:
                i5 = 480;
                int i14 = 72;
                int i15 = 128;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i14 = 128;
                    i15 = 72;
                }
                i11 = 600;
                i2 = i15;
                i3 = i14;
                i4 = 480;
                break;
            case 56:
                int i16 = 240;
                int i17 = 320;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i16 = 320;
                    i17 = 240;
                }
                int i18 = 54;
                int i19 = 96;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i18 = 96;
                    i19 = 54;
                }
                i11 = 400;
                i2 = i19;
                i3 = i18;
                i4 = i17;
                i5 = i16;
                break;
            case 62:
                int i20 = 480;
                int i21 = 640;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i20 = 640;
                    i21 = 480;
                }
                int i22 = 90;
                int i23 = 160;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i22 = 160;
                    i23 = 90;
                }
                i11 = 800;
                i2 = i23;
                i3 = i22;
                i4 = i21;
                i5 = i20;
                break;
            case 104:
                int i24 = 192;
                int i25 = 336;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i24 = 336;
                    i25 = 192;
                }
                int i26 = 54;
                int i27 = 96;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i26 = 96;
                    i27 = 54;
                }
                i10 = 30;
                i11 = 400;
                i2 = i27;
                i3 = i26;
                i4 = i25;
                i5 = i24;
                break;
            case 108:
                int i28 = 368;
                int i29 = 640;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i28 = 640;
                    i29 = 368;
                }
                int i30 = 90;
                int i31 = 160;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i30 = 160;
                    i31 = 90;
                }
                i11 = 800;
                i2 = i31;
                i3 = i30;
                i4 = i29;
                i5 = i28;
                break;
            case 110:
                int i32 = 544;
                int i33 = 960;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i32 = 960;
                    i33 = 544;
                }
                int i34 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1;
                int i35 = 304;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i34 = 304;
                    i35 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1;
                }
                i11 = 1000;
                i2 = i35;
                i3 = i34;
                i4 = i33;
                i5 = i32;
                break;
            case 112:
                int i36 = TAVExporter.VIDEO_EXPORT_WIDTH;
                int i37 = TAVExporter.VIDEO_EXPORT_HEIGHT;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i36 = TAVExporter.VIDEO_EXPORT_HEIGHT;
                    i37 = TAVExporter.VIDEO_EXPORT_WIDTH;
                }
                int i38 = TXLiveConstants.RENDER_ROTATION_180;
                int i39 = 320;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i38 = 320;
                    i39 = TXLiveConstants.RENDER_ROTATION_180;
                }
                i11 = 1500;
                i2 = i39;
                i3 = i38;
                i4 = i37;
                i5 = i36;
                break;
            case 114:
                int i40 = 1088;
                int i41 = 1920;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i40 = 1920;
                    i41 = 1088;
                }
                int i42 = 272;
                int i43 = 480;
                if (!a.C0385a.hAV.aDD().hBG) {
                    i42 = 480;
                    i43 = 272;
                }
                i11 = 1900;
                i2 = i43;
                i3 = i42;
                i4 = i41;
                i5 = i40;
                break;
            default:
                i2 = i9;
                i3 = i8;
                i4 = i7;
                i5 = i6;
                break;
        }
        int i44 = a.C0385a.hAV.aDD().mVideoBitrate;
        if (i44 > 0) {
            i11 = i44;
        }
        int i45 = a.C0385a.hAV.aDD().hBv;
        if (i45 <= 0) {
            i45 = 15;
        }
        float f4 = ((float) i5) * (f2 / ((float) au.az(MMApplicationContext.getContext()).x));
        float f5 = ((float) i4) * (f3 / ((float) au.az(MMApplicationContext.getContext()).y));
        Log.i("MicroMsg.LiveCoreVisitor", "xOffset:%s, realXOffset:%s, yOffset:%s, realYOffset:%s, videoWidth:%s, videoHeight:%s, bitrate:%s,fps:%s", Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f5), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i11), Integer.valueOf(i45));
        TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
        tRTCTranscodingConfig.appId = this.hBR;
        tRTCTranscodingConfig.bizId = this.hBS;
        tRTCTranscodingConfig.videoWidth = i5;
        tRTCTranscodingConfig.videoHeight = i4;
        tRTCTranscodingConfig.videoGOP = 1;
        tRTCTranscodingConfig.videoFramerate = i45;
        tRTCTranscodingConfig.videoBitrate = i11;
        tRTCTranscodingConfig.audioSampleRate = 48000;
        tRTCTranscodingConfig.audioBitrate = 64;
        if (a.C0385a.hAV.aDE().hBo == 3) {
            tRTCTranscodingConfig.audioBitrate = 128;
        }
        tRTCTranscodingConfig.audioChannels = 2;
        TRTCCloudDef.TRTCMixUser tRTCMixUser = new TRTCCloudDef.TRTCMixUser();
        tRTCMixUser.userId = this.hBO;
        tRTCMixUser.zOrder = 0;
        tRTCMixUser.x = 0;
        tRTCMixUser.y = 0;
        tRTCMixUser.width = i5;
        tRTCMixUser.height = i4;
        tRTCTranscodingConfig.mixUsers = new ArrayList<>();
        tRTCTranscodingConfig.mixUsers.add(tRTCMixUser);
        if (a.C0385a.hAV.aDD().hBE) {
            int i46 = 0;
            TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.hBN.size());
            List<a> list = b.a.aDT().hBJ;
            if (list != null) {
                for (a aVar : list) {
                    TRTCCloudDef.TRTCMixUser tRTCMixUser2 = new TRTCCloudDef.TRTCMixUser();
                    com.tencent.mm.live.core.core.trtc.a.a.c aDF = a.C0385a.hAV.aDF();
                    if (aDF.hBs && aVar.goe.equalsIgnoreCase(aDF.hBr)) {
                        tRTCMixUser2.roomId = aDF.hBq;
                    }
                    tRTCMixUser2.userId = aVar.goe;
                    tRTCMixUser2.streamType = aVar.mStreamType;
                    tRTCMixUser2.zOrder = i46 + 1;
                    tRTCMixUser2.pureAudio = true;
                    b Gu = Gu(tRTCMixUser2.userId);
                    if (Gu != null) {
                        tRTCMixUser2.pureAudio = Gu.hBV;
                        if (i46 < 3) {
                            if (Gu.x == 0) {
                                tRTCMixUser2.x = ((i5 - 5) - i3) + ((int) f4);
                            } else {
                                tRTCMixUser2.x = Gu.x + ((int) f4);
                            }
                            tRTCMixUser2.x = Math.max(Math.min(i5 - i3, tRTCMixUser2.x), 0);
                            Gu.x = tRTCMixUser2.x;
                            if (Gu.y == 0) {
                                tRTCMixUser2.y = (i46 * i2) + i10 + ((int) f5);
                            } else {
                                tRTCMixUser2.y = Gu.y + ((int) f5);
                            }
                            tRTCMixUser2.y = Math.max(Math.min(i4 - i2, tRTCMixUser2.y), 0);
                            Gu.y = tRTCMixUser2.y;
                            tRTCMixUser2.width = i3;
                            tRTCMixUser2.height = i2;
                        } else if (i46 < 6) {
                            tRTCMixUser2.x = 5;
                            tRTCMixUser2.y = ((i4 - i10) - ((i46 - 3) * i2)) - i2;
                            tRTCMixUser2.width = i3;
                            tRTCMixUser2.height = i2;
                        }
                    }
                    TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + tRTCMixUser2.userId + ", pureAudioMode: " + tRTCMixUser2.pureAudio);
                    tRTCTranscodingConfig.mixUsers.add(tRTCMixUser2);
                    i46++;
                }
            }
        }
        boolean z = a.C0385a.hAV.aDD().uKs;
        if (z || (tRTCTranscodingConfig.mixUsers != null && tRTCTranscodingConfig.mixUsers.size() > 1)) {
            this.hAY.setMixTranscodingConfig(tRTCTranscodingConfig);
            Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, config:%s, is265:%b", tRTCTranscodingConfig, Boolean.valueOf(z));
            AppMethodBeat.o(196301);
            return;
        }
        this.hAY.setMixTranscodingConfig(null);
        Log.i("MicroMsg.LiveCoreVisitor", "cancel cloudmixturing");
        AppMethodBeat.o(196301);
    }

    public final void jh(boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(261583);
        int i6 = TAVExporter.VIDEO_EXPORT_WIDTH;
        int i7 = TAVExporter.VIDEO_EXPORT_HEIGHT;
        if (!a.C0385a.hAV.aDD().hBw) {
            i6 = TAVExporter.VIDEO_EXPORT_HEIGHT;
            i7 = TAVExporter.VIDEO_EXPORT_WIDTH;
        }
        a.C0385a.hAV.aDD();
        switch (a.C0385a.hAV.aDD().hBu) {
            case 3:
                i6 = 160;
                a.C0385a.hAV.aDD();
                i2 = 200;
                i3 = 160;
                break;
            case 7:
                a.C0385a.hAV.aDD();
                i2 = 600;
                i3 = 480;
                i6 = 480;
                break;
            case 56:
                i6 = 240;
                int i8 = 320;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i6 = 320;
                    i8 = 240;
                }
                a.C0385a.hAV.aDD();
                i2 = 400;
                i3 = i8;
                break;
            case 62:
                if (!a.C0385a.hAV.aDD().hBw) {
                    i4 = 480;
                    i6 = 640;
                } else {
                    i4 = 640;
                    i6 = 480;
                }
                a.C0385a.hAV.aDD();
                i2 = 800;
                i3 = i4;
                break;
            case 104:
                i6 = 192;
                int i9 = 336;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i6 = 336;
                    i9 = 192;
                }
                a.C0385a.hAV.aDD();
                i2 = 400;
                i3 = i9;
                break;
            case 108:
                i6 = 368;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i5 = 368;
                    i6 = 640;
                } else {
                    i5 = 640;
                }
                a.C0385a.hAV.aDD();
                i2 = 800;
                i3 = i5;
                break;
            case 110:
                i6 = 544;
                int i10 = 960;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i6 = 960;
                    i10 = 544;
                }
                a.C0385a.hAV.aDD();
                i2 = 1000;
                i3 = i10;
                break;
            case 112:
                i6 = TAVExporter.VIDEO_EXPORT_WIDTH;
                int i11 = TAVExporter.VIDEO_EXPORT_HEIGHT;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i6 = TAVExporter.VIDEO_EXPORT_HEIGHT;
                    i11 = TAVExporter.VIDEO_EXPORT_WIDTH;
                }
                a.C0385a.hAV.aDD();
                i2 = 1500;
                i3 = i11;
                break;
            case 114:
                i6 = 1088;
                int i12 = 1920;
                if (!a.C0385a.hAV.aDD().hBw) {
                    i6 = 1920;
                    i12 = 1088;
                }
                a.C0385a.hAV.aDD();
                i2 = 1900;
                i3 = i12;
                break;
            default:
                i2 = 1500;
                i3 = i7;
                break;
        }
        int i13 = a.C0385a.hAV.aDD().mVideoBitrate;
        if (i13 > 0) {
            i2 = i13;
        }
        int i14 = a.C0385a.hAV.aDD().hBv;
        if (i14 <= 0) {
            i14 = 15;
        }
        Log.i("MicroMsg.LiveCoreVisitor", "videoWidth:%s, videoHeight:%s, bitrate:%s, fps:%s", Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i14));
        TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
        tRTCTranscodingConfig.appId = this.hBR;
        tRTCTranscodingConfig.bizId = this.hBS;
        tRTCTranscodingConfig.videoWidth = i6;
        tRTCTranscodingConfig.videoHeight = i3;
        tRTCTranscodingConfig.videoGOP = 1;
        tRTCTranscodingConfig.videoFramerate = i14;
        tRTCTranscodingConfig.videoBitrate = i2;
        tRTCTranscodingConfig.audioSampleRate = 48000;
        tRTCTranscodingConfig.audioBitrate = 64;
        if (a.C0385a.hAV.aDE().hBo == 3) {
            tRTCTranscodingConfig.audioBitrate = 128;
        }
        tRTCTranscodingConfig.audioChannels = 2;
        TRTCCloudDef.TRTCMixUser tRTCMixUser = new TRTCCloudDef.TRTCMixUser();
        tRTCMixUser.userId = this.hBO;
        tRTCMixUser.zOrder = 0;
        tRTCMixUser.x = 0;
        tRTCMixUser.y = 0;
        tRTCMixUser.width = i6;
        tRTCMixUser.height = i3;
        tRTCTranscodingConfig.mixUsers = new ArrayList<>();
        tRTCTranscodingConfig.mixUsers.add(tRTCMixUser);
        if (a.C0385a.hAV.aDD().hBE) {
            TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.hBN.size());
            List<a> list = b.a.aDT().hBJ;
            if (list != null) {
                int size = list.size();
                if (size == 1) {
                    tRTCMixUser.x = 0;
                    tRTCMixUser.y = 0;
                    tRTCMixUser.width = i6 / 2;
                    tRTCMixUser.height = i3 / 2;
                    tRTCTranscodingConfig.videoWidth = i6;
                    tRTCTranscodingConfig.videoHeight = i3 / 2;
                    tRTCTranscodingConfig.backgroundImage = "408";
                    int i15 = 0;
                    for (a aVar : list) {
                        TRTCCloudDef.TRTCMixUser tRTCMixUser2 = new TRTCCloudDef.TRTCMixUser();
                        com.tencent.mm.live.core.core.trtc.a.a.c aDF = a.C0385a.hAV.aDF();
                        if (aDF.hBs && aVar.goe.equalsIgnoreCase(aDF.hBr)) {
                            tRTCMixUser2.roomId = aDF.hBq;
                        }
                        tRTCMixUser2.userId = aVar.goe;
                        tRTCMixUser2.streamType = aVar.mStreamType;
                        tRTCMixUser2.zOrder = i15 + 1;
                        tRTCMixUser2.pureAudio = true;
                        b Gu = Gu(tRTCMixUser2.userId);
                        if (Gu != null) {
                            tRTCMixUser2.pureAudio = Gu.hBV;
                            tRTCMixUser2.x = i6 / 2;
                            tRTCMixUser2.y = 0;
                            tRTCMixUser2.width = i6 / 2;
                            tRTCMixUser2.height = i3 / 2;
                        }
                        TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + tRTCMixUser2.userId + ", pureAudioMode: " + tRTCMixUser2.pureAudio + ", userStream: " + Gu);
                        tRTCTranscodingConfig.mixUsers.add(tRTCMixUser2);
                        i15++;
                    }
                } else if (size == 2) {
                    tRTCMixUser.x = 0;
                    tRTCMixUser.y = 0;
                    tRTCMixUser.width = i6 / 2;
                    tRTCMixUser.height = i3 / 2;
                    tRTCTranscodingConfig.videoWidth = i6;
                    tRTCTranscodingConfig.videoHeight = i3 / 2;
                    tRTCTranscodingConfig.backgroundImage = "409";
                    int i16 = 0;
                    for (a aVar2 : list) {
                        TRTCCloudDef.TRTCMixUser tRTCMixUser3 = new TRTCCloudDef.TRTCMixUser();
                        com.tencent.mm.live.core.core.trtc.a.a.c aDF2 = a.C0385a.hAV.aDF();
                        if (aDF2.hBs && aVar2.goe.equalsIgnoreCase(aDF2.hBr)) {
                            tRTCMixUser3.roomId = aDF2.hBq;
                        }
                        tRTCMixUser3.userId = aVar2.goe;
                        tRTCMixUser3.streamType = aVar2.mStreamType;
                        tRTCMixUser3.zOrder = i16 + 1;
                        tRTCMixUser3.pureAudio = true;
                        b Gu2 = Gu(tRTCMixUser3.userId);
                        if (Gu2 != null) {
                            tRTCMixUser3.pureAudio = Gu2.hBV;
                            if (i16 == 0) {
                                tRTCMixUser3.x = i6 / 2;
                                tRTCMixUser3.y = 0;
                                tRTCMixUser3.width = i6 / 2;
                                tRTCMixUser3.height = i3 / 4;
                            } else if (i16 == 1) {
                                tRTCMixUser3.x = i6 / 2;
                                tRTCMixUser3.y = i3 / 4;
                                tRTCMixUser3.width = i6 / 2;
                                tRTCMixUser3.height = i3 / 4;
                            }
                        }
                        TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + tRTCMixUser3.userId + ", pureAudioMode: " + tRTCMixUser3.pureAudio + ", userStream: " + Gu2);
                        tRTCTranscodingConfig.mixUsers.add(tRTCMixUser3);
                        i16++;
                    }
                } else if (size == 3) {
                    tRTCMixUser.x = 0;
                    tRTCMixUser.y = 0;
                    tRTCMixUser.width = i6 / 2;
                    tRTCMixUser.height = i3 / 4;
                    tRTCTranscodingConfig.videoWidth = i6;
                    tRTCTranscodingConfig.videoHeight = i3 / 2;
                    tRTCTranscodingConfig.backgroundImage = "410";
                    int i17 = 0;
                    for (a aVar3 : list) {
                        TRTCCloudDef.TRTCMixUser tRTCMixUser4 = new TRTCCloudDef.TRTCMixUser();
                        com.tencent.mm.live.core.core.trtc.a.a.c aDF3 = a.C0385a.hAV.aDF();
                        if (aDF3.hBs && aVar3.goe.equalsIgnoreCase(aDF3.hBr)) {
                            tRTCMixUser4.roomId = aDF3.hBq;
                        }
                        tRTCMixUser4.userId = aVar3.goe;
                        tRTCMixUser4.streamType = aVar3.mStreamType;
                        tRTCMixUser4.zOrder = i17 + 1;
                        tRTCMixUser4.pureAudio = true;
                        b Gu3 = Gu(tRTCMixUser4.userId);
                        if (Gu3 != null) {
                            tRTCMixUser4.pureAudio = Gu3.hBV;
                            if (i17 == 0) {
                                tRTCMixUser4.x = i6 / 2;
                                tRTCMixUser4.y = 0;
                                tRTCMixUser4.width = i6 / 2;
                                tRTCMixUser4.height = i3 / 4;
                            } else if (i17 == 1) {
                                tRTCMixUser4.x = 0;
                                tRTCMixUser4.y = i3 / 4;
                                tRTCMixUser4.width = i6 / 2;
                                tRTCMixUser4.height = i3 / 4;
                            } else if (i17 == 2) {
                                tRTCMixUser4.x = i6 / 2;
                                tRTCMixUser4.y = i3 / 4;
                                tRTCMixUser4.width = i6 / 2;
                                tRTCMixUser4.height = i3 / 4;
                            }
                        }
                        TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + tRTCMixUser4.userId + ", pureAudioMode: " + tRTCMixUser4.pureAudio + ", userStream: " + Gu3);
                        tRTCTranscodingConfig.mixUsers.add(tRTCMixUser4);
                        i17++;
                    }
                }
            }
        }
        boolean z2 = a.C0385a.hAV.aDD().uKs;
        if (z) {
            this.hAY.setMixTranscodingConfig(tRTCTranscodingConfig);
            Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, reset");
        } else if (z2 || (tRTCTranscodingConfig.mixUsers != null && tRTCTranscodingConfig.mixUsers.size() > 1)) {
            this.hAY.setMixTranscodingConfig(tRTCTranscodingConfig);
            Log.i("MicroMsg.LiveCoreVisitor", "do cloudmixturing, config:%s, is265:%b", tRTCTranscodingConfig, Boolean.valueOf(z2));
        } else {
            this.hAY.setMixTranscodingConfig(null);
            Log.i("MicroMsg.LiveCoreVisitor", "cancel cloudmixturing");
        }
        this.uKt = hD(tRTCTranscodingConfig.mixUsers);
        Log.i("MicroMsg.LiveCoreVisitor", "sendLinkMicSeiMsg linkMicSeiMsg:" + this.uKt);
        if (Util.isNullOrNil(this.uKt)) {
            this.uKu.stopTimer();
            AppMethodBeat.o(261583);
            return;
        }
        this.uKu.startTimer(1000);
        AppMethodBeat.o(261583);
    }

    private static String hD(List<TRTCCloudDef.TRTCMixUser> list) {
        AppMethodBeat.i(261584);
        if (list == null) {
            Log.i("MicroMsg.LiveCoreVisitor", "prepareLinkMicSeiInfo return nil, mixUserList == null");
            AppMethodBeat.o(261584);
            return "";
        }
        ArrayList<TRTCCloudDef.TRTCMixUser> arrayList = new ArrayList(list);
        if (arrayList.size() > 0) {
            arrayList.remove(0);
        }
        if (arrayList.size() == 0) {
            Log.i("MicroMsg.LiveCoreVisitor", "prepareLinkMicSeiInfo return nil, list.size == 0");
            AppMethodBeat.o(261584);
            return "";
        }
        ArrayList arrayList2 = new ArrayList();
        for (TRTCCloudDef.TRTCMixUser tRTCMixUser : arrayList) {
            fhm fhm = new fhm();
            fhm.KTu = tRTCMixUser.userId;
            fhm.VjV = !tRTCMixUser.pureAudio;
            arrayList2.add(fhm);
            Log.i("MicroMsg.LiveCoreVisitor", "prepareLinkMicSeiInfo mixUser.userid:" + fhm.KTu + " use_video:" + fhm.VjV);
        }
        fhl fhl = new fhl();
        fhl.MTn.addAll(arrayList2);
        String str = "";
        try {
            String str2 = new String(fhl.toByteArray());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("wxT", e.k.SEIMode_LINKMIC.value);
            jSONObject.put("d", str2);
            str = jSONObject.toString();
        } catch (IOException | JSONException e2) {
        }
        AppMethodBeat.o(261584);
        return str;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public boolean hBV;
        public int streamType;
        public String userId;
        public int x;
        public int y;

        private b() {
            this.hBV = true;
            this.x = 0;
            this.y = 0;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static void bxj(String str) {
        AppMethodBeat.i(261582);
        b.a.aDT().Gx(Util.nullAsNil(str));
        AppMethodBeat.o(261582);
    }

    public final void Gx(String str) {
        AppMethodBeat.i(196295);
        b.a.aDT().Gx(str);
        Gz(str);
        this.hAY.stopRemoteView(str);
        this.hAY.stopRemoteSubStreamView(str);
        com.tencent.mm.live.core.core.trtc.a.a.c aDF = a.C0385a.hAV.aDF();
        if (str.equals(aDF.hBr)) {
            aDF.hBq = "";
            aDF.hBr = "";
            aDF.hBs = false;
            aDF.hBt = "";
        }
        AppMethodBeat.o(196295);
    }
}
