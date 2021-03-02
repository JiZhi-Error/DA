package com.tencent.mm.sticker;

import android.support.v7.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/sticker/LensItem;", "", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "reportPos", "", "lensType", "(Lcom/tencent/mm/protocal/protobuf/LensInfo;II)V", "getLensInfo", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getLensType", "()I", "setLensType", "(I)V", "getReportPos", "setReportPos", "Companion", "plugin-sticker_release"})
public final class c {
    public static final a NML = new a((byte) 0);
    public final chz NMJ;
    public int NMK;
    public int gZh;

    static {
        AppMethodBeat.i(194214);
        AppMethodBeat.o(194214);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/sticker/LensItem$Companion;", "", "()V", "TypeHistory", "", "TypeMore", "TypeRecommend", "getDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/sticker/LensItem;", "newList", "lensContentEqual", "", "oldItem", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "newItem", "plugin-sticker_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/sticker/LensItem$Companion$getDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-sticker_release"})
        /* renamed from: com.tencent.mm.sticker.c$a$a  reason: collision with other inner class name */
        public static final class C2065a extends c.a {
            final /* synthetic */ List NMM;
            final /* synthetic */ List uWv;

            C2065a(List list, List list2) {
                this.NMM = list;
                this.uWv = list2;
            }

            @Override // android.support.v7.h.c.a
            public final int aB() {
                AppMethodBeat.i(194207);
                int size = this.NMM.size();
                AppMethodBeat.o(194207);
                return size;
            }

            @Override // android.support.v7.h.c.a
            public final int aC() {
                AppMethodBeat.i(194208);
                int size = this.uWv.size();
                AppMethodBeat.o(194208);
                return size;
            }

            @Override // android.support.v7.h.c.a
            public final boolean i(int i2, int i3) {
                AppMethodBeat.i(194209);
                boolean j2 = p.j(((c) this.NMM.get(i2)).NMJ.Lso, ((c) this.uWv.get(i3)).NMJ.Lso);
                AppMethodBeat.o(194209);
                return j2;
            }

            @Override // android.support.v7.h.c.a
            public final boolean j(int i2, int i3) {
                String str;
                String str2;
                String str3 = null;
                AppMethodBeat.i(194210);
                a aVar = c.NML;
                chz chz = ((c) this.NMM.get(i2)).NMJ;
                chz chz2 = ((c) this.uWv.get(i3)).NMJ;
                p.h(chz, "oldItem");
                p.h(chz2, "newItem");
                if (!Util.isNullOrNil(chz.Lso)) {
                    if (Util.isEqual(chz.Lso, chz2.Lso)) {
                        chy chy = chz.Mnr;
                        if (chy != null) {
                            str = chy.Url;
                        } else {
                            str = null;
                        }
                        chy chy2 = chz2.Mnr;
                        if (Util.isEqual(str, chy2 != null ? chy2.Url : null)) {
                            cib cib = chz.Mns;
                            if (cib != null) {
                                str2 = cib.KMl;
                            } else {
                                str2 = null;
                            }
                            cib cib2 = chz2.Mns;
                            if (cib2 != null) {
                                str3 = cib2.KMl;
                            }
                            if (Util.isEqual(str2, str3)) {
                                AppMethodBeat.o(194210);
                                return true;
                            }
                        }
                    }
                    AppMethodBeat.o(194210);
                    return false;
                }
                boolean j2 = p.j(chz, chz2);
                AppMethodBeat.o(194210);
                return j2;
            }
        }

        public static c.b A(List<c> list, List<c> list2) {
            AppMethodBeat.i(194211);
            p.h(list, "oldList");
            p.h(list2, "newList");
            c.b a2 = android.support.v7.h.c.a(new C2065a(list, list2), false);
            p.g(a2, "DiffUtil.calculateDiff(o…  }\n            }, false)");
            AppMethodBeat.o(194211);
            return a2;
        }
    }

    public c(chz chz, int i2, int i3) {
        p.h(chz, "lensInfo");
        AppMethodBeat.i(194212);
        this.NMJ = chz;
        this.gZh = i2;
        this.NMK = i3;
        AppMethodBeat.o(194212);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(chz chz, int i2, int i3, byte b2) {
        this(chz, 0, (i3 & 4) != 0 ? 0 : i2);
        AppMethodBeat.i(194213);
        AppMethodBeat.o(194213);
    }
}
