package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;

public class AdlandingVideoSightView extends AdlandingSightPlayImageView implements j {
    private boolean EhM;
    private boolean EhN = true;
    protected String cJp;
    protected int duration = 0;
    private boolean guh = false;

    public AdlandingVideoSightView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(96920);
        init();
        AppMethodBeat.o(96920);
    }

    public AdlandingVideoSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(96921);
        init();
        AppMethodBeat.o(96921);
    }

    private void init() {
        AppMethodBeat.i(96922);
        if (Util.nullAs(ae.gKE.gHE, "").equals(FacebookRequestErrorClassification.KEY_OTHER)) {
            Log.i("MicroMsg.VideoSightView", "init::use other player");
        } else {
            uE(true);
        }
        setOnCompletionListener(new b.e() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.e
            public final void Zb(int i2) {
                AppMethodBeat.i(96918);
                if (-1 == i2) {
                    if (AdlandingVideoSightView.this.rso != null) {
                        AdlandingVideoSightView.this.rso.onError(0, 0);
                        AppMethodBeat.o(96918);
                        return;
                    }
                } else if (i2 == 0 && AdlandingVideoSightView.this.rso != null) {
                    AdlandingVideoSightView.this.rso.onCompletion();
                }
                AppMethodBeat.o(96918);
            }
        });
        AppMethodBeat.o(96922);
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(96923);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(96923);
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(96924);
        super.onLayout(z, i2, i3, i4, i5);
        Log.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(this.Dnx));
        if (this.Dnx && i4 - i2 > 0) {
            setDrawableWidth(i4 - i2);
        }
        AppMethodBeat.o(96924);
    }

    public void setEnableConfigChanged(boolean z) {
        this.EhN = z;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(96925);
        super.onConfigurationChanged(configuration);
        if (this.EhN) {
            setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
        }
        AppMethodBeat.o(96925);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoPath(String str) {
        AppMethodBeat.i(96927);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(this.rso == null);
        Log.i("MicroMsg.VideoSightView", "set sight path %s, callback null ? %B", objArr);
        this.duration = 0;
        this.cJp = str;
        if (this.rso != null) {
            this.rso.tf();
        }
        AppMethodBeat.o(96927);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void pause() {
        AppMethodBeat.i(96929);
        cd(this.cJp, true);
        AppMethodBeat.o(96929);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setLoop(boolean z) {
        AppMethodBeat.i(96930);
        setLoopImp(z);
        AppMethodBeat.o(96930);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoCallback(j.a aVar) {
        this.rso = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public int getCurrentPosition() {
        AppMethodBeat.i(96931);
        Log.v("MicroMsg.VideoSightView", "get current position");
        AppMethodBeat.o(96931);
        return 0;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView, com.tencent.mm.pluginsdk.ui.tools.j
    public int getDuration() {
        AppMethodBeat.i(96932);
        int duration2 = super.getDuration();
        Log.v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(duration2)));
        AppMethodBeat.o(96932);
        return duration2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean start() {
        AppMethodBeat.i(96934);
        boolean E = E(getContext(), false);
        AppMethodBeat.o(96934);
        return E;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean E(Context context, boolean z) {
        boolean z2;
        AppMethodBeat.i(96935);
        if (this.cJp == null) {
            Log.e("MicroMsg.VideoSightView", "start::use path is null!");
            AppMethodBeat.o(96935);
            return false;
        } else if (Util.nullAs(ae.gKE.gHE, "").equals(FacebookRequestErrorClassification.KEY_OTHER) || !com.tencent.mm.plugin.sight.decode.a.b.aNy(this.cJp)) {
            Log.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", this.cJp, Boolean.valueOf(this.EhM));
            if (!this.EhM || z) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                FileProviderHelper.setIntentDataAndType(context, intent, new o(this.cJp), "video/*", false);
                try {
                    a bl = new a().bl(Intent.createChooser(intent, context.getString(R.string.cd1)));
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdlandingVideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdlandingVideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } catch (Exception e2) {
                    Log.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
                    h.cD(context, context.getResources().getString(R.string.hwr));
                }
                this.EhM = true;
                AppMethodBeat.o(96935);
                return false;
            }
            AppMethodBeat.o(96935);
            return false;
        } else {
            cd(this.cJp, false);
            if (!this.guh) {
                z2 = true;
            } else {
                z2 = false;
            }
            uE(z2);
            AppMethodBeat.o(96935);
            return true;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setThumb(Bitmap bitmap) {
        AppMethodBeat.i(96936);
        au(bitmap);
        AppMethodBeat.o(96936);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public double getLastProgresstime() {
        AppMethodBeat.i(96937);
        if (getController() != null) {
            b controller = getController();
            if (controller.DmV != -1.0d) {
                double d2 = controller.DmV;
                AppMethodBeat.o(96937);
                return d2;
            }
            double d3 = controller.DmS;
            AppMethodBeat.o(96937);
            return d3;
        }
        AppMethodBeat.o(96937);
        return 0.0d;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.i(96939);
        if (z) {
            setOnDecodeDurationListener(new b.f() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.f
                public final void JB(long j2) {
                    AppMethodBeat.i(96919);
                    if (AdlandingVideoSightView.this.duration == 0) {
                        AdlandingVideoSightView.this.duration = AdlandingVideoSightView.this.getDuration();
                    }
                    if (AdlandingVideoSightView.this.rso != null) {
                        Log.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", Long.valueOf(j2), Integer.valueOf(AdlandingVideoSightView.this.duration));
                        AdlandingVideoSightView.this.rso.fh((int) j2, AdlandingVideoSightView.this.duration);
                    }
                    AppMethodBeat.o(96919);
                }
            });
            AppMethodBeat.o(96939);
            return;
        }
        setOnDecodeDurationListener(null);
        AppMethodBeat.o(96939);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setMute(boolean z) {
        AppMethodBeat.i(96940);
        this.guh = z;
        uE(!this.guh);
        AppMethodBeat.o(96940);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void d(double d2, boolean z) {
        AppMethodBeat.i(96941);
        q(d2);
        AppMethodBeat.o(96941);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOneTimeVideoTextureUpdateCallback(j.e eVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnSeekCompleteCallback(j.c cVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnInfoCallback(j.b bVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnSurfaceCallback(j.d dVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean isPlaying() {
        AppMethodBeat.i(96926);
        boolean eVy = this.EhJ.eVy();
        AppMethodBeat.o(96926);
        return eVy;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void stop() {
        AppMethodBeat.i(96928);
        this.EhJ.clear();
        AppMethodBeat.o(96928);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void onDetach() {
        AppMethodBeat.i(96933);
        EventCenter.instance.removeListener(this.EhJ.eVB());
        AppMethodBeat.o(96933);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void q(double d2) {
        AppMethodBeat.i(96938);
        if (this.EhJ != null) {
            b bVar = this.EhJ;
            Log.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", Double.valueOf(d2), Util.getStack().toString());
            com.tencent.mm.modelvideo.o.g(new Runnable(d2) {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.AnonymousClass2 */
                final /* synthetic */ double Dnd;

                {
                    this.Dnd = r2;
                }

                public final void run() {
                    AppMethodBeat.i(96873);
                    Log.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", Double.valueOf(this.Dnd), Util.getStack().toString());
                    b.this.DmV = this.Dnd;
                    AppMethodBeat.o(96873);
                }
            }, 0);
        }
        AppMethodBeat.o(96938);
    }
}
