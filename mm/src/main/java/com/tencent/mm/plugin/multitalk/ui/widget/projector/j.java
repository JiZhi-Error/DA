package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 O2\u00020\u0001:\u0001OB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0014J\u0010\u00100\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u000102J\u0010\u00103\u001a\u0002042\u0006\u00101\u001a\u000202H\u0002J\u000e\u00105\u001a\u00020.2\u0006\u00106\u001a\u000204J\b\u00107\u001a\u00020.H\u0016J(\u00108\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0014H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\r\u0010?\u001a\u0004\u0018\u00010@¢\u0006\u0002\u0010AJ\u0006\u0010B\u001a\u000202J\u000e\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020$J\b\u0010E\u001a\u000202H\u0016J\u0006\u0010F\u001a\u000204J\u001e\u0010G\u001a\u0002042\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u0002020Ij\b\u0012\u0004\u0012\u000202`JJ\u0006\u0010K\u001a\u00020.J\u0006\u0010L\u001a\u00020.J\u000e\u0010M\u001a\u00020.2\u0006\u00101\u001a\u000202J\u000e\u0010N\u001a\u00020.2\u0006\u00106\u001a\u000204R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006P"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "getAvatarManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "setAvatarManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;)V", "avatarRootLayout", "Landroid/view/View;", "getAvatarRootLayout", "()Landroid/view/View;", "setAvatarRootLayout", "(Landroid/view/View;)V", "beforeOrientation", "", "getBeforeOrientation", "()I", "setBeforeOrientation", "(I)V", "cellContent", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "getCellContent", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "setCellContent", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mRootView", "Landroid/view/ViewGroup;", "getMRootView", "()Landroid/view/ViewGroup;", "setMRootView", "(Landroid/view/ViewGroup;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "applyOrientation", "", "orientation", "changeRendererSpeaker", "userName", "", "checkIfReceivingVideo", "", "doShowOrHideAvatarView", "show", "drawAvatar", "drawBitmap", "bm", "Landroid/graphics/Bitmap;", "angle", "mirror", "getAvatarIv", "Landroid/widget/ImageView;", "getLastRenderSwitchTick", "", "()Ljava/lang/Long;", "getRendererSpeaker", "getScreenProjectAvatarContent", "rootView", "getUsername", "isShown", "refreshAvatar", "speakers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "release", "resetLayoutCauseDoodle", "showSpeakerAvatar", "showSpeakerVoice", "Companion", "plugin-multitalk_release"})
public final class j implements f {
    public static final a zWG = new a((byte) 0);
    private Context context;
    public ViewGroup nmW;
    private a zQD;
    private View zWC;
    private h zWD;
    public i zWE = new i(this, this.zQD);
    private int zWF = -1;

    static {
        AppMethodBeat.i(240007);
        AppMethodBeat.o(240007);
    }

    public j(Context context2, a aVar) {
        p.h(context2, "context");
        p.h(aVar, "statusManager");
        AppMethodBeat.i(240006);
        this.context = context2;
        this.zQD = aVar;
        AppMethodBeat.o(240006);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void A(ViewGroup viewGroup) {
        AppMethodBeat.i(239996);
        p.h(viewGroup, "rootView");
        this.nmW = viewGroup;
        this.zWC = View.inflate(this.context, R.layout.bcx, viewGroup);
        View view = this.zWC;
        RelativeLayout relativeLayout = view != null ? (RelativeLayout) view.findViewById(R.id.wv) : null;
        if (relativeLayout == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(239996);
            throw tVar;
        }
        this.zWD = new h(relativeLayout, this.zQD);
        AppMethodBeat.o(239996);
    }

    public final void RA(int i2) {
        AppMethodBeat.i(239997);
        if (this.zWF != i2) {
            this.zWF = i2;
            h hVar = this.zWD;
            if (hVar != null) {
                hVar.RA(i2);
                AppMethodBeat.o(239997);
                return;
            }
        }
        AppMethodBeat.o(239997);
    }

    public final void sf(boolean z) {
        h hVar;
        Integer num = null;
        AppMethodBeat.i(239998);
        if (z) {
            h hVar2 = this.zWD;
            if (hVar2 != null) {
                num = hVar2.eoH();
            }
            if (num == null || num.intValue() != 0) {
                h hVar3 = this.zWD;
                if (hVar3 != null) {
                    hVar3.epx();
                    AppMethodBeat.o(239998);
                    return;
                }
                AppMethodBeat.o(239998);
                return;
            }
        } else {
            h hVar4 = this.zWD;
            if (hVar4 != null) {
                num = hVar4.eoH();
            }
            if ((num == null || num.intValue() != 4) && (hVar = this.zWD) != null) {
                hVar.epy();
                AppMethodBeat.o(239998);
                return;
            }
        }
        AppMethodBeat.o(239998);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.f
    public final void a(String str, Bitmap bitmap, int i2, int i3) {
        String str2;
        h hVar;
        String str3 = null;
        AppMethodBeat.i(239999);
        p.h(str, "userName");
        p.h(bitmap, "bm");
        h hVar2 = this.zWD;
        if (hVar2 != null) {
            str2 = hVar2.zTg;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            h hVar3 = this.zWD;
            if (hVar3 != null) {
                str3 = hVar3.zTg;
            }
            if (p.j(str, str3)) {
                q eom = ac.eom();
                p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                if (eom.enw().aGj(str) == 100 && (hVar = this.zWD) != null) {
                    hVar.b(str, bitmap, i3, i2);
                    AppMethodBeat.o(239999);
                    return;
                }
            }
        }
        AppMethodBeat.o(239999);
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
        h hVar = this.zWD;
        return (hVar == null || (str = hVar.zTg) == null) ? "" : str;
    }

    public final void sg(boolean z) {
        h hVar;
        AppMethodBeat.i(240000);
        h hVar2 = this.zWD;
        Integer eoH = hVar2 != null ? hVar2.eoH() : null;
        if (eoH == null) {
            AppMethodBeat.o(240000);
            return;
        }
        if (eoH.intValue() == 0) {
            if ((!n.aL(getRendererSpeaker())) && (hVar = this.zWD) != null) {
                hVar.se(z);
                AppMethodBeat.o(240000);
                return;
            }
        }
        AppMethodBeat.o(240000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
        if (r0.enw().aGj(r4) == 103) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        if (kotlin.g.b.p.j(com.tencent.mm.model.z.aTY(), r4) != false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        r0 = r3.zWD;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        if (r0 == null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        r0.aGv(r4);
        com.tencent.matrix.trace.core.AppMethodBeat.o(240001);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aGz(java.lang.String r4) {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.projector.j.aGz(java.lang.String):void");
    }

    private static boolean aGD(String str) {
        AppMethodBeat.i(240002);
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean contains = eom.enr().contains(str);
        AppMethodBeat.o(240002);
        return contains;
    }

    public final String getRendererSpeaker() {
        String str;
        h hVar = this.zWD;
        return (hVar == null || (str = hVar.zTg) == null) ? "" : str;
    }

    public final Long getLastRenderSwitchTick() {
        h hVar = this.zWD;
        if (hVar != null) {
            return hVar.zTi;
        }
        return null;
    }

    public final void aGA(String str) {
        AppMethodBeat.i(240003);
        h hVar = this.zWD;
        if (hVar != null) {
            hVar.aGs(str);
            AppMethodBeat.o(240003);
            return;
        }
        AppMethodBeat.o(240003);
    }

    public final void epz() {
        AppMethodBeat.i(240004);
        h hVar = this.zWD;
        if (hVar != null) {
            hVar.epz();
            AppMethodBeat.o(240004);
            return;
        }
        AppMethodBeat.o(240004);
    }

    public final boolean aD(ArrayList<String> arrayList) {
        String rendererSpeaker;
        AppMethodBeat.i(240005);
        p.h(arrayList, "speakers");
        i iVar = this.zWE;
        p.h(arrayList, "speakers");
        Long lastRenderSwitchTick = iVar.zWA.getLastRenderSwitchTick();
        if (lastRenderSwitchTick == null) {
            rendererSpeaker = i.fC(arrayList);
        } else if (Util.ticksToNow(lastRenderSwitchTick.longValue()) < 3000 || arrayList.contains(iVar.zWA.getRendererSpeaker())) {
            rendererSpeaker = iVar.zWA.getRendererSpeaker();
        } else {
            rendererSpeaker = i.fC(arrayList);
        }
        iVar.zWA.aGA(rendererSpeaker);
        iVar.zWA.sf(true);
        AppMethodBeat.o(240005);
        return true;
    }
}
