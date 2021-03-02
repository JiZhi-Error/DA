package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JI\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0001J=\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0001J?\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0001JI\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0001J?\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0001JI\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0001J=\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0001¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderAssertCat;", "Lcom/tencent/mm/kt/IAssert;", "()V", "assertEquals", "", "key", "", "expected", "", "actual", "isReport", "", "isThrow", "message", "Lkotlin/Function0;", "assertFalse", "condition", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertTrue", "plugin-finder_release"})
public final class c implements f {
    public static final c vVc = new c();
    private final /* synthetic */ b vVd = new b(new Long[]{1535L, 1536L}, "FinderAssertCat", new b.a() {
        /* class com.tencent.mm.plugin.finder.utils.c.AnonymousClass1 */

        @Override // com.tencent.mm.ac.b.a
        public final int getId(String str) {
            AppMethodBeat.i(253354);
            p.h(str, "key");
            switch (str.hashCode()) {
                case -1992170110:
                    if (str.equals("liveInvalidBadgeTag")) {
                        AppMethodBeat.o(253354);
                        return 9;
                    }
                    break;
                case -1731756960:
                    if (str.equals("cgiReportNormal")) {
                        AppMethodBeat.o(253354);
                        return 12;
                    }
                    break;
                case -1714598175:
                    if (str.equals("NetSceneFinderFollow_fromCommentScene_0")) {
                        AppMethodBeat.o(253354);
                        return 2;
                    }
                    break;
                case -1710086618:
                    if (str.equals("liveHeartBeatSvrErr")) {
                        AppMethodBeat.o(253354);
                        return 4;
                    }
                    break;
                case -1170135445:
                    if (str.equals("liveHeartBeatBreak_manualRecovery")) {
                        AppMethodBeat.o(253354);
                        return 20;
                    }
                    break;
                case -895369361:
                    if (str.equals("cgiReportError")) {
                        AppMethodBeat.o(253354);
                        return 11;
                    }
                    break;
                case -775292920:
                    if (str.equals("opt_moov_fail")) {
                        AppMethodBeat.o(253354);
                        return 1;
                    }
                    break;
                case -485086917:
                    if (str.equals("liveVisitorUIParamsInvalid")) {
                        AppMethodBeat.o(253354);
                        return 6;
                    }
                    break;
                case -410791884:
                    if (str.equals("iconPreferenceError")) {
                        AppMethodBeat.o(253354);
                        return 15;
                    }
                    break;
                case -56891478:
                    if (str.equals("liveHeartBeatLocalErr")) {
                        AppMethodBeat.o(253354);
                        return 5;
                    }
                    break;
                case 3622727:
                    if (str.equals("liveCheckCommentMsgErr")) {
                        AppMethodBeat.o(253354);
                        return 10;
                    }
                    break;
                case 95743278:
                    if (str.equals("optimizeMP4VFS_fail")) {
                        AppMethodBeat.o(253354);
                        return 7;
                    }
                    break;
                case 207305279:
                    if (str.equals("finderStreamReturnInvalidFeed")) {
                        AppMethodBeat.o(253354);
                        return 15;
                    }
                    break;
                case 408071997:
                    if (str.equals("liveInvalidBadgeInfoColor")) {
                        AppMethodBeat.o(253354);
                        return 8;
                    }
                    break;
                case 1057368614:
                    if (str.equals("liveInitContentViewError")) {
                        AppMethodBeat.o(253354);
                        return 13;
                    }
                    break;
                case 1864591139:
                    if (str.equals("layoutIdError")) {
                        AppMethodBeat.o(253354);
                        return 3;
                    }
                    break;
            }
            if (BuildInfo.DEBUG) {
                RuntimeException runtimeException = new RuntimeException("this key[" + str + "] never define.");
                AppMethodBeat.o(253354);
                throw runtimeException;
            }
            AppMethodBeat.o(253354);
            return 0;
        }
    });

    @Override // com.tencent.mm.ac.f
    public final void a(String str, boolean z, boolean z2, boolean z3, a<String> aVar) {
        AppMethodBeat.i(253358);
        p.h(str, "key");
        p.h(aVar, "message");
        this.vVd.a(str, z, z2, z3, aVar);
        AppMethodBeat.o(253358);
    }

    @Override // com.tencent.mm.ac.f
    public final void b(String str, boolean z, boolean z2, boolean z3, a<String> aVar) {
        AppMethodBeat.i(253357);
        p.h(str, "key");
        p.h(aVar, "message");
        this.vVd.b(str, z, z2, z3, aVar);
        AppMethodBeat.o(253357);
    }

    static {
        AppMethodBeat.i(253356);
        AppMethodBeat.o(253356);
    }

    private c() {
        AppMethodBeat.i(253355);
        AppMethodBeat.o(253355);
    }
}
