package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0018\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\nJ\u001c\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001f\u001a\u00020\nH\u0002J\u0010\u0010 \u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010%\u001a\u00020\u0015J\u0006\u0010&\u001a\u00020\u0015J\u0006\u0010'\u001a\u00020\u0015J\u0006\u0010(\u001a\u00020\u0015J\u0012\u0010)\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0002J\u000e\u0010*\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nJ\b\u0010+\u001a\u00020\u0015H\u0002J\u001a\u0010,\u001a\u00020\u00152\b\b\u0002\u0010-\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "", "()V", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "currentSessionId", "", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "Companion", "plugin-vlog_release"})
public final class a {
    public static final C1880a GOm = new C1880a((byte) 0);
    private boolean FHg;
    private String FHh;
    private boolean FHi;
    public boolean FHk;
    private b FHl = new b(MMApplicationContext.getContext());
    private boolean FHm;
    public VLogFakeVideoView GOk;
    private c GOl;
    public boolean guh;

    static {
        AppMethodBeat.i(111196);
        AppMethodBeat.o(111196);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.preview.a$a  reason: collision with other inner class name */
    public static final class C1880a {
        private C1880a() {
        }

        public /* synthetic */ C1880a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(111195);
        AppMethodBeat.o(111195);
    }

    public final void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        Integer num;
        VLogFakeVideoView vLogFakeVideoView;
        AppMethodBeat.i(111184);
        p.h(viewGroup, "parent");
        boolean I = I(viewGroup);
        StringBuilder append = new StringBuilder("attachVideoView, parent:").append(viewGroup.hashCode()).append(", isVideoPause:").append(this.FHg).append(", currentSessionId:").append(this.FHh).append(", isPlayingVideoItem:").append(this.FHi).append(" videoView ");
        VLogFakeVideoView vLogFakeVideoView2 = this.GOk;
        if (vLogFakeVideoView2 != null) {
            num = Integer.valueOf(vLogFakeVideoView2.hashCode());
        } else {
            num = null;
        }
        Log.i("MicroMsg.VLogFakeVideoViewMgr", append.append(num).append(" sameParent ").append(I).append(" this:").append(hashCode()).toString());
        H(viewGroup);
        if (this.GOk == null) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            hm(context);
        }
        if (!I) {
            Log.i("MicroMsg.VLogFakeVideoViewMgr", "addView layoutParams:".concat(String.valueOf(layoutParams)));
            if (layoutParams == null) {
                viewGroup.addView(this.GOk);
            } else {
                viewGroup.addView(this.GOk, layoutParams);
            }
        } else if (!(layoutParams == null || (vLogFakeVideoView = this.GOk) == null)) {
            vLogFakeVideoView.setLayoutParams(layoutParams);
        }
        VLogFakeVideoView vLogFakeVideoView3 = this.GOk;
        if (vLogFakeVideoView3 != null) {
            vLogFakeVideoView3.setAlpha(0.0f);
            AppMethodBeat.o(111184);
            return;
        }
        AppMethodBeat.o(111184);
    }

    public final void a(c cVar, boolean z) {
        AppMethodBeat.i(111185);
        if (cVar == null) {
            AppMethodBeat.o(111185);
            return;
        }
        boolean z2 = !e(cVar);
        Log.i("MicroMsg.VLogFakeVideoViewMgr", "change:" + z2 + ' ' + this.FHk + ", " + z + ", changeVideoItem: origin: " + this.GOl + ", new: " + cVar + ",  change:" + z2 + " this:" + hashCode());
        if (z2) {
            this.GOl = cVar;
            if (this.FHk || z) {
                wb(false);
                PF();
            }
        }
        AppMethodBeat.o(111185);
    }

    private final void H(ViewGroup viewGroup) {
        int i2;
        ViewParent viewParent;
        ViewParent viewParent2;
        AppMethodBeat.i(111186);
        StringBuilder sb = new StringBuilder("checkDetachVideoView, videoView:");
        VLogFakeVideoView vLogFakeVideoView = this.GOk;
        if (vLogFakeVideoView != null) {
            i2 = vLogFakeVideoView.hashCode();
        } else {
            i2 = 0;
        }
        StringBuilder append = sb.append(i2).append(", isPlay:");
        VLogFakeVideoView vLogFakeVideoView2 = this.GOk;
        StringBuilder append2 = append.append(vLogFakeVideoView2 != null ? vLogFakeVideoView2.isPlaying() : false).append(", parent:");
        VLogFakeVideoView vLogFakeVideoView3 = this.GOk;
        ViewParent parent = vLogFakeVideoView3 != null ? vLogFakeVideoView3.getParent() : null;
        Log.i("MicroMsg.VLogFakeVideoViewMgr", append2.append(parent != null ? parent.hashCode() : 0).append(", newParent:").append(viewGroup != null ? viewGroup.hashCode() : 0).append(", isPlayingVideoItem:").append(this.FHi).toString());
        VLogFakeVideoView vLogFakeVideoView4 = this.GOk;
        if (vLogFakeVideoView4 != null) {
            viewParent = vLogFakeVideoView4.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null && !I(viewGroup)) {
            wb(false);
            VLogFakeVideoView vLogFakeVideoView5 = this.GOk;
            if (vLogFakeVideoView5 != null) {
                viewParent2 = vLogFakeVideoView5.getParent();
            } else {
                viewParent2 = null;
            }
            if (viewParent2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(111186);
                throw tVar;
            }
            ((ViewGroup) viewParent2).removeView(this.GOk);
            this.GOl = null;
        }
        AppMethodBeat.o(111186);
    }

    private final boolean I(ViewGroup viewGroup) {
        AppMethodBeat.i(111187);
        VLogFakeVideoView vLogFakeVideoView = this.GOk;
        boolean j2 = p.j(vLogFakeVideoView != null ? vLogFakeVideoView.getParent() : null, viewGroup);
        AppMethodBeat.o(111187);
        return j2;
    }

    private final boolean e(c cVar) {
        c cVar2;
        if (cVar == null || cVar.systemRowid == 0 || (cVar2 = this.GOl) == null || cVar2.systemRowid != cVar.systemRowid) {
            return false;
        }
        return true;
    }

    private final void hm(Context context) {
        AppMethodBeat.i(111188);
        Log.i("MicroMsg.VLogFakeVideoViewMgr", "initCreateVideoView");
        this.GOk = new VLogFakeVideoView(context, null, 2);
        this.FHi = false;
        AppMethodBeat.o(111188);
    }

    public final void wb(boolean z) {
        AppMethodBeat.i(111189);
        Log.i("MicroMsg.VLogFakeVideoViewMgr", "stopVideo, detach: ".concat(String.valueOf(z)));
        VLogFakeVideoView vLogFakeVideoView = this.GOk;
        if (vLogFakeVideoView != null) {
            vLogFakeVideoView.setAlpha(0.0f);
        }
        if (this.FHi) {
            this.FHh = null;
            VLogFakeVideoView vLogFakeVideoView2 = this.GOk;
            if (vLogFakeVideoView2 != null) {
                vLogFakeVideoView2.stop();
            }
            this.FHg = false;
            if (this.FHm) {
                this.FHl.apm();
                this.FHm = false;
            }
            this.FHi = false;
        }
        if (z) {
            this.FHk = false;
            H(null);
        }
        AppMethodBeat.o(111189);
    }

    public final void PF() {
        AppMethodBeat.i(111190);
        Log.printInfoStack("MicroMsg.VLogFakeVideoViewMgr", "playVideo, " + this.FHg + ' ' + this.FHk + ", " + this.GOl, new Object[0]);
        fst();
        this.FHk = true;
        if (this.GOl != null) {
            boolean z = this.FHg;
            this.FHg = false;
            if (z) {
                VLogFakeVideoView vLogFakeVideoView = this.GOk;
                if (vLogFakeVideoView != null) {
                    vLogFakeVideoView.setAlpha(1.0f);
                }
                VLogFakeVideoView vLogFakeVideoView2 = this.GOk;
                if (vLogFakeVideoView2 != null) {
                    vLogFakeVideoView2.b(this.GOl);
                }
            } else {
                this.FHh = UUID.randomUUID().toString();
                VLogFakeVideoView vLogFakeVideoView3 = this.GOk;
                if (vLogFakeVideoView3 != null) {
                    c cVar = this.GOl;
                    if (cVar == null) {
                        cVar = new c();
                    }
                    vLogFakeVideoView3.a(cVar);
                }
                VLogFakeVideoView vLogFakeVideoView4 = this.GOk;
                if (vLogFakeVideoView4 != null) {
                    vLogFakeVideoView4.setAlpha(0.0f);
                }
            }
            this.FHg = false;
            this.FHi = true;
            if (!this.FHm) {
                this.FHl.requestFocus();
                this.FHm = true;
            }
        }
        AppMethodBeat.o(111190);
    }

    private final void fst() {
        AppMethodBeat.i(111191);
        Log.i("MicroMsg.VLogFakeVideoViewMgr", "setVideoViewProp, isMute:" + this.guh);
        VLogFakeVideoView vLogFakeVideoView = this.GOk;
        if (vLogFakeVideoView != null) {
            vLogFakeVideoView.setMute(this.guh);
            AppMethodBeat.o(111191);
            return;
        }
        AppMethodBeat.o(111191);
    }

    public final void onUIResume() {
        AppMethodBeat.i(111192);
        Log.i("MicroMsg.VLogFakeVideoViewMgr", "onUIResume " + hashCode());
        if (this.FHk) {
            VLogFakeVideoView vLogFakeVideoView = this.GOk;
            if (vLogFakeVideoView != null) {
                vLogFakeVideoView.onUIResume();
            }
            if (!this.FHm) {
                this.FHl.requestFocus();
                this.FHm = true;
            }
        }
        AppMethodBeat.o(111192);
    }

    public final void onUIPause() {
        AppMethodBeat.i(111193);
        Log.i("MicroMsg.VLogFakeVideoViewMgr", "onUIPause " + hashCode());
        H(null);
        if (this.FHm) {
            this.FHl.apm();
            this.FHm = false;
        }
        AppMethodBeat.o(111193);
    }

    public final void onUIDestroy() {
        AppMethodBeat.i(111194);
        Log.i("MicroMsg.VLogFakeVideoViewMgr", "onUIDestroy " + hashCode());
        this.FHk = false;
        H(null);
        this.GOl = null;
        this.GOk = null;
        if (this.FHm) {
            this.FHl.apm();
            this.FHm = false;
        }
        AppMethodBeat.o(111194);
    }
}
