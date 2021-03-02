package com.tencent.mm.plugin.wallet_core.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.f;

public final class c {
    public boolean IoO = false;
    MMActivity activity;

    public interface a {
        void a(cfl cfl);
    }

    public c(MMActivity mMActivity) {
        this.activity = mMActivity;
    }

    public static boolean a(b bVar) {
        if (bVar == null || bVar.IoN == 0) {
            return false;
        }
        return true;
    }

    public static boolean a(cdh cdh) {
        if (cdh == null || cdh.IoN == 0) {
            return false;
        }
        return true;
    }

    public final void b(b bVar) {
        AppMethodBeat.i(214257);
        a(bVar, new a() {
            /* class com.tencent.mm.plugin.wallet_core.utils.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.utils.c.a
            public final void a(cfl cfl) {
            }
        });
        AppMethodBeat.o(214257);
    }

    public final void a(final b bVar, final a aVar) {
        AppMethodBeat.i(214258);
        if (bVar.IoN == 1) {
            h.a((Context) this.activity, bVar.dQx, "", bVar.IoL.dQx, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.utils.c.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(214251);
                    aVar.a(bVar.IoL);
                    c.a(c.this, bVar.IoL);
                    AppMethodBeat.o(214251);
                }
            });
            AppMethodBeat.o(214258);
            return;
        }
        if (bVar.IoN == 2) {
            h.a((Context) this.activity, bVar.dQx, "", bVar.IoM.dQx, bVar.IoL.dQx, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.utils.c.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(214252);
                    aVar.a(bVar.IoM);
                    c.a(c.this, bVar.IoM);
                    AppMethodBeat.o(214252);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.utils.c.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(214253);
                    aVar.a(bVar.IoL);
                    c.a(c.this, bVar.IoL);
                    AppMethodBeat.o(214253);
                }
            });
        }
        AppMethodBeat.o(214258);
    }

    public final void b(cdh cdh) {
        AppMethodBeat.i(214259);
        a(cdh, new a() {
            /* class com.tencent.mm.plugin.wallet_core.utils.c.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.wallet_core.utils.c.a
            public final void a(cfl cfl) {
            }
        });
        AppMethodBeat.o(214259);
    }

    private void a(final cdh cdh, final a aVar) {
        AppMethodBeat.i(214260);
        if (cdh.IoN == 1) {
            h.a((Context) this.activity, cdh.dQx, "", cdh.IoL.dQx, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.utils.c.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(214254);
                    aVar.a(cdh.IoL);
                    c.a(c.this, cdh.IoL);
                    AppMethodBeat.o(214254);
                }
            });
            AppMethodBeat.o(214260);
            return;
        }
        if (cdh.IoN == 2) {
            h.a((Context) this.activity, cdh.dQx, "", cdh.IoM.dQx, cdh.IoL.dQx, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.utils.c.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(214255);
                    aVar.a(cdh.IoL);
                    c.a(c.this, cdh.IoM);
                    AppMethodBeat.o(214255);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.utils.c.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(214256);
                    aVar.a(cdh.IoL);
                    c.a(c.this, cdh.IoL);
                    AppMethodBeat.o(214256);
                }
            });
        }
        AppMethodBeat.o(214260);
    }

    static /* synthetic */ void a(c cVar, cfl cfl) {
        AppMethodBeat.i(214261);
        if (cfl != null) {
            if (cfl.action == 3) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", cfl.url);
                f.aA(cVar.activity, intent);
            } else if (cfl.action == 4) {
                wq wqVar = new wq();
                wqVar.ecI.userName = cfl.username;
                wqVar.ecI.ecK = cfl.Cqk;
                wqVar.ecI.scene = 1034;
                wqVar.ecI.ecL = 0;
                EventCenter.instance.publish(wqVar);
            }
            if (cVar.IoO) {
                cVar.activity.finish();
            }
        }
        AppMethodBeat.o(214261);
    }
}
