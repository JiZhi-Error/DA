package com.tencent.mm.emoji.b.b;

import android.support.v7.h.c;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.w;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u0000 )*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001)B\u0005¢\u0006\u0002\u0010\u0004J\r\u0010\u001a\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ$\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001cH\u0002J\u0006\u0010%\u001a\u00020\"J\u0010\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010\rJ\b\u0010(\u001a\u00020\"H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006*"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "", "()V", "TAG", "", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;)V", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "setDataListener", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;)V", "isUpdating", "", "()Z", "setUpdating", "(Z)V", "needUpdate", "getNeedUpdate", "setNeedUpdate", "createData", "getDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItemList", "", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "newItemList", "notifyDiff", "", "newData", "diff", "postUpdate", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "updateData", "Companion", "plugin-emojisdk_release"})
public abstract class ab<T extends w> {
    public static final a gYS = new a((byte) 0);
    private final String TAG = "MicroMsg.PanelGroupModel";
    boolean gYQ;
    aa gYR;
    boolean needUpdate = true;

    public abstract void a(T t);

    public abstract T avp();

    public abstract T avr();

    public final void a(aa aaVar) {
        if (!p.j(this.gYR, aaVar)) {
            this.gYR = aaVar;
            if (this.gYR != null) {
                avu();
            }
        }
    }

    public final synchronized void avu() {
        if (this.gYQ) {
            this.needUpdate = true;
        } else if (this.gYR != null) {
            this.gYQ = true;
            com.tencent.mm.ac.d.b("PanelGroupModel_postUpdate", new d(this));
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/emoji/model/panel/PanelGroupModel$getDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"})
    public static final class b extends c.a {
        final /* synthetic */ List gYT;
        final /* synthetic */ List gYU;

        b(List list, List list2) {
            this.gYT = list;
            this.gYU = list2;
        }

        @Override // android.support.v7.h.c.a
        public final int aB() {
            AppMethodBeat.i(105563);
            int size = this.gYT.size();
            AppMethodBeat.o(105563);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final int aC() {
            AppMethodBeat.i(105564);
            int size = this.gYU.size();
            AppMethodBeat.o(105564);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final boolean i(int i2, int i3) {
            AppMethodBeat.i(105565);
            boolean j2 = p.j((ac) this.gYT.get(i2), (ac) this.gYU.get(i3));
            AppMethodBeat.o(105565);
            return j2;
        }

        @Override // android.support.v7.h.c.a
        public final boolean j(int i2, int i3) {
            AppMethodBeat.i(105566);
            boolean aZ = ((ac) this.gYT.get(i2)).aZ(this.gYU.get(i3));
            AppMethodBeat.o(105566);
            return aZ;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/PanelGroupModel$Companion;", "", "()V", "createGroupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "group", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ab gYV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ab abVar) {
            super(0);
            this.gYV = abVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.tencent.mm.emoji.b.b.ab */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105572);
            ab abVar = this.gYV;
            if (abVar.gYR != null) {
                w avr = abVar.avr();
                c.b a2 = android.support.v7.h.c.a(new b(abVar.avp().avn(), avr.avn()), false);
                p.g(a2, "DiffUtil.calculateDiff(o…      }\n        }, false)");
                abVar.a(avr);
                com.tencent.mm.ac.d.h(new c(abVar, avr, a2));
            } else {
                abVar.gYQ = false;
                abVar.needUpdate = true;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105572);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ab gYV;
        final /* synthetic */ w gYW;
        final /* synthetic */ c.b gYX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ab abVar, w wVar, c.b bVar) {
            super(0);
            this.gYV = abVar;
            this.gYW = wVar;
            this.gYX = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105571);
            aa aaVar = this.gYV.gYR;
            if (aaVar != null) {
                aaVar.b(this.gYW);
            }
            this.gYX.a(new android.support.v7.h.d(this) {
                /* class com.tencent.mm.emoji.b.b.ab.c.AnonymousClass1 */
                final /* synthetic */ c gYY;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.gYY = r1;
                }

                @Override // android.support.v7.h.d
                public final void f(int i2, int i3) {
                    AppMethodBeat.i(105567);
                    aa aaVar = this.gYY.gYV.gYR;
                    if (aaVar != null) {
                        aaVar.cD(i2, i3);
                        AppMethodBeat.o(105567);
                        return;
                    }
                    AppMethodBeat.o(105567);
                }

                @Override // android.support.v7.h.d
                public final void k(int i2, int i3) {
                    AppMethodBeat.i(105568);
                    aa aaVar = this.gYY.gYV.gYR;
                    if (aaVar != null) {
                        aaVar.cE(i2, i3);
                        AppMethodBeat.o(105568);
                        return;
                    }
                    AppMethodBeat.o(105568);
                }

                @Override // android.support.v7.h.d
                public final void l(int i2, int i3) {
                    AppMethodBeat.i(105569);
                    aa aaVar = this.gYY.gYV.gYR;
                    if (aaVar != null) {
                        aaVar.cF(i2, i3);
                        AppMethodBeat.o(105569);
                        return;
                    }
                    AppMethodBeat.o(105569);
                }

                @Override // android.support.v7.h.d
                public final void c(int i2, int i3, Object obj) {
                    AppMethodBeat.i(105570);
                    aa aaVar = this.gYY.gYV.gYR;
                    if (aaVar != null) {
                        aaVar.cG(i2, i3);
                        AppMethodBeat.o(105570);
                        return;
                    }
                    AppMethodBeat.o(105570);
                }
            });
            this.gYV.gYQ = false;
            if (this.gYV.needUpdate) {
                this.gYV.needUpdate = false;
                this.gYV.avu();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105571);
            return xVar;
        }
    }
}
