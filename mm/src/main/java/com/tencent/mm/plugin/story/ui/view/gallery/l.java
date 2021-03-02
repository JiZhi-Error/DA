package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.f;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.f.e.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u000bJ\u001c\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010 \u001a\u00020\u000bH\u0002J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\bJ\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0016J\u0006\u0010(\u001a\u00020\u0016J\u0006\u0010)\u001a\u00020\u0016J\u0012\u0010*\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0002J\u000e\u0010+\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010,\u001a\u00020\u0016H\u0002J\u001a\u0010-\u001a\u00020\u00162\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "", "()V", "TAG", "", "audioFocos", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "currVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "currentSessionId", "isMute", "", "isPlayingVideoItem", "isRequestAudioFocus", "isVideoPause", "isVideoPlaying", "()Z", "setVideoPlaying", "(Z)V", "videoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "attachVideoView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "changeVideoItem", "item", "playing", "checkDetachVideoView", "newParent", "enableReport", "getPlayStatus", "initCreateVideoView", "context", "Landroid/content/Context;", "isVideoNotChangeItem", "onUIDestroy", "onUIPause", "onUIResume", "playVideo", "sameParent", "setMute", "setVideoViewProp", "stopVideo", "detach", "plugin-story_release"})
public final class l {
    f FHf;
    private boolean FHg;
    private String FHh;
    private boolean FHi;
    private j FHj;
    boolean FHk;
    private b FHl = new b(MMApplicationContext.getContext());
    private boolean FHm;
    final String TAG = "MicroMsg.Gallery.StoryImageVideoViewMgr";
    boolean guh;

    public l() {
        AppMethodBeat.i(120526);
        AppMethodBeat.o(120526);
    }

