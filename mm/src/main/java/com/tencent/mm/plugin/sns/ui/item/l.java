package com.tencent.mm.plugin.sns.ui.item;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.QImageView;

public final class l extends BaseTimeLineItem {
    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(100090);
        baseViewHolder.EWG.setPosition(i2);
        String str5 = blVar.Eql;
        SnsInfo snsInfo = blVar.DqO;
        boolean z4 = false;
        if (blVar.Eoq) {
            if (snsInfo.getAdXml().adContentStyle == 2) {
                z4 = true;
                baseViewHolder.EIs.setTag(baseViewHolder);
                baseViewHolder.EIs.setOnClickListener(bkVar.DQs.Fbi);
            }
            z = z4;
            z2 = false;
        } else {
            if (timeLineObject.ContentObj.LoU == 9) {
                if (timeLineObject.ContentObj.LoV.size() > 0) {
                    baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                    baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERk);
                    z = false;
                    z2 = false;
                }
            } else if (timeLineObject.ContentObj.LoU == 10) {
                if (timeLineObject.ContentObj.LoV.size() > 0) {
                    baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                    baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERm);
                    z = false;
                    z2 = false;
                }
            } else if (timeLineObject.ContentObj.LoU == 17) {
                if (timeLineObject.ContentObj.LoV.size() > 0) {
                    baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                    baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERn);
                    z = false;
                    z2 = false;
                }
            } else if (timeLineObject.ContentObj.LoU == 22) {
                if (timeLineObject.ContentObj.LoV.size() > 0) {
                    baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                    baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERo);
                    z = false;
                    z2 = false;
                }
            } else if (timeLineObject.ContentObj.LoU == 23) {
                if (timeLineObject.ContentObj.LoV.size() > 0) {
                    baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                    baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERp);
                    z = false;
                    z2 = false;
                }
            } else if (timeLineObject.ContentObj.LoU == 14) {
                if (timeLineObject.ContentObj.LoV.size() > 0) {
                    baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                    baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERl);
                    z = false;
                    z2 = false;
                }
            } else if (timeLineObject.ContentObj.LoU == 12) {
                if (timeLineObject.ContentObj.LoV.size() > 0) {
                    baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                    baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERv);
                    z = false;
                    z2 = false;
                }
            } else if (timeLineObject.ContentObj.LoU == 13) {
                if (timeLineObject.ContentObj.LoV.size() > 0) {
                    baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                    baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERw);
                    z = false;
                    z2 = false;
                } else {
                    baseViewHolder.EIs.setOnClickListener(null);
                    z = false;
                    z2 = false;
                }
            } else if (timeLineObject.ContentObj.LoU == 30) {
                baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERt);
                z = false;
                z2 = false;
            } else if (timeLineObject.ContentObj.LoU == 26) {
                baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERx);
                z = false;
                z2 = false;
            } else if (timeLineObject.ContentObj.LoU == 28 || timeLineObject.ContentObj.LoU == 29 || timeLineObject.ContentObj.LoU == 38 || timeLineObject.ContentObj.LoU == 34 || timeLineObject.ContentObj.LoU == 37 || timeLineObject.ContentObj.LoU == 36) {
                baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                baseViewHolder.EIs.setOnClickListener(bkVar.EBo.EIc);
                z = false;
                z2 = false;
            } else if (timeLineObject.ContentObj.LoU == 41) {
                baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERy);
                z = false;
                z2 = false;
            } else if (timeLineObject.ContentObj.LoU == 39) {
                baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                baseViewHolder.EIs.setOnClickListener(bkVar.EBo.EIc);
                z = false;
                z2 = false;
            } else if (timeLineObject.ContentObj.LoU == 4) {
                baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                baseViewHolder.EIs.setOnClickListener(bkVar.EBo.EIc);
                z = false;
                z2 = false;
            } else {
                baseViewHolder.EIs.setTag(new s(timeLineObject, str5));
                baseViewHolder.EIs.setOnClickListener(bkVar.EBo.EIc);
                if ((timeLineObject.contentattr & 1) > 0) {
                    z = false;
                    z2 = true;
                }
            }
            z = false;
            z2 = false;
        }
        if (z) {
            bkVar.fiV().c(baseViewHolder.EIs, bkVar.DQs.FaK, bkVar.DQs.Far);
        } else {
            bkVar.fiV().c(baseViewHolder.EIs, bkVar.DQs.FaG, bkVar.DQs.Far);
        }
        if (timeLineObject.ContentObj.LoU == 9) {
            z3 = true;
        } else {
            z3 = (aq.a.fbx() & 1) <= 0;
        }
        String aRf = z3 ? bk.aRf(timeLineObject.ContentObj.Url) : "";
        if (timeLineObject.ContentObj.LoU == 9 || timeLineObject.ContentObj.LoU == 14 || timeLineObject.ContentObj.LoU == 12 || timeLineObject.ContentObj.LoU == 13 || z) {
            aRf = timeLineObject.ContentObj.Desc;
        }
        if (timeLineObject.ContentObj.LoY == null || timeLineObject.ContentObj.LoY.iwf != 1) {
            str = aRf;
        } else {
            str = MMApplicationContext.getContext().getString(R.string.f3t);
        }
        String str6 = timeLineObject.ContentObj.Title;
        if (str6 == null || str6.length() <= 40) {
            str2 = str6;
        } else {
            str2 = str6.substring(0, 40) + "...";
        }
        baseViewHolder.uzC.setVisibility(8);
        if (!timeLineObject.ContentObj.LoV.isEmpty()) {
            baseViewHolder.EWG.setVisibility(0);
            cnb cnb = timeLineObject.ContentObj.LoV.get(0);
            if (timeLineObject.ContentObj.LoU == 5) {
                str2 = cnb.Title;
                baseViewHolder.uzC.setImageResource(R.raw.shortvideo_play_btn);
                baseViewHolder.uzC.setVisibility(0);
                g faL = aj.faL();
                TagImageView tagImageView = baseViewHolder.EWG;
                int hashCode = this.mActivity.hashCode();
                bp gCU = bp.gCU();
                gCU.hXs = timeLineObject.CreateTime;
                faL.a(cnb, tagImageView, R.raw.app_attach_file_icon_video, hashCode, gCU);
            } else if (timeLineObject.ContentObj.LoU == 18) {
                baseViewHolder.uzC.setVisibility(0);
                baseViewHolder.uzC.setImageResource(R.raw.shortvideo_play_btn);
                baseViewHolder.EWG.setVisibility(0);
                g faL2 = aj.faL();
                TagImageView tagImageView2 = baseViewHolder.EWG;
                int hashCode2 = this.mActivity.hashCode();
                bp gCU2 = bp.gCU();
                gCU2.hXs = timeLineObject.CreateTime;
                faL2.a(cnb, tagImageView2, R.raw.app_attach_file_icon_video, hashCode2, gCU2);
            } else {
                if (!(timeLineObject.weappInfo == null || timeLineObject.weappInfo.path == null || timeLineObject.weappInfo.subType != 1)) {
                    baseViewHolder.uzC.setImageResource(R.raw.shortvideo_play_btn);
                    baseViewHolder.uzC.setVisibility(0);
                }
                if (timeLineObject.webSearchInfo != null && !Util.isNullOrNil(timeLineObject.webSearchInfo.IEy)) {
                    baseViewHolder.uzC.setImageResource(R.raw.shortvideo_play_btn);
                    baseViewHolder.uzC.setVisibility(0);
                }
                if (timeLineObject.ContentObj.LoY != null && timeLineObject.ContentObj.LoY.iAb == 5) {
                    baseViewHolder.uzC.setImageResource(R.raw.shortvideo_play_btn);
                    baseViewHolder.uzC.setVisibility(0);
                }
                g faL3 = aj.faL();
                TagImageView tagImageView3 = baseViewHolder.EWG;
                int hashCode3 = this.mActivity.hashCode();
                bp gCU3 = bp.gCU();
                gCU3.hXs = timeLineObject.CreateTime;
                faL3.b(cnb, tagImageView3, hashCode3, gCU3);
            }
        } else if (timeLineObject.ContentObj.LoU == 18) {
            baseViewHolder.uzC.setVisibility(0);
            baseViewHolder.uzC.setImageResource(R.raw.shortvideo_play_btn);
            baseViewHolder.EWG.setVisibility(0);
            aj.faL().d(baseViewHolder.EWG, -1, R.raw.app_attach_file_icon_video, this.mActivity.hashCode());
        } else if (timeLineObject.ContentObj.LoU == 26) {
            baseViewHolder.EWG.setVisibility(0);
            aj.faL().d(baseViewHolder.EWG, -1, R.raw.note_sns_link_default, this.mActivity.hashCode());
        } else if (timeLineObject.ContentObj.LoU == 28) {
            if (timeLineObject.ContentObj.dME != null) {
                if (((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).showFinderEntry() || ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 0) {
                    if (Util.isNullOrNil(timeLineObject.ContentObj.dME.nickname) && !Util.isNullOrNil(timeLineObject.ContentObj.dME.desc)) {
                        str2 = timeLineObject.ContentObj.dME.desc;
                    } else if (!Util.isNullOrNil(timeLineObject.ContentObj.dME.desc)) {
                        str2 = timeLineObject.ContentObj.dME.nickname + ": " + timeLineObject.ContentObj.dME.desc;
                    } else {
                        str2 = this.mActivity.getString(R.string.h_n, new Object[]{timeLineObject.ContentObj.dME.nickname});
                    }
                }
                baseViewHolder.EWG.setVisibility(0);
                if (!timeLineObject.ContentObj.dME.mediaList.isEmpty()) {
                    cnb cnb2 = new cnb();
                    cnb2.Url = timeLineObject.ContentObj.dME.mediaList.get(0).thumbUrl;
                    cnb2.Msz = timeLineObject.ContentObj.dME.mediaList.get(0).thumbUrl;
                    cnb2.oUv = 2;
                    cnb2.MsA = 1;
                    cnb2.MsB = new cnd();
                    cnb2.Mcw = 1;
                    cnb2.MsB.Mto = timeLineObject.ContentObj.dME.mediaList.get(0).width;
                    cnb2.MsB.Mtp = timeLineObject.ContentObj.dME.mediaList.get(0).height;
                    cnb2.Id = snsInfo.getSnsId();
                    g faL4 = aj.faL();
                    TagImageView tagImageView4 = baseViewHolder.EWG;
                    int hashCode4 = this.mActivity.hashCode();
                    bp gCU4 = bp.gCU();
                    gCU4.hXs = timeLineObject.CreateTime;
                    faL4.b(cnb2, tagImageView4, hashCode4, gCU4);
                }
            }
        } else if (timeLineObject.ContentObj.LoU == 36) {
            if (timeLineObject.ContentObj.Lpd != null) {
                if (((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).showFinderEntry() || ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 0) {
                    if (Util.isNullOrNil(timeLineObject.ContentObj.Lpd.nickname) && !Util.isNullOrNil(timeLineObject.ContentObj.Lpd.desc)) {
                        str2 = timeLineObject.ContentObj.Lpd.desc;
                    } else if (!Util.isNullOrNil(timeLineObject.ContentObj.Lpd.desc)) {
                        str2 = timeLineObject.ContentObj.Lpd.nickname + ": " + timeLineObject.ContentObj.Lpd.desc;
                    } else {
                        str2 = this.mActivity.getString(R.string.h_n, new Object[]{timeLineObject.ContentObj.Lpd.nickname});
                    }
                }
                baseViewHolder.EWG.setVisibility(0);
                if (!timeLineObject.ContentObj.Lpd.mediaList.isEmpty()) {
                    cnb cnb3 = new cnb();
                    if (!TextUtils.isEmpty(timeLineObject.ContentObj.Lpd.mediaList.get(0).coverUrl)) {
                        str4 = timeLineObject.ContentObj.Lpd.mediaList.get(0).coverUrl;
                    } else {
                        str4 = timeLineObject.ContentObj.Lpd.mediaList.get(0).thumbUrl;
                    }
                    cnb3.Url = str4;
                    cnb3.Msz = str4;
                    cnb3.oUv = 2;
                    cnb3.MsA = 1;
                    cnb3.MsB = new cnd();
                    cnb3.Mcw = 1;
                    cnb3.MsB.Mto = timeLineObject.ContentObj.Lpd.mediaList.get(0).width;
                    cnb3.MsB.Mtp = timeLineObject.ContentObj.Lpd.mediaList.get(0).height;
                    cnb3.Id = snsInfo.getSnsId();
                    g faL5 = aj.faL();
                    TagImageView tagImageView5 = baseViewHolder.EWG;
                    int hashCode5 = this.mActivity.hashCode();
                    bp gCU5 = bp.gCU();
                    gCU5.hXs = timeLineObject.CreateTime;
                    faL5.b(cnb3, tagImageView5, hashCode5, gCU5);
                }
            }
        } else if (timeLineObject.ContentObj.LoU == 29 || timeLineObject.ContentObj.LoU == 37) {
            if (timeLineObject.ContentObj.LoZ != null) {
                String string = this.mActivity.getString(R.string.vk);
                if (timeLineObject.ContentObj.LoZ != null) {
                    if (timeLineObject.ContentObj.LoZ.tvC == 1) {
                        string = MMApplicationContext.getContext().getString(R.string.h_q, timeLineObject.ContentObj.LoZ.dST);
                    } else {
                        string = timeLineObject.ContentObj.LoZ.dST;
                    }
                }
                baseViewHolder.EWG.setVisibility(0);
                if (!Util.isNullOrNil(timeLineObject.ContentObj.LoZ.iconUrl)) {
                    cnb cnb4 = new cnb();
                    cnb4.Url = timeLineObject.ContentObj.LoZ.iconUrl;
                    cnb4.Msz = timeLineObject.ContentObj.LoZ.iconUrl;
                    cnb4.oUv = 2;
                    cnb4.MsA = 1;
                    cnb4.MsB = new cnd();
                    cnb4.Mcw = 1;
                    cnb4.MsB.Mto = 0.0f;
                    cnb4.MsB.Mtp = 0.0f;
                    cnb4.Id = snsInfo.getSnsId();
                    g faL6 = aj.faL();
                    TagImageView tagImageView6 = baseViewHolder.EWG;
                    int hashCode6 = this.mActivity.hashCode();
                    bp gCU6 = bp.gCU();
                    gCU6.hXs = timeLineObject.CreateTime;
                    faL6.b(cnb4, tagImageView6, hashCode6, gCU6);
                }
                str = timeLineObject.ContentObj.LoZ.desc;
                str2 = string;
            }
        } else if (timeLineObject.ContentObj.LoU == 38) {
            if (timeLineObject.ContentObj.Lpb != null) {
                str2 = timeLineObject.ContentObj.Lpb.title;
                baseViewHolder.EWG.setVisibility(0);
                if (timeLineObject.ContentObj.Lpb.LLt.size() > 0) {
                    cnb cnb5 = new cnb();
                    cnb5.Url = timeLineObject.ContentObj.Lpb.LLt.get(0) + timeLineObject.ContentObj.Lpb.LLu.get(0);
                    cnb5.Msz = cnb5.Url;
                    cnb5.oUv = 2;
                    cnb5.MsA = 1;
                    cnb5.MsB = new cnd();
                    cnb5.Mcw = 1;
                    cnb5.MsB.Mto = 0.0f;
                    cnb5.MsB.Mtp = 0.0f;
                    cnb5.Id = snsInfo.getSnsId();
                    g faL7 = aj.faL();
                    TagImageView tagImageView7 = baseViewHolder.EWG;
                    int hashCode7 = this.mActivity.hashCode();
                    bp gCU7 = bp.gCU();
                    gCU7.hXs = timeLineObject.CreateTime;
                    faL7.b(cnb5, tagImageView7, hashCode7, gCU7);
                }
            }
        } else if (timeLineObject.ContentObj.LoU == 34) {
            if (timeLineObject.ContentObj.Lpc != null) {
                if (((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).showFinderEntry() || ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) == 0) {
                    if (Util.isNullOrNil(timeLineObject.ContentObj.Lpc.nickName) && !Util.isNullOrNil(timeLineObject.ContentObj.Lpc.desc)) {
                        str2 = timeLineObject.ContentObj.Lpc.desc;
                    } else if (!Util.isNullOrNil(timeLineObject.ContentObj.Lpc.desc)) {
                        str2 = timeLineObject.ContentObj.Lpc.nickName + ": " + timeLineObject.ContentObj.Lpc.desc;
                    } else {
                        str2 = this.mActivity.getString(R.string.h_p, new Object[]{timeLineObject.ContentObj.Lpc.nickName});
                    }
                }
                baseViewHolder.EWG.setVisibility(0);
                if (!timeLineObject.ContentObj.Lpc.coverUrl.isEmpty()) {
                    cnb cnb6 = new cnb();
                    cnb6.Url = timeLineObject.ContentObj.Lpc.coverUrl;
                    cnb6.Msz = timeLineObject.ContentObj.Lpc.coverUrl;
                    cnb6.oUv = 2;
                    cnb6.MsA = 1;
                    cnb6.MsB = new cnd();
                    cnb6.Mcw = 1;
                    cnb6.MsB.Mto = timeLineObject.ContentObj.Lpc.width;
                    cnb6.MsB.Mtp = timeLineObject.ContentObj.Lpc.height;
                    cnb6.Id = snsInfo.getSnsId();
                    g faL8 = aj.faL();
                    TagImageView tagImageView8 = baseViewHolder.EWG;
                    int hashCode8 = this.mActivity.hashCode();
                    bp gCU8 = bp.gCU();
                    gCU8.hXs = timeLineObject.CreateTime;
                    faL8.b(cnb6, tagImageView8, hashCode8, gCU8);
                }
            }
        } else if (timeLineObject.ContentObj.LoU != 39) {
            baseViewHolder.EWG.setVisibility(0);
            aj.faL().d(baseViewHolder.EWG, -1, R.raw.app_attach_file_icon_webpage, this.mActivity.hashCode());
        } else if (timeLineObject.ContentObj.izD == 3) {
            if (timeLineObject.ContentObj.Lpe != null) {
                String string2 = this.mActivity.getString(R.string.vk);
                if (timeLineObject.ContentObj.Lpe.tvC != 7 || timeLineObject.ContentObj.Lpe.LLD == null) {
                    str3 = string2;
                } else {
                    str3 = MMApplicationContext.getContext().getString(R.string.h_l, timeLineObject.ContentObj.Lpe.LLD.LAr, timeLineObject.ContentObj.Lpe.LLD.LAq);
                }
                baseViewHolder.EWG.setVisibility(0);
                if (!Util.isNullOrNil(timeLineObject.ContentObj.Lpe.iconUrl)) {
                    cnb cnb7 = new cnb();
                    cnb7.Url = timeLineObject.ContentObj.Lpe.iconUrl;
                    cnb7.Msz = timeLineObject.ContentObj.Lpe.iconUrl;
                    cnb7.oUv = 2;
                    cnb7.MsA = 1;
                    cnb7.MsB = new cnd();
                    cnb7.Mcw = 1;
                    cnb7.MsB.Mto = 0.0f;
                    cnb7.MsB.Mtp = 0.0f;
                    cnb7.Id = snsInfo.getSnsId();
                    baseViewHolder.EWG.setScaleType(QImageView.a.CENTER_CROP);
                    ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImageForSns(timeLineObject.ContentObj.Lpe.iconUrl, baseViewHolder.EWG);
                } else {
                    aj.faL().d(baseViewHolder.EWG, -1, R.raw.icon_filled_activity, this.mActivity.hashCode());
                }
                str = timeLineObject.ContentObj.Lpe.desc;
                str2 = str3;
            }
        } else if (timeLineObject.ContentObj.izD == 100000000 && timeLineObject.ContentObj.LoZ != null) {
            String string3 = this.mActivity.getString(R.string.vk);
            if (timeLineObject.ContentObj.LoZ != null) {
                if (timeLineObject.ContentObj.LoZ.tvC == 1) {
                    string3 = MMApplicationContext.getContext().getString(R.string.h_q, timeLineObject.ContentObj.LoZ.dST);
                } else if (timeLineObject.ContentObj.LoZ.tvC != 7) {
                    string3 = timeLineObject.ContentObj.LoZ.dST;
                } else if (timeLineObject.ContentObj.LoZ.LLD != null) {
                    string3 = MMApplicationContext.getContext().getString(R.string.h_l, timeLineObject.ContentObj.LoZ.LLD.LAr, timeLineObject.ContentObj.LoZ.LLD.LAq);
                } else {
                    string3 = timeLineObject.ContentObj.LoZ.dST;
                }
            }
            baseViewHolder.EWG.setVisibility(0);
            if (!Util.isNullOrNil(timeLineObject.ContentObj.LoZ.iconUrl)) {
                cnb cnb8 = new cnb();
                cnb8.Url = timeLineObject.ContentObj.LoZ.iconUrl;
                cnb8.Msz = timeLineObject.ContentObj.LoZ.iconUrl;
                cnb8.oUv = 2;
                cnb8.MsA = 1;
                cnb8.MsB = new cnd();
                cnb8.Mcw = 1;
                cnb8.MsB.Mto = 0.0f;
                cnb8.MsB.Mtp = 0.0f;
                cnb8.Id = snsInfo.getSnsId();
                g faL9 = aj.faL();
                TagImageView tagImageView9 = baseViewHolder.EWG;
                int hashCode9 = this.mActivity.hashCode();
                bp gCU9 = bp.gCU();
                gCU9.hXs = timeLineObject.CreateTime;
                faL9.b(cnb8, tagImageView9, hashCode9, gCU9);
            }
            str = timeLineObject.ContentObj.LoZ.desc;
            str2 = string3;
        }
        if (!Util.isNullOrNil(str)) {
            baseViewHolder.EWH.setVisibility(0);
            baseViewHolder.EWH.setText(str);
        } else {
            baseViewHolder.EWH.setVisibility(8);
        }
        if (!Util.isNullOrNil(str2)) {
            if (baseViewHolder.EWH.getVisibility() == 8) {
                if (baseViewHolder.EWI != 2) {
                    baseViewHolder.titleTv.setMaxLines(2);
                }
                baseViewHolder.EWI = 2;
            } else {
                if (baseViewHolder.EWI != 1) {
                    baseViewHolder.titleTv.setMaxLines(1);
                }
                baseViewHolder.EWI = 1;
            }
            baseViewHolder.titleTv.setVisibility(0);
            if (z2) {
                baseViewHolder.titleTv.setText(r.a(str2, this.mActivity, baseViewHolder.titleTv));
                AppMethodBeat.o(100090);
                return;
            }
            baseViewHolder.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.mActivity, str2));
            AppMethodBeat.o(100090);
        } else if (i3 == 1) {
            baseViewHolder.titleTv.setText(bk.aRf(timeLineObject.ContentObj.Url));
            baseViewHolder.titleTv.setVisibility(0);
            AppMethodBeat.o(100090);
        } else {
            baseViewHolder.titleTv.setVisibility(8);
            AppMethodBeat.o(100090);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(100089);
        if (baseViewHolder.EWD == null || baseViewHolder.EWD.getParent() == null) {
            baseViewHolder.EXr = baseViewHolder.convertView.findViewById(R.id.fbh);
            baseViewHolder.EXq = true;
        } else {
            baseViewHolder.EWD.setLayoutResource(R.layout.bwh);
            if (!baseViewHolder.EXq) {
                baseViewHolder.EXr = baseViewHolder.EWD.inflate();
                baseViewHolder.EXq = true;
            }
        }
        baseViewHolder.EIs = baseViewHolder.EXr;
        baseViewHolder.EWG = (TagImageView) baseViewHolder.EIs.findViewById(R.id.dw4);
        baseViewHolder.uzC = (ImageView) baseViewHolder.EIs.findViewById(R.id.i4t);
        baseViewHolder.EWH = (TextView) baseViewHolder.EIs.findViewById(R.id.h7r);
        baseViewHolder.titleTv = (TextView) baseViewHolder.EIs.findViewById(R.id.ir7);
        baseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(R.color.a2x));
        r.b(baseViewHolder.EWG, this.mActivity);
        AppMethodBeat.o(100089);
    }
}
