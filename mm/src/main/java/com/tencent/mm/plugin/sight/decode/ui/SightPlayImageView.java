package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public class SightPlayImageView extends QPictureView implements com.tencent.mm.plugin.sight.decode.a.a {
    int DnA;
    public b Dnr;
    private int Dnt;
    private int Dnu;
    private int Dnv;
    private int Dnw;
    public boolean Dnx;
    private boolean Dny;
    public boolean Dnz;
    public j.a rso;

    static final class a extends b {
        private WeakReference<SightPlayImageView> Dns;

        @Override // com.tencent.mm.plugin.sight.decode.a.b
        public final int eVx() {
            return R.anim.eh;
        }

        public a(SightPlayImageView sightPlayImageView) {
            super(0, sightPlayImageView);
            AppMethodBeat.i(116099);
            this.Dns = new WeakReference<>(sightPlayImageView);
            AppMethodBeat.o(116099);
        }

        @Override // com.tencent.mm.plugin.sight.decode.a.b
        public final void eo(int i2, int i3) {
            AppMethodBeat.i(116100);
            final SightPlayImageView sightPlayImageView = this.Dns.get();
            if (sightPlayImageView == null) {
                Log.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
                clear();
                AppMethodBeat.o(116100);
            } else if (sightPlayImageView.Dnz) {
                AppMethodBeat.o(116100);
            } else {
                sightPlayImageView.Dnv = i2;
                sightPlayImageView.Dnw = i3;
                if (sightPlayImageView.rso != null) {
                    sightPlayImageView.rso.eo(i2, i3);
                }
                if (sightPlayImageView.Dny) {
                    if (sightPlayImageView.Dnv >= sightPlayImageView.Dnw) {
                        sightPlayImageView.Dnt = com.tencent.mm.cb.a.fromDPToPix(sightPlayImageView.getContext(), 150);
                    } else {
                        sightPlayImageView.Dnt = com.tencent.mm.cb.a.fromDPToPix(sightPlayImageView.getContext(), 85);
                    }
                }
                if (sightPlayImageView.Dnt > 0) {
                    final ViewGroup.LayoutParams layoutParams = sightPlayImageView.getLayoutParams();
                    if (!(layoutParams.width == sightPlayImageView.Dnt && layoutParams.height == (sightPlayImageView.Dnt * i3) / i2)) {
                        layoutParams.width = sightPlayImageView.Dnt;
                        layoutParams.height = (sightPlayImageView.Dnt * i3) / i2;
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView.a.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(116098);
                                sightPlayImageView.setLayoutParams(layoutParams);
                                AppMethodBeat.o(116098);
                            }
                        });
                        sightPlayImageView.postInvalidate();
                    }
                    Log.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                }
                Log.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", Integer.valueOf(sightPlayImageView.Dnt), Integer.valueOf(i2), Integer.valueOf(i3));
                AppMethodBeat.o(116100);
            }
        }

        @Override // com.tencent.mm.plugin.sight.decode.a.b
        public final void at(Bitmap bitmap) {
            AppMethodBeat.i(116101);
            SightPlayImageView sightPlayImageView = this.Dns.get();
            if (sightPlayImageView == null) {
                Log.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                AppMethodBeat.o(116101);
                return;
            }
            sightPlayImageView.setImageBitmap(bitmap);
            AppMethodBeat.o(116101);
        }
    }

    public final void eVK() {
        this.Dnz = true;
    }

    public void setDrawWidthAndHeightFix(boolean z) {
        this.Dnz = z;
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(116102);
        this.Dnx = true;
        this.Dny = false;
        this.Dnz = false;
        this.DnA = 0;
        this.Dnr = new a(this);
        Log.i("MicroMsg.SightPlayImageView", "mController %s", Util.getStack().toString());
        AppMethodBeat.o(116102);
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SightPlayImageView(Context context) {
        this(context, null, 0);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public String getVideoPath() {
        return this.Dnr.cJp;
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void setImageBitmap(Bitmap bitmap) {
        int height;
        int width;
        AppMethodBeat.i(116103);
        super.setImageBitmap(bitmap);
        if (this.Dnz) {
            AppMethodBeat.o(116103);
            return;
        }
        if (bitmap == null) {
            height = this.Dnu == 0 ? 240 : this.Dnu;
        } else {
            height = bitmap.getHeight();
        }
        if (bitmap == null) {
            width = this.Dnt == 0 ? 320 : this.Dnt;
        } else {
            width = bitmap.getWidth();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != ((int) (((float) (this.Dnt * height)) / ((float) width)))) {
            layoutParams.width = this.Dnt;
            layoutParams.height = (int) ((((float) height) * ((float) this.Dnt)) / ((float) width));
            setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(116103);
    }

    public void setScaleMode(int i2) {
        this.DnA = i2;
    }

    @Override // com.tencent.mm.ui.widget.QImageView, com.tencent.mm.memory.ui.QPictureView
    public void setImageDrawable(Drawable drawable) {
        int intrinsicHeight;
        int intrinsicWidth;
        AppMethodBeat.i(116104);
        super.setImageDrawable(drawable);
        if (this.Dnz) {
            AppMethodBeat.o(116104);
            return;
        }
        if (drawable == null) {
            intrinsicHeight = this.Dnu == 0 ? 240 : this.Dnu;
        } else {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        if (drawable == null) {
            intrinsicWidth = this.Dnt == 0 ? 320 : this.Dnt;
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        if (!(intrinsicHeight == 0 || intrinsicWidth == 0)) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.height != ((int) ((((float) this.Dnt) * ((float) intrinsicHeight)) / ((float) intrinsicWidth))) && this.DnA == 0) {
                layoutParams.width = this.Dnt;
                layoutParams.height = (int) ((((float) intrinsicHeight) * ((float) this.Dnt)) / ((float) intrinsicWidth));
                setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.o(116104);
    }

    public final void au(Bitmap bitmap) {
        AppMethodBeat.i(116105);
        super.setImageBitmap(bitmap);
        AppMethodBeat.o(116105);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public final void clear() {
        AppMethodBeat.i(116106);
        this.Dnr.clear();
        AppMethodBeat.o(116106);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void e(String str, boolean z, int i2) {
        AppMethodBeat.i(177100);
        this.Dnr.cd(str, z);
        AppMethodBeat.o(177100);
    }

    public final boolean eVL() {
        AppMethodBeat.i(116108);
        boolean eVz = this.Dnr.eVz();
        AppMethodBeat.o(116108);
        return eVz;
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setPosition(int i2) {
        this.Dnr.position = i2;
    }

    @Override // com.tencent.mm.ui.widget.QImageView, com.tencent.mm.memory.ui.QPictureView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(116109);
        super.onDetachedFromWindow();
        Log.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.Dnr.clear();
        EventCenter.instance.removeListener(this.Dnr.eVB());
        AppMethodBeat.o(116109);
    }

    @Override // com.tencent.mm.memory.ui.QPictureView
    public void onAttachedToWindow() {
        AppMethodBeat.i(116110);
        Log.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        EventCenter.instance.addListener(this.Dnr.eVB());
        AppMethodBeat.o(116110);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setDrawableWidth(int i2) {
        AppMethodBeat.i(116111);
        this.Dnx = false;
        this.Dnt = i2;
        if (this.Dnv > 0 && this.Dnw > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            this.Dnu = (this.Dnt * this.Dnw) / this.Dnv;
            if (!(layoutParams.width == this.Dnt && layoutParams.height == this.Dnu)) {
                layoutParams.width = this.Dnt;
                layoutParams.height = this.Dnu;
                setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.o(116111);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.i(116112);
        setImageBitmap(bitmap);
        AppMethodBeat.o(116112);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public final void eVw() {
        AppMethodBeat.i(116113);
        setImageBitmap(null);
        setImageResource(R.drawable.bjn);
        AppMethodBeat.o(116113);
    }

    public void setMaskID(int i2) {
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.i(116114);
        setTag(obj);
        AppMethodBeat.o(116114);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public Object getTagObject() {
        AppMethodBeat.i(116115);
        Object tag = getTag();
        AppMethodBeat.o(116115);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.i(116116);
        Context context = getContext();
        AppMethodBeat.o(116116);
        return context;
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void im(int i2, int i3) {
        AppMethodBeat.i(116117);
        this.Dnx = false;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        this.Dnt = i2;
        this.Dnu = (this.Dnt * i3) / i2;
        layoutParams.width = this.Dnt;
        layoutParams.height = this.Dnu;
        setLayoutParams(layoutParams);
        postInvalidate();
        AppMethodBeat.o(116117);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setCanPlay(boolean z) {
        this.Dnr.DmM = z;
    }

    public void setOnCompletionListener(b.e eVar) {
        this.Dnr.DmZ = eVar;
    }

    public void setOnSightCompletionAction(b.g gVar) {
        this.Dnr.Dnb = gVar;
    }

    public void setOnDecodeDurationListener(b.f fVar) {
        AppMethodBeat.i(204060);
        this.Dnr.setOnDecodeDurationListener(fVar);
        AppMethodBeat.o(204060);
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.i(116118);
        this.Dnr.setThumbBgView(view);
        AppMethodBeat.o(116118);
    }

    public void setIsWhatsNew(boolean z) {
        this.Dnr.DmR = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.i(116119);
        this.Dnr.setSightInfoView(textView);
        AppMethodBeat.o(116119);
    }

    public final void uE(boolean z) {
        AppMethodBeat.i(116120);
        b bVar = this.Dnr;
        Log.i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (bVar.DmF != null) {
                bVar.DmF.type = 0;
                o.g(bVar.DmF, 0);
            }
            bVar.DmF = null;
        } else if (bVar.DmF == null) {
            bVar.DmF = new b.i(bVar, (byte) 0);
            AppMethodBeat.o(116120);
            return;
        }
        AppMethodBeat.o(116120);
    }

    @Override // com.tencent.mm.plugin.sight.decode.a.a
    public void setForceRecordState(boolean z) {
    }

    public b getController() {
        return this.Dnr;
    }

    public int getDuration() {
        AppMethodBeat.i(116121);
        if (this.Dnr == null) {
            AppMethodBeat.o(116121);
            return 0;
        }
        int eVC = (int) this.Dnr.eVC();
        AppMethodBeat.o(116121);
        return eVC;
    }

    public void setLoopImp(boolean z) {
        if (this.Dnr != null) {
            this.Dnr.jqj = z;
        }
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(116122);
        super.onDraw(canvas);
        AppMethodBeat.o(116122);
    }

    public void setIsAdVideo(boolean z) {
        if (this.Dnr != null) {
            this.Dnr.DmO = z;
        }
    }

    public void setIsForbidLoopAnim(boolean z) {
        if (this.Dnr != null) {
            this.Dnr.DmP = z;
        }
    }
}
