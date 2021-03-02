package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0004¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "mCurrentSpeakerList", "Ljava/util/HashMap;", "", "", "getMCurrentSpeakerList", "()Ljava/util/HashMap;", "setMCurrentSpeakerList", "(Ljava/util/HashMap;)V", "remoteSpeakerSpeakerMuteChecker", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "checkHistorySpeakerList", "", "checkRemoteSpeakerIsSpeaking", "", "startProjectorSpeakerChecker", "stopProjectorSpeakerChecker", "plugin-multitalk_release"})
public final class q {
    MTimerHandler zMk;
    private volatile HashMap<String, Integer> zMl = new HashMap<>();
    private a zQD;

    public q(a aVar) {
        p.h(aVar, "statusManager");
        AppMethodBeat.i(240059);
        this.zQD = aVar;
        AppMethodBeat.o(240059);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    public static final class a implements MTimerHandler.CallBack {
        final /* synthetic */ q zYb;

        a(q qVar) {
            this.zYb = qVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(240057);
            this.zYb.epJ();
            AppMethodBeat.o(240057);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void epJ() {
        AppMethodBeat.i(240058);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Integer> entry : this.zMl.entrySet()) {
            arrayList.add(entry.getKey());
        }
        ArrayList<String> arrayList2 = arrayList;
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        com.tencent.mm.plugin.multitalk.model.q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        List<String> elR = eom.elR();
        if (elR != null) {
            for (String str : elR) {
                if (!arrayList2.contains(str)) {
                    p.g(str, "tempSpeaker");
                    hashMap.put(str, 0);
                }
            }
            boolean z = false;
            for (String str2 : arrayList2) {
                if (elR.contains(str2)) {
                    Integer num = this.zMl.get(str2);
                    Integer num2 = num == null ? 0 : num;
                    if (num2.intValue() > 30) {
                        arrayList3.add(str2);
                        z = true;
                    } else {
                        hashMap.put(str2, Integer.valueOf(num2.intValue() + 1));
                    }
                } else if (this.zMl.get(str2) != null) {
                    hashMap.put(str2, 0);
                }
            }
            this.zMl = hashMap;
            if (z && !this.zQD.eph()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("avatar_available_speaker", arrayList3);
                this.zQD.a(a.c.AVATAR_READY, bundle);
            }
            AppMethodBeat.o(240058);
        } else {
            AppMethodBeat.o(240058);
        }
    }
}
