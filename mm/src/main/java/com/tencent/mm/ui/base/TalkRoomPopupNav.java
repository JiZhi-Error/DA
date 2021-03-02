package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;

public class TalkRoomPopupNav extends LinearLayout {
    private View OFk;
    private com.tencent.mm.ui.chatting.e.a OFl;
    private WeImageView OFm;
    private LinearLayout OJh;
    private LinearLayout OJs;
    private LinearLayout OJt;
    private int OJw;
    private WeImageView OWA;
    private WeImageView OWB;
    private int OWC = 0;
    private int OWD = 0;
    Animation OWE;
    private AlphaAnimation OWF;
    private AlphaAnimation OWG;
    private a OWu;
    private LinearLayout OWv;
    public LinearLayout OWw;
    private LinearLayout OWx;
    private View OWy;
    private Button OWz;
    private View obi;

    public interface a {
        void bme(String str);

        void gLw();
    }

    @TargetApi(11)
    public TalkRoomPopupNav(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(33875);
        initView();
        AppMethodBeat.o(33875);
    }

    public TalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33876);
        initView();
        AppMethodBeat.o(33876);
    }

    public void setOnClickListener(a aVar) {
        this.OWu = aVar;
    }

    public void setNavContent(String str) {
        AppMethodBeat.i(33877);
        ((TextView) findViewById(R.id.iy2)).setText(str);
        AppMethodBeat.o(33877);
    }

    public void setDialogContent(String str) {
        AppMethodBeat.i(33878);
        ((TextView) findViewById(R.id.ix9)).setText(str);
        AppMethodBeat.o(33878);
    }

    public void setBgViewResource(int i2) {
        AppMethodBeat.i(33879);
        if (this.OJh != null) {
            this.OJh.setBackgroundResource(i2);
        }
        AppMethodBeat.o(33879);
    }

    public final void setIconRes$255f295(int i2) {
        AppMethodBeat.i(232761);
        if (this.OWA != null) {
            this.OWA.setImageResource(R.raw.icons_filled_location);
            this.OWA.setIconColor(i2);
        }
        AppMethodBeat.o(232761);
    }

    public final void gLu() {
        AppMethodBeat.i(232762);
        if (this.OWB != null) {
            this.OWB.setVisibility(8);
        }
        AppMethodBeat.o(232762);
    }

    public void setRootTipsBarBackground(View view) {
        this.OFk = view;
    }

    public void setChattingContext(com.tencent.mm.ui.chatting.e.a aVar) {
        this.OFl = aVar;
    }

    public final void gLv() {
        AppMethodBeat.i(232763);
        if (this.OFk != null) {
            this.OFk.setVisibility(8);
        }
        AppMethodBeat.o(232763);
    }

    public final void Bo(boolean z) {
        AppMethodBeat.i(232764);
        if (this.OFk != null) {
            if (z) {
                this.OFk.setVisibility(0);
                if (this.obi != null) {
                    this.obi.setVisibility(8);
                }
                if (this.OJh != null) {
                    this.OJh.setBackgroundColor(0);
                }
                if (this.OFm != null) {
                    this.OFm.setVisibility(4);
                }
                if (this.OFl != null) {
                    this.OFl.hideVKB();
                    AppMethodBeat.o(232764);
                    return;
                }
            } else {
                this.OFk.setVisibility(8);
                if (this.obi != null) {
                    this.obi.setVisibility(0);
                }
                if (this.OJh != null) {
                    this.OJh.setBackgroundResource(R.drawable.azy);
                }
                if (this.OFm != null) {
                    this.OFm.setVisibility(0);
                }
            }
        }
        AppMethodBeat.o(232764);
    }

    private void initView() {
        AppMethodBeat.i(33882);
        inflate(getContext(), R.layout.c1j, this);
        this.obi = findViewById(R.id.aar);
        this.OJh = (LinearLayout) findViewById(R.id.ftq);
        this.OWv = (LinearLayout) findViewById(R.id.ftr);
        this.OWw = (LinearLayout) findViewById(R.id.br4);
        this.OWx = (LinearLayout) findViewById(R.id.dw5);
        this.OJs = (LinearLayout) findViewById(R.id.dw7);
        this.OJt = (LinearLayout) findViewById(R.id.dw6);
        this.OWy = findViewById(R.id.aen);
        this.OWz = (Button) findViewById(R.id.aeq);
        this.OFm = (WeImageView) findViewById(R.id.uk);
        this.OWA = (WeImageView) findViewById(R.id.ihv);
        this.OWB = (WeImageView) findViewById(R.id.ihw);
        this.OWB.setVisibility(8);
        this.OJh.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.base.TalkRoomPopupNav.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(33865);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (TalkRoomPopupNav.this.OWu != null) {
                    TalkRoomPopupNav.this.OWu.gLw();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(33865);
            }
        });
        if (this.OFk != null) {
            this.OFk.setVisibility(8);
        }
        this.OWC = this.OJh.getLayoutParams().height;
        this.OWD = this.OWw.getLayoutParams().height;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.OJw = (int) Math.floor((double) (((float) (displayMetrics.widthPixels - at.fromDPToPix(getContext(), 56))) / ((float) at.fromDPToPix(getContext(), 48))));
        AppMethodBeat.o(33882);
    }

    public final void N(final String str, List<String> list) {
        int i2 = 0;
        AppMethodBeat.i(232765);
        this.OWz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.base.TalkRoomPopupNav.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(33866);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TalkRoomPopupNav.b(TalkRoomPopupNav.this);
                if (TalkRoomPopupNav.this.OWu != null) {
                    TalkRoomPopupNav.this.OWu.bme(str);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(33866);
            }
        });
        this.OWy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.base.TalkRoomPopupNav.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(33867);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TalkRoomPopupNav.b(TalkRoomPopupNav.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(33867);
            }
        });
        if (this.OFk != null) {
            this.OFk.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.base.TalkRoomPopupNav.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(232760);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    TalkRoomPopupNav.b(TalkRoomPopupNav.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232760);
                }
            });
        }
        if (this.OWw.getVisibility() != 0) {
            this.OWw.setVisibility(0);
            Bo(true);
            this.OWw.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dn));
            if (this.OFk != null) {
                this.OFk.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.br));
            }
        }
        this.OWx.setVisibility(0);
        this.OWx.removeAllViews();
        if (list != null) {
            if (list.size() > this.OJw) {
                this.OJs.setVisibility(0);
                this.OJs.removeAllViews();
            }
            if (list.size() > this.OJw * 2) {
                this.OJt.setVisibility(0);
                this.OJt.removeAllViews();
            }
        }
        for (String str2 : list) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40));
            layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(layoutParams);
            if (i2 < this.OJw) {
                this.OWx.addView(imageView);
            } else if (i2 >= this.OJw && i2 < this.OJw * 2) {
                this.OJs.addView(imageView);
            } else if (i2 >= this.OJw * 2 && i2 < this.OJw * 3) {
                this.OJt.addView(imageView);
            }
            a.b.c(imageView, str2);
            i2++;
        }
        AppMethodBeat.o(232765);
    }

    public final void jc(List<String> list) {
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(232766);
        if (this.OWx == null || this.OWx.getVisibility() != 0) {
            z = false;
        } else {
            this.OWx.removeAllViews();
            z = true;
        }
        if (this.OJs != null && this.OJs.getVisibility() == 0) {
            this.OJs.removeAllViews();
            z = true;
        }
        if (this.OJt != null && this.OJt.getVisibility() == 0) {
            this.OJt.removeAllViews();
            z = true;
        }
        if (z) {
            for (String str : list) {
                ImageView imageView = new ImageView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40));
                layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                if (i2 < this.OJw) {
                    this.OWx.addView(imageView);
                } else if (i2 >= this.OJw && i2 < this.OJw * 2) {
                    this.OJs.addView(imageView);
                } else if (i2 >= this.OJw * 2 && i2 < this.OJw * 3) {
                    this.OJt.addView(imageView);
                }
                a.b.c(imageView, str);
                i2++;
            }
        }
        AppMethodBeat.o(232766);
    }

    public final void updateView() {
        AppMethodBeat.i(232767);
        if (this.OWw != null) {
            if (this.OWw.getVisibility() == 0 && this.OWE == null) {
                Bo(true);
                AppMethodBeat.o(232767);
                return;
            }
            Bo(false);
        }
        AppMethodBeat.o(232767);
    }

    public final void stop() {
        AppMethodBeat.i(33884);
        if (!(this.OWF == null || this.OWG == null)) {
            BackwardSupportUtil.AnimationHelper.cancelAnimation(this.OWB, this.OWF);
            BackwardSupportUtil.AnimationHelper.cancelAnimation(this.OWB, this.OWG);
            this.OWB.clearAnimation();
            this.OWF = null;
            this.OWG = null;
        }
        AppMethodBeat.o(33884);
    }

    static /* synthetic */ void b(TalkRoomPopupNav talkRoomPopupNav) {
        AppMethodBeat.i(33885);
        talkRoomPopupNav.Bo(false);
        if (talkRoomPopupNav.OWw.getVisibility() == 0) {
            talkRoomPopupNav.OWE = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.anim.dr);
            talkRoomPopupNav.OWE.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.ui.base.TalkRoomPopupNav.AnonymousClass5 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(33869);
                    TalkRoomPopupNav.this.OWE = null;
                    TalkRoomPopupNav.this.OWw.setVisibility(8);
                    AppMethodBeat.o(33869);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            talkRoomPopupNav.OWw.startAnimation(talkRoomPopupNav.OWE);
        } else {
            talkRoomPopupNav.OWv.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.anim.br));
        }
        talkRoomPopupNav.OJh.setClickable(true);
        AppMethodBeat.o(33885);
    }
}
