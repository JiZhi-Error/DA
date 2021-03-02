package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0003\u0010\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback;", "", "()V", "hasMore_Field", "Ljava/lang/reflect/Field;", "incrementList_Field", "isNeedClear_Field", "lastBuffer_Field", "pullType_Field", "getArgsOnFetchDone", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "args", "", "([Ljava/lang/Object;)Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "startMonitor", "", "ArgsOnFetchDone", "Companion", "FinderPullType", "plugin-expt_release"})
public final class m {
    public static final b sGi = new b((byte) 0);
    private Field sGd;
    private Field sGe;
    private Field sGf;
    private Field sGg;
    private Field sGh;

    static {
        AppMethodBeat.i(221014);
        AppMethodBeat.o(221014);
    }

    public m() {
        AppMethodBeat.i(221013);
        try {
            Class<?> cls = Class.forName("com.tencent.mm.plugin.finder.feed.model.internal.IResponse");
            p.g(cls, "Class.forName(\"com.tence…odel.internal.IResponse\")");
            Field declaredField = cls.getDeclaredField("incrementList");
            p.g(declaredField, "clazz.getDeclaredField(\"incrementList\")");
            this.sGd = declaredField;
            Field field = this.sGd;
            if (field == null) {
                p.btv("incrementList_Field");
            }
            field.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("lastBuffer");
            p.g(declaredField2, "clazz.getDeclaredField(\"lastBuffer\")");
            this.sGe = declaredField2;
            Field field2 = this.sGe;
            if (field2 == null) {
                p.btv("lastBuffer_Field");
            }
            field2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("pullType");
            p.g(declaredField3, "clazz.getDeclaredField(\"pullType\")");
            this.sGf = declaredField3;
            Field field3 = this.sGf;
            if (field3 == null) {
                p.btv("pullType_Field");
            }
            field3.setAccessible(true);
            Field declaredField4 = cls.getDeclaredField("hasMore");
            p.g(declaredField4, "clazz.getDeclaredField(\"hasMore\")");
            this.sGg = declaredField4;
            Field field4 = this.sGg;
            if (field4 == null) {
                p.btv("hasMore_Field");
            }
            field4.setAccessible(true);
            Field declaredField5 = cls.getDeclaredField("isNeedClear");
            p.g(declaredField5, "clazz.getDeclaredField(\"isNeedClear\")");
            this.sGh = declaredField5;
            Field field5 = this.sGh;
            if (field5 == null) {
                p.btv("isNeedClear_Field");
            }
            field5.setAccessible(true);
            AppMethodBeat.o(221013);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.RefreshLoadMoreCallback", e2, "init crash: " + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(221013);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final a p(Object[] objArr) {
        AppMethodBeat.i(221012);
        p.h(objArr, "args");
        Object obj = objArr[0];
        try {
            Field field = this.sGd;
            if (field == null) {
                p.btv("incrementList_Field");
            }
            Object obj2 = field.get(obj);
            if (!(obj2 instanceof List)) {
                obj2 = null;
            }
            List list = (List) obj2;
            Field field2 = this.sGe;
            if (field2 == null) {
                p.btv("lastBuffer_Field");
            }
            Object obj3 = field2.get(obj);
            com.tencent.mm.bw.b bVar = obj3 == null ? null : (com.tencent.mm.bw.b) obj3;
            Field field3 = this.sGf;
            if (field3 == null) {
                p.btv("pullType_Field");
            }
            Object obj4 = field3.get(obj);
            if (obj4 == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(221012);
                throw tVar;
            }
            int intValue = ((Integer) obj4).intValue();
            Field field4 = this.sGg;
            if (field4 == null) {
                p.btv("hasMore_Field");
            }
            Object obj5 = field4.get(obj);
            if (obj5 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(221012);
                throw tVar2;
            }
            boolean booleanValue = ((Boolean) obj5).booleanValue();
            Field field5 = this.sGh;
            if (field5 == null) {
                p.btv("isNeedClear_Field");
            }
            Object obj6 = field5.get(obj);
            if (obj6 == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(221012);
                throw tVar3;
            }
            a aVar = new a(list, bVar, intValue, booleanValue, ((Boolean) obj6).booleanValue());
            AppMethodBeat.o(221012);
            return aVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.RefreshLoadMoreCallback", e2, "getArgsOnFetchDone crash: " + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(221012);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003JC\u0010\"\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "", "incrementList", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "hasMore", "", "isNeedClear", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;IZZ)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "getIncrementList", "()Ljava/util/List;", "setIncrementList", "(Ljava/util/List;)V", "setNeedClear", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getPullType", "()I", "setPullType", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-expt_release"})
    public static final class a {
        private boolean hasMore;
        public List<?> incrementList;
        private boolean isNeedClear;
        private com.tencent.mm.bw.b lastBuffer;
        public int pullType;

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
            if (r3.isNeedClear == r4.isNeedClear) goto L_0x0034;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 221008(0x35f50, float:3.09698E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0034
                boolean r0 = r4 instanceof com.tencent.mm.plugin.expt.hellhound.a.b.b.m.a
                if (r0 == 0) goto L_0x0039
                com.tencent.mm.plugin.expt.hellhound.a.b.b.m$a r4 = (com.tencent.mm.plugin.expt.hellhound.a.b.b.m.a) r4
                java.util.List<?> r0 = r3.incrementList
                java.util.List<?> r1 = r4.incrementList
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0039
                com.tencent.mm.bw.b r0 = r3.lastBuffer
                com.tencent.mm.bw.b r1 = r4.lastBuffer
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0039
                int r0 = r3.pullType
                int r1 = r4.pullType
                if (r0 != r1) goto L_0x0039
                boolean r0 = r3.hasMore
                boolean r1 = r4.hasMore
                if (r0 != r1) goto L_0x0039
                boolean r0 = r3.isNeedClear
                boolean r1 = r4.isNeedClear
                if (r0 != r1) goto L_0x0039
            L_0x0034:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0038:
                return r0
            L_0x0039:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0038
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.b.b.m.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 1;
            int i3 = 0;
            AppMethodBeat.i(221007);
            List<?> list = this.incrementList;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            com.tencent.mm.bw.b bVar = this.lastBuffer;
            if (bVar != null) {
                i3 = bVar.hashCode();
            }
            int i4 = (((hashCode + i3) * 31) + this.pullType) * 31;
            boolean z = this.hasMore;
            if (z) {
                z = true;
            }
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = z ? 1 : 0;
            int i8 = (i5 + i4) * 31;
            boolean z2 = this.isNeedClear;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            int i9 = i8 + i2;
            AppMethodBeat.o(221007);
            return i9;
        }

        public final String toString() {
            AppMethodBeat.i(221006);
            String str = "ArgsOnFetchDone(incrementList=" + this.incrementList + ", lastBuffer=" + this.lastBuffer + ", pullType=" + this.pullType + ", hasMore=" + this.hasMore + ", isNeedClear=" + this.isNeedClear + ")";
            AppMethodBeat.o(221006);
            return str;
        }

        public a(List<?> list, com.tencent.mm.bw.b bVar, int i2, boolean z, boolean z2) {
            this.incrementList = list;
            this.lastBuffer = bVar;
            this.pullType = i2;
            this.hasMore = z;
            this.isNeedClear = z2;
        }

        private /* synthetic */ a() {
            this(null, null, -1, true, true);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$FinderPullType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PULL_TYPE_ENTER", "PULL_TYPE_TOP", "PULL_TYPE_BOTTOM", "PULL_TYPE_PRE_FETCH", "PULL_TYPE_REFRESH", "plugin-expt_release"})
    public enum c {
        PULL_TYPE_ENTER(0),
        PULL_TYPE_TOP(1),
        PULL_TYPE_BOTTOM(2),
        PULL_TYPE_PRE_FETCH(3),
        PULL_TYPE_REFRESH(4);
        
        final int value;

        public static c valueOf(String str) {
            AppMethodBeat.i(221011);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(221011);
            return cVar;
        }

        private c(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(221009);
            AppMethodBeat.o(221009);
        }
    }
}
