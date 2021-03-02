package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.e;
import com.tencent.mm.api.h;
import com.tencent.mm.api.j;
import com.tencent.mm.api.r;
import com.tencent.mm.bt.b;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.footer.SelectColorBar;

public abstract class a extends e implements ViewTreeObserver.OnGlobalLayoutListener {
    private boolean PpR = true;
    private View RiA;
    private PhotoEditText RiB;
    private Switch RiC;
    protected h[] Riw;
    private View Rix;
    private com.tencent.mm.view.footer.a Riy;
    private View Riz;
    private com.tencent.mm.view.b.a dhg;
    private ab.a diP;
    public boolean diT = true;
    private b drS;
    private View nZg;
    private Button sTL;
    private Button zDY;
    private ChatFooterPanel zdv;

    public abstract h[] getFeatures();

    /* access modifiers changed from: protected */
    public abstract com.tencent.mm.view.b.a hfv();

    /* access modifiers changed from: protected */
    public abstract com.tencent.mm.view.footer.a hfw();

    public a(Context context) {
        super(context);
    }

    public ab.a getConfig() {
        return this.diP;
    }

    public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView() {
        if (this.Riy == null) {
            this.Riy = hfw();
        }
        return (T) this.Riy;
    }

    public <T extends com.tencent.mm.view.b.a> T getBaseBoardView() {
        if (this.dhg == null) {
            this.dhg = hfv();
        }
        return (T) this.dhg;
    }

    public View getFooterBg() {
        if (this.Rix == null) {
            this.Rix = LayoutInflater.from(getContext()).inflate(R.layout.am9, (ViewGroup) null);
            this.Rix.setVisibility(8);
        }
        return this.Rix;
    }

