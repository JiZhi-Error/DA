package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.support.constraint.ConstraintLayout;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.z;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.b.a.gf;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.n;
import com.tencent.mm.ui.chatting.o;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.wework.api.IWWAPI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@a(gRF = l.class)
public class m extends a implements z, l {
    public static QueueWorkerThread PnZ = new QueueWorkerThread(5, "MicroMsg.ChattingMoreBtnBarHelper");
    private Animation Dog;
    private boolean Pdm;
    private String PjI = "";
    private boolean PlM = false;
    private ChattingFooterMoreBtnBar Poa;
    private boolean Pob = true;
    private as dSh;
    private s gzP;
    private boolean hasInit = false;

    static {
        AppMethodBeat.i(35233);
        AppMethodBeat.o(35233);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.l
    public final void bW(ca caVar) {
        AppMethodBeat.i(35226);
        if (caVar == null) {
            Log.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
            AppMethodBeat.o(35226);
            return;
        }
        k kVar = (k) this.dom.bh(k.class);
        if (kVar.Nu(caVar.field_msgId)) {
            this.Poa.amj(kVar.eGR());
            this.Poa.setVisibility(0);
            this.gzP.gXP();
        }
        AppMethodBeat.o(35226);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.l
    public final List<ca> gPy() {
        AppMethodBeat.i(169864);
        LinkedList linkedList = new LinkedList();
        for (Long l : ((k) this.dom.bh(k.class)).gOs()) {
            long longValue = l.longValue();
            Log.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", Long.valueOf(longValue));
            bg.aVF();
            linkedList.add(c.aSQ().Hb(longValue));
        }
        Collections.sort(linkedList, new Comparator<ca>() {
            /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass7 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(ca caVar, ca caVar2) {
                AppMethodBeat.i(35221);
                int compare = Long.compare(caVar.field_createTime, caVar2.field_createTime);
                AppMethodBeat.o(35221);
                return compare;
            }
        });
        AppMethodBeat.o(169864);
        return linkedList;
    }

    @Override // com.tencent.mm.ag.z
    public final void b(z.a aVar) {
    }

    @Override // com.tencent.mm.ui.chatting.d.b.l
    public final boolean gPB() {
        return this.PlM;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.l
    public final void gPC() {
        AppMethodBeat.i(35229);
        if (this.gzP != null) {
            this.gzP.gXP();
            this.gzP.Qwi = null;
        }
        AppMethodBeat.o(35229);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(169865);
        super.gOK();
        if (this.PlM) {
            gPz();
        }
        AppMethodBeat.o(169865);
    }

    @Override // com.tencent.mm.ag.z
    public final void a(z.a aVar) {
        AppMethodBeat.i(35230);
        gPz();
        AppMethodBeat.o(35230);
    }

    @Override // com.tencent.mm.ag.z
    public final void c(z.a aVar) {
        AppMethodBeat.i(35231);
        gPz();
        AppMethodBeat.o(35231);
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSC() {
        return this.Pob;
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSD() {
        return false;
    }

    @Override // com.tencent.mm.ag.z
    public final void B(Bundle bundle) {
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSE() {
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.l
    public final void bV(ca caVar) {
        AppMethodBeat.i(35225);
        if (this.hasInit) {
            Log.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
        } else {
            this.hasInit = true;
            if (this.Poa == null) {
                ((ViewStub) this.dom.findViewById(R.id.j7u)).inflate();
                this.Poa = (ChattingFooterMoreBtnBar) this.dom.findViewById(R.id.av_);
            }
            if (((am) this.dom.bh(am.class)).gRd()) {
                Log.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
                if (this.gzP != null) {
                    this.gzP.Qwi = null;
                }
            } else {
                this.gzP = new s((byte) 0);
                this.gzP.Qwi = new s.b() {
                    /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass8 */
                    String heA = null;

                    @Override // com.tencent.mm.ui.tools.s.b
                    public final void SO(String str) {
                        AppMethodBeat.i(35222);
                        Log.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
                        am amVar = (am) m.this.dom.bh(am.class);
                        if (!Util.isNullOrNil(str)) {
                            Log.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                            m.this.Poa.setVisibility(8);
                            amVar.gQV();
                            if (amVar.gQY() != null) {
                                amVar.gQY().SM(str);
                            }
                        } else if (amVar.gRd()) {
                            if (amVar.gQY() != null) {
                                amVar.gQY().SM("");
                            }
                            amVar.amE(-1);
                        } else if (!m.this.PlM) {
                            amVar.gQW();
                            m.this.Poa.setVisibility(8);
                        } else if (this.heA != null) {
                            amVar.gQW();
                            m.this.Poa.setVisibility(0);
                            m.this.Poa.amj(((k) m.this.dom.bh(k.class)).eGR());
                        }
                        this.heA = str;
                        AppMethodBeat.o(35222);
                    }

                    @Override // com.tencent.mm.ui.tools.s.b
                    public final void bny() {
                        AppMethodBeat.i(35223);
                        Log.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
                        k kVar = (k) m.this.dom.bh(k.class);
                        if (kVar.isInEditMode()) {
                            ((am) m.this.dom.bh(am.class)).gQW();
                            m.this.Poa.setVisibility(0);
                            m.this.Poa.amj(kVar.eGR());
                        }
                        m.this.dom.Pwc.getController().supportInvalidateOptionsMenu();
                        AppMethodBeat.o(35223);
                    }

                    @Override // com.tencent.mm.ui.tools.s.b
                    public final void bnz() {
                        AppMethodBeat.i(35224);
                        Log.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
                        h.INSTANCE.idkeyStat(219, 21, 1, true);
                        if (((k) m.this.dom.bh(k.class)).isInEditMode()) {
                            ((am) m.this.dom.bh(am.class)).gQV();
                            m.this.Poa.setVisibility(8);
                        }
                        AppMethodBeat.o(35224);
                    }

                    @Override // com.tencent.mm.ui.tools.s.b
                    public final boolean SN(String str) {
                        return false;
                    }

                    @Override // com.tencent.mm.ui.tools.s.b
                    public final void bnA() {
                    }

                    @Override // com.tencent.mm.ui.tools.s.b
                    public final void bnB() {
                    }
                };
            }
            this.Poa.b(3, new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(35197);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    final k kVar = (k) m.this.dom.bh(k.class);
                    if (kVar.eGR() == 0) {
                        Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(35197);
                        return;
                    }
                    final Activity context = m.this.dom.Pwc.getContext();
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.string.b91), "", context.getString(R.string.blj), context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass2.AnonymousClass1 */

                        /* JADX WARNING: Removed duplicated region for block: B:32:0x0082 A[EDGE_INSN: B:32:0x0082->B:19:0x0082 ?: BREAK  , SYNTHETIC] */
                        /* JADX WARNING: Removed duplicated region for block: B:5:0x0042  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void onClick(android.content.DialogInterface r15, int r16) {
                            /*
                            // Method dump skipped, instructions count: 205
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.m.AnonymousClass2.AnonymousClass1.onClick(android.content.DialogInterface, int):void");
                        }
                    }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(35197);
                }
            });
            this.Poa.b(2, new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(35198);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (((k) m.this.dom.bh(k.class)).eGR() == 0) {
                        Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(35198);
                        return;
                    }
                    n.a(m.this.dom, m.this.gPy(), m.this.Pdm, m.this, m.this.dSh);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(35198);
                }
            });
            this.Poa.b(1, new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(35199);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    k kVar = (k) m.this.dom.bh(k.class);
                    if (kVar == null || kVar.eGR() == 0) {
                        Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(35199);
                        return;
                    }
                    List<ca> gPy = m.this.gPy();
                    if (com.tencent.mm.ui.chatting.k.jj(gPy)) {
                        com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(R.string.bin), "", m.this.dom.Pwc.getContext().getString(R.string.f3148e), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass4.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(35199);
                    } else if (com.tencent.mm.ui.chatting.k.jk(gPy)) {
                        com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(R.string.bio), "", m.this.dom.Pwc.getContext().getString(R.string.f3148e), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass4.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(35199);
                    } else if (com.tencent.mm.ui.chatting.k.ji(gPy)) {
                        com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(R.string.bip), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass4.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }, (DialogInterface.OnClickListener) null);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(35199);
                    } else {
                        if (o.a(m.this.dom, gPy, m.this.dSh)) {
                            m.this.gPz();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(35199);
                    }
                }
            });
            this.Poa.b(0, new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass5 */

                public final void onClick(final View view) {
                    AppMethodBeat.i(35202);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (((k) m.this.dom.bh(k.class)).eGR() == 0) {
                        Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(35202);
                        return;
                    }
                    if ((!ab.IT(m.this.dSh.field_username) || g.DQ(m.this.dSh.field_username)) && !ab.JF(m.this.dSh.field_username)) {
                        com.tencent.mm.plugin.selectrecord.b.b.eSA();
                        e eVar = new e((Context) m.this.dom.Pwc.getContext(), 1, false);
                        eVar.HLX = new o.f() {
                            /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass5.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                                AppMethodBeat.i(35200);
                                mVar.kV(0, R.string.f52);
                                mVar.kV(1, R.string.f53);
                                if (ao.a(m.this.dom.Pwc.getContext(), IWWAPI.WWAppType.WwAppTypeWxwork)) {
                                    mVar.d(2, m.this.dom.Pwc.getContext().getString(R.string.f54, new Object[]{ao.b(m.this.dom.Pwc.getContext(), IWWAPI.WWAppType.WwAppTypeWxwork)}));
                                }
                                if (ao.a(m.this.dom.Pwc.getContext(), IWWAPI.WWAppType.WwAppTypeLocal)) {
                                    mVar.d(3, m.this.dom.Pwc.getContext().getString(R.string.f54, new Object[]{ao.b(m.this.dom.Pwc.getContext(), IWWAPI.WWAppType.WwAppTypeLocal)}));
                                }
                                AppMethodBeat.o(35200);
                            }
                        };
                        eVar.HLY = new o.g() {
                            /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass5.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                AppMethodBeat.i(35201);
                                final List<ca> gPy = m.this.gPy();
                                com.tencent.mm.plugin.selectrecord.b.b eSz = com.tencent.mm.plugin.selectrecord.b.b.eSz();
                                eSz.CXf.eJj = (long) gPy.size();
                                int i3 = 0;
                                int i4 = 0;
                                int i5 = 0;
                                int i6 = 0;
                                int i7 = 0;
                                int i8 = 0;
                                int i9 = 0;
                                int i10 = 0;
                                int i11 = 0;
                                int i12 = 0;
                                for (ca caVar : gPy) {
                                    switch (caVar.getType()) {
                                        case 1:
                                        case 11:
                                        case 21:
                                        case 31:
                                        case 36:
                                        case 301989937:
                                            i4++;
                                            break;
                                        case 3:
                                        case 13:
                                        case 23:
                                        case 33:
                                        case 39:
                                        case 268435505:
                                            i5++;
                                            break;
                                        case 34:
                                            i6++;
                                            break;
                                        case 42:
                                        case 66:
                                            i8++;
                                            break;
                                        case 43:
                                        case 44:
                                        case 62:
                                            i7++;
                                            break;
                                        case 47:
                                            i9++;
                                            break;
                                        case 49:
                                            k.b HD = k.b.HD(caVar.field_content);
                                            if (HD == null) {
                                                break;
                                            } else {
                                                switch (HD.type) {
                                                    case 1:
                                                    case 53:
                                                    case com.tencent.mm.plugin.appbrand.jsapi.pay.n.CTRL_INDEX:
                                                        i4++;
                                                        continue;
                                                    case 4:
                                                        i7++;
                                                        continue;
                                                    case 6:
                                                        i10++;
                                                        continue;
                                                    case 19:
                                                        i11++;
                                                        continue;
                                                    case 33:
                                                    case 36:
                                                    case 44:
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                                                        i12++;
                                                        continue;
                                                    case 1048625:
                                                        i9++;
                                                        continue;
                                                    default:
                                                        i3++;
                                                        continue;
                                                }
                                            }
                                        default:
                                            i3++;
                                            break;
                                    }
                                }
                                String str = i3 + ";" + i4 + ";" + i5 + ";" + i6 + ";" + i7 + ";" + i8 + ";" + i9 + ";" + i10 + ";" + i11 + ";" + i12 + ";";
                                gf gfVar = eSz.CXf;
                                gfVar.eJk = gfVar.x("FinalShareCountByType", str, true);
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        com.tencent.mm.plugin.selectrecord.b.b.eSz().IH(2);
                                        if (gPy.size() > 31) {
                                            com.tencent.mm.ui.base.h.c(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(R.string.hrl), "", m.this.dom.Pwc.getContext().getString(R.string.f53), m.this.dom.Pwc.getContext().getString(R.string.sz), new DialogInterface.OnClickListener() {
                                                /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass5.AnonymousClass2.AnonymousClass1 */

                                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                                    AppMethodBeat.i(233072);
                                                    Log.i("MicroMsg.ChattingMoreBtnBarHelper", "MENU_ID_SEND_NORMAL to MENU_ID_SEND_RECORD");
                                                    AnonymousClass5.a(AnonymousClass5.this, gPy);
                                                    AppMethodBeat.o(233072);
                                                }
                                            }, new DialogInterface.OnClickListener() {
                                                /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass5.AnonymousClass2.AnonymousClass2 */

                                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                                    AppMethodBeat.i(233073);
                                                    Log.i("MicroMsg.ChattingMoreBtnBarHelper", "MENU_ID_SEND_NORMAL onCancel");
                                                    AppMethodBeat.o(233073);
                                                }
                                            });
                                            AppMethodBeat.o(35201);
                                            return;
                                        }
                                        m.this.Pob = true;
                                        if (!com.tencent.mm.ui.chatting.l.a(m.this.dom.Pwc.getContext(), gPy, m.this.Pdm, m.this.dSh.field_username, m.this)) {
                                            com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
                                            AppMethodBeat.o(35201);
                                            return;
                                        }
                                        break;
                                    case 1:
                                        AnonymousClass5.a(AnonymousClass5.this, gPy);
                                        AppMethodBeat.o(35201);
                                        return;
                                    case 2:
                                        if (WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(view.getContext())) {
                                            com.tencent.mm.plugin.selectrecord.b.b.eSz().IH(3);
                                            if (!ao.a(m.this.dom.Pwc.getContext(), m.this.dSh, gPy, m.this.Pdm, IWWAPI.WWAppType.WwAppTypeWxwork)) {
                                                com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
                                            }
                                            m.this.gPz();
                                            AppMethodBeat.o(35201);
                                            return;
                                        }
                                        break;
                                    case 3:
                                        if (WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(view.getContext())) {
                                            com.tencent.mm.plugin.selectrecord.b.b.eSz().IH(3);
                                            if (!ao.a(m.this.dom.Pwc.getContext(), m.this.dSh, gPy, m.this.Pdm, IWWAPI.WWAppType.WwAppTypeLocal)) {
                                                com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
                                            }
                                            m.this.gPz();
                                            break;
                                        }
                                        break;
                                }
                                AppMethodBeat.o(35201);
                            }
                        };
                        eVar.PGl = new e.b() {
                            /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass5.AnonymousClass3 */

                            @Override // com.tencent.mm.ui.widget.a.e.b
                            public final void onDismiss() {
                                AppMethodBeat.i(233074);
                                com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
                                AppMethodBeat.o(233074);
                            }
                        };
                        eVar.dGm();
                    } else {
                        m.this.Pob = true;
                        com.tencent.mm.ui.chatting.l.a(m.this.dom.Pwc.getContext(), m.this.gPy(), m.this.Pdm, m.this.dSh.field_username, m.this);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(35202);
                }

                static /* synthetic */ void a(AnonymousClass5 r5, List list) {
                    AppMethodBeat.i(233075);
                    m.this.Pob = false;
                    com.tencent.mm.plugin.selectrecord.b.b.eSz().IH(1);
                    if (!com.tencent.mm.ui.chatting.l.a(m.this.dom.Pwc.getContext(), list, m.this.Pdm, m.this.dSh.field_username, m.this)) {
                        com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
                    }
                    AppMethodBeat.o(233075);
                }
            });
            this.Poa.b(4, new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass6 */

                static /* synthetic */ void a(AnonymousClass6 r1, cz czVar) {
                    AppMethodBeat.i(35219);
                    r1.c(czVar);
                    AppMethodBeat.o(35219);
                }

                static /* synthetic */ void a(AnonymousClass6 r1, HashSet hashSet) {
                    AppMethodBeat.i(35218);
                    r1.g(hashSet);
                    AppMethodBeat.o(35218);
                }

                static /* synthetic */ void jp(List list) {
                    AppMethodBeat.i(35220);
                    jo(list);
                    AppMethodBeat.o(35220);
                }

                private void c(cz czVar) {
                    k.b HD;
                    AppMethodBeat.i(35212);
                    List<ca> gPy = m.this.gPy();
                    for (ca caVar : gPy) {
                        if (!ac.bB(caVar)) {
                            com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(R.string.c89), "", m.this.dom.Pwc.getContext().getString(R.string.j34), (DialogInterface.OnClickListener) null);
                            AppMethodBeat.o(35212);
                            return;
                        }
                    }
                    long aqs = (long) com.tencent.mm.n.c.aqs();
                    com.tencent.mm.ui.chatting.h hVar = com.tencent.mm.ui.chatting.h.Pgg;
                    if (com.tencent.mm.ui.chatting.h.i(gPy, aqs)) {
                        com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(R.string.ce4, new Object[]{Util.getSizeKB(aqs)}), "", m.this.dom.Pwc.getContext().getString(R.string.j34), (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(35212);
                        return;
                    }
                    long aqu = com.tencent.mm.n.c.aqu();
                    com.tencent.mm.ui.chatting.h hVar2 = com.tencent.mm.ui.chatting.h.Pgg;
                    if (com.tencent.mm.ui.chatting.h.h(gPy, aqu)) {
                        com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(R.string.ce5, new Object[]{Util.getSizeKB(aqu)}), "", m.this.dom.Pwc.getContext().getString(R.string.j34), (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(35212);
                        return;
                    }
                    czVar.dFZ.fragment = m.this.dom.Pwc;
                    czVar.dFZ.dGf = 41;
                    czVar.dFZ.dGh = new a.c() {
                        /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass6.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.snackbar.a.c
                        public final void onShow() {
                            AppMethodBeat.i(35203);
                            m.this.gPz();
                            m.this.Poa.setVisibility(4);
                            AppMethodBeat.o(35203);
                        }

                        @Override // com.tencent.mm.ui.widget.snackbar.a.c
                        public final void onHide() {
                            AppMethodBeat.i(35204);
                            m.this.gPz();
                            AppMethodBeat.o(35204);
                        }

                        @Override // com.tencent.mm.ui.widget.snackbar.a.c
                        public final void bDY() {
                            AppMethodBeat.i(35205);
                            ((u) m.this.dom.bh(u.class)).gPW();
                            AppMethodBeat.o(35205);
                        }
                    };
                    EventCenter.instance.publish(czVar);
                    int i2 = czVar.dGa.ret == 0 ? 1 : 2;
                    long nowSecond = Util.nowSecond();
                    for (ca caVar2 : gPy) {
                        if (caVar2.dOQ() && (HD = k.b.HD(Util.processXml(caVar2.field_content))) != null && HD.type == 5 && !Util.isNullOrNil(HD.url)) {
                            int i3 = caVar2.gAt() ? 1 : 2;
                            Log.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", 13378, HD.url, Long.valueOf(nowSecond), Integer.valueOf(i3), 2, 1);
                            String str = "";
                            try {
                                str = URLEncoder.encode(HD.url, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                            } catch (UnsupportedEncodingException e2) {
                                Log.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", e2, "", new Object[0]);
                            }
                            h.INSTANCE.a(13378, str, Long.valueOf(nowSecond), Integer.valueOf(i3), 2, Integer.valueOf(i2));
                        }
                    }
                    if (czVar.dGa.ret == 0) {
                        if (14 != czVar.dFZ.type) {
                            Log.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                            AppMethodBeat.o(35212);
                            return;
                        } else if (czVar.dFZ.dGc == null) {
                            Log.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                            AppMethodBeat.o(35212);
                            return;
                        } else {
                            h.INSTANCE.a(11142, Integer.valueOf(czVar.dFZ.dGc.Lyp), Integer.valueOf(czVar.dFZ.dGc.Lyq), Integer.valueOf(czVar.dFZ.dGc.Lyr), Integer.valueOf(czVar.dFZ.dGc.xiP), Integer.valueOf(czVar.dFZ.dGc.Lys), Integer.valueOf(czVar.dFZ.dGc.Lyt), Integer.valueOf(czVar.dFZ.dGc.Lyu), Integer.valueOf(czVar.dFZ.dGc.fileCount), Integer.valueOf(czVar.dFZ.dGc.Lyv), Integer.valueOf(czVar.dFZ.dGc.Lyw), Integer.valueOf(czVar.dFZ.dGc.Lyx), Integer.valueOf(czVar.dFZ.dGc.Lyy), Integer.valueOf(czVar.dFZ.dGc.Lyz), Integer.valueOf(czVar.dFZ.dGc.LyA), Integer.valueOf(czVar.dFZ.dGc.LyB));
                        }
                    }
                    AppMethodBeat.o(35212);
                }

                private static String jn(List<ca> list) {
                    AppMethodBeat.i(35213);
                    StringBuffer stringBuffer = new StringBuffer();
                    for (ca caVar : list) {
                        stringBuffer.append(caVar.field_msgId);
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    AppMethodBeat.o(35213);
                    return stringBuffer2;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:14:0x00a6, code lost:
                    r1 = com.tencent.mm.pluginsdk.model.app.m.c(r7, r0.dCK);
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onClick(android.view.View r15) {
                    /*
                    // Method dump skipped, instructions count: 648
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.m.AnonymousClass6.onClick(android.view.View):void");
                }

                private void g(HashSet<Long> hashSet) {
                    AppMethodBeat.i(35215);
                    if (hashSet.isEmpty()) {
                        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass6.AnonymousClass5 */

                            public final void run() {
                                AppMethodBeat.i(35210);
                                AnonymousClass6.this.gPD();
                                AppMethodBeat.o(35210);
                            }
                        });
                    }
                    AppMethodBeat.o(35215);
                }

                public final void gPD() {
                    String string;
                    String string2;
                    ca caVar;
                    AppMethodBeat.i(35216);
                    m.this.PjI = "";
                    final List<ca> gPy = m.this.gPy();
                    if (com.tencent.mm.ui.chatting.k.jj(gPy)) {
                        com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(R.string.c_g), "", m.this.dom.Pwc.getContext().getString(R.string.f3148e), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass6.AnonymousClass6 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        AppMethodBeat.o(35216);
                        return;
                    }
                    final cz czVar = new cz();
                    Log.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", m.this.dSh.field_username);
                    if (gPy.size() == 1 && (caVar = gPy.get(0)) != null && (caVar.dOQ() || caVar.gAt())) {
                        String JX = ad.JX(new StringBuilder().append(caVar.field_msgSvrId).toString());
                        ad.b G = ad.aVe().G(JX, true);
                        G.l("prePublishId", "msg_" + caVar.field_msgSvrId);
                        G.l("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(caVar, m.this.Pdm, ((d) m.this.dom.bh(d.class)).gOP()));
                        G.l("preChatName", m.this.dSh.field_username);
                        G.l("preMsgIndex", 0);
                        G.l("sendAppMsgScene", 1);
                        ((j) com.tencent.mm.kernel.g.af(j.class)).a("adExtStr", G, caVar);
                        czVar.dFZ.sessionId = JX;
                    }
                    if (com.tencent.mm.pluginsdk.model.j.a(m.this.dom.Pwc.getContext(), czVar, m.this.dSh.field_username, gPy, true)) {
                        for (ca caVar2 : gPy) {
                            if (caVar2.dOQ()) {
                                com.tencent.mm.modelstat.b.jmd.c(caVar2, com.tencent.mm.ag.l.t(caVar2));
                            } else {
                                com.tencent.mm.modelstat.b.jmd.ac(caVar2);
                            }
                        }
                        c(czVar);
                        jo(m.this.gPy());
                        AppMethodBeat.o(35216);
                    } else if (m.this.gPy().size() > 1) {
                        Activity context = m.this.dom.Pwc.getContext();
                        if (czVar.dFZ.dGe >= 0) {
                            string = m.this.dom.Pwc.getContext().getString(R.string.c_f);
                        } else {
                            string = m.this.dom.Pwc.getContext().getString(R.string.c_e);
                        }
                        if (czVar.dFZ.dGe >= 0) {
                            string2 = m.this.dom.Pwc.getContext().getString(R.string.b98);
                        } else {
                            string2 = m.this.dom.Pwc.getContext().getString(R.string.fn9);
                        }
                        com.tencent.mm.ui.base.h.c(context, string, "", string2, m.this.dom.Pwc.getContext().getString(R.string.b96), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass6.AnonymousClass7 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(35211);
                                for (ca caVar : gPy) {
                                    if (!(caVar.gDo() || caVar.gDn())) {
                                        if (czVar.dFZ.type == 14 && czVar.dFZ.dGb.ppH.size() == 0) {
                                            m.this.gPz();
                                            AppMethodBeat.o(35211);
                                            return;
                                        }
                                        AnonymousClass6.a(AnonymousClass6.this, czVar);
                                        AnonymousClass6.jp(m.this.gPy());
                                        AppMethodBeat.o(35211);
                                        return;
                                    }
                                }
                                AppMethodBeat.o(35211);
                            }
                        }, null);
                        AppMethodBeat.o(35216);
                    } else {
                        com.tencent.mm.ui.base.h.n(m.this.dom.Pwc.getContext(), czVar.dFZ.dGe, 0);
                        AppMethodBeat.o(35216);
                    }
                }

                private static void jo(List<ca> list) {
                    AppMethodBeat.i(35217);
                    for (ca caVar : list) {
                        com.tencent.mm.ui.chatting.a.a(a.c.Fav, a.d.Samll, caVar, 0);
                    }
                    AppMethodBeat.o(35217);
                }
            });
            this.Dog = AnimationUtils.loadAnimation(this.dom.Pwc.getContext(), R.anim.dq);
            ((com.tencent.mm.ui.chatting.d.b.k) this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).i(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.m.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(35195);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.ui.chatting.d.b.k kVar = (com.tencent.mm.ui.chatting.d.b.k) m.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
                    if (kVar.Nu(((Long) view.getTag()).longValue())) {
                        int eGR = kVar.eGR();
                        ((am) m.this.dom.bh(am.class)).gQW();
                        m.this.gzP.gXP();
                        m.this.Poa.setVisibility(0);
                        m.this.Poa.amj(eGR);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(35195);
                }
            });
        }
        this.dSh = this.dom.GUe;
        this.Pdm = this.dom.gRL() || ((d) this.dom.bh(d.class)).gOQ();
        this.Poa.eer();
        this.dom.Pwc.getController().addSearchMenu(true, this.gzP);
        if (this.Poa != null) {
            this.Poa.startAnimation(this.Dog);
            this.Poa.setVisibility(0);
        }
        this.PlM = true;
        ((am) this.dom.bh(am.class)).gQW();
        com.tencent.mm.ui.chatting.d.b.k kVar = (com.tencent.mm.ui.chatting.d.b.k) this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
        kVar.gOu();
        kVar.gOt();
        kVar.Nu(caVar.field_msgId);
        this.Poa.amj(kVar.eGR());
        ((p) this.dom.bh(p.class)).gPM();
        this.dom.hideVKB();
        gPA();
        ((u) this.dom.bh(u.class)).gPX();
        h.INSTANCE.a(10811, 1);
        if (this.dSh.gBM()) {
            com.tencent.mm.ui.chatting.e.a aVar = this.dom;
            Log.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", Integer.valueOf((int) R.id.fdi));
            aVar.Pwd.removeOptionMenu(R.id.fdi);
        }
        ((com.tencent.mm.ui.chatting.d.b.ab) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).gQB();
        AppMethodBeat.o(35225);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.l
    public final void gPz() {
        AppMethodBeat.i(35227);
        this.dom.Pwc.getController().addSearchMenu(false, this.gzP);
        if (this.Poa != null) {
            this.Poa.setVisibility(8);
        }
        ((com.tencent.mm.ui.chatting.d.b.k) this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).cVM();
        ((d) this.dom.bh(d.class)).gPd();
        ((am) this.dom.bh(am.class)).gQW();
        this.PlM = false;
        gPA();
        ((p) this.dom.bh(p.class)).fjK();
        ((u) this.dom.bh(u.class)).gPX();
        this.dom.hideVKB();
        com.tencent.mm.ui.chatting.l.gNy();
        AppMethodBeat.o(35227);
    }

    private void gPA() {
        AppMethodBeat.i(35228);
        if (this.PlM) {
            this.dom.showOptionMenu(false);
        } else {
            ((aa) this.dom.bh(aa.class)).gQp();
        }
        ((aw) this.dom.bh(aw.class)).gRy();
        AppMethodBeat.o(35228);
    }
}
