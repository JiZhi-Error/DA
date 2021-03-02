package com.tencent.mm.sdcard_migrate.a;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;

public final class c extends Dialog implements DialogInterface {
    private Button FNQ;
    private Button HRF;
    private LinearLayout NIA;
    private TextView NIB;
    public TextView NIC;
    public TextView NID;
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
    public a.AbstractC2051c NIU;
    private DialogInterface.OnDismissListener NIV;
    private View ahJ;
    com.tencent.mm.ui.widget.a.c iOnDialogDismissListener;
    private TextView jUu;
    private Context mContext;
    private EditText mEditText;
    private boolean needEdit = false;
    private LinearLayout nmr;
    private boolean ox;

    static /* synthetic */ void a(c cVar, int i2) {
        AppMethodBeat.i(204692);
        cVar.ajK(i2);
        AppMethodBeat.o(204692);
    }

    public c(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(204673);
        this.mContext = context;
        this.NIA = (LinearLayout) View.inflate(this.mContext, R.layout.b7i, null);
        this.HRF = (Button) this.NIA.findViewById(R.id.ffp);
        this.FNQ = (Button) this.NIA.findViewById(R.id.ffb);
        this.jUu = (TextView) this.NIA.findViewById(R.id.ffq);
        this.NIB = (TextView) this.NIA.findViewById(R.id.ffs);
        this.NIC = (TextView) this.NIA.findViewById(R.id.ffh);
        this.NID = (TextView) this.NIA.findViewById(R.id.ffi);
        this.NIE = (TextView) this.NIA.findViewById(R.id.ffn);
        this.NIF = (TextView) this.NIA.findViewById(R.id.ffm);
        this.NIG = (TextView) this.NIA.findViewById(R.id.b_c);
        this.mEditText = (EditText) this.NIA.findViewById(R.id.b_h);
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
        AppMethodBeat.o(204673);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(204674);
        super.onCreate(bundle);
        setContentView(this.NIA);
        AppMethodBeat.o(204674);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(204675);
        this.nmr.setVisibility(0);
        this.jUu.setVisibility(0);
        if (this.NIU != null) {
            a.AbstractC2051c cVar = this.NIU;
            charSequence.toString();
            this.jUu.getTextSize();
            charSequence = cVar.gxn();
        }
        this.jUu.setMaxLines(2);
        this.jUu.setText(charSequence);
        this.jUu.getPaint().setFakeBoldText(true);
        ajJ(this.mContext.getResources().getColor(R.color.FG_1));
        AppMethodBeat.o(204675);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i2) {
        AppMethodBeat.i(204676);
        this.nmr.setVisibility(0);
        this.jUu.setVisibility(0);
        this.jUu.setMaxLines(2);
        this.jUu.setText(i2);
        this.jUu.getPaint().setFakeBoldText(true);
        ajJ(this.mContext.getResources().getColor(R.color.FG_1));
        AppMethodBeat.o(204676);
    }

    private void ajJ(int i2) {
        AppMethodBeat.i(204677);
        if (this.NIC != null) {
            this.NIC.setTextColor(i2);
        }
        AppMethodBeat.o(204677);
    }

