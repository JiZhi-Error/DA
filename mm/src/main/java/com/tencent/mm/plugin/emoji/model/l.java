package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aao;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class l {
    Set<String> rcd;
    Set<String> rce;
    Set<String> rcf;
    IListener rcg = new IListener<aao>() {
        /* class com.tencent.mm.plugin.emoji.model.l.AnonymousClass1 */

        {
            AppMethodBeat.i(161082);
            this.__eventId = aao.class.getName().hashCode();
            AppMethodBeat.o(161082);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aao aao) {
            AppMethodBeat.i(108655);
            aao aao2 = aao;
            switch (aao2.ehA.dDe) {
                case 1:
                    l.this.rcd.addAll(Util.stringsToList(aao2.ehA.ehB));
                    l.this.rce.addAll(l.this.rcd);
                    l.this.cGl();
                    break;
            }
            AppMethodBeat.o(108655);
            return false;
        }
    };
    IListener rch = new IListener<dm>() {
        /* class com.tencent.mm.plugin.emoji.model.l.AnonymousClass2 */

        {
            AppMethodBeat.i(161083);
            this.__eventId = dm.class.getName().hashCode();
            AppMethodBeat.o(161083);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dm dmVar) {
            AppMethodBeat.i(108656);
            dm dmVar2 = dmVar;
            if (l.this.rcd.contains(dmVar2.dGw.md5)) {
                l.this.rcf.remove(dmVar2.dGw.md5);
                if (dmVar2.dGw.success) {
                    Log.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s success", dmVar2.dGw.md5);
                    k.getEmojiStorageMgr().OpO.blc(dmVar2.dGw.md5);
                    g.aAg().hqi.a(new r(dmVar2.dGw.md5, 2), 0);
                } else {
                    Log.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s fail", dmVar2.dGw.md5);
                }
                l.this.cGl();
            }
            AppMethodBeat.o(108656);
            return false;
        }
    };

    public l() {
        AppMethodBeat.i(108657);
        EventCenter.instance.addListener(this.rcg);
        EventCenter.instance.addListener(this.rch);
        this.rcd = Collections.synchronizedSet(new HashSet());
        this.rce = Collections.synchronizedSet(new HashSet());
        this.rcf = Collections.synchronizedSet(new HashSet());
        AppMethodBeat.o(108657);
    }

    /* access modifiers changed from: package-private */
    public final void cGl() {
        AppMethodBeat.i(108658);
        while (!this.rce.isEmpty()) {
            if (!this.rcf.isEmpty()) {
                Log.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", this.rcf.toString());
                AppMethodBeat.o(108658);
                return;
            }
            Iterator<String> it = this.rce.iterator();
            if (it != null) {
                String next = it.next();
                this.rce.remove(next);
                EmojiGroupInfo di = k.getEmojiStorageMgr().OpO.di(next, true);
                if (di == null || (di.field_flag & 256) <= 0) {
                    Log.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", next);
                    this.rcf.add(next);
                    g.aAg().hqi.a(new h(next, ""), 0);
                } else {
                    Log.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", next);
                }
            }
            AppMethodBeat.o(108658);
            return;
        }
        Log.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
        AppMethodBeat.o(108658);
    }
}
