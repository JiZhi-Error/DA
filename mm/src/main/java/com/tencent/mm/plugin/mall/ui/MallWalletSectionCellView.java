package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cyf;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dqd;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import org.json.JSONObject;

public class MallWalletSectionCellView extends LinearLayout {
    private static final int qfn = a.fromDPToPix(MMApplicationContext.getContext(), 16);
    public View lJI;
    public View pYY;
    public CdnImageView zmI;
    public TextView zmJ;
    public TextView zmK;
    public CdnImageView zmL;
    public TextView zmM;
    public ImageView zmN;
    public ImageView zmO;
    public TextView zmP;
    public TextView zmQ;
    public ViewGroup zmR;
    public TextView zmS;
    public WcPayMoneyLoadingView zmT;
    public ProgressBar zmU;
    private dlp zmV;

    static /* synthetic */ void a(MallWalletSectionCellView mallWalletSectionCellView) {
        AppMethodBeat.i(66155);
        mallWalletSectionCellView.ehu();
        AppMethodBeat.o(66155);
    }

    static {
        AppMethodBeat.i(66156);
        AppMethodBeat.o(66156);
    }

    public MallWalletSectionCellView(Context context) {
        super(context);
        AppMethodBeat.i(66148);
        init(context);
        AppMethodBeat.o(66148);
    }

