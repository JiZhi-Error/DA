package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
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

public final class p extends BaseTimeLineItem {
    private static int[] EWh = {R.id.iw1, R.id.iw2};
    private static int[] EZt = {R.id.iw3};
    private static int[][] EZu = {new int[]{R.id.iw7, R.id.iw5}, new int[]{R.id.iw6, R.id.iw4}, new int[]{R.id.iw6, R.id.iw5}};
    private int EZs = 0;
    public int mScreenHeight = 0;
    private int mScreenWidth = 0;

    public static final class a {
        public cnb DIq;
        public SnsInfo DsC;
        public View EZA;
        public b EZB;
        public a EZC;
        public int index;
        public View view;
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(100120);
        a(aVar);
        AppMethodBeat.o(100120);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(100116);
        if (this.mActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            this.EZs = (((Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.i2)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.k5);
        }
        b bVar = (b) baseViewHolder;
        if (bVar.EWD != null && !bVar.EZE) {
            bVar.EWD.setLayoutResource(R.layout.bxw);
            if (!bVar.EZE) {
                bVar.EZD = bVar.EWD.inflate();
                bVar.EZE = true;
            }
        } else if (!bVar.EZE) {
            bVar.EZD = bVar.convertView.findViewById(R.id.iw0);
            bVar.EZE = true;
        }
        ViewGroup.LayoutParams layoutParams = bVar.EZD.getLayoutParams();
        layoutParams.width = this.EZs;
        layoutParams.height = this.EZs;
        ((RoundedCornerFrameLayout) bVar.EZD).setRadius(8.0f);
        at atVar = bVar.EZG;
        atVar.Ewu = w(bVar.EZD, 0, 6);
        atVar.Ewr = atVar.Ewu;
        atVar.Ews = (VideoSightView) atVar.Ewu.findViewById(R.id.dup);
        baseViewHolder.EUK.Ews.setMute(true);
        atVar.EeS = (ImageView) atVar.Ewu.findViewById(R.id.i59);
        atVar.Ewv = (MMPinProgressBtn) atVar.Ewu.findViewById(R.id.gl7);
        atVar.Eww = (TextView) atVar.Ewu.findViewById(R.id.c3v);
        atVar.EeT = (TextView) atVar.Ewu.findViewById(R.id.c4k);
        atVar.Ews.Dnz = true;
        atVar.Ews.setScaleType(QImageView.a.CENTER_CROP);
        atVar.Ews.im(this.EZs, this.EZs);
        bVar.wnX = bVar.EZD.findViewById(R.id.ik0);
        bVar.EVh = bVar.EZD.findViewById(R.id.ijz);
        AppMethodBeat.o(100116);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    @TargetApi(16)
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, final bk bkVar) {
        a aVar;
        a aVar2;
        AppMethodBeat.i(100117);
        Log.i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", Integer.valueOf(i2));
        if (baseViewHolder.hho) {
            Log.i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
            AppMethodBeat.o(100117);
            return;
        }
        final b bVar = (b) baseViewHolder;
        bVar.EZD.setTag(bVar);
        bVar.EZD.setVisibility(0);
        b bVar2 = bVar;
        for (int i4 : EWh) {
            View findViewById = bVar2.EZD.findViewById(i4);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (findViewById instanceof MaskImageView) {
                ((MaskImageView) findViewById).setScaleType(QImageView.a.CENTER_CROP);
            }
        }
        for (int i5 : EZt) {
            View findViewById2 = bVar2.EZD.findViewById(i5);
            if (findViewById2 != null) {
                findViewById2.setBackground(null);
                findViewById2.setVisibility(8);
                if (findViewById2 instanceof ViewGroup) {
                    ((ViewGroup) findViewById2).setClipChildren(false);
                }
            }
        }
        baseViewHolder.EWC.setLayoutParams(new LinearLayout.LayoutParams((((((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.i2)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.k5), -2));
        if (blVar.Eoq && i3 == 11) {
            if (timeLineObject.ContentObj == null || timeLineObject.ContentObj.LoV == null || timeLineObject.ContentObj.LoV.size() < 2) {
                Log.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
                AppMethodBeat.o(100117);
                return;
            }
            final int i6 = bVar.EWv == 1 ? 1 : 0;
            a aVar3 = null;
            a aVar4 = null;
            final int i7 = 0;
            while (i7 < Math.min(timeLineObject.ContentObj.LoV.size(), 2)) {
                cnb cnb = timeLineObject.ContentObj.LoV.get(i7);
                View w = w(bVar.EZD, i7, 2);
                w.setVisibility(4);
                if (w != null) {
                    w.setTag(baseViewHolder);
                    w.setOnClickListener(bkVar.DQs.Fbd);
                    if (cnb.oUv == 2) {
                        g faL = aj.faL();
                        int hashCode = this.mActivity.hashCode();
                        bp gCU = bp.gCU();
                        gCU.hXs = timeLineObject.CreateTime;
                        faL.a(cnb, w, -1, hashCode, gCU, 3);
                    } else {
                        g faL2 = aj.faL();
                        int hashCode2 = this.mActivity.hashCode();
                        bp gCU2 = bp.gCU();
                        gCU2.hXs = timeLineObject.CreateTime;
                        faL2.a(cnb, w, hashCode2, gCU2);
                    }
                    View view = null;
                    if (cnb.oUv == 6 && i6 == i7) {
                        final boolean z = i6 > 0;
                        final long j2 = blVar.ENp;
                        final at atVar = bVar.EZG;
                        SnsInfo snsInfo = blVar.DqO;
                        View view2 = atVar.Ewr;
                        atVar.Ewq = timeLineObject;
                        atVar.Ews.setOnCompletionListener(new b.e() {
                            /* class com.tencent.mm.plugin.sns.ui.item.p.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.sight.decode.a.b.e
                            public final void c(com.tencent.mm.plugin.sight.decode.a.b bVar, int i2) {
                                AppMethodBeat.i(100109);
                                if (i2 != -1) {
                                    if (bkVar == null || bkVar.EKl == null || bkVar.EKl.EoE == null) {
                                        AppMethodBeat.o(100109);
                                        return;
                                    }
                                    bkVar.EKl.EoE.I(j2, z);
                                }
                                AppMethodBeat.o(100109);
                            }
                        });
                        if (!bkVar.EKl.EoE.IQ(((long) i7) + j2)) {
                            atVar.Ews.setOnDecodeDurationListener(new b.f() {
                                /* class com.tencent.mm.plugin.sns.ui.item.p.AnonymousClass2 */

                                @Override // com.tencent.mm.plugin.sight.decode.a.b.f
                                public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j2) {
                                    AppMethodBeat.i(100110);
                                    if (bkVar == null || bkVar.EKl == null || bkVar.EKl.EoE == null) {
                                        AppMethodBeat.o(100110);
                                        return;
                                    }
                                    if (j2 >= 3) {
                                        bkVar.EKl.EoE.c(j2, Util.currentTicks(), z);
                                        bkVar.EKl.EoE.e(j2, (int) bVar.eVC(), z);
                                        bkVar.EKl.EoE.an(j2, j2 + ((long) i7));
                                        atVar.Ews.setOnDecodeDurationListener(null);
                                    }
                                    AppMethodBeat.o(100110);
                                }
                            });
                        } else if (!(bkVar == null || bkVar.EKl == null || bkVar.EKl.EoE == null)) {
                            bkVar.EKl.EoE.c(j2, Util.currentTicks(), z);
                        }
                        atVar.a(timeLineObject, i2, blVar.Eql, blVar.Eoq);
                        atVar.EeT.setVisibility(8);
                        g faL3 = aj.faL();
                        long nanoTime = System.nanoTime();
                        boolean u = g.u(cnb);
                        Log.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(u), Long.valueOf(System.nanoTime() - nanoTime));
                        if (u) {
                            if (faL3.v(cnb)) {
                                atVar.EeS.setVisibility(0);
                                atVar.Ewv.setVisibility(8);
                                atVar.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                                atVar.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                            } else if (faL3.w(cnb)) {
                                atVar.EeS.setVisibility(8);
                                atVar.Ewv.setVisibility(8);
                            } else if (faL3.b(snsInfo, (int[]) null) <= 5) {
                                atVar.EeS.setVisibility(8);
                                atVar.Ewv.setVisibility(8);
                            } else {
                                faL3.z(cnb);
                                atVar.EeS.setVisibility(0);
                                atVar.Ewv.setVisibility(8);
                                atVar.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                                atVar.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                            }
                            if (atVar.Ews.Dnr.eVz()) {
                                Log.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + cnb.Id + " " + cnb.Url + " " + cnb.Msz + " " + i2);
                                faL3.z(cnb);
                                atVar.EeS.setVisibility(0);
                                atVar.Ewv.setVisibility(8);
                                atVar.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                                atVar.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                            }
                        } else if (faL3.x(cnb)) {
                            atVar.EeS.setVisibility(8);
                            atVar.Ewv.setVisibility(0);
                            atVar.Ewv.gYN();
                        } else if (faL3.b(snsInfo, (int[]) null) == 5) {
                            faL3.B(cnb);
                            atVar.EeS.setVisibility(8);
                            atVar.Ewv.setVisibility(0);
                            atVar.Ewv.gYN();
                        } else if (faL3.y(cnb)) {
                            atVar.Ewv.setVisibility(8);
                            atVar.EeS.setImageResource(R.raw.shortvideo_play_icon_err);
                            atVar.EeS.setVisibility(0);
                        } else {
                            faL3.z(cnb);
                            atVar.EeS.setVisibility(0);
                            atVar.Ewv.setVisibility(8);
                            atVar.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                            atVar.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                            if (faL3.b(snsInfo, (int[]) null) == 4) {
                                atVar.EeT.setVisibility(0);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = atVar.Eww.getLayoutParams();
                        layoutParams.width = this.EZs;
                        layoutParams.height = this.EZs;
                        atVar.Eww.setLayoutParams(layoutParams);
                        atVar.Ews.setTagObject(atVar);
                        VideoSightView videoSightView = atVar.Ews;
                        int hashCode3 = this.mActivity.hashCode();
                        bp gCU3 = bp.gCU();
                        gCU3.hXs = timeLineObject.CreateTime;
                        faL3.a(snsInfo, cnb, videoSightView, hashCode3, i2, gCU3, blVar.Eoq, true);
                        faL3.start();
                        view2.setVisibility(0);
                        atVar.Ewu.setTag(baseViewHolder);
                        atVar.Ewu.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ui.item.p.AnonymousClass3 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(100111);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (i6 > 0) {
                                    bkVar.EKl.EoE.IS(bVar.EWu);
                                }
                                bkVar.DQs.Fbd.onClick(view);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(100111);
                            }
                        });
                        if (s.YS(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.j(cnb))) {
                            bkVar.EKl.EoE.b(blVar.ENp, 0, true, z);
                        } else {
                            bkVar.EKl.EoE.b(blVar.ENp, 0, false, z);
                        }
                        bkVar.EKl.EoE.d(blVar.ENp, aj.faL().b(snsInfo, null) == 5, z);
                        view = view2;
                    }
                    ViewGroup.LayoutParams layoutParams2 = w.getLayoutParams();
                    layoutParams2.width = this.EZs;
                    layoutParams2.height = this.EZs;
                    w.setLayoutParams(layoutParams2);
                    if (view != null) {
                        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                        layoutParams3.width = this.EZs;
                        layoutParams3.height = this.EZs;
                        view.setLayoutParams(layoutParams3);
                    }
                    if (i6 == i7 && cnb.oUv == 2) {
                        w.setVisibility(0);
                        w.setOnTouchListener(new View.OnTouchListener() {
                            /* class com.tencent.mm.plugin.sns.ui.item.p.AnonymousClass4 */

                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                return false;
                            }
                        });
                    }
                    a aVar5 = new a();
                    aVar5.index = i7;
                    if (view == null) {
                        view = w;
                    }
                    aVar5.view = view;
                    aVar5.EZA = w;
                    aVar5.EZB = bVar;
                    aVar5.DIq = cnb;
                    aVar5.DsC = blVar.DqO;
                    if (aVar3 != null) {
                        aVar3.EZC = aVar5;
                        aVar = aVar4;
                    } else {
                        aVar = aVar5;
                    }
                    if (i7 == timeLineObject.ContentObj.LoV.size() - 1) {
                        aVar5.EZC = aVar;
                    }
                    if (i7 == i6) {
                        bVar.EZF = aVar5;
                        a(aVar5);
                    }
                    aVar2 = aVar5;
                } else {
                    aVar = aVar4;
                    aVar2 = aVar3;
                }
                i7++;
                aVar4 = aVar;
                aVar3 = aVar2;
            }
            if (bVar.convertView != null && (bVar.convertView instanceof FrameLayout)) {
                ((FrameLayout) bVar.convertView).setClipChildren(false);
            }
            if (bVar.EWC != null) {
                bVar.EWC.setClipChildren(false);
            }
            if (bVar.EXw != null && (bVar.EXw instanceof LinearLayout)) {
                ((LinearLayout) bVar.EXw).setClipChildren(false);
            }
            bVar.EZD.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.item.p.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(100112);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    bkVar.DQs.Fbd.onClick(view);
                    if (i6 > 0) {
                        bkVar.EKl.EoE.IS(bVar.EWu);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/TurnMediaTimeLineItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100112);
                }
            });
        }
        AppMethodBeat.o(100117);
    }

    public static View w(View view, int i2, int i3) {
        AppMethodBeat.i(100118);
        if (i3 == 6) {
            View findViewById = view.findViewById(EZt[0]);
            AppMethodBeat.o(100118);
            return findViewById;
        }
        View findViewById2 = view.findViewById(EWh[i2]);
        AppMethodBeat.o(100118);
        return findViewById2;
    }

    private static void a(a aVar) {
        AppMethodBeat.i(100119);
        aVar.EZB.wnX.setVisibility(8);
        aVar.EZB.EVh.setVisibility(8);
        ((TextView) aVar.EZB.EZD.findViewById(R.id.iw6)).setText((CharSequence) null);
        ((TextView) aVar.EZB.EZD.findViewById(R.id.iw7)).setText((CharSequence) null);
        ((TextView) aVar.EZB.EZD.findViewById(R.id.iw4)).setText((CharSequence) null);
        ((TextView) aVar.EZB.EZD.findViewById(R.id.iw5)).setText((CharSequence) null);
        ADXml adXml = aVar.DsC.getAdXml();
        if (!(adXml.adTurnInfo == null || adXml.adTurnInfo.DWP == null || adXml.adTurnInfo.DWP.size() < 2)) {
            ADXml.o oVar = adXml.adTurnInfo.DWP.get(aVar.index);
            if (oVar.DWw >= 0 && oVar.DWw < EZu.length) {
                int[] iArr = EZu[oVar.DWw];
                TextView textView = (TextView) aVar.EZB.EZD.findViewById(iArr[0]);
                TextView textView2 = (TextView) aVar.EZB.EZD.findViewById(iArr[1]);
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
        AppMethodBeat.o(100119);
    }

    public static class b extends BaseTimeLineItem.BaseViewHolder {
        public View EVh;
        public View EZD;
        public boolean EZE = false;
        public a EZF;
        public at EZG = new at();
        public View wnX;

        public b() {
            AppMethodBeat.i(100115);
            AppMethodBeat.o(100115);
        }
    }
}