    public View getActionBar() {
        int i2;
        if (this.nZg == null) {
            this.nZg = LayoutInflater.from(getContext()).inflate(R.layout.bi2, (ViewGroup) null);
            if (ao.aQ(getContext())) {
                i2 = ao.aP(getContext()) + 0;
            } else {
                i2 = 0;
            }
            this.nZg.setPadding(0, i2, 0, 0);
            this.zDY = (Button) this.nZg.findViewById(R.id.bw6);
            this.zDY.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.view.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(9348);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/BaseDrawingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.getTextEditView().getVisibility() == 0) {
                        a.this.getPresenter().a(a.this.RiB.getText(), a.this.RiB.getCurrentTextColor(), a.this.RiC.isChecked() ? ((Integer) a.this.RiC.getTag()).intValue() : 0);
                    } else {
                        a.this.getPresenter().onFinish();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/BaseDrawingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(9348);
                }
            });
            this.sTL = (Button) this.nZg.findViewById(R.id.bw3);
            this.sTL.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.view.a.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(9354);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/BaseDrawingView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.getTextEditView().getVisibility() == 0) {
                        a.this.getPresenter().gtg();
                    } else {
                        a.this.getPresenter().onExit();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/BaseDrawingView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(9354);
                }
            });
        }
        return this.nZg;
    }

    public View getTextEditView() {
        if (this.Riz == null) {
            this.Riz = LayoutInflater.from(getContext()).inflate(R.layout.a0n, (ViewGroup) null);
            this.RiB = (PhotoEditText) this.Riz.findViewById(R.id.ik7);
            int dimension = (int) this.RiB.getResources().getDimension(R.dimen.a0u);
            int dimension2 = (int) this.RiB.getResources().getDimension(R.dimen.xl);
            if (ao.aQ(getContext())) {
                dimension2 += ao.aP(getContext());
            }
            this.RiB.setPadding(dimension, dimension2, dimension, 0);
            final SelectColorBar selectColorBar = (SelectColorBar) this.Riz.findViewById(R.id.hhf);
            this.RiC = (Switch) this.Riz.findViewById(R.id.a37);
            this.RiC.setTag(-707825);
            this.RiC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.tencent.mm.view.a.AnonymousClass7 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(9355);
                    if (z) {
                        selectColorBar.setSelectColor(((Integer) a.this.RiC.getTag()).intValue());
                        a.this.RiB.setTextBackground(((Integer) a.this.RiC.getTag()).intValue());
                        AppMethodBeat.o(9355);
                        return;
                    }
                    a.this.RiC.setTag(Integer.valueOf(selectColorBar.getCurColor()));
                    a.this.RiB.setTextBackground(0);
                    AppMethodBeat.o(9355);
                }
            });
            this.RiB.setTextColor(-1);
            selectColorBar.setSelectColor(-1);
            selectColorBar.setSelectColorListener(new SelectColorBar.a() {
                /* class com.tencent.mm.view.a.AnonymousClass8 */

                @Override // com.tencent.mm.view.footer.SelectColorBar.a
                public final void acC(int i2) {
                    AppMethodBeat.i(9356);
                    if (a.this.RiC.isChecked()) {
                        a.this.RiC.setTag(Integer.valueOf(i2));
                        a.this.RiB.setTextBackground(i2);
                        AppMethodBeat.o(9356);
                        return;
                    }
                    a.this.RiB.setTextColor(i2);
                    AppMethodBeat.o(9356);
                }
            });
        }
        return this.Riz;
    }

    public View getRubbishView() {
        if (this.Riz == null) {
            this.RiA = LayoutInflater.from(getContext()).inflate(R.layout.bnh, (ViewGroup) this, false);
        }
        return this.RiA;
    }

    public ChatFooterPanel getChatFooterPanel() {
        boolean z = false;
        if (this.zdv == null) {
            try {
                this.zdv = ad.bC(getContext());
                this.zdv.setEntranceScene(ChatFooterPanel.KbD);
                this.zdv.setShowSmiley(false);
                this.zdv.setShowClose(true);
                this.zdv.setVisibility(8);
                this.zdv.onResume();
                ac VK = ad.VK();
                VK.djc = new ac.a() {
                    /* class com.tencent.mm.view.a.AnonymousClass9 */

                    @Override // com.tencent.mm.api.ac.a
                    public final void a(r rVar) {
                        AppMethodBeat.i(9357);
                        Log.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", rVar);
                        a.this.getPresenter().c(rVar);
                        onHide();
                        AppMethodBeat.o(9357);
                    }

                    @Override // com.tencent.mm.api.ac.a
                    public final void onHide() {
                        AppMethodBeat.i(9358);
                        a.this.setActionBarVisible(true);
                        a.this.DC(true);
                        a.this.setFooterVisible(true);
                        AppMethodBeat.o(9358);
                    }
                };
                this.zdv.setCallback(VK);
            } catch (Exception e2) {
                Object[] objArr = new Object[2];
                objArr[0] = e2.getMessage();
                if (getContext() == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                Log.e("MicroMsg.BaseDrawingView", "exception:%s,getContext() is null?", objArr);
                throw e2;
            }
        }
        return this.zdv;
    }

    public void setup(ab.a aVar) {
        this.diP = aVar;
        getPresenter().a(getConfig());
        removeAllViews();
        addView(getBaseBoardView(), new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.a49));
        layoutParams.gravity = 80;
        addView(getFooterBg(), layoutParams);
        addView(getBaseFooterView(), layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        getTextEditView().setVisibility(8);
        addView(getTextEditView(), layoutParams2);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) getRubbishView().getLayoutParams();
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin += au.aD(getContext());
        layoutParams3.bottomMargin += com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
        getRubbishView().setVisibility(8);
        addView(getRubbishView(), layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ad.bD(getContext()));
        layoutParams4.gravity = 80;
        layoutParams4.bottomMargin += au.aD(getContext());
        addView(getChatFooterPanel(), layoutParams4);
        new FrameLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.b8)).gravity = 48;
        if (this.diP.diT) {
            addView(getActionBar());
        } else {
            getBaseFooterView().setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() {
            /* class com.tencent.mm.view.a.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(9359);
                a.this.getPresenter().onAttachedToWindow();
                AppMethodBeat.o(9359);
            }
        });
    }

    public b getPresenter() {
        if (this.drS == null) {
            this.drS = new com.tencent.mm.bt.a();
            this.drS.a(this);
        }
        return this.drS;
    }

    @Override // com.tencent.mm.api.e
    public void setActionBarCallback(j jVar) {
        getPresenter().setActionBarCallback(jVar);
    }

    @Override // com.tencent.mm.api.e
    public void setAutoShowFooterAndBar(boolean z) {
        getPresenter().setAutoShowFooterAndBar(z);
    }

    @Override // com.tencent.mm.api.e
    public void setFooterVisible(boolean z) {
        if (this.PpR != z && getConfig().diT) {
            getBaseFooterView().setFooterVisible(z);
            setFooterBgVisible(z);
            this.PpR = z;
        }
    }

    @Override // com.tencent.mm.api.e
    public void setActionBarVisible(boolean z) {
        if (this.diT == z) {
            Log.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
            return;
        }
        this.diT = z;
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.n);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.view.a.AnonymousClass11 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(9360);
                    a.this.getActionBar().setVisibility(0);
                    a.this.getFooterBg().setVisibility(0);
                    AppMethodBeat.o(9360);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            getActionBar().startAnimation(loadAnimation);
            return;
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.o);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.view.a.AnonymousClass12 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(9361);
                a.this.getActionBar().setVisibility(8);
                a.this.getFooterBg().setVisibility(8);
                AppMethodBeat.o(9361);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        getActionBar().startAnimation(loadAnimation2);
    }

    public void setFooterBgVisible(boolean z) {
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.n);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.view.a.AnonymousClass13 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(9362);
                    a.this.getFooterBg().setVisibility(0);
                    a.this.getActionBar().setVisibility(0);
                    AppMethodBeat.o(9362);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            getActionBar().startAnimation(loadAnimation);
            return;
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.o);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.view.a.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(9349);
                a.this.getFooterBg().setVisibility(8);
                a.this.getActionBar().setVisibility(8);
                AppMethodBeat.o(9349);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        getActionBar().startAnimation(loadAnimation2);
    }

    public final void DC(boolean z) {
        Log.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", Boolean.valueOf(z));
        if (this.zdv.getVisibility() == 0 && z) {
            this.zdv.setVisibility(8);
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f6do);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.view.a.AnonymousClass3 */

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(9350);
                    a.this.zdv.setVisibility(0);
                    AppMethodBeat.o(9350);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(9351);
                    a.this.zdv.setVisibility(8);
                    AppMethodBeat.o(9351);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.zdv.startAnimation(loadAnimation);
        } else if (this.zdv.getVisibility() == 8 && !z) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.dq);
            loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.view.a.AnonymousClass4 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(9352);
                    a.this.zdv.setVisibility(0);
                    AppMethodBeat.o(9352);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.zdv.startAnimation(loadAnimation2);
        }
    }

    public final boolean hfx() {
        return this.zdv.getVisibility() == 0 || getTextEditView().getVisibility() == 0;
    }

    public void onGlobalLayout() {
        if (getTextEditView().getVisibility() == 0) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.RiB.postDelayed(new Runnable() {
                /* class com.tencent.mm.view.a.AnonymousClass5 */

                public final void run() {
                    int bottom;
                    AppMethodBeat.i(9353);
                    Rect rect = new Rect();
                    a.this.getWindowVisibleDisplayFrame(rect);
                    boolean z = a.this.getBottom() - rect.bottom >= 300;
                    a.this.getResources().getDisplayMetrics();
                    if (!z) {
                        bottom = a.this.getBottom() - ((int) a.this.getResources().getDimension(R.dimen.xl));
                    } else {
                        bottom = (a.this.getBottom() - i.apu()) - ((int) a.this.getResources().getDimension(R.dimen.xl));
                        Log.e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", Integer.valueOf(bottom));
                    }
                    if (a.this.RiB.getHeight() != bottom) {
                        a.this.RiB.setHeight(bottom);
                    }
                    a.this.getViewTreeObserver().removeOnGlobalLayoutListener(a.this);
                    a.this.getViewTreeObserver().addOnGlobalLayoutListener(a.this);
                    AppMethodBeat.o(9353);
                }
            }, 160);
        }
    }
}