    public final void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        Integer num;
        f fVar;
        AppMethodBeat.i(120514);
        p.h(viewGroup, "parent");
        boolean I = I(viewGroup);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("attachVideoView, parent:").append(viewGroup.hashCode()).append(", isVideoPause:").append(this.FHg).append(", currentSessionId:").append(this.FHh).append(", isPlayingVideoItem:").append(this.FHi).append(" videoView ");
        f fVar2 = this.FHf;
        if (fVar2 != null) {
            num = Integer.valueOf(fVar2.hashCode());
        } else {
            num = null;
        }
        Log.i(str, append.append(num).append(" sameParent ").append(I).append(" this:").append(hashCode()).toString());
        H(viewGroup);
        if (this.FHf == null) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            hm(context);
        }
        if (!I) {
            if (layoutParams == null) {
                viewGroup.addView(this.FHf);
            } else {
                viewGroup.addView(this.FHf, layoutParams);
            }
        } else if (!(layoutParams == null || (fVar = this.FHf) == null)) {
            fVar.setLayoutParams(layoutParams);
        }
        f fVar3 = this.FHf;
        if (fVar3 != null) {
            fVar3.setAlpha(0.0f);
            AppMethodBeat.o(120514);
            return;
        }
        AppMethodBeat.o(120514);
    }

    public final void a(j jVar, boolean z) {
        AppMethodBeat.i(120515);
        p.h(jVar, "item");
        boolean z2 = !g(jVar);
        Log.i(this.TAG, "change:" + z2 + ' ' + this.FHk + ", " + z + ", changeVideoItem: origin: " + this.FHj + ", new: " + jVar + ",  change:" + z2 + " this:" + hashCode());
        if (z2) {
            this.FHj = jVar;
            if (this.FHk || z) {
                wb(false);
                PF();
            }
        }
        AppMethodBeat.o(120515);
    }

    private final void H(ViewGroup viewGroup) {
        int i2;
        ViewParent viewParent;
        ViewParent viewParent2;
        AppMethodBeat.i(120516);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("checkDetachVideoView, videoView:");
        f fVar = this.FHf;
        if (fVar != null) {
            i2 = fVar.hashCode();
        } else {
            i2 = 0;
        }
        StringBuilder append = sb.append(i2).append(", isPlay:");
        f fVar2 = this.FHf;
        StringBuilder append2 = append.append(fVar2 != null ? fVar2.isPlaying() : false).append(", parent:");
        f fVar3 = this.FHf;
        ViewParent parent = fVar3 != null ? fVar3.getParent() : null;
        Log.i(str, append2.append(parent != null ? parent.hashCode() : 0).append(", newParent:").append(viewGroup != null ? viewGroup.hashCode() : 0).append(", isPlayingVideoItem:").append(this.FHi).toString());
        f fVar4 = this.FHf;
        if (fVar4 != null) {
            viewParent = fVar4.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null && !I(viewGroup)) {
            wb(false);
            f fVar5 = this.FHf;
            if (fVar5 != null) {
                viewParent2 = fVar5.getParent();
            } else {
                viewParent2 = null;
            }
            if (viewParent2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(120516);
                throw tVar;
            }
            ((ViewGroup) viewParent2).removeView(this.FHf);
            this.FHj = null;
        }
        AppMethodBeat.o(120516);
    }

    private final boolean I(ViewGroup viewGroup) {
        AppMethodBeat.i(120517);
        f fVar = this.FHf;
        boolean j2 = p.j(fVar != null ? fVar.getParent() : null, viewGroup);
        AppMethodBeat.o(120517);
        return j2;
    }

    private final void hm(Context context) {
        AppMethodBeat.i(120519);
        a aVar = a.Fpl;
        this.FHf = a.hl(context);
        this.FHi = false;
        AppMethodBeat.o(120519);
    }

    public final void wb(boolean z) {
        AppMethodBeat.i(120520);
        Log.i(this.TAG, "stopVideo, detach: ".concat(String.valueOf(z)));
        if (this.FHi) {
            this.FHh = null;
            f fVar = this.FHf;
            if (fVar != null) {
                fVar.stop();
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
        AppMethodBeat.o(120520);
    }

    public final void PF() {
        AppMethodBeat.i(120521);
        Log.printInfoStack(this.TAG, "playVideo, " + this.FHg + ' ' + this.FHk + ", " + this.FHj, new Object[0]);
        fst();
        this.FHk = true;
        j jVar = this.FHj;
        if (jVar != null) {
            boolean z = this.FHg;
            this.FHg = false;
            if (z) {
                f fVar = this.FHf;
                if (fVar != null) {
                    fVar.setAlpha(1.0f);
                }
                f fVar2 = this.FHf;
                if (fVar2 != null) {
                    fVar2.b(jVar.Fpe);
                }
            } else {
                this.FHh = UUID.randomUUID().toString();
                f fVar3 = this.FHf;
                if (fVar3 != null) {
                    c cVar = jVar.Fpe;
                    if (cVar == null) {
                        cVar = new c();
                    }
                    fVar3.a(cVar);
                }
            }
            this.FHg = false;
            if (jVar.foW()) {
                this.FHi = true;
            }
            if (!this.FHm) {
                this.FHl.requestFocus();
                this.FHm = true;
            }
        }
        h hVar = h.FuH;
        jo fqi = h.fqi();
        f fVar4 = this.FHf;
        fqi.sk((long) NetStatusUtil.getIOSNetType(fVar4 != null ? fVar4.getContext() : null));
        AppMethodBeat.o(120521);
    }

    private final void fst() {
        AppMethodBeat.i(120522);
        Log.i(this.TAG, "setVideoViewProp, isMute:" + this.guh);
        f fVar = this.FHf;
        if (fVar != null) {
            fVar.setMute(this.guh);
            AppMethodBeat.o(120522);
            return;
        }
        AppMethodBeat.o(120522);
    }

    public final void onUIResume() {
        AppMethodBeat.i(120523);
        Log.i(this.TAG, "onUIResume " + hashCode());
        if (this.FHk) {
            f fVar = this.FHf;
            if (fVar != null) {
                fVar.onUIResume();
            }
            if (!this.FHm) {
                this.FHl.requestFocus();
                this.FHm = true;
            }
        }
        AppMethodBeat.o(120523);
    }

    public final void onUIPause() {
        AppMethodBeat.i(120524);
        Log.i(this.TAG, "onUIPause " + hashCode());
        H(null);
        if (this.FHm) {
            this.FHl.apm();
            this.FHm = false;
        }
        AppMethodBeat.o(120524);
    }

    public final void onUIDestroy() {
        AppMethodBeat.i(120525);
        Log.i(this.TAG, "onUIDestroy " + hashCode());
        this.FHk = false;
        H(null);
        this.FHj = null;
        this.FHf = null;
        if (this.FHm) {
            this.FHl.apm();
            this.FHm = false;
        }
        AppMethodBeat.o(120525);
    }

    private final boolean g(j jVar) {
        boolean z;
        String str;
        edt edt;
        j jVar2;
        AppMethodBeat.i(120518);
        if (jVar.ecf == 0 || (jVar2 = this.FHj) == null || jVar2.ecf != jVar.ecf) {
            String str2 = jVar.Fpd.Url;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                j jVar3 = this.FHj;
                if (jVar3 == null || (edt = jVar3.Fpd) == null) {
                    str = null;
                } else {
                    str = edt.Url;
                }
                if (p.j(str, jVar.Fpd.Url)) {
                    AppMethodBeat.o(120518);
                    return true;
                }
            }
            AppMethodBeat.o(120518);
            return false;
        }
        AppMethodBeat.o(120518);
        return true;
    }
}
