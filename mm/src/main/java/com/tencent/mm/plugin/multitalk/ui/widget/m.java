package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.widget.j;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0016J(\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\r\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0014J\b\u0010$\u001a\u00020\u0014H\u0016J\u000e\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0016J\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u0012H\u0016J\u000e\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\u0006\u0010,\u001a\u00020\u0012J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u001cH\u0016J\u000e\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0016J\u000e\u00101\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0016J\u000e\u00102\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u00103\u001a\u00020\u0012J\u0006\u00104\u001a\u00020\u0012J\b\u00105\u001a\u00020\u0012H\u0016J\u0012\u00106\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u00108\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView;", "Lcom/tencent/mm/plugin/voip/widget/BaseSmallView;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mStatusView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniStatusLayout;", "mVideoView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVideoView;", "mVoiceView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView;", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "radius", "", "changeRendererSpeaker", "", "userName", "", "checkIfReceivingVideo", "", "drawAvatar", "drawBitmap", "bm", "Landroid/graphics/Bitmap;", "angle", "", "mirror", "getAvatarIv", "Landroid/widget/ImageView;", "getLastRenderSwitchTick", "", "()Ljava/lang/Long;", "getRendererSpeaker", "getUsername", "initShowMode", "isVideo", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "refreshMiniView", "refreshRenderTick", "setVoicePlayDevice", "device", "showSelfCameraStatus", "show", "showSelfMuteStatus", "showSpeakerAvatar", "switchToVideo", "switchToVoice", "uninit", "updateText", "text", ch.COL_UPDATETIME, "Companion", "plugin-multitalk_release"})
public final class m extends BaseSmallView implements f {
    public static final a zTL = new a((byte) 0);
    private HashMap _$_findViewCache;
    private PowerManager.WakeLock hCN;
    private final float radius = ((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 12));
    j zTI;
    i zTJ;
    private h zTK;

    static {
        AppMethodBeat.i(239840);
        AppMethodBeat.o(239840);
    }

    private View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(239841);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(239841);
        return view;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallView$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(Context context) {
        super(context, null);
        p.h(context, "context");
        AppMethodBeat.i(239839);
        Object systemService = MMApplicationContext.getContext().getSystemService("power");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.os.PowerManager");
            AppMethodBeat.o(239839);
            throw tVar;
        }
        this.hCN = ((PowerManager) systemService).newWakeLock(536870922, "MicroMsg.MultiTalkSmallView");
        PowerManager.WakeLock wakeLock = this.hCN;
        if (wakeLock != null) {
            wakeLock.acquire();
        }
        LayoutInflater.from(context).inflate(R.layout.bct, this);
        setClipToOutline(true);
        setOutlineProvider(new e(this.radius));
        View _$_findCachedViewById = _$_findCachedViewById(R.id.fpg);
        p.g(_$_findCachedViewById, "multitalk_voice");
        _$_findCachedViewById.setClipToOutline(true);
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.fpg);
        p.g(_$_findCachedViewById2, "multitalk_voice");
        _$_findCachedViewById2.setOutlineProvider(new e(this.radius));
        View _$_findCachedViewById3 = _$_findCachedViewById(R.id.fpe);
        p.g(_$_findCachedViewById3, "multitalk_video");
        _$_findCachedViewById3.setClipToOutline(true);
        View _$_findCachedViewById4 = _$_findCachedViewById(R.id.fpe);
        p.g(_$_findCachedViewById4, "multitalk_video");
        _$_findCachedViewById4.setOutlineProvider(new e(this.radius));
        View _$_findCachedViewById5 = _$_findCachedViewById(R.id.fpg);
        p.g(_$_findCachedViewById5, "multitalk_voice");
        this.zTI = new j(_$_findCachedViewById5);
        View _$_findCachedViewById6 = _$_findCachedViewById(R.id.fpe);
        p.g(_$_findCachedViewById6, "multitalk_video");
        this.zTJ = new i(_$_findCachedViewById6);
        View _$_findCachedViewById7 = _$_findCachedViewById(R.id.foq);
        p.g(_$_findCachedViewById7, "multitalk_minio_small_status_layout");
        this.zTK = new h(_$_findCachedViewById7);
        AppMethodBeat.o(239839);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void uninit() {
        ImageView imageView;
        AppMethodBeat.i(239824);
        super.uninit();
        i iVar = this.zTJ;
        if (!(iVar == null || (imageView = iVar.zTa) == null)) {
            imageView.clearAnimation();
        }
        j jVar = this.zTI;
        if (jVar != null) {
            jVar.lJI.clearAnimation();
        }
        if (this.hCN != null) {
            PowerManager.WakeLock wakeLock = this.hCN;
            if (wakeLock == null) {
                p.hyc();
            }
            if (wakeLock.isHeld()) {
                Log.i("MicroMsg.MultiTalkSmallView", "release waklock");
                PowerManager.WakeLock wakeLock2 = this.hCN;
                if (wakeLock2 != null) {
                    wakeLock2.release();
                    AppMethodBeat.o(239824);
                    return;
                }
            }
        }
        AppMethodBeat.o(239824);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r1 = 4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void rS(boolean r6) {
        /*
            r5 = this;
            r4 = 239825(0x3a8d1, float:3.36066E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r6 == 0) goto L_0x002a
            com.tencent.mm.plugin.multitalk.ui.widget.j r0 = r5.zTI
            if (r0 == 0) goto L_0x001e
            r1 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            if (r1 == 0) goto L_0x001e
            android.view.View r2 = r0.lJI
            int r3 = r1.intValue()
            r2.setVisibility(r3)
            r0.zTu = r1
        L_0x001e:
            com.tencent.mm.plugin.multitalk.ui.widget.i r0 = r5.zTJ
            if (r0 == 0) goto L_0x002a
            r1 = 0
            r0.H(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0029:
            return
        L_0x002a:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.m.rS(boolean):void");
    }

    public final void eoJ() {
        AppMethodBeat.i(239826);
        j jVar = this.zTI;
        Integer eoH = jVar != null ? jVar.eoH() : null;
        if (eoH == null || eoH.intValue() != 4) {
            j jVar2 = this.zTI;
            if (jVar2 != null) {
                jVar2.lJI.setAlpha(1.0f);
                jVar2.lJI.setVisibility(0);
                jVar2.lJI.clearAnimation();
                jVar2.lJI.animate().alpha(0.0f).setDuration(300).setListener(new j.a(jVar2)).start();
            }
            i iVar = this.zTJ;
            if (iVar != null) {
                iVar.H(0);
            }
            i iVar2 = this.zTJ;
            if (iVar2 != null) {
                iVar2.aGv(getRendererSpeaker());
                AppMethodBeat.o(239826);
                return;
            }
        }
        AppMethodBeat.o(239826);
    }

    public final void rT(boolean z) {
        AppMethodBeat.i(239827);
        h hVar = this.zTK;
        if (hVar != null) {
            hVar.zSW = z;
            hVar.aa(hVar.zSX, hVar.zSW);
            AppMethodBeat.o(239827);
            return;
        }
        AppMethodBeat.o(239827);
    }

    public final void rU(boolean z) {
        AppMethodBeat.i(239828);
        h hVar = this.zTK;
        if (hVar != null) {
            hVar.zSX = z;
            hVar.aa(hVar.zSX, hVar.zSW);
            AppMethodBeat.o(239828);
            return;
        }
        AppMethodBeat.o(239828);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.f
    public final void a(String str, Bitmap bitmap, int i2, int i3) {
        String str2;
        i iVar;
        String str3 = null;
        AppMethodBeat.i(239829);
        p.h(str, "userName");
        p.h(bitmap, "bm");
        i iVar2 = this.zTJ;
        if (iVar2 != null) {
            str2 = iVar2.zTg;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            i iVar3 = this.zTJ;
            if (iVar3 != null) {
                str3 = iVar3.zTg;
            }
            if (p.j(str, str3) && (iVar = this.zTJ) != null) {
                iVar.b(str, bitmap, i3, i2);
                AppMethodBeat.o(239829);
                return;
            }
        }
        AppMethodBeat.o(239829);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.f
    public final void emz() {
    }

    @Override // com.tencent.mm.plugin.multitalk.model.f
    public final ImageView getAvatarIv() {
        return null;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.f
    public final String getUsername() {
        String str;
        i iVar = this.zTJ;
        return (iVar == null || (str = iVar.zTg) == null) ? "" : str;
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void aGx(String str) {
        String str2;
        AppMethodBeat.i(239830);
        super.aGx(str);
        j jVar = this.zTI;
        if (jVar != null) {
            TextView textView = jVar.timeTv;
            if (textView != null) {
                textView.setTextSize(1, 12.0f);
            }
            TextView textView2 = jVar.timeTv;
            if (textView2 != null) {
                textView2.setText(str);
            }
            View view = jVar.lJI;
            StringBuilder sb = new StringBuilder();
            Context context = jVar.context;
            if (context != null) {
                str2 = context.getString(R.string.b3_);
            } else {
                str2 = null;
            }
            view.setContentDescription(sb.append(String.valueOf(str2)).append(",").append(str).toString());
            AppMethodBeat.o(239830);
            return;
        }
        AppMethodBeat.o(239830);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final boolean eoK() {
        AppMethodBeat.i(239831);
        super.eoK();
        j jVar = this.zTI;
        if (jVar != null) {
            TextView textView = jVar.timeTv;
            if (textView != null) {
                textView.setVisibility(8);
            }
            WeImageView weImageView = jVar.zTt;
            if (weImageView != null) {
                weImageView.setBackground(ar.m(jVar.context, R.raw.icons_filled_call_end, Color.parseColor("#FA5151")));
            }
            WeImageView weImageView2 = jVar.zTt;
            if (weImageView2 != null) {
                weImageView2.setIconColor(Color.parseColor("#FA5151"));
            }
            TextView textView2 = jVar.jBS;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = jVar.jBS;
            if (textView3 != null) {
                textView3.setTextColor(Color.parseColor("#FA5151"));
            }
            TextView textView4 = jVar.jBS;
            if (textView4 != null) {
                textView4.setText(R.string.i3b);
            }
            jVar.lJI.clearAnimation();
        }
        i iVar = this.zTJ;
        if (iVar != null) {
            TextView textView5 = iVar.zSY;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            View view = iVar.zTc;
            if (view != null) {
                view.setVisibility(0);
            }
            ImageView imageView = iVar.zTd;
            if (imageView != null) {
                imageView.setImageDrawable(ar.m(iVar.context, R.raw.icons_filled_call_end, Color.parseColor("#FFFFFF")));
            }
            TextView textView6 = iVar.zTe;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            ImageView imageView2 = iVar.zTa;
            if (imageView2 != null) {
                imageView2.clearAnimation();
            }
            TextView textView7 = iVar.zTe;
            if (textView7 != null) {
                textView7.setText(R.string.i3b);
            }
        }
        AppMethodBeat.o(239831);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setVoicePlayDevice(int i2) {
        TextView textView;
        AppMethodBeat.i(239832);
        if (this.GUk != i2) {
            this.GUk = i2;
            i iVar = this.zTJ;
            if (!(iVar == null || (textView = iVar.zSY) == null)) {
                textView.setVisibility(8);
            }
            i iVar2 = this.zTJ;
            if (iVar2 != null) {
                View view = iVar2.zTc;
                if (view != null) {
                    view.setVisibility(0);
                }
                switch (i2) {
                    case 1:
                        ImageView imageView = iVar2.zTd;
                        if (imageView != null) {
                            imageView.setImageDrawable(ar.m(iVar2.context, R.raw.icons_filled_volume_up, Color.parseColor("#FFFFFF")));
                        }
                        TextView textView2 = iVar2.zTe;
                        if (textView2 == null) {
                            p.hyc();
                        }
                        textView2.setText(R.string.i3a);
                        break;
                    case 2:
                        ImageView imageView2 = iVar2.zTd;
                        if (imageView2 != null) {
                            imageView2.setImageDrawable(ar.m(iVar2.context, R.raw.icons_filled_ear, Color.parseColor("#FFFFFF")));
                        }
                        TextView textView3 = iVar2.zTe;
                        if (textView3 == null) {
                            p.hyc();
                        }
                        textView3.setText(R.string.i39);
                        break;
                    case 3:
                        ImageView imageView3 = iVar2.zTd;
                        if (imageView3 != null) {
                            imageView3.setImageDrawable(ar.m(iVar2.context, R.raw.icons_filled_headset, Color.parseColor("#FFFFFF")));
                        }
                        TextView textView4 = iVar2.zTe;
                        if (textView4 == null) {
                            p.hyc();
                        }
                        textView4.setText(R.string.i3_);
                        break;
                    case 4:
                        ImageView imageView4 = iVar2.zTd;
                        if (imageView4 != null) {
                            imageView4.setImageDrawable(ar.m(iVar2.context, R.raw.icons_filled_bluetooth, Color.parseColor("#FFFFFF")));
                        }
                        TextView textView5 = iVar2.zTe;
                        if (textView5 == null) {
                            p.hyc();
                        }
                        textView5.setText(R.string.i38);
                        break;
                }
            }
            j jVar = this.zTI;
            if (jVar != null) {
                TextView textView6 = jVar.jBS;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                switch (i2) {
                    case 1:
                        WeImageView weImageView = jVar.zTt;
                        if (weImageView != null) {
                            weImageView.setBackground(ar.m(jVar.context, R.raw.icons_filled_volume_up, Color.parseColor("#07C160")));
                        }
                        WeImageView weImageView2 = jVar.zTt;
                        if (weImageView2 != null) {
                            weImageView2.setIconColor(Color.parseColor("#07C160"));
                        }
                        TextView textView7 = jVar.jBS;
                        if (textView7 != null) {
                            textView7.setText(R.string.i3a);
                            break;
                        }
                        break;
                    case 2:
                        WeImageView weImageView3 = jVar.zTt;
                        if (weImageView3 != null) {
                            weImageView3.setBackground(ar.m(jVar.context, R.raw.icons_filled_ear, Color.parseColor("#07C160")));
                        }
                        WeImageView weImageView4 = jVar.zTt;
                        if (weImageView4 != null) {
                            weImageView4.setIconColor(Color.parseColor("#07C160"));
                        }
                        TextView textView8 = jVar.jBS;
                        if (textView8 != null) {
                            textView8.setText(R.string.i39);
                            break;
                        }
                        break;
                    case 3:
                        WeImageView weImageView5 = jVar.zTt;
                        if (weImageView5 != null) {
                            weImageView5.setBackground(ar.m(jVar.context, R.raw.icons_filled_headset, Color.parseColor("#07C160")));
                        }
                        WeImageView weImageView6 = jVar.zTt;
                        if (weImageView6 != null) {
                            weImageView6.setIconColor(Color.parseColor("#07C160"));
                        }
                        TextView textView9 = jVar.jBS;
                        if (textView9 != null) {
                            textView9.setText(R.string.i3_);
                            break;
                        }
                        break;
                    case 4:
                        WeImageView weImageView7 = jVar.zTt;
                        if (weImageView7 != null) {
                            weImageView7.setBackground(ar.m(jVar.context, R.raw.icons_filled_bluetooth, Color.parseColor("#07C160")));
                        }
                        WeImageView weImageView8 = jVar.zTt;
                        if (weImageView8 != null) {
                            weImageView8.setIconColor(Color.parseColor("#07C160"));
                        }
                        TextView textView10 = jVar.jBS;
                        if (textView10 != null) {
                            textView10.setText(R.string.i38);
                            break;
                        }
                        break;
                }
                TextView textView11 = jVar.timeTv;
                if (textView11 != null) {
                    textView11.setVisibility(8);
                }
            }
            super.setVoicePlayDevice(i2);
        }
        AppMethodBeat.o(239832);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void eoL() {
        AppMethodBeat.i(239833);
        i iVar = this.zTJ;
        if (iVar != null) {
            TextView textView = iVar.zSY;
            if (textView != null) {
                textView.setVisibility(0);
            }
            View view = iVar.zTc;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        j jVar = this.zTI;
        if (jVar != null) {
            WeImageView weImageView = jVar.zTt;
            if (weImageView != null) {
                weImageView.setBackground(ar.m(jVar.context, R.raw.icons_filled_call, Color.parseColor("#07C160")));
            }
            WeImageView weImageView2 = jVar.zTt;
            if (weImageView2 != null) {
                weImageView2.setIconColor(Color.parseColor("#07C160"));
            }
            TextView textView2 = jVar.jBS;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = jVar.jBS;
            if (textView3 != null) {
                textView3.setTextColor(Color.parseColor("#07C160"));
            }
            TextView textView4 = jVar.timeTv;
            if (textView4 != null) {
                textView4.setVisibility(0);
                AppMethodBeat.o(239833);
                return;
            }
            AppMethodBeat.o(239833);
            return;
        }
        AppMethodBeat.o(239833);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void eoM() {
        Resources resources;
        Resources resources2;
        AppMethodBeat.i(239834);
        super.eoM();
        j jVar = this.zTI;
        if (jVar != null) {
            View view = jVar.cBH;
            if (view != null) {
                Context context = jVar.context;
                Context context2 = jVar.context;
                view.setBackground(ar.m(context, R.drawable.b32, (context2 == null || (resources2 = context2.getResources()) == null) ? -1 : resources2.getColor(R.color.a1t)));
            }
            Context context3 = jVar.context;
            if (context3 == null || (resources = context3.getResources()) == null) {
                AppMethodBeat.o(239834);
                return;
            }
            int color = resources.getColor(R.color.FG_1);
            TextView textView = jVar.timeTv;
            if (textView != null) {
                textView.setTextColor(color);
                AppMethodBeat.o(239834);
                return;
            }
            AppMethodBeat.o(239834);
            return;
        }
        AppMethodBeat.o(239834);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void aGy(String str) {
        String str2;
        AppMethodBeat.i(239835);
        super.aGy(str);
        j jVar = this.zTI;
        if (jVar != null) {
            TextView textView = jVar.timeTv;
            if (textView != null) {
                textView.setTextSize(1, 14.0f);
            }
            TextView textView2 = jVar.timeTv;
            if (textView2 != null) {
                textView2.setText(str);
            }
            View view = jVar.lJI;
            StringBuilder sb = new StringBuilder();
            Context context = jVar.context;
            if (context != null) {
                str2 = context.getString(R.string.b3_);
            } else {
                str2 = null;
            }
            view.setContentDescription(sb.append(String.valueOf(str2)).append(",").append(str).toString());
            AppMethodBeat.o(239835);
            return;
        }
        AppMethodBeat.o(239835);
    }

    public final String getRendererSpeaker() {
        String str;
        i iVar = this.zTJ;
        return (iVar == null || (str = iVar.zTg) == null) ? "" : str;
    }

    public final Long getLastRenderSwitchTick() {
        i iVar = this.zTJ;
        if (iVar != null) {
            return iVar.zTi;
        }
        return null;
    }

    public final void aGA(String str) {
        AppMethodBeat.i(239837);
        Object[] objArr = new Object[1];
        Long lastRenderSwitchTick = getLastRenderSwitchTick();
        objArr[0] = Long.valueOf(Util.ticksToNow(lastRenderSwitchTick != null ? lastRenderSwitchTick.longValue() : 0));
        Log.printInfoStack("MicroMsg.MultiTalkSmallView", "changeRendererSpeaker %s", objArr);
        i iVar = this.zTJ;
        if (iVar != null) {
            iVar.aGs(str);
            AppMethodBeat.o(239837);
            return;
        }
        AppMethodBeat.o(239837);
    }

    public final void rV(boolean z) {
        View view;
        ViewGroup.LayoutParams layoutParams;
        View view2;
        AppMethodBeat.i(239838);
        j jVar = this.zTI;
        if (!(jVar == null || (view2 = jVar.contentView) == null || view2.getLayoutParams() == null)) {
            View view3 = jVar.contentView;
            ViewGroup.LayoutParams layoutParams2 = view3 != null ? view3.getLayoutParams() : null;
            if (layoutParams2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(239838);
                throw tVar;
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
            if (z) {
                layoutParams3.setMarginStart(at.fromDPToPix(jVar.context, 24));
                layoutParams3.setMarginEnd(at.fromDPToPix(jVar.context, 8));
            } else {
                layoutParams3.setMarginEnd(at.fromDPToPix(jVar.context, 24));
                layoutParams3.setMarginStart(at.fromDPToPix(jVar.context, 8));
            }
            View view4 = jVar.contentView;
            if (view4 != null) {
                view4.setLayoutParams(layoutParams3);
            }
        }
        i iVar = this.zTJ;
        if (!(iVar == null || (view = iVar.contentView) == null || view.getLayoutParams() == null)) {
            View view5 = iVar.contentView;
            if (view5 != null) {
                layoutParams = view5.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(239838);
                throw tVar2;
            }
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
            if (z) {
                layoutParams4.setMarginStart(at.fromDPToPix(iVar.context, 24));
                layoutParams4.setMarginEnd(at.fromDPToPix(iVar.context, 8));
            } else {
                layoutParams4.setMarginEnd(at.fromDPToPix(iVar.context, 24));
                layoutParams4.setMarginStart(at.fromDPToPix(iVar.context, 8));
            }
            View view6 = iVar.contentView;
            if (view6 != null) {
                view6.setLayoutParams(layoutParams4);
            }
        }
        h hVar = this.zTK;
        if (hVar != null) {
            ViewGroup.LayoutParams layoutParams5 = hVar.lJI.getLayoutParams();
            if (layoutParams5 == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(239838);
                throw tVar3;
            }
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
            if (z) {
                layoutParams6.removeRule(21);
                layoutParams6.addRule(20);
            } else {
                layoutParams6.removeRule(20);
                layoutParams6.addRule(21);
            }
            hVar.lJI.setLayoutParams(layoutParams6);
            AppMethodBeat.o(239838);
            return;
        }
        AppMethodBeat.o(239838);
    }

    public final void aGz(String str) {
        i iVar;
        AppMethodBeat.i(239836);
        p.h(str, "userName");
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        if (eom.enr().contains(str) || (iVar = this.zTJ) == null) {
            AppMethodBeat.o(239836);
            return;
        }
        iVar.aGv(str);
        AppMethodBeat.o(239836);
    }
}
