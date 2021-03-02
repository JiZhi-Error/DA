package com.tencent.mm.plugin.ball.a;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.ball.a.d;
import com.tencent.mm.plugin.ball.d.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.CircleAnimateView;
import com.tencent.mm.plugin.ball.view.CircleImageView;
import com.tencent.mm.plugin.ball.view.d;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class a extends RecyclerView.a<C0850a> {
    private static final int oVA = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7x);
    private static final int oVB = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7r);
    private static final int oVC = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7t);
    private static final int oVD = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7n);
    private static final int oVE = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7p);
    private static final int oVF = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7s);
    private static final int oVG = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7u);
    private static final int oVH = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7o);
    private static final int oVI = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7q);
    private static final int oVu = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a81);
    private static final int oVv = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7j);
    private static final int oVw = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a82);
    private static final int oVx = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7k);
    private static final int oVy = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7y);
    private static final int oVz = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a7z);
    private Context mContext;
    public boolean oVo;
    public boolean oVp;
    public List<BallInfo> oVq;
    public b oVr;
    public boolean oVs;
    public d.b oVt;

    static /* synthetic */ void b(C0850a aVar, int i2, BallInfo ballInfo) {
        AppMethodBeat.i(216966);
        a(aVar, i2, ballInfo);
        AppMethodBeat.o(216966);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(C0850a aVar, int i2) {
        final boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(106026);
        final C0850a aVar2 = aVar;
        if (com.tencent.mm.plugin.ball.f.d.h(this.oVq) && i2 >= 0 && i2 < this.oVq.size()) {
            final BallInfo ballInfo = this.oVq.get(i2);
            aVar2.position = i2;
            aVar2.oVO = ballInfo;
            aVar2.aus.setTranslationX(0.0f);
            aVar2.aus.setAlpha(1.0f);
            if (this.oVp) {
                aVar2.oVS.setVisibility(4);
            } else {
                aVar2.oVS.setVisibility(0);
                aVar2.oVR.setImageResource(R.raw.icons_filled_close);
                aVar2.oVR.setColorFilter(com.tencent.mm.cb.a.n(aVar2.oVR.getContext(), R.color.BW_50));
                aVar2.oVS.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.ball.a.a.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(106015);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/adapter/FloatBallMenuAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (d.a.oWb.a(view.getContext(), ballInfo)) {
                            Log.i("MicroMsg.FloatBallMenuAdapter", "onFloatBallListCloseBtn delegate intercept");
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/adapter/FloatBallMenuAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(106015);
                            return;
                        }
                        if (a.this.oVs) {
                            Log.d("MicroMsg.FloatBallMenuAdapter", "alvinluo notifyItemRemoved position: %d", Integer.valueOf(aVar2.position));
                            a.a(a.this, aVar2);
                        } else if (a.this.oVr != null) {
                            a.this.oVr.a(ballInfo, aVar2.lR());
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/adapter/FloatBallMenuAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(106015);
                    }
                });
            }
            if (ballInfo.oWr) {
                a(aVar2, com.tencent.mm.plugin.ball.f.d.BM(ballInfo.state), ballInfo);
            } else if (ballInfo.noe != -1) {
                a(aVar2, ballInfo.noe, ballInfo);
            } else {
                final int BL = com.tencent.mm.plugin.ball.f.d.BL(ballInfo.type);
                if (Util.isNullOrNil(ballInfo.icon)) {
                    a(aVar2, BL, ballInfo);
                } else {
                    aVar2.oVZ = -1;
                    com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                        /* class com.tencent.mm.plugin.ball.a.a.AnonymousClass3 */

                        @Override // com.tencent.mm.modelappbrand.a.b.k
                        public final void aYg() {
                            AppMethodBeat.i(216959);
                            a.b(aVar2, BL, ballInfo);
                            AppMethodBeat.o(216959);
                        }

                        @Override // com.tencent.mm.modelappbrand.a.b.k
                        public final void I(Bitmap bitmap) {
                            AppMethodBeat.i(216960);
                            if (bitmap != null && !bitmap.isRecycled()) {
                                aVar2.oVQ.setVisibility(8);
                                aVar2.oVP.setVisibility(0);
                                aVar2.oVP.setImageBitmap(bitmap);
                            }
                            AppMethodBeat.o(216960);
                        }

                        @Override // com.tencent.mm.modelappbrand.a.b.k
                        public final void oD() {
                            AppMethodBeat.i(216961);
                            Log.i("MicroMsg.FloatBallMenuAdapter", "onLoadFailed, iconResId:%s, iconUrl:%s", Integer.valueOf(ballInfo.noe), ballInfo.icon);
                            a.b(aVar2, BL, ballInfo);
                            AppMethodBeat.o(216961);
                        }

                        @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                        public final String Lb() {
                            AppMethodBeat.i(216962);
                            String str = "FloatMenuIcon#" + ballInfo.cif();
                            AppMethodBeat.o(216962);
                            return str;
                        }
                    }, ballInfo.icon, com.tencent.mm.plugin.ball.view.a.oZc);
                }
            }
            if (ballInfo.oWo == null || !ballInfo.oWr) {
                if (aVar2.oVX != null) {
                    aVar2.oVX.setVisibility(0);
                }
                if (aVar2.oVY != null) {
                    aVar2.oVY.setVisibility(8);
                }
                if (!d.a.oWb.a(aVar2.oVT, ballInfo)) {
                    if (ballInfo.type == 20) {
                        a(aVar2.oVT, String.format(this.mContext.getString(R.string.dd0), Util.nullAs(ballInfo.name, "")));
                    } else {
                        a(aVar2.oVT, ballInfo.name);
                    }
                }
                a(aVar2.oVU, ballInfo.tag);
                if (aVar2.oVT.getVisibility() == 8 && aVar2.oVU.getVisibility() == 8) {
                    aVar2.oVV.setVisibility(8);
                } else {
                    aVar2.oVV.setVisibility(0);
                }
            } else {
                if (ballInfo.oWo.getParent() instanceof ViewGroup) {
                    ((ViewGroup) ballInfo.oWo.getParent()).removeView(ballInfo.oWo);
                }
                if (aVar2.oVX != null) {
                    aVar2.oVX.setVisibility(8);
                }
                if (aVar2.oVY != null) {
                    aVar2.oVY.setVisibility(0);
                    aVar2.oVY.removeAllViews();
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 8388627;
                    aVar2.oVY.addView(ballInfo.oWo, layoutParams);
                }
            }
            if (!ballInfo.oWr || ballInfo.type == 16 || ballInfo.type == 17 || ballInfo.type == 19 || ballInfo.type == 20) {
                z = true;
            } else {
                z = false;
            }
            if (aVar2.oVW != null) {
                aVar2.oVW.setVisibility(z ? 0 : 8);
            }
            aVar2.aus.setTag(ballInfo);
            aVar2.aus.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.ball.a.a.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(216963);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/adapter/FloatBallMenuAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (z && a.this.oVr != null) {
                        ballInfo.oWs.opType = 1;
                        a.this.oVr.v(ballInfo);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/adapter/FloatBallMenuAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(216963);
                }
            });
            if (ballInfo.oWr) {
                View view = aVar2.aus;
                if (this.oVo) {
                    i5 = oVF;
                } else {
                    i5 = oVG + oVy;
                }
                if (this.oVo) {
                    i6 = oVH + oVy;
                } else {
                    i6 = oVI;
                }
                view.setPadding(i5, 0, i6, 0);
                AppMethodBeat.o(106026);
                return;
            }
            aVar2.aus.setBackgroundResource(this.oVo ? R.drawable.eu : R.drawable.ev);
            View view2 = aVar2.aus;
            if (this.oVo) {
                i3 = oVB;
            } else {
                i3 = oVC + oVy;
            }
            int i7 = oVz;
            if (this.oVo) {
                i4 = oVD + oVy;
            } else {
                i4 = oVE;
            }
            view2.setPadding(i3, i7, i4, oVA);
        }
        AppMethodBeat.o(106026);
    }

    static {
        AppMethodBeat.i(106029);
        AppMethodBeat.o(106029);
    }

    public a(Context context) {
        this.mContext = context;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(106022);
        if (com.tencent.mm.plugin.ball.f.d.h(this.oVq)) {
            int size = this.oVq.size();
            AppMethodBeat.o(106022);
            return size;
        }
        AppMethodBeat.o(106022);
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(106023);
        if (!com.tencent.mm.plugin.ball.f.d.h(this.oVq) || i2 < 0 || i2 >= this.oVq.size()) {
            AppMethodBeat.o(106023);
            return 1;
        } else if (this.oVq.get(i2).oWr) {
            AppMethodBeat.o(106023);
            return 2;
        } else {
            AppMethodBeat.o(106023);
            return 1;
        }
    }

    private static void a(TextView textView, String str) {
        AppMethodBeat.i(106024);
        if (!Util.isNullOrNil(str)) {
            textView.setVisibility(0);
            textView.setText(Html.fromHtml(str));
            AppMethodBeat.o(106024);
            return;
        }
        textView.setText("");
        textView.setVisibility(8);
        AppMethodBeat.o(106024);
    }

    private boolean BB(int i2) {
        AppMethodBeat.i(216964);
        if (i2 < 0 || i2 >= this.oVq.size()) {
            AppMethodBeat.o(216964);
            return false;
        }
        AppMethodBeat.o(216964);
        return true;
    }

    private static void a(C0850a aVar, int i2, BallInfo ballInfo) {
        AppMethodBeat.i(106025);
        if (i2 == -1) {
            aVar.oVP.setVisibility(4);
            aVar.oVQ.setVisibility(4);
        } else if (ImgUtil.isGif(MMApplicationContext.getContext(), i2)) {
            if (aVar.oVZ != i2) {
                aVar.oVP.setVisibility(8);
                aVar.oVQ.setVisibility(0);
                try {
                    aVar.oVQ.setImageResource(i2);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", e2, "setIconAnimateView exception:%s", e2);
                    aVar.oVQ.setImageResource(com.tencent.mm.plugin.ball.f.d.BM(ballInfo.state));
                }
            }
            if (ballInfo.progress >= 0) {
                aVar.oVQ.setProgress(ballInfo.progress);
            } else {
                aVar.oVQ.setProgress(-2147483648L);
            }
        } else {
            if (aVar.oVZ != i2) {
                aVar.oVQ.setVisibility(8);
                aVar.oVP.setVisibility(0);
                try {
                    aVar.oVP.setImageResource(i2);
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", e3, "setIconImageView exception:%s", e3);
                    int BL = com.tencent.mm.plugin.ball.f.d.BL(ballInfo.type);
                    aVar.oVP.setImageResource(BL);
                    ballInfo.noe = BL;
                }
            }
            if (ballInfo.progress >= 0) {
                aVar.oVP.setProgress(ballInfo.progress);
            } else {
                aVar.oVP.setProgress(-2147483648L);
            }
        }
        aVar.oVZ = i2;
        AppMethodBeat.o(106025);
    }

    /* renamed from: com.tencent.mm.plugin.ball.a.a$a  reason: collision with other inner class name */
    public class C0850a extends RecyclerView.v {
        public BallInfo oVO;
        public CircleImageView oVP;
        public CircleAnimateView oVQ;
        public ImageView oVR;
        public FrameLayout oVS;
        public TextView oVT;
        public TextView oVU;
        public LinearLayout oVV;
        public ImageView oVW;
        public LinearLayout oVX;
        public LinearLayout oVY;
        public int oVZ = -1;
        public int position;

        public C0850a(View view) {
            super(view);
            AppMethodBeat.i(106021);
            this.oVP = (CircleImageView) view.findViewById(R.id.dtc);
            this.oVQ = (CircleAnimateView) view.findViewById(R.id.dt_);
            this.oVR = (ImageView) view.findViewById(R.id.h31);
            this.oVS = (FrameLayout) view.findViewById(R.id.h30);
            this.oVT = (TextView) view.findViewById(R.id.fta);
            this.oVU = (TextView) view.findViewById(R.id.ft_);
            this.oVV = (LinearLayout) view.findViewById(R.id.ft8);
            this.oVW = (ImageView) view.findViewById(R.id.ul);
            this.oVX = (LinearLayout) view.findViewById(R.id.fcy);
            this.oVY = (LinearLayout) view.findViewById(R.id.fd0);
            AppMethodBeat.o(106021);
        }
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ C0850a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(106027);
        if (i2 == 1) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ayq, (ViewGroup) null, false);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(oVu + oVy, oVv + oVz + oVA));
            C0850a aVar = new C0850a(inflate);
            AppMethodBeat.o(106027);
            return aVar;
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ayr, (ViewGroup) null, false);
        inflate2.setLayoutParams(new RecyclerView.LayoutParams(oVw + oVy, oVx));
        C0850a aVar2 = new C0850a(inflate2);
        AppMethodBeat.o(106027);
        return aVar2;
    }

    static /* synthetic */ void a(a aVar, final C0850a aVar2) {
        AppMethodBeat.i(216965);
        if (aVar.oVq != null) {
            if (aVar.oVq.size() > 1) {
                if (aVar.BB(aVar2.position)) {
                    aVar.oVq.remove(aVar2.position);
                    aVar.ck(aVar2.position);
                    AppMethodBeat.o(216965);
                    return;
                }
            } else if (aVar.oVq.size() == 1 && aVar.BB(aVar2.position)) {
                aVar.oVq.remove(aVar2.position);
                if (aVar.oVt != null) {
                    aVar.oVt.a(aVar2, new Animator.AnimatorListener() {
                        /* class com.tencent.mm.plugin.ball.a.a.AnonymousClass2 */

                        public final void onAnimationStart(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(216958);
                            if (!(a.this.oVr == null || aVar2 == null || aVar2.oVO == null)) {
                                a.this.oVr.a(aVar2.oVO, aVar2.position);
                            }
                            AppMethodBeat.o(216958);
                        }

                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }
                    });
                }
            }
        }
        AppMethodBeat.o(216965);
    }
}
