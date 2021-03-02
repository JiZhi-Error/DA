package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;

public class LiveTalkRoomTipsBar extends LinearLayout {
    public q OFb;
    private RelativeLayout OFc;
    public RelativeLayout OFd;
    private RelativeLayout OFe;
    private FrameLayout OFf;
    private TextView OFg;
    private ImageView OFh;
    private View OFi;
    public ListView OFj;
    private View OFk;
    private a OFl;
    private WeImageView OFm;
    private View OFn;
    private boolean OFo;
    public Context context;
    private View obi;
    private View psf;

    static /* synthetic */ void a(LiveTalkRoomTipsBar liveTalkRoomTipsBar, boolean z) {
        AppMethodBeat.i(232616);
        liveTalkRoomTipsBar.bc(z, true);
        AppMethodBeat.o(232616);
    }

    @TargetApi(11)
    public LiveTalkRoomTipsBar(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(232607);
        this.context = context2;
        initView();
        AppMethodBeat.o(232607);
    }

    public LiveTalkRoomTipsBar(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(232608);
        this.context = context2;
        initView();
        AppMethodBeat.o(232608);
    }

    public void setRootTipsBarBackground(View view) {
        this.OFk = view;
    }

    public void setChattingContext(a aVar) {
        this.OFl = aVar;
    }

    public void setChattingUserName(String str) {
        if (this.OFb != null) {
            this.OFb.hwa = str;
        }
    }

    public final void gID() {
        AppMethodBeat.i(232609);
        if (this.OFb != null) {
            q qVar = this.OFb;
            ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().hLf = qVar.hLf;
        }
        AppMethodBeat.o(232609);
    }

    public void setInChatRoom(boolean z) {
        this.OFo = z;
    }

