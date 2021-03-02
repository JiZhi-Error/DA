package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.util.d;

public final class j extends BaseTimeLineItem {

    public static class a extends BaseTimeLineItem.BaseViewHolder {
        boolean EYR = false;
        RoundCornerRelativeLayout EYS;
        View EYT;
        View EYU;
        TextView EYV;
        TextView EYW;
        MMRoundCornerImageView EYX;
        WeImageView EYY;
        TextView EsH;
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(203931);
        a aVar = (a) baseViewHolder;
        if (baseViewHolder.EWD == null || baseViewHolder.EWD.getParent() == null) {
            aVar.EYS = (RoundCornerRelativeLayout) baseViewHolder.convertView.findViewById(R.id.h9d);
            aVar.EYR = true;
        } else {
            baseViewHolder.EWD.setLayoutResource(R.layout.bwe);
            if (!aVar.EYR) {
                aVar.EYS = (RoundCornerRelativeLayout) baseViewHolder.EWD.inflate().findViewById(R.id.h9d);
                aVar.EYR = true;
            }
        }
        aVar.EYS.setRadius((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4));
        aVar.EYU = aVar.EYS.findViewById(R.id.a_q);
        aVar.EYT = aVar.EYS.findViewById(R.id.fpx);
        if (ao.isDarkMode()) {
            aVar.EYT.setBackgroundResource(R.drawable.avn);
        } else {
            aVar.EYT.setBackgroundResource(R.drawable.avo);
        }
        aVar.EYX = (MMRoundCornerImageView) aVar.EYT.findViewById(R.id.axd);
        aVar.EsH = (TextView) aVar.EYT.findViewById(R.id.axh);
        aVar.EYV = (TextView) aVar.EYT.findViewById(R.id.axi);
        aVar.EYW = (TextView) aVar.EYT.findViewById(R.id.axf);
        aVar.EYY = (WeImageView) aVar.EYT.findViewById(R.id.axe);
        AppMethodBeat.o(203931);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    @SuppressLint({"ResourceType"})
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, final TimeLineObject timeLineObject, int i3, bk bkVar) {
        final String str;
        String str2;
        String str3;
        AppMethodBeat.i(203932);
        String str4 = blVar.Eql;
        final a aVar = (a) baseViewHolder;
        aVar.EYX.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.drawable.cvc));
        if (ao.isDarkMode()) {
            aVar.EYX.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.drawable.cvb));
        }
        String str5 = "";
        if (!(timeLineObject == null || timeLineObject.ContentObj == null)) {
            String str6 = "";
            if (timeLineObject.ContentObj.jfy != null) {
                String str7 = timeLineObject.ContentObj.jfy.Ktq;
                if (!Util.isNullOrNil(str7)) {
                    Log.i("MicroMsg.BaseTimeLineItem", "has mvInfo:%s", str7);
                    aVar.EYT.findViewById(R.id.g8b).setVisibility(0);
                    ((ViewGroup.MarginLayoutParams) aVar.EYV.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6);
                    ((ViewGroup.MarginLayoutParams) aVar.EsH.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
                    aVar.EYW.setVisibility(0);
                    aVar.EYW.setText(str7 + MMApplicationContext.getContext().getString(R.string.f8v));
                } else {
                    aVar.EYT.findViewById(R.id.g8b).setVisibility(8);
                    ((ViewGroup.MarginLayoutParams) aVar.EYV.getLayoutParams()).topMargin = 0;
                    ((ViewGroup.MarginLayoutParams) aVar.EsH.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
                    aVar.EYW.setText("");
                    aVar.EYW.setVisibility(8);
                }
                str3 = timeLineObject.ContentObj.jfy.Ktp;
                str6 = str7;
            } else {
                str3 = str5;
            }
            str5 = Util.nullAs(str3, "");
            Log.i("MicroMsg.BaseTimeLineItem", "coverInfo: coverUrl:%s, postInfo:%s", str5, str6);
        }
        if (timeLineObject.ContentObj != null && !timeLineObject.ContentObj.LoV.isEmpty()) {
            cnb cnb = timeLineObject.ContentObj.LoV.get(0);
            if (!Util.isNullOrNil(str5)) {
                Log.i("MicroMsg.BaseTimeLineItem", "loadMusicCover use mv, title: %s", cnb.Title);
                str = b.aIf(str5);
                str2 = str5;
            } else if (!Util.isNullOrNil(cnb.Msz)) {
                Log.i("MicroMsg.BaseTimeLineItem", "loadMusicCover use media.Thumb, title: %s", cnb.Title);
                String aIf = b.aIf(cnb.Msz);
                str2 = cnb.Msz;
                str = aIf;
            } else {
                q JK = aj.faD().JK((long) cnb.ecf);
                String str8 = ar.ki(aj.getAccSnsPath(), JK.EmN) + r.aOj(JK.EmN);
                Log.v("MicroMsg.BaseTimeLineItem", "loadMusicCover use thumb path: %s, exist: %s, title: %s", str8, Boolean.valueOf(s.YS(str8)), cnb.Title);
                str = str8;
                str2 = str8;
            }
            c.a aVar2 = new c.a();
            aVar2.fullPath = str;
            aVar2.jbf = true;
            aVar2.iaT = true;
            aVar2.jbd = true;
            aVar2.hZF = true;
            aVar2.jbx = (float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
            com.tencent.mm.av.q.bcV().a(str2, aVar.EYX, aVar2.bdv(), new h() {
                /* class com.tencent.mm.plugin.sns.ui.item.j.AnonymousClass1 */

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view) {
                }

                @Override // com.tencent.mm.av.a.c.h
                public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                    return null;
                }

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                    AppMethodBeat.i(203930);
                    if (bVar.bitmap != null && !bVar.bitmap.isRecycled()) {
                        ((com.tencent.mm.ay.a.a) g.af(com.tencent.mm.ay.a.a.class)).bw(timeLineObject.Id, str);
                        String messageDigest = d.getMessageDigest(str.getBytes());
                        com.tencent.mm.plugin.comm.b bVar2 = com.tencent.mm.plugin.comm.b.qCp;
                        com.tencent.mm.plugin.comm.b.a(MMApplicationContext.getContext(), aVar.EYU, bVar.bitmap, messageDigest);
                    }
                    AppMethodBeat.o(203930);
                }
            });
            if (timeLineObject.ContentObj.jfy == null) {
                timeLineObject.ContentObj.jfy = new css();
            }
            timeLineObject.ContentObj.jfy.jfz = str;
            aVar.EYY.setPressed(false);
            if (!Util.isNullOrNil(timeLineObject.ContentObj.jfy.singerName)) {
                aVar.EsH.setVisibility(0);
                aVar.EsH.setText(timeLineObject.ContentObj.jfy.singerName);
            } else if (!Util.isNullOrNil(cnb.Desc)) {
                aVar.EsH.setVisibility(0);
                aVar.EsH.setText(cnb.Desc);
            } else {
                aVar.EsH.setVisibility(8);
                aVar.EsH.setText("");
            }
            String str9 = cnb.Title;
            if (!Util.isNullOrNil(str9)) {
                aVar.EYV.setVisibility(0);
                aVar.EYV.setText(new SpannableString(str9), TextView.BufferType.SPANNABLE);
            } else {
                Log.e("MicroMsg.BaseTimeLineItem", "songName must make sure not empty");
            }
            if (bk.aMJ(timeLineObject.Id)) {
                aVar.EYY.setImageResource(R.raw.icons_outlined_pause2);
            } else {
                aVar.EYY.setImageResource(R.raw.icons_outlined_play2);
            }
            aVar.EYY.setIconColor(MMApplicationContext.getContext().getResources().getColor(R.color.fo));
            com.tencent.mm.plugin.sns.ui.s sVar = new com.tencent.mm.plugin.sns.ui.s(timeLineObject, str4);
            sVar.ixW = 1;
            aVar.EYY.setTag(sVar);
            aVar.EYY.setOnClickListener(bkVar.EBo.ERr);
            aVar.EYT.setTag(sVar);
            aVar.EYT.setOnClickListener(bkVar.EBo.ERf);
            bkVar.fiV().c(aVar.EYT, bkVar.DQs.FaG, bkVar.DQs.Far);
        }
        AppMethodBeat.o(203932);
    }
}
