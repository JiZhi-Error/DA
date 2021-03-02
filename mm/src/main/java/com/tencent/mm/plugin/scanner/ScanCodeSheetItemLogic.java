package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.mm.vending.g.d;
import java.util.HashMap;
import org.json.JSONObject;

public class ScanCodeSheetItemLogic implements LifecycleObserver {
    public bws CAh;
    public final bws CAi = new bws();
    private a CAj;
    private b CAk;
    public d CAl;
    private HashMap<String, bws> CAm = new HashMap<>();
    private MutableLiveData<bws> CAn = new MutableLiveData<>();
    private int CAo;
    private boolean CAp = false;
    public Context mContext;

    public interface a {
        void bLz();
    }

    public interface b {
        void asu(String str);
    }

    public ScanCodeSheetItemLogic(Context context) {
        AppMethodBeat.i(151569);
        this.mContext = context;
        AppMethodBeat.o(151569);
    }

    public ScanCodeSheetItemLogic(Context context, a aVar) {
        AppMethodBeat.i(151570);
        this.mContext = context;
        this.CAj = aVar;
        AppMethodBeat.o(151570);
    }

    public ScanCodeSheetItemLogic(Context context, b bVar) {
        AppMethodBeat.i(151571);
        this.mContext = context;
        this.CAk = bVar;
        AppMethodBeat.o(151571);
    }

    public final String Wp(int i2) {
        AppMethodBeat.i(223709);
        String string = this.mContext.getString(R.string.gcc);
        if (!e.d.ahw(i2)) {
            string = this.mContext.getString(R.string.gca);
        }
        AppMethodBeat.o(223709);
        return string;
    }

    public final void cl(int i2, final String str) {
        AppMethodBeat.i(223710);
        this.CAp = true;
        this.CAh = null;
        h.RTc.bqo("MicroMsg.ScanCodeSheetItemLogic");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(223710);
            return;
        }
        if (this.CAl == null) {
            this.CAl = new d();
        }
        if (g.ci(i2, str)) {
            if (1000 > 0) {
                h.RTc.bqo("MicroMsg.ScanCodeSheetItemLogic");
                h.RTc.a(new Runnable() {
                    /* class com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(223706);
                        h.RTc.aV(new Runnable() {
                            /* class com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(223705);
                                if (ScanCodeSheetItemLogic.this.CAh == null || ScanCodeSheetItemLogic.this.CAh == ScanCodeSheetItemLogic.this.CAi) {
                                    ScanCodeSheetItemLogic.this.CAh = ScanCodeSheetItemLogic.this.CAi;
                                    ScanCodeSheetItemLogic.b(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.this.CAh);
                                    if (ScanCodeSheetItemLogic.this.CAj != null) {
                                        ScanCodeSheetItemLogic.this.CAj.bLz();
                                    }
                                    if (ScanCodeSheetItemLogic.this.CAk != null) {
                                        b bVar = ScanCodeSheetItemLogic.this.CAk;
                                        String str = str;
                                        bws unused = ScanCodeSheetItemLogic.this.CAh;
                                        bVar.asu(str);
                                    }
                                    AppMethodBeat.o(223705);
                                    return;
                                }
                                AppMethodBeat.o(223705);
                            }
                        });
                        AppMethodBeat.o(223706);
                    }
                }, 1000, "MicroMsg.ScanCodeSheetItemLogic");
            }
            this.CAl.bZ(i2, str).a(new d.b<bws>() {
                /* class com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.g.d.b
                public final /* synthetic */ void bz(bws bws) {
                    AppMethodBeat.i(151567);
                    bws bws2 = bws;
                    if (ScanCodeSheetItemLogic.this.CAh == ScanCodeSheetItemLogic.this.CAi) {
                        Log.i("MicroMsg.ScanCodeSheetItemLogic", "net call back after 1s");
                        AppMethodBeat.o(151567);
                    } else if (!ScanCodeSheetItemLogic.this.CAp) {
                        Log.i("MicroMsg.ScanCodeSheetItemLogic", "enableCallback false");
                        AppMethodBeat.o(151567);
                    } else {
                        h.RTc.bqo("MicroMsg.ScanCodeSheetItemLogic");
                        ScanCodeSheetItemLogic.this.CAh = bws2;
                        ScanCodeSheetItemLogic.b(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.this.CAh);
                        ScanCodeSheetItemLogic.this.CAm.put(str, bws2);
                        if (ScanCodeSheetItemLogic.this.CAj != null) {
                            ScanCodeSheetItemLogic.this.CAj.bLz();
                        }
                        if (ScanCodeSheetItemLogic.this.CAk != null) {
                            b bVar = ScanCodeSheetItemLogic.this.CAk;
                            String str = str;
                            bws unused = ScanCodeSheetItemLogic.this.CAh;
                            bVar.asu(str);
                        }
                        AppMethodBeat.o(151567);
                    }
                }
            });
        }
        AppMethodBeat.o(223710);
    }

