package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.protocal.protobuf.eik;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;

public class TopStoryCommentFloatDialog extends RelativeLayout implements i, g {
    long EPV = 0;
    TextView GlA;
    SnsEditText GlD;
    f GqS;
    View Gra;
    boolean Grb = false;
    a Grc;
    private View.OnClickListener Grd = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.AnonymousClass8 */

        public final void onClick(View view) {
            AppMethodBeat.i(126656);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (TopStoryCommentFloatDialog.this.getVisibility() == 0) {
                TopStoryCommentFloatDialog.this.hide();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126656);
        }
    };
    MMActivity activity;
    public h gyh;
    TextView hXK;
    q tipDialog = null;
    TextView uCE;

    public interface a {
        void fzQ();

        void onDismiss();
    }

    static /* synthetic */ void a(TopStoryCommentFloatDialog topStoryCommentFloatDialog) {
        AppMethodBeat.i(126671);
        topStoryCommentFloatDialog.fyv();
        AppMethodBeat.o(126671);
    }

    static /* synthetic */ void b(TopStoryCommentFloatDialog topStoryCommentFloatDialog) {
        AppMethodBeat.i(126672);
        topStoryCommentFloatDialog.fzZ();
        AppMethodBeat.o(126672);
    }

    public TopStoryCommentFloatDialog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(126657);
        init();
        AppMethodBeat.o(126657);
    }

    public TopStoryCommentFloatDialog(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(126658);
        init();
        AppMethodBeat.o(126658);
    }

    private void init() {
        AppMethodBeat.i(126659);
        inflate(getContext(), R.layout.c3r, this);
        this.Gra = findViewById(R.id.b8p);
        this.GlD = (SnsEditText) findViewById(R.id.b9k);
        this.hXK = (TextView) findViewById(R.id.b4p);
        this.GlA = (TextView) findViewById(R.id.b4q);
        AppMethodBeat.o(126659);
    }

    public final void o(final MMActivity mMActivity) {
        AppMethodBeat.i(126660);
        this.activity = mMActivity;
        this.gyh = new h(mMActivity);
        setOnClickListener(this.Grd);
        findViewById(R.id.aid).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(126650);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TopStoryCommentFloatDialog.this.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126650);
            }
        });
        this.uCE = (TextView) findViewById(R.id.gf5);
        this.uCE.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(126651);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (System.currentTimeMillis() - TopStoryCommentFloatDialog.this.EPV < 500) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126651);
                    return;
                }
                TopStoryCommentFloatDialog.this.EPV = System.currentTimeMillis();
                String obj = TopStoryCommentFloatDialog.this.GlD.getText().toString();
                if (obj.length() > 200) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126651);
                } else if (obj.length() <= 0 || obj.trim().length() <= 0) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126651);
                } else if (!TopStoryCommentFloatDialog.dzA()) {
                    com.tencent.mm.ui.base.h.c(mMActivity, mMActivity.getString(R.string.dep), "", true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126651);
                } else {
                    TopStoryCommentFloatDialog.this.tipDialog = com.tencent.mm.ui.base.h.a((Context) mMActivity, mMActivity.getString(R.string.ys), false, (DialogInterface.OnCancelListener) null);
                    f fVar = new f(TopStoryCommentFloatDialog.this.GqS);
                    ((eik) fVar.rr.iLK.iLR).iAc = obj;
                    com.tencent.mm.kernel.g.azz().a(fVar, 0);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126651);
                }
            }
        });
        fyv();
        fzZ();
        this.GlD.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(126652);
                TopStoryCommentFloatDialog.a(TopStoryCommentFloatDialog.this);
                TopStoryCommentFloatDialog.b(TopStoryCommentFloatDialog.this);
                AppMethodBeat.o(126652);
            }
        });
        post(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(126653);
                TopStoryCommentFloatDialog.this.gyh.start();
                AppMethodBeat.o(126653);
            }
        });
        AppMethodBeat.o(126660);
    }

    public final void a(f fVar, a aVar, int i2, int i3) {
        AppMethodBeat.i(126661);
        this.Grb = true;
        this.GqS = fVar;
        setVisibility(0);
        this.GlD.requestFocus();
        this.activity.showVKB();
        this.Grc = aVar;
        eik fyd = fVar.fyd();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17080, 7, 2, "action=14&channelId=" + i2 + "&mpScene=0&kykScene=" + fyd.Scene + "&kykSubScene=0&itemType=" + i3 + "&searchId=" + fyd.Mbb + "&docId=" + fyd.MEq + "&byPass=" + fyd.MRt);
        AppMethodBeat.o(126661);
    }

    public final void hide() {
        AppMethodBeat.i(126662);
        if (this.GlD.getText().toString().length() > 0) {
            com.tencent.mm.ui.base.h.a((Context) this.activity, (int) R.string.hq8, 0, (int) R.string.a0_, (int) R.string.x6, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(126655);
                    TopStoryCommentFloatDialog.this.fzY();
                    AppMethodBeat.o(126655);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            }, (int) R.color.g7);
            AppMethodBeat.o(126662);
            return;
        }
        fzY();
        AppMethodBeat.o(126662);
    }

    public final void fzY() {
        AppMethodBeat.i(126663);
        this.GlD.setText("");
        setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Gra.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.Gra.setLayoutParams(layoutParams);
        this.activity.hideVKB();
        this.Grb = false;
        if (this.Grc != null) {
            this.Grc.onDismiss();
        }
        AppMethodBeat.o(126663);
    }

    public final void onPause() {
        AppMethodBeat.i(126664);
        this.gyh.Quk = null;
        com.tencent.mm.kernel.g.azz().b(2906, this);
        AppMethodBeat.o(126664);
    }

    public final void onResume() {
        AppMethodBeat.i(126665);
        this.gyh.Quk = this;
        com.tencent.mm.kernel.g.azz().a(2906, this);
        AppMethodBeat.o(126665);
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(final int i2, boolean z) {
        AppMethodBeat.i(126666);
        Log.i("MicroMsg.TopStoryCommentFloatDialog", "onKeyboardHeightChanged in pixels: ".concat(String.valueOf(i2)));
        if (this.Grb) {
            this.Gra.setVisibility(0);
            if (((RelativeLayout.LayoutParams) this.Gra.getLayoutParams()).bottomMargin != i2) {
                AnonymousClass5 r0 = new Animation() {
                    /* class com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.AnonymousClass5 */

                    /* access modifiers changed from: protected */
                    public final void applyTransformation(float f2, Transformation transformation) {
                        AppMethodBeat.i(126654);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) TopStoryCommentFloatDialog.this.Gra.getLayoutParams();
                        layoutParams.bottomMargin = (int) (((float) i2) * f2);
                        TopStoryCommentFloatDialog.this.Gra.setLayoutParams(layoutParams);
                        AppMethodBeat.o(126654);
                    }
                };
                if (i2 != 0) {
                    r0.setDuration(200);
                } else {
                    r0.setDuration(300);
                }
                this.Gra.startAnimation(r0);
            }
            this.GlD.requestFocus();
            setVisibility(0);
        }
        AppMethodBeat.o(126666);
    }

    private void fyv() {
        int color;
        AppMethodBeat.i(126667);
        int length = this.GlD.getText().toString().length();
        if (length < 180) {
            this.hXK.setVisibility(8);
            this.GlA.setVisibility(8);
            AppMethodBeat.o(126667);
            return;
        }
        this.hXK.setVisibility(0);
        this.GlA.setVisibility(0);
        if (length <= 200) {
            color = getResources().getColor(R.color.aby);
        } else {
            color = getResources().getColor(R.color.a5c);
        }
        this.hXK.setText(String.valueOf(length));
        this.hXK.setTextColor(color);
        AppMethodBeat.o(126667);
    }

    private void fzZ() {
        AppMethodBeat.i(126668);
        int length = this.GlD.getText().toString().length();
        int length2 = this.GlD.getText().toString().trim().length();
        if (length > 200 || length <= 0 || length2 <= 0) {
            this.uCE.setBackgroundResource(R.drawable.b0k);
            AppMethodBeat.o(126668);
            return;
        }
        this.uCE.setBackgroundResource(R.drawable.b0j);
        AppMethodBeat.o(126668);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String str2;
        String str3;
        AppMethodBeat.i(126669);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i2 == 0 && i3 == 0) {
            fzY();
            if (this.Grc != null) {
                this.Grc.fzQ();
            }
            if (qVar instanceof f) {
                f fVar = (f) qVar;
                com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i();
                try {
                    eik eik = (eik) fVar.rr.iLK.iLR;
                    if (eik != null) {
                        str2 = eik.iAc;
                    } else {
                        str2 = "";
                    }
                    iVar.h("content", str2);
                    iVar.h("id", fVar.fyc().NhH);
                    eik eik2 = (eik) fVar.rr.iLK.iLR;
                    if (eik2 != null) {
                        str3 = eik2.MEq;
                    } else {
                        str3 = "";
                    }
                    iVar.h("docId", str3);
                    iVar.h("opType", "REPLY_ARTICLE_BY_ME");
                    kn knVar = new kn();
                    knVar.dPD.dPE = iVar.toString();
                    knVar.dPD.dPF = "";
                    EventCenter.instance.publish(knVar);
                } catch (com.tencent.mm.ab.g e2) {
                    Log.e("MicroMsg.TopStoryCommentFloatDialog", "notify tl failed");
                }
            }
            u.makeText(this.activity, (int) R.string.hq_, 0).show();
            AppMethodBeat.o(126669);
            return;
        }
        com.tencent.mm.ui.base.h.c(this.activity, this.activity.getString(R.string.u5), "", true);
        AppMethodBeat.o(126669);
    }

    protected static boolean dzA() {
        boolean z;
        AppMethodBeat.i(126670);
        if (com.tencent.mm.kernel.g.aAe().azG().aBb()) {
            int aYS = com.tencent.mm.kernel.g.azz().aYS();
            if (aYS == 4 || aYS == 6) {
                AppMethodBeat.o(126670);
                return true;
            }
            AppMethodBeat.o(126670);
            return false;
        }
        if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(126670);
            return true;
        }
        AppMethodBeat.o(126670);
        return false;
    }
}
