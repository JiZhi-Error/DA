package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.s;

public final class f extends a {
    k EBv;
    boolean ESr = false;
    public View EWf;
    public View EWg;
    private int[] EWh = {R.id.iw1, R.id.iw2};
    private final int EWi = R.id.iw3;
    Context context;
    public int currentIndex;

    public f(TimeLineObject timeLineObject, SnsInfo snsInfo, c cVar, k kVar) {
        AppMethodBeat.i(100040);
        this.timeLineObject = timeLineObject;
        this.DsC = snsInfo;
        this.Dyw = cVar;
        this.EBv = kVar;
        AppMethodBeat.o(100040);
    }

    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    public final void n(View view, View view2) {
        AppMethodBeat.i(100041);
        this.contentView = view;
        this.EAV = view2;
        this.context = view.getContext();
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int min = ((((Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight()) - a.aG(this.context, R.dimen.ajw)) - a.aG(this.context, R.dimen.kb)) - this.context.getResources().getDimensionPixelSize(R.dimen.ir)) - this.context.getResources().getDimensionPixelSize(R.dimen.ir)) - this.context.getResources().getDimensionPixelSize(R.dimen.k5);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = this.context.getResources().getDimensionPixelOffset(R.dimen.ib);
        layoutParams.bottomMargin = 0;
        layoutParams.width = min;
        layoutParams.height = min;
        view.setLayoutParams(layoutParams);
        ((RoundedCornerFrameLayout) view).setRadius(8.0f);
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
            ((ViewGroup) view.getParent()).setClipToPadding(false);
        }
        for (int i2 : this.EWh) {
            MaskImageView maskImageView = (MaskImageView) view.findViewById(i2);
            maskImageView.setVisibility(8);
            maskImageView.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.sns.ui.c.a.f.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
        }
        View findViewById = view.findViewById(this.EWi);
        findViewById.setBackground(null);
        findViewById.setVisibility(8);
        ((ViewGroup) findViewById).setClipChildren(false);
        this.EUK = new at();
        this.EUK.Ewu = findViewById;
        this.EUK.Ewr = this.EUK.Ewu;
        this.EUK.Ews = (VideoSightView) this.EUK.Ewu.findViewById(R.id.dup);
        this.EUK.Ews.setMute(true);
        this.EUK.EeS = (ImageView) this.EUK.Ewu.findViewById(R.id.i59);
        this.EUK.Ewv = (MMPinProgressBtn) this.EUK.Ewu.findViewById(R.id.gl7);
        this.EUK.Eww = (TextView) this.EUK.Ewu.findViewById(R.id.c3v);
        this.EUK.EeT = (TextView) this.EUK.Ewu.findViewById(R.id.c4k);
        this.EUK.Ewu.setTag(this);
        this.EUK.Ewu.setOnClickListener(null);
        this.EUK.Ews.Dnz = true;
        this.EUK.Ews.setScaleType(QImageView.a.CENTER_CROP);
        this.EUK.Ews.im(min, min);
        this.EWg = view.findViewById(R.id.ik0);
        this.EWf = view.findViewById(R.id.ijz);
        aad(0);
        AppMethodBeat.o(100041);
    }

    /* access modifiers changed from: package-private */
    public final void aad(int i2) {
        AppMethodBeat.i(100042);
        if (this.EWg == null || this.EWf == null) {
            AppMethodBeat.o(100042);
            return;
        }
        this.currentIndex = i2;
        this.EWg.setVisibility(8);
        this.EWf.setVisibility(8);
        ((TextView) this.contentView.findViewById(R.id.iw6)).setText((CharSequence) null);
        ((TextView) this.contentView.findViewById(R.id.iw7)).setText((CharSequence) null);
        ((TextView) this.contentView.findViewById(R.id.iw4)).setText((CharSequence) null);
        ((TextView) this.contentView.findViewById(R.id.iw5)).setText((CharSequence) null);
        int[][] iArr = {new int[]{R.id.iw7, R.id.iw5}, new int[]{R.id.iw6, R.id.iw4}, new int[]{R.id.iw6, R.id.iw5}};
        ADXml adXml = this.DsC.getAdXml();
        if (!(adXml.adTurnInfo == null || adXml.adTurnInfo.DWP == null || adXml.adTurnInfo.DWP.size() < 2)) {
            ADXml.o oVar = adXml.adTurnInfo.DWP.get(i2);
            if (oVar.DWw >= 0 && oVar.DWw < 3) {
                int[] iArr2 = iArr[oVar.DWw];
                TextView textView = (TextView) this.contentView.findViewById(iArr2[0]);
                TextView textView2 = (TextView) this.contentView.findViewById(iArr2[1]);
                if (Util.isNullOrNil(oVar.title)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(oVar.title);
                }
                if (Util.isNullOrNil(oVar.desc)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(oVar.desc);
                }
                ((View) textView.getParent()).setVisibility(0);
                ((View) textView2.getParent()).setVisibility(0);
            }
        }
        AppMethodBeat.o(100042);
    }

    public final void fko() {
        final int i2;
        int i3;
        final int i4;
        int i5;
        AppMethodBeat.i(100043);
        if (this.timeLineObject.ContentObj.LoV.size() >= 2) {
            int i6 = this.DsC.getLikeFlag() == 1 ? 1 : 0;
            if (this.EBv != null && this.timeLineObject.ContentObj.LoV.get(i6).oUv == 6) {
                this.EBv.K(this.DsC.field_snsId, this.DsC.getLikeFlag() == 1);
            }
            if (this.ESr) {
                Log.i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
                AppMethodBeat.o(100043);
                return;
            }
            if (this.DsC.getLikeFlag() == 1) {
                i2 = 0;
                i3 = 1;
            } else {
                i2 = 1;
                i3 = 0;
            }
            final View a2 = a(this.timeLineObject.ContentObj.LoV.get(i3), i3, false);
            final View a3 = a(this.timeLineObject.ContentObj.LoV.get(i2), i2, true);
            int width = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth();
            int[] iArr = new int[2];
            this.contentView.getLocationOnScreen(iArr);
            this.contentView.setPivotY((float) ((width / 2) - iArr[1]));
            this.contentView.setCameraDistance(8000.0f);
            final float width2 = ((float) this.contentView.getWidth()) / 2.0f;
            final float height = ((float) this.contentView.getHeight()) / 2.0f;
            if (this.DsC.getLikeFlag() == 1) {
                i4 = -90;
                i5 = 90;
            } else {
                i4 = 90;
                i5 = -90;
            }
            com.tencent.mm.plugin.sns.ui.widget.a aVar = new com.tencent.mm.plugin.sns.ui.widget.a(this.context, 0.0f, (float) i5, width2, height, true);
            aVar.setDuration(187);
            aVar.setInterpolator(new AccelerateInterpolator());
            aVar.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.sns.ui.c.a.f.AnonymousClass2 */

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(100034);
                    f.this.contentView.setLayerType(2, null);
                    AppMethodBeat.o(100034);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(100035);
                    f.this.contentView.setLayerType(0, null);
                    a3.setVisibility(0);
                    a2.setVisibility(8);
                    f.this.aad(i2);
                    com.tencent.mm.plugin.sns.ui.widget.a aVar = new com.tencent.mm.plugin.sns.ui.widget.a(f.this.context, (float) i4, 0.0f, width2, height, false);
                    aVar.setDuration(187);
                    aVar.setInterpolator(new DecelerateInterpolator());
                    f.this.contentView.startAnimation(aVar);
                    f.this.ESr = false;
                    f.this.refreshView();
                    AppMethodBeat.o(100035);
                }
            });
            this.contentView.startAnimation(aVar);
            this.ESr = true;
        }
        AppMethodBeat.o(100043);
    }

    private View a(cnb cnb, int i2, boolean z) {
        AppMethodBeat.i(100044);
        int[] iArr = {R.id.iw1, R.id.iw2};
        if (z) {
            View findViewById = this.contentView.findViewById(iArr[i2]);
            AppMethodBeat.o(100044);
            return findViewById;
        } else if (cnb.oUv == 6) {
            View findViewById2 = this.contentView.findViewById(R.id.iw3);
            AppMethodBeat.o(100044);
            return findViewById2;
        } else if (cnb.oUv == 2) {
            View findViewById3 = this.contentView.findViewById(iArr[i2]);
            AppMethodBeat.o(100044);
            return findViewById3;
        } else {
            AppMethodBeat.o(100044);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    public final void refreshView() {
        AppMethodBeat.i(100045);
        this.DsC = com.tencent.mm.plugin.sns.storage.f.aQl(this.DsC.getSnsId());
        Log.i("MicroMsg.TurnCardAdDetailItem", "refresh view");
        int width = (((((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth() - a.fromDPToPix(this.context, 50)) - this.context.getResources().getDimensionPixelSize(R.dimen.ir)) - this.context.getResources().getDimensionPixelSize(R.dimen.ir)) - this.context.getResources().getDimensionPixelSize(R.dimen.k5);
        if (this.DsC.getTimeLine().ContentObj.LoV.size() >= 2) {
            final int i2 = this.DsC.field_likeFlag == 1 ? 1 : 0;
            aad(i2);
            for (final int i3 = 0; i3 < 2; i3++) {
                cnb cnb = this.DsC.getTimeLine().ContentObj.LoV.get(i3);
                MaskImageView maskImageView = (MaskImageView) this.contentView.findViewById(this.EWh[i3]);
                ViewGroup.LayoutParams layoutParams = maskImageView.getLayoutParams();
                maskImageView.setTag(this);
                if (cnb.oUv == 2) {
                    g faL = aj.faL();
                    int hashCode = hashCode();
                    bp gCY = bp.gCY();
                    gCY.hXs = this.timeLineObject.CreateTime;
                    faL.a(cnb, maskImageView, -1, hashCode, gCY, 3);
                } else {
                    g faL2 = aj.faL();
                    int hashCode2 = hashCode();
                    bp gCY2 = bp.gCY();
                    gCY2.hXs = this.timeLineObject.CreateTime;
                    faL2.a(cnb, maskImageView, hashCode2, gCY2);
                }
                maskImageView.setScaleType(QImageView.a.CENTER_CROP);
                layoutParams.width = width;
                layoutParams.height = width;
                if (i2 == i3 && cnb.oUv == 2) {
                    maskImageView.setVisibility(0);
                    maskImageView.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.c.a.f.AnonymousClass3 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(100036);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (f.this.EBv != null && i2 > 0) {
                                f.this.EBv.IS(f.this.DsC.field_snsId);
                            }
                            f.this.Dyw.Fbd.onClick(view);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(100036);
                        }
                    });
                } else {
                    maskImageView.setVisibility(8);
                    maskImageView.setOnClickListener(null);
                }
                if (cnb.oUv == 6 && i2 == i3) {
                    final boolean z = i2 > 0;
                    final long j2 = this.DsC.field_snsId;
                    ViewGroup.LayoutParams layoutParams2 = this.EUK.Ewr.getLayoutParams();
                    layoutParams2.width = width;
                    layoutParams2.height = width;
                    this.EUK.Ews.im(width, width);
                    this.EUK.Ewr.setVisibility(0);
                    aj.faL().a(this.DsC, cnb, this.EUK.Ews, this.context.hashCode(), 0, bp.Oqs, this.DsC.isAd(), true);
                    this.EUK.Ews.start();
                    this.EUK.Ewy = true;
                    this.EUK.Ewz = i3;
                    this.EUK.Ewq = this.timeLineObject;
                    this.EUK.position = 0;
                    this.EUK.dHp = this.DsC.getLocalid();
                    this.EUK.Ewu.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.c.a.f.AnonymousClass4 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(100037);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (f.this.EBv != null && z) {
                                f.this.EBv.IS(f.this.DsC.field_snsId);
                            }
                            f.this.Dyw.Fbd.onClick(view);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(100037);
                        }
                    });
                    this.EUK.Ews.setOnCompletionListener(new b.e() {
                        /* class com.tencent.mm.plugin.sns.ui.c.a.f.AnonymousClass5 */

                        @Override // com.tencent.mm.plugin.sight.decode.a.b.e
                        public final void c(com.tencent.mm.plugin.sight.decode.a.b bVar, int i2) {
                            AppMethodBeat.i(100038);
                            if (i2 != -1) {
                                f.this.EBv.I(j2, z);
                            }
                            AppMethodBeat.o(100038);
                        }
                    });
                    if (this.EBv != null) {
                        if (!this.EBv.IQ(((long) i3) + j2)) {
                            this.EUK.Ews.setOnDecodeDurationListener(new b.f() {
                                /* class com.tencent.mm.plugin.sns.ui.c.a.f.AnonymousClass6 */

                                @Override // com.tencent.mm.plugin.sight.decode.a.b.f
                                public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j2) {
                                    AppMethodBeat.i(100039);
                                    if (j2 >= 3) {
                                        int eVC = (int) bVar.eVC();
                                        if (f.this.EBv != null) {
                                            f.this.EBv.c(j2, Util.currentTicks(), z);
                                            f.this.EBv.e(j2, eVC, z);
                                            f.this.EBv.an(j2, j2 + ((long) i3));
                                        }
                                        f.this.EUK.Ews.setOnDecodeDurationListener(null);
                                    }
                                    AppMethodBeat.o(100039);
                                }
                            });
                        } else {
                            this.EBv.c(j2, Util.currentTicks(), z);
                        }
                    }
                    this.EUK.a(this.timeLineObject, 0, this.DsC.getLocalid(), this.DsC.isAd());
                    this.EUK.EeT.setVisibility(8);
                    g faL3 = aj.faL();
                    long nanoTime = System.nanoTime();
                    boolean u = g.u(cnb);
                    Log.i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", Boolean.valueOf(u), Long.valueOf(System.nanoTime() - nanoTime));
                    if (u) {
                        if (faL3.v(cnb)) {
                            this.EUK.EeS.setVisibility(0);
                            this.EUK.Ewv.setVisibility(8);
                            this.EUK.EeS.setImageDrawable(a.l(this.context, R.raw.shortvideo_play_btn));
                            this.EUK.EeS.setContentDescription(this.context.getString(R.string.fn7));
                        } else if (faL3.w(cnb)) {
                            this.EUK.EeS.setVisibility(8);
                            this.EUK.Ewv.setVisibility(8);
                        } else if (faL3.b(this.DsC, (int[]) null) <= 5) {
                            this.EUK.EeS.setVisibility(8);
                            this.EUK.Ewv.setVisibility(8);
                        } else {
                            faL3.z(cnb);
                            this.EUK.EeS.setVisibility(0);
                            this.EUK.Ewv.setVisibility(8);
                            this.EUK.EeS.setImageDrawable(a.l(this.context, R.raw.shortvideo_play_btn));
                            this.EUK.EeS.setContentDescription(this.context.getString(R.string.fn7));
                        }
                        if (this.EUK.Ews.Dnr.eVz()) {
                            Log.d("MicroMsg.TurnCardAdDetailItem", "play video error " + cnb.Id + " " + cnb.Url + " " + cnb.Msz + " 0");
                            faL3.z(cnb);
                            this.EUK.EeS.setVisibility(0);
                            this.EUK.Ewv.setVisibility(8);
                            this.EUK.EeS.setImageDrawable(a.l(this.context, R.raw.shortvideo_play_btn));
                            this.EUK.EeS.setContentDescription(this.context.getString(R.string.fn7));
                        }
                    } else if (faL3.x(cnb)) {
                        this.EUK.EeS.setVisibility(8);
                        this.EUK.Ewv.setVisibility(0);
                        this.EUK.Ewv.gYN();
                    } else if (faL3.b(this.DsC, (int[]) null) == 5) {
                        faL3.B(cnb);
                        this.EUK.EeS.setVisibility(8);
                        this.EUK.Ewv.setVisibility(0);
                        this.EUK.Ewv.gYN();
                    } else if (faL3.y(cnb)) {
                        this.EUK.Ewv.setVisibility(8);
                        this.EUK.EeS.setImageResource(R.raw.shortvideo_play_icon_err);
                        this.EUK.EeS.setVisibility(0);
                    } else {
                        faL3.z(cnb);
                        this.EUK.EeS.setVisibility(0);
                        this.EUK.Ewv.setVisibility(8);
                        this.EUK.EeS.setImageDrawable(a.l(this.context, R.raw.shortvideo_play_btn));
                        this.EUK.EeS.setContentDescription(this.context.getString(R.string.fn7));
                        if (faL3.b(this.DsC, (int[]) null) == 4) {
                            this.EUK.EeT.setVisibility(0);
                        }
                    }
                    if (this.EBv != null) {
                        if (s.YS(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.j(cnb))) {
                            this.EBv.f(this.DsC.field_snsId, 0, true);
                        } else {
                            this.EBv.f(this.DsC.field_snsId, 0, false);
                        }
                        this.EBv.d(j2, aj.faL().b(this.DsC, null) == 5, z);
                    }
                }
            }
        }
        AppMethodBeat.o(100045);
    }
}
