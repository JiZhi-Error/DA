package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.i.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;

public final class u {
    public String Bxl;
    String Bxm;
    String Bxn;
    public ChatFooterCustom PhX;
    public FrameLayout PhY;
    public FrameLayout PhZ;
    public TextView Pia;
    public ImageView Pib;
    a Pic = a.DEFAULT;
    public boolean Pid;
    String Pie = null;
    public String Pif;
    public View.OnClickListener Pig = new View.OnClickListener() {
        /* class com.tencent.mm.ui.chatting.u.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(34609);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            new Intent().putExtra("composeType", 1);
            c.V(u.this.mContext, "qqmail", ".ui.ComposeUI");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34609);
        }
    };
    public View.OnClickListener Pih = new View.OnClickListener() {
        /* class com.tencent.mm.ui.chatting.u.AnonymousClass2 */

        public final void onClick(View view) {
            Intent intent;
            AppMethodBeat.i(34610);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            switch (AnonymousClass8.Pil[u.this.Pic.ordinal()]) {
                case 1:
                    h.INSTANCE.a(11288, 7);
                    u uVar = u.this;
                    Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
                    g.aZ(uVar.mContext, uVar.Pie);
                    break;
                case 2:
                    u uVar2 = u.this;
                    Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
                    f.cBv().Cn(uVar2.rDg);
                    uVar2.gNS();
                    break;
                case 3:
                    h.INSTANCE.a(11288, 6);
                    u uVar3 = u.this;
                    if (NetStatusUtil.isConnected(uVar3.mContext)) {
                        if (NetStatusUtil.isWifi(uVar3.mContext)) {
                            com.tencent.mm.ui.base.h.a(uVar3.mContext, (int) R.string.awa, 0, (int) R.string.aw6, (int) R.string.aw5, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.chatting.u.AnonymousClass4 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(34612);
                                    u.b(u.this);
                                    AppMethodBeat.o(34612);
                                }
                            }, (DialogInterface.OnClickListener) null);
                            break;
                        } else {
                            com.tencent.mm.ui.base.h.a(uVar3.mContext, (int) R.string.aw_, 0, (int) R.string.aw6, (int) R.string.aw5, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.chatting.u.AnonymousClass3 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(34611);
                                    u.b(u.this);
                                    AppMethodBeat.o(34611);
                                }
                            }, (DialogInterface.OnClickListener) null);
                            break;
                        }
                    } else {
                        com.tencent.mm.ui.base.h.a(uVar3.mContext, com.tencent.mm.cb.a.aI(uVar3.mContext, R.string.awc), "", com.tencent.mm.cb.a.aI(uVar3.mContext, R.string.aw8), (DialogInterface.OnClickListener) null);
                        break;
                    }
                case 4:
                    h.INSTANCE.a(11288, 5);
                    u uVar4 = u.this;
                    Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
                    Log.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", uVar4.Pif);
                    if (Util.isNullOrNil(uVar4.Pif)) {
                        intent = uVar4.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                    } else {
                        intent = new Intent();
                        intent.setData(Uri.parse(uVar4.Pif));
                        intent.addFlags(268435456);
                        if (Build.VERSION.SDK_INT >= 11) {
                            intent.addFlags(32768);
                        }
                        if (!Util.isIntentAvailable(uVar4.mContext, intent)) {
                            intent = uVar4.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                        }
                    }
                    Log.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", intent);
                    com.tencent.mm.ch.a.post(new Runnable(intent) {
                        /* class com.tencent.mm.ui.chatting.u.AnonymousClass5 */
                        final /* synthetic */ Intent BxJ;

                        {
                            this.BxJ = r2;
                        }

                        public final void run() {
                            AppMethodBeat.i(34613);
                            com.tencent.mm.pluginsdk.model.app.h.a(u.this.mContext, this.BxJ, u.this.mContext.getString(R.string.awf), null, null);
                            AppMethodBeat.o(34613);
                        }
                    });
                    break;
                case 5:
                    if (u.this.Pid) {
                        u.a(u.this);
                        break;
                    }
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34610);
        }
    };
    private o.a Pii = new o.a() {
        /* class com.tencent.mm.ui.chatting.u.AnonymousClass7 */

        @Override // com.tencent.mm.pluginsdk.ui.tools.o.a
        public final void onSuccess(int i2) {
            AppMethodBeat.i(34616);
            u.this.xXB = i2;
            u.this.gNT();
            AppMethodBeat.o(34616);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.o.a
        public final void eGv() {
            AppMethodBeat.i(34617);
            u.this.Pia.setText(R.string.awf);
            AppMethodBeat.o(34617);
        }
    };
    Context mContext;
    long rDg = -1;
    public LinearLayout rmL = null;
    private SharedPreferences sp;
    public int xXB = -1;

    /* access modifiers changed from: package-private */
    public enum a {
        DEFAULT,
        NEED_DOWNLOAD,
        DOWNLOADING,
        NEED_INSTALL,
        INSTALLED,
        NO_URL;

        public static a valueOf(String str) {
            AppMethodBeat.i(34620);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(34620);
            return aVar;
        }

        static {
            AppMethodBeat.i(34621);
            AppMethodBeat.o(34621);
        }
    }

    public u(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.i(34622);
        this.mContext = chatFooterCustom.getContext();
        this.PhX = chatFooterCustom;
        AppMethodBeat.o(34622);
    }

    public final void gNR() {
        AppMethodBeat.i(34623);
        if (this.Pic == a.INSTALLED) {
            this.Pib.setImageResource(R.raw.promo_icon_qqmail);
            AppMethodBeat.o(34623);
            return;
        }
        this.Pib.setImageResource(R.raw.promo_icon_qqmail_uninstall);
        AppMethodBeat.o(34623);
    }

    public final void gNT() {
        AppMethodBeat.i(34625);
        if (this.xXB == 0) {
            this.Pia.setText(R.string.awf);
            AppMethodBeat.o(34625);
        } else if (this.xXB > 99) {
            this.Pia.setText(R.string.awe);
            AppMethodBeat.o(34625);
        } else {
            this.Pia.setText(String.format(com.tencent.mm.cb.a.aI(this.mContext, R.string.awd), Integer.valueOf(this.xXB)));
            AppMethodBeat.o(34625);
        }
    }

    public final void gNS() {
        a aVar;
        AppMethodBeat.i(34624);
        if (!q.s(this.mContext, "com.tencent.androidqqmail")) {
            this.sp = this.mContext.getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.aps());
            this.rDg = this.sp.getLong("qqmail_downloadid", -1);
            if (this.rDg >= 0) {
                FileDownloadTaskInfo Co = f.cBv().Co(this.rDg);
                int i2 = Co.status;
                this.Pie = Co.path;
                switch (i2) {
                    case 1:
                        aVar = a.DOWNLOADING;
                        break;
                    case 2:
                    default:
                        if (!Util.isNullOrNil(this.Bxl)) {
                            aVar = a.NEED_DOWNLOAD;
                            break;
                        } else {
                            aVar = a.NO_URL;
                            break;
                        }
                    case 3:
                        if (!s.YS(this.Pie)) {
                            if (!Util.isNullOrNil(this.Bxl)) {
                                aVar = a.NEED_DOWNLOAD;
                                break;
                            } else {
                                aVar = a.NO_URL;
                                break;
                            }
                        } else {
                            aVar = a.NEED_INSTALL;
                            break;
                        }
                }
            } else if (Util.isNullOrNil(this.Bxl)) {
                aVar = a.NO_URL;
            } else {
                aVar = a.NEED_DOWNLOAD;
            }
        } else {
            aVar = a.INSTALLED;
        }
        this.Pic = aVar;
        gNR();
        Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", this.Pic.toString());
        switch (this.Pic) {
            case NEED_INSTALL:
                this.Pia.setText(R.string.aw9);
                AppMethodBeat.o(34624);
                return;
            case DOWNLOADING:
                this.Pia.setText(R.string.aw7);
                AppMethodBeat.o(34624);
                return;
            case NEED_DOWNLOAD:
            case INSTALLED:
            case NO_URL:
                o.a(this.Pii);
                AppMethodBeat.o(34624);
                return;
            default:
                o.a(this.Pii);
                AppMethodBeat.o(34624);
                return;
        }
    }

    static /* synthetic */ void a(u uVar) {
        AppMethodBeat.i(34626);
        Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[handleNoUrl]");
        com.tencent.mm.ui.base.h.a(uVar.mContext, com.tencent.mm.cb.a.aI(uVar.mContext, R.string.awb), "", com.tencent.mm.cb.a.aI(uVar.mContext, R.string.aw8), (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(34626);
    }

    static /* synthetic */ void b(u uVar) {
        AppMethodBeat.i(34627);
        Log.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initQQMailDownloadUrlAndMD5]");
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.chatting.u.AnonymousClass6 */

            /* JADX WARNING: Removed duplicated region for block: B:19:0x00b9 A[SYNTHETIC, Splitter:B:19:0x00b9] */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x0101 A[SYNTHETIC, Splitter:B:29:0x0101] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 324
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.u.AnonymousClass6.run():void");
            }
        }, "QQMailDownloadUrlAndMD5");
        AppMethodBeat.o(34627);
    }
}
