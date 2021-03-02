package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.af;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.bq;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseTimeLineItem {
    public boolean DEBUG = false;
    protected bk DQX;
    protected boolean EAv = false;
    public ArrayList<au.b> EWs = new ArrayList<>();
    protected Activity mActivity;
    private com.tencent.mm.pluginsdk.ui.span.a mAdTagClickCallback = new com.tencent.mm.pluginsdk.ui.span.a() {
        /* class com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.AnonymousClass2 */

        @Override // com.tencent.mm.pluginsdk.ui.span.a
        public final void iL(int i2, int i3) {
            AppMethodBeat.i(203908);
            try {
                SnsInfo Zv = BaseTimeLineItem.this.DQX.Zv(i2);
                if (Zv != null) {
                    Log.i("AdTagClickableHelper", "BaseTimeLineItem position = " + i2 + ", snsId = " + Zv.field_snsId + ", source = SOURCE_TIMELINE , clickPos = " + i3);
                    com.tencent.mm.plugin.sns.ad.timeline.b.b.a(BaseTimeLineItem.this.mActivity, 0, Zv, i3);
                    AppMethodBeat.o(203908);
                    return;
                }
                Log.e("AdTagClickableHelper", "BaseTimeLineItem, snsInfo is null");
                AppMethodBeat.o(203908);
            } catch (Throwable th) {
                Log.e("AdTagClickableHelper", th.toString());
                AppMethodBeat.o(203908);
            }
        }
    };
    protected int qcr;

    public abstract void a(BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar);

    public abstract void d(BaseViewHolder baseViewHolder);

    public static class BaseViewHolder {
        public bq DDr;
        public TextView DGi;
        public int EBt = 210;
        public TextView EIm;
        public View EIs;
        public at EUK = new at();
        public AsyncNormalTextView EWA;
        public SnsTranslateResultView EWB;
        public LinearLayout EWC;
        public ViewStub EWD;
        public boolean EWE = false;
        public TextView EWF;
        public TagImageView EWG;
        public TextView EWH;
        public int EWI = 0;
        public RelativeLayout EWJ;
        public TextView EWK;
        public WeImageView EWL;
        public AsyncTextView EWM;
        public AsyncTextView EWN;
        public View EWO;
        public ImageView EWP;
        public View EWQ;
        public SnsLikesTextView EWR;
        public boolean EWS = false;
        public LinearLayout EWT;
        public LinearLayout EWU;
        public View EWV;
        public LinearLayout EWW;
        public PhotosContent EWX;
        public View EWY;
        public ViewStub EWZ;
        public long EWu;
        public int EWv;
        public SnsAvatarImageView EWw;
        public AsyncTextView EWx;
        public ImageView EWy;
        public ViewGroup EWz;
        public MaskTextView EXA;
        public View EXB;
        private TextView EXC;
        public String EXD;
        public View EXE;
        public boolean EXF = false;
        public ViewStub EXG;
        public LinearLayout EXH;
        public ViewGroup EXI;
        public boolean EXJ = false;
        public ViewStub EXK;
        public LinearLayout EXL;
        public TextView EXM;
        public TextView EXN;
        public View EXO;
        public boolean EXa = false;
        public ViewStub EXb;
        public ViewStub EXc;
        public View EXd = null;
        public boolean EXe = false;
        public boolean EXf = false;
        public ViewStub EXg;
        public boolean EXh = false;
        public View EXi;
        public LinearLayout EXj;
        public TextView EXk;
        public ViewStub EXl;
        public boolean EXm = false;
        public View EXn;
        public LinearLayout EXo;
        public ViewStub EXp;
        public boolean EXq = false;
        public View EXr;
        public ImageView EXs;
        public boolean EXt = false;
        ViewStub EXu;
        boolean EXv = false;
        public View EXw;
        public BaseTimeLineItem EXx;
        public ViewStub EXy;
        public View EXz;
        public TextView EeT;
        public LinearLayout EnO;
        public com.tencent.mm.contact.c Eou;
        public TextView EqV;
        public View convertView;
        public String dHp;
        public String dRS;
        public volatile boolean hho;
        public boolean isAd;
        public TextView jBQ;
        public ViewGroup jLy;
        public int position;
        public cnc postInfo;
        public int qcr;
        public SnsObject snsobj;
        public TimeLineObject timeLineObject;
        public TextView timeTv;
        public TextView titleTv;
        public ImageView uzC;
        public boolean xEm;

        public BaseViewHolder() {
            AppMethodBeat.i(100055);
            AppMethodBeat.o(100055);
        }
    }

    public final void setIsFromMainTimeline(boolean z) {
        this.EAv = z;
    }

    public static ViewStub i(BaseViewHolder baseViewHolder) {
        return baseViewHolder.EWD;
    }

    private static void a(BaseViewHolder baseViewHolder, SnsInfo snsInfo) {
        if (snsInfo.isAd()) {
            if (baseViewHolder.EWA != null) {
                baseViewHolder.EWA.setVisibility(0);
            }
            baseViewHolder.EWC.setLongClickable(false);
            baseViewHolder.EWC.setOnClickListener(null);
            baseViewHolder.EWC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            baseViewHolder.EWC.setBackgroundColor(Color.parseColor("#00ffffff"));
            if (baseViewHolder.EWX != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baseViewHolder.EWX.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                baseViewHolder.EWX.setLayoutParams(layoutParams);
            }
            if (baseViewHolder.EXv) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) baseViewHolder.EUK.Ewr.getLayoutParams();
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                baseViewHolder.EUK.Ewr.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        if (baseViewHolder.EWA != null) {
            baseViewHolder.EWA.setVisibility(0);
        }
        baseViewHolder.EWC.setLongClickable(false);
        baseViewHolder.EWC.setOnClickListener(null);
        if (baseViewHolder.EWX != null) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) baseViewHolder.EWX.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            baseViewHolder.EWX.setLayoutParams(layoutParams3);
        }
        if (baseViewHolder.EXv) {
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) baseViewHolder.EUK.Ewr.getLayoutParams();
            layoutParams4.leftMargin = 0;
            layoutParams4.rightMargin = 0;
            baseViewHolder.EUK.Ewr.setLayoutParams(layoutParams4);
        }
        baseViewHolder.EWC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        baseViewHolder.EWC.setBackgroundColor(Color.parseColor("#00ffffff"));
    }

    public final View a(Activity activity, BaseViewHolder baseViewHolder, int i2, bk bkVar, SnsInfo snsInfo) {
        String str;
        this.mActivity = activity;
        this.qcr = i2;
        this.DQX = bkVar;
        baseViewHolder.dRS = snsInfo.getSnsId();
        switch (i2) {
            case 0:
            case 1:
            case 7:
            case 8:
            case 16:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 2:
                str = "R.layout.sns_timeline_imagesline_one";
                break;
            case 3:
                str = "R.layout.sns_timeline_imagesline1";
                break;
            case 4:
                str = "R.layout.sns_timeline_imagesline2";
                break;
            case 5:
                str = "R.layout.sns_timeline_imagesline3";
                break;
            case 6:
                str = "R.layout.sns_timeline_item_photo_one3";
                break;
            case 9:
            case 24:
                str = "R.layout.sns_media_sight_item";
                break;
            case 10:
                str = "R.layout.sns_hb_reward_item";
                break;
            case 11:
                str = "R.layout.sns_timeline_turn_media";
                break;
            case 12:
                str = "R.layout.sns_media_collapse_item";
                break;
            case 13:
                str = "R.layout.sns_ad_card_layout_item";
                break;
            case 14:
                str = "R.layout.sns_timeline_ad_full_card";
                break;
            case 15:
                str = "R.layout.sns_timeline_ad_sphere_card";
                break;
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
            default:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 19:
                str = "R.layout.sns_media_sight_item";
                break;
            case 23:
                str = "R.layout.sns_ad_finder_topic_item_content";
                break;
        }
        com.tencent.mm.kiss.a.b.aBh();
        View c2 = com.tencent.mm.kiss.a.b.c(this.mActivity, R.layout.bxu);
        baseViewHolder.EXE = c2;
        baseViewHolder.EXD = str;
        View findViewById = c2.findViewById(R.id.dwu);
        if (findViewById instanceof ViewStub) {
            baseViewHolder.EWD = (ViewStub) findViewById;
        } else {
            baseViewHolder.EWD = null;
        }
        Log.i("MicroMsg.BaseTimeLineItem", "create new item  " + i2 + "  " + c2.hashCode());
        baseViewHolder.EXw = c2.findViewById(R.id.i16);
        baseViewHolder.qcr = i2;
        baseViewHolder.EWw = (SnsAvatarImageView) c2.findViewById(R.id.iu);
        baseViewHolder.EWw.setWeakContext(activity);
        baseViewHolder.EWw.setOnClickListener(bkVar.DQs.Fas);
        baseViewHolder.EWw.setOnLongClickListener(bkVar.DQs.Fat);
        baseViewHolder.EWw.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(100046);
                if (motionEvent.getAction() == 0) {
                    view.setTag(R.id.iu_, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                }
                AppMethodBeat.o(100046);
                return false;
            }
        });
        baseViewHolder.EWx = (AsyncTextView) c2.findViewById(R.id.fzg);
        baseViewHolder.EWy = (ImageView) c2.findViewById(R.id.izi);
        baseViewHolder.EWx.setOnTouchListener(new af());
        baseViewHolder.EWz = (ViewGroup) c2.findViewById(R.id.fzb);
        baseViewHolder.EWA = (AsyncNormalTextView) c2.findViewById(R.id.bmy);
        baseViewHolder.EWA.setOpClickListener(bkVar.EKD);
        baseViewHolder.EWA.setShrinkOrSpreadListener(bkVar.EKE);
        baseViewHolder.EWC = (LinearLayout) c2.findViewById(R.id.dwv);
        baseViewHolder.EWC.setTag(baseViewHolder);
        baseViewHolder.EWC.setOnClickListener(bkVar.DQs.Fbd);
        bkVar.fiV().c(c2.findViewById(R.id.bn6), bkVar.DQs.Fau, bkVar.DQs.Far);
        bkVar.fiV().c((TextView) c2.findViewById(R.id.bn7), bkVar.DQs.Fau, bkVar.DQs.Far);
        baseViewHolder.EWB = (SnsTranslateResultView) c2.findViewById(R.id.i1c);
        baseViewHolder.EWB.setVisibility(8);
        baseViewHolder.EWB.getSplitlineView().setPadding(0, 0, 0, 0);
        baseViewHolder.EWB.getResultTextView().setBackgroundResource(R.drawable.auv);
        bkVar.fiV().c(baseViewHolder.EWB.getResultTextView(), bkVar.DQs.Fau, bkVar.DQs.Far);
        baseViewHolder.EWW = (LinearLayout) c2.findViewById(R.id.b95);
        baseViewHolder.EWK = (TextView) c2.findViewById(R.id.joc);
        baseViewHolder.timeTv = (TextView) c2.findViewById(R.id.km);
        baseViewHolder.EWM = (AsyncTextView) c2.findViewById(R.id.ip);
        baseViewHolder.EWN = (AsyncTextView) c2.findViewById(R.id.f3093io);
        baseViewHolder.EIm = (TextView) c2.findViewById(R.id.is);
        baseViewHolder.DDr = new bq(c2);
        baseViewHolder.DDr.b(bkVar.DQs.FaC, bkVar.DQs.FaS);
        baseViewHolder.EWJ = (RelativeLayout) c2.findViewById(R.id.g4r);
        baseViewHolder.EWJ.setOnClickListener(bkVar.DQs.FaV);
        baseViewHolder.EqV = (TextView) c2.findViewById(R.id.jr);
        baseViewHolder.EqV.setText(activity.getString(R.string.tf));
        baseViewHolder.EqV.setContentDescription(activity.getString(R.string.tf));
        baseViewHolder.EqV.setOnClickListener(bkVar.DQs.Faw);
        baseViewHolder.EWM.setOnClickListener(bkVar.DQs.FaT);
        baseViewHolder.EWN.setOnClickListener(bkVar.DQs.FaU);
        baseViewHolder.EIm.setOnClickListener(bkVar.DQs.FaP);
        baseViewHolder.EWO = c2.findViewById(R.id.jv);
        baseViewHolder.EWO.setOnClickListener(bkVar.DQs.FaB);
        baseViewHolder.EWL = (WeImageView) c2.findViewById(R.id.le);
        baseViewHolder.jBQ = (TextView) c2.findViewById(R.id.ju);
        baseViewHolder.EWP = (ImageView) c2.findViewById(R.id.kn);
        baseViewHolder.EWZ = (ViewStub) c2.findViewById(R.id.jm);
        baseViewHolder.EnO = (LinearLayout) c2.findViewById(R.id.ke);
        baseViewHolder.EXy = (ViewStub) c2.findViewById(R.id.jx);
        baseViewHolder.EXG = (ViewStub) c2.findViewById(R.id.i1f);
        baseViewHolder.EXK = (ViewStub) c2.findViewById(R.id.i05);
        baseViewHolder.jLy = (ViewGroup) c2.findViewById(R.id.hyd);
        baseViewHolder.EXb = (ViewStub) c2.findViewById(R.id.hzu);
        baseViewHolder.EWF = (TextView) c2.findViewById(R.id.dhk);
        baseViewHolder.EWF.setOnClickListener(bkVar.DQs.Fax);
        baseViewHolder.EXC = (TextView) c2.findViewById(R.id.dne);
        baseViewHolder.EXN = (TextView) c2.findViewById(R.id.i1u);
        baseViewHolder.convertView = c2;
        baseViewHolder.EXO = c2.findViewById(R.id.i17);
        if (this.EAv) {
            com.tencent.mm.plugin.sns.abtest.c.b(c2, baseViewHolder);
            com.tencent.mm.plugin.sns.abtest.a.a(c2, baseViewHolder);
            aj.faF();
            com.tencent.mm.plugin.sns.h.c.c(c2, baseViewHolder);
        }
        d(baseViewHolder);
        c2.setTag(baseViewHolder);
        a(baseViewHolder, snsInfo);
        return c2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x06f7  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x07b4  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x07c3  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x07e7  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x088d  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x08f6  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0973  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0e82  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0e93  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x1028  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x1036  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x1079  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x10a3  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x10be  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x1132  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x1159  */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x119f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder r16, int r17, com.tencent.mm.plugin.sns.storage.SnsInfo r18, com.tencent.mm.protocal.protobuf.TimeLineObject r19, int r20, final com.tencent.mm.plugin.sns.ui.bk r21, com.tencent.mm.plugin.sns.ui.bl r22) {
        /*
        // Method dump skipped, instructions count: 4740
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.a(com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder, int, com.tencent.mm.plugin.sns.storage.SnsInfo, com.tencent.mm.protocal.protobuf.TimeLineObject, int, com.tencent.mm.plugin.sns.ui.bk, com.tencent.mm.plugin.sns.ui.bl):void");
    }

    private void b(BaseViewHolder baseViewHolder, SnsInfo snsInfo) {
        w wVar;
        baseViewHolder.EXN.setVisibility(8);
        if (this.DQX != null && this.DQX.EKy) {
            x faW = aj.faW();
            long j2 = snsInfo.field_snsId;
            Cursor rawQuery = faW.iFy.rawQuery("select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.bottom<=" + j2 + " AND SnsWsFoldGroup.top>=" + j2, null, 2);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    wVar = new w();
                    wVar.convertFrom(rawQuery);
                } else {
                    wVar = null;
                }
                rawQuery.close();
            } else {
                wVar = null;
            }
            if (wVar != null) {
                String Jc = r.Jc(wVar.field_top);
                String Jc2 = r.Jc(wVar.field_bottom);
                n faO = aj.faO();
                String feR = n.feR();
                if (Jc == null || !Jc.equals("")) {
                    feR = feR + " AND " + faO.aQB(Jc);
                }
                if (n.aQw(Jc2)) {
                    feR = feR + " AND " + faO.aQx(Jc2);
                }
                String str = feR + n.Emu;
                Log.d("MicroMsg.SnsInfoStorage", "getCursorByTimeLineSeqIncluded ".concat(String.valueOf(str)));
                Cursor rawQuery2 = faO.iFy.rawQuery(str, null);
                ArrayList arrayList = new ArrayList();
                if (rawQuery2 != null) {
                    while (rawQuery2.moveToNext()) {
                        SnsInfo snsInfo2 = new SnsInfo();
                        snsInfo2.convertFrom(rawQuery2);
                        arrayList.add(snsInfo2);
                    }
                    rawQuery2.close();
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= arrayList.size()) {
                        i2 = 0;
                        break;
                    } else if (((SnsInfo) arrayList.get(i2)).field_snsId == snsInfo.field_snsId) {
                        break;
                    } else {
                        i2++;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("top:").append(Jc).append("bottom:").append(Jc2).append("\n");
                sb.append("snsid:").append(r.Jc(snsInfo.field_snsId)).append("\n");
                sb.append("indexInGroup:").append(i2);
                baseViewHolder.EXN.setText(sb.toString());
                baseViewHolder.EXN.setVisibility(0);
            }
        }
    }

    public static void a(au.b bVar, BaseViewHolder baseViewHolder, String str, String str2) {
        if (baseViewHolder != null && baseViewHolder.EWB != null) {
            baseViewHolder.EWB.a(bVar, 1, str, str2, bVar.DNh);
            baseViewHolder.EWB.setVisibility(0);
        }
    }

    public static void j(BaseViewHolder baseViewHolder) {
        if (baseViewHolder != null && baseViewHolder.EWB != null) {
            baseViewHolder.EWB.ZW(1);
            baseViewHolder.EWB.setVisibility(0);
        }
    }

    public static void k(BaseViewHolder baseViewHolder) {
        if (baseViewHolder != null && baseViewHolder.EWB != null) {
            baseViewHolder.EWB.setVisibility(8);
        }
    }

    private void a(ADInfo aDInfo, BaseViewHolder baseViewHolder) {
        if (aDInfo == null || baseViewHolder == null) {
            Log.i("MicroMsg.BaseTimeLineItem", "adInfo or holder is null");
            return;
        }
        try {
            if (aDInfo.adChainType == 1 && !Util.isNullOrNil(aDInfo.adActionExtTailFormattedWording)) {
                String str = aDInfo.adActionExtTailUserDisplayName;
                String str2 = aDInfo.adActionExtTailFormattedWording;
                Activity activity = this.mActivity;
                baseViewHolder.EWM.getTextSize();
                m mVar = new m(l.f(activity, str2, 1));
                mVar.a(null, str2, 0);
                TextPaint paint = baseViewHolder.EWM.getPaint();
                if (com.tencent.mm.cb.a.E(this.mActivity, (int) Layout.getDesiredWidth(mVar, 0, mVar.length(), paint)) > baseViewHolder.EBt) {
                    while (str.length() > 1) {
                        str = str.substring(0, str.length() - 2);
                        String format = String.format(aDInfo.adActionExtTailWording, str + "...");
                        Activity activity2 = this.mActivity;
                        baseViewHolder.EWM.getTextSize();
                        m mVar2 = new m(l.f(activity2, format, 1));
                        mVar2.a(null, format, 0);
                        int E = com.tencent.mm.cb.a.E(this.mActivity, (int) Layout.getDesiredWidth(mVar2, 0, mVar2.length(), paint));
                        baseViewHolder.EWM.setText(mVar2, TextView.BufferType.SPANNABLE);
                        baseViewHolder.EWM.setVisibility(0);
                        if (E <= baseViewHolder.EBt) {
                            return;
                        }
                    }
                    return;
                }
                baseViewHolder.EWM.setText(mVar, TextView.BufferType.SPANNABLE);
                baseViewHolder.EWM.setVisibility(0);
            }
        } catch (Throwable th) {
            Log.e("MicroMsg.BaseTimeLineItem", th.toString());
        }
    }

    private void a(MaskTextView maskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, int i2) {
        if (bVar.size() == 0) {
            maskTextView.setVisibility(8);
            return;
        }
        maskTextView.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        boolean z = true;
        for (int i3 = 0; i3 < bVar.size(); i3++) {
            try {
                String str = (String) bVar.get(i3).get(1);
                if (z) {
                    spannableStringBuilder.append((CharSequence) " ");
                    stringBuffer.append(" ");
                    z = false;
                } else {
                    spannableStringBuilder.append((CharSequence) ", ");
                    stringBuffer.append(", ");
                }
                iArr[i3] = spannableStringBuilder.length();
                iArr2[i3] = iArr[i3] + str.length();
                stringBuffer.append(str);
                spannableStringBuilder.append((CharSequence) l.b(this.mActivity, str, maskTextView.getTextSize()));
            } catch (Exception e2) {
                Log.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", Util.stackTraceToString(e2));
                return;
            }
        }
        Drawable drawable = this.mActivity.getResources().getDrawable(R.raw.friendactivity_luckymoney_icon);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
        aVar.QBM = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 2))) / 2.0f);
        spannableStringBuilder.setSpan(aVar, length, length + 1, 33);
        int i4 = i2 == 10 ? 3 : 2;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            spannableStringBuilder.setSpan(new q((String) bVar.get(i5).get(0), this.DQX.EBk, i4), iArr[i5], iArr2[i5], 33);
        }
        maskTextView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        maskTextView.setOriginText(stringBuffer.toString());
    }

    public final void a(BaseViewHolder baseViewHolder, int i2, SnsInfo snsInfo, bl blVar) {
        TimeLineObject timeLine = snsInfo.getTimeLine();
        a(baseViewHolder, i2, blVar, timeLine, baseViewHolder.qcr, this.DQX);
        a(blVar, timeLine);
    }

    private void a(bl blVar, TimeLineObject timeLineObject) {
        if (blVar != null && timeLineObject != null) {
            String str = timeLineObject.AppInfo == null ? null : timeLineObject.AppInfo.Id;
            if (!Util.isNullOrNil(str)) {
                com.tencent.mm.plugin.sns.c.a.jRu.a(str, timeLineObject.UserName, timeLineObject.ContentObj.LoU, timeLineObject.statisticsData, blVar.ENp);
            }
        }
    }

    private boolean a(List<dzo> list, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, BaseViewHolder baseViewHolder, bl blVar, int i2, SnsInfo snsInfo) {
        boolean z;
        TranslateCommentTextView childAt;
        boolean z2;
        SnsCommentCollapseLayout snsCommentCollapseLayout;
        CharSequence[] charSequenceArr;
        boolean z3;
        final View view;
        Drawable bitmapDrawable;
        String[] strArr;
        View view2;
        LinearLayout linearLayout = baseViewHolder.EWT;
        int childCount = linearLayout.getChildCount();
        int size = bVar.size();
        if (childCount > size) {
            for (int i3 = size; i3 < childCount; i3++) {
                View childAt2 = linearLayout.getChildAt(size);
                linearLayout.removeViewAt(size);
                if (childAt2 instanceof SnsCommentCollapseLayout) {
                    this.DQX.a((SnsCommentCollapseLayout) childAt2);
                }
            }
        }
        if (bVar.size() == 0) {
            linearLayout.setVisibility(8);
            return false;
        }
        linearLayout.setVisibility(0);
        if (this.DEBUG) {
            Log.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + baseViewHolder.position + " commentCount: " + size);
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i4 = 0;
        boolean z4 = false;
        int i5 = 0;
        while (i4 < bVar.size()) {
            com.tencent.mm.vending.j.a aVar = bVar.get(i4);
            long longValue = ((Long) aVar.get(0)).longValue();
            String str = (String) aVar.get(1);
            String str2 = (String) aVar.get(2);
            String str3 = (String) aVar.get(3);
            CharSequence charSequence = (CharSequence) aVar.get(4);
            String str4 = (String) aVar.get(5);
            CharSequence charSequence2 = (CharSequence) aVar.get(6);
            if (!Util.isNullOrNil(str4)) {
                z = true;
                sb2.append(longValue).append("|");
            } else {
                z = z4;
            }
            sb.append(longValue).append("|");
            dzo dzo = list.get(i4);
            int i6 = dzo.MYX;
            int i7 = dzo.DeleteFlag;
            au.b br = br(baseViewHolder.dRS, longValue);
            if (br != null && br.aGI) {
                au.fB(br.id, 2);
            }
            if (i5 >= childCount) {
                if (br == null || br.aGI) {
                    view2 = this.DQX.fiO();
                    ((SnsCommentCollapseLayout) view2).setTextSize$255e752(15.0f * com.tencent.mm.cb.a.ez(view2.getContext()));
                    if (this.DQX.EKq == -1) {
                        this.DQX.EKq = this.mActivity.getResources().getColor(R.color.a8v);
                    }
                    ((SnsCommentCollapseLayout) view2).setTextColor(this.DQX.EKq);
                    ((SnsCommentCollapseLayout) view2).setGravity(16);
                } else {
                    view2 = new TranslateCommentTextView(this.mActivity);
                    ((TranslateCommentTextView) view2).getTranslateResultView().setResultTextSize$255e752(15.0f * com.tencent.mm.cb.a.ez(view2.getContext()));
                    ((TranslateCommentTextView) view2).getOriginCommentTextView().setTextSize(1, 15.0f * com.tencent.mm.cb.a.ez(view2.getContext()));
                }
                z2 = true;
                childAt = view2;
            } else {
                childAt = linearLayout.getChildAt(i5);
                z2 = false;
            }
            if (br != null) {
                if (!(childAt instanceof TranslateCommentTextView)) {
                    linearLayout.removeView(childAt);
                    TranslateCommentTextView translateCommentTextView = new TranslateCommentTextView(this.mActivity);
                    linearLayout.addView(translateCommentTextView, i5);
                    translateCommentTextView.getTranslateResultView().setResultTextSize$255e752(15.0f * com.tencent.mm.cb.a.ez(translateCommentTextView.getContext()));
                    translateCommentTextView.getOriginCommentTextView().setTextSize(1, 15.0f * com.tencent.mm.cb.a.ez(translateCommentTextView.getContext()));
                    childAt = translateCommentTextView;
                }
                TranslateCommentTextView translateCommentTextView2 = (TranslateCommentTextView) childAt;
                childAt.setOnTouchListener(null);
                a(translateCommentTextView2.getOriginCommentTextView(), charSequence2, charSequence, i6, i7, dzo);
                if (!br.iGD) {
                    translateCommentTextView2.ERU.setTextSize(1, 15.0f * com.tencent.mm.cb.a.ez(translateCommentTextView2.getContext()));
                    translateCommentTextView2.ECF.ZW(2);
                    translateCommentTextView2.ECF.setVisibility(0);
                    z3 = true;
                    view = childAt;
                } else if (!br.aGI) {
                    String str5 = br.result;
                    String str6 = br.brand;
                    String charSequence3 = translateCommentTextView2.ERU.getText().toString();
                    if (!Util.isNullOrNil(charSequence3)) {
                        String[] split = charSequence3.split(":");
                        if (split.length > 2) {
                            strArr = new String[2];
                            strArr[0] = split[0];
                            strArr[1] = charSequence3.substring(strArr[0].length() + 1);
                        } else {
                            strArr = split;
                        }
                        if (strArr.length == 2) {
                            if (!Util.isNullOrNil(str5)) {
                                translateCommentTextView2.ECF.a(br, 2, strArr[0] + ": " + str5, str6, br.DNh);
                            } else {
                                translateCommentTextView2.ECF.a(br, 2, null, str6, br.DNh);
                            }
                            translateCommentTextView2.ECF.setVisibility(0);
                        }
                        translateCommentTextView2.ERU.setTextSize(1, 15.0f * com.tencent.mm.cb.a.ez(translateCommentTextView2.getContext()));
                    }
                    z3 = true;
                    view = childAt;
                } else {
                    translateCommentTextView2.getTranslateResultView().setVisibility(8);
                    z3 = true;
                    view = childAt;
                }
            } else {
                if (z2 || !(childAt instanceof TranslateCommentTextView)) {
                    snsCommentCollapseLayout = childAt;
                } else {
                    linearLayout.removeView(childAt);
                    SnsCommentCollapseLayout fiO = this.DQX.fiO();
                    linearLayout.addView(fiO, i5);
                    fiO.setTextSize$255e752(15.0f * com.tencent.mm.cb.a.ez(fiO.getContext()));
                    snsCommentCollapseLayout = fiO;
                }
                if (snsCommentCollapseLayout instanceof SnsCommentCollapseLayout) {
                    ((SnsCommentCollapseLayout) snsCommentCollapseLayout).setTextSize$255e752(15.0f * com.tencent.mm.cb.a.ez(snsCommentCollapseLayout.getContext()));
                    ((SnsCommentCollapseLayout) snsCommentCollapseLayout).setOpClickListener(this.DQX.EKG);
                    o oVar = new o(this.mActivity);
                    if (e.b(snsInfo, dzo.Username)) {
                        oVar.setAdTagClickCallback(this.mAdTagClickCallback, i2);
                        oVar.mAdTagClickScene = 31;
                    }
                    ((SnsCommentCollapseLayout) snsCommentCollapseLayout).setPressTouchListener(oVar);
                }
                CharSequence[] charSequenceArr2 = {charSequence2, charSequence};
                snsCommentCollapseLayout.hashCode();
                if (Util.isNullOrNil(str4) || !(snsCommentCollapseLayout instanceof SnsCommentCollapseLayout)) {
                    charSequenceArr = charSequenceArr2;
                } else {
                    g faL = aj.faL();
                    d dVar = new d(str4, charSequence2, charSequence, snsCommentCollapseLayout, i6, i7, this.DQX.EKu);
                    com.tencent.mm.emoji.loader.a.b bVar2 = com.tencent.mm.emoji.loader.a.b.gVU;
                    Bitmap EP = com.tencent.mm.emoji.loader.a.b.EP(str4);
                    if (EP == null) {
                        aj.faB().execute(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0431: INVOKE  
                              (wrap: java.util.concurrent.ExecutorService : 0x0426: INVOKE  (r10v2 java.util.concurrent.ExecutorService) =  type: STATIC call: com.tencent.mm.plugin.sns.model.aj.faB():java.util.concurrent.ExecutorService)
                              (wrap: com.tencent.mm.plugin.sns.model.g$5 : 0x042e: CONSTRUCTOR  (r11v22 com.tencent.mm.plugin.sns.model.g$5) = 
                              (r2v24 'faL' com.tencent.mm.plugin.sns.model.g)
                              (r19v1 'str4' java.lang.String)
                              (r8v5 'dVar' com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$d)
                             call: com.tencent.mm.plugin.sns.model.g.5.<init>(com.tencent.mm.plugin.sns.model.g, java.lang.String, com.tencent.mm.plugin.sns.model.g$d):void type: CONSTRUCTOR)
                             type: INTERFACE call: java.util.concurrent.ExecutorService.execute(java.lang.Runnable):void in method: com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.a(java.util.List<com.tencent.mm.protocal.protobuf.dzo>, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a>, com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder, com.tencent.mm.plugin.sns.ui.bl, int, com.tencent.mm.plugin.sns.storage.SnsInfo):boolean, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:239)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x042e: CONSTRUCTOR  (r11v22 com.tencent.mm.plugin.sns.model.g$5) = 
                              (r2v24 'faL' com.tencent.mm.plugin.sns.model.g)
                              (r19v1 'str4' java.lang.String)
                              (r8v5 'dVar' com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$d)
                             call: com.tencent.mm.plugin.sns.model.g.5.<init>(com.tencent.mm.plugin.sns.model.g, java.lang.String, com.tencent.mm.plugin.sns.model.g$d):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.a(java.util.List<com.tencent.mm.protocal.protobuf.dzo>, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a>, com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder, com.tencent.mm.plugin.sns.ui.bl, int, com.tencent.mm.plugin.sns.storage.SnsInfo):boolean, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 38 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.model.g, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 44 more
                            */
                        /*
                        // Method dump skipped, instructions count: 1641
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.a(java.util.List, com.tencent.mm.vending.d.b, com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder, com.tencent.mm.plugin.sns.ui.bl, int, com.tencent.mm.plugin.sns.storage.SnsInfo):boolean");
                    }

                    private static void a(View view, CharSequence charSequence, CharSequence charSequence2, int i2, int i3, dzo dzo) {
                        if (view instanceof SnsCommentCollapseLayout) {
                            ((SnsCommentCollapseLayout) view).a(charSequence, charSequence2, i2, i3);
                        } else if (view instanceof TextView) {
                            ((TextView) view).setText(charSequence);
                        }
                        a.C1715a aVar = com.tencent.mm.plugin.sns.i.a.DRI;
                        a.C1715a.a(view, dzo);
                    }

                    private au.b br(String str, long j2) {
                        if (this.EWs.size() <= 0) {
                            return null;
                        }
                        Iterator<au.b> it = this.EWs.iterator();
                        while (it.hasNext()) {
                            au.b next = it.next();
                            if (next.id != null && next.id.equals(au.kj(str, String.valueOf(j2)))) {
                                return next;
                            }
                        }
                        return null;
                    }

                    class b extends q {
                        b() {
                        }

                        @Override // com.tencent.mm.pluginsdk.ui.span.p, com.tencent.mm.pluginsdk.ui.span.q
                        public final void onClick(View view) {
                            AppMethodBeat.i(100053);
                            BaseTimeLineItem.this.DQX.EBo.ERi.onClick(view);
                            AppMethodBeat.o(100053);
                        }

                        @Override // com.tencent.mm.pluginsdk.ui.span.p, com.tencent.mm.pluginsdk.ui.span.q
                        public final void updateDrawState(TextPaint textPaint) {
                            AppMethodBeat.i(100054);
                            int color = BaseTimeLineItem.this.mActivity.getResources().getColor(R.color.a91);
                            if (getPress()) {
                                textPaint.bgColor = color;
                                AppMethodBeat.o(100054);
                                return;
                            }
                            textPaint.bgColor = 0;
                            AppMethodBeat.o(100054);
                        }
                    }

                    class c extends q {
                        c() {
                        }

                        @Override // com.tencent.mm.pluginsdk.ui.span.p, com.tencent.mm.pluginsdk.ui.span.q
                        public final void onClick(View view) {
                            AppMethodBeat.i(100056);
                            BaseTimeLineItem.this.DQX.EBo.ERj.onClick(view);
                            AppMethodBeat.o(100056);
                        }

                        @Override // com.tencent.mm.pluginsdk.ui.span.p, com.tencent.mm.pluginsdk.ui.span.q
                        public final void updateDrawState(TextPaint textPaint) {
                            AppMethodBeat.i(100057);
                            int color = BaseTimeLineItem.this.mActivity.getResources().getColor(R.color.a91);
                            if (getPress()) {
                                textPaint.bgColor = color;
                                AppMethodBeat.o(100057);
                                return;
                            }
                            textPaint.bgColor = 0;
                            AppMethodBeat.o(100057);
                        }
                    }

                    class a extends q {
                        a() {
                        }

                        @Override // com.tencent.mm.pluginsdk.ui.span.p, com.tencent.mm.pluginsdk.ui.span.q
                        public final void onClick(View view) {
                            AppMethodBeat.i(100051);
                            BaseTimeLineItem.this.DQX.EBo.ERu.onClick(view);
                            AppMethodBeat.o(100051);
                        }

                        @Override // com.tencent.mm.pluginsdk.ui.span.p, com.tencent.mm.pluginsdk.ui.span.q
                        public final void updateDrawState(TextPaint textPaint) {
                            AppMethodBeat.i(100052);
                            int color = BaseTimeLineItem.this.mActivity.getResources().getColor(R.color.a91);
                            if (getPress()) {
                                textPaint.bgColor = color;
                                AppMethodBeat.o(100052);
                                return;
                            }
                            textPaint.bgColor = 0;
                            AppMethodBeat.o(100052);
                        }
                    }

                    /* access modifiers changed from: package-private */
                    public static class d implements g.d {
                        public int ECO = 0;
                        public com.tencent.mm.plugin.sns.ui.l EKu = null;
                        public CharSequence EXP = null;
                        public int EXQ = com.tencent.mm.ui.at.fromDPToPix(MMApplicationContext.getContext(), 28);
                        public int deleteFlag = 0;
                        public CharSequence hus = null;
                        public String md5 = null;
                        private WeakReference<View> view = null;

                        public d(String str, CharSequence charSequence, CharSequence charSequence2, View view2, int i2, int i3, com.tencent.mm.plugin.sns.ui.l lVar) {
                            AppMethodBeat.i(203914);
                            this.view = new WeakReference<>(view2);
                            this.md5 = str;
                            this.EXP = charSequence;
                            this.hus = charSequence2;
                            this.ECO = i2;
                            this.deleteFlag = i3;
                            this.EKu = lVar;
                            AppMethodBeat.o(203914);
                        }

                        @Override // com.tencent.mm.plugin.sns.model.g.d
                        public final void f(Bitmap bitmap, String str) {
                            SnsCommentCollapseLayout snsCommentCollapseLayout;
                            AppMethodBeat.i(100059);
                            Log.i("MicroMsg.BaseTimeLineItem", "onEmojiDecodeFin bitmapAvailable:%s, md5:%s", Boolean.valueOf(r.M(bitmap)), str);
                            if (!(this.view == null || this.view.get() == null || !(this.view.get() instanceof SnsCommentCollapseLayout) || (snsCommentCollapseLayout = (SnsCommentCollapseLayout) this.view.get()) == null || snsCommentCollapseLayout.getTag() == null || !(snsCommentCollapseLayout.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))) {
                                com.tencent.mm.plugin.sns.ui.m mVar = (com.tencent.mm.plugin.sns.ui.m) snsCommentCollapseLayout.getTag();
                                if (mVar.DIu != null && !Util.isNullOrNil(mVar.DIu.MYY) && mVar.DIu.MYY.get(0) != null && Util.isEqual(str, mVar.DIu.MYY.get(0).Md5) && r.M(bitmap)) {
                                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                                    bitmapDrawable.setBounds(0, 0, this.EXQ, this.EXQ);
                                    com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(bitmapDrawable, 1);
                                    MMApplicationContext.getContext();
                                    q qVar = new q(this.md5, this.EKu, 2);
                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.EXP);
                                    spannableStringBuilder.append((CharSequence) "  ").append((CharSequence) this.md5).append((CharSequence) "  ").append((CharSequence) " ");
                                    int length = ((spannableStringBuilder.length() - this.md5.length()) - 2) - 1;
                                    int length2 = ((spannableStringBuilder.length() - this.md5.length()) - 4) - 1;
                                    spannableStringBuilder.setSpan(aVar, length, this.md5.length() + length, 33);
                                    spannableStringBuilder.setSpan(qVar, length2, length2 + 4 + this.md5.length(), 33);
                                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.hus);
                                    spannableStringBuilder2.append((CharSequence) "  ").append((CharSequence) this.md5).append((CharSequence) "  ").append((CharSequence) " ");
                                    int length3 = ((spannableStringBuilder2.length() - this.md5.length()) - 2) - 1;
                                    int length4 = ((spannableStringBuilder2.length() - this.md5.length()) - 4) - 1;
                                    spannableStringBuilder2.setSpan(aVar, length3, this.md5.length() + length3, 33);
                                    spannableStringBuilder2.setSpan(qVar, length4, length4 + 4 + this.md5.length(), 33);
                                    snsCommentCollapseLayout.a(spannableStringBuilder, spannableStringBuilder2, this.ECO, this.deleteFlag);
                                }
                            }
                            AppMethodBeat.o(100059);
                        }
                    }
                }
