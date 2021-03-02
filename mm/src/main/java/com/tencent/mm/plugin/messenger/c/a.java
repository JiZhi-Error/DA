package com.tencent.mm.plugin.messenger.c;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.d.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a extends b implements i {
    private ProgressDialog gtM = null;
    String lJj;
    long msgId;
    WeakReference<Context> nhy;
    String zqA;
    String zqB;
    String zqC;
    com.tencent.mm.plugin.messenger.b.a zqx;
    String zqy;
    String zqz;

    public a(b.AbstractC1472b bVar) {
        super(bVar);
        AppMethodBeat.i(194484);
        g.azz().a(3713, this);
        AppMethodBeat.o(194484);
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final String eiT() {
        return "new_link_succeed_contact";
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final void release() {
        AppMethodBeat.i(194485);
        super.release();
        g.azz().b(3713, this);
        AppMethodBeat.o(194485);
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final CharSequence b(final Map<String, String> map, final String str, final Bundle bundle, final WeakReference<Context> weakReference, final WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.i(194486);
        if (map == null) {
            AppMethodBeat.o(194486);
            return null;
        }
        final String string = bundle != null ? bundle.getString("conv_talker_username") : "";
        String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
        SpannableString spannableString = new SpannableString(nullAsNil);
        spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
            /* class com.tencent.mm.plugin.messenger.c.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.messenger.a.a
            public final void onClickImp(View view) {
                String str;
                AppMethodBeat.i(194481);
                a.this.msgId = bundle.getLong("msg_id");
                a aVar = a.this;
                Map map = map;
                String str2 = str;
                WeakReference<Context> weakReference = weakReference;
                if (weakReference != null) {
                    try {
                        if (weakReference.get() != null) {
                            aVar.nhy = weakReference;
                            if ("new_tmpl_type_succeed_contact_window".equals((String) map.get(str2 + ".window_template.$type"))) {
                                aVar.zqy = Util.nullAs((String) map.get(str2 + ".window_template.title"), "");
                                aVar.zqz = Util.nullAs((String) map.get(str2 + ".window_template.cancel_wording"), "");
                                aVar.lJj = Util.nullAs((String) map.get(str2 + ".window_template.confirm_wording"), "");
                                aVar.zqA = Util.nullAs((String) map.get(str2 + ".origin_username"), "");
                                aVar.zqB = Util.nullAs((String) map.get(str2 + ".heir_username"), "");
                                aVar.zqC = Util.nullAs((String) map.get(str2 + ".succeed_ticket"), "");
                                ArrayList<c.a> aFd = c.aFd(aVar.zqy);
                                if (aFd != null && aFd.size() > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    Iterator<c.a> it = aFd.iterator();
                                    while (it.hasNext()) {
                                        c.a next = it.next();
                                        if (next != null && next.content != null) {
                                            if (next.type == 0) {
                                                arrayList.add(new SpannableString(l.c(MMApplicationContext.getContext(), next.content)));
                                            } else if (next.type == 1) {
                                                int i2 = 0;
                                                while (true) {
                                                    String str3 = str2 + ".window_template.link_list.link";
                                                    if (i2 != 0) {
                                                        str = str3 + i2;
                                                    } else {
                                                        str = str3;
                                                    }
                                                    if (Util.isNullOrNil((String) map.get(str))) {
                                                        break;
                                                    }
                                                    String str4 = (String) map.get(str + ".$type");
                                                    if (next.content.equals((String) map.get(str + ".$name")) && "link_plain".equals(str4)) {
                                                        arrayList.add(Util.nullAs((String) map.get(str + ".plain"), ""));
                                                    }
                                                    i2++;
                                                }
                                            }
                                        }
                                    }
                                    aVar.zqy = a.concactSpannable(arrayList).toString();
                                }
                                aVar.gv(weakReference.get());
                                aVar.zqx = new com.tencent.mm.plugin.messenger.b.a(aVar.zqA, aVar.zqB, aVar.zqC, 1);
                                g.azz().a(aVar.zqx, 0);
                            }
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                    }
                }
                ((e) g.af(e.class)).a("new_link_succeed_contact", map, bundle);
                AppMethodBeat.o(194481);
            }
        }, 0, nullAsNil.length(), 33);
        AppMethodBeat.o(194486);
        return spannableString;
    }

    static CharSequence concactSpannable(ArrayList<CharSequence> arrayList) {
        AppMethodBeat.i(194487);
        CharSequence spannableString = new SpannableString("");
        Iterator<CharSequence> it = arrayList.iterator();
        while (it.hasNext()) {
            spannableString = TextUtils.concat(spannableString, it.next());
        }
        AppMethodBeat.o(194487);
        return spannableString;
    }

    /* access modifiers changed from: package-private */
    public final void gv(Context context) {
        AppMethodBeat.i(194488);
        if (this.gtM == null) {
            context.getString(R.string.zb);
            this.gtM = h.a(context, context.getString(R.string.fj9), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.messenger.c.a.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(194482);
                    g.azz().a(a.this.zqx);
                    AppMethodBeat.o(194482);
                }
            });
            AppMethodBeat.o(194488);
            return;
        }
        if (!this.gtM.isShowing()) {
            this.gtM.show();
        }
        AppMethodBeat.o(194488);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        ctv ctv;
        AppMethodBeat.i(194489);
        Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        if (qVar instanceof com.tencent.mm.plugin.messenger.b.a) {
            if (i3 == -3600) {
                new f.a(MMApplicationContext.getContext()).bow(MMApplicationContext.getContext().getString(R.string.fj4)).apa(R.string.j34).b((f.c) null).show();
                com.tencent.mm.plugin.messenger.e.a.Q(this.msgId, 7);
                AppMethodBeat.o(194489);
                return;
            }
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.messenger.b.a aVar = (com.tencent.mm.plugin.messenger.b.a) qVar;
                if (aVar.zqw == null) {
                    ctv = null;
                } else {
                    ctv = aVar.zqw;
                }
                int i4 = ((com.tencent.mm.plugin.messenger.b.a) qVar).action;
                if (ctv != null) {
                    Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NetSceneOpenImNotAutoSucceed ret:%s action:%s", Integer.valueOf(ctv.BaseResponse.Ret), Integer.valueOf(i4));
                    if (i4 == 1) {
                        if (this.nhy == null || this.nhy.get() == null) {
                            Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NOT_AUTO_SUCCEED_ACTION_PREPARE context == null");
                            AppMethodBeat.o(194489);
                            return;
                        }
                        f.a aVar2 = new f.a(this.nhy.get());
                        aVar2.Dq(false);
                        aVar2.bow(this.zqy).boB(this.zqz).boA(this.lJj).c(new f.c() {
                            /* class com.tencent.mm.plugin.messenger.c.a.AnonymousClass3 */

                            @Override // com.tencent.mm.ui.widget.a.f.c
                            public final void e(boolean z, String str) {
                                AppMethodBeat.i(194483);
                                Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "click %s", Boolean.valueOf(z));
                                if (!z) {
                                    com.tencent.mm.plugin.messenger.e.a.Q(a.this.msgId, 10);
                                    AppMethodBeat.o(194483);
                                } else if (a.this.nhy == null || a.this.nhy.get() == null) {
                                    Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onDialogClick context == null");
                                    AppMethodBeat.o(194483);
                                } else {
                                    a.this.zqx = new com.tencent.mm.plugin.messenger.b.a(a.this.zqA, a.this.zqB, a.this.zqC, 2);
                                    g.azz().a(a.this.zqx, 0);
                                    a.this.gv(a.this.nhy.get());
                                    com.tencent.mm.plugin.messenger.e.a.Q(a.this.msgId, 9);
                                    AppMethodBeat.o(194483);
                                }
                            }
                        }).show();
                        com.tencent.mm.plugin.messenger.e.a.Q(this.msgId, 8);
                    }
                    AppMethodBeat.o(194489);
                    return;
                }
                Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "notAutoSucceedResp is null");
            }
            Context context = MMApplicationContext.getContext();
            if (Util.isNullOrNil(str)) {
                str = MMApplicationContext.getContext().getString(R.string.u5);
            }
            u.makeText(context, str, 0).show();
            com.tencent.mm.plugin.messenger.e.a.Q(this.msgId, 6);
        }
        AppMethodBeat.o(194489);
    }
}