    public final void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(204678);
        this.NIK.setVisibility(0);
        this.NIC.setVisibility(0);
        if (this.NIU != null) {
            a.AbstractC2051c cVar = this.NIU;
            this.NIC.getContext();
            charSequence.toString();
            this.NIC.getTextSize();
            charSequence = cVar.gxn();
        }
        this.NIC.setText(charSequence);
        AppMethodBeat.o(204678);
    }

    private void AH(boolean z) {
        AppMethodBeat.i(204679);
        if (z) {
            int fromDPToPix = at.fromDPToPix(this.mContext, 8);
            this.NIK.setVisibility(0);
            this.NIK.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            this.NIK.setBackgroundResource(R.drawable.s3);
        }
        AppMethodBeat.o(204679);
    }

    private void ajK(int i2) {
        AppMethodBeat.i(204680);
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
                AppMethodBeat.o(204680);
                return;
            }
            this.mEditText.setVisibility(i2);
        }
        AppMethodBeat.o(204680);
    }

    private void gq(View view) {
        AppMethodBeat.i(204681);
        this.ahJ = view;
        if (this.ahJ != null) {
            this.NIK.setVisibility(0);
            this.NIM.setVisibility(0);
            this.NIM.removeAllViews();
            this.NIM.setGravity(1);
            this.NIM.addView(this.ahJ, new LinearLayout.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(204681);
    }

    private void a(CharSequence charSequence, final boolean z, final DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(204682);
        if (this.HRF == null) {
            AppMethodBeat.o(204682);
            return;
        }
        this.HRF.setVisibility(0);
        this.HRF.setText(charSequence);
        this.HRF.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.sdcard_migrate.a.c.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(204664);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (onClickListener != null) {
                    onClickListener.onClick(c.this, -1);
                }
                if (z) {
                    c.this.dismiss();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(204664);
            }
        });
        AppMethodBeat.o(204682);
    }

    private void ajL(int i2) {
        AppMethodBeat.i(204683);
        this.HRF.setTextColor(i2);
        AppMethodBeat.o(204683);
    }

    private void ajM(int i2) {
        AppMethodBeat.i(204684);
        this.FNQ.setTextColor(i2);
        AppMethodBeat.o(204684);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(204686);
        super.setCancelable(z);
        this.ox = z;
        setCanceledOnTouchOutside(this.ox);
        AppMethodBeat.o(204686);
    }

    private void b(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(204687);
        this.NIO.setVisibility(8);
        this.NIL.removeAllViews();
        this.NIL.addView(view, layoutParams);
        AppMethodBeat.o(204687);
    }

    public final void a(final a aVar) {
        CharSequence charSequence;
        LinearLayout linearLayout;
        CharSequence charSequence2;
        CharSequence charSequence3;
        LinearLayout linearLayout2;
        AppMethodBeat.i(204688);
        if (aVar.title != null && aVar.title.length() > 0) {
            int i2 = aVar.NIs;
            if (this.jUu != null) {
                this.jUu.setGravity(i2);
            }
            setTitle(aVar.title);
        }
        if (aVar.NHK != null && aVar.NHK.length() > 0) {
            CharSequence charSequence4 = aVar.NHK;
            this.nmr.setVisibility(0);
            this.NIB.setVisibility(0);
            if (this.NIU != null) {
                a.AbstractC2051c cVar = this.NIU;
                charSequence4.toString();
                this.jUu.getTextSize();
                charSequence4 = cVar.gxn();
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
            gq(aVar.vk);
        }
        if (aVar.NIn != null) {
            View view = aVar.NIn;
            this.nmr.setVisibility(0);
            this.NIJ.setLayoutResource(R.layout.vt);
            try {
                linearLayout2 = (LinearLayout) this.NIJ.inflate();
            } catch (Exception e2) {
                this.NIJ.setVisibility(0);
                linearLayout2 = null;
            }
            linearLayout2.addView(view);
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
            int i3 = aVar.NIu;
            this.NIK.setVisibility(i3);
            this.NIH.setVisibility(i3);
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
                if (this.NIU != null) {
                    a.AbstractC2051c cVar2 = this.NIU;
                    this.NIF.getContext();
                    charSequence3.toString();
                    this.NIF.getTextSize();
                    charSequence3 = cVar2.gxn();
                }
                this.NIF.setText(charSequence3);
            }
            if (aVar.NHW != null) {
                Bitmap bitmap = aVar.NHW;
                if (this.ahJ == null) {
                    this.NIK.setVisibility(0);
                    this.NIH.setVisibility(0);
                    this.NIH.setImageBitmap(bitmap);
                }
            }
        }
        if (aVar.NIy) {
            Bitmap bitmap2 = aVar.NHW;
            CharSequence charSequence6 = aVar.NHY;
            CharSequence charSequence7 = aVar.NHZ;
            View inflate = View.inflate(this.mContext, R.layout.vw, null);
            if (bitmap2 != null) {
                ImageView imageView = (ImageView) inflate.findViewById(R.id.ffl);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence6 != null) {
                TextView textView = (TextView) inflate.findViewById(R.id.ffn);
                textView.setVisibility(0);
                if (this.NIU != null) {
                    a.AbstractC2051c cVar3 = this.NIU;
                    charSequence6.toString();
                    textView.getTextSize();
                    charSequence6 = cVar3.gxn();
                }
                textView.setText(charSequence6);
            }
            if (charSequence7 != null) {
                TextView textView2 = (TextView) inflate.findViewById(R.id.ffm);
                textView2.setVisibility(0);
                if (this.NIU != null) {
                    a.AbstractC2051c cVar4 = this.NIU;
                    charSequence7.toString();
                    textView2.getTextSize();
                    charSequence2 = cVar4.gxn();
                } else {
                    charSequence2 = charSequence7;
                }
                textView2.setText(charSequence2);
            }
            gq(inflate);
        } else if (aVar.NIz) {
            Bitmap bitmap3 = aVar.NHW;
            CharSequence charSequence8 = aVar.NHY;
            CharSequence charSequence9 = aVar.NHZ;
            View inflate2 = View.inflate(this.mContext, R.layout.vx, null);
            if (bitmap3 != null) {
                ImageView imageView2 = (ImageView) inflate2.findViewById(R.id.ffl);
                imageView2.setVisibility(0);
                imageView2.setImageBitmap(bitmap3);
            }
            if (charSequence8 != null) {
                TextView textView3 = (TextView) inflate2.findViewById(R.id.ffn);
                textView3.setVisibility(0);
                if (this.NIU != null) {
                    a.AbstractC2051c cVar5 = this.NIU;
                    charSequence8.toString();
                    textView3.getTextSize();
                    charSequence8 = cVar5.gxn();
                }
                textView3.setText(charSequence8);
            }
            if (charSequence9 != null) {
                TextView textView4 = (TextView) inflate2.findViewById(R.id.ffm);
                textView4.setVisibility(0);
                if (this.NIU != null) {
                    a.AbstractC2051c cVar6 = this.NIU;
                    charSequence9.toString();
                    textView4.getTextSize();
                    charSequence = cVar6.gxn();
                } else {
                    charSequence = charSequence9;
                }
                textView4.setText(charSequence);
            }
            gq(inflate2);
        }
        if (!(aVar.NHO == null && aVar.NHP == null)) {
            String str2 = aVar.NHO;
            CharSequence charSequence10 = aVar.NHP;
            Boolean valueOf = Boolean.valueOf(aVar.NHQ);
            final a.b bVar = aVar.NHS;
            this.NIJ.setLayoutResource(R.layout.w6);
            try {
                linearLayout = (LinearLayout) this.NIJ.inflate();
            } catch (Exception e3) {
                this.NIJ.setVisibility(0);
                linearLayout = null;
            }
            if (!(linearLayout == null || str2 == null)) {
                ((ImageView) linearLayout.findViewById(R.id.iqa)).setVisibility(0);
            }
            if (!(linearLayout == null || charSequence10 == null)) {
                TextView textView5 = (TextView) linearLayout.findViewById(R.id.iqz);
                textView5.setVisibility(0);
                if (this.NIU != null) {
                    a.AbstractC2051c cVar7 = this.NIU;
                    charSequence10.toString();
                    this.jUu.getTextSize();
                    charSequence10 = cVar7.gxn();
                }
                textView5.setText(charSequence10);
            }
            if (valueOf.booleanValue() && linearLayout != null) {
                final ImageView imageView3 = (ImageView) linearLayout.findViewById(R.id.dwn);
                imageView3.setVisibility(0);
                ajK(0);
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.sdcard_migrate.a.c.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(204661);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (imageView3.isSelected()) {
                            c.this.NIN.startAnimation(c.this.NIT);
                            c.this.NIT.setAnimationListener(new Animation.AnimationListener() {
                                /* class com.tencent.mm.sdcard_migrate.a.c.AnonymousClass1.AnonymousClass1 */

                                public final void onAnimationStart(Animation animation) {
                                    AppMethodBeat.i(204657);
                                    c.a(c.this, c.this.NIQ);
                                    AppMethodBeat.o(204657);
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    AppMethodBeat.i(204658);
                                    c.this.NIN.setVisibility(8);
                                    c.a(c.this, 0);
                                    AppMethodBeat.o(204658);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }
                            });
                            ObjectAnimator.ofFloat(imageView3, "rotation", 180.0f, 0.0f).setDuration(200L).start();
                            imageView3.setSelected(false);
                        } else {
                            c.this.NIN.startAnimation(c.this.NIR);
                            c.this.NIR.setAnimationListener(new Animation.AnimationListener() {
                                /* class com.tencent.mm.sdcard_migrate.a.c.AnonymousClass1.AnonymousClass2 */

                                public final void onAnimationStart(Animation animation) {
                                    AppMethodBeat.i(204659);
                                    c.a(c.this, c.this.NIS);
                                    AppMethodBeat.o(204659);
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    AppMethodBeat.i(204660);
                                    c.this.NIN.setVisibility(0);
                                    c.a(c.this, 8);
                                    AppMethodBeat.o(204660);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }
                            });
                            ObjectAnimator.ofFloat(imageView3, "rotation", 0.0f, 180.0f).setDuration(200L).start();
                            imageView3.setSelected(true);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(204661);
                    }
                });
            }
        }
        if (aVar.NHT != null) {
            final a.AbstractC2050a aVar2 = aVar.NHT;
            if (this.NIK != null && this.NIK.getVisibility() == 0) {
                this.NIK.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.sdcard_migrate.a.c.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(204662);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(204662);
                    }
                });
            } else if (this.NIM != null) {
                this.NIM.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.sdcard_migrate.a.c.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(204663);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(204663);
                    }
                });
            }
        }
        if (aVar.NHL != null && aVar.NHL.length() > 0) {
            CharSequence charSequence11 = aVar.NHL;
            if (charSequence11 != null) {
                this.NIG.setVisibility(0);
                this.NIG.setText(charSequence11);
            }
            this.NIP = true;
            int i4 = aVar.NIr;
            if (this.NIG != null) {
                this.NIG.setGravity(i4);
            }
        }
        if (aVar.NHM != null && aVar.NHM.length() > 0) {
            CharSequence charSequence12 = aVar.NHM;
            this.mEditText.setVisibility(0);
            this.mEditText.setHint(charSequence12);
        }
        if (aVar.NHN) {
            this.needEdit = aVar.NHN;
            if (aVar.NHN) {
                this.mEditText.setVisibility(0);
            } else {
                this.mEditText.setVisibility(8);
            }
        }
        if (aVar.NIa != null && aVar.NIa.length() > 0) {
            a(aVar.NIa, aVar.NIx, aVar.NIi);
        }
        if (aVar.NIb != null && aVar.NIb.length() > 0) {
            a(aVar.NIb, aVar.NIj);
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
        if (aVar.NHU != null) {
            this.NIU = aVar.NHU;
        }
        setCancelable(aVar.ox);
        this.ox = aVar.ox;
        if (!this.ox) {
            super.setCancelable(aVar.NIf);
        }
        if (!(aVar.NIc == null && aVar.NId == null && aVar.NIe == null)) {
            View inflate3 = View.inflate(this.mContext, R.layout.w5, null);
            Button button = (Button) inflate3.findViewById(R.id.ff8);
            Button button2 = (Button) inflate3.findViewById(R.id.ff9);
            Button button3 = (Button) inflate3.findViewById(R.id.ff_);
            if (aVar.NIc != null) {
                button.setVisibility(0);
                button.setText(aVar.NIc);
                button.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.sdcard_migrate.a.c.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(204666);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (aVar.NIk != null) {
                            aVar.NIk.onClick(c.this, -1);
                        }
                        c.this.dismiss();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(204666);
                    }
                });
            }
            if (aVar.NId != null) {
                button2.setVisibility(0);
                button2.setText(aVar.NId);
                button2.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.sdcard_migrate.a.c.AnonymousClass7 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(204667);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (aVar.NIl != null) {
                            aVar.NIl.onClick(c.this, -2);
                        }
                        c.this.dismiss();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(204667);
                    }
                });
            }
            if (aVar.NIe != null) {
                button3.setVisibility(0);
                button3.setText(aVar.NIe);
                button3.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.sdcard_migrate.a.c.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(204668);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (aVar.NIm != null) {
                            aVar.NIm.onClick(c.this, -3);
                        }
                        c.this.dismiss();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(204668);
                    }
                });
            }
            b(inflate3, new LinearLayout.LayoutParams(-1, -1));
        }
        if (aVar.NHR) {
            View inflate4 = View.inflate(this.mContext, R.layout.vs, null);
            this.FNQ = (Button) inflate4.findViewById(R.id.ffb);
            this.HRF = (Button) inflate4.findViewById(R.id.ffp);
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
                a(aVar.NIb, aVar.NIj);
            }
            b(inflate4, new LinearLayout.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(204688);
    }

    public final void show() {
        AppMethodBeat.i(204689);
        try {
            super.show();
            AppMethodBeat.o(204689);
        } catch (Exception e2) {
            as.printErrStackTrace("MicroMsg.MMAlertDialog", e2, "", new Object[0]);
            AppMethodBeat.o(204689);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dismiss() {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdcard_migrate.a.c.dismiss():void");
    }

    public static class a {
        private a NJg = new a();
        private Context mContext;

        /* renamed from: com.tencent.mm.sdcard_migrate.a.c$a$a  reason: collision with other inner class name */
        public interface AbstractC2050a {
        }

        public interface b {
        }

        /* renamed from: com.tencent.mm.sdcard_migrate.a.c$a$c  reason: collision with other inner class name */
        public interface AbstractC2051c {
            CharSequence gxn();
        }

        public a(Context context) {
            AppMethodBeat.i(204670);
            this.mContext = context;
            AppMethodBeat.o(204670);
        }

        public final a bhS(String str) {
            this.NJg.title = null;
            return this;
        }

        public final a bhT(String str) {
            this.NJg.NHX = str;
            return this;
        }

        public final a bhU(String str) {
            this.NJg.NIa = str;
            return this;
        }

        public final a gxl() {
            AppMethodBeat.i(204671);
            this.NJg.NIa = this.mContext.getString(R.string.x_);
            AppMethodBeat.o(204671);
            return this;
        }

        public final a a(DialogInterface.OnClickListener onClickListener) {
            this.NJg.NIi = onClickListener;
            return this;
        }

        public final a bhV(String str) {
            this.NJg.NIb = str;
            return this;
        }

        public final a b(DialogInterface.OnClickListener onClickListener) {
            this.NJg.NIj = onClickListener;
            return this;
        }

        public final a AI(boolean z) {
            this.NJg.ox = false;
            return this;
        }

        public final c gxm() {
            AppMethodBeat.i(204672);
            c cVar = new c(this.mContext);
            cVar.a(this.NJg);
            AppMethodBeat.o(204672);
            return cVar;
        }
    }

    private void a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(204685);
        if (this.FNQ != null) {
            this.FNQ.setVisibility(0);
            this.FNQ.setText(charSequence);
            this.FNQ.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.sdcard_migrate.a.c.AnonymousClass5 */
                final /* synthetic */ boolean NJe = true;

                public final void onClick(View view) {
                    AppMethodBeat.i(204665);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (onClickListener != null) {
                        onClickListener.onClick(c.this, -2);
                    }
                    if (this.NJe) {
                        c.this.cancel();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(204665);
                }
            });
        }
        AppMethodBeat.o(204685);
    }

    static /* synthetic */ void a(c cVar, Animation animation) {
        AppMethodBeat.i(204691);
        if (cVar.NIK != null) {
            cVar.NIK.startAnimation(animation);
        }
        if (cVar.NIM != null) {
            cVar.NIM.startAnimation(animation);
        }
        if (cVar.NIG != null && cVar.NIP) {
            cVar.NIG.startAnimation(animation);
        }
        if (cVar.mEditText != null) {
            if (!cVar.needEdit) {
                cVar.mEditText.setVisibility(8);
                AppMethodBeat.o(204691);
                return;
            }
            cVar.mEditText.startAnimation(animation);
        }
        AppMethodBeat.o(204691);
    }
}
