package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

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
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView extends QPictureView {
    private int Dnt;
    private int Dnu;
    private int Dnv;
    private int Dnw;
    public boolean Dnx;
    private boolean Dny;
    private boolean Dnz;
    b EhJ;
    public j.a rso;

    static final class a extends b {
        private WeakReference<AdlandingSightPlayImageView> Dns;

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b
        public final int eVx() {
            return R.anim.eh;
        }

        public a(AdlandingSightPlayImageView adlandingSightPlayImageView) {
            super(adlandingSightPlayImageView);
            AppMethodBeat.i(96898);
            this.Dns = new WeakReference<>(adlandingSightPlayImageView);
            AppMethodBeat.o(96898);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b
        public final void eo(int i2, int i3) {
            AppMethodBeat.i(96899);
            final AdlandingSightPlayImageView adlandingSightPlayImageView = this.Dns.get();
            if (adlandingSightPlayImageView == null) {
                Log.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
                clear();
                AppMethodBeat.o(96899);
            } else if (adlandingSightPlayImageView.Dnz) {
                AppMethodBeat.o(96899);
            } else {
                adlandingSightPlayImageView.Dnv = i2;
                adlandingSightPlayImageView.Dnw = i3;
                if (adlandingSightPlayImageView.rso != null) {
                    adlandingSightPlayImageView.rso.eo(i2, i3);
                }
                if (adlandingSightPlayImageView.Dny) {
                    if (adlandingSightPlayImageView.Dnv >= adlandingSightPlayImageView.Dnw) {
                        adlandingSightPlayImageView.Dnt = com.tencent.mm.cb.a.fromDPToPix(adlandingSightPlayImageView.getContext(), 150);
                    } else {
                        adlandingSightPlayImageView.Dnt = com.tencent.mm.cb.a.fromDPToPix(adlandingSightPlayImageView.getContext(), 85);
                    }
                }
                if (adlandingSightPlayImageView.Dnt > 0) {
                    final ViewGroup.LayoutParams layoutParams = adlandingSightPlayImageView.getLayoutParams();
                    if (!(layoutParams.width == adlandingSightPlayImageView.Dnt && layoutParams.height == (adlandingSightPlayImageView.Dnt * i3) / i2)) {
                        layoutParams.width = adlandingSightPlayImageView.Dnt;
                        layoutParams.height = (adlandingSightPlayImageView.Dnt * i3) / i2;
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView.a.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(96897);
                                adlandingSightPlayImageView.setLayoutParams(layoutParams);
                                AppMethodBeat.o(96897);
                            }
                        });
                        adlandingSightPlayImageView.postInvalidate();
                    }
                    Log.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                }
                Log.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", Integer.valueOf(adlandingSightPlayImageView.Dnt), Integer.valueOf(i2), Integer.valueOf(i3));
                AppMethodBeat.o(96899);
            }
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b
        public final void at(Bitmap bitmap) {
            AppMethodBeat.i(96900);
            AdlandingSightPlayImageView adlandingSightPlayImageView = this.Dns.get();
            if (adlandingSightPlayImageView == null) {
                Log.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                AppMethodBeat.o(96900);
                return;
            }
            adlandingSightPlayImageView.setImageBitmap(bitmap);
            AppMethodBeat.o(96900);
        }
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(96901);
        this.Dnx = true;
        this.Dny = false;
        this.Dnz = false;
        this.EhJ = new a(this);
        Log.i("MicroMsg.SightPlayImageView", "mController %s", Util.getStack().toString());
        AppMethodBeat.o(96901);
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public String getVideoPath() {
        return this.EhJ.cJp;
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void setImageBitmap(Bitmap bitmap) {
        int height;
        int width;
        AppMethodBeat.i(96902);
        super.setImageBitmap(bitmap);
        if (this.Dnz) {
            AppMethodBeat.o(96902);
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
        if (((float) layoutParams.height) != ((float) (this.Dnt * height)) / ((float) width)) {
            layoutParams.width = this.Dnt;
            layoutParams.height = (int) ((((float) height) * ((float) this.Dnt)) / ((float) width));
            setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(96902);
    }

    @Override // com.tencent.mm.ui.widget.QImageView, com.tencent.mm.memory.ui.QPictureView
    public void setImageDrawable(Drawable drawable) {
        int intrinsicHeight;
        int intrinsicWidth;
        AppMethodBeat.i(96903);
        super.setImageDrawable(drawable);
        if (this.Dnz) {
            AppMethodBeat.o(96903);
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
            if (((float) layoutParams.height) != (((float) this.Dnt) * ((float) intrinsicHeight)) / ((float) intrinsicWidth)) {
                layoutParams.width = this.Dnt;
                layoutParams.height = (int) ((((float) intrinsicHeight) * ((float) this.Dnt)) / ((float) intrinsicWidth));
                setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.o(96903);
    }

    public final void au(Bitmap bitmap) {
        AppMethodBeat.i(96904);
        super.setImageBitmap(bitmap);
        AppMethodBeat.o(96904);
    }

    public final void cd(String str, boolean z) {
        AppMethodBeat.i(96905);
        b bVar = this.EhJ;
        Log.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", Integer.valueOf(bVar.hashCode()), str, bVar.cJp, Boolean.valueOf(z), Integer.valueOf(bVar.Dmr), Boolean.valueOf(bVar.DmX), Boolean.valueOf(bVar.DmM));
        if (bVar.DmX) {
            bVar.uD(false);
            AppMethodBeat.o(96905);
        } else if (bVar.eVz()) {
            Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            bVar.clear();
            AppMethodBeat.o(96905);
        } else if (!bVar.DmM) {
            bVar.clear();
            AppMethodBeat.o(96905);
        } else if (z) {
            bVar.Dmq = str;
            bVar.uD(false);
            AppMethodBeat.o(96905);
        } else if (bVar.cJp.equals(str)) {
            bVar.Dmq = "ERROR#PATH";
            bVar.uD(false);
            bVar.restart();
            AppMethodBeat.o(96905);
        } else {
            bVar.clear();
            if (str == null) {
                str = "";
            }
            bVar.cJp = str;
            if (Util.isNullOrNil(bVar.cJp)) {
                Log.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                bVar.fdR();
                AppMethodBeat.o(96905);
            } else if (!b.aNy(bVar.cJp)) {
                Log.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                bVar.clear();
                AppMethodBeat.o(96905);
            } else {
                bVar.Ehs = new b.h(bVar, (byte) 0);
                o.g(bVar.Ehs, 0);
                AppMethodBeat.o(96905);
            }
        }
    }

    public void setPosition(int i2) {
        this.EhJ.position = i2;
    }

    @Override // com.tencent.mm.ui.widget.QImageView, com.tencent.mm.memory.ui.QPictureView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(96906);
        super.onDetachedFromWindow();
        Log.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.EhJ.clear();
        EventCenter.instance.removeListener(this.EhJ.eVB());
        AppMethodBeat.o(96906);
    }

    @Override // com.tencent.mm.memory.ui.QPictureView
    public void onAttachedToWindow() {
        AppMethodBeat.i(96907);
        Log.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        EventCenter.instance.addListener(this.EhJ.eVB());
        AppMethodBeat.o(96907);
    }

    public void setDrawableWidth(int i2) {
        AppMethodBeat.i(96908);
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
        AppMethodBeat.o(96908);
    }

    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.i(96909);
        setImageBitmap(bitmap);
        AppMethodBeat.o(96909);
    }

    public void setMaskID(int i2) {
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.i(96910);
        setTag(obj);
        AppMethodBeat.o(96910);
    }

    public Object getTagObject() {
        AppMethodBeat.i(96911);
        Object tag = getTag();
        AppMethodBeat.o(96911);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.i(96912);
        Context context = getContext();
        AppMethodBeat.o(96912);
        return context;
    }

    public void setCanPlay(boolean z) {
        this.EhJ.DmM = z;
    }

    public void setOnCompletionListener(b.e eVar) {
        this.EhJ.EhA = eVar;
    }

    public void setOnSightCompletionAction(b.g gVar) {
        this.EhJ.EhC = gVar;
    }

    public void setOnDecodeDurationListener(b.f fVar) {
        this.EhJ.EhB = fVar;
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.i(96913);
        this.EhJ.Dmx = new WeakReference<>(view);
        AppMethodBeat.o(96913);
    }

    public void setIsWhatsNew(boolean z) {
        this.EhJ.DmR = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.i(96914);
        this.EhJ.Dmy = new WeakReference<>(textView);
        AppMethodBeat.o(96914);
    }

    public final void uE(boolean z) {
        AppMethodBeat.i(96915);
        b bVar = this.EhJ;
        Log.i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (bVar.Ehu != null) {
                bVar.Ehu.type = 0;
                o.g(bVar.Ehu, 0);
            }
            bVar.Ehu = null;
        } else if (bVar.Ehu == null) {
            bVar.Ehu = new b.i(bVar, (byte) 0);
            AppMethodBeat.o(96915);
            return;
        }
        AppMethodBeat.o(96915);
    }

    public void setForceRecordState(boolean z) {
    }

    public b getController() {
        return this.EhJ;
    }

    public int getDuration() {
        double videoDuration;
        AppMethodBeat.i(96916);
        if (this.EhJ == null) {
            AppMethodBeat.o(96916);
            return 0;
        }
        b bVar = this.EhJ;
        if (bVar.Dmr == -1) {
            videoDuration = 0.0d;
        } else {
            videoDuration = SightVideoJNI.getVideoDuration(bVar.Dmr);
        }
        int i2 = (int) videoDuration;
        AppMethodBeat.o(96916);
        return i2;
    }

    public void setLoopImp(boolean z) {
        if (this.EhJ != null) {
            this.EhJ.jqj = z;
        }
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(96917);
        super.onDraw(canvas);
        AppMethodBeat.o(96917);
    }
}
