package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bz;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;

public final class g implements x {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.x
    public final void a(abn abn, byte[] bArr, boolean z, aa aaVar) {
        as asVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        AppMethodBeat.i(116929);
        switch (abn.Lms) {
            case 1:
                cqm cqm = (cqm) new cqm().parseFrom(bArr);
                com.tencent.mm.kernel.g.aAh().azQ().get(2, (Object) null);
                ao azQ = com.tencent.mm.kernel.g.aAh().azQ();
                Log.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", Integer.valueOf(cqm.Mwf), Integer.valueOf(cqm.oTW), Integer.valueOf(cqm.KEc), Integer.valueOf(cqm.Mwm));
                String a2 = z.a(cqm.Lqk);
                String a3 = z.a(cqm.Mjj);
                String a4 = z.a(cqm.Mwg);
                String a5 = z.a(cqm.Mwh);
                int i2 = cqm.KDZ;
                as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(a2);
                if (Kn == null || Kn.field_username == null || !Kn.field_username.equals(a2)) {
                    asVar = new as(a2);
                } else {
                    asVar = Kn;
                }
                asVar.BC(cqm.ked);
                asVar.setNickname(a3);
                asVar.Cb(RegionCodeDecoder.bq(cqm.keh, cqm.kdZ, cqm.kea));
                asVar.nj(cqm.kdY);
                asVar.BV(cqm.keb);
                asVar.ne(cqm.MmO);
                asVar.BZ(cqm.MmM);
                asVar.BH(cqm.MmN);
                asVar.setUin(i2);
                ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().ao(asVar);
                azQ.set(2, a2);
                azQ.set(4, a3);
                azQ.set(5, a4);
                azQ.set(6, a5);
                azQ.set(9, Integer.valueOf(i2));
                StringBuilder sb = new StringBuilder("doCmd : status ");
                int i3 = cqm.oTW;
                String str15 = "code=" + Integer.toHexString(i3) + ", status = " + i3;
                if ((i3 & 1) != 0) {
                    str15 = str15 + ", open";
                }
                if ((i3 & 2) != 0) {
                    str15 = str15 + ", email-verified";
                }
                if ((i3 & 4) != 0) {
                    str15 = str15 + ", mobile-verified";
                }
                if ((i3 & 8) != 0) {
                    str15 = str15 + ", hide-qq-search";
                }
                if ((i3 & 16) != 0) {
                    str15 = str15 + ", hide-qq-promote";
                }
                if ((i3 & 32) != 0) {
                    str15 = str15 + ", need-verify";
                }
                if ((i3 & 64) != 0) {
                    str15 = str15 + ", has-qq-msg";
                }
                if ((i3 & 128) != 0) {
                    str15 = str15 + ", no-qq-promote";
                }
                if ((i3 & 256) != 0) {
                    str15 = str15 + ", no-mobile-promote";
                }
                if ((i3 & 512) != 0) {
                    str15 = str15 + ", hide-mobile_search";
                }
                if ((i3 & 4096) != 0) {
                    str15 = str15 + ", open-float-bottle";
                }
                if ((i3 & 131072) != 0) {
                    str15 = str15 + ", bind but not upload";
                }
                Log.d("MicroMsg.UserInfoSyncExtension", sb.append(str15).toString());
                azQ.set(7, Integer.valueOf(cqm.oTW));
                if (cqm.kec != 0) {
                    bz bzVar = new bz();
                    bzVar.fuI = 1;
                    bzVar.fuA = cqm.kdY;
                    bzVar.signature = cqm.keb;
                    bzVar.countryCode = cqm.keh;
                    bzVar.provinceCode = cqm.kdZ;
                    bzVar.cityCode = cqm.kea;
                    bzVar.fuM = cqm.MmM;
                    Log.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + bzVar.fuM + " nickName :" + cqm.MmN);
                    bz.a(bzVar);
                }
                StringBuilder sb2 = new StringBuilder("userinfo Plugstate: ");
                int i4 = cqm.KEc;
                String str16 = "code=" + Integer.toHexString(i4) + ", pluginFlag = " + i4;
                if ((i4 & 1) != 0) {
                    str = str16 + ", QQMAIL_UNINSTALL";
                } else {
                    str = str16 + ", QQMAIL_INSTALL";
                }
                if ((i4 & 2) != 0) {
                    str2 = str + ", PM_UNINSTALL";
                } else {
                    str2 = str + ", PM_INSTALL";
                }
                if ((i4 & 4) != 0) {
                    str3 = str2 + ", FM_UNINSTALL";
                } else {
                    str3 = str2 + ", FM_INSTALL";
                }
                if ((i4 & 8) != 0) {
                    str4 = str3 + ", WEIBO_UNINSTALL";
                } else {
                    str4 = str3 + ", WEIBO_INSTALL";
                }
                if ((i4 & 16) != 0) {
                    str5 = str4 + ", MEDIANOTE_UNINSTALL";
                } else {
                    str5 = str4 + ", MEDIANOTE_INSTALL";
                }
                if ((i4 & 32) != 0) {
                    str6 = str5 + ", QMSG_UNINSTALL";
                } else {
                    str6 = str5 + ", QMSG_INSTALL";
                }
                if ((i4 & 64) != 0) {
                    str7 = str6 + ", BOTTLE_UNINSTALL";
                } else {
                    str7 = str6 + ", BOTTLE_INSTALL";
                }
                if ((i4 & 128) != 0) {
                    str8 = str7 + ", QSYNC_UNISTALL";
                } else {
                    str8 = str7 + ", QSYNC_INSTALL";
                }
                if ((i4 & 256) != 0) {
                    str9 = str8 + ", SHAKE_UNISTALL";
                } else {
                    str9 = str8 + ", SHAKE_INSTALL";
                }
                if ((i4 & 512) != 0) {
                    str10 = str9 + ", LBS_UNISTALL";
                } else {
                    str10 = str9 + ", LBS_INSTALL";
                }
                if ((i4 & 1024) != 0) {
                    str11 = str10 + ", BOTTLE_CHART_INSTALL";
                } else {
                    str11 = str10 + ", BOTTLE_CHART_INSTALL";
                }
                if ((i4 & 4096) != 0) {
                    str12 = str11 + ",CHECKQQF_UNINSTALL";
                } else {
                    str12 = str11 + ",CHECKQQF_INSTALL";
                }
                if ((i4 & 32768) != 0) {
                    str13 = str12 + ",MM_FEEDSAPP_UNINSTALL";
                } else {
                    str13 = str12 + ",MM_FEEDSAPP_INSTALL";
                }
                Log.i("MicroMsg.UserInfoSyncExtension", sb2.append(str13).toString());
                azQ.set(34, Integer.valueOf(cqm.KEc));
                azQ.set(8200, Boolean.valueOf(Util.nullAs(Boolean.valueOf(1 == cqm.MvH.Lrk), false)));
                azQ.set(8201, Integer.valueOf(Util.nullAs(Integer.valueOf(cqm.MvH.Lrl.Lro), 22)));
                azQ.set(8208, Integer.valueOf(Util.nullAs(Integer.valueOf(cqm.MvH.Lrl.Lrp), 8)));
                azQ.set(66049, Integer.valueOf(cqm.MmK));
                azQ.set(66050, cqm.MmL);
                azQ.set(40, Integer.valueOf(cqm.Mwm));
                bf.iDu.aO("last_login_use_voice", new StringBuilder().append(cqm.Mwm).toString());
                azQ.set(41, Integer.valueOf(cqm.MmO));
                azQ.set(43, cqm.MmN);
                Log.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + cqm.Mwm + " WeiboFlag:" + cqm.MmO);
                azQ.set(868518889, Integer.valueOf(cqm.MvW));
                Log.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + cqm.MvW);
                azQ.set(42, cqm.ked);
                Log.d("MicroMsg.UserInfoSyncExtension", "userid:" + cqm.LuA + " username:" + cqm.LuB);
                azQ.set(65825, new StringBuilder().append(cqm.LuA).toString());
                azQ.set(65826, cqm.LuB);
                Log.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + cqm.kee);
                Log.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + cqm.kef);
                Log.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + cqm.keg);
                String nullAsNil = Util.nullAsNil((String) com.tencent.mm.kernel.g.aAh().azQ().get(65830, (Object) null));
                if ((nullAsNil == null || nullAsNil.length() == 0) && (str14 = cqm.Mwp) != null && str14.length() > 0) {
                    com.tencent.mm.kernel.g.aAh().azQ().set(65830, str14);
                }
                ab.b(1, cqm);
                break;
        }
        AppMethodBeat.o(116929);
    }
}
