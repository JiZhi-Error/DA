package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.x;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e;

public class NewBizInfoMessagePreference extends Preference {
    private a BjG;
    private MMActivity gte;
    private View hSw;
    private RecyclerView hak;
    private boolean rFe = false;
    private int state = 1;

    public NewBizInfoMessagePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27542);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(27542);
    }

    public NewBizInfoMessagePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27543);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(27543);
    }

    public static class a extends RecyclerView.a<View$OnClickListenerC1584a> {
        private static int BjI = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6);
        private static final int BjJ = MMApplicationContext.getResources().getDimensionPixelSize(R.dimen.k9);
        private static int BjK = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
        private static int BjL = 13;
        private static int BjM = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
        private static int BjN = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
        private static int BjO = 13;
        protected ov BjH;
        private int BjP;
        private as contact;
        private MMActivity gte;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(View$OnClickListenerC1584a aVar, int i2) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            AppMethodBeat.i(27539);
            View$OnClickListenerC1584a aVar2 = aVar;
            int itemCount = getItemCount();
            if (i2 == itemCount - 1 && this.BjH.KVx.KWa == 0) {
                TextView textView = new TextView(a.this.gte);
                textView.setTextColor(-7829368);
                textView.setText("正在加载");
                textView.setTextSize((float) BjL);
                textView.setGravity(17);
                aVar2.qnZ.addView(textView, new LinearLayout.LayoutParams(-2, -1));
                this.BjP = i2;
                AppMethodBeat.o(27539);
                return;
            }
            b a2 = a.a(this.BjH, i2);
            if (a2 != null) {
                if (itemCount - 1 == i2) {
                    aVar2.lrc.setVisibility(4);
                } else {
                    aVar2.lrc.setVisibility(0);
                }
                aVar2.BjQ = a2;
                aVar2.gyt.setText(l.c(a.this.gte, a2.title));
                String str = a2.coverImgUrl;
                ImageView imageView = aVar2.Bga;
                if (com.tencent.mm.cb.a.jk(a.this.gte)) {
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    int dimension = (int) a.this.gte.getResources().getDimension(R.dimen.bu);
                    layoutParams.height = dimension;
                    layoutParams.width = dimension;
                    imageView.setLayoutParams(layoutParams);
                }
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) a.this.gte, 72);
                String u = com.tencent.mm.api.b.u(str, 2);
                com.tencent.mm.av.a.a bcV = q.bcV();
                c.a aVar3 = new c.a();
                aVar3.jbf = true;
                c.a dr = aVar3.dr(fromDPToPix, fromDPToPix);
                dr.jaU = new n(3);
                dr.jbC = new e(3);
                dr.fullPath = s.bdu(u);
                bcV.a(u, imageView, dr.bdv(), null, new m(3, fromDPToPix, fromDPToPix, null, null));
                if (aVar2.BjQ.type == 7) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    aVar2.gBZ.setVisibility(0);
                    aVar2.gBZ.setImageResource(R.raw.new_biz_info_message_voice_icon);
                } else {
                    if (aVar2.BjQ.type == 5) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        aVar2.gBZ.setVisibility(0);
                        aVar2.gBZ.setImageResource(R.raw.new_biz_info_message_video_icon);
                    } else {
                        if (aVar2.BjQ.type == 6) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            aVar2.gBZ.setVisibility(0);
                            aVar2.gBZ.setImageResource(R.raw.new_biz_info_message_music_icon);
                        } else {
                            if (aVar2.BjQ.type == 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (!z4) {
                                if (aVar2.BjQ.type == 10) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (z5) {
                                    aVar2.Bga.setVisibility(8);
                                }
                            }
                            aVar2.gBZ.setVisibility(8);
                        }
                    }
                }
                aVar2.qnZ.removeAllViews();
                if (a2.Bkp == 1) {
                    TextView textView2 = new TextView(a.this.gte);
                    textView2.setText(a.this.gte.getResources().getText(R.string.b_r));
                    textView2.setTextSize((float) BjO);
                    textView2.setTextColor(a.this.gte.getResources().getColor(R.color.uj));
                    aVar2.qnZ.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
                }
                String str2 = a2.Bkq;
                TextView textView3 = new TextView(a.this.gte);
                textView3.setTextColor(-7829368);
                textView3.setText(str2);
                textView3.setTextSize((float) BjL);
                textView3.setGravity(17);
                if (aVar2.BjQ.Bkp == 1) {
                    textView3.setPadding(BjK, 0, BjK, 0);
                } else {
                    textView3.setPadding(0, 0, BjK, 0);
                }
                aVar2.qnZ.addView(textView3, new LinearLayout.LayoutParams(-2, -1));
            }
            AppMethodBeat.o(27539);
        }

        static {
            AppMethodBeat.i(27541);
            AppMethodBeat.o(27541);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            int i2 = 0;
            AppMethodBeat.i(27538);
            if (this.BjH == null || this.BjH.KVw == null) {
                AppMethodBeat.o(27538);
                return 0;
            }
            int fT = a.fT(this.BjH.KVw);
            if (this.BjH.KVx.KWa == 0) {
                i2 = 1;
            }
            int i3 = i2 + fT;
            AppMethodBeat.o(27538);
            return i3;
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference$a$a  reason: collision with other inner class name */
        public class View$OnClickListenerC1584a extends RecyclerView.v implements View.OnClickListener {
            public ImageView Bga;
            public b BjQ;
            public ImageView gBZ;
            public TextView gyt;
            public View lrc;
            public LinearLayout qnZ;

            public View$OnClickListenerC1584a(View view) {
                super(view);
                AppMethodBeat.i(27536);
                this.Bga = (ImageView) view.findViewById(R.id.fvn);
                this.gBZ = (ImageView) view.findViewById(R.id.fvm);
                this.gyt = (TextView) view.findViewById(R.id.fvq);
                this.qnZ = (LinearLayout) view.findViewById(R.id.fvj);
                this.lrc = view.findViewById(R.id.fvl);
                view.setOnClickListener(this);
                AppMethodBeat.o(27536);
            }

            public final void onClick(View view) {
                AppMethodBeat.i(27537);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMessagePreference$messageItemAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.NewBizInfoMessagePreference", "onClick jump to url:%s", this.BjQ.Bko);
                int intExtra = a.this.gte.getIntent().getIntExtra("KOpenArticleSceneFromScene", -1);
                Intent intent = new Intent();
                String d2 = com.tencent.mm.ag.m.d(this.BjQ.Bko, 126, intExtra, 0);
                intent.putExtra("rawUrl", d2);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                intent.putExtra("geta8key_scene", 3);
                String stringExtra = a.this.gte.getIntent().getStringExtra("prePublishId");
                if (!Util.isNullOrNil(stringExtra)) {
                    intent.putExtra("KPublisherId", stringExtra);
                    intent.putExtra("prePublishId", stringExtra);
                    intent.putExtra("preUsername", a.this.gte.getIntent().getStringExtra("preUsername"));
                    intent.putExtra("preChatName", a.this.gte.getIntent().getStringExtra("preChatName"));
                } else {
                    intent.putExtra("prePublishId", "brand_profile");
                    intent.putExtra("KPublisherId", "brand_profile");
                }
                intent.putExtra("preChatTYPE", a.this.gte.getIntent().getIntExtra("preChatTYPE", 0));
                int intExtra2 = a.this.gte.getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
                if (this.BjQ.type == 5 && ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()) {
                    intent.putExtra(e.b.OyQ, 126);
                    intent.putExtra(e.b.OyR, intExtra2);
                    intent.putExtra("biz_video_session_id", ab.getSessionId());
                    x xVar = new x();
                    xVar.iAh = intent.getStringExtra("KPublisherId");
                    xVar.dHc = a.this.contact.field_username;
                    xVar.iAg = a.this.contact.arI();
                    xVar.iAi.url = d2;
                    xVar.iAi.title = this.BjQ.title;
                    xVar.iAi.iAq = this.BjQ.Bkt;
                    xVar.iAi.iAo = this.BjQ.coverImgUrl;
                    xVar.iAi.type = this.BjQ.type;
                    xVar.iAi.time = (long) this.BjQ.hXs;
                    xVar.iAi.iAs = this.BjQ.videoDuration;
                    xVar.iAi.videoWidth = this.BjQ.videoWidth;
                    xVar.iAi.videoHeight = this.BjQ.videoHeight;
                    xVar.iAi.vid = this.BjQ.vid;
                    xVar.t(intent);
                    Log.i("MicroMsg.NewBizInfoMessagePreference", "jump to native video");
                    int[] iArr = new int[2];
                    View findViewById = view.findViewById(R.id.fvn);
                    if (findViewById != null) {
                        int width = findViewById.getWidth();
                        int height = findViewById.getHeight();
                        findViewById.getLocationInWindow(iArr);
                        intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    }
                    intent.addFlags(268435456);
                }
                if (!((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(6) || !((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(a.this.gte, d2, this.BjQ.type, 126, intExtra2, intent)) {
                    com.tencent.mm.br.c.b(a.this.gte, "webview", ".ui.tools.WebViewUI", intent);
                } else {
                    Log.i("MicroMsg.NewBizInfoMessagePreference", "jump to TmplWebview");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMessagePreference$messageItemAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27537);
            }
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ View$OnClickListenerC1584a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(27540);
            View$OnClickListenerC1584a aVar = new View$OnClickListenerC1584a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.xq, viewGroup, false));
            AppMethodBeat.o(27540);
            return aVar;
        }
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27544);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.hak = (RecyclerView) view.findViewById(R.id.fvp);
        this.hak.setLayoutParams(new FrameLayout.LayoutParams(-1, displayMetrics.heightPixels));
        this.hak.setLayoutManager(new LinearLayoutManager());
        this.hak.setHasFixedSize(true);
        this.hSw = view.findViewById(R.id.fvd);
        this.rFe = true;
        if (this.rFe) {
            if (this.state == 1) {
                this.hSw.setVisibility(0);
            } else if (this.state == 2) {
                this.hak.setVisibility(8);
                this.hSw.setVisibility(0);
                AppMethodBeat.o(27544);
                return;
            } else if (this.state == 3) {
                this.hSw.setVisibility(8);
                this.hak.setVisibility(0);
                this.hak.setAdapter(this.BjG);
                AppMethodBeat.o(27544);
                return;
            }
            this.hak.setVisibility(8);
        }
        AppMethodBeat.o(27544);
    }
}