    private void initView() {
        AppMethodBeat.i(232610);
        inflate(getContext(), R.layout.b1l, this);
        this.OFc = (RelativeLayout) findViewById(R.id.em9);
        this.OFh = (ImageView) findViewById(R.id.em8);
        this.OFh.setImageDrawable(ar.m(getContext(), R.raw.room_live_icon, getContext().getResources().getColor(R.color.a5r)));
        this.OFg = (TextView) findViewById(R.id.emc);
        this.OFe = (RelativeLayout) findViewById(R.id.em6);
        this.obi = findViewById(R.id.aar);
        this.OFm = (WeImageView) findViewById(R.id.uk);
        this.OFn = findViewById(R.id.em5);
        this.OFd = (RelativeLayout) findViewById(R.id.emd);
        this.OFf = (FrameLayout) findViewById(R.id.eme);
        this.OFj = (ListView) findViewById(R.id.ema);
        this.psf = aa.jQ(this.context).inflate(R.layout.b1m, (ViewGroup) null);
        this.OFj.addFooterView(this.psf);
        this.OFi = findViewById(R.id.em_);
        bc(true, false);
        this.OFc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.LiveTalkRoomTipsBar.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(232602);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (LiveTalkRoomTipsBar.this.OFb.OFs != null) {
                    int count = LiveTalkRoomTipsBar.this.OFb.OFs.getCount();
                    if (count <= 0) {
                        Log.e("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout error, count:%d", Integer.valueOf(count));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(232602);
                        return;
                    } else if (!WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(view.getContext())) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(232602);
                        return;
                    } else {
                        Log.i("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout, isAnchorLiving:%b, isVisitorLiving:%b, count:%s", Boolean.valueOf(((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isAnchorLiving()), Boolean.valueOf(((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isVisitorLiving()), Integer.valueOf(count));
                        if (LiveTalkRoomTipsBar.this.OFd.getVisibility() == 8) {
                            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, false);
                        }
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232602);
            }
        });
        this.OFe.setVisibility(8);
        this.OFe.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.LiveTalkRoomTipsBar.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(232603);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (LiveTalkRoomTipsBar.this.OFb != null) {
                    q unused = LiveTalkRoomTipsBar.this.OFb;
                    q.blO(LiveTalkRoomTipsBar.this.OFl.getTalkerUserName());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232603);
            }
        });
        this.OFi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.LiveTalkRoomTipsBar.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(232604);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232604);
            }
        });
        AppMethodBeat.o(232610);
    }

    public final void bc(boolean z, boolean z2) {
        AppMethodBeat.i(232611);
        if (z) {
            if (this.OFd.getVisibility() != 0 || !z2) {
                this.OFd.setVisibility(8);
                gIE();
            } else {
                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.dr);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.ui.LiveTalkRoomTipsBar.AnonymousClass4 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(232605);
                        LiveTalkRoomTipsBar.this.OFd.setVisibility(8);
                        LiveTalkRoomTipsBar.this.gIE();
                        AppMethodBeat.o(232605);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                this.OFd.startAnimation(loadAnimation);
            }
            setRootTipsBarBackground(false);
            AppMethodBeat.o(232611);
            return;
        }
        if (this.OFd.getVisibility() != 0) {
            this.OFd.setVisibility(0);
            setRootTipsBarBackground(true);
            if (z2) {
                this.OFd.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dn));
                if (this.OFk != null) {
                    this.OFk.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.br));
                }
            }
        }
        gIE();
        if (this.OFl != null) {
            this.OFl.hideVKB();
        }
        AppMethodBeat.o(232611);
    }

    public final void gIE() {
        Object valueOf;
        AppMethodBeat.i(232612);
        if (!this.OFo) {
            gIF();
            AppMethodBeat.o(232612);
            return;
        }
        if (this.OFb != null) {
            LinkedList<com.tencent.mm.live.b.c.b> gIH = this.OFb.gIH();
            if (gIH == null || gIH.size() <= 0) {
                Object[] objArr = new Object[1];
                objArr[0] = gIH == null ? BuildConfig.COMMAND : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                Log.e("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List error:%s", objArr);
                gIF();
                AppMethodBeat.o(232612);
                return;
            }
            boolean isAnchorLiving = ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isAnchorLiving();
            boolean isVisitorLiving = ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isVisitorLiving();
            Object[] objArr2 = new Object[3];
            if (gIH == null) {
                valueOf = BuildConfig.COMMAND;
            } else {
                valueOf = Integer.valueOf(gIH.size());
            }
            objArr2[0] = valueOf;
            objArr2[1] = Boolean.valueOf(isAnchorLiving);
            objArr2[2] = Boolean.valueOf(isVisitorLiving);
            Log.i("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List size:%s, isAnchorLiving:%b, isVisitorLiving:%b", objArr2);
            if ((isAnchorLiving || isVisitorLiving) && this.OFb != null && this.OFb.blN(((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).getLivingRoomId())) {
                String string = this.context.getString(R.string.ejs, Integer.valueOf(gIH.size()));
                if (this.OFd.getVisibility() == 0) {
                    this.OFg.setText(string);
                    akU(gIH.size());
                    setRootTipsBarBackground(true);
                    this.OFb.OFs.notifyDataSetChanged();
                } else {
                    this.OFg.setText(string);
                }
            } else {
                String string2 = this.context.getString(R.string.ejt, Integer.valueOf(gIH.size()));
                if (this.OFd.getVisibility() == 0) {
                    this.OFg.setText(string2);
                    akU(gIH.size());
                    setRootTipsBarBackground(true);
                    this.OFb.OFs.notifyDataSetChanged();
                } else {
                    this.OFg.setText(string2);
                }
            }
            setVisibility(0);
        }
        AppMethodBeat.o(232612);
    }

    private void akU(int i2) {
        AppMethodBeat.i(232613);
        int aG = com.tencent.mm.cb.a.aG(this.context, R.dimen.ct);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = (displayMetrics.heightPixels - (aG * 21)) / 2;
        int i4 = aG * (i2 + 1) * 8;
        ViewGroup.LayoutParams layoutParams = this.OFj.getLayoutParams();
        if (i4 > i3) {
            layoutParams.height = i3;
        } else {
            layoutParams.height = i4;
        }
        this.OFj.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.OFd.getLayoutParams();
        layoutParams2.height = layoutParams.height;
        this.OFd.setLayoutParams(layoutParams2);
        AppMethodBeat.o(232613);
    }

    private void gIF() {
        AppMethodBeat.i(232614);
        this.OFd.setVisibility(8);
        setVisibility(8);
        setRootTipsBarBackground(false);
        AppMethodBeat.o(232614);
    }

    public void setRootTipsBarBackground(boolean z) {
        AppMethodBeat.i(232615);
        if (this.OFk != null) {
            if (z) {
                this.OFk.setVisibility(0);
                this.OFk.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.LiveTalkRoomTipsBar.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(232606);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(232606);
                    }
                });
                if (this.obi != null) {
                    this.obi.setVisibility(8);
                }
                if (this.OFm != null) {
                    this.OFm.setVisibility(4);
                }
                if (this.OFn != null) {
                    this.OFn.setBackgroundColor(0);
                    AppMethodBeat.o(232615);
                    return;
                }
            } else {
                this.OFk.setVisibility(8);
                if (this.obi != null) {
                    this.obi.setVisibility(0);
                }
                if (this.OFm != null) {
                    this.OFm.setVisibility(0);
                }
                if (this.OFn != null) {
                    this.OFn.setBackgroundResource(R.drawable.azy);
                }
            }
        }
        AppMethodBeat.o(232615);
    }
}
