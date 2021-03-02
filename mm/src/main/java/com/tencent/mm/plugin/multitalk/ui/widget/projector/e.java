package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001c\u001d\u001eBU\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "", "supportFuncList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "moreFuncList", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "featureSupportList", "type", "(Ljava/util/HashSet;Ljava/util/HashSet;Ljava/util/HashSet;I)V", "getFeatureSupportList", "()Ljava/util/HashSet;", "setFeatureSupportList", "(Ljava/util/HashSet;)V", "getMoreFuncList", "setMoreFuncList", "getSupportFuncList", "setSupportFuncList", "getType", "()I", "setType", "(I)V", "checkFeatureSupport", "", "func", "checkFuncSupport", "getMoreFuncSupportList", "Builder", "Companion", "MoreItem", "plugin-multitalk_release"})
public final class e {
    public static final b zWh = new b((byte) 0);
    private int type;
    private HashSet<Integer> zWe;
    HashSet<c> zWf;
    private HashSet<Integer> zWg;

    static {
        AppMethodBeat.i(239935);
        AppMethodBeat.o(239935);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Companion;", "", "()V", "CLEAR_SCREEN", "", "COUNT_DOWN", "DOODLE", "FAV", "FLIP_SUPPORTED", "MORE", "RENDER_IGNORE_BG", "SAVE_TO_PICTURE", "SCALE_SUPPORTED", "SEND_TO_FRIEND", "TAG", "", "TEXT", "plugin-multitalk_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public e(HashSet<Integer> hashSet, HashSet<c> hashSet2, HashSet<Integer> hashSet3, int i2) {
        p.h(hashSet, "supportFuncList");
        p.h(hashSet2, "moreFuncList");
        p.h(hashSet3, "featureSupportList");
        AppMethodBeat.i(239934);
        this.zWe = hashSet;
        this.zWf = hashSet2;
        this.zWg = hashSet3;
        this.type = i2;
        AppMethodBeat.o(239934);
    }

    public final boolean Rx(int i2) {
        AppMethodBeat.i(239932);
        boolean contains = this.zWe.contains(Integer.valueOf(i2));
        AppMethodBeat.o(239932);
        return contains;
    }

    public final boolean Ry(int i2) {
        AppMethodBeat.i(239933);
        boolean contains = this.zWg.contains(Integer.valueOf(i2));
        AppMethodBeat.o(239933);
        return contains;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "", "name", "", "func", "", "(Ljava/lang/String;I)V", "getFunc", "()I", "setFunc", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-multitalk_release"})
    public static final class c {
        String name;
        int zWi;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (r3.zWi == r4.zWi) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 239931(0x3a93b, float:3.36215E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.multitalk.ui.widget.projector.e.c
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.multitalk.ui.widget.projector.e$c r4 = (com.tencent.mm.plugin.multitalk.ui.widget.projector.e.c) r4
                java.lang.String r0 = r3.name
                java.lang.String r1 = r4.name
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
                int r0 = r3.zWi
                int r1 = r4.zWi
                if (r0 != r1) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.projector.e.c.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(239930);
            String str = this.name;
            int hashCode = ((str != null ? str.hashCode() : 0) * 31) + this.zWi;
            AppMethodBeat.o(239930);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(239929);
            String str = "MoreItem(name=" + this.name + ", func=" + this.zWi + ")";
            AppMethodBeat.o(239929);
            return str;
        }

        public c(String str, int i2) {
            p.h(str, "name");
            AppMethodBeat.i(239928);
            this.name = str;
            this.zWi = i2;
            AppMethodBeat.o(239928);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u00020\u00002\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0005J\u0012\u0010\u001a\u001a\u00020\u00002\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0005J\u001f\u0010\u001b\u001a\u00020\u00002\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u001c\"\u00020\f¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0005R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Builder;", "", "()V", "featureSupportList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getFeatureSupportList", "()Ljava/util/HashSet;", "setFeatureSupportList", "(Ljava/util/HashSet;)V", "moreFuncList", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "getMoreFuncList", "setMoreFuncList", "supportFuncList", "getSupportFuncList", "setSupportFuncList", "type", "getType", "()I", "setType", "(I)V", "addFeatureSupport", "funcs", "", "addFunc", "addMoreFuncSupport", "", "([Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;)Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Builder;", "build", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "plugin-multitalk_release"})
    public static final class a {
        int type;
        private HashSet<Integer> zWe = new HashSet<>();
        private HashSet<c> zWf = new HashSet<>();
        private HashSet<Integer> zWg = new HashSet<>();

        public a() {
            AppMethodBeat.i(239927);
            AppMethodBeat.o(239927);
        }

        public final a E(int... iArr) {
            AppMethodBeat.i(239923);
            p.h(iArr, "funcs");
            for (int i2 : iArr) {
                this.zWe.add(Integer.valueOf(i2));
            }
            AppMethodBeat.o(239923);
            return this;
        }

        public final a a(c... cVarArr) {
            AppMethodBeat.i(239924);
            p.h(cVarArr, "funcs");
            for (c cVar : cVarArr) {
                this.zWf.add(cVar);
            }
            AppMethodBeat.o(239924);
            return this;
        }

        public final a F(int... iArr) {
            AppMethodBeat.i(239925);
            p.h(iArr, "funcs");
            for (int i2 = 0; i2 < 2; i2++) {
                this.zWg.add(Integer.valueOf(iArr[i2]));
            }
            AppMethodBeat.o(239925);
            return this;
        }

        public final e epo() {
            AppMethodBeat.i(239926);
            e eVar = new e(this.zWe, this.zWf, this.zWg, this.type);
            AppMethodBeat.o(239926);
            return eVar;
        }
    }
}