    public final void cm(int i2, final String str) {
        AppMethodBeat.i(151573);
        this.CAh = null;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151573);
            return;
        }
        if (this.CAl == null) {
            this.CAl = new d();
        }
        if (g.ci(i2, str)) {
            this.CAl.bZ(i2, str).a(new d.b<bws>() {
                /* class com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.g.d.b
                public final /* synthetic */ void bz(bws bws) {
                    AppMethodBeat.i(223704);
                    bws bws2 = bws;
                    ScanCodeSheetItemLogic.this.CAh = bws2;
                    ScanCodeSheetItemLogic.b(ScanCodeSheetItemLogic.this, ScanCodeSheetItemLogic.this.CAh);
                    ScanCodeSheetItemLogic.this.CAm.put(str, bws2);
                    if (ScanCodeSheetItemLogic.this.CAj != null) {
                        ScanCodeSheetItemLogic.this.CAj.bLz();
                    }
                    if (ScanCodeSheetItemLogic.this.CAk != null) {
                        b bVar = ScanCodeSheetItemLogic.this.CAk;
                        String str = str;
                        bws unused = ScanCodeSheetItemLogic.this.CAh;
                        bVar.asu(str);
                    }
                    AppMethodBeat.o(223704);
                }
            });
        }
        AppMethodBeat.o(151573);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(int r9, byte[] r10) {
        /*
            r8 = this;
            r7 = 151574(0x25016, float:2.124E-40)
            r6 = -1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            com.tencent.mm.protocal.protobuf.bws r1 = new com.tencent.mm.protocal.protobuf.bws
            r1.<init>()
            if (r9 != 0) goto L_0x004d
            boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r10)
            if (r0 != 0) goto L_0x004d
            r1.parseFrom(r10)     // Catch:{ IOException -> 0x0039 }
            java.lang.String r0 = r1.Mcx     // Catch:{ IOException -> 0x0039 }
            boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)     // Catch:{ IOException -> 0x0039 }
            if (r0 == 0) goto L_0x002a
            java.lang.String r0 = r1.UserName     // Catch:{ IOException -> 0x0039 }
            boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)     // Catch:{ IOException -> 0x0039 }
            if (r0 == 0) goto L_0x002a
            r0 = -1
            r1.Ret = r0     // Catch:{ IOException -> 0x0039 }
        L_0x002a:
            r8.CAh = r1
            com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic$a r0 = r8.CAj
            if (r0 == 0) goto L_0x0035
            com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic$a r0 = r8.CAj
            r0.bLz()
        L_0x0035:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return
        L_0x0039:
            r0 = move-exception
            java.lang.String r2 = "MicroMsg.ScanCodeSheetItemLogic"
            java.lang.String r3 = "parse exception: s%"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            java.lang.String r0 = r0.getMessage()
            r4[r5] = r0
            com.tencent.mm.sdk.platformtools.Log.e(r2, r3, r4)
        L_0x004d:
            r1.Ret = r6
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.q(int, byte[]):void");
    }

    @SuppressLint({"ResourceType"})
    public final View a(final View.OnClickListener onClickListener, int i2, String str, final int i3) {
        AppMethodBeat.i(151575);
        this.CAo = i3;
        AnonymousClass6 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(223708);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String safeFormatString = Util.safeFormatString("%d,%d", Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
                Log.i("MicroMsg.ScanCodeSheetItemLogic", "18684 report:".concat(String.valueOf(safeFormatString)));
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(18684, safeFormatString);
                onClickListener.onClick(view);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(223708);
            }
        };
        if (this.CAh == null) {
            View a2 = a(r0, i2, str);
            AppMethodBeat.o(151575);
            return a2;
        }
        View d2 = d(r0);
        AppMethodBeat.o(151575);
        return d2;
    }

    @SuppressLint({"ResourceType"})
    private View d(View.OnClickListener onClickListener) {
        AppMethodBeat.i(151576);
        ViewTitleWithAnimation viewTitleWithAnimation = new ViewTitleWithAnimation(this.mContext);
        viewTitleWithAnimation.hideLoading();
        if (this.CAh.Ret != 0 || Util.isNullOrNil(this.CAh.UserName)) {
            viewTitleWithAnimation.gZm();
            viewTitleWithAnimation.setOnClickListener(onClickListener);
            AppMethodBeat.o(151576);
        } else {
            viewTitleWithAnimation.setTitle(this.CAh.UserName);
            viewTitleWithAnimation.setOnClickListener(onClickListener);
            c.a aVar = new c.a();
            aVar.jbe = true;
            viewTitleWithAnimation.getIconImageView().setBackground(null);
            viewTitleWithAnimation.getIconImageView().setImageDrawable(null);
            if (this.CAh.Mcw == 4) {
                viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc0));
                aVar.jbq = R.raw.actionsheet_default_appbrand_icon;
                aVar.iaT = true;
                com.tencent.mm.av.a.a.bdb().a(this.CAh.Mcx, viewTitleWithAnimation.getIconImageView(), aVar.bdv());
            } else if (this.CAh.Mcw == 3) {
                viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc1));
                aVar.jbq = R.drawable.ars;
                aVar.iaT = true;
                com.tencent.mm.av.a.a.bdb().a(this.CAh.Mcx, viewTitleWithAnimation.getIconImageView(), aVar.bdv());
            } else if (this.CAh.Mcw == 1) {
                viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc4));
                aVar.jbq = R.color.BW_BG_95;
                com.tencent.mm.av.a.a.bdb().a(this.CAh.Mcx, viewTitleWithAnimation.getIconImageView(), aVar.bdv());
            } else if (this.CAh.Mcw == 2) {
                viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc2));
                viewTitleWithAnimation.getIconImageView().setImageResource(R.raw.default_chatroom);
            } else if (this.CAh.Mcw == 7) {
                viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc6));
                viewTitleWithAnimation.getIconImageView().setImageDrawable(null);
                if (!Util.isNullOrNil(this.CAh.Mcy)) {
                    viewTitleWithAnimation.setCompanyText(Util.safeFormatString("@%s", this.CAh.Mcy));
                }
                aVar.jbq = R.color.BW_BG_95;
                com.tencent.mm.av.a.a.bdb().a(this.CAh.Mcx, viewTitleWithAnimation.getIconImageView(), aVar.bdv());
            } else if (this.CAh.Mcw == 6) {
                viewTitleWithAnimation.setTitle(Util.safeFormatString(this.mContext.getString(R.string.gdd), this.CAh.UserName));
                viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc3));
                viewTitleWithAnimation.getIconImageView().setImageDrawable(ar.m(this.mContext, R.raw.icons_outlined_wallet, this.mContext.getResources().getColor(R.color.Brand)));
            } else if (this.CAh.Mcw == 5) {
                viewTitleWithAnimation.setTitle(Util.safeFormatString(this.mContext.getString(R.string.gdz), this.CAh.UserName));
                viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc5));
                viewTitleWithAnimation.getIconImageView().setImageDrawable(ar.m(this.mContext, R.raw.icon_scan_code_reward, this.mContext.getResources().getColor(R.color.Yellow)));
            } else {
                viewTitleWithAnimation.gZm();
            }
            AppMethodBeat.o(151576);
        }
        return viewTitleWithAnimation;
    }

    @SuppressLint({"ResourceType"})
    private View a(View.OnClickListener onClickListener, int i2, String str) {
        AppMethodBeat.i(151577);
        ViewTitleWithAnimation viewTitleWithAnimation = new ViewTitleWithAnimation(this.mContext);
        viewTitleWithAnimation.startLoading();
        viewTitleWithAnimation.setOnClickListener(onClickListener);
        if (g.ca(i2, str)) {
            viewTitleWithAnimation.getIconImageView().setImageResource(R.raw.actionsheet_default_appbrand_icon);
            viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc0));
        } else if (g.cb(i2, str)) {
            viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc1));
            viewTitleWithAnimation.getIconImageView().setImageDrawable(null);
            viewTitleWithAnimation.getIconImageView().setImageResource(R.drawable.ars);
        } else if (g.cc(i2, str)) {
            viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc4));
            viewTitleWithAnimation.getIconImageView().setImageDrawable(null);
            viewTitleWithAnimation.getIconImageView().setImageResource(R.color.BW_BG_95);
        } else if (g.cd(i2, str)) {
            viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc2));
            viewTitleWithAnimation.getIconImageView().setImageDrawable(null);
            viewTitleWithAnimation.getIconImageView().setImageResource(R.raw.default_chatroom);
        } else if (g.ce(i2, str)) {
            viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc6));
            viewTitleWithAnimation.getIconImageView().setImageDrawable(null);
            viewTitleWithAnimation.getIconImageView().setImageResource(R.color.BW_BG_95);
        } else if (g.ch(i2, str)) {
            viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc3));
            viewTitleWithAnimation.getIconImageView().setImageDrawable(ar.m(this.mContext, R.raw.icons_outlined_wallet, this.mContext.getResources().getColor(R.color.Brand_100)));
        } else if (g.cg(i2, str)) {
            viewTitleWithAnimation.setSubTitle(this.mContext.getString(R.string.gc5));
            viewTitleWithAnimation.getIconImageView().setImageDrawable(ar.m(this.mContext, R.raw.icon_scan_code_reward, this.mContext.getResources().getColor(R.color.Yellow)));
        } else {
            String string = this.mContext.getString(R.string.gdg);
            if (!e.d.ahw(i2)) {
                string = this.mContext.getString(R.string.gdf);
            }
            com.tencent.mm.ui.widget.bottomsheet.a aVar = new com.tencent.mm.ui.widget.bottomsheet.a(this.mContext);
            aVar.setOnClickListener(onClickListener);
            aVar.setTitle(string);
            AppMethodBeat.o(151577);
            return aVar;
        }
        AppMethodBeat.o(151577);
        return viewTitleWithAnimation;
    }

    public final void onDismiss() {
        AppMethodBeat.i(223711);
        h.RTc.bqo("MicroMsg.ScanCodeSheetItemLogic");
        this.CAh = null;
        this.CAp = false;
        AppMethodBeat.o(223711);
    }

    static /* synthetic */ void b(ScanCodeSheetItemLogic scanCodeSheetItemLogic, bws bws) {
        AppMethodBeat.i(223712);
        if (bws == null || TextUtils.isEmpty(bws.Mcy)) {
            AppMethodBeat.o(223712);
            return;
        }
        try {
            String optString = new JSONObject(bws.Mcy).optString(ch.COL_USERNAME);
            if (!TextUtils.isEmpty(optString) && as.HF(optString)) {
                Log.i("MicroMsg.ScanCodeSheetItemLogic", "try preloadWxaAttrs username:%s, scene:%d", optString, Integer.valueOf(scanCodeSheetItemLogic.CAo));
                b bVar = new b();
                bVar.username = optString;
                EventCenter.instance.publish(bVar);
            }
            AppMethodBeat.o(223712);
        } catch (Throwable th) {
            AppMethodBeat.o(223712);
        }
    }
}
