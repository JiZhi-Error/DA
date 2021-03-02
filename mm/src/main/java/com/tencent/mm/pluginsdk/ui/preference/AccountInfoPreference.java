package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.PluginStory;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.v;

public class AccountInfoPreference extends Preference {
    public View.OnClickListener AmH;
    private boolean BdH;
    private boolean BdI;
    private boolean BdJ;
    public d BgU;
    public SpannableString KoG;
    public String KoH;
    private RelativeLayout KoI;
    private View KoJ;
    private View KoK;
    public View KoL;
    private boolean KoM;
    private int KoN;
    private NoMeasuredTextView KoO;
    public ImageView KoP;
    private RelativeLayout KoQ;
    private FrameLayout KoR;
    private LinearLayout KoS;
    public boolean KoT;
    public boolean KoU;
    public View.OnClickListener KoV;
    private View.OnClickListener KoW;
    private View.OnClickListener KoX;
    private final String TAG;
    public boolean rFe;
    public String userName;

    public AccountInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountInfoPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(31806);
        this.TAG = "MicroMsg.AccountInfoPreference";
        this.BgU = null;
        this.BdJ = false;
        this.BdI = false;
        this.BdH = false;
        this.KoM = true;
        this.KoO = null;
        this.KoP = null;
        this.KoQ = null;
        this.KoR = null;
        this.KoS = null;
        this.KoT = false;
        this.KoU = true;
        this.rFe = false;
        this.AmH = null;
        this.KoV = null;
        this.KoW = null;
        this.KoX = new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(31805);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/pluginsdk/ui/preference/AccountInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.b(AccountInfoPreference.this.mContext, "setting", ".ui.setting.SettingsPersonalInfoUI", new Intent());
                a.a(this, "com/tencent/mm/pluginsdk/ui/preference/AccountInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31805);
            }
        };
        AppMethodBeat.o(31806);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(final View view) {
        int aH;
        AppMethodBeat.i(31807);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.x1);
        if (!(this.userName == null || imageView == null || !g.aAc())) {
            a.b.c(imageView, this.userName);
        }
        imageView.setOnClickListener(this.KoX);
        this.KoO = (NoMeasuredTextView) view.findViewById(R.id.fz_);
        if (!(this.userName == null || this.KoO == null)) {
            this.KoO.setShouldEllipsize(true);
            this.KoO.setTextSize(0, (float) com.tencent.mm.cb.a.aG(this.mContext, R.dimen.hd));
            if (!this.BdJ) {
                if (this.BdH) {
                    this.KoO.setTextColor(com.tencent.mm.cb.a.m(this.mContext, R.color.ag2));
                } else {
                    this.KoO.setTextColor(this.mContext.getResources().getColor(R.color.FG_0));
                }
            }
            this.KoO.setText(this.KoG == null ? this.userName : this.KoG);
            if (this.KoO.getPaint() != null) {
                this.KoO.getPaint().setFakeBoldText(true);
            }
        }
        TextView textView = (TextView) view.findViewById(R.id.j1l);
        if (this.KoH != null && textView != null) {
            textView.setText(view.getResources().getString(R.string.h5, this.KoH));
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        textView.setOnClickListener(this.KoX);
        TextView textView2 = (TextView) view.findViewById(R.id.h7d);
        if (textView2 != null) {
            if (this.KoN > 99) {
                textView2.setText(this.mContext.getString(R.string.hk6));
                textView2.setBackgroundResource(v.kH(this.mContext));
                textView2.setVisibility(0);
            } else if (this.KoN > 0) {
                textView2.setText(new StringBuilder().append(this.KoN).toString());
                textView2.setBackgroundResource(v.aQ(this.mContext, this.KoN));
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        this.KoI = (RelativeLayout) view.findViewById(R.id.gnx);
        this.KoI.setOnClickListener(this.KoX);
        this.KoJ = view.findViewById(R.id.dnn);
        this.KoK = view.findViewById(R.id.dnp);
        this.KoL = view.findViewById(R.id.dns);
        if (this.KoL != null) {
            if (this.BdH || !this.KoM) {
                aH = com.tencent.mm.cb.a.aH(this.mContext, R.dimen.agv);
            } else {
                aH = com.tencent.mm.cb.a.aH(this.mContext, R.dimen.agw);
            }
            if (this.BdJ) {
                aH = com.tencent.mm.cb.a.aH(this.mContext, R.dimen.agw);
            }
            this.KoL.setPadding(this.KoL.getPaddingLeft(), aH, this.KoL.getPaddingRight(), this.KoL.getPaddingBottom());
            if (this.BdJ) {
                this.KoL.setOnClickListener(this.KoX);
            } else {
                this.KoL.setOnClickListener(this.KoV);
            }
        }
        View view2 = this.KoL;
        if (this.BgU == null && p.fvC() && (view instanceof RelativeLayout)) {
            d moreTabCardView = ((com.tencent.mm.plugin.textstatus.a.c) g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).getMoreTabCardView(this.mContext, (RelativeLayout) view, (LinearLayout) view2);
            ((RelativeLayout) view).addView(moreTabCardView.getView());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) moreTabCardView.getView().getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.addRule(3, R.id.dns);
            moreTabCardView.DV(this.userName);
            this.BgU = moreTabCardView;
        }
        p(this.BdH, this.KoM, this.BdI);
        view.post(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference.AnonymousClass2 */

            public final void run() {
                int i2;
                boolean z = false;
                AppMethodBeat.i(169792);
                if (!AccountInfoPreference.this.rFe) {
                    AccountInfoPreference.this.KoP = (ImageView) view.findViewById(R.id.bbr);
                    AccountInfoPreference.this.KoQ = (RelativeLayout) view.findViewById(R.id.bbp);
                    AccountInfoPreference.this.KoR = (FrameLayout) view.findViewById(R.id.bbo);
                    AccountInfoPreference.this.KoS = (LinearLayout) view.findViewById(R.id.bc1);
                    AccountInfoPreference.this.rFe = true;
                    if (!AccountInfoPreference.this.BdH) {
                        i2 = com.tencent.mm.cb.a.aH(AccountInfoPreference.this.mContext, R.dimen.agv) - com.tencent.mm.cb.a.aH(AccountInfoPreference.this.mContext, R.dimen.agw);
                    } else {
                        i2 = 0;
                    }
                    Log.d("MicroMsg.AccountInfoPreference", "root.width:%s, root.height:%s, tip.width:%s, tip.height:%s, offsetY:%s", Integer.valueOf(AccountInfoPreference.this.KoR.getWidth()), Integer.valueOf(AccountInfoPreference.this.KoR.getHeight()), Integer.valueOf(AccountInfoPreference.this.KoP.getWidth()), Integer.valueOf(AccountInfoPreference.this.KoP.getHeight()), Integer.valueOf(i2));
                    ((e) g.ah(e.class)).getStoryUIFactory().b(AccountInfoPreference.this.KoR, AccountInfoPreference.this.KoP, i2);
                    AccountInfoPreference accountInfoPreference = AccountInfoPreference.this;
                    if (((e) g.ah(e.class)).isShowStoryCheck() && com.tencent.mm.y.c.axV().cO(352279, 266241)) {
                        z = true;
                    }
                    accountInfoPreference.KoT = z;
                    AccountInfoPreference.this.grG();
                }
                AppMethodBeat.o(169792);
            }
        });
        AppMethodBeat.o(31807);
    }

    public final void p(boolean z, boolean z2, boolean z3) {
        int aH;
        AppMethodBeat.i(232332);
        this.BdH = z;
        this.KoM = z2;
        this.BdI = z3;
        this.BdJ = p.fvC();
        if (this.KoO != null) {
            if (!this.BdJ) {
                if (z) {
                    this.KoO.setTextColor(com.tencent.mm.cb.a.m(this.mContext, R.color.ag2));
                } else {
                    this.KoO.setTextColor(this.mContext.getResources().getColor(R.color.FG_0));
                }
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.KoI.getLayoutParams();
            layoutParams.gravity = 8388693;
            this.KoI.setGravity(16);
            this.KoI.setLayoutParams(layoutParams);
        }
        if (!this.BdJ || !z3) {
            if (this.KoK != null) {
                this.KoK.setVisibility(0);
            }
        } else if (this.KoK != null) {
            this.KoK.setVisibility(8);
        }
        if (!this.BdJ || z3) {
            if (this.KoJ != null) {
                this.KoJ.setVisibility(8);
            }
        } else if (this.KoJ != null) {
            this.KoJ.setVisibility(0);
        }
        if (this.BdJ && this.KoL != null) {
            this.KoL.setOnClickListener(this.KoX);
        }
        if (this.KoL != null) {
            if (z || !z2) {
                aH = com.tencent.mm.cb.a.aH(this.mContext, R.dimen.agv);
            } else {
                aH = com.tencent.mm.cb.a.aH(this.mContext, R.dimen.agw);
            }
            if (this.BdJ) {
                aH = com.tencent.mm.cb.a.aH(this.mContext, R.dimen.agw);
            }
            this.KoL.setPadding(this.KoL.getPaddingLeft(), aH, this.KoL.getPaddingRight(), this.KoL.getPaddingBottom());
        }
        AppMethodBeat.o(232332);
    }

    public final void grF() {
        AppMethodBeat.i(169793);
        Log.i("MicroMsg.AccountInfoPreference", "forceStopBubbleTip this:%s, bindView:%s", this, Boolean.valueOf(this.rFe));
        if (!this.rFe) {
            AppMethodBeat.o(169793);
            return;
        }
        this.KoQ.setVisibility(8);
        if (((PluginStory) g.ah(PluginStory.class)).getStoryNewFeatureConfig().fng()) {
            this.KoS.setVisibility(8);
            AppMethodBeat.o(169793);
            return;
        }
        this.KoP.setVisibility(8);
        this.KoR.setVisibility(8);
        ((e) g.ah(e.class)).getStoryUIFactory().fR(this.KoP);
        AppMethodBeat.o(169793);
    }

    public final void grG() {
        AppMethodBeat.i(169794);
        Log.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip hasUnreadComment:%s, isListVisible:%s", Boolean.valueOf(this.KoT), Boolean.valueOf(this.KoU));
        if (!this.KoT || !this.KoU) {
            grF();
        } else {
            Log.i("MicroMsg.AccountInfoPreference", "activeBubbleTip this:%s, bindView:%s", this, Boolean.valueOf(this.rFe));
            if (this.rFe) {
                this.KoQ.setVisibility(0);
                if (((e) g.ah(e.class)).getStoryNewFeatureConfig().fng()) {
                    this.KoP.setVisibility(8);
                    this.KoR.setVisibility(4);
                    this.KoS.setVisibility(0);
                } else {
                    this.KoP.setVisibility(0);
                    this.KoR.setVisibility(0);
                    this.KoS.setVisibility(8);
                    ((e) g.ah(e.class)).getStoryUIFactory().fQ(this.KoP);
                }
            }
        }
        if (this.rFe) {
            Log.i("MicroMsg.AccountInfoPreference", "checkUnreadBubbleTip mBubbleContentNewGroup.visible:%s, mStoryBubbleTipViews.visible:%s", Integer.valueOf(this.KoS.getVisibility()), Integer.valueOf(this.KoP.getVisibility()));
        }
        AppMethodBeat.o(169794);
    }
}
