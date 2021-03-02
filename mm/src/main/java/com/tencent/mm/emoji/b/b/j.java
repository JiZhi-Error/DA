package com.tencent.mm.emoji.b.b;

import android.support.v7.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.b.b.ab;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\u0006\u0010\"\u001a\u00020\u001bJ\b\u0010#\u001a\u00020\u001bH\u0002J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/EmojiPanelDataFactory;", "", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelDataListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "data", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "dataUpdating", "", "expandGroupList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "externalPanelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "groupDiffResult", "Landroid/support/v7/util/DiffUtil$DiffResult;", "queueUpdate", "tempData", "addExternalGroup", "", "externalPanelProvider", "addGroup", "group", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getDiff", "notifyDataDiff", "postUpdate", "resetTempData", "toggleExpandGroup", "groupId", "plugin-emojisdk_release"})
public final class j {
    final i gYa;
    l gYs = new l();
    l gYt = new l();
    c.b gYu;
    public final LinkedList<n> gYv = new LinkedList<>();
    private HashSet<String> gYw = new HashSet<>();
    boolean gYx;
    boolean gYy;
    final z gYz;

    public j(i iVar, z zVar) {
        p.h(iVar, "config");
        p.h(zVar, "dataListener");
        AppMethodBeat.i(105556);
        this.gYa = iVar;
        this.gYz = zVar;
        AppMethodBeat.o(105556);
    }

