package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.timeline.b.f;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.a;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.vfs.s;

public class q extends BaseTimeLineItem implements a {
    private SnsInfo DqO;
    private View.OnClickListener EVA = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.item.q.AnonymousClass6 */

        public final void onClick(View view) {
            AppMethodBeat.i(203939);
            Log.i("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick");
            try {
                if (q.this.DQX.EKl.ffo() == 0) {
                    q.this.DQX.DQs.FaQ.onClick(view);
                } else if (q.this.DQX.EKl.ffo() == 1) {
                    q.this.DQX.DQs.FaQ.onClick(view);
                }
                q.this.EZH = true;
                AppMethodBeat.o(203939);
            } catch (Exception e2) {
                Log.e("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick, exp=" + e2.toString());
                AppMethodBeat.o(203939);
            }
        }
    };
    private boolean EXV;
    private boolean EZH = false;
    private boolean EZI = false;
    private b.e EZJ = new b.e() {
        /* class com.tencent.mm.plugin.sns.ui.item.q.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.sight.decode.a.b.e
        public final void c(b bVar, int i2) {
        }
    };
    private BaseTimeLineItem.BaseViewHolder EZK;
    View EZL = null;
    private String EZM = "";
    View EZN = null;
    private boolean EZO = false;
    private int mScreenHeight;
    private int mScreenWidth;

    public q() {
        AppMethodBeat.i(100124);
        AppMethodBeat.o(100124);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(100125);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.EZI = f.eXW();
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        this.EZK = baseViewHolder;
        if (baseViewHolder.EWD != null) {
            baseViewHolder.EWD.setLayoutResource(R.layout.bwf);
            baseViewHolder.EXu = (ViewStub) baseViewHolder.convertView.findViewById(R.id.dwu);
            if (!baseViewHolder.EXv) {
                baseViewHolder.EUK.Ewr = baseViewHolder.EXu.inflate();
                baseViewHolder.EXv = true;
            }
        } else {
            baseViewHolder.EUK.Ewr = baseViewHolder.convertView.findViewById(R.id.hyv);
            baseViewHolder.EXv = true;
        }
        baseViewHolder.EUK.Ewu = baseViewHolder.EUK.Ewr.findViewById(R.id.auf);
        baseViewHolder.EUK.Ews = (VideoSightView) baseViewHolder.EUK.Ewr.findViewById(R.id.dup);
        baseViewHolder.EUK.Ews.setMute(true);
        if (!(baseViewHolder == null || baseViewHolder.EUK == null)) {
            baseViewHolder.EUK.Ewt = (SnsAdTimelineVideoView) baseViewHolder.EUK.Ewr.findViewById(R.id.fxe);
            f.a(baseViewHolder.EUK.Ewt);
        }
        baseViewHolder.EUK.Ewu.setOnClickListener(this.EVA);
        baseViewHolder.EUK.EeS = (ImageView) baseViewHolder.EUK.Ewr.findViewById(R.id.i59);
        baseViewHolder.EUK.Ewv = (MMPinProgressBtn) baseViewHolder.EUK.Ewr.findViewById(R.id.gl7);
        baseViewHolder.EUK.Eww = (TextView) baseViewHolder.EUK.Ewr.findViewById(R.id.c3v);
        baseViewHolder.EUK.EeT = (TextView) baseViewHolder.EUK.Ewr.findViewById(R.id.c4k);
        g.aAi();
        if (((Boolean) g.aAh().azQ().get(344065, Boolean.FALSE)).booleanValue()) {
            baseViewHolder.EUK.Ews.setSightInfoView((TextView) ((ViewStub) baseViewHolder.EUK.Ewr.findViewById(R.id.hru)).inflate());
        }
        AppMethodBeat.o(100125);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        cnb cnb;
        boolean z;
        boolean z2;
        Pair<Integer, Integer> a2;
        boolean z3;
        int i4;
        Pair<Integer, Integer> a3;
        AppMethodBeat.i(100126);
        this.DqO = blVar.DqO;
        if (timeLineObject.ContentObj == null || timeLineObject.ContentObj.LoV.size() <= 0) {
            cnb = null;
        } else {
            cnb = timeLineObject.ContentObj.LoV.get(0);
        }
        if (this.DqO == null || !this.DqO.isAd()) {
            Log.i("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", Integer.valueOf(i2));
        } else {
            Log.i("MicroMsg.VideoTimeLineItem", "ad fillItem, videoItem, pos=" + i2 + ", snsId=" + timeLineObject.Id + ", hash=" + hashCode());
        }
        if (d.fkS().aRu(timeLineObject.Id)) {
            z = true;
        } else {
            z = false;
        }
        this.EZM = timeLineObject.Id;
        this.EZN = baseViewHolder.EUK.EeS;
        com.tencent.mm.plugin.sns.model.g faL = aj.faL();
        if (!blVar.Eoq) {
            baseViewHolder.EUK.Ews.setOnSightCompletionAction(null);
            baseViewHolder.EUK.Ews.setOnCompletionListener(null);
            baseViewHolder.EUK.Ews.setOnDecodeDurationListener(null);
            if (baseViewHolder.EUK.Ewt != null) {
                baseViewHolder.EUK.Ewt.setVideoCallback(null);
            }
        }
        baseViewHolder.EUK.Ews.setIsAdVideo(blVar.Eoq);
        if (baseViewHolder.EUK.Ewq != null && !Util.isEqual(baseViewHolder.EUK.Ewq.Id, timeLineObject.Id)) {
            Log.i("MicroMsg.VideoTimeLineItem", "need clear sightView %s", baseViewHolder.EUK.Ewq.Id);
            faL.a(baseViewHolder.EUK.Ews, this.mActivity.hashCode(), 0);
            a(baseViewHolder, faL, 0);
        }
        baseViewHolder.EUK.a(timeLineObject, i2, blVar.Eql, blVar.Eoq);
        baseViewHolder.EUK.EeT.setVisibility(8);
        if (timeLineObject.ContentObj != null && timeLineObject.ContentObj.LoV.size() > 0) {
            long nanoTime = System.nanoTime();
            boolean u = com.tencent.mm.plugin.sns.model.g.u(cnb);
            Log.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(u), Long.valueOf(System.nanoTime() - nanoTime));
            if (u) {
                if (faL.v(cnb)) {
                    a(baseViewHolder, 0, z);
                    baseViewHolder.EUK.Ewv.setVisibility(8);
                    baseViewHolder.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                    baseViewHolder.EUK.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                } else if (faL.w(cnb)) {
                    a(baseViewHolder, 8, z);
                    baseViewHolder.EUK.Ewv.setVisibility(8);
                } else if (!blVar.Eoq || faL.b(blVar.DqO, (int[]) null) > 5) {
                    faL.z(cnb);
                    a(baseViewHolder, 0, z);
                    baseViewHolder.EUK.Ewv.setVisibility(8);
                    baseViewHolder.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                    baseViewHolder.EUK.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                } else if (!this.EZH) {
                    Log.i("MicroMsg.VideoTimeLineItem", "fillItem, showPlayBtn");
                    fkq();
                }
                if (baseViewHolder.EUK.Ews.Dnr.eVz()) {
                    Log.e("MicroMsg.VideoTimeLineItem", "play video error " + cnb.Id + " " + cnb.Url + " " + cnb.Msz + " " + i2);
                    faL.z(cnb);
                    a(baseViewHolder, 0, z);
                    baseViewHolder.EUK.Ewv.setVisibility(8);
                    baseViewHolder.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                    baseViewHolder.EUK.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                }
            } else if (faL.x(cnb)) {
                a(baseViewHolder, 8, z);
                baseViewHolder.EUK.Ewv.setVisibility(0);
                baseViewHolder.EUK.Ewv.gYN();
            } else if (blVar.Eoq && faL.b(blVar.DqO, (int[]) null) == 5) {
                faL.B(cnb);
                a(baseViewHolder, 8, z);
                baseViewHolder.EUK.Ewv.setVisibility(0);
                baseViewHolder.EUK.Ewv.gYN();
            } else if (faL.y(cnb)) {
                baseViewHolder.EUK.Ewv.setVisibility(8);
                baseViewHolder.EUK.EeS.setImageResource(R.raw.shortvideo_play_icon_err);
                a(baseViewHolder, 0, z);
            } else {
                faL.z(cnb);
                a(baseViewHolder, 0, z);
                baseViewHolder.EUK.Ewv.setVisibility(8);
                baseViewHolder.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                baseViewHolder.EUK.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                if (!blVar.Eoq && faL.a(blVar.DqO, (int[]) null) == 4) {
                    baseViewHolder.EUK.EeT.setVisibility(0);
                } else if (blVar.Eoq && faL.b(blVar.DqO, (int[]) null) == 4) {
                    baseViewHolder.EUK.EeT.setVisibility(0);
                }
            }
            if (!blVar.Eoq || !k.d(baseViewHolder.timeLineObject)) {
                z2 = false;
                a2 = n.a(baseViewHolder.timeLineObject, baseViewHolder.EUK.Ews.getUIContext(), blVar.Eoq);
            } else {
                int i5 = 0;
                if (this.DqO != null) {
                    i5 = this.DqO.getAdXml().verticalVideoDisplayType;
                }
                if (i5 == 1) {
                    a3 = n.df(baseViewHolder.EUK.Ews.getUIContext());
                } else {
                    a3 = n.a(baseViewHolder.timeLineObject, baseViewHolder.EUK.Ews.getUIContext(), false);
                }
                Log.i("MicroMsg.VideoTimeLineItem", "isVerticalAdVideo=true, snsId=" + (blVar.DqO == null ? "" : Long.valueOf(blVar.DqO.field_snsId)) + ", showW=" + a3.first + ", showH=" + a3.second);
                z2 = true;
                a2 = a3;
            }
            if (blVar.Eoq) {
                ADXml adXml = blVar.DqO.getAdXml();
                int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
                if (adXml != null && adXml.adMediaDisplayWidth > 0.0f && adXml.adMediaDisplayHeight > 0.0f) {
                    float a4 = i.a((double) adXml.adMediaDisplayWidth, 1, adXml.adBasicRemWidth, adXml.adBasicRootFontSize);
                    float a5 = i.a((double) adXml.adMediaDisplayHeight, 1, adXml.adBasicRemWidth, adXml.adBasicRootFontSize);
                    if (adXml.adMediaDisplayMode == 0) {
                        if (a4 >= ((float) (((width - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 50)) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 12)) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 12)))) {
                            a4 = (float) (((width - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 50)) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 12)) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 12));
                            a5 = (float) ((int) ((adXml.adMediaDisplayHeight * a4) / adXml.adMediaDisplayWidth));
                        }
                        a2 = Pair.create(Integer.valueOf((int) a4), Integer.valueOf((int) a5));
                    } else if (adXml.adMediaDisplayMode == 1) {
                        int fromDPToPix = (((width - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 50)) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 50)) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 12)) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 12);
                        a2 = Pair.create(Integer.valueOf(fromDPToPix), Integer.valueOf((int) ((((float) fromDPToPix) * adXml.adMediaDisplayHeight) / adXml.adMediaDisplayWidth)));
                        baseViewHolder.EWA.setLayoutParams(new LinearLayout.LayoutParams(fromDPToPix, -2));
                    } else if (adXml.adMediaDisplayMode == 2) {
                        int fromDPToPix2 = ((width - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 50)) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 12)) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 12);
                        a2 = Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf((int) ((((float) fromDPToPix2) * adXml.adMediaDisplayHeight) / adXml.adMediaDisplayWidth)));
                        baseViewHolder.EWA.setLayoutParams(new LinearLayout.LayoutParams(fromDPToPix2, -2));
                    }
                }
            }
            int intValue = ((Integer) a2.first).intValue();
            int intValue2 = ((Integer) a2.second).intValue();
            if (baseViewHolder.EUK.Ews instanceof SightPlayImageView) {
                if (!blVar.Eoq) {
                    baseViewHolder.EUK.Ews.setScaleMode(1);
                    baseViewHolder.EUK.Ews.setScaleType(QImageView.a.CENTER_CROP);
                } else if (z2) {
                    baseViewHolder.EUK.Ews.setScaleMode(1);
                    baseViewHolder.EUK.Ews.setScaleType(QImageView.a.CENTER_CROP);
                } else {
                    baseViewHolder.EUK.Ews.setScaleMode(0);
                    baseViewHolder.EUK.Ews.setScaleType(QImageView.a.FIT_XY);
                }
            }
            baseViewHolder.EUK.Ews.im(intValue, intValue2);
            if (!(baseViewHolder == null || baseViewHolder.EUK == null)) {
                f.a(baseViewHolder.EUK.Ewt, intValue, intValue2);
            }
            if (baseViewHolder.EUK.Ews instanceof SightPlayImageView) {
                if (z2) {
                    baseViewHolder.EUK.Ews.Dnz = true;
                } else {
                    baseViewHolder.EUK.Ews.setDrawWidthAndHeightFix(false);
                }
            }
            if (eXX()) {
                a(baseViewHolder, true);
                baseViewHolder.EUK.Ews.setVisibility(8);
            } else {
                a(baseViewHolder, false);
                baseViewHolder.EUK.Ews.setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = baseViewHolder.EUK.Eww.getLayoutParams();
            layoutParams.width = intValue;
            layoutParams.height = intValue2;
            baseViewHolder.EUK.Eww.setLayoutParams(layoutParams);
            FrameLayout frameLayout = (FrameLayout) baseViewHolder.EUK.Ewr.findViewById(R.id.i1s);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams2.width = intValue;
            layoutParams2.height = intValue2;
            frameLayout.setLayoutParams(layoutParams2);
            View findViewById = baseViewHolder.EUK.Ewr.findViewById(R.id.imc);
            findViewById.setLayoutParams(new FrameLayout.LayoutParams(layoutParams));
            findViewById.setVisibility(4);
            this.EZL = frameLayout;
            SnsTimelineVideoView aRx = d.fkS().aRx(timeLineObject.Id);
            Log.i("MicroMsg.VideoTimeLineItem", "lxl fill itemview check videoView reAttach, tlObjId:%s, vv:%s, count:%s", timeLineObject.Id, aRx, Integer.valueOf(frameLayout.getChildCount()));
            if (frameLayout.getChildCount() == 1 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                frameLayout.removeAllViews();
                Log.i("MicroMsg.VideoTimeLineItem", "find thumbView thne remove it %s", timeLineObject.Id);
            }
            if (frameLayout.getChildCount() == 1 && (frameLayout.getChildAt(0) instanceof SnsTimelineVideoView)) {
                SnsTimelineVideoView snsTimelineVideoView = (SnsTimelineVideoView) frameLayout.getChildAt(0);
                if (!timeLineObject.Id.equals(snsTimelineVideoView.FcZ)) {
                    frameLayout.removeAllViews();
                    Log.i("MicroMsg.VideoTimeLineItem", "find diff id then remove it %s %s", timeLineObject.Id, snsTimelineVideoView.FcZ);
                }
            }
            if (aRx == null || frameLayout.getChildCount() != 0) {
                if (!z && frameLayout.getChildCount() > 0 && !d.fkS().aRv(timeLineObject.Id)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    frameLayout.removeViewAt(0);
                    Log.i("MicroMsg.VideoTimeLineItem", "lxl item remove videoview cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            } else if (!(aRx.getParent() == null || aRx.getParent() == frameLayout)) {
                aRx.Fdc = true;
                ((ViewGroup) aRx.getParent()).removeView(aRx);
                aRx.setVisibility(0);
                aRx.setVideoScaleType(i.e.COVER);
                frameLayout.addView(aRx, new FrameLayout.LayoutParams(-1, -1));
                Log.i("MicroMsg.VideoTimeLineItem", "lxl reAttach succ");
            }
            if (aRx != null) {
                String str = baseViewHolder.dHp;
                if (baseViewHolder.timeLineObject == null) {
                    i4 = 0;
                } else {
                    i4 = baseViewHolder.timeLineObject.CreateTime;
                }
                aRx.a(cnb, str, i4);
            }
            if (!eXX()) {
                baseViewHolder.EUK.Ews.setTagObject(baseViewHolder.EUK);
                if (blVar.DqO == null || !blVar.DqO.isAd() || !eXY()) {
                    SnsInfo snsInfo = blVar.DqO;
                    VideoSightView videoSightView = baseViewHolder.EUK.Ews;
                    int hashCode = this.mActivity.hashCode();
                    bp gCU = bp.gCU();
                    gCU.hXs = timeLineObject.CreateTime;
                    faL.a(snsInfo, cnb, videoSightView, hashCode, i2, gCU, blVar.Eoq, true);
                } else {
                    SnsInfo snsInfo2 = blVar.DqO;
                    VideoSightView videoSightView2 = baseViewHolder.EUK.Ews;
                    int hashCode2 = this.mActivity.hashCode();
                    bp gCU2 = bp.gCU();
                    gCU2.hXs = timeLineObject.CreateTime;
                    faL.a(snsInfo2, cnb, videoSightView2, -1, hashCode2, i2, gCU2, blVar.Eoq, true, false);
                }
            } else if (!(baseViewHolder == null || baseViewHolder.EUK == null || baseViewHolder.EUK.Ewt == null || faL == null || blVar == null || cnb == null || timeLineObject == null)) {
                baseViewHolder.EUK.Ewt.setTag(baseViewHolder.EUK);
                SnsAdTimelineVideoView snsAdTimelineVideoView = baseViewHolder.EUK.Ewt;
                SnsInfo snsInfo3 = blVar.DqO;
                Activity activity = this.mActivity;
                bp gCU3 = bp.gCU();
                gCU3.hXs = timeLineObject.CreateTime;
                f.a(snsAdTimelineVideoView, faL, snsInfo3, activity, cnb, i2, gCU3);
            }
            baseViewHolder.EUK.Ewu.setTag(baseViewHolder.EUK);
            String str2 = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.j(cnb);
            if (s.YS(str2)) {
                bkVar.EKl.EoE.f(blVar.ENp, (int) cnb.MsT, true);
                if (com.tencent.mm.plugin.sns.ad.e.b.KB() && blVar.Eoq) {
                    Log.i("MicroMsg.VideoTimeLineItem", "AdH265Helper, fileExists, isH265File=" + com.tencent.mm.modelvideo.r.isH265Video(str2) + ", path=" + str2);
                }
            } else {
                bkVar.EKl.EoE.f(blVar.ENp, (int) cnb.MsT, false);
            }
            if (blVar.Eoq) {
                z3 = aj.faL().b(blVar.DqO, null) == 5;
            } else {
                z3 = aj.faL().a(blVar.DqO, null) == 5;
            }
            bkVar.EKl.EoE.d(blVar.ENp, z3, false);
        } else if (eXX()) {
            a(baseViewHolder, faL, i2);
        } else {
            faL.a(baseViewHolder.EUK.Ews, this.mActivity.hashCode(), i2);
        }
        if (blVar.DqO != null && !blVar.DqO.isCardAd()) {
            bkVar.fiV().c(baseViewHolder.EUK.Ewu, bkVar.DQs.FaH, bkVar.DQs.Far);
        }
        AppMethodBeat.o(100126);
    }

    public final void fkq() {
        AppMethodBeat.i(176430);
        Log.i("MicroMsg.VideoTimeLineItem", "try show play btn");
        if (!(this.EZK == null || this.EZK.EUK == null || this.EXV)) {
            Log.i("MicroMsg.VideoTimeLineItem", "show play btn");
            this.EZK.EUK.EeS.setVisibility(0);
            this.EZK.EUK.Ewv.setVisibility(8);
            this.EZK.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
            this.EZK.EUK.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
        }
        AppMethodBeat.o(176430);
    }

    /* access modifiers changed from: protected */
    public final void eYc() {
        AppMethodBeat.i(203940);
        Log.i("MicroMsg.VideoTimeLineItem", "try hide play btn");
        if (!(this.EZK == null || this.EZK.EUK == null)) {
            Log.i("MicroMsg.VideoTimeLineItem", "hide play btn");
            this.EZK.EUK.EeS.setVisibility(8);
            this.EZK.EUK.Ewv.setVisibility(8);
        }
        AppMethodBeat.o(203940);
    }

    private static void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, boolean z) {
        AppMethodBeat.i(100127);
        if (z) {
            Log.i("MicroMsg.VideoTimeLineItem", "lxl setVideoStatusIvVisibility %s, but isPlaying", Integer.valueOf(i2));
            AppMethodBeat.o(100127);
            return;
        }
        baseViewHolder.EUK.EeS.setVisibility(i2);
        AppMethodBeat.o(100127);
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public void a(final BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2) {
        cnb cnb;
        SnsTimelineVideoView snsTimelineVideoView;
        SnsTimelineVideoView snsTimelineVideoView2;
        AppMethodBeat.i(176431);
        final SnsInfo aQm = aj.faO().aQm(baseViewHolder.dHp);
        if (aQm == null) {
            Log.w("MicroMsg.VideoTimeLineItem", "play error, snsId:%s", baseViewHolder.dHp);
            AppMethodBeat.o(176431);
            return;
        }
        TimeLineObject timeLine = aQm.getTimeLine();
        if (timeLine.ContentObj == null || timeLine.ContentObj.LoV.size() <= 0) {
            cnb = null;
        } else {
            cnb = timeLine.ContentObj.LoV.get(0);
        }
        if (cnb == null) {
            AppMethodBeat.o(176431);
        } else if (aQm.isAd()) {
            Log.i("MicroMsg.VideoTimeLineItem", "%s Ad autoPlay", this);
            final long j2 = aQm.field_snsId;
            if (!this.EZO) {
                this.EZO = true;
                baseViewHolder.EUK.Ews.setOnCompletionListener(new b.e() {
                    /* class com.tencent.mm.plugin.sns.ui.item.q.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.sight.decode.a.b.e
                    public final void c(b bVar, int i2) {
                        AppMethodBeat.i(100121);
                        if (i2 != -1) {
                            if (aQm == null || !aQm.isAd()) {
                                Log.e("MicroMsg.VideoTimeLineItem", "onCompletion, !isAd,  snsId=" + r.Jb(j2));
                                AppMethodBeat.o(100121);
                                return;
                            } else if (q.this.DQX == null || q.this.DQX.EKl == null || q.this.DQX.EKl.EoE == null) {
                                AppMethodBeat.o(100121);
                                return;
                            } else {
                                q.this.DQX.EKl.EoE.I(j2, false);
                                Log.d("MicroMsg.VideoTimeLineItem", "onCompletion, retCode=" + i2 + ", snsId=" + r.Jb(j2));
                            }
                        }
                        AppMethodBeat.o(100121);
                    }
                });
                baseViewHolder.EUK.Ews.setOnDecodeDurationListener(new b.f() {
                    /* class com.tencent.mm.plugin.sns.ui.item.q.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.sight.decode.a.b.f
                    public final void b(b bVar, long j2) {
                        AppMethodBeat.i(100122);
                        if (aQm == null || !aQm.isAd()) {
                            Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, !isAd, currentTime=" + j2 + ", snsId=" + r.Jb(j2));
                            AppMethodBeat.o(100122);
                        } else if (q.this.DQX == null || q.this.DQX.EKl == null || q.this.DQX.EKl.EoE == null) {
                            AppMethodBeat.o(100122);
                        } else {
                            if (aQm != null) {
                                q.this.DQX.EKl.EoE.IT(aQm.field_snsId);
                                q.this.DQX.EKl.EoE.ao(aQm.field_snsId, 1000 * j2);
                            }
                            if (!q.this.DQX.EKl.EoE.IQ(j2)) {
                                q.this.DQX.EKl.EoE.c(j2, Util.currentTicks(), false);
                                q.this.DQX.EKl.EoE.e(j2, (int) bVar.eVC(), false);
                                q.this.DQX.EKl.EoE.an(j2, j2);
                                Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, addPlay3s, snsId=" + r.Jb(j2));
                            }
                            Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, currentTime=" + j2 + ", snsId=" + r.Jb(j2));
                            AppMethodBeat.o(100122);
                        }
                    }
                });
                baseViewHolder.EUK.Ewt.setVideoCallback(new OfflineVideoView.a() {
                    /* class com.tencent.mm.plugin.sns.ui.item.q.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                    public final boolean a(PString pString) {
                        return false;
                    }

                    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                    public final void onStart(int i2) {
                        AppMethodBeat.i(203935);
                        Log.d("MicroMsg.VideoTimeLineItem", "onStart is called , the duration second is ".concat(String.valueOf(i2)));
                        AppMethodBeat.o(203935);
                    }

                    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                    public final void onCompletion() {
                        AppMethodBeat.i(203936);
                        baseViewHolder.EUK.Ewt.restart();
                        q.a(q.this, baseViewHolder, aQm);
                        AppMethodBeat.o(203936);
                    }

                    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                    public final void xv(int i2) {
                        AppMethodBeat.i(203937);
                        q.a(q.this, baseViewHolder, aQm, (long) i2, (long) baseViewHolder.EUK.Ewt.getDurationMs());
                        AppMethodBeat.o(203937);
                    }
                });
            } else {
                Log.d("MicroMsg.VideoTimeLineItem", "play, hasSetListener=true");
            }
            d.fkS().cXa();
            com.tencent.mm.plugin.sns.ui.video.b.fkM().a(this);
            if (eXX()) {
                BaseTimeLineItem.BaseViewHolder baseViewHolder2 = this.EZK;
                if (!(baseViewHolder2 == null || baseViewHolder2.EUK == null)) {
                    f.b(baseViewHolder2.EUK.Ewt);
                }
            } else {
                this.EZK.EUK.Ews.start();
            }
            eYc();
            this.EXV = true;
            this.EZH = false;
            AppMethodBeat.o(176431);
        } else {
            com.tencent.mm.plugin.sns.ui.video.b.fkM().pause();
            c cVar = new c();
            cVar.ebR = cnb;
            cVar.dHp = baseViewHolder.dHp;
            cVar.dRS = r.Jb(aQm.field_snsId);
            SnsInfo aQl = aj.faO().aQl(baseViewHolder.dRS);
            if (aQl != null) {
                cVar.iXu = aQl.getCreateTime();
            } else {
                cVar.iXu = (int) (System.currentTimeMillis() / 1000);
            }
            FrameLayout frameLayout = (FrameLayout) baseViewHolder.EUK.Ewr.findViewById(R.id.i1s);
            if (frameLayout.getChildCount() > 0) {
                snsTimelineVideoView = (SnsTimelineVideoView) frameLayout.getChildAt(0);
            } else {
                snsTimelineVideoView = null;
            }
            if (snsTimelineVideoView == null || snsTimelineVideoView.FcY == null || snsTimelineVideoView.Fdb || !Util.isEqual(timeLine.Id, snsTimelineVideoView.FcZ) || !Util.isEqual(snsTimelineVideoView.FcY.ebR.Id, cVar.ebR.Id)) {
                d.fkS();
                if (!d.gcR() || snsTimelineVideoView == null || snsTimelineVideoView.FcY != null) {
                    if (snsTimelineVideoView != null) {
                        frameLayout.removeViewAt(0);
                    }
                    SnsTimelineVideoView hd = d.fkS().hd(frameLayout.getContext());
                    if (hd.getParent() != null) {
                        hd.fkQ();
                        hd.Fdc = true;
                        ((ViewGroup) hd.getParent()).removeView(hd);
                    }
                    frameLayout.addView(hd, new FrameLayout.LayoutParams(-1, -1));
                    hd.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
                    snsTimelineVideoView2 = hd;
                } else {
                    Log.i("MicroMsg.VideoTimeLineItem", "reuse videoview by precreate View:%s", Integer.valueOf(snsTimelineVideoView.hashCode()));
                    snsTimelineVideoView2 = snsTimelineVideoView;
                }
            } else {
                Log.i("MicroMsg.VideoTimeLineItem", "reuse videoview:%s", Integer.valueOf(snsTimelineVideoView.hashCode()));
                snsTimelineVideoView2 = snsTimelineVideoView;
            }
            snsTimelineVideoView2.setVisibility(0);
            snsTimelineVideoView2.setVideoScaleType(i.e.COVER);
            baseViewHolder.EUK.Ewr.findViewById(R.id.imc).setVisibility(8);
            if (baseViewHolder.EUK.EeS != null) {
                baseViewHolder.EUK.EeS.setVisibility(8);
            }
            snsTimelineVideoView2.setUICallback(new SnsTimelineVideoView.b() {
                /* class com.tencent.mm.plugin.sns.ui.item.q.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b
                public final void Zl(String str) {
                    AppMethodBeat.i(203938);
                    Log.i("MicroMsg.VideoTimeLineItem", "onDestroy UICallback %s, %s", str, q.this.EZM);
                    if (!Util.isNullOrNil(str) && str.equals(q.this.EZM) && q.this.EZN != null) {
                        q.this.EZN.setVisibility(0);
                        Log.i("MicroMsg.VideoTimeLineItem", "onDestroy show videoStatusIv");
                    }
                    AppMethodBeat.o(203938);
                }
            });
            snsTimelineVideoView2.setVideoCallback(null);
            d.fkS().a(snsTimelineVideoView2, cVar, timeLine.Id);
            AppMethodBeat.o(176431);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void pause() {
        AppMethodBeat.i(176432);
        Log.i("MicroMsg.VideoTimeLineItem", "pause");
        doPause();
        fkq();
        AppMethodBeat.o(176432);
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void onUIPause() {
        AppMethodBeat.i(177697);
        Log.i("MicroMsg.VideoTimeLineItem", "onUIPause");
        doPause();
        AppMethodBeat.o(177697);
    }

    private void doPause() {
        AppMethodBeat.i(177698);
        Log.i("MicroMsg.VideoTimeLineItem", "%s Ad Video doPause", this);
        if (!(this.EZK == null || this.EZK.EUK == null)) {
            if (eXX()) {
                m(this.EZK);
            } else {
                this.EZK.EUK.Ews.pause();
            }
            ab(this.DqO);
        }
        this.EXV = false;
        AppMethodBeat.o(177698);
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void stop() {
        AppMethodBeat.i(176433);
        Log.i("MicroMsg.VideoTimeLineItem", "%s Ad Video stop", this);
        if (!(this.EZK == null || this.EZK.EUK == null)) {
            if (eXX()) {
                BaseTimeLineItem.BaseViewHolder baseViewHolder = this.EZK;
                Log.d("MicroMsg.VideoTimeLineItem", "newPlayerClear is called");
                if (!(baseViewHolder == null || baseViewHolder.EUK == null)) {
                    SnsAdTimelineVideoView snsAdTimelineVideoView = baseViewHolder.EUK.Ewt;
                    Log.d("NormalVideoAdHelper", "clear is called");
                    if (snsAdTimelineVideoView != null) {
                        snsAdTimelineVideoView.clear();
                    }
                }
            } else {
                this.EZK.EUK.Ews.Dnr.clear();
            }
        }
        this.EXV = false;
        AppMethodBeat.o(176433);
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final Rect getDisplayRect() {
        AppMethodBeat.i(100129);
        if (this.EZL != null) {
            int[] iArr = new int[2];
            this.EZL.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            Rect rect = new Rect(i2, i3, this.EZL.getMeasuredWidth() + i2, this.EZL.getMeasuredHeight() + i3);
            AppMethodBeat.o(100129);
            return rect;
        }
        AppMethodBeat.o(100129);
        return null;
    }

    private void ab(SnsInfo snsInfo) {
        AppMethodBeat.i(203941);
        if (!(this.DQX == null || this.DQX.EKl == null || this.DQX.EKl.EoE == null || snsInfo == null)) {
            this.DQX.EKl.EoE.IU(snsInfo.field_snsId);
        }
        AppMethodBeat.o(203941);
    }

    private static void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, boolean z) {
        AppMethodBeat.i(203942);
        if (baseViewHolder == null || baseViewHolder.EUK == null) {
            AppMethodBeat.o(203942);
            return;
        }
        f.a(baseViewHolder.EUK.Ewt, z);
        AppMethodBeat.o(203942);
    }

    private static void m(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(203943);
        if (baseViewHolder == null || baseViewHolder.EUK == null) {
            AppMethodBeat.o(203943);
            return;
        }
        f.c(baseViewHolder.EUK.Ewt);
        AppMethodBeat.o(203943);
    }

    private void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, com.tencent.mm.plugin.sns.model.g gVar, int i2) {
        AppMethodBeat.i(203944);
        Log.d("MicroMsg.VideoTimeLineItem", "cleanNewPlayerSnsSight is called, the position is ".concat(String.valueOf(i2)));
        if (baseViewHolder == null || baseViewHolder.EUK == null || gVar == null) {
            AppMethodBeat.o(203944);
            return;
        }
        f.a(baseViewHolder.EUK.Ewt, gVar, this.mActivity, i2);
        AppMethodBeat.o(203944);
    }

    /* access modifiers changed from: protected */
    public boolean eXX() {
        AppMethodBeat.i(203945);
        boolean z = false;
        SnsInfo snsInfo = this.DqO;
        if (this.EZI && snsInfo != null && snsInfo.isAd()) {
            z = true;
        }
        Log.i("MicroMsg.VideoTimeLineItem", "the useNewPlayer return value is ".concat(String.valueOf(z)));
        AppMethodBeat.o(203945);
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean eXY() {
        return false;
    }

    static /* synthetic */ void a(q qVar, BaseTimeLineItem.BaseViewHolder baseViewHolder, SnsInfo snsInfo) {
        AppMethodBeat.i(203946);
        if (!(baseViewHolder == null || snsInfo == null)) {
            long j2 = snsInfo.field_snsId;
            Log.d("MicroMsg.VideoTimeLineItem", "doOnNewPlayerCompletion is called, snsId=" + r.Jb(j2));
            if (!snsInfo.isAd()) {
                Log.e("MicroMsg.VideoTimeLineItem", "onCompletion, !isAd,  snsId=" + r.Jb(j2));
                AppMethodBeat.o(203946);
                return;
            } else if (qVar.DQX == null || qVar.DQX.EKl == null || qVar.DQX.EKl.EoE == null) {
                Log.e("MicroMsg.VideoTimeLineItem", "doOnNewPlayerCompletion is called , but the adapter isnsAdstatistic is null");
                AppMethodBeat.o(203946);
                return;
            } else {
                qVar.DQX.EKl.EoE.I(j2, false);
            }
        }
        AppMethodBeat.o(203946);
    }

    static /* synthetic */ void a(q qVar, BaseTimeLineItem.BaseViewHolder baseViewHolder, SnsInfo snsInfo, long j2, long j3) {
        AppMethodBeat.i(203947);
        Log.d("MicroMsg.VideoTimeLineItem", "doOnNewPlayerPlaying is called , the second  is ".concat(String.valueOf(j2)));
        if (baseViewHolder == null || snsInfo == null) {
            Log.e("MicroMsg.VideoTimeLineItem", "doOnNewPlayerPlaying is called , the holder or sns info is null");
            AppMethodBeat.o(203947);
            return;
        }
        long j4 = snsInfo.field_snsId;
        if (!snsInfo.isAd()) {
            Log.w("MicroMsg.VideoTimeLineItem", "doOnNewPlayerPlaying, the info is not Ad, snsId=" + r.Jb(j4));
            AppMethodBeat.o(203947);
        } else if (qVar.DQX == null || qVar.DQX.EKl == null || qVar.DQX.EKl.EoE == null) {
            Log.e("MicroMsg.VideoTimeLineItem", "doOnNewPlayerPlaying is called , but the adapter isnsAdstatistic is null");
            AppMethodBeat.o(203947);
        } else {
            qVar.DQX.EKl.EoE.IT(snsInfo.field_snsId);
            qVar.DQX.EKl.EoE.ao(snsInfo.field_snsId, j2);
            if (!qVar.DQX.EKl.EoE.IQ(j4)) {
                qVar.DQX.EKl.EoE.c(j4, Util.currentTicks(), false);
                qVar.DQX.EKl.EoE.e(j4, (int) (j3 / 1000), false);
                qVar.DQX.EKl.EoE.an(j4, j4);
                Log.d("MicroMsg.VideoTimeLineItem", "doOnNewPlayerPlaying, addPlay3s, snsId=" + r.Jb(j4));
            }
            AppMethodBeat.o(203947);
        }
    }
}
