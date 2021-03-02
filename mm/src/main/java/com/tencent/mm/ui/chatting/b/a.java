package com.tencent.mm.ui.chatting.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.choosemsgfile.compat.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.record.b.d;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.smtt.sdk.TbsListener;

public final class a implements b {
    @Override // com.tencent.mm.choosemsgfile.compat.b
    public final boolean a(ca caVar, c cVar) {
        AppMethodBeat.i(35056);
        boolean a2 = m.a(caVar, cVar);
        AppMethodBeat.o(35056);
        return a2;
    }

    @Override // com.tencent.mm.choosemsgfile.compat.b
    public final c s(String str, long j2) {
        AppMethodBeat.i(35057);
        c s = m.s(str, j2);
        AppMethodBeat.o(35057);
        return s;
    }

    @Override // com.tencent.mm.choosemsgfile.compat.b
    public final boolean a(final String str, ca caVar, final b.AbstractC0294b bVar) {
        AppMethodBeat.i(35058);
        if (Util.isNullOrNil(str) || caVar == null) {
            Log.e("MicroMsg.ChooseMsgFileCompat", "mediaId:%s or msg is null, err", str);
            AppMethodBeat.o(35058);
            return false;
        }
        AnonymousClass1 r3 = new i() {
            /* class com.tencent.mm.ui.chatting.b.a.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(35051);
                Log.i("MicroMsg.ChooseMsgFileCompat", "tryInitAttachInfo errType:%d errCode:%d, errMsg:%s type:%d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
                if (qVar.getType() != 728) {
                    AppMethodBeat.o(35051);
                    return;
                }
                d dVar = (d) qVar;
                if (!str.equals(dVar.getMediaId())) {
                    Log.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", str, dVar.getMediaId());
                    AppMethodBeat.o(35051);
                    return;
                }
                bg.azz().b(728, this);
                if (i2 == 0 && i3 == 0) {
                    if (bVar != null) {
                        bVar.u(0, "");
                        AppMethodBeat.o(35051);
                        return;
                    }
                } else if (bVar != null) {
                    bVar.u(i3, str);
                }
                AppMethodBeat.o(35051);
            }
        };
        bg.azz().a(728, r3);
        if (!(!m.e(str, caVar))) {
            bVar.u(0, "");
            bg.azz().b(728, r3);
        }
        AppMethodBeat.o(35058);
        return true;
    }

    @Override // com.tencent.mm.choosemsgfile.compat.b
    public final void a(c cVar) {
        AppMethodBeat.i(35059);
        if (cVar != null) {
            cVar.field_status = 101;
            cVar.field_lastModifyTime = Util.nowSecond();
            ao.cgO().a(cVar, new String[0]);
        }
        AppMethodBeat.o(35059);
    }

    @Override // com.tencent.mm.choosemsgfile.compat.b
    public final com.tencent.mm.vending.e.a a(final long j2, final String str, final b.a aVar) {
        AppMethodBeat.i(35060);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect() mediaId is null, return");
            AppMethodBeat.o(35060);
            return null;
        }
        bg.azz().a(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, new i() {
            /* class com.tencent.mm.ui.chatting.b.a.AnonymousClass2 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(35052);
                Log.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect errType:%d errCode:%d, errMsg:%s type:%d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
                if (qVar.getType() != 221) {
                    AppMethodBeat.o(35052);
                    return;
                }
                f fVar = (f) qVar;
                if (!str.equals(fVar.getMediaId())) {
                    Log.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", str, fVar.getMediaId());
                    AppMethodBeat.o(35052);
                    return;
                }
                bg.azz().b(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this);
                if (i2 == 0 && i3 == 0) {
                    int i4 = fVar.retCode;
                    Log.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect retCode:%d", Integer.valueOf(i4));
                    if (i4 < 0 && aVar != null) {
                        aVar.t(i4, "");
                    }
                    AppMethodBeat.o(35052);
                    return;
                }
                c s = m.s(str, j2);
                if (s == null || s.field_status != 102) {
                    if (aVar != null) {
                        aVar.t(-1, str);
                    }
                    AppMethodBeat.o(35052);
                    return;
                }
                if (aVar != null) {
                    aVar.t(1, str);
                }
                AppMethodBeat.o(35052);
            }
        });
        final f fVar = new f(j2, str, new j() {
            /* class com.tencent.mm.ui.chatting.b.a.AnonymousClass3 */

            @Override // com.tencent.mm.ak.j
            public final void a(int i2, int i3, q qVar) {
                AppMethodBeat.i(35053);
                if (aVar != null) {
                    aVar.cs(i2, i3);
                }
                if (i2 >= i3 && aVar != null) {
                    aVar.t(0, "");
                }
                AppMethodBeat.o(35053);
            }
        });
        bg.azz().a(fVar, 0);
        AnonymousClass4 r0 = new com.tencent.mm.vending.e.a() {
            /* class com.tencent.mm.ui.chatting.b.a.AnonymousClass4 */

            @Override // com.tencent.mm.vending.e.a
            public final void dead() {
                AppMethodBeat.i(35054);
                fVar.a(null);
                g.azz().a(fVar);
                AppMethodBeat.o(35054);
            }
        };
        AppMethodBeat.o(35060);
        return r0;
    }

    @Override // com.tencent.mm.choosemsgfile.compat.b
    public final boolean j(ca caVar) {
        AppMethodBeat.i(35061);
        boolean j2 = com.tencent.mm.ui.chatting.gallery.b.j(caVar);
        AppMethodBeat.o(35061);
        return j2;
    }

    @Override // com.tencent.mm.choosemsgfile.compat.b
    public final com.tencent.mm.av.g k(ca caVar) {
        AppMethodBeat.i(35062);
        com.tencent.mm.av.g k = com.tencent.mm.ui.chatting.gallery.d.k(caVar);
        AppMethodBeat.o(35062);
        return k;
    }

    @Override // com.tencent.mm.choosemsgfile.compat.b
    public final String a(ca caVar, com.tencent.mm.av.g gVar) {
        AppMethodBeat.i(35063);
        String a2 = com.tencent.mm.ui.chatting.gallery.d.a(caVar, gVar);
        AppMethodBeat.o(35063);
        return a2;
    }

    @Override // com.tencent.mm.choosemsgfile.compat.b
    public final String l(ca caVar) {
        AppMethodBeat.i(35064);
        String l = com.tencent.mm.ui.chatting.gallery.b.l(caVar);
        AppMethodBeat.o(35064);
        return l;
    }

    @Override // com.tencent.mm.choosemsgfile.compat.b
    public final void a(ca caVar, final b.a aVar) {
        AppMethodBeat.i(35065);
        m.a(caVar, new m.a() {
            /* class com.tencent.mm.ui.chatting.b.a.AnonymousClass5 */

            @Override // com.tencent.mm.pluginsdk.model.app.m.a
            public final void kA(int i2, int i3) {
                AppMethodBeat.i(35055);
                if (aVar != null) {
                    aVar.cs(i2, i3);
                }
                if (i2 >= i3 && aVar != null) {
                    aVar.t(0, "");
                }
                AppMethodBeat.o(35055);
            }
        });
        AppMethodBeat.o(35065);
    }

    @Override // com.tencent.mm.choosemsgfile.compat.b
    public final boolean m(ca caVar) {
        AppMethodBeat.i(35066);
        boolean m = com.tencent.mm.ui.chatting.gallery.b.m(caVar);
        AppMethodBeat.o(35066);
        return m;
    }
}
