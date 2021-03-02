package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;

@TargetApi(14)
public class SightVideoTextureView extends SightCameraView {
    private SurfaceTexture DqE;
    private Surface DqF;
    private boolean DqG;
    private TextureView cIM;
    private String cJp;
    private MediaPlayer mBq;
    private boolean mMute;

    public SightVideoTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(28799);
        this.cIM = null;
        this.DqE = null;
        this.DqF = null;
        this.cIM = (TextureView) findViewById(R.id.iep);
        this.cIM.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            /* class com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.AnonymousClass1 */

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(28790);
                Log.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureAvailable, [%d, %d]", Integer.valueOf(i2), Integer.valueOf(i3));
                SightVideoTextureView.this.Dqq = SightCameraView.b.CREATE;
                SightVideoTextureView.this.DqE = surfaceTexture;
                ((MMTextureView) SightVideoTextureView.this.cIM).gLi();
                Log.i("MicroMsg.SightVideoTextureView", "available texture %s, wantPlay %B", surfaceTexture, Boolean.valueOf(SightVideoTextureView.this.DqG));
                if (SightVideoTextureView.this.DqG) {
                    SightVideoTextureView.this.ce(SightVideoTextureView.this.cJp, SightVideoTextureView.this.mMute);
                }
                AppMethodBeat.o(28790);
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(28791);
                Log.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureSizeChanged, [%d, %d]", Integer.valueOf(i2), Integer.valueOf(i3));
                SightVideoTextureView.this.Dqq = SightCameraView.b.CHANGED;
                Log.i("MicroMsg.SightVideoTextureView", "changed texture %s", surfaceTexture);
                AppMethodBeat.o(28791);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(28792);
                Log.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureDestroyed");
                SightVideoTextureView.this.Dqq = SightCameraView.b.DESTORY;
                SightVideoTextureView.this.DqE = null;
                SightVideoTextureView.this.Dqs = false;
                Log.i("MicroMsg.SightVideoTextureView", "destroyed texture %s", surfaceTexture);
                AppMethodBeat.o(28792);
                return true;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
        AppMethodBeat.o(28799);
    }

    public SightVideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sight.encode.ui.SightCameraView
    public void setIsMute(boolean z) {
        AppMethodBeat.i(28800);
        if (this.mBq == null) {
            AppMethodBeat.o(28800);
            return;
        }
        try {
            if (!this.mBq.isPlaying()) {
                AppMethodBeat.o(28800);
            } else if (z) {
                try {
                    this.mBq.setVolume(0.0f, 0.0f);
                    AppMethodBeat.o(28800);
                } catch (Exception e2) {
                    Log.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 0, 0 Fail: %s", e2.getMessage());
                    AppMethodBeat.o(28800);
                }
            } else {
                requestAudioFocus();
                try {
                    this.mBq.setVolume(1.0f, 1.0f);
                    AppMethodBeat.o(28800);
                } catch (Exception e3) {
                    Log.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 1, 1 Fail: %s", e3.getMessage());
                    AppMethodBeat.o(28800);
                }
            }
        } catch (Exception e4) {
            Log.w("MicroMsg.SightVideoTextureView", "setIsMute %B, check MediaPlayer playing Fail: %s", Boolean.valueOf(z), e4.getMessage());
            AppMethodBeat.o(28800);
        }
    }

    @Override // com.tencent.mm.plugin.sight.encode.ui.SightCameraView
    public final void ce(final String str, final boolean z) {
        AppMethodBeat.i(28801);
        Log.i("MicroMsg.SightVideoTextureView", "start play video, path %s, mute %B, wantPlay %B", str, Boolean.valueOf(z), Boolean.valueOf(this.DqG));
        this.cJp = str;
        this.mMute = z;
        if (this.DqE == null) {
            Log.w("MicroMsg.SightVideoTextureView", "play video fail, texture is null");
            this.DqG = true;
            AppMethodBeat.o(28801);
            return;
        }
        this.DqG = false;
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(28795);
                if (SightVideoTextureView.this.mBq != null) {
                    try {
                        SightVideoTextureView.this.mBq.stop();
                        SightVideoTextureView.this.mBq.release();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SightVideoTextureView", e2, "", new Object[0]);
                        Log.w("MicroMsg.SightVideoTextureView", "try to release mediaplayer error");
                    }
                }
                try {
                    SightVideoTextureView.this.mBq = new k();
                    SightVideoTextureView.this.mBq.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        /* class com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.AnonymousClass2.AnonymousClass1 */

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            AppMethodBeat.i(28793);
                            Log.i("MicroMsg.SightVideoTextureView", "complete playing %s ", str);
                            SightVideoTextureView.this.eWs();
                            AppMethodBeat.o(28793);
                        }
                    });
                    SightVideoTextureView.this.mBq.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                        /* class com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.AnonymousClass2.AnonymousClass2 */

                        public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                            AppMethodBeat.i(28794);
                            Log.i("MicroMsg.SightVideoTextureView", "play %s error", str);
                            AppMethodBeat.o(28794);
                            return false;
                        }
                    });
                    SightVideoTextureView.this.mBq.setDataSource(str);
                    SightVideoTextureView.this.DqF = SightVideoTextureView.this.getPreviewSurface();
                    SightVideoTextureView.this.mBq.setSurface(SightVideoTextureView.this.DqF);
                    SightVideoTextureView.this.mBq.setAudioStreamType(3);
                    if (z) {
                        SightVideoTextureView.this.mBq.setVolume(0.0f, 0.0f);
                    } else {
                        SightVideoTextureView.this.requestAudioFocus();
                    }
                    SightVideoTextureView.this.mBq.setScreenOnWhilePlaying(true);
                    SightVideoTextureView.this.mBq.setLooping(true);
                    SightVideoTextureView.this.mBq.prepare();
                    SightVideoTextureView.this.mBq.start();
                    AppMethodBeat.o(28795);
                } catch (Exception e3) {
                    Log.e("MicroMsg.SightVideoTextureView", "play %s, error: %s, %s", str, e3.getMessage(), Util.stackTraceToString(e3));
                    AppMethodBeat.o(28795);
                }
            }

            public final String toString() {
                AppMethodBeat.i(28796);
                String str = super.toString() + "|playVideo";
                AppMethodBeat.o(28796);
                return str;
            }
        });
        AppMethodBeat.o(28801);
    }

    @Override // com.tencent.mm.plugin.sight.encode.ui.SightCameraView
    public final boolean isPlaying() {
        boolean z = false;
        AppMethodBeat.i(28802);
        try {
            if (this.mBq == null) {
                AppMethodBeat.o(28802);
            } else {
                z = this.mBq.isPlaying();
                AppMethodBeat.o(28802);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SightVideoTextureView", e2, "", new Object[0]);
            AppMethodBeat.o(28802);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.sight.encode.ui.SightCameraView
    public final void eWq() {
        AppMethodBeat.i(28803);
        Log.i("MicroMsg.SightVideoTextureView", "stop play video, wantPlay %B", Boolean.valueOf(this.DqG));
        if (this.mBq != null || this.DqG) {
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(28797);
                    try {
                        SightVideoTextureView.this.eWs();
                        SightVideoTextureView.this.mBq.stop();
                        SightVideoTextureView.this.mBq.release();
                        if (SightVideoTextureView.this.DqF != null && SightVideoTextureView.this.DqF.isValid()) {
                            SightVideoTextureView.this.DqF.release();
                            SightVideoTextureView.this.DqF = null;
                        }
                    } catch (Exception e2) {
                        Log.w("MicroMsg.SightVideoTextureView", "stop play video error: %s, %s", e2.getMessage(), Util.stackTraceToString(e2));
                    }
                    SightVideoTextureView.this.mBq = null;
                    AppMethodBeat.o(28797);
                }

                public final String toString() {
                    AppMethodBeat.i(28798);
                    String str = super.toString() + "|stopPlayVideo";
                    AppMethodBeat.o(28798);
                    return str;
                }
            });
            AppMethodBeat.o(28803);
            return;
        }
        Log.w("MicroMsg.SightVideoTextureView", "mediaplayer is null, do nothing when stop play video");
        AppMethodBeat.o(28803);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sight.encode.ui.SightCameraView
    public int getSurfaceWidth() {
        AppMethodBeat.i(28804);
        if (this.cIM != null) {
            int width = this.cIM.getWidth();
            AppMethodBeat.o(28804);
            return width;
        }
        AppMethodBeat.o(28804);
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sight.encode.ui.SightCameraView
    public int getSurfaceHeight() {
        AppMethodBeat.i(28805);
        if (this.cIM != null) {
            int height = this.cIM.getHeight();
            AppMethodBeat.o(28805);
            return height;
        }
        AppMethodBeat.o(28805);
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sight.encode.ui.SightCameraView
    public Surface getPreviewSurface() {
        AppMethodBeat.i(28806);
        if (this.DqE != null) {
            Surface surface = new Surface(this.DqE);
            AppMethodBeat.o(28806);
            return surface;
        }
        AppMethodBeat.o(28806);
        return null;
    }

    @Override // com.tencent.mm.plugin.sight.encode.ui.SightCameraView
    public void setFixPreviewRate(float f2) {
        AppMethodBeat.i(28807);
        ViewGroup.LayoutParams layoutParams = this.cIM.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Log.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate [%f], dm[%d, %d]", Float.valueOf(f2), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f2);
        Log.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate width:%d, height:%d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        this.cIM.setLayoutParams(layoutParams);
        super.setPreviewRate(f2);
        AppMethodBeat.o(28807);
    }
}
