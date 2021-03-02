package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.uk;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.bq;
import com.tencent.mm.ui.z;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class c implements View.OnClickListener, i, u {
    private static final String PdY = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect");
    private a PdZ;
    private ProgressDialog gtM;

    static {
        AppMethodBeat.i(232833);
        AppMethodBeat.o(232833);
    }

    public c(a aVar) {
        this.PdZ = aVar;
    }

    public final void onClick(View view) {
        final String str;
        boolean z = true;
        final int i2 = 1;
        boolean z2 = false;
        AppMethodBeat.i(34233);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() == null) {
            Log.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34233);
            return;
        }
        if (view.getTag() instanceof bq) {
            bq bqVar = (bq) view.getTag();
            if (bqVar == null) {
                Log.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34233);
                return;
            }
            String str2 = bqVar.dXm.appId;
            if (Util.isNullOrNil(str2)) {
                Log.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
            } else if (h.o(str2, false, false) == null) {
                Log.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = ".concat(String.valueOf(str2)));
            } else {
                z2 = true;
            }
            if (!z2) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34233);
                return;
            }
            ao.eAV().a(2, this);
            if (this.PdZ.gRM()) {
                i2 = 2;
            }
            String talkerUserName = this.PdZ.getTalkerUserName();
            if (ab.Eq(talkerUserName)) {
                str = bp.Ks(bqVar.dTX.field_content);
            } else {
                str = talkerUserName;
            }
            final k.b bVar2 = bqVar.dXm;
            com.tencent.mm.ui.base.h.c(this.PdZ.Pwc.getContext(), this.PdZ.Pwc.getMMResources().getString(R.string.wi), this.PdZ.Pwc.getMMResources().getString(R.string.wj), this.PdZ.Pwc.getMMResources().getString(R.string.ca), this.PdZ.Pwc.getMMResources().getString(R.string.fxk), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.c.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(34230);
                    c.a(c.this, new com.tencent.mm.pluginsdk.model.app.ab(2, new ai(bVar2.appId, "1")));
                    com.tencent.mm.plugin.game.api.b dSQ = b.a.dSQ();
                    if (dSQ != null) {
                        c.this.PdZ.Pwc.getContext();
                        dSQ.a(str, bVar2.appId, bVar2.type, i2, bVar2.mediaTagName, 1);
                    }
                    AppMethodBeat.o(34230);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.c.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(34231);
                    c.a(c.this, new com.tencent.mm.pluginsdk.model.app.ab(2, new ai(bVar2.appId, AppEventsConstants.EVENT_PARAM_VALUE_NO)));
                    com.tencent.mm.plugin.game.api.b dSQ = b.a.dSQ();
                    if (dSQ != null) {
                        c.this.PdZ.Pwc.getContext();
                        dSQ.a(str, bVar2.appId, bVar2.type, i2, bVar2.mediaTagName, 2);
                    }
                    AppMethodBeat.o(34231);
                }
            });
        } else if (view.getTag() instanceof t.o) {
            final t.o oVar = (t.o) view.getTag();
            if (oVar == null) {
                Log.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34233);
                return;
            } else if (oVar == null || Util.isNullOrNil(oVar.ixM) || oVar.dTX == null) {
                Object[] objArr = new Object[1];
                if (oVar != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                Log.e("MicroMsg.AppSpamClickListener", "wrong args, tag is null ? ", objArr);
            } else {
                com.tencent.mm.ui.base.h.b(this.PdZ.Pwc.getContext(), null, new String[]{this.PdZ.Pwc.getMMResources().getString(R.string.hmp), this.PdZ.Pwc.getMMResources().getString(R.string.hmq), this.PdZ.Pwc.getMMResources().getString(R.string.sz)}, null, new h.d() {
                    /* class com.tencent.mm.ui.chatting.c.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(34229);
                        switch (i2) {
                            case 0:
                                Intent intent = new Intent();
                                try {
                                    intent.putExtra("rawUrl", String.format(c.PdY, URLEncoder.encode(oVar.dkU, MimeTypeUtil.ContentType.DEFAULT_CHARSET), URLEncoder.encode(oVar.ixM, MimeTypeUtil.ContentType.DEFAULT_CHARSET), Long.valueOf(oVar.dTX.field_msgSvrId), Integer.valueOf((int) (oVar.dTX.field_createTime / 1000)), 42));
                                    intent.putExtra("show_bottom", false);
                                    intent.putExtra("showShare", false);
                                    com.tencent.mm.br.c.b(c.this.PdZ.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    AppMethodBeat.o(34229);
                                    return;
                                } catch (UnsupportedEncodingException e2) {
                                    Log.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", e2.getMessage());
                                    AppMethodBeat.o(34229);
                                    return;
                                }
                            case 1:
                                Log.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", oVar.dkU, oVar.ixM);
                                bg.azz().a(1030, c.this);
                                cla cla = new cla();
                                cla.KHa = 1;
                                cla.Mqy = oVar.ixM;
                                cla.Title = "";
                                LinkedList<cla> linkedList = new LinkedList<>();
                                linkedList.add(cla);
                                uk ukVar = new uk();
                                ukVar.eaK.dYs = oVar.dkU;
                                ukVar.eaK.eaL = linkedList;
                                if (EventCenter.instance.publish(ukVar)) {
                                    c cVar = c.this;
                                    Activity context = c.this.PdZ.Pwc.getContext();
                                    c.this.PdZ.Pwc.getMMResources().getString(R.string.zb);
                                    cVar.gtM = com.tencent.mm.ui.base.h.a((Context) context, c.this.PdZ.Pwc.getMMResources().getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                        /* class com.tencent.mm.ui.chatting.c.AnonymousClass1.AnonymousClass1 */

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            AppMethodBeat.i(34228);
                                            bg.azz().b(1030, c.this);
                                            AppMethodBeat.o(34228);
                                        }
                                    });
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.o(34229);
                    }
                });
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34233);
    }

    @Override // com.tencent.mm.pluginsdk.model.app.u
    public final void a(int i2, int i3, String str, aa aaVar) {
        AppMethodBeat.i(34234);
        Log.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + i2 + ", errCode = " + i3);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        ao.eAV().b(2, this);
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.ui.base.h.cD(this.PdZ.Pwc.getContext(), this.PdZ.Pwc.getMMResources().getString(R.string.ds5));
            AppMethodBeat.o(34234);
        } else if (z.a.a(this.PdZ.Pwc.getContext(), i2, i3, str, 4)) {
            AppMethodBeat.o(34234);
        } else {
            Toast.makeText(this.PdZ.Pwc.getContext(), this.PdZ.Pwc.getMMResources().getString(R.string.dpy, Integer.valueOf(i2), Integer.valueOf(i3)), 0).show();
            AppMethodBeat.o(34234);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(34235);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        bg.azz().b(1030, this);
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.ui.base.h.cD(this.PdZ.Pwc.getContext(), this.PdZ.Pwc.getMMResources().getString(R.string.ds5));
            AppMethodBeat.o(34235);
            return;
        }
        Toast.makeText(this.PdZ.Pwc.getContext(), this.PdZ.Pwc.getMMResources().getString(R.string.hmr, Integer.valueOf(i2), Integer.valueOf(i3)), 0).show();
        AppMethodBeat.o(34235);
    }

    static /* synthetic */ void a(c cVar, final q qVar) {
        AppMethodBeat.i(232832);
        bg.azz().a(qVar, 0);
        Activity context = cVar.PdZ.Pwc.getContext();
        cVar.PdZ.Pwc.getMMResources().getString(R.string.zb);
        cVar.gtM = com.tencent.mm.ui.base.h.a((Context) context, cVar.PdZ.Pwc.getMMResources().getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.chatting.c.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(34232);
                bg.azz().a(qVar);
                ao.eAV().b(2, c.this);
                AppMethodBeat.o(34232);
            }
        });
        AppMethodBeat.o(232832);
    }
}
