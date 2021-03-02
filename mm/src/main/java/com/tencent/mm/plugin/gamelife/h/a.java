package com.tencent.mm.plugin.gamelife.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.protobuf.du;
import com.tencent.mm.plugin.game.protobuf.h;
import com.tencent.mm.plugin.game.protobuf.k;
import com.tencent.mm.plugin.game.protobuf.u;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/panel/GameLifePanelControlService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifePanelControlService;", "()V", "enableAttachButton", "", "enableCamera", "enableEmoji", "enablePic", "setButtonConfig", "", "shouldShowAttachButton", "shouldShowCamera", "shouldShowEmoji", "shouldShowSendPic", "wordForCameraIfDisabled", "", "sessionId", "wordForDynamicPanelIfDisabled", "panelType", "", "wordForSendPicIfDisabled", "wordForStaticPanelIfDisabled", "plugin-gamelife_release"})
public final class a implements d {
    private boolean ycn;
    private boolean yco;
    private boolean ycp;
    private boolean ycq;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if ((r0 == null || r0.isEmpty()) == false) goto L_0x002d;
     */
    @Override // com.tencent.mm.plugin.gamelife.a.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dXc() {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gamelife.h.a.dXc():void");
    }

    @Override // com.tencent.mm.plugin.gamelife.a.d
    public final boolean dXd() {
        return this.ycq;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.d
    public final boolean dXe() {
        return this.yco;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.d
    public final boolean dXf() {
        return this.ycn;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.d
    public final boolean dXg() {
        return this.ycp;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.d
    public final String aAU(String str) {
        AppMethodBeat.i(241409);
        String el = el(str, 1);
        AppMethodBeat.o(241409);
        return el;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.d
    public final String aAV(String str) {
        AppMethodBeat.i(241410);
        String el = el(str, 2);
        AppMethodBeat.o(241410);
        return el;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.d
    public final String ek(String str, int i2) {
        c dXh;
        LinkedList<h> linkedList;
        T t;
        LinkedList<u> linkedList2;
        T t2;
        boolean z;
        AppMethodBeat.i(241411);
        if (str == null) {
            AppMethodBeat.o(241411);
            return null;
        }
        e aAW = ((f) g.af(f.class)).aAW(str);
        if (aAW == null || (dXh = aAW.dXh()) == null) {
            AppMethodBeat.o(241411);
            return null;
        } else if ((dXh.ybc & ((long) (1 << (i2 - 1)))) == 0) {
            AppMethodBeat.o(241411);
            return null;
        } else {
            k dSZ = com.tencent.mm.plugin.game.commlib.a.dSZ();
            if (!(dSZ == null || (linkedList = dSZ.xJi) == null)) {
                Iterator<T> it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (next.xIY == i2) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        t = next;
                        break;
                    }
                }
                T t3 = t;
                if (!(t3 == null || (linkedList2 = t3.xJe) == null)) {
                    Iterator<T> it2 = linkedList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t2 = null;
                            break;
                        }
                        T next2 = it2.next();
                        if (p.j(next2.rBI, LocaleUtil.getApplicationLanguage())) {
                            t2 = next2;
                            break;
                        }
                    }
                    T t4 = t2;
                    if (t4 != null) {
                        String str2 = t4.xJH;
                        AppMethodBeat.o(241411);
                        return str2;
                    }
                }
            }
            String aI = com.tencent.mm.cb.a.aI(ApplicationGlobal.context(), R.string.dtp);
            AppMethodBeat.o(241411);
            return aI;
        }
    }

    private static String el(String str, int i2) {
        c dXh;
        LinkedList<du> linkedList;
        T t;
        LinkedList<u> linkedList2;
        T t2;
        boolean z;
        AppMethodBeat.i(241412);
        if (str == null) {
            AppMethodBeat.o(241412);
            return null;
        }
        e aAW = ((f) g.af(f.class)).aAW(str);
        if (aAW == null || (dXh = aAW.dXh()) == null) {
            AppMethodBeat.o(241412);
            return null;
        } else if ((dXh.ybb & ((long) (1 << (i2 - 1)))) == 0) {
            AppMethodBeat.o(241412);
            return null;
        } else {
            k dSZ = com.tencent.mm.plugin.game.commlib.a.dSZ();
            if (!(dSZ == null || (linkedList = dSZ.xJj) == null)) {
                Iterator<T> it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (next.xIY == i2) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        t = next;
                        break;
                    }
                }
                T t3 = t;
                if (!(t3 == null || (linkedList2 = t3.xJe) == null)) {
                    Iterator<T> it2 = linkedList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t2 = null;
                            break;
                        }
                        T next2 = it2.next();
                        if (p.j(next2.rBI, LocaleUtil.getApplicationLanguage())) {
                            t2 = next2;
                            break;
                        }
                    }
                    T t4 = t2;
                    if (t4 != null) {
                        String str2 = t4.xJH;
                        AppMethodBeat.o(241412);
                        return str2;
                    }
                }
            }
            String aI = com.tencent.mm.cb.a.aI(ApplicationGlobal.context(), R.string.dtp);
            AppMethodBeat.o(241412);
            return aI;
        }
    }
}
