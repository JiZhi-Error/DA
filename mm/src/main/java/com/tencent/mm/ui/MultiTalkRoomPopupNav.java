package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bh.f;
import com.tencent.mm.bi.d;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.multitalk.d.e;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkRoomPopupNav extends LinearLayout {
    private View GDE;
    private View OFk;
    private com.tencent.mm.ui.chatting.e.a OFl;
    private WeImageView OFm;
    private boolean OFo;
    private LinearLayout OJh;
    private View OJi;
    private TextView OJj;
    private TextView OJk;
    private TextView OJl;
    private String OJm;
    private String OJn;
    private b OJo = b.NotInTalking;
    public a OJp;
    private final int OJq = 6;
    private LinearLayout OJr;
    private LinearLayout OJs;
    private LinearLayout OJt;
    public boolean OJu = false;
    private f OJv = new f();
    private int OJw;
    private View obi;

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, boolean z) {
        AppMethodBeat.i(258909);
        multiTalkRoomPopupNav.Bo(false);
        AppMethodBeat.o(258909);
    }

    /* access modifiers changed from: package-private */
    public enum b {
        Inviting,
        Talking,
        NotInTalking;

        public static b valueOf(String str) {
            AppMethodBeat.i(33617);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(33617);
            return bVar;
        }

        static {
            AppMethodBeat.i(33618);
            AppMethodBeat.o(33618);
        }
    }

    @TargetApi(11)
    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(33619);
        initView();
        AppMethodBeat.o(33619);
    }

    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33620);
        initView();
        AppMethodBeat.o(33620);
    }

    public void setGroupUserName(String str) {
        this.OJm = str;
    }

    public void setCurrentSenderUserName(String str) {
        this.OJn = str;
    }

    public void setInChatRoom(boolean z) {
        this.OFo = z;
    }

    public void setMultiTalkInfo(f fVar) {
        this.OJv = fVar;
    }

    public void setRootTipsBarBackground(View view) {
        this.OFk = view;
    }

    public void setChattingContext(com.tencent.mm.ui.chatting.e.a aVar) {
        this.OFl = aVar;
    }

    private void Bo(boolean z) {
        AppMethodBeat.i(232683);
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
                    AppMethodBeat.o(232683);
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
        AppMethodBeat.o(232683);
    }

    private void initView() {
        AppMethodBeat.i(33621);
        inflate(getContext(), R.layout.bcv, this);
        this.GDE = findViewById(R.id.h94);
        this.obi = findViewById(R.id.aar);
        this.OJh = (LinearLayout) findViewById(R.id.fou);
        this.OJj = (TextView) findViewById(R.id.fpa);
        this.OJk = (TextView) findViewById(R.id.fpb);
        this.OJl = (TextView) findViewById(R.id.fpc);
        this.OJr = (LinearLayout) findViewById(R.id.foj);
        this.OJs = (LinearLayout) findViewById(R.id.foi);
        this.OJt = (LinearLayout) findViewById(R.id.foh);
        this.OFm = (WeImageView) findViewById(R.id.uk);
        this.OJh.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.MultiTalkRoomPopupNav.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(33611);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (d.jpA != null && ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).cC(MultiTalkRoomPopupNav.this.getContext())) {
                    Log.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(33611);
                } else if (d.jpA == null || !d.jpA.bgJ()) {
                    MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(33611);
                } else {
                    Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.e3d), 0).show();
                    Log.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(33611);
                }
            }
        });
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.OJw = (int) Math.floor((double) (((float) (displayMetrics.widthPixels - at.fromDPToPix(getContext(), 56))) / ((float) at.fromDPToPix(getContext(), 48))));
        AppMethodBeat.o(33621);
    }

    public final void Bp(boolean z) {
        AppMethodBeat.i(33622);
        this.OJu = false;
        if (this.OJm == null || this.OJn == null) {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + this.OJm + ",currentSenderUserName:" + this.OJn);
            AppMethodBeat.o(33622);
            return;
        }
        String str = this.OJm;
        if (!((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFH(str)) {
            gJt();
            AppMethodBeat.o(33622);
            return;
        }
        List<String> aFK = ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFK(str);
        if (aFK.size() == 0) {
            ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).gC(str);
            gJt();
            AppMethodBeat.o(33622);
            return;
        }
        int iM = ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).iM(str, this.OJn);
        if (iM == 1) {
            setUserTalkingStatus(b.Inviting);
            if (((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFL(str)) {
                gJt();
                AppMethodBeat.o(33622);
                return;
            }
            String eqg = e.eqg();
            if (eqg == null) {
                setInvitingBannerStyle(((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).getDisplayName(((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).iN(str, this.OJn)));
            } else {
                setInvitingBannerStyleWithText(eqg);
            }
        } else if (iM == 10) {
            setUserTalkingStatus(b.Talking);
            if (((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFL(str)) {
                gJt();
                AppMethodBeat.o(33622);
                return;
            } else if (((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).ems()) {
                gJt();
                AppMethodBeat.o(33622);
                return;
            } else {
                String eqi = e.eqi();
                setUserTalkingStatus(b.NotInTalking);
                if (eqi == null) {
                    eqi = MMApplicationContext.getContext().getString(R.string.f73, Integer.valueOf(aFK.size()));
                }
                setDefaultBannerStyle(eqi);
            }
        } else {
            setUserTalkingStatus(b.NotInTalking);
            String eqi2 = e.eqi();
            if (eqi2 == null) {
                eqi2 = MMApplicationContext.getContext().getString(R.string.f73, Integer.valueOf(aFK.size()));
            }
            setDefaultBannerStyle(eqi2);
        }
        setVisibility(0);
        this.OJh.setVisibility(0);
        if (this.OJp != null && (z || this.OJr == null || this.OJr.getVisibility() != 0)) {
            this.OJp.close();
        }
        jc(s(aFK, ""));
        if (!(this.OJp == null || this.OJp.OJy == null)) {
            if (this.OJp.OJy.getVisibility() == 0) {
                Bo(true);
                AppMethodBeat.o(33622);
                return;
            }
            Bo(false);
        }
        AppMethodBeat.o(33622);
    }

    public void setUserTalkingStatus(b bVar) {
        this.OJo = bVar;
    }

    private void setTalkingBannerStyle(String str) {
        AppMethodBeat.i(33623);
        this.OJj.setTextColor(getResources().getColor(R.color.a1w));
        this.OJj.setText(str);
        this.OJj.setVisibility(0);
        this.OJl.setVisibility(8);
        this.OJk.setVisibility(8);
        AppMethodBeat.o(33623);
    }

    private void setInvitingBannerStyle(String str) {
        AppMethodBeat.i(33624);
        this.OJk.setTextColor(getResources().getColor(R.color.a1u));
        this.OJk.setText(str);
        this.OJj.setVisibility(8);
        this.OJl.setVisibility(0);
        this.OJk.setVisibility(0);
        this.OJr.setVisibility(8);
        AppMethodBeat.o(33624);
    }

    private void setInvitingBannerStyleWithText(String str) {
        AppMethodBeat.i(232684);
        this.OJi.setBackgroundResource(R.drawable.akg);
        this.OJj.setVisibility(8);
        this.OJl.setVisibility(0);
        this.OJl.setText(str);
        this.OJk.setVisibility(0);
        this.OJr.setVisibility(8);
        AppMethodBeat.o(232684);
    }

    private void setDefaultBannerStyle(String str) {
        AppMethodBeat.i(33625);
        this.OJj.setTextColor(getResources().getColor(R.color.a1u));
        this.OJj.setText(str);
        if (this.OJr == null || this.OJr.getVisibility() != 0) {
            this.OJj.setVisibility(0);
            this.OJl.setVisibility(8);
            this.OJk.setVisibility(8);
            this.OJr.setVisibility(8);
        }
        AppMethodBeat.o(33625);
    }

    public final void gJt() {
        AppMethodBeat.i(33626);
        this.OJu = false;
        setVisibility(8);
        if (this.OJp != null) {
            this.OJp.close();
        }
        AppMethodBeat.o(33626);
    }

    private void d(String str, List<String> list, final String str2) {
        int i2 = 0;
        AppMethodBeat.i(33627);
        this.OJh.setBackgroundColor(0);
        this.OFm.setVisibility(4);
        b bVar = b.Inviting;
        this.OJp = new a(this, (byte) 0);
        a aVar = this.OJp;
        AnonymousClass2 r3 = new View.OnClickListener() {
            /* class com.tencent.mm.ui.MultiTalkRoomPopupNav.AnonymousClass2 */

            public final void onClick(View view) {
                int i2;
                int i3;
                AppMethodBeat.i(33612);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
                if (str2 != null) {
                    if (((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).emq()) {
                        Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
                        h.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(R.string.f6b), null, true);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(33612);
                        return;
                    }
                    List<String> aFK = ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFK(MultiTalkRoomPopupNav.this.OJm);
                    if (aFK.size() == 1) {
                        MultiTalkRoomPopupNav.blV(str2);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13945, 1, 0, 0, 1, MultiTalkRoomPopupNav.this.OJm, Integer.valueOf(MultiTalkRoomPopupNav.this.OJv.field_roomId), Long.valueOf(MultiTalkRoomPopupNav.this.OJv.field_roomKey));
                    } else if (aFK.size() >= e.epZ()) {
                        Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + aFK.size());
                        h.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(R.string.f6h, Integer.valueOf(e.epZ())), null, true);
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        Object[] objArr = new Object[7];
                        objArr[0] = 1;
                        if (MultiTalkRoomPopupNav.this.OJo == b.Inviting) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        objArr[1] = Integer.valueOf(i3);
                        objArr[2] = 1;
                        objArr[3] = 1;
                        objArr[4] = MultiTalkRoomPopupNav.this.OJm;
                        objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.this.OJv.field_roomId);
                        objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.this.OJv.field_roomKey);
                        hVar.a(13945, objArr);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(33612);
                        return;
                    } else if (((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).emp()) {
                        Log.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
                        h.c(MultiTalkRoomPopupNav.this.getContext(), MMApplicationContext.getContext().getString(R.string.f6_), null, true);
                        com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        Object[] objArr2 = new Object[7];
                        objArr2[0] = 1;
                        if (MultiTalkRoomPopupNav.this.OJo == b.Inviting) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        objArr2[1] = Integer.valueOf(i2);
                        objArr2[2] = 0;
                        objArr2[3] = 1;
                        objArr2[4] = MultiTalkRoomPopupNav.this.OJm;
                        objArr2[5] = Integer.valueOf(MultiTalkRoomPopupNav.this.OJv.field_roomId);
                        objArr2[6] = Long.valueOf(MultiTalkRoomPopupNav.this.OJv.field_roomKey);
                        hVar2.a(13945, objArr2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(33612);
                        return;
                    } else {
                        MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this, str2);
                    }
                }
                MultiTalkRoomPopupNav.this.OJp.close();
                MultiTalkRoomPopupNav.this.OJh.setVisibility(0);
                MultiTalkRoomPopupNav.this.OJh.setBackgroundResource(R.drawable.azy);
                MultiTalkRoomPopupNav.this.OFm.setVisibility(0);
                MultiTalkRoomPopupNav.this.OJr.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(33612);
            }
        };
        AnonymousClass3 r4 = new View.OnClickListener() {
            /* class com.tencent.mm.ui.MultiTalkRoomPopupNav.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(33613);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MultiTalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
                if (MultiTalkRoomPopupNav.this.OJo == b.Inviting) {
                    Log.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
                    boolean aFP = ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFP(str2);
                    ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFQ(str2);
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    Object[] objArr = new Object[7];
                    objArr[0] = 3;
                    objArr[1] = 1;
                    objArr[2] = 0;
                    objArr[3] = Integer.valueOf(aFP ? 0 : 1);
                    objArr[4] = MultiTalkRoomPopupNav.this.OJm;
                    objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.this.OJv.field_roomId);
                    objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.this.OJv.field_roomKey);
                    hVar.a(13945, objArr);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13945, 2, 0, 0, 0, MultiTalkRoomPopupNav.this.OJm, Integer.valueOf(MultiTalkRoomPopupNav.this.OJv.field_roomId), Long.valueOf(MultiTalkRoomPopupNav.this.OJv.field_roomKey));
                }
                MultiTalkRoomPopupNav.this.OJp.close();
                MultiTalkRoomPopupNav.this.OJh.setVisibility(0);
                MultiTalkRoomPopupNav.this.OJh.setBackgroundResource(R.drawable.azy);
                MultiTalkRoomPopupNav.this.OFm.setVisibility(0);
                MultiTalkRoomPopupNav.this.OJr.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MultiTalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(33613);
            }
        };
        aVar.titleView.setText(str);
        if (aVar.OJy.getVisibility() != 0) {
            aVar.OJy.setVisibility(0);
            aVar.OJy.startAnimation(AnimationUtils.loadAnimation(MultiTalkRoomPopupNav.this.getContext(), R.anim.dn));
            MultiTalkRoomPopupNav.this.Bo(true);
            if (MultiTalkRoomPopupNav.this.OFk != null) {
                MultiTalkRoomPopupNav.this.OFk.startAnimation(AnimationUtils.loadAnimation(MultiTalkRoomPopupNav.this.getContext(), R.anim.br));
            }
        }
        MultiTalkRoomPopupNav.this.OJr.setVisibility(0);
        MultiTalkRoomPopupNav.this.OJr.removeAllViews();
        if (list != null) {
            if (list.size() > MultiTalkRoomPopupNav.this.OJw) {
                MultiTalkRoomPopupNav.this.OJs.setVisibility(0);
                MultiTalkRoomPopupNav.this.OJs.removeAllViews();
            }
            if (list.size() > MultiTalkRoomPopupNav.this.OJw * 2) {
                MultiTalkRoomPopupNav.this.OJt.setVisibility(0);
                MultiTalkRoomPopupNav.this.OJt.removeAllViews();
            }
        }
        for (String str3 : list) {
            ImageView imageView = new ImageView(MultiTalkRoomPopupNav.this.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40));
            layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(layoutParams);
            if (i2 < MultiTalkRoomPopupNav.this.OJw) {
                MultiTalkRoomPopupNav.this.OJr.addView(imageView);
            } else if (i2 >= MultiTalkRoomPopupNav.this.OJw && i2 < MultiTalkRoomPopupNav.this.OJw * 2) {
                MultiTalkRoomPopupNav.this.OJs.addView(imageView);
            } else if (i2 >= MultiTalkRoomPopupNav.this.OJw * 2 && i2 < MultiTalkRoomPopupNav.this.OJw * 3) {
                MultiTalkRoomPopupNav.this.OJt.addView(imageView);
            }
            a.b.c(imageView, str3);
            i2++;
        }
        ((Button) MultiTalkRoomPopupNav.this.findViewById(R.id.foa)).setOnClickListener(r3);
        aVar.CBl.setOnClickListener(r4);
        if (MultiTalkRoomPopupNav.this.OFk != null) {
            MultiTalkRoomPopupNav.this.OFk.setOnClickListener(r4);
        }
        AppMethodBeat.o(33627);
    }

    public class a {
        View CBl;
        public LinearLayout OJy;
        TextView titleView;

        /* synthetic */ a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, byte b2) {
            this();
        }

        private a() {
            AppMethodBeat.i(232682);
            this.CBl = MultiTalkRoomPopupNav.this.findViewById(R.id.b4g);
            this.titleView = (TextView) MultiTalkRoomPopupNav.this.findViewById(R.id.fp_);
            this.OJy = (LinearLayout) MultiTalkRoomPopupNav.this.findViewById(R.id.br4);
            AppMethodBeat.o(232682);
        }

        public final void close() {
            AppMethodBeat.i(33615);
            MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this, false);
            if (this.OJy.getVisibility() == 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(MultiTalkRoomPopupNav.this.getContext(), R.anim.dr);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.ui.MultiTalkRoomPopupNav.a.AnonymousClass1 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(232681);
                        a.this.OJy.setVisibility(8);
                        AppMethodBeat.o(232681);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                this.OJy.startAnimation(loadAnimation);
            }
            AppMethodBeat.o(33615);
        }
    }

    private void jc(List<String> list) {
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(33628);
        if (this.OJr == null || this.OJr.getVisibility() != 0) {
            z = false;
        } else {
            this.OJr.removeAllViews();
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
                    this.OJr.addView(imageView);
                } else if (i2 >= this.OJw && i2 < this.OJw * 2) {
                    this.OJs.addView(imageView);
                } else if (i2 >= this.OJw * 2 && i2 < this.OJw * 3) {
                    this.OJt.addView(imageView);
                }
                a.b.c(imageView, str);
                i2++;
            }
        }
        AppMethodBeat.o(33628);
    }

    private static List<String> s(List<String> list, String str) {
        AppMethodBeat.i(33629);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!(str == null || str == "")) {
            for (String str2 : list) {
                if (str2 != null && !str2.equals(str)) {
                    arrayList2.add(str2);
                }
            }
            list = arrayList2;
        }
        for (String str3 : list) {
            arrayList.add(str3);
        }
        AppMethodBeat.o(33629);
        return arrayList;
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        AppMethodBeat.i(33630);
        if (multiTalkRoomPopupNav.OJm == null || multiTalkRoomPopupNav.OJn == null) {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.OJm + ",currentSenderUserName:" + multiTalkRoomPopupNav.OJn);
            AppMethodBeat.o(33630);
        } else if (!ab.Eq(multiTalkRoomPopupNav.OJm) || multiTalkRoomPopupNav.OFo) {
            String str = multiTalkRoomPopupNav.OJm;
            if (!((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFH(str)) {
                Log.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkInfo is null!");
                h.c(multiTalkRoomPopupNav.getContext(), MMApplicationContext.getContext().getString(R.string.f7a), null, true);
                multiTalkRoomPopupNav.gJt();
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[7];
                objArr[0] = 4;
                if (multiTalkRoomPopupNav.OJo == b.Inviting) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                objArr[1] = Integer.valueOf(i6);
                objArr[2] = 0;
                objArr[3] = 1;
                objArr[4] = multiTalkRoomPopupNav.OJm;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.OJv.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.OJv.field_roomKey);
                hVar.a(13945, objArr);
                AppMethodBeat.o(33630);
                return;
            }
            List<String> aFK = ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFK(str);
            if (aFK.size() == 0) {
                Log.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkMemberList is empty!");
                h.c(multiTalkRoomPopupNav.getContext(), MMApplicationContext.getContext().getString(R.string.f7a), null, true);
                multiTalkRoomPopupNav.gJt();
                com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr2 = new Object[7];
                objArr2[0] = 4;
                if (multiTalkRoomPopupNav.OJo == b.Inviting) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                objArr2[1] = Integer.valueOf(i5);
                objArr2[2] = 0;
                objArr2[3] = 1;
                objArr2[4] = multiTalkRoomPopupNav.OJm;
                objArr2[5] = Integer.valueOf(multiTalkRoomPopupNav.OJv.field_roomId);
                objArr2[6] = Long.valueOf(multiTalkRoomPopupNav.OJv.field_roomKey);
                hVar2.a(13945, objArr2);
                AppMethodBeat.o(33630);
                return;
            }
            if (aFK.size() == 1) {
                Log.i("MicroMsg.MultiTalkRoomPopupNav", "just one now member now! wait for back service process!");
            }
            if (multiTalkRoomPopupNav.OJo == b.Talking) {
                multiTalkRoomPopupNav.OJu = true;
                Intent intent = new Intent();
                intent.putExtra("enterMainUiSource", 2);
                intent.putExtra("enterMainUiWxGroupId", str);
                c.b(MMApplicationContext.getContext(), "multitalk", ".ui.MultiTalkMainUI", intent);
                com.tencent.mm.plugin.report.service.h hVar3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr3 = new Object[7];
                objArr3[0] = 4;
                if (multiTalkRoomPopupNav.OJo == b.Inviting) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                objArr3[1] = Integer.valueOf(i4);
                objArr3[2] = 0;
                objArr3[3] = 0;
                objArr3[4] = multiTalkRoomPopupNav.OJm;
                objArr3[5] = Integer.valueOf(multiTalkRoomPopupNav.OJv.field_roomId);
                objArr3[6] = Long.valueOf(multiTalkRoomPopupNav.OJv.field_roomKey);
                hVar3.a(13945, objArr3);
                AppMethodBeat.o(33630);
            } else if (multiTalkRoomPopupNav.OJo == b.Inviting) {
                String iN = ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).iN(str, multiTalkRoomPopupNav.OJn);
                if (iN != null) {
                    String string = MMApplicationContext.getContext().getString(R.string.bx2, ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).getDisplayName(iN));
                    List<String> s = s(aFK, multiTalkRoomPopupNav.OJn);
                    aFK.size();
                    multiTalkRoomPopupNav.d(string, s, str);
                }
                com.tencent.mm.plugin.report.service.h hVar4 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr4 = new Object[7];
                objArr4[0] = 4;
                if (multiTalkRoomPopupNav.OJo == b.Inviting) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                objArr4[1] = Integer.valueOf(i3);
                objArr4[2] = 0;
                objArr4[3] = 0;
                objArr4[4] = multiTalkRoomPopupNav.OJm;
                objArr4[5] = Integer.valueOf(multiTalkRoomPopupNav.OJv.field_roomId);
                objArr4[6] = Long.valueOf(multiTalkRoomPopupNav.OJv.field_roomKey);
                hVar4.a(13945, objArr4);
                AppMethodBeat.o(33630);
            } else if (((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).emq()) {
                h.c(multiTalkRoomPopupNav.getContext(), MMApplicationContext.getContext().getString(R.string.f6b), null, true);
                com.tencent.mm.plugin.report.service.h hVar5 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr5 = new Object[7];
                objArr5[0] = 4;
                if (multiTalkRoomPopupNav.OJo == b.Inviting) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                objArr5[1] = Integer.valueOf(i2);
                objArr5[2] = 0;
                objArr5[3] = 1;
                objArr5[4] = multiTalkRoomPopupNav.OJm;
                objArr5[5] = Integer.valueOf(multiTalkRoomPopupNav.OJv.field_roomId);
                objArr5[6] = Long.valueOf(multiTalkRoomPopupNav.OJv.field_roomKey);
                hVar5.a(13945, objArr5);
                AppMethodBeat.o(33630);
            } else if (aFK.size() >= e.epZ()) {
                h.c(multiTalkRoomPopupNav.getContext(), MMApplicationContext.getContext().getString(R.string.f6h, new StringBuilder().append(e.epZ()).toString()), null, true);
                com.tencent.mm.plugin.report.service.h hVar6 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr6 = new Object[7];
                objArr6[0] = 4;
                if (multiTalkRoomPopupNav.OJo == b.Inviting) {
                    i8 = 1;
                }
                objArr6[1] = Integer.valueOf(i8);
                objArr6[2] = 1;
                objArr6[3] = 1;
                objArr6[4] = multiTalkRoomPopupNav.OJm;
                objArr6[5] = Integer.valueOf(multiTalkRoomPopupNav.OJv.field_roomId);
                objArr6[6] = Long.valueOf(multiTalkRoomPopupNav.OJv.field_roomKey);
                hVar6.a(13945, objArr6);
                AppMethodBeat.o(33630);
            } else {
                String string2 = MMApplicationContext.getContext().getString(R.string.f7n);
                List<String> s2 = s(aFK, "");
                aFK.size();
                multiTalkRoomPopupNav.d(string2, s2, str);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13945, 4, 0, 0, 0, multiTalkRoomPopupNav.OJm, Integer.valueOf(multiTalkRoomPopupNav.OJv.field_roomId), Long.valueOf(multiTalkRoomPopupNav.OJv.field_roomKey));
                AppMethodBeat.o(33630);
            }
        } else {
            h.c(multiTalkRoomPopupNav.getContext(), MMApplicationContext.getContext().getString(R.string.f6t), null, true);
            multiTalkRoomPopupNav.gJt();
            ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).gC(multiTalkRoomPopupNav.OJm);
            com.tencent.mm.plugin.report.service.h hVar7 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr7 = new Object[7];
            objArr7[0] = 4;
            if (multiTalkRoomPopupNav.OJo == b.Inviting) {
                i7 = 1;
            } else {
                i7 = 0;
            }
            objArr7[1] = Integer.valueOf(i7);
            objArr7[2] = 0;
            objArr7[3] = 1;
            objArr7[4] = multiTalkRoomPopupNav.OJm;
            objArr7[5] = Integer.valueOf(multiTalkRoomPopupNav.OJv.field_roomId);
            objArr7[6] = Long.valueOf(multiTalkRoomPopupNav.OJv.field_roomKey);
            hVar7.a(13945, objArr7);
            AppMethodBeat.o(33630);
        }
    }

    static /* synthetic */ void blV(String str) {
        AppMethodBeat.i(232685);
        Log.i("MicroMsg.MultiTalkRoomPopupNav", "when only on menber do clear banner!");
        ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFO(str);
        Log.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk!");
        if (!((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFM(str)) {
            Log.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk failure! groupId:".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(232685);
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        int i2;
        AppMethodBeat.i(232686);
        Log.i("MicroMsg.MultiTalkRoomPopupNav", "now try enter multitalk:".concat(String.valueOf(str)));
        if (!((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFN(str)) {
            Log.e("MicroMsg.MultiTalkRoomPopupNav", "try enter fail!".concat(String.valueOf(str)));
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f5x), 0).show();
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[7];
            objArr[0] = 1;
            objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.OJo == b.Inviting ? 1 : 0);
            objArr[2] = 0;
            objArr[3] = 1;
            objArr[4] = multiTalkRoomPopupNav.OJm;
            objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.OJv.field_roomId);
            objArr[6] = Long.valueOf(multiTalkRoomPopupNav.OJv.field_roomKey);
            hVar.a(13945, objArr);
            AppMethodBeat.o(232686);
            return;
        }
        ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFQ(str);
        com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr2 = new Object[7];
        objArr2[0] = 1;
        if (multiTalkRoomPopupNav.OJo == b.Inviting) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr2[1] = Integer.valueOf(i2);
        objArr2[2] = 0;
        objArr2[3] = 0;
        objArr2[4] = multiTalkRoomPopupNav.OJm;
        objArr2[5] = Integer.valueOf(multiTalkRoomPopupNav.OJv.field_roomId);
        objArr2[6] = Long.valueOf(multiTalkRoomPopupNav.OJv.field_roomKey);
        hVar2.a(13945, objArr2);
        AppMethodBeat.o(232686);
    }
}