    public final synchronized void avu() {
        AppMethodBeat.i(105554);
        if (this.gYx) {
            this.gYy = true;
            AppMethodBeat.o(105554);
        } else {
            Log.i(k.TAG, "updateData: start");
            this.gYx = true;
            d.b("EmojiPanelData_updateData", new c(this));
            AppMethodBeat.o(105554);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(105555);
        int size = this.gYt.gYE.size();
        this.gYt.gYE.add(emojiGroupInfo);
        this.gYt.gYF.add(new ag(0, emojiGroupInfo, size));
        AppMethodBeat.o(105555);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/emoji/model/panel/EmojiPanelDataFactory$getDiff$groupDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"})
    public static final class a extends c.a {
        final /* synthetic */ j gYA;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(j jVar) {
            this.gYA = jVar;
        }

        @Override // android.support.v7.h.c.a
        public final int aB() {
            AppMethodBeat.i(105545);
            int size = this.gYA.gYs.gYE.size();
            AppMethodBeat.o(105545);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final int aC() {
            AppMethodBeat.i(105546);
            int size = this.gYA.gYt.gYE.size();
            AppMethodBeat.o(105546);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final boolean i(int i2, int i3) {
            AppMethodBeat.i(105547);
            EmojiGroupInfo emojiGroupInfo = this.gYA.gYs.gYE.get(i2);
            p.g(emojiGroupInfo, "data.groupList[oldItemPosition]");
            String hYf = emojiGroupInfo.hYf();
            EmojiGroupInfo emojiGroupInfo2 = this.gYA.gYt.gYE.get(i3);
            p.g(emojiGroupInfo2, "tempData.groupList[newItemPosition]");
            boolean j2 = p.j(hYf, emojiGroupInfo2.hYf());
            AppMethodBeat.o(105547);
            return j2;
        }

        @Override // android.support.v7.h.c.a
        public final boolean j(int i2, int i3) {
            AppMethodBeat.i(105548);
            EmojiGroupInfo emojiGroupInfo = this.gYA.gYs.gYE.get(i2);
            p.g(emojiGroupInfo, "data.groupList[oldItemPosition]");
            EmojiGroupInfo emojiGroupInfo2 = emojiGroupInfo;
            EmojiGroupInfo emojiGroupInfo3 = this.gYA.gYt.gYE.get(i3);
            p.g(emojiGroupInfo3, "tempData.groupList[newItemPosition]");
            EmojiGroupInfo emojiGroupInfo4 = emojiGroupInfo3;
            if (!p.j(emojiGroupInfo2.hYf(), emojiGroupInfo4.hYf()) || !p.j(emojiGroupInfo2.beq(), emojiGroupInfo4.beq()) || !p.j(emojiGroupInfo2.hYg(), emojiGroupInfo4.hYg())) {
                AppMethodBeat.o(105548);
                return false;
            }
            AppMethodBeat.o(105548);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ j gYA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(j jVar) {
            super(0);
            this.gYA = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            T t;
            T t2;
            ab<?> amVar;
            AppMethodBeat.i(105553);
            j jVar = this.gYA;
            jVar.gYt.gYE.clear();
            jVar.gYt.gYF.clear();
            if (jVar.gYa.gYf) {
                jVar.gYt.gYF.add(new ag(2, new EmojiGroupInfo(), -1));
                jVar.gYt.gYG = 1;
            }
            Iterator<T> it = jVar.gYv.iterator();
            while (it.hasNext()) {
                jVar.a(it.next().avz());
            }
            if (jVar.gYa.gYg) {
                jVar.a(ad.avF());
            }
            if (jVar.gYa.gYh) {
                jVar.a(ad.avG());
            }
            if (jVar.gYa.gYk) {
                if (!new c(jVar.gYa.gYl).gXW.isEmpty()) {
                    jVar.a(ad.avH());
                }
            }
            if (jVar.gYa.gYm) {
                com.tencent.mm.emoji.b.j auL = com.tencent.mm.emoji.b.j.auL();
                p.g(auL, "EmojiStorageCache.getInstance()");
                ArrayList<EmojiGroupInfo> auP = auL.auP();
                p.g(auP, "EmojiStorageCache.getInstance().emojiGroupInfoList");
                for (T t3 : auP) {
                    p.g(t3, LocaleUtil.ITALIAN);
                    jVar.a(t3);
                }
            }
            for (T t4 : jVar.gYt.gYE) {
                Iterator<T> it2 = jVar.gYs.gYD.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it2.next();
                    if (p.j(next.avp().avm().hYf(), t4.hYf())) {
                        t = next;
                        break;
                    }
                }
                T t5 = t;
                if (t5 != null) {
                    t5.avu();
                    jVar.gYt.gYD.add(t5);
                } else {
                    Iterator<T> it3 = jVar.gYv.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            t2 = null;
                            break;
                        }
                        T next2 = it3.next();
                        if (p.j(next2.avy(), t4.hYf())) {
                            t2 = next2;
                            break;
                        }
                    }
                    T t6 = t2;
                    if (t6 != null) {
                        jVar.gYt.gYD.add(t6.avA());
                    } else {
                        LinkedList<ab<?>> linkedList = jVar.gYt.gYD;
                        ab.a aVar = ab.gYS;
                        i iVar = jVar.gYa;
                        p.h(iVar, "config");
                        p.h(t4, "group");
                        String hYf = t4.hYf();
                        if (p.j(hYf, ad.avB())) {
                            amVar = new ak(iVar);
                        } else if (p.j(hYf, ad.avC())) {
                            amVar = new f(iVar);
                        } else if (p.j(hYf, ad.avD())) {
                            amVar = new d(iVar);
                        } else {
                            amVar = new am(t4);
                        }
                        linkedList.add(amVar);
                    }
                }
            }
            j jVar2 = this.gYA;
            c.b a2 = android.support.v7.h.c.a(new a(jVar2), false);
            p.g(a2, "DiffUtil.calculateDiff(o…      }\n        }, false)");
            jVar2.gYu = a2;
            j jVar3 = this.gYA;
            jVar3.gYs = jVar3.gYt;
            jVar3.gYt = new l();
            d.h(new b(jVar3, jVar3.gYs));
            x xVar = x.SXb;
            AppMethodBeat.o(105553);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ j gYA;
        final /* synthetic */ l gYB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(j jVar, l lVar) {
            super(0);
            this.gYA = jVar;
            this.gYB = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105552);
            this.gYA.gYz.a(this.gYB);
            c.b bVar = this.gYA.gYu;
            if (bVar != null) {
                bVar.a(new android.support.v7.h.d(this) {
                    /* class com.tencent.mm.emoji.b.b.j.b.AnonymousClass1 */
                    final /* synthetic */ b gYC;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.gYC = r1;
                    }

                    @Override // android.support.v7.h.d
                    public final void f(int i2, int i3) {
                        AppMethodBeat.i(105549);
                        this.gYC.gYA.gYz.cA(i2, i3);
                        this.gYC.gYA.gYz.cH(this.gYC.gYB.gYG + i2, i3);
                        AppMethodBeat.o(105549);
                    }

                    @Override // android.support.v7.h.d
                    public final void k(int i2, int i3) {
                        AppMethodBeat.i(105550);
                        this.gYC.gYA.gYz.cC(i2, i3);
                        this.gYC.gYA.gYz.cJ(this.gYC.gYB.gYG + i2, i3);
                        AppMethodBeat.o(105550);
                    }

                    @Override // android.support.v7.h.d
                    public final void l(int i2, int i3) {
                    }

                    @Override // android.support.v7.h.d
                    public final void c(int i2, int i3, Object obj) {
                        AppMethodBeat.i(105551);
                        this.gYC.gYA.gYz.cB(i2, i3);
                        this.gYC.gYA.gYz.cI(this.gYC.gYB.gYG + i2, i3);
                        AppMethodBeat.o(105551);
                    }
                });
            }
            Log.i(k.TAG, "updateData: end");
            this.gYA.gYx = false;
            if (this.gYA.gYy) {
                this.gYA.gYy = false;
                this.gYA.avu();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105552);
            return xVar;
        }
    }
}
