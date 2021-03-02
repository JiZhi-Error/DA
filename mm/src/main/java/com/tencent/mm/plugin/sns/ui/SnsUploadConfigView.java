package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.o.a;

public class SnsUploadConfigView extends LinearLayout implements i, a.AbstractC2123a, a.b {
    private static String pkgName = MMApplicationContext.getApplicationId();
    ImageView EPj;
    ImageView EPk;
    ImageView EPl;
    ImageView EPm;
    private boolean EPn = false;
    boolean EPo = false;
    boolean EPp = false;
    private boolean EPq = false;
    private boolean EPr = false;
    private boolean EPs = true;
    private boolean EPt = false;
    boolean EPu = false;
    a EPv = new a();
    cjy Etm = new cjy();
    private Context context;
    private ProgressDialog vIA = null;
    boolean vUk = false;

    static /* synthetic */ void c(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.i(99542);
        snsUploadConfigView.fjE();
        AppMethodBeat.o(99542);
    }

    static /* synthetic */ void e(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.i(99543);
        snsUploadConfigView.fjF();
        AppMethodBeat.o(99543);
    }

    static /* synthetic */ void j(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.i(99545);
        snsUploadConfigView.fjG();
        AppMethodBeat.o(99545);
    }

    static {
        AppMethodBeat.i(203759);
        AppMethodBeat.o(203759);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x01b3, code lost:
        if (com.tencent.mm.kernel.g.aAh().azQ().getBoolean(com.tencent.mm.storage.ar.a.USERINFO_SNS_OPEN_UPLOAD_WEISHI_BOOLEAN_SYNC, false) == false) goto L_0x01b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SnsUploadConfigView(final android.content.Context r11, android.util.AttributeSet r12) {
        /*
        // Method dump skipped, instructions count: 592
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final void fjD() {
        AppMethodBeat.i(99532);
        this.EPn = false;
        this.EPo = false;
        this.EPp = false;
        this.EPq = false;
        this.EPr = false;
        this.EPl.setImageDrawable(ar.m(this.context, R.raw.album_qzone_icon_normal, this.context.getResources().getColor(R.color.en)));
        this.EPm.setImageDrawable(ar.m(this.context, R.raw.album_wesee_icon_normal, this.context.getResources().getColor(R.color.en)));
        this.EPj.setImageDrawable(ar.m(this.context, R.raw.album_facebook_icon_normal, this.context.getResources().getColor(R.color.en)));
        this.EPk.setImageDrawable(ar.m(this.context, R.raw.album_twitter_icon_normal, this.context.getResources().getColor(R.color.en)));
        AppMethodBeat.o(99532);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fjE() {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.fjE():void");
    }

    /* access modifiers changed from: package-private */
    public final void fjF() {
        AppMethodBeat.i(99534);
        if (this.EPm == null) {
            AppMethodBeat.o(99534);
            return;
        }
        if (this.EPu) {
            g.aAi();
            if (g.aAh().azQ().getBoolean(ar.a.USERINFO_SNS_OPEN_UPLOAD_WEISHI_BOOLEAN_SYNC, false)) {
                this.EPm.setVisibility(0);
                if (this.EPr) {
                    this.EPm.setImageDrawable(com.tencent.mm.ui.ar.m(this.context, R.raw.album_wesee_icon_normal, Color.parseColor("#FF0F80")));
                    AppMethodBeat.o(99534);
                    return;
                }
                this.EPm.setImageDrawable(com.tencent.mm.ui.ar.m(this.context, R.raw.album_wesee_icon_normal, this.context.getResources().getColor(R.color.en)));
                AppMethodBeat.o(99534);
                return;
            }
        }
        this.EPr = false;
        this.EPm.setVisibility(8);
        AppMethodBeat.o(99534);
    }

    /* access modifiers changed from: package-private */
    public void setSyncFacebook(boolean z) {
        boolean z2;
        AppMethodBeat.i(99535);
        if (this.EPo) {
            if (!z.aUF()) {
                h.a(getContext(), (int) R.string.gon, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.AnonymousClass13 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(99529);
                        c.b(SnsUploadConfigView.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent().putExtra("shake_music", true));
                        AppMethodBeat.o(99529);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.AnonymousClass14 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                this.EPo = false;
                AppMethodBeat.o(99535);
                return;
            }
            if (!z && !this.EPt && z.aUF()) {
                final gs gsVar = new gs();
                gsVar.callback = new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(99521);
                        if (!gsVar.dKM.dFE) {
                            SnsUploadConfigView.m(SnsUploadConfigView.this);
                        }
                        AppMethodBeat.o(99521);
                    }
                };
                EventCenter.instance.asyncPublish(gsVar, Looper.myLooper());
            }
            this.EPj.setImageDrawable(com.tencent.mm.ui.ar.m(this.context, R.raw.album_facebook_icon_normal, Color.parseColor("#3C5998")));
            AppMethodBeat.o(99535);
            return;
        }
        this.EPj.setImageDrawable(com.tencent.mm.ui.ar.m(this.context, R.raw.album_facebook_icon_normal, this.context.getResources().getColor(R.color.en)));
        AppMethodBeat.o(99535);
    }

    /* access modifiers changed from: package-private */
    public final void fjG() {
        boolean z;
        AppMethodBeat.i(99536);
        if (this.EPp) {
            if (!this.EPv.gYx()) {
                h.a(getContext(), (int) R.string.gvt, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.AnonymousClass15 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(99530);
                        SnsUploadConfigView snsUploadConfigView = SnsUploadConfigView.this;
                        Context context = SnsUploadConfigView.this.getContext();
                        SnsUploadConfigView.this.getContext().getString(R.string.zb);
                        snsUploadConfigView.vIA = h.a(context, SnsUploadConfigView.this.getContext().getString(R.string.hrq), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.AnonymousClass15.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        SnsUploadConfigView.this.EPv.a(SnsUploadConfigView.this, SnsUploadConfigView.this.getContext());
                        AppMethodBeat.o(99530);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                this.EPp = false;
                AppMethodBeat.o(99536);
                return;
            }
            this.EPk.setImageDrawable(com.tencent.mm.ui.ar.m(this.context, R.raw.album_twitter_icon_normal, Color.parseColor("#1DA1F2")));
            AppMethodBeat.o(99536);
            return;
        }
        this.EPk.setImageDrawable(com.tencent.mm.ui.ar.m(this.context, R.raw.album_twitter_icon_normal, this.context.getResources().getColor(R.color.en)));
        AppMethodBeat.o(99536);
    }

    public int getPrivated() {
        if (this.vUk) {
            return 1;
        }
        return 0;
    }

    public void setPrivated(boolean z) {
        AppMethodBeat.i(99537);
        this.vUk = z;
        if (z) {
            fjD();
        }
        AppMethodBeat.o(99537);
    }

    public int getSyncFlag() {
        int i2 = 0;
        if (this.EPn) {
            i2 = 1;
        }
        if (this.EPo) {
            i2 |= 2;
        }
        if (this.EPp) {
            i2 |= 8;
        }
        if (this.EPq) {
            i2 |= 4;
        }
        if (this.EPr) {
            return i2 | 16;
        }
        return i2;
    }

    public org.b.d.i getTwitterAccessToken() {
        return this.EPv.QAH;
    }

    private void Po(int i2) {
        AppMethodBeat.i(99538);
        h.a(getContext(), i2, (int) R.string.zb, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(99538);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(99539);
        if (i2 == 0 && i3 == 0 && qVar != null) {
            fjF();
            AppMethodBeat.o(99539);
            return;
        }
        AppMethodBeat.o(99539);
    }

    @Override // com.tencent.mm.ui.o.a.b
    public final void a(a.c cVar) {
        AppMethodBeat.i(99540);
        if (this.vIA != null) {
            this.vIA.cancel();
        }
        switch (cVar) {
            case Finished:
                this.EPp = true;
                Po(R.string.hrs);
                break;
            case Canceled:
                this.EPp = false;
                break;
            case QAR:
                this.EPp = false;
                Po(R.string.hrr);
                break;
        }
        fjG();
        AppMethodBeat.o(99540);
    }

    @Override // com.tencent.mm.ui.o.a.AbstractC2123a
    public final void b(a.c cVar) {
        AppMethodBeat.i(99541);
        switch (cVar) {
            case QAR:
                this.EPp = false;
                break;
        }
        fjG();
        AppMethodBeat.o(99541);
    }

    static /* synthetic */ void h(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.i(99544);
        snsUploadConfigView.setSyncFacebook(false);
        AppMethodBeat.o(99544);
    }

    static /* synthetic */ void m(SnsUploadConfigView snsUploadConfigView) {
        AppMethodBeat.i(99546);
        Log.e("MicroMsg.SnsUploadConfigView", "dealWithRefreshTokenFail");
        if (snsUploadConfigView.EPo) {
            String string = snsUploadConfigView.getContext().getString(R.string.zb);
            h.a(snsUploadConfigView.getContext(), snsUploadConfigView.getContext().getString(R.string.c7h), string, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(99522);
                    Intent intent = new Intent();
                    intent.putExtra("is_force_unbind", true);
                    intent.putExtra("shake_music", true);
                    c.b(SnsUploadConfigView.this.getContext(), "account", ".ui.FacebookAuthUI", intent, 8);
                    AppMethodBeat.o(99522);
                }
            }, (DialogInterface.OnClickListener) null);
        }
        snsUploadConfigView.EPo = false;
        snsUploadConfigView.setSyncFacebook(false);
        AppMethodBeat.o(99546);
    }
}
