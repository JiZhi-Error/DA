package com.tencent.mm.plugin.gallery.model;

import android.support.v4.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Set;
import kotlin.j.c;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J6\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/gallery/model/RandomPreload;", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "()V", "preloadOnlyOnIdle", "", "retrievePreloadItems", "", "", "state", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "lastState", "first", "last", "limit", "Companion", "plugin-gallery_release"})
public final class q implements j {
    public static final a xjD = new a((byte) 0);

    static {
        AppMethodBeat.i(111801);
        AppMethodBeat.o(111801);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/gallery/model/RandomPreload$Companion;", "", "()V", "COUNT", "", "SCREEN", "SUM", "TAG", "", "plugin-gallery_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.gallery.model.j
    public final Set<Integer> a(p.c cVar, p.c cVar2, int i2, int i3, int i4) {
        AppMethodBeat.i(111800);
        kotlin.g.b.p.h(cVar, "state");
        kotlin.g.b.p.h(cVar2, "lastState");
        b bVar = new b();
        if (!(i2 == -1 || i3 == -1 || i2 >= i3)) {
            Log.d("MicroMsg.RandomPreload", "start RandomPreload!!!");
            switch (r.$EnumSwitchMapping$0[cVar.ordinal()]) {
                case 1:
                    int i5 = i2 >= 160 ? i2 - 160 : 0;
                    int i6 = i2 - i5;
                    Log.d("MicroMsg.RandomPreload", "from %s until %s range %s", Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i6));
                    if (i6 > 0) {
                        if (i6 > 50) {
                            ArrayList arrayList = new ArrayList(50);
                            for (int i7 = 0; i7 < 50; i7++) {
                                arrayList.add(Integer.valueOf(c.SYP.nextInt(i5, i2)));
                            }
                            bVar.addAll(arrayList);
                            break;
                        } else {
                            ArrayList arrayList2 = new ArrayList(i6);
                            for (int i8 = 0; i8 < i6; i8++) {
                                arrayList2.add(Integer.valueOf(c.SYP.nextInt(i5, i2)));
                            }
                            bVar.addAll(arrayList2);
                            break;
                        }
                    }
                    break;
                case 2:
                case 3:
                    int i9 = i3 + 160;
                    if (i9 <= i4) {
                        i4 = i9;
                    }
                    int i10 = i4 - i3;
                    Log.d("MicroMsg.RandomPreload", "from %s until %s range %s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i10));
                    if (i10 > 0) {
                        if (i10 > 50) {
                            ArrayList arrayList3 = new ArrayList(50);
                            for (int i11 = 0; i11 < 50; i11++) {
                                arrayList3.add(Integer.valueOf(c.SYP.nextInt(i3, i4)));
                            }
                            bVar.addAll(arrayList3);
                            break;
                        } else {
                            ArrayList arrayList4 = new ArrayList(i10);
                            for (int i12 = 0; i12 < i10; i12++) {
                                arrayList4.add(Integer.valueOf(c.SYP.nextInt(i3, i4)));
                            }
                            bVar.addAll(arrayList4);
                            break;
                        }
                    }
                    break;
            }
        }
        b bVar2 = bVar;
        AppMethodBeat.o(111800);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.gallery.model.j
    public final boolean dRm() {
        return false;
    }
}