    public MallWalletSectionCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(66149);
        init(context);
        AppMethodBeat.o(66149);
    }

    public MallWalletSectionCellView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(66150);
        init(context);
        AppMethodBeat.o(66150);
    }

    private void init(Context context) {
        AppMethodBeat.i(66151);
        this.lJI = LayoutInflater.from(context).inflate(R.layout.b6b, (ViewGroup) this, true);
        this.zmI = (CdnImageView) this.lJI.findViewById(R.id.fsc);
        this.zmJ = (TextView) this.lJI.findViewById(R.id.fsk);
        this.zmK = (TextView) this.lJI.findViewById(R.id.fs_);
        this.zmL = (CdnImageView) this.lJI.findViewById(R.id.fsi);
        this.zmM = (TextView) this.lJI.findViewById(R.id.fsj);
        this.zmN = (ImageView) this.lJI.findViewById(R.id.fsg);
        this.zmO = (ImageView) this.lJI.findViewById(R.id.fsh);
        this.zmP = (TextView) this.lJI.findViewById(R.id.fse);
        this.zmQ = (TextView) this.lJI.findViewById(R.id.fsf);
        this.pYY = this.lJI.findViewById(R.id.fsa);
        this.zmR = (ViewGroup) this.lJI.findViewById(R.id.fsd);
        this.zmS = (TextView) this.lJI.findViewById(R.id.fsb);
        this.zmT = (WcPayMoneyLoadingView) this.lJI.findViewById(R.id.fs9);
        this.zmU = (ProgressBar) this.lJI.findViewById(R.id.jg5);
        this.zmT.setLoadingPb(this.zmU);
        setOrientation(1);
        setBackgroundResource(R.drawable.a__);
        AppMethodBeat.o(66151);
    }

    public final void a(final egf egf, final JSONObject jSONObject, boolean z, String str, boolean z2) {
        AppMethodBeat.i(66152);
        g.a(this.zmI, egf.Nge);
        if (egf.Ngh == null || Util.isNullOrNil(egf.Ngh.url)) {
            this.zmL.setImageResource(R.raw.icons_outlined_arrow);
            this.zmL.setColorFilter(getContext().getResources().getColor(R.color.en), PorterDuff.Mode.SRC_ATOP);
        } else {
            g.a(this.zmL, egf.Ngh, R.drawable.cql, true);
        }
        if (egf.Ngf == null || egf.Ngf.size() <= 0) {
            this.zmJ.setText("");
        } else {
            g.a(this.zmJ, egf.Ngf.get(0), (g.a) null);
        }
        if (egf.Ngj != null) {
            TextView textView = this.zmS;
            dqd dqd = egf.Ngj;
            if (!(dqd == null || textView == null)) {
                g.a(textView, dqd.Lov, (g.a) null);
                g.a(textView, dqd.MTe);
                int i2 = (int) dqd.MTg;
                if ((dqd.MTg & -16777216) == 0) {
                    i2 = (int) (dqd.MTg | -16777216);
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                if (dqd.MTf > 0.0f) {
                    gradientDrawable.setCornerRadius((float) a.fromDPToPix(textView.getContext(), (int) dqd.MTf));
                }
                gradientDrawable.setColor(i2);
                textView.setBackground(gradientDrawable);
            }
            this.zmS.setVisibility(0);
        } else {
            this.zmS.setVisibility(8);
        }
        if (egf.Ngg == null || egf.Ngg.size() <= 0) {
            if (!Util.isNullOrNil(str)) {
                this.zmT.cH("", !z2);
                this.zmT.setVisibility(0);
                this.zmK.setVisibility(8);
            } else {
                this.zmK.setText("");
                this.zmT.setVisibility(8);
                this.zmK.setVisibility(0);
            }
        } else if (!Util.isNullOrNil(str)) {
            this.zmT.cH(str, !z2);
            this.zmT.setVisibility(0);
            this.zmK.setVisibility(8);
        } else {
            g.a(this.zmK, egf.Ngg.get(0), (g.a) null);
            this.zmT.setVisibility(8);
            this.zmK.setVisibility(0);
        }
        if (egf.Ngg == null || egf.Ngg.size() <= 1) {
            this.zmM.setVisibility(8);
        } else {
            g.a(this.zmM, egf.Ngg.get(1), (g.a) null);
        }
        if (egf.Ngi == null || jSONObject == null) {
            ehu();
        } else {
            this.zmV = egf.Ngi;
            boolean z3 = jSONObject.optInt(egf.Ngi.LXh, 0) == 1;
            long optLong = jSONObject.optLong(String.format("%s_expiretime", egf.Ngi.LXh), 0);
            if (optLong > 0 && System.currentTimeMillis() > optLong) {
                Log.i("MicroMsg.MallWalletSectionCellView", "red dot expired: %s, %s", egf.Ngi.LXh, Long.valueOf(optLong));
                z3 = false;
            }
            ehu();
            if (!z3) {
                ehu();
            } else if (egf.Ngi.type == 1) {
                if (!Util.isNullOrNil(this.zmK.getText())) {
                    this.zmO.setVisibility(0);
                } else {
                    this.zmN.setVisibility(0);
                }
            } else if (egf.Ngi.type == 2) {
                this.zmP.setVisibility(0);
            } else if (egf.Ngi.type == 3) {
                this.zmQ.setText(g.a(getContext(), egf.Ngi.Lov));
                this.zmQ.setVisibility(0);
            } else if (egf.Ngi.type == 4) {
                this.zmO.setVisibility(0);
                g.a(this.zmK, egf.Ngi.Lov, (g.a) null);
                WcPayMoneyLoadingView wcPayMoneyLoadingView = this.zmT;
                wcPayMoneyLoadingView.setVisibility(8);
                if (wcPayMoneyLoadingView.kdb != null) {
                    wcPayMoneyLoadingView.kdb.setVisibility(8);
                }
                wcPayMoneyLoadingView.removeCallbacks(wcPayMoneyLoadingView.Ios);
            } else {
                ehu();
            }
        }
        int i3 = qfn;
        int i4 = qfn;
        int i5 = qfn;
        int i6 = qfn;
        if (egf.MTe != null) {
            cyf cyf = egf.MTe;
            if (cyf.left > 0.0f) {
                i3 = bu(cyf.left);
            }
            if (cyf.right > 0.0f) {
                i5 = bu(cyf.right);
            }
            if (cyf.top > 0.0f) {
                i4 = bu(cyf.top);
            }
            if (cyf.bottom > 0.0f) {
                i6 = bu(cyf.bottom);
            }
            this.zmR.setPadding(i3, i4, i5, i6);
        }
        if (z) {
            this.zmJ.post(new Runnable() {
                /* class com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(66146);
                    Log.d("MicroMsg.MallWalletSectionCellView", "x: %s, left: %s", Float.valueOf(MallWalletSectionCellView.this.zmJ.getX()), Integer.valueOf(MallWalletSectionCellView.this.zmJ.getLeft()));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
                    layoutParams.leftMargin = MallWalletSectionCellView.this.zmJ.getLeft();
                    MallWalletSectionCellView.this.pYY.setLayoutParams(layoutParams);
                    MallWalletSectionCellView.this.pYY.setVisibility(0);
                    AppMethodBeat.o(66146);
                }
            });
        } else {
            this.pYY.setVisibility(8);
        }
        if (egf.KEP != null) {
            setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView.AnonymousClass2 */

                public final void onClick(View view) {
                    int i2;
                    AppMethodBeat.i(66147);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallWalletSectionCellView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_tiny_app_scene", 1019);
                    g.a(MallWalletSectionCellView.this.getContext(), egf.KEP, bundle);
                    xo xoVar = new xo();
                    xoVar.edO.viewId = egf.KNW;
                    EventCenter.instance.publish(xoVar);
                    MallWalletSectionCellView.a(MallWalletSectionCellView.this);
                    if (!(jSONObject == null || egf.Ngi == null)) {
                        jSONObject.remove(egf.Ngi.LXh);
                        jSONObject.remove(String.format("%s_expiretime", egf.Ngi.LXh));
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MALL_UI_ITEM_REDDOT_CONFIG_STRING_SYNC, jSONObject.toString());
                    }
                    String str = "";
                    if (egf.KEP.type == 1) {
                        str = egf.KEP.url;
                        i2 = 1;
                    } else if (egf.KEP.type == 2) {
                        if (egf.KEP.MTh != null) {
                            str = egf.KEP.MTh.username;
                        }
                        i2 = 2;
                    } else if (egf.KEP.type == 4) {
                        str = egf.KEP.url;
                        i2 = 3;
                    } else {
                        i2 = 0;
                    }
                    h.INSTANCE.a(16502, 2, str, Integer.valueOf(i2));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallWalletSectionCellView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66147);
                }
            });
        }
        AppMethodBeat.o(66152);
    }

    private int bu(float f2) {
        AppMethodBeat.i(66153);
        int fromDPToPix = a.fromDPToPix(getContext(), (int) f2);
        AppMethodBeat.o(66153);
        return fromDPToPix;
    }

    private void ehu() {
        AppMethodBeat.i(66154);
        this.zmP.setVisibility(8);
        this.zmN.setVisibility(8);
        this.zmO.setVisibility(8);
        this.zmQ.setVisibility(8);
        if (this.zmV != null && this.zmV.type == 4) {
            this.zmK.setText("");
        }
        AppMethodBeat.o(66154);
    }
}
