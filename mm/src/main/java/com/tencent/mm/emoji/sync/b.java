package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bj;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "designerUin", "", "(I)V", "TAG", "", "cgiTask", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "getDesignerUin", "()I", "call", "", "uniqueId", "CgiGetDesignerTask", "plugin-emojisdk_release"})
public final class b extends c {
    private final String TAG = "MicroMsg.EmojiDesignerTask";
    final int gWW;
    private final a hcw = new a(this.gWW, new C0337b(this));

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.sync.b$b  reason: collision with other inner class name */
    static final class C0337b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ b hcA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0337b(b bVar) {
            super(1);
            this.hcA = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(183971);
            if (bool.booleanValue()) {
                this.hcA.a(j.OK);
            } else {
                this.hcA.a(j.Fail);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(183971);
            return xVar;
        }
    }

    public b(int i2) {
        AppMethodBeat.i(183974);
        this.gWW = i2;
        AppMethodBeat.o(183974);
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        AppMethodBeat.i(183972);
        Log.i(this.TAG, "call: " + this.gWW);
        this.hcw.awg();
        AppMethodBeat.o(183972);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(183973);
        String valueOf = String.valueOf(this.gWW);
        AppMethodBeat.o(183973);
        return valueOf;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0006\u0010\u0017\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "", "designerUin", "", "callback", "Lkotlin/Function1;", "", "", "(ILkotlin/jvm/functions/Function1;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "dbList", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getDesignerUin", "()I", "packList", "Ljava/util/LinkedList;", "reqBuff", "", "finish", "getNext", "start", "plugin-emojisdk_release"})
    public static final class a {
        final String TAG;
        final kotlin.g.a.b<Boolean, x> callback;
        private final int gWW;
        byte[] gWX;
        final LinkedList<String> hcx;
        private final bg hcy;

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
        /* renamed from: com.tencent.mm.emoji.sync.b$a$a  reason: collision with other inner class name */
        public static final class C0336a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            final /* synthetic */ a hcz;

            C0336a(a aVar) {
                this.hcz = aVar;
            }

            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Object obj) {
                SKBuiltinBuffer_t sKBuiltinBuffer_t;
                LinkedList<EmotionSummary> linkedList;
                LinkedList<EmotionSummary> linkedList2;
                AppMethodBeat.i(183967);
                c.a aVar = (c.a) obj;
                int i2 = aVar.errType;
                int i3 = aVar.errCode;
                Log.i(this.hcz.TAG, "getNext: " + i2 + ", " + i3);
                bsp bsp = (bsp) aVar.iLC;
                if (i2 == 0 && i3 == 0) {
                    if (!(bsp == null || (linkedList2 = bsp.EmotionList) == null)) {
                        Iterator<T> it = linkedList2.iterator();
                        while (it.hasNext()) {
                            this.hcz.hcx.add(it.next().ProductID);
                        }
                    }
                    a.a(this.hcz);
                    x xVar = x.SXb;
                    AppMethodBeat.o(183967);
                    return xVar;
                } else if (i2 == 4 && i3 == 2) {
                    if (!(bsp == null || (linkedList = bsp.EmotionList) == null)) {
                        Iterator<T> it2 = linkedList.iterator();
                        while (it2.hasNext()) {
                            this.hcz.hcx.add(it2.next().ProductID);
                        }
                    }
                    a aVar2 = this.hcz;
                    if (bsp != null) {
                        sKBuiltinBuffer_t = bsp.ReqBuf;
                    } else {
                        sKBuiltinBuffer_t = null;
                    }
                    aVar2.gWX = z.a(sKBuiltinBuffer_t);
                    if (this.hcz.gWX == null) {
                        a.a(this.hcz);
                        x xVar2 = x.SXb;
                        AppMethodBeat.o(183967);
                        return xVar2;
                    }
                    this.hcz.awg();
                    x xVar3 = x.SXb;
                    AppMethodBeat.o(183967);
                    return xVar3;
                } else {
                    kotlin.g.a.b<Boolean, x> bVar = this.hcz.callback;
                    if (bVar != null) {
                        x invoke = bVar.invoke(Boolean.FALSE);
                        AppMethodBeat.o(183967);
                        return invoke;
                    }
                    AppMethodBeat.o(183967);
                    return null;
                }
            }
        }

        public /* synthetic */ a(int i2) {
            this(i2, null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(int i2, kotlin.g.a.b<? super Boolean, x> bVar) {
            AppMethodBeat.i(183969);
            this.gWW = i2;
            this.callback = bVar;
            this.TAG = "MicroMsg.EmojiDesignerTask";
            this.hcx = new LinkedList<>();
            bg.a aVar = bg.a.Opu;
            this.hcy = bg.a.aki(this.gWW);
            AppMethodBeat.o(183969);
        }

        /* access modifiers changed from: package-private */
        public final void awg() {
            AppMethodBeat.i(183968);
            new e(this.gWW, this.gWX).aYI().g(new C0336a(this));
            AppMethodBeat.o(183968);
        }

        public static final /* synthetic */ void a(a aVar) {
            boolean z;
            T t;
            AppMethodBeat.i(183970);
            bg bgVar = new bg();
            int nowSecond = (int) Util.nowSecond();
            bgVar.gWW = aVar.gWW;
            Log.i(aVar.TAG, "finish: " + aVar.gWW + ", " + aVar.hcx.size() + ", oldSize " + aVar.hcy.LGy.size());
            boolean z2 = false;
            for (T t2 : aVar.hcx) {
                com.tencent.mm.storage.emotion.a aVar2 = new com.tencent.mm.storage.emotion.a();
                aVar2.field_designerUin = aVar.gWW;
                aVar2.field_productId = t2;
                aVar2.field_syncTime = 0;
                if (!aVar.hcy.LGy.isEmpty()) {
                    Iterator<T> it = aVar.hcy.LGy.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        T next = it.next();
                        if (p.j(((com.tencent.mm.storage.emotion.a) next).field_productId, t2)) {
                            t = next;
                            break;
                        }
                    }
                    T t3 = t;
                    if (t3 == null) {
                        aVar2.field_syncTime = nowSecond;
                        z = true;
                    } else {
                        aVar2.field_syncTime = ((com.tencent.mm.storage.emotion.a) t3).field_syncTime;
                        z = z2;
                    }
                } else {
                    z = true;
                }
                bgVar.LGy.add(aVar2);
                z2 = z;
            }
            if (z2) {
                bj gCJ = bj.gCJ();
                p.g(gCJ, "EmojiStorageMgr.getInstance()");
                gCJ.gCN().a(bgVar);
                bg.a aVar3 = bg.a.Opu;
                bg.a.a(aVar.gWW, bgVar);
                EventCenter.instance.publish(new rj());
            }
            kotlin.g.a.b<Boolean, x> bVar = aVar.callback;
            if (bVar != null) {
                bVar.invoke(Boolean.TRUE);
                AppMethodBeat.o(183970);
                return;
            }
            AppMethodBeat.o(183970);
        }
    }
}
