package com.tencent.mm.ui.widget.a;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class d extends Dialog implements DialogInterface {
    private Button FNQ;
    private Button HRF;
    private LinearLayout NIA;
    private TextView NIB;
    public TextView NIC;
    private TextView NIE;
    private TextView NIF;
    private TextView NIG;
    private ImageView NIH;
    private View NII;
    private ViewStub NIJ;
    public LinearLayout NIK;
    private ViewGroup NIL;
    private LinearLayout NIM;
    private ViewGroup NIN;
    private View NIO;
    private boolean NIP = false;
    private Animation NIQ;
    private Animation NIR;
    private Animation NIS;
    private Animation NIT;
    public DialogInterface.OnDismissListener NIV;
    private a.AbstractC2137d QNz;
    CheckBox afU;
    private View ahJ;
    public c iOnDialogDismissListener;
    private TextView jUu;
    private Context mContext;
    public EditText mEditText;
    private boolean needEdit = false;
    private LinearLayout nmr;
    private boolean ox;

    static /* synthetic */ void a(d dVar, int i2) {
        AppMethodBeat.i(159339);
        dVar.ajK(i2);
        AppMethodBeat.o(159339);
    }

    public d(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(159314);
        this.mContext = context;
        hbj();
        AppMethodBeat.o(159314);
    }

    public d(Context context, byte b2) {
        super(context, R.style.a66);
        AppMethodBeat.i(198217);
        this.mContext = context;
        hbj();
        AppMethodBeat.o(198217);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(159315);
        super.onCreate(bundle);
        setContentView(this.NIA);
        AppMethodBeat.o(159315);
    }

    public View getContentView() {
        return this.NIA;
    }

    private void hbj() {
        AppMethodBeat.i(198218);
        this.NIA = (LinearLayout) View.inflate(this.mContext, R.layout.b7g, null);
        this.HRF = (Button) this.NIA.findViewById(R.id.ffp);
        this.FNQ = (Button) this.NIA.findViewById(R.id.ffb);
        this.jUu = (TextView) this.NIA.findViewById(R.id.ffq);
        this.NIB = (TextView) this.NIA.findViewById(R.id.ffs);
        this.NIC = (TextView) this.NIA.findViewById(R.id.ffh);
        this.NIE = (TextView) this.NIA.findViewById(R.id.ffn);
        this.NIF = (TextView) this.NIA.findViewById(R.id.ffm);
        this.NIG = (TextView) this.NIA.findViewById(R.id.b_c);
        this.mEditText = (EditText) this.NIA.findViewById(R.id.b_h);
        this.afU = (CheckBox) this.NIA.findViewById(R.id.b__);
        this.NIH = (ImageView) this.NIA.findViewById(R.id.ffl);
        this.nmr = (LinearLayout) this.NIA.findViewById(R.id.ffr);
        this.NIJ = (ViewStub) this.NIA.findViewById(R.id.iql);
        this.NIK = (LinearLayout) this.NIA.findViewById(R.id.ffj);
        this.NIL = (ViewGroup) this.NIA.findViewById(R.id.ff6);
        this.NIO = this.NIA.findViewById(R.id.ffa);
        this.NIM = (LinearLayout) this.NIA.findViewById(R.id.ffd);
        this.NIN = (ViewGroup) this.NIA.findViewById(R.id.iqk);
        setCanceledOnTouchOutside(true);
        this.NIQ = AnimationUtils.loadAnimation(this.mContext, R.anim.n);
        this.NIR = AnimationUtils.loadAnimation(this.mContext, R.anim.n);
        this.NIS = AnimationUtils.loadAnimation(this.mContext, R.anim.o);
        this.NIT = AnimationUtils.loadAnimation(this.mContext, R.anim.o);
        AppMethodBeat.o(198218);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(159316);
        this.nmr.setVisibility(0);
        this.jUu.setVisibility(0);
        if (this.QNz != null) {
            charSequence = this.QNz.a(charSequence.toString(), this.jUu.getTextSize());
        }
        this.jUu.setMaxLines(2);
        this.jUu.setText(charSequence);
        this.jUu.getPaint().setFakeBoldText(true);
        ajJ(this.mContext.getResources().getColor(R.color.FG_1));
        AppMethodBeat.o(159316);
    }

    public final void aoM(int i2) {
        AppMethodBeat.i(198219);
        if (this.jUu != null) {
            this.jUu.setGravity(i2);
        }
        AppMethodBeat.o(198219);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        AppMethodBeat.i(159317);
        this.nmr.setVisibility(0);
        this.jUu.setVisibility(0);
        this.jUu.setMaxLines(2);
        this.jUu.setText(i2);
        this.jUu.getPaint().setFakeBoldText(true);
        ajJ(this.mContext.getResources().getColor(R.color.FG_1));
        AppMethodBeat.o(159317);
    }

    private void ajJ(int i2) {
        AppMethodBeat.i(159318);
        if (this.NIC != null) {
            this.NIC.setTextColor(i2);
        }
        AppMethodBeat.o(159318);
    }

    public final void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(159319);
        this.NIK.setVisibility(0);
        this.NIC.setVisibility(0);
        if (this.QNz != null) {
            a.AbstractC2137d dVar = this.QNz;
            this.NIC.getContext();
            charSequence = dVar.a(charSequence.toString(), this.NIC.getTextSize());
        }
        this.NIC.setText(charSequence);
        AppMethodBeat.o(159319);
    }

    private void AH(boolean z) {
        AppMethodBeat.i(159320);
        if (z) {
            int fromDPToPix = at.fromDPToPix(this.mContext, 8);
            this.NIK.setVisibility(0);
            this.NIK.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        }
        AppMethodBeat.o(159320);
    }

    public final void aoN(int i2) {
        AppMethodBeat.i(198220);
        if (this.NIG != null) {
            this.NIG.setGravity(i2);
        }
        AppMethodBeat.o(198220);
    }

    public final void ay(CharSequence charSequence) {
        AppMethodBeat.i(198221);
        this.mEditText.setVisibility(0);
        this.mEditText.setHint(charSequence);
        AppMethodBeat.o(198221);
    }

    public final void Dg(boolean z) {
        AppMethodBeat.i(198222);
        if (z) {
            this.mEditText.setVisibility(0);
            AppMethodBeat.o(198222);
            return;
        }
        this.mEditText.setVisibility(8);
        AppMethodBeat.o(198222);
    }

    public final String hbk() {
        AppMethodBeat.i(159321);
        if (this.mEditText == null) {
            AppMethodBeat.o(159321);
            return null;
        }
        String obj = this.mEditText.getText().toString();
        AppMethodBeat.o(159321);
        return obj;
    }

    public final int hbl() {
        AppMethodBeat.i(159322);
        if (this.mEditText instanceof PasterEditText) {
            int pasterLen = ((PasterEditText) this.mEditText).getPasterLen();
            AppMethodBeat.o(159322);
            return pasterLen;
        }
        AppMethodBeat.o(159322);
        return 0;
    }

    public final void b(final a.b bVar) {
        AppMethodBeat.i(159323);
        if (this.NIK == null || this.NIK.getVisibility() != 0) {
            if (this.NIM != null) {
                this.NIM.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.widget.a.d.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(159299);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (bVar != null) {
                            bVar.cXd();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(159299);
                    }
                });
            }
            AppMethodBeat.o(159323);
            return;
        }
        this.NIK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.a.d.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(159298);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (bVar != null) {
                    bVar.cXd();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159298);
            }
        });
        AppMethodBeat.o(159323);
    }

    private void ajK(int i2) {
        AppMethodBeat.i(159324);
        if (this.NIK != null) {
            this.NIK.setVisibility(i2);
        }
        if (this.NIM != null) {
            this.NIM.setVisibility(i2);
        }
        if (this.NIG != null && this.NIP) {
            this.NIG.setVisibility(i2);
        }
        if (this.mEditText != null) {
            if (!this.needEdit) {
                this.mEditText.setVisibility(8);
                AppMethodBeat.o(159324);
                return;
            }
            this.mEditText.setVisibility(i2);
        }
        AppMethodBeat.o(159324);
    }

    private void aN(View view, int i2) {
        AppMethodBeat.i(159325);
        this.ahJ = view;
        if (this.ahJ != null) {
            this.NIK.setVisibility(0);
            this.NIM.setVisibility(0);
            this.NIM.removeAllViews();
            this.NIM.setGravity(1);
            this.NIM.addView(this.ahJ, new LinearLayout.LayoutParams(i2, i2));
        }
        AppMethodBeat.o(159325);
    }

    public final void a(CharSequence charSequence, final boolean z, final DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(159326);
        if (this.HRF == null) {
            AppMethodBeat.o(159326);
            return;
        }
        this.HRF.setVisibility(0);
        this.HRF.setText(charSequence);
        this.HRF.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.a.d.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(159300);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (onClickListener != null) {
                    onClickListener.onClick(d.this, -1);
                }
                if (z) {
                    d.this.dismiss();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159300);
            }
        });
        AppMethodBeat.o(159326);
    }

    public final void ajL(int i2) {
        AppMethodBeat.i(159327);
        this.HRF.setTextColor(i2);
        AppMethodBeat.o(159327);
    }

    public final void ajM(int i2) {
        AppMethodBeat.i(159328);
        this.FNQ.setTextColor(i2);
        AppMethodBeat.o(159328);
    }

    public final void b(CharSequence charSequence, final boolean z, final DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(159330);
        if (this.FNQ == null) {
            AppMethodBeat.o(159330);
            return;
        }
        this.FNQ.setVisibility(0);
        this.FNQ.setText(charSequence);
        this.FNQ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.a.d.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(159301);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (onClickListener != null) {
                    onClickListener.onClick(d.this, -2);
                }
                if (z) {
                    d.this.cancel();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159301);
            }
        });
        AppMethodBeat.o(159330);
    }

    public final void bT(int i2, boolean z) {
        AppMethodBeat.i(198223);
        switch (i2) {
            case -1:
                if (z) {
                    this.HRF.setVisibility(0);
                    AppMethodBeat.o(198223);
                    return;
                }
                this.HRF.setVisibility(8);
                AppMethodBeat.o(198223);
                return;
            case -2:
                if (!z) {
                    this.FNQ.setVisibility(8);
                    break;
                } else {
                    this.FNQ.setVisibility(0);
                    AppMethodBeat.o(198223);
                    return;
                }
        }
        AppMethodBeat.o(198223);
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.i(159332);
        super.setCancelable(z);
        this.ox = z;
        setCanceledOnTouchOutside(this.ox);
        AppMethodBeat.o(159332);
    }

    public final void Dh(boolean z) {
        AppMethodBeat.i(159333);
        super.setCancelable(z);
        AppMethodBeat.o(159333);
    }

    public final Button getButton(int i2) {
        switch (i2) {
            case -2:
                return this.FNQ;
            case -1:
                return this.HRF;
            default:
                return null;
        }
    }

    public final ImageView hbm() {
        return this.NIH;
    }

    private void b(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(159334);
        this.NIO.setVisibility(8);
        this.NIL.removeAllViews();
        this.NIL.addView(view, layoutParams);
        AppMethodBeat.o(159334);
    }

    public final void a(final a aVar) {
        CharSequence charSequence;
        Bitmap bitmap;
        CharSequence charSequence2;
        CharSequence charSequence3;
        LinearLayout linearLayout;
        AppMethodBeat.i(159335);
        if (aVar.title != null && aVar.title.length() > 0) {
            aoM(aVar.NIs);
            setTitle(aVar.title);
        }
        if (aVar.NHK != null && aVar.NHK.length() > 0) {
            CharSequence charSequence4 = aVar.NHK;
            this.nmr.setVisibility(0);
            this.NIB.setVisibility(0);
            if (this.QNz != null) {
                charSequence4 = this.QNz.a(charSequence4.toString(), this.jUu.getTextSize());
            }
            this.NIB.setText(charSequence4);
        }
        if (aVar.Kaw != 0) {
            this.jUu.setTextColor(ColorStateList.valueOf(aVar.Kaw));
        }
        if (aVar.NIp != 0) {
            this.jUu.setMaxLines(aVar.NIp);
        }
        if (aVar.NIq != 0) {
            this.NIC.setMaxLines(aVar.NIq);
        }
        if (aVar.vk != null) {
            aN(aVar.vk, -1);
        }
        if (aVar.NIn != null) {
            View view = aVar.NIn;
            this.nmr.setVisibility(0);
            this.NIJ.setLayoutResource(R.layout.vt);
            try {
                linearLayout = (LinearLayout) this.NIJ.inflate();
            } catch (Exception e2) {
                this.NIJ.setVisibility(0);
                linearLayout = null;
            }
            linearLayout.addView(view);
        }
        if (aVar.NIo != null) {
            this.NII = aVar.NIo;
            if (this.NII != null) {
                this.NIK.setVisibility(8);
                this.NIG.setVisibility(8);
                this.mEditText.setVisibility(8);
                this.NIN.removeAllViews();
                this.NIN.addView(this.NII, new LinearLayout.LayoutParams(-1, -1));
                this.NIN.setVisibility(8);
            }
        }
        if (aVar.NHV != null) {
            Drawable drawable = aVar.NHV;
            if (this.ahJ == null) {
                this.NIK.setVisibility(0);
                this.NIH.setVisibility(0);
                this.NIH.setBackgroundDrawable(drawable);
            }
        }
        if (aVar.NHX != null && aVar.NHX.length() > 0) {
            setMessage(aVar.NHX);
        }
        AH(aVar.NIg);
        if (aVar.thumbPath != null) {
            String str = aVar.thumbPath;
            int fromDPToPix = at.fromDPToPix(this.mContext, 120);
            this.NIK.setVisibility(0);
            this.NIH.setVisibility(0);
            if (this.NIH instanceof com.tencent.mm.ui.g.a) {
                ((com.tencent.mm.ui.g.a) this.NIH).aM(str, fromDPToPix, fromDPToPix);
            }
            int i2 = aVar.NIu;
            this.NIK.setVisibility(i2);
            this.NIH.setVisibility(i2);
        }
        if (!aVar.NIy && !aVar.NIz) {
            if (aVar.NHX != null && aVar.NHX.length() > 0) {
                setMessage(aVar.NHX);
            }
            if (aVar.NHY == null || aVar.NHY.length() <= 0) {
                AH(false);
            } else {
                CharSequence charSequence5 = aVar.NHY;
                this.NIK.setVisibility(0);
                this.NIE.setVisibility(0);
                this.NIE.setMaxLines(2);
                this.NIE.setText(charSequence5);
            }
            if (!(aVar.NHZ == null || aVar.NHZ.length() <= 0 || (charSequence3 = aVar.NHZ) == null)) {
                this.NIK.setVisibility(0);
                this.NIF.setVisibility(0);
                if (this.QNz != null) {
                    a.AbstractC2137d dVar = this.QNz;
                    this.NIF.getContext();
                    charSequence3 = dVar.a(charSequence3.toString(), this.NIF.getTextSize());
                }
                this.NIF.setText(charSequence3);
            }
            if (aVar.NHW != null) {
                Bitmap bitmap2 = aVar.NHW;
                if (this.ahJ == null) {
                    this.NIK.setVisibility(0);
                    this.NIH.setVisibility(0);
                    this.NIH.setImageBitmap(bitmap2);
                }
            }
        }
        if (aVar.NIy) {
            Bitmap bitmap3 = aVar.NHW;
            CharSequence charSequence6 = aVar.NHY;
            CharSequence charSequence7 = aVar.NHZ;
            View inflate = View.inflate(this.mContext, R.layout.vw, null);
            if (bitmap3 != null) {
                ImageView imageView = (ImageView) inflate.findViewById(R.id.ffl);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap3);
            }
            if (charSequence6 != null) {
                TextView textView = (TextView) inflate.findViewById(R.id.ffn);
                textView.setVisibility(0);
                if (this.QNz != null) {
                    charSequence6 = this.QNz.a(charSequence6.toString(), textView.getTextSize());
                }
                textView.setText(charSequence6);
            }
            if (charSequence7 != null) {
                TextView textView2 = (TextView) inflate.findViewById(R.id.ffm);
                textView2.setVisibility(0);
                if (this.QNz != null) {
                    charSequence2 = this.QNz.a(charSequence7.toString(), textView2.getTextSize());
                } else {
                    charSequence2 = charSequence7;
                }
                textView2.setText(charSequence2);
            }
            aN(inflate, -1);
        } else if (aVar.NIz) {
            Bitmap bitmap4 = aVar.NHW;
            CharSequence charSequence8 = aVar.NHY;
            CharSequence charSequence9 = aVar.NHZ;
            View inflate2 = View.inflate(this.mContext, R.layout.vx, null);
            if (bitmap4 != null) {
                ImageView imageView2 = (ImageView) inflate2.findViewById(R.id.ffl);
                imageView2.setVisibility(0);
                imageView2.setImageBitmap(bitmap4);
            }
            if (charSequence8 != null) {
                TextView textView3 = (TextView) inflate2.findViewById(R.id.ffn);
                textView3.setVisibility(0);
                if (this.QNz != null) {
                    charSequence8 = this.QNz.a(charSequence8.toString(), textView3.getTextSize());
                }
                textView3.setText(charSequence8);
            }
            if (charSequence9 != null) {
                TextView textView4 = (TextView) inflate2.findViewById(R.id.ffm);
                textView4.setVisibility(0);
                if (this.QNz != null) {
                    charSequence = this.QNz.a(charSequence9.toString(), textView4.getTextSize());
                } else {
                    charSequence = charSequence9;
                }
                textView4.setText(charSequence);
            }
            aN(inflate2, -1);
        }
        if (!(aVar.NHO == null && aVar.NHP == null)) {
            String str2 = aVar.NHO;
            CharSequence charSequence10 = aVar.NHP;
            Boolean valueOf = Boolean.valueOf(aVar.NHQ);
            final a.c cVar = aVar.QNt;
            a.AbstractC2136a aVar2 = aVar.QNu;
            this.NIJ.setLayoutResource(R.layout.w6);
            LinearLayout linearLayout2 = null;
            try {
                linearLayout2 = (LinearLayout) this.NIJ.inflate();
            } catch (Exception e3) {
                this.NIJ.setVisibility(0);
            }
            if (!(linearLayout2 == null || str2 == null)) {
                ImageView imageView3 = (ImageView) linearLayout2.findViewById(R.id.iqa);
                imageView3.setVisibility(0);
                if (aVar2 != null) {
                    aVar2.C(imageView3, str2);
                }
            }
            if (!(linearLayout2 == null || charSequence10 == null)) {
                TextView textView5 = (TextView) linearLayout2.findViewById(R.id.iqz);
                textView5.setVisibility(0);
                if (this.QNz != null) {
                    charSequence10 = this.QNz.a(charSequence10.toString(), this.jUu.getTextSize());
                }
                textView5.setText(charSequence10);
            }
            if (valueOf.booleanValue() && linearLayout2 != null) {
                final ImageView imageView4 = (ImageView) linearLayout2.findViewById(R.id.dwn);
                imageView4.setVisibility(0);
                ajK(0);
                linearLayout2.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.widget.a.d.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(159297);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (cVar != null) {
                            cVar.gpw();
                        }
                        if (imageView4.isSelected()) {
                            d.this.NIN.startAnimation(d.this.NIT);
                            d.this.NIT.setAnimationListener(new Animation.AnimationListener() {
                                /* class com.tencent.mm.ui.widget.a.d.AnonymousClass1.AnonymousClass1 */

                                public final void onAnimationStart(Animation animation) {
                                    AppMethodBeat.i(159293);
                                    d.a(d.this, d.this.NIQ);
                                    AppMethodBeat.o(159293);
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    AppMethodBeat.i(159294);
                                    d.this.NIN.setVisibility(8);
                                    d.a(d.this, 0);
                                    AppMethodBeat.o(159294);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }
                            });
                            ObjectAnimator.ofFloat(imageView4, "rotation", 180.0f, 0.0f).setDuration(200L).start();
                            imageView4.setSelected(false);
                        } else {
                            d.this.NIN.startAnimation(d.this.NIR);
                            d.this.NIR.setAnimationListener(new Animation.AnimationListener() {
                                /* class com.tencent.mm.ui.widget.a.d.AnonymousClass1.AnonymousClass2 */

                                public final void onAnimationStart(Animation animation) {
                                    AppMethodBeat.i(159295);
                                    d.a(d.this, d.this.NIS);
                                    AppMethodBeat.o(159295);
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    AppMethodBeat.i(159296);
                                    d.this.NIN.setVisibility(0);
                                    d.a(d.this, 8);
                                    AppMethodBeat.o(159296);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }
                            });
                            ObjectAnimator.ofFloat(imageView4, "rotation", 0.0f, 180.0f).setDuration(200L).start();
                            imageView4.setSelected(true);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(159297);
                    }
                });
            }
        }
        if (aVar.QNv != null) {
            b(aVar.QNv);
        }
        if (aVar.QNx != null && !aVar.QNx.isRecycled()) {
            Bitmap bitmap5 = aVar.QNx;
            boolean z = aVar.NIh;
            int i3 = aVar.NIt;
            if (bitmap5 != null) {
                AH(false);
                this.NIK.setVisibility(0);
                this.NIK.setGravity(1);
                this.NIK.setPadding(0, 0, 0, 0);
                View inflate3 = View.inflate(this.mContext, R.layout.vy, null);
                ImageView imageView5 = (ImageView) inflate3.findViewById(R.id.ffl);
                if (z) {
                    Bitmap bitmap6 = null;
                    float height = ((float) bitmap5.getHeight()) / ((float) bitmap5.getWidth());
                    int i4 = 0;
                    int i5 = 0;
                    int aH = at.aH(this.mContext, R.dimen.bg);
                    int aH2 = at.aH(this.mContext, R.dimen.bf);
                    int i6 = 0;
                    int i7 = 0;
                    if (height > 0.0f && ((double) height) < 0.5d) {
                        i5 = (int) (((float) aH) / height);
                        i7 = aH;
                        i6 = aH2;
                        i4 = aH;
                    } else if (((double) height) >= 0.5d && height < 1.0f) {
                        int i8 = (int) (((float) aH2) * height);
                        i7 = i8;
                        i6 = aH2;
                        i5 = aH2;
                        i4 = i8;
                    } else if (height >= 1.0f && height < 2.0f) {
                        int i9 = (int) (((float) aH2) / height);
                        i7 = aH2;
                        i6 = i9;
                        i5 = i9;
                        i4 = aH2;
                    } else if (height >= 2.0f) {
                        i4 = (int) (((float) aH) * height);
                        i7 = aH2;
                        i6 = aH;
                        i5 = aH;
                    }
                    if (i4 > 0 && i5 > 0 && bitmap5 != null) {
                        bitmap6 = Bitmap.createScaledBitmap(bitmap5, i5, i4, true);
                        imageView5.setLayoutParams(new FrameLayout.LayoutParams(i6, i7));
                    }
                    bitmap = aq.a(bitmap6, (float) at.fromDPToPix(this.mContext, 3));
                } else {
                    bitmap = bitmap5;
                }
                imageView5.setImageBitmap(bitmap);
                ImageView imageView6 = (ImageView) inflate3.findViewById(R.id.dwm);
                if (i3 == 0) {
                    imageView6.setVisibility(8);
                } else {
                    imageView6.setVisibility(0);
                    if (i3 == 1) {
                        imageView6.setImageResource(R.raw.sight_icon_in_gird);
                    } else if (i3 == 2) {
                        imageView6.setImageResource(R.raw.video_icon_in_gird);
                    }
                }
                aN(inflate3, -2);
            }
        }
        if (aVar.NHL != null && aVar.NHL.length() > 0) {
            CharSequence charSequence11 = aVar.NHL;
            if (charSequence11 != null) {
                this.NIG.setVisibility(0);
                this.NIG.setText(charSequence11);
            }
            this.NIP = true;
            aoN(aVar.NIr);
        }
        if (aVar.NHM != null && aVar.NHM.length() > 0) {
            ay(aVar.NHM);
        }
        if (aVar.QNs != null && aVar.QNs.length() > 0) {
            CharSequence charSequence12 = aVar.QNs;
            this.afU.setVisibility(0);
            this.afU.setText(charSequence12);
        }
        if (aVar.NHN) {
            this.needEdit = aVar.NHN;
            Dg(aVar.NHN);
        }
        if (aVar.NIa != null && aVar.NIa.length() > 0) {
            a(aVar.NIa, aVar.NIx, aVar.NIi);
        }
        if (aVar.NIb != null && aVar.NIb.length() > 0) {
            b(aVar.NIb, true, aVar.NIj);
        }
        if (aVar.NIw != 0) {
            ajL(aVar.NIw);
        }
        if (aVar.NIv != 0) {
            ajM(aVar.NIv);
        }
        if (aVar.XY != null) {
            setOnCancelListener(aVar.XY);
        }
        if (aVar.XZ != null) {
            this.NIV = aVar.XZ;
            setOnDismissListener(aVar.XZ);
        }
        if (aVar.QNw != null) {
            this.QNz = aVar.QNw;
        }
        setCancelable(aVar.ox);
        this.ox = aVar.ox;
        if (!this.ox) {
            super.setCancelable(aVar.NIf);
        }
        if (!(aVar.NIc == null && aVar.NId == null && aVar.NIe == null)) {
            View inflate4 = View.inflate(this.mContext, R.layout.w5, null);
            Button button = (Button) inflate4.findViewById(R.id.ff8);
            Button button2 = (Button) inflate4.findViewById(R.id.ff9);
            Button button3 = (Button) inflate4.findViewById(R.id.ff_);
            if (aVar.NIc != null) {
                button.setVisibility(0);
                button.setText(aVar.NIc);
                button.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.widget.a.d.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(159302);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (aVar.NIk != null) {
                            aVar.NIk.onClick(d.this, -1);
                        }
                        d.this.dismiss();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(159302);
                    }
                });
            }
            if (aVar.NId != null) {
                button2.setVisibility(0);
                button2.setText(aVar.NId);
                button2.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.widget.a.d.AnonymousClass7 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(159303);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (aVar.NIl != null) {
                            aVar.NIl.onClick(d.this, -2);
                        }
                        d.this.dismiss();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(159303);
                    }
                });
            }
            if (aVar.NIe != null) {
                button3.setVisibility(0);
                button3.setText(aVar.NIe);
                button3.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.widget.a.d.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(159304);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (aVar.NIm != null) {
                            aVar.NIm.onClick(d.this, -3);
                        }
                        d.this.dismiss();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(159304);
                    }
                });
            }
            b(inflate4, new LinearLayout.LayoutParams(-1, -1));
        }
        if (aVar.NHR) {
            View inflate5 = View.inflate(this.mContext, R.layout.vs, null);
            this.FNQ = (Button) inflate5.findViewById(R.id.ffb);
            this.HRF = (Button) inflate5.findViewById(R.id.ffp);
            if (aVar.NIw != 0) {
                ajL(aVar.NIw);
            }
            if (aVar.NIv != 0) {
                ajM(aVar.NIv);
            }
            if (aVar.NIa != null && aVar.NIa.length() > 0) {
                a(aVar.NIa, aVar.NIx, aVar.NIi);
            }
            if (aVar.NIb != null && aVar.NIb.length() > 0) {
                b(aVar.NIb, true, aVar.NIj);
            }
            b(inflate5, new LinearLayout.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(159335);
    }

    public void show() {
        AppMethodBeat.i(159336);
        try {
            super.show();
            AppMethodBeat.o(159336);
        } catch (Exception e2) {
            as.printErrStackTrace("MicroMsg.MMAlertDialog", e2, "", new Object[0]);
            AppMethodBeat.o(159336);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dismiss() {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.a.d.dismiss():void");
    }

    public static class a {
        public a QNF = new a();
        public Context mContext;

        /* renamed from: com.tencent.mm.ui.widget.a.d$a$a  reason: collision with other inner class name */
        public interface AbstractC2136a {
            void C(ImageView imageView, String str);
        }

        public interface b {
            void cXd();
        }

        public interface c {
            void gpw();
        }

        /* renamed from: com.tencent.mm.ui.widget.a.d$a$d  reason: collision with other inner class name */
        public interface AbstractC2137d {
            CharSequence a(CharSequence charSequence, float f2);
        }

        public a(Context context) {
            AppMethodBeat.i(159306);
            this.mContext = context;
            AppMethodBeat.o(159306);
        }

        public final a bon(String str) {
            this.QNF.title = str;
            return this;
        }

        public final a az(CharSequence charSequence) {
            this.QNF.title = charSequence;
            return this;
        }

        public final a aA(CharSequence charSequence) {
            this.QNF.NHK = charSequence;
            return this;
        }

        public final a aoO(int i2) {
            AppMethodBeat.i(159307);
            this.QNF.title = com.tencent.mm.ui.e.a.kn(this.mContext).getString(i2);
            AppMethodBeat.o(159307);
            return this;
        }

        public final a aoP(int i2) {
            this.QNF.Kaw = i2;
            return this;
        }

        public final a aoQ(int i2) {
            this.QNF.NIp = i2;
            return this;
        }

        public final a aoR(int i2) {
            this.QNF.NIs = i2;
            return this;
        }

        public final a boo(String str) {
            this.QNF.NHX = str;
            return this;
        }

        public final a aoS(int i2) {
            AppMethodBeat.i(159308);
            this.QNF.NHX = com.tencent.mm.ui.e.a.kn(this.mContext).getString(i2);
            AppMethodBeat.o(159308);
            return this;
        }

        public final a aoT(int i2) {
            this.QNF.NIq = i2;
            return this;
        }

        public final a aB(CharSequence charSequence) {
            this.QNF.NHY = charSequence;
            return this;
        }

        public final a bop(String str) {
            this.QNF.NHZ = str;
            return this;
        }

        public final a Di(boolean z) {
            this.QNF.NIg = z;
            return this;
        }

        public final a a(String str, CharSequence charSequence, Boolean bool, c cVar, AbstractC2136a aVar) {
            AppMethodBeat.i(159309);
            this.QNF.NHO = str;
            this.QNF.NHP = charSequence;
            this.QNF.NHQ = bool.booleanValue();
            this.QNF.QNt = cVar;
            this.QNF.QNu = aVar;
            AppMethodBeat.o(159309);
            return this;
        }

        public final a c(b bVar) {
            this.QNF.QNv = bVar;
            return this;
        }

        public final a a(AbstractC2137d dVar) {
            this.QNF.QNw = dVar;
            return this;
        }

        public final a aN(Bitmap bitmap) {
            this.QNF.NHW = bitmap;
            return this;
        }

        public final a boq(String str) {
            this.QNF.thumbPath = str;
            return this;
        }

        public final a b(Bitmap bitmap, boolean z, int i2) {
            this.QNF.QNx = bitmap;
            this.QNF.NIh = z;
            this.QNF.NIt = i2;
            return this;
        }

        public final a bor(String str) {
            this.QNF.NHL = str;
            return this;
        }

        public final a aoU(int i2) {
            this.QNF.NIr = i2;
            return this;
        }

        public final a bos(String str) {
            this.QNF.NHM = str;
            return this;
        }

        public final a bot(String str) {
            this.QNF.QNs = str;
            return this;
        }

        public final a Dj(boolean z) {
            this.QNF.NHN = z;
            return this;
        }

        public final a hs(View view) {
            this.QNF.vk = view;
            return this;
        }

        public final a ht(View view) {
            this.QNF.NIn = view;
            return this;
        }

        public final a bou(String str) {
            this.QNF.NIa = str;
            return this;
        }

        public final a aoV(int i2) {
            AppMethodBeat.i(159310);
            this.QNF.NIa = com.tencent.mm.ui.e.a.kn(this.mContext).getString(i2);
            AppMethodBeat.o(159310);
            return this;
        }

        public final a c(DialogInterface.OnClickListener onClickListener) {
            this.QNF.NIi = onClickListener;
            return this;
        }

        public final a a(boolean z, DialogInterface.OnClickListener onClickListener) {
            this.QNF.NIi = onClickListener;
            this.QNF.NIx = z;
            return this;
        }

        public final a bov(String str) {
            this.QNF.NIb = str;
            return this;
        }

        public final a aoW(int i2) {
            AppMethodBeat.i(159311);
            this.QNF.NIb = com.tencent.mm.ui.e.a.kn(this.mContext).getString(i2);
            AppMethodBeat.o(159311);
            return this;
        }

        public final a aoX(int i2) {
            this.QNF.NIw = i2;
            return this;
        }

        public final a aoY(int i2) {
            this.QNF.NIv = i2;
            return this;
        }

        public final a d(DialogInterface.OnClickListener onClickListener) {
            this.QNF.NIj = onClickListener;
            return this;
        }

        public final a f(DialogInterface.OnCancelListener onCancelListener) {
            this.QNF.XY = onCancelListener;
            return this;
        }

        public final a a(DialogInterface.OnDismissListener onDismissListener) {
            this.QNF.XZ = onDismissListener;
            return this;
        }

        public final a Dk(boolean z) {
            this.QNF.ox = z;
            return this;
        }

        public final a Dl(boolean z) {
            this.QNF.NIf = z;
            return this;
        }

        public final d hbn() {
            AppMethodBeat.i(159312);
            d dVar = new d(this.mContext, (byte) 0);
            dVar.a(this.QNF);
            AppMethodBeat.o(159312);
            return dVar;
        }

        public final void show() {
            AppMethodBeat.i(258267);
            hbn().show();
            AppMethodBeat.o(258267);
        }
    }

    public final void a(int i2, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(159329);
        a(com.tencent.mm.ui.e.a.kn(this.mContext).getString(i2), true, onClickListener);
        AppMethodBeat.o(159329);
    }

    public final void b(int i2, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(159331);
        b(com.tencent.mm.ui.e.a.kn(this.mContext).getString(i2), true, onClickListener);
        AppMethodBeat.o(159331);
    }

    static /* synthetic */ void a(d dVar, Animation animation) {
        AppMethodBeat.i(159338);
        if (dVar.NIK != null) {
            dVar.NIK.startAnimation(animation);
        }
        if (dVar.NIM != null) {
            dVar.NIM.startAnimation(animation);
        }
        if (dVar.NIG != null && dVar.NIP) {
            dVar.NIG.startAnimation(animation);
        }
        if (dVar.mEditText != null) {
            if (!dVar.needEdit) {
                dVar.mEditText.setVisibility(8);
                AppMethodBeat.o(159338);
                return;
            }
            dVar.mEditText.startAnimation(animation);
        }
        AppMethodBeat.o(159338);
    }
}
