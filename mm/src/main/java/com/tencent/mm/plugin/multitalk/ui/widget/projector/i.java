package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.g;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.q;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.List;
import kotlin.g.b.p;
import kotlin.j.c;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 02\u00020\u0001:\u00010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020%H\u0016J\u0006\u0010&\u001a\u00020%J\b\u0010'\u001a\u00020\u0017H\u0002J\u0016\u0010(\u001a\u00020\u00172\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170*H\u0002J\u001e\u0010+\u001a\u00020\u00192\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00170-j\b\u0012\u0004\u0012\u00020\u0017`.J\u0006\u0010/\u001a\u00020%R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "contentView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarChecker", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "getAvatarChecker", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "setAvatarChecker", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;)V", "getContentView", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "setContentView", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "waitingRenderList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "checkRenderUserTalking", "", "userName", "checkSpeakerHasVideo", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "", "getNormalRenderTarget", "wxUserName", "getRandomNum", "maxSize", "onScreenFrame", "", "onTimeSecondCallback", "randomPeakUser", "randomPeakUserWhileTalking", "list", "", "refreshAvatar", "speakers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "release", "Companion", "plugin-multitalk_release"})
public final class i implements g {
    public static final a zWB = new a((byte) 0);
    private a zQD;
    j zWA;
    private q zWz = new q(this.zQD);

    static {
        AppMethodBeat.i(239995);
        AppMethodBeat.o(239995);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public i(j jVar, a aVar) {
        p.h(jVar, "contentView");
        p.h(aVar, "statusManager");
        AppMethodBeat.i(239994);
        this.zWA = jVar;
        this.zQD = aVar;
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        eom.enz().a(this);
        q qVar = this.zWz;
        if (qVar != null) {
            MTimerHandler mTimerHandler = qVar.zMk;
            if (mTimerHandler != null) {
                mTimerHandler.stopTimer();
            }
            MTimerHandler mTimerHandler2 = qVar.zMk;
            if (mTimerHandler2 != null) {
                mTimerHandler2.quitSafely();
            }
            MTimerHandler mTimerHandler3 = qVar.zMk;
            if (mTimerHandler3 != null) {
                mTimerHandler3.removeCallbacksAndMessages(null);
            }
            qVar.zMk = new MTimerHandler(new q.a(qVar), true);
            MTimerHandler mTimerHandler4 = qVar.zMk;
            if (mTimerHandler4 != null) {
                mTimerHandler4.startTimer(20);
                AppMethodBeat.o(239994);
                return;
            }
            AppMethodBeat.o(239994);
            return;
        }
        AppMethodBeat.o(239994);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eaa() {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.projector.i.eaa():void");
    }

    static String fC(List<String> list) {
        AppMethodBeat.i(239991);
        String str = list.get(j.a(j.mY(0, list.size()), c.SYP));
        AppMethodBeat.o(239991);
        return str;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.g
    public final f Rc(int i2) {
        return null;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.g
    public final f aFB(String str) {
        AppMethodBeat.i(239992);
        p.h(str, "wxUserName");
        j jVar = this.zWA;
        j jVar2 = TextUtils.isEmpty(jVar.getUsername()) || p.j(jVar.getUsername(), str) ? jVar : null;
        AppMethodBeat.o(239992);
        return jVar2;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.g
    public final void emc() {
    }

    public final void release() {
        AppMethodBeat.i(239993);
        q qVar = this.zWz;
        if (qVar != null) {
            MTimerHandler mTimerHandler = qVar.zMk;
            if (mTimerHandler != null) {
                mTimerHandler.removeCallbacksAndMessages(null);
            }
            MTimerHandler mTimerHandler2 = qVar.zMk;
            if (mTimerHandler2 != null) {
                mTimerHandler2.stopTimer();
            }
            MTimerHandler mTimerHandler3 = qVar.zMk;
            if (mTimerHandler3 != null) {
                mTimerHandler3.quitSafely();
            }
        }
        com.tencent.mm.plugin.multitalk.model.q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        eom.enz().b(this);
        AppMethodBeat.o(239993);
    }
}
