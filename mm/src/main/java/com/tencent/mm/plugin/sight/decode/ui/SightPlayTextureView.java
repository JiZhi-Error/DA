package com.tencent.mm.plugin.sight.decode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class SightPlayTextureView extends MMTextureView implements com.tencent.mm.plugin.sight.decode.a.a {
    private int DnE;
    private com.tencent.mm.plugin.sight.decode.a.b Dnr;
    private int Dnt;
    private boolean Dny;
    private Surface mSurface;
    private int videoHeight;
    private int videoWidth;

    static final class b extends com.tencent.mm.plugin.sight.decode.a.b {
        private WeakReference<SightPlayTextureView> DnH;

        @Override // com.tencent.mm.plugin.sight.decode.a.b
        public final int eVx() {
            return R.anim.eh;
        }

        public b(SightPlayTextureView sightPlayTextureView) {
            super(1, sightPlayTextureView);
            AppMethodBeat.i(28648);
            this.DnH = new WeakReference<>(sightPlayTextureView);
            AppMethodBeat.o(28648);
        }

        @Override // com.tencent.mm.plugin.sight.decode.a.b
        public final void eo(int i2, int i3) {
            AppMethodBeat.i(28649);
            if (this.DnH.get() == null) {
                Log.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
                clear();
                AppMethodBeat.o(28649);
                return;
            }
            this.DnH.get().videoWidth = i2;
            this.DnH.get().videoHeight = i3;
            Log.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.DnH.get().Dny));
            final ViewGroup.LayoutParams layoutParams = this.DnH.get().getLayoutParams();
            if (this.DnH.get().Dny && i2 > 0 && i3 > 0) {
                if (i2 >= i3) {
                    this.DnH.get().Dnt = com.tencent.mm.cb.a.fromDPToPix(this.DnH.get().getContext(), 150);
                } else {
                    this.DnH.get().Dnt = com.tencent.mm.cb.a.fromDPToPix(this.DnH.get().getContext(), 85);
                }
            }
            if (layoutParams.height != (this.DnH.get().Dnt * i3) / i2) {
                layoutParams.width = this.DnH.get().Dnt;
                layoutParams.height = (this.DnH.get().Dnt * i3) / i2;
                if (this.DnH.get().Dny && layoutParams.height < com.tencent.mm.cb.a.fromDPToPix(this.DnH.get().getContext(), 50)) {
                    layoutParams.height = com.tencent.mm.cb.a.fromDPToPix(this.DnH.get().getContext(), 50);
                }
                Log.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                if (MMHandlerThread.isMainThread()) {
                    this.DnH.get().setLayoutParams(layoutParams);
                } else {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.b.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(28647);
                            ((SightPlayTextureView) b.this.DnH.get()).setLayoutParams(layoutParams);
                            AppMethodBeat.o(28647);
                        }
                    });
                }
            }
            this.Dmv = com.tencent.mm.plugin.sight.decode.a.b.a(this.DnH.get().getContext(), this.DnH.get().DnE, this.DnH.get().Dnt, i2, i3);
            AppMethodBeat.o(28649);
        }

        @Override // com.tencent.mm.plugin.sight.decode.a.b
        public final void at(Bitmap bitmap) {
        }
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(28650);
        this.Dny = false;
        setOpaque(false);
        this.Dnr = new b(this);
        setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            /* class com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.AnonymousClass1 */

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(28641);
                Log.i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + i2 + " height " + i3);
                AppMethodBeat.o(28641);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(28642);
                Log.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
                SightPlayTextureView.this.Dnr.j((Surface) null);
                SightPlayTextureView.this.Dnr.clear();
                a aVar = new a((byte) 0);
                aVar.DnG = SightPlayTextureView.this.mSurface;
                o.g(aVar, 0);
                SightPlayTextureView.this.mSurface = null;
                AppMethodBeat.o(28642);
                return false;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(28643);
                Log.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", Integer.valueOf(i2), Integer.valueOf(i3));
                a aVar = new a((byte) 0);
                aVar.DnG = SightPlayTextureView.this.mSurface;
                o.g(aVar, 0);
                SightPlayTextureView.this.mSurface = new Surface(surfaceTexture);
                SightPlayTextureView.this.Dnr.j(SightPlayTextureView.this.mSurface);
                SightPlayTextureView.this.gLi();
                AppMethodBeat.o(28643);
            }
        });
        AppMethodBeat.o(28650);
    }

    static final class a implements Runnable {
        Surface DnG;

        private a() {
            this.DnG = null;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(28646);
            if (this.DnG == null) {
                AppMethodBeat.o(28646);
                return;
            }
            this.DnG.release();
            AppMethodBeat.o(28646);
        }
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public String getVideoPath() {
        return this.Dnr.cJp;
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public final void clear() {
        AppMethodBeat.i(28651);
        this.Dnr.clear();
        AppMethodBeat.o(28651);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public final void e(String str, boolean z, int i2) {
        AppMethodBeat.i(169764);
        this.Dnr.cd(str, z);
        AppMethodBeat.o(169764);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setPosition(int i2) {
        this.Dnr.position = i2;
    }

    @Override // com.tencent.mm.ui.base.MMTextureView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(28654);
        super.onDetachedFromWindow();
        Log.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.Dnr.clear();
        EventCenter.instance.removeListener(this.Dnr.eVB());
        AppMethodBeat.o(28654);
    }

    @Override // com.tencent.mm.ui.base.MMTextureView
    public void onAttachedToWindow() {
        AppMethodBeat.i(28655);
        Log.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        EventCenter.instance.addListener(this.Dnr.eVB());
        AppMethodBeat.o(28655);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setDrawableWidth(int i2) {
        AppMethodBeat.i(28656);
        this.Dnt = i2;
        y(0.75d);
        AppMethodBeat.o(28656);
    }

    private void y(double d2) {
        AppMethodBeat.i(28657);
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != ((int) (((double) this.Dnt) * d2))) {
            layoutParams.width = this.Dnt;
            layoutParams.height = (int) (((double) this.Dnt) * d2);
            if (this.Dny && layoutParams.height < com.tencent.mm.cb.a.fromDPToPix(getContext(), 50)) {
                layoutParams.height = com.tencent.mm.cb.a.fromDPToPix(getContext(), 50);
            }
            Log.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
            if (MMHandlerThread.isMainThread()) {
                setLayoutParams(layoutParams);
                AppMethodBeat.o(28657);
                return;
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(28644);
                    SightPlayTextureView.this.setLayoutParams(layoutParams);
                    AppMethodBeat.o(28644);
                }
            });
        }
        AppMethodBeat.o(28657);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.i(28658);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bitmap == null);
        objArr[1] = Boolean.valueOf(this.mSurface == null);
        Log.d("MicroMsg.SightPlayTextureView", "thumb is null? %B, surface is null? %B", objArr);
        if (bitmap != null) {
            Log.d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            if (this.Dny) {
                if (bitmap.getWidth() >= bitmap.getHeight()) {
                    this.Dnt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 150);
                } else {
                    this.Dnt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 85);
                }
            }
            Bitmap a2 = com.tencent.mm.plugin.sight.decode.a.b.a(getContext(), this.DnE, this.Dnt, bitmap.getWidth(), bitmap.getHeight());
            y(((double) bitmap.getHeight()) / ((double) bitmap.getWidth()));
            this.Dnr.Dmv = a2;
            this.Dnr.as(bitmap);
            AppMethodBeat.o(28658);
            return;
        }
        this.Dnr.as(null);
        AppMethodBeat.o(28658);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public final void eVw() {
        AppMethodBeat.i(28659);
        SightVideoJNI.drawSurfaceThumb(this.mSurface, com.tencent.mm.plugin.sight.decode.a.b.a(getContext(), R.drawable.bjn, this.Dnt, 320, 240), com.tencent.mm.plugin.sight.decode.a.b.a(getContext(), this.DnE, this.Dnt, 320, 240));
        AppMethodBeat.o(28659);
    }

    public void setMaskID(int i2) {
        this.DnE = i2;
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.i(28660);
        setTag(obj);
        AppMethodBeat.o(28660);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public Object getTagObject() {
        AppMethodBeat.i(28661);
        Object tag = getTag();
        AppMethodBeat.o(28661);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.i(28662);
        Context context = getContext();
        AppMethodBeat.o(28662);
        return context;
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public final void im(int i2, int i3) {
        AppMethodBeat.i(28663);
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        this.Dnt = i2;
        layoutParams.width = this.Dnt;
        layoutParams.height = (this.Dnt * i3) / i2;
        Log.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        if (MMHandlerThread.isMainThread()) {
            setLayoutParams(layoutParams);
            AppMethodBeat.o(28663);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(28645);
                SightPlayTextureView.this.setLayoutParams(layoutParams);
                AppMethodBeat.o(28645);
            }
        });
        AppMethodBeat.o(28663);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setCanPlay(boolean z) {
        this.Dnr.DmM = z;
    }

    public void setOnCompletionListener(b.e eVar) {
        this.Dnr.DmZ = eVar;
    }

    public void setOnSightCompletionAction(b.g gVar) {
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.i(28664);
        this.Dnr.setThumbBgView(view);
        AppMethodBeat.o(28664);
    }

    public void setIsWhatsNew(boolean z) {
        this.Dnr.DmR = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.i(28665);
        this.Dnr.setSightInfoView(textView);
        AppMethodBeat.o(28665);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setForceRecordState(boolean z) {
    }

    public void setOnDecodeDurationListener(b.f fVar) {
        AppMethodBeat.i(232059);
        this.Dnr.setOnDecodeDurationListener(fVar);
        AppMethodBeat.o(232059);
    }
}
