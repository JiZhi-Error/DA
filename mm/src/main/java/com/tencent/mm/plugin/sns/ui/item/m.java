package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.timeline.b.c;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.QImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class m extends BaseTimeLineItem {
    private int EBq;
    private int EBr = 103;
    private MaskImageView EYZ;
    private ImageView EZa;
    private List<ImageView> EZb = new ArrayList();
    private ImageView EpU;

    public static class a extends BaseTimeLineItem.BaseViewHolder {
    }

    public m() {
        AppMethodBeat.i(203933);
        AppMethodBeat.o(203933);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(100092);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Log.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.qcr);
        Point point = new Point();
        point.x = displayMetrics.widthPixels;
        point.y = displayMetrics.heightPixels;
        aj.k(point);
        this.EBq = aj.fbb();
        if (baseViewHolder.EWD == null || baseViewHolder.EWD.getParent() == null || !(baseViewHolder.EWD.getParent() instanceof ViewGroup)) {
            baseViewHolder.EWX = (PhotosContent) baseViewHolder.convertView.findViewById(R.id.gb7);
            baseViewHolder.EWE = true;
        } else {
            if (this.qcr == 2) {
                baseViewHolder.EWD.setLayoutResource(R.layout.bxt);
            } else if (this.qcr == 3) {
                baseViewHolder.EWD.setLayoutResource(R.layout.bxq);
            } else if (this.qcr == 4) {
                baseViewHolder.EWD.setLayoutResource(R.layout.bxr);
            } else if (this.qcr == 5) {
                baseViewHolder.EWD.setLayoutResource(R.layout.bxs);
            } else {
                Log.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.qcr);
            }
            if (!baseViewHolder.EWE) {
                baseViewHolder.EWX = (PhotosContent) baseViewHolder.EWD.inflate();
                baseViewHolder.EWE = true;
            }
        }
        baseViewHolder.EWX.EuD.clear();
        for (int i2 = 0; i2 < be.EGv[this.qcr]; i2++) {
            TagImageView tagImageView = (TagImageView) baseViewHolder.EWX.findViewById(be.EGz[i2]);
            baseViewHolder.EWX.a(tagImageView);
            tagImageView.setOnClickListener(this.DQX.DQs.Erh);
            this.DQX.fiV().c(tagImageView, this.DQX.DQs.FaF, this.DQX.DQs.Far);
        }
        baseViewHolder.EWX.setImageViewWidth(this.EBq);
        AppMethodBeat.o(100092);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    @TargetApi(16)
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        PhotosContent photosContent;
        float f2;
        AppMethodBeat.i(100093);
        if (baseViewHolder.EWX == null) {
            AppMethodBeat.o(100093);
            return;
        }
        if (!(blVar == null || timeLineObject == null || !blVar.Eoq)) {
            Log.i("MiroMsg.PhotoTimeLineItem", "ad fillItem, photoItem, pos=" + i2 + ", snsId=" + timeLineObject.Id + ", hash=" + hashCode());
        }
        baseViewHolder.EWX.setVisibility(0);
        LinkedList linkedList = new LinkedList();
        int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
        if (this.EpU != null) {
            this.EpU.setVisibility(8);
        }
        SnsInfo snsInfo = blVar.DqO;
        if (this.EZa != null) {
            this.EZa.setVisibility(8);
        }
        for (ImageView imageView : this.EZb) {
            imageView.setVisibility(8);
            baseViewHolder.EWX.removeView(imageView);
        }
        if (blVar.Eoq && i3 == 2) {
            final ADXml adXml = snsInfo.getAdXml();
            if (adXml != null && adXml.adMediaDisplayWidth > 0.0f && adXml.adMediaDisplayHeight > 0.0f) {
                float a2 = i.a((double) adXml.adMediaDisplayWidth, 1, adXml.adBasicRemWidth, adXml.adBasicRootFontSize);
                float a3 = i.a((double) adXml.adMediaDisplayHeight, 1, adXml.adBasicRemWidth, adXml.adBasicRootFontSize);
                if (adXml.adMediaDisplayMode == 0) {
                    cnd cnd = new cnd();
                    cnd.Mto = a2;
                    cnd.Mtp = a3;
                    if (a2 >= ((float) (((width - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir)))) {
                        cnd.Mto = (float) (((width - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir));
                        cnd.Mtp = (float) ((int) ((cnd.Mto * adXml.adMediaDisplayHeight) / adXml.adMediaDisplayWidth));
                    }
                    cnd.Mtq = cnd.Mto * cnd.Mtp;
                    linkedList.add(cnd);
                } else if (adXml.adMediaDisplayMode == 1) {
                    int fromDPToPix = (((width - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 50)) - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir);
                    int i4 = (int) ((((float) fromDPToPix) * adXml.adMediaDisplayHeight) / adXml.adMediaDisplayWidth);
                    cnd cnd2 = new cnd();
                    if (fromDPToPix > 0) {
                        a2 = (float) fromDPToPix;
                    }
                    cnd2.Mto = a2;
                    if (i4 > 0) {
                        f2 = (float) i4;
                    } else {
                        f2 = a3;
                    }
                    cnd2.Mtp = f2;
                    cnd2.Mtq = cnd2.Mto * cnd2.Mtp;
                    linkedList.add(cnd2);
                } else if (adXml.adMediaDisplayMode == 2) {
                    int fromDPToPix2 = ((width - com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir);
                    int i5 = (int) ((((float) fromDPToPix2) * adXml.adMediaDisplayHeight) / adXml.adMediaDisplayWidth);
                    cnd cnd3 = new cnd();
                    if (fromDPToPix2 > 0) {
                        a2 = (float) fromDPToPix2;
                    }
                    cnd3.Mto = a2;
                    if (i5 > 0) {
                        a3 = (float) i5;
                    }
                    cnd3.Mtp = a3;
                    cnd3.Mtq = cnd3.Mto * cnd3.Mtp;
                    linkedList.add(cnd3);
                }
            }
            if (adXml != null && adXml.isShowPlayIconOnCover()) {
                if (this.EpU == null) {
                    this.EpU = (ImageView) baseViewHolder.EWX.findViewById(R.id.i5e);
                }
                if (this.EpU != null) {
                    this.EpU.setVisibility(0);
                }
            }
            if (k.a(snsInfo, 0) && !k.t(snsInfo) && (photosContent = baseViewHolder.EWX) != null) {
                try {
                    if (this.EZa == null) {
                        this.EZa = new ImageView(this.mActivity);
                    }
                    photosContent.removeView(this.EZa);
                    int fromDPToPix3 = com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 24);
                    int fromDPToPix4 = com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 4);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fromDPToPix3, fromDPToPix3);
                    layoutParams.leftMargin = fromDPToPix4;
                    layoutParams.topMargin = fromDPToPix4;
                    this.EZa.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.drawable.brd));
                    this.EZa.setLayoutParams(layoutParams);
                    this.EZa.setVisibility(0);
                    photosContent.addView(this.EZa);
                } catch (Throwable th) {
                    Log.e("MiroMsg.PhotoTimeLineItem", th.toString());
                }
            }
            if (!Util.isNullOrNil(adXml.adMediaIconUrl)) {
                final PhotosContent photosContent2 = baseViewHolder.EWX;
                final TagImageView ZD = baseViewHolder.EWX.ZD(0);
                h.a("adId", adXml.adMediaIconUrl, false, 41, new f.a() {
                    /* class com.tencent.mm.plugin.sns.ui.item.m.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWN() {
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWO() {
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void aNH(String str) {
                        AppMethodBeat.i(100091);
                        m.this.EYZ = (MaskImageView) photosContent2.findViewById(R.id.fbm);
                        if (m.this.EYZ != null) {
                            m.this.EYZ.setVisibility(0);
                            m.this.EYZ.setImageBitmap(BitmapUtil.decodeFile(str));
                            float a2 = i.a((double) adXml.adMediaIconWidth, 1, adXml.adBasicRemWidth, adXml.adBasicRootFontSize);
                            float a3 = i.a((double) adXml.adMediaIconHeight, 1, adXml.adBasicRemWidth, adXml.adBasicRootFontSize);
                            float a4 = i.a((double) adXml.adMediaIconPaddingRight, 1, adXml.adBasicRemWidth, adXml.adBasicRootFontSize);
                            float a5 = i.a((double) adXml.adMediaIconPaddingBottom, 1, adXml.adBasicRemWidth, adXml.adBasicRootFontSize);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a2, (int) a3);
                            layoutParams.setMargins((int) ((((float) ZD.getRight()) - a4) - a2), (int) ((((float) ZD.getBottom()) - a5) - a3), 0, 0);
                            m.this.EYZ.setLayoutParams(layoutParams);
                        }
                        AppMethodBeat.o(100091);
                    }
                });
            }
        }
        be beVar = bkVar.EBe;
        PhotosContent photosContent3 = baseViewHolder.EWX;
        String str = blVar.Eql;
        int hashCode = this.mActivity.hashCode();
        boolean z = blVar.Eoq;
        boolean z2 = this.EAv;
        bp gCU = bp.gCU();
        gCU.hXs = timeLineObject.CreateTime;
        beVar.a(photosContent3, timeLineObject, str, hashCode, i3, i2, z, z2, gCU, linkedList, blVar.Dsr, snsInfo);
        baseViewHolder.EWX.ZD(0).setScaleType(QImageView.a.CENTER_CROP);
        if (blVar.Eoq && this.qcr == 2) {
            try {
                ADXml adXml2 = blVar.DqO.getAdXml();
                if (adXml2 != null && adXml2.isShowPlayIconOnCover()) {
                    if (this.EpU == null) {
                        this.EpU = (ImageView) baseViewHolder.EWX.findViewById(R.id.i5e);
                    }
                    if (this.EpU != null) {
                        this.EpU.setVisibility(0);
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) baseViewHolder.EWX.ZD(0).getLayoutParams();
                        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.EpU.getLayoutParams();
                        int i6 = ((layoutParams2.width / 2) - (layoutParams3.width / 2)) + layoutParams2.leftMargin;
                        int i7 = layoutParams2.topMargin + ((layoutParams2.height / 2) - (layoutParams3.height / 2));
                        if (!(i6 == layoutParams3.leftMargin && i7 == layoutParams3.topMargin)) {
                            layoutParams3.leftMargin = i6;
                            layoutParams3.topMargin = i7;
                            this.EpU.setLayoutParams(layoutParams3);
                        }
                    }
                }
            } catch (Throwable th2) {
                if (this.EpU != null) {
                    this.EpU.setVisibility(8);
                }
                Log.e("MiroMsg.PhotoTimeLineItem", "checkShowStatusIcon exp=" + th2.toString());
            }
        }
        if (blVar.Eoq && ((i3 == 3 || i3 == 4 || i3 == 5) && k.a(snsInfo, 0) && !k.t(snsInfo))) {
            a(baseViewHolder.EWX, be.EGv[i3]);
        }
        AppMethodBeat.o(100093);
    }

    private void a(PhotosContent photosContent, int i2) {
        AppMethodBeat.i(203934);
        if (photosContent == null || i2 <= 1) {
            Log.e("MiroMsg.PhotoTimeLineItem", "photosContent == null or imgNums <= 1");
            AppMethodBeat.o(203934);
            return;
        }
        try {
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 20);
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.EZb.size() < i2) {
                    Log.i("MiroMsg.PhotoTimeLineItem", "current index = " + i3 + ", weAppIcons current size = " + this.EZb.size() + ", total imgNums = " + i2);
                    ImageView a2 = c.a(this.mActivity, photosContent, i3, fromDPToPix);
                    if (a2 != null) {
                        a2.setVisibility(8);
                        this.EZb.add(a2);
                    }
                }
                if (photosContent.ZD(i3).getVisibility() != 8) {
                    ImageView imageView = this.EZb.get(i3);
                    if (imageView != null) {
                        photosContent.addView(imageView);
                        imageView.setVisibility(0);
                    } else {
                        Log.e("MiroMsg.PhotoTimeLineItem", "weAppIcons get weAppIv is null");
                    }
                }
            }
            AppMethodBeat.o(203934);
        } catch (Throwable th) {
            Log.e("MiroMsg.PhotoTimeLineItem", th.toString());
            AppMethodBeat.o(203934);
        }
    }
}
