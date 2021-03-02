package com.tencent.mm.plugin.multitalk.ui.widget.projector.a;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.j;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0010J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0006\u0010$\u001a\u00020\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/receiver/ReceiverAvatarCellIconManager;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "isAvatarLayoutOn", "", "()Z", "setAvatarLayoutOn", "(Z)V", "mAvatarUi", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "mCurrentOrientation", "", "checkCallerState", "checkCurrentInAvatarLayout", "checkCurrentInDoodleLayout", "checkCurrentOrientation", "getCurrentStatus", "hideAvatar", "", "rootView", "Landroid/view/ViewGroup;", "onTimeTick", "release", "setOrientation", "orientation", "showAvatar", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "Landroid/os/Bundle;", "unInitLayout", "plugin-multitalk_release"})
public final class a implements com.tencent.mm.plugin.multitalk.ui.widget.projector.a {
    private Context context;
    private int mCurrentOrientation = -1;
    private boolean zXk;
    public j zYA = new j(this.context, this);

    public a(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(240067);
        this.context = context2;
        AppMethodBeat.o(240067);
    }

    public final void setOrientation(int i2) {
        AppMethodBeat.i(240065);
        this.mCurrentOrientation = i2;
        j jVar = this.zYA;
        if (jVar != null) {
            jVar.RA(i2);
            AppMethodBeat.o(240065);
            return;
        }
        AppMethodBeat.o(240065);
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public final void a(a.c cVar, Bundle bundle) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(240066);
        p.h(cVar, "status");
        switch (b.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                q eom = ac.eom();
                p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                if (eom.enA().emb()) {
                    j jVar = this.zYA;
                    if (jVar != null) {
                        ViewGroup viewGroup = jVar.nmW;
                        if (viewGroup == null || viewGroup.getVisibility() != 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            if (bundle != null) {
                                ArrayList<String> stringArrayList = bundle.getStringArrayList("avatar_available_speaker");
                                j jVar2 = this.zYA;
                                if (jVar2 != null) {
                                    if (stringArrayList == null) {
                                        p.hyc();
                                    }
                                    z2 = jVar2.aD(stringArrayList);
                                }
                                this.zXk = z2;
                                AppMethodBeat.o(240066);
                                return;
                            }
                            AppMethodBeat.o(240066);
                            return;
                        }
                    } else {
                        AppMethodBeat.o(240066);
                        return;
                    }
                }
                break;
            case 2:
                this.zXk = false;
                break;
        }
        AppMethodBeat.o(240066);
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public final boolean getCurrentStatus() {
        return false;
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public final boolean epg() {
        return false;
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public final boolean eph() {
        return this.zXk;
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public final int epf() {
        return this.mCurrentOrientation;
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public final int epi() {
        return 0;
    }
}
